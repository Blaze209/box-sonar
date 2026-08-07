package com.geniusscansdk.ocr;

import android.content.Context;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OcrLanguage.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B7\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b\u0017J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b\u0019J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÀ\u0003¢\u0006\u0002\b\u001bJF\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÀ\u0001¢\u0006\u0002\b\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006%"}, d2 = {"Lcom/geniusscansdk/ocr/OcrLanguage;", "", "tag", "", "displayName", "tesseractCode", "tesseractMD5", "mlKitScript", "Lcom/geniusscansdk/ocr/MLKitScript;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/geniusscansdk/ocr/MLKitScript;)V", "getTag", "()Ljava/lang/String;", "getDisplayName", "getTesseractCode$gssdk_release", "getTesseractMD5$gssdk_release", "setTesseractMD5$gssdk_release", "(Ljava/lang/String;)V", "getMlKitScript$gssdk_release", "()Lcom/geniusscansdk/ocr/MLKitScript;", "component1", "component2", "component3", "component3$gssdk_release", "component4", "component4$gssdk_release", "component5", "component5$gssdk_release", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy$gssdk_release", "equals", "", "other", "hashCode", "", "toString", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class OcrLanguage {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static List<OcrLanguage> allLanguages;
    private final String displayName;
    private final MLKitScript mlKitScript;
    private final String tag;
    private final String tesseractCode;
    private String tesseractMD5;

    public static /* synthetic */ OcrLanguage copy$gssdk_release$default(OcrLanguage ocrLanguage, String str, String str2, String str3, String str4, MLKitScript mLKitScript, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ocrLanguage.tag;
        }
        if ((i & 2) != 0) {
            str2 = ocrLanguage.displayName;
        }
        if ((i & 4) != 0) {
            str3 = ocrLanguage.tesseractCode;
        }
        if ((i & 8) != 0) {
            str4 = ocrLanguage.tesseractMD5;
        }
        if ((i & 16) != 0) {
            mLKitScript = ocrLanguage.mlKitScript;
        }
        MLKitScript mLKitScript2 = mLKitScript;
        String str5 = str3;
        return ocrLanguage.copy$gssdk_release(str, str2, str5, str4, mLKitScript2);
    }

    @JvmStatic
    public static final List<OcrLanguage> getAllLanguages(Context context) {
        return INSTANCE.getAllLanguages(context);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* JADX INFO: renamed from: component3$gssdk_release, reason: from getter */
    public final String getTesseractCode() {
        return this.tesseractCode;
    }

    /* JADX INFO: renamed from: component4$gssdk_release, reason: from getter */
    public final String getTesseractMD5() {
        return this.tesseractMD5;
    }

    /* JADX INFO: renamed from: component5$gssdk_release, reason: from getter */
    public final MLKitScript getMlKitScript() {
        return this.mlKitScript;
    }

    public final OcrLanguage copy$gssdk_release(String tag, String displayName, String tesseractCode, String tesseractMD5, MLKitScript mlKitScript) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        return new OcrLanguage(tag, displayName, tesseractCode, tesseractMD5, mlKitScript);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OcrLanguage)) {
            return false;
        }
        OcrLanguage ocrLanguage = (OcrLanguage) other;
        return Intrinsics.areEqual(this.tag, ocrLanguage.tag) && Intrinsics.areEqual(this.displayName, ocrLanguage.displayName) && Intrinsics.areEqual(this.tesseractCode, ocrLanguage.tesseractCode) && Intrinsics.areEqual(this.tesseractMD5, ocrLanguage.tesseractMD5) && this.mlKitScript == ocrLanguage.mlKitScript;
    }

    public int hashCode() {
        int iHashCode = ((this.tag.hashCode() * 31) + this.displayName.hashCode()) * 31;
        String str = this.tesseractCode;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.tesseractMD5;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        MLKitScript mLKitScript = this.mlKitScript;
        return iHashCode3 + (mLKitScript != null ? mLKitScript.hashCode() : 0);
    }

    public String toString() {
        return "OcrLanguage(tag=" + this.tag + ", displayName=" + this.displayName + ", tesseractCode=" + this.tesseractCode + ", tesseractMD5=" + this.tesseractMD5 + ", mlKitScript=" + this.mlKitScript + ")";
    }

    public OcrLanguage(String tag, String displayName, String str, String str2, MLKitScript mLKitScript) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        this.tag = tag;
        this.displayName = displayName;
        this.tesseractCode = str;
        this.tesseractMD5 = str2;
        this.mlKitScript = mLKitScript;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getTesseractCode$gssdk_release() {
        return this.tesseractCode;
    }

    public final String getTesseractMD5$gssdk_release() {
        return this.tesseractMD5;
    }

    public final void setTesseractMD5$gssdk_release(String str) {
        this.tesseractMD5 = str;
    }

    public final MLKitScript getMlKitScript$gssdk_release() {
        return this.mlKitScript;
    }

    /* JADX INFO: compiled from: OcrLanguage.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00020\tH\u0007R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/geniusscansdk/ocr/OcrLanguage$Companion;", "", "<init>", "()V", "allLanguages", "", "Lcom/geniusscansdk/ocr/OcrLanguage;", "getAllLanguages", "context", "Landroid/content/Context;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final List<OcrLanguage> getAllLanguages(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            List<OcrLanguage> list = OcrLanguage.allLanguages;
            if (list != null) {
                return list;
            }
            List<OcrLanguage> listLoadLanguages = new OcrLanguageListLoader(context).loadLanguages();
            Companion companion = OcrLanguage.INSTANCE;
            OcrLanguage.allLanguages = listLoadLanguages;
            return listLoadLanguages;
        }
    }
}
