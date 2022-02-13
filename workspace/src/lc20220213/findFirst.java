package lc20220213;

public class findFirst {
	public static void main(String[] args){
		int[] nums = {4,1,2,2,1};
		System.out.println(singleNumber(nums));
	}
	
	//位运算的性质：0与任何数位运算为其本身，相同为0，相异为1，满足交换律和结合律
    public static int singleNumber(int[] nums) {
        int a = 0;
        for(int i : nums){
            a ^= i;
        }
        return a;
    }
}
