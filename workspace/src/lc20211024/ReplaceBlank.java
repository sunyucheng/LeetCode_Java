package lc20211024;

public class ReplaceBlank {
    public String replaceSpace(String s) {
        //StringBuffer���̰߳�ȫ�ģ�StringBuilder���̲߳���ȫ��
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' '){
                //' '���ַ���ָ����ֻ����һ���ַ�����������������ַ���
            	//StringBuilder�����Ԫ����append��StringBuffer�����Ԫ��Ҳ��append
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
