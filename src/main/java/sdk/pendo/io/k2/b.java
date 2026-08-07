package sdk.pendo.io.k2;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.hc.core5.http.HeaderElements;
import sdk.pendo.io.e2.b0;
import sdk.pendo.io.e2.c0;
import sdk.pendo.io.e2.d0;
import sdk.pendo.io.e2.e0;
import sdk.pendo.io.e2.w;
import sdk.pendo.io.s2.o;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\t¨\u0006\r"}, d2 = {"Lsdk/pendo/io/k2/b;", "Lsdk/pendo/io/e2/w;", "", "code", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/e2/w$a;", "chain", "Lsdk/pendo/io/e2/d0;", "Z", "forWebSocket", "<init>", "(Z)V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class b implements w {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final boolean forWebSocket;

    public b(boolean z) {
        this.forWebSocket = z;
    }

    private final boolean a(int code) {
        if (code == 100) {
            return true;
        }
        return 102 <= code && code < 200;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0095 A[Catch: IOException -> 0x009a, TRY_LEAVE, TryCatch #0 {IOException -> 0x009a, blocks: (B:15:0x0053, B:17:0x0059, B:26:0x008f, B:28:0x0095, B:18:0x0068, B:19:0x0077, B:21:0x0084), top: B:83:0x002e }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21, types: [sdk.pendo.io.e2.d0$a] */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.Object, sdk.pendo.io.e2.d0$a] */
    /* JADX WARN: Type inference failed for: r10v4, types: [sdk.pendo.io.e2.d0$a] */
    @Override // sdk.pendo.io.e2.w
    public d0 a(w.a chain) throws IOException {
        boolean z;
        ?? A;
        ?? A2;
        d0.a aVarM;
        e0 e0VarA;
        ?? r10;
        Intrinsics.checkNotNullParameter(chain, "chain");
        g gVar = (g) chain;
        sdk.pendo.io.j2.c exchange = gVar.getExchange();
        Intrinsics.checkNotNull(exchange);
        b0 request = gVar.getRequest();
        c0 body = request.getBody();
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            exchange.a(request);
            A = f.a(request.getCom.google.firebase.analytics.FirebaseAnalytics.Param.METHOD java.lang.String());
            try {
                if (A == 0 || body == null) {
                    exchange.n();
                    z = true;
                    A = 0;
                } else {
                    if (StringsKt.equals("100-continue", request.a("Expect"), true)) {
                        exchange.d();
                        A = exchange.a(true);
                        try {
                            exchange.o();
                            z = false;
                            r10 = A;
                        } catch (IOException e) {
                            e = e;
                            z = true;
                            if (e instanceof sdk.pendo.io.m2.a) {
                                throw e;
                            }
                            if (!exchange.getHasFailure()) {
                                A2 = A;
                                throw e;
                            }
                        }
                    } else {
                        z = true;
                        r10 = 0;
                    }
                    if (r10 != 0) {
                        exchange.n();
                        if (!exchange.getConnection().i()) {
                            A = r10;
                            exchange.m();
                            A = r10;
                        }
                    } else if (body.c()) {
                        exchange.d();
                        body.a(o.a(exchange.a(request, true)));
                    } else {
                        sdk.pendo.io.s2.e eVarA = o.a(exchange.a(request, false));
                        body.a(eVarA);
                        eVarA.close();
                    }
                }
                if (body != null) {
                    A = r10;
                    if (!body.c()) {
                        A = r10;
                        A = r10;
                        A = r10;
                        exchange.c();
                    }
                } else {
                    A = r10;
                    A = r10;
                    A = r10;
                    exchange.c();
                }
                A = r10;
                e = null;
                A2 = A;
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            e = e3;
            z = true;
            A = 0;
        }
        if (A2 == 0) {
            try {
                A2 = exchange.a(false);
                Intrinsics.checkNotNull(A2);
                if (z) {
                    exchange.o();
                    z = false;
                }
            } catch (IOException e4) {
                if (e == null) {
                    throw e4;
                }
                ExceptionsKt.addSuppressed(e, e4);
                throw e;
            }
        }
        d0 d0VarA = A2.a(request).a(exchange.getConnection().getHandshake()).b(jCurrentTimeMillis).a(System.currentTimeMillis()).a();
        int code = d0VarA.getCode();
        if (a(code)) {
            d0.a aVarA = exchange.a(false);
            Intrinsics.checkNotNull(aVarA);
            if (z) {
                exchange.o();
            }
            d0VarA = aVarA.a(request).a(exchange.getConnection().getHandshake()).b(jCurrentTimeMillis).a(System.currentTimeMillis()).a();
            code = d0VarA.getCode();
        }
        exchange.b(d0VarA);
        if (this.forWebSocket && code == 101) {
            aVarM = d0VarA.m();
            e0VarA = sdk.pendo.io.f2.b.c;
        } else {
            aVarM = d0VarA.m();
            e0VarA = exchange.a(d0VarA);
        }
        d0 d0VarA2 = aVarM.a(e0VarA).a();
        if (StringsKt.equals(HeaderElements.CLOSE, d0VarA2.getRequest().a("Connection"), true) || StringsKt.equals(HeaderElements.CLOSE, d0.a(d0VarA2, "Connection", null, 2, null), true)) {
            exchange.m();
        }
        if (code == 204 || code == 205) {
            e0 e0VarB = d0VarA2.b();
            if ((e0VarB != null ? e0VarB.getContentLength() : -1L) > 0) {
                StringBuilder sbAppend = new StringBuilder("HTTP ").append(code).append(" had non-zero Content-Length: ");
                e0 e0VarB2 = d0VarA2.b();
                throw new ProtocolException(sbAppend.append(e0VarB2 != null ? Long.valueOf(e0VarB2.getContentLength()) : null).toString());
            }
        }
        return d0VarA2;
    }
}
