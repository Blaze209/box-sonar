package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.java.providers.oauth2.OAuth2Configuration;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class AzureActiveDirectoryOAuth2Configuration extends OAuth2Configuration {
    private URL mAuthorityUrl;
    private boolean mMultipleCloudsSupported;
    private AzureActiveDirectorySlice mSlice;
    private boolean mAuthorityHostValidationEnabled = true;
    private Map<String, String> mFlightParameters = new HashMap();

    public boolean isAuthorityHostValidationEnabled() {
        return this.mAuthorityHostValidationEnabled;
    }

    public void setAuthorityHostValidationEnabled(boolean z) {
        this.mAuthorityHostValidationEnabled = z;
    }

    public URL getAuthorityUrl() {
        return this.mAuthorityUrl;
    }

    public void setAuthorityUrl(URL url) {
        this.mAuthorityUrl = url;
    }

    public Map<String, String> getFlightParameters() {
        return this.mFlightParameters;
    }

    public void setFlightParameters(Map<String, String> map) {
        this.mFlightParameters = map;
    }

    public AzureActiveDirectorySlice getSlice() {
        return this.mSlice;
    }

    public void setSlice(AzureActiveDirectorySlice azureActiveDirectorySlice) {
        this.mSlice = azureActiveDirectorySlice;
    }

    public void setMultipleCloudsSupported(boolean z) {
        this.mMultipleCloudsSupported = z;
    }

    public boolean getMultipleCloudsSupported() {
        return this.mMultipleCloudsSupported;
    }
}
