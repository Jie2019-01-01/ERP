package cn.itcast.erp.utils.generator;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderNumUtil {
	
	public static Integer i = 1;
	public static byte[] bus = {48,48,48,48,48,48};
	public static final Integer ORDER_NUM_MAX_LENGTH = 7;
	
	// 2002240000001
	public static String generatorNum() {
		DateFormat df = new SimpleDateFormat("yymmdd");
		int len = String.valueOf(i).length();
		String serNum = new String(bus, 0, ORDER_NUM_MAX_LENGTH-len);
		String orderNum = df.format(new Date())+serNum+i++;
		return Long.toHexString(new Long(orderNum)).toUpperCase();
	}
	
	public static void main(String[] args) {
	}
}
