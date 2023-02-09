package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayProblems {
    public static void main(String[] args) {

        int[] arr = {3, 4, 3, 0, 8, 7};
        int target = 11;

        twoSum(arr, target);

    }

    public static String reverse(String text) {
        if (text == null) {
            return null;
        }

        char[] arr = text.toCharArray();
        int startIndex = 0;
        int endIndex = arr.length - 1;
        while (startIndex < endIndex) {
            char temp = arr[endIndex];
            arr[endIndex--] = arr[startIndex];
            arr[startIndex++] = temp;
        }

        return new String(arr);
    }

    public static int[] mergeSortedArrays(int[] array1, int[] array2) {

        // [0,3,4,31] [4,6,30]

        if (array1.length == 0 && array2.length > 0) return array2;
        if (array1.length > 0 && array2.length == 0) return array1;
        if (array1.length == 0 && array2.length == 0) return null;

        int mergedLength = array1.length + array2.length;
        int[] merged = new int[mergedLength];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < array1.length && j < array2.length) {

            if (array1[i] < array2[j]) {
                merged[k++] = array1[i++];
            } else {
                merged[k++] = array2[j++];
            }
        }

        while (i < array1.length) {
            merged[k++] = array1[i++];
        }

        while (j < array2.length) {
            merged[k++] = array2[j++];
        }

        System.out.println(Arrays.toString(merged));
        return merged;
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }

        /*

        Solution 1 - Time Complexity n^2

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }*/

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                System.out.println(Arrays.toString(new int[] {i, map.get(target - nums[i])}));
                return new int[] {i, map.get(target - nums[i])};
            }
        }

        return null;
    }
}
