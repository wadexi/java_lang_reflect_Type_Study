package com.company;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ParamerizedTypeBean {

    Map<String,Person> map;

    Set<String> set;

    Class<?> clazz;

    Holder<String> holder;

    List<String> list;

    Map.Entry<String,String> entry;

    String string;

    Integer integer;

    Set set2;

    List aList;

    String[] strings;

    static class Holder<T>{

    }
}
