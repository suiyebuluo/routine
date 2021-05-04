package com.gj.routine.lt;

import java.util.Scanner;

/**
 * @title: 删除有序数组中的重复项
 * @description: 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *               不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *               说明:
 *               为什么返回数值是整数，但输出的答案是数组呢?
 *               请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *               你可以想象内部操作如下:
 *               // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 *               int len = removeDuplicates(nums);
 *               // 在函数里修改输入数组对于调用者是可见的。
 *               // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 *               for (int i = 0; i < len; i++) {
 *                 print(nums[i]);
 *               }
 *               输入：nums = [0,0,1,1,1,2,2,3,3,4]
 *               输出：5, nums = [0,1,2,3,4]
 *               解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 * @author: jguo
 * @date: 2021/5/4
 */
public class lt_26 {

    public int removeDuplicates(int[] nums){
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i]!=nums[i-1]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,3,4,4,5,6};
        lt_26 solution = new lt_26();
        System.out.println(solution.removeDuplicates(nums));
    }

}
