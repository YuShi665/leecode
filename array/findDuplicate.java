import java.util.*;
public class findDuplicate {

    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param numbers int整型一维数组
         * @return int整型
         */
        public int duplicate (int[] numbers) {

            // write code here
            //O(nlogn)
            Arrays.sort(numbers);
            for(int i = 1; i < numbers.length; i++){
                if(numbers[i] == numbers[i-1]) return numbers[i];
            }
            return -1;
        }
        //O(N) 时间快但是空间占用多一些
        //hashmap 比hash set快
        public int duplicate1 (int[] numbers) {
            int res = -1;
            HashMap<Integer,Integer> h = new HashMap<>();
            for (int i=0;i< numbers.length;i++){
                if (h.containsKey(numbers[i])){
                    res = numbers[i];
                    return res;
                }else
                    h.put(numbers[i], i);
            }
            return res;
        }
        //O(N) 比上面慢
        public int duplicate2 (int [] numbers) {
            HashSet<Integer> set = new HashSet<>();
            for(int i=0; i<numbers.length; ++i){
                if(!set.add(i)){
                    return numbers[i];
                }
            }
            return -1;
        }
    }
}
