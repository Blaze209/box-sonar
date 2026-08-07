package com.box.android.inbox.notifications.inboxitem;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxItemTaskStatus.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/TaskStatus;", "", "iconRes", "", "text", "", "<init>", "(ILjava/lang/String;)V", "getIconRes", "()I", "getText", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
final /* data */ class TaskStatus {
    private final int iconRes;
    private final String text;

    public static /* synthetic */ TaskStatus copy$default(TaskStatus taskStatus, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = taskStatus.iconRes;
        }
        if ((i2 & 2) != 0) {
            str = taskStatus.text;
        }
        return taskStatus.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIconRes() {
        return this.iconRes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final TaskStatus copy(int iconRes, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new TaskStatus(iconRes, text);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskStatus)) {
            return false;
        }
        TaskStatus taskStatus = (TaskStatus) other;
        return this.iconRes == taskStatus.iconRes && Intrinsics.areEqual(this.text, taskStatus.text);
    }

    public int hashCode() {
        return (Integer.hashCode(this.iconRes) * 31) + this.text.hashCode();
    }

    public String toString() {
        return "TaskStatus(iconRes=" + this.iconRes + ", text=" + this.text + ")";
    }

    public TaskStatus(int i, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.iconRes = i;
        this.text = text;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final String getText() {
        return this.text;
    }
}
