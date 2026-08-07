package com.box.android.domain.controller;

import android.content.Context;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxComment;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxIteratorCollaborations;
import com.box.androidsdk.content.models.BoxIteratorCollaborators;
import com.box.androidsdk.content.models.BoxIteratorComments;
import com.box.androidsdk.content.views.BoxAvatarView;
import java.io.Serializable;

/* JADX INFO: loaded from: classes11.dex */
public interface ICommentsController {
    void addComment(String str, String str2, BoxFutureTask.OnCompletedListener<BoxComment> onCompletedListener);

    void addTaggedComment(String str, String str2, BoxFutureTask.OnCompletedListener<BoxComment> onCompletedListener);

    void clearTasks();

    void fetchCollaborations(BoxFile boxFile, BoxFutureTask.OnCompletedListener<BoxIteratorCollaborations> onCompletedListener);

    void fetchCollaborators(BoxFile boxFile, BoxFutureTask.OnCompletedListener<BoxIteratorCollaborators> onCompletedListener);

    void fetchComments(BoxFile boxFile, BoxFutureTask.OnCompletedListener<BoxIteratorComments> onCompletedListener, int i);

    <E extends BoxAvatarView.AvatarController & Serializable> E getAvatarController();

    void showToast(Context context, int i);
}
