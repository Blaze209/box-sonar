package sdk.pendo.io;

import android.content.Context;
import android.view.View;
import androidx.navigation.NavHostController;
import com.facebook.react.common.ReactConstants;
import java.util.Map;
import sdk.pendo.io.f6.b;
import sdk.pendo.io.f6.f;

/* JADX INFO: loaded from: classes.dex */
public final class Pendo {
    public static final JWT jwt = new JWT();

    public static class PendoOptions {

        @Deprecated(forRemoval = true, since = "3.12.5")
        public static final String CERTIFICATE_TRANSPARENCY_EXCLUDE_LIST = "certificateTransparencyExcludeList";
        public static final String DISABLE_ANALYTICS = "disableAnalytics";
        public static final String FLUTTER_BRIDGE = "flutterBridge";
        public static final String FRAMEWORK = "framework";
        public static final String FRAMEWORK_TYPE = "frameworkType";
        public static final String FRAMEWORK_VERSION = "frameworkVersion";

        @Deprecated(forRemoval = true, since = "3.7")
        public static final String JETPACK_COMPOSE_DESIGN_PARTNER = "jetpackComposeDesignPartner";
        public static final String PLUGIN_VERSION = "pluginVersion";
        public static final String REACT_NATIVE_BRIDGE = "reactNativeBridge";
        public static final String SR_SCAN_DEBOUNCE_MS = "srScanDebounceMs";
        public static final String SR_SCAN_TIMEOUT_MS = "srScanTimeoutMs";
        public static final String SR_SHOW_VIEW_BOUNDS = "srShowViewBounds";
        public static final String USE_MODIFIED_SCREEN_DATA_FOR_NATIVE_TRANSIENT_UI_COMPONENT = "useModifiedScreenDataForNativeTransientUIComponent";
        public static final String USE_ONLY_XAMARIN_BRIDGE_PROVIDED_SCREEN_ID = "useProvidedScreenId";
        public static final String XAMARIN_BRIDGE = "xamarinBridge";
        private AdaptivePageScanningMode mAdaptivePageScanningMode;
        private Map<String, Object> mAdditionalOptions;
        private boolean mDisableAppAnalytics;
        private boolean mEnableAutoSessionEndDetection;
        private b mEnvironment;
        private boolean mExcludeHiddenElementsWhileScanning;
        private Framework mFramework;
        private FrameworkType mFrameworkType;
        private String mFrameworkVersion;
        private boolean mImportInitModelFromLocalFile;
        private boolean mIncludeAllGuideContent;
        private String mPluginVersion;
        private Long mSRScanDebounceMs;
        private Long mSRScanTimeoutMs;
        private Boolean mSRShowViewBounds;
        private boolean mUseClickableElementsFromJS;
        private boolean mUseModifiedScreenDataForNativeTransientUIComponent;
        private boolean mUseOnlyXamarinBridgeProvidedScreenId;

        public enum AdaptivePageScanningMode {
            DEFAULT,
            TIME_FIXED,
            DISABLED
        }

        public static class Builder {
            private boolean mUseClickableElementsFromJS = true;
            private boolean mEnableAutoSessionEndDetection = false;
            private b mEnvironment = null;
            private Map<String, Object> mAdditionalOptions = null;
            private boolean mIncludeAllGuideContent = false;
            private boolean mImportInitModelFromLocalFile = false;
            private boolean mExcludeGhostElementsWhileScanning = true;
            private AdaptivePageScanningMode mAdaptivePageScanningMode = AdaptivePageScanningMode.DEFAULT;

            public PendoOptions build() {
                return new PendoOptions(this);
            }

            public Builder setAdaptivePageScanning(AdaptivePageScanningMode adaptivePageScanningMode) {
                this.mAdaptivePageScanningMode = adaptivePageScanningMode;
                return this;
            }

            public Builder setAdditionalOptions(Map<String, Object> map) {
                this.mAdditionalOptions = map;
                return this;
            }

            public Builder setEnableAutoSessionEndDetection(boolean z) {
                this.mEnableAutoSessionEndDetection = z;
                return this;
            }

            public Builder setEnvironmentName(String str) {
                this.mEnvironment = f.a(str);
                return this;
            }

            public Builder setExcludeHiddenElementsWhileScanning(boolean z) {
                this.mExcludeGhostElementsWhileScanning = z;
                return this;
            }

            public Builder setImportInitModelFromLocalFile(boolean z) {
                this.mImportInitModelFromLocalFile = z;
                return this;
            }

            public Builder setIncludeAllGuideContent(boolean z) {
                this.mIncludeAllGuideContent = z;
                return this;
            }

            @Deprecated(forRemoval = true, since = "3.7")
            public Builder setJetpackComposeBeta(boolean z) {
                return this;
            }

            public Builder setUseClickableElementsFromJS(boolean z) {
                this.mUseClickableElementsFromJS = z;
                return this;
            }
        }

