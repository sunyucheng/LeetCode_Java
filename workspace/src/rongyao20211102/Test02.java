package rongyao20211102;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



public class Test02 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		//输入是一行，所以读取就是一行
		String str = sc.nextLine();
		//通过分隔符存到字符串数组中
		String[] vote = str.split(",");
		//用来存储人名以及人名出现的次数
		Map<String,Integer> map = new HashMap<String,Integer>();
		//循环判断vote中String是否合法，如果不合法的话，打印error.0001
		for(int k = 0; k < vote.length; k++){
			String name = vote[k];
			if(name.charAt(0) < 'A' || name.charAt(0) > 'Z'){
				System.out.println("error.0001");
				return;
			}else{
				for(int n = 1; n < name.length(); n++){
					if(name.charAt(n) < 'a' || name.charAt(n) > 'z'){
						System.out.println("error.0001");
						return;
					}
				}
			}
		}
		
		//用hashmap统计人名出现的次数
		for(int i = 0; i < vote.length; i++){
			map.put(vote[i],map.getOrDefault(vote[i], 1)+1);
		}       
		
		//list存放结果集
		List<String> list = new ArrayList<String>();
		int max = 0;
		//map.keySet():返回的是所有的map的结果集，Set类型的
		//map.entrySet()：返回的是所有的map的key-value的结果集，Set类型的
		//遍历map的set结果集合
		for(String key : map.keySet()){
			if(map.get(key) > max){
				max = map.get(key);
				list.clear();
				list.add(key);
			}else if(map.get(key) == max){
				list.add(key);
			}
		}
		Collections.sort(list);
		System.out.println(list.get(0));
	}
}
