package io.split.android.engine.matchers;

import io.split.android.client.Evaluator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class AllKeysMatcher implements Matcher {
    public int hashCode() {
        return 17;
    }

    @Override // io.split.android.engine.matchers.Matcher
    public boolean match(Object matchValue, String bucketingKey, Map<String, Object> attributes, Evaluator evaluator) {
        return matchValue != null;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj instanceof AllKeysMatcher;
    }

    public String toString() {
        return "in segment all";
    }
}
