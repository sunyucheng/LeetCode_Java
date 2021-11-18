package lc20211118;

public class TwoSumOfString {
	public static void main(String[] args){
		String a = "11";
		String b = "123";
		String res = addStrings(a,b);
		System.out.println(res);
	}
	
    public static String addStrings(String num1, String num2) {
        //toCharArray() 用于将字符串转换为字符数组
        //String[] arr = num1.split("");   这个是将
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        //字符串采用的是反向相加
        int flag = 0;
        StringBuilder res = new StringBuilder();
        //中间可以这样写，因为中间只要放一个表达式就可以了：i >= 0 || j >= 0
        for(int i = c1.length - 1,  j = c2.length - 1; i >= 0 || j >= 0; i--, j--){
            //这个应该是根据i >= 0 或者 j >= 0 来判断，这是为了解决两个字符串长度不一致的问题
            int a = i >= 0 ? c1[i] - '0' : 0;
            int b = j >= 0 ? c2[j] - '0' : 0;
            int resval = a + b + flag;
            flag = resval / 10;
            res.append(resval % 10 + "");
        }
        if(flag == 1){
            res.append("1");
        }
        //最后再将字符串反转
        return res.reverse().toString();
    }
}
