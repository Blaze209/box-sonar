package com.box.android.localrepo;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.box.android.application.BoxBaseApplication;
import com.box.android.coreservices.jobmanager.JobItemJsonEntity;
import com.box.android.coreservices.models.BoxLocalMetadata;
import com.box.android.coreservices.models.BoxPersistableObject;
import com.box.android.coreservices.models.BoxPersistableObjectUtility;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.localrepo.IKeyValueStore;
import com.box.android.domain.models.IBoxPersistableObject;
import com.box.android.usercontext.UserContextComponent;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.models.BoxEvent;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.box.androidsdk.content.utils.SdkUtils;
import com.eclipsesource.json.JsonObject;
import com.google.code.p.leveldb.LevelDB;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes12.dex */
public class LevelDBKeyValueStore extends UserContextComponent implements IKeyValueStore {
    private static final String CORRUPTION_CHECK_KEY = "testkey";
    private static final String CORRUPTION_CHECK_VALUE = "testvalue";
    private static final int MAX_CACHE_SIZE = 10000;
    private LevelDB mDB;
    private String mDbPath;
    private Thread mInsertBufferThread;
    private Thread mPrecacheInsertThread;
    private final LinkedBlockingQueue<String> mInsertBufferQueue = new LinkedBlockingQueue<>();
    private final Map<String, Stringable> mInsertBufferMap = Collections.synchronizedMap(new HashMap());
    private final LinkedBlockingQueue<String> mPrecacheInsertQueue = new LinkedBlockingQueue<>();
    private final Map<String, Object> mCacheMap = Collections.synchronizedMap(new LinkedHashMap<String, Object>(10000, 0.75f, true) { // from class: com.box.android.localrepo.LevelDBKeyValueStore.1
        private static final long serialVersionUID = 1;

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, Object> entry) {
            return size() > 10000;
        }
    });

    private interface Stringable {
        Object rawValue();

        String stringify();
    }

    public LevelDBKeyValueStore(Context context) {
    }

    public static String getDbPath(String str) {
        return BoxBaseApplication.getInstance().getFilesDir() + File.separator + "leveldb" + str;
    }

    @Override // com.box.android.usercontext.UserContextComponent, com.box.android.domain.identity.IUserContextComponent
    public void onCreate(String str) throws IUserContextComponent.UserContextComponentCreationException {
        super.onCreate(str);
        this.mDbPath = getDbPath(getLastKnowContextId());
        startAsyncPutThread();
        startAsyncPrecacheThread();
        initDB();
    }

    @Override // com.box.android.usercontext.UserContextComponent, com.box.android.domain.identity.IUserContextComponent
    public synchronized void onSoftDestroy() {
        clearBuffer();
        clearCache();
        LevelDB levelDB = this.mDB;
        if (levelDB != null) {
            levelDB.close();
        }
        super.onSoftDestroy();
    }

    @Override // com.box.android.domain.localrepo.IKeyValueStore
    public boolean hasDB() {
        return this.mDB != null;
    }

    @Override // com.box.android.usercontext.UserContextComponent, com.box.android.domain.identity.IUserContextComponent
    public synchronized void onHardDestroy() {
        destroy();
        super.onHardDestroy();
    }

    private void initDB() throws IUserContextComponent.UserContextComponentCreationException {
        LevelDB levelDB = new LevelDB(this.mDbPath);
        this.mDB = levelDB;
        levelDB.open();
        this.mDB.put(CORRUPTION_CHECK_KEY, CORRUPTION_CHECK_VALUE);
        if (!CORRUPTION_CHECK_VALUE.equals(this.mDB.get(CORRUPTION_CHECK_KEY))) {
            throw new IUserContextComponent.UserContextComponentCreationException("LevelDB database is corrupt for user " + getLastKnowContextId());
        }
        this.mDB.delete(CORRUPTION_CHECK_KEY);
    }

    @Override // com.box.android.domain.localrepo.IKeyValueStore
    public synchronized String getString(String str) {
        Stringable stringable = this.mInsertBufferMap.get(str);
        if (stringable != null) {
            return stringable.stringify();
        }
        LevelDB levelDB = this.mDB;
        if (levelDB == null) {
            return null;
        }
        return levelDB.get(str);
    }

    @Override // com.box.android.domain.localrepo.IKeyValueStore
    public synchronized boolean getBoolean(String str, boolean z) {
        String string = getString(str);
        if (string == null) {
            return z;
        }
        if (Boolean.toString(true).equals(string)) {
            return true;
        }
        if (Boolean.toString(false).equals(string)) {
            return false;
        }
        return z;
    }

    @Override // com.box.android.domain.localrepo.IKeyValueStore
    public synchronized long getLong(String str, long j) {
        String string = getString(str);
        if (string == null) {
            return j;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    @Override // com.box.android.domain.localrepo.IKeyValueStore
    public synchronized void put(String str, final String str2) {
        try {
            if (str2 == null) {
                delete(str);
            } else {
                put(str, new Stringable() { // from class: com.box.android.localrepo.LevelDBKeyValueStore.2
                    @Override // com.box.android.localrepo.LevelDBKeyValueStore.Stringable
                    public String stringify() {
                        return str2;
                    }

                    @Override // com.box.android.localrepo.LevelDBKeyValueStore.Stringable
                    public Object rawValue() {
                        return str2;
                    }
                });
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void put(String str, Stringable stringable) {
        try {
            if (stringable == null) {
                delete(str);
                return;
            }
            this.mCacheMap.remove(str);
            this.mInsertBufferMap.put(str, stringable);
            this.mInsertBufferQueue.add(str);
            startAsyncPutThread();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.box.android.domain.localrepo.IKeyValueStore
    public synchronized void put(final BoxEntity boxEntity) {
        final String json = boxEntity.toJson();
        put(keyNamer().getKey(boxEntity), new Stringable() { // from class: com.box.android.localrepo.LevelDBKeyValueStore.3
            @Override // com.box.android.localrepo.LevelDBKeyValueStore.Stringable
            public String stringify() {
                return json;
            }

            @Override // com.box.android.localrepo.LevelDBKeyValueStore.Stringable
            public Object rawValue() {
                return boxEntity;
            }
        });
    }

    @Override // com.box.android.domain.localrepo.IKeyValueStore
    public synchronized JsonObject getJsonObject(String str, String str2) {
        return getJsonObject(keyNamer().getBoxObjectKey(str, str2));
    }

    @Override // com.box.android.domain.localrepo.IKeyValueStore
    public synchronized BoxJsonObject getBoxJsonObject(String str, String str2) {
        return getBoxJsonObject(keyNamer().getBoxObjectKey(str, str2));
    }

    @Override // com.box.android.domain.localrepo.IKeyValueStore
    public synchronized JsonObject getJsonObject(String str) {
        String string = getString(str);
        if (string == null) {
            return null;
        }
        return JsonObject.readFrom(string);
    }

    @Override // com.box.android.domain.localrepo.IKeyValueStore
    public synchronized BoxJsonObject getBoxJsonObject(String str) {
        Object obj = this.mCacheMap.get(str);
        if (obj instanceof BoxJsonObject) {
            return (BoxJsonObject) obj;
        }
        Stringable stringable = this.mInsertBufferMap.get(str);
        if (stringable != null && (stringable.rawValue() instanceof BoxJsonObject)) {
            return (BoxJsonObject) stringable.rawValue();
        }
        String string = getString(str);
        if (!SdkUtils.isBlank(string)) {
            BoxEntity boxEntityCreateEntityFromJson = BoxEntity.createEntityFromJson(string);
            this.mCacheMap.put(str, boxEntityCreateEntityFromJson);
            return boxEntityCreateEntityFromJson;
        }
        deleteLocalMetadataForObject(str);
        return null;
    }

    @Override // com.box.android.domain.localrepo.IKeyValueStore
    public synchronized BoxPersistableObject getBoxPersistableObject(String str) {
        Object obj = this.mCacheMap.get(str);
        if (obj instanceof BoxPersistableObject) {
            return (BoxPersistableObject) obj;
        }
        Stringable stringable = this.mInsertBufferMap.get(str);
        if (stringable != null && (stringable.rawValue() instanceof BoxPersistableObject)) {
            return (BoxPersistableObject) stringable.rawValue();
        }
        String string = getString(str);
        if (!SdkUtils.isBlank(string)) {
            BoxPersistableObject boxPersistableObjectCreateEntityFromJson = BoxPersistableObjectUtility.createEntityFromJson(string);
            this.mCacheMap.put(str, boxPersistableObjectCreateEntityFromJson);
            return boxPersistableObjectCreateEntityFromJson;
        }
        deleteLocalMetadataForObject(str);
        return null;
    }

    @Override // com.box.android.domain.localrepo.IKeyValueStore
    public synchronized BoxLocalMetadata getLocalMetadataForObject(String str, String str2) {
        String key = keyNamer().getKey(BoxLocalMetadata.SCHEME, str, str2);
        Object obj = this.mCacheMap.get(key);
        if (obj instanceof String) {
            BoxLocalMetadata boxLocalMetadata = new BoxLocalMetadata();
            boxLocalMetadata.createFromJson((String) obj);
            return boxLocalMetadata;
        }
        Stringable stringable = this.mInsertBufferMap.get(key);
        if (stringable != null && (stringable.rawValue() instanceof BoxLocalMetadata)) {
            return (BoxLocalMetadata) stringable.rawValue();
        }
        String string = getString(key);
        if (StringUtils.isBlank(string)) {
            return null;
        }
        BoxLocalMetadata boxLocalMetadata2 = new BoxLocalMetadata();
        boxLocalMetadata2.createFromJson(string);
        return boxLocalMetadata2;
    }

    @Override // com.box.android.domain.localrepo.IKeyValueStore
    public synchronized void saveLocalMetadata(IBoxPersistableObject iBoxPersistableObject) throws BoxException {
        if (iBoxPersistableObject instanceof BoxLocalMetadata) {
            String keyNamerKey = ((BoxLocalMetadata) iBoxPersistableObject).getKeyNamerKey(keyNamer());
            this.mCacheMap.remove(keyNamerKey);
            put(keyNamerKey, iBoxPersistableObject.toJson());
        }
    }

    private synchronized void deleteLocalMetadataForObject(String str) {
        this.mInsertBufferMap.remove(str);
        this.mCacheMap.remove(str);
        this.mDB.delete(str);
    }

    @Override // com.box.android.domain.localrepo.IKeyValueStore
    public synchronized <T> T getBoxObject(String str, String str2, String str3, Class<T> cls) {
        String key = keyNamer().getKey(str3, str, str2);
        Stringable stringable = this.mInsertBufferMap.get(key);
        if (stringable != null && cls.isInstance(stringable)) {
            T t = (T) stringable.rawValue();
            if (JobItemJsonEntity.SCHEME.equals(str3)) {
                Log.i("LevelDB", "getBoxObject1 with key = " + key + " and value = " + stringable);
            }
            return t;
        }
        String string = getString(key);
        if (!StringUtils.isBlank(string)) {
            T t2 = (T) BoxEntity.createEntityFromJson(string);
            if (JobItemJsonEntity.SCHEME.equals(str3)) {
                Log.i("LevelDB", "getBoxObject2 with key = " + key + " and value = " + string);
            }
            return t2;
        }
        if (JobItemJsonEntity.SCHEME.equals(str3)) {
            Log.i("LevelDB", "getBoxObject3 with key = " + key + " and value = null");
        }
        return null;
    }

    @Override // com.box.android.domain.localrepo.IKeyValueStore
    public void clearAllByScheme(String str) {
        this.mDB.clear(str);
    }

    @Override // com.box.android.domain.localrepo.IKeyValueStore
    public synchronized void put(String str, boolean z) {
        put(str, String.valueOf(z));
    }

    @Override // com.box.android.domain.localrepo.IKeyValueStore
    public synchronized void put(String str, long j) {
        put(str, String.valueOf(j));
    }

    @Override // com.box.android.domain.localrepo.IKeyValueStore
    public synchronized void delete(String str) {
        this.mInsertBufferMap.remove(str);
        this.mCacheMap.remove(str);
        this.mDB.delete(str);
    }

    @Override // com.box.android.domain.localrepo.IKeyValueStore
    public synchronized void clear() {
        this.mInsertBufferMap.clear();
        this.mCacheMap.clear();
        Thread thread = this.mInsertBufferThread;
        if (thread != null) {
            thread.interrupt();
        }
        Thread thread2 = this.mPrecacheInsertThread;
        if (thread2 != null) {
            thread2.interrupt();
        }
        this.mDB.clear();
    }

    @Override // com.box.android.domain.localrepo.IKeyValueStore
    public synchronized void destroy() {
        clearBuffer();
        clearCache();
        LevelDB levelDB = this.mDB;
        if (levelDB != null) {
            levelDB.close();
            this.mDB.destroy();
        }
        if (this.mDbPath != null) {
            FileUtils.deleteQuietly(new File(this.mDbPath));
        }
    }

    private synchronized void clearBuffer() {
        this.mInsertBufferQueue.clear();
        this.mInsertBufferMap.clear();
        Thread thread = this.mInsertBufferThread;
        if (thread != null) {
            thread.interrupt();
            this.mInsertBufferThread = null;
        }
    }

    private synchronized void clearCache() {
        this.mPrecacheInsertQueue.clear();
        this.mCacheMap.clear();
        Thread thread = this.mPrecacheInsertThread;
        if (thread != null) {
            thread.interrupt();
            this.mPrecacheInsertThread = null;
        }
    }

    private synchronized void startAsyncPutThread() {
        Thread thread = this.mInsertBufferThread;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread() { // from class: com.box.android.localrepo.LevelDBKeyValueStore.4
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted()) {
                        try {
                            String str = (String) LevelDBKeyValueStore.this.mInsertBufferQueue.poll(60L, TimeUnit.SECONDS);
                            synchronized (LevelDBKeyValueStore.this) {
                                if (str == null) {
                                    try {
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                } else {
                                    if (isInterrupted()) {
                                        return;
                                    }
                                    Stringable stringable = (Stringable) LevelDBKeyValueStore.this.mInsertBufferMap.get(str);
                                    if (stringable != null && LevelDBKeyValueStore.this.mDB != null) {
                                        LevelDBKeyValueStore.this.mDB.put(str, stringable.stringify());
                                        LevelDBKeyValueStore.this.mCacheMap.put(str, stringable.rawValue());
                                        LevelDBKeyValueStore.this.mDB.get(str);
                                    }
                                    LevelDBKeyValueStore.this.mInsertBufferMap.remove(str);
                                }
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                }
            };
            this.mInsertBufferThread = thread2;
            thread2.start();
        }
    }

    private synchronized void startAsyncPrecacheThread() {
        Thread thread = this.mPrecacheInsertThread;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread() { // from class: com.box.android.localrepo.LevelDBKeyValueStore.5
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted()) {
                        try {
                            String str = (String) LevelDBKeyValueStore.this.mPrecacheInsertQueue.poll(60L, TimeUnit.SECONDS);
                            synchronized (LevelDBKeyValueStore.this) {
                                if (str == null) {
                                    try {
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                } else {
                                    if (isInterrupted()) {
                                        return;
                                    }
                                    String type = LevelDBKeyValueStore.this.keyNamer().getType(str);
                                    String id = LevelDBKeyValueStore.this.keyNamer().getId(str);
                                    LevelDBKeyValueStore.this.mCacheMap.put(str, LevelDBKeyValueStore.this.getBoxJsonObject(type, id));
                                    LevelDBKeyValueStore.this.mCacheMap.put(LevelDBKeyValueStore.this.keyNamer().getKey(BoxLocalMetadata.SCHEME, type, id), LevelDBKeyValueStore.this.getLocalMetadataForObject(type, id));
                                }
                            }
                        } catch (IllegalMonitorStateException unused) {
                            return;
                        } catch (InterruptedException unused2) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                }
            };
            this.mPrecacheInsertThread = thread2;
            thread2.start();
        }
    }

    @Override // com.box.android.domain.localrepo.IKeyValueStore
    public synchronized void precacheTypedIds(List<String> list) {
        this.mPrecacheInsertQueue.addAll(list);
    }

    @Override // com.box.android.domain.localrepo.IKeyValueStore
    public KeyNamer keyNamer() {
        return new KeyNamer();
    }

    public static class KeyNamer implements IKeyValueStore.KeyNamer {
        private static final String BOX_ITEM_SCHEME = "boxitem";
        private static final String LOCAL_ITEM_SCHEME = "localitem";
        private static final String PATH_SEP = "/";
        private static final String SCHEME_SEP = "://";

        @Override // com.box.android.domain.localrepo.IKeyValueStore.KeyNamer
        public String getKey(BoxEntity boxEntity) {
            String userId = boxEntity.getUserId();
            if (boxEntity instanceof BoxEvent) {
                userId = ((BoxEvent) boxEntity).getEventId();
            }
            return getBoxObjectKey(boxEntity.getType(), userId);
        }

        @Override // com.box.android.domain.localrepo.IKeyValueStore.KeyNamer
        public String getBoxObjectKey(String str, String str2) {
            return getKey("boxitem", str, str2);
        }

        @Override // com.box.android.domain.localrepo.IKeyValueStore.KeyNamer
        public String getKey(String str, String str2, String str3) {
            return str + SCHEME_SEP + str2 + "/" + str3;
        }

        @Override // com.box.android.domain.localrepo.IKeyValueStore.KeyNamer
        public boolean isBoxItem(String str) {
            return "boxitem".equals(Uri.parse(str).getScheme());
        }

        @Override // com.box.android.domain.localrepo.IKeyValueStore.KeyNamer
        public String getLocalKey(String str, String str2) {
            return getKey(LOCAL_ITEM_SCHEME, str, str2);
        }

        @Override // com.box.android.domain.localrepo.IKeyValueStore.KeyNamer
        public boolean isLocalItem(String str) {
            return LOCAL_ITEM_SCHEME.equals(Uri.parse(str).getScheme());
        }

        @Override // com.box.android.domain.localrepo.IKeyValueStore.KeyNamer
        public String getType(String str) {
            return str.substring(str.indexOf(47) + 2, str.lastIndexOf(47));
        }

        @Override // com.box.android.domain.localrepo.IKeyValueStore.KeyNamer
        public String getId(String str) {
            return str.substring(str.lastIndexOf(47) + 1);
        }
    }
}
