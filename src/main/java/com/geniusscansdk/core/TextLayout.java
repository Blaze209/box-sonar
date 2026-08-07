package com.geniusscansdk.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextLayout.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nJ\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\r\u001a\u00020\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/geniusscansdk/core/TextLayout;", "Landroid/os/Parcelable;", "hocr", "", "<init>", "(Ljava/lang/String;)V", "getHocr", "()Ljava/lang/String;", "toJNI", "Lcom/geniusscansdk/core/JNITextLayout;", "toJNI$gssdk_release", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class TextLayout implements Parcelable {
    public static final Parcelable.Creator<TextLayout> CREATOR = new Creator();
    private final String hocr;

    /* JADX INFO: compiled from: TextLayout.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TextLayout> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TextLayout createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TextLayout(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TextLayout[] newArray(int i) {
            return new TextLayout[i];
        }
    }

    public static /* synthetic */ TextLayout copy$default(TextLayout textLayout, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = textLayout.hocr;
        }
        return textLayout.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getHocr() {
        return this.hocr;
    }

    public final TextLayout copy(String hocr) {
        Intrinsics.checkNotNullParameter(hocr, "hocr");
        return new TextLayout(hocr);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TextLayout) && Intrinsics.areEqual(this.hocr, ((TextLayout) other).hocr);
    }

    public int hashCode() {
        return this.hocr.hashCode();
    }

    public String toString() {
        return "TextLayout(hocr=" + this.hocr + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.hocr);
    }

    public TextLayout(String hocr) {
        Intrinsics.checkNotNullParameter(hocr, "hocr");
        this.hocr = hocr;
    }

    public final String getHocr() {
        return this.hocr;
    }

    public final JNITextLayout toJNI$gssdk_release() {
        return new JNITextLayout(this.hocr);
    }
}
