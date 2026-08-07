package com.box.android.inbox.notifications.inboxitem;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxItemContent.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/NotificationPayload;", "", "segments", "", "Lcom/box/android/inbox/notifications/inboxitem/NotificationSegment;", "description", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getSegments", "()Ljava/util/List;", "getDescription", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class NotificationPayload {
    public static final int $stable = 8;
    private final String description;
    private final List<NotificationSegment> segments;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NotificationPayload copy$default(NotificationPayload notificationPayload, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = notificationPayload.segments;
        }
        if ((i & 2) != 0) {
            str = notificationPayload.description;
        }
        return notificationPayload.copy(list, str);
    }

    public final List<NotificationSegment> component1() {
        return this.segments;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final NotificationPayload copy(List<NotificationSegment> segments, String description) {
        Intrinsics.checkNotNullParameter(segments, "segments");
        return new NotificationPayload(segments, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationPayload)) {
            return false;
        }
        NotificationPayload notificationPayload = (NotificationPayload) other;
        return Intrinsics.areEqual(this.segments, notificationPayload.segments) && Intrinsics.areEqual(this.description, notificationPayload.description);
    }

    public int hashCode() {
        int iHashCode = this.segments.hashCode() * 31;
        String str = this.description;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "NotificationPayload(segments=" + this.segments + ", description=" + this.description + ")";
    }

    public NotificationPayload(List<NotificationSegment> segments, String str) {
        Intrinsics.checkNotNullParameter(segments, "segments");
        this.segments = segments;
        this.description = str;
    }

    public /* synthetic */ NotificationPayload(List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : str);
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<NotificationSegment> getSegments() {
        return this.segments;
    }
}
