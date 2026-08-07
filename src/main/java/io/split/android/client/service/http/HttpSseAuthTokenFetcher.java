package io.split.android.client.service.http;

import io.split.android.client.network.HttpClient;
import io.split.android.client.network.HttpException;
import io.split.android.client.network.HttpMethod;
import io.split.android.client.network.HttpResponse;
import io.split.android.client.network.URIBuilder;
import io.split.android.client.service.sseclient.SseAuthenticationResponse;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class HttpSseAuthTokenFetcher implements HttpFetcher<SseAuthenticationResponse> {
    private final HttpClient mClient;
    private final HttpResponseParser<SseAuthenticationResponse> mResponseParser;
    private final URI mTarget;

    @Override // io.split.android.client.service.http.HttpFetcher
    public /* bridge */ /* synthetic */ SseAuthenticationResponse execute(Map params, Map headers) throws HttpFetcherException {
        return execute((Map<String, Object>) params, (Map<String, String>) headers);
    }

    public HttpSseAuthTokenFetcher(HttpClient client, URI target, HttpResponseParser<SseAuthenticationResponse> responseParser) {
        this.mClient = (HttpClient) Utils.checkNotNull(client);
        this.mTarget = (URI) Utils.checkNotNull(target);
        this.mResponseParser = (HttpResponseParser) Utils.checkNotNull(responseParser);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.split.android.client.service.http.HttpFetcher
    public SseAuthenticationResponse execute(Map<String, Object> params, Map<String, String> headers) throws HttpFetcherException {
        Utils.checkNotNull(params);
        try {
            URI uri = getUri(params, this.mTarget);
            HttpResponse httpResponseExecute = this.mClient.request(uri, HttpMethod.GET).execute();
            if (uri != null && httpResponseExecute != null) {
                Logger.v("Received from: " + uri.toString() + " -> " + httpResponseExecute.getData());
            }
            if (!httpResponseExecute.isSuccess()) {
                if (httpResponseExecute.isClientRelatedError()) {
                    return new SseAuthenticationResponse(true);
                }
                throw new IllegalStateException("http return code " + httpResponseExecute.getHttpStatus());
            }
            SseAuthenticationResponse sseAuthenticationResponse = this.mResponseParser.parse(httpResponseExecute.getData());
            if (sseAuthenticationResponse != null) {
                return sseAuthenticationResponse;
            }
            throw new IllegalStateException("Wrong data received from authentication server");
        } catch (HttpException e) {
            throw new HttpFetcherException(this.mTarget.toString(), e.getLocalizedMessage(), e.getStatusCode());
        } catch (Exception e2) {
            throw new HttpFetcherException(this.mTarget.toString(), e2.getLocalizedMessage());
        }
    }

    private static URI getUri(Map<String, Object> params, URI target) throws URISyntaxException {
        URIBuilder uRIBuilder = new URIBuilder(target);
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (entry.getValue() instanceof Iterable) {
                Iterator it = ((Iterable) entry.getValue()).iterator();
                while (it.hasNext()) {
                    uRIBuilder.addParameter(entry.getKey(), it.next().toString());
                }
            } else {
                uRIBuilder.addParameter(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return uRIBuilder.build();
    }
}
