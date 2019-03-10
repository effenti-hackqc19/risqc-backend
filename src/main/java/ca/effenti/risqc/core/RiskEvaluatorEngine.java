package ca.effenti.risqc.core;

import ca.effenti.risqc.model.FountainBorn;
import ca.effenti.risqc.model.ZoneRisqc;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RiskEvaluatorEngine {
    private static final Long FLOOD_ZONE_SCORE = 80L;
    private static final Long FOUNTAIN_BORN_SCORE = 20L;

    public Float computeLocationRiskScore (List<ZoneRisqc> zonesOrderedByDist, List<FountainBorn> foundtainBornsByDist) {
        RiskEvaluator floodRiskEvaluator = new FloodZonesRiskEvaluator(zonesOrderedByDist.get(0), FLOOD_ZONE_SCORE);
        RiskEvaluator fountainEvaluator = new FountainBornRiskEvaluator(foundtainBornsByDist.get(0), FOUNTAIN_BORN_SCORE);
        Float floodRisk = floodRiskEvaluator.computeRisk();
        Float bornRisk = fountainEvaluator.computeRisk();
        System.out.println("Born risk: " + bornRisk + " flood risk: " + floodRisk);
        return (floodRisk + bornRisk) /(FLOOD_ZONE_SCORE+FOUNTAIN_BORN_SCORE);
    }
}
