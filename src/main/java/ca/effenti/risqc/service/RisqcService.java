package ca.effenti.risqc.service;

import ca.effenti.risqc.core.RiskEvaluatorEngine;
import ca.effenti.risqc.model.Casern;
import ca.effenti.risqc.model.FountainBorn;
import ca.effenti.risqc.model.ZoneRisqc;
import ca.effenti.risqc.repository.BornRepository;
import ca.effenti.risqc.repository.CasernRepository;
import ca.effenti.risqc.repository.ZoneRisqcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RisqcService {

    @Autowired
    private BornRepository bornRepository;

    @Autowired
    private ZoneRisqcRepository zoneRisqcRepository;

    @Autowired
    private CasernRepository casernRepository;

    @Autowired
    private RiskEvaluatorEngine riskEvaluatorEngine;

    public RisqcResponse computeRisksFrom(final Double longitude, final Double latitude) {
        RisqcResponse risk = new RisqcResponse();
        List<FountainBorn> borns = bornRepository.findClosestFountainBorns(longitude, latitude);
        List<ZoneRisqc> zones = zoneRisqcRepository.findClosestZones(longitude,latitude);
        List<Casern> caserns = casernRepository.findClosestCasern(longitude, latitude);
        Float riskScore = riskEvaluatorEngine.computeLocationRiskScore(zones, borns, caserns);
        risk.setBorns(borns);
        risk.setZones(zones);
        risk.setCaserns(caserns);
        risk.setRiskScore(riskScore);
        return risk;
    }
}
