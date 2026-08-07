package com.box.android.data.mappers.annotation;

import com.box.android.data.api.models.annotations.Location;
import com.box.android.data.mappers.DomainMapper;
import com.box.android.domain.models.annotations.AnnotationLocationModel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocationDomainModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/annotation/LocationDomainModelMapper;", "Lcom/box/android/data/mappers/DomainMapper;", "Lcom/box/android/domain/models/annotations/AnnotationLocationModel;", "Lcom/box/android/data/api/models/annotations/Location;", "<init>", "()V", "toDomain", "dataModel", "fromDomain", "domainModel", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LocationDomainModelMapper implements DomainMapper<AnnotationLocationModel, Location> {
    public static final LocationDomainModelMapper INSTANCE = new LocationDomainModelMapper();

    private LocationDomainModelMapper() {
    }

    @Override // com.box.android.data.mappers.DomainMapper
    public AnnotationLocationModel toDomain(Location dataModel) {
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        if (Intrinsics.areEqual(dataModel.getType(), Location.TYPE_PAGE)) {
            return new AnnotationLocationModel.Page(dataModel.getValue());
        }
        if (Intrinsics.areEqual(dataModel.getType(), "frame")) {
            return new AnnotationLocationModel.Frame(dataModel.getValue());
        }
        return AnnotationLocationModel.None.INSTANCE;
    }

    @Override // com.box.android.data.mappers.DomainMapper
    public Location fromDomain(AnnotationLocationModel domainModel) {
        Intrinsics.checkNotNullParameter(domainModel, "domainModel");
        if (domainModel instanceof AnnotationLocationModel.Page) {
            return new Location(Location.TYPE_PAGE, ((AnnotationLocationModel.Page) domainModel).getPageNumber());
        }
        if (domainModel instanceof AnnotationLocationModel.Frame) {
            return new Location("frame", ((AnnotationLocationModel.Frame) domainModel).getFrameTimestampMs());
        }
        throw new NotImplementedError(null, 1, null);
    }
}
