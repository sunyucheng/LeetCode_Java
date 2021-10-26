package lc20211026;

public class FindCountOfTarget {
	public int search(int[] nums, int target) {
        return findRight(nums, target) - findRight(nums, target - 1);
    }

    //����target���ұ߽�ĺ�����ͨ�����ַ������ڶ��ַ��ݽ���һ����Ŀ��
    //���ҵ�������target�ĸ�������Ҫ�ҵ�target���ұ߽��target��-1���ұ߽磬�������
    public int findRight(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] <= target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}
