package com.box.android.data.controller.impl;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.coreservices.modelcontroller.BoxAppFutureTask;
import com.box.android.coreservices.modelcontroller.BoxCallable;
import com.box.android.coreservices.modelcontroller.BoxFutureTask;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.messages.BoxLocalParentMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxResponseMessage;
import com.box.android.domain.identity.IExecutorPool;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.IKeyValueStore;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.domain.localrepo.ISQLHelper;
import com.box.android.domain.localrepo.LocalSortPreferences;
import com.box.android.domain.localrepo.sqlitetables.BoxItemSQLData;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxRequestItem;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.requests.BoxRequestsFolder;
import com.box.androidsdk.content.requests.BoxRequestsSearch;
import com.box.androidsdk.content.requests.BoxRequestsUser;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes11.dex */
public class BaseModelController implements IBaseModelController {
    private static final HashSet<Class> EXCLUDE_FOLDER_FIELD_REQUESTS;
    private static final String TAG = "BaseModelController";
    protected final LocalBroadcastManager mBroadcastMgr;
    protected IUserContextManager mUserContextManager;

    static {
        HashSet<Class> hashSet = new HashSet<>();
        EXCLUDE_FOLDER_FIELD_REQUESTS = hashSet;
        hashSet.add(BoxRequestsUser.GetUserInfo.class);
    }

