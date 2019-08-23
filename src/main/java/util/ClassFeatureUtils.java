package util;


import org.apache.commons.collections.CollectionUtils;

import java.util.*;

public class ClassFeatureUtils {

    public static Map<String, ClassBean> classMapGlobal = null;

    public static Map<String, ClassBean> generateClassFeature() {

        List<FeatureBean> lstFeatureBeanLocal= new ArrayList<FeatureBean>();

        Map<String, ClassBean> classMap = new HashMap<String, ClassBean>();
        if (null != classMapGlobal) {
            classMap = classMapGlobal;
        } else {


            try {
                String fileName = ClassFeatureUtils.class.getClassLoader().getResource("dicts.txt").toURI().getPath();
                List<String> lstFileContent = FileUtils.readTxtFile(fileName);


                for (String line : lstFileContent) {
                    String[] flieLineArr = line.split("\t");
                    String featureCode = flieLineArr[1];
                    String featureName = flieLineArr[2];
                    String className = flieLineArr[3];
                    String classId = flieLineArr[4];

                    ClassBean classBeanLocal = null;
                    if (classMap.get(classId) == null) {
                        classBeanLocal = new ClassBean();
                    } else {
                        classBeanLocal = classMap.get(classId);
                    }

                    if(featureCode.lastIndexOf("s")>=2){
                        FeatureBean featureBeanSort= new FeatureBean();
                        featureBeanSort.setFeatureCode(featureCode);
                        featureBeanSort.setFeatureName(line);
                        lstFeatureBeanLocal.add(featureBeanSort);
                    }

                    classBeanLocal.setClassId(classId);
                    classBeanLocal.setClassName(className);
                    List<FeatureBean> lstFeatueBean = classBeanLocal.getLstFeatureBean();
                    boolean existFlag = false;
                    for (FeatureBean featureBeanLoop : lstFeatueBean) {
                        if (featureCode.equals(featureBeanLoop.getFeatureCode())) {
                            existFlag = true;
                        }
                    }
                    if (!existFlag) {
                        FeatureBean featureBeanLocal = new FeatureBean();
                        featureBeanLocal.setFeatureCode(featureCode);
                        featureBeanLocal.setFeatureName(featureName);
                        lstFeatueBean.add(featureBeanLocal);
                        classBeanLocal.setLstFeatureBean(lstFeatueBean);

                    }

                    classMap.put(classId, classBeanLocal);
                }


            } catch (Exception ex) {
                ex.printStackTrace();
            }

            classMapGlobal = classMap;
        }

        Collections.sort(lstFeatureBeanLocal);
        for(FeatureBean featureBean:lstFeatureBeanLocal){
            System.out.println(featureBean.getFeatureName());
        }
        return classMap;
    }


    public static Map<String, String> featureMapGlobal = null;

    public static Map<String, String> generateFeatureMap() {
        Map<String, String> featureMapLocal = new HashMap<String, String>();
        if (null != featureMapGlobal) {
            featureMapLocal = featureMapGlobal;
        } else {


            try {
                String fileName = ClassFeatureUtils.class.getClassLoader().getResource("dicts.txt").toURI().getPath();
                List<String> lstFileContent = FileUtils.readTxtFile(fileName);


                for (String line : lstFileContent) {
                    String[] flieLineArr = line.split("\t");
                    String featureCode = flieLineArr[1];
                    String featureName = flieLineArr[2];
                    featureMapLocal.put(featureCode,featureName);

                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return featureMapLocal;
    }

    public static void main(String[] args) {
        ClassFeatureUtils.generateClassFeature();
        ClassFeatureUtils.generateFeatureMap();
        System.out.println("测试读取");

    }
}
