package lc20211118;

public class TwoSumOfString {
	public static void main(String[] args){
		String a = "11";
		String b = "123";
		String res = addStrings(a,b);
		System.out.println(res);
	}
	
    public static String addStrings(String num1, String num2) {
        //toCharArray() ���ڽ��ַ���ת��Ϊ�ַ�����
        //String[] arr = num1.split("");   ����ǽ�
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        //�ַ������õ��Ƿ������
        int flag = 0;
        StringBuilder res = new StringBuilder();
        //�м��������д����Ϊ�м�ֻҪ��һ�����ʽ�Ϳ����ˣ�i >= 0 || j >= 0
        for(int i = c1.length - 1,  j = c2.length - 1; i >= 0 || j >= 0; i--, j--){
            //���Ӧ���Ǹ���i >= 0 ���� j >= 0 ���жϣ�����Ϊ�˽�������ַ������Ȳ�һ�µ�����
            int a = i >= 0 ? c1[i] - '0' : 0;
            int b = j >= 0 ? c2[j] - '0' : 0;
            int resval = a + b + flag;
            flag = resval / 10;
            res.append(resval % 10 + "");
        }
        if(flag == 1){
            res.append("1");
        }
        //����ٽ��ַ�����ת
        return res.reverse().toString();
    }
}
