package com.box.android.data.api.models.tasks;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.tasks.CompletionRule;
import com.box.android.domain.models.tasks.TaskType;
import com.box.boxandroidlibv2private.model.BoxTask;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import io.split.android.client.service.ServiceConstants;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateTaskDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/box/android/data/api/models/tasks/TaskBodyDTO;", "", "description", "", "dueAt", "Ljava/util/Date;", ServiceConstants.TASK_INFO_FIELD_TYPE, "Lcom/box/android/domain/models/tasks/TaskType;", "completionRule", "Lcom/box/android/domain/models/tasks/CompletionRule;", "<init>", "(Ljava/lang/String;Ljava/util/Date;Lcom/box/android/domain/models/tasks/TaskType;Lcom/box/android/domain/models/tasks/CompletionRule;)V", "getDescription", "()Ljava/lang/String;", "getDueAt", "()Ljava/util/Date;", "getTaskType", "()Lcom/box/android/domain/models/tasks/TaskType;", "getCompletionRule", "()Lcom/box/android/domain/models/tasks/CompletionRule;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TaskBodyDTO {
    private final CompletionRule completionRule;
    private final String description;
    private final Date dueAt;
    private final TaskType taskType;

    public static /* synthetic */ TaskBodyDTO copy$default(TaskBodyDTO taskBodyDTO, String str, Date date, TaskType taskType, CompletionRule completionRule, int i, Object obj) {
        if ((i & 1) != 0) {
            str = taskBodyDTO.description;
        }
        if ((i & 2) != 0) {
            date = taskBodyDTO.dueAt;
        }
        if ((i & 4) != 0) {
            taskType = taskBodyDTO.taskType;
        }
        if ((i & 8) != 0) {
            completionRule = taskBodyDTO.completionRule;
        }
        return taskBodyDTO.copy(str, date, taskType, completionRule);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Date getDueAt() {
        return this.dueAt;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final TaskType getTaskType() {
        return this.taskType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final CompletionRule getCompletionRule() {
        return this.completionRule;
    }

    public final TaskBodyDTO copy(@Json(name = "description") String description, @Json(name = BoxTask.FIELD_DUE_AT) Date dueAt, @Json(name = BoxTask.FIELD_TASK_TYPE) TaskType taskType, @Json(name = BoxTask.FIELD_COMPLETION_RULE) CompletionRule completionRule) {
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(taskType, "taskType");
        Intrinsics.checkNotNullParameter(completionRule, "completionRule");
        return new TaskBodyDTO(description, dueAt, taskType, completionRule);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskBodyDTO)) {
            return false;
        }
        TaskBodyDTO taskBodyDTO = (TaskBodyDTO) other;
        return Intrinsics.areEqual(this.description, taskBodyDTO.description) && Intrinsics.areEqual(this.dueAt, taskBodyDTO.dueAt) && this.taskType == taskBodyDTO.taskType && this.completionRule == taskBodyDTO.completionRule;
    }

    public int hashCode() {
        int iHashCode = this.description.hashCode() * 31;
        Date date = this.dueAt;
        return ((((iHashCode + (date == null ? 0 : date.hashCode())) * 31) + this.taskType.hashCode()) * 31) + this.completionRule.hashCode();
    }

    public String toString() {
        return "TaskBodyDTO(description=" + this.description + ", dueAt=" + this.dueAt + ", taskType=" + this.taskType + ", completionRule=" + this.completionRule + ")";
    }

    public TaskBodyDTO(@Json(name = "description") String description, @Json(name = BoxTask.FIELD_DUE_AT) Date date, @Json(name = BoxTask.FIELD_TASK_TYPE) TaskType taskType, @Json(name = BoxTask.FIELD_COMPLETION_RULE) CompletionRule completionRule) {
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(taskType, "taskType");
        Intrinsics.checkNotNullParameter(completionRule, "completionRule");
        this.description = description;
        this.dueAt = date;
        this.taskType = taskType;
        this.completionRule = completionRule;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Date getDueAt() {
        return this.dueAt;
    }

    public final TaskType getTaskType() {
        return this.taskType;
    }

    public final CompletionRule getCompletionRule() {
        return this.completionRule;
    }
}
