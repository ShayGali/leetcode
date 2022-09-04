class Solution {
  // At best: Runtime - 3 ms, Memory - 51.2 MB 
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i =0; i<grid.length;i++){
            for(int j =0; j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    void dfs(char[][] grid, int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col]=='0') return;
        
        grid[row][col] = '0'; // mark as visited
        
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
        
    }
    	
  // To much OOP
  // At best: Runtime - 34 ms, Memory - 53.5 MB
    /*
    public int numIslands(char[][] grid) {
        Set<Index> visited = new HashSet<>();
        Index startNode = null;
        int count = 0;
        
        for(int i = 0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
              if(grid[i][j] == '1'){
                startNode = new Index(i,j);
                if(!visited.contains(startNode)){
                        dfs(grid,startNode,visited);
                        count++;
                }
              }
            }
        }
        return count;
    }
    
    void dfs(char[][] grid, Index startNode, Set<Index> visited){
        Stack<Index> workingStack = new Stack<>();
        workingStack.push(startNode);
        visited.add(startNode);
        while(!workingStack.isEmpty()){
            Index poped = workingStack.pop();
            List<Index> neighbors = getNeighbors(grid, poped.row, poped.col);
            for(Index nei : neighbors){
                if(!visited.contains(nei)){
                    workingStack.push(nei);
                    visited.add(nei);
                }
            }
        }
    }
    
    List<Index> getNeighbors(char[][] grid, int row,int col){
        List<Index> s = new LinkedList<>();
        int rowLen = grid.length;
        int colLen = grid[0].length;
        
        if(row -1 >=0 && grid[row -1][col] == '1')
            s.add(new Index(row -1,col));
        
        
        if(col-1 >=0 && grid[row][col-1]=='1')
            s.add(new Index(row ,col-1));
        
        if(col+1 < colLen && grid[row][col+1]=='1')
            s.add(new Index(row ,col+1));
        
        if(row + 1 < rowLen && grid[row+1][col] == '1')
            s.add(new Index(row+1,col));
              
        return s;
    }
    
    static class Index{
        int row;
        int col;
        
        Index(int x, int y){
            this.row = x;
            this.col = y;
        }
        
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Index index = (Index) o;
            return row == index.row && col == index.col;
        }
        
        public int hashCode(){
            return Objects.hash(row, col);
        }
    } 
    */
}
