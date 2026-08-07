package com.box.android.preview.wopi;

import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.ClientSettingsModel;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.services.IClientSettingsService;
import com.box.android.domain.utils.result.ResultKt;
import com.box.androidsdk.content.auth.OAuthActivity;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WopiService.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0002J*\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/box/android/preview/wopi/WopiService;", "Lcom/box/android/preview/wopi/IWopiService;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "officeAppDetector", "Lcom/box/android/preview/wopi/IOfficeAppDetector;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "clientSettingsService", "Lcom/box/android/domain/services/IClientSettingsService;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/preview/wopi/IOfficeAppDetector;Lcom/box/android/domain/configuration/FeatureFlips;Lcom/box/android/domain/services/IClientSettingsService;)V", "getWopiConfiguration", "Lcom/box/android/preview/wopi/WopiConfiguration;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "resolveServiceId", "", "buildWopiUrl", OAuthActivity.USER_ID, "appType", "Lcom/box/android/preview/wopi/OfficeAppType;", "serviceId", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WopiService implements IWopiService {

    @Deprecated
    public static final String BOX = "box";

    @Deprecated
    public static final String EXCEL_SCHEME = "ms-excel";

    @Deprecated
    public static final String POWERPOINT_SCHEME = "ms-powerpoint";

    @Deprecated
    public static final String WORD_SCHEME = "ms-word";
    private final IClientSettingsService clientSettingsService;
    private final FeatureFlips featureFlips;
    private final IOfficeAppDetector officeAppDetector;
    private final IUserContextManager userContextManager;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    @Deprecated
    public static final String SERVICE_ID = "TP_BOX";

    @Deprecated
    public static final String COAUTH_SERVICE_ID = "TP_BOX_2";
    private static final Set<String> VALID_SERVICE_IDS = SetsKt.setOf((Object[]) new String[]{SERVICE_ID, COAUTH_SERVICE_ID});

    /* JADX INFO: compiled from: WopiService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OfficeAppType.values().length];
            try {
                iArr[OfficeAppType.WORD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OfficeAppType.POWERPOINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OfficeAppType.EXCEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OfficeAppType.OFFICE_365.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public WopiService(IUserContextManager userContextManager, IOfficeAppDetector officeAppDetector, FeatureFlips featureFlips, IClientSettingsService clientSettingsService) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(officeAppDetector, "officeAppDetector");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(clientSettingsService, "clientSettingsService");
        this.userContextManager = userContextManager;
        this.officeAppDetector = officeAppDetector;
        this.featureFlips = featureFlips;
        this.clientSettingsService = clientSettingsService;
    }

    /* JADX INFO: compiled from: WopiService.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/preview/wopi/WopiService$Companion;", "", "<init>", "()V", "COAUTH_SERVICE_ID", "", "SERVICE_ID", "VALID_SERVICE_IDS", "", "getVALID_SERVICE_IDS", "()Ljava/util/Set;", "WORD_SCHEME", "POWERPOINT_SCHEME", "EXCEL_SCHEME", "BOX", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<String> getVALID_SERVICE_IDS() {
            return WopiService.VALID_SERVICE_IDS;
        }
    }

    @Override // com.box.android.preview.wopi.IWopiService
    public WopiConfiguration getWopiConfiguration(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        OfficeAppType officeAppTypeDetectInstalledApp = this.officeAppDetector.detectInstalledApp(fileModel.getName());
        if (officeAppTypeDetectInstalledApp == null) {
            return null;
        }
        String id = this.userContextManager.getUserInfo().getUserId();
        String strResolveServiceId = resolveServiceId();
        Intrinsics.checkNotNull(id);
        String strBuildWopiUrl = buildWopiUrl(fileModel, id, officeAppTypeDetectInstalledApp, strResolveServiceId);
        if (strBuildWopiUrl == null) {
            return null;
        }
        BoxLogUtils.v("WOPI", "constructed WOPI URL -> " + strBuildWopiUrl);
        PermissionsModel permissions = fileModel.getPermissions();
        return new WopiConfiguration(officeAppTypeDetectInstalledApp, strBuildWopiUrl, permissions != null && permissions.getCanRename(), fileModel.getExtension(), strResolveServiceId);
    }

    private final String resolveServiceId() {
        if (!this.featureFlips.getUseCoAuthoring().getEnabled()) {
            return SERVICE_ID;
        }
        ClientSettingsModel clientSettingsModel = (ClientSettingsModel) ResultKt.getOrNull(this.clientSettingsService.getClientSettingsLocal());
        String wopiServiceId = clientSettingsModel != null ? clientSettingsModel.getWopiServiceId() : null;
        if (wopiServiceId != null) {
            String str = VALID_SERVICE_IDS.contains(wopiServiceId) ? wopiServiceId : null;
            if (str != null) {
                return str;
            }
        }
        return SERVICE_ID;
    }

    private final String buildWopiUrl(FileModel fileModel, String userId, OfficeAppType appType, String serviceId) {
        String str;
        String boxId;
        int i = WhenMappings.$EnumSwitchMapping$0[appType.ordinal()];
        if (i == 1) {
            str = WORD_SCHEME;
        } else if (i == 2) {
            str = POWERPOINT_SCHEME;
        } else {
            if (i != 3) {
                if (i == 4) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
            str = EXCEL_SCHEME;
        }
        PermissionsModel permissions = fileModel.getPermissions();
        String str2 = (permissions == null || !permissions.getCanRename()) ? "ofv" : "ofe";
        String name = fileModel.getName();
        ItemId itemId = fileModel.getItemId();
        ItemId.Remote remote = itemId instanceof ItemId.Remote ? (ItemId.Remote) itemId : null;
        if (remote == null || (boxId = remote.getBoxId()) == null) {
            return null;
        }
        return str + ":" + str2 + "|u|https://api.box.com/wopi/files/" + boxId + "|d|" + serviceId + "|e|" + userId + "|n|" + name + "|a|App";
    }
}
