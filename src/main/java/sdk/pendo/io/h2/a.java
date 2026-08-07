package sdk.pendo.io.h2;

import androidx.media3.exoplayer.upstream.CmcdData;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.e2.a0;
import sdk.pendo.io.e2.b0;
import sdk.pendo.io.e2.c;
import sdk.pendo.io.e2.d0;
import sdk.pendo.io.e2.e;
import sdk.pendo.io.e2.e0;
import sdk.pendo.io.e2.r;
import sdk.pendo.io.e2.u;
import sdk.pendo.io.e2.w;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lsdk/pendo/io/h2/a;", "Lsdk/pendo/io/e2/w;", "Lsdk/pendo/io/e2/w$a;", "chain", "Lsdk/pendo/io/e2/d0;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/e2/c;", SemanticAttributes.DbSystemValues.CACHE, "<init>", "(Lokhttp3/Cache;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class a implements w {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: sdk.pendo.io.h2.a$a, reason: collision with other inner class name and from kotlin metadata */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0004\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¨\u0006\u000e"}, d2 = {"Lsdk/pendo/io/h2/a$a;", "", "Lsdk/pendo/io/e2/d0;", "response", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/e2/u;", "cachedHeaders", "networkHeaders", "", "fieldName", "", "b", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean b(String fieldName) {
            return (StringsKt.equals("Connection", fieldName, true) || StringsKt.equals("Keep-Alive", fieldName, true) || StringsKt.equals("Proxy-Authenticate", fieldName, true) || StringsKt.equals("Proxy-Authorization", fieldName, true) || StringsKt.equals("TE", fieldName, true) || StringsKt.equals("Trailers", fieldName, true) || StringsKt.equals("Transfer-Encoding", fieldName, true) || StringsKt.equals("Upgrade", fieldName, true)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final u a(u cachedHeaders, u networkHeaders) {
            u.a aVar = new u.a();
            int size = cachedHeaders.size();
            for (int i = 0; i < size; i++) {
                String strA = cachedHeaders.a(i);
                String strB = cachedHeaders.b(i);
                if ((!StringsKt.equals("Warning", strA, true) || !StringsKt.startsWith$default(strB, "1", false, 2, (Object) null)) && (a(strA) || !b(strA) || networkHeaders.a(strA) == null)) {
                    aVar.b(strA, strB);
                }
            }
            int size2 = networkHeaders.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String strA2 = networkHeaders.a(i2);
                if (!a(strA2) && b(strA2)) {
                    aVar.b(strA2, networkHeaders.b(i2));
                }
            }
            return aVar.a();
        }

        private final boolean a(String fieldName) {
            return StringsKt.equals("Content-Length", fieldName, true) || StringsKt.equals("Content-Encoding", fieldName, true) || StringsKt.equals("Content-Type", fieldName, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final d0 a(d0 response) {
            return (response != null ? response.b() : null) != null ? response.m().a((e0) null).a() : response;
        }
    }

    public a(c cVar) {
    }

    @Override // sdk.pendo.io.e2.w
    public d0 a(w.a chain) {
        r eventListener;
        Intrinsics.checkNotNullParameter(chain, "chain");
        e eVarCall = chain.call();
        b bVarB = new b.C0393b(System.currentTimeMillis(), chain.request(), null).b();
        b0 b0VarB = bVarB.getNetworkRequest();
        d0 d0VarA = bVarB.getCacheResponse();
        sdk.pendo.io.j2.e eVar = eVarCall instanceof sdk.pendo.io.j2.e ? (sdk.pendo.io.j2.e) eVarCall : null;
        if (eVar == null || (eventListener = eVar.getEventListener()) == null) {
            eventListener = r.b;
        }
        if (b0VarB == null && d0VarA == null) {
            d0 d0VarA2 = new d0.a().a(chain.request()).a(a0.HTTP_1_1).a(504).a("Unsatisfiable Request (only-if-cached)").a(sdk.pendo.io.f2.b.c).b(-1L).a(System.currentTimeMillis()).a();
            eventListener.d(eVarCall, d0VarA2);
            return d0VarA2;
        }
        if (b0VarB == null) {
            Intrinsics.checkNotNull(d0VarA);
            d0 d0VarA3 = d0VarA.m().a(INSTANCE.a(d0VarA)).a();
            eventListener.b(eVarCall, d0VarA3);
            return d0VarA3;
        }
        if (d0VarA != null) {
            eventListener.a(eVarCall, d0VarA);
        }
        d0 d0VarA4 = chain.a(b0VarB);
        if (d0VarA != null) {
            if (d0VarA4 != null && d0VarA4.getCode() == 304) {
                d0.a aVarM = d0VarA.m();
                Companion companion = INSTANCE;
                aVarM.a(companion.a(d0VarA.getHeaders(), d0VarA4.getHeaders())).b(d0VarA4.getSentRequestAtMillis()).a(d0VarA4.getReceivedResponseAtMillis()).a(companion.a(d0VarA)).c(companion.a(d0VarA4)).a();
                e0 e0VarB = d0VarA4.b();
                Intrinsics.checkNotNull(e0VarB);
                e0VarB.close();
                Intrinsics.checkNotNull(null);
                throw null;
            }
            e0 e0VarB2 = d0VarA.b();
            if (e0VarB2 != null) {
                sdk.pendo.io.f2.b.a(e0VarB2);
            }
        }
        Intrinsics.checkNotNull(d0VarA4);
        d0.a aVarM2 = d0VarA4.m();
        Companion companion2 = INSTANCE;
        return aVarM2.a(companion2.a(d0VarA)).c(companion2.a(d0VarA4)).a();
    }
}
