package beautifulcode;

public class CakeTuneSimple {
    public static void main(String[] args) {
        int n=10;
        int[] num={2,5,4,9,8,3,1,6,0,7};
//        tune(num);

        tuneWithHat(num);
    }



    public  static int[] tune(int[] num){
        int maxId=0;//最大烙饼的下标
        int max=num[0];
        int n=num.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(num[j]>max){
                    num[j]=max;
                    maxId=j;
                }
            }
            reverse(num,maxId);//找到当前最大的之后开始把最大的翻到最上边
            reverse(num,n-i-1);//然后把没排好序的整体翻个个，让最大的翻到最下面。
        }
        for(int k=0;k<10;k++) {
            System.out.print(k);
        }
        return num;
    }
    public static void reverse(int[] num,int n){
        int i=0;
        int temp;
        if(n>num.length){
            System.out.println("超过数组大小");
            return;
        }
        while(i<n){
            temp=num[i];
            num[i]=num[n];
            num[n]=temp;
            n--;
            i++;
        }

    }

    /**
     * 有一些服务员会把上面的一摞饼子放在自己头顶上（放心，他们都戴着洁白的帽子），
     * 然后再处理其他饼子，在这个条件下，我们的算法能有什么改进？
     *
     * 每次找到最大的，把最大以上的放到帽子上，然后把最大的直径翻到底下
     * @param numArr
     * @return
     */
    public  static int[] tuneWithHat(int[] numArr){
        int maxId=0;//最大烙饼的下标
        int max=numArr[0];
        int n=numArr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(numArr[j]>max){
                    maxId=j;
                }
            }
            reverse(numArr,maxId,n-i-1);
        }
        for(int k=0;k<10;k++) {
            System.out.print(k);
        }
        return numArr;
    }

    public static void reverse(int[] numArr,int start, int end){
        if(null == numArr || start <0 || end>numArr.length || start > end){
            return;
        }
        int i=start;
        int j=end;
        while(i<j){
            int temp=numArr[i];
            numArr[i]=numArr[j];
            numArr[j]=temp;
            j--;
            i++;
        }

    }
}
