package sdk.pendo.io.x6;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0016"}, d2 = {"Lsdk/pendo/io/x6/c;", "", "", "toString", "", "hashCode", "other", "", "equals", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "fragmentName", "I", "()I", "fragmentLevel", "c", "getRootViewHashCode", "rootViewHashCode", "<init>", "(Ljava/lang/String;II)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final /* data */ class c {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String fragmentName;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final int fragmentLevel;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final int rootViewHashCode;

    public c(String fragmentName, int i, int i2) {
        Intrinsics.checkNotNullParameter(fragmentName, "fragmentName");
        this.fragmentName = fragmentName;
        this.fragmentLevel = i;
        this.rootViewHashCode = i2;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getFragmentLevel() {
        return this.fragmentLevel;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getFragmentName() {
        return this.fragmentName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        return Intrinsics.areEqual(this.fragmentName, cVar.fragmentName) && this.fragmentLevel == cVar.fragmentLevel && this.rootViewHashCode == cVar.rootViewHashCode;
    }

    public int hashCode() {
        return (((this.fragmentName.hashCode() * 31) + Integer.hashCode(this.fragmentLevel)) * 31) + Integer.hashCode(this.rootViewHashCode);
    }

    public String toString() {
        return "FragmentInfo(fragmentName=" + this.fragmentName + ", fragmentLevel=" + this.fragmentLevel + ", rootViewHashCode=" + this.rootViewHashCode + ")";
    }
}
