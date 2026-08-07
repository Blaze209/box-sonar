package com.box.brownfieldApi;

import android.app.Application;
import android.content.Context;
import android.preference.PreferenceManager;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.ts.TsExtractor;
import com.callstack.reactnativebrownfield.OnJSBundleLoaded;
import com.callstack.reactnativebrownfield.ReactNativeBrownfield;
import com.facebook.react.ReactHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint;
import com.facebook.react.soloader.OpenSourceMergedSoMapping;
import com.facebook.soloader.SoLoader;
import expo.modules.ExpoReactHostFactory;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ReactNativeHostManager.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018J\u001a\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0002J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/box/brownfieldApi/ReactNativeHostManager;", "", "<init>", "()V", "DEFAULT_METRO_URL", "", "PREFS_DEBUG_SERVER_HOST_KEY", "value", "Lcom/facebook/react/ReactHost;", "reactHost", "getReactHost", "()Lcom/facebook/react/ReactHost;", "initialize", "", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "packages", "", "Lcom/facebook/react/ReactPackage;", "useMetro", "", "metroUrl", "onConfigurationChanged", "context", "Landroid/content/Context;", "applyMetroHostOverride", "normalizeMetroUrl", "brownfieldApi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactNativeHostManager {
    public static final String DEFAULT_METRO_URL = "10.0.2.2:8081";
    private static final String PREFS_DEBUG_SERVER_HOST_KEY = "debug_http_host";
    private static ReactHost reactHost;
    public static final ReactNativeHostManager INSTANCE = new ReactNativeHostManager();
    public static final int $stable = 8;

    private ReactNativeHostManager() {
    }

    public final ReactHost getReactHost() {
        ReactHost reactHost2 = reactHost;
        if (reactHost2 != null) {
            return reactHost2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("reactHost");
        return null;
    }

    public static /* synthetic */ void initialize$default(ReactNativeHostManager reactNativeHostManager, Application application, List list, boolean z, String str, int i, Object obj) throws IOException {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            str = null;
        }
        reactNativeHostManager.initialize(application, list, z, str);
    }

    public final void initialize(Application application, List<? extends ReactPackage> packages, boolean useMetro, String metroUrl) throws IOException {
        ReactHost defaultReactHost;
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(packages, "packages");
        SoLoader.init(application, OpenSourceMergedSoMapping.INSTANCE);
        DefaultNewArchitectureEntryPoint.load();
        if (useMetro) {
            applyMetroHostOverride(application, metroUrl);
            Context applicationContext = application.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            defaultReactHost = ExpoReactHostFactory.getDefaultReactHost(applicationContext, packages, (TsExtractor.TS_PACKET_SIZE & 4) != 0 ? ".expo/.virtual-metro-entry" : null, (TsExtractor.TS_PACKET_SIZE & 8) != 0 ? "index.android.bundle" : null, (TsExtractor.TS_PACKET_SIZE & 16) != 0 ? null : null, (TsExtractor.TS_PACKET_SIZE & 32) != 0 ? null : null, (TsExtractor.TS_PACKET_SIZE & 64) != 0 ? ReactBuildConfig.DEBUG : true, (TsExtractor.TS_PACKET_SIZE & 128) != 0 ? null : null);
        } else {
            Context applicationContext2 = application.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
            defaultReactHost = ExpoReactHostFactory.getDefaultReactHost(applicationContext2, packages, (TsExtractor.TS_PACKET_SIZE & 4) != 0 ? ".expo/.virtual-metro-entry" : null, (TsExtractor.TS_PACKET_SIZE & 8) != 0 ? "index.android.bundle" : null, (TsExtractor.TS_PACKET_SIZE & 16) != 0 ? null : null, (TsExtractor.TS_PACKET_SIZE & 32) != 0 ? null : null, (TsExtractor.TS_PACKET_SIZE & 64) != 0 ? ReactBuildConfig.DEBUG : false, (TsExtractor.TS_PACKET_SIZE & 128) != 0 ? null : null);
        }
        reactHost = defaultReactHost;
        ReactNativeBrownfield.Companion.initialize$default(ReactNativeBrownfield.INSTANCE, application, getReactHost(), (OnJSBundleLoaded) null, 4, (Object) null);
    }

    public final void onConfigurationChanged(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        getReactHost().onConfigurationChanged(context);
    }

    private final void applyMetroHostOverride(Application application, String metroUrl) {
        String strNormalizeMetroUrl = normalizeMetroUrl(metroUrl);
        if (strNormalizeMetroUrl == null) {
            strNormalizeMetroUrl = "10.0.2.2:8081";
        }
        PreferenceManager.getDefaultSharedPreferences(application).edit().putString(PREFS_DEBUG_SERVER_HOST_KEY, strNormalizeMetroUrl).apply();
    }

    private final String normalizeMetroUrl(String metroUrl) {
        String string = metroUrl != null ? StringsKt.trim((CharSequence) metroUrl).toString() : null;
        if (string == null) {
            string = "";
        }
        if (string.length() == 0) {
            return null;
        }
        String string2 = StringsKt.trim((CharSequence) StringsKt.substringBefore$default(StringsKt.substringAfter$default(string, "://", (String) null, 2, (Object) null), "/", (String) null, 2, (Object) null)).toString();
        return string2.length() != 0 ? string2 : null;
    }
}