    @Inject
    public BaseModelController(final IUserContextManager userContextManager, final Context context) {
        this.mUserContextManager = userContextManager;
        this.mBroadcastMgr = LocalBroadcastManager.getInstance(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.box.android.coreservices.modelcontroller.IBaseModelController
    public <T extends BoxObject> T getFromLocalOrRemote(BoxCacheableRequest<T> boxCacheableRequest) throws BoxException {
        try {
            try {
                return (T) boxCacheableRequest.sendForCachedResult();
            } catch (BoxException.CacheResultUnavailable unused) {
                return (T) performRemote((BoxRequest) boxCacheableRequest).get().getResult();
            }
        } catch (InterruptedException | ExecutionException e) {
            BoxLogUtils.e(TAG, e);
            if (!(e instanceof InterruptedException)) {
                return null;
            }
            Thread.currentThread().interrupt();
            return null;
        }
    }

    private <R extends BoxRequest<T, R>, T extends BoxObject> BoxAppFutureTask<T> performRemote(BoxRequest<T, R> request, BoxFutureTask.TaskPriority priority, final BoxAppFutureTask.OnCompletedListener<T> listener) {
        String[] appropriateFields = getAppropriateFields(request);
        if ((request instanceof BoxRequestItem) && appropriateFields != null) {
            ((BoxRequestItem) request).setFields(appropriateFields);
        }
        if (request instanceof BoxRequestsFolder.GetFolderWithAllItems) {
            LocalSortPreferences localSortPreferences = new LocalSortPreferences(this.mUserContextManager);
            BoxRequestsFolder.GetFolderWithAllItems getFolderWithAllItems = (BoxRequestsFolder.GetFolderWithAllItems) request;
            getFolderWithAllItems.setSort(localSortPreferences.getSortBy().toApiSort());
            getFolderWithAllItems.setDirection(localSortPreferences.getSortOrder().toString());
        }
        BoxAppFutureTask<T> boxAppFutureTask = new BoxAppFutureTask<>(request, priority);
        submit(boxAppFutureTask, true, listener);
        return boxAppFutureTask;
    }

    @Override // com.box.android.coreservices.modelcontroller.IBaseModelController
    public <R extends BoxRequest<T, R>, T extends BoxObject> BoxAppFutureTask<T> performRemote(BoxRequest<T, R> request, final BoxAppFutureTask.OnCompletedListener<T> listener) {
        return performRemote(request, BoxFutureTask.TaskPriority.PRIORITY_MEDIUM, listener);
    }

    private String[] getAppropriateFields(BoxRequest request) {
        if (!(request instanceof BoxRequestItem) || EXCLUDE_FOLDER_FIELD_REQUESTS.contains(request.getClass())) {
            return null;
        }
        if (request instanceof BoxRequestsSearch.Search) {
            return BoxApiPrivate.SEARCH_FIELDS;
        }
        if ((request instanceof BoxRequestsFile.AddTaggedCommentToFile) || (request instanceof BoxRequestsFile.AddCommentToFile) || (request instanceof BoxRequestsFile.GetFileComments)) {
            return BoxApiPrivate.COMMENTS_FIELDS;
        }
        return BoxApiPrivate.FOLDER_FIELDS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performRemote$0(BoxResponse boxResponse) {
        this.mBroadcastMgr.sendBroadcast(new BoxResponseMessage(boxResponse, true));
    }

    @Override // com.box.android.coreservices.modelcontroller.IBaseModelController
    public <R extends BoxRequest<T, R>, T extends BoxObject> BoxAppFutureTask<T> performRemote(BoxRequest<T, R> request) {
        return performRemote(request, BoxFutureTask.TaskPriority.PRIORITY_MEDIUM, new BoxAppFutureTask.OnCompletedListener() { // from class: com.box.android.data.controller.impl.BaseModelController$$ExternalSyntheticLambda0
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public final void onCompleted(BoxResponse boxResponse) {
                this.f$0.lambda$performRemote$0(boxResponse);
            }
        });
    }

    private <R extends BoxRequest<T, R> & BoxCacheableRequest<T>, T extends BoxObject> BoxAppFutureTask<T> performLocal(BoxRequest<T, R> request, BoxFutureTask.TaskPriority priority, final BoxAppFutureTask.OnCompletedListener<T> listener) {
        if (request instanceof BoxRequestItem) {
            ((BoxRequestItem) request).setFields(BoxApiPrivate.FOLDER_FIELDS);
        }
        BoxAppFutureTask<T> boxAppFutureTask = new BoxAppFutureTask<>(request, priority, true);
        submit(boxAppFutureTask, false, listener);
        return boxAppFutureTask;
    }

    @Override // com.box.android.coreservices.modelcontroller.IBaseModelController
    public <R extends BoxRequest<T, R> & BoxCacheableRequest<T>, T extends BoxObject> BoxAppFutureTask<T> performLocal(BoxRequest<T, R> request, final BoxAppFutureTask.OnCompletedListener<T> listener) {
        return performLocal(request, BoxFutureTask.TaskPriority.PRIORITY_MEDIUM, listener);
    }

    @Override // com.box.android.domain.services.IBaseModelControllerService
    public <R extends BoxRequest<T, R>, T extends BoxObject> Result<BoxObject, DomainError> performRemoteForResult(BoxRequest<T, R> request) {
        try {
            BoxResponse boxResponse = performRemote(request).get(30L, TimeUnit.SECONDS);
            if (boxResponse.isSuccess()) {
                return new Result.Success(boxResponse.getResult());
            }
            String message = boxResponse.getException().getMessage();
            if (message == null) {
                message = boxResponse.getException().toString();
            }
            return new Result.Error(new DomainError.UnknownError(message));
        } catch (Exception e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            return new Result.Error(new DomainError.UnknownError(e.getMessage() == null ? "Unknown Error" : e.getMessage()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.box.android.coreservices.modelcontroller.IBaseModelController
    public <R extends BoxRequest<T, R> & BoxCacheableRequest<T>, T extends BoxObject> BoxAppFutureTask<T> performLocal(BoxRequest<T, R> request) {
        return performLocal(request, BoxFutureTask.TaskPriority.PRIORITY_MEDIUM, new BoxAppFutureTask.OnCompletedListener<T>() { // from class: com.box.android.data.controller.impl.BaseModelController.1
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public void onCompleted(BoxResponse<T> response) {
                BaseModelController.this.mBroadcastMgr.sendBroadcast(new BoxResponseMessage(response, false));
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T extends BoxObject> void submit(BoxAppFutureTask<T> task, final boolean remote, final BoxAppFutureTask.OnCompletedListener<T> listener) {
        task.setRequestId(IBaseModelController.INSTANCE.getNextRequestId());
        task.addOnCompletedListener(listener);
        try {
            getExecutor(remote).submit(task);
        } catch (RejectedExecutionException e) {
            BoxLogUtils.d(BaseModelController.class.getName(), "rejected execution" + getExecutor(remote).isShutdown() + " " + getExecutor(remote).isTerminated() + " " + this.mUserContextManager.isSwitchingOrDestroyingUser());
            BoxLogUtils.e(BaseModelController.class.getName(), e);
            task.cancel(true);
        }
    }

    protected ISQLHelper getSqlHelper() {
        return this.mUserContextManager.getCurrentContext().getSQLHelper();
    }

    @Override // com.box.android.coreservices.modelcontroller.IBaseModelController
    public IKeyValueStore getKeyValueStore() {
        return this.mUserContextManager.getCurrentContext().getKVStore();
    }

    protected IExecutorPool getExecutorPool() {
        return (IExecutorPool) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.EXECUTOR_POOL);
    }

    protected ExecutorService getExecutor(final boolean fetchRemote) {
        IExecutorPool executorPool = getExecutorPool();
        return fetchRemote ? executorPool.getApiExecutor() : executorPool.getLocalModelExecutor();
    }

    protected <T extends BoxMessage<?>> BoxFutureTask<T> asyncBuildAndRunFutureTask(final BoxCallable<T> callable, final ExecutorService executor) {
        return asyncBuildAndRunFutureTask(callable, BoxFutureTask.TaskPriority.PRIORITY_MEDIUM, executor);
    }

    private <T extends BoxMessage<?>> BoxFutureTask<T> asyncBuildAndRunFutureTask(final BoxCallable<T> callable, final BoxFutureTask.TaskPriority taskPriority, final ExecutorService executor) {
        return asyncBuildAndRunFutureTask(callable, null, taskPriority, executor);
    }

    private <T extends BoxMessage<?>> BoxFutureTask<T> asyncBuildAndRunFutureTask(final BoxCallable<T> boxCallable, BoxFutureTask.FinalMessageListener<T> finalMessageListener, BoxFutureTask.TaskPriority taskPriority, ExecutorService executorService) {
        long nextRequestId = IBaseModelController.INSTANCE.getNextRequestId();
        BoxFutureTask<T> boxFutureTask = (BoxFutureTask<T>) new BoxFutureTask<T>(boxCallable, nextRequestId, finalMessageListener, taskPriority) { // from class: com.box.android.data.controller.impl.BaseModelController.2
            @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
            public boolean cancel(boolean mayInterruptIfRunning) {
                boxCallable.onCancel(mayInterruptIfRunning);
                return super.cancel(mayInterruptIfRunning);
            }
        };
        boxCallable.setRequestId(nextRequestId);
        try {
            executorService.submit(boxFutureTask);
            return boxFutureTask;
        } catch (RejectedExecutionException unused) {
            boxFutureTask.cancel(true);
            return boxFutureTask;
        }
    }

    protected SharedPreferences getUserSharedPrefs() {
        return this.mUserContextManager.getUserSharedPrefs();
    }

    protected SharedPreferences getSharedPreferences(final ILocalSharedPreferences.PreferenceName sharedPrefName) {
        return this.mUserContextManager.getUserSharedPrefs(sharedPrefName);
    }

    @Override // com.box.android.coreservices.modelcontroller.IBaseModelController
    public String getParentId(final BoxItem boxItem) throws SQLException {
        return getParentId(boxItem.getUserId(), boxItem.getType());
    }

    private String getParentId(final String itemId, final String itemType) {
        try {
            return ((BoxLocalParentMessage) getParentIdFutureTask(itemId, itemType).get()).getPayload();
        } catch (Exception e) {
            if (!(e instanceof InterruptedException)) {
                return null;
            }
            Thread.currentThread().interrupt();
            return null;
        }
    }

    private BoxFutureTask<BoxLocalParentMessage> getParentIdFutureTask(final String itemId, final String itemType) {
        return asyncBuildAndRunFutureTask(new BoxCallable<BoxLocalParentMessage>() { // from class: com.box.android.data.controller.impl.BaseModelController.3
            @Override // java.util.concurrent.Callable
            public BoxLocalParentMessage call() throws Exception {
                BoxLocalParentMessage boxLocalParentMessage = new BoxLocalParentMessage();
                BoxItemSQLData boxItemSQLData = (BoxItemSQLData) BaseModelController.this.getSqlHelper().getQueryManager().queryForId(BaseModelController.this.getSqlHelper().getDao(itemType).getDataClass(), itemId);
                if (boxItemSQLData == null) {
                    return boxLocalParentMessage;
                }
                boxLocalParentMessage.setPayload(boxItemSQLData.getParentId());
                return boxLocalParentMessage;
            }
        }, getExecutorPool().getLocalModelExecutor());
    }
}
