package sdk.pendo.io.h7;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0006\u001a\u00020\u0002HÖ\u0001J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\u0005\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\f\u001a\u0004\b\u000e\u0010\r¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/h7/t;", "", "", "recordingId", "recordingSessionId", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "()Ljava/lang/String;", "b", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final /* data */ class t {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String recordingId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String recordingSessionId;

    public t(String recordingId, String recordingSessionId) {
        Intrinsics.checkNotNullParameter(recordingId, "recordingId");
        Intrinsics.checkNotNullParameter(recordingSessionId, "recordingSessionId");
        this.recordingId = recordingId;
        this.recordingSessionId = recordingSessionId;
    }

    public final t a(String recordingId, String recordingSessionId) {
        Intrinsics.checkNotNullParameter(recordingId, "recordingId");
        Intrinsics.checkNotNullParameter(recordingSessionId, "recordingSessionId");
        return new t(recordingId, recordingSessionId);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getRecordingSessionId() {
        return this.recordingSessionId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof t)) {
            return false;
        }
        t tVar = (t) other;
        return Intrinsics.areEqual(this.recordingId, tVar.recordingId) && Intrinsics.areEqual(this.recordingSessionId, tVar.recordingSessionId);
    }

    public int hashCode() {
        return (this.recordingId.hashCode() * 31) + this.recordingSessionId.hashCode();
    }

    public String toString() {
        return "SRSessionAnalyticsData(recordingId=" + this.recordingId + ", recordingSessionId=" + this.recordingSessionId + ")";
    }

    public static /* synthetic */ t a(t tVar, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tVar.recordingId;
        }
        if ((i & 2) != 0) {
            str2 = tVar.recordingSessionId;
        }
        return tVar.a(str, str2);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getRecordingId() {
        return this.recordingId;
    }
}
