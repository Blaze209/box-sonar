package io.split.android.client.service.http;

import io.split.android.client.network.HttpClient;
import io.split.android.client.network.HttpException;
import io.split.android.client.network.HttpMethod;
import io.split.android.client.network.HttpResponse;
import io.split.android.client.utils.Utils;
import java.net.URI;

/* JADX INFO: loaded from: classes4.dex */
public class HttpRecorderImpl<T> implements HttpRecorder<T> {
    private final HttpClient mClient;
    private final HttpRequestBodySerializer<T> mRequestSerializer;
    private final URI mTarget;

    public HttpRecorderImpl(HttpClient client, URI target, HttpRequestBodySerializer<T> requestSerializer) {
        this.mClient = (HttpClient) Utils.checkNotNull(client);
        this.mTarget = (URI) Utils.checkNotNull(target);
        this.mRequestSerializer = (HttpRequestBodySerializer) Utils.checkNotNull(requestSerializer);
    }

    @Override // io.split.android.client.service.http.HttpRecorder
    public void execute(T data) throws HttpRecorderException {
        Utils.checkNotNull(data);
        try {
            HttpResponse httpResponseExecute = this.mClient.request(this.mTarget, HttpMethod.POST, this.mRequestSerializer.serialize(data)).execute();
            if (httpResponseExecute.isSuccess()) {
                return;
            }
            int httpStatus = httpResponseExecute.getHttpStatus();
            throw new HttpRecorderException(this.mTarget.toString(), "http return code " + httpStatus, Integer.valueOf(httpStatus));
        } catch (HttpException e) {
            throw new HttpRecorderException(this.mTarget.toString(), e.getLocalizedMessage(), e.getStatusCode());
        } catch (HttpRecorderException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new HttpRecorderException(this.mTarget.toString(), e3.getLocalizedMessage());
        }
    }
}
