package com.box.android.coreservices.modelcontroller;

import com.box.android.coreservices.modelcontroller.messages.BoxAdminSettingsMessage;

/* JADX INFO: loaded from: classes9.dex */
public interface IMoCoAdminSettings {
    BoxFutureTask<BoxAdminSettingsMessage> getAdminSettingsIfNeeded();

    BoxFutureTask<BoxAdminSettingsMessage> getAdminSettingsLocal();

    BoxFutureTask<BoxAdminSettingsMessage> getAdminSettingsRemote();
}
