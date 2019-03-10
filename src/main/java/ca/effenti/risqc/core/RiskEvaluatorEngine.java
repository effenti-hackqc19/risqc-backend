package ca.effenti.risqc.core;

import ca.effenti.risqc.model.Casern;
import ca.effenti.risqc.model.FountainBorn;
import ca.effenti.risqc.model.ZoneRisqc;
import ca.effenti.risqc.service.RisqcResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RiskEvaluatorEngine {
    private static final Long FLOOD_ZONE_SCORE = 70L;
    private static final Long FOUNTAIN_BORN_SCORE = 10L;
    private static final Long CASERN_POSITION_SCORE = 20L;

    public RisqcResponse computeLocationRiskScore (List<ZoneRisqc> zonesOrderedByDist, List<FountainBorn> foundtainBornsByDist, List<Casern> caserns) {
        RiskEvaluator floodRiskEvaluator = new FloodZonesRiskEvaluator(zonesOrderedByDist.get(0), FLOOD_ZONE_SCORE);
        RiskEvaluator fountainEvaluator = new FountainBornRiskEvaluator(foundtainBornsByDist.get(0), FOUNTAIN_BORN_SCORE);
        CasernRiskEvaluator casernRiskEvaluator = new CasernRiskEvaluator(caserns.get(0), CASERN_POSITION_SCORE);
        RiskMeaning floodRisk = floodRiskEvaluator.computeRisk();
        RiskMeaning bornRisk = fountainEvaluator.computeRisk();
        RiskMeaning casernRisk = casernRiskEvaluator.computeRisk();
        System.out.println("Born risk: " + bornRisk + " flood risk: " + floodRisk + " casern risk :" + casernRisk);
        Float totalRisk = (floodRisk.value + bornRisk.value + casernRisk.value) /(FLOOD_ZONE_SCORE+FOUNTAIN_BORN_SCORE +CASERN_POSITION_SCORE);

        RiskDetails riskDetails = new RiskDetails();
        riskDetails.setBornRisks(bornRisk);
        riskDetails.setCasernRisk(casernRisk);
        riskDetails.setFloodRisks(floodRisk);

        RisqcResponse resp = new RisqcResponse();
        resp.setRiskDetails(riskDetails);
        resp.setRiskScore(totalRisk);

        return resp;
    }
}
