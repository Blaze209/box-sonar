package com.geniusscansdk.core;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextLayoutToTextConverter.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0004\u000e\u000f\u0010\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rR\u0018\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/geniusscansdk/core/TextLayoutToTextConverter;", "", "<init>", "()V", "fromJNI", "Lcom/geniusscansdk/core/TextLayoutToTextConverter$Result;", "Lcom/geniusscansdk/core/JNITextLayoutToTextConverterResult;", "converter", "Lcom/geniusscansdk/core/JNITextLayoutToTextConverter;", "kotlin.jvm.PlatformType", "Lcom/geniusscansdk/core/JNITextLayoutToTextConverter;", "convert", "textLayout", "Lcom/geniusscansdk/core/TextLayout;", "Exception", "InternalError", "InvalidHocrError", "Result", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextLayoutToTextConverter {
    private final JNITextLayoutToTextConverter converter = JNITextLayoutToTextConverter.create(GeniusScanSDK.getLogger());

    /* JADX INFO: compiled from: TextLayoutToTextConverter.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JNITextLayoutToTextConverterStatus.values().length];
            try {
                iArr[JNITextLayoutToTextConverterStatus.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JNITextLayoutToTextConverterStatus.INTERNALERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[JNITextLayoutToTextConverterStatus.INVALIDHOCRERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: compiled from: TextLayoutToTextConverter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/geniusscansdk/core/TextLayoutToTextConverter$Exception;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "()V", "Lcom/geniusscansdk/core/TextLayoutToTextConverter$InternalError;", "Lcom/geniusscansdk/core/TextLayoutToTextConverter$InvalidHocrError;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class Exception extends java.lang.Exception {
        public /* synthetic */ Exception(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Exception() {
        }
    }

    /* JADX INFO: compiled from: TextLayoutToTextConverter.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/geniusscansdk/core/TextLayoutToTextConverter$InternalError;", "Lcom/geniusscansdk/core/TextLayoutToTextConverter$Exception;", "<init>", "()V", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InternalError extends Exception {
        public InternalError() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: TextLayoutToTextConverter.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/geniusscansdk/core/TextLayoutToTextConverter$InvalidHocrError;", "Lcom/geniusscansdk/core/TextLayoutToTextConverter$Exception;", "<init>", "()V", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InvalidHocrError extends Exception {
        public InvalidHocrError() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: TextLayoutToTextConverter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/geniusscansdk/core/TextLayoutToTextConverter$Result;", "", "text", "", "averageWordConfidence", "", "wordCount", "<init>", "(Ljava/lang/String;II)V", "getText", "()Ljava/lang/String;", "getAverageWordConfidence", "()I", "getWordCount", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Result {
        private final int averageWordConfidence;
        private final String text;
        private final int wordCount;

        public static /* synthetic */ Result copy$default(Result result, String str, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = result.text;
            }
            if ((i3 & 2) != 0) {
                i = result.averageWordConfidence;
            }
            if ((i3 & 4) != 0) {
                i2 = result.wordCount;
            }
            return result.copy(str, i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getAverageWordConfidence() {
            return this.averageWordConfidence;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getWordCount() {
            return this.wordCount;
        }

        public final Result copy(String text, int averageWordConfidence, int wordCount) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new Result(text, averageWordConfidence, wordCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Result)) {
                return false;
            }
            Result result = (Result) other;
            return Intrinsics.areEqual(this.text, result.text) && this.averageWordConfidence == result.averageWordConfidence && this.wordCount == result.wordCount;
        }

        public int hashCode() {
            return (((this.text.hashCode() * 31) + Integer.hashCode(this.averageWordConfidence)) * 31) + Integer.hashCode(this.wordCount);
        }

        public String toString() {
            return "Result(text=" + this.text + ", averageWordConfidence=" + this.averageWordConfidence + ", wordCount=" + this.wordCount + ")";
        }

        public Result(String text, int i, int i2) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
            this.averageWordConfidence = i;
            this.wordCount = i2;
        }

        public final int getAverageWordConfidence() {
            return this.averageWordConfidence;
        }

        public final String getText() {
            return this.text;
        }

        public final int getWordCount() {
            return this.wordCount;
        }
    }

    private final Result fromJNI(JNITextLayoutToTextConverterResult jNITextLayoutToTextConverterResult) {
        String text = jNITextLayoutToTextConverterResult.text;
        Intrinsics.checkNotNullExpressionValue(text, "text");
        return new Result(text, jNITextLayoutToTextConverterResult.averageWordConfidence, jNITextLayoutToTextConverterResult.wordCount);
    }

    public final Result convert(TextLayout textLayout) throws Exception {
        Intrinsics.checkNotNullParameter(textLayout, "textLayout");
        JNITextLayoutToTextConverterResult jNITextLayoutToTextConverterResultConvert = this.converter.convert(textLayout.toJNI$gssdk_release());
        JNITextLayoutToTextConverterStatus jNITextLayoutToTextConverterStatus = jNITextLayoutToTextConverterResultConvert.status;
        int i = jNITextLayoutToTextConverterStatus == null ? -1 : WhenMappings.$EnumSwitchMapping$0[jNITextLayoutToTextConverterStatus.ordinal()];
        if (i == -1) {
            throw new InternalError();
        }
        if (i == 1) {
            Intrinsics.checkNotNull(jNITextLayoutToTextConverterResultConvert);
            return fromJNI(jNITextLayoutToTextConverterResultConvert);
        }
        if (i == 2) {
            throw new InternalError();
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        throw new InvalidHocrError();
    }
}
