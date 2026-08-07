package com.box.android.data.persistence.representations;

import com.box.android.domain.models.ItemId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RepresentationsItemEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/box/android/data/persistence/representations/RepresentationsItemEntity;", "", "fileId", "Lcom/box/android/domain/models/ItemId$Remote;", "sha1", "", "responseJson", "<init>", "(Lcom/box/android/domain/models/ItemId$Remote;Ljava/lang/String;Ljava/lang/String;)V", "getFileId", "()Lcom/box/android/domain/models/ItemId$Remote;", "getSha1", "()Ljava/lang/String;", "getResponseJson", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RepresentationsItemEntity {
    private final ItemId.Remote fileId;
    private final String responseJson;
    private final String sha1;

    public RepresentationsItemEntity(ItemId.Remote fileId, String sha1, String responseJson) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(sha1, "sha1");
        Intrinsics.checkNotNullParameter(responseJson, "responseJson");
        this.fileId = fileId;
        this.sha1 = sha1;
        this.responseJson = responseJson;
    }

    public final ItemId.Remote getFileId() {
        return this.fileId;
    }

    public final String getSha1() {
        return this.sha1;
    }

    public final String getResponseJson() {
        return this.responseJson;
    }
}
