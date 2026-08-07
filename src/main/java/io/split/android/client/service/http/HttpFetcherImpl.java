package io.split.android.client.service.http;

import io.split.android.android_client.BuildConfig;
import io.split.android.client.ServiceEndpoints;
import io.split.android.client.network.HttpClient;
import io.split.android.client.network.HttpException;
import io.split.android.client.network.HttpMethod;
import io.split.android.client.network.HttpResponse;
import io.split.android.client.network.URIBuilder;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.net.URI;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class HttpFetcherImpl<T> implements HttpFetcher<T> {
    public static final String TILL_PARAM = "till";
    private final HttpClient mClient;
    private final HttpResponseParser<T> mResponseParser;
    private final URI mTarget;

    public HttpFetcherImpl(HttpClient client, URI target, HttpResponseParser<T> responseParser) {
        this.mClient = (HttpClient) Utils.checkNotNull(client);
        this.mTarget = (URI) Utils.checkNotNull(target);
        this.mResponseParser = (HttpResponseParser) Utils.checkNotNull(responseParser);
    }

    @Override // io.split.android.client.service.http.HttpFetcher
    public T execute(Map<String, Object> params, Map<String, String> headers) throws HttpFetcherException {
        Utils.checkNotNull(params);
        try {
            URIBuilder uRIBuilder = new URIBuilder(this.mTarget);
            if (params.containsKey(TILL_PARAM)) {
                params.put(TILL_PARAM, params.remove(TILL_PARAM));
            }
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                Object value = entry.getValue();
                uRIBuilder.addParameter(entry.getKey(), value != null ? value.toString() : "");
            }
            URI uriBuild = uRIBuilder.build();
            HttpResponse httpResponseExecute = this.mClient.request(uriBuild, HttpMethod.GET, null, headers).execute();
            if (uriBuild != null && httpResponseExecute != null) {
                Logger.v("Received from: " + uriBuild + " -> " + httpResponseExecute.getData());
            }
            if (!httpResponseExecute.isSuccess()) {
                int httpStatus = httpResponseExecute.getHttpStatus();
                checkOutdatedProxyError(httpStatus, uriBuild, params);
                throw new HttpFetcherException(this.mTarget.toString(), "http return code " + httpStatus, Integer.valueOf(httpStatus));
            }
            T t = this.mResponseParser.parse(httpResponseExecute.getData());
            if (t != null) {
                return t;
            }
            throw new IllegalStateException("Wrong data received from split changes server");
        } catch (HttpException e) {
            throw new HttpFetcherException(this.mTarget.toString(), e.getLocalizedMessage(), e.getStatusCode());
        } catch (HttpFetcherException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new HttpFetcherException(this.mTarget.toString(), e3.getLocalizedMessage());
        }
    }

    private void checkOutdatedProxyError(int httpStatus, URI builtUri, Map<String, Object> params) throws HttpFetcherException {
        int code = HttpStatus.BAD_REQUEST.getCode();
        boolean z = (builtUri == null || builtUri.getHost() == null || !ServiceEndpoints.EndpointValidator.sdkEndpointIsOverridden(builtUri.getHost())) ? false : true;
        boolean z2 = params != null && BuildConfig.FLAGS_SPEC.equals(params.get("s"));
        if (httpStatus == code && z && z2) {
            throw new HttpFetcherException(this.mTarget.toString(), "Proxy is outdated", Integer.valueOf(HttpStatus.INTERNAL_PROXY_OUTDATED.getCode()));
        }
    }
}
