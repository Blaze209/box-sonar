package com.microsoft.identity.client;

import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.java.util.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class AccountAdapter {
    private static final String TAG = "AccountAdapter";
    private static final CacheRecordFilter guestAccountsWithNoHomeTenantAccountFilter = new CacheRecordFilter() { // from class: com.microsoft.identity.client.AccountAdapter.1
        private boolean hasNoCorrespondingHomeAccount(ICacheRecord iCacheRecord, List<ICacheRecord> list) {
            return !new ArrayList<String>(list) { // from class: com.microsoft.identity.client.AccountAdapter.1.1
                final /* synthetic */ List val$homeRecords;

                {
                    this.val$homeRecords = list;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        add(((ICacheRecord) it.next()).getAccount().getHomeAccountId());
                    }
                }
            }.contains(iCacheRecord.getAccount().getHomeAccountId());
        }

        @Override // com.microsoft.identity.client.AccountAdapter.CacheRecordFilter
        public List<ICacheRecord> filter(List<ICacheRecord> list) {
            ArrayList arrayList = new ArrayList();
            List<ICacheRecord> listFilterCacheRecords = AccountAdapter.filterCacheRecords(list, new HomeAccountFilter());
            for (ICacheRecord iCacheRecord : AccountAdapter.filterCacheRecords(list, new GuestAccountFilter())) {
                if (hasNoCorrespondingHomeAccount(iCacheRecord, listFilterCacheRecords)) {
                    arrayList.add(iCacheRecord);
                }
            }
            return arrayList;
        }
    };

    private interface CacheRecordFilter {
        List<ICacheRecord> filter(List<ICacheRecord> list);
    }

    private static class GuestAccountFilter implements CacheRecordFilter {
        private GuestAccountFilter() {
        }

        @Override // com.microsoft.identity.client.AccountAdapter.CacheRecordFilter
        public List<ICacheRecord> filter(List<ICacheRecord> list) {
            boolean z;
            String str = AccountAdapter.TAG + ":GuestAccountFilter";
            ArrayList arrayList = new ArrayList();
            for (ICacheRecord iCacheRecord : list) {
                String homeAccountId = iCacheRecord.getAccount().getHomeAccountId();
                String localAccountId = iCacheRecord.getAccount().getLocalAccountId();
                boolean z2 = false;
                if (homeAccountId == null) {
                    com.microsoft.identity.common.logging.Logger.warn(str, "Home account ID is null for entry.");
                    z = false;
                } else {
                    z = true;
                }
                if (localAccountId == null) {
                    com.microsoft.identity.common.logging.Logger.warn(str, "Local account ID is null for entry.");
                } else {
                    z2 = z;
                }
                if (z2 && !homeAccountId.contains(localAccountId)) {
                    arrayList.add(iCacheRecord);
                }
            }
            return arrayList;
        }
    }

    private static class HomeAccountFilter implements CacheRecordFilter {
        private HomeAccountFilter() {
        }

        @Override // com.microsoft.identity.client.AccountAdapter.CacheRecordFilter
        public List<ICacheRecord> filter(List<ICacheRecord> list) {
            ArrayList arrayList = new ArrayList();
            for (ICacheRecord iCacheRecord : list) {
                String homeAccountId = iCacheRecord.getAccount().getHomeAccountId();
                String localAccountId = iCacheRecord.getAccount().getLocalAccountId();
                if (localAccountId != null && homeAccountId.contains(localAccountId)) {
                    arrayList.add(iCacheRecord);
                }
            }
            return arrayList;
        }
    }

    public static List<IAccount> adapt(List<ICacheRecord> list) {
        List<ICacheRecord> listFilterCacheRecords = filterCacheRecords(list, new HomeAccountFilter());
        List<ICacheRecord> listFilterCacheRecords2 = filterCacheRecords(list, new GuestAccountFilter());
        List<ICacheRecord> listFilterCacheRecords3 = filterCacheRecords(list, guestAccountsWithNoHomeTenantAccountFilter);
        listFilterCacheRecords2.removeAll(listFilterCacheRecords3);
        List<IAccount> listCreateRootAccounts = createRootAccounts(listFilterCacheRecords);
        appendChildren(listCreateRootAccounts, listFilterCacheRecords2);
        listCreateRootAccounts.addAll(createIAccountsForGuestsNotSignedIntoHomeTenant(listFilterCacheRecords3));
        return listCreateRootAccounts;
    }

    private static List<IAccount> createIAccountsForGuestsNotSignedIntoHomeTenant(List<ICacheRecord> list) {
        HashMap map = new HashMap();
        for (ICacheRecord iCacheRecord : list) {
            String homeAccountId = iCacheRecord.getAccount().getHomeAccountId();
            if (map.get(homeAccountId) == null) {
                map.put(homeAccountId, new ArrayList());
            }
            ((List) map.get(homeAccountId)).add(iCacheRecord);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            MultiTenantAccount multiTenantAccount = new MultiTenantAccount(null, null);
            multiTenantAccount.setId(StringUtil.getTenantInfo((String) entry.getKey()).getKey());
            multiTenantAccount.setTenantId(StringUtil.getTenantInfo((String) entry.getKey()).getValue());
            multiTenantAccount.setEnvironment(((ICacheRecord) ((List) entry.getValue()).get(0)).getAccount().getEnvironment());
            HashMap map2 = new HashMap();
            for (ICacheRecord iCacheRecord2 : (List) entry.getValue()) {
                map2.put(iCacheRecord2.getAccount().getRealm(), new TenantProfile(null, getIdToken(iCacheRecord2)));
            }
            multiTenantAccount.setTenantProfiles(map2);
            arrayList.add(multiTenantAccount);
        }
        return arrayList;
    }

    private static void appendChildren(List<IAccount> list, List<ICacheRecord> list2) {
        for (IAccount iAccount : list) {
            HashMap map = new HashMap();
            for (ICacheRecord iCacheRecord : list2) {
                if (iCacheRecord.getAccount().getHomeAccountId().contains(iAccount.getId())) {
                    TenantProfile tenantProfile = new TenantProfile(null, getIdToken(iCacheRecord));
                    tenantProfile.setEnvironment(iCacheRecord.getAccount().getEnvironment());
                    map.put(iCacheRecord.getAccount().getRealm(), tenantProfile);
                }
            }
            ((MultiTenantAccount) iAccount).setTenantProfiles(map);
        }
    }

    private static List<IAccount> createRootAccounts(List<ICacheRecord> list) {
        ArrayList arrayList = new ArrayList();
        for (ICacheRecord iCacheRecord : list) {
            MultiTenantAccount multiTenantAccount = new MultiTenantAccount(iCacheRecord.getAccount().getClientInfo(), getIdToken(iCacheRecord));
            multiTenantAccount.setHomeAccountId(iCacheRecord.getAccount().getHomeAccountId());
            multiTenantAccount.setTenantId(StringUtil.getTenantInfo(iCacheRecord.getAccount().getHomeAccountId()).getValue());
            multiTenantAccount.setEnvironment(iCacheRecord.getAccount().getEnvironment());
            arrayList.add(multiTenantAccount);
        }
        return arrayList;
    }

    private static IDToken getIdToken(ICacheRecord iCacheRecord) {
        String secret;
        if (iCacheRecord.getIdToken() != null) {
            secret = iCacheRecord.getIdToken().getSecret();
        } else {
            if (iCacheRecord.getV1IdToken() == null) {
                return null;
            }
            secret = iCacheRecord.getV1IdToken().getSecret();
        }
        try {
            return new IDToken(secret);
        } catch (ServiceException unused) {
            throw new IllegalStateException("Failed to restore IdToken");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<ICacheRecord> filterCacheRecords(List<ICacheRecord> list, CacheRecordFilter cacheRecordFilter) {
        return cacheRecordFilter.filter(list);
    }

    static AccountRecord getAccountInternal(String str, OAuth2TokenCache oAuth2TokenCache, String str2, String str3) {
        String str4 = TAG + ":getAccountInternal";
        if (!StringUtil.isNullOrEmpty(str2)) {
            return oAuth2TokenCache.getAccount(null, str, str2, str3);
        }
        com.microsoft.identity.common.logging.Logger.warn(str4, "homeAccountIdentifier was null or empty -- invalid criteria");
        return null;
    }
}
