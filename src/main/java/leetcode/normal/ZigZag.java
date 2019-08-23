package leetcode.normal;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

 这道题就是看坐标的变化。并且需要分块处理。

 n=2时，字符串坐标变成zigzag的走法就是：

 0 2 4 6

 1 3 5 7

 n=3时的走法是：

 0     4     8

 1  3 5  7 9

 2     6    10

 n=4时的走法是：

 0      6        12

 1   5 7    11 13

 2 4   8 10    14

 3      9         15
 */
public class ZigZag {

    public String convert(String s, int nRows) {
        if(s == null || s.length()==0 || nRows <=0)
            return "";
        if(nRows == 1)
            return s;

        StringBuilder res = new StringBuilder();
        int size = 2*nRows-2;
        for(int i=0;i<nRows;i++){
            for(int j=i;j<s.length();j+=size){
                res.append(s.charAt(j));
                if(i != 0 && i != nRows - 1){//except the first row and the last row
                    int temp = j+size-2*i;
                    if(temp<s.length()){
                        res.append(s.charAt(temp));
                    }

                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        ZigZag zigZag = new ZigZag();
       String resource= zigZag.convert("PAYPALISHIRING", 3);
       System.out.println(resource);
    }
}
