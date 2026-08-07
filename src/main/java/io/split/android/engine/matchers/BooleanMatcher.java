package io.split.android.engine.matchers;

import io.split.android.client.Evaluator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class BooleanMatcher implements Matcher {
    private boolean _booleanValue;

    public BooleanMatcher(boolean booleanValue) {
        this._booleanValue = booleanValue;
    }

    @Override // io.split.android.engine.matchers.Matcher
    public boolean match(Object matchValue, String bucketingKey, Map<String, Object> attributes, Evaluator evaluator) {
        Boolean boolAsBoolean;
        return (matchValue == null || (boolAsBoolean = Transformers.asBoolean(matchValue)) == null || boolAsBoolean.booleanValue() != this._booleanValue) ? false : true;
    }

    public String toString() {
        return "is " + this._booleanValue;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return o != null && getClass() == o.getClass() && this._booleanValue == ((BooleanMatcher) o)._booleanValue;
    }

    public int hashCode() {
        return this._booleanValue ? 1 : 0;
    }
}
