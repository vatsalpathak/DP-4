//tc = O(n-k) sc = O(n) 
//if we use two arrays of size k then sc = O(k)
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int [] dp = new int [n];
        dp[0] = arr[0];
        for(int i = 1; i < n; i++){
            int max = arr[i];
            for(int j = 1; j <= k && i-j+1 >= 0; j++){
                max = Math.max(max, arr[i-j+1]);
                int curr = 0;
                if(i-j >= 0){
                    curr = (j * max) + dp[i-j];
                }else{
                    curr =  j * max;
                }
                dp[i] = Math.max(dp[i], curr);
            }
        }
        return dp[n-1];
    }
}