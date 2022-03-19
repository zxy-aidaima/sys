package vms.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.io.PrintStream;
import java.math.BigDecimal;

public class TimeAndDate {
	/**
	 * 获取系统当前时间戳
	 * 
	 * 2021年1月9日
	 * @return
	 */
	public static Long getTimestamp() {
		return System.currentTimeMillis();
	}
	/**
	 * 获取系统当前日期
	 * 格式：yyyy-MM-dd HH:mm:ss
	 * 2021年1月9日
	 * @return
	 */
	public static String getNowTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        return date;
	}
	/**
	 * 获取系统当前日期
	 * 格式：yyyyMMdd
	 * 2021年1月24日
	 * @return
	 */
	public static String getNowDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String date = df.format(new Date());
        return date;
	}
	
	
	
	
	
	
	/**
	 * 获取系统当前日期
	 * 格式：yyyy-MM-dd HH:mm:ss
	 * 2021年1月9日
	 * @return
	 */
	public static Date getNowTimeDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = df.parse("2020-01-25 00:12:13");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return date;
	}
	/**
	 * 获取系统当前日期
	 * 格式：yyyyMMdd
	 * 2021年1月24日
	 * @return
	 */
	public static Date getNowDateDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date date = null;
		try {
			date = df.parse(getNowDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return date;
	}
	
	




	
	  public String getCurrentTime(String iFormat)
	  {
	    Date date = new Date();
	    SimpleDateFormat format = new SimpleDateFormat(iFormat);

	    return format.format(date);
	  }

	  public String toString(Date iDate, String iFormat)
	  {
	    SimpleDateFormat format = new SimpleDateFormat(iFormat);

	    return format.format(iDate);
	  }

	  public String toFormat(String iStrDate)
	  {
	    String strTemp = "";
	    String strFlag = "";
	    String strYear = "";
	    String strMonth = "";
	    String strDate = "";
	    String strRet = "";
	    int intStartPoint = 0; int intEndPoint = 0;

	    if ((iStrDate == null) || (iStrDate == "") || (iStrDate.equals("null")))
	    {
	      return "";
	    }

	    if ((iStrDate.length() < 8) || (iStrDate.length() > 10))
	    {
	      return iStrDate;
	    }

	    if (iStrDate.indexOf("/") > 0) strFlag = "/";
	    if (iStrDate.indexOf("-") > 0) strFlag = "-";

	    if (strFlag.trim().equals(""))
	    {
	      System.err.println("输入日期串中没有分割符!" + iStrDate);
	      return iStrDate;
	    }

	    intStartPoint = iStrDate.indexOf(strFlag);
	    intEndPoint = iStrDate.lastIndexOf(strFlag);
	    strTemp = iStrDate.substring(0, intStartPoint);

	    if (strTemp.length() == 4)
	    {
	      strYear = iStrDate.substring(0, intStartPoint);
	      strMonth = iStrDate.substring(intStartPoint + 1, intEndPoint);
	      if (strMonth.length() == 1) strMonth = "0" + strMonth.trim();
	      strDate = iStrDate.substring(intEndPoint + 1, iStrDate.length());
	      if (strDate.length() == 1) { strDate = "0" + strDate.trim();
	      }

	      strFlag = "-";

	      strRet = strYear.trim() + strFlag.trim() + strMonth.trim() + strFlag.trim() + strDate.trim();
	    }

	    if (strTemp.length() != 4)
	    {
	      strMonth = iStrDate.substring(0, intStartPoint);
	      if (strMonth.length() == 1) strMonth = "0" + strMonth.trim();
	      strDate = iStrDate.substring(intStartPoint + 1, intEndPoint);
	      if (strDate.length() == 1) strDate = "0" + strDate.trim();
	      strYear = iStrDate.substring(intEndPoint + 1, iStrDate.length());

	      strFlag = "-";

	      strRet = strYear.trim() + strFlag.trim() + strMonth.trim() + strFlag.trim() + strDate.trim();
	    }
	    return strRet.trim();
	  }

	  public String toWestFormat(String iStrDate, String iFormat)
	    throws Exception
	  {
	    String[] arrMonth = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

	    String strYear = "";
	    String strMonth = "";
	    String strDate = "";
	    String strRet = "";
	    int index = 0;
	    try
	    {
	      strRet = toFormat(iStrDate);
	      strYear = strRet.substring(0, 4);
	      strMonth = strRet.substring(5, 7);
	      strDate = strRet.substring(8, 10);
	      index = Integer.parseInt(strMonth);
	      strMonth = arrMonth[(index - 1)];

	      if ((iFormat.trim().equals("")) || (iFormat.trim().equals("MMddyyyy")) || (iFormat.trim().equals("MM.dd,yyyy")))
	      {
	        strRet = strMonth + "." + strDate + "," + strYear;
	      }
	      else if (iFormat.trim().equals("dd-MM-yyyy")) {
	        strRet = strDate + "-" + strMonth + "-" + strYear;
	      }
	      else if (iFormat.trim().equals("yyyyMMdd")) {
	        strRet = strYear + "-" + strMonth + "-" + strDate;
	      }
	      else
	        throw new Exception("日期不正确或不存在此日期格式！");

	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw e;
	    }
	    return strRet.trim();
	  }

	  public static void main(String[] args)
	  {   
		  double sumPlanFee = 27.89;
		  double sumpayPlanFee = 0.0;
		  double sum = 0.0;
		  List<Double> list = new ArrayList<Double>();
		  list.add(26.29D);
		  list.add(1.6D);
		  for (int i = 0; i < list.size(); i++) {
			System.out.println(sumpayPlanFee += list.get(i));
			
		}
		  
		  sumPlanFee = Double.parseDouble(new  DecimalFormat("#####.00").format(sumPlanFee));
		  sum = Double.parseDouble(new  DecimalFormat("#####.00").format((sumPlanFee - sumpayPlanFee)));  
		  System.out.println(sum == 0.0);
		  System.out.println(sumPlanFee);
		  System.out.println(sum);
		  System.out.println(Math.abs(sum));
		  //System.out.println(new DecimalFormat("###########0.00").format(new BigDecimal("")));
//		  
//		  TimeAndDate TimeAndDate1 =new TimeAndDate();
//		String  ExpireDate = TimeAndDate1.toFormat("");
//		System.out.println(ExpireDate == null);
//		System.out.println(ExpireDate.length() == 0);
//	        if  (ExpireDate == null || ExpireDate.length() == 0 ){ 
//	            ExpireDate = "";
//	        }else{
//	            //ExpireDate = ExpireDate;
//	        }
//	    System.out.println(ExpireDate);
	  }
	
}
