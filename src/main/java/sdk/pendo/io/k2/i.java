package sdk.pendo.io.k2;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.net.Proxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.e2.b0;
import sdk.pendo.io.e2.v;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¨\u0006\u000e"}, d2 = {"Lsdk/pendo/io/k2/i;", "", "Lsdk/pendo/io/e2/b0;", "request", "Ljava/net/Proxy$Type;", "proxyType", "", "b", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/e2/v;", "url", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class i {
    public static final i a = new i();

    private i() {
    }

    private final boolean b(b0 request, Proxy.Type proxyType) {
        return !request.f() && proxyType == Proxy.Type.HTTP;
    }

    public final String a(b0 request, Proxy.Type proxyType) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(proxyType, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(request.getCom.google.firebase.analytics.FirebaseAnalytics.Param.METHOD java.lang.String());
        sb.append(' ');
        i iVar = a;
        boolean zB = iVar.b(request, proxyType);
        v vVarI = request.i();
        if (zB) {
            sb.append(vVarI);
        } else {
            sb.append(iVar.a(vVarI));
        }
        sb.append(" HTTP/1.1");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String a(v url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String strD = url.d();
        String strF = url.f();
        return strF != null ? strD + '?' + strF : strD;
    }
}
