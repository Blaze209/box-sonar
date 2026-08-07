package io.split.android.engine.matchers.strings;

import io.split.android.client.Evaluator;
import io.split.android.engine.matchers.Matcher;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public class WhitelistMatcher implements Matcher {
    private final Set<String> _whitelist;

    public WhitelistMatcher(Collection<String> whitelist) {
        HashSet hashSet = new HashSet();
        this._whitelist = hashSet;
        if (whitelist == null) {
            throw new IllegalArgumentException("Null whitelist parameter");
        }
        hashSet.addAll(whitelist);
    }

    @Override // io.split.android.engine.matchers.Matcher
    public boolean match(Object matchValue, String bucketingKey, Map<String, Object> attributes, Evaluator evaluator) {
        return this._whitelist.contains(matchValue);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("in segment [");
        boolean z = true;
        for (String str : this._whitelist) {
            if (!z) {
                sb.append(AbstractJsonLexerKt.COMMA);
            }
            sb.append('\"');
            sb.append(str);
            sb.append('\"');
            z = false;
        }
        sb.append("]");
        return sb.toString();
    }

    public int hashCode() {
        return 527 + this._whitelist.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof WhitelistMatcher) {
            return this._whitelist.equals(((WhitelistMatcher) obj)._whitelist);
        }
        return false;
    }
}
