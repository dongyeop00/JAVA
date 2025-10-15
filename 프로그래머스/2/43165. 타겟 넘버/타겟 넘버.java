class Solution {
    
    static int count = 0;
    
    public int solution(int[] numbers, int target) {
        
        DFS(0, 0, numbers, target);
        
        return count;
    }
    
    public void DFS(int depth, int current, int[] numbers, int target){
        if(depth == numbers.length){
            if(current == target){
                count++;
            }
            return;
        }
        
        DFS(depth+1, current - numbers[depth], numbers, target);
        DFS(depth+1, current + numbers[depth], numbers, target);
    }
}