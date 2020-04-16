package javaSenior.reflectStudy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName reflectDemo
 * @Description TODO
 * @Author hzc
 * @Date 2020/4/16 22:05
 * @Version 1.0
 */
public class reflectDemo {
    public static void main(String[] args) throws Exception{
        String value = "ename:Smith|job:Clerk";
        Emp emp = ClassInstanceFactory.create(Emp.class,value);
        System.out.println("姓名"+emp.getEname()+"、工作"+emp.getJob());

    }

}

class ClassInstanceFactory{
    private ClassInstanceFactory(){};

    public static <T> T create(Class<?> clazz,String value)throws Exception{
        Object obj = clazz.getDeclaredConstructor().newInstance();
        String []valuelists = value.split("\\|");
        for(String valuelist:valuelists){
            String filedname = valuelist.split(":")[0];
            String fieldvalue = valuelist.split(":")[1];
            if(filedname.contains("\\.")){
                String temp[] = filedname.split("\\.");
                Object currentObject = obj;
                for(int y=0;y<temp.length-1;y++){
                    Method getMethod = currentObject.getClass().getDeclaredMethod("get"+StringUtils.omotcap(temp[y]));
                    Object tempObject = getMethod.invoke(currentObject);
                    if(tempObject==null){
                        Field field = currentObject.getClass().getDeclaredField(temp[y]);
                        Method method = currentObject.getClass().getDeclaredMethod("set"+StringUtils.omotcap(temp[y]));
                        Object newObject = field.getType().getDeclaredConstructor().newInstance();
                        method.invoke(currentObject,newObject);
                        currentObject = newObject;
                    }else {
                        currentObject = tempObject;
                    }
                }

                Field field = currentObject.getClass().getDeclaredField(temp[temp.length-1]);
                Method method = currentObject.getClass().getDeclaredMethod("set"+StringUtils.omotcap(field.getName()),field.getType());
                Object convertValue = convertAttributeValue(field.getType().getName(),fieldvalue);
                method.invoke(currentObject,convertValue);
            }else {
                try {
                    Field field = clazz.getDeclaredField(filedname);
                    Method method = clazz.getDeclaredMethod("set"+StringUtils.omotcap(filedname),field.getType());
                    Object val = convertAttributeValue(field.getType().getName(),fieldvalue); //用来做类型转换
                    method.invoke(obj,fieldvalue);
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        }
        return (T)obj;
    }

    public static Object convertAttributeValue(String type,String value){
        return null;
    }
}

class Emp{
    private String ename;
    private String job;

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEname() {
        return ename;
    }

    public String getJob() {
        return job;
    }
}

class StringUtils{
    public static String omotcap(String str){
        if(str==null || "".equals(str)){
            return "";
        }
        else if(str.length()==1){
            return str;
        }else {
            return str.substring(0,1).toUpperCase()+str.substring(1);
        }
    }
}
