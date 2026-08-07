package sdk.pendo.io.network.interfaces;

import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import sdk.pendo.io.e2.b0;
import sdk.pendo.io.e2.c0;
import sdk.pendo.io.e2.d0;
import sdk.pendo.io.e2.e0;
import sdk.pendo.io.e2.j;
import sdk.pendo.io.e2.u;
import sdk.pendo.io.e2.w;
import sdk.pendo.io.e2.x;
import sdk.pendo.io.k2.e;
import sdk.pendo.io.n2.h;
import sdk.pendo.io.s2.d;
import sdk.pendo.io.s2.f;
import sdk.pendo.io.s2.l;

/* JADX INFO: loaded from: classes4.dex */
public final class HttpLoggingInterceptor implements w {
    private static final Charset d = Charset.forName("UTF-8");
    private final Logger a;
    private volatile Set<String> b;
    private volatile a c;

    public interface Logger {
        public static final Logger DEFAULT = new Logger() { // from class: sdk.pendo.io.network.interfaces.HttpLoggingInterceptor$Logger$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.network.interfaces.HttpLoggingInterceptor.Logger
            public final void log(String str) {
                h.b().a("Pendo::" + str, 4, (Throwable) null);
            }
        };

        void log(String str);
    }

    public enum a {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    private static boolean a(u uVar) {
        String strA = uVar.a("Content-Encoding");
        return (strA == null || strA.equalsIgnoreCase("identity") || strA.equalsIgnoreCase("gzip")) ? false : true;
    }

    public HttpLoggingInterceptor(Logger logger) {
        this.b = Collections.emptySet();
        this.c = a.NONE;
        this.a = logger;
    }

