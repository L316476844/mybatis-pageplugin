package org.jon.lv.utils;

import java.lang.reflect.Field;

public  class ReflectUtils {

    /**
     * 利用反射获取指定对象的指定属性
     * @param obj 目标对象
     * @param fieldName 目标属性
     * @return 目标属性的值
     */
    public static Object getFieldValue(Object obj, String fieldName) {
        Object result = null;
        Field field = ReflectUtils.getField(obj, fieldName);
        if (field != null) {
            field.setAccessible(true);
            try {
                result = field.get(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
            field.setAccessible(false);
        }
        return result;
    }

    /**
     * 利用反射获取指定对象里面的指定属性
     * @param obj 目标对象
     * @param fieldName 目标属性
     * @return 目标字段
     */
    private static Field getField(Object obj, String fieldName) {
        Field field = null;
        for (Class<?> clazz=obj.getClass(); clazz != Object.class; clazz=clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                break;
            } catch (NoSuchFieldException e) {
                //这里不用做处理，子类没有该字段可能对应的父类有，都没有就返回null。
            }
        }
        return field;
    }

    /**
     * 利用反射设置指定对象的指定属性为指定的值
     * @param obj 目标对象
     * @param fieldName 目标属性
     * @param fieldValue 目标值
     */
    public static void setFieldValue(Object obj, String fieldName,String fieldValue) {

        Field field = ReflectUtils.getField(obj, fieldName);
        if (field != null) {
            field.setAccessible(true);
            try {
                field.set(obj, fieldValue);
            } catch (Exception e) {

            }
            field.setAccessible(false);
        }
    }

    /**
     * 提取成员属性
     * @param object 要提取属性的所有者
     * @param type   要提取的类型
     * @param <T>     提取的值(支取第一个符合条件的)
     * @return
     */
    public static <T> T findMemberByType (Object object,Class<T> type){

        if( null == type )
            return null;

        if(  type.isInstance( object )  ){
            return (T)object;
        }

        if(  object instanceof java.util.Map ){

            java.util.Map paramMap= (java.util.Map) object;
            for(Object parameter : paramMap.values() ){

                if( type.isInstance( parameter )){
                    return (T) parameter;
                }
            }
        }
        return null;
    }
}