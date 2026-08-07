package com.box.boxandroidlibv2private.dao;

import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

/* JADX INFO: loaded from: classes13.dex */
@Deprecated
public class BoxAdminSettings extends BoxEntity implements IBoxAdminSettings {
    public static final String TYPE = "boxAdminSettings";
    private static final long serialVersionUID = 1699690660113781694L;

    public BoxAdminSettings() {
    }

    public BoxAdminSettings(JsonObject jsonObject) {
        super(jsonObject);
    }

    public void setType() {
        set("type", TYPE);
    }

    @Override // com.box.boxandroidlibv2private.dao.IBoxAdminSettings
    public boolean isRestrictedToEncryptedClientOnly() {
        return "on".equals(getRestrictToEncryptedClientOnly());
    }

    @Override // com.box.boxandroidlibv2private.dao.IBoxAdminSettings
    public int getIntMobilePasscodeLockInterval() {
        Integer numValueOf;
        Object value = getValue(IBoxAdminSettings.SETTING_MOBILE_PASSCODE_LOCK_INTERVAL);
        try {
            try {
                numValueOf = (Integer) value;
            } catch (ClassCastException unused) {
                if (value instanceof String) {
                    numValueOf = Integer.valueOf(Integer.parseInt((String) value));
                } else {
                    throw new NumberFormatException();
                }
            }
        } catch (NumberFormatException unused2) {
            BoxLogUtils.e("BoxAdminSettings", "Could not read passcode lock interval.");
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }

    @Override // com.box.boxandroidlibv2private.dao.IBoxAdminSettings
    public boolean isMobilePasscodeLockRequired() {
        return "on".equals(getRequireMobilePasscodeLock());
    }

    @Override // com.box.boxandroidlibv2private.dao.IBoxAdminSettings
    public String getMinimumVersion() {
        Object value = getValue(IBoxAdminSettings.SETTING_MINIMUM_VERSION);
        if (value instanceof Integer) {
            return Integer.toString(((Integer) value).intValue());
        }
        return (String) value;
    }

    @Override // com.box.boxandroidlibv2private.dao.IBoxAdminSettings
    public String getMinimumVersionFailureMessage() {
        return getStringValue(IBoxAdminSettings.SETTING_MINIMUM_VERSION_FAILURE_MESSAGE);
    }

    @Override // com.box.boxandroidlibv2private.dao.IBoxAdminSettings
    public String getMinimumVersionFailureAction() {
        return getStringValue(IBoxAdminSettings.SETTING_MINIMUM_VERSION_FAILURE_ACTION);
    }

    protected String getRestrictToEncryptedClientOnly() {
        return getStringValue(IBoxAdminSettings.SETTING_RESTRICT_TO_ENCRYPTED_CLIENT);
    }

    protected String getRequireMobilePasscodeLock() {
        return getStringValue(IBoxAdminSettings.SETTING_REQUIRE_MOBILE_PASSCODE_LOCK);
    }

    protected String getEnableMobilePhotoAutoUpload() {
        return getStringValue(IBoxAdminSettings.SETTING_ENABLE_MOBILE_AUTO_PHOTO_UPLOAD);
    }

    protected String getEnableMobileCopyPaste() {
        return getStringValue(IBoxAdminSettings.SETTING_ENABLE_MOBILE_COPY_PASTE);
    }

    protected String getEnableMobileOpenIn() {
        return getStringValue(IBoxAdminSettings.SETTING_ENABLE_MOBILE_OPEN_IN);
    }

    protected String getEnableMobilePrint() {
        return getStringValue(IBoxAdminSettings.SETTING_ENABLE_MOBILE_PRINT);
    }

    protected String getEnableMobileSaveOnDevice() {
        return getStringValue(IBoxAdminSettings.SETTING_ENABLE_MOBILE_SAVE_ON_DEVICE);
    }

    @Override // com.box.boxandroidlibv2private.dao.IBoxAdminSettings
    public boolean isMobileAutoPhotoUploadEnabled() {
        return "on".equals(getEnableMobilePhotoAutoUpload());
    }

    @Override // com.box.boxandroidlibv2private.dao.IBoxAdminSettings
    public boolean isMobileCopyPasteEnabled() {
        return !"off".equals(getEnableMobileCopyPaste());
    }

    @Override // com.box.boxandroidlibv2private.dao.IBoxAdminSettings
    public boolean isMobileOpenInEnabled() {
        return !"off".equals(getEnableMobileOpenIn());
    }

    @Override // com.box.boxandroidlibv2private.dao.IBoxAdminSettings
    public boolean isMobilePrintEnabled() {
        return !"off".equals(getEnableMobilePrint());
    }

    @Override // com.box.boxandroidlibv2private.dao.IBoxAdminSettings
    public boolean isMobileSaveOnDeviceEnabled() {
        return !"off".equals(getEnableMobileSaveOnDevice());
    }

    public String getEnableMobilePreviewOnlyOfflining() {
        return getStringValue(IBoxAdminSettings.SETTING_ENABLE_MOBILE_PREVIEW_ONLY_OFFLINING);
    }

    public String getEnableAnnotations() {
        return getStringValue(IBoxAdminSettings.SETTING_ENABLE_VIEWING_ANNOTATIONS);
    }

    public String getEnableAnnotationsCreate() {
        return getStringValue(IBoxAdminSettings.SETTING_ENABLE_CREATING_ANNOTATIONS);
    }

    public String getEnableIntuneMAM() {
        return getStringValue(IBoxAdminSettings.SETTING_ENABLE_INTUNE_MAM);
    }

    public String getEnabledBoxAiPreview() {
        return getStringValue(IBoxAdminSettings.SETTING_ENABLE_BOX_AI_PREVIEW);
    }

    public String getEnabledBoxAiStudio() {
        return getStringValue(IBoxAdminSettings.SETTING_ENABLE_BOX_AI_STUDIO);
    }

    public String getEnabledBoxAiNotes() {
        return getStringValue(IBoxAdminSettings.SETTING_ENABLE_BOX_AI_NOTES);
    }

    public String getEnabledBoxAiMultidoc() {
        return getStringValue(IBoxAdminSettings.SETTING_ENABLE_BOX_AI_MULTIDOC);
    }

    public String getEnabledHubsGallery() {
        return getStringValue(IBoxAdminSettings.SETTING_ENABLE_HUBS_GALLERY);
    }

    public String getEnabledAxCenterInWeb() {
        return getStringValue(IBoxAdminSettings.SETTING_AX_CENTER_IN_WEB);
    }

    @Override // com.box.boxandroidlibv2private.dao.IBoxAdminSettings
    public boolean isMobilePreviewOnlyOffliningEnabled() {
        return "on".equals(getEnableMobilePreviewOnlyOfflining());
    }

    @Override // com.box.boxandroidlibv2private.dao.IBoxAdminSettings
    public boolean isAnnotationsEnabled() {
        return "on".equals(getEnableAnnotations());
    }

    @Override // com.box.boxandroidlibv2private.dao.IBoxAdminSettings
    public boolean isAnnotationCreationEnabled() {
        return "on".equals(getEnableAnnotationsCreate());
    }

    @Override // com.box.boxandroidlibv2private.dao.IBoxAdminSettings
    public boolean isIntuneEnabled() {
        return "on".equals(getEnableIntuneMAM());
    }

    @Override // com.box.boxandroidlibv2private.dao.IBoxAdminSettings
    public boolean isBoxAiPreviewEnabled() {
        return "on".equals(getEnabledBoxAiPreview());
    }

    @Override // com.box.boxandroidlibv2private.dao.IBoxAdminSettings
    public boolean isBoxAiStudioEnabled() {
        return "on".equals(getEnabledBoxAiStudio());
    }

    @Override // com.box.boxandroidlibv2private.dao.IBoxAdminSettings
    public boolean isBoxAiNotesEnabled() {
        return "on".equals(getEnabledBoxAiNotes());
    }

    @Override // com.box.boxandroidlibv2private.dao.IBoxAdminSettings
    public boolean isBoxAiMultidocEnabled() {
        return "on".equals(getEnabledBoxAiMultidoc());
    }

    @Override // com.box.boxandroidlibv2private.dao.IBoxAdminSettings
    public boolean isHubsGalleryEnabled() {
        return "on".equals(getEnabledHubsGallery());
    }

    @Override // com.box.boxandroidlibv2private.dao.IBoxAdminSettings
    public boolean isAxCenterInWebEnabled() {
        return "on".equals(getEnabledAxCenterInWeb());
    }

    public BoxObservability getObservability() {
        return (BoxObservability) getPropertyAsJsonObject(BoxJsonObject.getBoxJsonObjectCreator(BoxObservability.class), "observability");
    }

    @Override // com.box.boxandroidlibv2private.dao.IBoxAdminSettings
    public String getStringValue(String str) {
        return (String) getValue(str);
    }

    @Override // com.box.boxandroidlibv2private.dao.IBoxAdminSettings
    public Object getValue(String str) {
        JsonValue propertyValue = getPropertyValue(str);
        if (propertyValue == null) {
            return null;
        }
        if (propertyValue.isString()) {
            return propertyValue.asString();
        }
        if (propertyValue.isBoolean()) {
            return Boolean.valueOf(propertyValue.asBoolean());
        }
        if (propertyValue.isNumber()) {
            return Integer.valueOf(propertyValue.asInt());
        }
        if (propertyValue.isObject()) {
            return propertyValue.asObject();
        }
        return null;
    }
}