    @Override // sdk.pendo.io.e2.w
    public d0 a(w.a aVar) throws Exception {
        long j;
        Long lValueOf;
        Logger logger;
        StringBuilder sbAppend;
        StringBuilder sbAppend2;
        String str;
        a aVar2 = this.c;
        b0 b0VarRequest = aVar.request();
        if (aVar2 == a.NONE) {
            return aVar.a(b0VarRequest);
        }
        boolean z = aVar2 == a.BODY;
        boolean z2 = z || aVar2 == a.HEADERS;
        c0 body = b0VarRequest.getBody();
        boolean z3 = body != null;
        j jVarConnection = aVar.connection();
        String str2 = " ";
        String str3 = "--> " + b0VarRequest.getCom.google.firebase.analytics.FirebaseAnalytics.Param.METHOD java.lang.String() + ' ' + b0VarRequest.i() + (jVarConnection != null ? " " + jVarConnection.protocol() : "");
        if (!z2 && z3) {
            str3 = str3 + " (" + body.a() + "-byte body)";
        }
        this.a.log(str3);
        if (z2) {
            if (z3) {
                if (body.getContentType() != null) {
                    j = -1;
                    this.a.log("Content-Type: " + body.getContentType());
                } else {
                    j = -1;
                }
                if (body.a() != j) {
                    this.a.log("Content-Length: " + body.a());
                }
            } else {
                j = -1;
            }
            u headers = b0VarRequest.getHeaders();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String strA = headers.a(i);
                if (!"Content-Type".equalsIgnoreCase(strA) && !"Content-Length".equalsIgnoreCase(strA)) {
                    a(headers, i);
                }
            }
            if (z && z3) {
                if (a(b0VarRequest.getHeaders())) {
                    logger = this.a;
                    sbAppend2 = new StringBuilder("--> END ").append(b0VarRequest.getCom.google.firebase.analytics.FirebaseAnalytics.Param.METHOD java.lang.String());
                    str = " (encoded body omitted)";
                } else if (body.c()) {
                    logger = this.a;
                    sbAppend2 = new StringBuilder("--> END ").append(b0VarRequest.getCom.google.firebase.analytics.FirebaseAnalytics.Param.METHOD java.lang.String());
                    str = " (duplex request body omitted)";
                } else {
                    d dVar = new d();
                    body.a(dVar);
                    Charset charsetA = d;
                    x contentType = body.getContentType();
                    if (contentType != null) {
                        charsetA = contentType.a(charsetA);
                    }
                    this.a.log("");
                    if (a(dVar)) {
                        this.a.log(dVar.readString(charsetA));
                        logger = this.a;
                        sbAppend = new StringBuilder("--> END ").append(b0VarRequest.getCom.google.firebase.analytics.FirebaseAnalytics.Param.METHOD java.lang.String()).append(" (").append(body.a()).append("-byte body)");
                    } else {
                        logger = this.a;
                        sbAppend = new StringBuilder("--> END ").append(b0VarRequest.getCom.google.firebase.analytics.FirebaseAnalytics.Param.METHOD java.lang.String()).append(" (binary ").append(body.a()).append("-byte body omitted)");
                    }
                }
                sbAppend = sbAppend2.append(str);
            } else {
                logger = this.a;
                sbAppend = new StringBuilder("--> END ").append(b0VarRequest.getCom.google.firebase.analytics.FirebaseAnalytics.Param.METHOD java.lang.String());
            }
            logger.log(sbAppend.toString());
        } else {
            str2 = " ";
            j = -1;
        }
        long jNanoTime = System.nanoTime();
        try {
            d0 d0VarA = aVar.a(b0VarRequest);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
            e0 e0VarB = d0VarA.b();
            long contentLength = e0VarB.getContentLength();
            this.a.log("<-- " + d0VarA.getCode() + (d0VarA.getMessage().isEmpty() ? "" : str2 + d0VarA.getMessage()) + ' ' + d0VarA.getRequest().i() + " (" + millis + "ms" + (z2 == 0 ? ", " + (contentLength != j ? contentLength + "-byte" : "unknown-length") + " body" : "") + ')');
            if (z2) {
                u headers2 = d0VarA.getHeaders();
                int size2 = headers2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    a(headers2, i2);
                }
                if (z && e.a(d0VarA)) {
                    if (a(d0VarA.getHeaders())) {
                        this.a.log("<-- END HTTP (encoded body omitted)");
                        return d0VarA;
                    }
                    f source = e0VarB.getSource();
                    source.request(Long.MAX_VALUE);
                    d bufferField = source.getBufferField();
                    if ("gzip".equalsIgnoreCase(headers2.a("Content-Encoding"))) {
                        lValueOf = Long.valueOf(bufferField.getSize());
                        l lVar = new l(bufferField.clone());
                        try {
                            bufferField = new d();
                            bufferField.a(lVar);
                            lVar.close();
                        } catch (Throwable th) {
                            try {
                                lVar.close();
                                throw th;
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                                throw th;
                            }
                        }
                    } else {
                        lValueOf = null;
                    }
                    Charset charsetA2 = d;
                    x c = e0VarB.getC();
                    if (c != null) {
                        charsetA2 = c.a(charsetA2);
                    }
                    if (!a(bufferField)) {
                        this.a.log("");
                        this.a.log("<-- END HTTP (binary " + bufferField.getSize() + "-byte body omitted)");
                        return d0VarA;
                    }
                    if (contentLength != 0) {
                        this.a.log("");
                        this.a.log(bufferField.clone().readString(charsetA2));
                    }
                    if (lValueOf != null) {
                        this.a.log("<-- END HTTP (" + bufferField.getSize() + "-byte, " + lValueOf + "-gzipped-byte body)");
                        return d0VarA;
                    }
                    this.a.log("<-- END HTTP (" + bufferField.getSize() + "-byte body)");
                    return d0VarA;
                }
                this.a.log("<-- END HTTP");
            }
            return d0VarA;
        } catch (Exception e) {
            this.a.log("<-- HTTP FAILED: " + e);
            throw e;
        }
    }

    static boolean a(d dVar) {
        try {
            d dVar2 = new d();
            dVar.a(dVar2, 0L, dVar.getSize() < 64 ? dVar.getSize() : 64L);
            for (int i = 0; i < 16 && !dVar2.exhausted(); i++) {
                int utf8CodePoint = dVar2.readUtf8CodePoint();
                if (Character.isISOControl(utf8CodePoint) && !Character.isWhitespace(utf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    private void a(u uVar, int i) {
        this.a.log(uVar.a(i) + ": " + (this.b.contains(uVar.a(i)) ? "██" : uVar.b(i)));
    }

    public HttpLoggingInterceptor a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException("level == null. Use Level.NONE instead.");
        }
        this.c = aVar;
        return this;
    }
}
