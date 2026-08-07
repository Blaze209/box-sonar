package com.microsoft.identity.common.java.cache;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes14.dex */
public class BrokerApplicationMetadata extends AbstractApplicationMetadata {

    @SerializedName("family_id")
    private String mFoci;

    private static final class SerializedNames extends AbstractApplicationMetadata.SerializedNames {
        static final String FAMILY_ID = "family_id";

        private SerializedNames() {
        }
    }

    public String getFoci() {
        return this.mFoci;
    }

    public void setFoci(String str) {
        this.mFoci = str;
    }

    @Override // com.microsoft.identity.common.java.cache.AbstractApplicationMetadata
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.microsoft.identity.common.java.cache.AbstractApplicationMetadata
    public int hashCode() {
        return super.hashCode();
    }
}
