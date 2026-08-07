package com.geniusscansdk.ocr;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.utilities.script.JavascriptRunner;

/* JADX INFO: compiled from: OcrEngineSelector.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\n"}, d2 = {"Lcom/geniusscansdk/ocr/OcrEngineSelector;", "", "<init>", "()V", "selectEngine", "Lcom/geniusscansdk/ocr/OcrEngineSelector$EngineSelection;", "requestedLanguages", "", "Lcom/geniusscansdk/ocr/OcrLanguage;", "EngineSelection", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OcrEngineSelector {

    /* JADX INFO: compiled from: OcrEngineSelector.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/geniusscansdk/ocr/OcrEngineSelector$EngineSelection;", "", "MLKit", "Tesseract", "Lcom/geniusscansdk/ocr/OcrEngineSelector$EngineSelection$MLKit;", "Lcom/geniusscansdk/ocr/OcrEngineSelector$EngineSelection$Tesseract;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface EngineSelection {

        /* JADX INFO: compiled from: OcrEngineSelector.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/geniusscansdk/ocr/OcrEngineSelector$EngineSelection$MLKit;", "Lcom/geniusscansdk/ocr/OcrEngineSelector$EngineSelection;", JavascriptRunner.SCRIPT_NAME, "Lcom/geniusscansdk/ocr/MLKitScript;", "<init>", "(Lcom/geniusscansdk/ocr/MLKitScript;)V", "getScript", "()Lcom/geniusscansdk/ocr/MLKitScript;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class MLKit implements EngineSelection {
            private final MLKitScript script;

            public static /* synthetic */ MLKit copy$default(MLKit mLKit, MLKitScript mLKitScript, int i, Object obj) {
                if ((i & 1) != 0) {
                    mLKitScript = mLKit.script;
                }
                return mLKit.copy(mLKitScript);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final MLKitScript getScript() {
                return this.script;
            }

            public final MLKit copy(MLKitScript script) {
                Intrinsics.checkNotNullParameter(script, "script");
                return new MLKit(script);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof MLKit) && this.script == ((MLKit) other).script;
            }

            public int hashCode() {
                return this.script.hashCode();
            }

            public String toString() {
                return "MLKit(script=" + this.script + ")";
            }

            public MLKit(MLKitScript script) {
                Intrinsics.checkNotNullParameter(script, "script");
                this.script = script;
            }

            public final MLKitScript getScript() {
                return this.script;
            }
        }

        /* JADX INFO: compiled from: OcrEngineSelector.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/geniusscansdk/ocr/OcrEngineSelector$EngineSelection$Tesseract;", "Lcom/geniusscansdk/ocr/OcrEngineSelector$EngineSelection;", "<init>", "()V", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Tesseract implements EngineSelection {
            public static final Tesseract INSTANCE = new Tesseract();

            private Tesseract() {
            }
        }
    }

    public final EngineSelection selectEngine(List<OcrLanguage> requestedLanguages) {
        MLKitScript mLKitScript;
        Intrinsics.checkNotNullParameter(requestedLanguages, "requestedLanguages");
        if (requestedLanguages.isEmpty()) {
            throw new IllegalArgumentException("Please provide at least one language to perform OCR");
        }
        List<OcrLanguage> list = requestedLanguages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((OcrLanguage) it.next()).getMlKitScript$gssdk_release());
        }
        Set set = CollectionsKt.toSet(arrayList);
        if (set.size() == 1 && (mLKitScript = (MLKitScript) CollectionsKt.first(set)) != null) {
            return new EngineSelection.MLKit(mLKitScript);
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((OcrLanguage) it2.next()).getTesseractCode$gssdk_release());
        }
        if (!arrayList2.contains(null)) {
            return EngineSelection.Tesseract.INSTANCE;
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it3 = list.iterator();
        while (it3.hasNext()) {
            arrayList3.add(((OcrLanguage) it3.next()).getTag());
        }
        throw new IllegalArgumentException("Cannot find an OCR engine for languages " + arrayList3 + ".");
    }
}
