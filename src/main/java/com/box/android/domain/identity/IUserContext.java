package com.box.android.domain.identity;

import com.box.android.domain.localrepo.IKeyValueStore;
import com.box.android.domain.localrepo.ISQLHelper;

/* JADX INFO: loaded from: classes11.dex */
public interface IUserContext {
    public static final String EMPTY_USER_ID = "-1";

    public enum UserContextComponent {
        EXECUTOR_POOL,
        LOCAL_SHARED_PREFERENCES,
        LOCAL_FILES,
        LOCAL_STATIC_VARIABLE,
        LOCAL_AUTO_CONTENT_UPLOAD_INFORMATION,
        DOCUMENT_PROVIDER_PREFERENCES,
        LEVELDB,
        SQL_PROVIDER,
        USER_CONTEXT_PROXY,
        JOB_SERVICE
    }

    String getContextId();

    IKeyValueStore getKVStore();

    ISQLHelper getSQLHelper();

    IUserContextComponent getUserContextComponent(UserContextComponent userContextComponent);
}