        public enum Framework {
            NATIVE("AndroidX"),
            REACT_NATIVE(ReactConstants.TAG),
            FLUTTER("Flutter"),
            XAMARIN_FORMS("XamarinForms"),
            MAUI("MAUI");

            private final String name;

            Framework(String str) {
                this.name = str;
            }

            @Override // java.lang.Enum
            public String toString() {
                return this.name;
            }
        }

        public enum FrameworkType {
            REACT_NAVIGATION("ReactNavigation"),
            REACT_NATIVE_NAVIGATION("ReactNativeNavigation"),
            FLUTTER_OBSERVABLE("Observable"),
            TRACK("Track"),
            NATIVE_VIEW("View"),
            NATIVE_JETPACK_COMPOSE("JetpackCompose");

            private final String name;

            FrameworkType(String str) {
                this.name = str;
            }

            @Override // java.lang.Enum
            public String toString() {
                return this.name;
            }
        }

        public PendoOptions() {
            this.mFramework = Framework.NATIVE;
            this.mFrameworkType = null;
            this.mFrameworkVersion = null;
            this.mPluginVersion = null;
            this.mEnableAutoSessionEndDetection = false;
            this.mUseClickableElementsFromJS = true;
            this.mEnvironment = null;
            this.mDisableAppAnalytics = false;
            this.mImportInitModelFromLocalFile = false;
            this.mIncludeAllGuideContent = false;
            this.mExcludeHiddenElementsWhileScanning = true;
            this.mUseOnlyXamarinBridgeProvidedScreenId = false;
            this.mUseModifiedScreenDataForNativeTransientUIComponent = false;
            this.mSRShowViewBounds = Boolean.FALSE;
            this.mSRScanDebounceMs = null;
            this.mSRScanTimeoutMs = null;
            this.mAdaptivePageScanningMode = AdaptivePageScanningMode.DEFAULT;
            this.mAdditionalOptions = null;
        }

        private <T> T extractAdditionalOption(Map<String, Object> map, String str, Class<T> cls, T t) {
            try {
                Object obj = map.get(str);
                if (obj != null && cls.isAssignableFrom(obj.getClass())) {
                    return cls.cast(obj);
                }
            } catch (Exception unused) {
            }
            return t;
        }

        public AdaptivePageScanningMode getAdaptivePageScanning() {
            return this.mAdaptivePageScanningMode;
        }

        public Map<String, Object> getAdditionalOptions() {
            return this.mAdditionalOptions;
        }

        @Deprecated(forRemoval = true, since = "3.12.5")
        public Iterable<String> getCertificateTransparencyExcludeList() {
            return null;
        }

        public boolean getDisableAnalytics() {
            return this.mDisableAppAnalytics;
        }

        public boolean getEnableAutoSessionEndDetection() {
            return this.mEnableAutoSessionEndDetection;
        }

        public b getEnvironment() {
            return this.mEnvironment;
        }

        public boolean getExcludeHiddenElementsWhileScanning() {
            return this.mExcludeHiddenElementsWhileScanning;
        }

        public Framework getFramework() {
            return this.mFramework;
        }

        public FrameworkType getFrameworkType() {
            return this.mFrameworkType;
        }

        public String getFrameworkVersion() {
            return this.mFrameworkVersion;
        }

        public String getPluginVersion() {
            return this.mPluginVersion;
        }

        public Long getSRScanDebounceMs() {
            return this.mSRScanDebounceMs;
        }

        public Long getSRScanTimeoutMs() {
            return this.mSRScanTimeoutMs;
        }

        public Boolean getSRShowViewBounds() {
            return this.mSRShowViewBounds;
        }

        public boolean getUseClickableElementsFromJS() {
            return this.mUseClickableElementsFromJS;
        }

        public boolean getUseModifiedScreenDataForNativeTransientUIComponent() {
            return this.mUseModifiedScreenDataForNativeTransientUIComponent;
        }

        public boolean getUseOnlyXamarinBridgeProvidedScreenId() {
            return this.mUseOnlyXamarinBridgeProvidedScreenId;
        }

        public boolean isImportInitModelFromLocalFile() {
            return this.mImportInitModelFromLocalFile;
        }

        public boolean isIncludeAllGuidesContent() {
            return this.mIncludeAllGuideContent;
        }

