package com.box.android.coreservices.models;

import android.app.admin.DevicePolicyManager;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.R;
import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.coreservices.services.NotificationServices;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.coreservices.utilities.intune.IntuneKeysConfigUtils;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IJobService;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.dao.BoxAdminSettings;
import com.box.boxandroidlibv2private.dao.IBoxAdminSettings;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes9.dex */
public final class BoxAccountManager {
    public static final long DEFAULT_WARNING_PERIOD = 3600000;
    public static final int MINIMUM_VERSION_CHECK_APP_REPEATED = 1;
    private static final String PASSCODE_ADMIN_REQUIRED_PREFS_KEY = "adminRequiredPasscodeKey";
    private static final String REQUIRED_MINIMUM_VERSION_ACTION_PREFS_KEY = "requiredMinimumVersionActionPrefsKey";
    private static final String REQUIRED_MINIMUM_VERSION_MESSAGE_PREFS_KEY = "requiredMinimumVersionMessagePrefsKey";
    private static final String REQUIRED_MINIMUM_VERSION_PREFS_KEY = "requiredMinimumVersionPrefsKey";
    private static final String REQUIRED_PASSCODE_DURATION_PREFS_KEY = "requiredPasscodeDurationKey";
    private static final String SAVE_FOR_OFFLINE_ADMIN_DISABLED_PREFS_KEY = "saveForOfflineAdminDisabledPrefsKey";
    private static final String SAVE_FOR_OFFLINE_NEED_AN_ENCRYPTED_DEVICE_PREFS_KEY = "saveForOfflineNeedsEncryptedDevicePrefsKey";
    static final String SAVE_ON_DEVICE_ADMIN_DISABLED_PREFS_KEY = "saveOnDeviceAdminDisabledPrefsKey";
    private static final String SAVE_ON_DEVICE_NEED_AN_ENCRYPTED_DEVICE_PREFS_KEY = "saveOnDeviceNeedsEncryptedDevicePrefsKey";
    private static long lastMinimumVersionDialogDisplayed;

