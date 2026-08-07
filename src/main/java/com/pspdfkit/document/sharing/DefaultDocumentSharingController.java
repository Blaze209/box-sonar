package com.pspdfkit.document.sharing;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.pspdfkit.R;
import com.pspdfkit.document.processor.PdfProcessor;
import com.pspdfkit.internal.cx;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.uw;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.disposables.Disposable;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultDocumentSharingController extends DocumentSharingController {
    private static final long SHOW_PROGRESS_DIALOG_DELAY_MS = 100;
    private final String LOG_TAG;
    private final Handler handler;
    private cx progressDialog;
    private final ShareAction shareAction;
    private final ShareTarget shareTarget;
    private Runnable showProgressDialogRunnable;

    public DefaultDocumentSharingController(Context context) {
        this(context, ShareAction.SEND);
    }

    private void hideProgressDialog() {
        Runnable runnable = this.showProgressDialogRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
            this.showProgressDialogRunnable = null;
        }
        cx cxVar = this.progressDialog;
        if (cxVar != null) {
            cxVar.dismiss();
            this.progressDialog = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onSharingStarted$0() {
        cx cxVar = new cx(getContext());
        this.progressDialog = cxVar;
        cxVar.a(true);
        this.progressDialog.setCancelable(false);
        this.progressDialog.setCanceledOnTouchOutside(false);
        cx cxVar2 = this.progressDialog;
        cxVar2.c = 0;
        cxVar2.setMessage(getProgressDialogTitle());
        this.progressDialog.show();
    }

    @Override // com.pspdfkit.document.sharing.DocumentSharingController
    public void cancelSharing() {
        super.cancelSharing();
        hideProgressDialog();
    }

    public String getProgressDialogTitle() {
        return no.a(getContext(), R.string.pspdf__exporting, null);
    }

    public ShareAction getShareAction() {
        return this.shareAction;
    }

    public ShareTarget getShareTarget() {
        return this.shareTarget;
    }

    public void notifyNoApplicationFoundForSharing() {
        if (getContext() == null) {
            return;
        }
        Toast.makeText(getContext(), R.string.pspdf__no_applications_found, 0).show();
    }

    @Override // com.pspdfkit.document.sharing.DocumentSharingController
    public void onDetach() {
        hideProgressDialog();
        super.onDetach();
    }

    @Override // com.pspdfkit.document.sharing.DocumentSharingController
    public void onDocumentPrepared(Uri uri) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        uw.a(uri, "shareUri", null);
        ShareTarget shareTarget = this.shareTarget;
        Intent shareIntent = shareTarget != null ? DocumentSharingIntentHelper.getShareIntent(context, uri, shareTarget) : Intent.createChooser(DocumentSharingIntentHelper.getShareIntent(context, uri, getShareAction()), null);
        if (shareIntent == null) {
            return;
        }
        try {
            context.startActivity(shareIntent);
        } catch (ActivityNotFoundException e) {
            PdfLog.e("Nutri.DefDocSharingCont", e, "Unable to share document with URI " + uri + ". Activity cannot be started.", new Object[0]);
        }
    }

    @Override // com.pspdfkit.document.sharing.DocumentSharingController
    public void onSharingError() {
        hideProgressDialog();
        super.onSharingError();
    }

    @Override // com.pspdfkit.document.sharing.DocumentSharingController
    public void onSharingFinished(Uri uri) {
        hideProgressDialog();
        super.onSharingFinished(uri);
    }

    @Override // com.pspdfkit.document.sharing.DocumentSharingController
    public void onSharingProgress(PdfProcessor.ProcessorProgress processorProgress) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (this.progressDialog == null || this.showProgressDialogRunnable != null) {
            hideProgressDialog();
            cx cxVar = new cx(context);
            this.progressDialog = cxVar;
            cxVar.a(false);
            this.progressDialog.setCancelable(false);
            this.progressDialog.setCanceledOnTouchOutside(false);
            cx cxVar2 = this.progressDialog;
            cxVar2.c = 1;
            cxVar2.setTitle(getProgressDialogTitle());
            cx cxVar3 = this.progressDialog;
            int totalPages = processorProgress.getTotalPages();
            ProgressBar progressBar = cxVar3.a;
            if (progressBar != null) {
                progressBar.setMax(totalPages);
                cxVar3.a();
            } else {
                cxVar3.h = totalPages;
            }
            this.progressDialog.show();
        }
        cx cxVar4 = this.progressDialog;
        int pagesProcessed = processorProgress.getPagesProcessed();
        if (!cxVar4.o) {
            cxVar4.i = pagesProcessed;
        } else {
            cxVar4.a.setProgress(pagesProcessed);
            cxVar4.a();
        }
    }

    @Override // com.pspdfkit.document.sharing.DocumentSharingController
    public void onSharingStarted(Disposable disposable) {
        super.onSharingStarted(disposable);
        hideProgressDialog();
        Runnable runnable = new Runnable() { // from class: com.pspdfkit.document.sharing.DefaultDocumentSharingController$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onSharingStarted$0();
            }
        };
        this.showProgressDialogRunnable = runnable;
        this.handler.postDelayed(runnable, 100L);
    }

    public DefaultDocumentSharingController(Context context, ShareAction shareAction) {
        super(context);
        this.LOG_TAG = "Nutri.DefDocSharingCont";
        this.handler = new Handler(Looper.getMainLooper());
        uw.a(shareAction, "shareAction", null);
        this.shareAction = shareAction;
        this.shareTarget = null;
    }

    public DefaultDocumentSharingController(Context context, ShareTarget shareTarget) {
        super(context);
        this.LOG_TAG = "Nutri.DefDocSharingCont";
        this.handler = new Handler(Looper.getMainLooper());
        uw.a(shareTarget, "shareTarget", null);
        this.shareAction = ShareAction.SEND;
        this.shareTarget = shareTarget;
    }
}
