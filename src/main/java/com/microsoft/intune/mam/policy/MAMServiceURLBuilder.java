package com.microsoft.intune.mam.policy;

import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMServiceURLBuilder {
    URL build() throws MalformedURLException;

    MAMServiceURLBuilder setEndpointApiVersion(String str);

    MAMServiceURLBuilder setIsTargetedApiVersion();

    MAMServiceURLBuilder setLookupServiceApiVersion();

    MAMServiceURLBuilder setQueryParameters(MAMServiceQueryParameters mAMServiceQueryParameters);

    MAMServiceURLBuilder setURL(URL url);
}
