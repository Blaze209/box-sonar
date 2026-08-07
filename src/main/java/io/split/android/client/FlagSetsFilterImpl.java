package io.split.android.client;

import io.split.android.client.utils.Utils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class FlagSetsFilterImpl implements FlagSetsFilter {
    private final Set<String> mFlagSets;
    private final boolean mShouldFilter;

    public FlagSetsFilterImpl(Collection<String> flagSets) {
        HashSet hashSet = new HashSet(flagSets);
        this.mFlagSets = hashSet;
        this.mShouldFilter = !hashSet.isEmpty();
    }

    @Override // io.split.android.client.FeatureFlagFilter
    public boolean intersect(Set<String> sets) {
        if (!this.mShouldFilter) {
            return true;
        }
        if (sets == null) {
            return false;
        }
        return !Utils.intersection(this.mFlagSets, sets).isEmpty();
    }

    @Override // io.split.android.client.FeatureFlagFilter
    public boolean intersect(String set) {
        if (!this.mShouldFilter) {
            return true;
        }
        if (set == null) {
            return false;
        }
        return this.mFlagSets.contains(set);
    }
}
