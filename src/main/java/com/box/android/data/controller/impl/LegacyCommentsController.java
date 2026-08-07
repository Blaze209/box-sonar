package com.box.android.data.controller.impl;

import android.content.Context;
import android.os.AsyncTask;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.coreservices.modelcontroller.BoxAppFutureTask;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.messages.BoxResponseMessage;
import com.box.android.domain.controller.ILegacyCommentsController;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxComment;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxIteratorComments;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.requests.BoxFileNotificationMute;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiCollections;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes11.dex */
public class LegacyCommentsController extends BoxCommentsController implements ILegacyCommentsController {
    private final Context mContext;
    private final BoxExtendedApiFile mExtendedFileApi;

    @Inject
    public LegacyCommentsController(Context context, IBaseModelController baseMoco, BoxExtendedApiFile fileApi, IUserContextManager userContextManager) {
        super(fileApi);
        this.mContext = context;
        this.mDefaultAvatarController = userContextManager.getPreviewStorage().getAvatarController();
        this.mBaseModelController = baseMoco;
        this.mExtendedFileApi = fileApi;
    }

    @Override // com.box.android.data.controller.impl.BoxCommentsController, com.box.android.domain.controller.ICommentsController
    public void addComment(String boxFileId, String message, final BoxFutureTask.OnCompletedListener<BoxComment> onCompletedListener) {
        this.mBaseModelController.performRemote(this.mExtendedFileApi.getAddCommentRequest(boxFileId, message), new BoxAppFutureTask.OnCompletedListener() { // from class: com.box.android.data.controller.impl.LegacyCommentsController$$ExternalSyntheticLambda0
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public final void onCompleted(BoxResponse boxResponse) {
                this.f$0.lambda$addComment$0(onCompletedListener, boxResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addComment$0(BoxFutureTask.OnCompletedListener onCompletedListener, BoxResponse boxResponse) {
        onCompletedListener.onCompleted(boxResponse);
        LocalBroadcastManager.getInstance(this.mContext).sendBroadcast(new BoxResponseMessage(boxResponse, true));
    }

    @Override // com.box.android.data.controller.impl.BoxCommentsController, com.box.android.domain.controller.ICommentsController
    public void addTaggedComment(String boxFileId, String taggedMessage, final BoxFutureTask.OnCompletedListener<BoxComment> onCompletedListener) {
        this.mBaseModelController.performRemote(this.mExtendedFileApi.getAddTaggedCommentRequest(boxFileId, taggedMessage), new BoxAppFutureTask.OnCompletedListener() { // from class: com.box.android.data.controller.impl.LegacyCommentsController$$ExternalSyntheticLambda1
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public final void onCompleted(BoxResponse boxResponse) {
                this.f$0.lambda$addTaggedComment$1(onCompletedListener, boxResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addTaggedComment$1(BoxFutureTask.OnCompletedListener onCompletedListener, BoxResponse boxResponse) {
        onCompletedListener.onCompleted(boxResponse);
        LocalBroadcastManager.getInstance(this.mContext).sendBroadcast(new BoxResponseMessage(boxResponse, true));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.box.android.data.controller.impl.LegacyCommentsController$1] */
    @Override // com.box.android.data.controller.impl.BoxCommentsController, com.box.android.domain.controller.ICommentsController
    public void fetchComments(final BoxFile file, final BoxFutureTask.OnCompletedListener<BoxIteratorComments> onCompletedListener, final int offset) {
        new AsyncTask<Void, Void, BoxResponse<BoxIteratorComments>>() { // from class: com.box.android.data.controller.impl.LegacyCommentsController.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public BoxResponse<BoxIteratorComments> doInBackground(Void... params) {
                try {
                    BoxRequestsFile.GetFileComments commentsRequest = LegacyCommentsController.this.mExtendedFileApi.getCommentsRequest(file.getUserId());
                    commentsRequest.setOffset(offset);
                    if (offset > 0) {
                        return new BoxResponse<>(new BoxIteratorComments(), new Exception(), commentsRequest);
                    }
                    return (BoxResponse) LegacyCommentsController.this.mBaseModelController.performLocal(commentsRequest).get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                    return null;
                } catch (ExecutionException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(BoxResponse<BoxIteratorComments> response) {
                if (response.isSuccess()) {
                    onCompletedListener.onCompleted(response);
                } else if (file.getCommentCount() != null && file.getCommentCount().longValue() == 0) {
                    onCompletedListener.onCompleted(new BoxResponse(new BoxIteratorComments(), null, response.getRequest()));
                }
                LegacyCommentsController.super.fetchComments(file, onCompletedListener, offset);
            }
        }.execute(new Void[0]);
    }

    @Override // com.box.android.domain.controller.ILegacyCommentsController
    public void fetchCommentsMuteStatus(String fileId, final ILegacyCommentsController.CommentStatusListener mListener) {
        IBaseModelController iBaseModelController = this.mBaseModelController;
        BoxFileNotificationMute.GetFileMute fileNotificationMute = this.mExtendedFileApi.getFileNotificationMute(fileId);
        Objects.requireNonNull(mListener);
        iBaseModelController.performLocal(fileNotificationMute, new BoxAppFutureTask.OnCompletedListener() { // from class: com.box.android.data.controller.impl.LegacyCommentsController$$ExternalSyntheticLambda2
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public final void onCompleted(BoxResponse boxResponse) {
                mListener.onCompleted(boxResponse);
            }
        });
    }

    @Override // com.box.android.domain.controller.ILegacyCommentsController
    public void removeMuteStatus(final String fileId) {
        this.mBaseModelController.performLocal(this.mExtendedFileApi.removeMuteNotificationCategory(fileId, BoxExtendedApiCollections.COLLECTION_TYPE_MUTE_CONVERSATIONS));
    }
}
