package com.box.android.data.mappers;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: EntityMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0005\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00028\u00012\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/mappers/EntityMapper;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "toEntity", "sourceModel", "(Ljava/lang/Object;)Ljava/lang/Object;", "fromEntity", "entityModel", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface EntityMapper<T, V> {
    V fromEntity(T entityModel);

    T toEntity(V sourceModel);
}
