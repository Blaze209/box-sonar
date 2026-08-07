package com.box.android.data.mappers.observability;

import com.box.android.data.persistence.logging.MetricsEntity;
import com.box.android.domain.models.observability.ApdexGen204Metric;
import com.box.android.domain.models.observability.AuthEvent;
import com.box.android.domain.models.observability.BoxAiEvent;
import com.box.android.domain.models.observability.BrowsePerformanceEvent;
import com.box.android.domain.models.observability.DownloadJobEvent;
import com.box.android.domain.models.observability.FileActivityEvent;
import com.box.android.domain.models.observability.FolderLoadEvent;
import com.box.android.domain.models.observability.ForceUpdateEvent;
import com.box.android.domain.models.observability.Gen204Event;
import com.box.android.domain.models.observability.HubAssetLoadingEvent;
import com.box.android.domain.models.observability.HubListLoadingEvent;
import com.box.android.domain.models.observability.JobUploadEvent;
import com.box.android.domain.models.observability.LogEvent;
import com.box.android.domain.models.observability.MoveCopyEvent;
import com.box.android.domain.models.observability.MsalEvent;
import com.box.android.domain.models.observability.OfflineEvent;
import com.box.android.domain.models.observability.PerformanceEvent;
import com.box.android.domain.models.observability.PreviewPM23Event;
import com.box.android.domain.models.observability.PreviousVersionPreviewPM23Event;
import com.box.android.domain.models.observability.WatermarkingUpdateEvent;
import com.box.android.domain.models.observability.XPlatformEvent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetricsModelEntityMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/mappers/observability/MetricsModelEntityMapper;", "", "<init>", "()V", "toEntity", "Lcom/box/android/data/persistence/logging/MetricsEntity;", "genericEvent", "Lcom/box/android/domain/models/observability/Gen204Event;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MetricsModelEntityMapper {
    public static final MetricsModelEntityMapper INSTANCE = new MetricsModelEntityMapper();

    private MetricsModelEntityMapper() {
    }

    public final MetricsEntity toEntity(Gen204Event genericEvent) {
        Intrinsics.checkNotNullParameter(genericEvent, "genericEvent");
        if (genericEvent instanceof LogEvent) {
            return LogEventEntityMapper.INSTANCE.toEntity((LogEvent) genericEvent);
        }
        if (genericEvent instanceof PerformanceEvent) {
            return PerformanceEventEntityMapper.INSTANCE.toEntity((PerformanceEvent) genericEvent);
        }
        if (genericEvent instanceof BrowsePerformanceEvent) {
            return BrowsePerformanceEventEntityMapper.INSTANCE.toEntity((BrowsePerformanceEvent) genericEvent);
        }
        if (genericEvent instanceof JobUploadEvent) {
            return JobUploadEventEntityMapper.INSTANCE.toEntity((JobUploadEvent) genericEvent);
        }
        if (genericEvent instanceof MoveCopyEvent) {
            return MoveCopyEventEntityMapper.INSTANCE.toEntity((MoveCopyEvent) genericEvent);
        }
        if (genericEvent instanceof FolderLoadEvent) {
            return FolderLoadEventEntityMapper.INSTANCE.toEntity((FolderLoadEvent) genericEvent);
        }
        if (genericEvent instanceof DownloadJobEvent) {
            return DownloadJobEventEntityMapper.INSTANCE.toEntity((DownloadJobEvent) genericEvent);
        }
        if (genericEvent instanceof FileActivityEvent) {
            return FileActivityEventEntityMapper.INSTANCE.toEntity((FileActivityEvent) genericEvent);
        }
        if (genericEvent instanceof PreviewPM23Event) {
            return PreviewEventEntityMapper.INSTANCE.toMetricsEntity((PreviewPM23Event) genericEvent);
        }
        if (genericEvent instanceof PreviousVersionPreviewPM23Event) {
            return PreviousVersionPreviewEventEntityMapper.INSTANCE.toMetricsEntity((PreviousVersionPreviewPM23Event) genericEvent);
        }
        if (genericEvent instanceof BoxAiEvent) {
            return MetricsModelEntityMapperKt.toMetricsEntity((BoxAiEvent) genericEvent);
        }
        if (genericEvent instanceof ApdexGen204Metric) {
            return MetricsModelEntityMapperKt.toEntity((ApdexGen204Metric) genericEvent);
        }
        if (genericEvent instanceof MsalEvent) {
            return MetricsModelEntityMapperKt.toMetricsEntity((MsalEvent) genericEvent);
        }
        if (genericEvent instanceof HubListLoadingEvent) {
            return MetricsModelEntityMapperKt.toMetricsEntity((HubListLoadingEvent) genericEvent);
        }
        if (genericEvent instanceof HubAssetLoadingEvent) {
            return MetricsModelEntityMapperKt.toMetricsEntity((HubAssetLoadingEvent) genericEvent);
        }
        if (genericEvent instanceof AuthEvent) {
            return MetricsModelEntityMapperKt.toMetricsEntity((AuthEvent) genericEvent);
        }
        if (genericEvent instanceof ForceUpdateEvent) {
            return MetricsModelEntityMapperKt.toMetricsEntity((ForceUpdateEvent) genericEvent);
        }
        if (genericEvent instanceof XPlatformEvent) {
            return MetricsModelEntityMapperKt.toMetricsEntity((XPlatformEvent) genericEvent);
        }
        if (genericEvent instanceof OfflineEvent) {
            return OfflineEventEntityMapper.INSTANCE.toEntity((OfflineEvent) genericEvent);
        }
        if (genericEvent instanceof WatermarkingUpdateEvent) {
            return WatermarkingUpdateEventEntityMapper.INSTANCE.toEntity((WatermarkingUpdateEvent) genericEvent);
        }
        throw new NoWhenBranchMatchedException();
    }
}
