package com.box.android.data.mappers;

import com.box.android.data.api.models.SharedLinkDTO;
import com.box.android.data.api.models.SharedLinkPermissionsDTO;
import com.box.android.domain.models.item.SharedLinkAccessModel;
import com.box.android.domain.models.item.SharedLinkEffectivePermissionModel;
import com.box.android.domain.models.item.SharedLinkModel;
import com.box.androidsdk.content.utils.BoxDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedLinkDTOtoSharedLinkModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\f\u0010\t\u001a\u0004\u0018\u00010\u0005*\u00020\u0007¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/SharedLinkDTOtoSharedLinkModelMapper;", "", "<init>", "()V", "toSharedLinkModelOrNull", "Lcom/box/android/domain/models/item/SharedLinkModel;", "dto", "Lcom/box/android/data/api/models/SharedLinkDTO;", "mapDtoToDomain", "toDomain", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SharedLinkDTOtoSharedLinkModelMapper {
    public static final SharedLinkDTOtoSharedLinkModelMapper INSTANCE = new SharedLinkDTOtoSharedLinkModelMapper();

    private SharedLinkDTOtoSharedLinkModelMapper() {
    }

    public final SharedLinkModel toSharedLinkModelOrNull(SharedLinkDTO dto) {
        if (dto != null) {
            return INSTANCE.mapDtoToDomain(dto);
        }
        return null;
    }

    private final SharedLinkModel mapDtoToDomain(SharedLinkDTO dto) {
        Boolean canDownload;
        String url = dto.getUrl();
        if (url == null) {
            return null;
        }
        SharedLinkAccessModel sharedLinkAccessModelFromString = SharedLinkAccessModel.INSTANCE.fromString(dto.getEffectiveAccess());
        SharedLinkEffectivePermissionModel sharedLinkEffectivePermissionModelFromString = SharedLinkEffectivePermissionModel.INSTANCE.fromString(dto.getEffectivePermission());
        Boolean boolIsPasswordEnabled = dto.isPasswordEnabled();
        boolean zBooleanValue = false;
        boolean zBooleanValue2 = boolIsPasswordEnabled != null ? boolIsPasswordEnabled.booleanValue() : false;
        String unsharedAt = dto.getUnsharedAt();
        Date date = unsharedAt != null ? BoxDateFormat.parse(unsharedAt) : null;
        SharedLinkPermissionsDTO permissions = dto.getPermissions();
        if (permissions != null && (canDownload = permissions.getCanDownload()) != null) {
            zBooleanValue = canDownload.booleanValue();
        }
        return new SharedLinkModel(url, sharedLinkAccessModelFromString, sharedLinkEffectivePermissionModelFromString, zBooleanValue2, date, zBooleanValue);
    }

    public final SharedLinkModel toDomain(SharedLinkDTO sharedLinkDTO) {
        Intrinsics.checkNotNullParameter(sharedLinkDTO, "<this>");
        return toSharedLinkModelOrNull(sharedLinkDTO);
    }
}
