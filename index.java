package most_important;

public class KnapSackDypo 
{
    public static void main(String[] args) 
    {
        int[] item = {1,2,3,4};
        int[] itemW = {2,1,3,2};
        int[] itemV = {12,10,20,15};
        int sackW = 5;
        
        int[][] arr = new int[item.length+1][sackW+1];
        
        for (int i = 1; i < sackW+1; i++) 
        {
            arr[0][i] = 0;
        }
        for (int i = 0; i < item.length+1; i++) 
        {
            arr[i][0] = 0;
        }
        
        for (int i = 1; i < item.length+1; i++) 
        {
            for (int j = 1; j < sackW+1; j++) 
            {
                if (itemW[i-1]>j) 
                {
                    arr[i][j] = arr[i-1][j];
                }
                else
                {
                    int a = itemV[i-1]+arr[i-1][j-itemW[i-1]];
                    int b = arr[i-1][j];
                    
                    if (a>=b) 
                    {
                        arr[i][j] = a;
                    }
                    else
                    {
                        arr[i][j] = b;
                    }
                }
            }
        }
        
        System.out.println(arr[item.length][sackW]+" ");
    }
}