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
		//������һ�У����Զ�ȡ����һ��
		String str = sc.nextLine();
		//ͨ���ָ����浽�ַ���������
		String[] vote = str.split(",");
		//�����洢�����Լ��������ֵĴ���
		Map<String,Integer> map = new HashMap<String,Integer>();
		//ѭ���ж�vote��String�Ƿ�Ϸ���������Ϸ��Ļ�����ӡerror.0001
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
		
		//��hashmapͳ���������ֵĴ���
		for(int i = 0; i < vote.length; i++){
			map.put(vote[i],map.getOrDefault(vote[i], 1)+1);
		}       
		
		//list��Ž����
		List<String> list = new ArrayList<String>();
		int max = 0;
		//map.keySet():���ص������е�map�Ľ������Set���͵�
		//map.entrySet()�����ص������е�map��key-value�Ľ������Set���͵�
		//����map��set�������
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
