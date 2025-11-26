import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long[] numbers = new long[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      numbers[i] = Long.parseLong(st.nextToken());
    }

    Arrays.sort(numbers);
    int result = 0;
    for(int k=0; k<N; k++){
      long find = numbers[k];
      int i=0;
      int j=N-1;

      while(i<j){
        if(numbers[i] + numbers[j] == find){
          if(i!=k && j!=k){
            result++;
            break;
          }else if(i==k){
            i++;
          }else if(j==k){
            j--;
          }
        }else if(numbers[i] + numbers[j] < find){
          i++;
        }else{
          j--;
        }
      }
    }
    System.out.print(result);
    br.close();
  }
}