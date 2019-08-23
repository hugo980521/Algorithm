package bookrelation.other;

/**
 * Created by lcm on 2018/7/6 0006.
 */
public class Interval implements  Comparable<Interval>{
    int start; //起点
    int end; //终点
    Interval(int a, int b){
        start=a;
        end=b;
    }
    //实现compareTo函数
    public int compareTo(Interval p){
        if(this.start==p.start){
            return 0;
        }else if(this.start >p.start){
            return 1;
        }else {
            return -1;
        }
    }
}