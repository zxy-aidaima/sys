package vms.tool;

import vms.util.TimeAndDate;

public class RandomAccount {

	/**
	 *  生成6位随机数
	 * 2021年1月24日
	 * @return
	 */
	public static String getRandomNum() {
		int num = 6;
		String numStr = "";
		for (int i = 0; i < num; i++) {
			numStr += (int) (10 * (Math.random()));
		}
		return numStr;
	}
	/**
	 * 自动生成主键
	 * 2021年1月24日
	 * @param userType 用户类型1位
	 * @param provinceCode 省份编码2位
	 * @return
	 */
	public static String getGeneratID(String userType, String provinceCode) {
		String registerCode = "";
		registerCode = userType + provinceCode + TimeAndDate.getNowDate() + getRandomNum();
		return registerCode;
	}

	public static void main(String[] args) {
		System.out.println(getGeneratID("A", "13"));
	}

}
