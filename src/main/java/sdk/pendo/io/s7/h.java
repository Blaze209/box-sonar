package sdk.pendo.io.s7;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\u000b\u0010\rR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u000f\u0010\rR$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\t\u0010\rR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015¨\u0006\u0019"}, d2 = {"Lsdk/pendo/io/s7/h;", "", "", "toString", "", "hashCode", "other", "", "equals", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "nav2Route", "c", "nav3Scene", "circuitScreen", "", "d", "Ljava/util/List;", "()Ljava/util/List;", "pendoScreenTags", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final /* data */ class h {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private String nav2Route;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private String nav3Scene;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private String circuitScreen;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final List<String> pendoScreenTags;

    public h() {
        this(null, null, null, null, 15, null);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getCircuitScreen() {
        return this.circuitScreen;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getNav2Route() {
        return this.nav2Route;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getNav3Scene() {
        return this.nav3Scene;
    }

    public final List<String> d() {
        return this.pendoScreenTags;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof h)) {
            return false;
        }
        h hVar = (h) other;
        return Intrinsics.areEqual(this.nav2Route, hVar.nav2Route) && Intrinsics.areEqual(this.nav3Scene, hVar.nav3Scene) && Intrinsics.areEqual(this.circuitScreen, hVar.circuitScreen) && Intrinsics.areEqual(this.pendoScreenTags, hVar.pendoScreenTags);
    }

    public int hashCode() {
        String str = this.nav2Route;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.nav3Scene;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.circuitScreen;
        return ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.pendoScreenTags.hashCode();
    }

    public String toString() {
        return "ComposeRouteSnapshot(nav2Route=" + this.nav2Route + ", nav3Scene=" + this.nav3Scene + ", circuitScreen=" + this.circuitScreen + ", pendoScreenTags=" + this.pendoScreenTags + ")";
    }

    public h(String str, String str2, String str3, List<String> pendoScreenTags) {
        Intrinsics.checkNotNullParameter(pendoScreenTags, "pendoScreenTags");
        this.nav2Route = str;
        this.nav3Scene = str2;
        this.circuitScreen = str3;
        this.pendoScreenTags = pendoScreenTags;
    }

    public final void a(String str) {
        this.circuitScreen = str;
    }

    public final void b(String str) {
        this.nav2Route = str;
    }

    public final void c(String str) {
        this.nav3Scene = str;
    }

    public /* synthetic */ h(String str, String str2, String str3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? new ArrayList() : list);
    }
}
