package com.training.springcore.service;

import com.training.springcore.model.Captor;
import com.training.springcore.service.measure.FixedMeasureService;
import com.training.springcore.service.measure.MeasureService;
import com.training.springcore.service.measure.RealMeasureService;
import com.training.springcore.service.measure.SimulatedMeasureService;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Set;


public class CaptorServiceImplTest {
    private MeasureService realMeasureService = new RealMeasureService();
    private MeasureService simulatedService = new SimulatedMeasureService();
    private MeasureService fixedMeasureService = new FixedMeasureService();

        private CaptorServiceImpl captorService = new CaptorServiceImpl(realMeasureService,simulatedService,fixedMeasureService);

    @Test
    public void findBySiteShouldReturnNullWhenIdIsNull() {
        // Initialisation
        String siteId = null;

        // Appel du SUT
        Set<Captor> captors = captorService.findBySite(siteId);

        // Vérification
        Assertions.assertThat(captors).isEmpty();
    }

    @Test
    public void findBySite() {
        // Initialisation
        String siteId = "siteId";

        // Appel du SUT
        Set<Captor> captors = captorService.findBySite(siteId);

        // Vérification
        Assertions.assertThat(captors).hasSize(1);
        Assertions.assertThat(captors).extracting(Captor::getName).contains("Capteur A");
    }
}