import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        for(int num : arr){
            if(num%divisor==0) list.add(num);
        }
        if(list.isEmpty()) list.add(-1);
        answer = list.stream().mapToInt(i->i).toArray();
        Arrays.sort(answer);
        return answer;
    }
}