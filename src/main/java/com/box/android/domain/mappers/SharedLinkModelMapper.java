package com.box.android.domain.mappers;

import com.box.android.domain.models.item.SharedLinkAccessModel;
import com.box.android.domain.models.item.SharedLinkEffectivePermissionModel;
import com.box.android.domain.models.item.SharedLinkModel;
import com.box.androidsdk.content.models.BoxSharedLink;
import com.box.androidsdk.content.utils.BoxDateFormat;
import com.eclipsesource.json.JsonObject;
import java.util.Date;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedLinkModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006J\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0005H\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/domain/mappers/SharedLinkModelMapper;", "", "<init>", "()V", "toSharedLinkModel", "Lcom/box/android/domain/models/item/SharedLinkModel;", "Lcom/box/androidsdk/content/models/BoxSharedLink;", "toBoxSharedLink", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SharedLinkModelMapper {
    public static final SharedLinkModelMapper INSTANCE = new SharedLinkModelMapper();

    private SharedLinkModelMapper() {
    }

    public final SharedLinkModel toSharedLinkModel(BoxSharedLink boxSharedLink) {
        Intrinsics.checkNotNullParameter(boxSharedLink, "<this>");
        String url = boxSharedLink.getURL();
        Intrinsics.checkNotNullExpressionValue(url, "getURL(...)");
        SharedLinkAccessModel sharedLinkAccessModelFromString = SharedLinkAccessModel.INSTANCE.fromString(boxSharedLink.getEffectiveAccess().toString());
        SharedLinkEffectivePermissionModel sharedLinkEffectivePermissionModelFromString = SharedLinkEffectivePermissionModel.INSTANCE.fromString(boxSharedLink.getEffectivePermission().toString());
        Boolean isPasswordEnabled = boxSharedLink.getIsPasswordEnabled();
        Intrinsics.checkNotNullExpressionValue(isPasswordEnabled, "getIsPasswordEnabled(...)");
        boolean zBooleanValue = isPasswordEnabled.booleanValue();
        Date unsharedDate = boxSharedLink.getUnsharedDate();
        Boolean canDownload = boxSharedLink.getPermissions().getCanDownload();
        Intrinsics.checkNotNullExpressionValue(canDownload, "getCanDownload(...)");
        return new SharedLinkModel(url, sharedLinkAccessModelFromString, sharedLinkEffectivePermissionModelFromString, zBooleanValue, unsharedDate, canDownload.booleanValue());
    }

    @Deprecated(message = "Refactor legacy code to use SharedLinkModel instead")
    public final BoxSharedLink toBoxSharedLink(SharedLinkModel sharedLinkModel) {
        Intrinsics.checkNotNullParameter(sharedLinkModel, "<this>");
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("url", sharedLinkModel.getUrl());
        jsonObject.add(BoxSharedLink.FIELD_EFFECTIVE_ACCESS, sharedLinkModel.getEffectiveAccess().getValue());
        jsonObject.add(BoxSharedLink.FIELD_EFFECTIVE_PERMISSION, sharedLinkModel.getEffectivePermission().toString());
        jsonObject.add(BoxSharedLink.FIELD_IS_PASSWORD_ENABLED, sharedLinkModel.isPasswordEnabled());
        Date unsharedAt = sharedLinkModel.getUnsharedAt();
        if (unsharedAt != null) {
            jsonObject.add(BoxSharedLink.FIELD_UNSHARED_AT, BoxDateFormat.format(unsharedAt));
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.add(BoxSharedLink.Permissions.FIELD_CAN_DOWNLOAD, sharedLinkModel.getCanDownload());
        jsonObject.add("permissions", jsonObject2);
        return new BoxSharedLink(jsonObject);
    }
}
