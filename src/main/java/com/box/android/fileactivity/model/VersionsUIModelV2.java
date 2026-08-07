package com.box.android.fileactivity.model;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.annotations.FileActivityIdModel;
import com.box.android.domain.models.annotations.FileActivityType;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivityUIModelsV2.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/fileactivity/model/VersionsUIModelV2;", "Lcom/box/android/fileactivity/model/FileActivityUIModelV2;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class VersionsUIModelV2 extends FileActivityUIModelV2 {
    public static final int $stable = 8;
    private final String message;

    public static /* synthetic */ VersionsUIModelV2 copy$default(VersionsUIModelV2 versionsUIModelV2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = versionsUIModelV2.message;
        }
        return versionsUIModelV2.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final VersionsUIModelV2 copy(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return new VersionsUIModelV2(message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof VersionsUIModelV2) && Intrinsics.areEqual(this.message, ((VersionsUIModelV2) other).message);
    }

    public int hashCode() {
        return this.message.hashCode();
    }

    public String toString() {
        return "VersionsUIModelV2(message=" + this.message + ")";
    }

    public final String getMessage() {
        return this.message;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public VersionsUIModelV2(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        super(new FileActivityIdModel(string, FileActivityType.VERSIONS), null);
        this.message = message;
    }
}
