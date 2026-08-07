package sdk.pendo.io.s7;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0004\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0006\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÖ\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00018\u00008\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/s7/g0;", "M", "", "", "toString", "", "hashCode", "other", "", "equals", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/Object;", "()Ljava/lang/Object;", "value", "b", "Z", "()Z", "isEmpty", "<init>", "(Ljava/lang/Object;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final /* data */ class g0<M> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final M value;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final boolean isEmpty;

    public g0(M m) {
        this.value = m;
        this.isEmpty = m == null;
    }

    public final M a() {
        return this.value;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final boolean getIsEmpty() {
        return this.isEmpty;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof g0) && Intrinsics.areEqual(this.value, ((g0) other).value);
    }

    public int hashCode() {
        M m = this.value;
        if (m == null) {
            return 0;
        }
        return m.hashCode();
    }

    public String toString() {
        return "Optional(value=" + this.value + ")";
    }
}
