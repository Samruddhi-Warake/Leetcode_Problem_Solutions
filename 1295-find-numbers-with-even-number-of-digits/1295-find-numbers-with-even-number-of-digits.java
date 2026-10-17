class Solution {
    public int findNumbers(int[] nums) {
      int cnt=0;
      for(int i=0;i<=nums.length-1;i++){
      int digit=0;
     int temp = nums[i]; 
        while(temp>0){
            digit++;
             temp = temp/10;
}
if(digit%2==0){
       cnt++;
}
    }
return cnt;
}
}