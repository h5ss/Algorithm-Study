import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] parts = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<n; i++){
            parts[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(parts);
        int i=0, j=n-1, count=0;
        while(i<j){
            if(parts[i]+parts[j]<m){
                i++;
            }else if(parts[i]+parts[j]>m){
                j--;
            }else{
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);
        br.close();
    }
}