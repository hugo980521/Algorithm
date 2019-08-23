package util;

import java.io.Serializable;


public class FeatureBean implements Comparable<FeatureBean> {
    private String featureCode; // 特征编码
    private String featureName;// 特征名称

    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }
    public   int compareTo(FeatureBean featureBean)
    {
        return featureCode.compareTo(featureBean.getFeatureCode());
    }
}
