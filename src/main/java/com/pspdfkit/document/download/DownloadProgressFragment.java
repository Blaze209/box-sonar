package com.pspdfkit.document.download;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ProgressBar;
import androidx.core.internal.view.SupportMenu;
import androidx.fragment.app.DialogFragment;
import com.pspdfkit.internal.cx;
import com.pspdfkit.internal.n70;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import java.text.NumberFormat;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadProgressFragment extends DialogFragment {
    protected Dialog dialog;
    private DialogInterface.OnCancelListener dialogCancelListener;
    private DownloadJob job;
    private boolean progressBarConfigured = false;
    private cx progressDialog;
    private Disposable progressDisposable;

    private void ensureDialog() {
        if (this.dialog != null) {
            return;
        }
        this.dialog = createDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isIndeterminateProgress(Progress progress) {
        long j = progress.totalBytes;
        return j <= -1 || j != ((long) ((int) j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Publisher lambda$setJob$0(DownloadJob downloadJob, Progress progress) throws Throwable {
        ensureDialog();
        boolean zIsIndeterminateProgress = isIndeterminateProgress(progress);
        configureDialog(progress, zIsIndeterminateProgress);
        this.progressBarConfigured = true;
        return zIsIndeterminateProgress ? downloadJob.getProgress().ignoreElements().toFlowable() : downloadJob.getProgress();
    }

    public void configureDialog(Progress progress, boolean z) {
        cx cxVar = this.progressDialog;
        if (z) {
            cxVar.a(true);
            cx cxVar2 = this.progressDialog;
            cxVar2.g = null;
            cxVar2.a();
            cx cxVar3 = this.progressDialog;
            cxVar3.e = null;
            cxVar3.a();
            return;
        }
        int i = (int) (progress.totalBytes / 1024);
        ProgressBar progressBar = cxVar.a;
        if (progressBar != null) {
            progressBar.setMax(i);
            cxVar.a();
        } else {
            cxVar.h = i;
        }
        this.progressDialog.a(false);
        cx cxVar4 = this.progressDialog;
        cxVar4.e = "%1d/%2d KB";
        cxVar4.a();
        cx cxVar5 = this.progressDialog;
        cxVar5.g = NumberFormat.getPercentInstance();
        cxVar5.a();
    }

    public Dialog createDialog() {
        boolean z;
        cx cxVar = new cx(getActivity());
        this.progressDialog = cxVar;
        cxVar.setTitle("Downloading");
        cx cxVar2 = this.progressDialog;
        cxVar2.e = null;
        cxVar2.a();
        cx cxVar3 = this.progressDialog;
        cxVar3.g = null;
        cxVar3.a();
        cx cxVar4 = this.progressDialog;
        boolean z2 = true;
        cxVar4.c = 1;
        cxVar4.a(true);
        synchronized (n70.class) {
            if (n70.a == null) {
                try {
                    Class.forName("androidx.test.espresso.Espresso");
                } catch (ClassNotFoundException unused) {
                    z2 = false;
                }
                n70.a = new AtomicBoolean(z2);
            }
            z = n70.a.get();
        }
        if (z) {
            cx cxVar5 = this.progressDialog;
            ColorDrawable colorDrawable = new ColorDrawable(SupportMenu.CATEGORY_MASK);
            ProgressBar progressBar = cxVar5.a;
            if (progressBar != null) {
                progressBar.setIndeterminateDrawable(colorDrawable);
            } else {
                cxVar5.l = colorDrawable;
            }
        }
        return this.progressDialog;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog getDialog() {
        return super.getDialog();
    }

    public DownloadJob getJob() {
        return this.job;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        Disposable disposable = this.progressDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        DownloadJob downloadJob = this.job;
        if (downloadJob != null) {
            downloadJob.cancel();
        }
        DialogInterface.OnCancelListener onCancelListener = this.dialogCancelListener;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        ensureDialog();
        this.progressBarConfigured = false;
        return this.dialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Dialog dialog = getDialog();
        if (dialog != null && getRetainInstance()) {
            dialog.setDismissMessage(null);
        }
        this.dialog = null;
        super.onDestroyView();
    }

    public void setDialogOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.dialogCancelListener = onCancelListener;
    }

    public void setJob(final DownloadJob downloadJob) {
        Disposable disposable = this.progressDisposable;
        if (disposable != null) {
            disposable.dispose();
            this.progressDisposable = null;
        }
        this.job = downloadJob;
        this.progressDisposable = (Disposable) downloadJob.getProgress().take(1L).observeOn(AndroidSchedulers.mainThread()).flatMap(new Function() { // from class: com.pspdfkit.document.download.DownloadProgressFragment$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$setJob$0(downloadJob, (Progress) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSubscriber<Progress>() { // from class: com.pspdfkit.document.download.DownloadProgressFragment.1
            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                DownloadProgressFragment.this.dismissAllowingStateLoss();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                DownloadProgressFragment.this.dismissAllowingStateLoss();
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Progress progress) {
                DownloadProgressFragment downloadProgressFragment = DownloadProgressFragment.this;
                if (!downloadProgressFragment.progressBarConfigured) {
                    downloadProgressFragment.configureDialog(progress, downloadProgressFragment.isIndeterminateProgress(progress));
                    DownloadProgressFragment.this.progressBarConfigured = true;
                }
                DownloadProgressFragment.this.updateProgress(progress);
            }
        });
    }

    public void updateProgress(Progress progress) {
        cx cxVar = this.progressDialog;
        if (cxVar != null) {
            int i = (int) (progress.bytesReceived / 1024);
            if (!cxVar.o) {
                cxVar.i = i;
            } else {
                cxVar.a.setProgress(i);
                cxVar.a();
            }
        }
    }
}
