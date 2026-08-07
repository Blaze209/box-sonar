package io.split.android.client.service.workmanager.splits;

import io.split.android.client.dtos.TargetingRulesChange;
import io.split.android.client.network.HttpClient;
import io.split.android.client.service.ServiceFactory;
import io.split.android.client.service.http.HttpFetcher;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes4.dex */
class FetcherProvider {
    private final String mEndpoint;
    private final HttpClient mHttpClient;

    FetcherProvider(HttpClient httpClient, String endpoint) {
        this.mHttpClient = httpClient;
        this.mEndpoint = endpoint;
    }

    public HttpFetcher<TargetingRulesChange> provideFetcher(String splitsFilterQueryString) throws URISyntaxException {
        return ServiceFactory.getSplitsFetcher(this.mHttpClient, this.mEndpoint, splitsFilterQueryString);
    }
}
