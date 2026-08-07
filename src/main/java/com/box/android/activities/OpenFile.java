package com.box.android.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.application.BoxBaseApplication;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.base.presentation.activities.IntentChooserActivity;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.modelcontroller.BoxFutureTask;
import com.box.android.coreservices.modelcontroller.BoxTransferFutureTask;
import com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers;
import com.box.android.coreservices.modelcontroller.messages.BoxDownloadFileMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.models.BoxAccountManager;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.domain.exceptions.PermissionDeniedException;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.domain.utils.MimeTypeHelper;
import com.box.android.localrepo.LocalFiles;
import com.box.android.services.BoxAsyncTask;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes9.dex */
public class OpenFile extends Hilt_OpenFile {
    private static final String EXTRA_LAUNCH_INTENT = "launchIntent";
    private static final int FILE_INFO_REQUEST_TIME_OUT_MS = 10000;
    private DLTask dlTask;
    private String mId;
    private View mLayoutContainer;

    @Inject
    IMoCoBoxTransfers mMoCoBoxTransfers;
    private ProgressBar pBar;

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    public static Intent createIntent(Context context, BoxFile boxFile, Intent intent) {
        Intent intent2 = new Intent(context, (Class<?>) OpenFile.class);
        intent2.putExtra("fileId", boxFile.getUserId());
        intent2.putExtra(BoxCommonConstants.EXTRA_FILE_NAME, boxFile.getName());
        intent2.putExtra(EXTRA_LAUNCH_INTENT, intent);
        return intent2;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        if (!BoxAccountManager.isMobileOpenInEnabled(this.mUserContextManager)) {
            BoxPresentationUtils.displayToast(R.string.This_feature_has_been_disabled_by_your_administrator, this, new String[0]);
            finish();
            return;
        }
        this.mId = getIntent().getStringExtra("fileId");
        String stringExtra = getIntent().getStringExtra(BoxCommonConstants.EXTRA_FILE_NAME);
        setContentView(R.layout.dialog_upload_prog);
        this.mLayoutContainer = findViewById(R.id.dialog_container);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_horizontal);
        this.pBar = progressBar;
        progressBar.setIndeterminate(true);
        System.setProperty("http.keepAlive", "false");
        ((TextView) findViewById(R.id.load_name)).setText(getString(R.string.verify_item_permissions, new Object[]{stringExtra}));
        DLTask dLTask = new DLTask();
        this.dlTask = dLTask;
        dLTask.execute(new Void[0]);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void handleOnActivityResult(int i, int i2, Intent intent) {
        if (i == 294) {
            if (intent != null) {
                this.mUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.PREFERRED_PACKAGE_FOR_MIME_TYPE).edit().putString(this.dlTask._mimeType, intent.getPackage()).commit();
            }
            finish();
        }
        super.handleOnActivityResult(i, i2, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        DLTask dLTask = this.dlTask;
        if (dLTask != null) {
            dLTask.cancel(true);
        }
        finish();
        super.onBackPressed();
    }

    private class DLTask extends BoxAsyncTask<Void, Void, File> {
        String _mimeType;
        private BoxFile boxFile;
        private long bytesDownloaded;
        private int error;
        private boolean isError;
        private ProgressReporter.FileTransferProgressListener mProgressListener;
        private BoxFutureTask<BoxDownloadFileMessage> mTransferTask;

