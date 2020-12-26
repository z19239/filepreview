package cn.keking.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *特殊字符处理
 *
 */
public class CommonalityUtil {


	/**
	 * 清除字符串特殊字符
	 * @param str
	 */
	public static String clearSpecialCharacters(String str) {
		String regEx="[\n`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？]";//可以在中括号内加上任何想要替换的字符
		String aa= "";//这里是将特殊字符换为aa字符串,""代表直接去掉
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);//这里把想要替换的字符串传进来
		String newString= m.replaceAll(aa).trim();
		return newString;
	}
	
}
