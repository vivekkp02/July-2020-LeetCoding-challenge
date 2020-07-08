/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
Note:
The solution set must not contain duplicate triplets.

Example:
Given array nums = [-1, 0, 1, 2, -1, -4],
A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

class Solution {
   /*
   public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
		int n = nums.length;
		Arrays.sort(nums);
		
		for(int i=0; i<n-2; i++){
            if(i > 0 &&  nums[i] == nums[i-1])
                continue;
            else{
			    int p1 = i+1; 
                int p2 = n-1;	
                int target = -nums[i];
			    while(p1 < p2){	
				   // int sum  nums[p1] + nums[p2];
				    if(target == nums[p1] + nums[p2]){
                        resultList.add(Arrays.asList(nums[i], nums[p1], nums[p2]));
                        p1++; p2--;
                        
                        while(p1 < p2 && nums[p1] == nums[p1-1]) 
                            p1++;
                        while(p1 < p2 && nums[p2] == nums[p2+1]) 
                            p1--; 
                        
				    }
				    else if(nums[p1] + nums[p2] > target){
					    p2--;
				    }else{
					    p1++;
				    }
			    }
            }
		}
        return resultList;
    }
    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;  
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}
