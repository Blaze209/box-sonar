package com.box.android.domain.mappers;

import com.box.android.domain.models.item.FileLockModel;
import com.box.android.domain.models.item.UserModel;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.box.androidsdk.content.models.BoxLock;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.utils.BoxDateFormat;
import com.eclipsesource.json.JsonObject;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileLockModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006J\n\u0010\u0007\u001a\u00020\b*\u00020\u0005¨\u0006\t"}, d2 = {"Lcom/box/android/domain/mappers/FileLockModelMapper;", "", "<init>", "()V", "toFileLockModel", "Lcom/box/android/domain/models/item/FileLockModel;", "Lcom/box/androidsdk/content/models/BoxLock;", "toJsonObject", "Lcom/eclipsesource/json/JsonObject;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileLockModelMapper {
    public static final FileLockModelMapper INSTANCE = new FileLockModelMapper();

    private FileLockModelMapper() {
    }

    public final FileLockModel toFileLockModel(BoxLock boxLock) {
        Intrinsics.checkNotNullParameter(boxLock, "<this>");
        return new FileLockModel(boxLock.getId(), boxLock.getAppType(), boxLock.getCreatedAt(), UserModelMapper.INSTANCE.toUserModel(boxLock.getCreator()), boxLock.getExpiresAt(), Boolean.valueOf(boxLock.isDownloadPrevented()));
    }

    public final JsonObject toJsonObject(FileLockModel fileLockModel) {
        Intrinsics.checkNotNullParameter(fileLockModel, "<this>");
        JsonObject jsonObject = new JsonObject();
        JsonObject jsonObjectAdd = jsonObject.add("id", fileLockModel.getId()).add("app_type", fileLockModel.getAppType());
        Date createdAt = fileLockModel.getCreatedAt();
        JsonObject jsonObjectAdd2 = jsonObjectAdd.add("created_at", createdAt != null ? BoxDateFormat.format(createdAt) : null);
        UserModel createdBy = fileLockModel.getCreatedBy();
        JsonObject jsonObject2 = BoxUser.createFromId(createdBy != null ? createdBy.getId() : null).toJsonObject();
        UserModel createdBy2 = fileLockModel.getCreatedBy();
        JsonObject jsonObjectAdd3 = jsonObject2.add("name", createdBy2 != null ? createdBy2.getName() : null);
        UserModel createdBy3 = fileLockModel.getCreatedBy();
        JsonObject jsonObjectAdd4 = jsonObjectAdd2.add("created_by", jsonObjectAdd3.add("login", createdBy3 != null ? createdBy3.getLogin() : null));
        Date expiresAt = fileLockModel.getExpiresAt();
        JsonObject jsonObjectAdd5 = jsonObjectAdd4.add(BoxCollaboration.FIELD_EXPIRES_AT, expiresAt != null ? BoxDateFormat.format(expiresAt) : null);
        Boolean boolIsDownloadPrevented = fileLockModel.isDownloadPrevented();
        jsonObjectAdd5.add("is_download_prevented", boolIsDownloadPrevented != null ? boolIsDownloadPrevented.booleanValue() : true);
        return jsonObject;
    }
}
