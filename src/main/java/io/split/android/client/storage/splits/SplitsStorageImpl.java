package io.split.android.client.storage.splits;

import com.google.gson.JsonSyntaxException;
import io.split.android.client.dtos.Split;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.Utils;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class SplitsStorageImpl implements SplitsStorage {
    private long mChangeNumber;
    private String mFlagsSpec;
    private final PersistentSplitsStorage mPersistentStorage;
    private String mSplitsFilterQueryString;
    private long mUpdateTimestamp;
    private final AtomicBoolean mInitialized = new AtomicBoolean(false);
    private final Map<String, Split> mInMemorySplits = new ConcurrentHashMap();
    private final Map<String, Integer> mTrafficTypes = new ConcurrentHashMap();
    private final Map<String, Set<String>> mFlagSets = new ConcurrentHashMap();

    public SplitsStorageImpl(PersistentSplitsStorage persistentStorage) {
        this.mPersistentStorage = (PersistentSplitsStorage) Utils.checkNotNull(persistentStorage);
    }

    @Override // io.split.android.client.storage.RolloutDefinitionsCache
    public synchronized void loadLocal() {
        if (this.mInitialized.get()) {
            return;
        }
        try {
            System.currentTimeMillis();
            SplitsSnapshot snapshot = this.mPersistentStorage.getSnapshot();
            List<Split> splits = snapshot.getSplits();
            this.mChangeNumber = snapshot.getChangeNumber();
            this.mUpdateTimestamp = snapshot.getUpdateTimestamp();
            this.mSplitsFilterQueryString = snapshot.getSplitsFilterQueryString();
            this.mFlagsSpec = snapshot.getFlagsSpec();
            this.mTrafficTypes.putAll(snapshot.getTrafficTypesMap());
            for (Map.Entry<String, Set<String>> entry : snapshot.getFlagSetsMap().entrySet()) {
                this.mFlagSets.put(entry.getKey(), new HashSet(entry.getValue()));
            }
            for (Split split : splits) {
                this.mInMemorySplits.put(split.name, split);
            }
            this.mInitialized.compareAndSet(false, true);
        } catch (Throwable th) {
            this.mInitialized.compareAndSet(false, true);
            throw th;
        }
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public Split get(String name) {
        Split split = this.mInMemorySplits.get(name);
        if (split == null) {
            return null;
        }
        if (split.json == null) {
            return split;
        }
        try {
            Split split2 = (Split) Json.fromJson(split.json, Split.class);
            split2.json = null;
            this.mInMemorySplits.put(name, split2);
            return this.mInMemorySplits.get(name);
        } catch (JsonSyntaxException unused) {
            return null;
        }
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public Map<String, Split> getMany(List<String> splitNames) {
        HashMap map = new HashMap();
        if (splitNames == null || splitNames.isEmpty()) {
            for (String str : this.mInMemorySplits.keySet()) {
                map.put(str, get(str));
            }
        } else {
            for (String str2 : splitNames) {
                Split split = get(str2);
                if (split != null) {
                    map.put(str2, split);
                }
            }
        }
        return map;
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public Map<String, Split> getAll() {
        return getMany(null);
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public boolean update(ProcessedSplitChange splitChange) {
        boolean z = false;
        if (splitChange == null) {
            return false;
        }
        List<Split> activeSplits = splitChange.getActiveSplits();
        List<Split> archivedSplits = splitChange.getArchivedSplits();
        if (activeSplits != null) {
            z = !activeSplits.isEmpty();
            for (Split split : activeSplits) {
                Split split2 = get(split.name);
                if (split2 != null && split2.trafficTypeName != null) {
                    MetadataHelper.decreaseTrafficTypeCount(split2.trafficTypeName, this.mTrafficTypes);
                }
                MetadataHelper.increaseTrafficTypeCount(split.trafficTypeName, this.mTrafficTypes);
                this.mInMemorySplits.put(split.name, split);
                MetadataHelper.addOrUpdateFlagSets(split, this.mFlagSets);
            }
        }
        if (archivedSplits != null) {
            for (Split split3 : archivedSplits) {
                if (this.mInMemorySplits.remove(split3.name) != null) {
                    MetadataHelper.decreaseTrafficTypeCount(split3.trafficTypeName, this.mTrafficTypes);
                    MetadataHelper.deleteFromFlagSetsIfNecessary(split3, this.mFlagSets);
                    z = true;
                }
            }
        }
        this.mChangeNumber = splitChange.getChangeNumber();
        this.mUpdateTimestamp = splitChange.getUpdateTimestamp();
        this.mPersistentStorage.update(splitChange, this.mTrafficTypes, this.mFlagSets);
        return z;
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public void updateWithoutChecks(Split split) {
        this.mInMemorySplits.put(split.name, split);
        this.mPersistentStorage.update(split);
        MetadataHelper.deleteFromFlagSets(split, this.mFlagSets);
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public long getTill() {
        return this.mChangeNumber;
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public long getUpdateTimestamp() {
        return this.mUpdateTimestamp;
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public String getSplitsFilterQueryString() {
        return this.mSplitsFilterQueryString;
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public void updateSplitsFilterQueryString(String queryString) {
        this.mPersistentStorage.updateFilterQueryString(queryString);
        this.mSplitsFilterQueryString = queryString;
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public String getFlagsSpec() {
        return this.mFlagsSpec;
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public void updateFlagsSpec(String flagsSpec) {
        this.mPersistentStorage.updateFlagsSpec(flagsSpec);
        this.mFlagsSpec = flagsSpec;
    }

    @Override // io.split.android.client.storage.RolloutDefinitionsCache
    public void clear() {
        this.mInMemorySplits.clear();
        this.mChangeNumber = -1L;
        this.mPersistentStorage.clear();
        this.mFlagSets.clear();
        this.mTrafficTypes.clear();
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public Set<String> getNamesByFlagSets(Collection<String> sets) {
        HashSet hashSet = new HashSet();
        if (sets != null && !sets.isEmpty()) {
            Iterator<String> it = sets.iterator();
            while (it.hasNext()) {
                Set<String> set = this.mFlagSets.get(it.next());
                if (set != null) {
                    hashSet.addAll(set);
                }
            }
        }
        return hashSet;
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public boolean isValidTrafficType(String name) {
        return (name == null || this.mTrafficTypes.get(name.toLowerCase()) == null) ? false : true;
    }
}
