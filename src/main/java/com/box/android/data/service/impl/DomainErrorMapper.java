package com.box.android.data.service.impl;

import com.apollographql.apollo3.api.Error;
import com.apollographql.apollo3.exception.ApolloNetworkException;
import com.box.android.data.api.models.items.FileDTO;
import com.box.android.data.api.models.items.FolderDTO;
import com.box.android.data.api.models.items.IItemDTO;
import com.box.android.data.api.models.items.WebLinkDTO;
import com.box.android.data.datasource.CacheError;
import com.box.android.data.datasource.GQLErrorUtil;
import com.box.android.data.datasource.errors.CollaborationRemoteError;
import com.box.android.data.datasource.errors.CollectionsRemoteError;
import com.box.android.data.datasource.errors.CreateFolderRemoteError;
import com.box.android.data.datasource.errors.FileUploadRemoteError;
import com.box.android.data.datasource.errors.ItemsRemoteError;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.errors.RequestCancelledError;
import com.box.android.data.datasource.gql.CustomAttributeKeys;
import com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor;
import com.box.android.data.mappers.FileDTOtoFileModelMapper;
import com.box.android.data.mappers.FolderDTOtoFolderModelMapper;
import com.box.android.data.mappers.WebLinkDTOtoWebLinkModelMapper;
import com.box.android.data.utilities.RemoteErrorConverter;
import com.box.android.domain.models.CollaborationDomainError;
import com.box.android.domain.models.CollectionsDomainError;
import com.box.android.domain.models.CreateFolderDomainError;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.FileUploadDomainError;
import com.box.android.domain.models.IGenericError;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.WebLinkModel;
import com.box.androidsdk.content.BoxException;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationErrorResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DomainErrorMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0007*\u00020\tJ\n\u0010\b\u001a\u00020\u0007*\u00020\nJ\n\u0010\b\u001a\u00020\u0007*\u00020\u000bJ\u0016\u0010\b\u001a\u00020\u0007*\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\n\u0010\b\u001a\u00020\u0007*\u00020\u0012J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0011J\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/box/android/data/service/impl/DomainErrorMapper;", "", "<init>", "()V", "CACHE_TO_DOMAIN_ERROR_MAP", "", "Lcom/box/android/data/datasource/CacheError;", "Lcom/box/android/domain/models/DomainError;", "toDomainError", "Lcom/box/android/data/datasource/errors/CollectionsRemoteError;", "Lcom/box/android/data/datasource/errors/FileUploadRemoteError;", "Lcom/box/android/data/datasource/errors/CollaborationRemoteError;", "REMOTE_TO_DOMAIN_ERROR_MAP", "Lcom/box/android/data/datasource/errors/RemoteError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorMessage", "", "Lcom/apollographql/apollo3/api/Error;", "error", "Lcom/box/android/domain/models/IGenericError;", "unknownErrorMessage", "mapItemDTOsToDomainModel", "", "Lcom/box/android/domain/models/item/ItemModel;", "itemDTOs", "Lcom/box/android/data/api/models/items/IItemDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DomainErrorMapper {
    private static final Map<RemoteError, DomainError> REMOTE_TO_DOMAIN_ERROR_MAP;
    public static final DomainErrorMapper INSTANCE = new DomainErrorMapper();
    private static final Map<CacheError, DomainError> CACHE_TO_DOMAIN_ERROR_MAP = MapsKt.mapOf(TuplesKt.to(CacheError.DatabaseInitError.INSTANCE, new DomainError.CacheInitError(null, 1, null)), TuplesKt.to(CacheError.NoUserLoggedInError.INSTANCE, new DomainError.NoUserLoggedInError(null, 1, null)), TuplesKt.to(CacheError.SaveError.INSTANCE, new DomainError.CacheWriteError(null, 1, null)), TuplesKt.to(CacheError.DeleteError.INSTANCE, new DomainError.CacheWriteError(null, 1, null)), TuplesKt.to(CacheError.ReadError.INSTANCE, new DomainError.CacheReadError(null, 1, null)), TuplesKt.to(CacheError.NoResultFound.INSTANCE, new DomainError.NoResultFoundError(null, 1, null)));

    private DomainErrorMapper() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i = 1;
        REMOTE_TO_DOMAIN_ERROR_MAP = MapsKt.mapOf(TuplesKt.to(new RemoteError.Forbidden(null, 1, null), new DomainError.APIAuthError(null, 1, null)), TuplesKt.to(new RemoteError.Unauthorized(null, 1, null), new DomainError.Unauthorized(null, 1, null)), TuplesKt.to(new RemoteError.Conflict(), new DomainError.APIResourceConflict(null, 1, null)), TuplesKt.to(new RemoteError.NotFound(null, 1, null), new DomainError.APINotFoundError(null, 1, null)), TuplesKt.to(RemoteError.InternalServerError.INSTANCE, new DomainError.APIServerError(null, 1, null)), TuplesKt.to(new RemoteError.UnknownHostError(), new DomainError.NoConnectivityError(null, 1, null)), TuplesKt.to(RemoteError.NetworkError.INSTANCE, new DomainError.NetworkError(null, 1, null)), TuplesKt.to(RequestCancelledError.INSTANCE, new DomainError.JobCancelledError("RequestCancelledError Handled")), TuplesKt.to(RemoteError.PreconditionFailed.INSTANCE, new DomainError.PreconditionFailed(null, 1, null)), TuplesKt.to(new CreateFolderRemoteError.InvalidName(null, 1, null), new CreateFolderDomainError.InvalidName(null, i, 0 == true ? 1 : 0)), TuplesKt.to(new CreateFolderRemoteError.ItemNameTooLong(null, 1, null), new CreateFolderDomainError.ItemNameTooLong(0 == true ? 1 : 0, i, 0 == true ? 1 : 0)), TuplesKt.to(new CreateFolderRemoteError.OperationBlockedTemporary(null, 1, null), new CreateFolderDomainError.OperationBlockedTemporary(0 == true ? 1 : 0, i, 0 == true ? 1 : 0)));
    }

    public final DomainError toDomainError(CollectionsRemoteError collectionsRemoteError) {
        Intrinsics.checkNotNullParameter(collectionsRemoteError, "<this>");
        if (collectionsRemoteError instanceof CollectionsRemoteError.CollectionNotFound) {
            return new CollectionsDomainError.CollectionNotFound(((CollectionsRemoteError.CollectionNotFound) collectionsRemoteError).getMessage());
        }
        if (collectionsRemoteError instanceof CollectionsRemoteError.DeletingFavoritesNotAllowed) {
            return new CollectionsDomainError.DeletingFavoritesNotAllowed(((CollectionsRemoteError.DeletingFavoritesNotAllowed) collectionsRemoteError).getMessage());
        }
        if (collectionsRemoteError instanceof CollectionsRemoteError.CreatingFavoritesNotAllowed) {
            return new CollectionsDomainError.CreatingFavoritesNotAllowed(((CollectionsRemoteError.CreatingFavoritesNotAllowed) collectionsRemoteError).getMessage());
        }
        if (collectionsRemoteError instanceof CollectionsRemoteError.UserNotAllowedCreation) {
            return new CollectionsDomainError.UserNotAllowedCreation(((CollectionsRemoteError.UserNotAllowedCreation) collectionsRemoteError).getMessage());
        }
        if (collectionsRemoteError instanceof CollectionsRemoteError.CollectionNameMalformed) {
            return new CollectionsDomainError.CollectionNameMalformed(((CollectionsRemoteError.CollectionNameMalformed) collectionsRemoteError).getMessage());
        }
        if (collectionsRemoteError instanceof CollectionsRemoteError.CollectionNameConflict) {
            return new CollectionsDomainError.CollectionNameConflict(((CollectionsRemoteError.CollectionNameConflict) collectionsRemoteError).getMessage());
        }
        if (collectionsRemoteError instanceof CollectionsRemoteError.CollectionIdMalformed) {
            return new CollectionsDomainError.CollectionIdMalformed(((CollectionsRemoteError.CollectionIdMalformed) collectionsRemoteError).getMessage());
        }
        if (!(collectionsRemoteError instanceof CollectionsRemoteError.ExceedsItemLimit)) {
            throw new NoWhenBranchMatchedException();
        }
        return new CollectionsDomainError.TooManyCollectionItems(((CollectionsRemoteError.ExceedsItemLimit) collectionsRemoteError).getMessage());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final DomainError toDomainError(FileUploadRemoteError fileUploadRemoteError) {
        Intrinsics.checkNotNullParameter(fileUploadRemoteError, "<this>");
        if (fileUploadRemoteError instanceof FileUploadRemoteError.AccessDeniedError) {
            return new FileUploadDomainError.AccessDeniedError(((FileUploadRemoteError.AccessDeniedError) fileUploadRemoteError).getMessage());
        }
        if (fileUploadRemoteError instanceof FileUploadRemoteError.AccountSpaceError) {
            return new FileUploadDomainError.AccountSpaceError(((FileUploadRemoteError.AccountSpaceError) fileUploadRemoteError).getMessage());
        }
        if (fileUploadRemoteError instanceof FileUploadRemoteError.CommitNotReady) {
            return new FileUploadDomainError.CommitNotReady(((FileUploadRemoteError.CommitNotReady) fileUploadRemoteError).getMessage());
        }
        if (Intrinsics.areEqual(fileUploadRemoteError, FileUploadRemoteError.FileSizeLimitError.INSTANCE)) {
            return new FileUploadDomainError.FileSizeLimitError(fileUploadRemoteError.getMessage());
        }
        if (Intrinsics.areEqual(fileUploadRemoteError, FileUploadRemoteError.InsufficientStorageError.INSTANCE)) {
            return new FileUploadDomainError.InsufficientStorageError(fileUploadRemoteError.getMessage());
        }
        if (Intrinsics.areEqual(fileUploadRemoteError, FileUploadRemoteError.NameExistsErr.INSTANCE)) {
            return new FileUploadDomainError.NameExistsErr(null, 1, 0 == true ? 1 : 0);
        }
        if (fileUploadRemoteError instanceof FileUploadRemoteError.SourceOrDestNotFound) {
            return new FileUploadDomainError.SourceOrDestNotFound(((FileUploadRemoteError.SourceOrDestNotFound) fileUploadRemoteError).getMessage());
        }
        throw new NoWhenBranchMatchedException();
    }

    public final DomainError toDomainError(CollaborationRemoteError collaborationRemoteError) {
        Intrinsics.checkNotNullParameter(collaborationRemoteError, "<this>");
        if (!(collaborationRemoteError instanceof CollaborationRemoteError.TwoFactorAuthenticationUnmet)) {
            throw new NoWhenBranchMatchedException();
        }
        return new CollaborationDomainError.TwoFactorAuthenticationUnmet(((CollaborationRemoteError.TwoFactorAuthenticationUnmet) collaborationRemoteError).getMessage());
    }

    public final DomainError toDomainError(Exception exc, String errorMessage) {
        String message;
        Intrinsics.checkNotNullParameter(exc, "<this>");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        if (exc instanceof ApolloNetworkException) {
            Throwable cause = exc.getCause();
            if ((cause != null && (message = cause.getMessage()) != null) || (message = exc.getMessage()) != null) {
                errorMessage = message;
            }
            String lowerCase = errorMessage.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String str = lowerCase;
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) "user must accept custom terms of service", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "terms_of_service_required", false, 2, (Object) null)) {
                return new DomainError.TermsOfServiceError(lowerCase);
            }
            return new DomainError.NetworkError(lowerCase);
        }
        if (exc instanceof BoxException.CacheResultUnavailable) {
            return new DomainError.CacheReadError(errorMessage);
        }
        boolean z = exc instanceof BoxException;
        if (z && ((BoxException) exc).getErrorType() == BoxException.ErrorType.NETWORK_ERROR) {
            String message2 = exc.getMessage();
            if (message2 != null) {
                errorMessage = message2;
            }
            return new DomainError.NetworkError(errorMessage);
        }
        if (z && ((BoxException) exc).getErrorType() == BoxException.ErrorType.TERMS_OF_SERVICE_REQUIRED) {
            String message3 = exc.getMessage();
            if (message3 != null) {
                errorMessage = message3;
            }
            return new DomainError.TermsOfServiceError(errorMessage);
        }
        if (z && ((BoxException) exc).getErrorType() == BoxException.ErrorType.NOT_FOUND) {
            String message4 = exc.getMessage();
            if (message4 != null) {
                errorMessage = message4;
            }
            return new DomainError.APINotFoundError(errorMessage);
        }
        return new DomainError.UnknownError(errorMessage);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    public final DomainError toDomainError(Error error) {
        RemoteError remoteError;
        RemoteError remoteErrorFromString;
        Intrinsics.checkNotNullParameter(error, "<this>");
        RemoteError remoteError2 = GQLErrorUtil.INSTANCE.getRemoteError(error);
        if ((remoteError2 instanceof RemoteError.Unknown ? (RemoteError.Unknown) remoteError2 : null) != null) {
            Map<String, Object> nonStandardFields = error.getNonStandardFields();
            Object obj = nonStandardFields != null ? nonStandardFields.get(CustomAttributeKeys.REMOTE_ERROR) : null;
            String str = obj instanceof String ? (String) obj : null;
            Map<String, Object> nonStandardFields2 = error.getNonStandardFields();
            Object obj2 = nonStandardFields2 != null ? nonStandardFields2.get(GQLPartialDataExtractor.GQL_CACHE_ERROR_KEY) : null;
            remoteError = (str == null || (remoteErrorFromString = RemoteErrorConverter.INSTANCE.fromString(str)) == null) ? obj2 instanceof CacheError ? (CacheError) obj2 : null : remoteErrorFromString;
            if (remoteError == null) {
                remoteError = remoteError2;
            }
        } else {
            remoteError = remoteError2;
        }
        return toDomainError(remoteError, "An unknown remote error happened! " + error);
    }

    public static /* synthetic */ DomainError toDomainError$default(DomainErrorMapper domainErrorMapper, IGenericError iGenericError, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return domainErrorMapper.toDomainError(iGenericError, str);
    }

    public final DomainError toDomainError(IGenericError error, String unknownErrorMessage) {
        DomainError domainError;
        DomainError.UnknownError unknownError;
        Intrinsics.checkNotNullParameter(error, "error");
        if (error instanceof CacheError) {
            DomainError domainError2 = CACHE_TO_DOMAIN_ERROR_MAP.get(error);
            if (domainError2 != null) {
                return domainError2;
            }
            if (unknownErrorMessage == null) {
                unknownErrorMessage = "Unknown Cache Error";
            }
            return new DomainError.UnknownError(unknownErrorMessage);
        }
        if (error instanceof RemoteError) {
            RemoteError remoteError = (RemoteError) error;
            if (remoteError instanceof RemoteError.BadRequest) {
                domainError = new DomainError.APIRequestError(((RemoteError.BadRequest) error).getMessage());
            } else if (remoteError instanceof ItemsRemoteError.NameConflict) {
                domainError = new DomainError.NameConflict(mapItemDTOsToDomainModel(((ItemsRemoteError.NameConflict) error).getItemDTOs()));
            } else if (remoteError instanceof ItemsRemoteError.ForbiddenByShieldPolicy) {
                domainError = new DomainError.ForbiddenByShieldPolicy(((ItemsRemoteError.ForbiddenByShieldPolicy) error).getMessage());
            } else if (remoteError instanceof CollectionsRemoteError) {
                domainError = toDomainError((CollectionsRemoteError) error);
            } else if (remoteError instanceof FileUploadRemoteError) {
                domainError = toDomainError((FileUploadRemoteError) error);
            } else {
                domainError = remoteError instanceof CollaborationRemoteError ? toDomainError((CollaborationRemoteError) error) : REMOTE_TO_DOMAIN_ERROR_MAP.get(error);
            }
            if (domainError != null) {
                return domainError;
            }
            if (remoteError instanceof RemoteError.Unknown) {
                unknownError = new DomainError.UnknownError(((RemoteError.Unknown) error).getMessage());
            } else {
                if (unknownErrorMessage == null) {
                    unknownErrorMessage = "Unknown Remote Error";
                }
                unknownError = new DomainError.UnknownError(unknownErrorMessage);
            }
            return unknownError;
        }
        if (error instanceof DomainError) {
            return (DomainError) error;
        }
        if (unknownErrorMessage == null) {
            unknownErrorMessage = MicrosoftAuthorizationErrorResponse.UNKNOWN_ERROR;
        }
        return new DomainError.UnknownError(unknownErrorMessage);
    }

    public final List<ItemModel> mapItemDTOsToDomainModel(List<? extends IItemDTO> itemDTOs) {
        WebLinkModel domain;
        Intrinsics.checkNotNullParameter(itemDTOs, "itemDTOs");
        ArrayList arrayList = new ArrayList();
        for (IItemDTO iItemDTO : itemDTOs) {
            if (iItemDTO instanceof FolderDTO) {
                domain = FolderDTOtoFolderModelMapper.INSTANCE.toDomain((FolderDTO) iItemDTO);
            } else if (iItemDTO instanceof FileDTO) {
                domain = FileDTOtoFileModelMapper.INSTANCE.toDomain((FileDTO) iItemDTO);
            } else {
                domain = iItemDTO instanceof WebLinkDTO ? WebLinkDTOtoWebLinkModelMapper.INSTANCE.toDomain((WebLinkDTO) iItemDTO) : null;
            }
            if (domain != null) {
                arrayList.add(domain);
            }
        }
        return arrayList;
    }
}
