package io.split.android.client.storage.db;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import io.split.android.client.storage.db.attributes.AttributesDao;
import io.split.android.client.storage.db.impressions.observer.ImpressionsObserverCacheDao;
import io.split.android.client.storage.db.impressions.unique.UniqueKeysDao;
import io.split.android.client.storage.db.rbs.RuleBasedSegmentDao;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SplitRoomDatabase extends RoomDatabase {
    private static volatile Map<String, SplitRoomDatabase> mInstances = new ConcurrentHashMap();
    private volatile SplitQueryDao mSplitQueryDao;

    public abstract AttributesDao attributesDao();

    public abstract EventDao eventDao();

    public abstract GeneralInfoDao generalInfoDao();

    public abstract ImpressionDao impressionDao();

    public abstract ImpressionsCountDao impressionsCountDao();

    public abstract ImpressionsObserverCacheDao impressionsObserverCacheDao();

    public abstract MyLargeSegmentDao myLargeSegmentDao();

    public abstract MySegmentDao mySegmentDao();

    public abstract RuleBasedSegmentDao ruleBasedSegmentDao();

    public abstract SplitDao splitDao();

    public abstract UniqueKeysDao uniqueKeysDao();

    public SplitQueryDao getSplitQueryDao() {
        if (this.mSplitQueryDao == null) {
            synchronized (this) {
                if (this.mSplitQueryDao == null) {
                    this.mSplitQueryDao = new SplitQueryDaoImpl(this);
                }
            }
        }
        return this.mSplitQueryDao;
    }

    public static SplitRoomDatabase getDatabase(final Context context, final String databaseName) {
        SplitRoomDatabase splitRoomDatabase;
        Utils.checkNotNull(context);
        Utils.checkNotNull(databaseName);
        Utils.checkArgument(!databaseName.isEmpty());
        synchronized (SplitRoomDatabase.class) {
            splitRoomDatabase = mInstances.get(databaseName);
            if (splitRoomDatabase == null) {
                splitRoomDatabase = (SplitRoomDatabase) Room.databaseBuilder(context.getApplicationContext(), SplitRoomDatabase.class, databaseName).setJournalMode(RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING).fallbackToDestructiveMigration().build();
                try {
                    SupportSQLiteDatabase writableDatabase = splitRoomDatabase.getOpenHelper().getWritableDatabase();
                    writableDatabase.execSQL("PRAGMA cache_size = -3000");
                    writableDatabase.execSQL("PRAGMA automatic_index = ON");
                    writableDatabase.execSQL("PRAGMA foreign_keys = OFF");
                } catch (Exception unused) {
                    Logger.i("Failed to set optimized pragma");
                }
                mInstances.put(databaseName, splitRoomDatabase);
                try {
                    splitRoomDatabase.getOpenHelper().getWritableDatabase();
                } catch (Exception e) {
                    Logger.i("Failed to force Room initialization: " + e.getMessage());
                }
                new Thread(new Runnable() { // from class: io.split.android.client.storage.db.SplitRoomDatabase$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SplitRoomDatabase.lambda$getDatabase$0(databaseName);
                    }
                }).start();
            }
        }
        return splitRoomDatabase;
    }

    static /* synthetic */ void lambda$getDatabase$0(String str) {
        try {
            mInstances.get(str).getSplitQueryDao();
        } catch (Exception unused) {
            Logger.i("Failed to preload query DAO");
        }
    }
}
