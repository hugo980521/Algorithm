package leetcode.bitoperate;

public class TwoDifferentNumber {

    public static  void twoDifferentNumber(int[] numArr){
        int temp=numArr[0];
        for(int i=1;i<numArr.length;i++){
            temp=temp^numArr[i];
        }
        temp=temp&(temp^(temp-1));
        int x=0;
        int y=0;
        for(int p:numArr){
            if((p&temp) > 0){
                x=x^p;
            }else{
                y=y^p;
            }
        }


        System.out.println("x="+x+" y="+y);
    }

    public static void main(String[] args) {
        int[] numArr={2,1,2,3,4,1};
        twoDifferentNumber(numArr);
    }
}
