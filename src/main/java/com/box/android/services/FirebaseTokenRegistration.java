package com.box.android.services;

import android.text.TextUtils;
import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.usecases.pushnotifications.RegisterPushDeviceUseCase;
import com.box.android.domain.usecases.pushnotifications.UpdateDeviceRegistrationUseCase;
import com.box.android.pushnotification.PushNotifRegistrationController;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.google.firebase.iid.FirebaseInstanceId;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes13.dex */
public class FirebaseTokenRegistration {
    protected BoxApiPrivate mApiPrivate;
    FeatureFlips mFeatureFlips;
    IMoCoBoxGlobalSettings mGlobalSettings;
    RegisterPushDeviceUseCase mRegisterPushDeviceUseCase;
    UpdateDeviceRegistrationUseCase mUpdateDeviceRegistrationUseCase;
    protected IUserContextManager mUserContextManager;

    @Inject
    public FirebaseTokenRegistration(IUserContextManager iUserContextManager, BoxApiPrivate boxApiPrivate, FeatureFlips featureFlips, RegisterPushDeviceUseCase registerPushDeviceUseCase, UpdateDeviceRegistrationUseCase updateDeviceRegistrationUseCase, IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings) {
        this.mUserContextManager = iUserContextManager;
        this.mApiPrivate = boxApiPrivate;
        this.mFeatureFlips = featureFlips;
        this.mRegisterPushDeviceUseCase = registerPushDeviceUseCase;
        this.mUpdateDeviceRegistrationUseCase = updateDeviceRegistrationUseCase;
        this.mGlobalSettings = iMoCoBoxGlobalSettings;
    }

    public void register() {
        String firebaseToken = this.mGlobalSettings.getFirebaseToken();
        String token = FirebaseInstanceId.getInstance().getToken();
        if (TextUtils.isEmpty(token) || token.equals(firebaseToken) || !this.mUserContextManager.hasValidUserId()) {
            return;
        }
        try {
            new PushNotifRegistrationController(this.mApiPrivate, this.mUserContextManager, this.mRegisterPushDeviceUseCase, this.mUpdateDeviceRegistrationUseCase, this.mFeatureFlips, this.mGlobalSettings).registerWithBoxServer(token);
            this.mGlobalSettings.saveFirebaseToken(token);
            IUserContextManager iUserContextManager = this.mUserContextManager;
            iUserContextManager.createUser(iUserContextManager.getCurrentContextId(), this.mApiPrivate);
        } catch (IUserContextComponent.UserContextComponentCreationException e) {
            BoxLogUtils.logException(getClass().getName(), e);
        }
    }
}
