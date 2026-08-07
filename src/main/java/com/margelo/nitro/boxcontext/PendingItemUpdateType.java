package com.margelo.nitro.boxcontext;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: PendingItemUpdateType.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0087\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/margelo/nitro/boxcontext/PendingItemUpdateType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "PROGRESS", "COMPLETED", "FAILED", "CANCELED", "Companion", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum PendingItemUpdateType {
    PROGRESS(0),
    COMPLETED(1),
    FAILED(2),
    CANCELED(3);

    private final int value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<PendingItemUpdateType> getEntries() {
        return $ENTRIES;
    }

    PendingItemUpdateType(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
