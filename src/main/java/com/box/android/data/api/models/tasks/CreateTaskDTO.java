package com.box.android.data.api.models.tasks;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.boxandroidlibv2private.model.BoxTask;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateTaskDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0003\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/box/android/data/api/models/tasks/CreateTaskDTO;", "", "task", "Lcom/box/android/data/api/models/tasks/TaskBodyDTO;", "assignedTo", "", "Lcom/box/android/data/api/models/tasks/AssigneeTargetDTO;", "taskLinks", "Lcom/box/android/data/api/models/tasks/TaskLinkTargetDTO;", "<init>", "(Lcom/box/android/data/api/models/tasks/TaskBodyDTO;Ljava/util/List;Ljava/util/List;)V", "getTask", "()Lcom/box/android/data/api/models/tasks/TaskBodyDTO;", "getAssignedTo", "()Ljava/util/List;", "getTaskLinks", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CreateTaskDTO {
    private final List<AssigneeTargetDTO> assignedTo;
    private final TaskBodyDTO task;
    private final List<TaskLinkTargetDTO> taskLinks;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreateTaskDTO copy$default(CreateTaskDTO createTaskDTO, TaskBodyDTO taskBodyDTO, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            taskBodyDTO = createTaskDTO.task;
        }
        if ((i & 2) != 0) {
            list = createTaskDTO.assignedTo;
        }
        if ((i & 4) != 0) {
            list2 = createTaskDTO.taskLinks;
        }
        return createTaskDTO.copy(taskBodyDTO, list, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final TaskBodyDTO getTask() {
        return this.task;
    }

    public final List<AssigneeTargetDTO> component2() {
        return this.assignedTo;
    }

    public final List<TaskLinkTargetDTO> component3() {
        return this.taskLinks;
    }

    public final CreateTaskDTO copy(@Json(name = "task") TaskBodyDTO task, @Json(name = BoxTask.FIELD_ASSIGNMENT_COLLABORATORS) List<AssigneeTargetDTO> assignedTo, @Json(name = BoxTask.FIELD_TASK_LINKS) List<TaskLinkTargetDTO> taskLinks) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(assignedTo, "assignedTo");
        Intrinsics.checkNotNullParameter(taskLinks, "taskLinks");
        return new CreateTaskDTO(task, assignedTo, taskLinks);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateTaskDTO)) {
            return false;
        }
        CreateTaskDTO createTaskDTO = (CreateTaskDTO) other;
        return Intrinsics.areEqual(this.task, createTaskDTO.task) && Intrinsics.areEqual(this.assignedTo, createTaskDTO.assignedTo) && Intrinsics.areEqual(this.taskLinks, createTaskDTO.taskLinks);
    }

    public int hashCode() {
        return (((this.task.hashCode() * 31) + this.assignedTo.hashCode()) * 31) + this.taskLinks.hashCode();
    }

    public String toString() {
        return "CreateTaskDTO(task=" + this.task + ", assignedTo=" + this.assignedTo + ", taskLinks=" + this.taskLinks + ")";
    }

    public CreateTaskDTO(@Json(name = "task") TaskBodyDTO task, @Json(name = BoxTask.FIELD_ASSIGNMENT_COLLABORATORS) List<AssigneeTargetDTO> assignedTo, @Json(name = BoxTask.FIELD_TASK_LINKS) List<TaskLinkTargetDTO> taskLinks) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(assignedTo, "assignedTo");
        Intrinsics.checkNotNullParameter(taskLinks, "taskLinks");
        this.task = task;
        this.assignedTo = assignedTo;
        this.taskLinks = taskLinks;
    }

    public final TaskBodyDTO getTask() {
        return this.task;
    }

    public final List<AssigneeTargetDTO> getAssignedTo() {
        return this.assignedTo;
    }

    public final List<TaskLinkTargetDTO> getTaskLinks() {
        return this.taskLinks;
    }
}
