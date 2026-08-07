package com.box.android.data.controller.impl;

import android.content.Context;
import android.widget.Toast;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.coreservices.modelcontroller.BoxAppFutureTask;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.messages.BoxResponseMessage;
import com.box.android.domain.controller.ICommentsController;
import com.box.androidsdk.content.BoxApiFile;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxComment;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxIteratorCollaborations;
import com.box.androidsdk.content.models.BoxIteratorCollaborators;
import com.box.androidsdk.content.models.BoxIteratorComments;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.views.BoxAvatarView;
import com.box.androidsdk.content.views.DefaultAvatarController;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes11.dex */
public class BoxCommentsController implements ICommentsController {
    private static ThreadPoolExecutor mApiExecutor;
    protected WeakReference<Context> contextWeakReference;
    protected IBaseModelController mBaseModelController;
    protected DefaultAvatarController mDefaultAvatarController;
    protected BoxApiFile mFileApi;

    public BoxCommentsController(BoxSession session, IBaseModelController baseModelController, Context context) {
        if (session != null) {
            this.mFileApi = new BoxApiFile(session);
            this.mDefaultAvatarController = new DefaultAvatarController(session);
            this.mBaseModelController = baseModelController;
            this.contextWeakReference = new WeakReference<>(context);
        }
    }

    public BoxCommentsController(BoxApiFile fileApi) {
        this.mFileApi = fileApi;
    }

    @Override // com.box.android.domain.controller.ICommentsController
    public void fetchComments(BoxFile file, BoxFutureTask.OnCompletedListener<BoxIteratorComments> onCompletedListener, int offset) {
        BoxRequestsFile.GetFileComments commentsRequest = this.mFileApi.getCommentsRequest(file.getUserId());
        commentsRequest.setOffset(offset);
        BoxFutureTask<E> task = commentsRequest.toTask();
        task.addOnCompletedListener(onCompletedListener);
        getApiExecutor().submit(task);
    }

    @Override // com.box.android.domain.controller.ICommentsController
    public void fetchCollaborations(BoxFile boxFile, BoxFutureTask.OnCompletedListener<BoxIteratorCollaborations> onCompletedListener) {
        BoxFutureTask<E> task = this.mFileApi.getCollaborationsRequest(boxFile.getUserId()).toTask();
        task.addOnCompletedListener(onCompletedListener);
        getApiExecutor().submit(task);
    }

    @Override // com.box.android.domain.controller.ICommentsController
    public void fetchCollaborators(BoxFile boxFile, BoxFutureTask.OnCompletedListener<BoxIteratorCollaborators> onCompletedListener) {
        BoxFutureTask<E> task = this.mFileApi.getCollaboratorsRequest(boxFile.getUserId()).toTask();
        task.addOnCompletedListener(onCompletedListener);
        getApiExecutor().submit(task);
    }

    @Override // com.box.android.domain.controller.ICommentsController
    public void addComment(String boxFileId, String message, final BoxFutureTask.OnCompletedListener<BoxComment> onCompletedListener) {
        this.mBaseModelController.performRemote(this.mFileApi.getAddCommentRequest(boxFileId, message), new BoxAppFutureTask.OnCompletedListener() { // from class: com.box.android.data.controller.impl.BoxCommentsController$$ExternalSyntheticLambda1
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public final void onCompleted(BoxResponse boxResponse) {
                this.f$0.lambda$addComment$0(onCompletedListener, boxResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addComment$0(BoxFutureTask.OnCompletedListener onCompletedListener, BoxResponse boxResponse) {
        onCompletedListener.onCompleted(boxResponse);
        Context context = this.contextWeakReference.get();
        if (context != null) {
            LocalBroadcastManager.getInstance(context).sendBroadcast(new BoxResponseMessage(boxResponse, true));
        }
    }

    @Override // com.box.android.domain.controller.ICommentsController
    public void addTaggedComment(String boxFileId, String taggedMessage, final BoxFutureTask.OnCompletedListener<BoxComment> onCompletedListener) {
        this.mBaseModelController.performRemote(this.mFileApi.getAddTaggedCommentRequest(boxFileId, taggedMessage), new BoxAppFutureTask.OnCompletedListener() { // from class: com.box.android.data.controller.impl.BoxCommentsController$$ExternalSyntheticLambda0
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public final void onCompleted(BoxResponse boxResponse) {
                this.f$0.lambda$addTaggedComment$1(onCompletedListener, boxResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addTaggedComment$1(BoxFutureTask.OnCompletedListener onCompletedListener, BoxResponse boxResponse) {
        onCompletedListener.onCompleted(boxResponse);
        Context context = this.contextWeakReference.get();
        if (context != null) {
            LocalBroadcastManager.getInstance(context).sendBroadcast(new BoxResponseMessage(boxResponse, true));
        }
    }

    @Override // com.box.android.domain.controller.ICommentsController
    public <E extends BoxAvatarView.AvatarController & Serializable> E getAvatarController() {
        return this.mDefaultAvatarController;
    }

    @Override // com.box.android.domain.controller.ICommentsController
    public void clearTasks() {
        getApiExecutor().getQueue().clear();
    }

    protected ThreadPoolExecutor getApiExecutor() {
        ThreadPoolExecutor threadPoolExecutor = mApiExecutor;
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
            mApiExecutor = new ThreadPoolExecutor(1, 1, 3600L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        }
        return mApiExecutor;
    }

    @Override // com.box.android.domain.controller.ICommentsController
    public void showToast(Context context, int resId) {
        Toast.makeText(context, resId, 1).show();
    }
}
