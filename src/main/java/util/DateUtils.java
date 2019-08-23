package util;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class DateUtils implements Serializable {

    /**
     * 获取间隔内容所有日期
     *
     * @param dataDateStart
     * @param dataDateEnd
     * @return
     */
    public static List<String> getAllDate(String dataDateStart, String dataDateEnd) {
        List<String> lstRtn = new ArrayList<String>();

        if (!StringUtils.isEmpty(dataDateStart) && !StringUtils.isEmpty(dataDateEnd)) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                Date dateStart = simpleDateFormat.parse(dataDateStart);
                Date dateEnd = simpleDateFormat.parse(dataDateEnd);
                long diff = (dateEnd.getTime() - dateStart.getTime()) / (24 * 60 * 60 * 1000);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dateStart);

                for (int i = 0; i <= diff; i++) {
                    lstRtn.add(simpleDateFormat.format(getDateAfter(dateStart, i)));
                }


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return lstRtn;

    }

    /**
     * 得到几天后的时间
     *
     * @param d
     * @param day
     * @return
     */
    public static Date getDateAfter(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();
    }

    /**
     * 取得n天后的字符串
     * @param dataDate
     * @param day
     * @return
     */
    public static  String getDateAfterFromStr(String dataDate, int day){
        String dateStrLocal = formatDataDate(dataDate);
        Date date=new Date(strToDateLong(dateStrLocal));
        Date dateAfter=getDateAfter(date,day);

        return getDayStr(dateAfter);
    }



    /**
     * 获取格式为 yyyyMMdd 字符串时间的毫秒数
     *
     * @param strDate
     * @return
     */
    public static Long strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date strtodate = null;
        try {
            strtodate = formatter.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return strtodate.getTime();
    }


    /**
     * @param startTime
     * @param finishTime
     * @return
     */
    public static List<String> getMonthList(String startTime, String finishTime) {

        Map<String, String> monthMap = new HashMap<String, String>();
        if (StringUtils.isBlank(startTime) || StringUtils.isBlank(finishTime)) {
            // 开始或结束时间为空时，什么也不做
        } else {

            String startTimeLocal = startTime;
            String timeStr = String.valueOf(startTimeLocal);


            SimpleDateFormat sdfDay = new SimpleDateFormat("yyyyMMdd");// 小写的mm表示的是分钟
            SimpleDateFormat sdfMonth = new SimpleDateFormat("yyyyMM");// 小写的mm表示的是分钟

            try {
                Date dateStart = sdfDay.parse(timeStr);

                Calendar c = Calendar.getInstance();
                c.setTime(dateStart);

                Date dateFinishLocal = new Date();
                String finishTimeLocal = finishTime;


                dateFinishLocal = sdfDay.parse(finishTimeLocal);
                long dayCount = (dateFinishLocal.getTime() - dateStart.getTime()) / (24 * 60 * 60 * 1000);

                for (long i = 1; i <= dayCount; i++) {
                    c.add(Calendar.DATE, 1); //日期加1天
                    Date dateLocal = c.getTime();
                    String monthKey = sdfMonth.format(dateLocal);
                    monthMap.put(monthKey, "");
                }

            } catch (ParseException e) {

            }
        }

        List<String> rtnList = new ArrayList<String>(monthMap.keySet());
        Collections.sort(rtnList);
        return rtnList;
    }

    private static final String YYYYMMDD = "yyyyMMdd";

    public static String formatDataDate(String dateStr) {
        String strLocal = "";
        String dataStrLocal = dateStr.replace("-", "");
        SimpleDateFormat sdfFirst = new SimpleDateFormat(YYYYMMDD);
        try {
            Date dateTemp = sdfFirst.parse(dataStrLocal);
            strLocal = sdfFirst.format(dateTemp);
        } catch (Exception ex) {

        }

        return strLocal;
    }

    /**
     *  格式化成 2017-11-30
     * @param dateStr
     * @return
     */
    public static String formatWithDash(String dateStr) {
        String strLocal = "";
        SimpleDateFormat sdfFirst = new SimpleDateFormat(YYYYMMDD);
        try {
            Date dateLocal=sdfFirst.parse(formatDataDate(dateStr));

            SimpleDateFormat sdfSecond = new SimpleDateFormat("yyyyMMdd");
            strLocal=sdfSecond.format(dateLocal);
        } catch (Exception ex) {

        }

        return strLocal;
    }

    public static String formatWithISODate(String dateStr) {
        String strLocal = "";
        SimpleDateFormat sdfFirst = new SimpleDateFormat(YYYYMMDD);
        try {
            Date dateLocal=sdfFirst.parse(formatDataDate(dateStr));

            SimpleDateFormat sdfSecond = new SimpleDateFormat("yyyy-MM-dd");
            strLocal=sdfSecond.format(dateLocal);
        } catch (Exception ex) {

        }
        return strLocal;
    }

    public static List<String> getWeekStartList(String startTime, String finishTime) {
        String startTimeLocal = startTime;

        String finishTimeLocal = finishTime;

        Map<String, String> weekMap = new HashMap<String, String>();


        String timeStr = String.valueOf(startTimeLocal);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");// 小写的mm表示的是分钟


        try {
            Date dateStart = sdf.parse(timeStr);

            Calendar c = Calendar.getInstance();
            c.setTime(dateStart);


            long dayCount = 0;

            Date dateFinishLocal = new Date();
            if ("".equals(finishTime) || null == finishTime) {
                dateFinishLocal = new Date();

            } else {
                dateFinishLocal = sdf.parse(finishTimeLocal);
            }
            dayCount = (dateFinishLocal.getTime() - dateStart.getTime()) / (24 * 60 * 60 * 1000);

            for (long i = 1; i <= dayCount; i++) {
                c.add(Calendar.DATE, 1); //日期加1天
                Date dateLocal = c.getTime();
                String weekKey = getWeekStart(dateLocal);
                weekMap.put(weekKey, "");
            }

        } catch (ParseException e) {

        }
        List<String> rtnList = new ArrayList<String>(weekMap.keySet());
        Collections.sort(rtnList);
        return rtnList;
    }


    public static String getWeekStart(Date date) {
        String rtnStr = "";

        SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDD); //设置时间格式
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        //判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }

        cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一

        int day = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);//根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        String monday = sdf.format(cal.getTime());

        rtnStr = rtnStr + monday;


        return rtnStr;
    }

    public static String getWeekKey(Date date) {
        String rtnStr = "";

        SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDD); //设置时间格式
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        //判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }

        cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一

        int day = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);//根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        String monday = sdf.format(cal.getTime());

        rtnStr = rtnStr + monday;
        cal.add(Calendar.DATE, 6);
        String sunDay = sdf.format(cal.getTime());

        rtnStr = rtnStr + sunDay;


        return rtnStr;
    }

    public static Long getDateTimeMillis(Date date) {
        SimpleDateFormat sdfFirst = new SimpleDateFormat(YYYYMMDD);
        String dateStrLocal = sdfFirst.format(date);
        Long currentTime = 0l;
        try {
            currentTime = sdfFirst.parse(dateStrLocal).getTime();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return currentTime;

    }


    /**
     * 取得日期的最后毫秒数
     * @param date
     * @return
     */
    public static Long getLastDateTimeMillis(Date date) {
        SimpleDateFormat sdfFirst = new SimpleDateFormat(YYYYMMDD);
        String dateStrLocal = sdfFirst.format(date);

        Long currentTime = 0l;
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdfFirst.parse(dateStrLocal));
            cal.add(Calendar.DATE,1);
            currentTime = cal.getTime().getTime()-1;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return currentTime;

    }

    public static Integer timestampToYYYYMMDD(Long timestamp) {
        return Integer.valueOf(DateFormatUtils.format(timestamp, YYYYMMDD));
    }

    public static boolean isToday(Long timestamp) {
        return timestampToYYYYMMDD(System.currentTimeMillis()).equals(timestampToYYYYMMDD(timestamp));
    }

    public static String getDayStr(Date date) {
        return DateFormatUtils.format(date.getTime(), YYYYMMDD);
    }

    public static boolean isYesterday(Long timestamp) {
        DateTime today = new DateTime();
        DateTime time = new DateTime(timestamp);

        return today.getYear() == time.getYear() &&
                today.getMonthOfYear() == time.getMonthOfYear() &&
                today.getDayOfMonth() - time.getDayOfMonth() == 1;
    }

    public static boolean inLastWeek(long timestamp) {
        Date weekAgo = org.apache.commons.lang3.time.DateUtils.addDays(new Date(), -7);
        return timestampToYYYYMMDD(weekAgo.getTime()).compareTo(timestampToYYYYMMDD(timestamp)) <= 0;
    }

    public static void main(String[] args) {
        String dataDateStart="20170814";
        String strLocal=getDateAfterFromStr(dataDateStart,-1);
        System.out.println(strLocal);
        Date nowDate= new Date();
    }
}
