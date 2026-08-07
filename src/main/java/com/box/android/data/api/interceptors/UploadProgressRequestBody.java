package com.box.android.data.api.interceptors;

import android.os.SystemClock;
import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.domain.utils.Progress;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* JADX INFO: compiled from: UploadProgressRequestBody.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB'\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/box/android/data/api/interceptors/UploadProgressRequestBody;", "Lokhttp3/RequestBody;", "inputStreamProvider", "Lcom/box/android/data/api/interceptors/UploadProgressRequestBody$ProgressRequestBodyInfoProvider;", "mediaType", "Lokhttp3/MediaType;", "progressFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/box/android/domain/utils/Progress;", "<init>", "(Lcom/box/android/data/api/interceptors/UploadProgressRequestBody$ProgressRequestBodyInfoProvider;Lokhttp3/MediaType;Lkotlinx/coroutines/flow/MutableStateFlow;)V", "firstWriteHappened", "", "getFirstWriteHappened$annotations", "()V", "getFirstWriteHappened", "()Z", "setFirstWriteHappened", "(Z)V", "contentType", "contentLength", "", "writeTo", "", "sink", "Lokio/BufferedSink;", "updateProgress", "uploaded", "fileLength", "Companion", "ProgressRequestBodyInfoProvider", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UploadProgressRequestBody extends RequestBody {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int DEFAULT_BUFFER_SIZE = 2048;
    private boolean firstWriteHappened;
    private final ProgressRequestBodyInfoProvider inputStreamProvider;
    private final MediaType mediaType;
    private final MutableStateFlow<Progress> progressFlow;

    @JvmStatic
    public static final RequestBody asProgressRequestBody(File file, MediaType mediaType, MutableStateFlow<Progress> mutableStateFlow) {
        return INSTANCE.asProgressRequestBody(file, mediaType, mutableStateFlow);
    }

    public static /* synthetic */ void getFirstWriteHappened$annotations() {
    }

    public UploadProgressRequestBody(ProgressRequestBodyInfoProvider inputStreamProvider, MediaType mediaType, MutableStateFlow<Progress> progressFlow) {
        Intrinsics.checkNotNullParameter(inputStreamProvider, "inputStreamProvider");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(progressFlow, "progressFlow");
        this.inputStreamProvider = inputStreamProvider;
        this.mediaType = mediaType;
        this.progressFlow = progressFlow;
    }

    public final boolean getFirstWriteHappened() {
        return this.firstWriteHappened;
    }

    public final void setFirstWriteHappened(boolean z) {
        this.firstWriteHappened = z;
    }

    @Override // okhttp3.RequestBody
    /* JADX INFO: renamed from: contentType, reason: from getter */
    public MediaType getMediaType() {
        return this.mediaType;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.inputStreamProvider.getLength();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink sink) throws Throwable {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long jContentLength = contentLength();
        byte[] bArr = new byte[2048];
        InputStream inputStream = this.inputStreamProvider.getInputStream();
        try {
            InputStream inputStream2 = inputStream;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = 0;
            while (true) {
                int i = inputStream2.read(bArr);
                if (i == -1) {
                    break;
                }
                j += (long) i;
                if (SystemClock.elapsedRealtime() - jElapsedRealtime > 500 && j != jContentLength) {
                    updateProgress(j, jContentLength);
                    jElapsedRealtime = SystemClock.elapsedRealtime();
                }
                sink.write(bArr, 0, i);
            }
            updateProgress(jContentLength, jContentLength);
            Unit unit = Unit.INSTANCE;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th) {
                    th = th;
                }
            }
            th = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th3) {
                    ExceptionsKt.addSuppressed(th, th3);
                }
            }
        }
        if (th == null) {
            this.firstWriteHappened = true;
            return;
        }
        throw th;
    }

    private final void updateProgress(long uploaded, long fileLength) {
        if (this.firstWriteHappened || !BuildConfigProvider.INSTANCE.isDebugBuild()) {
            this.progressFlow.tryEmit(new Progress(uploaded, fileLength));
        }
    }

    /* JADX INFO: compiled from: UploadProgressRequestBody.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007J \u0010\u0006\u001a\u00020\u0007*\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/api/interceptors/UploadProgressRequestBody$Companion;", "", "<init>", "()V", "DEFAULT_BUFFER_SIZE", "", "asProgressRequestBody", "Lokhttp3/RequestBody;", "Ljava/io/File;", "contentType", "Lokhttp3/MediaType;", "progressFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/box/android/domain/utils/Progress;", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final RequestBody asProgressRequestBody(File file, MediaType contentType, MutableStateFlow<Progress> progressFlow) {
            Intrinsics.checkNotNullParameter(file, "<this>");
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            Intrinsics.checkNotNullParameter(progressFlow, "progressFlow");
            return new UploadProgressRequestBody(ProgressRequestBodyInfoProvider.INSTANCE.getFileInputStreamProvider(file), contentType, progressFlow);
        }

        public final RequestBody asProgressRequestBody(byte[] bArr, MediaType contentType, MutableStateFlow<Progress> progressFlow) {
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            Intrinsics.checkNotNullParameter(progressFlow, "progressFlow");
            return new UploadProgressRequestBody(ProgressRequestBodyInfoProvider.INSTANCE.getByteArrayInputStreamProvider(bArr), contentType, progressFlow);
        }
    }

    /* JADX INFO: compiled from: UploadProgressRequestBody.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B!\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/api/interceptors/UploadProgressRequestBody$ProgressRequestBodyInfoProvider;", "", "file", "Ljava/io/File;", "byteArray", "", "<init>", "(Ljava/io/File;[B)V", "getFile", "()Ljava/io/File;", "getByteArray", "()[B", "getLength", "", "getInputStream", "Ljava/io/InputStream;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ProgressRequestBodyInfoProvider {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final byte[] byteArray;
        private final File file;

        private ProgressRequestBodyInfoProvider(File file, byte[] bArr) {
            this.file = file;
            this.byteArray = bArr;
        }

        /* synthetic */ ProgressRequestBodyInfoProvider(File file, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : file, (i & 2) != 0 ? null : bArr);
        }

        public final byte[] getByteArray() {
            return this.byteArray;
        }

        public final File getFile() {
            return this.file;
        }

        public final long getLength() {
            File file = this.file;
            if (file != null) {
                return file.length();
            }
            byte[] bArr = this.byteArray;
            Intrinsics.checkNotNull(bArr);
            return bArr.length;
        }

        public final InputStream getInputStream() {
            return this.file != null ? new FileInputStream(this.file) : new ByteArrayInputStream(this.byteArray);
        }

        /* JADX INFO: compiled from: UploadProgressRequestBody.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/box/android/data/api/interceptors/UploadProgressRequestBody$ProgressRequestBodyInfoProvider$Companion;", "", "<init>", "()V", "getFileInputStreamProvider", "Lcom/box/android/data/api/interceptors/UploadProgressRequestBody$ProgressRequestBodyInfoProvider;", "file", "Ljava/io/File;", "getByteArrayInputStreamProvider", "byteArray", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final ProgressRequestBodyInfoProvider getFileInputStreamProvider(File file) {
                Intrinsics.checkNotNullParameter(file, "file");
                return new ProgressRequestBodyInfoProvider(file, null, 2, 0 == true ? 1 : 0);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final ProgressRequestBodyInfoProvider getByteArrayInputStreamProvider(byte[] byteArray) {
                Intrinsics.checkNotNullParameter(byteArray, "byteArray");
                return new ProgressRequestBodyInfoProvider(null, byteArray, 1, 0 == true ? 1 : 0);
            }
        }
    }
}
