package lc20211022;

public class LeftRotateString {
	 public String reverseLeftWords(String s, int n) {
	        //×Ö·û´®ÇÐÆ¬£º
	        return s.substring(n,s.length()) + s.substring(0,n);
	 }
}
