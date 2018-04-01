package com.company;

import java.util.List;

public class WildcardTypeBean<T> {

    private List<? extends Number> a;//a没有下界

    private List<? super  String> b;

    private  List<String> c;

    private Class<?> aClass;

    private T t;

    private T[] ts;

//    private List<String>[] lists;

    private Person<String>[] persons;

    private String[] strings;

    private String string;

    private List<String> listStrings;

    private List list;


 }
