package com.box.android.data.mappers.observability;

import com.box.android.data.api.models.observability.DiagnosticsMetricsDTO;
import com.box.android.data.mappers.EntityMapper;
import com.box.android.data.persistence.logging.MetricsEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DiagnosticsMetricsEntityDTOMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/observability/DiagnosticsMetricsEntityDTOMapper;", "Lcom/box/android/data/mappers/EntityMapper;", "Lcom/box/android/data/persistence/logging/MetricsEntity;", "Lcom/box/android/data/api/models/observability/DiagnosticsMetricsDTO;", "<init>", "()V", "toEntity", "sourceModel", "fromEntity", "entityModel", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DiagnosticsMetricsEntityDTOMapper implements EntityMapper<MetricsEntity, DiagnosticsMetricsDTO> {
    @Override // com.box.android.data.mappers.EntityMapper
    public MetricsEntity toEntity(DiagnosticsMetricsDTO sourceModel) {
        Intrinsics.checkNotNullParameter(sourceModel, "sourceModel");
        return new MetricsEntity(sourceModel.getCategory(), sourceModel.getEventType(), sourceModel.getUserId(), sourceModel.getUsername(), sourceModel.getEnterpriseId(), sourceModel.getMessage(), sourceModel.getFormattedMessage(), null, sourceModel.getFileName(), sourceModel.getMethodName(), sourceModel.getMethodLine(), sourceModel.getTimestamp(), sourceModel.getAppVersion(), sourceModel.getAppId(), sourceModel.getDeviceModel(), sourceModel.getOsVersion(), sourceModel.getPlatform(), sourceModel.getStatus(), sourceModel.getDuration(), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, null, null, null, -524288, 1048575, null);
    }

    @Override // com.box.android.data.mappers.EntityMapper
    public DiagnosticsMetricsDTO fromEntity(MetricsEntity entityModel) {
        Intrinsics.checkNotNullParameter(entityModel, "entityModel");
        return new DiagnosticsMetricsDTO(entityModel.getEventType(), entityModel.getUserId(), entityModel.getUsername(), entityModel.getEnterpriseId(), entityModel.getTimestamp(), entityModel.getAppVersion(), entityModel.getAppId(), entityModel.getDeviceModel(), entityModel.getOsVersion(), entityModel.getPlatform(), entityModel.getMessage(), entityModel.getFormattedMessage(), entityModel.getFileName(), entityModel.getMethodName(), entityModel.getMethodLine(), entityModel.getStatus(), entityModel.getDuration());
    }
}
