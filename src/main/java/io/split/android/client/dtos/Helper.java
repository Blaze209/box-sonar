package io.split.android.client.dtos;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class Helper {
    public static Set<String> getReferencedRuleBasedSegments(List<Condition> conditions) {
        HashSet hashSet = new HashSet();
        if (conditions != null) {
            Iterator<Condition> it = conditions.iterator();
            while (it.hasNext()) {
                for (Matcher matcher : it.next().matcherGroup.matchers) {
                    if (matcher.matcherType == MatcherType.IN_RULE_BASED_SEGMENT) {
                        hashSet.add(matcher.userDefinedSegmentMatcherData.segmentName);
                    }
                }
            }
        }
        return hashSet;
    }
}
