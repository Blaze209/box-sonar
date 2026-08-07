package org.yaml.snakeyaml.resolver;

import java.util.regex.Pattern;
import org.yaml.snakeyaml.nodes.Tag;

/* JADX INFO: loaded from: classes5.dex */
final class ResolverTuple {
    private final int limit;
    private final Pattern regexp;
    private final Tag tag;

    public ResolverTuple(Tag tag, Pattern pattern, int i) {
        this.tag = tag;
        this.regexp = pattern;
        this.limit = i;
    }

    public Tag getTag() {
        return this.tag;
    }

    public Pattern getRegexp() {
        return this.regexp;
    }

    public int getLimit() {
        return this.limit;
    }

    public String toString() {
        return "Tuple tag=" + this.tag + " regexp=" + this.regexp + " limit=" + this.limit;
    }
}
