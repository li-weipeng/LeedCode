package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by weipengli on 2016/12/8.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length - 3; i++) {
            if (i==0 || nums[i] != nums[i-1]) {
                for (int j=i+1; j<nums.length-2; j++) {
                    if (j==i+1 || nums[j] != nums[j-1]) {
                        List<List<Integer>> twoRes = twoSum(nums, j+1, nums.length-1, target-nums[i]-nums[j]);
                        for (List<Integer> list : twoRes) {
                            list.add(0, nums[j]);
                            list.add(0, nums[i]);
                            res.add(list);
                        }
                    }
                }
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int end, int target) {
        List<List<Integer>> res = new ArrayList<>();
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                List<Integer> item = new ArrayList<>();
                item.add(nums[start]);
                item.add(nums[end]);
                res.add(item);
                start++;
                end--;
                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }
                while (start < end && nums[end] == nums[end + 1]) {
                    end--;
                }
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        return res;
    }
}
