package io.split.android.client;

import io.split.android.client.attributes.AttributesManager;
import io.split.android.client.events.SplitEvent;
import io.split.android.client.events.SplitEventTask;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface SplitClient extends AttributesManager {
    void destroy();

    void flush();

    String getTreatment(String featureFlagName);

    String getTreatment(String featureFlagName, Map<String, Object> attributes);

    String getTreatment(String featureFlagName, Map<String, Object> attributes, EvaluationOptions evaluationOptions);

    SplitResult getTreatmentWithConfig(String featureFlagName, Map<String, Object> attributes);

    SplitResult getTreatmentWithConfig(String featureFlagName, Map<String, Object> attributes, EvaluationOptions evaluationOptions);

    Map<String, String> getTreatments(List<String> featureFlagNames, Map<String, Object> attributes);

    Map<String, String> getTreatments(List<String> featureFlagNames, Map<String, Object> attributes, EvaluationOptions evaluationOptions);

    Map<String, String> getTreatmentsByFlagSet(String flagSet, Map<String, Object> attributes);

    Map<String, String> getTreatmentsByFlagSet(String flagSet, Map<String, Object> attributes, EvaluationOptions evaluationOptions);

    Map<String, String> getTreatmentsByFlagSets(List<String> flagSets, Map<String, Object> attributes);

    Map<String, String> getTreatmentsByFlagSets(List<String> flagSets, Map<String, Object> attributes, EvaluationOptions evaluationOptions);

    Map<String, SplitResult> getTreatmentsWithConfig(List<String> featureFlagNames, Map<String, Object> attributes);

    Map<String, SplitResult> getTreatmentsWithConfig(List<String> featureFlagNames, Map<String, Object> attributes, EvaluationOptions evaluationOptions);

    Map<String, SplitResult> getTreatmentsWithConfigByFlagSet(String flagSet, Map<String, Object> attributes);

    Map<String, SplitResult> getTreatmentsWithConfigByFlagSet(String flagSet, Map<String, Object> attributes, EvaluationOptions evaluationOptions);

    Map<String, SplitResult> getTreatmentsWithConfigByFlagSets(List<String> flagSets, Map<String, Object> attributes);

    Map<String, SplitResult> getTreatmentsWithConfigByFlagSets(List<String> flagSets, Map<String, Object> attributes, EvaluationOptions evaluationOptions);

    boolean isReady();

    void on(SplitEvent event, SplitEventTask task);

    boolean track(String eventType);

    boolean track(String eventType, double value);

    boolean track(String eventType, double value, Map<String, Object> properties);

    boolean track(String trafficType, String eventType);

    boolean track(String trafficType, String eventType, double value);

    boolean track(String trafficType, String eventType, double value, Map<String, Object> properties);

    boolean track(String trafficType, String eventType, Map<String, Object> properties);

    boolean track(String eventType, Map<String, Object> properties);
}
