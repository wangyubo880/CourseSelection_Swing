package com.db;

public class StringUtil {
	public static boolean isEmpty(String str) {
		if("".equals(str)||str==null) {
			//str.equals("") ����ǿ� �����쳣 ��ȷ���Ƿ�Ϊ�յı�������Ҫȥ�������ķ���
			return true;
		}
		return false;
	}

}
