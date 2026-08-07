package io.split.android.engine.matchers;

import io.split.android.client.EvaluationResult;
import io.split.android.client.Evaluator;
import io.split.android.client.dtos.Prerequisite;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class PrerequisitesMatcher implements Matcher {
    private final List<Prerequisite> mPrerequisites;

    public PrerequisitesMatcher(List<Prerequisite> prerequisites) {
        this.mPrerequisites = prerequisites == null ? new ArrayList<>() : prerequisites;
    }

    @Override // io.split.android.engine.matchers.Matcher
    public boolean match(Object matchValue, String bucketingKey, Map<String, Object> attributes, Evaluator evaluator) {
        if (!(matchValue instanceof String)) {
            return false;
        }
        for (Prerequisite prerequisite : this.mPrerequisites) {
            EvaluationResult treatment = evaluator.getTreatment((String) matchValue, bucketingKey, prerequisite.getFlagName(), attributes);
            if (treatment == null || !prerequisite.getTreatments().contains(treatment.getTreatment())) {
                return false;
            }
        }
        return true;
    }
}
