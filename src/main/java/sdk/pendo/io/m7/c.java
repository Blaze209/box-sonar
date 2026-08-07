package sdk.pendo.io.m7;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\b\u0081\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\r\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u001a\u0010\u0019\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018¨\u0006\u001c"}, d2 = {"Lsdk/pendo/io/m7/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "J", "()J", "id", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "payload", "c", "I", "()I", "payloadSize", "d", "Z", "()Z", "isSending", "<init>", "(JLjava/lang/String;IZ)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final /* data */ class c {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final long id;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String payload;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final int payloadSize;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final boolean isSending;

    public c(long j, String payload, int i, boolean z) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.id = j;
        this.payload = payload;
        this.payloadSize = i;
        this.isSending = z;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getPayload() {
        return this.payload;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getPayloadSize() {
        return this.payloadSize;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final boolean getIsSending() {
        return this.isSending;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        return this.id == cVar.id && Intrinsics.areEqual(this.payload, cVar.payload) && this.payloadSize == cVar.payloadSize && this.isSending == cVar.isSending;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int iHashCode = ((((Long.hashCode(this.id) * 31) + this.payload.hashCode()) * 31) + Integer.hashCode(this.payloadSize)) * 31;
        boolean z = this.isSending;
        ?? r2 = z;
        if (z) {
            r2 = 1;
        }
        return iHashCode + r2;
    }

    public String toString() {
        return "SessionReplayEntity(id=" + this.id + ", payload=" + this.payload + ", payloadSize=" + this.payloadSize + ", isSending=" + this.isSending + ")";
    }

    public /* synthetic */ c(long j, String str, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, str, i, (i2 & 8) != 0 ? false : z);
    }
}
