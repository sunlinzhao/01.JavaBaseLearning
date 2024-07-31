package com.slz.javalearing.day21;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/29
 */
public class TestGenerics {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        // 获得成员变量的泛型
        Field declaredField = King.class.getDeclaredField("list");
        Class<?> type = declaredField.getType(); // 得到的是非泛型类型
        System.out.println(type.getSimpleName());
        Type genericType = declaredField.getGenericType(); // 得到的是泛型类型
        System.out.println(genericType.getTypeName());
        // 判断获取到的 Type 是不是参数化类型(泛型)
        if(genericType instanceof ParameterizedType) {
            System.out.println("参数化类型（泛型）");
            ParameterizedType parameterizedType = (ParameterizedType) genericType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
//                System.out.println(actualTypeArgument.getTypeName());
                Class clazz = (Class) actualTypeArgument;
                System.out.println(clazz.getSimpleName());
            }
        }
        System.out.println("----------------------");
        // 获得方法参数的泛型
        Method test1 = King.class.getDeclaredMethod("test1", List.class, Map.class);
        Type[] genericParameterTypes = test1.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            if(genericParameterType instanceof ParameterizedType){
                ParameterizedType parameterizedType = (ParameterizedType) genericParameterType;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments(); // 因为实际的泛型参数可能有多个，例如 Map<K,V>, 所以这里用数组接收
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument.getTypeName());
                }
            }
        }
        System.out.println("----------------------");
        // 获得方法返回值的泛型
        Method test2 = King.class.getDeclaredMethod("test2");
        Type genericReturnType = test2.getGenericReturnType();
        if(genericReturnType instanceof  ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument.getTypeName());
            }
        }
    }
}

class King{
    // 成员变量带有泛型
    private List<String> list = new ArrayList<>();
    private  int x;
    // 方法参数带有泛型
    public void test1(List<String> list, Map<String, Integer> map){}
    // 方法返回值带有泛型
    public Map<String, Double> test2(){
        return null;
    }
}