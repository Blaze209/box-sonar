package com.squareup.sqldelight;

import androidx.exifinterface.media.ExifInterface;
import java.lang.Enum;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EnumColumnAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\t\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003B\u0017\b\u0001\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eR\u0018\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/squareup/sqldelight/EnumColumnAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/squareup/sqldelight/ColumnAdapter;", "", "enumValues", "", "([Ljava/lang/Enum;)V", "[Ljava/lang/Enum;", "decode", "databaseValue", "(Ljava/lang/String;)Ljava/lang/Enum;", "encode", "value", "(Ljava/lang/Enum;)Ljava/lang/String;", "runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EnumColumnAdapter<T extends Enum<T>> implements ColumnAdapter<T, String> {
    private final T[] enumValues;

    public EnumColumnAdapter(T[] enumValues) {
        Intrinsics.checkNotNullParameter(enumValues, "enumValues");
        this.enumValues = enumValues;
    }

    @Override // com.squareup.sqldelight.ColumnAdapter
    public T decode(String databaseValue) {
        Intrinsics.checkNotNullParameter(databaseValue, "databaseValue");
        for (T t : this.enumValues) {
            if (Intrinsics.areEqual(t.name(), databaseValue)) {
                return t;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @Override // com.squareup.sqldelight.ColumnAdapter
    public String encode(T value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return value.name();
    }
}
