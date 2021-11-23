package com.gj.routine.lt;

import java.util.*;

/**
 * @title: 子集 II
 * @description: 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *               解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *               示例 1：
 *                  输入：nums = [1,2,2]
 *                  输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 *               示例 2：
 *                  输入：nums = [0]
 *                  输出：[[],[0]]
 *               提示：
 *                  1 <= nums.length <= 10
 *                  -10 <= nums[i] <= 10
 * @author: jguo
 * @date: 2021/9/15
 */
public class lt_90 {

    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0){
            result.add(path);
            return result;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        subsetsWithDupHelper(nums, 0);
        return result;
    }

    private void subsetsWithDupHelper(int[] nums, int startIndex){
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length){
            return;
        }
        for (int i = startIndex; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            subsetsWithDupHelper(nums, i + 1);
            path.removeLast();
            used[i] = false;
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] sInput = s.trim().split(",");
        int[] nums = new int[sInput.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(sInput[i]);
        }
        lt_90 solution = new lt_90();
        List<List<Integer>> results = solution.subsetsWithDup(nums);
        System.out.println(results);
    }


}