        private PendoOptions(Builder builder) {
            Framework framework = Framework.NATIVE;
            this.mFramework = framework;
            this.mFrameworkType = null;
            this.mFrameworkVersion = null;
            this.mPluginVersion = null;
            this.mEnableAutoSessionEndDetection = false;
            this.mUseClickableElementsFromJS = true;
            this.mEnvironment = null;
            this.mDisableAppAnalytics = false;
            this.mImportInitModelFromLocalFile = false;
            this.mIncludeAllGuideContent = false;
            this.mExcludeHiddenElementsWhileScanning = true;
            this.mUseOnlyXamarinBridgeProvidedScreenId = false;
            this.mUseModifiedScreenDataForNativeTransientUIComponent = false;
            Boolean bool = Boolean.FALSE;
            this.mSRShowViewBounds = bool;
            this.mSRScanDebounceMs = null;
            this.mSRScanTimeoutMs = null;
            this.mAdaptivePageScanningMode = AdaptivePageScanningMode.DEFAULT;
            this.mAdditionalOptions = null;
            Map<String, Object> map = builder.mAdditionalOptions;
            this.mAdditionalOptions = map;
            this.mFramework = (Framework) extractAdditionalOption(map, "framework", Framework.class, framework);
            this.mFrameworkType = (FrameworkType) extractAdditionalOption(this.mAdditionalOptions, FRAMEWORK_TYPE, FrameworkType.class, null);
            this.mFrameworkVersion = (String) extractAdditionalOption(this.mAdditionalOptions, FRAMEWORK_VERSION, String.class, null);
            this.mPluginVersion = (String) extractAdditionalOption(this.mAdditionalOptions, PLUGIN_VERSION, String.class, null);
            this.mUseOnlyXamarinBridgeProvidedScreenId = ((Boolean) extractAdditionalOption(this.mAdditionalOptions, USE_ONLY_XAMARIN_BRIDGE_PROVIDED_SCREEN_ID, Boolean.class, bool)).booleanValue();
            this.mUseModifiedScreenDataForNativeTransientUIComponent = ((Boolean) extractAdditionalOption(this.mAdditionalOptions, USE_MODIFIED_SCREEN_DATA_FOR_NATIVE_TRANSIENT_UI_COMPONENT, Boolean.class, bool)).booleanValue();
            this.mDisableAppAnalytics = Boolean.TRUE.equals(extractAdditionalOption(this.mAdditionalOptions, DISABLE_ANALYTICS, Boolean.class, bool)) || FrameworkType.TRACK.equals(this.mFrameworkType);
            this.mSRShowViewBounds = (Boolean) extractAdditionalOption(this.mAdditionalOptions, SR_SHOW_VIEW_BOUNDS, Boolean.class, bool);
            this.mSRScanDebounceMs = (Long) extractAdditionalOption(this.mAdditionalOptions, SR_SCAN_DEBOUNCE_MS, Long.class, null);
            this.mSRScanTimeoutMs = (Long) extractAdditionalOption(this.mAdditionalOptions, SR_SCAN_TIMEOUT_MS, Long.class, null);
            this.mUseClickableElementsFromJS = builder.mUseClickableElementsFromJS;
            this.mEnableAutoSessionEndDetection = builder.mEnableAutoSessionEndDetection;
            this.mEnvironment = builder.mEnvironment;
            this.mIncludeAllGuideContent = builder.mIncludeAllGuideContent;
            this.mImportInitModelFromLocalFile = builder.mImportInitModelFromLocalFile;
            this.mExcludeHiddenElementsWhileScanning = builder.mExcludeGhostElementsWhileScanning;
            this.mAdaptivePageScanningMode = builder.mAdaptivePageScanningMode;
        }
    }

    private Pendo() {
    }

    public static synchronized void dismissVisibleGuides() {
        PendoInternal.g();
    }

    public static void endSession() {
        PendoInternal.i();
    }

    public static String getAccountId() {
        return PendoInternal.m();
    }

    public static String getDeviceId() {
        return PendoInternal.p();
    }

    public static String getVisitorId() {
        return PendoInternal.H();
    }

    public static synchronized void pauseGuides(boolean z) {
        PendoInternal.a(z);
    }

    public static synchronized void resumeGuides() {
        PendoInternal.W();
    }

    public static void screenContentChanged() {
        PendoInternal.X();
    }

    public static boolean sendClickAnalytic(View view) {
        return PendoInternal.a(view);
    }

    public static void setAccountData(Map<String, Object> map) {
        PendoInternal.a(map);
    }

    @Deprecated(since = "3.12")
    public static synchronized void setComposeNavigationController(NavHostController navHostController) {
    }

    public static synchronized void setDebugMode(boolean z) {
        PendoInternal.c(z);
    }

    public static void setVisitorData(Map<String, Object> map) {
        PendoInternal.b(map);
    }

    public static synchronized void setup(Context context, String str, PendoOptions pendoOptions, PendoPhasesCallbackInterface pendoPhasesCallbackInterface) {
        PendoInternal.a(context, str, pendoOptions, pendoPhasesCallbackInterface);
    }

    public static void startSession(String str, String str2, Map<String, Object> map, Map<String, Object> map2) {
        PendoInternal.a(str, str2, map, map2);
    }

    public static void track(String str, Map<String, Object> map) {
        PendoInternal.a(str, map);
    }
}
