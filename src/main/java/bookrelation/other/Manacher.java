package bookrelation.other;

/**
 * manacher 算法实现，最长回文
 */
public class Manacher {
    public static void main(String[] args) {
        String s = "acbahkafojlnavnufnavkvnv";
        doManacher(s);
    }

    public static void doManacher(String s) {
        //在字符串两头和质检添加特殊字符转成奇数长度，原理：奇数+奇数+1=奇数，偶数+偶数+1=奇数。
        StringBuffer sb = new StringBuffer();
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb = sb.append(s.substring(i, i + 1)).append("#");
        }
        s = sb.toString();

//		以每个字符为轴求最长回文串半径，其中半径=1表示字符本身。
        int[] p = new int[s.length()];
        int left, right = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = 1;
            for (left = i - 1, right = i + 1; left >= 0 && right <= (2 * i) && right < s.length(); left--, right++) {
                if (s.charAt(left) == s.charAt(right)) {
                    len = len + 1;
                    continue;//如果匹配成功就继续
                } else {
                    break;//不成功就跳出循环
                }
            }
            p[i] = len;
        }//end wai for

        //求最大的p[i]值
        int pos, maxValuePos = 0;
        for (int i = 0; i < p.length - 1; i++) {
            pos = i;
            for (int j = i + 1; j < p.length; j++) {
                if (p[i] < p[j]) {
                    pos = j;
                    int tep = p[i];
                    p[i] = p[pos];
                    p[pos] = tep;
                }
                if (i == 0)
                    maxValuePos = pos;
            }
        }
        //求得的回文串一定是奇数长度
        int realLen = ((p[0] * 2 - 1) - 1) / 2;//最长回文串的长度，去掉其他字符
        System.out.println("最长的回文串长度为：" + realLen);


//求最长回文串内容
        String huiwen;
        StringBuffer realHuiwen = new StringBuffer();
        if (realLen == 1) {
            System.out.println("最长回文串为：" + s.charAt(maxValuePos));
        } else {
//              截出来
            huiwen = s.substring((maxValuePos + 1 - p[0]), maxValuePos + p[0]);
//             去掉辅助字符
            for (int j = 0; j < huiwen.length(); j++) {
                if (j % 2 != 0)
                    realHuiwen = realHuiwen.append(huiwen.charAt(j));
            }
            System.out.println("最长回文串为：" + realHuiwen.toString());
        }

    }

}
