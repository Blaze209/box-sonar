package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class AzureActiveDirectoryCloud {

    @SerializedName("aliases")
    private List<String> mCloudHostAliases;
    private boolean mIsValidated;

    @SerializedName("preferred_cache")
    private final String mPreferredCacheHostName;

    @SerializedName("preferred_network")
    private final String mPreferredNetworkHostName;

    protected boolean canEqual(Object obj) {
        return obj instanceof AzureActiveDirectoryCloud;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AzureActiveDirectoryCloud)) {
            return false;
        }
        AzureActiveDirectoryCloud azureActiveDirectoryCloud = (AzureActiveDirectoryCloud) obj;
        if (!azureActiveDirectoryCloud.canEqual(this)) {
            return false;
        }
        String str = this.mPreferredNetworkHostName;
        String str2 = azureActiveDirectoryCloud.mPreferredNetworkHostName;
        if (str != null ? !str.equals(str2) : str2 != null) {
            return false;
        }
        String str3 = this.mPreferredCacheHostName;
        String str4 = azureActiveDirectoryCloud.mPreferredCacheHostName;
        return str3 != null ? str3.equals(str4) : str4 == null;
    }

    public int hashCode() {
        String str = this.mPreferredNetworkHostName;
        int iHashCode = str == null ? 43 : str.hashCode();
        String str2 = this.mPreferredCacheHostName;
        return ((iHashCode + 59) * 59) + (str2 != null ? str2.hashCode() : 43);
    }

    public AzureActiveDirectoryCloud(boolean z) {
        this.mIsValidated = z;
        this.mPreferredNetworkHostName = null;
        this.mPreferredCacheHostName = null;
    }

    public AzureActiveDirectoryCloud(String str, String str2, List<String> list) {
        this.mPreferredNetworkHostName = str;
        this.mPreferredCacheHostName = str2;
        ArrayList arrayList = new ArrayList();
        this.mCloudHostAliases = arrayList;
        arrayList.addAll(list);
        this.mIsValidated = true;
    }

    AzureActiveDirectoryCloud(String str, String str2) {
        this.mPreferredNetworkHostName = str;
        this.mPreferredCacheHostName = str2;
        this.mIsValidated = true;
    }

    public String getPreferredNetworkHostName() {
        return this.mPreferredNetworkHostName;
    }

    public String getPreferredCacheHostName() {
        return this.mPreferredCacheHostName;
    }

    public List<String> getHostAliases() {
        return this.mCloudHostAliases;
    }

    public boolean isValidated() {
        return this.mIsValidated;
    }

    void setIsValidated(boolean z) {
        this.mIsValidated = z;
    }
}
