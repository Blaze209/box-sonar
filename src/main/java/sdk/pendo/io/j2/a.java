package sdk.pendo.io.j2;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.e2.d0;
import sdk.pendo.io.e2.w;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lsdk/pendo/io/j2/a;", "Lsdk/pendo/io/e2/w;", "Lsdk/pendo/io/e2/w$a;", "chain", "Lsdk/pendo/io/e2/d0;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class a implements w {
    public static final a a = new a();

    private a() {
    }

    @Override // sdk.pendo.io.e2.w
    public d0 a(w.a chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        sdk.pendo.io.k2.g gVar = (sdk.pendo.io.k2.g) chain;
        return sdk.pendo.io.k2.g.a(gVar, 0, gVar.getCall().a(gVar), null, 0, 0, 0, 61, null).a(gVar.getRequest());
    }
}
