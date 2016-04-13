package com.dubilowicz.elista.services.impl;

import com.dubilowicz.elista.core.dto.WorkTimeDto;
import com.dubilowicz.elista.data.ob.WorkTimeOb;
import com.dubilowicz.elista.data.repository.IWorkTimeRepository;
import com.dubilowicz.elista.services.ISimpleService;
import com.dubilowicz.elista.utils.converters.WorkTimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by RaikPraca on 2016-03-22.
 */
@Service
@Transactional
public class WorkTimeServiceImpl implements ISimpleService<WorkTimeDto,Long> {
    @Autowired
    IWorkTimeRepository iWorkTimeRepository;

    private WorkTimeConverter cnv = new WorkTimeConverter();

    @Override
    public WorkTimeDto saveEntity(WorkTimeDto entityDto) {
        if(entityDto==null)return null;
        if(entityDto.Id()==null){
            return cnv.ConvertToDto(iWorkTimeRepository.save((cnv.ConvertToOb(entityDto))));
        }
        WorkTimeOb ob = iWorkTimeRepository.findOne(entityDto.Id());
        ob.UpdateDay(entityDto.Day());
        ob.UpdateEnd(entityDto.End());
        ob.UpdateJobInfo(entityDto.JobInfo());
        ob.UpdateStart(entityDto.Start());
        ob.UpdateUser(entityDto.User());
        return cnv.ConvertToDto(ob);
    }

    @Override
    public void deleteEntity(Long aId) {
        iWorkTimeRepository.delete(aId);
    }

    @Override
    public List<WorkTimeDto> getAll() {
        //Jupiii lambda jak w c# dla kolekcji :)
        return iWorkTimeRepository.findAll().stream().map(x->cnv.ConvertToDto(x)).collect(Collectors.toList());
    }
}
