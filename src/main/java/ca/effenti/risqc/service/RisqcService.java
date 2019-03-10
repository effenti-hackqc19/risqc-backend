package ca.effenti.risqc.service;

import ca.effenti.risqc.model.FountainBorn;
import ca.effenti.risqc.repository.BornRepository;
import ca.effenti.risqc.repository.ZoneRisqcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RisqcService {

    @Autowired
    private BornRepository bornRepository;

    private ZoneRisqcRepository zoneRisqcRepository;

    public RisqcResponse computeRisksFrom(final Double longitude, final Double latitude) {
        RisqcResponse risk = new RisqcResponse();
        List<FountainBorn> borns = bornRepository.findClosestFountainBorns(longitude, latitude);
        risk.setBorns(borns);
        risk.setZones(zoneRisqcRepository.findClosestZones(longitude,latitude));
        return risk;
    }
}
