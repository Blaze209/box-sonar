package com.box.androidsdk.content.requests;

import android.text.TextUtils;
import com.box.androidsdk.content.BoxConstants;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.listeners.DownloadStartListener;
import com.box.androidsdk.content.listeners.ProgressListener;
import com.box.androidsdk.content.models.BoxDownload;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.ProgressOutputStream;
import com.box.androidsdk.content.utils.SdkUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: classes13.dex */
public abstract class BoxRequestDownload<E extends BoxObject, R extends BoxRequest<E, R>> extends BoxRequest<E, R> {
    private static final String CONTENT_ENCODING_GZIP = "gzip";
    private static final String QUERY_CONTENT_ACCESS = "log_content_access";
    private static final String QUERY_VERSION = "version";
    protected DownloadStartListener mDownloadStartListener;
    protected OutputStream mFileOutputStream;
    protected String mId;
    protected long mRangeEnd;
    protected long mRangeStart;
    private String mSha1;
    protected File mTarget;

    protected BoxRequestDownload(String str, Class<E> cls, OutputStream outputStream, String str2, BoxSession boxSession) {
        super(cls, str2, boxSession);
        this.mRangeStart = -1L;
        this.mRangeEnd = -1L;
        this.mId = str;
        this.mRequestMethod = BoxRequest.Methods.GET;
        this.mRequestUrlString = str2;
        this.mFileOutputStream = outputStream;
        setRequestHandler(new DownloadRequestHandler(this));
        this.mRequiresSocket = true;
        this.mQueryMap.put(QUERY_CONTENT_ACCESS, Boolean.toString(true));
    }

    @Deprecated
    protected BoxRequestDownload(Class<E> cls, OutputStream outputStream, String str, BoxSession boxSession) {
        super(cls, str, boxSession);
        this.mRangeStart = -1L;
        this.mRangeEnd = -1L;
        this.mRequestMethod = BoxRequest.Methods.GET;
        this.mRequestUrlString = str;
        this.mFileOutputStream = outputStream;
        setRequestHandler(new DownloadRequestHandler(this));
        this.mRequiresSocket = true;
        this.mQueryMap.put(QUERY_CONTENT_ACCESS, Boolean.toString(true));
    }

    protected BoxRequestDownload(String str, Class<E> cls, File file, String str2, BoxSession boxSession) {
        super(cls, str2, boxSession);
        this.mRangeStart = -1L;
        this.mRangeEnd = -1L;
        this.mId = str;
        this.mRequestMethod = BoxRequest.Methods.GET;
        this.mRequestUrlString = str2;
        this.mTarget = file;
        setRequestHandler(new DownloadRequestHandler(this));
        this.mRequiresSocket = true;
        this.mQueryMap.put(QUERY_CONTENT_ACCESS, Boolean.toString(true));
    }

    @Deprecated
    protected BoxRequestDownload(Class<E> cls, File file, String str, BoxSession boxSession) {
        super(cls, str, boxSession);
        this.mRangeStart = -1L;
        this.mRangeEnd = -1L;
        this.mRequestMethod = BoxRequest.Methods.GET;
        this.mRequestUrlString = str;
        this.mTarget = file;
        setRequestHandler(new DownloadRequestHandler(this));
        this.mRequiresSocket = true;
        this.mQueryMap.put(QUERY_CONTENT_ACCESS, Boolean.toString(true));
    }

