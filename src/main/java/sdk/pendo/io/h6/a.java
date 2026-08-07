package sdk.pendo.io.h6;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.a0.l;
import sdk.pendo.io.e2.b0;
import sdk.pendo.io.e2.d0;
import sdk.pendo.io.e2.v;
import sdk.pendo.io.e2.w;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.w7.b;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\t\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/h6/a;", "Lsdk/pendo/io/e2/w;", "", "error", "url", "", "b", "Lsdk/pendo/io/e2/d0;", "response", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "content", "Lsdk/pendo/io/e2/w$a;", "chain", "Lsdk/pendo/io/w7/a;", "Lsdk/pendo/io/w7/a;", "getFile", "()Lsdk/pendo/io/w7/a;", "file", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a implements w {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final sdk.pendo.io.w7.a file;

    public a() {
        b bVarA = b.INSTANCE.a();
        File externalFilesDir = PendoInternal.o().getExternalFilesDir(null);
        Intrinsics.checkNotNull(externalFilesDir);
        this.file = b.a(bVarA, "PNDQaLogs.txt", externalFilesDir, null, false, 12, null);
    }

    private final String a(String error, String url) {
        l lVar = new l();
        try {
            lVar.a("content", error);
            lVar.a("request", url);
            lVar.a("timestamp", Long.valueOf(System.currentTimeMillis()));
        } catch (Exception e) {
            PendoLogger.d(e, "could not create file content json " + lVar, new Object[0]);
        }
        String string = lVar.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final void b(String error, String url) {
        a(a(error, url));
    }

    private final String a(d0 response, String url) {
        l lVar = new l();
        try {
            String str = response.getCode() + " " + url;
            lVar.a("content", sdk.pendo.io.s7.a.a.a(response.getBody()));
            lVar.a("request", str);
            lVar.a("timestamp", Long.valueOf(System.currentTimeMillis()));
        } catch (Exception e) {
            PendoLogger.d(e, "could not create file content json " + lVar, new Object[0]);
        }
        String string = lVar.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final void b(d0 response, String url) {
        a(a(response, url));
    }

    @Override // sdk.pendo.io.e2.w
    public d0 a(w.a chain) throws Exception {
        Intrinsics.checkNotNullParameter(chain, "chain");
        b0 b0VarRequest = chain.request();
        v url = b0VarRequest.getUrl();
        try {
            d0 d0VarA = chain.a(b0VarRequest);
            b(d0VarA, url.getUrl());
            return d0VarA;
        } catch (Exception e) {
            b(e.toString(), url.getUrl());
            throw e;
        }
    }

    private final void a(String content) {
        sdk.pendo.io.w7.a aVar = this.file;
        if (aVar != null) {
            aVar.a(content + "\n");
        }
    }
}
