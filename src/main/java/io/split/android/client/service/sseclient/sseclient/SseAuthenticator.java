package io.split.android.client.service.sseclient.sseclient;

import io.split.android.client.service.http.HttpFetcher;
import io.split.android.client.service.http.HttpFetcherException;
import io.split.android.client.service.http.HttpStatus;
import io.split.android.client.service.sseclient.InvalidJwtTokenException;
import io.split.android.client.service.sseclient.SseAuthenticationResponse;
import io.split.android.client.service.sseclient.SseJwtParser;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class SseAuthenticator {
    private static final String USER_KEY_PARAM = "users";
    private final HttpFetcher<SseAuthenticationResponse> mAuthFetcher;
    private final String mFlagsSpec;
    private final SseJwtParser mJwtParser;
    private final Set<String> mUserKeys = Collections.newSetFromMap(new ConcurrentHashMap());

    public SseAuthenticator(HttpFetcher<SseAuthenticationResponse> authFetcher, SseJwtParser jwtParser, String flagsSpec) {
        this.mAuthFetcher = (HttpFetcher) Utils.checkNotNull(authFetcher);
        this.mJwtParser = (SseJwtParser) Utils.checkNotNull(jwtParser);
        this.mFlagsSpec = flagsSpec;
    }

    public SseAuthenticationResult authenticate(long defaultSseConnectionDelaySecs) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String str = this.mFlagsSpec;
            if (str != null && !str.trim().isEmpty()) {
                linkedHashMap.put("s", this.mFlagsSpec);
            }
            linkedHashMap.put(USER_KEY_PARAM, this.mUserKeys);
            SseAuthenticationResponse sseAuthenticationResponseExecute = this.mAuthFetcher.execute(linkedHashMap, null);
            Logger.d("SSE Authentication done, now parsing token");
            if (sseAuthenticationResponseExecute.isClientError()) {
                Logger.d("Error while authenticating to streaming. Check your SDK key is correct.");
                return unsuccessfulAuthenticationUnrecoverableError();
            }
            if (!sseAuthenticationResponseExecute.isStreamingEnabled()) {
                Logger.d("Streaming disabled for SDK key");
                return new SseAuthenticationResult(true, true, false, 0L, null);
            }
            try {
                if (sseAuthenticationResponseExecute.getSseConnectionDelay() != null) {
                    defaultSseConnectionDelaySecs = sseAuthenticationResponseExecute.getSseConnectionDelay().longValue();
                }
                Logger.d("SSE token parsed successfully");
                return new SseAuthenticationResult(true, true, true, defaultSseConnectionDelaySecs, this.mJwtParser.parse(sseAuthenticationResponseExecute.getToken()));
            } catch (InvalidJwtTokenException unused) {
                Logger.e("Error while parsing Jwt");
                return unexpectedError();
            }
        } catch (HttpFetcherException e) {
            logError("Unexpected " + e.getLocalizedMessage());
            if (e.getHttpStatus() != null) {
                if (HttpStatus.isNotRetryable(HttpStatus.fromCode(e.getHttpStatus()))) {
                    return unsuccessfulAuthenticationUnrecoverableError();
                }
                return unexpectedHttpError(e.getHttpStatus().intValue());
            }
            return unexpectedError();
        } catch (Exception e2) {
            logError("Unexpected " + e2.getLocalizedMessage());
            return unexpectedError();
        }
    }

    private static SseAuthenticationResult unsuccessfulAuthenticationUnrecoverableError() {
        return new SseAuthenticationResult(false, false, false, 0L, null);
    }

    public void registerKey(String userKey) {
        this.mUserKeys.add(userKey);
    }

    public void unregisterKey(String userKey) {
        this.mUserKeys.remove(userKey);
    }

    private void logError(String message) {
        Logger.e("Error while authenticating to SSE server: " + message);
    }

    private SseAuthenticationResult unexpectedError() {
        return new SseAuthenticationResult(false, true);
    }

    private SseAuthenticationResult unexpectedHttpError(int httpStatus) {
        return new SseAuthenticationResult(httpStatus);
    }
}
