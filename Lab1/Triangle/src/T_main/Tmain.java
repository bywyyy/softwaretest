package T_main;

public class Tmain {
	private static int one, two, three = 1;
	
	public static void main(String[] args) {		
         check ( one , two , three );
    }

    public static int check ( int a , int b , int c ){
        int maxn = Math.max(Math.max(a,b), c);
        int x[]={a,b,c};
        int pow_sum = 0;
        int min_sum = 0;
        boolean flag = false;
        for ( int i = 0 ; i < x.length ; i++ )
        {
            if( x[i] != maxn || flag ){
                pow_sum += Math.pow(x[i], 2);
                min_sum += x[i];
            }
            if( x[i] == maxn ) flag = true;
        }
        //两边之和小于第三边，非法三角形
        if( min_sum <= maxn ) return -1;
        //等边三角形，返回1
        else if ( a == b && b == c  ) return 1;
        //等腰三角形，返回2
        else if( a== b || b == c || a == c ) return 2;
        //直角三角形，返回3
        else if( Math.pow(maxn, 2) == pow_sum ) return 3;
        //普通三角形，返回0
        return 0;
    }

}
