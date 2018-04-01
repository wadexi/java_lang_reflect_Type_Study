package com.company;

import jdk.internal.util.xml.impl.Input;

import java.io.InputStream;
import java.util.List;

public class TypeVariableBean<K extends InputStream,V>{


    //key的上边界为InputStream
    K key;

    //没有指定的话，V的上边界属于Object
    V value;

    //不属于TypeVariable
    V[] values;

    String str;

    List<K> kList;


}
