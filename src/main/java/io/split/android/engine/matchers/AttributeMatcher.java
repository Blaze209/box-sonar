package io.split.android.engine.matchers;

import io.split.android.client.Evaluator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class AttributeMatcher {
    private final String _attribute;
    private final Matcher _matcher;

    public static AttributeMatcher vanilla(Matcher matcher) {
        return new AttributeMatcher(null, matcher, false);
    }

    public AttributeMatcher(String attribute, Matcher matcher, boolean negate) {
        this._attribute = attribute;
        if (matcher == null) {
            throw new IllegalArgumentException("Null matcher");
        }
        this._matcher = new NegatableMatcher(matcher, negate);
    }

    public boolean match(String key, String bucketingKey, Map<String, Object> attributes, Evaluator evaluator) {
        Object obj;
        String str = this._attribute;
        if (str == null) {
            return this._matcher.match(key, bucketingKey, attributes, evaluator);
        }
        if (attributes == null || (obj = attributes.get(str)) == null) {
            return false;
        }
        return this._matcher.match(obj, bucketingKey, null, null);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AttributeMatcher attributeMatcher = (AttributeMatcher) o;
        String str = this._attribute;
        if (str == null ? attributeMatcher._attribute == null : str.equals(attributeMatcher._attribute)) {
            return this._matcher.equals(attributeMatcher._matcher);
        }
        return false;
    }

    public int hashCode() {
        String str = this._attribute;
        return ((str != null ? str.hashCode() : 0) * 31) + this._matcher.hashCode();
    }

    public String attribute() {
        return this._attribute;
    }

    public Matcher matcher() {
        return this._matcher;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("key");
        if (this._attribute != null) {
            sb.append(".");
            sb.append(this._attribute);
        }
        sb.append(" is");
        sb.append(this._matcher);
        return sb.toString();
    }

    public static final class NegatableMatcher implements Matcher {
        private final Matcher _delegate;
        private final boolean _negate;

        public NegatableMatcher(Matcher matcher, boolean negate) {
            this._negate = negate;
            this._delegate = matcher;
        }

        @Override // io.split.android.engine.matchers.Matcher
        public boolean match(Object matchValue, String bucketingKey, Map<String, Object> attributes, Evaluator evaluator) {
            return this._negate != this._delegate.match(matchValue, bucketingKey, attributes, evaluator);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this._negate) {
                sb.append(" not");
            }
            sb.append(" ");
            sb.append(this._delegate);
            return sb.toString();
        }

        public Matcher delegate() {
            return this._delegate;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            NegatableMatcher negatableMatcher = (NegatableMatcher) o;
            if (this._negate != negatableMatcher._negate) {
                return false;
            }
            return this._delegate.equals(negatableMatcher._delegate);
        }

        public int hashCode() {
            return ((this._negate ? 1 : 0) * 31) + this._delegate.hashCode();
        }
    }
}
