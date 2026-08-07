package sdk.pendo.io.h7;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b \u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\r\u001a\u00020\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/h7/u;", "Lsdk/pendo/io/h7/q;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "J", "d", "()J", "timestamp", "", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "retroactiveScreenId", "<init>", "(JLjava/lang/String;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public abstract class u implements q {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final long timestamp;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String retroactiveScreenId;

    public u(long j, String retroactiveScreenId) {
        Intrinsics.checkNotNullParameter(retroactiveScreenId, "retroactiveScreenId");
        this.timestamp = j;
        this.retroactiveScreenId = retroactiveScreenId;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getRetroactiveScreenId() {
        return this.retroactiveScreenId;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }
}
