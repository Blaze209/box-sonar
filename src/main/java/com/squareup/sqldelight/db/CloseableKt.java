package com.squareup.sqldelight.db;

import androidx.exifinterface.media.ExifInterface;
import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Closeable.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aA\u0010\u0000\u001a\u0002H\u0001\"\u0010\b\u0000\u0010\u0002*\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004\"\u0004\b\u0001\u0010\u0001*\u0002H\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0007*\n\u0010\b\"\u00020\u00032\u00020\u0003\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"use", "R", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Closeable;", "Lcom/squareup/sqldelight/db/Closeable;", "body", "Lkotlin/Function1;", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Closeable", "runtime"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class CloseableKt {
    public static final <T extends Closeable, R> R use(T t, Function1<? super T, ? extends R> body) throws IOException {
        Intrinsics.checkNotNullParameter(body, "body");
        try {
            R rInvoke = body.invoke(t);
            kotlin.io.CloseableKt.closeFinally(t, null);
            return rInvoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.io.CloseableKt.closeFinally(t, th);
                throw th2;
            }
        }
    }
}
