package util;

import org.apache.commons.lang.StringUtils;

public class DesensitizationDataUtils {


    /**
     * 脱敏邮箱数据
     * @param data
     * @return
     */
    public static String desensitizationDataEmail(String data){
        String dataLocal= data;
        if(!StringUtils.isBlank(dataLocal)){
            int index = data.lastIndexOf('@');
            if(index<0){
                index=data.lastIndexOf('＠');
            }
            dataLocal=desensitizationDataBefore(dataLocal,index);
        }
        return  dataLocal;
    }


    /**
     * 脱敏后N位数据
     * @param data
     * @param length
     * @return
     */
    public static String desensitizationDataAfter(String data,int length){
        String dataLocal= data;
        if(!StringUtils.isBlank(dataLocal)){
            StringBuffer sb = new StringBuffer();
            int dataLength=dataLocal.length();
            if(dataLength > length){
                sb.append(dataLocal.substring(0,dataLength-length));
                for(int i=0;i< length ;i++){
                    sb.append('*');
                }
            }else{
                for(int i=0;i<dataLength;i++){
                    sb.append('*');
                }
            }
            dataLocal=sb.toString();
        }
        return  dataLocal;
    }

    /**
     * 脱敏前N位数据
     * @param data
     * @param length
     * @return
     */
    public static String desensitizationDataBefore(String data,int length){
        String dataLocal= data;
        if(!StringUtils.isBlank(dataLocal)){
            StringBuffer sb = new StringBuffer();
            int dataLength=dataLocal.length();
            if(dataLength > length){
                for(int i=0;i< length ;i++){
                    sb.append('*');
                }
                sb.append(dataLocal.substring(length,dataLength));

            }else{
                for(int i=0;i<dataLength;i++){
                    sb.append('*');
                }
            }
            dataLocal=sb.toString();
        }
        return  dataLocal;
    }

    /**
     * 脱敏中间N位数据
     * @param data
     * @param length
     * @return
     */
    public static String desensitizationDataMid(String data,int length){
        String dataLocal= data;
        if(!StringUtils.isBlank(dataLocal)&& length >0){
            StringBuffer sb = new StringBuffer();
            int dataLength=dataLocal.length();
            if(dataLength > length){
                int start=0;
                int end=0;

                int midData= dataLength/2 ;
                int midLength= (length/2);
                int  moldData = dataLength%2;
                int  moldLenth = length%2;

                if(moldData==0){
                    if(moldLenth==0){
                        start= midData+moldData- midLength;
                        end=midData+ midLength;
                    }else{
                        start= midData+moldData- midLength;
                        end=midData+ midLength+1;
                    }

                }else{
                    if(moldLenth==0){
                        start= midData+moldData- midLength;
                        end=midData+ midLength+1;
                    }else{
                        start= midData+moldData- midLength-1;
                        end=midData+ midLength+1;
                    }
                }


                sb.append(dataLocal.substring(0,start));


                for(int i=0;i< length ;i++){
                    sb.append('*');
                }
                sb.append(dataLocal.substring(end,dataLength));

            }else{
                for(int i=0;i<dataLength;i++){
                    sb.append('*');
                }
            }
            dataLocal=sb.toString();
        }
        return  dataLocal;
    }

    /**
     * 脱敏 指定从第start位到底end位的数据，指定时数组下表从1开始
     * @param data
     * @param start
     * @param end
     * @return
     */
    public static String desensitizationDataSpecify(String data,int start, int end){
        String dataLocal= data;
        if(!StringUtils.isBlank(dataLocal)){
            StringBuffer sb = new StringBuffer();
            int dataLength=dataLocal.length();

            if((dataLength >= start) && (dataLength >= end) ){
                sb.append(dataLocal.substring(0,start-1));
                int length= end-start+1;
                for(int i=0;i< length ;i++){
                    sb.append('*');
                }
                sb.append(dataLocal.substring(end,dataLength));

            }else{
                for(int i=0;i<dataLength;i++){
                    sb.append('*');
                }
            }
            dataLocal=sb.toString();
        }
        return  dataLocal;
    }

    public static void main(String[] args) {

        String str="中国1人民";
        System.out.println("脱敏前数据："+str);
        System.out.println("脱敏后3位： "+desensitizationDataAfter(str,3));
        System.out.println("脱敏前3位： "+desensitizationDataBefore(str,3));
        System.out.println("脱敏中间3位： "+desensitizationDataMid(str,3));
        System.out.println("脱敏中间4位： "+desensitizationDataMid(str,4));
        System.out.println();
         str="中国1人民真伟大";
        System.out.println("脱敏前数据："+str);
        System.out.println("脱敏中间3位： "+desensitizationDataMid(str,3));
        System.out.println("脱敏中间4位： "+desensitizationDataMid(str,4));


        str="中国";
        System.out.println("脱敏前数据："+str);
        System.out.println("脱敏中间1位： "+desensitizationDataMid(str,1));

        str="中国人";
        System.out.println("脱敏前数据："+str);
        System.out.println("脱敏中间1位： "+desensitizationDataMid(str,1));


        str="中国人";
        System.out.println("脱敏前数据："+str);
        System.out.println("脱敏从第2位到第3位的数据： "+desensitizationDataSpecify(str,2,3));
        System.out.println("脱敏从第2位到第3位的数据： "+desensitizationDataSpecify(str,2,2));

        str="123@126.com";
        System.out.println("脱敏前数据："+str);
        System.out.println("脱敏后邮箱的数据： "+desensitizationDataEmail(str));


        str="123＠126.com";
        System.out.println("脱敏前数据："+str);
        System.out.println("脱敏后邮箱的数据： "+desensitizationDataEmail(str));

    }



}
