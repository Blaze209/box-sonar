package com.box.android.data.mappers;

import com.box.android.data.persistence.ScannedDocumentPageEntity;
import com.box.android.domain.models.ScannedDocumentPage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScannedDocumentPageEntityMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/ScannedDocumentPageEntityMapper;", "Lcom/box/android/data/mappers/DomainMapper;", "Lcom/box/android/domain/models/ScannedDocumentPage;", "Lcom/box/android/data/persistence/ScannedDocumentPageEntity;", "<init>", "()V", "toDomain", "dataModel", "fromDomain", "domainModel", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ScannedDocumentPageEntityMapper implements DomainMapper<ScannedDocumentPage, ScannedDocumentPageEntity> {
    public static final ScannedDocumentPageEntityMapper INSTANCE = new ScannedDocumentPageEntityMapper();

    private ScannedDocumentPageEntityMapper() {
    }

    @Override // com.box.android.data.mappers.DomainMapper
    public ScannedDocumentPage toDomain(ScannedDocumentPageEntity dataModel) {
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        return new ScannedDocumentPage(Integer.valueOf(dataModel.getId()), dataModel.getOriginalImagePath(), dataModel.getEnhancedImagePath(), dataModel.getFilterType(), dataModel.getQuadrangle(), dataModel.getDistortionCorrectionEnabled(), dataModel.getRotationAngle(), dataModel.getVersion(), dataModel.getCreatedAt());
    }

    @Override // com.box.android.data.mappers.DomainMapper
    public ScannedDocumentPageEntity fromDomain(ScannedDocumentPage domainModel) {
        Intrinsics.checkNotNullParameter(domainModel, "domainModel");
        Integer id = domainModel.getId();
        return new ScannedDocumentPageEntity(id != null ? id.intValue() : 0, domainModel.getOriginalImagePath(), domainModel.getEnhancedImagePath(), domainModel.getFilterType(), domainModel.getQuadrangle(), domainModel.getDistortionCorrectionEnabled(), domainModel.getRotationAngle(), domainModel.getVersion(), domainModel.getCreatedAt());
    }
}
