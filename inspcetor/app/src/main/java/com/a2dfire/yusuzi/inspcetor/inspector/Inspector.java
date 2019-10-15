package com.a2dfire.yusuzi.inspcetor.inspector;


public interface Inspector<T,R> {
    R inspect(T t);
}
