package com.geniusscansdk.readablecodeflow;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.geniusscansdk.structureddata.ReadableCode;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReadableCodeConfiguration.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0003\u0010\u0007\u001a\u00020\b\u0012\b\b\u0003\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\bHÆ\u0001J\u0006\u0010\u0017\u001a\u00020\bJ\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006#"}, d2 = {"Lcom/geniusscansdk/readablecodeflow/ReadableCodeConfiguration;", "Landroid/os/Parcelable;", "isBatchModeEnabled", "", "supportedCodeTypes", "", "Lcom/geniusscansdk/structureddata/ReadableCode$Type;", "highlightColor", "", "menuColor", "<init>", "(ZLjava/util/Set;II)V", "()Z", "getSupportedCodeTypes", "()Ljava/util/Set;", "getHighlightColor", "()I", "getMenuColor", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ReadableCodeConfiguration implements Parcelable {
    public static final Parcelable.Creator<ReadableCodeConfiguration> CREATOR = new Creator();
    private final int highlightColor;
    private final boolean isBatchModeEnabled;
    private final int menuColor;
    private final Set<ReadableCode.Type> supportedCodeTypes;

    /* JADX INFO: compiled from: ReadableCodeConfiguration.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ReadableCodeConfiguration> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ReadableCodeConfiguration createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            boolean z = parcel.readInt() != 0;
            int i = parcel.readInt();
            LinkedHashSet linkedHashSet = new LinkedHashSet(i);
            for (int i2 = 0; i2 != i; i2++) {
                linkedHashSet.add(ReadableCode.Type.valueOf(parcel.readString()));
            }
            return new ReadableCodeConfiguration(z, linkedHashSet, parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ReadableCodeConfiguration[] newArray(int i) {
            return new ReadableCodeConfiguration[i];
        }
    }

    public ReadableCodeConfiguration() {
        this(false, null, 0, 0, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReadableCodeConfiguration copy$default(ReadableCodeConfiguration readableCodeConfiguration, boolean z, Set set, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = readableCodeConfiguration.isBatchModeEnabled;
        }
        if ((i3 & 2) != 0) {
            set = readableCodeConfiguration.supportedCodeTypes;
        }
        if ((i3 & 4) != 0) {
            i = readableCodeConfiguration.highlightColor;
        }
        if ((i3 & 8) != 0) {
            i2 = readableCodeConfiguration.menuColor;
        }
        return readableCodeConfiguration.copy(z, set, i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsBatchModeEnabled() {
        return this.isBatchModeEnabled;
    }

    public final Set<ReadableCode.Type> component2() {
        return this.supportedCodeTypes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getHighlightColor() {
        return this.highlightColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getMenuColor() {
        return this.menuColor;
    }

    public final ReadableCodeConfiguration copy(boolean isBatchModeEnabled, Set<? extends ReadableCode.Type> supportedCodeTypes, int highlightColor, int menuColor) {
        Intrinsics.checkNotNullParameter(supportedCodeTypes, "supportedCodeTypes");
        return new ReadableCodeConfiguration(isBatchModeEnabled, supportedCodeTypes, highlightColor, menuColor);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReadableCodeConfiguration)) {
            return false;
        }
        ReadableCodeConfiguration readableCodeConfiguration = (ReadableCodeConfiguration) other;
        return this.isBatchModeEnabled == readableCodeConfiguration.isBatchModeEnabled && Intrinsics.areEqual(this.supportedCodeTypes, readableCodeConfiguration.supportedCodeTypes) && this.highlightColor == readableCodeConfiguration.highlightColor && this.menuColor == readableCodeConfiguration.menuColor;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.isBatchModeEnabled) * 31) + this.supportedCodeTypes.hashCode()) * 31) + Integer.hashCode(this.highlightColor)) * 31) + Integer.hashCode(this.menuColor);
    }

    public String toString() {
        return "ReadableCodeConfiguration(isBatchModeEnabled=" + this.isBatchModeEnabled + ", supportedCodeTypes=" + this.supportedCodeTypes + ", highlightColor=" + this.highlightColor + ", menuColor=" + this.menuColor + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.isBatchModeEnabled ? 1 : 0);
        Set<ReadableCode.Type> set = this.supportedCodeTypes;
        dest.writeInt(set.size());
        Iterator<ReadableCode.Type> it = set.iterator();
        while (it.hasNext()) {
            dest.writeString(it.next().name());
        }
        dest.writeInt(this.highlightColor);
        dest.writeInt(this.menuColor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ReadableCodeConfiguration(boolean z, Set<? extends ReadableCode.Type> supportedCodeTypes, int i, int i2) {
        Intrinsics.checkNotNullParameter(supportedCodeTypes, "supportedCodeTypes");
        this.isBatchModeEnabled = z;
        this.supportedCodeTypes = supportedCodeTypes;
        this.highlightColor = i;
        this.menuColor = i2;
    }

    public final boolean isBatchModeEnabled() {
        return this.isBatchModeEnabled;
    }

    public /* synthetic */ ReadableCodeConfiguration(boolean z, EnumSet enumSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? EnumSet.allOf(ReadableCode.Type.class) : enumSet, (i3 & 4) != 0 ? -16711936 : i, (i3 & 8) != 0 ? -16777216 : i2);
    }

    public final Set<ReadableCode.Type> getSupportedCodeTypes() {
        return this.supportedCodeTypes;
    }

    public final int getHighlightColor() {
        return this.highlightColor;
    }

    public final int getMenuColor() {
        return this.menuColor;
    }
}
