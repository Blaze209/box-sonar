package sdk.pendo.io.h7;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.s7.u0;
import sdk.pendo.io.sdk.react.PlatformStateManager;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/h7/r;", "Lsdk/pendo/io/h7/g;", "Lsdk/pendo/io/Pendo$PendoOptions$Framework;", "b", "Lsdk/pendo/io/Pendo$PendoOptions$FrameworkType;", "c", "", "d", "f", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "e", "", "g", CmcdData.STREAMING_FORMAT_HLS, "i", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class r implements g {
    public static final r a = new r();

    private r() {
    }

    @Override // sdk.pendo.io.h7.g
    public String a() {
        String strA = u0.a();
        Intrinsics.checkNotNullExpressionValue(strA, "getSDKVersion(...)");
        return strA;
    }

    public Pendo.PendoOptions.Framework b() {
        return PlatformStateManager.INSTANCE.getFramework();
    }

    public Pendo.PendoOptions.FrameworkType c() {
        return PlatformStateManager.INSTANCE.getFrameworkType();
    }

    public String d() {
        return PlatformStateManager.INSTANCE.getFrameworkVersion();
    }

    public boolean e() {
        return sdk.pendo.io.o6.a.d().h();
    }

    public String f() {
        return PlatformStateManager.INSTANCE.getPluginVersion();
    }

    public long g() {
        return sdk.pendo.io.u6.a.a.a();
    }

    public long h() {
        return sdk.pendo.io.u6.a.a.b();
    }

    public boolean i() {
        return sdk.pendo.io.u6.a.a.c();
    }
}
