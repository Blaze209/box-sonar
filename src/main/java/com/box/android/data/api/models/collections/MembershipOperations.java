package com.box.android.data.api.models.collections;

import com.box.androidsdk.content.requests.BoxRequestsMetadata;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: MembershipOperationsDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/data/api/models/collections/MembershipOperations;", "", BoxRequestsMetadata.UpdateItemMetadata.BoxMetadataUpdateTask.OPERATION, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getOp", "()Ljava/lang/String;", "ADD", "REMOVE", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum MembershipOperations {
    ADD("add"),
    REMOVE("remove");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String op;

    public static EnumEntries<MembershipOperations> getEntries() {
        return $ENTRIES;
    }

    MembershipOperations(String str) {
        this.op = str;
    }

    public final String getOp() {
        return this.op;
    }
}
