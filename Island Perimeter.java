/*
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island 
(i.e., one or more connected land cells).
The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. 
The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island. 

Example:
Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:
*/
class Solution {
    int perimeter = 0;
    void dfs(int i, int j, int[][] grid){
        grid[i][j] = 2;
        if(i==0 || grid[i-1][j]==0) perimeter++;
        if(i==grid.length-1 || grid[i+1][j]==0) perimeter++;
        if(j==0 || grid[i][j-1]==0) perimeter++;
        if(j==grid[0].length-1 || grid[i][j+1]==0) perimeter++;
        
        if(i>0 && grid[i-1][j]==1) dfs(i-1, j, grid);
        if(i<grid.length-1 && grid[i+1][j]==1) dfs(i+1, j, grid);
        if(j>0 && grid[i][j-1]==1) dfs(i, j-1, grid);
        if(j<grid[0].length-1 && grid[i][j+1]==1) dfs(i, j+1, grid);
    }
    public int islandPerimeter(int[][] grid) {  
        int m = grid.length;
        int n = grid[0].length;        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1) 
                    dfs(i, j, grid);                  
            }
        }
        return perimeter;   
        
       /*
        int m = grid.length;
        int n = grid[0].length;        
        int perimeter=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0) continue;
                perimeter += 4;
                if(i>0) perimeter -= grid[i-1][j];
                if(i<m-1) perimeter -= grid[i+1][j];
                if(j>0) perimeter -= grid[i][j-1];
                if(j<n-1) perimeter -= grid[i][j+1];                    
            }
        }
        return perimeter;     
        */
    }
}
