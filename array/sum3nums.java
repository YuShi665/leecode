public class ss {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        if(nums==null||nums.length<3){
            return output;
        }
        for(int first = 0; first<nums.length-2;first++){
            if(nums[first]>0){
                break;
            }
            if(first>0 && nums[first-1]==nums[first]){
                continue;
            }
            int second=first+1;
            int third=nums.length-1;
            while(third>second){
                int sum= nums[third]+nums[first]+nums[second];
                if(sum==0){
                    output.add(ArrayList.asList(nums[first],nums[second],nums[third]));
                    while(third>second && nums[third]==nums[third-1]) --third;
                    while(third>second && nums[second]==nums[second+1]) ++second;
                }
                else if(sum>0) third--;

                else if(sum<0) second++;
            }
        }
        return output;

    }
}
