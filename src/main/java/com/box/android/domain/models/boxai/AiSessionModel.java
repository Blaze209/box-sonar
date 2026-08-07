package com.box.android.domain.models.boxai;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AiSessionModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/box/android/domain/models/boxai/AiSessionModel;", "Lcom/box/android/domain/models/DomainModel;", "isLargeFile", "", "encodedSession", "", "<init>", "(ZLjava/lang/String;)V", "()Z", "getEncodedSession", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AiSessionModel implements DomainModel {
    private final String encodedSession;
    private final boolean isLargeFile;

    public static /* synthetic */ AiSessionModel copy$default(AiSessionModel aiSessionModel, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = aiSessionModel.isLargeFile;
        }
        if ((i & 2) != 0) {
            str = aiSessionModel.encodedSession;
        }
        return aiSessionModel.copy(z, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsLargeFile() {
        return this.isLargeFile;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEncodedSession() {
        return this.encodedSession;
    }

    public final AiSessionModel copy(boolean isLargeFile, String encodedSession) {
        Intrinsics.checkNotNullParameter(encodedSession, "encodedSession");
        return new AiSessionModel(isLargeFile, encodedSession);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AiSessionModel)) {
            return false;
        }
        AiSessionModel aiSessionModel = (AiSessionModel) other;
        return this.isLargeFile == aiSessionModel.isLargeFile && Intrinsics.areEqual(this.encodedSession, aiSessionModel.encodedSession);
    }

    public int hashCode() {
        return (Boolean.hashCode(this.isLargeFile) * 31) + this.encodedSession.hashCode();
    }

    public String toString() {
        return "AiSessionModel(isLargeFile=" + this.isLargeFile + ", encodedSession=" + this.encodedSession + ")";
    }

    public AiSessionModel(boolean z, String encodedSession) {
        Intrinsics.checkNotNullParameter(encodedSession, "encodedSession");
        this.isLargeFile = z;
        this.encodedSession = encodedSession;
    }

    public final String getEncodedSession() {
        return this.encodedSession;
    }

    public final boolean isLargeFile() {
        return this.isLargeFile;
    }
}
