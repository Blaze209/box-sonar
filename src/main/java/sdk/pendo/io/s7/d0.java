package sdk.pendo.io.s7;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u001c\u0010\u0007\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lsdk/pendo/io/e2/v;", "url", "", "initPath", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "registerPath", "b", "pendoIO_release"}, k = 2, mv = {1, 9, 0})
public final class d0 {
    public static final boolean a(sdk.pendo.io.e2.v vVar) {
        return a(vVar, null, 2, null);
    }

    public static final boolean b(sdk.pendo.io.e2.v vVar) {
        return b(vVar, null, 2, null);
    }

    public static final boolean a(sdk.pendo.io.e2.v vVar, String initPath) {
        Intrinsics.checkNotNullParameter(initPath, "initPath");
        if (vVar == null) {
            return false;
        }
        return StringsKt.contains$default((CharSequence) vVar.getUrl(), (CharSequence) initPath, false, 2, (Object) null);
    }

    public static final boolean b(sdk.pendo.io.e2.v vVar, String registerPath) {
        Intrinsics.checkNotNullParameter(registerPath, "registerPath");
        if (vVar == null) {
            return false;
        }
        return StringsKt.contains$default((CharSequence) vVar.getUrl(), (CharSequence) registerPath, false, 2, (Object) null);
    }

    public static /* synthetic */ boolean a(sdk.pendo.io.e2.v vVar, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "/devices/init";
        }
        return a(vVar, str);
    }

    public static /* synthetic */ boolean b(sdk.pendo.io.e2.v vVar, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "/devices/register";
        }
        return b(vVar, str);
    }
}
