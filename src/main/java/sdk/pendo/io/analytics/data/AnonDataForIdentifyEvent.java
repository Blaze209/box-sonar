package sdk.pendo.io.analytics.data;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.models.SessionData;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/analytics/data/AnonDataForIdentifyEvent;", "", "", "toString", "", "hashCode", "other", "", "equals", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "anonVisitorId", "anonAccountId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "c", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final /* data */ class AnonDataForIdentifyEvent {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String anonVisitorId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String anonAccountId;

    /* JADX INFO: renamed from: sdk.pendo.io.analytics.data.AnonDataForIdentifyEvent$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¨\u0006\b"}, d2 = {"Lsdk/pendo/io/analytics/data/AnonDataForIdentifyEvent$a;", "", "Lsdk/pendo/io/models/SessionData;", "sessionData", "Lsdk/pendo/io/analytics/data/AnonDataForIdentifyEvent;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final AnonDataForIdentifyEvent a(SessionData sessionData) {
            if (sessionData == null || !sessionData.isAnonymous()) {
                return null;
            }
            return new AnonDataForIdentifyEvent(sessionData.getVisitorId(), sessionData.getAccountId());
        }
    }

    public AnonDataForIdentifyEvent(String anonVisitorId, String anonAccountId) {
        Intrinsics.checkNotNullParameter(anonVisitorId, "anonVisitorId");
        Intrinsics.checkNotNullParameter(anonAccountId, "anonAccountId");
        this.anonVisitorId = anonVisitorId;
        this.anonAccountId = anonAccountId;
    }

    @JvmStatic
    public static final AnonDataForIdentifyEvent a(SessionData sessionData) {
        return INSTANCE.a(sessionData);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getAnonVisitorId() {
        return this.anonVisitorId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnonDataForIdentifyEvent)) {
            return false;
        }
        AnonDataForIdentifyEvent anonDataForIdentifyEvent = (AnonDataForIdentifyEvent) other;
        return Intrinsics.areEqual(this.anonVisitorId, anonDataForIdentifyEvent.anonVisitorId) && Intrinsics.areEqual(this.anonAccountId, anonDataForIdentifyEvent.anonAccountId);
    }

    public int hashCode() {
        return (this.anonVisitorId.hashCode() * 31) + this.anonAccountId.hashCode();
    }

    public String toString() {
        return "AnonDataForIdentifyEvent(anonVisitorId=" + this.anonVisitorId + ", anonAccountId=" + this.anonAccountId + ")";
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getAnonAccountId() {
        return this.anonAccountId;
    }
}
