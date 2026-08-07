package com.pspdfkit;

import android.content.Context;
import android.net.Uri;
import com.facebook.react.common.ReactConstants;
import com.pspdfkit.analytics.AnalyticsClient;
import com.pspdfkit.configuration.policy.ApplicationPolicy;
import com.pspdfkit.exceptions.NutrientNotInitializedException;
import com.pspdfkit.initialization.CrossPlatformTechnology;
import com.pspdfkit.initialization.InitializationOptions;
import com.pspdfkit.listeners.LocalizationListener;
import com.pspdfkit.ui.fonts.FontManager;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "Nutrient for Android 10.0: Will be removed in 2026.", replaceWith = @ReplaceWith(expression = "Nutrient", imports = {}))
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0005H\u0007J2\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0007J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0007J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J0\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0007J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\b\u0010\u0014\u001a\u00020\tH\u0007J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\u0017\u001a\u00020\tH\u0007J\u0016\u0010\u0018\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\b\u0010\u001c\u001a\u00020\u0016H\u0007J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u000e\u0010 \u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0005J\u000e\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020\u0013H\u0007J\u0010\u0010'\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u0010(\u001a\u00020\tH\u0007J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0007J\b\u0010,\u001a\u00020-H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/pspdfkit/PSPDFKit;", "", "<init>", "()V", "VERSION", "", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialize", "", "context", "Landroid/content/Context;", "options", "Lcom/pspdfkit/initialization/InitializationOptions;", "licenseKey", "fontPaths", "", "hybridTechnology", "applicationPolicy", "Lcom/pspdfkit/configuration/policy/ApplicationPolicy;", "clearCaches", "clearDiskCache", "", "release", "isLocalFileUri", "uri", "Landroid/net/Uri;", "isOpenableUri", "isInitialized", "addAnalyticsClient", "client", "Lcom/pspdfkit/analytics/AnalyticsClient;", "removeAnalyticsClient", "setNativeCrashDumpPath", "path", "setLocalizationListener", "localizationListener", "Lcom/pspdfkit/listeners/LocalizationListener;", "getApplicationPolicy", "setApplicationPolicy", "ensureInitialized", "getLicenseFeatures", "Ljava/util/EnumSet;", "Lcom/pspdfkit/LicenseFeature;", "getSystemFontManager", "Lcom/pspdfkit/ui/fonts/FontManager;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PSPDFKit {
    public static final String VERSION = "11.3.0";
    public static final PSPDFKit INSTANCE = new PSPDFKit();
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    public static final int $stable = 8;

    private PSPDFKit() {
    }

    @JvmStatic
    public static final boolean addAnalyticsClient(AnalyticsClient client) {
        client.getClass();
        return Nutrient.addAnalyticsClient(client);
    }

    @Deprecated(message = "v2024.2: Will be removed in a future release.", replaceWith = @ReplaceWith(expression = "clearCaches()", imports = {"com.pspdfkit.PSPDFKit.clearCaches"}))
    @JvmStatic
    public static final void clearCaches(Context context, boolean clearDiskCache) {
        context.getClass();
        clearCaches();
    }

    @JvmStatic
    public static final void ensureInitialized() throws NutrientNotInitializedException {
        if (!initialized.get()) {
            throw new NutrientNotInitializedException("PSPDFKit must be initialized with the initialize() call before use.");
        }
    }

    @JvmStatic
    public static final ApplicationPolicy getApplicationPolicy() {
        return Nutrient.getApplicationPolicy();
    }

    @JvmStatic
    public static final synchronized EnumSet<LicenseFeature> getLicenseFeatures() {
        return Nutrient.getLicenseFeatures();
    }

    @JvmStatic
    public static final FontManager getSystemFontManager() {
        return Nutrient.getSystemFontManager();
    }

    @JvmStatic
    public static final synchronized void initialize(Context context, InitializationOptions options) {
        context.getClass();
        Nutrient.initialize(context, options);
    }

    public static /* synthetic */ void initialize$default(Context context, InitializationOptions initializationOptions, int i, Object obj) {
        if ((i & 2) != 0) {
            initializationOptions = null;
        }
        initialize(context, initializationOptions);
    }

    @JvmStatic
    public static final boolean isInitialized() {
        return Nutrient.isInitialized();
    }

    @JvmStatic
    public static final boolean isOpenableUri(Context context, Uri uri) {
        context.getClass();
        uri.getClass();
        return Nutrient.isOpenableUri(context, uri);
    }

    @Deprecated(message = "v2024.2: Will be removed in a future release.", replaceWith = @ReplaceWith(expression = "release()", imports = {}))
    @JvmStatic
    public static final void release(Context context) {
        context.getClass();
        release();
    }

    @JvmStatic
    public static final void setApplicationPolicy(ApplicationPolicy applicationPolicy) {
        applicationPolicy.getClass();
        Nutrient.setApplicationPolicy(applicationPolicy);
    }

    public final boolean isLocalFileUri(Context context, Uri uri) {
        context.getClass();
        uri.getClass();
        return Nutrient.INSTANCE.isLocalFileUri(context, uri);
    }

    public final boolean removeAnalyticsClient(AnalyticsClient client) {
        client.getClass();
        return Nutrient.INSTANCE.removeAnalyticsClient(client);
    }

    public final void setLocalizationListener(LocalizationListener localizationListener) {
        localizationListener.getClass();
        Nutrient.INSTANCE.setLocalizationListener(localizationListener);
    }

    public final void setNativeCrashDumpPath(String path) {
        path.getClass();
        Nutrient.INSTANCE.setNativeCrashDumpPath(path);
    }

    @JvmStatic
    public static final void clearCaches() {
        Nutrient.clearCaches();
    }

    @JvmStatic
    public static final synchronized void initialize(Context context, String licenseKey) {
        context.getClass();
        licenseKey.getClass();
        Nutrient.initialize(context, licenseKey);
    }

    @JvmStatic
    public static final synchronized void release() {
        Nutrient.release();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Deprecated(message = "v2024.2: Will be removed in 2025.", replaceWith = @ReplaceWith(expression = "initialize(context, options: InitializationOptions?)", imports = {}))
    @JvmStatic
    public static final synchronized void initialize(Context context, String licenseKey, List<String> fontPaths, String hybridTechnology) {
        CrossPlatformTechnology crossPlatformTechnology;
        context.getClass();
        fontPaths.getClass();
        if (hybridTechnology != null) {
            switch (hybridTechnology.hashCode()) {
                case -1675556132:
                    crossPlatformTechnology = !hybridTechnology.equals("Cordova") ? null : CrossPlatformTechnology.Cordova;
                    break;
                case -1111981651:
                    if (hybridTechnology.equals("DotNetBindingsAndroid")) {
                        crossPlatformTechnology = CrossPlatformTechnology.DotNetBindings;
                    }
                    break;
                case -623360614:
                    if (hybridTechnology.equals("Xamarin")) {
                        crossPlatformTechnology = CrossPlatformTechnology.Xamarin;
                    }
                    break;
                case -281583018:
                    if (hybridTechnology.equals(ReactConstants.TAG)) {
                        crossPlatformTechnology = CrossPlatformTechnology.ReactNative;
                    }
                    break;
                case 2390856:
                    if (hybridTechnology.equals("Maui")) {
                        crossPlatformTechnology = CrossPlatformTechnology.Maui;
                    }
                    break;
                case 904318972:
                    if (hybridTechnology.equals("Flutter")) {
                        crossPlatformTechnology = CrossPlatformTechnology.Flutter;
                    }
                    break;
                default:
                    break;
            }
        }
        Nutrient.initialize(context, new InitializationOptions(licenseKey, fontPaths, crossPlatformTechnology, null, 8, null));
    }

    @Deprecated(message = "v2024.2: Will be removed in 2025.", replaceWith = @ReplaceWith(expression = "initialize(context, options: InitializationOptions?)", imports = {}))
    @JvmStatic
    public static final synchronized void initialize(Context context, String licenseKey, List<String> fontPaths) {
        context.getClass();
        fontPaths.getClass();
        Nutrient.initialize(context, new InitializationOptions(licenseKey, fontPaths, null, null, 12, null));
    }

    @Deprecated(message = "v2024.2: Will be removed in 2025.", replaceWith = @ReplaceWith(expression = "initialize(context, options: InitializationOptions?)", imports = {}))
    @JvmStatic
    public static final synchronized void initialize(Context context, String licenseKey, ApplicationPolicy applicationPolicy) {
        context.getClass();
        applicationPolicy.getClass();
        Nutrient.initialize(context, new InitializationOptions(licenseKey, null, null, applicationPolicy, 6, null));
    }

    @Deprecated(message = "v2024.2: Will be removed in 2025.", replaceWith = @ReplaceWith(expression = "initialize(context, options: InitializationOptions?)", imports = {}))
    @JvmStatic
    public static final synchronized void initialize(Context context, String licenseKey, ApplicationPolicy applicationPolicy, List<String> fontPaths) {
        context.getClass();
        applicationPolicy.getClass();
        fontPaths.getClass();
        Nutrient.initialize(context, new InitializationOptions(licenseKey, fontPaths, null, applicationPolicy, 4, null));
    }
}
