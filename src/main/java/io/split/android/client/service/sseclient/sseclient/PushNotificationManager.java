package io.split.android.client.service.sseclient.sseclient;

import io.split.android.client.service.executor.SplitSingleThreadTaskExecutor;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.executor.ThreadFactoryBuilder;
import io.split.android.client.service.sseclient.SseJwtToken;
import io.split.android.client.service.sseclient.feedbackchannel.DelayStatusEvent;
import io.split.android.client.service.sseclient.feedbackchannel.PushManagerEventBroadcaster;
import io.split.android.client.service.sseclient.feedbackchannel.PushStatusEvent;
import io.split.android.client.telemetry.model.OperationType;
import io.split.android.client.telemetry.model.streaming.SyncModeUpdateStreamingEvent;
import io.split.android.client.telemetry.model.streaming.TokenRefreshStreamingEvent;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class PushNotificationManager {
    private static final long AWAIT_SHUTDOWN_TIME = 5;
    private static final int POOL_SIZE = 1;
    private final SplitTask mBackgroundDisconnectionTask;
    private final PushManagerEventBroadcaster mBroadcasterChannel;
    private Future<?> mConnectionTask;
    private final long mDefaultSSEConnectionDelayInSecs;
    private final SseDisconnectionTimer mDisconnectionTimer;
    private final ScheduledExecutorService mExecutor;
    private final AtomicBoolean mIsPaused;
    private final AtomicBoolean mIsStopped;
    private final SseRefreshTokenTimer mRefreshTokenTimer;
    private final SseAuthenticator mSseAuthenticator;
    private final SseClient mSseClient;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    public PushNotificationManager(PushManagerEventBroadcaster pushManagerEventBroadcaster, SseAuthenticator sseAuthenticator, SseClient sseClient, SseRefreshTokenTimer refreshTokenTimer, TelemetryRuntimeProducer telemetryRuntimeProducer, long defaultSSEConnectionDelayInSecs, int sseDisconnectionDelayInSecs, ScheduledExecutorService executorService) {
        this(pushManagerEventBroadcaster, sseAuthenticator, sseClient, refreshTokenTimer, new SseDisconnectionTimer(new SplitSingleThreadTaskExecutor(), sseDisconnectionDelayInSecs), telemetryRuntimeProducer, defaultSSEConnectionDelayInSecs, executorService);
    }

    public PushNotificationManager(PushManagerEventBroadcaster broadcasterChannel, SseAuthenticator sseAuthenticator, SseClient sseClient, SseRefreshTokenTimer refreshTokenTimer, SseDisconnectionTimer disconnectionTimer, TelemetryRuntimeProducer telemetryRuntimeProducer, long defaultSSEConnectionDelayInSecs, ScheduledExecutorService executor) {
        this.mBroadcasterChannel = (PushManagerEventBroadcaster) Utils.checkNotNull(broadcasterChannel);
        this.mSseAuthenticator = (SseAuthenticator) Utils.checkNotNull(sseAuthenticator);
        SseClient sseClient2 = (SseClient) Utils.checkNotNull(sseClient);
        this.mSseClient = sseClient2;
        SseRefreshTokenTimer sseRefreshTokenTimer = (SseRefreshTokenTimer) Utils.checkNotNull(refreshTokenTimer);
        this.mRefreshTokenTimer = sseRefreshTokenTimer;
        this.mDisconnectionTimer = (SseDisconnectionTimer) Utils.checkNotNull(disconnectionTimer);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Utils.checkNotNull(telemetryRuntimeProducer);
        this.mIsStopped = new AtomicBoolean(false);
        this.mIsPaused = new AtomicBoolean(false);
        this.mBackgroundDisconnectionTask = new BackgroundDisconnectionTask(sseClient2, sseRefreshTokenTimer);
        this.mDefaultSSEConnectionDelayInSecs = defaultSSEConnectionDelayInSecs;
        if (executor != null) {
            this.mExecutor = executor;
        } else {
            this.mExecutor = buildExecutor();
        }
    }

    public synchronized void start() {
        this.mTelemetryRuntimeProducer.recordStreamingEvents(new SyncModeUpdateStreamingEvent(SyncModeUpdateStreamingEvent.Mode.STREAMING, System.currentTimeMillis()));
        Logger.d("Push notification manager started");
        connect();
    }

    public void pause() {
        this.mIsPaused.set(true);
        this.mDisconnectionTimer.schedule(this.mBackgroundDisconnectionTask);
        Logger.d("Push notification manager paused");
    }

    public void resume() {
        if (this.mIsPaused.compareAndSet(true, false)) {
            this.mDisconnectionTimer.cancel();
            if (isSseClientDisconnected() && !this.mIsStopped.get()) {
                connect();
            }
            Logger.d("Push notification manager resumed");
        }
    }

    public boolean isSseClientDisconnected() {
        return this.mSseClient.status() == 2;
    }

    public synchronized void stop() {
        Logger.d("Shutting down SSE client");
        this.mIsStopped.set(true);
        disconnect();
        shutdownAndAwaitTermination();
    }

    public void disconnect() {
        Logger.d("Disconnecting down SSE client");
        this.mDisconnectionTimer.cancel();
        this.mRefreshTokenTimer.cancel();
        this.mSseClient.disconnect();
    }

    public void connect() {
        if (this.mSseClient.status() == 1) {
            this.mSseClient.disconnect();
        }
        Future<?> future = this.mConnectionTask;
        if (future != null && (!future.isDone() || !this.mConnectionTask.isCancelled())) {
            this.mConnectionTask.cancel(true);
        }
        this.mConnectionTask = this.mExecutor.submit(new StreamingConnection(this.mDefaultSSEConnectionDelayInSecs));
    }

    private void shutdownAndAwaitTermination() {
        this.mExecutor.shutdown();
        try {
            if (this.mExecutor.awaitTermination(5L, TimeUnit.SECONDS)) {
                return;
            }
            this.mExecutor.shutdownNow();
            if (this.mExecutor.awaitTermination(5L, TimeUnit.SECONDS)) {
                return;
            }
            System.err.println("Sse client pool did not terminate");
        } catch (InterruptedException unused) {
            this.mExecutor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    private ScheduledThreadPoolExecutor buildExecutor() {
        ThreadFactoryBuilder threadFactoryBuilder = new ThreadFactoryBuilder();
        threadFactoryBuilder.setDaemon(true);
        threadFactoryBuilder.setNameFormat("split-sse_client-%d");
        threadFactoryBuilder.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: io.split.android.client.service.sseclient.sseclient.PushNotificationManager.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread t, Throwable e) {
                Logger.e(e, "Error in thread: %s", t.getName());
            }
        });
        return new ScheduledThreadPoolExecutor(1, threadFactoryBuilder.build());
    }

    private class StreamingConnection implements Runnable {
        private final long mDefaultSSEConnectionDelayInSecs;

        public StreamingConnection(long defaultSseConnectionDelaySecs) {
            this.mDefaultSSEConnectionDelayInSecs = defaultSseConnectionDelaySecs;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            SseAuthenticationResult sseAuthenticationResultAuthenticate = PushNotificationManager.this.mSseAuthenticator.authenticate(this.mDefaultSSEConnectionDelayInSecs);
            PushNotificationManager.this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.TOKEN, System.currentTimeMillis() - jCurrentTimeMillis);
            if (sseAuthenticationResultAuthenticate.isSuccess() && !sseAuthenticationResultAuthenticate.isPushEnabled()) {
                handlePushDisabled();
                return;
            }
            if (!sseAuthenticationResultAuthenticate.isSuccess() && !sseAuthenticationResultAuthenticate.isErrorRecoverable()) {
                handleNonRetryableError(sseAuthenticationResultAuthenticate);
                recordNonRetryableError(sseAuthenticationResultAuthenticate);
                return;
            }
            if (!sseAuthenticationResultAuthenticate.isSuccess() && sseAuthenticationResultAuthenticate.isErrorRecoverable()) {
                handleRetryableError();
                return;
            }
            final SseJwtToken jwtToken = sseAuthenticationResultAuthenticate.getJwtToken();
            if (jwtToken == null || jwtToken.getChannels() == null || jwtToken.getRawJwt() == null) {
                handleAuthError();
                return;
            }
            recordSuccessfulSyncAndTokenRefreshes(jwtToken);
            long sseConnectionDelay = sseAuthenticationResultAuthenticate.getSseConnectionDelay();
            PushNotificationManager.this.mBroadcasterChannel.pushMessage(new DelayStatusEvent(sseConnectionDelay));
            if ((sseConnectionDelay > 0 && !delay(sseConnectionDelay)) || PushNotificationManager.this.mIsPaused.get() || PushNotificationManager.this.mIsStopped.get()) {
                return;
            }
            PushNotificationManager.this.mSseClient.connect(jwtToken, new SseClient.ConnectionListener() { // from class: io.split.android.client.service.sseclient.sseclient.PushNotificationManager.StreamingConnection.1
                @Override // io.split.android.client.service.sseclient.sseclient.SseClient.ConnectionListener
                public void onConnectionSuccess() {
                    PushNotificationManager.this.mBroadcasterChannel.pushMessage(new PushStatusEvent(PushStatusEvent.EventType.PUSH_SUBSYSTEM_UP));
                    PushNotificationManager.this.mRefreshTokenTimer.schedule(jwtToken.getIssuedAtTime(), jwtToken.getExpirationTime());
                }
            });
        }

        private void recordSuccessfulSyncAndTokenRefreshes(SseJwtToken token) {
            PushNotificationManager.this.mTelemetryRuntimeProducer.recordSuccessfulSync(OperationType.TOKEN, System.currentTimeMillis());
            PushNotificationManager.this.mTelemetryRuntimeProducer.recordStreamingEvents(new TokenRefreshStreamingEvent(token.getExpirationTime(), System.currentTimeMillis()));
            PushNotificationManager.this.mTelemetryRuntimeProducer.recordTokenRefreshes();
        }

        private void handlePushDisabled() {
            Logger.d("Streaming disabled");
            PushNotificationManager.this.mBroadcasterChannel.pushMessage(new PushStatusEvent(PushStatusEvent.EventType.PUSH_SUBSYSTEM_DOWN));
            PushNotificationManager.this.mIsStopped.set(true);
        }

        private void handleNonRetryableError(SseAuthenticationResult authResult) {
            Logger.d("Streaming no recoverable auth error.");
            PushNotificationManager.this.mBroadcasterChannel.pushMessage(new PushStatusEvent(PushStatusEvent.EventType.PUSH_NON_RETRYABLE_ERROR));
            PushNotificationManager.this.mIsStopped.set(true);
        }

        private void recordNonRetryableError(SseAuthenticationResult authResult) {
            PushNotificationManager.this.mTelemetryRuntimeProducer.recordAuthRejections();
            if (authResult.getHttpStatus() != null) {
                PushNotificationManager.this.mTelemetryRuntimeProducer.recordSyncError(OperationType.TOKEN, authResult.getHttpStatus());
            }
        }

        private void handleAuthError() {
            Logger.d("Streaming auth error. Retrying");
            handleRetryableError();
        }

        private void handleRetryableError() {
            PushNotificationManager.this.mBroadcasterChannel.pushMessage(new PushStatusEvent(PushStatusEvent.EventType.PUSH_RETRYABLE_ERROR));
        }

        private boolean delay(long seconds) {
            try {
                Thread.sleep(seconds * 1000);
                return true;
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
    }

    public static class BackgroundDisconnectionTask implements SplitTask {
        private final SseRefreshTokenTimer mRefreshTokenTimer;
        private final SseClient mSseClient;

        public BackgroundDisconnectionTask(SseClient sseClient, SseRefreshTokenTimer refreshTokenTimer) {
            this.mSseClient = sseClient;
            this.mRefreshTokenTimer = refreshTokenTimer;
        }

        @Override // io.split.android.client.service.executor.SplitTask
        public SplitTaskExecutionInfo execute() {
            Logger.d("Disconnecting streaming while in background");
            this.mSseClient.disconnect();
            this.mRefreshTokenTimer.cancel();
            return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
        }
    }
}
