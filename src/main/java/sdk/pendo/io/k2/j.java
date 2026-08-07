package sdk.pendo.io.k2;

import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import sdk.pendo.io.e2.b0;
import sdk.pendo.io.e2.c0;
import sdk.pendo.io.e2.d0;
import sdk.pendo.io.e2.e0;
import sdk.pendo.io.e2.f0;
import sdk.pendo.io.e2.v;
import sdk.pendo.io.e2.w;
import sdk.pendo.io.e2.z;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J(\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u001c\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\n\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0016¨\u0006\u001b"}, d2 = {"Lsdk/pendo/io/k2/j;", "Lsdk/pendo/io/e2/w;", "Ljava/io/IOException;", "e", "Lsdk/pendo/io/j2/e;", NotificationCompat.CATEGORY_CALL, "Lsdk/pendo/io/e2/b0;", "userRequest", "", "requestSendStarted", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/e2/d0;", "userResponse", "Lsdk/pendo/io/j2/c;", "exchange", "", FirebaseAnalytics.Param.METHOD, "", "defaultDelay", "Lsdk/pendo/io/e2/w$a;", "chain", "Lsdk/pendo/io/e2/z;", "Lsdk/pendo/io/e2/z;", "client", "<init>", "(Lokhttp3/OkHttpClient;)V", "b", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class j implements w {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final z client;

    public j(z client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
    }

    private final b0 a(d0 userResponse, String method) {
        String strA;
        v vVarD;
        c0 body = null;
        if (!this.client.getFollowRedirects() || (strA = d0.a(userResponse, "Location", null, 2, null)) == null || (vVarD = userResponse.getRequest().i().d(strA)) == null) {
            return null;
        }
        if (!Intrinsics.areEqual(vVarD.getScheme(), userResponse.getRequest().i().getScheme()) && !this.client.getFollowSslRedirects()) {
            return null;
        }
        b0.a aVarH = userResponse.getRequest().h();
        if (f.a(method)) {
            int code = userResponse.getCode();
            f fVar = f.a;
            boolean z = fVar.c(method) || code == 308 || code == 307;
            if (fVar.b(method) && code != 308 && code != 307) {
                method = "GET";
            } else if (z) {
                body = userResponse.getRequest().getBody();
            }
            aVarH.a(method, body);
            if (!z) {
                aVarH.a("Transfer-Encoding");
                aVarH.a("Content-Length");
                aVarH.a("Content-Type");
            }
        }
        if (!sdk.pendo.io.f2.b.a(userResponse.getRequest().i(), vVarD)) {
            aVarH.a("Authorization");
        }
        return aVarH.a(vVarD).a();
    }

    private final b0 a(d0 userResponse, sdk.pendo.io.j2.c exchange) throws ProtocolException {
        sdk.pendo.io.j2.f connection;
        f0 route = (exchange == null || (connection = exchange.getConnection()) == null) ? null : connection.getRoute();
        int code = userResponse.getCode();
        String str = userResponse.getRequest().getCom.google.firebase.analytics.FirebaseAnalytics.Param.METHOD java.lang.String();
        if (code != 307 && code != 308) {
            if (code == 401) {
                return this.client.getAuthenticator().a(route, userResponse);
            }
            if (code == 421) {
                c0 body = userResponse.getRequest().getBody();
                if ((body != null && body.d()) || exchange == null || !exchange.j()) {
                    return null;
                }
                exchange.getConnection().j();
                return userResponse.getRequest();
            }
            if (code == 503) {
                d0 priorResponse = userResponse.getPriorResponse();
                if ((priorResponse == null || priorResponse.getCode() != 503) && a(userResponse, Integer.MAX_VALUE) == 0) {
                    return userResponse.getRequest();
                }
                return null;
            }
            if (code == 407) {
                Intrinsics.checkNotNull(route);
                if (route.getProxy().type() == Proxy.Type.HTTP) {
                    return this.client.getProxyAuthenticator().a(route, userResponse);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (code == 408) {
                if (!this.client.getRetryOnConnectionFailure()) {
                    return null;
                }
                c0 body2 = userResponse.getRequest().getBody();
                if (body2 != null && body2.d()) {
                    return null;
                }
                d0 priorResponse2 = userResponse.getPriorResponse();
                if ((priorResponse2 == null || priorResponse2.getCode() != 408) && a(userResponse, 0) <= 0) {
                    return userResponse.getRequest();
                }
                return null;
            }
            switch (code) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        return a(userResponse, str);
    }

    @Override // sdk.pendo.io.e2.w
    public d0 a(w.a chain) {
        IOException e;
        d0 d0VarA;
        Intrinsics.checkNotNullParameter(chain, "chain");
        g gVar = (g) chain;
        b0 request = gVar.getRequest();
        sdk.pendo.io.j2.e call = gVar.getCall();
        List listEmptyList = CollectionsKt.emptyList();
        int i = 0;
        d0 d0Var = null;
        while (true) {
            boolean z = true;
            while (true) {
                call.a(request, z);
                try {
                    if (call.getCanceled()) {
                        throw new IOException("Canceled");
                    }
                    try {
                        d0VarA = gVar.a(request);
                    } catch (IOException e2) {
                        e = e2;
                        if (!a(e, call, request, !(e instanceof sdk.pendo.io.m2.a))) {
                            throw sdk.pendo.io.f2.b.a(e, (List<? extends Exception>) listEmptyList);
                        }
                        listEmptyList = CollectionsKt.plus((Collection<? extends IOException>) listEmptyList, e);
                        call.a(true);
                        z = false;
                    } catch (sdk.pendo.io.j2.i e3) {
                        if (!a(e3.getLastConnectException(), call, request, false)) {
                            throw sdk.pendo.io.f2.b.a(e3.getFirstConnectException(), (List<? extends Exception>) listEmptyList);
                        }
                        e = e3.getFirstConnectException();
                        listEmptyList = CollectionsKt.plus((Collection<? extends IOException>) listEmptyList, e);
                        call.a(true);
                        z = false;
                    }
                    call.a(true);
                    z = false;
                } catch (Throwable th) {
                    call.a(true);
                    throw th;
                }
            }
            if (d0Var != null) {
                d0VarA = d0VarA.m().d(d0Var.m().a((e0) null).a()).a();
            }
            d0Var = d0VarA;
            sdk.pendo.io.j2.c interceptorScopedExchange = call.getInterceptorScopedExchange();
            b0 b0VarA = a(d0Var, interceptorScopedExchange);
            if (b0VarA == null) {
                if (interceptorScopedExchange != null && interceptorScopedExchange.getIsDuplex()) {
                    call.m();
                }
                call.a(false);
                return d0Var;
            }
            c0 body = b0VarA.getBody();
            if (body != null && body.d()) {
                call.a(false);
                return d0Var;
            }
            e0 e0VarB = d0Var.b();
            if (e0VarB != null) {
                sdk.pendo.io.f2.b.a(e0VarB);
            }
            i++;
            if (i > 20) {
                throw new ProtocolException("Too many follow-up requests: " + i);
            }
            call.a(true);
            request = b0VarA;
        }
    }

    private final boolean a(IOException e, boolean requestSendStarted) {
        if (e instanceof ProtocolException) {
            return false;
        }
        if (e instanceof InterruptedIOException) {
            return (e instanceof SocketTimeoutException) && !requestSendStarted;
        }
        return (((e instanceof SSLHandshakeException) && (e.getCause() instanceof CertificateException)) || (e instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private final boolean a(IOException e, sdk.pendo.io.j2.e call, b0 userRequest, boolean requestSendStarted) {
        if (this.client.getRetryOnConnectionFailure()) {
            return !(requestSendStarted && a(e, userRequest)) && a(e, requestSendStarted) && call.l();
        }
        return false;
    }

    private final boolean a(IOException e, b0 userRequest) {
        c0 body = userRequest.getBody();
        return (body != null && body.d()) || (e instanceof FileNotFoundException);
    }

    private final int a(d0 userResponse, int defaultDelay) {
        String strA = d0.a(userResponse, "Retry-After", null, 2, null);
        if (strA == null) {
            return defaultDelay;
        }
        if (!new Regex("\\d+").matches(strA)) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strA);
        Intrinsics.checkNotNullExpressionValue(numValueOf, "valueOf(header)");
        return numValueOf.intValue();
    }
}
