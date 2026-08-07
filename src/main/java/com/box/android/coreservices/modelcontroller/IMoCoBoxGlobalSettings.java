package com.box.android.coreservices.modelcontroller;

import android.content.SharedPreferences;
import com.box.android.coreservices.modelcontroller.messages.BoxLocalUserDataMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxLocalUsersDataMessage;
import com.box.android.domain.models.BoxAuthMap;
import com.box.androidsdk.content.auth.BoxAuthentication;

/* JADX INFO: loaded from: classes9.dex */
public interface IMoCoBoxGlobalSettings {
    BoxFutureTask<BoxLocalUserDataMessage> addCurrentUserData(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo);

    BoxFutureTask<BoxLocalUsersDataMessage> getAllUsersData();

    BoxFutureTask<BoxLocalUserDataMessage> getCurrentUserData();

    String getDecryptedToken(String str);

    String getEncryptedToken(String str);

    String getFirebaseToken();

    SharedPreferences getGlobalSharedPreferences();

    String getLastRememberedUserName();

    String getPrivateKeyString();

    BoxAuthMap getStoredBoxIterator();

    BoxFutureTask<BoxLocalUserDataMessage> getUserData(String str);

    boolean isFirstLaunch();

    boolean isFirstTimeUser();

    boolean isPushRegistrationPromptShown();

    BoxFutureTask<BoxLocalUserDataMessage> removeUserData(String str);

    void saveFirebaseToken(String str);

    void setFirstLaunch(boolean z);

    void setFirstTimeUser(boolean z);

    void setLastRememberedUserName(String str);

    void setPushRegistrationPromptShown(boolean z);

    void setShouldAllowCollabsPushNotification(boolean z);

    void setShouldAllowCommentsPushNotification(boolean z);

    void setShouldAllowTasksPushNotification(boolean z);

    void setShouldAllowUpdatesPushNotification(boolean z);

    boolean shouldAllowCollabsPushNotification();

    boolean shouldAllowCommentsPushNotification();

    boolean shouldAllowTasksPushNotification();

    boolean shouldAllowUpdatesPushNotification();

    boolean shouldDisableAllPushNotifications();
}
