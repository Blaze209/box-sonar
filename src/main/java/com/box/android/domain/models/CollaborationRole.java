package com.box.android.domain.models;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: CollaborationModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/box/android/domain/models/CollaborationRole;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "OWNER", "CO_OWNER", "EDITOR", "VIEWER_UPLOADER", "PREVIEWER_UPLOADER", "VIEWER", "PREVIEWER", "UPLOADER", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum CollaborationRole {
    OWNER("owner"),
    CO_OWNER("co-owner"),
    EDITOR("editor"),
    VIEWER_UPLOADER("viewer uploader"),
    PREVIEWER_UPLOADER("previewer uploader"),
    VIEWER("viewer"),
    PREVIEWER("previewer"),
    UPLOADER("uploader");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    public static EnumEntries<CollaborationRole> getEntries() {
        return $ENTRIES;
    }

    CollaborationRole(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
