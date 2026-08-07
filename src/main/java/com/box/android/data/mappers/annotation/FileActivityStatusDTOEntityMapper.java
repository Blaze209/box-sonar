package com.box.android.data.mappers.annotation;

import com.box.android.data.api.models.annotations.Status;
import com.box.android.data.mappers.EntityMapper;
import com.box.android.data.persistence.annotations.FileActivityStatus;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivityStatusDTOEntityMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/annotation/FileActivityStatusDTOEntityMapper;", "Lcom/box/android/data/mappers/EntityMapper;", "Lcom/box/android/data/persistence/annotations/FileActivityStatus;", "Lcom/box/android/data/api/models/annotations/Status;", "<init>", "()V", "toEntity", "sourceModel", "fromEntity", "entityModel", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileActivityStatusDTOEntityMapper implements EntityMapper<FileActivityStatus, Status> {

    /* JADX INFO: compiled from: FileActivityStatusDTOEntityMapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Status.values().length];
            try {
                iArr[Status.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Status.RESOLVED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Status.DELETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public FileActivityStatusDTOEntityMapper() {
    }

    @Override // com.box.android.data.mappers.EntityMapper
    public FileActivityStatus toEntity(Status sourceModel) {
        Intrinsics.checkNotNullParameter(sourceModel, "sourceModel");
        int i = WhenMappings.$EnumSwitchMapping$0[sourceModel.ordinal()];
        if (i == 1) {
            return FileActivityStatus.OPEN;
        }
        if (i == 2) {
            return FileActivityStatus.RESOLVED;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return FileActivityStatus.DELETED;
    }

    @Override // com.box.android.data.mappers.EntityMapper
    public Status fromEntity(FileActivityStatus entityModel) {
        Intrinsics.checkNotNullParameter(entityModel, "entityModel");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
