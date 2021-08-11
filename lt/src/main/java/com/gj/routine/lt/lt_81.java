package com.gj.routine.lt;

import java.util.Scanner;

/**
 * @title: 搜索旋转排序数组 II
 * @description: 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 *               在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，
 *               使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 *               例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 *               给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。
 *               如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 *               示例1：
 *                  输入：nums = [2,5,6,0,0,1,2], target = 0
 *                  输出：true
 *               示例2：
 *                  输入：nums = [2,5,6,0,0,1,2], target = 3
 *                  输出：false
 *               提示：
 *                  1 <= nums.length <= 5000
 *                  -104 <= nums[i] <= 104
 *                  题目数据保证 nums 在预先未知的某个下标上进行了旋转
 *                  -104 <= target <= 104
 *               进阶：
 *                  这是 搜索旋转排序数组 的延伸题目，本题中的nums可能包含重复元素。
 *                  这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 * @author: jguo
 * @date: 2021/8/7
 */
public class lt_81 {

    /**
     * 与33题目类似，仅仅只是增加了可以重复的项，这样的话，在处理的时候需要微调。需要扣细节的
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return nums[0] == target;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                ++l;
                --r;
            } else if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一串数字，中间以逗号分隔：");
        String s = in.nextLine();
        System.out.println("请输入目标数字target：");
        int target = in.nextInt();
        String[] sInput = s.trim().split(",");
        int[] nums = new int[sInput.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(sInput[i]);
        }
        lt_81 solution = new lt_81();
        System.out.println("搜索旋转排序数组 II 搜索target的结果是：");
        System.out.println(solution.search(nums, target));
    }
}
