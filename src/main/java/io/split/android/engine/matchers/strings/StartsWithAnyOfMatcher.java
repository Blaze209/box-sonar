package io.split.android.engine.matchers.strings;

import io.split.android.client.Evaluator;
import io.split.android.engine.matchers.Matcher;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class StartsWithAnyOfMatcher implements Matcher {
    private final Set<String> _compareTo;

    public StartsWithAnyOfMatcher(Collection<String> compareTo) {
        HashSet hashSet = new HashSet();
        this._compareTo = hashSet;
        if (compareTo == null) {
            throw new IllegalArgumentException("Null whitelist");
        }
        hashSet.addAll(compareTo);
    }

    @Override // io.split.android.engine.matchers.Matcher
    public boolean match(Object matchValue, String bucketingKey, Map<String, Object> attributes, Evaluator evaluator) {
        if (matchValue == null || !(matchValue instanceof String) || this._compareTo.isEmpty()) {
            return false;
        }
        String str = (String) matchValue;
        for (String str2 : this._compareTo) {
            if (!str2.isEmpty() && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "starts with " + this._compareTo;
    }

    public int hashCode() {
        return 527 + this._compareTo.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof StartsWithAnyOfMatcher) {
            return this._compareTo.equals(((StartsWithAnyOfMatcher) obj)._compareTo);
        }
        return false;
    }
}
