package io.split.android.client.service.splits;

import io.split.android.client.storage.general.GeneralInfoStorage;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public class OutdatedSplitProxyHandler {
    private static final String PREVIOUS_SPEC = "1.2";
    private final AtomicReference<ProxyHandlingType> mCurrentProxyHandlingType;
    private final boolean mForBackgroundSync;
    private final GeneralInfoStorage mGeneralInfoStorage;
    private final AtomicLong mLastProxyCheckTimestamp;
    private final String mLatestSpec;
    private final String mPreviousSpec;
    private final long mProxyCheckIntervalMillis;

    private enum ProxyHandlingType {
        NONE,
        FALLBACK,
        RECOVERY
    }

    OutdatedSplitProxyHandler(String flagSpec, boolean forBackgroundSync, GeneralInfoStorage generalInfoStorage, long proxyCheckIntervalMillis) {
        this(flagSpec, PREVIOUS_SPEC, forBackgroundSync, generalInfoStorage, proxyCheckIntervalMillis);
    }

    OutdatedSplitProxyHandler(String flagSpec, String previousSpec, boolean forBackgroundSync, GeneralInfoStorage generalInfoStorage, long proxyCheckIntervalMillis) {
        this.mLastProxyCheckTimestamp = new AtomicLong(0L);
        this.mCurrentProxyHandlingType = new AtomicReference<>(ProxyHandlingType.NONE);
        this.mLatestSpec = flagSpec;
        this.mPreviousSpec = previousSpec;
        this.mForBackgroundSync = forBackgroundSync;
        this.mProxyCheckIntervalMillis = proxyCheckIntervalMillis;
        this.mGeneralInfoStorage = (GeneralInfoStorage) Utils.checkNotNull(generalInfoStorage);
    }

    void trackProxyError() {
        if (this.mForBackgroundSync) {
            Logger.i("Background sync fetch; skipping proxy handling");
            updateHandlingType(ProxyHandlingType.NONE);
        } else {
            updateLastProxyCheckTimestamp(System.currentTimeMillis());
            updateHandlingType(ProxyHandlingType.FALLBACK);
        }
    }

    void performProxyCheck() {
        if (this.mForBackgroundSync) {
            updateHandlingType(ProxyHandlingType.NONE);
        }
        long lastProxyCheckTimestamp = getLastProxyCheckTimestamp();
        if (lastProxyCheckTimestamp == 0) {
            updateHandlingType(ProxyHandlingType.NONE);
        } else if (System.currentTimeMillis() - lastProxyCheckTimestamp > this.mProxyCheckIntervalMillis) {
            Logger.i("Time since last check elapsed. Attempting recovery with latest spec: " + this.mLatestSpec);
            updateHandlingType(ProxyHandlingType.RECOVERY);
        } else {
            Logger.v("Have used proxy fallback mode; time since last check has not elapsed. Using previous spec");
            updateHandlingType(ProxyHandlingType.FALLBACK);
        }
    }

    void resetProxyCheckTimestamp() {
        updateLastProxyCheckTimestamp(0L);
    }

    String getCurrentSpec() {
        if (this.mCurrentProxyHandlingType.get() == ProxyHandlingType.FALLBACK) {
            return this.mPreviousSpec;
        }
        return this.mLatestSpec;
    }

    boolean isFallbackMode() {
        return this.mCurrentProxyHandlingType.get() == ProxyHandlingType.FALLBACK;
    }

    boolean isRecoveryMode() {
        return this.mCurrentProxyHandlingType.get() == ProxyHandlingType.RECOVERY;
    }

    private void updateHandlingType(ProxyHandlingType proxyHandlingType) {
        this.mCurrentProxyHandlingType.set(proxyHandlingType);
    }

    private long getLastProxyCheckTimestamp() {
        this.mLastProxyCheckTimestamp.compareAndSet(0L, this.mGeneralInfoStorage.getLastProxyUpdateTimestamp());
        return this.mLastProxyCheckTimestamp.get();
    }

    private void updateLastProxyCheckTimestamp(long newTimestamp) {
        this.mLastProxyCheckTimestamp.set(newTimestamp);
        this.mGeneralInfoStorage.setLastProxyUpdateTimestamp(newTimestamp);
    }
}
