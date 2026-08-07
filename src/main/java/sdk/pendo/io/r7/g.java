package sdk.pendo.io.r7;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.Pendo;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lsdk/pendo/io/r7/g;", "", "Lsdk/pendo/io/Pendo$PendoOptions$Framework;", "framework", "Lsdk/pendo/io/r7/h;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class g {
    public static final g a = new g();

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
                iArr[Pendo.PendoOptions.Framework.XAMARIN_FORMS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Pendo.PendoOptions.Framework.MAUI.ordinal()] = 3;
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

    private g() {
    }

    public final h a(Pendo.PendoOptions.Framework framework) {
        Intrinsics.checkNotNullParameter(framework, "framework");
        int i = a.a[framework.ordinal()];
        if (i == 1 || i == 2) {
            return new c();
        }
        if (i == 3) {
            return new b();
        }
        if (i == 4) {
            return new e();
        }
        if (i == 5) {
            return new sdk.pendo.io.r7.a();
        }
        throw new NoWhenBranchMatchedException();
    }
}