    public String getId() {
        return this.mId;
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest
    protected void setHeaders(BoxHttpRequest boxHttpRequest) {
        super.setHeaders(boxHttpRequest);
        long j = this.mRangeStart;
        if (j == -1 || this.mRangeEnd == -1) {
            return;
        }
        boxHttpRequest.addHeader("Range", String.format("bytes=%s-%s", Long.toString(j), Long.toString(this.mRangeEnd)));
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest
    protected void logDebug(BoxHttpResponse boxHttpResponse) throws BoxException {
        logRequest();
        BoxLogUtils.i(BoxConstants.TAG, String.format(Locale.ENGLISH, "Response (%s)", Integer.valueOf(boxHttpResponse.getResponseCode())));
    }

    public File getTarget() {
        return this.mTarget;
    }

    public OutputStream getTargetStream() {
        return this.mFileOutputStream;
    }

    public long getRangeStart() {
        return this.mRangeStart;
    }

    public long getRangeEnd() {
        return this.mRangeEnd;
    }

    public R setRange(long j, long j2) {
        this.mRangeStart = j;
        this.mRangeEnd = j2;
        return this;
    }

    public R setVersion(String str) {
        this.mQueryMap.put("version", str);
        return this;
    }

    public String getVersion() {
        return this.mQueryMap.get("version");
    }

    public R setSha1(String str) {
        this.mSha1 = str;
        return this;
    }

    public String getSha1() {
        return this.mSha1;
    }

    public R setProgressListener(ProgressListener progressListener) {
        this.mListener = progressListener;
        return this;
    }

    public R setDownloadStartListener(DownloadStartListener downloadStartListener) {
        this.mDownloadStartListener = downloadStartListener;
        return this;
    }

    public void setContentAccess(boolean z) {
        this.mQueryMap.put(QUERY_CONTENT_ACCESS, Boolean.toString(z));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.mRequestHandler = new DownloadRequestHandler(this);
    }

    public static class DownloadRequestHandler extends BoxRequest.BoxRequestHandler<BoxRequestDownload> {
        protected static final int DEFAULT_MAX_WAIT_MILLIS = 90000;
        protected static final int DEFAULT_NUM_RETRIES = 2;
        protected int mNumAcceptedRetries;
        protected int mRetryAfterMillis;

        public DownloadRequestHandler(BoxRequestDownload boxRequestDownload) {
            super(boxRequestDownload);
            this.mNumAcceptedRetries = 0;
            this.mRetryAfterMillis = 1000;
        }

        protected OutputStream getOutputStream(BoxDownload boxDownload) throws IOException {
            if (((BoxRequestDownload) this.mRequest).mFileOutputStream == null) {
                if (!boxDownload.getOutputFile().exists()) {
                    boxDownload.getOutputFile().createNewFile();
                }
                return new FileOutputStream(boxDownload.getOutputFile());
            }
            return ((BoxRequestDownload) this.mRequest).mFileOutputStream;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.box.androidsdk.content.requests.BoxRequest.BoxRequestHandler
        public BoxDownload onResponse(Class cls, BoxHttpResponse boxHttpResponse) throws Throwable {
            long j;
            Throwable th;
            Exception exc;
            OutputStream outputStream;
            String contentType = boxHttpResponse.getContentType();
            String contentEncoding = boxHttpResponse.getHttpURLConnection().getContentEncoding();
            if (Thread.currentThread().isInterrupted()) {
                disconnectForInterrupt(boxHttpResponse);
            }
            if (boxHttpResponse.getResponseCode() == 429) {
                return (BoxDownload) retryRateLimited(boxHttpResponse);
            }
            if (boxHttpResponse.getResponseCode() == 202) {
                try {
                    int i = this.mNumAcceptedRetries;
                    if (i < 2) {
                        this.mNumAcceptedRetries = i + 1;
                        this.mRetryAfterMillis = getRetryAfterFromResponse(boxHttpResponse, 1);
                    } else {
                        int i2 = this.mRetryAfterMillis;
                        if (i2 < DEFAULT_MAX_WAIT_MILLIS) {
                            this.mRetryAfterMillis = (int) (((double) i2) * (Math.random() + 1.5d));
                        } else {
                            throw new BoxException.MaxAttemptsExceeded("Max wait time exceeded.", this.mNumAcceptedRetries);
                        }
                    }
                    Thread.sleep(this.mRetryAfterMillis);
                    return (BoxDownload) ((BoxRequestDownload) this.mRequest).send();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new BoxException(e.getMessage(), boxHttpResponse);
                }
            }
            if (boxHttpResponse.getResponseCode() == 200 || boxHttpResponse.getResponseCode() == 206) {
                String headerField = boxHttpResponse.getHttpURLConnection().getHeaderField("Content-Length");
                String headerField2 = boxHttpResponse.getHttpURLConnection().getHeaderField("Content-Disposition");
                try {
                    j = Long.parseLong(headerField);
                } catch (Exception unused) {
                    j = -1;
                }
                long j2 = j;
                BoxDownload boxDownload = new BoxDownload(headerField2, j2, contentType, boxHttpResponse.getHttpURLConnection().getHeaderField("Content-Range"), boxHttpResponse.getHttpURLConnection().getHeaderField("Date"), boxHttpResponse.getHttpURLConnection().getHeaderField("Expiration")) { // from class: com.box.androidsdk.content.requests.BoxRequestDownload.DownloadRequestHandler.1
                    @Override // com.box.androidsdk.content.models.BoxDownload
                    public File getOutputFile() {
                        if (((BoxRequestDownload) DownloadRequestHandler.this.mRequest).getTarget() == null) {
                            return null;
                        }
                        if (((BoxRequestDownload) DownloadRequestHandler.this.mRequest).getTarget().isFile()) {
                            return ((BoxRequestDownload) DownloadRequestHandler.this.mRequest).getTarget();
                        }
                        if (!SdkUtils.isEmptyString(getFileName())) {
                            return new File(((BoxRequestDownload) DownloadRequestHandler.this.mRequest).getTarget(), getFileName());
                        }
                        return super.getOutputFile();
                    }
                };
                if (((BoxRequestDownload) this.mRequest).mDownloadStartListener != null) {
                    ((BoxRequestDownload) this.mRequest).mDownloadStartListener.onStart(boxDownload);
                }
                ProgressOutputStream progressOutputStream = null;
                try {
                    try {
                        if (((BoxRequestDownload) this.mRequest).mListener != null) {
                            ProgressOutputStream progressOutputStream2 = new ProgressOutputStream(getOutputStream(boxDownload), ((BoxRequestDownload) this.mRequest).mListener, j2);
                            try {
                                ((BoxRequestDownload) this.mRequest).mListener.onProgressChanged(0L, j2);
                                outputStream = progressOutputStream2;
                            } catch (Exception e2) {
                                exc = e2;
                                progressOutputStream = progressOutputStream2;
                                if (exc instanceof InterruptedException) {
                                    Thread.currentThread().interrupt();
                                }
                                Socket socket = ((BoxRequestDownload) this.mRequest).getSocket();
                                if (socket != null && contentEncoding != null && contentEncoding.equalsIgnoreCase(BoxRequestDownload.CONTENT_ENCODING_GZIP)) {
                                    try {
                                        socket.close();
                                    } catch (Exception e3) {
                                        BoxLogUtils.e("error closing socket", e3);
                                    }
                                }
                                if (exc instanceof BoxException) {
                                    throw ((BoxException) exc);
                                }
                                if (exc instanceof SSLException) {
                                    throw new BoxException.DownloadSSLException(exc.getMessage(), (SSLException) exc);
                                }
                                throw new BoxException(exc.getMessage(), exc);
                            } catch (Throwable th2) {
                                th = th2;
                                progressOutputStream = progressOutputStream2;
                                try {
                                    boxHttpResponse.getBody().close();
                                } catch (IOException e4) {
                                    BoxLogUtils.e("error closing inputstream", e4);
                                }
                                if (((BoxRequestDownload) this.mRequest).getTargetStream() == null) {
                                    try {
                                        progressOutputStream.close();
                                        throw th;
                                    } catch (IOException e5) {
                                        BoxLogUtils.e("error closing outputstream", e5);
                                        throw th;
                                    }
                                }
                                throw th;
                            }
                        } else {
                            outputStream = getOutputStream(boxDownload);
                        }
                        if (TextUtils.isEmpty(((BoxRequestDownload) this.mRequest).mSha1)) {
                            SdkUtils.copyStream(boxHttpResponse.getBody(), outputStream);
                        } else {
                            String strCopyStreamAndComputeSha1 = SdkUtils.copyStreamAndComputeSha1(boxHttpResponse.getBody(), outputStream);
                            if (!((BoxRequestDownload) this.mRequest).mSha1.equals(strCopyStreamAndComputeSha1)) {
                                throw new BoxException.CorruptedContentException("Sha1 checks failed", ((BoxRequestDownload) this.mRequest).mSha1, strCopyStreamAndComputeSha1);
                            }
                        }
                        try {
                            boxHttpResponse.getBody().close();
                        } catch (IOException e6) {
                            BoxLogUtils.e("error closing inputstream", e6);
                        }
                        if (((BoxRequestDownload) this.mRequest).getTargetStream() == null) {
                            try {
                                outputStream.close();
                            } catch (IOException e7) {
                                BoxLogUtils.e("error closing outputstream", e7);
                            }
                        }
                        return boxDownload;
                    } catch (Exception e8) {
                        exc = e8;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } else {
                return new BoxDownload(null, 0L, null, null, null, null);
            }
        }
    }
}
