package bookrelation.quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/30 0030.
 */
public class Q16_02 {
    public static List<Q16_Bean> getQ16(int num){
        List<Q16_Bean> lstQ16 = new ArrayList<>();


        int quarter=(num/4);
        for(int i=1;i<=quarter;i++){
            int half=2*i;
            for(int j=1;j<i;j++){
                for(int k=j+1;k<i;k++){
                    int powerJ=j*j;
                    int powerK=k*k;
                  if( i*i == ( powerJ + powerK )){
                      Q16_Bean localBean = new Q16_Bean();
                      localBean.setA(powerJ);
                      localBean.setB(powerK);
                      localBean.setC(i*i);
                      lstQ16.add(localBean);
                  }
                }

            }

        }
        return  lstQ16;
    }
    public static void main(String[] args) {
       int num=5000;
       long startTime=System.currentTimeMillis();

        List<Q16_Bean> lstQ16  =getQ16(num);
        long endTime=System.currentTimeMillis();
        System.out.println("耗时："+(endTime-startTime));
       for(Q16_Bean q16_bean:lstQ16){
          System.out.println("A:"+q16_bean.getA() + " B:"+q16_bean.getB()+ " C:"+q16_bean.getC() );
       }
    }
}
