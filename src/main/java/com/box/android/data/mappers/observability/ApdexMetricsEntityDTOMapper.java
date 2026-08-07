package com.box.android.data.mappers.observability;

import com.box.android.data.api.models.observability.ApdexMetricsDTO;
import com.box.android.data.mappers.EntityMapper;
import com.box.android.data.persistence.logging.MetricsCategory;
import com.box.android.data.persistence.logging.MetricsEntity;
import com.box.android.domain.models.observability.ApdexScore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApdexMetricsEntityDTOMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/observability/ApdexMetricsEntityDTOMapper;", "Lcom/box/android/data/mappers/EntityMapper;", "Lcom/box/android/data/persistence/logging/MetricsEntity;", "Lcom/box/android/data/api/models/observability/ApdexMetricsDTO;", "<init>", "()V", "toEntity", "sourceModel", "fromEntity", "entityModel", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ApdexMetricsEntityDTOMapper implements EntityMapper<MetricsEntity, ApdexMetricsDTO> {
    @Override // com.box.android.data.mappers.EntityMapper
    public MetricsEntity toEntity(ApdexMetricsDTO sourceModel) {
        Intrinsics.checkNotNullParameter(sourceModel, "sourceModel");
        MetricsCategory category = sourceModel.getCategory();
        String eventType = sourceModel.getEventType();
        String milestone = sourceModel.getMilestone();
        long j = Long.parseLong(sourceModel.getDuration());
        Boolean failed = sourceModel.getFailed();
        Double secondaryMeasurement = sourceModel.getSecondaryMeasurement();
        ApdexScore apdexScoreFromValue = ApdexScore.INSTANCE.fromValue(sourceModel.getScore());
        Double magnitude = sourceModel.getMagnitude();
        String os = sourceModel.getOs();
        return new MetricsEntity(category, eventType, sourceModel.getUserId(), "", sourceModel.getEnterpriseId(), null, null, null, null, null, null, 0L, sourceModel.getAppVersion(), "", null, sourceModel.getOsVersion(), os, null, Long.valueOf(j), null, 0, null, milestone, null, failed, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, secondaryMeasurement, magnitude, apdexScoreFromValue, null, null, 0L, null, null, null, -21362720, 1034239, null);
    }

    @Override // com.box.android.data.mappers.EntityMapper
    public ApdexMetricsDTO fromEntity(MetricsEntity entityModel) {
        Intrinsics.checkNotNullParameter(entityModel, "entityModel");
        String eventType = entityModel.getEventType();
        String milestone = entityModel.getMilestone();
        String strValueOf = String.valueOf(entityModel.getDuration());
        Double magnitude = entityModel.getMagnitude();
        Boolean failed = entityModel.getFailed();
        Double secondaryMeasurement = entityModel.getSecondaryMeasurement();
        ApdexScore score = entityModel.getScore();
        Double dValueOf = score != null ? Double.valueOf(score.getValue()) : null;
        String platform = entityModel.getPlatform();
        String appVersion = entityModel.getAppVersion();
        String osVersion = entityModel.getOsVersion();
        Intrinsics.checkNotNull(osVersion);
        return new ApdexMetricsDTO(eventType, milestone, strValueOf, magnitude, failed, secondaryMeasurement, dValueOf, platform, appVersion, osVersion, entityModel.getUserId(), entityModel.getEnterpriseId());
    }
}
