package com.microsoft.identity.common.java.registry;

import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.cache.AbstractApplicationMetadata;

/* JADX INFO: loaded from: classes14.dex */
public class BrokerApplicationRegistryData extends AbstractApplicationMetadata {

    @SerializedName("wpj_account_access_allowed")
    private boolean mWpjAccountAccessAllowed;

    private static final class SerializedNames extends AbstractApplicationMetadata.SerializedNames {
        static final String ALLOW_WPJ_ACCESS = "wpj_account_access_allowed";

        private SerializedNames() {
        }
    }

    public boolean isWpjAccountAccessAllowed() {
        return this.mWpjAccountAccessAllowed;
    }

    public void setWpjAccountAccessAllowed(boolean z) {
        this.mWpjAccountAccessAllowed = z;
    }

    @Override // com.microsoft.identity.common.java.cache.AbstractApplicationMetadata
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && super.equals(obj) && this.mWpjAccountAccessAllowed == ((BrokerApplicationRegistryData) obj).mWpjAccountAccessAllowed;
    }

    @Override // com.microsoft.identity.common.java.cache.AbstractApplicationMetadata
    public int hashCode() {
        return (super.hashCode() * 31) + (this.mWpjAccountAccessAllowed ? 1 : 0);
    }
}
