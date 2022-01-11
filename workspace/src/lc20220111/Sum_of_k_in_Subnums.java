package lc20220111;

public class Sum_of_k_in_Subnums {
	public static void main(String[] args){
		int[] nums = {1,2,3};
		System.out.println(subarraySum(nums,3));
	}
	
	//����������������飬Ȼ��������ǵĺ�
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        //����ǰ׺������
        int[] preSum = new int[n+1];
        //ǰ׺������ĵ�һ��Ԫ�ض�����
        preSum[0] = 0;
        //����ǰ׺������
        for(int i = 1 ; i < n+1 ;i++){
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        //res��¼���,��¼��������ĸ�������������Ԫ�صĸ���
        int res = 0;
        //����iһ���Ǵ�1��ʼ�ģ���ΪpreSum[0] = 0
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                if(preSum[i] - preSum[j] == k){
                    res++;
                }
            }
        }
        return res;
    }
}
