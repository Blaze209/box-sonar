package com.pspdfkit.internal.jni;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.text.TextUtils;
import com.getkeepsafe.relinker.ReLinker;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.exceptions.NutrientInitializationFailedException;
import com.pspdfkit.initialization.CrossPlatformTechnology;
import com.pspdfkit.internal.ac;
import com.pspdfkit.internal.d70;
import com.pspdfkit.internal.mo;
import com.pspdfkit.internal.o5;
import com.pspdfkit.internal.wg;
import com.pspdfkit.internal.wm;
import com.pspdfkit.internal.xj;
import com.pspdfkit.utils.PdfLog;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u000f\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0016\u0010\u0003J\u001a\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0087 ¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u001c\u0010\u001bJ\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b \u0010!J4\u0010\"\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0086 ¢\u0006\u0004\b\"\u0010#J\u001a\u0010%\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010\u0007H\u0086 ¢\u0006\u0004\b%\u0010\u0011J\u0010\u0010&\u001a\u00020\u000bH\u0086 ¢\u0006\u0004\b&\u0010\u0003J\u0010\u0010(\u001a\u00020'H\u0086 ¢\u0006\u0004\b(\u0010)J&\u0010,\u001a\u0004\u0018\u00010\u00072\b\u0010*\u001a\u0004\u0018\u00010\u00072\b\u0010+\u001a\u0004\u0018\u00010\u0007H\u0086 ¢\u0006\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u0010/R\u0014\u00101\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u0010/R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u001d\u00108\u001a\b\u0012\u0004\u0012\u00020\u0007078\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R!\u0010<\u001a\u00020\u000f8Æ\u0001X\u0087\u0004¢\u0006\u0012\n\u0004\b<\u00106\u0012\u0004\b>\u0010\u0003\u001a\u0004\b<\u0010=R!\u0010?\u001a\u00020'8Æ\u0001X\u0087\u0004¢\u0006\u0012\n\u0004\b?\u0010@\u0012\u0004\bB\u0010\u0003\u001a\u0004\bA\u0010)R\u0016\u0010E\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010D¨\u0006F"}, d2 = {"Lcom/pspdfkit/internal/jni/NutrientNative;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "", "fontPaths", "Lcom/pspdfkit/initialization/CrossPlatformTechnology;", "crossPlatformTechnology", "", "initialize", "(Landroid/content/Context;Ljava/util/List;Lcom/pspdfkit/initialization/CrossPlatformTechnology;)V", "licenseKey", "", "setLicenseKey", "(Ljava/lang/String;)Z", "Lcom/pspdfkit/internal/jni/NativeAndroidHybridId;", "hybridTechnology", "validateProductIDForDetectedHybridTechnology", "(Lcom/pspdfkit/internal/jni/NativeAndroidHybridId;)V", "release", "minidumpPath", "setNativeCrashPath", "(Ljava/lang/String;)V", "loadNativeLibrary", "(Landroid/content/Context;)V", "loadNativeOcrLibrary", "", "getSupportedABIs", "()[Ljava/lang/String;", "crossPlatformIdToNativeId", "(Lcom/pspdfkit/initialization/CrossPlatformTechnology;)Lcom/pspdfkit/internal/jni/NativeAndroidHybridId;", "initializeNative", "(Landroid/content/Context;[Ljava/lang/String;Lcom/pspdfkit/internal/jni/NativeAndroidHybridId;)V", "license", "setLicense", "destroy", "", "lid", "()I", "f", "p", "gdsN", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "NDK_CORE_LIBRARY_NAME", "Ljava/lang/String;", "NDK_OCR_LIBRARY_NAME", "LOG_TAG", "Lcom/pspdfkit/internal/ac;", "coreLogHandler", "Lcom/pspdfkit/internal/ac;", "isInitialized", "Z", "", "whitelistedLaunchActivities", "Ljava/util/Collection;", "getWhitelistedLaunchActivities", "()Ljava/util/Collection;", "isDemoLicense", "()Z", "isDemoLicense$annotations", "numberOfCPUCores", "I", "getNumberOfCPUCores", "getNumberOfCPUCores$annotations", "getNativeLibraryPathFromResources", "()Ljava/lang/String;", "nativeLibraryPathFromResources", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NutrientNative {
    public static final int $stable;
    private static final String LOG_TAG = "NutrientNative";
    public static final String NDK_CORE_LIBRARY_NAME = "pspdfkit";
    private static final String NDK_OCR_LIBRARY_NAME = "pspdf_tesseract_bridge";
    private static final boolean isDemoLicense = false;
    private static volatile boolean isInitialized;
    private static final int numberOfCPUCores = 0;
    private static final Collection<String> whitelistedLaunchActivities;
    public static final NutrientNative INSTANCE = new NutrientNative();
    private static final ac coreLogHandler = new ac();

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[NativeAndroidHybridId.values().length];
            try {
                iArr[NativeAndroidHybridId.CORDOVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NativeAndroidHybridId.XAMARIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NativeAndroidHybridId.REACTNATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[NativeAndroidHybridId.FLUTTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[NativeAndroidHybridId.DOTNETBINDINGS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[NativeAndroidHybridId.MAUI.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CrossPlatformTechnology.values().length];
            try {
                iArr2[CrossPlatformTechnology.ReactNative.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[CrossPlatformTechnology.Flutter.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[CrossPlatformTechnology.Cordova.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[CrossPlatformTechnology.Xamarin.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[CrossPlatformTechnology.DotNetBindings.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[CrossPlatformTechnology.Maui.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    static {
        Collection<String> collectionUnmodifiableCollection = Collections.unmodifiableCollection(CollectionsKt.listOf((Object[]) new String[]{"com.squareup.leakcanary.internal.DisplayLeakActivity", "leakcanary.internal.activity.LeakActivity", "leakcanary.internal.activity.LeakLauncherActivity"}));
        collectionUnmodifiableCollection.getClass();
        whitelistedLaunchActivities = collectionUnmodifiableCollection;
        $stable = 8;
    }

    private NutrientNative() {
    }

    private final NativeAndroidHybridId crossPlatformIdToNativeId(CrossPlatformTechnology crossPlatformTechnology) {
        switch (WhenMappings.$EnumSwitchMapping$1[crossPlatformTechnology.ordinal()]) {
            case 1:
                return NativeAndroidHybridId.REACTNATIVE;
            case 2:
                return NativeAndroidHybridId.FLUTTER;
            case 3:
                return NativeAndroidHybridId.CORDOVA;
            case 4:
                return NativeAndroidHybridId.XAMARIN;
            case 5:
                return NativeAndroidHybridId.DOTNETBINDINGS;
            case 6:
                return NativeAndroidHybridId.MAUI;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final String getNativeLibraryPathFromResources() {
        InputStream resourceAsStream;
        try {
            ClassLoader classLoader = NutrientNative.class.getClassLoader();
            if (classLoader == null || (resourceAsStream = classLoader.getResourceAsStream("com.pspdfkit.native-library-path")) == null) {
                return null;
            }
            return wg.b(resourceAsStream);
        } catch (Exception unused) {
            PdfLog.i(LOG_TAG, "Failed to get native library path but ignored exception.", new Object[0]);
            return null;
        }
    }

    public static final native int getNumberOfCPUCores();

    @JvmStatic
    public static /* synthetic */ void getNumberOfCPUCores$annotations() {
    }

    private final String[] getSupportedABIs() {
        String[] strArr = Build.SUPPORTED_ABIS;
        strArr.getClass();
        return strArr;
    }

    @JvmStatic
    public static final void initialize(Context context, List<String> fontPaths, CrossPlatformTechnology crossPlatformTechnology) throws InvalidNutrientLicenseException {
        context.getClass();
        fontPaths.getClass();
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryIntentActivities = Build.VERSION.SDK_INT >= 33 ? MAMPackageManagement.queryIntentActivities(packageManager, intent, 131072) : MAMPackageManagement.queryIntentActivities(packageManager, intent, 0);
        listQueryIntentActivities.getClass();
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
            if (whitelistedLaunchActivities.contains(resolveInfo.activityInfo.name)) {
                arrayList.add(resolveInfo);
            }
        }
        listQueryIntentActivities.removeAll(arrayList);
        if (listQueryIntentActivities.size() > 1) {
            throw new InvalidNutrientLicenseException("Apps with multiple LAUNCH intents currently aren't supported, contact Nutrient support.");
        }
        try {
            NutrientNative nutrientNative = INSTANCE;
            nutrientNative.loadNativeLibrary(context);
            try {
                nutrientNative.loadNativeOcrLibrary(context);
                NativeNativeLogging.setPlatformLogger(coreLogHandler);
                NativeNativeServices.init(new o5(context), new d70(), new wm(), new mo(context));
                NativeAndroidHybridId nativeAndroidHybridIdCrossPlatformIdToNativeId = crossPlatformTechnology != null ? nutrientNative.crossPlatformIdToNativeId(crossPlatformTechnology) : null;
                Object[] array = fontPaths.toArray(new String[0]);
                nutrientNative.initializeNative(context, (String[]) (array.length != 0 ? array : null), nativeAndroidHybridIdCrossPlatformIdToNativeId);
                if (nativeAndroidHybridIdCrossPlatformIdToNativeId != null) {
                    nutrientNative.validateProductIDForDetectedHybridTechnology(nativeAndroidHybridIdCrossPlatformIdToNativeId);
                }
                isInitialized = true;
            } catch (UnsatisfiedLinkError e) {
                throw new NutrientInitializationFailedException("Unable to load native OCR libraries: The device's ABI set is either not compatible with Nutrient: " + TextUtils.join(", ", INSTANCE.getSupportedABIs()) + ", or you haven't added the pspdfkit-ocr dependency to your build.gradle file.", e);
            }
        } catch (UnsatisfiedLinkError e2) {
            throw new NutrientInitializationFailedException("Unable to load native libraries: The device's ABI set is not compatible with Nutrient: " + TextUtils.join(", ", INSTANCE.getSupportedABIs()), e2);
        }
    }

    public static final native boolean isDemoLicense();

    @JvmStatic
    public static /* synthetic */ void isDemoLicense$annotations() {
    }

    private final void loadNativeLibrary(Context context) {
        String nativeLibraryPathFromResources = getNativeLibraryPathFromResources();
        if (nativeLibraryPathFromResources != null) {
            System.load(nativeLibraryPathFromResources);
            return;
        }
        try {
            Class.forName("com.getkeepsafe.relinker.ReLinker");
            ReLinker.loadLibrary(context, NDK_CORE_LIBRARY_NAME, "11.3.0");
        } catch (ClassNotFoundException unused) {
            System.loadLibrary(NDK_CORE_LIBRARY_NAME);
        }
    }

    private final void loadNativeOcrLibrary(Context context) {
        String str = context.getApplicationInfo().nativeLibraryDir;
        if (str == null) {
            return;
        }
        for (String str2 : (String[]) Objects.requireNonNull(new File(str).list())) {
            if (str2 != null && Intrinsics.areEqual(str2, "libpspdf_tesseract_bridge.so")) {
                try {
                    Class.forName("com.getkeepsafe.relinker.ReLinker");
                    ReLinker.recursively().loadLibrary(context, NDK_OCR_LIBRARY_NAME);
                    return;
                } catch (ClassNotFoundException unused) {
                    System.loadLibrary(NDK_OCR_LIBRARY_NAME);
                    return;
                }
            }
        }
    }

    @JvmStatic
    public static final synchronized void release() {
        if (isInitialized) {
            NativeNativeLogging.setPlatformLogger(null);
            INSTANCE.destroy();
            NativeNativeServices.deinit();
            isInitialized = false;
        }
    }

    @JvmStatic
    public static final boolean setLicenseKey(String licenseKey) {
        if (!isInitialized) {
            throw new NutrientInitializationFailedException("initialize has to be called first.");
        }
        NutrientNative nutrientNative = INSTANCE;
        if (licenseKey == null) {
            licenseKey = "";
        }
        return nutrientNative.setLicense(licenseKey);
    }

    @JvmStatic
    public static final native void setNativeCrashPath(String minidumpPath);

    private final void validateProductIDForDetectedHybridTechnology(NativeAndroidHybridId hybridTechnology) {
        HashMap map = xj.a;
        HashSet hashSetA = xj.a.a();
        switch (WhenMappings.$EnumSwitchMapping$0[hybridTechnology.ordinal()]) {
            case 1:
            case 2:
                return;
            case 3:
                if (!hashSetA.contains(hybridTechnology)) {
                    throw new NutrientInitializationFailedException("Nutrient detected an unusual setup for your React Native project. Please follow the instructions for integrating Nutrient for React Native here: https://nutrient.io/getting-started/react-native/?react-native-platform=android&project=existing-project");
                }
                return;
            case 4:
                if (!hashSetA.contains(hybridTechnology)) {
                    throw new NutrientInitializationFailedException("Nutrient detected an unusual setup for your Flutter project. Please follow the instructions for integrating Nutrient for Flutter here: https://nutrient.io/getting-started/flutter/?flutter-platform=android&project=existing-project");
                }
                return;
            case 5:
                if (!hashSetA.contains(hybridTechnology)) {
                    throw new NutrientInitializationFailedException("Nutrient detected an unusual setup for your .NET project. Please follow the instructions for integrating Nutrient for .NET here: https://nutrient.io/getting-started/dotnetformobile-android/?project=existing-project");
                }
                return;
            case 6:
                if (!hashSetA.contains(hybridTechnology)) {
                    throw new NutrientInitializationFailedException("Nutrient detected an unusual setup for your MAUI project. Please follow the instructions for integrating Nutrient for MAUI here: https://nutrient.io/getting-started/maui/?project=existing-project");
                }
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final native void destroy();

    public final native String gdsN(String f, String p);

    public final Collection<String> getWhitelistedLaunchActivities() {
        return whitelistedLaunchActivities;
    }

    public final native void initializeNative(Context context, String[] fontPaths, NativeAndroidHybridId hybridTechnology) throws InvalidNutrientLicenseException;

    public final native int lid();

    public final native boolean setLicense(String license) throws InvalidNutrientLicenseException;
}
