package com.box.android.data.mappers;

import com.box.android.data.GetCollectionItemsQuery;
import com.box.android.data.GetItemQuery;
import com.box.android.data.GetItemWithWatermarkDataQuery;
import com.box.android.data.fragment.FileFields;
import com.box.android.data.fragment.FolderFields;
import com.box.android.data.fragment.WeblinkFields;
import com.box.android.domain.models.item.SharedLinkAccessModel;
import com.box.android.domain.models.item.SharedLinkEffectivePermissionModel;
import com.box.android.domain.models.item.SharedLinkModel;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import java.util.Date;
import kotlin.Metadata;

/* JADX INFO: compiled from: GQLSharedLinkFragmentToSharedLinkModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JI\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010 J\u0012\u0010!\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\"J\u0012\u0010#\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010$J\u0012\u0010%\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010&¨\u0006'"}, d2 = {"Lcom/box/android/data/mappers/GQLSharedLinkFragmentToSharedLinkModelMapper;", "", "<init>", "()V", "toModelOrNull", "Lcom/box/android/domain/models/item/SharedLinkModel;", "url", "", "effectiveAccess", "effectivePermission", "isPasswordEnabled", "", "unsharedAt", "Ljava/util/Date;", "canDownload", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Date;Ljava/lang/Boolean;)Lcom/box/android/domain/models/item/SharedLinkModel;", "fromGetItemQueryFile", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "Lcom/box/android/data/GetItemQuery$SharedLink;", "fromGetItemQueryFolder", "Lcom/box/android/data/GetItemQuery$SharedLink1;", "fromGetItemQueryWeblink", "Lcom/box/android/data/GetItemQuery$SharedLink2;", "fromGetItemWithWatermarkDataQueryFile", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$SharedLink;", "fromGetItemWithWatermarkDataQueryFolder", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$SharedLink1;", "fromGetCollectionItemsFile", "Lcom/box/android/data/GetCollectionItemsQuery$SharedLink;", "fromGetCollectionItemsFolder", "Lcom/box/android/data/GetCollectionItemsQuery$SharedLink1;", "fromGetCollectionItemsWeblink", "Lcom/box/android/data/GetCollectionItemsQuery$SharedLink2;", "fromFileFields", "Lcom/box/android/data/fragment/FileFields$SharedLink;", "fromFolderFields", "Lcom/box/android/data/fragment/FolderFields$SharedLink;", "fromWeblinkFields", "Lcom/box/android/data/fragment/WeblinkFields$SharedLink;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLSharedLinkFragmentToSharedLinkModelMapper {
    public static final GQLSharedLinkFragmentToSharedLinkModelMapper INSTANCE = new GQLSharedLinkFragmentToSharedLinkModelMapper();

    private GQLSharedLinkFragmentToSharedLinkModelMapper() {
    }

    public final SharedLinkModel toModelOrNull(String url, String effectiveAccess, String effectivePermission, Boolean isPasswordEnabled, Date unsharedAt, Boolean canDownload) {
        if (url != null) {
            return new SharedLinkModel(url, SharedLinkAccessModel.INSTANCE.fromString(effectiveAccess), SharedLinkEffectivePermissionModel.INSTANCE.fromString(effectivePermission), isPasswordEnabled != null ? isPasswordEnabled.booleanValue() : false, unsharedAt, canDownload != null ? canDownload.booleanValue() : false);
        }
        return null;
    }

    public final SharedLinkModel fromGetItemQueryFile(GetItemQuery.SharedLink sharedLink) {
        return toModelOrNull(sharedLink != null ? sharedLink.getUrl() : null, sharedLink != null ? sharedLink.getEffectiveAccess() : null, sharedLink != null ? sharedLink.getEffectivePermission() : null, sharedLink != null ? sharedLink.isPasswordEnabled() : null, sharedLink != null ? sharedLink.getUnsharedAt() : null, sharedLink != null ? sharedLink.getCanDownload() : null);
    }

    public final SharedLinkModel fromGetItemQueryFolder(GetItemQuery.SharedLink1 sharedLink) {
        return toModelOrNull(sharedLink != null ? sharedLink.getUrl() : null, sharedLink != null ? sharedLink.getEffectiveAccess() : null, sharedLink != null ? sharedLink.getEffectivePermission() : null, sharedLink != null ? sharedLink.isPasswordEnabled() : null, sharedLink != null ? sharedLink.getUnsharedAt() : null, sharedLink != null ? sharedLink.getCanDownload() : null);
    }

    public final SharedLinkModel fromGetItemQueryWeblink(GetItemQuery.SharedLink2 sharedLink) {
        return toModelOrNull(sharedLink != null ? sharedLink.getUrl() : null, sharedLink != null ? sharedLink.getEffectiveAccess() : null, sharedLink != null ? sharedLink.getEffectivePermission() : null, sharedLink != null ? sharedLink.isPasswordEnabled() : null, sharedLink != null ? sharedLink.getUnsharedAt() : null, sharedLink != null ? sharedLink.getCanDownload() : null);
    }

    public final SharedLinkModel fromGetItemWithWatermarkDataQueryFile(GetItemWithWatermarkDataQuery.SharedLink sharedLink) {
        return toModelOrNull(sharedLink != null ? sharedLink.getUrl() : null, sharedLink != null ? sharedLink.getEffectiveAccess() : null, sharedLink != null ? sharedLink.getEffectivePermission() : null, sharedLink != null ? sharedLink.isPasswordEnabled() : null, sharedLink != null ? sharedLink.getUnsharedAt() : null, sharedLink != null ? sharedLink.getCanDownload() : null);
    }

    public final SharedLinkModel fromGetItemWithWatermarkDataQueryFolder(GetItemWithWatermarkDataQuery.SharedLink1 sharedLink) {
        return toModelOrNull(sharedLink != null ? sharedLink.getUrl() : null, sharedLink != null ? sharedLink.getEffectiveAccess() : null, sharedLink != null ? sharedLink.getEffectivePermission() : null, sharedLink != null ? sharedLink.isPasswordEnabled() : null, sharedLink != null ? sharedLink.getUnsharedAt() : null, sharedLink != null ? sharedLink.getCanDownload() : null);
    }

    public final SharedLinkModel fromGetCollectionItemsFile(GetCollectionItemsQuery.SharedLink sharedLink) {
        return toModelOrNull(sharedLink != null ? sharedLink.getUrl() : null, sharedLink != null ? sharedLink.getEffectiveAccess() : null, sharedLink != null ? sharedLink.getEffectivePermission() : null, sharedLink != null ? sharedLink.isPasswordEnabled() : null, sharedLink != null ? sharedLink.getUnsharedAt() : null, sharedLink != null ? sharedLink.getCanDownload() : null);
    }

    public final SharedLinkModel fromGetCollectionItemsFolder(GetCollectionItemsQuery.SharedLink1 sharedLink) {
        return toModelOrNull(sharedLink != null ? sharedLink.getUrl() : null, sharedLink != null ? sharedLink.getEffectiveAccess() : null, sharedLink != null ? sharedLink.getEffectivePermission() : null, sharedLink != null ? sharedLink.isPasswordEnabled() : null, sharedLink != null ? sharedLink.getUnsharedAt() : null, sharedLink != null ? sharedLink.getCanDownload() : null);
    }

    public final SharedLinkModel fromGetCollectionItemsWeblink(GetCollectionItemsQuery.SharedLink2 sharedLink) {
        return toModelOrNull(sharedLink != null ? sharedLink.getUrl() : null, sharedLink != null ? sharedLink.getEffectiveAccess() : null, sharedLink != null ? sharedLink.getEffectivePermission() : null, sharedLink != null ? sharedLink.isPasswordEnabled() : null, sharedLink != null ? sharedLink.getUnsharedAt() : null, sharedLink != null ? sharedLink.getCanDownload() : null);
    }

    public final SharedLinkModel fromFileFields(FileFields.SharedLink sharedLink) {
        return toModelOrNull(sharedLink != null ? sharedLink.getUrl() : null, sharedLink != null ? sharedLink.getEffectiveAccess() : null, sharedLink != null ? sharedLink.getEffectivePermission() : null, sharedLink != null ? sharedLink.isPasswordEnabled() : null, sharedLink != null ? sharedLink.getUnsharedAt() : null, sharedLink != null ? sharedLink.getCanDownload() : null);
    }

    public final SharedLinkModel fromFolderFields(FolderFields.SharedLink sharedLink) {
        return toModelOrNull(sharedLink != null ? sharedLink.getUrl() : null, sharedLink != null ? sharedLink.getEffectiveAccess() : null, sharedLink != null ? sharedLink.getEffectivePermission() : null, sharedLink != null ? sharedLink.isPasswordEnabled() : null, sharedLink != null ? sharedLink.getUnsharedAt() : null, sharedLink != null ? sharedLink.getCanDownload() : null);
    }

    public final SharedLinkModel fromWeblinkFields(WeblinkFields.SharedLink sharedLink) {
        return toModelOrNull(sharedLink != null ? sharedLink.getUrl() : null, sharedLink != null ? sharedLink.getEffectiveAccess() : null, sharedLink != null ? sharedLink.getEffectivePermission() : null, sharedLink != null ? sharedLink.isPasswordEnabled() : null, sharedLink != null ? sharedLink.getUnsharedAt() : null, sharedLink != null ? sharedLink.getCanDownload() : null);
    }
}
