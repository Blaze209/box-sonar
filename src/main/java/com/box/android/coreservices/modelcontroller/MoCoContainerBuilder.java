package com.box.android.coreservices.modelcontroller;

import android.os.Handler;
import android.os.Message;
import com.box.android.coreservices.jobmanager.JobItem;
import com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection;
import com.box.android.coreservices.jobmanager.jobs.BoxJob;
import com.box.android.coreservices.jobmanager.tasks.BoxTask;
import com.box.android.coreservices.modelcontroller.messages.BoxJobMessage;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiCollaboration;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiWeblink;

/* JADX INFO: loaded from: classes9.dex */
public class MoCoContainerBuilder {
    private IBaseModelController baseModelController;
    private BoxExtendedApiFile fileApi;
    private BoxExtendedApiFolder folderApi;
    private IMoCoAdminSettings mAdminSettings;
    private BoxExtendedApiCollaboration mApiCollaboration;
    private BoxApiPrivate mApiPrivate;
    private IUserContextManager mContextManager;
    private Handler mMessageHandler;
    private IMoCoBatchOperations moCoBatchOperations;
    private IMoCoBoxTransfers mocoTransfers;
    private BoxExtendedApiWeblink weblinkApi;

    public MoCoContainerBuilder setMocoTransfers(IMoCoBoxTransfers iMoCoBoxTransfers) {
        this.mocoTransfers = iMoCoBoxTransfers;
        return this;
    }

    public MoCoContainerBuilder setMocoBatchOperations(IMoCoBatchOperations iMoCoBatchOperations) {
        this.moCoBatchOperations = iMoCoBatchOperations;
        return this;
    }

    public MoCoContainerBuilder setContextManager(IUserContextManager iUserContextManager) {
        this.mContextManager = iUserContextManager;
        return this;
    }

    public MoCoContainerBuilder setMoCoAdminSettings(IMoCoAdminSettings iMoCoAdminSettings) {
        this.mAdminSettings = iMoCoAdminSettings;
        return this;
    }

    public MoCoContainer build() {
        return new MoCoContainer();
    }

    public IBaseModelController getBaseModelController() {
        return this.baseModelController;
    }

    public MoCoContainerBuilder setBaseModelController(IBaseModelController iBaseModelController) {
        this.baseModelController = iBaseModelController;
        return this;
    }

    public BoxExtendedApiFolder getFolderApi() {
        return this.folderApi;
    }

    public MoCoContainerBuilder setFolderApi(BoxExtendedApiFolder boxExtendedApiFolder) {
        this.folderApi = boxExtendedApiFolder;
        return this;
    }

    public BoxExtendedApiFile getFileApi() {
        return this.fileApi;
    }

    public MoCoContainerBuilder setFileApi(BoxExtendedApiFile boxExtendedApiFile) {
        this.fileApi = boxExtendedApiFile;
        return this;
    }

    public MoCoContainerBuilder setCollabApi(BoxExtendedApiCollaboration boxExtendedApiCollaboration) {
        this.mApiCollaboration = boxExtendedApiCollaboration;
        return this;
    }

    public BoxExtendedApiWeblink getWeblinkApi() {
        return this.weblinkApi;
    }

    public MoCoContainerBuilder setBookmarkApi(BoxExtendedApiWeblink boxExtendedApiWeblink) {
        this.weblinkApi = boxExtendedApiWeblink;
        return this;
    }

    public MoCoContainerBuilder setPrivateApi(BoxApiPrivate boxApiPrivate) {
        this.mApiPrivate = boxApiPrivate;
        return this;
    }

    public BoxApiPrivate getPrivateApi() {
        return this.mApiPrivate;
    }

    public MoCoContainerBuilder setMessageHandler(Handler handler) {
        this.mMessageHandler = handler;
        return this;
    }

    public static class MoCoContainer {
        private final IBaseModelController baseModelController;
        private final BoxExtendedApiFile fileApi;
        private final BoxExtendedApiFolder folderApi;
        private final IMoCoAdminSettings mAdminSettings;
        private final BoxExtendedApiCollaboration mApiCollaboration;
        private final BoxApiPrivate mApiPrivate;
        private final IUserContextManager mContextManager;
        private final Handler mMessageHandler;
        private final BoxExtendedApiWeblink mWeblinkApi;
        private final IMoCoBatchOperations moCoBatchOperations;
        private IMoCoBoxTransfers mocoTransfers;

        private MoCoContainer(MoCoContainerBuilder moCoContainerBuilder) {
            this.fileApi = moCoContainerBuilder.fileApi;
            this.mocoTransfers = moCoContainerBuilder.mocoTransfers;
            this.folderApi = moCoContainerBuilder.folderApi;
            this.mWeblinkApi = moCoContainerBuilder.weblinkApi;
            this.mAdminSettings = moCoContainerBuilder.mAdminSettings;
            this.baseModelController = moCoContainerBuilder.baseModelController;
            this.mApiPrivate = moCoContainerBuilder.mApiPrivate;
            this.mApiCollaboration = moCoContainerBuilder.mApiCollaboration;
            this.moCoBatchOperations = moCoContainerBuilder.moCoBatchOperations;
            this.mContextManager = moCoContainerBuilder.mContextManager;
            this.mMessageHandler = moCoContainerBuilder.mMessageHandler;
        }

        public BoxExtendedApiFile getFileApi() {
            return this.fileApi;
        }

        public IMoCoBoxTransfers getMocoTransfers() {
            return this.mocoTransfers;
        }

        public IMoCoBatchOperations getMocoBatchOperations() {
            return this.moCoBatchOperations;
        }

        public IUserContextManager getUserContextManager() {
            return this.mContextManager;
        }

        public IMoCoAdminSettings getAdminSettings() {
            return this.mAdminSettings;
        }

        public BoxExtendedApiFolder getFolderApi() {
            return this.folderApi;
        }

        public BoxExtendedApiWeblink getWeblinkApi() {
            return this.mWeblinkApi;
        }

        public IBaseModelController getBaseModelController() {
            return this.baseModelController;
        }

        public BoxExtendedApiCollaboration getCollabApi() {
            return this.mApiCollaboration;
        }

        public void broadcastJobStatus(BoxJobMessage boxJobMessage) {
            Message messageObtainMessage = this.mMessageHandler.obtainMessage(boxJobMessage.getCollectionId());
            messageObtainMessage.obj = boxJobMessage;
            for (int i : boxJobMessage.getCancelIds()) {
                this.mMessageHandler.removeMessages(i);
            }
            this.mMessageHandler.sendMessage(messageObtainMessage);
        }

        public static <E> BoxJobMessage<E> createStatusMessage(JobItem jobItem, E e) {
            BoxJobMessage<E> boxJobMessage = new BoxJobMessage<>(jobItem.getClass().getName());
            if (jobItem instanceof BoxJobCollection) {
                boxJobMessage.setCollectionId(jobItem.getId());
                boxJobMessage.setCancelIds(jobItem.getId());
            } else if (jobItem instanceof BoxJob) {
                boxJobMessage.setCollectionId(((BoxJob) jobItem).getParent().getId());
            } else if (jobItem instanceof BoxTask) {
                boxJobMessage.setCollectionId(((BoxTask) jobItem).getParent().getParent().getId());
            }
            boxJobMessage.setPayload(e);
            boxJobMessage.setSuccess(true);
            boxJobMessage.setState(jobItem.getCurrentState());
            return boxJobMessage;
        }
    }
}
