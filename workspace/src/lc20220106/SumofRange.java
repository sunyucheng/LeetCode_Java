package lc20220106;

public class SumofRange {
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5,6};
		NumArray arr = new NumArray(nums);
		System.out.println(arr.sumRange(0, 2));
	}
}

class NumArray {
    //����
    //���Ի����ϻ�����ڹ�����֮��
    public int[] nums;

    //�������������������Ϊ��ʼ������
    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    //��ѯ������[left,right]���ۼӺ�
    public int sumRange(int left, int right) {
        int res = 0;
        for(int i = left; i <= right; i++){
            res += nums[i];
        }
        return res;
    }
}
