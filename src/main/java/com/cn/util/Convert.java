package com.cn.util;

import com.beust.jcommander.internal.Lists;
import com.beust.jcommander.internal.Maps;
import org.springframework.cglib.beans.BeanMap;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

/**
 * @author chenyun
 * @projectName springboot
 * @description: 转换工具类:时间、金额、字符串、对象、Map
 * @date 2019/8/30 22:49
 */
public class Convert {

    /**
     * 浮点数相加
     *
     * @param d1
     * @param d2
     * @return
     */
    public static double doubleAdd(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return doubleFormat(b1.add(b2).doubleValue());
    }

    /**
     * 浮点数相减
     *
     * @param d1
     * @param d2
     * @return
     */
    public static double doubleSub(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return doubleFormat(b1.subtract(b2).doubleValue());
    }

    /**
     * 浮点数相乘
     *
     * @param d1
     * @param d2
     * @return
     */
    public static double doubleMul(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return doubleFormat(b1.multiply(b2).doubleValue());
    }

    /**
     * 浮点数相除
     *
     * @param d1
     * @param d2
     * @return
     */
    public static double doubleDivide(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return doubleFormat(b1.divide(b2, 10, RoundingMode.HALF_DOWN).doubleValue());
    }

    /**
     * 不定参数相加【请确保最少有两个参数】
     *
     * @param doubles
     * @return
     */
    public static double doublesAdd(double... doubles) {
        BigDecimal b1 = new BigDecimal(Double.toString(doubles[0]));
        for (int i = 1; i < doubles.length; i++) {
            BigDecimal b2 = new BigDecimal(Double.toString(doubles[i]));
            b1 = b1.add(b2);
        }
        return doubleFormat(b1.doubleValue());
    }

    /**
     * 不定参数相减【请确保最少有两个参数】
     *
     * @param doubles
     * @return
     */
    public static double doublesSub(double... doubles) {
        BigDecimal b1 = new BigDecimal(Double.toString(doubles[0]));
        for (int i = 1; i < doubles.length; i++) {
            BigDecimal b2 = new BigDecimal(Double.toString(doubles[i]));
            b1 = b1.subtract(b2);
        }
        return doubleFormat(b1.doubleValue());
    }

    /**
     * 不定参数相乘【请确保最少有两个参数】
     *
     * @param doubles
     * @return
     */
    public static double doublesMul(double... doubles) {
        BigDecimal b1 = new BigDecimal(Double.toString(doubles[0]));
        for (int i = 1; i < doubles.length; i++) {
            BigDecimal b2 = new BigDecimal(Double.toString(doubles[i]));
            b1 = b1.multiply(b2);
        }
        return doubleFormat(b1.doubleValue());
    }


    /**
     * double保留两位小数点
     *
     * @param d
     * @return
     */
    public static double doubleFormat(double d) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(d));
    }

    /**
     * intToInt
     *
     * @param val
     * @param defaultValue 默认值
     * @return
     */
    public static Integer intToInt(Integer val, Integer defaultValue) {
        int d = defaultValue;
        if (val == null) {
            return d;
        }
        return val;
    }

    /**
     * stringToInt
     *
     * @param val
     * @param defaultValue 默认值
     * @return
     */
    public static Integer stringToInt(String val, Integer defaultValue) {
        Integer d = defaultValue;
        try {
            d = Integer.parseInt(val);
        } catch (Exception e) {

        }
        return d;
    }

    /**
     * 将数字1或0转换为boolean
     *
     * @param state
     * @return
     */
    public static Boolean stringToBoolean(String state) {
        int t = stringToInt(state, 0);
        return t == 1;
    }

    /**
     * stringToDouble
     *
     * @param val
     * @param defaultValue
     * @return
     */
    public static Double stringToDouble(String val, double defaultValue) {
        double d = defaultValue;
        try {
            d = Double.parseDouble(val);
        } catch (Exception e) {

        }
        return d;
    }

    /**
     * stringToString
     *
     * @param val
     * @param defaultValue 默认值
     * @return
     */
    public static String stringToString(String val, String defaultValue) {
        if (val != null && !"".equals(val.trim())) {
            return val;
        }
        return defaultValue;
    }

    /**
     * 将对象装换为map
     * @param bean
     * @return
     */
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = Maps.newHashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key+"", beanMap.get(key));
            }
        }
        return map;
    }

    /**
     * 将map装换为javabean对象
     * @param map
     * @param bean
     * @return
     */
    public static <T> T mapToBean(Map<String, Object> map,T bean) {
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }

    /**
     * 将List<T>转换为List<Map<String, Object>>
     * @param objList
     * @return
     */
    public static <T> List<Map<String, Object>> objectsToMaps(List<T> objList) {
        List<Map<String, Object>> list = Lists.newArrayList();
        if (objList != null && objList.size() > 0) {
            Map<String, Object> map = null;
            T bean = null;
            for (int i = 0,size = objList.size(); i < size; i++) {
                bean = objList.get(i);
                map = beanToMap(bean);
                list.add(map);
            }
        }
        return list;
    }


    /**
     * 将List<Map<String,Object>>转换为List<T>
     * @param maps
     * @param clazz
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static <T> List<T> mapsToObjects(List<Map<String, Object>> maps,Class<T> clazz) throws InstantiationException, IllegalAccessException {
        List<T> list = Lists.newArrayList();
        if (maps != null && maps.size() > 0) {
            Map<String, Object> map = null;
            T bean = null;
            for (int i = 0,size = maps.size(); i < size; i++) {
                map = maps.get(i);
                bean = clazz.newInstance();
                mapToBean(map, bean);
                list.add(bean);
            }
        }
        return list;
    }


}
