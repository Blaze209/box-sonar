package com.box.android.localrepo;

import com.box.android.domain.localrepo.ILocalStatics;
import com.box.android.usercontext.UserContextComponent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class LocalStatics extends UserContextComponent implements ILocalStatics {
    private static final HashMap<String, Long> LAST_ADMIN_SETTINGS_FETCH_TIME = new HashMap<>();
    private static final HashSet<String> USERS_TO_IGNORE_START_PERIODS_FOR = new HashSet<>();
    private static final HashMap<String, Long> PREFLIGHT_UPLOAD_FOLDER_CHECK_MAP = new HashMap<>();

    @Override // com.box.android.usercontext.UserContextComponent, com.box.android.domain.identity.IUserContextComponent
    public void onHardDestroy() {
        LAST_ADMIN_SETTINGS_FETCH_TIME.clear();
        USERS_TO_IGNORE_START_PERIODS_FOR.clear();
        super.onHardDestroy();
    }

    @Override // com.box.android.usercontext.UserContextComponent, com.box.android.domain.identity.IUserContextComponent
    public void onSoftDestroy() {
        PREFLIGHT_UPLOAD_FOLDER_CHECK_MAP.clear();
        super.onSoftDestroy();
    }

    @Override // com.box.android.domain.localrepo.ILocalStatics
    public Map<String, Long> getLastAdminSettingsFetchTimeMap() {
        return LAST_ADMIN_SETTINGS_FETCH_TIME;
    }

    @Override // com.box.android.domain.localrepo.ILocalStatics
    public HashSet<String> getPincodeUserIgnorePeriodSet() {
        return USERS_TO_IGNORE_START_PERIODS_FOR;
    }

    @Override // com.box.android.domain.localrepo.ILocalStatics
    public void updatePreflightFolderSuccess(String str) {
        PREFLIGHT_UPLOAD_FOLDER_CHECK_MAP.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.box.android.domain.localrepo.ILocalStatics
    public boolean isPreflightFolderPreviouslySuccessful(String str) {
        Long l = PREFLIGHT_UPLOAD_FOLDER_CHECK_MAP.get(str);
        return l != null && l.longValue() + 3600000 > System.currentTimeMillis();
    }
}
