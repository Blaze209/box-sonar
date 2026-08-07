package sdk.pendo.io.s7;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014¨\u0006\u0018"}, d2 = {"Lsdk/pendo/io/s7/c0;", "", "", "toString", "", "hashCode", "other", "", "equals", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Z", "c", "()Z", "shouldScan", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "navRoute", "Lsdk/pendo/io/s7/g;", "Lsdk/pendo/io/s7/g;", "()Lsdk/pendo/io/s7/g;", "navigationVersion", "<init>", "(ZLjava/lang/String;Lsdk/pendo/io/s7/g;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
final /* data */ class c0 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final boolean shouldScan;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String navRoute;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final g navigationVersion;

    public c0(boolean z, String str, g gVar) {
        this.shouldScan = z;
        this.navRoute = str;
        this.navigationVersion = gVar;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getNavRoute() {
        return this.navRoute;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final g getNavigationVersion() {
        return this.navigationVersion;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final boolean getShouldScan() {
        return this.shouldScan;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) other;
        return this.shouldScan == c0Var.shouldScan && Intrinsics.areEqual(this.navRoute, c0Var.navRoute) && this.navigationVersion == c0Var.navigationVersion;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.shouldScan;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.navRoute;
        int iHashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        g gVar = this.navigationVersion;
        return iHashCode + (gVar != null ? gVar.hashCode() : 0);
    }

    public String toString() {
        return "NavigationFilterResult(shouldScan=" + this.shouldScan + ", navRoute=" + this.navRoute + ", navigationVersion=" + this.navigationVersion + ")";
    }
}
