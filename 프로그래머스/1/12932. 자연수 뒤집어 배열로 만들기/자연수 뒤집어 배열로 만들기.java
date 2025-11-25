class Solution {
    public int[] solution(long n) {
        String temp = Long.toString(n);
        int[] answer = new int[temp.length()];
        
        for(int i =0; i<temp.length(); i++){
            answer[i] = temp.charAt(temp.length() -1 -i) - '0';
        }
        return answer;
    }
}