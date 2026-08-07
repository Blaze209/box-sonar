package io.split.android.client;

import io.split.android.client.events.SplitEvent;
import io.split.android.client.events.SplitEventTask;
import io.split.android.grammar.Treatments;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class AlwaysReturnControlSplitClient implements SplitClient {
    @Override // io.split.android.client.attributes.AttributesManager
    public boolean clearAttributes() {
        return true;
    }

    @Override // io.split.android.client.SplitClient
    public void destroy() {
    }

    @Override // io.split.android.client.SplitClient
    public void flush() {
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public Object getAttribute(String attributeName) {
        return null;
    }

    @Override // io.split.android.client.SplitClient
    public boolean isReady() {
        return true;
    }

    @Override // io.split.android.client.SplitClient
    public void on(SplitEvent event, SplitEventTask task) {
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public boolean removeAttribute(String attributeName) {
        return true;
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public boolean setAttribute(String attributeName, Object value) {
        return true;
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public boolean setAttributes(Map<String, Object> attributes) {
        return true;
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String eventType) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String eventType, double value) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String eventType, double value, Map<String, Object> properties) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String trafficType, String eventType) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String trafficType, String eventType, double value) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String trafficType, String eventType, double value, Map<String, Object> properties) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String trafficType, String eventType, Map<String, Object> properties) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String eventType, Map<String, Object> properties) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public String getTreatment(String featureFlagName) {
        return Treatments.CONTROL;
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, String> getTreatments(List<String> featureFlagNames, Map<String, Object> attributes) {
        HashMap map = new HashMap();
        if (featureFlagNames != null) {
            Iterator<String> it = featureFlagNames.iterator();
            while (it.hasNext()) {
                map.put(it.next(), Treatments.CONTROL);
            }
        }
        return map;
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, String> getTreatments(List<String> featureFlagNames, Map<String, Object> attributes, EvaluationOptions evaluationOptions) {
        return Collections.emptyMap();
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, SplitResult> getTreatmentsWithConfig(List<String> featureFlagNames, Map<String, Object> attributes) {
        HashMap map = new HashMap();
        if (featureFlagNames != null) {
            Iterator<String> it = featureFlagNames.iterator();
            while (it.hasNext()) {
                map.put(it.next(), new SplitResult(Treatments.CONTROL));
            }
        }
        return map;
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, SplitResult> getTreatmentsWithConfig(List<String> featureFlagNames, Map<String, Object> attributes, EvaluationOptions evaluationOptions) {
        return Collections.emptyMap();
    }

    @Override // io.split.android.client.SplitClient
    public String getTreatment(String featureFlagName, Map<String, Object> attributes) {
        return Treatments.CONTROL;
    }

    @Override // io.split.android.client.SplitClient
    public String getTreatment(String featureFlagName, Map<String, Object> attributes, EvaluationOptions evaluationOptions) {
        return getTreatment(featureFlagName, attributes);
    }

    @Override // io.split.android.client.SplitClient
    public SplitResult getTreatmentWithConfig(String featureFlagName, Map<String, Object> attributes) {
        return new SplitResult(Treatments.CONTROL);
    }

    @Override // io.split.android.client.SplitClient
    public SplitResult getTreatmentWithConfig(String featureFlagName, Map<String, Object> attributes, EvaluationOptions evaluationOptions) {
        return getTreatmentWithConfig(featureFlagName, attributes);
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, String> getTreatmentsByFlagSet(String flagSet, Map<String, Object> attributes) {
        return Collections.emptyMap();
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, String> getTreatmentsByFlagSet(String flagSet, Map<String, Object> attributes, EvaluationOptions evaluationOptions) {
        return Collections.emptyMap();
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, String> getTreatmentsByFlagSets(List<String> flagSets, Map<String, Object> attributes) {
        return Collections.emptyMap();
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, String> getTreatmentsByFlagSets(List<String> flagSets, Map<String, Object> attributes, EvaluationOptions evaluationOptions) {
        return getTreatmentsByFlagSets(flagSets, attributes);
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, SplitResult> getTreatmentsWithConfigByFlagSet(String flagSet, Map<String, Object> attributes) {
        return Collections.emptyMap();
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, SplitResult> getTreatmentsWithConfigByFlagSet(String flagSet, Map<String, Object> attributes, EvaluationOptions evaluationOptions) {
        return getTreatmentsWithConfigByFlagSet(flagSet, attributes);
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, SplitResult> getTreatmentsWithConfigByFlagSets(List<String> flagSets, Map<String, Object> attributes) {
        return Collections.emptyMap();
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, SplitResult> getTreatmentsWithConfigByFlagSets(List<String> flagSets, Map<String, Object> attributes, EvaluationOptions evaluationOptions) {
        return getTreatmentsWithConfigByFlagSets(flagSets, attributes);
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public Map<String, Object> getAllAttributes() {
        return new HashMap();
    }
}
