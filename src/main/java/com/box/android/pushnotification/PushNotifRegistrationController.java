package com.box.android.pushnotification;

import android.content.SharedPreferences;
import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.PushNotificationSettingsDomainError;
import com.box.android.domain.models.pushnotifications.PushDeviceModel;
import com.box.android.domain.usecases.pushnotifications.RegisterPushDeviceUseCase;
import com.box.android.domain.usecases.pushnotifications.UpdateDeviceRegistrationUseCase;
import com.box.android.domain.utils.result.Result;
import com.box.android.localrepo.LocalSharedPreferences;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.models.BoxError;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.dao.BoxConvertedPushNotificationDevice;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes12.dex */
public class PushNotifRegistrationController {
    private static final String GCM_NOTIFICATION_KEY_NAME_PREFIX = "com.box.android.gcmnotifkey_";
    private static final String PLATFORM = "android";
    private BoxApiPrivate mApiPrivate;
    protected FeatureFlips mFeatureFlips;
    protected IMoCoBoxGlobalSettings mGlobalSettings;
    private RegisterPushDeviceUseCase mRegisterPushDeviceUseCase;
    private UpdateDeviceRegistrationUseCase mUpdateDeviceRegistrationUseCase;
    private final IUserContextManager mUserContextManager;

    public PushNotifRegistrationController(BoxApiPrivate boxApiPrivate, IUserContextManager iUserContextManager, RegisterPushDeviceUseCase registerPushDeviceUseCase, UpdateDeviceRegistrationUseCase updateDeviceRegistrationUseCase, FeatureFlips featureFlips, IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings) {
        this.mApiPrivate = boxApiPrivate;
        this.mUserContextManager = iUserContextManager;
        this.mRegisterPushDeviceUseCase = registerPushDeviceUseCase;
        this.mUpdateDeviceRegistrationUseCase = updateDeviceRegistrationUseCase;
        this.mFeatureFlips = featureFlips;
        this.mGlobalSettings = iMoCoBoxGlobalSettings;
    }

