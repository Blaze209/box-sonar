package com.squareup.sqldelight;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: ColumnAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0002J\u0015\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00028\u00012\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/squareup/sqldelight/ColumnAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "", ExifInterface.LATITUDE_SOUTH, "decode", "databaseValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "encode", "value", "runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface ColumnAdapter<T, S> {
    T decode(S databaseValue);

    S encode(T value);
}
