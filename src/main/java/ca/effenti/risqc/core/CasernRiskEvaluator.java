package ca.effenti.risqc.core;

import ca.effenti.risqc.model.Casern;
import ca.effenti.risqc.model.FountainBorn;

public class CasernRiskEvaluator implements RiskEvaluator {
    private static final Float MAX_DISTANCE_TO_CONSIDER = 4F;

    private final Casern closestCasern;
    private final Long score;

    CasernRiskEvaluator(Casern casern, Long score) {
        this.closestCasern = casern;
        this.score = score;
    }


    @Override
    public RiskMeaning computeRisk() {
        Float closestDistance = closestCasern.getDistance();
        if (closestDistance == 0) {
            Float riskValue =  MIN_RISK*score/100;
            String message = "Vous êtes à une bonne distance d'une caserne de pompiers";
            return  new RiskMeaning(message, riskValue);
        }
        if (closestDistance >= MAX_DISTANCE_TO_CONSIDER) {
            Float riskValue =   MAX_RISK * score/100;
            String message = "Vous êtes loin d'une caserne de pompiers";
            return  new RiskMeaning(message, riskValue);
        }
        Float riskValue =  score * getRiskFactor();
        String message = "Vous êtes à "+ closestDistance + " Km d'une caserne de pompiers";
        return  new RiskMeaning(message, riskValue);
    }

    private Float getRiskFactor() {
        return  closestCasern.getDistance() / MAX_DISTANCE_TO_CONSIDER;
    }
}
