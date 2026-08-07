package io.split.android.engine.matchers;

import io.split.android.client.Evaluator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class DependencyMatcher implements Matcher {
    private String _split;
    private List<String> _treatments;

    public DependencyMatcher(String split, List<String> treatments) {
        this._split = split;
        this._treatments = treatments;
    }

    @Override // io.split.android.engine.matchers.Matcher
    public boolean match(Object matchValue, String bucketingKey, Map<String, Object> attributes, Evaluator evaluator) {
        if (matchValue == null || !(matchValue instanceof String)) {
            return false;
        }
        return this._treatments.contains(evaluator.getTreatment((String) matchValue, bucketingKey, this._split, attributes).getTreatment());
    }

    public String toString() {
        return "in split \"" + this._split + "\" treatment " + this._treatments;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && getClass() == o.getClass()) {
            DependencyMatcher dependencyMatcher = (DependencyMatcher) o;
            String str = this._split;
            if (str == null ? dependencyMatcher._split != null : !str.equals(dependencyMatcher._split)) {
                return false;
            }
            List<String> list = this._treatments;
            if (list != null) {
                return list.equals(dependencyMatcher._treatments);
            }
            if (dependencyMatcher._treatments == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this._split;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this._treatments;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }
}
