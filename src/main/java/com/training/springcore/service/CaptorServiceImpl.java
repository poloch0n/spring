package com.training.springcore.service;

import com.training.springcore.annotation.Monitored;
import com.training.springcore.model.Captor;
import com.training.springcore.model.PowerSource;
import com.training.springcore.service.measure.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class CaptorServiceImpl implements CaptorService{

    PowerSource powerSource;
    MeasureService measureService;
    MeasureService measureService2;
    MeasureService measureService3;

    @Autowired
    public CaptorServiceImpl(MeasureService realMeasureService, MeasureService simulatedService, MeasureService fixedMeasureService){
        this.measureService = realMeasureService;
        this.measureService2 = simulatedService;
        this.measureService3 = fixedMeasureService;
    }

    @Monitored
    @Override
    public Set<Captor> findBySite(String siteId) {
        Set<Captor> captors = new HashSet<>();
        if (siteId == null) {
            return captors;
        }
        captors.add(new Captor("Capteur A"));
        return captors;
    }
}
