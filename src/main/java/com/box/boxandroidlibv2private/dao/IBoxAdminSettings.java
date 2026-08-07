package com.box.boxandroidlibv2private.dao;

/* JADX INFO: loaded from: classes13.dex */
public interface IBoxAdminSettings {
    public static final String SETTING_AX_CENTER_IN_WEB = "ax_center_in_web";
    public static final String SETTING_ENABLE_BOX_AI_MULTIDOC = "enable_box_ai_multidoc";
    public static final String SETTING_ENABLE_BOX_AI_NOTES = "enable_box_ai_notes";
    public static final String SETTING_ENABLE_BOX_AI_PREVIEW = "enable_box_ai_preview";
    public static final String SETTING_ENABLE_BOX_AI_STUDIO = "enable_box_ai_studio";
    public static final String SETTING_ENABLE_CREATING_ANNOTATIONS = "enable_creating_annotations";
    public static final String SETTING_ENABLE_HUBS_AI = "enable_box_ai_hubs";
    public static final String SETTING_ENABLE_HUBS_GALLERY = "enable_hubs_gallery";
    public static final String SETTING_ENABLE_INTUNE_MAM = "has_intune_mam_enabled";
    public static final String SETTING_ENABLE_MOBILE_AUTO_PHOTO_UPLOAD = "enable_mobile_auto_photo_upload";
    public static final String SETTING_ENABLE_MOBILE_COPY_PASTE = "enable_mobile_copy_paste";
    public static final String SETTING_ENABLE_MOBILE_OPEN_IN = "enable_mobile_open_in";
    public static final String SETTING_ENABLE_MOBILE_PREVIEW_ONLY_OFFLINING = "enable_mobile_preview_only_offlining";
    public static final String SETTING_ENABLE_MOBILE_PRINT = "enable_mobile_print";
    public static final String SETTING_ENABLE_MOBILE_SAVE_ON_DEVICE = "enable_mobile_save_on_device";
    public static final String SETTING_ENABLE_VIEWING_ANNOTATIONS = "enable_viewing_annotations";
    public static final String SETTING_MINIMUM_VERSION = "minimum_version";
    public static final String SETTING_MINIMUM_VERSION_FAILURE_ACTION = "minimum_version_failure_action";
    public static final String SETTING_MINIMUM_VERSION_FAILURE_MESSAGE = "minimum_version_failure_message";
    public static final String SETTING_MOBILE_PASSCODE_LOCK_INTERVAL = "mobile_passcode_lock_interval";
    public static final String SETTING_OBSERVABILITY = "observability";
    public static final String SETTING_REQUIRE_MOBILE_PASSCODE_LOCK = "require_mobile_passcode_lock";
    public static final String SETTING_RESTRICT_TO_ENCRYPTED_CLIENT = "restrict_to_encrypted_client_only";
    public static final String SETTING_VALUE_ENABLE_OFF = "off";
    public static final String SETTING_VALUE_ENABLE_ON = "on";
    public static final int SETTING_VALUE_NO_PASSCODE_LOCK = 0;
    public static final String SETTING_VALUE_REQUIRE_MOBILE_PASSCODE_LOCK_ON = "on";
    public static final String SETTING_VALUE_RESTRICT_TO_ENCRYPTED_CLIENT_ONLY_ON = "on";
    public static final String SETTING_WOPI_SERVICE_ID = "wopi_service_id";

    int getIntMobilePasscodeLockInterval();

    String getMinimumVersion();

    String getMinimumVersionFailureAction();

    String getMinimumVersionFailureMessage();

    String getStringValue(String str);

    Object getValue(String str);

    boolean isAnnotationCreationEnabled();

    boolean isAnnotationsEnabled();

    boolean isAxCenterInWebEnabled();

    boolean isBoxAiMultidocEnabled();

    boolean isBoxAiNotesEnabled();

    boolean isBoxAiPreviewEnabled();

    boolean isBoxAiStudioEnabled();

    boolean isHubsGalleryEnabled();

    boolean isIntuneEnabled();

    boolean isMobileAutoPhotoUploadEnabled();

    boolean isMobileCopyPasteEnabled();

    boolean isMobileOpenInEnabled();

    boolean isMobilePasscodeLockRequired();

    boolean isMobilePreviewOnlyOffliningEnabled();

    boolean isMobilePrintEnabled();

    boolean isMobileSaveOnDeviceEnabled();

    boolean isRestrictedToEncryptedClientOnly();
}
