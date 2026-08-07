package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.BoxApiPreview;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.listeners.DownloadStartListener;
import com.box.androidsdk.content.listeners.ProgressListener;
import com.box.androidsdk.content.models.BoxDownload;
import com.box.androidsdk.content.models.BoxSession;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestsPreview extends BoxRequestsFile {
    protected static final String FIELD_PAGE = "page";
    protected static final String TAG = "com.box.androidsdk.content.requests.BoxRequestsPreview";

    public static class DownloadPreview extends BoxRequestDownload<BoxDownload, DownloadPreview> {
        private static final String FIELD_MAX_HEIGHT = "max_height";
        private static final String FIELD_MAX_WIDTH = "max_width";
        private static final String FIELD_MIN_HEIGHT = "min_height";
        private static final String FIELD_MIN_WIDTH = "min_width";
        private static final String FIELD_VERSION = "version";
        public static final int SIZE_1024 = 1024;
        public static final int SIZE_1600 = 1600;
        public static final int SIZE_2048 = 2048;
        private final BoxApiPreview.Extensions previewExt;

        public DownloadPreview(String str, OutputStream outputStream, String str2, BoxSession boxSession, BoxApiPreview.Extensions extensions) {
            super(str, BoxDownload.class, outputStream, str2, boxSession);
            this.previewExt = extensions;
        }

        public Integer getPage() {
            if (this.mQueryMap.containsKey("page")) {
                return Integer.getInteger(this.mQueryMap.get("page"));
            }
            return null;
        }

        public DownloadPreview setPage(int i) {
            this.mQueryMap.put("page", Integer.toString(i));
            return this;
        }

        public Integer getMinWidth() {
            if (this.mQueryMap.containsKey(FIELD_MIN_WIDTH)) {
                return Integer.valueOf(Integer.parseInt(this.mQueryMap.get(FIELD_MIN_WIDTH)));
            }
            return null;
        }

        public DownloadPreview setMinWidth(int i) {
            this.mQueryMap.put(FIELD_MIN_WIDTH, Integer.toString(i));
            return this;
        }

        public Integer getMaxWidth() {
            if (this.mQueryMap.containsKey(FIELD_MAX_WIDTH)) {
                return Integer.valueOf(Integer.parseInt(this.mQueryMap.get(FIELD_MAX_WIDTH)));
            }
            return null;
        }

        public DownloadPreview setMaxWidth(int i) {
            this.mQueryMap.put(FIELD_MAX_WIDTH, Integer.toString(i));
            return this;
        }

        public Integer getMinHeight() {
            if (this.mQueryMap.containsKey(FIELD_MIN_HEIGHT)) {
                return Integer.valueOf(Integer.parseInt(this.mQueryMap.get(FIELD_MIN_HEIGHT)));
            }
            return null;
        }

        public DownloadPreview setMinHeight(int i) {
            this.mQueryMap.put(FIELD_MIN_HEIGHT, Integer.toString(i));
            return this;
        }

        public Integer getMaxHeight() {
            if (this.mQueryMap.containsKey(FIELD_MAX_HEIGHT)) {
                return Integer.valueOf(Integer.parseInt(this.mQueryMap.get(FIELD_MAX_HEIGHT)));
            }
            return null;
        }

        public DownloadPreview setMaxHeight(int i) {
            this.mQueryMap.put(FIELD_MAX_HEIGHT, Integer.toString(i));
            return this;
        }

        public DownloadPreview setMinSize(int i) {
            setMinWidth(i);
            setMinHeight(i);
            return this;
        }

        public DownloadPreview setMaxSize(int i) {
            setMaxWidth(i);
            setMaxHeight(i);
            return this;
        }

        public String getFileVersion() {
            if (this.mQueryMap.containsKey("version")) {
                return this.mQueryMap.get("version");
            }
            return null;
        }

        public DownloadPreview setFileVersion(String str) {
            this.mQueryMap.put("version", str);
            return this;
        }

        public BoxApiPreview.Extensions getPreviewExt() {
            return this.previewExt;
        }
    }

    public static class PreviewBatchRequest extends BoxRequestBatch {
        protected int mMainDownloadIndex = -1;
        protected WrapperProgressListener mWrapperListener;

        public BoxRequestBatch addMainDownloadRequest(BoxRequestDownload boxRequestDownload) {
            this.mRequests.add(boxRequestDownload);
            this.mMainDownloadIndex = this.mRequests.size() - 1;
            return this;
        }

        public BoxRequestDownload getMainDownloadRequest() {
            return (BoxRequestDownload) this.mRequests.get(this.mMainDownloadIndex);
        }

        public PreviewBatchRequest setProgressListener(ProgressListener progressListener) {
            WrapperProgressListener wrapperProgressListener = this.mWrapperListener;
            if (wrapperProgressListener != null) {
                wrapperProgressListener.setProgressListener(progressListener);
                return this;
            }
            getMainDownloadRequest().setProgressListener(progressListener);
            return this;
        }

        public void setMandatoryProgressListener(ProgressListener progressListener) {
            this.mWrapperListener = new WrapperProgressListener(progressListener);
            getMainDownloadRequest().setProgressListener(this.mWrapperListener);
        }

        public PreviewBatchRequest setDownloadStartListener(DownloadStartListener downloadStartListener) {
            getMainDownloadRequest().setDownloadStartListener(downloadStartListener);
            return this;
        }

        public boolean hasMainDownloadRequest() {
            return this.mMainDownloadIndex != -1;
        }

        public int getMainDownloadIndex() {
            return this.mMainDownloadIndex;
        }

        protected class WrapperProgressListener implements ProgressListener {
            private final ProgressListener mMainListener;
            private ProgressListener mSecondaryListener;

            public WrapperProgressListener(ProgressListener progressListener) {
                this.mMainListener = progressListener;
            }

            public void setProgressListener(ProgressListener progressListener) {
                this.mSecondaryListener = progressListener;
            }

            @Override // com.box.androidsdk.content.listeners.ProgressListener
            public void onProgressChanged(long j, long j2) {
                this.mMainListener.onProgressChanged(j, j2);
                this.mSecondaryListener.onProgressChanged(j, j2);
            }
        }
    }

    public static class PollForConversionReady extends BoxRequestsFile.DownloadFile {
        public PollForConversionReady(OutputStream outputStream, String str, BoxSession boxSession) {
            super(outputStream, str, boxSession);
            setRange(0L, 0L);
            setRequestHandler(new PollForConversionResponseHandler(this));
        }

        public static class PollForConversionResponseHandler extends BoxRequestDownload.DownloadRequestHandler {
            protected static final int MAX_RETRY_ATTEMPTS = 9;
            protected static final int MAX_WAIT_MILLIS = 10000;
            protected int mRetryAttempts;

            public PollForConversionResponseHandler(BoxRequestDownload boxRequestDownload) {
                super(boxRequestDownload);
                this.mRetryAttempts = 0;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.box.androidsdk.content.requests.BoxRequestDownload.DownloadRequestHandler, com.box.androidsdk.content.requests.BoxRequest.BoxRequestHandler
            public BoxDownload onResponse(Class cls, BoxHttpResponse boxHttpResponse) throws IllegalAccessException, BoxException, InstantiationException {
                if (boxHttpResponse.getResponseCode() == 202) {
                    try {
                        if (this.mNumAcceptedRetries < 2) {
                            this.mNumAcceptedRetries++;
                            this.mRetryAfterMillis = getRetryAfterFromResponse(boxHttpResponse, 1);
                        } else if (this.mRetryAfterMillis < 10000) {
                            this.mRetryAfterMillis = (int) (((double) this.mRetryAfterMillis) * (Math.random() + 1.5d));
                        } else if (this.mRetryAttempts < 9) {
                            this.mRetryAfterMillis = 10000;
                            this.mRetryAttempts++;
                        } else {
                            throw new BoxException.MaxAttemptsExceeded("Max wait time exceeded.", this.mNumAcceptedRetries);
                        }
                        Thread.sleep(this.mRetryAfterMillis);
                        return (BoxDownload) ((BoxRequestDownload) this.mRequest).send();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new BoxException(e.getMessage(), boxHttpResponse);
                    }
                }
                return super.onResponse(cls, boxHttpResponse);
            }
        }
    }
}
