class Solution {
    boolean solution(String s) {
        String temp = s.toLowerCase();
        
        
        return temp.chars().filter(e->e=='p').count() == temp.chars().filter(e->e=='y').count();
    }
}