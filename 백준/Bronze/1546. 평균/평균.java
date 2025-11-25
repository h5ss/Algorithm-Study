import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] score = new int[n];
        
        for(int i = 0; i < n; i++){
            score[i] = sc.nextInt();
        }
        
        long sum = 0;
        long max = 0;
        
        for(int i=0; i<score.length; i++){
            if(score[i]>max)
                max = score[i];
            sum += score[i];
        }
        System.out.print(sum*100.0/max/n);
    }
}