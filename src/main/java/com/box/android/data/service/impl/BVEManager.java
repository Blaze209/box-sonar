package com.box.android.data.service.impl;

import android.content.SharedPreferences;
import com.box.android.data.api.utils.ApiConstants;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.domain.services.IAppRestrictionsManager;
import com.box.android.domain.services.IBVEManager;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BVEManager.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/service/impl/BVEManager;", "Lcom/box/android/domain/services/IBVEManager;", "localSharedPrefs", "Lcom/box/android/domain/localrepo/ILocalSharedPreferences;", "appRestrictionsManager", "Lcom/box/android/domain/services/IAppRestrictionsManager;", "<init>", "(Lcom/box/android/domain/localrepo/ILocalSharedPreferences;Lcom/box/android/domain/services/IAppRestrictionsManager;)V", "getAppRestrictionsManager", "()Lcom/box/android/domain/services/IAppRestrictionsManager;", "prefs", "Landroid/content/SharedPreferences;", "isVerifiedEnterprise", "", "setVerifiedEnterprise", "", "verified", "getVerifiedEnterpriseDomain", "", "setVerifiedEnterpriseDomain", "domain", "getBaseUri", "getCloudBaseUri", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BVEManager implements IBVEManager {
    private static final String KEY_VERIFIED_ENTERPRISE = "verified_enterprise";
    private static final String KEY_VERIFIED_ENTERPRISE_DOMAIN = "verified_enterprise_domain";
    private final IAppRestrictionsManager appRestrictionsManager;
    private final SharedPreferences prefs;

    @Inject
    public BVEManager(ILocalSharedPreferences localSharedPrefs, IAppRestrictionsManager appRestrictionsManager) {
        Intrinsics.checkNotNullParameter(localSharedPrefs, "localSharedPrefs");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        this.appRestrictionsManager = appRestrictionsManager;
        this.prefs = localSharedPrefs.getSharedPreferences(ILocalSharedPreferences.PreferenceName.ENTERPRISE_VERIFIER);
    }

    public final IAppRestrictionsManager getAppRestrictionsManager() {
        return this.appRestrictionsManager;
    }

    @Override // com.box.android.domain.services.IBVEManager
    public boolean isVerifiedEnterprise() {
        return this.prefs.getBoolean(KEY_VERIFIED_ENTERPRISE, false);
    }

    @Override // com.box.android.domain.services.IBVEManager
    public void setVerifiedEnterprise(boolean verified) {
        SharedPreferences.Editor editorEdit = this.prefs.edit();
        editorEdit.putBoolean(KEY_VERIFIED_ENTERPRISE, verified);
        editorEdit.apply();
    }

    @Override // com.box.android.domain.services.IBVEManager
    public String getVerifiedEnterpriseDomain() {
        if (isVerifiedEnterprise()) {
            return this.prefs.getString(KEY_VERIFIED_ENTERPRISE_DOMAIN, null);
        }
        return null;
    }

    @Override // com.box.android.domain.services.IBVEManager
    public void setVerifiedEnterpriseDomain(String domain) {
        SharedPreferences.Editor editorEdit = this.prefs.edit();
        if (domain != null) {
            editorEdit.putString(KEY_VERIFIED_ENTERPRISE_DOMAIN, domain);
        } else {
            editorEdit.remove(KEY_VERIFIED_ENTERPRISE_DOMAIN);
        }
        editorEdit.apply();
    }

    @Override // com.box.android.domain.services.IBVEManager
    public String getBaseUri() {
        if (!isVerifiedEnterprise()) {
            return this.appRestrictionsManager.isAppFedrampHighCompliant() ? ApiConstants.BASE_URI_APP_FEDRAMP : ApiConstants.BASE_URI_APP;
        }
        String verifiedEnterpriseDomain = getVerifiedEnterpriseDomain();
        if (verifiedEnterpriseDomain == null) {
            return this.appRestrictionsManager.isAppFedrampHighCompliant() ? ApiConstants.BASE_URI_ENT_FEDRAMP : ApiConstants.BASE_URI_ENT;
        }
        if (this.appRestrictionsManager.isAppFedrampHighCompliant() && StringsKt.endsWith$default(verifiedEnterpriseDomain, "ent.box.com", false, 2, (Object) null)) {
            return AuthenticationConstants.Broker.REDIRECT_SSL_PREFIX + StringsKt.replace$default(verifiedEnterpriseDomain, "ent.box.com", "ent.box-gov.com", false, 4, (Object) null) + "/";
        }
        return AuthenticationConstants.Broker.REDIRECT_SSL_PREFIX + verifiedEnterpriseDomain + "/";
    }

    @Override // com.box.android.domain.services.IBVEManager
    public String getCloudBaseUri() {
        if (isVerifiedEnterprise()) {
            String verifiedEnterpriseDomain = getVerifiedEnterpriseDomain();
            if (verifiedEnterpriseDomain != null) {
                return "https://cloud." + verifiedEnterpriseDomain;
            }
            return ApiConstants.BASE_URI_CLOUD_ENT;
        }
        return ApiConstants.BASE_URI_CLOUD_APP;
    }
}
