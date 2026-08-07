package io.split.android.engine.experiments;

import io.split.android.client.dtos.Condition;
import io.split.android.client.dtos.Matcher;
import io.split.android.client.dtos.MatcherGroup;
import io.split.android.client.dtos.MatcherType;
import io.split.android.client.dtos.Partition;
import io.split.android.client.storage.mysegments.EmptyMySegmentsStorage;
import io.split.android.client.storage.mysegments.MySegmentsStorageContainer;
import io.split.android.client.storage.rbs.RuleBasedSegmentStorageConsumer;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import io.split.android.engine.matchers.AllKeysMatcher;
import io.split.android.engine.matchers.AttributeMatcher;
import io.split.android.engine.matchers.BetweenMatcher;
import io.split.android.engine.matchers.BooleanMatcher;
import io.split.android.engine.matchers.CombiningMatcher;
import io.split.android.engine.matchers.DependencyMatcher;
import io.split.android.engine.matchers.EqualToMatcher;
import io.split.android.engine.matchers.GreaterThanOrEqualToMatcher;
import io.split.android.engine.matchers.InRuleBasedSegmentMatcher;
import io.split.android.engine.matchers.LessThanOrEqualToMatcher;
import io.split.android.engine.matchers.MySegmentsMatcher;
import io.split.android.engine.matchers.collections.ContainsAllOfSetMatcher;
import io.split.android.engine.matchers.collections.ContainsAnyOfSetMatcher;
import io.split.android.engine.matchers.collections.EqualToSetMatcher;
import io.split.android.engine.matchers.collections.PartOfSetMatcher;
import io.split.android.engine.matchers.semver.BetweenSemverMatcher;
import io.split.android.engine.matchers.semver.EqualToSemverMatcher;
import io.split.android.engine.matchers.semver.GreaterThanOrEqualToSemverMatcher;
import io.split.android.engine.matchers.semver.InListSemverMatcher;
import io.split.android.engine.matchers.semver.LessThanOrEqualToSemverMatcher;
import io.split.android.engine.matchers.strings.ContainsAnyOfMatcher;
import io.split.android.engine.matchers.strings.EndsWithAnyOfMatcher;
import io.split.android.engine.matchers.strings.RegularExpressionMatcher;
import io.split.android.engine.matchers.strings.StartsWithAnyOfMatcher;
import io.split.android.engine.matchers.strings.WhitelistMatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ParserCommons {
    private static final int CONDITIONS_UPPER_LIMIT = 50;
    private final DefaultConditionsProvider mDefaultConditionsProvider;
    private EmptyMySegmentsStorage mEmptyMySegmentsStorage;
    private final MySegmentsStorageContainer mMyLargeSegmentsStorageContainer;
    private final MySegmentsStorageContainer mMySegmentsStorageContainer;
    private RuleBasedSegmentStorageConsumer mRuleBasedSegmentStorage;

    public ParserCommons(MySegmentsStorageContainer mySegmentsStorageContainer, MySegmentsStorageContainer myLargeSegmentsStorageContainer) {
        this(mySegmentsStorageContainer, myLargeSegmentsStorageContainer, new DefaultConditionsProvider());
    }

    ParserCommons(MySegmentsStorageContainer mySegmentsStorageContainer, MySegmentsStorageContainer myLargeSegmentsStorageContainer, DefaultConditionsProvider defaultConditionsProvider) {
        this.mMySegmentsStorageContainer = (MySegmentsStorageContainer) Utils.checkNotNull(mySegmentsStorageContainer);
        this.mMyLargeSegmentsStorageContainer = (MySegmentsStorageContainer) Utils.checkNotNull(myLargeSegmentsStorageContainer);
        this.mDefaultConditionsProvider = (DefaultConditionsProvider) Utils.checkNotNull(defaultConditionsProvider);
    }

    public void setRuleBasedSegmentStorage(RuleBasedSegmentStorageConsumer ruleBasedSegmentStorage) {
        this.mRuleBasedSegmentStorage = (RuleBasedSegmentStorageConsumer) Utils.checkNotNull(ruleBasedSegmentStorage);
    }

    List<ParsedCondition> getParsedConditions(String matchingKey, List<Condition> conditions, String largeConditionSizeMessage) {
        if (conditions.size() > 50) {
            Logger.w(largeConditionSizeMessage);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            for (Condition condition : conditions) {
                List<Partition> list = condition.partitions;
                arrayList.add(new ParsedCondition(condition.conditionType, toMatcher(condition.matcherGroup, matchingKey), list, condition.label));
            }
            return arrayList;
        } catch (UnsupportedMatcherException e) {
            Logger.w(e.getMessage());
            return this.mDefaultConditionsProvider.getDefaultConditions();
        }
    }

    private CombiningMatcher toMatcher(MatcherGroup matcherGroup, String matchingKey) throws UnsupportedMatcherException {
        List<Matcher> list = matcherGroup.matchers;
        Utils.checkArgument(!list.isEmpty());
        ArrayList arrayList = new ArrayList();
        Iterator<Matcher> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(toMatcher(it.next(), matchingKey));
        }
        return new CombiningMatcher(matcherGroup.combiner, arrayList);
    }

    private AttributeMatcher toMatcher(Matcher matcher, String matchingKey) throws UnsupportedMatcherException {
        io.split.android.engine.matchers.Matcher allKeysMatcher;
        if (matcher.matcherType == null) {
            throw new UnsupportedMatcherException("Unable to create matcher for matcher type");
        }
        String str = null;
        switch (AnonymousClass1.$SwitchMap$io$split$android$client$dtos$MatcherType[matcher.matcherType.ordinal()]) {
            case 1:
                allKeysMatcher = new AllKeysMatcher();
                break;
            case 2:
                Utils.checkNotNull(matcher.userDefinedSegmentMatcherData);
                allKeysMatcher = new MySegmentsMatcher(matchingKey != null ? this.mMySegmentsStorageContainer.getStorageForKey(matchingKey) : getEmptyMySegmentsStorage(), matcher.userDefinedSegmentMatcherData.segmentName);
                break;
            case 3:
                Utils.checkNotNull(matcher.userDefinedLargeSegmentMatcherData);
                allKeysMatcher = new MySegmentsMatcher(matchingKey != null ? this.mMyLargeSegmentsStorageContainer.getStorageForKey(matchingKey) : getEmptyMySegmentsStorage(), matcher.userDefinedLargeSegmentMatcherData.largeSegmentName);
                break;
            case 4:
                Utils.checkNotNull(matcher.whitelistMatcherData);
                allKeysMatcher = new WhitelistMatcher(matcher.whitelistMatcherData.whitelist);
                break;
            case 5:
                Utils.checkNotNull(matcher.unaryNumericMatcherData);
                allKeysMatcher = new EqualToMatcher(matcher.unaryNumericMatcherData.value, matcher.unaryNumericMatcherData.dataType);
                break;
            case 6:
                Utils.checkNotNull(matcher.unaryNumericMatcherData);
                allKeysMatcher = new GreaterThanOrEqualToMatcher(matcher.unaryNumericMatcherData.value, matcher.unaryNumericMatcherData.dataType);
                break;
            case 7:
                Utils.checkNotNull(matcher.unaryNumericMatcherData);
                allKeysMatcher = new LessThanOrEqualToMatcher(matcher.unaryNumericMatcherData.value, matcher.unaryNumericMatcherData.dataType);
                break;
            case 8:
                Utils.checkNotNull(matcher.betweenMatcherData);
                allKeysMatcher = new BetweenMatcher(matcher.betweenMatcherData.start, matcher.betweenMatcherData.end, matcher.betweenMatcherData.dataType);
                break;
            case 9:
                Utils.checkNotNull(matcher.whitelistMatcherData);
                allKeysMatcher = new EqualToSetMatcher(matcher.whitelistMatcherData.whitelist);
                break;
            case 10:
                Utils.checkNotNull(matcher.whitelistMatcherData);
                allKeysMatcher = new PartOfSetMatcher(matcher.whitelistMatcherData.whitelist);
                break;
            case 11:
                Utils.checkNotNull(matcher.whitelistMatcherData);
                allKeysMatcher = new ContainsAllOfSetMatcher(matcher.whitelistMatcherData.whitelist);
                break;
            case 12:
                Utils.checkNotNull(matcher.whitelistMatcherData);
                allKeysMatcher = new ContainsAnyOfSetMatcher(matcher.whitelistMatcherData.whitelist);
                break;
            case 13:
                Utils.checkNotNull(matcher.whitelistMatcherData);
                allKeysMatcher = new StartsWithAnyOfMatcher(matcher.whitelistMatcherData.whitelist);
                break;
            case 14:
                Utils.checkNotNull(matcher.whitelistMatcherData);
                allKeysMatcher = new EndsWithAnyOfMatcher(matcher.whitelistMatcherData.whitelist);
                break;
            case 15:
                Utils.checkNotNull(matcher.whitelistMatcherData);
                allKeysMatcher = new ContainsAnyOfMatcher(matcher.whitelistMatcherData.whitelist);
                break;
            case 16:
                Utils.checkNotNull(matcher.stringMatcherData);
                allKeysMatcher = new RegularExpressionMatcher(matcher.stringMatcherData);
                break;
            case 17:
                Utils.checkNotNull(matcher.dependencyMatcherData, "MatcherType is " + matcher.matcherType + ". matcher.dependencyMatcherData() MUST NOT BE null");
                allKeysMatcher = new DependencyMatcher(matcher.dependencyMatcherData.split, matcher.dependencyMatcherData.treatments);
                break;
            case 18:
                Utils.checkNotNull(matcher.booleanMatcherData, "MatcherType is " + matcher.matcherType + ". matcher.booleanMatcherData() MUST NOT BE null");
                allKeysMatcher = new BooleanMatcher(matcher.booleanMatcherData.booleanValue());
                break;
            case 19:
                allKeysMatcher = new EqualToSemverMatcher(matcher.stringMatcherData);
                break;
            case 20:
                allKeysMatcher = new GreaterThanOrEqualToSemverMatcher(matcher.stringMatcherData);
                break;
            case 21:
                allKeysMatcher = new LessThanOrEqualToSemverMatcher(matcher.stringMatcherData);
                break;
            case 22:
                allKeysMatcher = new BetweenSemverMatcher(matcher.betweenStringMatcherData.start, matcher.betweenStringMatcherData.end);
                break;
            case 23:
                allKeysMatcher = new InListSemverMatcher(matcher.whitelistMatcherData.whitelist);
                break;
            case 24:
                if (this.mRuleBasedSegmentStorage != null) {
                    allKeysMatcher = new InRuleBasedSegmentMatcher(this.mRuleBasedSegmentStorage, matchingKey != null ? this.mMySegmentsStorageContainer.getStorageForKey(matchingKey) : getEmptyMySegmentsStorage(), matchingKey != null ? this.mMyLargeSegmentsStorageContainer.getStorageForKey(matchingKey) : getEmptyMySegmentsStorage(), matcher.userDefinedSegmentMatcherData.segmentName);
                } else {
                    Logger.w("RuleBasedSegmentStorage not set in ParserCommons");
                    allKeysMatcher = null;
                }
                break;
            default:
                throw new UnsupportedMatcherException("Unable to create matcher for matcher type: " + matcher.matcherType);
        }
        if (allKeysMatcher == null) {
            throw new UnsupportedMatcherException("Unable to create matcher for matcher type: " + matcher.matcherType);
        }
        if (matcher.keySelector != null && matcher.keySelector.attribute != null) {
            str = matcher.keySelector.attribute;
        }
        return new AttributeMatcher(str, allKeysMatcher, matcher.negate);
    }

    /* JADX INFO: renamed from: io.split.android.engine.experiments.ParserCommons$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$dtos$MatcherType;

        static {
            int[] iArr = new int[MatcherType.values().length];
            $SwitchMap$io$split$android$client$dtos$MatcherType = iArr;
            try {
                iArr[MatcherType.ALL_KEYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$dtos$MatcherType[MatcherType.IN_SEGMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$split$android$client$dtos$MatcherType[MatcherType.IN_LARGE_SEGMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$split$android$client$dtos$MatcherType[MatcherType.WHITELIST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$split$android$client$dtos$MatcherType[MatcherType.EQUAL_TO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$split$android$client$dtos$MatcherType[MatcherType.GREATER_THAN_OR_EQUAL_TO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$split$android$client$dtos$MatcherType[MatcherType.LESS_THAN_OR_EQUAL_TO.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$split$android$client$dtos$MatcherType[MatcherType.BETWEEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$split$android$client$dtos$MatcherType[MatcherType.EQUAL_TO_SET.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$split$android$client$dtos$MatcherType[MatcherType.PART_OF_SET.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$split$android$client$dtos$MatcherType[MatcherType.CONTAINS_ALL_OF_SET.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$io$split$android$client$dtos$MatcherType[MatcherType.CONTAINS_ANY_OF_SET.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$io$split$android$client$dtos$MatcherType[MatcherType.STARTS_WITH.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$io$split$android$client$dtos$MatcherType[MatcherType.ENDS_WITH.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$io$split$android$client$dtos$MatcherType[MatcherType.CONTAINS_STRING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$io$split$android$client$dtos$MatcherType[MatcherType.MATCHES_STRING.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$io$split$android$client$dtos$MatcherType[MatcherType.IN_SPLIT_TREATMENT.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$io$split$android$client$dtos$MatcherType[MatcherType.EQUAL_TO_BOOLEAN.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$io$split$android$client$dtos$MatcherType[MatcherType.EQUAL_TO_SEMVER.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$io$split$android$client$dtos$MatcherType[MatcherType.GREATER_THAN_OR_EQUAL_TO_SEMVER.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$io$split$android$client$dtos$MatcherType[MatcherType.LESS_THAN_OR_EQUAL_TO_SEMVER.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$io$split$android$client$dtos$MatcherType[MatcherType.BETWEEN_SEMVER.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$io$split$android$client$dtos$MatcherType[MatcherType.IN_LIST_SEMVER.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$io$split$android$client$dtos$MatcherType[MatcherType.IN_RULE_BASED_SEGMENT.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
        }
    }

    private EmptyMySegmentsStorage getEmptyMySegmentsStorage() {
        if (this.mEmptyMySegmentsStorage == null) {
            this.mEmptyMySegmentsStorage = new EmptyMySegmentsStorage();
        }
        return this.mEmptyMySegmentsStorage;
    }
}
