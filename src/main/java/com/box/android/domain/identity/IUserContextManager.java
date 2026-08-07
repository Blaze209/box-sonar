package com.box.android.domain.identity;

import android.content.Context;
import android.content.SharedPreferences;
import com.box.android.domain.localrepo.IBoxStorage;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxUser;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;

/* JADX INFO: loaded from: classes11.dex */
public interface IUserContextManager {
    public static final String LOGOUT_ALL_USERS = "LOGOUT_ALL_USERS";
    public static final String LOGOUT_CURRENT_USER = "LOGOUT_CURRENT_USER";
    public static final int TYPE_ENTERPRISE = 3;
    public static final int TYPE_FREE = 0;
    public static final int TYPE_PAID = 2;
    public static final int TYPE_PAID_UNKNOWN = 1;
    public static final int TYPE_UNKNOWN = -1;

    void addUserContextListener(String str, IUserContextComponentListener iUserContextComponentListener);

    void createUser(String str, BoxApiPrivate boxApiPrivate) throws IUserContextComponent.UserContextComponentCreationException;

    void destroyAllUsers();

    void destroyUser();

    void destroyUser(String str);

    void expireAccessTokenForDebug();

    BoxSession getBoxSession(Context context);

    IUserContext getCurrentContext();

    String getCurrentContextId();

    String getDeviceId();

    SharedPreferences getEncryptedSharedPrefs(ILocalSharedPreferences.PreferenceName preferenceName);

    IBoxStorage getPreviewStorage();

    BoxUser getUserInfo();

    SharedPreferences getUserSharedPrefs();

    SharedPreferences getUserSharedPrefs(ILocalSharedPreferences.PreferenceName preferenceName);

    int getUserType();

    String getUserTypeAsString();

    boolean hasValidUserId();

    boolean isSwitchingOrDestroyingUser();

    boolean isSwitchingToNewUser();

    boolean isValidUserAvailable();

    void setUserInfo(BoxUser boxUser);

    void softSwitch(String str);

    void updatePushNotificationsLocale(BoxApiPrivate boxApiPrivate);
}
