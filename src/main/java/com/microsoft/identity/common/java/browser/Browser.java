package com.microsoft.identity.common.java.browser;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
public class Browser {
    private static final int PRIME_HASH_FACTOR = 92821;
    private final Boolean mIsCustomTabsServiceSupported;
    private final String mPackageName;
    private final Set<String> mSignatureHashes;
    private final String mVersion;

    public Browser(String str, Set<String> set, String str2, boolean z) {
        this.mPackageName = str;
        this.mSignatureHashes = set;
        this.mVersion = str2;
        this.mIsCustomTabsServiceSupported = Boolean.valueOf(z);
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public Set<String> getSignatureHashes() {
        return this.mSignatureHashes;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public boolean isCustomTabsServiceSupported() {
        return this.mIsCustomTabsServiceSupported.booleanValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Browser)) {
            return false;
        }
        Browser browser = (Browser) obj;
        return this.mPackageName.equals(browser.getPackageName()) && this.mVersion.equals(browser.getVersion()) && this.mSignatureHashes.equals(browser.getSignatureHashes());
    }

    public int hashCode() {
        int iHashCode = (((this.mPackageName.hashCode() * PRIME_HASH_FACTOR) + this.mVersion.hashCode()) * PRIME_HASH_FACTOR) + (this.mIsCustomTabsServiceSupported.booleanValue() ? 1 : 0);
        Iterator<String> it = this.mSignatureHashes.iterator();
        while (it.hasNext()) {
            iHashCode = (iHashCode * PRIME_HASH_FACTOR) + it.next().hashCode();
        }
        return iHashCode;
    }
}
