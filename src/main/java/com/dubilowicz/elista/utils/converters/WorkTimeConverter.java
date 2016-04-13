package com.dubilowicz.elista.utils.converters;

import com.dubilowicz.elista.core.dto.WorkTimeDto;
import com.dubilowicz.elista.data.ob.WorkTimeOb;

/**
 * Created by RaikPraca on 2016-03-23.
 */
public class WorkTimeConverter implements IConverter<WorkTimeOb,WorkTimeDto> {
    @Override
    public WorkTimeOb ConvertToOb(WorkTimeDto obj) {
        return new WorkTimeOb(obj.Id(),obj.User(),obj.Day(),obj.Start(),obj.End(),obj.JobInfo());
    }

    @Override
    public WorkTimeDto ConvertToDto(WorkTimeOb obj) {
        return new WorkTimeDto(obj.Id(),obj.User(),obj.Day(),obj.Start(),obj.End(),obj.JobInfo());
    }
}
