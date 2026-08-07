package com.box.android.models;

import android.content.Context;
import android.text.TextUtils;
import com.box.android.application.BoxBaseApplication;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.controller.AndroidForWorkController;
import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.coreservices.models.CustomBoxSession;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.configuration.BoxConfigConstants;
import com.box.android.domain.identity.DeviceId;
import com.box.android.domain.services.IAppRestrictionsManager;
import com.box.android.localrepo.LocalAuthStorage;
import com.box.android.usercontext.UserContext;
import com.box.android.usercontext.UserContextManager;
import com.box.androidsdk.content.BoxConfig;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: classes12.dex */
@Singleton
public class BoxSessionFactory {
    protected AndroidForWorkController mAfWController;
    protected LocalAuthStorage mAuthStorage;
    private CustomBoxSession mBoxSession;
    protected DeviceId mDeviceId;
    protected IMoCoBoxGlobalSettings mGlobalSettings;
    protected IntentServices mIntentServices;
    protected IAppRestrictionsManager mRestrictionsManager;
    protected UserContext mUserContext;

    public UserContext getUserContext() {
        return this.mUserContext;
    }

    @Inject
    public BoxSessionFactory(IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings, AndroidForWorkController androidForWorkController, DeviceId deviceId, IntentServices intentServices, IAppRestrictionsManager iAppRestrictionsManager, UserContext userContext) {
        this.mGlobalSettings = iMoCoBoxGlobalSettings;
        this.mAfWController = androidForWorkController;
        this.mDeviceId = deviceId;
        this.mIntentServices = intentServices;
        this.mRestrictionsManager = iAppRestrictionsManager;
        this.mUserContext = userContext;
        this.mAuthStorage = new LocalAuthStorage(this.mGlobalSettings);
    }

    public String getCurrentContextId() {
        return this.mUserContext.getContextId();
    }

    public boolean hasValidUserId() {
        return (TextUtils.isEmpty(this.mUserContext.getContextId()) || this.mUserContext.getContextId().equals("-1")) ? false : true;
    }

    public synchronized CustomBoxSession getBoxSession(Context context) {
        BoxAuthentication.getInstance().setAuthStorage(this.mAuthStorage);
        if (this.mBoxSession == null) {
            BoxConfig.CLIENT_ID = BoxBaseApplication.getInstance().getConfigManager().getString(BoxConfigConstants.CONFIG_KEY_CLIENT_ID);
            BoxConfig.CLIENT_SECRET = BoxBaseApplication.getInstance().getConfigManager().getString(BoxConfigConstants.CONFIG_KEY_CLIENT_SECRET);
            BoxConfig.REDIRECT_URL = BoxBaseApplication.getInstance().getConfigManager().getString(BoxConfigConstants.CONFIG_KEY_REDIRECT_URL);
            if (hasValidUserId()) {
                this.mBoxSession = new CustomBoxSession(context, getCurrentContextId(), BoxConfig.CLIENT_ID, BoxConfig.CLIENT_SECRET, BoxConfig.REDIRECT_URL, this.mRestrictionsManager.isAppFedrampHighCompliant());
            } else {
                this.mBoxSession = new CustomBoxSession(context, this.mRestrictionsManager.isAppFedrampHighCompliant());
            }
            this.mBoxSession.setIntentServices(this.mIntentServices);
            this.mBoxSession.setDeviceId(this.mDeviceId.getDeviceId());
            this.mBoxSession.setDeviceName(CommonBoxUtil.getDeviceName());
        }
        try {
            if (!SdkUtils.isBlank(this.mBoxSession.getUserId()) && this.mBoxSession.getUser() == null) {
                throw new RuntimeException("UserContextManager.getBoxSession has id missing user, validUserId?  " + hasValidUserId());
            }
            if (this.mBoxSession.getUser() != null && SdkUtils.isBlank(this.mBoxSession.getUserId())) {
                throw new RuntimeException("UserContextManager.getBoxSession has user missing id, validUserId?  " + hasValidUserId());
            }
        } catch (Exception e) {
            BoxLogUtils.e(UserContextManager.class.getName(), e);
        }
        return this.mBoxSession;
    }
}
