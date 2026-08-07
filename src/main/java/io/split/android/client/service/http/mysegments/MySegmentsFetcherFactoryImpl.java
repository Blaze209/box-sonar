package io.split.android.client.service.http.mysegments;

import io.split.android.client.dtos.AllSegmentsChange;
import io.split.android.client.network.HttpClient;
import io.split.android.client.service.http.HttpFetcher;
import io.split.android.client.service.http.HttpFetcherImpl;
import io.split.android.client.service.http.HttpResponseParser;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.net.URI;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes4.dex */
public class MySegmentsFetcherFactoryImpl implements MySegmentsFetcherFactory {
    private final String mEndpoint;
    private final HttpClient mHttpClient;
    private final HttpResponseParser<AllSegmentsChange> mMySegmentsResponseParser;
    private final MySegmentsFetcherFactory.UriBuilder mUriBuilder;

    public MySegmentsFetcherFactoryImpl(HttpClient httpClient, String endpoint, HttpResponseParser<AllSegmentsChange> responseParser, MySegmentsFetcherFactory.UriBuilder uriBuilder) {
        this.mHttpClient = (HttpClient) Utils.checkNotNull(httpClient);
        this.mEndpoint = (String) Utils.checkNotNull(endpoint);
        this.mMySegmentsResponseParser = (HttpResponseParser) Utils.checkNotNull(responseParser);
        this.mUriBuilder = uriBuilder;
    }

    @Override // io.split.android.client.service.http.mysegments.MySegmentsFetcherFactory
    public HttpFetcher<AllSegmentsChange> getFetcher(String matchingKey) {
        return new HttpFetcherImpl(this.mHttpClient, buildTargetUrl(matchingKey), this.mMySegmentsResponseParser);
    }

    private URI buildTargetUrl(String matchingKey) {
        try {
            return this.mUriBuilder.build(matchingKey);
        } catch (URISyntaxException e) {
            Logger.e(e.getMessage());
            return URI.create(this.mEndpoint);
        }
    }
}
