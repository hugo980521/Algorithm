package algorithm.search;

/**
 * Created by Administrator on 2017/9/27 0027.
 */
public class BinarySearchOld {
    public static Double getRiskScore(double modelScore,double lowBase, double highBase, double[] lowScoreSplit, double[] highScoreSplit, double threshold){


        double riskScore=0d;
        if (modelScore < threshold){
            riskScore=binarySearch(modelScore, lowScoreSplit, lowBase);
        }else{
            riskScore=binarySearch(modelScore, highScoreSplit, highBase);
        }
        return riskScore;

    }
    public static double binarySearch(double modelScore,double[] scoreSplit, double base ){
        int left=0;
        int right=scoreSplit.length;
        int mid = (left + right)/2;
        while(left < right){
            if(scoreSplit[mid] < modelScore ){
                left=mid+1;
            }else if(scoreSplit[mid] > modelScore){
                right = mid;
            }else{
                return  base + mid;
            }
            mid=(left + right)/2;
        }

        if(right <= 0){
            return base;
        }

        if(left >=scoreSplit.length){
            return  base + scoreSplit.length - 1;
        }
        return base + left;
    }

    public static void main(String[] args) {
       double threshold=0.23;
       double modelScore=0;
        double [] lowScoreSplit= {0.0461369, 0.0560492, 0.0622602, 0.0668611, 0.0713265, 0.0759019, 0.0798652, 0.0845326, 0.0884199, 0.0919281, 0.0953448, 0.0982539, 0.101934, 0.105037, 0.108043, 0.110879, 0.114218, 0.11718, 0.12025, 0.12395, 0.127201, 0.129904, 0.132943, 0.136426, 0.139296, 0.141512, 0.144903, 0.148112, 0.151008, 0.15402, 0.157232, 0.160555, 0.164235, 0.167702, 0.17039, 0.172946, 0.177055, 0.181082, 0.184367, 0.188602, 0.191857, 0.195315, 0.198893, 0.202964, 0.206524, 0.210978, 0.214552, 0.218492, 0.222417, threshold};
        double [] highScoreSplit={0.230689, 0.231709, 0.234028, 0.237044, 0.239945, 0.242564, 0.245366, 0.249074, 0.251721, 0.254429, 0.258356, 0.262024, 0.264687, 0.268918, 0.274284, 0.278637, 0.281542, 0.286339, 0.291642, 0.296387, 0.303146, 0.308169, 0.31565, 0.322423, 0.332469, 0.342791, 0.357937, 0.373523, 0.396003, 0.419906, 999};
        double lowBase = 10;
        double highBase = 60;

        modelScore=0.0461369;
        System.out.println( "分数：" +modelScore+
                "打分："+getRiskScore(modelScore,lowBase,highBase,lowScoreSplit,highScoreSplit,threshold));
        modelScore=0.0560492;
        System.out.println( "分数：" +modelScore+
                "打分："+getRiskScore(modelScore,lowBase,highBase,lowScoreSplit,highScoreSplit,threshold));


        modelScore=0.222417;
        System.out.println( "分数：" +modelScore+
                "打分："+getRiskScore(modelScore,lowBase,highBase,lowScoreSplit,highScoreSplit,threshold));


        modelScore=0.23;
        System.out.println( "分数：" +modelScore+
                "打分："+getRiskScore(modelScore,lowBase,highBase,lowScoreSplit,highScoreSplit,threshold));


        modelScore=0.230689;
        System.out.println( "分数：" +modelScore+
                "打分："+getRiskScore(modelScore,lowBase,highBase,lowScoreSplit,highScoreSplit,threshold));


        modelScore=0.231709;
        System.out.println( "分数：" +modelScore+
                "打分："+getRiskScore(modelScore,lowBase,highBase,lowScoreSplit,highScoreSplit,threshold));



        modelScore=0.419906;
        System.out.println( "分数：" +modelScore+
                "打分："+getRiskScore(modelScore,lowBase,highBase,lowScoreSplit,highScoreSplit,threshold));

        modelScore=0.419906;
        System.out.println( "分数：" +modelScore+
                "打分："+getRiskScore(modelScore,lowBase,highBase,lowScoreSplit,highScoreSplit,threshold));


        modelScore=999;
        System.out.println( "分数：" +modelScore+
                "打分："+getRiskScore(modelScore,lowBase,highBase,lowScoreSplit,highScoreSplit,threshold));


        modelScore=1000;
        System.out.println( "分数：" +modelScore+
                "打分："+getRiskScore(modelScore,lowBase,highBase,lowScoreSplit,highScoreSplit,threshold));
        modelScore=0.21351679;
        System.out.println( "分数：" +modelScore+
                "打分："+getRiskScore(modelScore,lowBase,highBase,lowScoreSplit,highScoreSplit,threshold));


    }
}
