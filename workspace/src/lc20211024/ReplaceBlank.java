package lc20211024;

public class ReplaceBlank {
    public String replaceSpace(String s) {
        //StringBuffer是线程安全的，StringBuilder是线程不安全的
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' '){
                //' '是字符，指的是只能有一个字符，而“”里面的是字符串
            	//StringBuilder中添加元素是append，StringBuffer中添加元素也是append
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
