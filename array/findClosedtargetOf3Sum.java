import java.util.Arrays;

public class findClosedtargetOf3Sum {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int result = nums[0] + nums[1] + nums[2];
            for(int i=0;i<nums.length-2;i++){
                int left = i+1;
                int right = nums.length - 1;
                while(left != right){
                    int min = nums[i] + nums[left] + nums[left + 1];
                    if(target < min){
                        if(Math.abs(result - target) > Math.abs(min - target))
                            result = min;
                        break;
                    }
                    int max = nums[i] + nums[right] + nums[right - 1];
                    if(target > max){
                        if(Math.abs(result - target) > Math.abs(max - target))
                            result = max;
                        break;
                    }
                    int sum = nums[i] + nums[left] + nums[right];
                    // 判断三数之和是否等于target
                    if(sum == target)
                        return sum;
                    if(Math.abs(sum - target) < Math.abs(result - target))
                        result = sum;
                    if(sum > target){
                        right--;
                        while(left != right && nums[right] == nums[right+1])
                            right--;
                    }
                    else{
                        left++;
                        while(left != right && nums[left] == nums[left-1])
                            left++;
                    }
                }
                while(i<nums.length-2 && nums[i] == nums[i+1])
                    i++;
            }
            return result;
        }
    }


}
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //int [] ans ;
        //if(nums == null || nums.length>=3) return null;
        Arrays.sort(nums);
        int ans = nums[0]+nums[1]+nums[2];

        for(int i=0;i<nums.length-2;++i){
            int left = i+1;
            int right = nums.length-1;
            while(left<right){

                int min = nums[i]+nums[left]+nums[left+1];
                if(target<min){
                    if(Math.abs(min-target) < Math.abs(ans-target)){
                        ans = min;
                    }
                    break;

                }
                int max = nums[i]+nums[right]+nums[right-1];
                if(target>max){
                    if(Math.abs(max-target) < Math.abs(ans- target)){
                        ans= max;
                    }
                    break;
                }


                int sum = nums[i]+nums[left]+nums[right];
                if(Math.abs(ans-target) > Math.abs(sum-target)){
                    ans = sum;
                }
                if(sum == target){
                    return sum;
                }
                else if(sum<target){
                    left++;
                    while(left<right && nums[left]==nums[left+1]){
                        left++;
                    }

                }else if(sum>target){
                    right--;
                    while(left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                }

            }
            while(i<nums.length-2 && nums[i]==nums[i+1]){
                i++;
            }
        }
        return ans;

    }
}
