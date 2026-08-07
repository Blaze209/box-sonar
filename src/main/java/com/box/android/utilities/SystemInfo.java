package com.box.android.utilities;

import android.content.Context;
import com.box.android.common.utilities.CommonBoxUtil;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: classes13.dex */
@Singleton
public class SystemInfo implements ISystemInfo {
    private final Context context;

    @Inject
    public SystemInfo(Context context) {
        this.context = context;
    }

    @Override // com.box.android.utilities.ISystemInfo
    public boolean isAppNotificationsEnabled() {
        return CommonBoxUtil.isAppNotificationsEnabled(this.context);
    }
}
