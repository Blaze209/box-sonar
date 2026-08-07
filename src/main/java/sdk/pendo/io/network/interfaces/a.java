package sdk.pendo.io.network.interfaces;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.analytics.data.IdentifyData;
import sdk.pendo.io.e2.b0;
import sdk.pendo.io.e2.d0;
import sdk.pendo.io.e2.w;
import sdk.pendo.io.e2.z;
import sdk.pendo.io.j4.b;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.l4.s;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.SessionData;
import sdk.pendo.io.network.responses.converters.gson.PendoGsonConverterFactory;
import sdk.pendo.io.s4.g;
import sdk.pendo.io.s7.j0;
import sdk.pendo.io.s7.p0;
import sdk.pendo.io.s7.u0;
import sdk.pendo.io.utilities.AndroidUtils;
import sdk.pendo.io.w6.d;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    public static boolean a = false;
    private static final Object b = new Object();
    private static Context c;
    private static String d;
    private static String e;
    private static String f;
    private static String g;
    private static String h;
    private static final long i;
    private static final long j;
    private static volatile String k;
    private static final sdk.pendo.io.j4.a<GetAuthToken.GetAuthTokenResponse> l;
    private static final b<EnumC0439a> m;
    private static z n;
    private static HttpLoggingInterceptor o;
    private static Uri p;
    private static s.b q;
    private static Map<String, s.b> r;
    public static sdk.pendo.io.g6.a s;
    private static final w t;
    private static final w u;

    /* JADX INFO: renamed from: sdk.pendo.io.network.interfaces.a$a, reason: collision with other inner class name */
    public enum EnumC0439a {
        SUCCESS,
        FAILED
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        i = timeUnit.toMillis(15L);
        j = timeUnit.toMillis(15L);
        l = sdk.pendo.io.j4.a.m();
        m = b.m();
        n = null;
        r = new HashMap();
        t = new w() { // from class: sdk.pendo.io.network.interfaces.a$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.e2.w
            public final d0 a(w.a aVar) {
                return a.a(aVar);
            }
        };
        u = new w() { // from class: sdk.pendo.io.network.interfaces.a$$ExternalSyntheticLambda1
            @Override // sdk.pendo.io.e2.w
            public final d0 a(w.a aVar) {
                return a.b(aVar);
            }
        };
    }

    public static void a(b0.a aVar) {
        String str = d;
        if (str != null) {
            aVar.a("X-Pendo-App-Key", str);
        }
    }

    private static void b(b0.a aVar) {
        f(aVar);
        aVar.a("X-Pendo-Device-Time", Long.toString(System.currentTimeMillis()));
        aVar.a("X-Pendo-OS", "android");
        aVar.a("X-Pendo-Request-Id", p0.INSTANCE.a(16));
        aVar.a("X-Pendo-Session-Id", d.INSTANCE.d());
        String strA = u0.a();
        if (strA != null) {
            aVar.a("X-Pendo-SDK-Ver", strA);
        }
        String strG = AndroidUtils.g();
        if (strG != null) {
            aVar.a("X-Pendo-Device-ID", strG);
        } else {
            PendoLogger.w("device id is null!", new Object[0]);
        }
        String strD = AndroidUtils.d();
        if (strD != null) {
            aVar.a("X-Pendo-App-Ver", strD);
        }
        aVar.a("X-Pendo-App-Ver-Code", String.valueOf(AndroidUtils.c()));
        String str = AndroidUtils.OS_VERSION;
        if (str != null) {
            aVar.a("X-Pendo-OS-Version", str);
        }
        aVar.a("X-Pendo-Deployment-Target", Integer.toString(AndroidUtils.e()));
        aVar.a("X-Pendo-Target-Version", Integer.toString(AndroidUtils.f()));
        e(aVar);
        c(aVar);
    }

    public static void c(b0.a aVar) {
        String str = e;
        if (str != null) {
            aVar.a("X-Pendo-Framework", str);
        }
        String str2 = f;
        if (str2 != null) {
            aVar.a("X-Pendo-Framework-Type", str2);
        }
        String str3 = g;
        if (str3 != null) {
            aVar.a("X-Pendo-Framework-Version", str3);
        }
        String str4 = h;
        if (str4 != null) {
            aVar.a("X-Pendo-Plugin-Version", str4);
        }
    }

    private static void d(b0.a aVar) {
        SessionData sessionDataA = PendoInternal.A();
        IdentifyData identifyData = sessionDataA != null ? sessionDataA.getIdentifyData() : null;
        if (identifyData != null) {
            aVar.a("X-Pendo-Encoded-Old-Visitor-ID", AndroidUtils.a(identifyData.getOldAnonymousVisitor()));
        }
    }

    private static void e(b0.a aVar) {
        if (a) {
            aVar.a("X-Pendo-Redirect", Integer.toString(1));
        }
    }

    private static void f(b0.a aVar) {
        b0 b0VarA = aVar.a();
        if (TextUtils.isEmpty(b0VarA.a("X-Pendo-JWT")) || TextUtils.isEmpty(b0VarA.a("X-Pendo-SigningKeyName"))) {
            String strS = PendoInternal.s();
            String strD = PendoInternal.D();
            if (PendoInternal.R()) {
                aVar.a("X-Pendo-JWT", strS);
                aVar.a("X-Pendo-SigningKeyName", strD);
                return;
            }
            String strG = PendoInternal.G();
            String strL = PendoInternal.l();
            if (!TextUtils.isEmpty(strG)) {
                aVar.a("X-Pendo-Encoded-Visitor-Id", AndroidUtils.a(strG));
            }
            if (TextUtils.isEmpty(strL)) {
                return;
            }
            aVar.a("X-Pendo-Encoded-Account-Id", AndroidUtils.a(strL));
        }
    }

    public static Uri g() {
        Uri uriA;
        Uri uri = p;
        if (uri != null) {
            return uri;
        }
        synchronized (b) {
            uriA = j0.a.a();
            p = uriA;
        }
        return uriA;
    }

    public static s.b h() {
        return a(false, g(), false, false);
    }

    public static j<EnumC0439a> i() {
        return m;
    }

    public static HttpLoggingInterceptor.a j() {
        return PendoInternal.N() ? HttpLoggingInterceptor.a.BODY : HttpLoggingInterceptor.a.NONE;
    }

    public static HttpLoggingInterceptor k() {
        return o;
    }

    public static z.a l() {
        if (n == null) {
            try {
                n = new z();
            } catch (AssertionError e2) {
                PendoLogger.e(e2, "Pendo was NOT initialized, this exception is probably caused by a race condition in the host app changing the security provider" + e2.getMessage(), new Object[0]);
                return null;
            }
        }
        z.a aVarV = n.v();
        if (o == null) {
            o = new HttpLoggingInterceptor();
        }
        o.a(j());
        aVarV.a(o);
        return aVarV;
    }

    public static s m() {
        s.b bVarA = a(true, g(), true);
        if (bVarA != null) {
            return bVarA.a();
        }
        return null;
    }

    public static s n() {
        s.b bVarA = a(false, g());
        if (bVarA != null) {
            return bVarA.a();
        }
        return null;
    }

    public static sdk.pendo.io.g6.a o() {
        sdk.pendo.io.g6.a aVar = s;
        if (aVar != null) {
            return aVar;
        }
        s.b bVarH = h();
        s sVarA = bVarH != null ? bVarH.a() : null;
        if (sVarA == null) {
            return null;
        }
        sdk.pendo.io.g6.a aVar2 = (sdk.pendo.io.g6.a) sVarA.a(sdk.pendo.io.g6.a.class);
        s = aVar2;
        return aVar2;
    }

    public static s p() {
        return a(PendoGsonConverterFactory.create(new external.sdk.pendo.io.gson.a().b().a()));
    }

    public static s.b q() {
        return a(false, g());
    }

    private static void a(z.a aVar) {
        if (sdk.pendo.io.y7.a.INSTANCE.a().a(c)) {
            aVar.a(new sdk.pendo.io.h6.a());
        }
    }

    public static String b() {
        return k;
    }

    public static j<GetAuthToken.GetAuthTokenResponse> c() {
        return l;
    }

    public static s d() {
        s.b bVarE = e();
        if (bVarE == null) {
            return null;
        }
        return bVarE.a();
    }

    private static s.b e() {
        return a(false, g());
    }

    public static z f() {
        z.a aVarL = l();
        if (aVarL == null) {
            return null;
        }
        return aVarL.a();
    }

    public static void a() {
        p = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ d0 b(w.a aVar) {
        b0.a aVarH = aVar.request().h();
        b(aVarH);
        a(aVarH);
        return aVar.a(aVarH.a());
    }

    public static void a(EnumC0439a enumC0439a) {
        m.onNext(enumC0439a);
    }

    public static void a(Boolean bool) {
        a = bool.booleanValue();
    }

    public static s.b a(boolean z, Uri uri) {
        return a(z, uri, false);
    }

    public static synchronized s.b a(boolean z, Uri uri, boolean z2) {
        return a(z, uri, z2, true);
    }

    public static synchronized s.b a(boolean z, Uri uri, boolean z2, boolean z3) {
        w wVar;
        if (uri == null) {
            return null;
        }
        String host = uri.getHost();
        String string = uri.toString();
        z.a aVarL = l();
        if (aVarL == null) {
            return null;
        }
        if (z) {
            s.b bVar = q;
            if (bVar != null && !z2) {
                return bVar;
            }
            wVar = u;
        } else {
            s.b bVar2 = r.get(host);
            if (bVar2 != null && !z2) {
                return bVar2.a(string);
            }
            wVar = t;
        }
        aVarL.a(wVar);
        s.b bVar3 = new s.b();
        a(aVarL);
        long j2 = i;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        aVarL.a(j2, timeUnit);
        aVarL.b(j, timeUnit);
        bVar3.a(aVarL.a()).a(PendoGsonConverterFactory.create());
        if (z3) {
            bVar3.a(g.a());
        }
        bVar3.a(string);
        a(z, bVar3, host);
        return bVar3;
    }

    public static s a(PendoGsonConverterFactory pendoGsonConverterFactory) {
        s.b bVarA = a(false, g(), true);
        if (bVarA != null) {
            return bVarA.a(pendoGsonConverterFactory).a();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ d0 a(w.a aVar) {
        b0.a aVarH = aVar.request().h();
        b(aVarH);
        if (sdk.pendo.io.s7.d0.b(aVar.request().i())) {
            a(aVarH);
        } else {
            String strB = b();
            if (strB != null) {
                aVarH.a("Authorization", "Bearer " + strB);
            }
            if (sdk.pendo.io.s7.d0.a(aVar.request().i())) {
                d(aVarH);
            }
        }
        return aVar.a(aVarH.a());
    }

    public static void a(GetAuthToken.GetAuthTokenResponse getAuthTokenResponse) {
        k = getAuthTokenResponse.accessToken;
        l.onNext(getAuthTokenResponse);
    }

    public static void a(String str) {
        d = str;
    }

    public static void a(Context context) {
        c = context;
    }

    public static void a(String str, String str2, String str3, String str4) {
        e = str;
        f = str2;
        g = str3;
        h = str4;
    }

    public static void a(boolean z) {
        HttpLoggingInterceptor httpLoggingInterceptorK = k();
        if (httpLoggingInterceptorK != null) {
            httpLoggingInterceptorK.a(z ? HttpLoggingInterceptor.a.BODY : HttpLoggingInterceptor.a.NONE);
        }
    }

    private static void a(boolean z, s.b bVar, String str) {
        if (z) {
            if (q == null) {
                q = bVar;
            }
        } else {
            if (r.containsKey(str)) {
                return;
            }
            r.put(str, bVar);
        }
    }
}
