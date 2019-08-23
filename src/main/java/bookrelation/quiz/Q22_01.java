package bookrelation.quiz;

/**
 * Created by Administrator on 2017/9/22 0022.
 */
public class Q22_01 {
    public  static int getAll( int personNum){

        int personNumHalf= personNum/2;
        int [] personArr = new int[personNum/2+1];
        personArr[0]=1;
        for(int i=1;i<=personNumHalf;i++){
            for(int j=0;j<i;j++){
                personArr[i]=personArr[i]+personArr[j]*personArr[i - j - 1];
            }

        }

        return personArr[personNumHalf];
    }
    public static void main(String[] args) {
        int all =getAll(6);
        System.out.println(all);
    }
}
