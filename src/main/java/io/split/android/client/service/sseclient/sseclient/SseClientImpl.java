package io.split.android.client.service.sseclient.sseclient;

import io.split.android.client.network.HttpClient;
import io.split.android.client.network.HttpException;
import io.split.android.client.network.HttpStreamRequest;
import io.split.android.client.network.HttpStreamResponse;
import io.split.android.client.network.URIBuilder;
import io.split.android.client.service.http.HttpStatus;
import io.split.android.client.service.sseclient.EventStreamParser;
import io.split.android.client.service.sseclient.SseJwtToken;
import io.split.android.client.utils.StringHelper;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public class SseClientImpl implements SseClient {
    private static final String PUSH_NOTIFICATION_CHANNELS_PARAM = "channel";
    private static final String PUSH_NOTIFICATION_TOKEN_PARAM = "accessToken";
    private static final String PUSH_NOTIFICATION_VERSION_PARAM = "v";
    private static final String PUSH_NOTIFICATION_VERSION_VALUE = "1.1";
    private final EventStreamParser mEventStreamParser;
    private final HttpClient mHttpClient;
    private HttpStreamRequest mHttpStreamRequest = null;
    private final AtomicBoolean mIsDisconnectCalled;
    private final SseHandler mSseHandler;
    private final AtomicInteger mStatus;
    private final StringHelper mStringHelper;
    private final URI mTargetUrl;

    public SseClientImpl(URI uri, HttpClient httpClient, EventStreamParser eventStreamParser, SseHandler sseHandler) {
        this.mTargetUrl = (URI) Utils.checkNotNull(uri);
        this.mHttpClient = (HttpClient) Utils.checkNotNull(httpClient);
        this.mEventStreamParser = (EventStreamParser) Utils.checkNotNull(eventStreamParser);
        this.mSseHandler = (SseHandler) Utils.checkNotNull(sseHandler);
        AtomicInteger atomicInteger = new AtomicInteger(2);
        this.mStatus = atomicInteger;
        this.mIsDisconnectCalled = new AtomicBoolean(false);
        this.mStringHelper = new StringHelper();
        atomicInteger.set(2);
    }

    @Override // io.split.android.client.service.sseclient.sseclient.SseClient
    public int status() {
        return this.mStatus.get();
    }

    @Override // io.split.android.client.service.sseclient.sseclient.SseClient
    public void disconnect() {
        if (this.mIsDisconnectCalled.getAndSet(true)) {
            return;
        }
        close();
    }

    private void close() {
        Logger.d("Disconnecting SSE client");
        if (this.mStatus.getAndSet(2) != 2) {
            HttpStreamRequest httpStreamRequest = this.mHttpStreamRequest;
            if (httpStreamRequest != null) {
                httpStreamRequest.close();
            }
            Logger.d("SSE client disconnected");
        }
    }

    @Override // io.split.android.client.service.sseclient.sseclient.SseClient
    public void connect(SseJwtToken token, SseClient.ConnectionListener connectionListener) {
        this.mIsDisconnectCalled.set(false);
        this.mStatus.set(0);
        boolean zIsClientRelatedError = true;
        try {
            try {
                try {
                    try {
                        HttpStreamRequest httpStreamRequestStreamRequest = this.mHttpClient.streamRequest(new URIBuilder(this.mTargetUrl).addParameter("v", "1.1").addParameter(PUSH_NOTIFICATION_CHANNELS_PARAM, this.mStringHelper.join(",", token.getChannels())).addParameter(PUSH_NOTIFICATION_TOKEN_PARAM, token.getRawJwt()).build());
                        this.mHttpStreamRequest = httpStreamRequestStreamRequest;
                        HttpStreamResponse httpStreamResponseExecute = httpStreamRequestStreamRequest.execute();
                        if (httpStreamResponseExecute.isSuccess()) {
                            BufferedReader bufferedReader = httpStreamResponseExecute.getBufferedReader();
                            if (bufferedReader == null) {
                                throw new IOException("Buffer is null");
                            }
                            Logger.d("Streaming connection opened");
                            this.mStatus.set(1);
                            HashMap map = new HashMap();
                            boolean z = false;
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                if (this.mEventStreamParser.parseLineAndAppendValue(line, map)) {
                                    if (!z) {
                                        if (!this.mEventStreamParser.isKeepAlive(map) && !this.mSseHandler.isConnectionConfirmed(map)) {
                                            Logger.d("Streaming error after connection");
                                            zIsClientRelatedError = this.mSseHandler.isRetryableError(map);
                                            break;
                                        }
                                        Logger.d("Streaming connection success");
                                        connectionListener.onConnectionSuccess();
                                        z = true;
                                    }
                                    if (!this.mEventStreamParser.isKeepAlive(map)) {
                                        this.mSseHandler.handleIncomingMessage(map);
                                    }
                                    map = new HashMap();
                                }
                            }
                        } else {
                            Logger.e("Streaming connection error. Http return code " + httpStreamResponseExecute.getHttpStatus());
                            zIsClientRelatedError = true ^ httpStreamResponseExecute.isClientRelatedError();
                        }
                        if (this.mIsDisconnectCalled.getAndSet(false)) {
                            return;
                        }
                        this.mSseHandler.handleError(zIsClientRelatedError);
                        close();
                    } catch (Exception e) {
                        logError("An unexpected error has occurred while receiving stream events from: ", e);
                        if (this.mIsDisconnectCalled.getAndSet(false)) {
                            return;
                        }
                        this.mSseHandler.handleError(true);
                        close();
                    }
                } catch (HttpException e2) {
                    logError("An error has occurred while creating stream Url ", e2);
                    boolean z2 = !HttpStatus.isNotRetryable(HttpStatus.fromCode(e2.getStatusCode()));
                    if (this.mIsDisconnectCalled.getAndSet(false)) {
                        return;
                    }
                    this.mSseHandler.handleError(z2);
                    close();
                }
            } catch (IOException e3) {
                Logger.d("An error has occurred while parsing stream: " + e3.getLocalizedMessage());
                if (this.mIsDisconnectCalled.getAndSet(false)) {
                    return;
                }
                this.mSseHandler.handleError(true);
                close();
            } catch (URISyntaxException e4) {
                logError("An error has occurred while creating stream Url ", e4);
                if (this.mIsDisconnectCalled.getAndSet(false)) {
                    return;
                }
                this.mSseHandler.handleError(false);
                close();
            }
        } catch (Throwable th) {
            if (!this.mIsDisconnectCalled.getAndSet(false)) {
                this.mSseHandler.handleError(true);
                close();
            }
            throw th;
        }
    }

    private void logError(String message, Exception e) {
        Logger.e(message + " : " + e.getLocalizedMessage());
    }
}
