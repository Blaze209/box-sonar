package com.box.android.data.api.models.tasks;

import com.box.android.data.api.models.items.mini.FileIdDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateTaskDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/api/models/tasks/TaskLinkTargetDTO;", "", "target", "Lcom/box/android/data/api/models/items/mini/FileIdDTO;", "<init>", "(Lcom/box/android/data/api/models/items/mini/FileIdDTO;)V", "getTarget", "()Lcom/box/android/data/api/models/items/mini/FileIdDTO;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TaskLinkTargetDTO {
    private final FileIdDTO target;

    public static /* synthetic */ TaskLinkTargetDTO copy$default(TaskLinkTargetDTO taskLinkTargetDTO, FileIdDTO fileIdDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            fileIdDTO = taskLinkTargetDTO.target;
        }
        return taskLinkTargetDTO.copy(fileIdDTO);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FileIdDTO getTarget() {
        return this.target;
    }

    public final TaskLinkTargetDTO copy(@Json(name = "target") FileIdDTO target) {
        Intrinsics.checkNotNullParameter(target, "target");
        return new TaskLinkTargetDTO(target);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TaskLinkTargetDTO) && Intrinsics.areEqual(this.target, ((TaskLinkTargetDTO) other).target);
    }

    public int hashCode() {
        return this.target.hashCode();
    }

    public String toString() {
        return "TaskLinkTargetDTO(target=" + this.target + ")";
    }

    public TaskLinkTargetDTO(@Json(name = "target") FileIdDTO target) {
        Intrinsics.checkNotNullParameter(target, "target");
        this.target = target;
    }

    public final FileIdDTO getTarget() {
        return this.target;
    }
}
