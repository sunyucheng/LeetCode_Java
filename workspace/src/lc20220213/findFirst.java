package lc20220213;

public class findFirst {
	public static void main(String[] args){
		int[] nums = {4,1,2,2,1};
		System.out.println(singleNumber(nums));
	}
	
	//λ��������ʣ�0���κ���λ����Ϊ�䱾����ͬΪ0������Ϊ1�����㽻���ɺͽ����
    public static int singleNumber(int[] nums) {
        int a = 0;
        for(int i : nums){
            a ^= i;
        }
        return a;
    }
}
