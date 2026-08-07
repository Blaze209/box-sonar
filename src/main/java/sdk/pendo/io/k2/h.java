package sdk.pendo.io.k2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.e2.e0;
import sdk.pendo.io.e2.x;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000f¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/k2/h;", "Lsdk/pendo/io/e2/e0;", "", "e", "Lsdk/pendo/io/e2/x;", "f", "Lsdk/pendo/io/s2/f;", "g", "", "c", "Ljava/lang/String;", "contentTypeString", "d", "J", "contentLength", "Lsdk/pendo/io/s2/f;", "source", "<init>", "(Ljava/lang/String;JLokio/BufferedSource;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class h extends e0 {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String contentTypeString;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final long contentLength;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final sdk.pendo.io.s2.f source;

    public h(String str, long j, sdk.pendo.io.s2.f source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.contentTypeString = str;
        this.contentLength = j;
        this.source = source;
    }

    @Override // sdk.pendo.io.e2.e0
    /* JADX INFO: renamed from: e, reason: from getter */
    public long getContentLength() {
        return this.contentLength;
    }

    @Override // sdk.pendo.io.e2.e0
    /* JADX INFO: renamed from: f */
    public x getC() {
        String str = this.contentTypeString;
        if (str != null) {
            return x.INSTANCE.b(str);
        }
        return null;
    }

    @Override // sdk.pendo.io.e2.e0
    /* JADX INFO: renamed from: g, reason: from getter */
    public sdk.pendo.io.s2.f getSource() {
        return this.source;
    }
}
