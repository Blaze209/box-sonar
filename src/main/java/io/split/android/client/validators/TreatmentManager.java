package io.split.android.client.validators;

import io.split.android.client.EvaluationOptions;
import io.split.android.client.SplitResult;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface TreatmentManager {
    String getTreatment(String split, Map<String, Object> attributes, EvaluationOptions evaluationOptions, boolean isClientDestroyed);

    SplitResult getTreatmentWithConfig(String split, Map<String, Object> attributes, EvaluationOptions evaluationOptions, boolean isClientDestroyed);

    Map<String, String> getTreatments(List<String> splits, Map<String, Object> attributes, EvaluationOptions evaluationOptions, boolean isClientDestroyed);

    Map<String, String> getTreatmentsByFlagSet(String flagSet, Map<String, Object> attributes, EvaluationOptions evaluationOptions, boolean isClientDestroyed);

    Map<String, String> getTreatmentsByFlagSets(List<String> flagSets, Map<String, Object> attributes, EvaluationOptions evaluationOptions, boolean isClientDestroyed);

    Map<String, SplitResult> getTreatmentsWithConfig(List<String> splits, Map<String, Object> attributes, EvaluationOptions evaluationOptions, boolean isClientDestroyed);

    Map<String, SplitResult> getTreatmentsWithConfigByFlagSet(String flagSet, Map<String, Object> attributes, EvaluationOptions evaluationOptions, boolean isClientDestroyed);

    Map<String, SplitResult> getTreatmentsWithConfigByFlagSets(List<String> flagSets, Map<String, Object> attributes, EvaluationOptions evaluationOptions, boolean isClientDestroyed);
}
