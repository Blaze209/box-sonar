package com.apollographql.apollo3.mpp;

import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0006\u0010\b\u001a\u00020\t\u001a\u0006\u0010\n\u001a\u00020\t\u001a\u0006\u0010\u000b\u001a\u00020\t\u001a\u0006\u0010\f\u001a\u00020\r\u001a\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u0006\u0010\u0014\u001a\u00020\u0015\"\u001b\u0010\u0000\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0016"}, d2 = {"simpleDateFormat", "Ljava/text/SimpleDateFormat;", "getSimpleDateFormat", "()Ljava/text/SimpleDateFormat;", "simpleDateFormat$delegate", "Lkotlin/Lazy;", "assertMainThreadOnNative", "", "currentThreadId", "", "currentThreadName", "currentTimeFormatted", "currentTimeMillis", "", "ensureNeverFrozen", "obj", "", "freeze", "isFrozen", "", "platform", "Lcom/apollographql/apollo3/mpp/Platform;", "apollo-mpp-utils"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class UtilsKt {
    private static final Lazy simpleDateFormat$delegate = LazyKt.lazy(new Function0<SimpleDateFormat>() { // from class: com.apollographql.apollo3.mpp.UtilsKt$simpleDateFormat$2
        @Override // kotlin.jvm.functions.Function0
        public final SimpleDateFormat invoke() {
            return new SimpleDateFormat("HH:mm:ss.SSS", Locale.ROOT);
        }
    });

    public static final void assertMainThreadOnNative() {
    }

    public static final void ensureNeverFrozen(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
    }

    public static final void freeze(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
    }

    public static final boolean isFrozen(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        return false;
    }

    public static final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    private static final SimpleDateFormat getSimpleDateFormat() {
        return (SimpleDateFormat) simpleDateFormat$delegate.getValue();
    }

    public static final String currentTimeFormatted() {
        String str = getSimpleDateFormat().format(Long.valueOf(currentTimeMillis()));
        Intrinsics.checkNotNullExpressionValue(str, "simpleDateFormat.format(currentTimeMillis())");
        return str;
    }

    public static final String currentThreadId() {
        return String.valueOf(Thread.currentThread().getId());
    }

    public static final String currentThreadName() {
        String name = Thread.currentThread().getName();
        Intrinsics.checkNotNullExpressionValue(name, "currentThread().name");
        return name;
    }

    public static final Platform platform() {
        return Platform.Jvm;
    }
}
