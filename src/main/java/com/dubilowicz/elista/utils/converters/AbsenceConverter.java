package com.dubilowicz.elista.utils.converters;

import com.dubilowicz.elista.core.dto.AbsenceDto;
import com.dubilowicz.elista.data.ob.AbsenceOb;

/**
 * Created by RaikPraca on 2016-03-23.
 */
public class AbsenceConverter implements IConverter<AbsenceOb,AbsenceDto> {
    @Override
    public AbsenceOb ConvertToOb(AbsenceDto obj) {
        return new AbsenceOb(obj.GetId(),obj.GetUser(),obj.GetType(),obj.GetDate(),obj.GetHours());
    }

    @Override
    public AbsenceDto ConvertToDto(AbsenceOb obj) {
        return new AbsenceDto(obj.GetId(),obj.GetUser(),obj.GetType(),obj.GetDate(),obj.GetHours());
    }
}
