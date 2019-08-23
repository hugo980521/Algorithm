package algorithm.search;

/**
 * Created by Administrator on 2017/9/27 0027.
 */
public class BinarySearch {
    public static Double getRiskScore(double modelScore, double lowBase, double highBase, double[] lowScoreSplit, double[] highScoreSplit, double threshold) {


        double riskScore = 0d;
        if (modelScore < threshold) {
            riskScore = binarySearch(modelScore, lowScoreSplit, lowBase);
        } else {
            riskScore = binarySearch(modelScore, highScoreSplit, highBase);
        }
        return riskScore;

    }

    public static double binarySearch(double modelScore, double[] scoreSplit, double base) {
        int left = 0;
        int right = scoreSplit.length;
        int mid = (left + right) / 2;
        while (left < right) {
            if (scoreSplit[mid] < modelScore) {
                left = mid + 1;
            } else if (scoreSplit[mid] > modelScore) {
                right = mid;
            } else {
                return base + mid;
            }
            mid = (left + right) / 2;
        }

        if (right <= 0) {
            return base;
        }

        if (left >= scoreSplit.length) {
            return base + scoreSplit.length - 1;
        }
        return base + left;
    }

    public static void main(String[] args) {
        double threshold = 0.23;
        double modelScore = 0;
        double[] scoreSplit = {0.0439723, 0.0538579, 0.0602241, 0.065329, 0.0685916, 0.0730548, 0.0776901, 0.0825638, 0.0863589, 0.0901233,
                0.0939749, 0.0970442, 0.100665, 0.103821, 0.107098, 0.110576, 0.114158, 0.117756, 0.12025, 0.123276,
                0.12615, 0.129526, 0.132876, 0.135808, 0.138552, 0.141466, 0.145115, 0.148298, 0.151943, 0.1569,
                0.159855, 0.16251, 0.165556, 0.168223, 0.170781, 0.173395, 0.176574, 0.180045, 0.183857, 0.186641,
                0.189926, 0.192984, 0.195663, 0.199371, 0.202962, 0.206015, 0.208495, 0.211358, 0.215604, 0.22,
                0.221646, 0.223976, 0.227249, 0.230069, 0.232357, 0.234049, 0.236552, 0.23834, 0.242568, 0.245978,
                0.249286, 0.255221, 0.259477, 0.262554, 0.266902, 0.27143, 0.275257, 0.280895, 0.286209, 0.293314,
                0.302645, 0.307315, 0.315768, 0.321569, 0.328656, 0.342874, 0.357418, 0.374537, 0.394506, 0.431578, 999};

        double base = 10;
        modelScore = 0.0439723;
        System.out.println("分数：" + modelScore +
                "打分：" + binarySearch(modelScore, scoreSplit, base));
        modelScore = 0.0538579;
        System.out.println("分数：" + modelScore +
                "打分：" + binarySearch(modelScore, scoreSplit, base));
        modelScore = 0.431578;
        System.out.println("分数：" + modelScore +
                "打分：" + binarySearch(modelScore, scoreSplit, base));

        modelScore = 0.5;
        System.out.println("分数：" + modelScore +
                "打分：" + binarySearch(modelScore, scoreSplit, base));

        modelScore = 0.30157083;
        System.out.println("分数：" + modelScore +
                "打分：" + binarySearch(modelScore, scoreSplit, base));
    }
}
