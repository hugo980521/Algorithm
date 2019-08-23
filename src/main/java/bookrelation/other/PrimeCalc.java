package bookrelation.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 计算素数
 */
public class PrimeCalc {
    private  int maxNum=0;
    public  PrimeCalc(int maxNum){
        this.maxNum=maxNum;
    }

    public List<Integer> getPrime(){
        boolean[] maxArr=new boolean[maxNum+1];
        for(int i=0;i<maxArr.length;i++){
            maxArr[i]=false;
        }
        List<Integer> lst = new ArrayList<Integer>();
        for(int i=2;i<=maxNum;i++){
           if(!maxArr[i]){
               lst.add(i);
               for(int j=(i+i);j<=maxNum;j+=i){
                   maxArr[j]=true;
               }
           }
        }

        return  lst;

    }

    public static void main(String[] args) {
        int maxNum=1000000000;
        PrimeCalc primeCalc = new PrimeCalc(maxNum);
        List<Integer> lst=primeCalc.getPrime();
        System.out.println(lst);

    }
}
