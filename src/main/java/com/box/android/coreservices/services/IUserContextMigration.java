package com.box.android.coreservices.services;

import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.domain.identity.IUserContextManager;

/* JADX INFO: loaded from: classes9.dex */
public interface IUserContextMigration {
    void migrateAuthInfo(IUserContextManager iUserContextManager, IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings);

    void migrateStorage();

    void migrateUsersIfNeeded(IUserContextManager iUserContextManager, IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings);

    boolean needsMigration();
}
