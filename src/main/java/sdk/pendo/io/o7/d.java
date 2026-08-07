package sdk.pendo.io.o7;

import android.app.Application;
import androidx.media3.exoplayer.upstream.CmcdData;
import io.split.android.client.service.ServiceConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.Pendo;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/o7/d;", "", "Landroid/app/Application;", "applicationContext", "", ServiceConstants.WORKER_PARAM_API_KEY, "baseUrl", "Lsdk/pendo/io/Pendo$PendoOptions$Framework;", "framework", "Lsdk/pendo/io/p5/a;", "pendoComponents", "Lsdk/pendo/io/o7/g;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class d {
    public static final d a = new d();

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Pendo.PendoOptions.Framework.values().length];
            try {
                iArr[Pendo.PendoOptions.Framework.NATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Pendo.PendoOptions.Framework.MAUI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Pendo.PendoOptions.Framework.XAMARIN_FORMS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Pendo.PendoOptions.Framework.REACT_NATIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Pendo.PendoOptions.Framework.FLUTTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    private d() {
    }

    public final g a(Application applicationContext, String apiKey, String baseUrl, Pendo.PendoOptions.Framework framework, sdk.pendo.io.p5.a pendoComponents) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(framework, "framework");
        Intrinsics.checkNotNullParameter(pendoComponents, "pendoComponents");
        sdk.pendo.io.n7.b.a.a(applicationContext);
        int i = a.a[framework.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return new e(applicationContext, apiKey, baseUrl, framework, pendoComponents, 0L, 0L, null, 224, null);
        }
        if (i != 4) {
            if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            return new c(apiKey, baseUrl, pendoComponents, null, 8, null);
        }
        return new f(applicationContext, apiKey, baseUrl, pendoComponents, 0L, 0L, null, 112, null);
    }
}
