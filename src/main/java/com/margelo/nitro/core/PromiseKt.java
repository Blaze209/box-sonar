package com.margelo.nitro.core;

import com.box.android.domain.metrics.Gen204FileActivityEventLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Promise.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002\u001a\u0010\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002*\u00020\u0004¨\u0006\u0005"}, d2 = {Gen204FileActivityEventLogger.ACTION_RESOLVE, "", "Lcom/margelo/nitro/core/Promise;", "resolved", "Lcom/margelo/nitro/core/Promise$Companion;", "react-native-nitro-modules_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class PromiseKt {
    public static final void resolve(Promise<Unit> promise) {
        Intrinsics.checkNotNullParameter(promise, "<this>");
        promise.resolve(Unit.INSTANCE);
    }

    public static final Promise<Unit> resolved(Promise.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return Promise.INSTANCE.resolved(Unit.INSTANCE);
    }
}
