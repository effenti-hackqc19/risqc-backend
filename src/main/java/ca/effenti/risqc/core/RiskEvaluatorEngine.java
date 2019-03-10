package ca.effenti.risqc.core;

import ca.effenti.risqc.model.Casern;
import ca.effenti.risqc.model.FountainBorn;
import ca.effenti.risqc.model.ZoneRisqc;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RiskEvaluatorEngine {
    private static final Long FLOOD_ZONE_SCORE = 70L;
    private static final Long FOUNTAIN_BORN_SCORE = 10L;
    private static final Long CASERN_POSITION_SCORE = 20L;

    public Float computeLocationRiskScore (List<ZoneRisqc> zonesOrderedByDist, List<FountainBorn> foundtainBornsByDist, List<Casern> caserns) {
        RiskEvaluator floodRiskEvaluator = new FloodZonesRiskEvaluator(zonesOrderedByDist.get(0), FLOOD_ZONE_SCORE);
        RiskEvaluator fountainEvaluator = new FountainBornRiskEvaluator(foundtainBornsByDist.get(0), FOUNTAIN_BORN_SCORE);
        CasernRiskEvaluator casernRiskEvaluator = new CasernRiskEvaluator(caserns.get(0), CASERN_POSITION_SCORE);
        Float floodRisk = floodRiskEvaluator.computeRisk();
        Float bornRisk = fountainEvaluator.computeRisk();
        Float casernRisk = casernRiskEvaluator.computeRisk();
        System.out.println("Born risk: " + bornRisk + " flood risk: " + floodRisk + " casern risk :" + casernRisk);
        return (floodRisk + bornRisk + casernRisk) /(FLOOD_ZONE_SCORE+FOUNTAIN_BORN_SCORE +CASERN_POSITION_SCORE);
    }
}
