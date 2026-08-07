package com.pspdfkit.document.providers;

import android.content.Context;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.webkit.URLUtil;
import com.box.boxandroidlibv2private.model.BoxTaskCollaborator;
import com.pspdfkit.document.download.DownloadJob;
import com.pspdfkit.document.download.DownloadRequest;
import com.pspdfkit.document.download.Progress;
import com.pspdfkit.document.download.exceptions.DownloadException;
import com.pspdfkit.internal.n5;
import com.pspdfkit.internal.u40;
import com.pspdfkit.internal.wg;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.subjects.PublishSubject;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 -2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001-B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0#H\u0016J\b\u0010&\u001a\u00020\u0013H\u0002J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020+H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u001d\u001a\u0015\u0012\f\u0012\n  *\u0004\u0018\u00010\u001f0\u001f0\u001e¢\u0006\u0002\b!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/pspdfkit/document/providers/UrlDataProvider;", "Lcom/pspdfkit/document/providers/InputStreamDataProvider;", "Lcom/pspdfkit/document/providers/ProgressDataProvider;", "Landroid/os/Parcelable;", "url", "Ljava/net/URL;", "targetFile", "Ljava/io/File;", "<init>", "(Ljava/net/URL;Ljava/io/File;)V", "input", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "urlPath", "", "cacheFileName", "getCacheFileName", "()Ljava/lang/String;", "downloadJob", "Lcom/pspdfkit/document/download/DownloadJob;", "downloadLatch", "Ljava/util/concurrent/CountDownLatch;", "size", "", "getSize", "openInputStream", "Ljava/io/InputStream;", "getUid", "getTitle", "progressSubject", "Lio/reactivex/rxjava3/subjects/PublishSubject;", "", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "observeProgress", "Lio/reactivex/rxjava3/core/Flowable;", "downloadException", "", "startDownloadIfNotRunning", "writeToParcel", "", "dest", "flags", "", "describeContents", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UrlDataProvider extends InputStreamDataProvider implements ProgressDataProvider, Parcelable {
    private static final String DOWNLOAD_DIR = "UrlDataProvider";
    private static final String LOG_TAG = "UrlDataProvider";
    private Throwable downloadException;
    private DownloadJob downloadJob;
    private final CountDownLatch downloadLatch;
    private final PublishSubject<Double> progressSubject;
    private long size;
    private final File targetFile;
    private final URL url;
    private final String urlPath;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    public static final Parcelable.Creator<UrlDataProvider> CREATOR = new Parcelable.Creator<UrlDataProvider>() { // from class: com.pspdfkit.document.providers.UrlDataProvider$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UrlDataProvider createFromParcel(Parcel parcel) {
            parcel.getClass();
            return new UrlDataProvider(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UrlDataProvider[] newArray(int size) {
            return new UrlDataProvider[size];
        }
    };

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/pspdfkit/document/providers/UrlDataProvider$Companion;", "", "<init>", "()V", "LOG_TAG", "", "DOWNLOAD_DIR", "getCacheDirectory", "Ljava/io/File;", "cacheFileNameFromUrl", "url", "Ljava/net/URL;", "deleteCachedFileForUrl", "", "deleteCachedFiles", "fileNameFromUrl", BoxTaskCollaborator.ROLE_CREATOR, "Landroid/os/Parcelable$Creator;", "Lcom/pspdfkit/document/providers/UrlDataProvider;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String cacheFileNameFromUrl(URL url) {
            url.getClass();
            return fileNameFromUrl(url) + "_" + u40.b(url.getPath()) + "." + FilesKt.getExtension(new File(url.getPath()));
        }

        public final void deleteCachedFileForUrl(URL url) {
            url.getClass();
            File file = new File(getCacheDirectory(), cacheFileNameFromUrl(url));
            try {
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e) {
                PdfLog.e("UrlDataProvider", e, "Could not delete cached file for " + url, new Object[0]);
            }
        }

        public final void deleteCachedFiles() {
            File cacheDirectory = getCacheDirectory();
            if (cacheDirectory.exists()) {
                FilesKt.deleteRecursively(cacheDirectory);
            }
        }

        public final String fileNameFromUrl(URL url) {
            url.getClass();
            return wg.a(URLUtil.guessFileName(url.toString(), null, null));
        }

        public final File getCacheDirectory() {
            Context context = n5.a;
            if (context != null) {
                return new File(wg.a(context), "UrlDataProvider");
            }
            throw new IllegalStateException("The application context should not be null. Please call fun setApplicationContext(context: Context) first");
        }

        private Companion() {
        }
    }

    public UrlDataProvider(URL url, File file) {
        url.getClass();
        this.url = url;
        this.targetFile = file;
        String string = url.toString();
        string.getClass();
        this.urlPath = string;
        this.downloadLatch = new CountDownLatch(1);
        this.size = -1L;
        PublishSubject<Double> publishSubjectCreate = PublishSubject.create();
        publishSubjectCreate.getClass();
        this.progressSubject = publishSubjectCreate;
    }

    private final String getCacheFileName() {
        return INSTANCE.cacheFileNameFromUrl(this.url);
    }

    private final DownloadJob startDownloadIfNotRunning() throws Throwable {
        DownloadJob downloadJob = this.downloadJob;
        if (downloadJob != null) {
            return downloadJob;
        }
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new DownloadException.DownloadOnMainThreadException();
        }
        this.downloadException = null;
        DownloadRequest.Builder builderUri = new DownloadRequest.Builder(getContext()).uri(this.url.toString());
        File file = this.targetFile;
        if (file == null) {
            file = new File(INSTANCE.getCacheDirectory(), getCacheFileName());
        }
        DownloadJob downloadJobStartDownload = DownloadJob.startDownload(builderUri.outputFile(file).overwriteExisting(true).build());
        downloadJobStartDownload.getProgress().subscribe(new Consumer() { // from class: com.pspdfkit.document.providers.UrlDataProvider$startDownloadIfNotRunning$progressDisposable$1
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Progress progress) {
                progress.getClass();
            }
        }, new Consumer() { // from class: com.pspdfkit.document.providers.UrlDataProvider$startDownloadIfNotRunning$progressDisposable$2
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Throwable th) {
                th.getClass();
                this.this$0.downloadException = th;
                this.this$0.downloadLatch.countDown();
            }
        }, new Action() { // from class: com.pspdfkit.document.providers.UrlDataProvider$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                UrlDataProvider.startDownloadIfNotRunning$lambda$1(this.f$0);
            }
        }).getClass();
        downloadJobStartDownload.setProgressListener(new DownloadJob.ProgressListener() { // from class: com.pspdfkit.document.providers.UrlDataProvider.startDownloadIfNotRunning.2
            @Override // com.pspdfkit.document.download.DownloadJob.ProgressListener
            public void onComplete(File output) {
                output.getClass();
                UrlDataProvider.this.progressSubject.onComplete();
            }

            @Override // com.pspdfkit.document.download.DownloadJob.ProgressListener
            public void onError(Throwable exception) {
                exception.getClass();
                PdfLog.e("UrlDataProvider", exception, "Download failed", new Object[0]);
            }

            @Override // com.pspdfkit.document.download.DownloadJob.ProgressListener
            public void onProgress(Progress progress) {
                progress.getClass();
                UrlDataProvider.this.progressSubject.onNext(Double.valueOf(progress.bytesReceived / progress.totalBytes));
            }
        });
        this.downloadJob = downloadJobStartDownload;
        this.downloadLatch.await();
        Throwable th = this.downloadException;
        if (th == null) {
            return downloadJobStartDownload;
        }
        throw th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startDownloadIfNotRunning$lambda$1(UrlDataProvider urlDataProvider) {
        urlDataProvider.downloadLatch.countDown();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.pspdfkit.document.providers.DataProvider
    public long getSize() {
        long j = this.size;
        if (j != -1) {
            return j;
        }
        try {
            File file = this.targetFile;
            long length = (file == null || !file.exists()) ? startDownloadIfNotRunning().getOutputFile().length() : this.targetFile.length();
            this.size = length;
            PdfLog.d("UrlDataProvider", "Downloaded file size: " + length, new Object[0]);
        } catch (InterruptedException unused) {
        }
        return this.size;
    }

    @Override // com.pspdfkit.document.providers.DataProvider
    public String getTitle() {
        String nameWithoutExtension;
        File file = this.targetFile;
        return (file == null || (nameWithoutExtension = FilesKt.getNameWithoutExtension(file)) == null) ? INSTANCE.fileNameFromUrl(this.url) : nameWithoutExtension;
    }

    @Override // com.pspdfkit.document.providers.DataProvider
    public String getUid() {
        String strB = u40.b(this.urlPath);
        strB.getClass();
        return strB;
    }

    @Override // com.pspdfkit.document.providers.ProgressDataProvider
    public Flowable<Double> observeProgress() {
        Flowable<Double> flowable = this.progressSubject.toFlowable(BackpressureStrategy.LATEST);
        flowable.getClass();
        return flowable;
    }

    @Override // com.pspdfkit.document.providers.InputStreamDataProvider
    public InputStream openInputStream() throws Exception {
        try {
            File file = this.targetFile;
            return new FileInputStream((file == null || !file.exists()) ? startDownloadIfNotRunning().getOutputFile() : this.targetFile);
        } catch (Exception e) {
            PdfLog.e("UrlDataProvider", e, "Could not open input stream for the " + this.url, new Object[0]);
            throw e;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.getClass();
        dest.writeString(this.urlPath);
        File file = this.targetFile;
        dest.writeString(file != null ? file.getAbsolutePath() : null);
    }

    public /* synthetic */ UrlDataProvider(URL url, File file, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(url, (i & 2) != 0 ? null : file);
    }

    public UrlDataProvider(Parcel parcel) {
        parcel.getClass();
        URL url = new URL(parcel.readString());
        String string = parcel.readString();
        this(url, string != null ? new File(string) : null);
    }
}
