package com.box.android.utilities;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: CoroutineExtensions.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0002"}, d2 = {"getChildScope", "Lkotlinx/coroutines/CoroutineScope;", "cpl-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class CoroutineExtensionsKt {
    public static final CoroutineScope getChildScope(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        return CoroutineScopeKt.plus(coroutineScope, SupervisorKt.SupervisorJob((Job) coroutineScope.getCoroutineContext().get(Job.INSTANCE)));
    }
}
