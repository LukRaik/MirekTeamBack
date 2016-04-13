package com.dubilowicz.elista.data.repository;

import com.dubilowicz.elista.data.ob.AbsenceOb;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by RaikPraca on 2016-03-22.
 */
public interface IAbsenceRepository extends JpaRepository<AbsenceOb,Long> {
}
