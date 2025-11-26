import java.io.*;
import java.util.*;

public class Main {
    static int[] need = new int[4]; // 필요한 최소 개수 (A,C,G,T)
    static int[] now = new int[4];  // 현재 윈도우의 개수
    static int successCount = 0;    // 조건 충족한 비밀번호 개수
    static int checkCount = 0;      // 4개 중 조건을 만족한 개수가 몇 개인지

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken()); // 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이

        char[] dna = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            need[i] = Integer.parseInt(st.nextToken());
            if (need[i] == 0) checkCount++; // 필요 수가 0이면 이미 만족한 것
        }

        // 초기 윈도우 P개 세팅
        for (int i = 0; i < P; i++) {
            add(dna[i]);
        }

        // 첫 윈도우가 조건 만족하면 successCount++
        if (checkCount == 4) successCount++;

        // 슬라이딩 윈도우 시작
        for (int i = P; i < S; i++) {
            int start = i - P;
            add(dna[i]);      // 새 문자 추가
            remove(dna[start]); // 빠지는 문자 제거

            if (checkCount == 4) successCount++;
        }

        System.out.println(successCount);
    }

    // 새 문자 들어올 때 카운트 증가
    static void add(char c) {
        int idx = toIndex(c);
        now[idx]++;
        if (now[idx] == need[idx]) {
            checkCount++;
        }
    }

    // 문자가 빠질 때 카운트 감소
    static void remove(char c) {
        int idx = toIndex(c);
        if (now[idx] == need[idx]) {
            checkCount--;
        }
        now[idx]--;
    }

    // 문자 → 배열 index 매핑
    static int toIndex(char c) {
        switch (c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            default: return 3; // 'T'
        }
    }
}
