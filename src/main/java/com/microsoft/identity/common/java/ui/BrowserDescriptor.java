package com.microsoft.identity.common.java.ui;

import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.common.internal.providers.oauth2.SwitchBrowserActivity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
public class BrowserDescriptor implements Serializable {
    private static final long serialVersionUID = 3745812401643512530L;

    @SerializedName(SwitchBrowserActivity.BROWSER_PACKAGE_NAME)
    private final String mPackageName;

    @SerializedName("browser_signature_hashes")
    private final Set<String> mSignatureHashes;

    @SerializedName("browser_version_lower_bound")
    private final String mVersionLowerBound;

    @SerializedName("browser_version_upper_bound")
    private final String mVersionUpperBound;

    public String getPackageName() {
        return this.mPackageName;
    }

    public Set<String> getSignatureHashes() {
        return this.mSignatureHashes;
    }

    public String getVersionLowerBound() {
        return this.mVersionLowerBound;
    }

    public String getVersionUpperBound() {
        return this.mVersionUpperBound;
    }

    public BrowserDescriptor(String str, Set<String> set, String str2, String str3) {
        if (str == null) {
            throw new NullPointerException("packageName is marked non-null but is null");
        }
        if (set == null) {
            throw new NullPointerException("signatureHashes is marked non-null but is null");
        }
        this.mPackageName = str;
        this.mSignatureHashes = set;
        this.mVersionLowerBound = str2;
        this.mVersionUpperBound = str3;
    }

    public BrowserDescriptor(String str, String str2, String str3, String str4) {
        if (str == null) {
            throw new NullPointerException("packageName is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("signatureHash is marked non-null but is null");
        }
        this.mPackageName = str;
        this.mSignatureHashes = Collections.singleton(str2);
        this.mVersionLowerBound = str3;
        this.mVersionUpperBound = str4;
    }

    private static BrowserDescriptor getBrowserDescriptorForEdge() {
        HashSet hashSet = new HashSet();
        hashSet.add("Ivy-Rk6ztai_IudfbyUrSHugzRqAtHWslFvHT0PTvLMsEKLUIgv7ZZbVxygWy_M5mOPpfjZrd3vOx3t-cA6fVQ==");
        return new BrowserDescriptor("com.microsoft.emmx", hashSet, (String) null, (String) null);
    }

    private static BrowserDescriptor getBrowserDescriptorForChrome() {
        HashSet hashSet = new HashSet();
        hashSet.add("7fmduHKTdHHrlMvldlEqAIlSfii1tl35bxj1OXN5Ve8c4lU6URVu4xtSHc3BVZxS6WWJnxMDhIfQN0N0K2NDJg==");
        return new BrowserDescriptor(MsalUtils.CHROME_PACKAGE, hashSet, (String) null, (String) null);
    }

    private static BrowserDescriptor getBrowserDescriptorForAea() {
        HashSet hashSet = new HashSet();
        hashSet.add("Nd3EDftVD0lR3Lz0Odq8NMkWWyM5CT8lahePkMtzvS6YkVYne_Hn5jaDSxrdXkN1s4AywAnav2RnarZvcqVFJQ==");
        return new BrowserDescriptor("com.amazon.enterprise.access.android", hashSet, (String) null, (String) null);
    }

    public static List<BrowserDescriptor> getBrowserSafeListForSwitchBrowser() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getBrowserDescriptorForChrome());
        arrayList.add(getBrowserDescriptorForEdge());
        arrayList.add(getBrowserDescriptorForAea());
        return arrayList;
    }

    public static List<BrowserDescriptor> getBrowserSafeListForBroker() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getBrowserDescriptorForChrome());
        return arrayList;
    }
}
