import java.util.Arrays;
class Solution {
    public long solution(long n) {
        char[] arr = String.valueOf(n).toCharArray(); // 숫자를 문자 배열로 변환
        Arrays.sort(arr); // 오름차순 정렬
        return Long.parseLong(new StringBuilder(new String(arr)).reverse().toString()); // 뒤집어서 숫자로 변환
    
    }
}