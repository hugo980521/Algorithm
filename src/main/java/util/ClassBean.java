package util;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ClassBean implements Serializable{
    private String classId; // 分类ID
    private String className; // 分类名称
    private List<FeatureBean> lstFeatureBean=new ArrayList<FeatureBean>();

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<FeatureBean> getLstFeatureBean() {
        return lstFeatureBean;
    }

    public void setLstFeatureBean(List<FeatureBean> lstFeatureBean) {
        this.lstFeatureBean = lstFeatureBean;
    }
}
