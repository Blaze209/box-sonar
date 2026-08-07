package com.box.android.domain.localrepo;

import com.box.android.domain.identity.IUserContextComponent;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public interface ILocalStatics extends IUserContextComponent {
    Map<String, Long> getLastAdminSettingsFetchTimeMap();

    HashSet<String> getPincodeUserIgnorePeriodSet();

    boolean isPreflightFolderPreviouslySuccessful(String str);

    void updatePreflightFolderSuccess(String str);
}
