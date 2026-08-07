package com.box.android.domain.models;

import com.box.android.common.utilities.CommonBoxUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JobInfoProviders.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u0004\u001a\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u0004\u001a\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0007"}, d2 = {"getFileDownloadErrorStringRes", "", "error", "Lcom/box/android/domain/models/DomainError;", "(Lcom/box/android/domain/models/DomainError;)Ljava/lang/Integer;", "getOfflineErrorStringRes", "getFileUploadErrorStringRes", "domain_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class JobInfoProvidersKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x000e  */
    public static final Integer getFileDownloadErrorStringRes(DomainError domainError) {
        String str;
        if (domainError instanceof DownloadFileDomainError.TargetFileCreationError) {
            str = "download_job_file_creation_error";
        } else if (domainError instanceof DownloadFileDomainError.FileSha1VerificationFailed) {
            str = "download_job_generic_error";
        } else if (domainError instanceof DownloadFileDomainError.TargetLocationNotFound) {
            str = "download_job_location_not_found";
        } else if ((domainError instanceof DownloadFileDomainError.FileToDownloadNotFound) || (domainError instanceof DownloadFileDomainError.PartialDownloadError) || (domainError instanceof DomainError.CacheReadError)) {
            str = "download_job_generic_error";
        } else {
            str = null;
        }
        if (str != null) {
            return Integer.valueOf(CommonBoxUtil.getStringResIdByName(str));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer getOfflineErrorStringRes(DomainError domainError) {
        String str;
        if (domainError instanceof OfflineDomainError.BoxNotesCannotBeOfflined) {
            str = "offline_job_box_notes_error";
        } else if (domainError instanceof OfflineDomainError.OffliningDisabledByAdministrator) {
            str = "offline_job_admin_disabled_error";
        } else if (domainError instanceof OfflineDomainError.MissingFilePermissions) {
            str = "offline_job_missing_permissions_error";
        } else if (domainError instanceof OfflineDomainError.InsufficientPermissionsToOffline) {
            str = "offline_job_insufficient_permissions_error";
        } else if (domainError instanceof OfflineDomainError.DownloadingOriginalFileFailed) {
            str = "offline_job_download_failed_error";
        } else if (domainError instanceof OfflineDomainError.FailedToRenameTempFile) {
            str = "offline_job_rename_temp_file_error";
        } else if (domainError instanceof OfflineDomainError.FailedToFindDownloadedFile) {
            str = "offline_job_find_downloaded_file_error";
        } else if (domainError instanceof OfflineDomainError.MissingParentPath) {
            str = "offline_job_missing_parent_path_error";
        } else if (domainError instanceof OfflineDomainError.NoDownloadPermission) {
            str = "offline_job_no_download_permission_error";
        } else if (domainError instanceof OfflineDomainError.NoPreviewPermission) {
            str = "offline_job_no_preview_permission_error";
        } else if (domainError instanceof OfflineDomainError.UnsupportedFileExtensionForPreview) {
            str = "offline_job_unsupported_extension_error";
        } else if (domainError instanceof OfflineDomainError.BoxCanvasCannotBeOfflined) {
            str = "offline_job_canvas_cannot_be_offlined_error";
        } else if (domainError instanceof OfflineDomainError.WatermarkedVideosCannotBeOfflined) {
            str = "offline_job_watermarked_videos_error";
        } else if (domainError instanceof AdminSettingsDomainError.PreviewOnlyOffliningDisabled) {
            str = "offline_job_preview_only_disabled_error";
        } else if (domainError instanceof AdminSettingsDomainError.EncryptedDeviceRequired) {
            str = "offline_job_device_encryption_error";
        } else {
            str = domainError instanceof AdminSettingsDomainError.SavingOnDeviceDisabled ? "offline_job_save_on_device_disabled" : null;
        }
        if (str != null) {
            return Integer.valueOf(CommonBoxUtil.getStringResIdByName(str));
        }
        return null;
    }

    public static final Integer getFileUploadErrorStringRes(DomainError error) {
        String str;
        Intrinsics.checkNotNullParameter(error, "error");
        if (error instanceof FileUploadDomainError.SourceOrDestNotFound) {
            str = "The_source_or_destination_does_not_exist";
        } else if (error instanceof FileUploadDomainError.AccessDeniedError) {
            str = "upload_job_permissions_error";
        } else if ((error instanceof FileUploadDomainError.FileSizeLimitError) || (error instanceof FileUploadDomainError.InsufficientStorageError) || (error instanceof FileUploadDomainError.AccountSpaceError)) {
            str = "job_item_error_type_exceeds_upload_limit";
        } else if ((error instanceof CreateFolderDomainError.ItemNameTooLong) || (error instanceof CreateFolderDomainError.InvalidName)) {
            str = "folder_create_error_invalid_name";
        } else if (error instanceof DomainError.NameConflict) {
            str = "LS_A_file_is_alrea";
        } else if (error instanceof CreateFolderDomainError.OperationBlockedTemporary) {
            str = "folder_create_error_generic";
        } else {
            str = error instanceof DomainError.StoragePermissionMissing ? "job_item_error_type_os_permission" : null;
        }
        if (str != null) {
            return Integer.valueOf(CommonBoxUtil.getStringResIdByName(str));
        }
        return null;
    }
}
