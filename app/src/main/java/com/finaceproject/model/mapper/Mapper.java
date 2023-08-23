package com.finaceproject.model.mapper;

public interface Mapper<T, R> {
    R toDao(T t);
    T toDto(R r);
}
