package com.box.android.preview.wopi;

import com.box.android.common.utilities.BoxCommonConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: OfficeAppDetector.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/preview/wopi/IOfficeAppDetector;", "", "detectInstalledApp", "Lcom/box/android/preview/wopi/OfficeAppType;", BoxCommonConstants.EXTRA_FILE_NAME, "", "isOfficeFile", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IOfficeAppDetector {
    OfficeAppType detectInstalledApp(String fileName);

    boolean isOfficeFile(String fileName);
}
