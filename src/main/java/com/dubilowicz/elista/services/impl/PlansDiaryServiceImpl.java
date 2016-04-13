package com.dubilowicz.elista.services.impl;

import com.dubilowicz.elista.core.dto.PlansDiaryDto;
import com.dubilowicz.elista.data.ob.PlansDiaryOb;
import com.dubilowicz.elista.data.repository.IPlansDiaryRepository;
import com.dubilowicz.elista.services.ISimpleService;
import com.dubilowicz.elista.utils.converters.PlansDiaryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by RaikPraca on 2016-03-23.
 */
@Service
@Transactional
public class PlansDiaryServiceImpl implements ISimpleService<PlansDiaryDto,Long> {

    @Autowired
    private IPlansDiaryRepository _db;

    private PlansDiaryConverter _cnv = new PlansDiaryConverter();

    @Override
    public PlansDiaryDto saveEntity(PlansDiaryDto entityDto) {
        if(entityDto==null)return null;
        if(entityDto.GetId()==null){
            return _cnv.ConvertToDto(_db.save((_cnv.ConvertToOb(entityDto))));
        }
        PlansDiaryOb ob = _db.findOne(entityDto.GetId());
        ob.SetBeginDate(entityDto.GetBeginDate());
        ob.SetDay(entityDto.GetDay());
        ob.SetEndDate(entityDto.GetEndDate());
        ob.SetUser(entityDto.GetUser());
        return _cnv.ConvertToDto(ob);
    }

    @Override
    public void deleteEntity(Long aId) {
        _db.delete(aId);
    }

    @Override
    public List<PlansDiaryDto> getAll() {
       return _db.findAll().stream().map(x->_cnv.ConvertToDto(x)).collect(Collectors.toList());
    }
}
