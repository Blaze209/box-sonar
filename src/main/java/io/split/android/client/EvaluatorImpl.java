package io.split.android.client;

import io.split.android.client.dtos.ConditionType;
import io.split.android.client.exceptions.ChangeNumberExceptionWrapper;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.utils.logger.Logger;
import io.split.android.engine.experiments.ParsedCondition;
import io.split.android.engine.experiments.ParsedSplit;
import io.split.android.engine.experiments.SplitParser;
import io.split.android.engine.matchers.PrerequisitesMatcher;
import io.split.android.engine.splitter.Splitter;
import io.split.android.grammar.Treatments;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class EvaluatorImpl implements Evaluator {
    private final SplitParser mSplitParser;
    private final SplitsStorage mSplitsStorage;

    public EvaluatorImpl(SplitsStorage splitsStorage, SplitParser splitParser) {
        this.mSplitsStorage = splitsStorage;
        this.mSplitParser = splitParser;
    }

    @Override // io.split.android.client.Evaluator
    public EvaluationResult getTreatment(String matchingKey, String bucketingKey, String splitName, Map<String, Object> attributes) {
        try {
            ParsedSplit parsedSplit = this.mSplitParser.parse(this.mSplitsStorage.get(splitName), matchingKey);
            if (parsedSplit == null) {
                return new EvaluationResult(Treatments.CONTROL, TreatmentLabels.DEFINITION_NOT_FOUND, true);
            }
            return getTreatment(matchingKey, bucketingKey, parsedSplit, attributes);
        } catch (ChangeNumberExceptionWrapper e) {
            Logger.e(e, "Catch Change Number Exception", new Object[0]);
            return new EvaluationResult(Treatments.CONTROL, "exception", Long.valueOf(e.changeNumber()), true);
        } catch (Exception e2) {
            Logger.e(e2, "Catch All Exception", new Object[0]);
            return new EvaluationResult(Treatments.CONTROL, "exception", true);
        }
    }

    private EvaluationResult getTreatment(String matchingKey, String bucketingKey, ParsedSplit parsedSplit, Map<String, Object> attributes) throws ChangeNumberExceptionWrapper {
        try {
            if (parsedSplit.killed()) {
                return new EvaluationResult(parsedSplit.defaultTreatment(), TreatmentLabels.KILLED, Long.valueOf(parsedSplit.changeNumber()), configForTreatment(parsedSplit, parsedSplit.defaultTreatment()), parsedSplit.impressionsDisabled());
            }
            if (!parsedSplit.prerequisites().isEmpty() && !new PrerequisitesMatcher(parsedSplit.prerequisites()).match(matchingKey, bucketingKey, attributes, this)) {
                return new EvaluationResult(parsedSplit.defaultTreatment(), TreatmentLabels.PREREQUISITES_NOT_MET, Long.valueOf(parsedSplit.changeNumber()), configForTreatment(parsedSplit, parsedSplit.defaultTreatment()), parsedSplit.impressionsDisabled());
            }
            String str = bucketingKey == null ? matchingKey : bucketingKey;
            boolean z = false;
            for (ParsedCondition parsedCondition : parsedSplit.parsedConditions()) {
                if (!z && parsedCondition.conditionType() == ConditionType.ROLLOUT) {
                    if (parsedSplit.trafficAllocation() < 100 && Splitter.getBucket(str, parsedSplit.trafficAllocationSeed(), parsedSplit.algo()) > parsedSplit.trafficAllocation()) {
                        return new EvaluationResult(parsedSplit.defaultTreatment(), TreatmentLabels.NOT_IN_SPLIT, Long.valueOf(parsedSplit.changeNumber()), configForTreatment(parsedSplit, parsedSplit.defaultTreatment()), parsedSplit.impressionsDisabled());
                    }
                    z = true;
                }
                if (parsedCondition.matcher().match(matchingKey, bucketingKey, attributes, this)) {
                    String treatment = Splitter.getTreatment(str, parsedSplit.seed(), parsedCondition.partitions(), parsedSplit.algo());
                    return new EvaluationResult(treatment, parsedCondition.label(), Long.valueOf(parsedSplit.changeNumber()), configForTreatment(parsedSplit, treatment), parsedSplit.impressionsDisabled());
                }
            }
            return new EvaluationResult(parsedSplit.defaultTreatment(), TreatmentLabels.DEFAULT_RULE, Long.valueOf(parsedSplit.changeNumber()), configForTreatment(parsedSplit, parsedSplit.defaultTreatment()), parsedSplit.impressionsDisabled());
        } catch (Exception e) {
            throw new ChangeNumberExceptionWrapper(e, parsedSplit.changeNumber());
        }
    }

    private String configForTreatment(ParsedSplit split, String treatment) {
        if (split.configurations() != null) {
            return split.configurations().get(treatment);
        }
        return null;
    }
}
