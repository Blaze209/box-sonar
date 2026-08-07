package com.microsoft.identity.common.migration;

import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.util.TaskCompletedCallback;
import com.microsoft.identity.common.logging.Logger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes14.dex */
public class DefaultMultiTypeNameValueStorageReencrypter implements IMultiTypeNameValueStorageReencrypter {
    private static final String TAG = "DefaultMultiTypeNameValueStorageReencrypter";
    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    private interface Callable<T> {
        void call(T t) throws Exception;
    }

    @Override // com.microsoft.identity.common.migration.IMultiTypeNameValueStorageReencrypter
    public IMigrationOperationResult reencrypt(INameValueStorage<String> iNameValueStorage, final IMultiTypeNameValueStorageReencrypter.IStringEncrypter iStringEncrypter, final IMultiTypeNameValueStorageReencrypter.IStringDecrypter iStringDecrypter, IMultiTypeNameValueStorageReencrypter.ReencryptionParams reencryptionParams) {
        String str = TAG + ":reencrypt";
        HashMap map = new HashMap(iNameValueStorage.getAll());
        Logger.verbose(str, "Attempting to migrate cache entries: " + map.size());
        MigrationOperationResult migrationOperationResult = new MigrationOperationResult();
        migrationOperationResult.setCountOfTotalRecords(map.size());
        HashSet hashSet = new HashSet();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        HashSet hashSet2 = new HashSet();
        applyCacheMutation(map, new Callable<Map.Entry<String, String>>() { // from class: com.microsoft.identity.common.migration.DefaultMultiTypeNameValueStorageReencrypter.1
            @Override // com.microsoft.identity.common.migration.DefaultMultiTypeNameValueStorageReencrypter.Callable
            public void call(Map.Entry<String, String> entry) throws Exception {
                entry.setValue(iStringDecrypter.decrypt(entry.getValue()));
            }
        }, migrationOperationResult, reencryptionParams, hashSet, hashSet2, atomicBoolean);
        clearEntriesMarkedForRemoval(iNameValueStorage, map, hashSet);
        if (atomicBoolean.get()) {
            Logger.info(str, "Aborting after decrypt.");
            return migrationOperationResult;
        }
        applyCacheMutation(map, new Callable<Map.Entry<String, String>>() { // from class: com.microsoft.identity.common.migration.DefaultMultiTypeNameValueStorageReencrypter.2
            @Override // com.microsoft.identity.common.migration.DefaultMultiTypeNameValueStorageReencrypter.Callable
            public void call(Map.Entry<String, String> entry) throws Exception {
                entry.setValue(iStringEncrypter.encrypt(entry.getValue()));
            }
        }, migrationOperationResult, reencryptionParams, hashSet, hashSet2, atomicBoolean);
        clearEntriesMarkedForRemoval(iNameValueStorage, map, hashSet);
        if (atomicBoolean.get()) {
            Logger.info(str, "Aborting after reencrypt.");
            return migrationOperationResult;
        }
        Logger.info(str, "Writing reencrypted cache entries.");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            iNameValueStorage.put(entry.getKey(), entry.getValue());
        }
        return migrationOperationResult;
    }

    private void applyCacheMutation(Map<String, String> map, Callable<Map.Entry<String, String>> callable, MigrationOperationResult migrationOperationResult, IMultiTypeNameValueStorageReencrypter.ReencryptionParams reencryptionParams, Set<String> set, Set<String> set2, AtomicBoolean atomicBoolean) {
        String str = TAG + ":applyCacheMutation";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                if (set2.contains(entry.getKey())) {
                    Logger.warn(str, "Skipping entry.");
                } else {
                    callable.call(entry);
                }
            } catch (Exception e) {
                Logger.error(str, "Error during mutation", e);
                Logger.errorPII(str, "Failed key: " + entry.getKey(), e);
                migrationOperationResult.addFailure(e);
                set2.add(entry.getKey());
                if (reencryptionParams.eraseEntryOnError()) {
                    Logger.warn(str, "Marking key for removal.");
                    set.add(entry.getKey());
                }
                if (reencryptionParams.eraseAllOnError()) {
                    Logger.warn(str, "Marking all keys for removal.");
                    set.addAll(map.keySet());
                    atomicBoolean.set(true);
                    return;
                } else if (reencryptionParams.abortOnError()) {
                    atomicBoolean.set(true);
                    return;
                }
            }
        }
    }

    private void clearEntriesMarkedForRemoval(INameValueStorage<String> iNameValueStorage, Map<String, String> map, Set<String> set) {
        Logger.warn(TAG + ":clearEntriesMarkedForRemoval", "Removing entries marked for removal");
        for (String str : set) {
            map.remove(str);
            iNameValueStorage.remove(str);
        }
    }

    @Override // com.microsoft.identity.common.migration.IMultiTypeNameValueStorageReencrypter
    public void reencryptAsync(final INameValueStorage<String> iNameValueStorage, final IMultiTypeNameValueStorageReencrypter.IStringEncrypter iStringEncrypter, final IMultiTypeNameValueStorageReencrypter.IStringDecrypter iStringDecrypter, final IMultiTypeNameValueStorageReencrypter.ReencryptionParams reencryptionParams, final TaskCompletedCallback<IMigrationOperationResult> taskCompletedCallback) {
        executor.execute(new Runnable() { // from class: com.microsoft.identity.common.migration.DefaultMultiTypeNameValueStorageReencrypter.3
            @Override // java.lang.Runnable
            public void run() {
                taskCompletedCallback.onTaskCompleted(DefaultMultiTypeNameValueStorageReencrypter.this.reencrypt(iNameValueStorage, iStringEncrypter, iStringDecrypter, reencryptionParams));
            }
        });
    }
}
