package com.box.android.data.persistence.jobs;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.domain.models.AdminSettingsDomainError;
import com.box.android.domain.models.AudioRecordingError;
import com.box.android.domain.models.CollectionsDomainError;
import com.box.android.domain.models.CreateFolderDomainError;
import com.box.android.domain.models.DocumentScanningError;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DownloadFileDomainError;
import com.box.android.domain.models.FileActivityDomainError;
import com.box.android.domain.models.FileUploadDomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.OfflineDomainError;
import com.box.android.domain.models.PushNotificationSettingsDomainError;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.UnknownItemModel;
import com.box.android.domain.models.item.WebLinkModel;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory;
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: DomainErrorConverter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007¨\u0006\u000b"}, d2 = {"Lcom/box/android/data/persistence/jobs/DomainErrorConverter;", "", "<init>", "()V", "toString", "", "jobError", "Lcom/box/android/domain/models/DomainError;", "fromString", "value", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DomainErrorConverter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final JsonAdapter<ItemModel> itemAdapter;
    private static final JsonAdapter<ItemId> itemIdAdapter;
    private static final JsonAdapter<DomainError> jobErrorAdapter;

    /* JADX INFO: compiled from: DomainErrorConverter.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\n\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\f0\f \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\f0\f\u0018\u00010\u000b0\u000b\"\n\b\u0000\u0010\r\u0018\u0001*\u00020\f*\b\u0012\u0004\u0012\u00020\f0\u000bH\u0082\bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fR2\u0010\u0004\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\b\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\t0\t \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\t0\t\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0011\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\f0\f \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\f0\f\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/persistence/jobs/DomainErrorConverter$Companion;", "", "<init>", "()V", "itemIdAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/box/android/domain/models/ItemId;", "kotlin.jvm.PlatformType", "itemAdapter", "Lcom/box/android/domain/models/item/ItemModel;", "withErrorSubtype", "Lcom/squareup/moshi/adapters/PolymorphicJsonAdapterFactory;", "Lcom/box/android/domain/models/DomainError;", ExifInterface.GPS_DIRECTION_TRUE, "appendTo", "Lcom/squareup/moshi/Moshi$Builder;", "builder", "jobErrorAdapter", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final /* synthetic */ <T extends DomainError> PolymorphicJsonAdapterFactory<DomainError> withErrorSubtype(PolymorphicJsonAdapterFactory<DomainError> polymorphicJsonAdapterFactory) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return polymorphicJsonAdapterFactory.withSubtype(DomainError.class, Reflection.getOrCreateKotlinClass(DomainError.class).getQualifiedName());
        }

        public final Moshi.Builder appendTo(Moshi.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            Moshi.Builder builderAdd = builder.add(ItemModel.class, DomainErrorConverter.itemAdapter);
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryOf = PolymorphicJsonAdapterFactory.of(DomainError.class, "className");
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryOf, "of(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype = polymorphicJsonAdapterFactoryOf.withSubtype(DomainError.CreateJobError.class, Reflection.getOrCreateKotlinClass(DomainError.CreateJobError.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype2 = polymorphicJsonAdapterFactoryWithSubtype.withSubtype(DomainError.CacheInitError.class, Reflection.getOrCreateKotlinClass(DomainError.CacheInitError.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype2, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype3 = polymorphicJsonAdapterFactoryWithSubtype2.withSubtype(DomainError.CacheReadError.class, Reflection.getOrCreateKotlinClass(DomainError.CacheReadError.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype3, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype4 = polymorphicJsonAdapterFactoryWithSubtype3.withSubtype(DomainError.CacheWriteError.class, Reflection.getOrCreateKotlinClass(DomainError.CacheWriteError.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype4, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype5 = polymorphicJsonAdapterFactoryWithSubtype4.withSubtype(DomainError.NoUserLoggedInError.class, Reflection.getOrCreateKotlinClass(DomainError.NoUserLoggedInError.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype5, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype6 = polymorphicJsonAdapterFactoryWithSubtype5.withSubtype(DomainError.NoResultFoundError.class, Reflection.getOrCreateKotlinClass(DomainError.NoResultFoundError.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype6, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype7 = polymorphicJsonAdapterFactoryWithSubtype6.withSubtype(DomainError.InputValidationError.class, Reflection.getOrCreateKotlinClass(DomainError.InputValidationError.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype7, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype8 = polymorphicJsonAdapterFactoryWithSubtype7.withSubtype(DomainError.NameConflict.class, Reflection.getOrCreateKotlinClass(DomainError.NameConflict.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype8, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype9 = polymorphicJsonAdapterFactoryWithSubtype8.withSubtype(DomainError.APIRequestError.class, Reflection.getOrCreateKotlinClass(DomainError.APIRequestError.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype9, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype10 = polymorphicJsonAdapterFactoryWithSubtype9.withSubtype(DomainError.APIAuthError.class, Reflection.getOrCreateKotlinClass(DomainError.APIAuthError.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype10, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype11 = polymorphicJsonAdapterFactoryWithSubtype10.withSubtype(DomainError.APINotFoundError.class, Reflection.getOrCreateKotlinClass(DomainError.APINotFoundError.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype11, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype12 = polymorphicJsonAdapterFactoryWithSubtype11.withSubtype(DomainError.APIResourceConflict.class, Reflection.getOrCreateKotlinClass(DomainError.APIResourceConflict.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype12, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype13 = polymorphicJsonAdapterFactoryWithSubtype12.withSubtype(DomainError.APIServerError.class, Reflection.getOrCreateKotlinClass(DomainError.APIServerError.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype13, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype14 = polymorphicJsonAdapterFactoryWithSubtype13.withSubtype(DomainError.NoConnectivityError.class, Reflection.getOrCreateKotlinClass(DomainError.NoConnectivityError.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype14, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype15 = polymorphicJsonAdapterFactoryWithSubtype14.withSubtype(DomainError.NetworkError.class, Reflection.getOrCreateKotlinClass(DomainError.NetworkError.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype15, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype16 = polymorphicJsonAdapterFactoryWithSubtype15.withSubtype(DomainError.TermsOfServiceError.class, Reflection.getOrCreateKotlinClass(DomainError.TermsOfServiceError.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype16, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype17 = polymorphicJsonAdapterFactoryWithSubtype16.withSubtype(DomainError.PreconditionFailed.class, Reflection.getOrCreateKotlinClass(DomainError.PreconditionFailed.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype17, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype18 = polymorphicJsonAdapterFactoryWithSubtype17.withSubtype(DomainError.ForbiddenByShieldPolicy.class, Reflection.getOrCreateKotlinClass(DomainError.ForbiddenByShieldPolicy.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype18, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype19 = polymorphicJsonAdapterFactoryWithSubtype18.withSubtype(DomainError.Unauthorized.class, Reflection.getOrCreateKotlinClass(DomainError.Unauthorized.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype19, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype20 = polymorphicJsonAdapterFactoryWithSubtype19.withSubtype(DomainError.UnknownError.class, Reflection.getOrCreateKotlinClass(DomainError.UnknownError.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype20, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype21 = polymorphicJsonAdapterFactoryWithSubtype20.withSubtype(CollectionsDomainError.CollectionNotFound.class, Reflection.getOrCreateKotlinClass(CollectionsDomainError.CollectionNotFound.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype21, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype22 = polymorphicJsonAdapterFactoryWithSubtype21.withSubtype(CollectionsDomainError.CollectionIdMalformed.class, Reflection.getOrCreateKotlinClass(CollectionsDomainError.CollectionIdMalformed.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype22, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype23 = polymorphicJsonAdapterFactoryWithSubtype22.withSubtype(CollectionsDomainError.CollectionNameConflict.class, Reflection.getOrCreateKotlinClass(CollectionsDomainError.CollectionNameConflict.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype23, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype24 = polymorphicJsonAdapterFactoryWithSubtype23.withSubtype(CollectionsDomainError.CollectionNameMalformed.class, Reflection.getOrCreateKotlinClass(CollectionsDomainError.CollectionNameMalformed.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype24, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype25 = polymorphicJsonAdapterFactoryWithSubtype24.withSubtype(CollectionsDomainError.UserNotAllowedCreation.class, Reflection.getOrCreateKotlinClass(CollectionsDomainError.UserNotAllowedCreation.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype25, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype26 = polymorphicJsonAdapterFactoryWithSubtype25.withSubtype(CollectionsDomainError.CreatingFavoritesNotAllowed.class, Reflection.getOrCreateKotlinClass(CollectionsDomainError.CreatingFavoritesNotAllowed.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype26, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype27 = polymorphicJsonAdapterFactoryWithSubtype26.withSubtype(CollectionsDomainError.DeletingFavoritesNotAllowed.class, Reflection.getOrCreateKotlinClass(CollectionsDomainError.DeletingFavoritesNotAllowed.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype27, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype28 = polymorphicJsonAdapterFactoryWithSubtype27.withSubtype(CollectionsDomainError.TooManyCollectionItems.class, Reflection.getOrCreateKotlinClass(CollectionsDomainError.TooManyCollectionItems.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype28, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype29 = polymorphicJsonAdapterFactoryWithSubtype28.withSubtype(FileUploadDomainError.AccessDeniedError.class, Reflection.getOrCreateKotlinClass(FileUploadDomainError.AccessDeniedError.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype29, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype30 = polymorphicJsonAdapterFactoryWithSubtype29.withSubtype(FileUploadDomainError.FileSizeLimitError.class, Reflection.getOrCreateKotlinClass(FileUploadDomainError.FileSizeLimitError.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype30, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype31 = polymorphicJsonAdapterFactoryWithSubtype30.withSubtype(FileUploadDomainError.InsufficientStorageError.class, Reflection.getOrCreateKotlinClass(FileUploadDomainError.InsufficientStorageError.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype31, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype32 = polymorphicJsonAdapterFactoryWithSubtype31.withSubtype(FileUploadDomainError.AccountSpaceError.class, Reflection.getOrCreateKotlinClass(FileUploadDomainError.AccountSpaceError.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype32, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype33 = polymorphicJsonAdapterFactoryWithSubtype32.withSubtype(FileActivityDomainError.CouldNotFetchActivityError.class, Reflection.getOrCreateKotlinClass(FileActivityDomainError.CouldNotFetchActivityError.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype33, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype34 = polymorphicJsonAdapterFactoryWithSubtype33.withSubtype(PushNotificationSettingsDomainError.DeviceAlreadyExists.class, Reflection.getOrCreateKotlinClass(PushNotificationSettingsDomainError.DeviceAlreadyExists.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype34, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype35 = polymorphicJsonAdapterFactoryWithSubtype34.withSubtype(DocumentScanningError.DocumentGenerationError.class, Reflection.getOrCreateKotlinClass(DocumentScanningError.DocumentGenerationError.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype35, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype36 = polymorphicJsonAdapterFactoryWithSubtype35.withSubtype(AudioRecordingError.MicrophoneInUseError.class, Reflection.getOrCreateKotlinClass(AudioRecordingError.MicrophoneInUseError.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype36, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype37 = polymorphicJsonAdapterFactoryWithSubtype36.withSubtype(AudioRecordingError.AudioRecordingStartError.class, Reflection.getOrCreateKotlinClass(AudioRecordingError.AudioRecordingStartError.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype37, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype38 = polymorphicJsonAdapterFactoryWithSubtype37.withSubtype(CreateFolderDomainError.ItemNameTooLong.class, Reflection.getOrCreateKotlinClass(CreateFolderDomainError.ItemNameTooLong.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype38, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype39 = polymorphicJsonAdapterFactoryWithSubtype38.withSubtype(CreateFolderDomainError.InvalidName.class, Reflection.getOrCreateKotlinClass(CreateFolderDomainError.InvalidName.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype39, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype40 = polymorphicJsonAdapterFactoryWithSubtype39.withSubtype(CreateFolderDomainError.OperationBlockedTemporary.class, Reflection.getOrCreateKotlinClass(CreateFolderDomainError.OperationBlockedTemporary.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype40, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype41 = polymorphicJsonAdapterFactoryWithSubtype40.withSubtype(FileUploadDomainError.SourceOrDestNotFound.class, Reflection.getOrCreateKotlinClass(FileUploadDomainError.SourceOrDestNotFound.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype41, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype42 = polymorphicJsonAdapterFactoryWithSubtype41.withSubtype(DomainError.StoragePermissionMissing.class, Reflection.getOrCreateKotlinClass(DomainError.StoragePermissionMissing.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype42, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype43 = polymorphicJsonAdapterFactoryWithSubtype42.withSubtype(FileUploadDomainError.CommitNotReady.class, Reflection.getOrCreateKotlinClass(FileUploadDomainError.CommitNotReady.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype43, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype44 = polymorphicJsonAdapterFactoryWithSubtype43.withSubtype(FileUploadDomainError.NameExistsErr.class, Reflection.getOrCreateKotlinClass(FileUploadDomainError.NameExistsErr.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype44, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype45 = polymorphicJsonAdapterFactoryWithSubtype44.withSubtype(DomainError.JobCancelledError.class, Reflection.getOrCreateKotlinClass(DomainError.JobCancelledError.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype45, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype46 = polymorphicJsonAdapterFactoryWithSubtype45.withSubtype(DownloadFileDomainError.TargetLocationNotFound.class, Reflection.getOrCreateKotlinClass(DownloadFileDomainError.TargetLocationNotFound.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype46, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype47 = polymorphicJsonAdapterFactoryWithSubtype46.withSubtype(DownloadFileDomainError.FileToDownloadNotFound.class, Reflection.getOrCreateKotlinClass(DownloadFileDomainError.FileToDownloadNotFound.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype47, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype48 = polymorphicJsonAdapterFactoryWithSubtype47.withSubtype(DownloadFileDomainError.FileSha1VerificationFailed.class, Reflection.getOrCreateKotlinClass(DownloadFileDomainError.FileSha1VerificationFailed.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype48, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype49 = polymorphicJsonAdapterFactoryWithSubtype48.withSubtype(DownloadFileDomainError.TargetFileCreationError.class, Reflection.getOrCreateKotlinClass(DownloadFileDomainError.TargetFileCreationError.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype49, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype50 = polymorphicJsonAdapterFactoryWithSubtype49.withSubtype(DownloadFileDomainError.PartialDownloadError.class, Reflection.getOrCreateKotlinClass(DownloadFileDomainError.PartialDownloadError.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype50, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype51 = polymorphicJsonAdapterFactoryWithSubtype50.withSubtype(OfflineDomainError.BoxNotesCannotBeOfflined.class, Reflection.getOrCreateKotlinClass(OfflineDomainError.BoxNotesCannotBeOfflined.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype51, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype52 = polymorphicJsonAdapterFactoryWithSubtype51.withSubtype(OfflineDomainError.OffliningDisabledByAdministrator.class, Reflection.getOrCreateKotlinClass(OfflineDomainError.OffliningDisabledByAdministrator.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype52, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype53 = polymorphicJsonAdapterFactoryWithSubtype52.withSubtype(OfflineDomainError.MissingFilePermissions.class, Reflection.getOrCreateKotlinClass(OfflineDomainError.MissingFilePermissions.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype53, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype54 = polymorphicJsonAdapterFactoryWithSubtype53.withSubtype(OfflineDomainError.InsufficientPermissionsToOffline.class, Reflection.getOrCreateKotlinClass(OfflineDomainError.InsufficientPermissionsToOffline.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype54, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype55 = polymorphicJsonAdapterFactoryWithSubtype54.withSubtype(OfflineDomainError.DownloadingOriginalFileFailed.class, Reflection.getOrCreateKotlinClass(OfflineDomainError.DownloadingOriginalFileFailed.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype55, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype56 = polymorphicJsonAdapterFactoryWithSubtype55.withSubtype(OfflineDomainError.FailedToRenameTempFile.class, Reflection.getOrCreateKotlinClass(OfflineDomainError.FailedToRenameTempFile.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype56, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype57 = polymorphicJsonAdapterFactoryWithSubtype56.withSubtype(OfflineDomainError.FailedToFindDownloadedFile.class, Reflection.getOrCreateKotlinClass(OfflineDomainError.FailedToFindDownloadedFile.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype57, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype58 = polymorphicJsonAdapterFactoryWithSubtype57.withSubtype(OfflineDomainError.MissingParentPath.class, Reflection.getOrCreateKotlinClass(OfflineDomainError.MissingParentPath.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype58, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype59 = polymorphicJsonAdapterFactoryWithSubtype58.withSubtype(OfflineDomainError.FailedToFetchRepresentations.class, Reflection.getOrCreateKotlinClass(OfflineDomainError.FailedToFetchRepresentations.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype59, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype60 = polymorphicJsonAdapterFactoryWithSubtype59.withSubtype(OfflineDomainError.SupportedRepresentationNotFound.class, Reflection.getOrCreateKotlinClass(OfflineDomainError.SupportedRepresentationNotFound.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype60, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype61 = polymorphicJsonAdapterFactoryWithSubtype60.withSubtype(OfflineDomainError.RepresentationNotReady.class, Reflection.getOrCreateKotlinClass(OfflineDomainError.RepresentationNotReady.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype61, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype62 = polymorphicJsonAdapterFactoryWithSubtype61.withSubtype(OfflineDomainError.PreviewDownloadFailed.class, Reflection.getOrCreateKotlinClass(OfflineDomainError.PreviewDownloadFailed.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype62, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype63 = polymorphicJsonAdapterFactoryWithSubtype62.withSubtype(OfflineDomainError.BothDownloadOptionsNotAvailable.class, Reflection.getOrCreateKotlinClass(OfflineDomainError.BothDownloadOptionsNotAvailable.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype63, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype64 = polymorphicJsonAdapterFactoryWithSubtype63.withSubtype(OfflineDomainError.RunningInfoNotAvailable.class, Reflection.getOrCreateKotlinClass(OfflineDomainError.RunningInfoNotAvailable.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype64, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype65 = polymorphicJsonAdapterFactoryWithSubtype64.withSubtype(OfflineDomainError.TempFileDoesNotExist.class, Reflection.getOrCreateKotlinClass(OfflineDomainError.TempFileDoesNotExist.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype65, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype66 = polymorphicJsonAdapterFactoryWithSubtype65.withSubtype(OfflineDomainError.NoDownloadPermission.class, Reflection.getOrCreateKotlinClass(OfflineDomainError.NoDownloadPermission.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype66, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype67 = polymorphicJsonAdapterFactoryWithSubtype66.withSubtype(OfflineDomainError.NoPreviewPermission.class, Reflection.getOrCreateKotlinClass(OfflineDomainError.NoPreviewPermission.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype67, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype68 = polymorphicJsonAdapterFactoryWithSubtype67.withSubtype(OfflineDomainError.UnsupportedFileExtensionForPreview.class, Reflection.getOrCreateKotlinClass(OfflineDomainError.UnsupportedFileExtensionForPreview.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype68, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype69 = polymorphicJsonAdapterFactoryWithSubtype68.withSubtype(OfflineDomainError.BoxCanvasCannotBeOfflined.class, Reflection.getOrCreateKotlinClass(OfflineDomainError.BoxCanvasCannotBeOfflined.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype69, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype70 = polymorphicJsonAdapterFactoryWithSubtype69.withSubtype(OfflineDomainError.WatermarkedVideosCannotBeOfflined.class, Reflection.getOrCreateKotlinClass(OfflineDomainError.WatermarkedVideosCannotBeOfflined.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype70, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype71 = polymorphicJsonAdapterFactoryWithSubtype70.withSubtype(AdminSettingsDomainError.PreviewOnlyOffliningDisabled.class, Reflection.getOrCreateKotlinClass(AdminSettingsDomainError.PreviewOnlyOffliningDisabled.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype71, "withErrorSubtype(...)");
            PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactoryWithSubtype72 = polymorphicJsonAdapterFactoryWithSubtype71.withSubtype(AdminSettingsDomainError.SavingOnDeviceDisabled.class, Reflection.getOrCreateKotlinClass(AdminSettingsDomainError.SavingOnDeviceDisabled.class).getQualifiedName());
            Intrinsics.checkNotNullExpressionValue(polymorphicJsonAdapterFactoryWithSubtype72, "withErrorSubtype(...)");
            Moshi.Builder builderAdd2 = builderAdd.add((JsonAdapter.Factory) polymorphicJsonAdapterFactoryWithSubtype72.withSubtype(AdminSettingsDomainError.EncryptedDeviceRequired.class, Reflection.getOrCreateKotlinClass(AdminSettingsDomainError.EncryptedDeviceRequired.class).getQualifiedName()));
            Intrinsics.checkNotNullExpressionValue(builderAdd2, "add(...)");
            return builderAdd2;
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        JsonAdapter<ItemId> jsonAdapterAdapter = new Moshi.Builder().add((JsonAdapter.Factory) PolymorphicJsonAdapterFactory.of(ItemId.class, "className").withSubtype(ItemId.Local.class, Reflection.getOrCreateKotlinClass(ItemId.Local.class).getQualifiedName()).withSubtype(ItemId.Remote.class, Reflection.getOrCreateKotlinClass(ItemId.Remote.class).getQualifiedName())).add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build().adapter(ItemId.class);
        itemIdAdapter = jsonAdapterAdapter;
        itemAdapter = new Moshi.Builder().add(ItemId.class, jsonAdapterAdapter).add(Date.class, new Rfc3339DateJsonAdapter()).add((JsonAdapter.Factory) PolymorphicJsonAdapterFactory.of(ItemModel.class, "className").withSubtype(FileModel.class, Reflection.getOrCreateKotlinClass(FileModel.class).getQualifiedName()).withSubtype(FolderModel.class, Reflection.getOrCreateKotlinClass(FolderModel.class).getQualifiedName()).withSubtype(UnknownItemModel.class, Reflection.getOrCreateKotlinClass(UnknownItemModel.class).getQualifiedName()).withSubtype(WebLinkModel.class, Reflection.getOrCreateKotlinClass(WebLinkModel.class).getQualifiedName())).add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build().adapter(ItemModel.class);
        jobErrorAdapter = companion.appendTo(new Moshi.Builder()).add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build().adapter(DomainError.class);
    }

    public final String toString(DomainError jobError) {
        DomainError.CachedDomainError cachedDomainError = jobError instanceof DomainError.CachedDomainError ? (DomainError.CachedDomainError) jobError : null;
        if (cachedDomainError != null) {
            return jobErrorAdapter.toJson(cachedDomainError.getError());
        }
        return jobErrorAdapter.toJson(jobError);
    }

    public final DomainError fromString(String value) {
        if (value != null) {
            return jobErrorAdapter.fromJson(value);
        }
        return null;
    }
}
