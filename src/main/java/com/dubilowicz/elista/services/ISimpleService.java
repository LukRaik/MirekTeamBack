package com.dubilowicz.elista.services;


import java.util.List;

/**
 * Created by RaikPraca on 2016-03-22.
 */
public interface ISimpleService<T1,T2> {
    T1 saveEntity(T1 entityDto);
    void deleteEntity(T2 aId);
    List<T1> getAll();
}
