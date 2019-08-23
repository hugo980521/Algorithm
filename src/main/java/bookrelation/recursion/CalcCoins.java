package bookrelation.recursion;

/**
 * Created by lcm on 2018/6/29 0029.
 */
public class CalcCoins {
    private  static  int[] INT_COIN={1,3,5};
    public static int getCount(int n){
        if(n<=1){
            return  1;
        }
        if(n==2){
            return  2;
        }
        if(n==3){
            return  1;
        }

        if(n==4){
            return  3;
        }

        if(n==5){
            return  1;
        }
        int minx=n;
        for(int i=0;i<3;i++){
           int count=getCount(n-INT_COIN[i])+1;
           if(minx > count){
               minx=count;
           }
        }
        return  minx;
    }

    public static void main(String[] args) {
       System.out.println(getCount(11));
    }
}
