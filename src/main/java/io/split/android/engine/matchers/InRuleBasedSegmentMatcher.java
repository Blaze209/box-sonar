package io.split.android.engine.matchers;

import io.split.android.client.Evaluator;
import io.split.android.client.dtos.ExcludedSegment;
import io.split.android.client.storage.mysegments.MySegmentsStorage;
import io.split.android.client.storage.rbs.RuleBasedSegmentStorageConsumer;
import io.split.android.client.utils.Utils;
import io.split.android.engine.experiments.ParsedCondition;
import io.split.android.engine.experiments.ParsedRuleBasedSegment;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class InRuleBasedSegmentMatcher implements Matcher {
    private final MySegmentsStorage mMyLargeSegmentsStorage;
    private final MySegmentsStorage mMySegmentsStorage;
    private final RuleBasedSegmentStorageConsumer mRuleBasedSegmentStorage;
    private final String mSegmentName;

    public InRuleBasedSegmentMatcher(RuleBasedSegmentStorageConsumer ruleBasedSegmentStorage, MySegmentsStorage mySegmentsStorage, MySegmentsStorage myLargeSegmentsStorage, String segmentName) {
        this.mRuleBasedSegmentStorage = (RuleBasedSegmentStorageConsumer) Utils.checkNotNull(ruleBasedSegmentStorage);
        this.mMySegmentsStorage = (MySegmentsStorage) Utils.checkNotNull(mySegmentsStorage);
        this.mMyLargeSegmentsStorage = (MySegmentsStorage) Utils.checkNotNull(myLargeSegmentsStorage);
        this.mSegmentName = (String) Utils.checkNotNull(segmentName);
    }

    @Override // io.split.android.engine.matchers.Matcher
    public boolean match(Object matchValue, String bucketingKey, Map<String, Object> attributes, Evaluator evaluator) {
        String str;
        ParsedRuleBasedSegment parsedRuleBasedSegment;
        if (!(matchValue instanceof String) || (parsedRuleBasedSegment = this.mRuleBasedSegmentStorage.get(this.mSegmentName, (str = (String) matchValue))) == null || isKeyExcluded(parsedRuleBasedSegment, str) || inExcludedSegment(parsedRuleBasedSegment, str, bucketingKey, attributes, evaluator)) {
            return false;
        }
        return matchesConditions(bucketingKey, attributes, evaluator, parsedRuleBasedSegment, str);
    }

    private static boolean isKeyExcluded(ParsedRuleBasedSegment parsedRuleBasedSegment, String matchingKey) {
        return parsedRuleBasedSegment.getExcludedKeys().contains(matchingKey);
    }

    private boolean inExcludedSegment(ParsedRuleBasedSegment parsedRuleBasedSegment, Object matchingKey, String bucketingKey, Map<String, Object> attributes, Evaluator evaluator) {
        for (ExcludedSegment excludedSegment : parsedRuleBasedSegment.getExcludedSegments()) {
            if (excludedSegment.isStandard() && this.mMySegmentsStorage.getAll().contains(excludedSegment.getName())) {
                return true;
            }
            if (excludedSegment.isRuleBased() && new InRuleBasedSegmentMatcher(this.mRuleBasedSegmentStorage, this.mMySegmentsStorage, this.mMyLargeSegmentsStorage, excludedSegment.getName()).match(matchingKey, bucketingKey, attributes, evaluator)) {
                return true;
            }
            if (excludedSegment.isLarge() && this.mMyLargeSegmentsStorage.getAll().contains(excludedSegment.getName())) {
                return true;
            }
        }
        return false;
    }

    private static boolean matchesConditions(String bucketingKey, Map<String, Object> attributes, Evaluator evaluator, ParsedRuleBasedSegment parsedRuleBasedSegment, String matchingKey) {
        Iterator<ParsedCondition> it = parsedRuleBasedSegment.getParsedConditions().iterator();
        while (it.hasNext()) {
            if (it.next().matcher().match(matchingKey, bucketingKey, attributes, evaluator)) {
                return true;
            }
        }
        return false;
    }
}
