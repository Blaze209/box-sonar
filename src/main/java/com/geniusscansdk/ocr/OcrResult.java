package com.geniusscansdk.ocr;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.geniusscansdk.core.TextLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OcrResult.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0004\u0018\u00010\tX\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006!"}, d2 = {"Lcom/geniusscansdk/ocr/OcrResult;", "Landroid/os/Parcelable;", "text", "", "textLayout", "Lcom/geniusscansdk/core/TextLayout;", "<init>", "(Ljava/lang/String;Lcom/geniusscansdk/core/TextLayout;)V", "spatialText", "Lcom/geniusscansdk/ocr/SpatialText;", "(Ljava/lang/String;Lcom/geniusscansdk/core/TextLayout;Lcom/geniusscansdk/ocr/SpatialText;)V", "getSpatialText$gssdk_release$annotations", "()V", "getSpatialText$gssdk_release", "()Lcom/geniusscansdk/ocr/SpatialText;", "setSpatialText$gssdk_release", "(Lcom/geniusscansdk/ocr/SpatialText;)V", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class OcrResult implements Parcelable {
    public static final Parcelable.Creator<OcrResult> CREATOR = new Creator();
    private SpatialText spatialText;
    public final String text;
    public final TextLayout textLayout;

    /* JADX INFO: compiled from: OcrResult.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OcrResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OcrResult createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OcrResult(parcel.readString(), TextLayout.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OcrResult[] newArray(int i) {
            return new OcrResult[i];
        }
    }

    public static /* synthetic */ OcrResult copy$default(OcrResult ocrResult, String str, TextLayout textLayout, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ocrResult.text;
        }
        if ((i & 2) != 0) {
            textLayout = ocrResult.textLayout;
        }
        return ocrResult.copy(str, textLayout);
    }

    public static /* synthetic */ void getSpatialText$gssdk_release$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final TextLayout getTextLayout() {
        return this.textLayout;
    }

    public final OcrResult copy(String text, TextLayout textLayout) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(textLayout, "textLayout");
        return new OcrResult(text, textLayout);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OcrResult)) {
            return false;
        }
        OcrResult ocrResult = (OcrResult) other;
        return Intrinsics.areEqual(this.text, ocrResult.text) && Intrinsics.areEqual(this.textLayout, ocrResult.textLayout);
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.textLayout.hashCode();
    }

    public String toString() {
        return "OcrResult(text=" + this.text + ", textLayout=" + this.textLayout + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.text);
        this.textLayout.writeToParcel(dest, flags);
    }

    public OcrResult(String text, TextLayout textLayout) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(textLayout, "textLayout");
        this.text = text;
        this.textLayout = textLayout;
    }

    /* JADX INFO: renamed from: getSpatialText$gssdk_release, reason: from getter */
    public final SpatialText getSpatialText() {
        return this.spatialText;
    }

    public final void setSpatialText$gssdk_release(SpatialText spatialText) {
        this.spatialText = spatialText;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OcrResult(String text, TextLayout textLayout, SpatialText spatialText) {
        this(text, textLayout);
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(textLayout, "textLayout");
        Intrinsics.checkNotNullParameter(spatialText, "spatialText");
        this.spatialText = spatialText;
    }
}
