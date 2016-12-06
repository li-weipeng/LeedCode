package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by weipengli on 2016/12/6.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        int target = 0;
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i=0; i<nums.length-2;i++) {
            if(i == 0 || nums[i]!=nums[i-1]) {
                for(int j=i+1; j<nums.length-1;j++) {
                    if (j==i+1 || nums[j] != nums[j-1]) {
                        if (map.containsKey(target - nums[i] - nums[j]) && map.get(target - nums[i] - nums[j]) > j) {
                            List<Integer> item = new ArrayList<>(3);
                            item.add(nums[i]);
                            item.add(nums[j]);
                            item.add(target - nums[i] - nums[j]);
                            res.add(item);
                        }
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2;i++) {
            if(i == 0 || nums[i]!=nums[i-1]) {
                List<List<Integer>> list = twoSum(nums, i+1, nums.length-1, -nums[i]);
                for(List<Integer> item : list) {
                    item.add(nums[i]);
                    res.add(item);
                }
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int end, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        while(start < end) {
            if (nums[start] + nums[end] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[start]);
                list.add(nums[end]);
                res.add(list);
                start++;
                end--;
                while (start <= end && nums[start] == nums[start - 1]) {
                    start++;
                }
                while (end -1 >= start && nums[end] == nums[end + 1]) {
                    end--;
                }
            } else if(nums[start] + nums[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> res = threeSum.threeSum(new int[]{0,0,0});
        for (List<Integer> item : res) {
            for (Integer val : item) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
