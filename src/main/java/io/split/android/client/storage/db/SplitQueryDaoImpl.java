package io.split.android.client.storage.db;

import android.database.Cursor;
import android.os.Process;
import io.split.android.client.utils.logger.Logger;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class SplitQueryDaoImpl implements SplitQueryDao {
    private volatile Map<String, SplitEntity> mCachedSplitsMap;
    private final SplitRoomDatabase mDatabase;
    private final Thread mInitializationThread;
    private final Object mLock = new Object();
    private boolean mIsInitialized = false;
    private boolean mIsInvalidated = false;

    public SplitQueryDaoImpl(SplitRoomDatabase mDatabase) {
        this.mDatabase = mDatabase;
        Thread thread = new Thread(new Runnable() { // from class: io.split.android.client.storage.db.SplitQueryDaoImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m14775x83e51146();
            }
        });
        this.mInitializationThread = thread;
        thread.setName("SplitMapPrefill");
        thread.start();
    }

    /* JADX INFO: renamed from: lambda$new$0$io-split-android-client-storage-db-SplitQueryDaoImpl, reason: not valid java name */
    /* synthetic */ void m14775x83e51146() {
        try {
            Process.setThreadPriority(-19);
        } catch (Exception unused) {
        }
        Map<String, SplitEntity> mapLoadSplitsMap = loadSplitsMap();
        synchronized (this.mLock) {
            this.mCachedSplitsMap = mapLoadSplitsMap;
            this.mIsInitialized = true;
            this.mLock.notifyAll();
        }
    }

    int getColumnIndexOrThrow(Cursor c, String name) {
        int columnIndex = c.getColumnIndex(name);
        return columnIndex >= 0 ? columnIndex : c.getColumnIndexOrThrow("`" + name + "`");
    }

    @Override // io.split.android.client.storage.db.SplitQueryDao
    public Map<String, SplitEntity> getAllAsMap() {
        if (isValid() && !this.mCachedSplitsMap.isEmpty()) {
            return new HashMap(this.mCachedSplitsMap);
        }
        synchronized (this.mLock) {
            if (isValid() && !this.mCachedSplitsMap.isEmpty()) {
                return new HashMap(this.mCachedSplitsMap);
            }
            Thread thread = this.mInitializationThread;
            if (thread != null && thread.isAlive()) {
                try {
                    this.mLock.wait(5000L);
                    if (isValid()) {
                        return new HashMap(this.mCachedSplitsMap);
                    }
                } catch (InterruptedException unused) {
                }
            }
            Map<String, SplitEntity> mapLoadSplitsMap = loadSplitsMap();
            this.mCachedSplitsMap = mapLoadSplitsMap;
            this.mIsInitialized = true;
            return new HashMap(mapLoadSplitsMap);
        }
    }

    private boolean isValid() {
        return this.mIsInitialized && !this.mIsInvalidated;
    }

    @Override // io.split.android.client.storage.db.SplitQueryDao
    public void invalidate() {
        synchronized (this.mLock) {
            if (this.mCachedSplitsMap != null) {
                this.mCachedSplitsMap.clear();
            }
            this.mIsInvalidated = true;
            this.mLock.notifyAll();
            Logger.i("Invalidated preloaded flags");
        }
    }

    private Map<String, SplitEntity> loadSplitsMap() {
        int i;
        Cursor cursorQuery = this.mDatabase.query("SELECT name, body FROM splits", (Object[]) null);
        HashMap map = new HashMap(2000);
        try {
            int columnIndexOrThrow = getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow2 = getColumnIndexOrThrow(cursorQuery, "body");
            String[] strArr = new String[100];
            String[] strArr2 = new String[100];
            while (true) {
                i = 0;
                do {
                    if (!cursorQuery.moveToNext()) {
                        break;
                    }
                    strArr[i] = cursorQuery.getString(columnIndexOrThrow);
                    strArr2[i] = cursorQuery.getString(columnIndexOrThrow2);
                    i++;
                } while (i != 100);
                for (int i2 = 0; i2 < 100; i2++) {
                    SplitEntity splitEntity = new SplitEntity();
                    splitEntity.setName(strArr[i2]);
                    splitEntity.setBody(strArr2[i2]);
                    map.put(strArr[i2], splitEntity);
                }
            }
            for (int i3 = 0; i3 < i; i3++) {
                SplitEntity splitEntity2 = new SplitEntity();
                splitEntity2.setName(strArr[i3]);
                splitEntity2.setBody(strArr2[i3]);
                map.put(strArr[i3], splitEntity2);
            }
            return map;
        } catch (Exception e) {
            Logger.e("Error executing loadSplitsMap query: " + e.getLocalizedMessage());
            return map;
        } finally {
            cursorQuery.close();
        }
    }
}
