package io.split.android.client.storage.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.box.boxandroidlibv2private.dao.BoxConvertedPushNotificationDevice;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import io.split.android.client.service.ServiceConstants;
import io.split.android.client.storage.db.attributes.AttributesDao;
import io.split.android.client.storage.db.attributes.AttributesDao_Impl;
import io.split.android.client.storage.db.impressions.observer.ImpressionsObserverCacheDao;
import io.split.android.client.storage.db.impressions.observer.ImpressionsObserverCacheDao_Impl;
import io.split.android.client.storage.db.impressions.unique.UniqueKeysDao;
import io.split.android.client.storage.db.impressions.unique.UniqueKeysDao_Impl;
import io.split.android.client.storage.db.rbs.RuleBasedSegmentDao;
import io.split.android.client.storage.db.rbs.RuleBasedSegmentDao_Impl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class SplitRoomDatabase_Impl extends SplitRoomDatabase {
    private volatile AttributesDao _attributesDao;
    private volatile EventDao _eventDao;
    private volatile GeneralInfoDao _generalInfoDao;
    private volatile ImpressionDao _impressionDao;
    private volatile ImpressionsCountDao _impressionsCountDao;
    private volatile ImpressionsObserverCacheDao _impressionsObserverCacheDao;
    private volatile MyLargeSegmentDao _myLargeSegmentDao;
    private volatile MySegmentDao _mySegmentDao;
    private volatile RuleBasedSegmentDao _ruleBasedSegmentDao;
    private volatile SplitDao _splitDao;
    private volatile UniqueKeysDao _uniqueKeysDao;

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
        return configuration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(configuration.context).name(configuration.name).callback(new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(7) { // from class: io.split.android.client.storage.db.SplitRoomDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase _db) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase _db) {
                _db.execSQL("CREATE TABLE IF NOT EXISTS `my_segments` (`user_key` TEXT NOT NULL, `segment_list` TEXT NOT NULL, `updated_at` INTEGER NOT NULL, PRIMARY KEY(`user_key`))");
                _db.execSQL("CREATE TABLE IF NOT EXISTS `splits` (`name` TEXT NOT NULL, `body` TEXT NOT NULL, `updated_at` INTEGER NOT NULL, PRIMARY KEY(`name`))");
                _db.execSQL("CREATE TABLE IF NOT EXISTS `events` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `body` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `status` INTEGER NOT NULL)");
                _db.execSQL("CREATE TABLE IF NOT EXISTS `impressions` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `test_name` TEXT NOT NULL, `body` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `status` INTEGER NOT NULL)");
                _db.execSQL("CREATE TABLE IF NOT EXISTS `general_info` (`name` TEXT NOT NULL, `stringValue` TEXT, `longValue` INTEGER NOT NULL, `updated_at` INTEGER NOT NULL, PRIMARY KEY(`name`))");
                _db.execSQL("CREATE TABLE IF NOT EXISTS `impressions_count` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `body` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `status` INTEGER NOT NULL)");
                _db.execSQL("CREATE TABLE IF NOT EXISTS `attributes` (`user_key` TEXT NOT NULL, `attributes` TEXT, `updated_at` INTEGER NOT NULL, PRIMARY KEY(`user_key`))");
                _db.execSQL("CREATE TABLE IF NOT EXISTS `unique_keys` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `user_key` TEXT NOT NULL, `feature_list` TEXT, `created_at` INTEGER NOT NULL, `status` INTEGER NOT NULL)");
                _db.execSQL("CREATE TABLE IF NOT EXISTS `impressions_observer_cache` (`hash` INTEGER NOT NULL, `time` INTEGER NOT NULL, `created_at` INTEGER NOT NULL, PRIMARY KEY(`hash`))");
                _db.execSQL("CREATE TABLE IF NOT EXISTS `my_large_segments` (`user_key` TEXT NOT NULL, `segment_list` TEXT NOT NULL, `updated_at` INTEGER NOT NULL, PRIMARY KEY(`user_key`))");
                _db.execSQL("CREATE TABLE IF NOT EXISTS `rule_based_segments` (`name` TEXT NOT NULL, `body` TEXT, `updated_at` INTEGER NOT NULL, PRIMARY KEY(`name`))");
                _db.execSQL(RoomMasterTable.CREATE_QUERY);
                _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '37a4d008c17ec65f2a6d5ceec22d93c8')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase _db) {
                _db.execSQL("DROP TABLE IF EXISTS `my_segments`");
                _db.execSQL("DROP TABLE IF EXISTS `splits`");
                _db.execSQL("DROP TABLE IF EXISTS `events`");
                _db.execSQL("DROP TABLE IF EXISTS `impressions`");
                _db.execSQL("DROP TABLE IF EXISTS `general_info`");
                _db.execSQL("DROP TABLE IF EXISTS `impressions_count`");
                _db.execSQL("DROP TABLE IF EXISTS `attributes`");
                _db.execSQL("DROP TABLE IF EXISTS `unique_keys`");
                _db.execSQL("DROP TABLE IF EXISTS `impressions_observer_cache`");
                _db.execSQL("DROP TABLE IF EXISTS `my_large_segments`");
                _db.execSQL("DROP TABLE IF EXISTS `rule_based_segments`");
                if (SplitRoomDatabase_Impl.this.mCallbacks != null) {
                    int size = SplitRoomDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) SplitRoomDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(_db);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(SupportSQLiteDatabase _db) {
                if (SplitRoomDatabase_Impl.this.mCallbacks != null) {
                    int size = SplitRoomDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) SplitRoomDatabase_Impl.this.mCallbacks.get(i)).onCreate(_db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase _db) {
                SplitRoomDatabase_Impl.this.mDatabase = _db;
                SplitRoomDatabase_Impl.this.internalInitInvalidationTracker(_db);
                if (SplitRoomDatabase_Impl.this.mCallbacks != null) {
                    int size = SplitRoomDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) SplitRoomDatabase_Impl.this.mCallbacks.get(i)).onOpen(_db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(SupportSQLiteDatabase _db) {
                DBUtil.dropFtsSyncTriggers(_db);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.RoomOpenHelper.Delegate
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
                HashMap map = new HashMap(3);
                map.put("user_key", new TableInfo.Column("user_key", "TEXT", true, 1, null, 1));
                map.put("segment_list", new TableInfo.Column("segment_list", "TEXT", true, 0, null, 1));
                map.put(IDToken.UPDATED_AT, new TableInfo.Column(IDToken.UPDATED_AT, "INTEGER", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo(MySegmentDao.TABLE_NAME, map, new HashSet(0), new HashSet(0));
                TableInfo tableInfo2 = TableInfo.read(_db, MySegmentDao.TABLE_NAME);
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenHelper.ValidationResult(false, "my_segments(io.split.android.client.storage.db.MySegmentEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                HashMap map2 = new HashMap(3);
                map2.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, 1));
                map2.put("body", new TableInfo.Column("body", "TEXT", true, 0, null, 1));
                map2.put(IDToken.UPDATED_AT, new TableInfo.Column(IDToken.UPDATED_AT, "INTEGER", true, 0, null, 1));
                TableInfo tableInfo3 = new TableInfo(ServiceConstants.DEFAULT_SPLITS_FILENAME, map2, new HashSet(0), new HashSet(0));
                TableInfo tableInfo4 = TableInfo.read(_db, ServiceConstants.DEFAULT_SPLITS_FILENAME);
                if (!tableInfo3.equals(tableInfo4)) {
                    return new RoomOpenHelper.ValidationResult(false, "splits(io.split.android.client.storage.db.SplitEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
                }
                HashMap map3 = new HashMap(4);
                map3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                map3.put("body", new TableInfo.Column("body", "TEXT", true, 0, null, 1));
                map3.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, 1));
                map3.put("status", new TableInfo.Column("status", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo5 = new TableInfo(BoxConvertedPushNotificationDevice.EVENTS, map3, new HashSet(0), new HashSet(0));
                TableInfo tableInfo6 = TableInfo.read(_db, BoxConvertedPushNotificationDevice.EVENTS);
                if (!tableInfo5.equals(tableInfo6)) {
                    return new RoomOpenHelper.ValidationResult(false, "events(io.split.android.client.storage.db.EventEntity).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
                }
                HashMap map4 = new HashMap(5);
                map4.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                map4.put("test_name", new TableInfo.Column("test_name", "TEXT", true, 0, null, 1));
                map4.put("body", new TableInfo.Column("body", "TEXT", true, 0, null, 1));
                map4.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, 1));
                map4.put("status", new TableInfo.Column("status", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo7 = new TableInfo("impressions", map4, new HashSet(0), new HashSet(0));
                TableInfo tableInfo8 = TableInfo.read(_db, "impressions");
                if (!tableInfo7.equals(tableInfo8)) {
                    return new RoomOpenHelper.ValidationResult(false, "impressions(io.split.android.client.storage.db.ImpressionEntity).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfo8);
                }
                HashMap map5 = new HashMap(4);
                map5.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, 1));
                map5.put("stringValue", new TableInfo.Column("stringValue", "TEXT", false, 0, null, 1));
                map5.put("longValue", new TableInfo.Column("longValue", "INTEGER", true, 0, null, 1));
                map5.put(IDToken.UPDATED_AT, new TableInfo.Column(IDToken.UPDATED_AT, "INTEGER", true, 0, null, 1));
                TableInfo tableInfo9 = new TableInfo("general_info", map5, new HashSet(0), new HashSet(0));
                TableInfo tableInfo10 = TableInfo.read(_db, "general_info");
                if (!tableInfo9.equals(tableInfo10)) {
                    return new RoomOpenHelper.ValidationResult(false, "general_info(io.split.android.client.storage.db.GeneralInfoEntity).\n Expected:\n" + tableInfo9 + "\n Found:\n" + tableInfo10);
                }
                HashMap map6 = new HashMap(4);
                map6.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                map6.put("body", new TableInfo.Column("body", "TEXT", true, 0, null, 1));
                map6.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, 1));
                map6.put("status", new TableInfo.Column("status", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo11 = new TableInfo("impressions_count", map6, new HashSet(0), new HashSet(0));
                TableInfo tableInfo12 = TableInfo.read(_db, "impressions_count");
                if (!tableInfo11.equals(tableInfo12)) {
                    return new RoomOpenHelper.ValidationResult(false, "impressions_count(io.split.android.client.storage.db.ImpressionsCountEntity).\n Expected:\n" + tableInfo11 + "\n Found:\n" + tableInfo12);
                }
                HashMap map7 = new HashMap(3);
                map7.put("user_key", new TableInfo.Column("user_key", "TEXT", true, 1, null, 1));
                map7.put(NativeAuthConstants.GrantType.ATTRIBUTES, new TableInfo.Column(NativeAuthConstants.GrantType.ATTRIBUTES, "TEXT", false, 0, null, 1));
                map7.put(IDToken.UPDATED_AT, new TableInfo.Column(IDToken.UPDATED_AT, "INTEGER", true, 0, null, 1));
                TableInfo tableInfo13 = new TableInfo(NativeAuthConstants.GrantType.ATTRIBUTES, map7, new HashSet(0), new HashSet(0));
                TableInfo tableInfo14 = TableInfo.read(_db, NativeAuthConstants.GrantType.ATTRIBUTES);
                if (!tableInfo13.equals(tableInfo14)) {
                    return new RoomOpenHelper.ValidationResult(false, "attributes(io.split.android.client.storage.db.attributes.AttributesEntity).\n Expected:\n" + tableInfo13 + "\n Found:\n" + tableInfo14);
                }
                HashMap map8 = new HashMap(5);
                map8.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                map8.put("user_key", new TableInfo.Column("user_key", "TEXT", true, 0, null, 1));
                map8.put("feature_list", new TableInfo.Column("feature_list", "TEXT", false, 0, null, 1));
                map8.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, 1));
                map8.put("status", new TableInfo.Column("status", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo15 = new TableInfo("unique_keys", map8, new HashSet(0), new HashSet(0));
                TableInfo tableInfo16 = TableInfo.read(_db, "unique_keys");
                if (!tableInfo15.equals(tableInfo16)) {
                    return new RoomOpenHelper.ValidationResult(false, "unique_keys(io.split.android.client.storage.db.impressions.unique.UniqueKeyEntity).\n Expected:\n" + tableInfo15 + "\n Found:\n" + tableInfo16);
                }
                HashMap map9 = new HashMap(3);
                map9.put("hash", new TableInfo.Column("hash", "INTEGER", true, 1, null, 1));
                map9.put("time", new TableInfo.Column("time", "INTEGER", true, 0, null, 1));
                map9.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo17 = new TableInfo("impressions_observer_cache", map9, new HashSet(0), new HashSet(0));
                TableInfo tableInfo18 = TableInfo.read(_db, "impressions_observer_cache");
                if (!tableInfo17.equals(tableInfo18)) {
                    return new RoomOpenHelper.ValidationResult(false, "impressions_observer_cache(io.split.android.client.storage.db.impressions.observer.ImpressionsObserverCacheEntity).\n Expected:\n" + tableInfo17 + "\n Found:\n" + tableInfo18);
                }
                HashMap map10 = new HashMap(3);
                map10.put("user_key", new TableInfo.Column("user_key", "TEXT", true, 1, null, 1));
                map10.put("segment_list", new TableInfo.Column("segment_list", "TEXT", true, 0, null, 1));
                map10.put(IDToken.UPDATED_AT, new TableInfo.Column(IDToken.UPDATED_AT, "INTEGER", true, 0, null, 1));
                TableInfo tableInfo19 = new TableInfo(MyLargeSegmentDao.TABLE_NAME, map10, new HashSet(0), new HashSet(0));
                TableInfo tableInfo20 = TableInfo.read(_db, MyLargeSegmentDao.TABLE_NAME);
                if (!tableInfo19.equals(tableInfo20)) {
                    return new RoomOpenHelper.ValidationResult(false, "my_large_segments(io.split.android.client.storage.db.MyLargeSegmentEntity).\n Expected:\n" + tableInfo19 + "\n Found:\n" + tableInfo20);
                }
                HashMap map11 = new HashMap(3);
                map11.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, 1));
                map11.put("body", new TableInfo.Column("body", "TEXT", false, 0, null, 1));
                map11.put(IDToken.UPDATED_AT, new TableInfo.Column(IDToken.UPDATED_AT, "INTEGER", true, 0, null, 1));
                TableInfo tableInfo21 = new TableInfo("rule_based_segments", map11, new HashSet(0), new HashSet(0));
                TableInfo tableInfo22 = TableInfo.read(_db, "rule_based_segments");
                if (!tableInfo21.equals(tableInfo22)) {
                    return new RoomOpenHelper.ValidationResult(false, "rule_based_segments(io.split.android.client.storage.db.rbs.RuleBasedSegmentEntity).\n Expected:\n" + tableInfo21 + "\n Found:\n" + tableInfo22);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "37a4d008c17ec65f2a6d5ceec22d93c8", "85ca744b88f6363d21687732b748bdd4")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), MySegmentDao.TABLE_NAME, ServiceConstants.DEFAULT_SPLITS_FILENAME, BoxConvertedPushNotificationDevice.EVENTS, "impressions", "general_info", "impressions_count", NativeAuthConstants.GrantType.ATTRIBUTES, "unique_keys", "impressions_observer_cache", MyLargeSegmentDao.TABLE_NAME, "rule_based_segments");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `my_segments`");
            writableDatabase.execSQL("DELETE FROM `splits`");
            writableDatabase.execSQL("DELETE FROM `events`");
            writableDatabase.execSQL("DELETE FROM `impressions`");
            writableDatabase.execSQL("DELETE FROM `general_info`");
            writableDatabase.execSQL("DELETE FROM `impressions_count`");
            writableDatabase.execSQL("DELETE FROM `attributes`");
            writableDatabase.execSQL("DELETE FROM `unique_keys`");
            writableDatabase.execSQL("DELETE FROM `impressions_observer_cache`");
            writableDatabase.execSQL("DELETE FROM `my_large_segments`");
            writableDatabase.execSQL("DELETE FROM `rule_based_segments`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(MySegmentDao.class, MySegmentDao_Impl.getRequiredConverters());
        map.put(MyLargeSegmentDao.class, MyLargeSegmentDao_Impl.getRequiredConverters());
        map.put(SplitDao.class, SplitDao_Impl.getRequiredConverters());
        map.put(EventDao.class, EventDao_Impl.getRequiredConverters());
        map.put(ImpressionDao.class, ImpressionDao_Impl.getRequiredConverters());
        map.put(GeneralInfoDao.class, GeneralInfoDao_Impl.getRequiredConverters());
        map.put(ImpressionsCountDao.class, ImpressionsCountDao_Impl.getRequiredConverters());
        map.put(AttributesDao.class, AttributesDao_Impl.getRequiredConverters());
        map.put(UniqueKeysDao.class, UniqueKeysDao_Impl.getRequiredConverters());
        map.put(ImpressionsObserverCacheDao.class, ImpressionsObserverCacheDao_Impl.getRequiredConverters());
        map.put(RuleBasedSegmentDao.class, RuleBasedSegmentDao_Impl.getRequiredConverters());
        return map;
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
        return Arrays.asList(new Migration[0]);
    }

    @Override // io.split.android.client.storage.db.SplitRoomDatabase
    public MySegmentDao mySegmentDao() {
        MySegmentDao mySegmentDao;
        if (this._mySegmentDao != null) {
            return this._mySegmentDao;
        }
        synchronized (this) {
            if (this._mySegmentDao == null) {
                this._mySegmentDao = new MySegmentDao_Impl(this);
            }
            mySegmentDao = this._mySegmentDao;
        }
        return mySegmentDao;
    }

    @Override // io.split.android.client.storage.db.SplitRoomDatabase
    public MyLargeSegmentDao myLargeSegmentDao() {
        MyLargeSegmentDao myLargeSegmentDao;
        if (this._myLargeSegmentDao != null) {
            return this._myLargeSegmentDao;
        }
        synchronized (this) {
            if (this._myLargeSegmentDao == null) {
                this._myLargeSegmentDao = new MyLargeSegmentDao_Impl(this);
            }
            myLargeSegmentDao = this._myLargeSegmentDao;
        }
        return myLargeSegmentDao;
    }

    @Override // io.split.android.client.storage.db.SplitRoomDatabase
    public SplitDao splitDao() {
        SplitDao splitDao;
        if (this._splitDao != null) {
            return this._splitDao;
        }
        synchronized (this) {
            if (this._splitDao == null) {
                this._splitDao = new SplitDao_Impl(this);
            }
            splitDao = this._splitDao;
        }
        return splitDao;
    }

    @Override // io.split.android.client.storage.db.SplitRoomDatabase
    public EventDao eventDao() {
        EventDao eventDao;
        if (this._eventDao != null) {
            return this._eventDao;
        }
        synchronized (this) {
            if (this._eventDao == null) {
                this._eventDao = new EventDao_Impl(this);
            }
            eventDao = this._eventDao;
        }
        return eventDao;
    }

    @Override // io.split.android.client.storage.db.SplitRoomDatabase
    public ImpressionDao impressionDao() {
        ImpressionDao impressionDao;
        if (this._impressionDao != null) {
            return this._impressionDao;
        }
        synchronized (this) {
            if (this._impressionDao == null) {
                this._impressionDao = new ImpressionDao_Impl(this);
            }
            impressionDao = this._impressionDao;
        }
        return impressionDao;
    }

    @Override // io.split.android.client.storage.db.SplitRoomDatabase
    public GeneralInfoDao generalInfoDao() {
        GeneralInfoDao generalInfoDao;
        if (this._generalInfoDao != null) {
            return this._generalInfoDao;
        }
        synchronized (this) {
            if (this._generalInfoDao == null) {
                this._generalInfoDao = new GeneralInfoDao_Impl(this);
            }
            generalInfoDao = this._generalInfoDao;
        }
        return generalInfoDao;
    }

    @Override // io.split.android.client.storage.db.SplitRoomDatabase
    public ImpressionsCountDao impressionsCountDao() {
        ImpressionsCountDao impressionsCountDao;
        if (this._impressionsCountDao != null) {
            return this._impressionsCountDao;
        }
        synchronized (this) {
            if (this._impressionsCountDao == null) {
                this._impressionsCountDao = new ImpressionsCountDao_Impl(this);
            }
            impressionsCountDao = this._impressionsCountDao;
        }
        return impressionsCountDao;
    }

    @Override // io.split.android.client.storage.db.SplitRoomDatabase
    public AttributesDao attributesDao() {
        AttributesDao attributesDao;
        if (this._attributesDao != null) {
            return this._attributesDao;
        }
        synchronized (this) {
            if (this._attributesDao == null) {
                this._attributesDao = new AttributesDao_Impl(this);
            }
            attributesDao = this._attributesDao;
        }
        return attributesDao;
    }

    @Override // io.split.android.client.storage.db.SplitRoomDatabase
    public UniqueKeysDao uniqueKeysDao() {
        UniqueKeysDao uniqueKeysDao;
        if (this._uniqueKeysDao != null) {
            return this._uniqueKeysDao;
        }
        synchronized (this) {
            if (this._uniqueKeysDao == null) {
                this._uniqueKeysDao = new UniqueKeysDao_Impl(this);
            }
            uniqueKeysDao = this._uniqueKeysDao;
        }
        return uniqueKeysDao;
    }

    @Override // io.split.android.client.storage.db.SplitRoomDatabase
    public ImpressionsObserverCacheDao impressionsObserverCacheDao() {
        ImpressionsObserverCacheDao impressionsObserverCacheDao;
        if (this._impressionsObserverCacheDao != null) {
            return this._impressionsObserverCacheDao;
        }
        synchronized (this) {
            if (this._impressionsObserverCacheDao == null) {
                this._impressionsObserverCacheDao = new ImpressionsObserverCacheDao_Impl(this);
            }
            impressionsObserverCacheDao = this._impressionsObserverCacheDao;
        }
        return impressionsObserverCacheDao;
    }

    @Override // io.split.android.client.storage.db.SplitRoomDatabase
    public RuleBasedSegmentDao ruleBasedSegmentDao() {
        RuleBasedSegmentDao ruleBasedSegmentDao;
        if (this._ruleBasedSegmentDao != null) {
            return this._ruleBasedSegmentDao;
        }
        synchronized (this) {
            if (this._ruleBasedSegmentDao == null) {
                this._ruleBasedSegmentDao = new RuleBasedSegmentDao_Impl(this);
            }
            ruleBasedSegmentDao = this._ruleBasedSegmentDao;
        }
        return ruleBasedSegmentDao;
    }
}
