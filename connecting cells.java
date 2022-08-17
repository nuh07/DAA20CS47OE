import java.io.*;
import java.util.*;

public class Solution 
{

    	private static int[]nav={-1,0,1};
    	public static void main(String[] args) 
	{
    		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        	Scanner in=new Scanner(System.in);
        	int m=in.nextInt();
        	int n=in.nextInt();
		int a[][]=new int[m][n];
        	boolean visited[][]=new boolean [m][n];
        	for(int i=0;i<m;++i)
		{
            		for(int j=0;j<n;++j)
			{
                		a[i][j]=in.nextInt();
            		}
        	}
        	int max=0;
        	for(int i=0;i<m;++i)
		{
            		for(int j=0;j<n;++j)
			{
                		if( !visited[i][j] )
				{
                    			int region=region(visited, a,i,j,m,n);
                                   	max=Math.max(max,region);
                		}
            		}
        	}
       		System.out.println(max);
    	}
    	private static int region(boolean[][]visited, int [][]a,int row, int col, int m,int n)
	{
        	if(row>=m || col >=n || row<0 || col<0 || a[row][col]==0 || visited[row][col])
		return 0;
        	visited[row][col]=true;
        	int region=1;
        	for(int r:nav)
		{
            		for(int c:nav)
			{
                		region+=region(visited,a,row+r,col+c,m,n);
            		}
        	}
        	return region;
    	}
      }
