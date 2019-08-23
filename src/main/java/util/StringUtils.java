package util;




import java.util.Collection;
import java.util.Map;


public class StringUtils {



	/**
	 * 去除字符串中所包含的空格（包括:空格(全角，半角)、制表符、换页符等）
	 * @param s
	 * @return
	 */
	public static String removeAllBlank(String s){
		String result = "";
		if(null!=s && !"".equals(s)){
			String spaceAll="[　*| *|\\s]*";
			result = s.replaceAll(spaceAll, "");
		}
		return result;
	}

	/**
	 * 去除字符串中头部和尾部所包含的空格（包括:空格(全角，半角)、制表符、换页符等）
	 * @param s
	 * @return
	 */
	public static String trimBluecat(String s){
		String result = "";
		if(null!=s && !"".equals(s)){
			String spaceAll="[　*| *|\\s]*";
			result = s.replaceAll("^"+spaceAll, "").replaceAll(spaceAll+"$", "");
		}
		return result;
	}
	public static boolean isSearchFeatureCode(String featureName) {
		boolean flag = false;
		if (StringUtils.isNotBlank(featureName)) {
			String regex = "^[a-z0-9A-Z]+$";//其他需要，直接修改正则表达式就好
			flag = featureName.matches(regex);
		}
		return flag;
	}



	public static void setParamMap(Map paramMap, String featureName) {
		String featureNameLocal = trimBluecat(featureName);
		String likeStr = "%" + featureNameLocal.toLowerCase() + "%";

		String preFix = "POR".toLowerCase();
		if (featureNameLocal.toLowerCase().indexOf(preFix) == 0) {
			paramMap.put("porIdLike", likeStr);
		} else {
			if (isSearchFeatureCode(featureNameLocal)) {
				paramMap.put("modelCodeLike", likeStr);
			} else {
				paramMap.put("featureNameLike", likeStr);
			}
		}
	}

	public static String trimNull(Object object){
        return object==null?"":trimToEmpty(object.toString());
    }

	

	public static boolean isEmpty(String str){
		return org.apache.commons.lang.StringUtils.isEmpty(str);
	}
	public static boolean isBlank(String str){
		return org.apache.commons.lang.StringUtils.isBlank(str);
	}

	public static boolean isNotBlank(String str){
		return !isBlank(str);
	}
	public static String defaultString(String str, String defaultStr) {
		return org.apache.commons.lang.StringUtils.defaultIfEmpty(str, defaultStr);
	}
//	Trim/Strip - removes leading and trailing whitespace
	public static String trimToEmpty(String str){
		return org.apache.commons.lang.StringUtils.trimToEmpty(str);
	}
	public static String trimToNull(String str){
		return org.apache.commons.lang.StringUtils.trimToNull(str);
	}
//	Equals - compares two strings null-safe
	public static boolean equals(String str1,String str2){
		return org.apache.commons.lang.StringUtils.equals(str1, str2);
	}
	public static boolean equalsIgnoreCase(String str1,String str2){
		return org.apache.commons.lang.StringUtils.equalsIgnoreCase(str1, str2);
	}
//	startsWith - check if a String starts with a prefix null-safe
	public static boolean startsWith(String str,String prefix){
		return org.apache.commons.lang.StringUtils.startsWith(str, prefix);
	}
	public static boolean startsWithIgnoreCase(String str,String prefix){
		return org.apache.commons.lang.StringUtils.startsWithIgnoreCase(str, prefix);
	}
//	endsWith - check if a String ends with a suffix null-safe
	public static boolean endsWith(String str,String suffix){
		return org.apache.commons.lang.StringUtils.endsWith(str, suffix);
	}
	public static boolean endsWithIgnoreCase(String str,String suffix){
		return org.apache.commons.lang.StringUtils.endsWithIgnoreCase(str, suffix);
	}

	public static boolean contains(String str,String searchChar){
		return org.apache.commons.lang.StringUtils.contains(str, searchChar);
	}

	public static String substring(String str,int start){
		return org.apache.commons.lang.StringUtils.substring(str, start);
	}
	public static String substring(String str,int start,int end){
		return org.apache.commons.lang.StringUtils.substring(str, start, end);
	}
	public static String left(String str,int len){
		return org.apache.commons.lang.StringUtils.left(str, len);
	}
	public static String right(String str,int len){
		return org.apache.commons.lang.StringUtils.right(str, len);
	}
	public static String center(String str,int size){
		return org.apache.commons.lang.StringUtils.center(str, size);
	}

	public static String[] split(String str){
		return org.apache.commons.lang.StringUtils.split(str);
	}
	public static String[] split(String str,String separatorChars){
		return org.apache.commons.lang.StringUtils.split(str, separatorChars);
	}
	public static String[] split(String str,String separatorChars,int max){
		return org.apache.commons.lang.StringUtils.split(str, separatorChars, max);
	}
	public static String join(String[] array){
		return org.apache.commons.lang.StringUtils.join(array);
	}
	public static String join(String[] array,String separator){
		return org.apache.commons.lang.StringUtils.join(array, separator);
	}
	public static String join(Collection<?> collection,String separator){
		return org.apache.commons.lang.StringUtils.join(collection, separator);
	}
	public static String join(Collection<?> collection){
		return org.apache.commons.lang.StringUtils.join(collection,"");
	}

	public static String str(String str, String remove){
		return org.apache.commons.lang.StringUtils.remove(str, remove);
	}
	public static String deleteWhitespace(String str){
		return org.apache.commons.lang.StringUtils.deleteWhitespace(str);
	}

	public static String Replace(String text, String searchString, String replacement){
		return org.apache.commons.lang.StringUtils.replace(text, searchString, replacement);
	}
	public static String replaceOnce(String text, String searchString, String replacement){
		return org.apache.commons.lang.StringUtils.replaceOnce(text, searchString, replacement);
	}

	public static String leftPad(String str,int size,String padStr){
		return org.apache.commons.lang.StringUtils.leftPad(str, size, padStr);
	}
	public static String leftPad(String str,int size){
		return org.apache.commons.lang.StringUtils.leftPad(str, size);
	}
	public static String rightPad(String str,int size,String padStr){
		return org.apache.commons.lang.StringUtils.rightPad(str, size, padStr);
	}
	public static String rightPad(String str,int size){
		return org.apache.commons.lang.StringUtils.rightPad(str, size);
	}

	public static String upperCase(String str){
		return org.apache.commons.lang.StringUtils.upperCase(str);
	}
	public static String lowerCase(String str){
		return org.apache.commons.lang.StringUtils.lowerCase(str);
	}
	public static String capitalize(String arg0){
		return org.apache.commons.lang.StringUtils.capitalize(arg0);
	}
	public static String uncapitalize(String arg0){
		return org.apache.commons.lang.StringUtils.uncapitalize(arg0);
	}

	public static boolean isAlpha(String arg0){
		return org.apache.commons.lang.StringUtils.isAlpha(arg0);
	}
	public static boolean isNumeric(String arg0){
		return org.apache.commons.lang.StringUtils.isNumeric(arg0);
	}
	public static boolean isWhitespace(String arg0){
		return org.apache.commons.lang.StringUtils.isWhitespace(arg0);
	}

}
