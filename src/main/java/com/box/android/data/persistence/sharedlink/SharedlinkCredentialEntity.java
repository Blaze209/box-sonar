package com.box.android.data.persistence.sharedlink;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedlinkCredentialEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/persistence/sharedlink/SharedlinkCredentialEntity;", "", "fileId", "", "url", "password", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFileId", "()Ljava/lang/String;", "getUrl", "getPassword", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SharedlinkCredentialEntity {
    private final String fileId;
    private final String password;
    private final String url;

    public static /* synthetic */ SharedlinkCredentialEntity copy$default(SharedlinkCredentialEntity sharedlinkCredentialEntity, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sharedlinkCredentialEntity.fileId;
        }
        if ((i & 2) != 0) {
            str2 = sharedlinkCredentialEntity.url;
        }
        if ((i & 4) != 0) {
            str3 = sharedlinkCredentialEntity.password;
        }
        return sharedlinkCredentialEntity.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPassword() {
        return this.password;
    }

    public final SharedlinkCredentialEntity copy(String fileId, String url, String password) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(url, "url");
        return new SharedlinkCredentialEntity(fileId, url, password);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SharedlinkCredentialEntity)) {
            return false;
        }
        SharedlinkCredentialEntity sharedlinkCredentialEntity = (SharedlinkCredentialEntity) other;
        return Intrinsics.areEqual(this.fileId, sharedlinkCredentialEntity.fileId) && Intrinsics.areEqual(this.url, sharedlinkCredentialEntity.url) && Intrinsics.areEqual(this.password, sharedlinkCredentialEntity.password);
    }

    public int hashCode() {
        int iHashCode = ((this.fileId.hashCode() * 31) + this.url.hashCode()) * 31;
        String str = this.password;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SharedlinkCredentialEntity(fileId=" + this.fileId + ", url=" + this.url + ", password=" + this.password + ")";
    }

    public SharedlinkCredentialEntity(String fileId, String url, String str) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(url, "url");
        this.fileId = fileId;
        this.url = url;
        this.password = str;
    }

    public final String getFileId() {
        return this.fileId;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getPassword() {
        return this.password;
    }
}
