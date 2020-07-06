/*
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:
Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.

Example 2:
Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
*/
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;        
        int sum = 0;
        int carry = 1;
        for(int i=n-1; i>=0; i--){
            sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }        
        if(carry > 0){
            int[] res = new int[n+1];
            res[0] = carry;
            for(int i=1; i<n+1; i++){
                res[i] = digits[i-1];
            }
            return res;            
        }else{
            int z = 0;
            while(digits[z] == 0){
                z++;
            }            
            int[] res = new int[n-z];
            for(int i=z; i<n; i++){
                res[i-z] = digits[i];
            }
            return res;            
        }
    }
}
