package ca.effenti.risqc.service;

import ca.effenti.risqc.repository.BornRepository;
import ca.effenti.risqc.repository.ZoneRisqcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RisqcService {

    @Autowired
    private BornRepository bornRepository;

    private ZoneRisqcRepository zoneRisqcRepository;
}
