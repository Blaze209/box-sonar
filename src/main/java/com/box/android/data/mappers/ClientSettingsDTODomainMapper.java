package com.box.android.data.mappers;

import com.box.android.data.api.models.ClientSettingsDTO;
import com.box.android.data.api.models.LicenseKeys;
import com.box.android.data.api.models.ObservabilityDTO;
import com.box.android.domain.models.ClientSettingsModel;
import com.box.boxandroidlibv2private.dao.BoxAdminSettings;
import com.box.boxandroidlibv2private.dao.BoxObservability;
import com.box.boxandroidlibv2private.dao.IBoxAdminSettings;
import com.eclipsesource.json.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ClientSettingsDTODomainMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006J\n\u0010\u0007\u001a\u00020\b*\u00020\u0005J!\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010\u000fJ\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010\u0012J\u0015\u0010\u0013\u001a\u0004\u0018\u00010\f*\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/mappers/ClientSettingsDTODomainMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/ClientSettingsModel;", "Lcom/box/android/data/api/models/ClientSettingsDTO;", "toBoxAdminSettings", "Lcom/box/boxandroidlibv2private/dao/BoxAdminSettings;", "observabilityJsonObject", "Lcom/eclipsesource/json/JsonObject;", "rumProxyUrl", "", "rumSamplingRatio", "", "(Ljava/lang/String;Ljava/lang/Double;)Lcom/eclipsesource/json/JsonObject;", "toBoolean", "", "(Ljava/lang/String;)Ljava/lang/Boolean;", "toSettingsBooleanString", "(Ljava/lang/Boolean;)Ljava/lang/String;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ClientSettingsDTODomainMapper {
    public static final ClientSettingsDTODomainMapper INSTANCE = new ClientSettingsDTODomainMapper();

    private ClientSettingsDTODomainMapper() {
    }

    public final ClientSettingsModel toDomain(ClientSettingsDTO clientSettingsDTO) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(clientSettingsDTO, "<this>");
        LicenseKeys licenseKeys = clientSettingsDTO.getLicenseKeys();
        String geniusScanKey = licenseKeys != null ? licenseKeys.getGeniusScanKey() : null;
        ObservabilityDTO observability = clientSettingsDTO.getObservability();
        String rumProxyUrl = observability != null ? observability.getRumProxyUrl() : null;
        ObservabilityDTO observability2 = clientSettingsDTO.getObservability();
        Double rumSamplingRatio = observability2 != null ? observability2.getRumSamplingRatio() : null;
        String minimumVersion = clientSettingsDTO.getMinimumVersion();
        String minimumVersionFailureMessage = clientSettingsDTO.getMinimumVersionFailureMessage();
        String minimumVersionFailureAction = clientSettingsDTO.getMinimumVersionFailureAction();
        String mobilePasscodeLockInterval = clientSettingsDTO.getMobilePasscodeLockInterval();
        return new ClientSettingsModel(geniusScanKey, rumProxyUrl, rumSamplingRatio, minimumVersion, minimumVersionFailureMessage, minimumVersionFailureAction, (mobilePasscodeLockInterval == null || (intOrNull = StringsKt.toIntOrNull(mobilePasscodeLockInterval)) == null) ? 0 : intOrNull.intValue(), toBoolean(clientSettingsDTO.getRequireMobilePasscodeLock()), toBoolean(clientSettingsDTO.getEnableMobileSaveOnDevice()), toBoolean(clientSettingsDTO.getRestrictToEncryptedClientOnly()), toBoolean(clientSettingsDTO.getEnableMobileCopyPaste()), toBoolean(clientSettingsDTO.getEnableMobilePrint()), toBoolean(clientSettingsDTO.getEnableMobileOpenIn()), toBoolean(clientSettingsDTO.getEnableMobileAutoPhotoUpload()), toBoolean(clientSettingsDTO.getEnableMobilePreviewOnlyOfflining()), toBoolean(clientSettingsDTO.getEnableViewingAnnotations()), toBoolean(clientSettingsDTO.getEnableCreatingAnnotations()), toBoolean(clientSettingsDTO.getIntuneMAMEnabled()), toBoolean(clientSettingsDTO.getEnableBoxAiPreview()), toBoolean(clientSettingsDTO.getEnableBoxAiStudio()), toBoolean(clientSettingsDTO.getEnableBoxAiNotes()), toBoolean(clientSettingsDTO.getEnableBoxAiMultidoc()), toBoolean(clientSettingsDTO.getEnableHubsGallery()), toBoolean(clientSettingsDTO.getEnableHubsAi()), toBoolean(clientSettingsDTO.getAxCenterInWeb()), clientSettingsDTO.getWopiServiceId());
    }

    public final BoxAdminSettings toBoxAdminSettings(ClientSettingsModel clientSettingsModel) {
        Intrinsics.checkNotNullParameter(clientSettingsModel, "<this>");
        JsonObject jsonObject = new JsonObject();
        String minimumVersion = clientSettingsModel.getMinimumVersion();
        if (minimumVersion != null) {
            jsonObject.add(IBoxAdminSettings.SETTING_MINIMUM_VERSION, minimumVersion);
        }
        jsonObject.add(IBoxAdminSettings.SETTING_MOBILE_PASSCODE_LOCK_INTERVAL, clientSettingsModel.getPasscodeLockInterval());
        jsonObject.add(IBoxAdminSettings.SETTING_MINIMUM_VERSION_FAILURE_MESSAGE, clientSettingsModel.getMinimumVersionFailureMessage());
        jsonObject.add(IBoxAdminSettings.SETTING_MINIMUM_VERSION_FAILURE_ACTION, clientSettingsModel.getMinimumVersionFailureAction());
        ClientSettingsDTODomainMapper clientSettingsDTODomainMapper = INSTANCE;
        jsonObject.add(IBoxAdminSettings.SETTING_RESTRICT_TO_ENCRYPTED_CLIENT, clientSettingsDTODomainMapper.toSettingsBooleanString(clientSettingsModel.isEncryptedDeviceRequired()));
        jsonObject.add(IBoxAdminSettings.SETTING_REQUIRE_MOBILE_PASSCODE_LOCK, clientSettingsDTODomainMapper.toSettingsBooleanString(clientSettingsModel.isPasscodeLockRequired()));
        jsonObject.add(IBoxAdminSettings.SETTING_ENABLE_MOBILE_AUTO_PHOTO_UPLOAD, clientSettingsDTODomainMapper.toSettingsBooleanString(clientSettingsModel.isAutoPhotoUploadAllowed()));
        jsonObject.add(IBoxAdminSettings.SETTING_ENABLE_MOBILE_COPY_PASTE, clientSettingsDTODomainMapper.toSettingsBooleanString(clientSettingsModel.isCopyPasteAllowed()));
        jsonObject.add(IBoxAdminSettings.SETTING_ENABLE_MOBILE_OPEN_IN, clientSettingsDTODomainMapper.toSettingsBooleanString(clientSettingsModel.isOpenInAllowed()));
        jsonObject.add(IBoxAdminSettings.SETTING_ENABLE_MOBILE_PRINT, clientSettingsDTODomainMapper.toSettingsBooleanString(clientSettingsModel.isPrintAllowed()));
        jsonObject.add(IBoxAdminSettings.SETTING_ENABLE_MOBILE_SAVE_ON_DEVICE, clientSettingsDTODomainMapper.toSettingsBooleanString(clientSettingsModel.isSaveOnDeviceAllowed()));
        jsonObject.add(IBoxAdminSettings.SETTING_ENABLE_MOBILE_PREVIEW_ONLY_OFFLINING, clientSettingsDTODomainMapper.toSettingsBooleanString(clientSettingsModel.isPreviewOnlyOffliningEnabled()));
        jsonObject.add(IBoxAdminSettings.SETTING_ENABLE_VIEWING_ANNOTATIONS, clientSettingsDTODomainMapper.toSettingsBooleanString(clientSettingsModel.isViewingAnnotationsAllowed()));
        jsonObject.add(IBoxAdminSettings.SETTING_ENABLE_CREATING_ANNOTATIONS, clientSettingsDTODomainMapper.toSettingsBooleanString(clientSettingsModel.isCreatingAnnotationsAllowed()));
        jsonObject.add(IBoxAdminSettings.SETTING_ENABLE_BOX_AI_PREVIEW, clientSettingsDTODomainMapper.toSettingsBooleanString(clientSettingsModel.isBoxAiPreviewEnabled()));
        jsonObject.add(IBoxAdminSettings.SETTING_ENABLE_BOX_AI_STUDIO, clientSettingsDTODomainMapper.toSettingsBooleanString(clientSettingsModel.isBoxAiStudioEnabled()));
        jsonObject.add(IBoxAdminSettings.SETTING_ENABLE_BOX_AI_NOTES, clientSettingsDTODomainMapper.toSettingsBooleanString(clientSettingsModel.isBoxAiNotesEnabled()));
        jsonObject.add(IBoxAdminSettings.SETTING_ENABLE_BOX_AI_MULTIDOC, clientSettingsDTODomainMapper.toSettingsBooleanString(clientSettingsModel.isBoxAiMultidocEnabled()));
        jsonObject.add(IBoxAdminSettings.SETTING_ENABLE_HUBS_GALLERY, clientSettingsDTODomainMapper.toSettingsBooleanString(clientSettingsModel.isHubsGalleryEnabled()));
        jsonObject.add(IBoxAdminSettings.SETTING_ENABLE_HUBS_AI, clientSettingsDTODomainMapper.toSettingsBooleanString(clientSettingsModel.isHubsAIEnabled()));
        jsonObject.add(IBoxAdminSettings.SETTING_AX_CENTER_IN_WEB, clientSettingsDTODomainMapper.toSettingsBooleanString(clientSettingsModel.isAxCenterInWebEnabled()));
        jsonObject.add(IBoxAdminSettings.SETTING_ENABLE_INTUNE_MAM, clientSettingsDTODomainMapper.toSettingsBooleanString(clientSettingsModel.isIntuneMAMEnabled()));
        jsonObject.add(IBoxAdminSettings.SETTING_WOPI_SERVICE_ID, clientSettingsModel.getWopiServiceId());
        jsonObject.add("observability", clientSettingsDTODomainMapper.observabilityJsonObject(clientSettingsModel.getRumProxyUrl(), clientSettingsModel.getRumSamplingRatio()));
        jsonObject.set("type", BoxAdminSettings.TYPE);
        return new BoxAdminSettings(jsonObject);
    }

    private final JsonObject observabilityJsonObject(String rumProxyUrl, Double rumSamplingRatio) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(BoxObservability.RUM_PROXY_URL, rumProxyUrl);
        if (rumSamplingRatio != null) {
            jsonObject.add(BoxObservability.RUM_SAMPLING_RATIO, rumSamplingRatio.doubleValue());
        }
        return jsonObject;
    }

    private final Boolean toBoolean(String str) {
        if (Intrinsics.areEqual(str, "on")) {
            return true;
        }
        return Intrinsics.areEqual(str, "off") ? false : null;
    }

    private final String toSettingsBooleanString(Boolean bool) {
        if (Intrinsics.areEqual((Object) bool, (Object) true)) {
            return "on";
        }
        if (Intrinsics.areEqual((Object) bool, (Object) false)) {
            return "off";
        }
        return null;
    }
}
