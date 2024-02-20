import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day36NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] chess=new char[n][n];
        List<List<String>> res=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                chess[i][j]='.';
            }
        }

        int pos[]=new int[n];
        Arrays.fill(pos,-1);
        CheckQueenPlacesPossible(0,chess,pos,res,n);

        return res;

    }

    public void CheckQueenPlacesPossible(int r,char[][] chess, int pos[], List<List<String>> res,int n)
    {
        if(r==n)
        {
            ConvertAndAdd(res,chess);
            return;
        }

        for(int i=0;i<n;i++)
        {
            if(ValidPlace(r,i,pos))
            {
                chess[r][i]='Q';
                pos[r]=i;
                CheckQueenPlacesPossible(r+1,chess,pos,res,n);
                pos[r]=-1;
                chess[r][i]='.';
            }
        }
    }

    public boolean ValidPlace(int r,int c ,int pos[])
    {
        int x1=r;
        int y1=c;
        for (int l = 0; l < pos.length; l++) {
            int x2=l;
            int y2=pos[l];
            if(pos[l]!=-1 && ( x1==x2 || y1==y2 || x1+y1==x2+y2 || x1-y1==x2-y2 ))
            {
                return false;
            }
        }
        return true;
    }

    public void ConvertAndAdd(List<List<String>> res,char[][] chess)
    {
        List<String> lst=new ArrayList<>();
        
        for(int i=0;i<chess.length;i++)
        {
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<chess.length;j++)
            {
                sb.append(chess[i][j]);
            }
            lst.add(sb.toString());
        }

        res.add(lst);

        
    }
}
