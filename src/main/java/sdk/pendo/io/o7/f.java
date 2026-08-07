package sdk.pendo.io.o7;

import android.app.Activity;
import android.app.Application;
import io.split.android.client.service.ServiceConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.h7.p;
import sdk.pendo.io.h7.r;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/o7/f;", "Lsdk/pendo/io/o7/e;", "Landroid/app/Activity;", "activity", "", "c", "Landroid/app/Application;", "applicationContext", "", ServiceConstants.WORKER_PARAM_API_KEY, "baseUrl", "Lsdk/pendo/io/p5/a;", "pendoComponents", "", "scanDebounceMs", "scanTimeoutMs", "Lsdk/pendo/io/z6/b;", "dispatcherProvider", "<init>", "(Landroid/app/Application;Ljava/lang/String;Ljava/lang/String;Lsdk/pendo/io/p5/a;JJLsdk/pendo/io/z6/b;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class f extends e {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Application applicationContext, String apiKey, String baseUrl, sdk.pendo.io.p5.a pendoComponents, long j, long j2, sdk.pendo.io.z6.b dispatcherProvider) {
        super(applicationContext, apiKey, baseUrl, Pendo.PendoOptions.Framework.REACT_NATIVE, pendoComponents, j, j2, dispatcherProvider);
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(pendoComponents, "pendoComponents");
        Intrinsics.checkNotNullParameter(dispatcherProvider, "dispatcherProvider");
    }

    @Override // sdk.pendo.io.o7.e
    public void c(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        p pVarA = a(activity);
        int width = pVarA.getWidth();
        if (r.a.i()) {
            width += 6;
        }
        a(p.a(pVarA, width, 0, 0, 0, 0, 0, 22, null));
    }

    public /* synthetic */ f(Application application, String str, String str2, sdk.pendo.io.p5.a aVar, long j, long j2, sdk.pendo.io.z6.b bVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, str, str2, aVar, (i & 16) != 0 ? r.a.g() : j, (i & 32) != 0 ? r.a.h() : j2, (i & 64) != 0 ? sdk.pendo.io.z6.a.a : bVar);
    }
}
