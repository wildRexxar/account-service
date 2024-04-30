package com.example.accountservice.mapper;

public interface Mapper <F, T> {
    T map(F object);
}
