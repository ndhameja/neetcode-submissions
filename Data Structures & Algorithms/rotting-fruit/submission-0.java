class Solution {
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c= grid[0].length;
        int freshCount=0;
        int minutes=0;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1)
                    freshCount++;
                if(grid[i][j]==2)
                    q.offer(new int [] {i,j});
            }
        }
        if(freshCount==0)
            return minutes;
        int[][] directions = {{0,1},{0,-1},{1,0}, {-1,0}};

        while(!q.isEmpty()){
            int size=q.size();
            boolean spreadThisMinute=false;
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                
                for(int[] dir: directions){
                    int nr = curr[0]+dir[0];
                    int nc = curr[1]+dir[1];
                    if(nr>=0&&nc>=0&&nr<r&&nc<c&&grid[nr][nc]==1){
                        spreadThisMinute=true;
                        grid[nr][nc]=2;
                        q.add(new int[]{nr,nc});
                        freshCount--;
                    }
                }
            }
        if(spreadThisMinute)
            minutes++;
        }
        return freshCount==0? minutes:-1;
    }
}
