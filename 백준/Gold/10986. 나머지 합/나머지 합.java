import java.util.*;
public class Main{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] s = new long[n];
        long[] c = new long[m];
        long answer = 0;
        
        s[0] = sc.nextInt();
        for(int i =1; i<n; i++){
            s[i] = s[i -1] + sc.nextInt();
        }
        
        for(int i=0; i<n; i++){
            int r = (int)(s[i] % m);
            if(r == 0)
                answer ++;
            c[r]++;
        }
        for(int i=0; i<m; i++){
            if(c[i]>1){
                answer = answer + (c[i] * (c[i]-1)/2);
            }
        }
        System.out.println(answer);
    }
}