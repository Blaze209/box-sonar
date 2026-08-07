package io.split.android.client.service.http.mysegments;

import io.split.android.client.dtos.AllSegmentsChange;
import io.split.android.client.service.http.HttpFetcher;
import java.net.URI;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes4.dex */
public interface MySegmentsFetcherFactory {

    public interface UriBuilder {
        URI build(String matchingKey) throws URISyntaxException;
    }

    HttpFetcher<AllSegmentsChange> getFetcher(String userKey);
}
