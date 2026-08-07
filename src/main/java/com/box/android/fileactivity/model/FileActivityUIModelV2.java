package com.box.android.fileactivity.model;

import com.box.android.cpl.Identifiable;
import com.box.android.domain.models.annotations.FileActivityIdModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FileActivityUIModelsV2.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/fileactivity/model/FileActivityUIModelV2;", "Lcom/box/android/cpl/Identifiable;", "Lcom/box/android/domain/models/annotations/FileActivityIdModel;", "activityId", "<init>", "(Lcom/box/android/domain/models/annotations/FileActivityIdModel;)V", "id", "getId", "()Lcom/box/android/domain/models/annotations/FileActivityIdModel;", "Lcom/box/android/fileactivity/model/AnnotationUIModelV2;", "Lcom/box/android/fileactivity/model/CommentUIModelV2;", "Lcom/box/android/fileactivity/model/VersionsUIModelV2;", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class FileActivityUIModelV2 implements Identifiable<FileActivityIdModel> {
    public static final int $stable = 8;
    private final FileActivityIdModel activityId;

    public /* synthetic */ FileActivityUIModelV2(FileActivityIdModel fileActivityIdModel, DefaultConstructorMarker defaultConstructorMarker) {
        this(fileActivityIdModel);
    }

    private FileActivityUIModelV2(FileActivityIdModel fileActivityIdModel) {
        this.activityId = fileActivityIdModel;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.box.android.cpl.Identifiable
    /* JADX INFO: renamed from: getId, reason: from getter */
    public FileActivityIdModel getActivityId() {
        return this.activityId;
    }
}
