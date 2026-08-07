package com.box.android.receiver;

import android.app.RemoteInput;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationManagerCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.activities.NotificationInterceptorActivity;
import com.box.android.controller.ExecutorPool;
import com.box.android.coreservices.modelcontroller.BoxAppFutureTask;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.messages.BoxResponseMessage;
import com.box.android.domain.analytics.BoxAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.pushnotification.BoxPushNotifObjectComments;
import com.box.androidsdk.content.models.BoxComment;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.model.BoxPushNotification;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes12.dex */
public class CommentsReplyReceiver extends Hilt_CommentsReplyReceiver {
    public static final String FILE_ID = "CommentsReplyBroadcastReceiver.FILE_ID";
    private static String KEY_MESSAGE_ID = "key_message_id";
    private static String KEY_NOTIFICATION_ID = "key_noticiation_id";
    public static final String REPLY_ACTION = "CommentsReplyBroadcastReceiver.REPLY_ACTION";

    @Inject
    BoxApiPrivate mApiPrivate;

    @Inject
    IBaseModelController mBaseModelController;

    @Inject
    BoxExtendedApiFile mFileApi;

    @Inject
    IUserContextManager mUserContextManager;

    public static Intent getReplyMessageIntent(Context context, int i, int i2, String str, List<String> list) {
        Intent intent = new Intent(context, (Class<?>) CommentsReplyReceiver.class);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            intent.addCategory(it.next());
        }
        intent.setAction(REPLY_ACTION);
        intent.putExtra(KEY_NOTIFICATION_ID, i);
        intent.putExtra(KEY_MESSAGE_ID, i2);
        intent.putExtra(FILE_ID, str);
        return intent;
    }

    @Override // com.box.android.receiver.Hilt_CommentsReplyReceiver, com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
    public void onMAMReceive(final Context context, final Intent intent) {
        super.onMAMReceive(context, intent);
        if (REPLY_ACTION.equals(intent.getAction())) {
            BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_PUSH_NOTIFICATIONS, BoxAnalyticsParams.ACTION_REPLY_INLINE, BoxPushNotification.PushNotifType.COMMENT_CREATE.name());
            Bundle resultsFromIntent = RemoteInput.getResultsFromIntent(intent);
            if (resultsFromIntent != null) {
                CharSequence charSequence = resultsFromIntent.getCharSequence(BoxPushNotifObjectComments.KEY_TEXT_REPLY);
                String stringExtra = intent.getStringExtra(FILE_ID);
                final ArrayList arrayList = new ArrayList(intent.getCategories());
                if (TextUtils.isEmpty(charSequence) || TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                this.mBaseModelController.performRemote(this.mFileApi.getAddCommentRequest(stringExtra, charSequence.toString()), new BoxAppFutureTask.OnCompletedListener<BoxComment>() { // from class: com.box.android.receiver.CommentsReplyReceiver.1
                    @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
                    public void onCompleted(BoxResponse boxResponse) {
                        NotificationManagerCompat.from(context).cancel(intent.getIntExtra(CommentsReplyReceiver.KEY_NOTIFICATION_ID, 1));
                        CommentsReplyReceiver.this.dismissNotification(arrayList);
                        LocalBroadcastManager.getInstance(context).sendBroadcast(new BoxResponseMessage(boxResponse, true));
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissNotification(List<String> list) {
        if (list.size() > 0) {
            ((ExecutorPool) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.EXECUTOR_POOL)).getNotificationExecutor().submit(NotificationInterceptorActivity.createDismissRunnable(list, this.mApiPrivate));
        }
    }
}
