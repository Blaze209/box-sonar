package io.split.android.engine.matchers.collections;

import io.split.android.client.Evaluator;
import io.split.android.engine.matchers.Matcher;
import io.split.android.engine.matchers.Transformers;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class ContainsAnyOfSetMatcher implements Matcher {
    private final Set<String> _compareTo;

    public ContainsAnyOfSetMatcher(Collection<String> compareTo) {
        HashSet hashSet = new HashSet();
        this._compareTo = hashSet;
        if (compareTo == null) {
            throw new IllegalArgumentException("Null whitelist");
        }
        hashSet.addAll(compareTo);
    }

    @Override // io.split.android.engine.matchers.Matcher
    public boolean match(Object matchValue, String bucketingKey, Map<String, Object> attributes, Evaluator evaluator) {
        if (matchValue == null || !(matchValue instanceof Collection)) {
            return false;
        }
        Set<String> setOfStrings = Transformers.toSetOfStrings((Collection) matchValue);
        Iterator<String> it = this._compareTo.iterator();
        while (it.hasNext()) {
            if (setOfStrings.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "contains any of " + this._compareTo;
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
        if (obj instanceof ContainsAnyOfSetMatcher) {
            return this._compareTo.equals(((ContainsAnyOfSetMatcher) obj)._compareTo);
        }
        return false;
    }
}
