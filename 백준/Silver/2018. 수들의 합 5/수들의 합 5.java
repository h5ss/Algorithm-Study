import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1, start = 1, end = 1, sum = 1;
        
        while(end != n){
            if(sum == n){
                count++;
                end++;
                sum += end;
            }else if(sum > n){
                sum -= start;
                start++;
            }else{
                end++;
                sum += end;
            }
        }
        System.out.println(count);
    }
}