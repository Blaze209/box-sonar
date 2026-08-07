package com.box.android.data.utilities;

import com.box.android.data.api.models.items.FileDTO;
import com.box.android.data.api.models.items.FolderDTO;
import com.box.android.data.api.models.items.IItemDTO;
import com.box.android.data.api.models.items.WebLinkDTO;
import com.box.android.data.datasource.errors.CollectionsRemoteError;
import com.box.android.data.datasource.errors.CreateFolderRemoteError;
import com.box.android.data.datasource.errors.FileUploadRemoteError;
import com.box.android.data.datasource.errors.ItemsRemoteError;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.models.item.ItemType;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationErrorResponse;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: RemoteErrorConverter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\tR2\u0010\u0004\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/box/android/data/utilities/RemoteErrorConverter;", "", "<init>", "()V", "remoteErrorAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/box/android/data/datasource/errors/RemoteError;", "kotlin.jvm.PlatformType", "toString", "", "jobError", "fromString", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RemoteErrorConverter {
    public static final RemoteErrorConverter INSTANCE = new RemoteErrorConverter();
    private static final JsonAdapter<RemoteError> remoteErrorAdapter = new Moshi.Builder().add((JsonAdapter.Factory) PolymorphicJsonAdapterFactory.of(IItemDTO.class, "className").withSubtype(FileDTO.class, Reflection.getOrCreateKotlinClass(FileDTO.class).getQualifiedName()).withSubtype(FolderDTO.class, Reflection.getOrCreateKotlinClass(FolderDTO.class).getQualifiedName()).withSubtype(WebLinkDTO.class, Reflection.getOrCreateKotlinClass(WebLinkDTO.class).getQualifiedName())).add((JsonAdapter.Factory) PolymorphicJsonAdapterFactory.of(RemoteError.class, "className").withSubtype(CollectionsRemoteError.CollectionNotFound.class, Reflection.getOrCreateKotlinClass(CollectionsRemoteError.CollectionNotFound.class).getQualifiedName()).withSubtype(CollectionsRemoteError.CollectionIdMalformed.class, Reflection.getOrCreateKotlinClass(CollectionsRemoteError.CollectionIdMalformed.class).getQualifiedName()).withSubtype(CollectionsRemoteError.CollectionNameMalformed.class, Reflection.getOrCreateKotlinClass(CollectionsRemoteError.CollectionNameMalformed.class).getQualifiedName()).withSubtype(CollectionsRemoteError.UserNotAllowedCreation.class, Reflection.getOrCreateKotlinClass(CollectionsRemoteError.UserNotAllowedCreation.class).getQualifiedName()).withSubtype(CollectionsRemoteError.CreatingFavoritesNotAllowed.class, Reflection.getOrCreateKotlinClass(CollectionsRemoteError.CreatingFavoritesNotAllowed.class).getQualifiedName()).withSubtype(CollectionsRemoteError.DeletingFavoritesNotAllowed.class, Reflection.getOrCreateKotlinClass(CollectionsRemoteError.DeletingFavoritesNotAllowed.class).getQualifiedName()).withSubtype(CollectionsRemoteError.ExceedsItemLimit.class, Reflection.getOrCreateKotlinClass(CollectionsRemoteError.ExceedsItemLimit.class).getQualifiedName()).withSubtype(CollectionsRemoteError.CollectionNameConflict.class, Reflection.getOrCreateKotlinClass(CollectionsRemoteError.CollectionNameConflict.class).getQualifiedName()).withSubtype(RemoteError.BadRequest.class, Reflection.getOrCreateKotlinClass(RemoteError.BadRequest.class).getQualifiedName()).withSubtype(RemoteError.NotFound.class, Reflection.getOrCreateKotlinClass(RemoteError.NotFound.class).getQualifiedName()).withSubtype(RemoteError.Conflict.class, Reflection.getOrCreateKotlinClass(RemoteError.Conflict.class).getQualifiedName()).withSubtype(RemoteError.Unauthorized.class, Reflection.getOrCreateKotlinClass(RemoteError.Unauthorized.class).getQualifiedName()).withSubtype(RemoteError.Forbidden.class, Reflection.getOrCreateKotlinClass(RemoteError.Forbidden.class).getQualifiedName()).withSubtype(RemoteError.PreconditionFailed.class, Reflection.getOrCreateKotlinClass(RemoteError.PreconditionFailed.class).getQualifiedName()).withSubtype(RemoteError.UnprocessableEntity.class, Reflection.getOrCreateKotlinClass(RemoteError.UnprocessableEntity.class).getQualifiedName()).withSubtype(RemoteError.InternalServerError.class, Reflection.getOrCreateKotlinClass(RemoteError.InternalServerError.class).getQualifiedName()).withSubtype(RemoteError.NetworkError.class, Reflection.getOrCreateKotlinClass(RemoteError.NetworkError.class).getQualifiedName()).withSubtype(RemoteError.Unknown.class, Reflection.getOrCreateKotlinClass(RemoteError.Unknown.class).getQualifiedName()).withSubtype(RemoteError.UnknownHostError.class, Reflection.getOrCreateKotlinClass(RemoteError.UnknownHostError.class).getQualifiedName()).withSubtype(ItemsRemoteError.NameConflict.class, Reflection.getOrCreateKotlinClass(ItemsRemoteError.NameConflict.class).getQualifiedName()).withSubtype(ItemsRemoteError.ForbiddenByShieldPolicy.class, Reflection.getOrCreateKotlinClass(ItemsRemoteError.ForbiddenByShieldPolicy.class).getQualifiedName()).withSubtype(ItemsRemoteError.ItemNotFound.class, Reflection.getOrCreateKotlinClass(ItemsRemoteError.ItemNotFound.class).getQualifiedName()).withSubtype(ItemsRemoteError.SharedLinkPasswordValidationError.class, Reflection.getOrCreateKotlinClass(ItemsRemoteError.SharedLinkPasswordValidationError.class).getQualifiedName()).withSubtype(CreateFolderRemoteError.ItemNameTooLong.class, Reflection.getOrCreateKotlinClass(CreateFolderRemoteError.ItemNameTooLong.class).getQualifiedName()).withSubtype(CreateFolderRemoteError.InvalidName.class, Reflection.getOrCreateKotlinClass(CreateFolderRemoteError.InvalidName.class).getQualifiedName()).withSubtype(CreateFolderRemoteError.OperationBlockedTemporary.class, Reflection.getOrCreateKotlinClass(CreateFolderRemoteError.OperationBlockedTemporary.class).getQualifiedName()).withSubtype(FileUploadRemoteError.AccessDeniedError.class, Reflection.getOrCreateKotlinClass(FileUploadRemoteError.AccessDeniedError.class).getQualifiedName()).withSubtype(FileUploadRemoteError.AccountSpaceError.class, Reflection.getOrCreateKotlinClass(FileUploadRemoteError.AccountSpaceError.class).getQualifiedName()).withSubtype(FileUploadRemoteError.SourceOrDestNotFound.class, Reflection.getOrCreateKotlinClass(FileUploadRemoteError.SourceOrDestNotFound.class).getQualifiedName()).withSubtype(FileUploadRemoteError.CommitNotReady.class, Reflection.getOrCreateKotlinClass(FileUploadRemoteError.CommitNotReady.class).getQualifiedName())).add((JsonAdapter.Factory) PolymorphicJsonAdapterFactory.of(IItemDTO.class, "type").withSubtype(FileDTO.class, ItemType.FILE.toString()).withSubtype(FolderDTO.class, ItemType.FOLDER.toString()).withSubtype(WebLinkDTO.class, ItemType.WEBLINK.toString())).add((JsonAdapter.Factory) new KotlinObjectAdapterFactory()).add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build().adapter(RemoteError.class);

    private RemoteErrorConverter() {
    }

    public final String toString(RemoteError jobError) {
        Intrinsics.checkNotNullParameter(jobError, "jobError");
        String json = remoteErrorAdapter.toJson(jobError);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    public final RemoteError fromString(String value) throws IOException {
        Intrinsics.checkNotNullParameter(value, "value");
        RemoteError remoteErrorFromJson = remoteErrorAdapter.fromJson(value);
        return remoteErrorFromJson == null ? new RemoteError.Unknown(-1, MicrosoftAuthorizationErrorResponse.UNKNOWN_ERROR) : remoteErrorFromJson;
    }
}
