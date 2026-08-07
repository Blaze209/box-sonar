package com.box.android.browse.activities;

import android.os.Handler;
import androidx.appcompat.app.AlertDialog;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.browse.R;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.jobmanager.dao.BoxUploadFile;
import com.box.android.coreservices.jobmanager.dao.UploadModelBoxFile;
import com.box.android.coreservices.models.BoxStaticUploadModel;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UploadToFolderActivity.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/box/android/browse/activities/UploadToFolderActivity$tryUpload$t$1", "Ljava/lang/Thread;", "run", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UploadToFolderActivity$tryUpload$t$1 extends Thread {
    final /* synthetic */ UploadToFolderActivity this$0;

    UploadToFolderActivity$tryUpload$t$1(UploadToFolderActivity uploadToFolderActivity) {
        this.this$0 = uploadToFolderActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            Long maxUploadSize = this.this$0.getUserInfo().getMaxUploadSize();
            Intrinsics.checkNotNullExpressionValue(maxUploadSize, "getMaxUploadSize(...)");
            ArrayList<UploadModelBoxFile> overUploadLimitFiles = BoxStaticUploadModel.getOverUploadLimitFiles(maxUploadSize.longValue(), this.this$0.mUserContextManager);
            final ArrayList<UploadModelBoxFile> nameConflicts = BoxStaticUploadModel.getNameConflicts(this.this$0.getMBoxFolderApi(), this.this$0.getMBaseModelController());
            ArrayList<UploadModelBoxFile> erroredFiles = BoxStaticUploadModel.getErroredFiles(this.this$0.mUserContextManager);
            boolean z = BoxStaticUploadModel.getCurrentFolder().getOwnedBy() != null && Intrinsics.areEqual(BoxStaticUploadModel.getCurrentFolder().getOwnedBy().getUserId(), this.this$0.getUserInfo().getUserId());
            if (overUploadLimitFiles.size() > 0 && z) {
                Handler handler = this.this$0.mHandler;
                final UploadToFolderActivity uploadToFolderActivity = this.this$0;
                handler.post(new Runnable() { // from class: com.box.android.browse.activities.UploadToFolderActivity$tryUpload$t$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        UploadToFolderActivity$tryUpload$t$1.run$lambda$0(uploadToFolderActivity);
                    }
                });
                this.this$0.broadcastDismissSpinner();
                return;
            }
            if (overUploadLimitFiles.size() > 0) {
                Iterator<UploadModelBoxFile> it = overUploadLimitFiles.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    it.next().setEnabledStatus(true);
                }
            }
            if (erroredFiles.size() > 0) {
                Handler handler2 = this.this$0.mHandler;
                final UploadToFolderActivity uploadToFolderActivity2 = this.this$0;
                handler2.post(new Runnable() { // from class: com.box.android.browse.activities.UploadToFolderActivity$tryUpload$t$1$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        UploadToFolderActivity$tryUpload$t$1.run$lambda$1(uploadToFolderActivity2);
                    }
                });
                this.this$0.broadcastDismissSpinner();
                return;
            }
            if (nameConflicts.size() == 0) {
                BoxStaticUploadModel.doUpload(BoxUploadFile.ConflictResolution.FAIL, this.this$0.getMBaseModelController(), this.this$0.getMBoxFileApi(), this.this$0.mUserContextManager, this.this$0.jobSource, this.this$0.getMLocalItemService());
                this.this$0.broadcastDismissSpinner();
                this.this$0.setResult(-1);
                this.this$0.finish();
                return;
            }
            StringBuilder sb = new StringBuilder();
            Iterator<UploadModelBoxFile> it2 = nameConflicts.iterator();
            Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
            int i = 0;
            int i2 = 0;
            while (it2.hasNext()) {
                UploadModelBoxFile next = it2.next();
                if (next.isExistingNameConflict()) {
                    if (i < 5) {
                        if (i > 0) {
                            sb.append(", ");
                        }
                        String fileName = next.getFileName();
                        if (fileName.length() > 10) {
                            String fileName2 = next.getFileName();
                            Intrinsics.checkNotNullExpressionValue(fileName2, "getFileName(...)");
                            String strSubstring = fileName2.substring(0, 10);
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                            fileName = strSubstring + "...";
                        }
                        sb.append("\"").append(fileName).append("\"");
                    }
                    i++;
                }
                if (next.isInvalidNameConflict()) {
                    i2++;
                    next.setEnabledStatus(false);
                }
            }
            if (i > 0) {
                sb = new StringBuilder(CommonBoxUtil.quantity(R.plurals.There_are_x_files, i, sb.toString()));
            }
            if (i2 > 0) {
                BoxPresentationUtils.displayToast(CommonBoxUtil.pluralFormat(R.array.There_are_x_files9, i2), ApplicationProvider.getApplication().getApplicationContext());
                if (i <= 0) {
                    BoxStaticUploadModel.doUpload(BoxUploadFile.ConflictResolution.FAIL, this.this$0.getMBaseModelController(), this.this$0.getMBoxFileApi(), this.this$0.mUserContextManager, this.this$0.jobSource, this.this$0.getMLocalItemService());
                    this.this$0.broadcastDismissSpinner();
                    this.this$0.setResult(-1);
                    this.this$0.finish();
                    return;
                }
            }
            final String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            Handler handler3 = this.this$0.mHandler;
            final UploadToFolderActivity uploadToFolderActivity3 = this.this$0;
            handler3.post(new Runnable() { // from class: com.box.android.browse.activities.UploadToFolderActivity$tryUpload$t$1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    UploadToFolderActivity$tryUpload$t$1.run$lambda$2(uploadToFolderActivity3, nameConflicts, string);
                }
            });
            this.this$0.broadcastDismissSpinner();
        } catch (Exception e) {
            BoxLogUtils.logException(e);
            this.this$0.mNotificationServices.displayToast(CommonBoxUtil.LS(R.string.err_unknown), this.this$0);
            this.this$0.broadcastDismissSpinner();
            this.this$0.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void run$lambda$0(UploadToFolderActivity uploadToFolderActivity) {
        AlertDialog alertDialogCreateFileErrorAlert = UploadToFolderActivity.INSTANCE.createFileErrorAlert(uploadToFolderActivity, CommonBoxUtil.LS(R.string.LS__Some_files_can), CommonBoxUtil.LS(R.string.Some_files_exceed_your_upload_file_size_limit));
        if (uploadToFolderActivity.isActivityResumed()) {
            alertDialogCreateFileErrorAlert.setOnDismissListener(uploadToFolderActivity.mPartialErrorListener);
            alertDialogCreateFileErrorAlert.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void run$lambda$1(UploadToFolderActivity uploadToFolderActivity) {
        AlertDialog alertDialogCreateFileErrorAlert = UploadToFolderActivity.INSTANCE.createFileErrorAlert(uploadToFolderActivity, CommonBoxUtil.LS(R.string.LS__Some_files_can), CommonBoxUtil.LS(R.string.LS_Some_files_cann));
        if (uploadToFolderActivity.isActivityResumed()) {
            alertDialogCreateFileErrorAlert.setOnDismissListener(uploadToFolderActivity.mPartialErrorListener);
            alertDialogCreateFileErrorAlert.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void run$lambda$2(UploadToFolderActivity uploadToFolderActivity, ArrayList arrayList, String str) {
        String strPluralFormat = CommonBoxUtil.pluralFormat(R.array.x_Name_Conflicts, arrayList.size());
        Intrinsics.checkNotNull(arrayList);
        AlertDialog alertDialogCreateFileNameConflictAlert = uploadToFolderActivity.createFileNameConflictAlert(uploadToFolderActivity, strPluralFormat, str, arrayList);
        if (uploadToFolderActivity.isActivityResumed()) {
            alertDialogCreateFileNameConflictAlert.show();
            alertDialogCreateFileNameConflictAlert.setCanceledOnTouchOutside(false);
        }
    }
}
