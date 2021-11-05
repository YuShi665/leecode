import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//time complexity O(n^2)
// sort array O(NlohN)
//+ FOR LOOP (O(N))
// * double pointer through the whole array once O(N)
// ++i SAVE one var so that slight faster than i++
public class sum3Nums {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        for (int first = 0; first < nums.length - 2; first++) {
            if (nums[first] > 0) {
                break;
            }
            //since array sorted ascending order once num[i]>0 the rest guarantee >0
            if (first > 0 && nums[first - 1] == nums[first]) {
                continue;
            }
            //skip duplicate continus skip the current iteration
            int second = first + 1;
            int third = nums.length - 1;
            while (third > second) {
                int sum = nums[third] + nums[first] + nums[second];
                if (sum == 0) {
                    output.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    while (third > second && nums[third] == nums[--third]) ;
                    while (third > second && nums[second] == nums[++second]) ;
                } else if (sum > 0) third--;
                else if (sum < 0) second++;
            }
        }
        return output;
    }
}

class solution2 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        //双指针
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            if (nums[i] > 0) return lists;

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int curr = nums[i];
            int L = i + 1, R = len - 1;
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if (tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    while (L < R && nums[L + 1] == nums[L]) ++L;
                    while (L < R && nums[R - 1] == nums[R]) --R;
                    ++L;
                    --R;
                } else if (tmp < 0) {
                    ++L;
                } else {
                    --R;
                }
            }
        }
        return lists;

    }
}

