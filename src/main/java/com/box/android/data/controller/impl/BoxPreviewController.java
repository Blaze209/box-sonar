package com.box.android.data.controller.impl;

import com.box.android.coreservices.modelcontroller.IMoCoAdminSettings;
import com.box.android.coreservices.modelcontroller.messages.BoxAdminSettingsMessage;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.controller.IBrowseController;
import com.box.android.domain.controller.IPreviewController;
import com.box.android.domain.identity.IExecutorPool;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.IBoxStorage;
import com.box.android.domain.preview.PreviewContentType;
import com.box.androidsdk.content.BoxApiFolder;
import com.box.androidsdk.content.BoxApiPreview;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxExtendedApiPreview;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxDownload;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes11.dex */
public class BoxPreviewController implements IPreviewController, Serializable {
    private static ConcurrentHashMap<String, BoxFutureTask<BoxDownload>> CURRENT_THUMBNAIL_DOWNLOADS = new ConcurrentHashMap<>();
    protected transient BoxExtendedApiFolder mApiFolder;
    protected transient BoxExtendedApiPreview mApiPreview;
    protected transient IBrowseController mBrowseController;
    protected transient FeatureFlips mFeatureFlips;
    protected transient IMoCoAdminSettings mMoCoAdminSettings;
    protected transient IUserContextManager mUserContextManager;

    @Inject
    public BoxPreviewController(IUserContextManager userContextManager, BoxExtendedApiPreview boxExtendedApiPreview, BoxExtendedApiFolder boxExtendedApiFolder, IBrowseController browseController, IMoCoAdminSettings moCoAdminSettings, FeatureFlips featureFlips) {
        this.mUserContextManager = userContextManager;
        this.mApiFolder = boxExtendedApiFolder;
        this.mApiPreview = boxExtendedApiPreview;
        this.mBrowseController = browseController;
        this.mMoCoAdminSettings = moCoAdminSettings;
        this.mFeatureFlips = featureFlips;
    }

    @Override // com.box.android.domain.controller.IPreviewController
    public IBoxStorage getStorage() {
        return this.mUserContextManager.getPreviewStorage();
    }

    @Override // com.box.android.domain.controller.IPreviewController
    public BoxApiPreview getApiPreview() {
        return this.mApiPreview;
    }

    @Override // com.box.android.domain.controller.IPreviewController
    public BoxApiFolder getApiFolder() {
        return this.mApiFolder;
    }

    @Override // com.box.android.domain.controller.IPreviewController
    public boolean isTextSelectionEnabled() {
        try {
            return ((BoxAdminSettingsMessage) this.mMoCoAdminSettings.getAdminSettingsLocal().get()).getPayload().isMobileCopyPasteEnabled();
        } catch (Exception e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            BoxLogUtils.e("BoxPreviewController", "Unable to access admin setting to verify file copy paste configuration", e);
            return false;
        }
    }

    @Override // com.box.android.domain.controller.IPreviewController
    public IBrowseController getBrowseController() {
        return this.mBrowseController;
    }

    @Override // com.box.android.domain.controller.IPreviewController
    public void execute(Runnable runnable) {
        ((IExecutorPool) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.EXECUTOR_POOL)).getPreviewExecutor().execute(runnable);
    }

    @Override // com.box.android.domain.controller.IPreviewController
    public FeatureFlips getFeatureFlips() {
        return this.mFeatureFlips;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.box.android.domain.controller.IPreviewController
    public InputStream downloadThumbnail(BoxFile boxFile, int i, boolean z) throws BoxException {
        File cachedThumbnailFile;
        OutputStream outputStreamCreateThumbnailOutputStream;
        BoxFutureTask task;
        BoxFile boxFile2 = (boxFile.getSha1() == null || boxFile.getName() == null) ? (BoxFile) getApiPreview().getInfoRequest(boxFile.getUserId()).send() : boxFile;
        String string = Integer.toString(i);
        if (i >= 1024) {
            cachedThumbnailFile = getStorage().getCachedPreviewFile(boxFile2, string);
        } else {
            cachedThumbnailFile = getStorage().getCachedThumbnailFile(boxFile2, string);
        }
        if (!cachedThumbnailFile.exists() || cachedThumbnailFile.length() == 0) {
            BoxFutureTask boxFutureTask = CURRENT_THUMBNAIL_DOWNLOADS.get(cachedThumbnailFile.getAbsolutePath());
            if (boxFutureTask == null || boxFutureTask.isDone() || boxFutureTask.isCancelled()) {
                if (i >= 1024) {
                    outputStreamCreateThumbnailOutputStream = getStorage().createPreviewOutputStream(boxFile2, string, (PreviewContentType) null);
                } else {
                    outputStreamCreateThumbnailOutputStream = getStorage().createThumbnailOutputStream(boxFile2, string);
                }
                if (z) {
                    task = getApiPreview().getDownloadPreviewRequest(outputStreamCreateThumbnailOutputStream, boxFile.getUserId(), boxFile.getFileVersion().getUserId(), BoxApiPreview.Extensions.PNG).setPage(1).setMinSize(i).toTask();
                } else {
                    task = getApiPreview().getDownloadThumbnailRequest(outputStreamCreateThumbnailOutputStream, boxFile.getUserId()).setMinSize(i).toTask();
                }
                boxFutureTask = task;
                CURRENT_THUMBNAIL_DOWNLOADS.put(cachedThumbnailFile.getAbsolutePath(), (BoxFutureTask<BoxDownload>) boxFutureTask);
                boxFutureTask.run();
            }
            try {
                try {
                    BoxResponse boxResponse = boxFutureTask.get();
                    if (boxResponse.getException() instanceof BoxException) {
                        throw ((BoxException) boxResponse.getException());
                    }
                    CURRENT_THUMBNAIL_DOWNLOADS.remove(cachedThumbnailFile.getAbsolutePath());
                } catch (InterruptedException e) {
                    BoxLogUtils.e("error", e);
                    Thread.currentThread().interrupt();
                    CURRENT_THUMBNAIL_DOWNLOADS.remove(cachedThumbnailFile.getAbsolutePath());
                    return null;
                } catch (ExecutionException e2) {
                    BoxLogUtils.e("error", e2);
                    CURRENT_THUMBNAIL_DOWNLOADS.remove(cachedThumbnailFile.getAbsolutePath());
                    return null;
                }
            } catch (Throwable th) {
                CURRENT_THUMBNAIL_DOWNLOADS.remove(cachedThumbnailFile.getAbsolutePath());
                throw th;
            }
        }
        if (i >= 1024) {
            return getStorage().getCachedPreview(boxFile2, string);
        }
        return getStorage().getCachedThumbnail(boxFile2, string);
    }
}
