package com.leonardostc.springbootrestapi.service;

import org.springframework.stereotype.Service;

import java.util.List;

public interface IService<T> {

    public List<T> findAll();
    public List<T> findAllOrderedBy(String property);
    public T findById(Long id);
    public T save(T t);
    public void deleteById(Long id);

}
