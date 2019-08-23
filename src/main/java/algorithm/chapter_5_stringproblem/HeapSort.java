package algorithm.chapter_5_stringproblem;

public class HeapSort {
    // 调整大顶堆
    public static void adjustHeap(char[] arr,int start,int length){
        int index=start;
        char temp=arr[start];
        for(int k=2*index+1;k<length;k=k*2+1){
            // 比较左右子节点大小
            if((k+1<length)&&(arr[k]<arr[k+1])){
                k++;
            }

            // 依次替换
            if(arr[k]>temp){
                arr[index]=arr[k];
                index=k;
            }else {
                break; // 调整完成
            }
        }
        arr[index]=temp; // 放到最终未知

    }

    public static void headSort(char[] arr){
        // 整体调整大顶堆
        int length=arr.length;
        for(int i=(length-1);i>=0;i--){
            adjustHeap(arr,i,length);
        }

        // 交换+调整大顶堆
        for(int j=length-1;j>=0;j--){
            char temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            adjustHeap(arr,0,j);
        }
    }

    public static void main(String[] args) {
        char[] chas = { '1', '2', '3', 'a', 'b', 'c', 'd', '4', '5', '6' };
        headSort(chas);
        for(int i=0;i<chas.length;i++){
            System.out.println(chas[i]);
        }
    }

}
