/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
Example:
Input:  [1,2,1,3,2,5]
Output: [3,5]
Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
*/
class Solution {
    public int[] singleNumber(int[] nums) {
       // xor will contain a ^ b as other elements have appeared twice
        int xor = 0;
        for (int num: nums) {
            xor = xor ^ num;
        }
        /*
        * get the low set bit, let's say it is at ith position and if ith
        * bit is set in A^B (xor), what does it mean? It means ith bit is
        * set in either A's or B's binary representation but not both.
        *
        * 1. now split all numbers into two groups, Group 1 will contains
        * all numbers whose ith bit is set in it's binary representation.
        * Let's assume A is also one of them. if we xor all the elements in
        * this group, we will get A why ? Because A has appeared exactly once
        * and rest of the elements which have ith bit set have appeared twice.
        * 
        * 2. second group will contain elements whose ith bit is not set. xoring
        * all the elements in this group will give B becaise B has appeared
        * exactly once and rest of the elements which have ith bit unset have
        * appeared twice.
        */
        int lowBitSet = xor & (-xor); // get the lowest bit set
        int a = 0; 
        int b = 0;
        for (int num: nums) {
            if ((lowBitSet & num) == 0) {
                // num has ith bit unset that's why & operation is returning zero
                a = a ^ num;
            } else {
                // num has ith bit set that's why & operation is returning non zero
                b = b ^ num;
            }
        }
        return new int[]{a,b};
    }
}
