package io.split.android.engine.matchers.strings;

import io.split.android.client.Evaluator;
import io.split.android.engine.matchers.Matcher;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class RegularExpressionMatcher implements Matcher {
    private Pattern _pattern;
    private String _stringMatcher;

    public RegularExpressionMatcher(String matcherValue) {
        this._stringMatcher = matcherValue;
        this._pattern = Pattern.compile(matcherValue);
    }

    @Override // io.split.android.engine.matchers.Matcher
    public boolean match(Object matchValue, String bucketingKey, Map<String, Object> attributes, Evaluator evaluator) {
        if (matchValue != null && (matchValue instanceof String)) {
            return this._pattern.matcher((String) matchValue).find();
        }
        return false;
    }

    public String toString() {
        return "matches " + this._stringMatcher;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && getClass() == o.getClass()) {
            RegularExpressionMatcher regularExpressionMatcher = (RegularExpressionMatcher) o;
            String str = this._stringMatcher;
            if (str != null) {
                return str.equals(regularExpressionMatcher._stringMatcher);
            }
            if (regularExpressionMatcher._stringMatcher == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this._stringMatcher;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
