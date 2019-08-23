package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/9/5 0005.
 */
public class TimeUtils {

    public static  List<String> getTimeList(String startTime, String finishTime) {

        String startTimeLocal=startTime;
        if("".equals(startTime) || null == startTime){
            startTimeLocal="20170821";

        }

        if("".equals(finishTime) || null == finishTime){
            startTimeLocal="20170930";

        }
        String finishTimeLocal = finishTime;



        List<String> lstTime = new ArrayList<String>();
        String timeStr = String.valueOf(startTimeLocal);
        lstTime.add(timeStr);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");// 小写的mm表示的是分钟

        try {
            Date dateStart = sdf.parse(timeStr);

            Calendar c = Calendar.getInstance();
            c.setTime(dateStart);



            long dayCount =0;

            Date dateFinishLocal=new Date();
            if("".equals(finishTime) || null == finishTime){
                dateFinishLocal = new Date();

            }else{
                dateFinishLocal= sdf.parse(finishTimeLocal);
            }
            dayCount = (dateFinishLocal.getTime() - dateStart.getTime())/(24*60*60*1000);

            for(long i=1;i<=dayCount;i++){
                c.add(Calendar.DATE, 1); //日期加1天
                Date dateLocal = c.getTime();
                String dayStr = sdf.format(dateLocal);
                lstTime.add(dayStr);
            }

        } catch (ParseException e) {

        }

        return lstTime;

    }
}
