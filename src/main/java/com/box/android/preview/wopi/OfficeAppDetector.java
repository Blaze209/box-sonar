package com.box.android.preview.wopi;

import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfficeAppDetector.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\tH\u0002¨\u0006\u000e"}, d2 = {"Lcom/box/android/preview/wopi/OfficeAppDetector;", "Lcom/box/android/preview/wopi/IOfficeAppDetector;", "<init>", "()V", "detectInstalledApp", "Lcom/box/android/preview/wopi/OfficeAppType;", BoxCommonConstants.EXTRA_FILE_NAME, "", "isOfficeFile", "", "isAppInstalled", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "isOfficeHubInstalled", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OfficeAppDetector implements IOfficeAppDetector {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final long MIN_VERSION_CODE = 1601241000;

    @Deprecated
    public static final String MSEXCEL_APP = "com.microsoft.office.excel";

    @Deprecated
    public static final String MSOFFICE_APP = "com.microsoft.office.officehubrow";

    @Deprecated
    public static final String MSPOWERPOINT_APP = "com.microsoft.office.powerpoint";

    @Deprecated
    public static final String MSWORD_APP = "com.microsoft.office.word";

    @Inject
    public OfficeAppDetector() {
    }

    /* JADX INFO: compiled from: OfficeAppDetector.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/box/android/preview/wopi/OfficeAppDetector$Companion;", "", "<init>", "()V", "MSOFFICE_APP", "", "MSWORD_APP", "MSEXCEL_APP", "MSPOWERPOINT_APP", "MIN_VERSION_CODE", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.box.android.preview.wopi.IOfficeAppDetector
    public OfficeAppType detectInstalledApp(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        String fileExtension = CommonBoxUtil.getFileExtension(fileName, "");
        if (SupportedFileExtensions.INSTANCE.isMicrosoftWordExtension(fileExtension) && isAppInstalled(MSWORD_APP)) {
            return OfficeAppType.WORD;
        }
        if (SupportedFileExtensions.INSTANCE.isMicrosoftPowerPointExtension(fileExtension) && isAppInstalled(MSPOWERPOINT_APP)) {
            return OfficeAppType.POWERPOINT;
        }
        if (SupportedFileExtensions.INSTANCE.isMicrosoftExcelExtension(fileExtension) && isAppInstalled(MSEXCEL_APP)) {
            return OfficeAppType.EXCEL;
        }
        if (SupportedFileExtensions.INSTANCE.isMicrosoftOfficeExtension(fileExtension) && isOfficeHubInstalled()) {
            return OfficeAppType.OFFICE_365;
        }
        return null;
    }

    @Override // com.box.android.preview.wopi.IOfficeAppDetector
    public boolean isOfficeFile(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return SupportedFileExtensions.INSTANCE.isMicrosoftOfficeExtension(CommonBoxUtil.getFileExtension(fileName, ""));
    }

    private final boolean isAppInstalled(String packageName) {
        return CommonBoxUtil.doesPackageExistWithMinimumVersionCode(packageName, MIN_VERSION_CODE);
    }

    private final boolean isOfficeHubInstalled() {
        return CommonBoxUtil.doesPackageExist(MSOFFICE_APP);
    }
}