    private BoxAccountManager() {
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002f A[Catch: Exception -> 0x0063, TryCatch #0 {Exception -> 0x0063, blocks: (B:7:0x0014, B:9:0x001b, B:11:0x0023, B:14:0x003c, B:16:0x0042, B:17:0x0050, B:12:0x002f), top: B:22:0x0014 }] */
    public static void updateRequiredMinimumVersionSetting(BoxAdminSettings boxAdminSettings, SharedPreferences sharedPreferences) {
        String minimumVersion = boxAdminSettings.getMinimumVersion();
        String minimumVersionFailureAction = boxAdminSettings.getMinimumVersionFailureAction();
        String minimumVersionFailureMessage = boxAdminSettings.getMinimumVersionFailureMessage();
        if (minimumVersion == null) {
            return;
        }
        if (minimumVersionFailureMessage == null) {
            sharedPreferences.edit().remove(REQUIRED_MINIMUM_VERSION_MESSAGE_PREFS_KEY).commit();
        } else {
            try {
                if (minimumVersionFailureMessage.length() <= 2 || minimumVersionFailureMessage.equalsIgnoreCase("NA")) {
                    sharedPreferences.edit().remove(REQUIRED_MINIMUM_VERSION_MESSAGE_PREFS_KEY).commit();
                } else {
                    sharedPreferences.edit().putString(REQUIRED_MINIMUM_VERSION_MESSAGE_PREFS_KEY, minimumVersionFailureMessage).commit();
                }
            } catch (Exception e) {
                BoxLogUtils.logException(e);
                return;
            }
        }
        if (minimumVersionFailureAction != null && minimumVersionFailureAction.length() > 0) {
            sharedPreferences.edit().putString(REQUIRED_MINIMUM_VERSION_ACTION_PREFS_KEY, minimumVersionFailureAction).commit();
        }
        sharedPreferences.edit().putInt(REQUIRED_MINIMUM_VERSION_PREFS_KEY, Integer.parseInt(minimumVersion)).commit();
    }

    public static boolean checkMinimumVersion(NotificationServices notificationServices, IntentServices intentServices, int i, SharedPreferences sharedPreferences) {
        try {
            if (MAMPackageManagement.getPackageInfo(ApplicationProvider.application.getPackageManager(), ApplicationProvider.application.getPackageName(), 0).versionCode >= sharedPreferences.getInt(REQUIRED_MINIMUM_VERSION_PREFS_KEY, 1)) {
                return false;
            }
            String string = sharedPreferences.getString(REQUIRED_MINIMUM_VERSION_ACTION_PREFS_KEY, "none");
            string.equals("none");
            String string2 = sharedPreferences.getString(REQUIRED_MINIMUM_VERSION_MESSAGE_PREFS_KEY, CommonBoxUtil.LS(R.string.This_version_of_the_application_is_out_of_date));
            if (string.equals("notify at start")) {
                if (lastMinimumVersionDialogDisplayed == 0) {
                    notificationServices.displayDialog(string2);
                    lastMinimumVersionDialogDisplayed = SystemClock.uptimeMillis();
                }
            } else if (string.equals("notify repeatedly")) {
                if ((i & 1) == 1 && lastMinimumVersionDialogDisplayed + 3600000 <= SystemClock.uptimeMillis()) {
                    notificationServices.displayDialog(string2);
                    lastMinimumVersionDialogDisplayed = SystemClock.uptimeMillis();
                }
            } else if (string.equals("quit application") || string.equals("logout user")) {
                ApplicationProvider.application.startActivity(intentServices.expiredVersionDialogActivityIntent(ApplicationProvider.application, CommonBoxUtil.LS(R.string.You_Must_Update), string2, CommonBoxUtil.LS(R.string.Get_Update)));
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void updateAllowSaveForOfflineSetting(NotificationServices notificationServices, BoxAdminSettings boxAdminSettings, IUserContextManager iUserContextManager, JobManager jobManager, IJobService iJobService) {
        boolean z;
        SharedPreferences.Editor editorEdit = iUserContextManager.getUserSharedPrefs().edit();
        boolean zIsRestrictedToEncryptedClientOnly = boxAdminSettings.isRestrictedToEncryptedClientOnly();
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) ApplicationProvider.getApplication().getSystemService("device_policy");
        boolean z2 = true;
        boolean z3 = devicePolicyManager != null && (devicePolicyManager.getStorageEncryptionStatus() == 3 || devicePolicyManager.getStorageEncryptionStatus() == 5);
        boolean z4 = isSaveOnDeviceAdminDisabled(iUserContextManager.getUserSharedPrefs()) || doesSaveOnDeviceRequireEncryptedDevice(iUserContextManager.getUserSharedPrefs());
        boolean zIsMobilePreviewOnlyOffliningEnabled = isMobilePreviewOnlyOffliningEnabled(iUserContextManager.getUserSharedPrefs());
        editorEdit.putBoolean(IBoxAdminSettings.SETTING_ENABLE_MOBILE_PREVIEW_ONLY_OFFLINING, boxAdminSettings.isMobilePreviewOnlyOffliningEnabled()).commit();
        if (boxAdminSettings.isMobileSaveOnDeviceEnabled()) {
            editorEdit.remove(SAVE_ON_DEVICE_ADMIN_DISABLED_PREFS_KEY).commit();
        } else {
            editorEdit.putBoolean(SAVE_ON_DEVICE_ADMIN_DISABLED_PREFS_KEY, true).commit();
        }
        if (zIsRestrictedToEncryptedClientOnly && !z3) {
            editorEdit.putBoolean(SAVE_ON_DEVICE_NEED_AN_ENCRYPTED_DEVICE_PREFS_KEY, true).commit();
        } else {
            editorEdit.remove(SAVE_ON_DEVICE_NEED_AN_ENCRYPTED_DEVICE_PREFS_KEY).commit();
        }
        if (z4 || !iUserContextManager.getUserSharedPrefs().getBoolean(SAVE_ON_DEVICE_ADMIN_DISABLED_PREFS_KEY, false) || (!BoxModelOfflineManager.userHasOfflineFiles(iUserContextManager) && iUserContextManager.getPreviewStorage().isPreviewCacheEmpty())) {
            z = false;
        } else {
            removeAllOfflineFilesAndFolders(iUserContextManager, jobManager, iJobService);
            notificationServices.displayDialog(R.string.Feature_disabled, R.string.Your_administrator_has_disabled_saving_files_for_offline);
            z = true;
        }
        if (z || z4 || !iUserContextManager.getUserSharedPrefs().getBoolean(SAVE_ON_DEVICE_NEED_AN_ENCRYPTED_DEVICE_PREFS_KEY, false) || !BoxModelOfflineManager.userHasOfflineFiles(iUserContextManager)) {
            z2 = z;
        } else {
            removeAllOfflineFilesAndFolders(iUserContextManager, jobManager, iJobService);
            notificationServices.displayDialog(R.string.Feature_disabled, R.string.Your_administrator_requires_encrypted_device_for_offline);
        }
        if (z2 || !zIsMobilePreviewOnlyOffliningEnabled || isMobilePreviewOnlyOffliningEnabled(iUserContextManager.getUserSharedPrefs()) || !BoxModelOfflineManager.userHasOfflineFiles(iUserContextManager)) {
            return;
        }
        removeAllOfflineFilesAndFolders(iUserContextManager, jobManager, iJobService);
        notificationServices.displayDialog(R.string.Feature_disabled, R.string.Your_administrator_has_disabled_preview_only_offlining);
    }

    public static void removeAllOfflineFilesAndFolders(IUserContextManager iUserContextManager, JobManager jobManager, IJobService iJobService) {
        try {
            BoxModelOfflineManager.removeAllOfflineFileFolders(iUserContextManager, iUserContextManager.getCurrentContext().getKVStore(), jobManager, iJobService).get();
        } catch (InterruptedException e) {
            BoxLogUtils.logException(e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e2) {
            BoxLogUtils.logException(e2);
        }
    }

    public static boolean isMobilePreviewOnlyOffliningEnabled(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(IBoxAdminSettings.SETTING_ENABLE_MOBILE_PREVIEW_ONLY_OFFLINING, false);
    }

    public static boolean isAnnotationsEnabled(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(IBoxAdminSettings.SETTING_ENABLE_VIEWING_ANNOTATIONS, false);
    }

    public static boolean isAnnotationCreationEnabled(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(IBoxAdminSettings.SETTING_ENABLE_CREATING_ANNOTATIONS, false);
    }

    public static boolean isBoxAiPreviewEnabled(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(IBoxAdminSettings.SETTING_ENABLE_BOX_AI_PREVIEW, false);
    }

    public static boolean isBoxAiStudioEnabled(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(IBoxAdminSettings.SETTING_ENABLE_BOX_AI_STUDIO, false);
    }

    public static boolean isBoxAiNotesEnabled(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(IBoxAdminSettings.SETTING_ENABLE_BOX_AI_NOTES, false);
    }

    public static boolean isBoxAiMultidocEnabled(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(IBoxAdminSettings.SETTING_ENABLE_BOX_AI_MULTIDOC, false);
    }

    public static boolean isHubsGalleryEnabled(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(IBoxAdminSettings.SETTING_ENABLE_HUBS_GALLERY, false);
    }

    public static boolean isAxCenterInWebEnabled(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(IBoxAdminSettings.SETTING_AX_CENTER_IN_WEB, false);
    }

    public static boolean isSaveOnDeviceAdminDisabled(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(SAVE_ON_DEVICE_ADMIN_DISABLED_PREFS_KEY, false);
    }

    public static boolean doesSaveOnDeviceRequireEncryptedDevice(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(SAVE_ON_DEVICE_NEED_AN_ENCRYPTED_DEVICE_PREFS_KEY, false);
    }

    public static boolean isIntuneMAMEnabled(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(IBoxAdminSettings.SETTING_ENABLE_INTUNE_MAM, false) || IntuneKeysConfigUtils.isIntuneEnterpriseSet();
    }

    public static void updateRequiresPasscodeLockSetting(BoxAdminSettings boxAdminSettings, SharedPreferences sharedPreferences) {
        Boolean boolValueOf = Boolean.valueOf(boxAdminSettings.isMobilePasscodeLockRequired());
        Integer numValueOf = Integer.valueOf(boxAdminSettings.getIntMobilePasscodeLockInterval());
        if (boolValueOf == null) {
            return;
        }
        if (boolValueOf == null || !boolValueOf.booleanValue()) {
            sharedPreferences.edit().remove(PASSCODE_ADMIN_REQUIRED_PREFS_KEY).commit();
            sharedPreferences.edit().remove(REQUIRED_PASSCODE_DURATION_PREFS_KEY).commit();
        } else {
            sharedPreferences.edit().putBoolean(PASSCODE_ADMIN_REQUIRED_PREFS_KEY, true).commit();
            sharedPreferences.edit().putInt(REQUIRED_PASSCODE_DURATION_PREFS_KEY, (numValueOf.intValue() * 60000) + 1000).apply();
        }
    }

    public static void migrateAdminSettings(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (sharedPreferences.contains(SAVE_FOR_OFFLINE_ADMIN_DISABLED_PREFS_KEY)) {
            editorEdit.putBoolean(SAVE_ON_DEVICE_ADMIN_DISABLED_PREFS_KEY, sharedPreferences.getBoolean(SAVE_FOR_OFFLINE_ADMIN_DISABLED_PREFS_KEY, false));
            editorEdit.remove(SAVE_FOR_OFFLINE_ADMIN_DISABLED_PREFS_KEY);
        }
        if (sharedPreferences.contains(SAVE_FOR_OFFLINE_NEED_AN_ENCRYPTED_DEVICE_PREFS_KEY)) {
            editorEdit.putBoolean(SAVE_ON_DEVICE_NEED_AN_ENCRYPTED_DEVICE_PREFS_KEY, sharedPreferences.getBoolean(SAVE_FOR_OFFLINE_NEED_AN_ENCRYPTED_DEVICE_PREFS_KEY, false));
            editorEdit.remove(SAVE_FOR_OFFLINE_NEED_AN_ENCRYPTED_DEVICE_PREFS_KEY);
        }
        editorEdit.apply();
    }

    public static int getRequiredPasscodeLockInterval(SharedPreferences sharedPreferences) {
        return sharedPreferences.getInt(REQUIRED_PASSCODE_DURATION_PREFS_KEY, -1);
    }

    public static boolean isPasscodeAdminRequired(SharedPreferences sharedPreferences) {
        if (CoreServiceUtils.getIsPinRequiredByMAMPolicy()) {
            return false;
        }
        return sharedPreferences.getBoolean(PASSCODE_ADMIN_REQUIRED_PREFS_KEY, false);
    }

    private static boolean getBooleanAdminSetting(String str, boolean z, IUserContextManager iUserContextManager) {
        return iUserContextManager.getUserSharedPrefs().getBoolean(str, z);
    }

    private static void setBooleanAdminSetting(String str, boolean z, IUserContextManager iUserContextManager) {
        iUserContextManager.getUserSharedPrefs().edit().putBoolean(str, z).apply();
    }

    public static boolean isMobileAutoPhotoUploadEnabled(IUserContextManager iUserContextManager) {
        return getBooleanAdminSetting(IBoxAdminSettings.SETTING_ENABLE_MOBILE_AUTO_PHOTO_UPLOAD, false, iUserContextManager);
    }

    public static void updateIsMobileAutoPhotoUploadEnabled(BoxAdminSettings boxAdminSettings, IUserContextManager iUserContextManager) {
        setBooleanAdminSetting(IBoxAdminSettings.SETTING_ENABLE_MOBILE_AUTO_PHOTO_UPLOAD, boxAdminSettings.isMobileAutoPhotoUploadEnabled(), iUserContextManager);
    }

    public static boolean isMobileCopyPasteEnabled(IUserContextManager iUserContextManager) {
        return getBooleanAdminSetting(IBoxAdminSettings.SETTING_ENABLE_MOBILE_COPY_PASTE, true, iUserContextManager);
    }

    public static void updateIsMobileCopyPasteEnabled(BoxAdminSettings boxAdminSettings, IUserContextManager iUserContextManager) {
        setBooleanAdminSetting(IBoxAdminSettings.SETTING_ENABLE_MOBILE_COPY_PASTE, boxAdminSettings.isMobileCopyPasteEnabled(), iUserContextManager);
    }

    public static boolean isMobileOpenInEnabled(IUserContextManager iUserContextManager) {
        return getBooleanAdminSetting(IBoxAdminSettings.SETTING_ENABLE_MOBILE_OPEN_IN, true, iUserContextManager);
    }

    public static void updateIsMobileOpenInEnabled(BoxAdminSettings boxAdminSettings, IUserContextManager iUserContextManager) {
        setBooleanAdminSetting(IBoxAdminSettings.SETTING_ENABLE_MOBILE_OPEN_IN, boxAdminSettings.isMobileOpenInEnabled(), iUserContextManager);
    }

    public static void updateIsAnnotationsEnabled(BoxAdminSettings boxAdminSettings, IUserContextManager iUserContextManager) {
        setBooleanAdminSetting(IBoxAdminSettings.SETTING_ENABLE_VIEWING_ANNOTATIONS, boxAdminSettings.isAnnotationsEnabled(), iUserContextManager);
    }

    public static void updateIsAnnotationCreationEnabled(BoxAdminSettings boxAdminSettings, IUserContextManager iUserContextManager) {
        setBooleanAdminSetting(IBoxAdminSettings.SETTING_ENABLE_CREATING_ANNOTATIONS, boxAdminSettings.isAnnotationCreationEnabled(), iUserContextManager);
    }

    public static void updateBoxAiPreviewEnabled(IBoxAdminSettings iBoxAdminSettings, IUserContextManager iUserContextManager) {
        setBooleanAdminSetting(IBoxAdminSettings.SETTING_ENABLE_BOX_AI_PREVIEW, iBoxAdminSettings.isBoxAiPreviewEnabled(), iUserContextManager);
    }

    public static void updateBoxAiStudioEnabled(IBoxAdminSettings iBoxAdminSettings, IUserContextManager iUserContextManager) {
        setBooleanAdminSetting(IBoxAdminSettings.SETTING_ENABLE_BOX_AI_STUDIO, iBoxAdminSettings.isBoxAiStudioEnabled(), iUserContextManager);
    }

    public static void updateBoxAiNotesEnabled(IBoxAdminSettings iBoxAdminSettings, IUserContextManager iUserContextManager) {
        setBooleanAdminSetting(IBoxAdminSettings.SETTING_ENABLE_BOX_AI_NOTES, iBoxAdminSettings.isBoxAiNotesEnabled(), iUserContextManager);
    }

    public static void updateBoxAiMultidocEnabled(IBoxAdminSettings iBoxAdminSettings, IUserContextManager iUserContextManager) {
        setBooleanAdminSetting(IBoxAdminSettings.SETTING_ENABLE_BOX_AI_MULTIDOC, iBoxAdminSettings.isBoxAiMultidocEnabled(), iUserContextManager);
    }

    public static void updateHubsGalleryEnabled(IBoxAdminSettings iBoxAdminSettings, IUserContextManager iUserContextManager) {
        setBooleanAdminSetting(IBoxAdminSettings.SETTING_ENABLE_HUBS_GALLERY, iBoxAdminSettings.isHubsGalleryEnabled(), iUserContextManager);
    }

    public static void updateAxCenterInWebEnabled(IBoxAdminSettings iBoxAdminSettings, IUserContextManager iUserContextManager) {
        setBooleanAdminSetting(IBoxAdminSettings.SETTING_AX_CENTER_IN_WEB, iBoxAdminSettings.isAxCenterInWebEnabled(), iUserContextManager);
    }

    public static void updateIsIntuneEnabled(BoxAdminSettings boxAdminSettings, IUserContextManager iUserContextManager) {
        setBooleanAdminSetting(IBoxAdminSettings.SETTING_ENABLE_INTUNE_MAM, boxAdminSettings.isIntuneEnabled(), iUserContextManager);
    }

    public static boolean isMobilePrintEnabled(IUserContextManager iUserContextManager) {
        return getBooleanAdminSetting(IBoxAdminSettings.SETTING_ENABLE_MOBILE_PRINT, true, iUserContextManager);
    }

    public static boolean isMobileSaveOnDeviceEnabled(IUserContextManager iUserContextManager) {
        return getBooleanAdminSetting(IBoxAdminSettings.SETTING_ENABLE_MOBILE_SAVE_ON_DEVICE, !isSaveOnDeviceAdminDisabled(iUserContextManager.getUserSharedPrefs()), iUserContextManager);
    }

    public static void updateIsMobileSaveOnDeviceEnabled(BoxAdminSettings boxAdminSettings, IUserContextManager iUserContextManager) {
        setBooleanAdminSetting(IBoxAdminSettings.SETTING_ENABLE_MOBILE_SAVE_ON_DEVICE, boxAdminSettings.isMobileSaveOnDeviceEnabled(), iUserContextManager);
    }

    public static void updateIsMobilePrintEnabled(BoxAdminSettings boxAdminSettings, IUserContextManager iUserContextManager) {
        setBooleanAdminSetting(IBoxAdminSettings.SETTING_ENABLE_MOBILE_PRINT, boxAdminSettings.isMobilePrintEnabled(), iUserContextManager);
    }

    public static void updateSimpleBooleanMobileSettings(BoxAdminSettings boxAdminSettings, IUserContextManager iUserContextManager) {
        updateIsMobileAutoPhotoUploadEnabled(boxAdminSettings, iUserContextManager);
        updateIsMobileCopyPasteEnabled(boxAdminSettings, iUserContextManager);
        updateIsMobileOpenInEnabled(boxAdminSettings, iUserContextManager);
        updateIsMobilePrintEnabled(boxAdminSettings, iUserContextManager);
        updateIsAnnotationsEnabled(boxAdminSettings, iUserContextManager);
        updateIsAnnotationCreationEnabled(boxAdminSettings, iUserContextManager);
        updateIsIntuneEnabled(boxAdminSettings, iUserContextManager);
        updateIsMobileSaveOnDeviceEnabled(boxAdminSettings, iUserContextManager);
        updateBoxAiPreviewEnabled(boxAdminSettings, iUserContextManager);
        updateBoxAiStudioEnabled(boxAdminSettings, iUserContextManager);
        updateBoxAiNotesEnabled(boxAdminSettings, iUserContextManager);
        updateBoxAiMultidocEnabled(boxAdminSettings, iUserContextManager);
        updateHubsGalleryEnabled(boxAdminSettings, iUserContextManager);
        updateAxCenterInWebEnabled(boxAdminSettings, iUserContextManager);
    }

    public static class Manager {
        private final HashMap<BoxItem.Permission, Integer> mItemsWithPermission = new HashMap<>();

        @Inject
        public Manager() {
        }

        public void addItem(BoxItem boxItem) {
            for (BoxItem.Permission permission : boxItem.getPermissions()) {
                String fileExtension = CommonBoxUtil.getFileExtension(boxItem.getName(), "");
                if (permission != BoxItem.Permission.CAN_DOWNLOAD || !SupportedFileExtensions.INSTANCE.isBoxNoteExtension(fileExtension)) {
                    Integer num = this.mItemsWithPermission.get(permission);
                    if (num == null) {
                        num = 0;
                    }
                    this.mItemsWithPermission.put(permission, Integer.valueOf(num.intValue() + 1));
                }
            }
        }

        public void removeItem(BoxItem boxItem) {
            for (BoxItem.Permission permission : boxItem.getPermissions()) {
                String fileExtension = CommonBoxUtil.getFileExtension(boxItem.getName(), "");
                if (permission != BoxItem.Permission.CAN_DOWNLOAD || !SupportedFileExtensions.INSTANCE.isBoxNoteExtension(fileExtension)) {
                    Integer num = this.mItemsWithPermission.get(permission);
                    if (num != null && num.intValue() > 1) {
                        this.mItemsWithPermission.put(permission, Integer.valueOf(num.intValue() - 1));
                    } else {
                        this.mItemsWithPermission.remove(permission);
                    }
                }
            }
        }

        public void clear() {
            this.mItemsWithPermission.clear();
        }

        public Set<BoxItem.Permission> getCumulativePermissions() {
            return this.mItemsWithPermission.keySet();
        }
    }
}
