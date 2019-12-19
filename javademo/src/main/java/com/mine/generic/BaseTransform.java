package com.mine.generic;

public interface BaseTransform<E> {

     <T> E parseTag(T t);

}