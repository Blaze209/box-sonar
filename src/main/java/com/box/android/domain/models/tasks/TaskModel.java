package com.box.android.domain.models.tasks;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TaskModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J?\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/box/android/domain/models/tasks/TaskModel;", "", "id", "", "type", "Lcom/box/android/domain/models/tasks/TaskType;", "description", "dueAt", "Ljava/util/Date;", "completionRule", "Lcom/box/android/domain/models/tasks/CompletionRule;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/tasks/TaskType;Ljava/lang/String;Ljava/util/Date;Lcom/box/android/domain/models/tasks/CompletionRule;)V", "getId", "()Ljava/lang/String;", "getType", "()Lcom/box/android/domain/models/tasks/TaskType;", "getDescription", "getDueAt", "()Ljava/util/Date;", "getCompletionRule", "()Lcom/box/android/domain/models/tasks/CompletionRule;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TaskModel {
    private final CompletionRule completionRule;
    private final String description;
    private final Date dueAt;
    private final String id;
    private final TaskType type;

    public static /* synthetic */ TaskModel copy$default(TaskModel taskModel, String str, TaskType taskType, String str2, Date date, CompletionRule completionRule, int i, Object obj) {
        if ((i & 1) != 0) {
            str = taskModel.id;
        }
        if ((i & 2) != 0) {
            taskType = taskModel.type;
        }
        if ((i & 4) != 0) {
            str2 = taskModel.description;
        }
        if ((i & 8) != 0) {
            date = taskModel.dueAt;
        }
        if ((i & 16) != 0) {
            completionRule = taskModel.completionRule;
        }
        CompletionRule completionRule2 = completionRule;
        String str3 = str2;
        return taskModel.copy(str, taskType, str3, date, completionRule2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final TaskType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Date getDueAt() {
        return this.dueAt;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final CompletionRule getCompletionRule() {
        return this.completionRule;
    }

    public final TaskModel copy(String id, TaskType type, String description, Date dueAt, CompletionRule completionRule) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(completionRule, "completionRule");
        return new TaskModel(id, type, description, dueAt, completionRule);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskModel)) {
            return false;
        }
        TaskModel taskModel = (TaskModel) other;
        return Intrinsics.areEqual(this.id, taskModel.id) && this.type == taskModel.type && Intrinsics.areEqual(this.description, taskModel.description) && Intrinsics.areEqual(this.dueAt, taskModel.dueAt) && this.completionRule == taskModel.completionRule;
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
        String str = this.description;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Date date = this.dueAt;
        return ((iHashCode2 + (date != null ? date.hashCode() : 0)) * 31) + this.completionRule.hashCode();
    }

    public String toString() {
        return "TaskModel(id=" + this.id + ", type=" + this.type + ", description=" + this.description + ", dueAt=" + this.dueAt + ", completionRule=" + this.completionRule + ")";
    }

    public TaskModel(String id, TaskType type, String str, Date date, CompletionRule completionRule) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(completionRule, "completionRule");
        this.id = id;
        this.type = type;
        this.description = str;
        this.dueAt = date;
        this.completionRule = completionRule;
    }

    public final String getId() {
        return this.id;
    }

    public final TaskType getType() {
        return this.type;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Date getDueAt() {
        return this.dueAt;
    }

    public final CompletionRule getCompletionRule() {
        return this.completionRule;
    }
}
