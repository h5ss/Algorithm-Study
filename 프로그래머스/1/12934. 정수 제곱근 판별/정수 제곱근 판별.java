class Solution {
    public long solution(long n) {
        double m = Math.sqrt(n);
        if(m%1==0){
          long x = (long) m;
          return (x+1)*(x+1);  
        } 
        else return -1;
    }
}