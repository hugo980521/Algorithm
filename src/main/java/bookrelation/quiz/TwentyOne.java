package bookrelation.quiz;

/**
 * Created by Administrator on 2017/9/22 0022.
 */
public class TwentyOne {
    public static long game(int coin,int depth){
        if(coin==0){
            return 0;
        }
        if(depth ==0 ){
            return  1;
        }
        long  win = game(coin+1,depth-1);
        long  lose = game(coin-1,depth-1);

        return  win+lose;
    }

    public static void main(String[] args) {
        long result= game(10,24);
        System.out.println(result);
    }
}
