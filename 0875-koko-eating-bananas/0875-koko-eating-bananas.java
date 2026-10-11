class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int max = 1;
        for(int p:piles){
            max=Math.max(max,p);
        } 

        int ans = 0;
        int u = max;
        while(l<=u){
            int mid=(l+u)/2;
            int sum = 0;
            for(int i:piles){
                sum+=Math.ceil((double)i/mid);
            }

            if(sum>h){
                l=mid+1;
            }
            else{
                u=mid-1;
                ans=mid;
            }
        }
        return ans;
    }
}