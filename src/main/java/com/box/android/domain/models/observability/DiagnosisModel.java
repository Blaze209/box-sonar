package com.box.android.domain.models.observability;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.observability.DiagnosisParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DiagnosisModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001eB;\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0018\u001a\u00020\u0007J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/box/android/domain/models/observability/DiagnosisModel;", "Landroid/os/Parcelable;", "source", "", DiagnosisParams.DIAGNOSIS_MODE, "Lcom/box/android/domain/models/observability/DiagnosisMode;", "durationInHours", "", "shouldUploadAtCompletion", "", "shouldClearLogsOnLogout", "tag", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/observability/DiagnosisMode;IZZLjava/lang/String;)V", "getSource", "()Ljava/lang/String;", "getMode", "()Lcom/box/android/domain/models/observability/DiagnosisMode;", "getDurationInHours", "()I", "getShouldUploadAtCompletion", "()Z", "getShouldClearLogsOnLogout", "getTag", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Builder", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DiagnosisModel implements Parcelable {
    public static final Parcelable.Creator<DiagnosisModel> CREATOR = new Creator();
    private final int durationInHours;
    private final DiagnosisMode mode;
    private final boolean shouldClearLogsOnLogout;
    private final boolean shouldUploadAtCompletion;
    private final String source;
    private final String tag;

    /* JADX INFO: compiled from: DiagnosisModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DiagnosisModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DiagnosisModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            DiagnosisMode diagnosisModeValueOf = DiagnosisMode.valueOf(parcel.readString());
            int i = parcel.readInt();
            boolean z = true;
            if (parcel.readInt() == 0) {
                z = false;
            }
            return new DiagnosisModel(string, diagnosisModeValueOf, i, z, parcel.readInt() != 0, parcel.readString(), null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DiagnosisModel[] newArray(int i) {
            return new DiagnosisModel[i];
        }
    }

    public /* synthetic */ DiagnosisModel(String str, DiagnosisMode diagnosisMode, int i, boolean z, boolean z2, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, diagnosisMode, i, z, z2, str2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.source);
        dest.writeString(this.mode.name());
        dest.writeInt(this.durationInHours);
        dest.writeInt(this.shouldUploadAtCompletion ? 1 : 0);
        dest.writeInt(this.shouldClearLogsOnLogout ? 1 : 0);
        dest.writeString(this.tag);
    }

    private DiagnosisModel(String str, DiagnosisMode diagnosisMode, int i, boolean z, boolean z2, String str2) {
        this.source = str;
        this.mode = diagnosisMode;
        this.durationInHours = i;
        this.shouldUploadAtCompletion = z;
        this.shouldClearLogsOnLogout = z2;
        this.tag = str2;
    }

    public final String getSource() {
        return this.source;
    }

    public final DiagnosisMode getMode() {
        return this.mode;
    }

    public final int getDurationInHours() {
        return this.durationInHours;
    }

    public final boolean getShouldUploadAtCompletion() {
        return this.shouldUploadAtCompletion;
    }

    public final boolean getShouldClearLogsOnLogout() {
        return this.shouldClearLogsOnLogout;
    }

    public final String getTag() {
        return this.tag;
    }

    /* JADX INFO: compiled from: DiagnosisModel.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0003J\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/box/android/domain/models/observability/DiagnosisModel$Builder;", "", "source", "", "<init>", "(Ljava/lang/String;)V", DiagnosisParams.DIAGNOSIS_MODE, "Lcom/box/android/domain/models/observability/DiagnosisMode;", "durationInHours", "", "shouldUploadAtCompletion", "", "shouldClearLogsOnLogout", "tag", "duration", "shouldUpload", "shouldClearLogs", "build", "Lcom/box/android/domain/models/observability/DiagnosisModel;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        private int durationInHours;
        private DiagnosisMode mode;
        private boolean shouldClearLogsOnLogout;
        private boolean shouldUploadAtCompletion;
        private final String source;
        private String tag;

        public Builder(String source) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
            this.mode = DiagnosisMode.INFO;
            this.durationInHours = 12;
            this.shouldUploadAtCompletion = true;
            this.shouldClearLogsOnLogout = true;
        }

        public final Builder mode(DiagnosisMode mode) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            this.mode = mode;
            return this;
        }

        public final Builder duration(int durationInHours) {
            this.durationInHours = durationInHours;
            return this;
        }

        public final Builder shouldUpload(boolean shouldUploadAtCompletion) {
            this.shouldUploadAtCompletion = shouldUploadAtCompletion;
            return this;
        }

        public final Builder shouldClearLogs(boolean shouldClearLogsOnLogout) {
            this.shouldClearLogsOnLogout = shouldClearLogsOnLogout;
            return this;
        }

        public final Builder tag(String tag) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.tag = tag;
            return this;
        }

        public final DiagnosisModel build() {
            return new DiagnosisModel(this.source, this.mode, this.durationInHours, this.shouldUploadAtCompletion, this.shouldClearLogsOnLogout, this.tag, null);
        }
    }
}
