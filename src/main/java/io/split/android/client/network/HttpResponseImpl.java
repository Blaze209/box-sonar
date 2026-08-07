package io.split.android.client.network;

/* JADX INFO: loaded from: classes4.dex */
public class HttpResponseImpl extends BaseHttpResponseImpl implements HttpResponse {
    private final String mData;

    HttpResponseImpl(int httpStatus) {
        this(httpStatus, null);
    }

    public HttpResponseImpl(int httpStatus, String data) {
        super(httpStatus);
        this.mData = data;
    }

    @Override // io.split.android.client.network.HttpResponse
    public String getData() {
        return this.mData;
    }
}
