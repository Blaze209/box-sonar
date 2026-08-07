package com.microsoft.intune.mam.client.identity;

import com.microsoft.intune.mam.client.app.LazyInit;
import com.microsoft.intune.mam.client.telemetry.events.MAMInterfaceError;
import com.microsoft.intune.mam.http.KnownClouds;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MAMIdentityManagerBase implements MAMIdentityManager {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(MAMIdentityManagerBase.class);
    private final MAMIdentityPersistenceManager mIdentityPersistenceManager;
    private String mPreferredOid;
    private final Map<String, String> mUpnOidMap = new ConcurrentHashMap();
    private boolean mUpnConflictFound = false;
    private final LazyInit<Map<String, MAMIdentity>> mIdentityCache = new LazyInit<>(new LazyInit.Provider() { // from class: com.microsoft.intune.mam.client.identity.MAMIdentityManagerBase$$ExternalSyntheticLambda0
        @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
        public final Object get() {
            return this.f$0.fetchPersistedIdentities();
        }
    });

    protected MAMIdentityManagerBase(MAMIdentityPersistenceManager mAMIdentityPersistenceManager) {
        this.mIdentityPersistenceManager = mAMIdentityPersistenceManager;
    }

    public void setPreferredOID(String str) {
        this.mPreferredOid = str;
    }

    public boolean hasUpnConflicts() {
        return this.mUpnConflictFound;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, MAMIdentity> fetchPersistedIdentities() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        MAMIdentityPersistenceManager mAMIdentityPersistenceManager = this.mIdentityPersistenceManager;
        if (mAMIdentityPersistenceManager != null) {
            for (MAMIdentity mAMIdentity : mAMIdentityPersistenceManager.getPersistedIdentities()) {
                concurrentHashMap.put(mAMIdentity.aadId(), mAMIdentity);
                mapIdentityUPNs(mAMIdentity);
            }
        }
        LOGGER.info(String.format(Locale.US, "fetched %d identities from persistent storage", Integer.valueOf(concurrentHashMap.size())), new Object[0]);
        return concurrentHashMap;
    }

    private void mapIdentityUPNs(MAMIdentity mAMIdentity) {
        Iterator<String> it = mAMIdentity.upns().iterator();
        while (it.hasNext()) {
            String strCanonicalize = MAMIdentity.canonicalize(it.next());
            String str = this.mUpnOidMap.get(strCanonicalize);
            if (str != null && !str.equals(mAMIdentity.aadId())) {
                this.mUpnConflictFound = true;
                LOGGER.warning("Found multiple accounts with the same UPN", new Object[0]);
            }
            this.mUpnOidMap.put(strCanonicalize, mAMIdentity.aadId());
        }
    }

    public MAMIdentity persistIdentity(MAMIdentity mAMIdentity) {
        if (!mAMIdentity.hasValidAadId()) {
            return null;
        }
        MAMIdentityPersistenceManager mAMIdentityPersistenceManager = this.mIdentityPersistenceManager;
        if (mAMIdentityPersistenceManager != null) {
            mAMIdentity = mAMIdentityPersistenceManager.persistIdentity(mAMIdentity);
        }
        if (mAMIdentity != null) {
            this.mIdentityCache.get().put(mAMIdentity.aadId(), mAMIdentity);
            mapIdentityUPNs(mAMIdentity);
        }
        return mAMIdentity;
    }

    public List<MAMIdentity> getPersistedIdentities() {
        MAMIdentityPersistenceManager mAMIdentityPersistenceManager = this.mIdentityPersistenceManager;
        if (mAMIdentityPersistenceManager != null) {
            return mAMIdentityPersistenceManager.getPersistedIdentities();
        }
        return new ArrayList();
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMIdentityManager
    public MAMIdentity fetch(String str) {
        String strCanonicalizeAadId = canonicalizeAadId(str);
        if (strCanonicalizeAadId == null || strCanonicalizeAadId.isEmpty()) {
            return null;
        }
        return this.mIdentityCache.get().get(strCanonicalizeAadId);
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMIdentityManager
    public MAMIdentity fetchFromUPN(String str) {
        MAMIdentity mAMIdentityFetch;
        String strCanonicalize = MAMIdentity.canonicalize(str);
        if (strCanonicalize == null || strCanonicalize.isEmpty()) {
            return null;
        }
        String str2 = this.mPreferredOid;
        if (str2 != null && (mAMIdentityFetch = fetch(str2)) != null && mAMIdentityFetch.hasUPN(str)) {
            return mAMIdentityFetch;
        }
        String str3 = this.mUpnOidMap.get(strCanonicalize);
        if (str3 == null) {
            return null;
        }
        return fetch(str3);
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMIdentityManager
    public MAMIdentity insertOrUpdate(String str, String str2, String str3, String str4, boolean z) {
        String str5;
        String str6;
        MAMIdentityManagerBase mAMIdentityManagerBase;
        String str7;
        String strCanonicalizeAadId = canonicalizeAadId(str);
        if (strCanonicalizeAadId == null || strCanonicalizeAadId.isEmpty()) {
            LOGGER.error(MAMInterfaceError.IDENTITY_MANAGER_INVALID_OID, "Invalid OID passed to insertOrUpdate", new Object[0]);
            return null;
        }
        MAMIdentity mAMIdentity = this.mIdentityCache.get().get(strCanonicalizeAadId);
        if (mAMIdentity != null) {
            mAMIdentityManagerBase = this;
            str7 = str2;
            boolean zShouldPersistValues = mAMIdentityManagerBase.shouldPersistValues(mAMIdentity, str3, str4, str7, z);
            str5 = str3;
            str6 = str4;
            if (!zShouldPersistValues) {
                return mAMIdentity;
            }
        } else {
            str5 = str3;
            str6 = str4;
            mAMIdentityManagerBase = this;
            str7 = str2;
        }
        return mAMIdentityManagerBase.persistIdentity(new MAMIdentity(str7, strCanonicalizeAadId, str6, str5, z));
    }

    private boolean shouldPersistValues(MAMIdentity mAMIdentity, String str, String str2, String str3, boolean z) {
        boolean zShouldUpdate = shouldUpdate(mAMIdentity.tenantId(), MAMIdentity.canonicalize(str));
        boolean z2 = false;
        if (zShouldUpdate && mAMIdentity.validated()) {
            LOGGER.error(MAMInterfaceError.IDENTITY_MANAGER_UNEXPECTED_TENANT_ID_UPDATE, "Unexpected update to validated tenant id.", new Object[0]);
        }
        boolean zShouldUpdate2 = shouldUpdate(mAMIdentity.authority(), str2);
        if (zShouldUpdate2 && mAMIdentity.validated() && KnownClouds.fromAuthority(str2) != KnownClouds.fromAuthority(mAMIdentity.authority())) {
            LOGGER.error(MAMInterfaceError.IDENTITY_MANAGER_CLOUD_CHANGE, "Attempt to change a validated authority across clouds to: " + str2 + " from: " + mAMIdentity.authority(), new Object[0]);
        }
        if (z && !mAMIdentity.validated()) {
            z2 = true;
        }
        if (zShouldUpdate || zShouldUpdate2 || z2) {
            return true;
        }
        return !mAMIdentity.hasUPN(str3);
    }

    private static boolean shouldUpdate(String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            return false;
        }
        if (str == null || str.isEmpty()) {
            return true;
        }
        return !str.equals(str2);
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMIdentityManager
    public MAMIdentity create(String str, String str2) {
        return create(str, str2, null, null);
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMIdentityManager
    public MAMIdentity create(String str, String str2, String str3) {
        return create(str, str2, str3, null);
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMIdentityManager
    public MAMIdentity create(String str, String str2, String str3, String str4) {
        MAMIdentity mAMIdentityFetchFromUPN;
        MAMIdentity mAMIdentityFetch = fetch(str2);
        if (mAMIdentityFetch != null) {
            return mAMIdentityFetch;
        }
        if ((str2 == null || str2.isEmpty()) && (mAMIdentityFetchFromUPN = fetchFromUPN(str)) != null) {
            return mAMIdentityFetchFromUPN;
        }
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            if (str2 != null && !str2.isEmpty()) {
                LOGGER.error(MAMInterfaceError.IDENTITY_MANAGER_EMPTY_UPN, "Empty UPN is accompanied by non-empty aadId", new Object[0]);
            }
            return MAMIdentity.EMPTY;
        }
        return new MAMIdentity(str, canonicalizeAadId(str2), str3, str4);
    }

    private String canonicalizeAadId(String str) {
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf(46);
        if (iIndexOf < 0) {
            return MAMIdentity.canonicalize(str);
        }
        String strSubstring = str.substring(0, iIndexOf);
        if (strSubstring.isEmpty()) {
            LOGGER.error(MAMInterfaceError.IDENTITY_MANAGER_INVALID_OID, "Invalid AAD ID detected, starting with '.'", new Object[0]);
            return null;
        }
        return MAMIdentity.canonicalize(strSubstring);
    }

    public void refreshIdentityCache() {
        this.mIdentityCache.get().putAll(fetchPersistedIdentities());
    }

    public List<MAMIdentity> getIdentities() {
        return new ArrayList(this.mIdentityCache.get().values());
    }

    public static MAMIdentity createDirect(String str, String str2, String str3, String str4) {
        return new MAMIdentity(str, str2, str3, str4);
    }
}
