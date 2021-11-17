package yidong;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeNumToChina {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		ChineseUtil cu = new ChineseUtil();
		String res = cu.integertoRmb(s);
		System.out.println(res);
	}
}

class ChineseUtil{
	private static final Pattern AMOUNT_PATTERN = Pattern.compile("^(0|[1-9]\\d{0,11})\\.(\\d\\d)$");
	private static final char[] RMB_NUMS = "ÁãÒ¼·¡ÈþËÁÎéÂ½Æâ°Æ¾Á".toCharArray();
	private static final String[] UNITS = {"Ôª","½Ç","·Ö","Õû"};
	private static final String[] U1 = {"","Ê°","°Û","Çª"};
	private static final String[] U2 = {"","Íò","ÒÚ"};
	
	public static String convert(String amount){
		Matcher matcher = AMOUNT_PATTERN.matcher(amount);
		String integer = matcher.group(1);
		String fraction = matcher.group(2);
		String result = "";
		if(!integer.equals("0")){
			result += integertoRmb(integer) + UNITS[0];
		}
		if(fraction.equals("00")){
			result += UNITS[3];
		}else if(fraction.startsWith("0") && integer.equals("0")){
			result += factoRmb(fraction).substring(1);
		}else{
			result += factoRmb(fraction);
		}
		return result;
	}
	
	public static String factoRmb(String fraction){
		char jiao = fraction.charAt(0);
		char fen = fraction.charAt(0);
		return (RMB_NUMS[jiao - '0'] + (jiao > '0' ? UNITS[1] : "")) + (fen > '0' ? RMB_NUMS[fen - '0'] + UNITS[2] : "");
	}
	
	public static String integertoRmb(String integer){
		StringBuilder buffer = new StringBuilder();
		int i, j;
		for(i = integer.length() - 1, j = 0; i >= 0; i--, j++){
			char n = integer.charAt(i);
			if(n == '0'){
				if(i < integer.length() - 1 && integer.charAt(i+1) != '0'){
					buffer.append(RMB_NUMS[0]);
				}
				if(j % 4 == 0){
					if(i > 0 && integer.charAt(i - 1) != '0' || i > 1 && integer.charAt(i-2) != '0' ||i > 2 && integer.charAt(i-3) != '0'){
						buffer.append(U2[j/4]);
					}
				}
			}else{
				if(j % 4 == 0){
					buffer.append(U2[j/4]);
				}
				buffer.append(U1[j%4]);
				buffer.append(RMB_NUMS[n-'0']);
			}
		}
		return buffer.reverse().toString();
	}
}
