package com.box.android.browse.cpl.browse.fab;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import com.box.android.base.analytics.UploadAnalyticsUtils;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.base.presentation.activities.BoxFragmentActivity;
import com.box.android.base.presentation.fragments.BottomSheetMenuFragment;
import com.box.android.browse.R;
import com.box.android.browse.cpl.browse.fab.newfile.NewFileMenuFragment;
import com.box.android.common.utilities.OSPermissionUtils;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.mappers.FolderModelMapper;
import com.box.android.domain.models.NewNoteLocation;
import com.box.android.domain.models.NoteCreationError;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.domain.usecases.notes.NewNoteData;
import com.box.android.domain.usecases.notes.ResolveNewNoteDataUseCase;
import com.box.android.domain.utils.result.Result;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.intune.mam.client.app.ui.MAMUIHelper;
import com.microsoft.intune.mam.policy.OpenLocation;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FabManager.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ \u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u001e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FabManager;", "", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "resolveNewNoteDataUseCase", "Lcom/box/android/domain/usecases/notes/ResolveNewNoteDataUseCase;", "<init>", "(Lcom/box/android/coreservices/services/IntentServices;Lcom/box/android/domain/configuration/FeatureFlips;Lcom/box/android/domain/usecases/notes/ResolveNewNoteDataUseCase;)V", "handleNewFolderClick", "Lcom/box/android/browse/cpl/browse/fab/FabMenuOptionResult;", "currentFolder", "Lcom/box/android/domain/models/item/FolderModel;", "activity", "Landroid/app/Activity;", "handleNewDocumentClick", "isHandlingLegacy", "", "handleNewBoxNoteClick", FirebaseAnalytics.Param.LOCATION, "Lcom/box/android/domain/models/NewNoteLocation;", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", "handleUploadContentClicked", "Lcom/box/android/browse/cpl/browse/fab/FabMenuUploadContentOptionResult;", "handleCaptureMediaClicked", "Lcom/box/android/browse/cpl/browse/fab/FabMenuCaptureMediaOptionResult;", "sendFABPageExitedAnalytics", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FabManager {
    public static final int $stable = 8;
    private final FeatureFlips featureFlips;
    private final IntentServices intentServices;
    private final ResolveNewNoteDataUseCase resolveNewNoteDataUseCase;

    @Inject
    public FabManager(IntentServices intentServices, FeatureFlips featureFlips, ResolveNewNoteDataUseCase resolveNewNoteDataUseCase) {
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(resolveNewNoteDataUseCase, "resolveNewNoteDataUseCase");
        this.intentServices = intentServices;
        this.featureFlips = featureFlips;
        this.resolveNewNoteDataUseCase = resolveNewNoteDataUseCase;
    }

    public final FabMenuOptionResult handleNewFolderClick(FolderModel currentFolder, Activity activity) {
        Intrinsics.checkNotNullParameter(currentFolder, "currentFolder");
        Intrinsics.checkNotNullParameter(activity, "activity");
        PermissionsModel permissions = currentFolder.getPermissions();
        if (permissions != null && !permissions.getCanUpload()) {
            BoxPresentationUtils.displayToast(R.string.you_do_not_have_permission_to_create_new_folder_in_this_folder, activity, new String[0]);
            return FabMenuOptionResult.PermissionDenied.INSTANCE;
        }
        UploadAnalyticsUtils.newUploadFlowCtaEventBuilder().setCtaTarget(BoxAnalyticsParams.PAGE_NAME_CREATE_FOLDER).logEvent(BoxAnalyticsParams.EVENT_NEW_FOLDER_FAB_CLICKED);
        return FabMenuOptionResult.Success.INSTANCE;
    }

    public static /* synthetic */ FabMenuOptionResult handleNewDocumentClick$default(FabManager fabManager, FolderModel folderModel, Activity activity, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return fabManager.handleNewDocumentClick(folderModel, activity, z);
    }

    public final FabMenuOptionResult handleNewDocumentClick(FolderModel currentFolder, final Activity activity, boolean isHandlingLegacy) {
        Intrinsics.checkNotNullParameter(currentFolder, "currentFolder");
        Intrinsics.checkNotNullParameter(activity, "activity");
        PermissionsModel permissions = currentFolder.getPermissions();
        if (permissions != null && !permissions.getCanUpload()) {
            BoxPresentationUtils.displayToast(R.string.you_do_not_have_permission_to_upload_to_this_folder, activity, new String[0]);
            return FabMenuOptionResult.PermissionDenied.INSTANCE;
        }
        UploadAnalyticsUtils.newUploadFlowCtaEventBuilder().setCtaTarget(BoxAnalyticsParams.PAGE_NAME_NEW_DOCUMENT).logEvent(BoxAnalyticsParams.EVENT_NEW_DOCUMENT_CLICKED);
        if (isHandlingLegacy && (activity instanceof BoxFragmentActivity)) {
            NewFileMenuFragment.newInstance(activity, FolderModelMapper.toBoxFolder$default(FolderModelMapper.INSTANCE, currentFolder, false, 1, null)).setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.box.android.browse.cpl.browse.fab.FabManager$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    FabManager.handleNewDocumentClick$lambda$0(activity, dialogInterface);
                }
            }).show(((BoxFragmentActivity) activity).getSupportFragmentManager(), BottomSheetMenuFragment.TAG);
        }
        return FabMenuOptionResult.Success.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleNewDocumentClick$lambda$0(Activity activity, DialogInterface dialogInterface) {
        ((BoxFragmentActivity) activity).amplitudeSetCurrentPage();
    }

    public final FabMenuOptionResult handleNewBoxNoteClick(NewNoteLocation location, PreviewSource previewSource, Activity activity) {
        Intent intentCreateDocumentTaskIntent;
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(previewSource, "previewSource");
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.featureFlips.getNewNoteCreationFlow().getEnabled()) {
            intentCreateDocumentTaskIntent = this.intentServices.quickNoteCreationIntent(activity, location, previewSource);
        } else {
            Result<NewNoteData, NoteCreationError> resultInvoke = this.resolveNewNoteDataUseCase.invoke(location);
            if (resultInvoke instanceof Result.Success) {
                intentCreateDocumentTaskIntent = this.intentServices.createDocumentTaskIntent(activity, ((NewNoteData) ((Result.Success) resultInvoke).getValue()).getFolderId(), "boxnote.boxnote");
            } else {
                if (resultInvoke instanceof Result.Error) {
                    BoxPresentationUtils.displayToast(R.string.you_do_not_have_permission_to_create_boxnote_in_this_folder, activity, new String[0]);
                    return FabMenuOptionResult.PermissionDenied.INSTANCE;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        sendFABPageExitedAnalytics();
        activity.startActivity(intentCreateDocumentTaskIntent);
        UploadAnalyticsUtils.newUploadFlowCtaEventBuilder().setCtaTarget(BoxAnalyticsParams.PAGE_NAME_BOX_NOTE).logEvent(BoxAnalyticsParams.EVENT_NEW_BOX_NOTE_CLICKED);
        return FabMenuOptionResult.Success.INSTANCE;
    }

    public final FabMenuUploadContentOptionResult handleUploadContentClicked(FolderModel currentFolder, Activity activity) {
        Intrinsics.checkNotNullParameter(currentFolder, "currentFolder");
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!CoreServiceUtils.getIsOpenFromLocationAllowed(OpenLocation.LOCAL, null)) {
            MAMUIHelper.showSharingBlockedDialog(activity);
            return FabMenuUploadContentOptionResult.MAMBlocked.INSTANCE;
        }
        PermissionsModel permissions = currentFolder.getPermissions();
        if (permissions != null && !permissions.getCanUpload()) {
            BoxPresentationUtils.displayToast(R.string.you_do_not_have_permission_to_upload_to_this_folder, activity, new String[0]);
            return FabMenuUploadContentOptionResult.PermissionDenied.INSTANCE;
        }
        if (!OSPermissionUtils.INSTANCE.hasStoragePermission(true)) {
            return FabMenuUploadContentOptionResult.StorageAccessNeeded.INSTANCE;
        }
        sendFABPageExitedAnalytics();
        UploadAnalyticsUtils.newUploadFlowCtaEventBuilder().setCtaTarget(BoxAnalyticsParams.PAGE_NAME_UPLOAD_CONTENT).logEvent(BoxAnalyticsParams.EVENT_UPLOAD_CONTENT_FAB_CLICKED);
        return FabMenuUploadContentOptionResult.Success.INSTANCE;
    }

    public final FabMenuCaptureMediaOptionResult handleCaptureMediaClicked(FolderModel currentFolder, Activity activity) {
        Intrinsics.checkNotNullParameter(currentFolder, "currentFolder");
        Intrinsics.checkNotNullParameter(activity, "activity");
        PermissionsModel permissions = currentFolder.getPermissions();
        if (permissions != null && !permissions.getCanUpload()) {
            BoxPresentationUtils.displayToast(R.string.you_do_not_have_permission_to_upload_to_this_folder, activity, new String[0]);
            return FabMenuCaptureMediaOptionResult.PermissionDenied.INSTANCE;
        }
        if (!OSPermissionUtils.INSTANCE.hasStoragePermission(true)) {
            return FabMenuCaptureMediaOptionResult.StorageAccessNeeded.INSTANCE;
        }
        sendFABPageExitedAnalytics();
        activity.startActivity(this.intentServices.captureMediaIntent(activity, currentFolder));
        UploadAnalyticsUtils.newUploadFlowCtaEventBuilder().setCtaTarget(BoxAnalyticsParams.PAGE_NAME_CAPTURE_PAGE).logEvent(BoxAnalyticsParams.EVENT_CAPTURE_CTA_TRIGGERED);
        return FabMenuCaptureMediaOptionResult.Success.INSTANCE;
    }

    private final void sendFABPageExitedAnalytics() {
        BoxAmplitudeAnalytics.createEventBuilder().setFlow(BoxAnalyticsParams.FLOW_UPLOAD).setTimeOnPage().logEvent(BoxAnalyticsParams.EVENT_FAB_PAGE_EXITED);
    }
}
