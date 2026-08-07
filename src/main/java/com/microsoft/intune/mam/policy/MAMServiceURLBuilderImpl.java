package com.microsoft.intune.mam.policy;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class MAMServiceURLBuilderImpl implements MAMServiceURLBuilder {
    private static final String APIVERSION_NAME = "api-version";
    private static final String ENCODING = "UTF-8";
    private static final String ISTARGETED_API_VERSION = "1.1";
    private static final String LS_API_VERSION = "2.0";
    private String mApiVersion;
    private MAMServiceQueryParameters mQueryParameters;
    private URL mUrl = null;

    @Override // com.microsoft.intune.mam.policy.MAMServiceURLBuilder
    public MAMServiceURLBuilder setURL(URL url) {
        this.mUrl = url;
        return this;
    }

    @Override // com.microsoft.intune.mam.policy.MAMServiceURLBuilder
    public MAMServiceURLBuilder setEndpointApiVersion(String str) {
        this.mApiVersion = str;
        return this;
    }

    @Override // com.microsoft.intune.mam.policy.MAMServiceURLBuilder
    public MAMServiceURLBuilder setLookupServiceApiVersion() {
        return setEndpointApiVersion("2.0");
    }

    @Override // com.microsoft.intune.mam.policy.MAMServiceURLBuilder
    public MAMServiceURLBuilder setIsTargetedApiVersion() {
        return setEndpointApiVersion("1.1");
    }

    @Override // com.microsoft.intune.mam.policy.MAMServiceURLBuilder
    public MAMServiceURLBuilder setQueryParameters(MAMServiceQueryParameters mAMServiceQueryParameters) {
        this.mQueryParameters = mAMServiceQueryParameters;
        return this;
    }

    @Override // com.microsoft.intune.mam.policy.MAMServiceURLBuilder
    public URL build() throws MalformedURLException {
        checkBuilderParameters();
        Uri.Builder builderBuildUpon = Uri.parse(this.mUrl.toString()).buildUpon();
        builderBuildUpon.appendQueryParameter(APIVERSION_NAME, this.mApiVersion);
        MAMServiceQueryParameters mAMServiceQueryParameters = this.mQueryParameters;
        if (mAMServiceQueryParameters != null) {
            try {
                for (Map.Entry<String, String> entry : mAMServiceQueryParameters.get().entrySet()) {
                    builderBuildUpon.appendQueryParameter(URLEncoder.encode(entry.getKey(), "UTF-8"), URLEncoder.encode(entry.getValue(), "UTF-8"));
                }
            } catch (UnsupportedEncodingException unused) {
                throw new AssertionError("UTF-8 should always be supported.");
            }
        }
        return new URL(Uri.decode(builderBuildUpon.build().toString()));
    }

    private void checkBuilderParameters() {
        if (this.mUrl == null) {
            throw new IllegalArgumentException("The base URL wasn't specified.");
        }
        if (this.mApiVersion == null) {
            throw new IllegalArgumentException("The endpoint API version wasn't specified");
        }
    }
}
