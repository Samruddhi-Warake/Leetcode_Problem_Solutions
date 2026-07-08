class Solution {
    public static void sortColors(int[] nums){
        int s=0;
        int e=nums.length-1;
        int idx=0;
        while(idx<=e){
            if(nums[idx]==0){
                int temp=nums[s];
                nums[s]=nums[idx];
                nums[idx]=temp;
                idx++;
                s++;
            }
            else if(nums[idx]==2){
                int temp=nums[e];
                nums[e]=nums[idx];
                nums[idx]=temp;
                e--;
            }
            else idx++;
        }
        for(int i=0;i< nums.length;i++){
            System.out.print(nums[i] + " ");
        }
    }
}