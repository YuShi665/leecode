import java.util.HashMap;

public class SumOf2Num {
    public int[] twoSum(int[] nums, int target) {
        int [] output=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                //
                if(target==nums[j]+nums[i]){
                    output[1]=j;
                    output[0]=i;
                    return output;
                }
            }
        }
        return null;
    }
}
//time complexity O(n^2)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] list = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                //rewritie second for loop booster 3ms time complexity same
                if (nums[i] + nums[j] == target) {
                    list[0] = i;
                    list[1] = j;
                    break;
                }
            }
        }
        return list;

    }
}
//hash map time complexity O(n)!!!
//why?
//save a for loop
//how?
//hash map . containsKey (target-nums[i]) directly search key index O(1)
//be carefull containsK(here K is capital)ey
//create int array save ans at return step boost 1ms.
class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        //int [] output=new int[2];
        HashMap<Integer,Integer> map= new HashMap<Integer,Integer>();
        //Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;++i){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
                //output[0]=map.get(target-nums[i]);
                //output[1]=i;
            }
            map.put(nums[i],i);
        }
        return null;
    }
}