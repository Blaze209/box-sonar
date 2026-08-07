package io.split.android.engine.experiments;

import io.split.android.client.dtos.ExcludedSegment;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class ParsedRuleBasedSegment {
    private final long mChangeNumber;
    private final Set<String> mExcludedKeys;
    private final Set<ExcludedSegment> mExcludedSegments;
    private final String mName;
    private final List<ParsedCondition> mParsedConditions;
    private final String mTrafficTypeName;

    public ParsedRuleBasedSegment(String name, Set<String> excludedKeys, Set<ExcludedSegment> excludedSegments, List<ParsedCondition> parsedConditions, String trafficTypeName, long changeNumber) {
        this.mName = name;
        this.mExcludedKeys = excludedKeys == null ? new HashSet<>() : excludedKeys;
        this.mExcludedSegments = excludedSegments == null ? new HashSet<>() : excludedSegments;
        this.mParsedConditions = parsedConditions;
        this.mTrafficTypeName = trafficTypeName;
        this.mChangeNumber = changeNumber;
    }

    public String getName() {
        return this.mName;
    }

    public Set<String> getExcludedKeys() {
        return this.mExcludedKeys;
    }

    public Set<ExcludedSegment> getExcludedSegments() {
        return this.mExcludedSegments;
    }

    public List<ParsedCondition> getParsedConditions() {
        return this.mParsedConditions;
    }

    public String getTrafficTypeName() {
        return this.mTrafficTypeName;
    }

    public long getChangeNumber() {
        return this.mChangeNumber;
    }
}
