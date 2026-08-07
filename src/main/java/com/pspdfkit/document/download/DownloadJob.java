package com.pspdfkit.document.download;

import com.facebook.cache.disk.DefaultDiskStorage;
import com.pspdfkit.document.download.exceptions.DownloadException;
import com.pspdfkit.internal.uw;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.processors.BehaviorProcessor;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadJob {
    private static final int BUFFER_SIZE = 8192;
    private static final String LOG_TAG = "Nutri.DownloadJob";
    private final Disposable downloadDisposable;
    private Disposable progressListenerDisposable;
    private final BehaviorProcessor<Progress> progressProcessor;
    private final DownloadRequest request;

    public interface ProgressListener {
        void onComplete(File file);

        void onError(Throwable th);

        void onProgress(Progress progress);
    }

    public static abstract class ProgressListenerAdapter implements ProgressListener {
        @Override // com.pspdfkit.document.download.DownloadJob.ProgressListener
        public void onComplete(File file) {
        }

        @Override // com.pspdfkit.document.download.DownloadJob.ProgressListener
        public void onError(Throwable th) {
        }

        @Override // com.pspdfkit.document.download.DownloadJob.ProgressListener
        public void onProgress(Progress progress) {
        }
    }

    private DownloadJob(DownloadRequest downloadRequest) {
        uw.a(downloadRequest, "request", null);
        this.request = downloadRequest;
        this.progressProcessor = BehaviorProcessor.create();
        this.downloadDisposable = startDownloadTask();
    }

    private void checkAvailableDiskSpace(long j) throws DownloadException.NotEnoughDiskSpaceException {
        File parentFile = this.request.outputFile.getParentFile();
        if (j < 0 || parentFile == null) {
            return;
        }
        long freeSpace = parentFile.getFreeSpace();
        if (freeSpace < j) {
            throw new DownloadException.NotEnoughDiskSpaceException("Not enough free disk space to download the file. Required: " + j + " bytes, available: " + freeSpace + " bytes");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void download(FlowableEmitter<Progress> flowableEmitter) throws DownloadException {
        if (this.request.outputFile.exists() && !this.request.overwriteExisting) {
            if (flowableEmitter.isCancelled()) {
                return;
            }
            flowableEmitter.onComplete();
            return;
        }
        DownloadRequest downloadRequest = this.request;
        File file = downloadRequest.useTemporaryOutputFile ? new File(this.request.outputFile.getParentFile(), this.request.outputFile.getName() + DefaultDiskStorage.FileType.TEMP) : downloadRequest.outputFile;
        File parentFile = this.request.outputFile.getParentFile();
        if (parentFile == null) {
            throw new DownloadException.OutputFolderException("Output file must have a parent folder. File: " + this.request.outputFile.getAbsolutePath());
        }
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            throw new DownloadException.OutputFolderException("Output folder did not exists and could not be created. Folder: " + this.request.outputFile.getParent());
        }
        if (this.request.outputFile.exists() && !this.request.outputFile.delete()) {
            throw new DownloadException.OutputFileException("Output file already existed and could not be deleted before downloading. File: " + this.request.outputFile.getAbsolutePath());
        }
        if (file.exists() && !file.delete()) {
            throw new DownloadException.DownloadFileException("Download file already existed and could not be deleted before downloading. File: " + file.getAbsolutePath());
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                InputStream inputStreamOpen = this.request.source.open();
                try {
                    long length = this.request.source.getLength();
                    checkAvailableDiskSpace(length);
                    byte[] bArr = new byte[8192];
                    long j = 0;
                    while (true) {
                        int i = inputStreamOpen.read(bArr, 0, 8192);
                        if (i <= -1 || flowableEmitter.isCancelled()) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i);
                        j += (long) i;
                        flowableEmitter.onNext(new Progress(j, length));
                    }
                    if (flowableEmitter.isCancelled()) {
                        file.delete();
                        inputStreamOpen.close();
                    } else {
                        DownloadRequest downloadRequest2 = this.request;
                        if (downloadRequest2.useTemporaryOutputFile && !file.renameTo(downloadRequest2.outputFile)) {
                            throw new DownloadException.OutputFileException("Error moving download from temporary file to output file. Output file: " + this.request.outputFile.getAbsolutePath());
                        }
                        if (!flowableEmitter.isCancelled()) {
                            flowableEmitter.onComplete();
                        }
                        inputStreamOpen.close();
                    }
                    fileOutputStream.close();
                } catch (Throwable th) {
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (DownloadException e) {
            if (flowableEmitter.isCancelled()) {
                return;
            }
            flowableEmitter.onError(e);
        } catch (IOException e2) {
            PdfLog.w(LOG_TAG, e2, "Download failed!", new Object[0]);
            if (flowableEmitter.isCancelled()) {
                return;
            }
            flowableEmitter.onError(new DownloadException.NetworkException("Error while downloading from " + this.request.source, e2));
        }
    }

    public static DownloadJob startDownload(DownloadRequest downloadRequest) {
        return new DownloadJob(downloadRequest);
    }

    private Disposable startDownloadTask() {
        return (Disposable) Flowable.create(new FlowableOnSubscribe() { // from class: com.pspdfkit.document.download.DownloadJob$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.core.FlowableOnSubscribe
            public final void subscribe(FlowableEmitter flowableEmitter) throws DownloadException {
                this.f$0.download(flowableEmitter);
            }
        }, BackpressureStrategy.MISSING).subscribeOn(Schedulers.io()).subscribeWith(new DisposableSubscriber<Progress>() { // from class: com.pspdfkit.document.download.DownloadJob.2
            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                DownloadJob.this.progressProcessor.onComplete();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                DownloadJob.this.progressProcessor.onError(th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Progress progress) {
                DownloadJob.this.progressProcessor.onNext(progress);
            }
        });
    }

    public void cancel() {
        this.downloadDisposable.dispose();
        Disposable disposable = this.progressListenerDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public File getOutputFile() {
        return this.request.outputFile;
    }

    public Flowable<Progress> getProgress() {
        return this.progressProcessor.onBackpressureDrop();
    }

    public boolean isComplete() {
        return this.progressProcessor.hasComplete();
    }

    public void setProgressListener(final ProgressListener progressListener) {
        Disposable disposable = this.progressListenerDisposable;
        if (disposable != null) {
            disposable.dispose();
            this.progressListenerDisposable = null;
        }
        if (progressListener != null) {
            this.progressListenerDisposable = (Disposable) this.progressProcessor.onBackpressureDrop().observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSubscriber<Progress>() { // from class: com.pspdfkit.document.download.DownloadJob.1
                @Override // org.reactivestreams.Subscriber
                public void onComplete() {
                    progressListener.onComplete(DownloadJob.this.request.outputFile);
                }

                @Override // org.reactivestreams.Subscriber
                public void onError(Throwable th) {
                    progressListener.onError(th);
                }

                @Override // org.reactivestreams.Subscriber
                public void onNext(Progress progress) {
                    progressListener.onProgress(progress);
                }
            });
        }
    }
}
