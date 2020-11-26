package com.db;

public class StringUtil {
	public static boolean isEmpty(String str) {
		if("".equals(str)||str==null) {
			//str.equals("") 如果是空 会抛异常 不确定是否为空的变量，不要去调用它的方法
			return true;
		}
		return false;
	}

}
