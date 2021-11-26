package lc20211125;

public class BinarySearch {
	public static void main(String[] args){
		int[] nums = {-1,0,3,5,9,12};
		System.out.println(search(nums,0));
	}
	
    //���ֲ��ҷ�
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            //Ŀ��ֵ�������򷵻�-1
            return -1;
        }
        //���õ�������ҿ������䣬�����ڲ������target
        //�����ڳ�ʼֵ�Լ��м�ѭ����ʱ��������ҿ���
        //��Ϊ�������򷵻�-1��������Ҫ���ǵ��ǿ����ǽ��ж��ֲ���֮���ֲ����ڣ��򷵻�-1
        int res = -1;
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                res =  mid;
                break;
            }else if(nums[mid] > target){
                right = mid;
            }else{
                left  = mid + 1;
            }
        }
        return res;
    }
}
