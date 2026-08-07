package org.tinylog.kotlin;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.tinylog.Supplier;

/* JADX INFO: compiled from: SupplierUtils.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a/\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0005\"\u0004\b\u0000\u0010\u0002*\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"asSupplier", "Lorg/tinylog/Supplier;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "asSuppliers", "", "([Lkotlin/jvm/functions/Function0;)[Lorg/tinylog/Supplier;", "tinylog-api-kotlin"}, k = 2, mv = {1, 1, 18})
public final class SupplierUtilsKt {
    public static final <T> Supplier<T> asSupplier(final Function0<? extends T> asSupplier) {
        Intrinsics.checkParameterIsNotNull(asSupplier, "$this$asSupplier");
        return new Supplier() { // from class: org.tinylog.kotlin.SupplierUtilsKt.asSupplier.1
            @Override // org.tinylog.Supplier
            public final T get() {
                return (T) asSupplier.invoke();
            }
        };
    }

    public static final <T> Supplier<T>[] asSuppliers(Function0<? extends T>[] asSuppliers) {
        Intrinsics.checkParameterIsNotNull(asSuppliers, "$this$asSuppliers");
        ArrayList arrayList = new ArrayList(asSuppliers.length);
        for (Function0<? extends T> function0 : asSuppliers) {
            arrayList.add(asSupplier(function0));
        }
        Object[] array = arrayList.toArray(new Supplier[0]);
        if (array != null) {
            return (Supplier[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
