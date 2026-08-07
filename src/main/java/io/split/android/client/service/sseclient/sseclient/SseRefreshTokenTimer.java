package io.split.android.client.service.sseclient.sseclient;

import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.sseclient.feedbackchannel.PushManagerEventBroadcaster;
import io.split.android.client.service.sseclient.feedbackchannel.PushStatusEvent;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class SseRefreshTokenTimer implements SplitTaskExecutionListener {
    private static final int RECONNECT_TIME_BEFORE_TOKEN_EXP_IN_SECONDS = 600;
    PushManagerEventBroadcaster mBroadcasterChannel;
    SplitTaskExecutor mTaskExecutor;
    String mTaskId;

    public SseRefreshTokenTimer(SplitTaskExecutor taskExecutor, PushManagerEventBroadcaster broadcasterChannel) {
        this.mTaskExecutor = (SplitTaskExecutor) Utils.checkNotNull(taskExecutor);
        this.mBroadcasterChannel = (PushManagerEventBroadcaster) Utils.checkNotNull(broadcasterChannel);
    }

    public void cancel() {
        this.mTaskExecutor.stopTask(this.mTaskId);
    }

    public void schedule(long issueAtTime, long expirationTime) {
        cancel();
        this.mTaskId = this.mTaskExecutor.schedule(new SplitTask() { // from class: io.split.android.client.service.sseclient.sseclient.SseRefreshTokenTimer.1
            @Override // io.split.android.client.service.executor.SplitTask
            public SplitTaskExecutionInfo execute() {
                Logger.d("Informing sse token expired through pushing retryable error.");
                SseRefreshTokenTimer.this.mBroadcasterChannel.pushMessage(new PushStatusEvent(PushStatusEvent.EventType.PUSH_RETRYABLE_ERROR));
                return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
            }
        }, reconnectTime(issueAtTime, expirationTime), null);
    }

    private long reconnectTime(long issuedAtTime, long expirationTime) {
        return Math.max((expirationTime - issuedAtTime) - 600, 0L);
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
    public void taskExecuted(SplitTaskExecutionInfo taskInfo) {
        this.mTaskId = null;
    }
}