    public boolean registerWithBoxServer(final String str) {
        String string = Locale.getDefault().toString();
        try {
            int length = this.mApiPrivate.getSession().getAuthInfo().accessToken().length();
            int length2 = this.mApiPrivate.getSession().getAuthInfo().refreshToken().length();
            if (length < 5 || length2 < 5) {
                throw new RuntimeException("registerWithBoxServer invalid access/refresh " + length + " refresh " + length2);
            }
        } catch (Exception e) {
            BoxLogUtils.e(PushNotifRegistrationController.class.getName(), e);
        }
        if (this.mFeatureFlips.getViewAnnotations().getEnabled()) {
            this.mRegisterPushDeviceUseCase.registerPushDevice(str, string, new Function1() { // from class: com.box.android.pushnotification.PushNotifRegistrationController$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return this.f$0.lambda$registerWithBoxServer$0(str, (Result) obj);
                }
            });
            return false;
        }
        try {
            saveDeviceRegisteredWithBox(this.mApiPrivate.getAddPushNotificationDeviceRequest("android", str, string).send().getUserId(), str, string);
            return false;
        } catch (BoxException e2) {
            if (e2.getResponseCode() != 409) {
                return false;
            }
            BoxError asBoxError = e2.getAsBoxError();
            if (asBoxError.getContextInfo() == null) {
                return false;
            }
            asBoxError.getContextInfo().getConflicts();
            BoxConvertedPushNotificationDevice boxConvertedPushNotificationDevice = null;
            for (BoxEntity boxEntity : asBoxError.getContextInfo().getConflicts()) {
                if (boxEntity instanceof BoxConvertedPushNotificationDevice) {
                    boxConvertedPushNotificationDevice = (BoxConvertedPushNotificationDevice) boxEntity;
                }
            }
            if (boxConvertedPushNotificationDevice == null) {
                return false;
            }
            saveDeviceRegisteredWithBox(boxConvertedPushNotificationDevice.getUserId(), boxConvertedPushNotificationDevice.getDeviceToken(), boxConvertedPushNotificationDevice.getLanguage());
            updateWithBoxServerIfNeeded(getUserSharedPref().getString(ILocalSharedPreferences.GlobalPreferenceKey.PUSH_NOTIF_LANGUAGE.getKey(), Locale.US.toString()), this.mGlobalSettings.getFirebaseToken(), boxConvertedPushNotificationDevice.getUserId());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$registerWithBoxServer$0(String str, Result result) {
        if (result instanceof Result.Error) {
            handlePushRegistrationError(str, (DomainError) ((Result.Error) result).getValue());
        }
        return Unit.INSTANCE;
    }

    private void handlePushRegistrationError(String str, DomainError domainError) {
        String string = Locale.getDefault().toString();
        if (domainError instanceof PushNotificationSettingsDomainError.DeviceAlreadyExists) {
            String string2 = getUserSharedPref().getString(ILocalSharedPreferences.GlobalPreferenceKey.PUSH_NOTIF_BOX_NOTIFICATION_ID.getKey(), "");
            if (StringUtils.isNotEmpty(string2)) {
                updatePushDevice(string2, str, string);
            } else {
                BoxLogUtils.e("Could not update the push device with Box!");
            }
        }
    }

    public void onLocaleChanged() {
        String firebaseToken = this.mGlobalSettings.getFirebaseToken();
        String string = getUserSharedPref().getString(ILocalSharedPreferences.GlobalPreferenceKey.PUSH_NOTIF_LANGUAGE.getKey(), Locale.US.toString());
        String string2 = getUserSharedPref().getString(ILocalSharedPreferences.GlobalPreferenceKey.PUSH_NOTIF_BOX_NOTIFICATION_ID.getKey(), "");
        if (StringUtils.isNotEmpty(string2) && StringUtils.isNotEmpty(firebaseToken)) {
            updateWithBoxServerIfNeeded(string, firebaseToken, string2);
        }
    }

    private boolean updateWithBoxServerIfNeeded(String str, String str2, String str3) {
        String firebaseToken = this.mGlobalSettings.getFirebaseToken();
        String string = Locale.getDefault().toString();
        if (firebaseToken.equals(str2) && string.equals(str)) {
            return true;
        }
        if (this.mFeatureFlips.getViewAnnotations().getEnabled()) {
            updatePushDevice(str3, firebaseToken, string);
            return true;
        }
        try {
            saveDeviceRegisteredWithBox(this.mApiPrivate.getUpdatePushNotificationDevice(str3, "android", firebaseToken, string).send().getUserId(), firebaseToken, string);
            return true;
        } catch (BoxException e) {
            BoxLogUtils.logException(e);
            return false;
        }
    }

    private void updatePushDevice(String str, String str2, String str3) {
        this.mUpdateDeviceRegistrationUseCase.updateDeviceRegistration(new PushDeviceModel(str, str2, str3, "1", true, true), new Function1() { // from class: com.box.android.pushnotification.PushNotifRegistrationController$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Unit.INSTANCE;
            }
        });
    }

    private void saveDeviceRegisteredWithBox(String str, String str2, String str3) {
        SharedPreferences userSharedPref = getUserSharedPref();
        userSharedPref.edit().putString(ILocalSharedPreferences.GlobalPreferenceKey.PUSH_NOTIF_BOX_NOTIFICATION_ID.getKey(), str).apply();
        userSharedPref.edit().putString(ILocalSharedPreferences.GlobalPreferenceKey.PUSH_NOTIF_FIREBASE_TOKEN.getKey(), str2).apply();
        userSharedPref.edit().putString(ILocalSharedPreferences.GlobalPreferenceKey.PUSH_NOTIF_LANGUAGE.getKey(), str3).apply();
        userSharedPref.edit().putString(ILocalSharedPreferences.GlobalPreferenceKey.PUSH_NOTIF_FIREBASE_TOKEN_WITH_BOX.getKey(), str2).apply();
    }

    private String getGcmNotificationKeyName(String str) {
        return GCM_NOTIFICATION_KEY_NAME_PREFIX + str;
    }

    private SharedPreferences getUserSharedPref() {
        return ((LocalSharedPreferences) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_SHARED_PREFERENCES)).getSharedPreferences(ILocalSharedPreferences.PreferenceName.PUSH_NOTIFICATION);
    }
}
