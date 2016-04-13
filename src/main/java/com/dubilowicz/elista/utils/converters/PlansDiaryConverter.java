package com.dubilowicz.elista.utils.converters;

import com.dubilowicz.elista.core.dto.PlansDiaryDto;
import com.dubilowicz.elista.data.ob.PlansDiaryOb;

/**
 * Created by RaikPraca on 2016-03-23.
 */
public class PlansDiaryConverter implements IConverter<PlansDiaryOb,PlansDiaryDto> {
    @Override
    public PlansDiaryOb ConvertToOb(PlansDiaryDto obj) {
        return new PlansDiaryOb(obj.GetId(),obj.GetUser(),obj.GetDay(),obj.GetBeginDate(),obj.GetEndDate());
    }

    @Override
    public PlansDiaryDto ConvertToDto(PlansDiaryOb obj) {
        return new PlansDiaryDto(obj.GetId(),obj.GetUser(),obj.GetDay(),obj.GetBeginDate(),obj.GetEndDate());
    }
}
