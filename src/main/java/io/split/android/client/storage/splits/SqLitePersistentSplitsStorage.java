package io.split.android.client.storage.splits;

import com.google.gson.reflect.TypeToken;
import io.split.android.client.dtos.Split;
import io.split.android.client.dtos.Status;
import io.split.android.client.service.executor.parallel.SplitParallelTaskExecutorFactory;
import io.split.android.client.service.executor.parallel.SplitParallelTaskExecutorFactoryImpl;
import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.db.GeneralInfoEntity;
import io.split.android.client.storage.db.SplitEntity;
import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class SqLitePersistentSplitsStorage implements PersistentSplitsStorage {
    private static final int SQL_PARAM_BIND_SIZE = 20;
    private final SplitCipher mCipher;
    private final SplitRoomDatabase mDatabase;
    private final SplitListTransformer<SplitEntity, Split> mEntityToSplitTransformer;
    private final SplitListTransformer<Split, SplitEntity> mSplitToEntityTransformer;

    @Override // io.split.android.client.storage.splits.PersistentSplitsStorage
    public void close() {
    }

    public SqLitePersistentSplitsStorage(SplitRoomDatabase database, SplitCipher splitCipher) {
        this(database, new SplitParallelTaskExecutorFactoryImpl(), splitCipher);
    }

    public SqLitePersistentSplitsStorage(SplitRoomDatabase database, SplitListTransformer<SplitEntity, Split> entityToSplitTransformer, SplitListTransformer<Split, SplitEntity> splitToEntityTransformer, SplitCipher cipher) {
        this.mDatabase = (SplitRoomDatabase) Utils.checkNotNull(database);
        this.mEntityToSplitTransformer = (SplitListTransformer) Utils.checkNotNull(entityToSplitTransformer);
        this.mSplitToEntityTransformer = (SplitListTransformer) Utils.checkNotNull(splitToEntityTransformer);
        this.mCipher = (SplitCipher) Utils.checkNotNull(cipher);
    }

    private SqLitePersistentSplitsStorage(SplitRoomDatabase database, SplitParallelTaskExecutorFactory executorFactory, SplitCipher splitCipher) {
        this(database, new SplitEntityToSplitTransformer(splitCipher), new SplitToSplitEntityTransformer(executorFactory.createForList(SplitEntity.class), splitCipher), splitCipher);
    }

    @Override // io.split.android.client.storage.splits.PersistentSplitsStorage
    public boolean update(final ProcessedSplitChange splitChange, final Map<String, Integer> mTrafficTypes, final Map<String, Set<String>> mFlagSets) {
        if (splitChange == null) {
            return false;
        }
        final List<String> listSplitNameList = splitNameList(splitChange.getArchivedSplits());
        final List<SplitEntity> listConvertSplitListToEntities = convertSplitListToEntities(splitChange.getActiveSplits());
        this.mDatabase.runInTransaction(new Runnable() { // from class: io.split.android.client.storage.splits.SqLitePersistentSplitsStorage.1
            @Override // java.lang.Runnable
            public void run() {
                SqLitePersistentSplitsStorage.this.mDatabase.generalInfoDao().update(new GeneralInfoEntity(GeneralInfoEntity.CHANGE_NUMBER_INFO, splitChange.getChangeNumber()));
                if (!listConvertSplitListToEntities.isEmpty()) {
                    SqLitePersistentSplitsStorage.this.mDatabase.splitDao().insert(listConvertSplitListToEntities);
                }
                if (!listSplitNameList.isEmpty()) {
                    SqLitePersistentSplitsStorage.this.mDatabase.splitDao().delete(listSplitNameList);
                }
                if (!mTrafficTypes.isEmpty()) {
                    SqLitePersistentSplitsStorage.this.mDatabase.generalInfoDao().update(new GeneralInfoEntity(GeneralInfoEntity.TRAFFIC_TYPES_MAP, SqLitePersistentSplitsStorage.this.mCipher.encrypt(Json.toJson(mTrafficTypes))));
                }
                if (!mFlagSets.isEmpty()) {
                    SqLitePersistentSplitsStorage.this.mDatabase.generalInfoDao().update(new GeneralInfoEntity(GeneralInfoEntity.FLAG_SETS_MAP, SqLitePersistentSplitsStorage.this.mCipher.encrypt(Json.toJson(mFlagSets))));
                }
                SqLitePersistentSplitsStorage.this.mDatabase.generalInfoDao().update(new GeneralInfoEntity(GeneralInfoEntity.SPLITS_UPDATE_TIMESTAMP, splitChange.getUpdateTimestamp()));
            }
        });
        return true;
    }

    @Override // io.split.android.client.storage.splits.PersistentSplitsStorage
    public SplitsSnapshot getSnapshot() {
        SplitsSnapshotLoader splitsSnapshotLoader = new SplitsSnapshotLoader(this.mDatabase, loadSplits(), this.mCipher);
        splitsSnapshotLoader.run();
        return new SplitsSnapshot(splitsSnapshotLoader.getSplits(), splitsSnapshotLoader.getChangeNumber().longValue(), splitsSnapshotLoader.getUpdateTimestamp().longValue(), splitsSnapshotLoader.getSplitsFilterQueryString(), splitsSnapshotLoader.getFlagsSpec(), splitsSnapshotLoader.getTrafficTypes(), splitsSnapshotLoader.getFlagSets());
    }

    @Override // io.split.android.client.storage.splits.PersistentSplitsStorage
    public void update(Split split) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(split);
        this.mDatabase.splitDao().insert(convertSplitListToEntities(arrayList));
    }

    @Override // io.split.android.client.storage.splits.PersistentSplitsStorage
    public void updateFilterQueryString(String queryString) {
        this.mDatabase.generalInfoDao().update(new GeneralInfoEntity(GeneralInfoEntity.SPLITS_FILTER_QUERY_STRING, queryString));
    }

    @Override // io.split.android.client.storage.splits.PersistentSplitsStorage
    public String getFlagsSpec() {
        GeneralInfoEntity byName = this.mDatabase.generalInfoDao().getByName("flagsSpec");
        if (byName != null) {
            return byName.getStringValue();
        }
        return null;
    }

    @Override // io.split.android.client.storage.splits.PersistentSplitsStorage
    public void updateFlagsSpec(String flagsSpec) {
        this.mDatabase.generalInfoDao().update(new GeneralInfoEntity("flagsSpec", flagsSpec));
    }

    @Override // io.split.android.client.storage.splits.PersistentSplitsStorage
    public void delete(List<String> splitNames) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = splitNames.iterator();
        while (it.hasNext()) {
            arrayList.add(this.mCipher.encrypt(it.next()));
        }
        Iterator it2 = Utils.partition(arrayList, 20).iterator();
        while (it2.hasNext()) {
            this.mDatabase.splitDao().delete((List) it2.next());
        }
    }

    @Override // io.split.android.client.storage.splits.PersistentSplitsStorage
    public void clear() {
        this.mDatabase.runInTransaction(new Runnable() { // from class: io.split.android.client.storage.splits.SqLitePersistentSplitsStorage.2
            @Override // java.lang.Runnable
            public void run() {
                SqLitePersistentSplitsStorage.this.mDatabase.generalInfoDao().update(new GeneralInfoEntity(GeneralInfoEntity.CHANGE_NUMBER_INFO, -1L));
                SqLitePersistentSplitsStorage.this.mDatabase.generalInfoDao().update(new GeneralInfoEntity(GeneralInfoEntity.FLAG_SETS_MAP, ""));
                SqLitePersistentSplitsStorage.this.mDatabase.generalInfoDao().update(new GeneralInfoEntity(GeneralInfoEntity.TRAFFIC_TYPES_MAP, ""));
                SqLitePersistentSplitsStorage.this.mDatabase.getSplitQueryDao().invalidate();
                SqLitePersistentSplitsStorage.this.mDatabase.splitDao().deleteAll();
            }
        });
    }

    @Override // io.split.android.client.storage.splits.PersistentSplitsStorage
    public List<Split> getAll() {
        return loadSplits();
    }

    @Override // io.split.android.client.storage.splits.PersistentSplitsStorage
    public String getFilterQueryString() {
        GeneralInfoEntity byName = this.mDatabase.generalInfoDao().getByName(GeneralInfoEntity.SPLITS_FILTER_QUERY_STRING);
        if (byName != null) {
            return byName.getStringValue();
        }
        return null;
    }

    private List<Split> loadSplits() {
        return this.mEntityToSplitTransformer.transform(this.mDatabase.getSplitQueryDao().getAllAsMap());
    }

    private List<SplitEntity> convertSplitListToEntities(List<Split> splits) {
        if (splits == null) {
            return new ArrayList();
        }
        return this.mSplitToEntityTransformer.transform(splits);
    }

    private List<String> splitNameList(List<Split> splits) {
        ArrayList arrayList = new ArrayList();
        if (splits != null) {
            Iterator<Split> it = splits.iterator();
            while (it.hasNext()) {
                arrayList.add(this.mCipher.encrypt(it.next().name));
            }
        }
        return arrayList;
    }

    private static class SplitsSnapshotLoader implements Runnable {
        private final SplitCipher mCipher;
        private final SplitRoomDatabase mDatabase;
        private final List<Split> mSplits;
        private Long mChangeNumber = -1L;
        private Long mUpdateTimestamp = 0L;
        private String mSplitsFilterQueryString = "";
        private String mFlagsSpec = "";
        private Map<String, Integer> mTrafficTypes = new ConcurrentHashMap();
        private Map<String, Set<String>> mFlagSets = new ConcurrentHashMap();

        public SplitsSnapshotLoader(SplitRoomDatabase database, List<Split> splits, SplitCipher cipher) {
            this.mDatabase = database;
            this.mSplits = splits;
            this.mCipher = cipher;
        }

        @Override // java.lang.Runnable
        public void run() {
            GeneralInfoEntity byName = this.mDatabase.generalInfoDao().getByName(GeneralInfoEntity.SPLITS_UPDATE_TIMESTAMP);
            GeneralInfoEntity byName2 = this.mDatabase.generalInfoDao().getByName(GeneralInfoEntity.CHANGE_NUMBER_INFO);
            GeneralInfoEntity byName3 = this.mDatabase.generalInfoDao().getByName(GeneralInfoEntity.SPLITS_FILTER_QUERY_STRING);
            GeneralInfoEntity byName4 = this.mDatabase.generalInfoDao().getByName("flagsSpec");
            GeneralInfoEntity byName5 = this.mDatabase.generalInfoDao().getByName(GeneralInfoEntity.TRAFFIC_TYPES_MAP);
            GeneralInfoEntity byName6 = this.mDatabase.generalInfoDao().getByName(GeneralInfoEntity.FLAG_SETS_MAP);
            if (byName2 != null) {
                this.mChangeNumber = Long.valueOf(byName2.getLongValue());
            }
            if (byName != null) {
                this.mUpdateTimestamp = Long.valueOf(byName.getLongValue());
            }
            if (byName3 != null) {
                this.mSplitsFilterQueryString = byName3.getStringValue();
            }
            if (byName4 != null) {
                this.mFlagsSpec = byName4.getStringValue();
            }
            boolean zIsEmpty = this.mSplits.isEmpty();
            boolean z = byName5 == null || byName5.getStringValue().isEmpty();
            boolean z2 = byName6 == null || byName6.getStringValue().isEmpty();
            if (!zIsEmpty && (z || z2)) {
                migrateTrafficTypesAndSetsFromStoredData();
            }
            parseTrafficTypesAndSets(byName5, byName6);
        }

        private synchronized void parseTrafficTypesAndSets(GeneralInfoEntity trafficTypesEntity, GeneralInfoEntity flagSetsEntity) {
            Logger.v("Parsing traffic types and sets");
            if (trafficTypesEntity != null && !trafficTypesEntity.getStringValue().isEmpty()) {
                this.mTrafficTypes = (Map) Json.fromJson(this.mCipher.decrypt(trafficTypesEntity.getStringValue()), new TypeToken<Map<String, Integer>>() { // from class: io.split.android.client.storage.splits.SqLitePersistentSplitsStorage.SplitsSnapshotLoader.1
                }.getType());
            }
            if (flagSetsEntity != null && !flagSetsEntity.getStringValue().isEmpty()) {
                this.mFlagSets = (Map) Json.fromJson(this.mCipher.decrypt(flagSetsEntity.getStringValue()), new TypeToken<Map<String, Set<String>>>() { // from class: io.split.android.client.storage.splits.SqLitePersistentSplitsStorage.SplitsSnapshotLoader.2
                }.getType());
            }
        }

        private void migrateTrafficTypesAndSetsFromStoredData() {
            Logger.i("Migration required for cached traffic types and flag sets. Migrating now.");
            try {
                Iterator<Split> it = this.mSplits.iterator();
                while (it.hasNext()) {
                    Split split = (Split) Json.fromJson(it.next().json, Split.class);
                    if (split != null) {
                        if (split.status == Status.ACTIVE) {
                            MetadataHelper.increaseTrafficTypeCount(split.trafficTypeName, this.mTrafficTypes);
                            MetadataHelper.addOrUpdateFlagSets(split, this.mFlagSets);
                        } else {
                            MetadataHelper.decreaseTrafficTypeCount(split.trafficTypeName, this.mTrafficTypes);
                            MetadataHelper.deleteFromFlagSetsIfNecessary(split, this.mFlagSets);
                        }
                    }
                }
                Map<String, Integer> map = this.mTrafficTypes;
                if (map != null && !map.isEmpty()) {
                    this.mDatabase.generalInfoDao().update(new GeneralInfoEntity(GeneralInfoEntity.TRAFFIC_TYPES_MAP, this.mCipher.encrypt(Json.toJson(this.mTrafficTypes))));
                }
                Map<String, Set<String>> map2 = this.mFlagSets;
                if (map2 == null || map2.isEmpty()) {
                    return;
                }
                this.mDatabase.generalInfoDao().update(new GeneralInfoEntity(GeneralInfoEntity.FLAG_SETS_MAP, this.mCipher.encrypt(Json.toJson(this.mFlagSets))));
            } catch (Exception e) {
                Logger.e("Failed to migrate traffic types and flag sets", e);
            }
        }

        public List<Split> getSplits() {
            return this.mSplits;
        }

        public Long getChangeNumber() {
            return this.mChangeNumber;
        }

        public Long getUpdateTimestamp() {
            return this.mUpdateTimestamp;
        }

        public String getSplitsFilterQueryString() {
            return this.mSplitsFilterQueryString;
        }

        public String getFlagsSpec() {
            return this.mFlagsSpec;
        }

        public Map<String, Integer> getTrafficTypes() {
            return this.mTrafficTypes;
        }

        public Map<String, Set<String>> getFlagSets() {
            return this.mFlagSets;
        }
    }
}
