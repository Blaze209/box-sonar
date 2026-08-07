package com.box.android.modelcontroller;

import android.content.Context;
import com.box.android.application.BoxBaseApplication;
import com.box.android.coreservices.jobmanager.JobItem;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.modelcontroller.BoxCallable;
import com.box.android.coreservices.modelcontroller.IMoCoBatchOperations;
import com.box.android.coreservices.modelcontroller.messages.BoxBatchOperationsMessage;
import com.box.android.coreservices.modelcontroller.messages.Controller;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.data.controller.impl.BaseModelController;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.utils.BoxTypeIdPair;
import com.box.androidsdk.content.models.BoxItem;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiWeblink;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes12.dex */
public class MoCoBatchOperations extends BaseModelController implements IMoCoBatchOperations {
    private final BoxExtendedApiWeblink mBookmarkApi;
    private final BoxExtendedApiFile mFileApi;
    private final BoxExtendedApiFolder mFolderApi;
    private Set<ProgressReporter.ProgressListener> mJobManagerProgressListeners;

    @Inject
    public MoCoBatchOperations(Context context, IUserContextManager iUserContextManager, BoxExtendedApiFile boxExtendedApiFile, BoxExtendedApiFolder boxExtendedApiFolder, BoxExtendedApiWeblink boxExtendedApiWeblink) {
        super(iUserContextManager, context);
        this.mJobManagerProgressListeners = new HashSet();
        this.mFileApi = boxExtendedApiFile;
        this.mFolderApi = boxExtendedApiFolder;
        this.mBookmarkApi = boxExtendedApiWeblink;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Collection<BoxItem> getItemsFromTypedIds(List<BoxTypeIdPair> list) throws ExecutionException, InterruptedException {
        ArrayList arrayList = new ArrayList();
        Iterator<BoxTypeIdPair> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getItemLocal(this.mFolderApi, this.mFileApi, this.mBookmarkApi));
        }
        return arrayList;
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBatchOperations
    public void deleteTypeIdPairs(final List<BoxTypeIdPair> list, final ProgressReporter.ProgressListener progressListener) {
        asyncBuildAndRunFutureTask(new BoxCallable<BoxBatchOperationsMessage>() { // from class: com.box.android.modelcontroller.MoCoBatchOperations.1
            @Override // java.util.concurrent.Callable
            public BoxBatchOperationsMessage call() throws Exception {
                final BoxBatchOperationsMessage boxBatchOperationsMessage = new BoxBatchOperationsMessage();
                boxBatchOperationsMessage.setRequestId(getRequestId());
                boxBatchOperationsMessage.setAction(Controller.ACTION_DELETED_ITEMS);
                boxBatchOperationsMessage.setIsLocal(false);
                boxBatchOperationsMessage.setSuccess(true);
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                try {
                    ProgressReporter.ProgressListener progressListener2 = new ProgressReporter.ProgressListener() { // from class: com.box.android.modelcontroller.MoCoBatchOperations.1.1
                        @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
                        public void onPaused(ProgressReporter progressReporter) {
                            if (progressListener != null) {
                                progressListener.onPaused(progressReporter);
                            }
                            countDownLatch.countDown();
                        }

                        @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
                        public void onCompleted(ProgressReporter progressReporter) {
                            if (progressListener != null) {
                                progressListener.onCompleted(progressReporter);
                            }
                            if (progressReporter instanceof JobItem) {
                                boxBatchOperationsMessage.setSuccess(!((JobItem) progressReporter).hasError());
                            }
                            MoCoBatchOperations.this.mJobManagerProgressListeners.remove(this);
                            countDownLatch.countDown();
                        }

                        @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
                        public void onStarted(ProgressReporter progressReporter) {
                            if (progressListener != null) {
                                progressListener.onStarted(progressReporter);
                            }
                        }

                        @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
                        public void onProgressUpdated(ProgressReporter progressReporter, ProgressReporter.ProgressType progressType, long j, long j2) {
                            if (progressListener != null) {
                                progressListener.onProgressUpdated(progressReporter, progressType, j, j2);
                            }
                        }

                        @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
                        public void onError(ProgressReporter progressReporter, Exception exc) {
                            if (progressListener != null) {
                                progressListener.onError(progressReporter, exc);
                            }
                        }
                    };
                    MoCoBatchOperations.this.mJobManagerProgressListeners.add(progressListener2);
                    BoxBaseApplication.getInstance().getJobManager().deleteItems(MoCoBatchOperations.this.getItemsFromTypedIds(list), progressListener2);
                } catch (Exception e) {
                    if (e instanceof InterruptedException) {
                        Thread.currentThread().interrupt();
                    }
                    boxBatchOperationsMessage.setSuccess(false);
                    boxBatchOperationsMessage.setException(e);
                }
                countDownLatch.await();
                CoreServiceUtils.broadcastIntent(MoCoBatchOperations.this.mUserContextManager, boxBatchOperationsMessage);
                return boxBatchOperationsMessage;
            }
        }, getExecutorPool().getApiExecutor());
    }
}
