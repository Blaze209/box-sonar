package com.box.android.data.mappers;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;

/* JADX INFO: compiled from: DomainMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004J\u0017\u0010\u0005\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0006\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u00028\u00012\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0002\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/mappers/DomainMapper;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/box/android/domain/models/DomainModel;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "toDomain", "dataModel", "(Ljava/lang/Object;)Lcom/box/android/domain/models/DomainModel;", "fromDomain", "domainModel", "(Lcom/box/android/domain/models/DomainModel;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DomainMapper<T extends DomainModel, V> {
    V fromDomain(T domainModel);

    T toDomain(V dataModel);
}
