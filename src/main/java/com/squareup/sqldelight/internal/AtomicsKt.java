package com.squareup.sqldelight.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: Atomics.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a>\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u0012\u0012\u0004\u0012\u0002H\u00010\u0002j\b\u0012\u0004\u0012\u0002H\u0001`\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0086\u0002¢\u0006\u0002\u0010\b\u001a'\u0010\u0000\u001a\u00020\t*\u00060\nj\u0002`\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0080\u0002\u001aF\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u0001*\u0012\u0012\u0004\u0012\u0002H\u00010\u0002j\b\u0012\u0004\u0012\u0002H\u0001`\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u000e\u001a\u0002H\u0001H\u0086\u0002¢\u0006\u0002\u0010\u000f\u001a/\u0010\f\u001a\u00020\r*\u00060\nj\u0002`\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u000e\u001a\u00020\tH\u0080\u0002¨\u0006\u0010"}, d2 = {"getValue", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/squareup/sqldelight/internal/Atomic;", "thisRef", "", "prop", "Lkotlin/reflect/KProperty;", "(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lcom/squareup/sqldelight/internal/AtomicBoolean;", "setValue", "", "value", "(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "runtime"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class AtomicsKt {
    public static final boolean getValue(AtomicBoolean atomicBoolean, Object obj, KProperty<?> prop) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<this>");
        Intrinsics.checkNotNullParameter(prop, "prop");
        return atomicBoolean.get();
    }

    public static final void setValue(AtomicBoolean atomicBoolean, Object obj, KProperty<?> prop, boolean z) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<this>");
        Intrinsics.checkNotNullParameter(prop, "prop");
        atomicBoolean.set(z);
    }

    public static final <T> T getValue(AtomicReference<T> atomicReference, Object obj, KProperty<?> prop) {
        Intrinsics.checkNotNullParameter(atomicReference, "<this>");
        Intrinsics.checkNotNullParameter(prop, "prop");
        return atomicReference.get();
    }

    public static final <T> void setValue(AtomicReference<T> atomicReference, Object obj, KProperty<?> prop, T t) {
        Intrinsics.checkNotNullParameter(atomicReference, "<this>");
        Intrinsics.checkNotNullParameter(prop, "prop");
        atomicReference.set(t);
    }
}
