package org.ozen.core.util;

import java.util.Random;

/**
 * 随机数工具类
 * 
 * @author zxy
 *
 */
public class RandomGenerator {
	/**
	 * 获取一定长度的随机字符串
	 * 
	 * @param length
	 *            指定字符串长度
	 * @return 一定长度的字符串
	 */
	public static String getRandomStrByLength() {
		int length = (int) (3 + Math.random() * (6 - 3 + 1));
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 生成指定范围的随机数
	 * 
	 * @param min
	 *            最小值
	 * @param max
	 *            最大值
	 * @return
	 */
	public static int getRangeRandomNum(int min, int max) {
		Random random = new Random();
		if (min == 0) {
			max = max + 1;
		}
		int s = random.nextInt(max) % (max - min + 1) + min;
		return s;
	}

	/**
	 * 随机一个小数
	 * 
	 * @return
	 */
	public static String getRandomDouble() {
		double min = 0.8;
		double max = 1.8; // 总和
		int scl = 2; // 小数最大位数
		int pow = (int) Math.pow(10, scl); // 用于提取指定小数位
		double one;
		// min~max 指定小数位的随机数
		one = Math.floor((Math.random() * (max - min) + min) * pow) / pow;
		return one + "";
	}

	public static void main(String[] args) {
		System.out.println(getRandomStrByLength());
	}
}
