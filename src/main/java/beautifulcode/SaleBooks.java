package beautifulcode;

import java.util.ArrayList;
import java.util.List;

public class SaleBooks {

    /**
     * 取得最大值数组
     * @param fValueArr
     * @return
     */
    public static BookBean[] getMaxArr(float[] fValueArr){
        List<BookBean> floatLst=new ArrayList<BookBean>();
        if(null !=floatLst){
            BookBean bookBean=new BookBean();
            floatLst.add(bookBean);
            for(int i=0;i<fValueArr.length;i++){
                bookBean=new BookBean();
                bookBean.setValue(fValueArr[i]);
                bookBean.setLow(i+1);
                floatLst.add(bookBean);
            }
            for(int i=fValueArr.length+1;i<=2*fValueArr.length;i++){
                int j=1;
                while(i-j >fValueArr.length){
                    j++;
                }
                float valueLocal=0;
                bookBean=new BookBean();
                for(;j<=(i/2);j++){
                  float temp=j*fValueArr[j-1]+(i-j)*fValueArr[i-j-1];
                  if(temp>valueLocal){
                      valueLocal=temp;
                      bookBean.setLow(j);
                      bookBean.setHigh(i-j);
                      bookBean.setValue(valueLocal);
                  }
                }
                floatLst.add(bookBean);
            }
            floatLst.remove(0);
        }

        return floatLst.toArray(new BookBean[floatLst.size()]);
    }

    // 买指定数量树的最小价格
    private  static float getMinCost(int[] numArr,float[] fValueArr){
        if(null ==numArr || null ==fValueArr){
            return 0;
        }

        if(numArr.length != fValueArr.length){
            return 0;
        }
        // 取得数量之和
        float sum=0;
        for(int i=0;i<numArr.length;i++){
            sum+=numArr[i];
        }


        // 排序数组
        sort(numArr);
        float discountAmount=0;
        for(int i=0;i<numArr.length;i++){
            int discountNum=numArr[i];
            if(i!=0){
                discountNum=numArr[i]-numArr[i-1];
            }
            discountAmount=discountAmount+discountNum*fValueArr[fValueArr.length-i-1];
        }


        return (sum-discountAmount);

    }

    // 排序数组
    public static void sort(int[] a){
        int i, j, k;

        for (i = 1; i < a.length; i++) {

            //为a[i]在前面的a[0...i-1]有序区间中找一个合适的位置
            for (j = i - 1; j >= 0; j--)
                if (a[j] < a[i]){
                    break;
                }

            //如找到了一个合适的位置
            if (j != i - 1) {
                //将比a[i]大的数据向后移
                int temp = a[i];
                for (k = i - 1; k > j; k--){
                    a[k + 1] = a[k];
                }
                //将a[i]放到正确位置上
                a[k + 1] = temp;
            }
        }
    }
    /**
     * 打印销售方案
     * @param num
     * @param fValueArr
     */
    public static void salePlan(int num,float[] fValueArr){
        if(num<1){
            return;
        }
        // 取得最佳组合
        BookBean[] result=getMaxArr(fValueArr);
        if(result.length<1){
            return;
        }
        BookBean bookBean=new BookBean();
        int totalFull=num/result.length*2;
        if(totalFull<0){
            totalFull=0;
        }
        int index=num%result.length-1;
        if(index>=0){
            bookBean=result[index];
        }
        int low=bookBean.getLow();
        int high=bookBean.getHigh();
        if(high==fValueArr.length){
            totalFull++;
            high=0;
        }
        int lowNum=0;
        if(low>0){
            lowNum=1;
        }
        if(low==high){
            high=0;
            lowNum++;
        }
        System.out.print(low+"卷数量："+lowNum+"  ");

        int highNum=0;
        if(high>0){
            highNum=1;
            System.out.print(high+"卷数量："+highNum+"  ");
        }

        System.out.print(" 全套数量："+totalFull);
    }


    public static void main(String[] args) {
        float[] fArr={0,0.05f,0.10f,0.20f,0.25f};
//        BookBean[] result=getMaxArr(fArr);
//        for(int i=0;i<result.length;i++){
//            BookBean bookBean=result[i];
//            System.out.println("i="+(i+1)+" value="+bookBean.getValue()+" low="+bookBean.getLow()+" high="+bookBean.getHigh());
//        }
//
//        salePlan(258,fArr);
        int[] numArr={96,34,22,18,12};
        float amount=getMinCost(numArr,fArr);
        System.out.println(amount);

    }
}
