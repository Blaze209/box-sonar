package com.box.android.modelcontroller;

import android.content.Context;
import com.box.android.clientadmin.BoxAdminSettingsProvider;
import com.box.android.coreservices.modelcontroller.BoxCallable;
import com.box.android.coreservices.modelcontroller.BoxFutureTask;
import com.box.android.coreservices.modelcontroller.IMoCoAdminSettings;
import com.box.android.coreservices.modelcontroller.messages.BoxAdminSettingsMessage;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.data.controller.impl.BaseModelController;
import com.box.android.domain.identity.IUserContextManager;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes12.dex */
public class MoCoAdminSettings extends BaseModelController implements IMoCoAdminSettings {
    private final BoxAdminSettingsProvider boxAdminSettingsProvider;

    @Inject
    public MoCoAdminSettings(Context context, IUserContextManager iUserContextManager, BoxAdminSettingsProvider boxAdminSettingsProvider) {
        super(iUserContextManager, context);
        this.boxAdminSettingsProvider = boxAdminSettingsProvider;
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoAdminSettings
    public BoxFutureTask<BoxAdminSettingsMessage> getAdminSettingsIfNeeded() {
        return asyncBuildAndRunFutureTask(new BoxCallable<BoxAdminSettingsMessage>() { // from class: com.box.android.modelcontroller.MoCoAdminSettings.1
            @Override // java.util.concurrent.Callable
            public BoxAdminSettingsMessage call() throws Exception {
                BoxAdminSettingsMessage boxAdminSettingsMessage = new BoxAdminSettingsMessage();
                boxAdminSettingsMessage.setRequestId(getRequestId());
                boxAdminSettingsMessage.setAction(BoxAdminSettingsMessage.ACTION_FETCHED_CLIENT_SETTINGS);
                try {
                    boxAdminSettingsMessage.setPayload(MoCoAdminSettings.this.boxAdminSettingsProvider.getAdminSettingsIfNeeded());
                    boxAdminSettingsMessage.setSuccess(true);
                } catch (Exception e) {
                    boxAdminSettingsMessage.setSuccess(false);
                    boxAdminSettingsMessage.setException(e);
                }
                CoreServiceUtils.broadcastIntent(MoCoAdminSettings.this.mUserContextManager, boxAdminSettingsMessage);
                return boxAdminSettingsMessage;
            }
        }, getExecutorPool().getApiExecutor());
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoAdminSettings
    public BoxFutureTask<BoxAdminSettingsMessage> getAdminSettingsRemote() {
        return asyncBuildAndRunFutureTask(new BoxCallable<BoxAdminSettingsMessage>() { // from class: com.box.android.modelcontroller.MoCoAdminSettings.2
            @Override // java.util.concurrent.Callable
            public BoxAdminSettingsMessage call() throws Exception {
                BoxAdminSettingsMessage boxAdminSettingsMessage = new BoxAdminSettingsMessage();
                boxAdminSettingsMessage.setRequestId(getRequestId());
                boxAdminSettingsMessage.setAction(BoxAdminSettingsMessage.ACTION_FETCHED_CLIENT_SETTINGS);
                try {
                    boxAdminSettingsMessage.setPayload(MoCoAdminSettings.this.boxAdminSettingsProvider.getAdminSettingsRemote());
                    boxAdminSettingsMessage.setSuccess(true);
                } catch (Exception e) {
                    boxAdminSettingsMessage.setSuccess(false);
                    boxAdminSettingsMessage.setException(e);
                }
                CoreServiceUtils.broadcastIntent(MoCoAdminSettings.this.mUserContextManager, boxAdminSettingsMessage);
                return boxAdminSettingsMessage;
            }
        }, getExecutorPool().getApiExecutor());
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoAdminSettings
    public BoxFutureTask<BoxAdminSettingsMessage> getAdminSettingsLocal() {
        return asyncBuildAndRunFutureTask(new BoxCallable<BoxAdminSettingsMessage>() { // from class: com.box.android.modelcontroller.MoCoAdminSettings.3
            @Override // java.util.concurrent.Callable
            public BoxAdminSettingsMessage call() throws Exception {
                BoxAdminSettingsMessage boxAdminSettingsMessage = new BoxAdminSettingsMessage();
                boxAdminSettingsMessage.setRequestId(getRequestId());
                boxAdminSettingsMessage.setAction(BoxAdminSettingsMessage.ACTION_FETCHED_CLIENT_SETTINGS);
                try {
                    boxAdminSettingsMessage.setPayload(MoCoAdminSettings.this.boxAdminSettingsProvider.getAdminSettingsLocal());
                    boxAdminSettingsMessage.setSuccess(true);
                } catch (Exception e) {
                    boxAdminSettingsMessage.setSuccess(false);
                    boxAdminSettingsMessage.setException(e);
                }
                CoreServiceUtils.broadcastIntent(MoCoAdminSettings.this.mUserContextManager, boxAdminSettingsMessage);
                return boxAdminSettingsMessage;
            }
        }, getExecutorPool().getLocalModelExecutor());
    }
}
