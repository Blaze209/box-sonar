package com.box.android.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.base.presentation.views.OKCancelView;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.dao.UploadModelBoxFile;
import com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers;
import com.box.android.coreservices.modelcontroller.messages.BoxFileTransferMessage;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.io.File;
import java.util.concurrent.ExecutionException;
import org.apache.commons.io.FileUtils;

/* JADX INFO: loaded from: classes9.dex */
public class UploadOverwriteDialogActivity extends Hilt_UploadOverwriteDialogActivity {
    private static final String EXTRA_BOX_FILE = "extraBoxFile";
    private static final String EXTRA_FILE_NAME = "extraFileName";
    private static final String EXTRA_FILE_PATH = "extraFilePath";

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return Integer.valueOf(R.layout.layout_dialog_confirm);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        Intent intent = getIntent();
        BoxFile boxFile = (BoxFile) intent.getSerializableExtra(EXTRA_BOX_FILE);
        File file = new File(intent.getStringExtra(EXTRA_FILE_PATH));
        String stringExtra = intent.getStringExtra(EXTRA_FILE_NAME);
        TextView textView = (TextView) findViewById(R.id.dialog_title);
        ((TextView) findViewById(R.id.dialog_text)).setText(R.string.newer_version_uploaded_confirm_overwrite);
        textView.setText(R.string.newer_version_available);
        ((OKCancelView) findViewById(R.id.okCancelView)).setOnClickListener(new AnonymousClass1(boxFile, stringExtra, file));
    }

    /* JADX INFO: renamed from: com.box.android.activities.UploadOverwriteDialogActivity$1, reason: invalid class name */
    class AnonymousClass1 implements OKCancelView.OKCancelClickListener {
        final /* synthetic */ BoxFile val$boxFile;
        final /* synthetic */ File val$file;
        final /* synthetic */ String val$fileName;

        AnonymousClass1(BoxFile boxFile, String str, File file) {
            this.val$boxFile = boxFile;
            this.val$fileName = str;
            this.val$file = file;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [com.box.android.activities.UploadOverwriteDialogActivity$1$1] */
        @Override // com.box.android.base.presentation.views.OKCancelView.OKCancelClickListener
        public void onOKClicked() {
            UploadOverwriteDialogActivity.this.showSpinner(CommonBoxUtil.LS(R.string.please_wait_dot_dot_dot));
            new Thread() { // from class: com.box.android.activities.UploadOverwriteDialogActivity.1.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    final String strLS;
                    try {
                        if (((BoxFileTransferMessage) UploadOverwriteDialogActivity.this.mTransfersModelController.uploadFileNewVersion(AnonymousClass1.this.val$boxFile, AnonymousClass1.this.val$fileName, new UploadModelBoxFile.UriFile(AnonymousClass1.this.val$file), false, false, IMoCoBoxTransfers.TransferSourceType.DOCUMENT_PROVIDER, new ProgressReporter.FileTransferProgressListener(), UploadOverwriteDialogActivity.this.mBoxExtendedApiFile, null, -1, -1L).runAndGet()).wasSuccessful()) {
                            strLS = CommonBoxUtil.LS(R.string.upload_completed_successfully);
                        } else {
                            strLS = CommonBoxUtil.LS(R.string.unable_to_upload_try_again_later);
                        }
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.box.android.activities.UploadOverwriteDialogActivity.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Toast.makeText(UploadOverwriteDialogActivity.this, strLS, 1).show();
                            }
                        });
                    } catch (InterruptedException e) {
                        BoxLogUtils.logException(e);
                        Thread.currentThread().interrupt();
                    } catch (ExecutionException e2) {
                        BoxLogUtils.logException(e2);
                    } finally {
                        FileUtils.deleteQuietly(AnonymousClass1.this.val$file);
                        UploadOverwriteDialogActivity.this.finish();
                    }
                }
            }.start();
        }

        @Override // com.box.android.base.presentation.views.OKCancelView.OKCancelClickListener
        public void onCancelClicked() {
            UploadOverwriteDialogActivity.this.finish();
        }
    }

    public static Intent createLaunchIntent(Context context, BoxFile boxFile, String str, String str2) {
        Intent intent = new Intent(context, (Class<?>) UploadOverwriteDialogActivity.class);
        intent.putExtra(EXTRA_BOX_FILE, boxFile);
        intent.putExtra(EXTRA_FILE_PATH, str);
        intent.putExtra(EXTRA_FILE_NAME, str2);
        return intent;
    }
}
