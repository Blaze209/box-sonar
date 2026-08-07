package com.box.android.data.mappers.observability;

import com.box.android.data.api.models.observability.ActionsMetricsDTO;
import com.box.android.data.mappers.EntityMapper;
import com.box.android.data.persistence.logging.MetricsCategory;
import com.box.android.data.persistence.logging.MetricsEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActionsMetricsEntityDTOMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/observability/ActionsMetricsEntityDTOMapper;", "Lcom/box/android/data/mappers/EntityMapper;", "Lcom/box/android/data/persistence/logging/MetricsEntity;", "Lcom/box/android/data/api/models/observability/ActionsMetricsDTO;", "<init>", "()V", "toEntity", "sourceModel", "fromEntity", "entityModel", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ActionsMetricsEntityDTOMapper implements EntityMapper<MetricsEntity, ActionsMetricsDTO> {
    @Override // com.box.android.data.mappers.EntityMapper
    public MetricsEntity toEntity(ActionsMetricsDTO sourceModel) {
        Intrinsics.checkNotNullParameter(sourceModel, "sourceModel");
        String fileId = sourceModel.getFileId();
        String folderId = sourceModel.getFolderId();
        Integer numItems = sourceModel.getNumItems();
        MetricsCategory category = sourceModel.getCategory();
        String eventType = sourceModel.getEventType();
        String userId = sourceModel.getUserId();
        String username = sourceModel.getUsername();
        String enterpriseId = sourceModel.getEnterpriseId();
        long timestamp = sourceModel.getTimestamp();
        String appVersion = sourceModel.getAppVersion();
        String appId = sourceModel.getAppId();
        int count = sourceModel.getCount();
        String deviceModel = sourceModel.getDeviceModel();
        String osVersion = sourceModel.getOsVersion();
        String platform = sourceModel.getPlatform();
        String type = sourceModel.getType();
        String subtype = sourceModel.getSubtype();
        Boolean failed = sourceModel.getFailed();
        String value = sourceModel.getValue();
        String completionStatusString = sourceModel.getCompletionStatusString();
        String failReason = sourceModel.getFailReason();
        Integer errorCode = sourceModel.getErrorCode();
        String message = sourceModel.getMessage();
        Double sizekB = sourceModel.getSizekB();
        String sizeBucket = sourceModel.getSizeBucket();
        Long duration = sourceModel.getDuration();
        return new MetricsEntity(category, eventType, userId, username, enterpriseId, message, null, fileId, null, null, null, timestamp, appVersion, appId, deviceModel, osVersion, platform, sourceModel.getStatus(), duration, numItems, count, type, null, subtype, failed, value, sourceModel.isRecoverable(), sourceModel.getJobManagerVersion(), sourceModel.getNumberAutomaticOfRetries(), sourceModel.getNumberOfManualRetries(), completionStatusString, failReason, errorCode, sizekB, sizeBucket, folderId, sourceModel.getTestJob(), sourceModel.getTestCode(), sourceModel.getTimeToStart(), sourceModel.getRate(), sourceModel.getTotalTime(), sourceModel.getBytesUploaded(), sourceModel.getNumOfParallelChunks(), null, null, null, sourceModel.isNewVersionUpload(), sourceModel.isUserTriggeredJob(), 0L, null, sourceModel.getSourceTab(), sourceModel.getUiSource(), 4196160, 210944, null);
    }

    @Override // com.box.android.data.mappers.EntityMapper
    public ActionsMetricsDTO fromEntity(MetricsEntity entityModel) {
        Intrinsics.checkNotNullParameter(entityModel, "entityModel");
        String fileId = entityModel.getFileId();
        String folderId = entityModel.getFolderId();
        String eventType = entityModel.getEventType();
        String userId = entityModel.getUserId();
        String username = entityModel.getUsername();
        String enterpriseId = entityModel.getEnterpriseId();
        long timestamp = entityModel.getTimestamp();
        String appVersion = entityModel.getAppVersion();
        String appId = entityModel.getAppId();
        int count = entityModel.getCount();
        String deviceModel = entityModel.getDeviceModel();
        String osVersion = entityModel.getOsVersion();
        String platform = entityModel.getPlatform();
        String type = entityModel.getType();
        String subtype = entityModel.getSubtype();
        Boolean failed = entityModel.getFailed();
        String value = entityModel.getValue();
        String completionStatusString = entityModel.getCompletionStatusString();
        String failReason = entityModel.getFailReason();
        Integer errorCode = entityModel.getErrorCode();
        String message = entityModel.getMessage();
        Double sizeKB = entityModel.getSizeKB();
        String sizeBucket = entityModel.getSizeBucket();
        Long duration = entityModel.getDuration();
        String status = entityModel.getStatus();
        String testJobName = entityModel.getTestJobName();
        String testName = entityModel.getTestName();
        return new ActionsMetricsDTO(fileId, folderId, eventType, entityModel.getNumItems(), userId, username, enterpriseId, timestamp, appVersion, appId, count, deviceModel, osVersion, platform, type, subtype, failed, value, completionStatusString, failReason, errorCode, message, sizeBucket, sizeKB, duration, status, entityModel.isRecoverable(), entityModel.getJobManagerVersion(), entityModel.getNumberOfAutomaticRetries(), entityModel.getNumberOfManualRetries(), entityModel.getTimeToStart(), entityModel.getRate(), entityModel.getTotalTime(), entityModel.getBytesUploaded(), entityModel.getNumOfParallelChunks(), testJobName, testName, entityModel.isNewVersionUpload(), entityModel.isUserTriggeredJob(), entityModel.getItemState(), entityModel.getSourceTab(), entityModel.getUiSource());
    }
}
