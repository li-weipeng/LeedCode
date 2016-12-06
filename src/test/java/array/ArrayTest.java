package array;

import org.junit.Test;

import java.util.List;

/**
 * Created by weipengli on 2016/12/6.
 */
public class ArrayTest {
    @Test
    public void twoSumTest() {
        TwoSum twoSum = new TwoSum();
        int[] res = twoSum.twoSum(new int[]{3,2,4}, 6);
        assert(res[0] == 1 && res[1] == 2);
    }

    @Test
    public void threeSumTest() {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> res = threeSum.threeSum2(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> item : res) {
            for (Integer val : item) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
