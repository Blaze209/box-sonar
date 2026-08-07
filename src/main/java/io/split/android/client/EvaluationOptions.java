package io.split.android.client;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class EvaluationOptions {
    private final Map<String, Object> mProperties;

    public EvaluationOptions(Map<String, Object> properties) {
        this.mProperties = properties != null ? new HashMap(properties) : null;
    }

    public Map<String, Object> getProperties() {
        if (this.mProperties != null) {
            return new HashMap(this.mProperties);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EvaluationOptions)) {
            return false;
        }
        EvaluationOptions evaluationOptions = (EvaluationOptions) obj;
        Map<String, Object> map = this.mProperties;
        if (map == null) {
            return evaluationOptions.mProperties == null;
        }
        return map.equals(evaluationOptions.mProperties);
    }

    public int hashCode() {
        Map<String, Object> map = this.mProperties;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }
}
