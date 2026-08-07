package sdk.pendo.io.x6;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.sdk.flutter.FlutterScreenManager;
import sdk.pendo.io.sdk.flutter.IFlutterBridge;
import sdk.pendo.io.sdk.react.IReactNativeBridge;
import sdk.pendo.io.sdk.react.PlatformStateManager;
import sdk.pendo.io.sdk.react.ReactNativeScreenManager;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lsdk/pendo/io/x6/j;", "", "Lsdk/pendo/io/sdk/react/PlatformStateManager;", "platformStateManager", "Lsdk/pendo/io/Pendo$PendoOptions;", "pendoOptions", "Lsdk/pendo/io/x6/d;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class j {
    public static final j a = new j();

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
                iArr[Pendo.PendoOptions.Framework.FLUTTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Pendo.PendoOptions.Framework.XAMARIN_FORMS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Pendo.PendoOptions.Framework.MAUI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Pendo.PendoOptions.Framework.REACT_NATIVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    private j() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, sdk.pendo.io.s7.m] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v0, types: [sdk.pendo.io.sdk.flutter.IFlutterBridge] */
    public final d a(PlatformStateManager platformStateManager, Pendo.PendoOptions pendoOptions) {
        Intrinsics.checkNotNullParameter(platformStateManager, "platformStateManager");
        Intrinsics.checkNotNullParameter(pendoOptions, "pendoOptions");
        PendoLogger.i("ScreenManagerFactory getScreenManagerByFramework -> framework: " + platformStateManager.getFramework(), new Object[0]);
        if (platformStateManager.isTrackEventSolutionOnly()) {
            return new l();
        }
        int i = 2;
        ?? r1 = 0;
        IReactNativeBridge iReactNativeBridge = null;
        if (platformStateManager.isJetpackComposeApp()) {
            return new sdk.pendo.io.v6.e(pendoOptions, r1, i, r1);
        }
        int i2 = a.a[platformStateManager.getFramework().ordinal()];
        if (i2 == 1) {
            return new e(pendoOptions, r1, i, r1);
        }
        if (i2 == 2) {
            Map<String, Object> additionalOptions = pendoOptions.getAdditionalOptions();
            if (additionalOptions != null) {
                Object obj = additionalOptions.get(Pendo.PendoOptions.FLUTTER_BRIDGE);
                r1 = (IFlutterBridge) (obj instanceof IFlutterBridge ? obj : null);
            }
            return new FlutterScreenManager(pendoOptions, r1, null, 4, null);
        }
        if (i2 == 3 || i2 == 4) {
            return new sdk.pendo.io.y6.a(pendoOptions, r1, i, r1);
        }
        if (i2 != 5) {
            throw new NoWhenBranchMatchedException();
        }
        Map<String, Object> additionalOptions2 = pendoOptions.getAdditionalOptions();
        if (additionalOptions2 != null) {
            Object obj2 = additionalOptions2.get(Pendo.PendoOptions.REACT_NATIVE_BRIDGE);
            iReactNativeBridge = (IReactNativeBridge) (obj2 instanceof IReactNativeBridge ? obj2 : null);
        }
        return new ReactNativeScreenManager(pendoOptions, iReactNativeBridge, null, 4, null);
    }
}
