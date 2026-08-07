package sdk.pendo.io.v6;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/v6/f;", "", "", "toString", "", "hashCode", "other", "", "equals", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "()Ljava/lang/String;", "encoded", "b", "hashed", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final /* data */ class f {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String encoded;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String hashed;

    public f(String str, String str2) {
        this.encoded = str;
        this.hashed = str2;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getEncoded() {
        return this.encoded;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getHashed() {
        return this.hashed;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof f)) {
            return false;
        }
        f fVar = (f) other;
        return Intrinsics.areEqual(this.encoded, fVar.encoded) && Intrinsics.areEqual(this.hashed, fVar.hashed);
    }

    public int hashCode() {
        String str = this.encoded;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.hashed;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "EncodedAndHashed(encoded=" + this.encoded + ", hashed=" + this.hashed + ")";
    }
}
