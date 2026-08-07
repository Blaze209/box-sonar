package sdk.pendo.io.m2;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Header;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0005B\u0019\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0014B\u0019\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0004HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/m2/c;", "", "", "toString", "Lsdk/pendo/io/s2/g;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "", "hashCode", "other", "", "equals", "Lsdk/pendo/io/s2/g;", "name", "value", "c", "I", "hpackSize", "<init>", "(Lokio/ByteString;Ljava/lang/String;)V", "(Lokio/ByteString;Lokio/ByteString;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "d", "okhttp"}, k = 1, mv = {1, 8, 0})
public final /* data */ class c {
    public static final sdk.pendo.io.s2.g e;
    public static final sdk.pendo.io.s2.g f;
    public static final sdk.pendo.io.s2.g g;
    public static final sdk.pendo.io.s2.g h;
    public static final sdk.pendo.io.s2.g i;
    public static final sdk.pendo.io.s2.g j;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final sdk.pendo.io.s2.g name;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final sdk.pendo.io.s2.g value;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final int hpackSize;

    static {
        sdk.pendo.io.s2.g.Companion companion = sdk.pendo.io.s2.g.INSTANCE;
        e = companion.b(":");
        f = companion.b(Header.RESPONSE_STATUS_UTF8);
        g = companion.b(Header.TARGET_METHOD_UTF8);
        h = companion.b(Header.TARGET_PATH_UTF8);
        i = companion.b(Header.TARGET_SCHEME_UTF8);
        j = companion.b(Header.TARGET_AUTHORITY_UTF8);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public c(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        sdk.pendo.io.s2.g.Companion companion = sdk.pendo.io.s2.g.INSTANCE;
        this(companion.b(name), companion.b(value));
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final sdk.pendo.io.s2.g getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final sdk.pendo.io.s2.g getValue() {
        return this.value;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        return Intrinsics.areEqual(this.name, cVar.name) && Intrinsics.areEqual(this.value, cVar.value);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return this.name.m() + ": " + this.value.m();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(sdk.pendo.io.s2.g name, String value) {
        this(name, sdk.pendo.io.s2.g.INSTANCE.b(value));
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    public c(sdk.pendo.io.s2.g name, sdk.pendo.io.s2.g value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.name = name;
        this.value = value;
        this.hpackSize = name.j() + 32 + value.j();
    }
}
