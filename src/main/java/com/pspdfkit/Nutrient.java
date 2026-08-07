package com.pspdfkit;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;
import com.pspdfkit.analytics.AnalyticsClient;
import com.pspdfkit.configuration.policy.ApplicationPolicy;
import com.pspdfkit.configuration.policy.DefaultApplicationPolicy;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.exceptions.NutrientNotInitializedException;
import com.pspdfkit.initialization.InitializationOptions;
import com.pspdfkit.internal.a;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.b30;
import com.pspdfkit.internal.e50;
import com.pspdfkit.internal.i0;
import com.pspdfkit.internal.jni.NativeAndroidHybridId;
import com.pspdfkit.internal.jni.NativeHybridLicense;
import com.pspdfkit.internal.jni.NativeLicense;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.jni.NativePageCache;
import com.pspdfkit.internal.jni.NutrientNative;
import com.pspdfkit.internal.lo;
import com.pspdfkit.internal.mr;
import com.pspdfkit.internal.n5;
import com.pspdfkit.internal.q10;
import com.pspdfkit.internal.u40;
import com.pspdfkit.internal.ut;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.wg;
import com.pspdfkit.internal.xj;
import com.pspdfkit.listeners.LocalizationListener;
import com.pspdfkit.ui.fonts.FontManager;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0005H\u0007J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0007J\b\u0010\u0013\u001a\u00020\u000bH\u0007J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\b\u0010\u0019\u001a\u00020\u0015H\u0007J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u0005J\u000e\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020$H\u0007J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020$H\u0007J\b\u0010'\u001a\u00020\u000bH\u0007J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0007J\b\u0010+\u001a\u00020,H\u0007J\u0010\u0010-\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u001e\u0010.\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000500H\u0002J\u0012\u00101\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/pspdfkit/Nutrient;", "", "<init>", "()V", "LOG_TAG", "", "VERSION", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "confirmedLicenseKeyHash", "initialize", "", "context", "Landroid/content/Context;", "options", "Lcom/pspdfkit/initialization/InitializationOptions;", "licenseKey", "initializeInternal", "clearCaches", "release", "isLocalFileUri", "", "uri", "Landroid/net/Uri;", "isOpenableUri", "isInitialized", "addAnalyticsClient", "client", "Lcom/pspdfkit/analytics/AnalyticsClient;", "removeAnalyticsClient", "setNativeCrashDumpPath", "path", "setLocalizationListener", "localizationListener", "Lcom/pspdfkit/listeners/LocalizationListener;", "getApplicationPolicy", "Lcom/pspdfkit/configuration/policy/ApplicationPolicy;", "setApplicationPolicy", "applicationPolicy", "ensureInitialized", "getLicenseFeatures", "Ljava/util/EnumSet;", "Lcom/pspdfkit/LicenseFeature;", "getSystemFontManager", "Lcom/pspdfkit/ui/fonts/FontManager;", "verifyLibraryABIs", "initializeModules", "fontPaths", "", "initializeLicenseKey", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Nutrient {
    private static final String LOG_TAG = "Nutrient";
    public static final String VERSION = "11.3.0";
    public static final Nutrient INSTANCE = new Nutrient();
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static String confirmedLicenseKeyHash = "";
    public static final int $stable = 8;

    private Nutrient() {
    }

    @JvmStatic
    public static final boolean addAnalyticsClient(AnalyticsClient client) {
        client.getClass();
        ensureInitialized();
        return ar.a().a(client);
    }

    @JvmStatic
    public static final void clearCaches() {
        ensureInitialized();
        ut utVar = q10.b;
        if (utVar == null) {
            utVar = new ut(NativePageCache.create(15728640));
            q10.b = utVar;
        }
        utVar.a.clear();
        utVar.b.a.evictAll();
    }

    @JvmStatic
    public static final void ensureInitialized() throws NutrientNotInitializedException {
        if (!initialized.get()) {
            throw new NutrientNotInitializedException("PSPDFKit must be initialized with the initialize() call before use.");
        }
    }

    @JvmStatic
    public static final ApplicationPolicy getApplicationPolicy() {
        ApplicationPolicy applicationPolicy;
        ensureInitialized();
        synchronized (ar.class) {
            if (ar.f == null) {
                ar.f = new DefaultApplicationPolicy();
            }
            applicationPolicy = ar.f;
        }
        applicationPolicy.getClass();
        return applicationPolicy;
    }

    @JvmStatic
    public static final synchronized EnumSet<LicenseFeature> getLicenseFeatures() {
        LicenseFeature licenseFeature;
        if (!initialized.get()) {
            EnumSet<LicenseFeature> enumSetNoneOf = EnumSet.noneOf(LicenseFeature.class);
            enumSetNoneOf.getClass();
            return enumSetNoneOf;
        }
        EnumSet<LicenseFeature> enumSetNoneOf2 = EnumSet.noneOf(LicenseFeature.class);
        EnumSet<NativeLicenseFeatures> enumSetFeatures = NativeLicense.license().features();
        enumSetFeatures.getClass();
        ArrayList arrayList = new ArrayList();
        for (NativeLicenseFeatures nativeLicenseFeatures : enumSetFeatures) {
            switch (nativeLicenseFeatures == null ? -1 : mr.b.i[nativeLicenseFeatures.ordinal()]) {
                case 1:
                    licenseFeature = LicenseFeature.PDF_CREATION;
                    break;
                case 2:
                    licenseFeature = LicenseFeature.DIGITAL_SIGNATURES;
                    break;
                case 3:
                    licenseFeature = LicenseFeature.ANNOTATION_EDITING;
                    break;
                case 4:
                    licenseFeature = LicenseFeature.INDEXED_FTS;
                    break;
                case 5:
                    licenseFeature = LicenseFeature.ANNOTATION_REPLIES;
                    break;
                case 6:
                    licenseFeature = LicenseFeature.IMAGE_DOCUMENT;
                    break;
                case 7:
                    licenseFeature = LicenseFeature.DOCUMENT_EDITING;
                    break;
                case 8:
                    licenseFeature = LicenseFeature.FORMS;
                    break;
                case 9:
                    licenseFeature = LicenseFeature.COMPARISON;
                    break;
                case 10:
                    licenseFeature = LicenseFeature.REDACTION;
                    break;
                case 11:
                    licenseFeature = LicenseFeature.WEBKIT_HTML_CONVERSION;
                    break;
                case 12:
                    licenseFeature = LicenseFeature.READER_VIEW;
                    break;
                case 13:
                    licenseFeature = LicenseFeature.ELECTRONIC_SIGNATURES;
                    break;
                case 14:
                    licenseFeature = LicenseFeature.MEASUREMENT_TOOLS;
                    break;
                case 15:
                    licenseFeature = LicenseFeature.CONTENT_EDITING;
                    break;
                default:
                    licenseFeature = null;
                    break;
            }
            if (licenseFeature != null) {
                arrayList.add(licenseFeature);
            }
        }
        enumSetNoneOf2.addAll(arrayList);
        return enumSetNoneOf2;
    }

    @JvmStatic
    public static final FontManager getSystemFontManager() {
        ensureInitialized();
        e50 e50VarC = ar.c();
        e50VarC.getClass();
        return e50VarC;
    }

    @JvmStatic
    public static final synchronized void initialize(Context context, InitializationOptions options) {
        context.getClass();
        Nutrient nutrient = INSTANCE;
        if (options == null) {
            options = new InitializationOptions(null, null, null, null, 15, null);
        }
        nutrient.initializeInternal(context, options);
    }

    public static /* synthetic */ void initialize$default(Context context, InitializationOptions initializationOptions, int i, Object obj) {
        if ((i & 2) != 0) {
            initializationOptions = null;
        }
        initialize(context, initializationOptions);
    }

    private final void initializeInternal(Context context, InitializationOptions options) {
        ar.f();
        if (!initialized.get()) {
            initializeModules(context, options.getFontPaths());
            verifyLibraryABIs(context);
            NutrientNative.initialize(context, options.getFontPaths(), options.getCrossPlatformTechnology());
            HashMap map = xj.a;
            HashSet hashSetA = xj.a.a();
            if (!hashSetA.isEmpty()) {
                HashSet hashSet = new HashSet();
                Iterator it = hashSetA.iterator();
                while (it.hasNext()) {
                    hashSet.add(NativeHybridLicense.androidHybridIdToString((NativeAndroidHybridId) it.next()));
                }
                PdfLog.i(LOG_TAG, "Detected Hybrid Technology: %s.", TextUtils.join(", ", hashSet));
            }
            if ((context.getApplicationInfo().flags & 1048576) == 0) {
                PdfLog.e(LOG_TAG, "It seems your app did not declare android:largeHeap=\"true\" on the <application> tag of your AndroidManifest.xml.\nRendering PDF documents is a memory intensive task. To prevent the chance of out-of-memory errors, consider adding this flag to your manifest.\nMore information: http://developer.android.com/guide/topics/manifest/application-element.html#largeHeap", new Object[0]);
            }
            if (Settings.Global.getInt(context.getContentResolver(), "always_finish_activities", 0) == 1) {
                PdfLog.d(LOG_TAG, "It seems that the \"Don't keep activities\" developer option is enabled. If you are encountering issues make sure to disable this option and see if the issues persist.", new Object[0]);
            }
            initialized.set(true);
        }
        initializeLicenseKey(options.getLicenseKey());
        ApplicationPolicy applicationPolicy = options.getApplicationPolicy();
        if (applicationPolicy != null) {
            setApplicationPolicy(applicationPolicy);
        }
    }

    private final void initializeLicenseKey(String licenseKey) {
        String strValueOf;
        if (licenseKey == null || licenseKey.length() == 0) {
            NutrientNative.setLicenseKey(licenseKey);
            return;
        }
        try {
            strValueOf = u40.c(licenseKey);
            strValueOf.getClass();
        } catch (Exception unused) {
            strValueOf = String.valueOf(u40.a(licenseKey));
        }
        if (Intrinsics.areEqual(confirmedLicenseKeyHash, strValueOf)) {
            return;
        }
        if (!NutrientNative.setLicenseKey(licenseKey)) {
            throw new InvalidNutrientLicenseException("Failed to initialize Nutrient.");
        }
        confirmedLicenseKeyHash = strValueOf;
    }

    private final void initializeModules(Context context, List<String> fontPaths) {
        context.getClass();
        n5.a = context;
        synchronized (ar.class) {
            ar.g = new e50(fontPaths);
        }
    }

    @JvmStatic
    public static final boolean isInitialized() {
        return initialized.get();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004a  */
    @JvmStatic
    public static final boolean isOpenableUri(Context context, Uri uri) {
        boolean z;
        context.getClass();
        uri.getClass();
        if (wg.a(context, uri) != null) {
            return true;
        }
        String string = uri.toString();
        string.getClass();
        if (StringsKt.startsWith$default(string, "file:///android_asset/", false, 2, (Object) null)) {
            return true;
        }
        try {
            Cursor cursorQuery = MAMContentResolverManagement.query(context.getContentResolver(), uri, new String[]{"_size"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    z = cursorQuery.moveToFirst() && cursorQuery.getString(0) != null;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(cursorQuery, th);
                        throw th2;
                    }
                }
            }
            CloseableKt.closeFinally(cursorQuery, null);
            return z;
        } catch (Exception unused) {
            return false;
        }
    }

    @JvmStatic
    public static final synchronized void release() {
        if (initialized.compareAndSet(true, false)) {
            confirmedLicenseKeyHash = "";
            ar.e();
        }
    }

    @JvmStatic
    public static final void setApplicationPolicy(ApplicationPolicy applicationPolicy) {
        applicationPolicy.getClass();
        ensureInitialized();
        synchronized (ar.class) {
            uw.a(applicationPolicy, "applicationPolicy", null);
            ar.f = applicationPolicy;
        }
    }

    private final void verifyLibraryABIs(Context context) {
        a.a(context).subscribe(new b30());
    }

    public final boolean isLocalFileUri(Context context, Uri uri) {
        context.getClass();
        uri.getClass();
        return wg.a(context, uri) != null;
    }

    public final boolean removeAnalyticsClient(AnalyticsClient client) {
        client.getClass();
        ensureInitialized();
        i0 i0VarA = ar.a();
        i0VarA.getClass();
        if (!i0VarA.a.containsKey(client)) {
            return false;
        }
        ((Disposable) i0VarA.a.remove(client)).dispose();
        return true;
    }

    public final void setLocalizationListener(LocalizationListener localizationListener) {
        localizationListener.getClass();
        lo.a = localizationListener;
    }

    public final void setNativeCrashDumpPath(String path) {
        path.getClass();
        ensureInitialized();
        NutrientNative.setNativeCrashPath(path);
    }

    @JvmStatic
    public static final synchronized void initialize(Context context, String licenseKey) {
        context.getClass();
        licenseKey.getClass();
        initialize(context, new InitializationOptions(licenseKey, null, null, null, 14, null));
    }
}
