package com.box.android.cpl;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: Effect.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f\"#\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"cancellationCancellables", "", "", "", "Lkotlin/coroutines/CoroutineContext;", "getCancellationCancellables", "()Ljava/util/Map;", "cancellationLock", "Lkotlinx/coroutines/sync/Mutex;", "toEffect", "Lcom/box/android/cpl/Effect;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "cpl-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class EffectKt {
    private static final Map<Object, Set<CoroutineContext>> cancellationCancellables = new LinkedHashMap();
    private static final Mutex cancellationLock = MutexKt.Mutex$default(false, 1, null);

    public static final Map<Object, Set<CoroutineContext>> getCancellationCancellables() {
        return cancellationCancellables;
    }

    public static final <T> Effect<T> toEffect(Flow<? extends T> flow) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        return new Effect<>((Flow) flow);
    }
}
