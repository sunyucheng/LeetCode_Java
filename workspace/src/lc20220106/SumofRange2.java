package lc20220106;

public class SumofRange2 {
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5,6};
		NumArray2 arr = new NumArray2(nums);
		System.out.println(arr.sumRange(0, 2));
	}
}

class NumArray2 {
    //����ǰ׺������
    //���ǰ׺��������������
    public int[] preSum;

    //�������������������Ϊ��ʼ������
    public NumArray2(int[] nums) {
        //��ΪpreSumֻ�������ˣ���û�ж��壬���������ǲ��Եģ���ֵ���Ӧ��д�ڶ���ĺ���
        //preSum[0] = 0;
        preSum = new int[nums.length+1];
        preSum[0] = 0;
        for(int i = 1; i < preSum.length; i++){
            preSum[i] = preSum[i-1] + nums[i-1];
        }
    }
    
    //��ѯ������[left,right]���ۼӺ�
    public int sumRange(int left, int right) {
        return preSum[right+1] - preSum[left];
    }
}