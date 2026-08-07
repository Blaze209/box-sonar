package com.margelo.nitro.boxcontext;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PickerConfig.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/margelo/nitro/boxcontext/PickerConfig;", "", "uploadFolder", "", "limits", "Lcom/margelo/nitro/boxcontext/PickerLimits;", "<init>", "(Ljava/lang/String;Lcom/margelo/nitro/boxcontext/PickerLimits;)V", "getUploadFolder", "()Ljava/lang/String;", "getLimits", "()Lcom/margelo/nitro/boxcontext/PickerLimits;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "Companion", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class PickerConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PickerLimits limits;
    private final String uploadFolder;

    public static /* synthetic */ PickerConfig copy$default(PickerConfig pickerConfig, String str, PickerLimits pickerLimits, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pickerConfig.uploadFolder;
        }
        if ((i & 2) != 0) {
            pickerLimits = pickerConfig.limits;
        }
        return pickerConfig.copy(str, pickerLimits);
    }

    @JvmStatic
    private static final PickerConfig fromCpp(String str, PickerLimits pickerLimits) {
        return INSTANCE.fromCpp(str, pickerLimits);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUploadFolder() {
        return this.uploadFolder;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PickerLimits getLimits() {
        return this.limits;
    }

    public final PickerConfig copy(String uploadFolder, PickerLimits limits) {
        Intrinsics.checkNotNullParameter(uploadFolder, "uploadFolder");
        Intrinsics.checkNotNullParameter(limits, "limits");
        return new PickerConfig(uploadFolder, limits);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PickerConfig)) {
            return false;
        }
        PickerConfig pickerConfig = (PickerConfig) other;
        return Intrinsics.areEqual(this.uploadFolder, pickerConfig.uploadFolder) && Intrinsics.areEqual(this.limits, pickerConfig.limits);
    }

    public int hashCode() {
        return (this.uploadFolder.hashCode() * 31) + this.limits.hashCode();
    }

    public String toString() {
        return "PickerConfig(uploadFolder=" + this.uploadFolder + ", limits=" + this.limits + ")";
    }

    public PickerConfig(String uploadFolder, PickerLimits limits) {
        Intrinsics.checkNotNullParameter(uploadFolder, "uploadFolder");
        Intrinsics.checkNotNullParameter(limits, "limits");
        this.uploadFolder = uploadFolder;
        this.limits = limits;
    }

    public final String getUploadFolder() {
        return this.uploadFolder;
    }

    public final PickerLimits getLimits() {
        return this.limits;
    }

    /* JADX INFO: compiled from: PickerConfig.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0003¨\u0006\n"}, d2 = {"Lcom/margelo/nitro/boxcontext/PickerConfig$Companion;", "", "<init>", "()V", "fromCpp", "Lcom/margelo/nitro/boxcontext/PickerConfig;", "uploadFolder", "", "limits", "Lcom/margelo/nitro/boxcontext/PickerLimits;", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final PickerConfig fromCpp(String uploadFolder, PickerLimits limits) {
            return new PickerConfig(uploadFolder, limits);
        }
    }
}
