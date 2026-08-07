package com.box.android.capture.documentscanning.logic;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextRecognitionConverter.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/box/android/capture/documentscanning/logic/TextRecognitionConversionResult;", "", "hOcrString", "", "charactersByLanguage", "", "", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "getHOcrString", "()Ljava/lang/String;", "getCharactersByLanguage", "()Ljava/util/Map;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TextRecognitionConversionResult {
    public static final int $stable = 8;
    private final Map<String, Integer> charactersByLanguage;
    private final String hOcrString;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextRecognitionConversionResult copy$default(TextRecognitionConversionResult textRecognitionConversionResult, String str, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = textRecognitionConversionResult.hOcrString;
        }
        if ((i & 2) != 0) {
            map = textRecognitionConversionResult.charactersByLanguage;
        }
        return textRecognitionConversionResult.copy(str, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getHOcrString() {
        return this.hOcrString;
    }

    public final Map<String, Integer> component2() {
        return this.charactersByLanguage;
    }

    public final TextRecognitionConversionResult copy(String hOcrString, Map<String, Integer> charactersByLanguage) {
        Intrinsics.checkNotNullParameter(hOcrString, "hOcrString");
        Intrinsics.checkNotNullParameter(charactersByLanguage, "charactersByLanguage");
        return new TextRecognitionConversionResult(hOcrString, charactersByLanguage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextRecognitionConversionResult)) {
            return false;
        }
        TextRecognitionConversionResult textRecognitionConversionResult = (TextRecognitionConversionResult) other;
        return Intrinsics.areEqual(this.hOcrString, textRecognitionConversionResult.hOcrString) && Intrinsics.areEqual(this.charactersByLanguage, textRecognitionConversionResult.charactersByLanguage);
    }

    public int hashCode() {
        return (this.hOcrString.hashCode() * 31) + this.charactersByLanguage.hashCode();
    }

    public String toString() {
        return "TextRecognitionConversionResult(hOcrString=" + this.hOcrString + ", charactersByLanguage=" + this.charactersByLanguage + ")";
    }

    public TextRecognitionConversionResult(String hOcrString, Map<String, Integer> charactersByLanguage) {
        Intrinsics.checkNotNullParameter(hOcrString, "hOcrString");
        Intrinsics.checkNotNullParameter(charactersByLanguage, "charactersByLanguage");
        this.hOcrString = hOcrString;
        this.charactersByLanguage = charactersByLanguage;
    }

    public final Map<String, Integer> getCharactersByLanguage() {
        return this.charactersByLanguage;
    }

    public final String getHOcrString() {
        return this.hOcrString;
    }
}
