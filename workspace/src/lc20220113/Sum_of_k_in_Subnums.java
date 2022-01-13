package lc20220113;

import java.util.HashMap;

public class Sum_of_k_in_Subnums {
	public static void main(String[] args){
		int[] nums = {1,2,3};
		System.out.println(subarraySum(nums,3));
	}
	
	public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> preSum = new HashMap<>();
        preSum.put(0,1);
        //¼ÇÂ¼½á¹û
        int res = 0;
        int sum1 = 0;
        for(int i = 0; i<n; i++){
            sum1 += nums[i];
            int sum2 = sum1 - k;
            if(preSum.containsKey(sum2)){
                res += preSum.get(sum2);
            }
            preSum.put(sum1,preSum.getOrDefault(sum1,0)+1);
        }
        return res;
    }
}
