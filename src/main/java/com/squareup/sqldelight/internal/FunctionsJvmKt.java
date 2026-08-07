package com.squareup.sqldelight.internal;

import androidx.exifinterface.media.ExifInterface;
import com.squareup.sqldelight.Query;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FunctionsJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\u001a\u0019\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003H\u0001¢\u0006\u0002\b\u0004\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000\u001a)\u0010\u0007\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00030\nH\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"copyOnWriteList", "", "Lcom/squareup/sqldelight/Query;", ExifInterface.GPS_DIRECTION_TRUE, "copyOnWriteListGeneric", "currentThreadId", "", "withLock", "Lcom/squareup/sqldelight/internal/QueryLock;", "block", "Lkotlin/Function0;", "(Lcom/squareup/sqldelight/internal/QueryLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "runtime"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class FunctionsJvmKt {
    public static final List<Query<?>> copyOnWriteList() {
        return new CopyOnWriteArrayList();
    }

    public static final <T> List<T> copyOnWriteListGeneric() {
        return new CopyOnWriteArrayList();
    }

    public static final <T> T withLock(QueryLock queryLock, Function0<? extends T> block) {
        T tInvoke;
        Intrinsics.checkNotNullParameter(queryLock, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        synchronized (queryLock) {
            tInvoke = block.invoke();
        }
        return tInvoke;
    }

    public static final long currentThreadId() {
        return Thread.currentThread().getId();
    }
}
