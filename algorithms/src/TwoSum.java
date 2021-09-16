import java.util.HashMap;

/**
 * @author: eric
 * @date: 2021/9/16 3:16 下午
 **/
public class TwoSum {
    /*
     * 方法一：暴力枚举
     * 使用遍历整个数组的方式寻找target - x时，每一个位于x之前的元素都已经和x匹配过的
     * 因此不需要在进行匹配，只匹配target - x部分
     * 时间复杂度O(N*N)
     * 空间复杂度O(1)
     * */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
    /*
    * 方法二：哈希表
    * 创建一个哈希表，将当前数值的下标储存为value，以值为当前的key，每次进行查询当前的表中是否包含target - x的key
    * 如果包含返回target - x 对应的value
    * */
    public int[] twoSum_1(int[] nums, int target){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (hashMap.containsKey(target - nums[i])){
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[0];
    }
    public static void main(String[] args) {
        int[] arr = {6, 3, 2, 1, 4, 5};
        TwoSum twoSum = new TwoSum();
        for (int i : twoSum.twoSum(arr, 5)) {
            System.out.println(i);
        }
        for (int i : twoSum.twoSum_1(arr, 6)) {
            System.out.println(i);
        }
    }
}
