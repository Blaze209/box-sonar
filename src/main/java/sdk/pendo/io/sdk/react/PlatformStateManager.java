package sdk.pendo.io.sdk.react;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.s7.i;
import sdk.pendo.io.w5.a;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b7\u00106J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\bJ\b\u0010\n\u001a\u0004\u0018\u00010\bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u000bR\u0016\u0010\u0013\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R*\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00158G@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u001d8G@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R(\u0010\"\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00048G@BX\u0086\u000e¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R(\u0010&\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b8G@BX\u0086\u000e¢\u0006\f\n\u0004\b&\u0010\u0014\u001a\u0004\b'\u0010(R(\u0010)\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b8G@BX\u0086\u000e¢\u0006\f\n\u0004\b)\u0010\u0014\u001a\u0004\b*\u0010(R$\u0010+\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b+\u0010-R(\u0010/\u001a\u00020.8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b/\u00100\u0012\u0004\b5\u00106\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u00068"}, d2 = {"Lsdk/pendo/io/sdk/react/PlatformStateManager;", "Lsdk/pendo/io/w5/a;", "Lsdk/pendo/io/Pendo$PendoOptions;", "pendoOptions", "Lsdk/pendo/io/Pendo$PendoOptions$FrameworkType;", "setNativeFrameworkType", "", "extractFrameworkDataFromPendoOptions", "", "getFrameworkAsString", "getFrameworkTypeAsString", "", "isNativeFramework", "isJetpackComposeApp", "isNotReactNativeApp", "isReactNativeApp", "isXamarinFormsOrMaui", "isFlutterCodelessApp", "isReactNativeAnalyticsEnabled", "TAG", "Ljava/lang/String;", "", "<set-?>", "rnnClickDelayMs", "J", "getRnnClickDelayMs", "()J", "setRnnClickDelayMs", "(J)V", "Lsdk/pendo/io/Pendo$PendoOptions$Framework;", "framework", "Lsdk/pendo/io/Pendo$PendoOptions$Framework;", "getFramework", "()Lsdk/pendo/io/Pendo$PendoOptions$Framework;", Pendo.PendoOptions.FRAMEWORK_TYPE, "Lsdk/pendo/io/Pendo$PendoOptions$FrameworkType;", "getFrameworkType", "()Lsdk/pendo/io/Pendo$PendoOptions$FrameworkType;", Pendo.PendoOptions.FRAMEWORK_VERSION, "getFrameworkVersion", "()Ljava/lang/String;", Pendo.PendoOptions.PLUGIN_VERSION, "getPluginVersion", "isTrackEventSolutionOnly", "Z", "()Z", "Lsdk/pendo/io/s7/i;", "composeUtilityHelper", "Lsdk/pendo/io/s7/i;", "getComposeUtilityHelper", "()Lsdk/pendo/io/s7/i;", "setComposeUtilityHelper", "(Lsdk/pendo/io/s7/i;)V", "getComposeUtilityHelper$annotations", "()V", "<init>", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class PlatformStateManager implements a {
    private static Pendo.PendoOptions.FrameworkType frameworkType;
    private static String frameworkVersion;
    private static boolean isTrackEventSolutionOnly;
    private static String pluginVersion;
    public static final PlatformStateManager INSTANCE = new PlatformStateManager();
    private static String TAG = "PlatformStateManager";
    private static long rnnClickDelayMs = 500;
    private static Pendo.PendoOptions.Framework framework = Pendo.PendoOptions.Framework.NATIVE;
    private static i composeUtilityHelper = new i(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);

    private PlatformStateManager() {
    }

    public static /* synthetic */ void getComposeUtilityHelper$annotations() {
    }

    private final Pendo.PendoOptions.FrameworkType setNativeFrameworkType(Pendo.PendoOptions pendoOptions) {
        if (framework != Pendo.PendoOptions.Framework.NATIVE) {
            return pendoOptions.getFrameworkType();
        }
        return composeUtilityHelper.j() ? Pendo.PendoOptions.FrameworkType.NATIVE_JETPACK_COMPOSE : Pendo.PendoOptions.FrameworkType.NATIVE_VIEW;
    }

    public final void extractFrameworkDataFromPendoOptions(Pendo.PendoOptions pendoOptions) {
        Intrinsics.checkNotNullParameter(pendoOptions, "pendoOptions");
        Pendo.PendoOptions.Framework framework2 = pendoOptions.getFramework();
        Intrinsics.checkNotNullExpressionValue(framework2, "getFramework(...)");
        framework = framework2;
        frameworkType = setNativeFrameworkType(pendoOptions);
        frameworkVersion = pendoOptions.getFrameworkVersion();
        pluginVersion = pendoOptions.getPluginVersion();
        isTrackEventSolutionOnly = pendoOptions.getDisableAnalytics() || frameworkType == Pendo.PendoOptions.FrameworkType.TRACK;
    }

    public final i getComposeUtilityHelper() {
        return composeUtilityHelper;
    }

    public final Pendo.PendoOptions.Framework getFramework() {
        return framework;
    }

    public final String getFrameworkAsString() {
        String string = framework.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final Pendo.PendoOptions.FrameworkType getFrameworkType() {
        return frameworkType;
    }

    public final String getFrameworkTypeAsString() {
        Pendo.PendoOptions.FrameworkType frameworkType2 = frameworkType;
        if (frameworkType2 != null) {
            return frameworkType2.toString();
        }
        return null;
    }

    public final String getFrameworkVersion() {
        return frameworkVersion;
    }

    @Override // sdk.pendo.io.v2.a
    public sdk.pendo.io.u2.a getKoin() {
        return a.C0510a.a(this);
    }

    public final String getPluginVersion() {
        return pluginVersion;
    }

    public final long getRnnClickDelayMs() {
        return rnnClickDelayMs;
    }

    public final boolean isFlutterCodelessApp() {
        return Pendo.PendoOptions.Framework.FLUTTER == framework && Pendo.PendoOptions.FrameworkType.FLUTTER_OBSERVABLE == frameworkType;
    }

    public final boolean isJetpackComposeApp() {
        return framework == Pendo.PendoOptions.Framework.NATIVE && frameworkType == Pendo.PendoOptions.FrameworkType.NATIVE_JETPACK_COMPOSE;
    }

    public final boolean isNativeFramework() {
        return framework == Pendo.PendoOptions.Framework.NATIVE;
    }

    public final boolean isNotReactNativeApp() {
        return !isReactNativeApp();
    }

    public final boolean isReactNativeAnalyticsEnabled() {
        return Pendo.PendoOptions.Framework.REACT_NATIVE == framework && !isTrackEventSolutionOnly;
    }

    public final boolean isReactNativeApp() {
        return Pendo.PendoOptions.Framework.REACT_NATIVE == framework;
    }

    public final boolean isTrackEventSolutionOnly() {
        return isTrackEventSolutionOnly;
    }

    public final boolean isXamarinFormsOrMaui() {
        return Pendo.PendoOptions.Framework.XAMARIN_FORMS == framework || Pendo.PendoOptions.Framework.MAUI == framework;
    }

    public final void setComposeUtilityHelper(i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<set-?>");
        composeUtilityHelper = iVar;
    }

    public final void setRnnClickDelayMs(long j) {
        rnnClickDelayMs = j;
    }
}
