/*
Given a set of distinct integers, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.

Example:
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());     
        for(Integer num : nums){
            List<List<Integer>> moreSubsets = new ArrayList<>();            
            for(List<Integer> newSubset : subsets){
                List<Integer> temp = new ArrayList<>(newSubset);
                temp.add(num);
                moreSubsets.add(temp);
            }            
            subsets.addAll(moreSubsets);
        }        
        return subsets;
    }
}
