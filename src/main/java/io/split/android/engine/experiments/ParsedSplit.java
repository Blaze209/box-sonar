package io.split.android.engine.experiments;

import io.split.android.client.dtos.Prerequisite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class ParsedSplit {
    private final int mAlgo;
    private final long mChangeNumber;
    private final Map<String, String> mConfigurations;
    private final String mDefaultTreatment;
    private final boolean mImpressionsDisabled;
    private final boolean mKilled;
    private final List<ParsedCondition> mParsedCondition;
    private final List<Prerequisite> mPrerequisites;
    private final int mSeed;
    private final Set<String> mSets;
    private final String mSplit;
    private final int mTrafficAllocation;
    private final int mTrafficAllocationSeed;
    private final String mTrafficTypeName;

    public ParsedSplit(String feature, int seed, boolean killed, String defaultTreatment, List<ParsedCondition> matcherAndSplits, String trafficTypeName, long changeNumber, int trafficAllocation, int trafficAllocationSeed, int algo, Map<String, String> configurations, Set<String> sets, boolean impressionsDisabled, List<Prerequisite> prerequisites) {
        this.mSplit = feature;
        this.mSeed = seed;
        this.mKilled = killed;
        this.mDefaultTreatment = defaultTreatment;
        this.mParsedCondition = Collections.unmodifiableList(new ArrayList(matcherAndSplits));
        this.mTrafficTypeName = trafficTypeName;
        this.mChangeNumber = changeNumber;
        this.mAlgo = algo;
        this.mConfigurations = configurations;
        this.mImpressionsDisabled = impressionsDisabled;
        if (defaultTreatment == null) {
            throw new IllegalArgumentException("DefaultTreatment is null");
        }
        this.mTrafficAllocation = trafficAllocation;
        this.mTrafficAllocationSeed = trafficAllocationSeed;
        this.mSets = sets;
        this.mPrerequisites = prerequisites;
    }

    public String feature() {
        return this.mSplit;
    }

    public int trafficAllocation() {
        return this.mTrafficAllocation;
    }

    public int trafficAllocationSeed() {
        return this.mTrafficAllocationSeed;
    }

    public int seed() {
        return this.mSeed;
    }

    public boolean killed() {
        return this.mKilled;
    }

    public String defaultTreatment() {
        return this.mDefaultTreatment;
    }

    public List<ParsedCondition> parsedConditions() {
        return this.mParsedCondition;
    }

    public String trafficTypeName() {
        return this.mTrafficTypeName;
    }

    public long changeNumber() {
        return this.mChangeNumber;
    }

    public int algo() {
        return this.mAlgo;
    }

    public Map<String, String> configurations() {
        return this.mConfigurations;
    }

    public Set<String> sets() {
        return this.mSets;
    }

    public boolean impressionsDisabled() {
        return this.mImpressionsDisabled;
    }

    public List<Prerequisite> prerequisites() {
        return this.mPrerequisites;
    }

    public int hashCode() {
        int iHashCode = (527 + this.mSplit.hashCode()) * 31;
        int i = this.mSeed;
        int iHashCode2 = (((((((iHashCode + (i ^ (i >>> 32))) * 31) + (this.mKilled ? 1 : 0)) * 31) + this.mDefaultTreatment.hashCode()) * 31) + this.mParsedCondition.hashCode()) * 31;
        String str = this.mTrafficTypeName;
        int iHashCode3 = str == null ? 0 : str.hashCode();
        long j = this.mChangeNumber;
        int i2 = (((iHashCode2 + iHashCode3) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        int i3 = this.mAlgo;
        int i4 = (i2 + (i3 ^ (i3 >>> 32))) * 31;
        Set<String> set = this.mSets;
        int iHashCode4 = (((i4 + (set != null ? set.hashCode() : 0)) * 31) + (this.mImpressionsDisabled ? 1 : 0)) * 31;
        List<Prerequisite> list = this.mPrerequisites;
        return iHashCode4 + (list != null ? list.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParsedSplit)) {
            return false;
        }
        ParsedSplit parsedSplit = (ParsedSplit) obj;
        return this.mSplit.equals(parsedSplit.mSplit) && this.mSeed == parsedSplit.mSeed && this.mKilled == parsedSplit.mKilled && this.mDefaultTreatment.equals(parsedSplit.mDefaultTreatment) && this.mParsedCondition.equals(parsedSplit.mParsedCondition) && Objects.equals(this.mTrafficTypeName, parsedSplit.mTrafficTypeName) && this.mChangeNumber == parsedSplit.mChangeNumber && this.mAlgo == parsedSplit.mAlgo && Objects.equals(this.mConfigurations, parsedSplit.mConfigurations) && Objects.equals(this.mSets, parsedSplit.mSets) && this.mImpressionsDisabled == parsedSplit.mImpressionsDisabled && Objects.equals(this.mPrerequisites, parsedSplit.mPrerequisites);
    }

    public String toString() {
        return "name:" + this.mSplit + ", seed:" + this.mSeed + ", killed:" + this.mKilled + ", default treatment:" + this.mDefaultTreatment + ", parsedConditions:" + this.mParsedCondition + ", trafficTypeName:" + this.mTrafficTypeName + ", changeNumber:" + this.mChangeNumber + ", algo:" + this.mAlgo + ", config:" + this.mConfigurations + ", sets:" + this.mSets + ", impressionsDisabled:" + this.mImpressionsDisabled + ", prerequisites:" + this.mPrerequisites;
    }
}
