package sdk.pendo.io.k2;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import sdk.pendo.io.e2.b0;
import sdk.pendo.io.e2.c0;
import sdk.pendo.io.e2.d0;
import sdk.pendo.io.e2.e0;
import sdk.pendo.io.e2.m;
import sdk.pendo.io.e2.n;
import sdk.pendo.io.e2.w;
import sdk.pendo.io.e2.x;
import sdk.pendo.io.s2.l;
import sdk.pendo.io.s2.o;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000b¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/k2/a;", "Lsdk/pendo/io/e2/w;", "", "Lsdk/pendo/io/e2/m;", "cookies", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/e2/w$a;", "chain", "Lsdk/pendo/io/e2/d0;", "Lsdk/pendo/io/e2/n;", "Lsdk/pendo/io/e2/n;", "cookieJar", "<init>", "(Lokhttp3/CookieJar;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class a implements w {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final n cookieJar;

    public a(n cookieJar) {
        Intrinsics.checkNotNullParameter(cookieJar, "cookieJar");
        this.cookieJar = cookieJar;
    }

    private final String a(List<m> cookies) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Object obj : cookies) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            m mVar = (m) obj;
            if (i > 0) {
                sb.append("; ");
            }
            sb.append(mVar.getName()).append('=').append(mVar.getValue());
            i = i2;
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // sdk.pendo.io.e2.w
    public d0 a(w.a chain) {
        e0 e0VarB;
        Intrinsics.checkNotNullParameter(chain, "chain");
        b0 b0VarRequest = chain.request();
        b0.a aVarH = b0VarRequest.h();
        c0 body = b0VarRequest.getBody();
        if (body != null) {
            x contentType = body.getContentType();
            if (contentType != null) {
                aVarH.b("Content-Type", contentType.getMediaType());
            }
            long jA = body.a();
            if (jA != -1) {
                aVarH.b("Content-Length", String.valueOf(jA));
                aVarH.a("Transfer-Encoding");
            } else {
                aVarH.b("Transfer-Encoding", "chunked");
                aVarH.a("Content-Length");
            }
        }
        boolean z = false;
        if (b0VarRequest.a("Host") == null) {
            aVarH.b("Host", sdk.pendo.io.f2.b.a(b0VarRequest.i(), false, 1, (Object) null));
        }
        if (b0VarRequest.a("Connection") == null) {
            aVarH.b("Connection", "Keep-Alive");
        }
        if (b0VarRequest.a("Accept-Encoding") == null && b0VarRequest.a("Range") == null) {
            aVarH.b("Accept-Encoding", "gzip");
            z = true;
        }
        List<m> listA = this.cookieJar.a(b0VarRequest.i());
        if (!listA.isEmpty()) {
            aVarH.b("Cookie", a(listA));
        }
        if (b0VarRequest.a("User-Agent") == null) {
            aVarH.b("User-Agent", Util.userAgent);
        }
        d0 d0VarA = chain.a(aVarH.a());
        e.a(this.cookieJar, b0VarRequest.i(), d0VarA.getHeaders());
        d0.a aVarA = d0VarA.m().a(b0VarRequest);
        if (z && StringsKt.equals("gzip", d0.a(d0VarA, "Content-Encoding", null, 2, null), true) && e.b(d0VarA) && (e0VarB = d0VarA.b()) != null) {
            l lVar = new l(e0VarB.getSource());
            aVarA.a(d0VarA.getHeaders().a().b("Content-Encoding").b("Content-Length").a());
            aVarA.a(new h(d0.a(d0VarA, "Content-Type", null, 2, null), -1L, o.a(lVar)));
        }
        return aVarA.a();
    }
}
