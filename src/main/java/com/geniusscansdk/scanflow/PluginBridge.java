package com.geniusscansdk.scanflow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import androidx.core.net.UriKt;
import androidx.exifinterface.media.ExifInterface;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.androidsdk.content.models.BoxOrder;
import com.facebook.react.uimanager.ViewProps;
import com.geniusscansdk.core.GeniusScanSDK;
import com.geniusscansdk.core.LicenseKeyStorage;
import com.geniusscansdk.core.ScanProcessor;
import com.geniusscansdk.core.TextLayout;
import com.geniusscansdk.pdf.DocumentGenerator;
import com.geniusscansdk.pdf.PDFDocument;
import com.geniusscansdk.pdf.PDFPage;
import com.geniusscansdk.readablecodeflow.ReadableCodeConfiguration;
import com.geniusscansdk.readablecodeflow.ReadableCodeFlow;
import com.geniusscansdk.readablecodeflow.ReadableCodeFlowResult;
import com.geniusscansdk.structureddata.ReadableCode;
import com.geniusscansdk.structureddata.ReceiptCategory;
import com.geniusscansdk.structureddata.StructuredDataReceipt;
import com.geniusscansdk.structureddata.StructuredDataResult;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PluginBridge.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000eH\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0005H\u0007J$\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000eH\u0007J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0005H\u0007J!\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0001¢\u0006\u0002\b\u0012J!\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000eH\u0001¢\u0006\u0002\b\u0016J!\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000eH\u0000¢\u0006\u0002\b\u0019J\u001c\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000eH\u0002J\f\u0010\u001c\u001a\u00020\u001d*\u00020\u0001H\u0002J.\u0010\u001e\u001a\u0002H\u001f\"\u0006\b\u0000\u0010\u001f\u0018\u0001*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010 \u001a\u00020\u0005H\u0082\b¢\u0006\u0002\u0010!J$\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001d2\b\u0010&\u001a\u0004\u0018\u00010'H\u0007J,\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010(\u001a\u00020)2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001d2\b\u0010&\u001a\u0004\u0018\u00010'H\u0007J-\u0010*\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010+j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001`,*\u00020-H\u0000¢\u0006\u0002\b.J,\u0010*\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050+j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005`,*\u00020/H\u0002J,\u0010*\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010+j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001`,*\u000200H\u0002J,\u0010*\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010+j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001`,*\u000201H\u0002J(\u0010*\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050+j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`,*\u000202H\u0002J-\u0010*\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010+j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001`,*\u000203H\u0000¢\u0006\u0002\b.J\f\u00104\u001a\u000205*\u00020\u0005H\u0002J\f\u00106\u001a\u000207*\u00020\u0005H\u0002J\f\u00108\u001a\u000209*\u00020\u0005H\u0002J(\u0010:\u001a\u00020\n2\u0006\u0010(\u001a\u00020)2\u0006\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0005H\u0007J8\u0010?\u001a\u00020#2\u0006\u0010(\u001a\u00020)2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000e2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000eH\u0007J \u0010?\u001a\u00020#2\u0006\u0010(\u001a\u00020)2\u0006\u0010B\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007J\u001c\u0010C\u001a\u00020D2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000eH\u0002J\u001c\u0010E\u001a\u00020F2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/geniusscansdk/scanflow/PluginBridge;", "", "<init>", "()V", PluginBridge.E_SCAN_CANCELED, "", PluginBridge.E_LICENSE_KEY_ERROR, "DOCUMENT_GENERATION_ERROR", PluginBridge.E_READABLE_CODE_SCAN_CANCELED, "scanWithConfiguration", "", "activity", "Landroid/app/Activity;", "configuration", "", "jsonConfiguration", "scanReadableCodesWithConfiguration", "fromJSON", "fromJSON$gssdk_release", "createScanConfiguration", "Lcom/geniusscansdk/scanflow/ScanConfiguration;", "mapConfiguration", "createScanConfiguration$gssdk_release", "createReadableCodeConfiguration", "Lcom/geniusscansdk/readablecodeflow/ReadableCodeConfiguration;", "createReadableCodeConfiguration$gssdk_release", "createOcrConfiguration", "Lcom/geniusscansdk/scanflow/ScanConfiguration$OcrConfiguration;", "toInt", "", PasskeyWebListener.GET_UNIQUE_KEY, ExifInterface.GPS_DIRECTION_TRUE, "key", "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Object;", "getPromiseResultFromActivityResult", "Lcom/geniusscansdk/scanflow/PromiseResult;", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "serialize", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Lcom/geniusscansdk/scanflow/ScanResult;", "serialize$gssdk_release", "Lcom/geniusscansdk/scanflow/ScanResult$OcrResult;", "Lcom/geniusscansdk/structureddata/StructuredDataResult;", "Lcom/geniusscansdk/structureddata/StructuredDataReceipt;", "Lcom/geniusscansdk/structureddata/ReadableCode;", "Lcom/geniusscansdk/readablecodeflow/ReadableCodeFlowResult$Success;", "toCurvatureCorrectionMode", "Lcom/geniusscansdk/scanflow/ScanConfiguration$CurvatureCorrectionMode;", "toScanOrientation", "Lcom/geniusscansdk/scanflow/ScanConfiguration$Orientation;", "toReadabilityLevel", "Lcom/geniusscansdk/core/ScanProcessor$ReadabilityLevel;", "setLicenseKey", "licenseKey", "autoRefresh", "", "framework", "generateDocument", "documentMap", "configurationMap", "jsonDocument", "deserializePdfDocument", "Lcom/geniusscansdk/pdf/PDFDocument;", "deserializeDocumentGeneratorConfiguration", "Lcom/geniusscansdk/pdf/DocumentGenerator$Configuration;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PluginBridge {
    private static final String DOCUMENT_GENERATION_ERROR = "E_DOCUMENT_GENERATION_ERROR";
    private static final String E_LICENSE_KEY_ERROR = "E_LICENSE_KEY_ERROR";
    private static final String E_READABLE_CODE_SCAN_CANCELED = "E_READABLE_CODE_SCAN_CANCELED";
    private static final String E_SCAN_CANCELED = "E_SCAN_CANCELED";
    public static final PluginBridge INSTANCE = new PluginBridge();

    private PluginBridge() {
    }

    @JvmStatic
    public static final void scanWithConfiguration(Activity activity, Map<String, ? extends Object> configuration) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        ScanFlow.scanWithConfiguration(activity, INSTANCE.createScanConfiguration$gssdk_release(configuration));
    }

    @JvmStatic
    public static final void scanWithConfiguration(Activity activity, String jsonConfiguration) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(jsonConfiguration, "jsonConfiguration");
        PluginBridge pluginBridge = INSTANCE;
        ScanFlow.scanWithConfiguration(activity, pluginBridge.createScanConfiguration$gssdk_release(pluginBridge.fromJSON$gssdk_release(jsonConfiguration)));
    }

    @JvmStatic
    public static final void scanReadableCodesWithConfiguration(Activity activity, Map<String, ? extends Object> configuration) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        ReadableCodeFlow.scanWithConfiguration(activity, INSTANCE.createReadableCodeConfiguration$gssdk_release(configuration));
    }

    @JvmStatic
    public static final void scanReadableCodesWithConfiguration(Activity activity, String jsonConfiguration) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(jsonConfiguration, "jsonConfiguration");
        PluginBridge pluginBridge = INSTANCE;
        ReadableCodeFlow.scanWithConfiguration(activity, pluginBridge.createReadableCodeConfiguration$gssdk_release(pluginBridge.fromJSON$gssdk_release(jsonConfiguration)));
    }

    public final Map<String, Object> fromJSON$gssdk_release(String jsonConfiguration) {
        Intrinsics.checkNotNullParameter(jsonConfiguration, "jsonConfiguration");
        Object objFromJson = new Gson().fromJson(jsonConfiguration, new TypeToken<Map<String, ? extends Object>>() { // from class: com.geniusscansdk.scanflow.PluginBridge$fromJSON$mapType$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (Map) objFromJson;
    }

    public final ScanConfiguration createScanConfiguration$gssdk_release(Map<String, ? extends Object> mapConfiguration) {
        Intrinsics.checkNotNullParameter(mapConfiguration, "mapConfiguration");
        ScanConfiguration scanConfiguration = new ScanConfiguration(null, null, false, null, null, null, false, null, null, null, false, false, null, 0, 0, 0, 0, 0, null, null, null, null, null, null, false, 33554431, null);
        if (mapConfiguration.containsKey("source")) {
            ScanConfiguration.Source.Companion companion = ScanConfiguration.Source.INSTANCE;
            Object obj = mapConfiguration.get("source");
            if (obj != null) {
                scanConfiguration.source = companion.fromCode((String) obj);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
        if (mapConfiguration.containsKey("sourceImageUrl")) {
            Object obj2 = mapConfiguration.get("sourceImageUrl");
            if (obj2 != null) {
                scanConfiguration.sourceImage = UriKt.toFile(Uri.parse((String) obj2));
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
        if (mapConfiguration.containsKey("multiPage")) {
            Object obj3 = mapConfiguration.get("multiPage");
            if (obj3 != null) {
                scanConfiguration.multiPage = ((Boolean) obj3).booleanValue();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
        }
        if (mapConfiguration.containsKey("defaultFilter")) {
            ScanConfiguration.Filter.Companion companion2 = ScanConfiguration.Filter.INSTANCE;
            Object obj4 = mapConfiguration.get("defaultFilter");
            if (obj4 != null) {
                scanConfiguration.defaultFilter = companion2.fromCode((String) obj4);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
        if (mapConfiguration.containsKey("availableFilters")) {
            Object obj5 = mapConfiguration.get("availableFilters");
            if (obj5 != null) {
                List list = (List) obj5;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(ScanConfiguration.Filter.INSTANCE.fromCode((String) it.next()));
                }
                scanConfiguration.availableFilters = arrayList;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            }
        }
        if (mapConfiguration.containsKey("pdfPageSize")) {
            ScanConfiguration.PdfPageSize.Companion companion3 = ScanConfiguration.PdfPageSize.INSTANCE;
            Object obj6 = mapConfiguration.get("pdfPageSize");
            if (obj6 != null) {
                scanConfiguration.pdfPageSize = companion3.fromCode((String) obj6);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
        if (mapConfiguration.containsKey("skipPostProcessingScreen")) {
            Object obj7 = mapConfiguration.get("skipPostProcessingScreen");
            if (obj7 != null) {
                scanConfiguration.skipPostProcessingScreen = ((Boolean) obj7).booleanValue();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
        }
        if (mapConfiguration.containsKey("postProcessingActions")) {
            Object obj8 = mapConfiguration.get("postProcessingActions");
            if (obj8 != null) {
                scanConfiguration.postProcessingActions = ScanConfiguration.Action.INSTANCE.fromCodes((List) obj8);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            }
        }
        if (mapConfiguration.containsKey("defaultCurvatureCorrection")) {
            Object obj9 = mapConfiguration.get("defaultCurvatureCorrection");
            if (obj9 != null) {
                scanConfiguration.defaultCurvatureCorrection = toCurvatureCorrectionMode((String) obj9);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
        if (mapConfiguration.containsKey("defaultScanOrientation")) {
            Object obj10 = mapConfiguration.get("defaultScanOrientation");
            if (obj10 != null) {
                scanConfiguration.defaultScanOrientation = toScanOrientation((String) obj10);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
        if (mapConfiguration.containsKey("flashButtonHidden")) {
            Object obj11 = mapConfiguration.get("flashButtonHidden");
            if (obj11 != null) {
                scanConfiguration.flashButtonHidden = ((Boolean) obj11).booleanValue();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
        }
        if (mapConfiguration.containsKey("photoLibraryButtonHidden")) {
            Object obj12 = mapConfiguration.get("photoLibraryButtonHidden");
            if (obj12 != null) {
                scanConfiguration.photoLibraryButtonHidden = ((Boolean) obj12).booleanValue();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
        }
        if (mapConfiguration.containsKey("defaultFlashMode")) {
            ScanConfiguration.FlashMode.Companion companion4 = ScanConfiguration.FlashMode.INSTANCE;
            Object obj13 = mapConfiguration.get("defaultFlashMode");
            if (obj13 != null) {
                scanConfiguration.defaultFlashMode = companion4.fromCode((String) obj13);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
        if (mapConfiguration.containsKey("backgroundColor")) {
            Object obj14 = mapConfiguration.get("backgroundColor");
            if (obj14 != null) {
                scanConfiguration.backgroundColor = Color.parseColor((String) obj14);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
        if (mapConfiguration.containsKey(ViewProps.FOREGROUND_COLOR)) {
            Object obj15 = mapConfiguration.get(ViewProps.FOREGROUND_COLOR);
            if (obj15 != null) {
                scanConfiguration.foregroundColor = Color.parseColor((String) obj15);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
        if (mapConfiguration.containsKey("highlightColor")) {
            Object obj16 = mapConfiguration.get("highlightColor");
            if (obj16 != null) {
                scanConfiguration.highlightColor = Color.parseColor((String) obj16);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
        if (mapConfiguration.containsKey("jpegQuality")) {
            Object obj17 = mapConfiguration.get("jpegQuality");
            Intrinsics.checkNotNull(obj17);
            scanConfiguration.jpegQuality = toInt(obj17);
        }
        if (mapConfiguration.containsKey("pdfMaxScanDimension")) {
            Object obj18 = mapConfiguration.get("pdfMaxScanDimension");
            Intrinsics.checkNotNull(obj18);
            scanConfiguration.pdfMaxScanDimension = toInt(obj18);
        }
        if (mapConfiguration.containsKey("ocrConfiguration")) {
            Object obj19 = mapConfiguration.get("ocrConfiguration");
            if (obj19 != null) {
                scanConfiguration.ocrConfiguration = createOcrConfiguration((Map) obj19);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
            }
        }
        if (mapConfiguration.containsKey("multiPageFormat")) {
            ScanConfiguration.MultiPageFormat.Companion companion5 = ScanConfiguration.MultiPageFormat.INSTANCE;
            Object obj20 = mapConfiguration.get("multiPageFormat");
            if (obj20 != null) {
                scanConfiguration.multiPageFormat = companion5.fromCode((String) obj20);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
        if (mapConfiguration.containsKey("pdfFontFileUrl")) {
            Object obj21 = mapConfiguration.get("pdfFontFileUrl");
            if (obj21 != null) {
                scanConfiguration.pdfFontFile = UriKt.toFile(Uri.parse((String) obj21));
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
        if (mapConfiguration.containsKey("structuredData")) {
            Object obj22 = mapConfiguration.get("structuredData");
            if (obj22 != null) {
                scanConfiguration.structuredData = ScanConfiguration.StructuredData.INSTANCE.fromCodes((List) obj22);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            }
        }
        if (mapConfiguration.containsKey("structuredDataReadableCodeTypes")) {
            Object obj23 = mapConfiguration.get("structuredDataReadableCodeTypes");
            if (obj23 != null) {
                scanConfiguration.structuredDataReadableCodeTypes = ReadableCode.Type.INSTANCE.fromCodes((List) obj23);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            }
        }
        if (!mapConfiguration.containsKey("requiredReadabilityLevel")) {
            return scanConfiguration;
        }
        Object obj24 = mapConfiguration.get("requiredReadabilityLevel");
        if (obj24 != null) {
            scanConfiguration.requiredReadabilityLevel = toReadabilityLevel((String) obj24);
            return scanConfiguration;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final ReadableCodeConfiguration createReadableCodeConfiguration$gssdk_release(Map<String, ? extends Object> mapConfiguration) {
        boolean zBooleanValue;
        Intrinsics.checkNotNullParameter(mapConfiguration, "mapConfiguration");
        if (mapConfiguration.containsKey("isBatchModeEnabled")) {
            Object obj = mapConfiguration.get("isBatchModeEnabled");
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            zBooleanValue = ((Boolean) obj).booleanValue();
        } else {
            zBooleanValue = false;
        }
        boolean z = zBooleanValue;
        EnumSet<ReadableCode.Type> set = CollectionsKt.toSet(ReadableCode.Type.getEntries());
        if (mapConfiguration.containsKey("supportedCodeTypes")) {
            Object obj2 = mapConfiguration.get("supportedCodeTypes");
            if (obj2 != null) {
                set = ReadableCode.Type.INSTANCE.fromCodes((List) obj2);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            }
        }
        return new ReadableCodeConfiguration(z, set, 0, 0, 12, null);
    }

    private final ScanConfiguration.OcrConfiguration createOcrConfiguration(Map<String, ? extends Object> mapConfiguration) {
        ScanConfiguration.OcrConfiguration ocrConfiguration = new ScanConfiguration.OcrConfiguration(null, null, 3, null);
        if (mapConfiguration.containsKey("languages")) {
            Object obj = mapConfiguration.get("languages");
            if (obj != null) {
                ocrConfiguration.languages = (List) obj;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            }
        }
        if (mapConfiguration.containsKey("languagesDirectoryUrl")) {
            throw new IllegalArgumentException("Language models are now automatically managed by the ScanFlow. Please check SDK changelog for v5.".toString());
        }
        if (!mapConfiguration.containsKey("outputFormats")) {
            return ocrConfiguration;
        }
        Object obj2 = mapConfiguration.get("outputFormats");
        if (obj2 != null) {
            ocrConfiguration.outputFormats = ScanConfiguration.OcrOutputFormat.INSTANCE.fromCodes((List) obj2);
            return ocrConfiguration;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
    }

    private final int toInt(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        throw new ClassCastException(obj + " cannot be converted to an integer");
    }

    private final /* synthetic */ <T> T get(Map<String, ? extends Object> map, String str) {
        T t = (T) map.get(str);
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }

    @JvmStatic
    public static final PromiseResult getPromiseResultFromActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 42) {
            if (resultCode != -1) {
                return PromiseResult.INSTANCE.reject(E_SCAN_CANCELED, "Scanning canceled by user");
            }
            if (data == null) {
                return PromiseResult.INSTANCE.resolve();
            }
            try {
                return PromiseResult.INSTANCE.resolve(INSTANCE.serialize$gssdk_release(ScanFlow.getScanResultFromActivityResult(data)));
            } catch (Exception e) {
                PromiseResult.Companion companion = PromiseResult.INSTANCE;
                String simpleName = e.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return companion.reject(simpleName, e.getMessage());
            }
        }
        if (requestCode != 43) {
            return null;
        }
        if (resultCode != -1 || data == null) {
            return PromiseResult.INSTANCE.reject(E_READABLE_CODE_SCAN_CANCELED, "Readable code scanning canceled by user");
        }
        ReadableCodeFlowResult resultFromActivityResult = ReadableCodeFlow.getResultFromActivityResult(data);
        if (resultFromActivityResult instanceof ReadableCodeFlowResult.Success) {
            return PromiseResult.INSTANCE.resolve(INSTANCE.serialize$gssdk_release((ReadableCodeFlowResult.Success) resultFromActivityResult));
        }
        if (!(resultFromActivityResult instanceof ReadableCodeFlowResult.Error)) {
            return PromiseResult.INSTANCE.reject(E_READABLE_CODE_SCAN_CANCELED, "Readable code scanning canceled by user");
        }
        ReadableCodeFlowResult.Error error = (ReadableCodeFlowResult.Error) resultFromActivityResult;
        return PromiseResult.INSTANCE.reject(error.getType().name(), error.getMessage());
    }

    @Deprecated(message = "Use method without context parameter", replaceWith = @ReplaceWith(expression = "getPromiseResultFromActivityResult(requestCode, resultCode, data)", imports = {}))
    @JvmStatic
    public static final PromiseResult getPromiseResultFromActivityResult(Context context, int requestCode, int resultCode, Intent data) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getPromiseResultFromActivityResult(requestCode, resultCode, data);
    }

    public final HashMap<String, Object> serialize$gssdk_release(ScanResult scanResult) {
        Intrinsics.checkNotNullParameter(scanResult, "<this>");
        HashMap<String, Object> map = new HashMap<>();
        File file = scanResult.multiPageDocument;
        if (file != null) {
            map.put("multiPageDocumentUrl", Uri.fromFile(file).toString());
        }
        List<ScanResult.Scan> list = scanResult.scans;
        if (list != null) {
            HashMap<String, Object> map2 = map;
            List<ScanResult.Scan> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (ScanResult.Scan scan : list2) {
                HashMap map3 = new HashMap();
                HashMap map4 = map3;
                map4.put("originalUrl", Uri.fromFile(scan.originalImageFile).toString());
                map4.put("enhancedUrl", Uri.fromFile(scan.enhancedImageFile).toString());
                ScanResult.OcrResult ocrResult = scan.ocrResult;
                if (ocrResult != null) {
                    map4.put("ocrResult", INSTANCE.serialize(ocrResult));
                }
                StructuredDataResult structuredDataResult = scan.structuredDataResult;
                if (structuredDataResult != null) {
                    map4.put("structuredData", INSTANCE.serialize(structuredDataResult));
                }
                arrayList.add(map3);
            }
            map2.put("scans", arrayList);
        }
        return map;
    }

    private final HashMap<String, String> serialize(ScanResult.OcrResult ocrResult) {
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, String> map2 = map;
        map2.put("text", ocrResult.text);
        map2.put("hocrTextLayout", ocrResult.hocrTextLayout);
        return map;
    }

    private final HashMap<String, Object> serialize(StructuredDataResult structuredDataResult) {
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> map2 = map;
        StructuredDataReceipt receipt = structuredDataResult.getReceipt();
        map2.put("receipt", receipt != null ? INSTANCE.serialize(receipt) : null);
        List<ReadableCode> readableCodes = structuredDataResult.getReadableCodes();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(readableCodes, 10));
        Iterator<T> it = readableCodes.iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.serialize((ReadableCode) it.next()));
        }
        map2.put("readableCodes", arrayList);
        return map;
    }

    private final HashMap<String, Object> serialize(StructuredDataReceipt structuredDataReceipt) {
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> map2 = map;
        Locale locale = structuredDataReceipt.getLocale();
        map2.put("locale", locale != null ? locale.getLanguage() : null);
        map2.put("merchant", structuredDataReceipt.getMerchant());
        map2.put("amount", structuredDataReceipt.getAmount());
        map2.put(FirebaseAnalytics.Param.CURRENCY, structuredDataReceipt.getCurrency());
        Date date = structuredDataReceipt.getDate();
        map2.put(BoxOrder.SORT_DATE, date != null ? Long.valueOf(date.getTime()) : null);
        ReceiptCategory category = structuredDataReceipt.getCategory();
        map2.put("category", category != null ? category.getDescription() : null);
        return map;
    }

    private final HashMap<String, String> serialize(ReadableCode readableCode) {
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, String> map2 = map;
        map2.put("value", readableCode.getValue());
        map2.put("type", readableCode.getType().getCode());
        return map;
    }

    public final HashMap<String, Object> serialize$gssdk_release(ReadableCodeFlowResult.Success success) {
        Intrinsics.checkNotNullParameter(success, "<this>");
        Pair[] pairArr = new Pair[1];
        List<ReadableCode> codes = success.getCodes();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(codes, 10));
        for (ReadableCode readableCode : codes) {
            arrayList.add(MapsKt.mapOf(TuplesKt.to("value", readableCode.getValue()), TuplesKt.to("type", readableCode.getType().getCode())));
        }
        pairArr[0] = TuplesKt.to("readableCodes", arrayList);
        return MapsKt.hashMapOf(pairArr);
    }

    private final ScanConfiguration.CurvatureCorrectionMode toCurvatureCorrectionMode(String str) {
        if (Intrinsics.areEqual(str, "enabled")) {
            return ScanConfiguration.CurvatureCorrectionMode.ENABLED;
        }
        if (Intrinsics.areEqual(str, "disabled")) {
            return ScanConfiguration.CurvatureCorrectionMode.DISABLED;
        }
        throw new IllegalArgumentException("Invalid curvature correction mode: " + str);
    }

    private final ScanConfiguration.Orientation toScanOrientation(String str) {
        if (Intrinsics.areEqual(str, "original")) {
            return ScanConfiguration.Orientation.ORIGINAL;
        }
        if (Intrinsics.areEqual(str, "automatic")) {
            return ScanConfiguration.Orientation.AUTOMATIC;
        }
        throw new IllegalArgumentException("Invalid scan orientation: " + str);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final ScanProcessor.ReadabilityLevel toReadabilityLevel(String str) {
        switch (str.hashCode()) {
            case -1096862286:
                if (str.equals("lowest")) {
                    return ScanProcessor.ReadabilityLevel.Lowest;
                }
                break;
            case -1078030475:
                if (str.equals(FirebaseAnalytics.Param.MEDIUM)) {
                    return ScanProcessor.ReadabilityLevel.Medium;
                }
                break;
            case 107348:
                if (str.equals("low")) {
                    return ScanProcessor.ReadabilityLevel.Low;
                }
                break;
            case 3202466:
                if (str.equals("high")) {
                    return ScanProcessor.ReadabilityLevel.High;
                }
                break;
            case 915484836:
                if (str.equals("highest")) {
                    return ScanProcessor.ReadabilityLevel.Highest;
                }
                break;
        }
        throw new IllegalArgumentException("Invalid readability level: " + str);
    }

    @JvmStatic
    public static final void setLicenseKey(Context context, String licenseKey, boolean autoRefresh, String framework) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(licenseKey, "licenseKey");
        Intrinsics.checkNotNullParameter(framework, "framework");
        SharedPreferences sharedPreferences = context.getSharedPreferences(LicenseKeyStorage.PREFERENCES_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("framework", framework);
        editorEdit.apply();
        GeniusScanSDK.setLicenseKey(context, licenseKey, autoRefresh);
    }

    @JvmStatic
    public static final PromiseResult generateDocument(Context context, Map<String, ? extends Object> documentMap, Map<String, ? extends Object> configurationMap) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(documentMap, "documentMap");
        Intrinsics.checkNotNullParameter(configurationMap, "configurationMap");
        PluginBridge pluginBridge = INSTANCE;
        try {
            DocumentGenerator.generatePDFDocument$default(new DocumentGenerator(context), pluginBridge.deserializePdfDocument(documentMap), pluginBridge.deserializeDocumentGeneratorConfiguration(configurationMap), null, 4, null);
            return PromiseResult.INSTANCE.resolve();
        } catch (DocumentGenerator.Exception e) {
            return PromiseResult.INSTANCE.reject(DOCUMENT_GENERATION_ERROR, e.getMessage());
        }
    }

    @JvmStatic
    public static final PromiseResult generateDocument(Context context, String jsonDocument, String jsonConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jsonDocument, "jsonDocument");
        Intrinsics.checkNotNullParameter(jsonConfiguration, "jsonConfiguration");
        PluginBridge pluginBridge = INSTANCE;
        return generateDocument(context, (Map<String, ? extends Object>) pluginBridge.fromJSON$gssdk_release(jsonDocument), (Map<String, ? extends Object>) pluginBridge.fromJSON$gssdk_release(jsonConfiguration));
    }

    private final PDFDocument deserializePdfDocument(Map<String, ? extends Object> documentMap) {
        Object obj = documentMap.get(SupportedFileExtensions.PAGES_EXTENSION);
        if (obj != null) {
            List<Map> list = (List) obj;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Map map : list) {
                Object obj2 = map.get("imageUrl");
                if (obj2 != null) {
                    File file = UriKt.toFile(Uri.parse((String) obj2));
                    String str = (String) map.get("hocrTextLayout");
                    arrayList.add(new PDFPage(file, ScanConfiguration.PdfPageSize.FIT.toPDFSize(), str != null ? new TextLayout(str) : null));
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }
            return new PDFDocument(arrayList, null, null, null, new Date(), new Date(), 14, null);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, kotlin.Any>>");
    }

    private final DocumentGenerator.Configuration deserializeDocumentGeneratorConfiguration(Map<String, ? extends Object> configurationMap) {
        Uri uri;
        Object obj = configurationMap.get("outputFileUrl");
        if (obj != null) {
            File file = UriKt.toFile(Uri.parse((String) obj));
            String str = (String) configurationMap.get("pdfFontFileUrl");
            return new DocumentGenerator.Configuration(file, (str == null || (uri = Uri.parse(str)) == null) ? null : UriKt.toFile(uri), null, 4, null);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }
}
