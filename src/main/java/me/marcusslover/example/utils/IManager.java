package me.marcusslover.example.utils;

import java.util.List;

public interface IManager<T> {
    void initialize();
    void register(T object);
    List<T> getAll();
}
