package com.box.android.domain.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import com.box.androidsdk.content.models.BoxIterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationIteratorModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/InboxNotificationIteratorModel;", "Lcom/box/android/domain/models/DomainModel;", BoxIterator.FIELD_LIMIT, "", "entries", "", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;", "nextMarker", "", "topNotificationId", "<init>", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getLimit", "()I", "getEntries", "()Ljava/util/List;", "getNextMarker", "()Ljava/lang/String;", "getTopNotificationId", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class InboxNotificationIteratorModel implements DomainModel {
    private final List<InboxNotificationModel> entries;
    private final int limit;
    private final String nextMarker;
    private final String topNotificationId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InboxNotificationIteratorModel copy$default(InboxNotificationIteratorModel inboxNotificationIteratorModel, int i, List list, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = inboxNotificationIteratorModel.limit;
        }
        if ((i2 & 2) != 0) {
            list = inboxNotificationIteratorModel.entries;
        }
        if ((i2 & 4) != 0) {
            str = inboxNotificationIteratorModel.nextMarker;
        }
        if ((i2 & 8) != 0) {
            str2 = inboxNotificationIteratorModel.topNotificationId;
        }
        return inboxNotificationIteratorModel.copy(i, list, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getLimit() {
        return this.limit;
    }

    public final List<InboxNotificationModel> component2() {
        return this.entries;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getNextMarker() {
        return this.nextMarker;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTopNotificationId() {
        return this.topNotificationId;
    }

    public final InboxNotificationIteratorModel copy(int limit, List<InboxNotificationModel> entries, String nextMarker, String topNotificationId) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        return new InboxNotificationIteratorModel(limit, entries, nextMarker, topNotificationId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboxNotificationIteratorModel)) {
            return false;
        }
        InboxNotificationIteratorModel inboxNotificationIteratorModel = (InboxNotificationIteratorModel) other;
        return this.limit == inboxNotificationIteratorModel.limit && Intrinsics.areEqual(this.entries, inboxNotificationIteratorModel.entries) && Intrinsics.areEqual(this.nextMarker, inboxNotificationIteratorModel.nextMarker) && Intrinsics.areEqual(this.topNotificationId, inboxNotificationIteratorModel.topNotificationId);
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.limit) * 31) + this.entries.hashCode()) * 31;
        String str = this.nextMarker;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.topNotificationId;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "InboxNotificationIteratorModel(limit=" + this.limit + ", entries=" + this.entries + ", nextMarker=" + this.nextMarker + ", topNotificationId=" + this.topNotificationId + ")";
    }

    public InboxNotificationIteratorModel(int i, List<InboxNotificationModel> entries, String str, String str2) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.limit = i;
        this.entries = entries;
        this.nextMarker = str;
        this.topNotificationId = str2;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final List<InboxNotificationModel> getEntries() {
        return this.entries;
    }

    public final String getNextMarker() {
        return this.nextMarker;
    }

    public final String getTopNotificationId() {
        return this.topNotificationId;
    }
}
