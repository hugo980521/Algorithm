package util;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

public class FeatureCodeGenerator {

  private static final char[] DICT_Z = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
  private static final char[] DICT_Y = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  private static final char[] DICT_X = "abcdefghijklmnopqrstuvwxyz".toCharArray();

  private static final char[] START = "aAa".toCharArray();

  public static String int32ToFeatureCode(int pos) {
    int startNum = ArrayUtils.indexOf(DICT_X, START[0]) * DICT_Y.length * DICT_Z.length
        + ArrayUtils.indexOf(DICT_Y, START[1]) * DICT_Z.length
        + ArrayUtils.indexOf(DICT_Z, START[2]);
    int value = startNum + pos;
    int x = value / (DICT_Y.length * DICT_Z.length);
    int y = value % (DICT_Y.length * DICT_Z.length) / DICT_Z.length;
    int z = value % (DICT_Y.length * DICT_Z.length) % DICT_Z.length;

    return StringUtils.join(new Character[]{DICT_X[x], DICT_Y[y], DICT_Z[z]}, "");
  }

  public static void main(String[] args) {
    System.out.println(int32ToFeatureCode(1001));
  }

}
