package com.dubilowicz.elista.data.repository;

import com.dubilowicz.elista.data.ob.WorkTimeOb;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by RaikPraca on 2016-03-22.
 */
public interface IWorkTimeRepository extends JpaRepository<WorkTimeOb,Long> {

}
