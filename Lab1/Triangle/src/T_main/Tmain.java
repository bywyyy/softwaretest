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
        //����֮��С�ڵ����ߣ��Ƿ�������
        if( min_sum <= maxn ) return -1;
        //�ȱ������Σ�����1
        else if ( a == b && b == c  ) return 1;
        //���������Σ�����2
        else if( a== b || b == c || a == c ) return 2;
        //ֱ�������Σ�����3
        else if( Math.pow(maxn, 2) == pow_sum ) return 3;
        //��ͨ�����Σ�����0
        return 0;
    }

}
