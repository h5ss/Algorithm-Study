import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        // 각 지점에 대한 좌표 map에 담기
        Map<Integer, int[]> map = new HashMap<>();
        for(int i=0; i<points.length; i++)
            map.put(i+1, points[i]);
        
        // routes에 있는 4->2 로봇들이 가는 경로 리스트
        List<List<int[]>> paths = new ArrayList<>();
        for(int[] route : routes){
            // 한 로봇의 경로 리스트
            List<int[]> path = new ArrayList<>();
            
            // 4에서 2로 가는 경로
            for(int j=0; j<route.length-1; j++){
                int[] start = map.get(route[j]);
                int[] end = map.get(route[j+1]);
                int r = start[0];
                int c = start[1];
                
                // 이동하기 전 출발점 포함
                if(path.isEmpty())
                    path.add(new int[]{r,c});
                
                // r 먼저 이동 
                while(r!=end[0]){
                    r += (end[0] > r)? 1 : -1;
                    path.add(new int[]{r,c});
                }
                
                // c 이동
                while(c!=end[1]){
                    c += (end[1] > c)? 1 : -1;
                    path.add(new int[]{r,c});
                }
            }
            
            paths.add(path);
        }
        
        // 매초 시뮬레이션
        int danger = 0;
        int maxTime = 0;
        
        for(List<int[]> path : paths)
            maxTime = Math.max(maxTime, path.size());
        
        for(int t = 0; t < maxTime; t++){
            Map<String, Integer> posCount = new HashMap<>();
            
            for(List<int[]> path : paths){
                if(t < path.size()){
                    int[] p = path.get(t);
                    String key = p[0] + "," + p[1];
                    posCount.put(key, posCount.getOrDefault(key, 0) + 1);
                }
            }
            
            for(int cnt : posCount.values()){
                if(cnt >= 2) danger++;
            }
        }
        
        answer = danger;
        
        return answer;
    }
}