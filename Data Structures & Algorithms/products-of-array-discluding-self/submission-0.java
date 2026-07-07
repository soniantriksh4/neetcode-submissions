class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] ans = new int [nums.length];
        int prefix = 1;
        // left se chlnge prefix ka first loop k liye
        for (int i =0;i <nums.length;i++){
            ans[i] = prefix;
            prefix = prefix * nums[i];
        }
            //suffix right side jane k liye
            int suffix = 1;
            for (int i = nums.length -1; i>=0;i--){
                //ans complete k liye
                ans[i] *= suffix;
                // next iteration ka suffix prepare krti h
                suffix = suffix *= nums[i];
            }
        return ans ;
    }
}  
