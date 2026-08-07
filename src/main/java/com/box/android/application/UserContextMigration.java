package com.box.android.application;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.coreservices.modelcontroller.MoCoBoxGlobalSettings;
import com.box.android.coreservices.models.CustomBoxSession;
import com.box.android.coreservices.services.IUserContextMigration;
import com.box.android.coreservices.utilities.BoxKeyManager;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.localrepo.LevelDBKeyValueStore;
import com.box.android.localrepo.LocalSharedPreferences;
import com.box.android.pushnotification.BoxPushNotifContainer;
import com.box.android.utilities.BoxConstants;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.google.code.p.leveldb.LevelDB;
import java.io.File;
import java.util.LinkedHashMap;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class UserContextMigration implements IUserContextMigration {
    private static final String EXTRA_LAST_SAVED_VERSION = "com.box.android.lastSavedVersion";
    private static final String OLD_AUTH_INFO_PREFS = "storedLoggedInUsers";
    private static final String OLD_AUTH_TOKEN_KEY = "userAuthToken";
    private static final String OLD_CLIENT_ID_KEY = "clientId";
    private static final String OLD_EXPIRES_IN_KEY = "userAuthTokenExpiration";
    private static final String OLD_REFRESH_TOKEN_KEY = "userRefreshToken";
    private static final String OLD_USER_ID_KEY = "id";
    private static final String OLD_USER_INFO_PREF_KEY = "com.box.android.MoCoBoxUsers.userInfo";
    private static final String PRE_2_2_DATABASE_NAME = "BoxSQLiteDB";
    private static final String PRE_2_2_TOKEN = "authToken";
    private final Context mContext;
    private final SharedPreferences mGlobalSharedPref = new LocalSharedPreferences().getSharedPreferences(ILocalSharedPreferences.PreferenceName.GLOBAL);
    private final boolean mIsAppFedrampHighCompliant;

    @Override // com.box.android.coreservices.services.IUserContextMigration
    public void migrateStorage() {
    }

    public UserContextMigration(Context context, boolean z) {
        this.mContext = context;
        this.mIsAppFedrampHighCompliant = z;
    }

    @Override // com.box.android.coreservices.services.IUserContextMigration
    public boolean needsMigration() {
        return getLastSavedVersion() < CommonBoxUtil.getCurrentVersionNumber();
    }

    private int getLastSavedVersion() {
        return this.mGlobalSharedPref.getInt(EXTRA_LAST_SAVED_VERSION, 0);
    }

    private void migrateSavedVersionNumber() {
        this.mGlobalSharedPref.edit().putInt(EXTRA_LAST_SAVED_VERSION, CommonBoxUtil.getCurrentVersionNumber()).apply();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.box.android.application.UserContextMigration$1] */
    @Override // com.box.android.coreservices.services.IUserContextMigration
    public void migrateUsersIfNeeded(IUserContextManager iUserContextManager, IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings) {
        if (needsMigration()) {
            migrateAuthInfo(iUserContextManager, iMoCoBoxGlobalSettings);
            migrateSavedVersionNumber();
            clearPushNotifications();
            new Thread() { // from class: com.box.android.application.UserContextMigration.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        BoxKeyManager.testKeyStore();
                    } catch (Exception e) {
                        BoxLogUtils.logException(e);
                    }
                }
            }.start();
        }
    }

    private void clearPushNotifications() {
        this.mGlobalSharedPref.edit().putString(BoxPushNotifContainer.PREF_NOTIFS, "").apply();
    }

    @Override // com.box.android.coreservices.services.IUserContextMigration
    public void migrateAuthInfo(IUserContextManager iUserContextManager, IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings) {
        if (needsCleanStart()) {
            this.mContext.deleteDatabase("BoxSQLiteDB");
            FileUtils.deleteQuietly(new File(this.mContext.getFilesDir() + File.separator + "leveldb"));
            this.mGlobalSharedPref.edit().clear().apply();
            return;
        }
        BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo = null;
        String string = this.mGlobalSharedPref.getString(OLD_AUTH_INFO_PREFS, null);
        if (TextUtils.isEmpty(string)) {
            this.mGlobalSharedPref.edit().remove(MoCoBoxGlobalSettings.KEY_REMEMBERED_USER_NAME).apply();
            return;
        }
        try {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string2 = jSONObject.getString(OLD_REFRESH_TOKEN_KEY);
                    if (!TextUtils.isEmpty(string2)) {
                        BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo2 = new BoxAuthentication.BoxAuthenticationInfo();
                        BoxUser boxUserCreateBoxUser = createBoxUser(jSONObject.getString("id"));
                        boxAuthenticationInfo2.setUser(boxUserCreateBoxUser);
                        boxAuthenticationInfo2.setRefreshToken(iMoCoBoxGlobalSettings.getDecryptedToken(string2));
                        boxAuthenticationInfo2.setAccessToken(iMoCoBoxGlobalSettings.getDecryptedToken(jSONObject.getString(OLD_AUTH_TOKEN_KEY)));
                        boxAuthenticationInfo2.setRefreshTime(Long.valueOf(jSONObject.getLong(OLD_EXPIRES_IN_KEY)));
                        boxAuthenticationInfo2.setExpiresIn(Long.valueOf(jSONObject.getLong(OLD_EXPIRES_IN_KEY)));
                        boxAuthenticationInfo2.setClientId(jSONObject.getString(OLD_CLIENT_ID_KEY));
                        BoxAuthentication.getInstance().onAuthenticated(boxAuthenticationInfo2, this.mContext, this.mIsAppFedrampHighCompliant);
                        if (boxAuthenticationInfo == null) {
                            boxAuthenticationInfo = boxAuthenticationInfo2;
                        }
                        String dbPath = LevelDBKeyValueStore.getDbPath(boxUserCreateBoxUser.getUserId());
                        if (!TextUtils.isEmpty(dbPath)) {
                            new LevelDB(dbPath).clear();
                        }
                    }
                }
                this.mGlobalSharedPref.edit().remove(OLD_AUTH_INFO_PREFS).apply();
                if (boxAuthenticationInfo != null) {
                    CustomBoxSession customBoxSession = (CustomBoxSession) iUserContextManager.getBoxSession(BoxBaseApplication.getInstance());
                    customBoxSession.setAuthInfo(boxAuthenticationInfo);
                    if (SdkUtils.isBlank(customBoxSession.getUserId())) {
                        try {
                            throw new RuntimeException("Unable to migrate userId");
                        } catch (Exception e) {
                            BoxLogUtils.e(UserContextMigration.class.getName(), e);
                        }
                    }
                }
            } catch (Exception e2) {
                BoxLogUtils.logException(UserContextMigration.class.getName(), "Exception " + e2.getMessage(), e2);
            }
        } catch (JSONException e3) {
            BoxLogUtils.logException(UserContextMigration.class.getName(), "JSONException " + e3.getMessage(), e3);
        }
    }

    private boolean needsCleanStart() {
        return !TextUtils.isEmpty(BoxBaseApplication.getInstance().getSharedPreferences(BoxConstants.MYPREFERENCE, 0).getString(PRE_2_2_TOKEN, ""));
    }

    private BoxUser createBoxUser(String str) {
        new LinkedHashMap().put("id", str);
        LocalSharedPreferences localSharedPreferences = new LocalSharedPreferences();
        localSharedPreferences.setContextId(str);
        String string = localSharedPreferences.getSharedPreferences().getString(OLD_USER_INFO_PREF_KEY, null);
        if (TextUtils.isEmpty(string)) {
            return BoxUser.createFromId(str);
        }
        BoxUser boxUser = new BoxUser();
        boxUser.createFromJson(string);
        return boxUser;
    }
}
