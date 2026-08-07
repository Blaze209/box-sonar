package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.listeners.ProgressListener;
import com.box.androidsdk.content.models.BoxIterator;
import com.box.androidsdk.content.models.BoxIteratorBoxEntity;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Date;

/* JADX INFO: loaded from: classes13.dex */
public abstract class BoxRequestUpload<E extends BoxJsonObject, R extends BoxRequest<E, R>> extends BoxRequestItem<E, R> {
    Date mCreatedDate;
    File mFile;
    String mFileName;
    Date mModifiedDate;
    String mSha1;
    InputStream mStream;
    long mUploadSize;

    public BoxRequestUpload(Class<E> cls, InputStream inputStream, String str, BoxSession boxSession) {
        super(cls, null, str, boxSession);
        this.mRequestMethod = BoxRequest.Methods.POST;
        this.mStream = inputStream;
        this.mFileName = "";
        this.mContentType = null;
        setRequestHandler(new UploadRequestHandler(this));
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest
    protected void setHeaders(BoxHttpRequest boxHttpRequest) {
        super.setHeaders(boxHttpRequest);
        String str = this.mSha1;
        if (str != null) {
            boxHttpRequest.addHeader("Content-MD5", str);
        }
    }

    protected InputStream getInputStream() throws FileNotFoundException {
        InputStream inputStream = this.mStream;
        return inputStream != null ? inputStream : new FileInputStream(this.mFile);
    }

    protected BoxRequestMultipart createMultipartRequest() throws BoxException, IOException {
        BoxRequestMultipart boxRequestMultipart = new BoxRequestMultipart(buildUrl(), this.mRequestMethod, this.mListener);
        setHeaders(boxRequestMultipart);
        boxRequestMultipart.setFile(getInputStream(), this.mFileName, this.mUploadSize);
        Date date = this.mCreatedDate;
        if (date != null) {
            boxRequestMultipart.putField("content_created_at", date);
        }
        Date date2 = this.mModifiedDate;
        if (date2 != null) {
            boxRequestMultipart.putField("content_modified_at", date2);
        }
        return boxRequestMultipart;
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest
    protected BoxHttpRequest createHttpRequest() throws BoxException, IOException {
        return createMultipartRequest();
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest
    protected BoxHttpResponse sendRequest(BoxHttpRequest boxHttpRequest, HttpURLConnection httpURLConnection) throws BoxException, IOException {
        if (boxHttpRequest instanceof BoxRequestMultipart) {
            ((BoxRequestMultipart) boxHttpRequest).writeBody(httpURLConnection, this.mListener);
        }
        return super.sendRequest(boxHttpRequest, httpURLConnection);
    }

    public R setProgressListener(ProgressListener progressListener) {
        this.mListener = progressListener;
        return this;
    }

    public long getUploadSize() {
        return this.mUploadSize;
    }

    public R setUploadSize(long j) {
        this.mUploadSize = j;
        return this;
    }

    public Date getModifiedDate() {
        return this.mModifiedDate;
    }

    public R setModifiedDate(Date date) {
        this.mModifiedDate = date;
        return this;
    }

    public Date getCreatedDate() {
        return this.mCreatedDate;
    }

    public R setCreatedDate(Date date) {
        this.mCreatedDate = date;
        return this;
    }

    public String getSha1() {
        return this.mSha1;
    }

    public void setSha1(String str) {
        this.mSha1 = str;
    }

    public File getFile() {
        return this.mFile;
    }

    public static class UploadRequestHandler extends BoxRequest.BoxRequestHandler<BoxRequestUpload> {
        public UploadRequestHandler(BoxRequestUpload boxRequestUpload) {
            super(boxRequestUpload);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest.BoxRequestHandler
        public <T extends BoxObject> T onResponse(Class<T> cls, BoxHttpResponse boxHttpResponse) throws IllegalAccessException, BoxException, InstantiationException {
            return ((BoxIterator) super.onResponse(BoxIteratorBoxEntity.class, boxHttpResponse)).get(0);
        }
    }
}
