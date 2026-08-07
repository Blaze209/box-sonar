package sdk.pendo.io.p7;

import androidx.media3.exoplayer.upstream.CmcdData;
import io.split.android.client.service.ServiceConstants;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import sdk.pendo.io.e2.b0;
import sdk.pendo.io.e2.c0;
import sdk.pendo.io.e2.d0;
import sdk.pendo.io.e2.e0;
import sdk.pendo.io.e2.w;
import sdk.pendo.io.e2.x;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\n¨\u0006\u000e"}, d2 = {"Lsdk/pendo/io/p7/e;", "Lsdk/pendo/io/e2/w;", "Lsdk/pendo/io/e2/b0;", "originalRequest", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/e2/d0;", "response", "Lsdk/pendo/io/e2/w$a;", "chain", "", "Ljava/lang/String;", ServiceConstants.WORKER_PARAM_API_KEY, "<init>", "(Ljava/lang/String;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class e implements w {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String apiKey;

    public e(String apiKey) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        this.apiKey = apiKey;
    }

    private final d0 a(d0 response) {
        String strH;
        e0 e0VarA;
        e0 e0VarA2 = a.a(response);
        if (e0VarA2 == null || (strH = e0VarA2.h()) == null) {
            strH = "[empty body]";
        }
        try {
            String strA = b.a(strH);
            e0.Companion companion = e0.INSTANCE;
            byte[] bytes = strA.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            e0VarA = companion.a(bytes, x.INSTANCE.b("application/json"));
        } catch (Exception unused) {
            e0.Companion companion2 = e0.INSTANCE;
            byte[] bytes2 = strH.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
            e0VarA = companion2.a(bytes2, e0VarA2 != null ? e0VarA2.getC() : null);
        }
        return response.m().a(e0VarA).a();
    }

    @Override // sdk.pendo.io.e2.w
    public d0 a(w.a chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        return a(chain.a(a(chain.request())));
    }

    private final b0 a(b0 originalRequest) throws IOException {
        String str = originalRequest.getCom.google.firebase.analytics.FirebaseAnalytics.Param.METHOD java.lang.String();
        c0 c0VarA = a.a(originalRequest);
        String strA = originalRequest.a("Content-Encoding");
        b0.a aVarB = originalRequest.h().a(a.b(originalRequest).j().a(this.apiKey).a()).b("User-Agent", f.b());
        if (c0VarA != null && strA != null && strA.length() != 0 && CollectionsKt.listOf((Object[]) new String[]{"POST", "PUT", "PATCH"}).contains(str)) {
            sdk.pendo.io.s2.d dVar = new sdk.pendo.io.s2.d();
            c0VarA.a(dVar);
            byte[] byteArray = dVar.readByteArray();
            if (Intrinsics.areEqual(strA, "gzip")) {
                byteArray = b.a(byteArray);
            } else if (Intrinsics.areEqual(strA, "deflate")) {
                byteArray = b.b(byteArray);
            }
            byte[] bArr = byteArray;
            x contentType = c0VarA.getContentType();
            if (contentType == null) {
                contentType = x.INSTANCE.b("application/json");
            }
            aVarB.a(str, c0.Companion.a(c0.INSTANCE, contentType, bArr, 0, 0, 12, (Object) null));
        }
        return aVarB.a();
    }
}
