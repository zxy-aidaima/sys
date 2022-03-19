package vms.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class SignMassage {

	public static String specialUrlEncode(String value) throws Exception {
		return java.net.URLEncoder.encode(value, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
	}

	@SuppressWarnings("restriction")
	public static String sign(String accessSecret, String stringToSign) throws Exception {
		javax.crypto.Mac mac = javax.crypto.Mac.getInstance("HmacSHA1");
		mac.init(new javax.crypto.spec.SecretKeySpec(accessSecret.getBytes("UTF-8"), "HmacSHA1"));
		byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
		return new sun.misc.BASE64Encoder().encode(signData);
	}

	public static String createUrl(String number, String code) throws Exception {
		String accessKeyId = StringUtils.getPropertiesValue("accessKeyId", "constant-config.properties");
		String accessSecret = StringUtils.getPropertiesValue("accessSecret", "constant-config.properties");
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		df.setTimeZone(new java.util.SimpleTimeZone(0, "GMT"));// 这里一定要设置GMT时区
		java.util.Map<String, String> paras = new java.util.HashMap<String, String>();
		// 1. 系统参数
		paras.put("SignatureMethod", "HMAC-SHA1");
		paras.put("SignatureNonce", java.util.UUID.randomUUID().toString());
		paras.put("AccessKeyId", accessKeyId);
		paras.put("SignatureVersion", "1.0");
		paras.put("Timestamp", df.format(new java.util.Date()));
		paras.put("Format", "JSON");
		// 2. 业务API参数
		paras.put("Action", "SendSms");
		paras.put("Version", "2017-05-25");
		paras.put("RegionId", "cn-hangzhou");
		paras.put("PhoneNumbers", number);
		paras.put("SignName", "遇见代码");
		paras.put("TemplateParam", "{\"code\":\"" + code + "\"}");
		paras.put("TemplateCode", "SMS_207495869");
		// 3. 去除签名关键字Key
		if (paras.containsKey("Signature"))
			paras.remove("Signature");
		// 4. 参数KEY排序
		java.util.TreeMap<String, String> sortParas = new java.util.TreeMap<String, String>();
		sortParas.putAll(paras);
		// 5. 构造待签名的字符串
		java.util.Iterator<String> it = sortParas.keySet().iterator();
		StringBuilder sortQueryStringTmp = new StringBuilder();
		while (it.hasNext()) {
			String key = it.next();
			sortQueryStringTmp.append("&").append(specialUrlEncode(key)).append("=")
					.append(specialUrlEncode(paras.get(key)));
		}
		String sortedQueryString = sortQueryStringTmp.substring(1);// 去除第一个多余的&符号
		StringBuilder stringToSign = new StringBuilder();
		stringToSign.append("GET").append("&");
		stringToSign.append(specialUrlEncode("/")).append("&");
		stringToSign.append(specialUrlEncode(sortedQueryString));
		String sign = sign(accessSecret + "&", stringToSign.toString());
		// 6. 签名最后也要做特殊URL编码
		String signature = specialUrlEncode(sign);
		System.out.println(paras.get("Timestamp"));
		System.out.println(sortedQueryString);
		System.out.println(stringToSign.toString());
		System.out.println(sign);
		System.out.println(signature);
		// 7.最终打印出合法GET请求的URL
		String URL = "https://dysmsapi.aliyuncs.com/?Signature=" + signature + sortQueryStringTmp;
		System.out.println("发送URL：" + URL);
		return URL;
	}

	public static String sendSms(String url) throws Exception {
		URL urlMassage = new URL(url);
		URLConnection urlConnection = urlMassage.openConnection();
		InputStream inputStream = urlConnection.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
		String returnMassage = bufferedReader.readLine();
		System.out.println("发送结果报文：" + returnMassage);
		return returnMassage;
	}

	public static void main(String[] args) throws Exception {
		String returnMassage = sendSms(createUrl("13231781681", "ABCabc"));
		System.out.println(returnMassage);
	}

}
