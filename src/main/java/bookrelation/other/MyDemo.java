package bookrelation.other;

import java.util.Arrays;

/**
 * Created by lcm on 2018/7/6 0006.
 */
public class MyDemo {
    public int getOverlappingCount(Interval[] A){

        int max = 0,count = 1;

        if(A==null || A.length==0) {
            return max;
        }

        Point[] points = new Point[A.length*2];

        for(int i = 0;i < A.length;i++){
            points[2*i] = new Point(A[i].start, 0);
            points[2*i+1] = new Point(A[i].end, 1);

        }


        Arrays.sort(points);

        for (int i = 0; i < points.length; i++) {

            if (points[i].type==0) {
                count++;
                max = Math.max(max, count);

            }else{
                count--;
            }
        }

        return max;

    }
    public static void main(String[] args){

        Interval[] testInterval=new Interval[4];
        testInterval[0]=new Interval(1,5);
        testInterval[1]=new Interval(10,15);
        testInterval[2]=new Interval(5,10);
        testInterval[3]=new Interval(20,30);

        MyDemo demo=new MyDemo();
        int max = demo.getOverlappingCount(testInterval);

        System.out.println(max);

    }
}


class Point implements Comparable<Point>{
    int value; //数值
    int type; //点的类型，0为起点，1为终点
    Point(int v,int t){
        value=v;
        type=t;
    }
    //实现compareTo函数
    public int compareTo(Point p){
        if(this.value==p.value){
            return 0;
        }else if(this.value >p.value){
            return 1;
        }else {
            return -1;
        }
    }

    //区间转换

}
