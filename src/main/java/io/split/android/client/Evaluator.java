package io.split.android.client;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface Evaluator {
    EvaluationResult getTreatment(String matchingKey, String bucketingKey, String split, Map<String, Object> attributes);
}
