package com.box.android.data.api.models.auth;

import com.box.androidsdk.content.models.BoxEvent;
import com.box.boxandroidlibv2private.model.BoxRecentBoxFile;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: ScopeDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/api/models/auth/Scope;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ANNOTATION_EDIT", "ANNOTATION_VIEW_ALL", "ANNOTATION_VIEW_SELF", "BASE_EXPLORER", "BASE_PICKER", "BASE_PREVIEW", "BASE_UPLOAD", "ITEM_DELETE", BoxEvent.EVENT_TYPE_ITEM_DOWNLOAD, BoxEvent.EVENT_TYPE_ITEM_PREVIEW, BoxEvent.EVENT_TYPE_ITEM_RENAME, "ITEM_SHARE", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum Scope {
    ANNOTATION_EDIT("annotation_edit"),
    ANNOTATION_VIEW_ALL("annotation_view_all"),
    ANNOTATION_VIEW_SELF("annotation_view_self"),
    BASE_EXPLORER("base_explorer"),
    BASE_PICKER("base_picker"),
    BASE_PREVIEW("base_preview"),
    BASE_UPLOAD("base_upload"),
    ITEM_DELETE("item_delete"),
    ITEM_DOWNLOAD("item_download"),
    ITEM_PREVIEW(BoxRecentBoxFile.RECENT_INTERACTION_TYPE_PREVIEW),
    ITEM_RENAME("item_rename"),
    ITEM_SHARE("item_share");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    public static EnumEntries<Scope> getEntries() {
        return $ENTRIES;
    }

    Scope(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
