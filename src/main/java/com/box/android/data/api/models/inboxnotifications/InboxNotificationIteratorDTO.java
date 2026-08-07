package com.box.android.data.api.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxIterator;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationIteratorDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\u000e\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationIteratorDTO;", "", "nextMarker", "", BoxIterator.FIELD_LIMIT, "", "entries", "", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationDTO;", "topNotificationId", "<init>", "(Ljava/lang/String;ILjava/util/List;Ljava/lang/String;)V", "getNextMarker", "()Ljava/lang/String;", "getLimit", "()I", "getEntries", "()Ljava/util/List;", "getTopNotificationId", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class InboxNotificationIteratorDTO {
    private final List<InboxNotificationDTO> entries;
    private final int limit;
    private final String nextMarker;
    private final String topNotificationId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InboxNotificationIteratorDTO copy$default(InboxNotificationIteratorDTO inboxNotificationIteratorDTO, String str, int i, List list, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = inboxNotificationIteratorDTO.nextMarker;
        }
        if ((i2 & 2) != 0) {
            i = inboxNotificationIteratorDTO.limit;
        }
        if ((i2 & 4) != 0) {
            list = inboxNotificationIteratorDTO.entries;
        }
        if ((i2 & 8) != 0) {
            str2 = inboxNotificationIteratorDTO.topNotificationId;
        }
        return inboxNotificationIteratorDTO.copy(str, i, list, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getNextMarker() {
        return this.nextMarker;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getLimit() {
        return this.limit;
    }

    public final List<InboxNotificationDTO> component3() {
        return this.entries;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTopNotificationId() {
        return this.topNotificationId;
    }

    public final InboxNotificationIteratorDTO copy(@Json(name = BoxIterator.FIELD_NEXT_MARKER) String nextMarker, @Json(name = BoxIterator.FIELD_LIMIT) int limit, @Json(name = "entries") List<InboxNotificationDTO> entries, @Json(name = "top_notification_id") String topNotificationId) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        return new InboxNotificationIteratorDTO(nextMarker, limit, entries, topNotificationId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboxNotificationIteratorDTO)) {
            return false;
        }
        InboxNotificationIteratorDTO inboxNotificationIteratorDTO = (InboxNotificationIteratorDTO) other;
        return Intrinsics.areEqual(this.nextMarker, inboxNotificationIteratorDTO.nextMarker) && this.limit == inboxNotificationIteratorDTO.limit && Intrinsics.areEqual(this.entries, inboxNotificationIteratorDTO.entries) && Intrinsics.areEqual(this.topNotificationId, inboxNotificationIteratorDTO.topNotificationId);
    }

    public int hashCode() {
        String str = this.nextMarker;
        int iHashCode = (((((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.limit)) * 31) + this.entries.hashCode()) * 31;
        String str2 = this.topNotificationId;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "InboxNotificationIteratorDTO(nextMarker=" + this.nextMarker + ", limit=" + this.limit + ", entries=" + this.entries + ", topNotificationId=" + this.topNotificationId + ")";
    }

    public InboxNotificationIteratorDTO(@Json(name = BoxIterator.FIELD_NEXT_MARKER) String str, @Json(name = BoxIterator.FIELD_LIMIT) int i, @Json(name = "entries") List<InboxNotificationDTO> entries, @Json(name = "top_notification_id") String str2) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.nextMarker = str;
        this.limit = i;
        this.entries = entries;
        this.topNotificationId = str2;
    }

    public final String getNextMarker() {
        return this.nextMarker;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final List<InboxNotificationDTO> getEntries() {
        return this.entries;
    }

    public final String getTopNotificationId() {
        return this.topNotificationId;
    }
}
