package io.split.android.engine.matchers;

import io.split.android.client.Evaluator;
import io.split.android.client.dtos.MatcherCombiner;
import io.split.android.client.utils.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class CombiningMatcher {
    private final MatcherCombiner _combiner;
    private final List<AttributeMatcher> _delegates;

    public static CombiningMatcher of(Matcher matcher) {
        return new CombiningMatcher(MatcherCombiner.AND, Collections.singletonList(AttributeMatcher.vanilla(matcher)));
    }

    public static CombiningMatcher of(String attribute, Matcher matcher) {
        return new CombiningMatcher(MatcherCombiner.AND, Collections.singletonList(new AttributeMatcher(attribute, matcher, false)));
    }

    public CombiningMatcher(MatcherCombiner combiner, List<AttributeMatcher> delegates) {
        List<AttributeMatcher> listUnmodifiableList = Collections.unmodifiableList(new ArrayList(delegates));
        this._delegates = listUnmodifiableList;
        this._combiner = combiner;
        Utils.checkArgument(listUnmodifiableList.size() > 0);
    }

    public boolean match(String key, String bucketingKey, Map<String, Object> attributes, Evaluator evaluator) {
        if (this._delegates.isEmpty()) {
            return false;
        }
        if (this._combiner == MatcherCombiner.AND) {
            return and(key, bucketingKey, attributes, evaluator);
        }
        throw new IllegalArgumentException("Unknown combiner: " + this._combiner);
    }

    private boolean and(String key, String bucketingKey, Map<String, Object> attributes, Evaluator evaluator) {
        Iterator<AttributeMatcher> it = this._delegates.iterator();
        boolean zMatch = true;
        while (it.hasNext()) {
            zMatch &= it.next().match(key, bucketingKey, attributes, evaluator);
        }
        return zMatch;
    }

    public List<AttributeMatcher> attributeMatchers() {
        return this._delegates;
    }

    public int hashCode() {
        return (this._delegates.hashCode() * 31) + this._combiner.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("if");
        boolean z = true;
        for (AttributeMatcher attributeMatcher : this._delegates) {
            if (!z) {
                sb.append(" ").append(this._combiner);
            }
            sb.append(" ");
            sb.append(attributeMatcher);
            z = false;
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CombiningMatcher)) {
            return false;
        }
        CombiningMatcher combiningMatcher = (CombiningMatcher) obj;
        return this._combiner.equals(combiningMatcher._combiner) && this._delegates.equals(combiningMatcher._delegates);
    }
}
