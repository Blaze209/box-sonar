package com.box.android.data;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JobCancellationHelper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006J\u001a\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u000f\u001a\u00020\tJ\u0012\u0010\u0010\u001a\u00020\t2\n\u0010\u000e\u001a\u00060\u0006j\u0002`\u0007R$\u0010\u0004\u001a\u0018\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/JobCancellationHelper;", "", "<init>", "()V", "mapper", "Ljava/util/concurrent/ConcurrentMap;", "", "Lcom/box/android/data/Key;", "Ljava/lang/ref/WeakReference;", "Lkotlin/coroutines/CoroutineContext;", "createFetchFolderKey", "folderId", "bindCoroutineContext", "", "key", "coroutineContext", "getCoroutineContext", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JobCancellationHelper {
    public static final JobCancellationHelper INSTANCE = new JobCancellationHelper();
    private static final ConcurrentMap<String, WeakReference<CoroutineContext>> mapper = new ConcurrentHashMap();

    private JobCancellationHelper() {
    }

    public final String createFetchFolderKey(String folderId) {
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        return "GetFolderItems:" + folderId;
    }

    public final void bindCoroutineContext(String key, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        mapper.put(key, new WeakReference<>(coroutineContext));
    }

    public final CoroutineContext getCoroutineContext(String key) {
        CoroutineContext coroutineContext;
        Intrinsics.checkNotNullParameter(key, "key");
        WeakReference<CoroutineContext> weakReference = mapper.get(key);
        return (weakReference == null || (coroutineContext = weakReference.get()) == null) ? EmptyCoroutineContext.INSTANCE : coroutineContext;
    }
}