        private DLTask() {
            this.isError = false;
            this.error = R.string.err_unknown;
            this.mProgressListener = new ProgressReporter.FileTransferProgressListener() { // from class: com.box.android.activities.OpenFile.DLTask.1
                @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.FileTransferProgressListener
                public void setBytesTransferred(long j) {
                    super.setBytesTransferred(j);
                    DLTask.this.bytesDownloaded = j;
                    OpenFile.this.runOnUiThread(new Runnable() { // from class: com.box.android.activities.OpenFile.DLTask.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            DLTask.this.onProgressUpdate(new Void[0]);
                        }
                    });
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.box.android.services.BoxAsyncTask
        public void onPostExecute(File file) {
            if (file == null || this.isError) {
                BoxPresentationUtils.displayToast(this.error, BoxBaseApplication.getInstance().getApplicationContext(), new String[0]);
                OpenFile.this.finish();
                return;
            }
            try {
                String absolutePath = file.getAbsolutePath();
                String lowerCase = absolutePath.substring(absolutePath.lastIndexOf(".") + 1).toLowerCase(Locale.US);
                this._mimeType = MimeTypeHelper.getTypeFromExt(lowerCase);
                String string = OpenFile.this.mUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.PREFERRED_PACKAGE_FOR_MIME_TYPE).getString(this._mimeType, null);
                ArrayList<String> promotedPartnerApps = MimeTypeHelper.getPromotedPartnerApps(lowerCase, OpenFile.this.getApplicationContext());
                if (promotedPartnerApps != null && promotedPartnerApps.size() > 0 && SdkUtils.isBlank(string)) {
                    OpenFile.this.mLayoutContainer.setVisibility(8);
                    Intent openIntent = CoreServiceUtils.getOpenIntent(OpenFile.this, file, this._mimeType);
                    OpenFile openFile = OpenFile.this;
                    openFile.startActivityForResult(IntentChooserActivity.newInstance(openFile, openIntent, promotedPartnerApps), BoxCommonConstants.REQUEST_OPEN_FILE);
                    return;
                }
                OpenFile.this.startActivity(CoreServiceUtils.getOpenIntent(OpenFile.this, file, this._mimeType));
                OpenFile.this.finish();
            } catch (Exception e) {
                BoxLogUtils.logException(getClass().getName(), e);
                BoxPresentationUtils.displayToast(R.string.err_app, BoxBaseApplication.getInstance().getApplicationContext(), new String[0]);
                OpenFile.this.finish();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.box.android.services.BoxAsyncTask
        public void onProgressUpdate(Void... voidArr) {
            if (OpenFile.this.pBar.isIndeterminate()) {
                OpenFile.this.pBar.setIndeterminate(false);
            }
            OpenFile.this.pBar.setMax(this.boxFile.getSize().intValue());
            OpenFile.this.pBar.setProgress((int) this.bytesDownloaded);
        }

        @Override // com.box.android.services.BoxAsyncTask
        protected void onCancelled() {
            BoxFutureTask<BoxDownloadFileMessage> boxFutureTask = this.mTransferTask;
            if (boxFutureTask != null) {
                boxFutureTask.cancel(true);
            }
            super.onCancelled();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.box.android.services.BoxAsyncTask
        public File doInBackground(Void... voidArr) {
            this.isError = true;
            try {
                BoxFile boxFile = (BoxFile) OpenFile.this.mBaseMoco.performRemote(OpenFile.this.mBoxExtendedApiFile.getInfoRequest(OpenFile.this.mId).setTimeOut(10000), null).get().getResult();
                this.boxFile = boxFile;
                if (!boxFile.getPermissions().contains(BoxItem.Permission.CAN_DOWNLOAD)) {
                    throw new PermissionDeniedException();
                }
            } catch (Exception e) {
                BoxLogUtils.logException(e);
                if (e instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                if (e instanceof PermissionDeniedException) {
                    this.error = R.string.permission_denied_general;
                    this.mProgressListener.onError(e);
                    return null;
                }
            }
            if (this.boxFile == null) {
                try {
                    BoxFile boxFile2 = (BoxFile) OpenFile.this.mBaseMoco.performLocal(OpenFile.this.mBoxExtendedApiFile.getInfoRequest(OpenFile.this.mId)).get().getResult();
                    this.boxFile = boxFile2;
                    if (boxFile2 == null) {
                        return null;
                    }
                } catch (Exception e2) {
                    BoxLogUtils.logException(e2);
                    if (e2 instanceof InterruptedException) {
                        Thread.currentThread().interrupt();
                    }
                    return null;
                }
            }
            OpenFile.this.runOnUiThread(new Runnable() { // from class: com.box.android.activities.OpenFile.DLTask.2
                @Override // java.lang.Runnable
                public void run() {
                    ((TextView) OpenFile.this.findViewById(R.id.load_name)).setText(OpenFile.this.getString(R.string.downloading_item, new Object[]{DLTask.this.boxFile.getName()}));
                }
            });
            File file = new File("/non_existent_temp_folder/", this.boxFile.getName());
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(file), MimeTypeHelper.getTypeFromExt(CommonBoxUtil.getFileExtension(this.boxFile.getName(), "")));
            if (!CommonBoxUtil.isIntentAvailable(OpenFile.this.getApplicationContext(), intent)) {
                this.isError = false;
                return file;
            }
            try {
                BoxTransferFutureTask<BoxDownloadFileMessage> boxTransferFutureTaskMakeWorkingFile = OpenFile.this.mMoCoBoxTransfers.makeWorkingFile(this.boxFile, this.mProgressListener);
                this.mTransferTask = boxTransferFutureTaskMakeWorkingFile;
                BoxDownloadFileMessage boxDownloadFileMessageRunAndGet = boxTransferFutureTaskMakeWorkingFile.runAndGet();
                if (boxDownloadFileMessageRunAndGet.wasSuccessful()) {
                    this.isError = false;
                    ((LocalFiles) OpenFile.this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_FILES)).getDownloads().registerFileObserver(this.boxFile, OpenFile.this.mMoCoBoxTransfers, OpenFile.this.mBaseMoco, OpenFile.this.mBoxExtendedApiFile);
                    return boxDownloadFileMessageRunAndGet.getJavaFilePayload();
                }
                this.error = boxDownloadFileMessageRunAndGet.getErrorStringRId(BoxMessage.Scenario.OPEN_FILE, R.string.err_file_open_offline, R.string.err_unknown);
                return null;
            } catch (InterruptedException e3) {
                Thread.currentThread().interrupt();
                BoxLogUtils.logException(e3);
            } catch (ExecutionException e4) {
                BoxLogUtils.logException(e4);
            }
        }
    }
}
