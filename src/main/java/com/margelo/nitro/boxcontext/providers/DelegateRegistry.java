package com.margelo.nitro.boxcontext.providers;

import androidx.exifinterface.media.ExifInterface;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DelegateRegistry.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0002\u0010\rJ\u0015\u0010\f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/margelo/nitro/boxcontext/providers/DelegateRegistry;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "delegates", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/lang/ref/WeakReference;", "register", "", "recipientId", "delegate", "(Ljava/lang/String;Ljava/lang/Object;)V", "(Ljava/lang/String;)Ljava/lang/Object;", "unregister", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DelegateRegistry<T> {
    private final ConcurrentHashMap<String, WeakReference<T>> delegates = new ConcurrentHashMap<>();

    public final void register(String recipientId, T delegate) {
        Intrinsics.checkNotNullParameter(recipientId, "recipientId");
        this.delegates.put(recipientId, new WeakReference<>(delegate));
    }

    public final T delegate(String recipientId) {
        Intrinsics.checkNotNullParameter(recipientId, "recipientId");
        WeakReference<T> weakReference = this.delegates.get(recipientId);
        if (weakReference == null) {
            return null;
        }
        T t = weakReference.get();
        if (t == null) {
            this.delegates.remove(recipientId);
        }
        return t;
    }

    public final void unregister(String recipientId) {
        Intrinsics.checkNotNullParameter(recipientId, "recipientId");
        this.delegates.remove(recipientId);
    }
}
