package com.company;

import java.io.FileInputStream;
import java.lang.reflect.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("====================ParamerizedTypeBean=============================");
        System.out.println("");

        Field[] fields = ParamerizedTypeBean.class.getDeclaredFields();
        for (Field field: fields){
            field.setAccessible(true);
            System.out.println(field.getName());
            System.out.println("typeName:" + field.getGenericType().getTypeName());

            if(field.getGenericType() instanceof  ParameterizedType){
                System.out.println("instanceof ParameterizedType:" + true);
                ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
                System.out.println("getRawType:" + parameterizedType.getRawType());

                Type[] typeArr = parameterizedType.getActualTypeArguments();
                System.out.println("getActualTypeArguments:" );
                for (int i = 0; i < typeArr.length;i++){
                    System.out.println("argument" + i + ":" + typeArr[i].getTypeName());
                }

                System.out.println("getOwnerType:" + parameterizedType.getOwnerType());
            }


            System.out.println("");
        }

        System.out.println("");
        System.out.println("====================TypeVariableBean=============================");
        System.out.println("");

        TypeVariableBean typeVariableBean = new TypeVariableBean<FileInputStream,String>();
        Field[] fields1 = typeVariableBean.getClass().getDeclaredFields();

        for (Field field: fields1){
            System.out.println("fieldName:" + field.getName());



            if(field.getGenericType() instanceof TypeVariable){
                System.out.println("instanceof TypeVariable:" + true);
                TypeVariable typeVariable = (TypeVariable) field.getGenericType();
                System.out.println("getName():" + typeVariable.getName());
                System.out.println("getGenericDeclaration():" + typeVariable.getGenericDeclaration());
                Type[] types = typeVariable.getBounds();

                System.out.println("getBounds():" );
                for(Type type : types){
                    System.out.println(type.getTypeName());
                }
            }

            System.out.println("");
        }

        System.out.println("");
        System.out.println("");
        System.out.println("===================GenericArrayTypeBean============================");
        System.out.println("");

        Method method = GenericArrayTypeBean.class.getDeclaredMethods()[0];
        method.setAccessible(true);
        Type[] types = method.getGenericParameterTypes();
        for (Type type: types){
            System.out.println("");
            System.out.println("typeName:" + type.getTypeName());
            if(type instanceof GenericArrayType){
                System.out.println("instanceof GenericArrayType:" + true);
                GenericArrayType genericArrayType = (GenericArrayType) type;
                System.out.println("GenericArrayTypeName:" + genericArrayType.getGenericComponentType().getTypeName());
            }
        }

        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("===============WildcardTypeBean========================");
        System.out.println("");


//        WildcardTypeBean<String> wildcardTypeBean = new WildcardTypeBean<String>();
//        Field[] fields2 = wildcardTypeBean.getClass().getDeclaredFields();
        Field[] fields2 = WildcardTypeBean.class.getDeclaredFields();

        for(Field field: fields2){
            System.out.println("");
            Type fieldType = field.getGenericType();
            System.out.println("getTypeName():" + fieldType.getTypeName());


            if(fieldType instanceof  TypeVariable){
                System.out.println("instanceof  TypeVariable :" + true);
            }

            if(fieldType instanceof  GenericArrayType){
                System.out.println("instanceof  GenericArrayType :" + true);
            }

            if(fieldType instanceof ParameterizedType){
                System.out.println("instanceof ParameterizedType:" + true);

                ParameterizedType parameterizedType = (ParameterizedType) fieldType;

                Type[] argumentsTypes = parameterizedType.getActualTypeArguments();

                for (Type type: argumentsTypes){
                    if(type instanceof WildcardType){
                        WildcardType wildcardType = (WildcardType) type;
                        System.out.println("getLowerBounds():" );
                        if(wildcardType.getLowerBounds() != null){
                            for (int i = 0; i < wildcardType.getLowerBounds().length;i++){
                                System.out.println(wildcardType.getLowerBounds()[i].getTypeName());
                            }

                        }

                        System.out.println("getUpperBounds():" );
                        if(wildcardType.getLowerBounds() != null){
                            for (int i = 0; i < wildcardType.getUpperBounds().length;i++){
                                System.out.println(wildcardType.getUpperBounds()[i].getTypeName());
                            }

                        }
                    }
                }
            }
        }

    }
}
