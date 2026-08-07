package io.split.android.client;

import io.split.android.client.utils.logger.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class RolloutCacheConfiguration {
    private final boolean mClearOnInit;
    private final int mExpirationDays;

    private RolloutCacheConfiguration(int expiration, boolean clearOnInit) {
        this.mExpirationDays = expiration;
        this.mClearOnInit = clearOnInit;
    }

    public int getExpirationDays() {
        return this.mExpirationDays;
    }

    public boolean isClearOnInit() {
        return this.mClearOnInit;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private static final int MIN_EXPIRATION_DAYS = 1;
        private boolean mClearOnInit;
        private int mExpiration;

        private Builder() {
            this.mExpiration = 10;
            this.mClearOnInit = false;
        }

        public Builder expirationDays(int expirationDays) {
            if (expirationDays < 1) {
                Logger.w("Cache expiration must be at least 1 day. Using default value.");
                this.mExpiration = 10;
                return this;
            }
            this.mExpiration = expirationDays;
            return this;
        }

        public Builder clearOnInit(boolean clearOnInit) {
            this.mClearOnInit = clearOnInit;
            return this;
        }

        public RolloutCacheConfiguration build() {
            return new RolloutCacheConfiguration(this.mExpiration, this.mClearOnInit);
        }
    }
}
