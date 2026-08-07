package com.microsoft.identity.common.internal.migration;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.microsoft.identity.common.adal.internal.cache.ADALTokenCacheItem;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftRefreshToken;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryAccount;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.ClientInfo;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import com.microsoft.identity.common.logging.Logger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class AdalMigrationAdapter implements IMigrationAdapter<MicrosoftAccount, MicrosoftRefreshToken> {
    private static final String KEY_MIGRATION_STATUS = "adal-migration-complete";
    private static final String MIGRATION_STATUS_SHARED_PREFERENCES = "com.microsoft.identity.client.migration_status";
    private static final String TAG = "AdalMigrationAdapter";
    private static final Object sLock = new Object();
    private final boolean mForceMigration;
    private final Map<String, String> mRedirectsMap;
    private final SharedPreferences mSharedPrefs;

    public AdalMigrationAdapter(Context context, Map<String, String> map, boolean z) {
        this.mSharedPrefs = context.getSharedPreferences(MIGRATION_STATUS_SHARED_PREFERENCES, 0);
        this.mRedirectsMap = map;
        this.mForceMigration = z;
    }

    @Override // com.microsoft.identity.common.internal.migration.IMigrationAdapter
    public List<Map.Entry<MicrosoftAccount, MicrosoftRefreshToken>> adapt(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        synchronized (sLock) {
            if (!getMigrationStatus() && !this.mForceMigration && loadCloudDiscoveryMetadata()) {
                arrayList.addAll(TokenCacheItemMigrationAdapter.migrateTokens(this.mRedirectsMap, deserialize(map).values()));
                setMigrationStatus(true);
            }
        }
        return arrayList;
    }

    public void setMigrationStatus(boolean z) {
        this.mSharedPrefs.edit().putBoolean(KEY_MIGRATION_STATUS, z).commit();
    }

    public boolean getMigrationStatus() {
        return this.mSharedPrefs.getBoolean(KEY_MIGRATION_STATUS, false);
    }

    public static MicrosoftAccount createAccount(ADALTokenCacheItem aDALTokenCacheItem) {
        String str = TAG + ":createAccount";
        try {
            String rawIdToken = aDALTokenCacheItem.getRawIdToken();
            String userId = aDALTokenCacheItem.getUserInfo().getUserId();
            String tenantId = aDALTokenCacheItem.getTenantId();
            String host = new URL(aDALTokenCacheItem.getAuthority()).getHost();
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("uid", userId);
            jsonObject.addProperty(AuthenticationConstants.OAuth2.UTID, tenantId);
            AzureActiveDirectoryAccount azureActiveDirectoryAccount = new AzureActiveDirectoryAccount(new IDToken(rawIdToken), new ClientInfo(new String(Base64.encode(jsonObject.toString().getBytes(com.microsoft.identity.common.adal.internal.AuthenticationConstants.CHARSET_UTF8), 0), com.microsoft.identity.common.adal.internal.AuthenticationConstants.CHARSET_UTF8)));
            azureActiveDirectoryAccount.setEnvironment(host);
            return azureActiveDirectoryAccount;
        } catch (ServiceException | MalformedURLException e) {
            Logger.error(str, "Failed to create Account", null);
            Logger.errorPII(str, "Failed to create Account", e);
            return null;
        }
    }

    Map<String, ADALTokenCacheItem> deserialize(Map<String, String> map) {
        String str = TAG + ":deserialize";
        HashMap map2 = new HashMap();
        Gson gson = new Gson();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                map2.put(entry.getKey(), (ADALTokenCacheItem) gson.fromJson(entry.getValue(), ADALTokenCacheItem.class));
            } catch (JsonSyntaxException unused) {
                Logger.warn(str, "Failed to deserialize ADAL cache entry. Skipping.");
            }
        }
        return map2;
    }

    public static boolean loadCloudDiscoveryMetadata() {
        String str = TAG + ":loadCloudDiscoveryMetadata";
        if (!AzureActiveDirectory.isInitialized()) {
            try {
                AzureActiveDirectory.performCloudDiscovery();
            } catch (ClientException e) {
                Logger.error(str, "Failed to load instance discovery metadata", e);
            }
        }
        return AzureActiveDirectory.isInitialized();
    }
}
