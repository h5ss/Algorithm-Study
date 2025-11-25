class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String temp = String.valueOf(x);
        int div = 0;
        for(int i =0; i<temp.length(); i++){
            div += temp.charAt(i) -'0';
        }
        if(x%div!=0){
            answer = false;
        }
        return answer;
    }
}