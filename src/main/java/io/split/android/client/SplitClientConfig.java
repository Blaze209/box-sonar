package io.split.android.client;

import io.split.android.client.impressions.ImpressionListener;
import io.split.android.client.network.CertificatePinningConfiguration;
import io.split.android.client.network.DevelopmentSslConfig;
import io.split.android.client.network.HttpProxy;
import io.split.android.client.network.SplitAuthenticator;
import io.split.android.client.service.ServiceConstants;
import io.split.android.client.service.impressions.ImpressionsMode;
import io.split.android.client.shared.UserConsent;
import io.split.android.client.telemetry.TelemetryHelperImpl;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import io.split.android.client.validators.PrefixValidatorImpl;
import io.split.android.client.validators.ValidationErrorInfo;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes4.dex */
public class SplitClientConfig {
    private static final int DEFAULT_BACKGROUND_SYNC_PERIOD_MINUTES = 15;
    private static final int DEFAULT_CONNECTION_TIMEOUT_SECS = 10000;
    private static final String DEFAULT_DATA_FOLDER = "split_data";
    private static final int DEFAULT_EVENTS_FLUSH_INTERVAL = 1800;
    private static final int DEFAULT_EVENTS_PER_PUSH = 2000;
    private static final int DEFAULT_EVENTS_QUEUE_SIZE = 10000;
    private static final int DEFAULT_FEATURES_REFRESH_RATE_SECS = 3600;
    private static final int DEFAULT_IMPRESSIONS_CHUNK_SIZE = 2048;
    private static final int DEFAULT_IMPRESSIONS_PER_PUSH = 2000;
    private static final int DEFAULT_IMPRESSIONS_QUEUE_SIZE = 30000;
    private static final int DEFAULT_IMPRESSIONS_REFRESH_RATE_SECS = 1800;
    private static final int DEFAULT_IMP_COUNTERS_REFRESH_RATE_SECS = 1800;
    private static final int DEFAULT_MTK_PER_PUSH = 30000;
    private static final int DEFAULT_READY = -1;
    private static final int DEFAULT_READ_TIMEOUT_SECS = 10000;
    private static final int DEFAULT_SEGMENTS_REFRESH_RATE_SECS = 1800;
    private static final int MAXIMUM_KEY_LENGTH = 250;
    private static final int MIN_CONNECTION_TIMEOUT = 0;
    private static final int MIN_FEATURES_REFRESH_RATE = 30;
    private static final int MIN_IMPRESSIONS_CHUNK_SIZE = 0;
    private static final int MIN_IMPRESSIONS_QUEUE_SIZE = 0;
    private static final int MIN_IMPRESSIONS_REFRESH_RATE = 30;
    private static final int MIN_MY_SEGMENTS_REFRESH_RATE = 30;
    private static final int MIN_READ_TIMEOUT = 0;
    private static final String TRACK_EVENT_NAME_PATTERN = "^[a-zA-Z0-9][-_.:a-zA-Z0-9]{0,79}$";
    public static String splitSdkVersion;
    private final String mAuthServiceUrl;
    private final long mBackgroundSyncPeriod;
    private final boolean mBackgroundSyncWhenBatteryNotLow;
    private final boolean mBackgroundSyncWhenWifiOnly;
    private final CertificatePinningConfiguration mCertificatePinningConfiguration;
    private final int mConnectionTimeout;
    private final long mDefaultSSEConnectionDelayInSecs;
    private final DevelopmentSslConfig mDevelopmentSslConfig;
    private boolean mEncryptionEnabled;
    private final String mEndpoint;
    private final long mEventFlushInterval;
    private final String mEventsEndpoint;
    private final int mEventsPerPush;
    private final int mEventsQueueSize;
    private final int mFeaturesRefreshRate;
    private final String mHostname;
    private final int mImpCountersRefreshRate;
    private final ImpressionListener mImpressionListener;
    private final long mImpressionsChunkSize;
    private final long mImpressionsDedupeTimeInterval;
    private final ImpressionsMode mImpressionsMode;
    private final int mImpressionsPerPush;
    private final int mImpressionsQueueSize;
    private final int mImpressionsRefreshRate;
    private final String mIp;
    private final boolean mIsPersistentAttributesEnabled;
    private final boolean mLabelsEnabled;
    private final boolean mLlegacyStorageMigrationEnabled;
    private int mLogLevel;
    private final int mMtkPerPush;
    private final int mMtkRefreshRate;
    private final long mObserverCacheExpirationPeriod;
    private final int mOfflineRefreshRate;
    private final String mPrefix;
    private final HttpProxy mProxy;
    private final SplitAuthenticator mProxyAuthenticator;
    private final int mReadTimeout;
    private final int mReady;
    private final RolloutCacheConfiguration mRolloutCacheConfiguration;
    private final int mSSEDisconnectionDelayInSecs;
    private final int mSegmentsRefreshRate;
    private boolean mShouldRecordTelemetry;
    private final boolean mStreamingEnabled;
    private final String mStreamingServiceUrl;
    private final SyncConfig mSyncConfig;
    private boolean mSyncEnabled;
    private final boolean mSynchronizeInBackground;
    private final String mTelemetryEndpoint;
    private final long mTelemetryRefreshRate;
    private final String mTrafficType;
    private UserConsent mUserConsent;
    private static final long MIN_IMPRESSIONS_DEDUPE_TIME_INTERVAL = TimeUnit.HOURS.toMillis(1);
    private static final long MAX_IMPRESSIONS_DEDUPE_TIME_INTERVAL = TimeUnit.HOURS.toMillis(24);
    private static final long OBSERVER_CACHE_EXPIRATION_PERIOD = ServiceConstants.DEFAULT_OBSERVER_CACHE_EXPIRATION_PERIOD_MS;

    int maximumKeyLength() {
        return 250;
    }

    public static Builder builder() {
        return new Builder();
    }

    private SplitClientConfig(String endpoint, String eventsEndpoint, int featureRefreshRate, int segmentsRefreshRate, int impressionsRefreshRate, int impressionsQueueSize, long impressionsChunkSize, int impressionsPerPush, int connectionTimeout, int readTimeout, int ready, boolean labelsEnabled, ImpressionListener impressionListener, String hostname, String ip, HttpProxy proxy, SplitAuthenticator proxyAuthenticator, int eventsQueueSize, int eventsPerPush, long eventFlushInterval, String trafficType, boolean synchronizeInBackground, long backgroundSyncPeriod, boolean backgroundSyncWhenBatteryNotLow, boolean backgroundSyncWhenWifiOnly, boolean streamingEnabled, String authServiceUrl, String streamingServiceUrl, DevelopmentSslConfig developmentSslConfig, SyncConfig syncConfig, boolean legacyStorageMigrationEnabled, ImpressionsMode impressionsMode, int impCountersRefreshRate, boolean isPersistentAttributesEnabled, int offlineRefreshRate, String telemetryEndpoint, long telemetryRefreshRate, boolean shouldRecordTelemetry, boolean syncEnabled, int logLevel, int mtkPerPush, int mtkRefreshRate, UserConsent userConsent, boolean encryptionEnabled, long defaultSSEConnectionDelayInSecs, int sseDisconnectionDelayInSecs, String prefix, long observerCacheExpirationPeriod, CertificatePinningConfiguration certificatePinningConfiguration, long impressionsDedupeTimeInterval, RolloutCacheConfiguration rolloutCacheConfiguration) {
        this.mEndpoint = endpoint;
        this.mEventsEndpoint = eventsEndpoint;
        this.mTelemetryEndpoint = telemetryEndpoint;
        this.mFeaturesRefreshRate = featureRefreshRate;
        this.mSegmentsRefreshRate = segmentsRefreshRate;
        this.mImpressionsRefreshRate = impressionsRefreshRate;
        this.mImpressionsQueueSize = impressionsQueueSize;
        this.mImpressionsPerPush = impressionsPerPush;
        this.mImpCountersRefreshRate = impCountersRefreshRate;
        this.mMtkRefreshRate = mtkRefreshRate;
        this.mConnectionTimeout = connectionTimeout;
        this.mReadTimeout = readTimeout;
        this.mReady = ready;
        this.mLabelsEnabled = labelsEnabled;
        this.mImpressionListener = impressionListener;
        this.mImpressionsChunkSize = impressionsChunkSize;
        this.mHostname = hostname;
        this.mIp = ip;
        this.mProxy = proxy;
        this.mProxyAuthenticator = proxyAuthenticator;
        this.mEventsQueueSize = eventsQueueSize;
        this.mEventsPerPush = eventsPerPush;
        this.mEventFlushInterval = eventFlushInterval;
        this.mTrafficType = trafficType;
        this.mSynchronizeInBackground = synchronizeInBackground;
        this.mBackgroundSyncPeriod = backgroundSyncPeriod;
        this.mBackgroundSyncWhenBatteryNotLow = backgroundSyncWhenBatteryNotLow;
        this.mBackgroundSyncWhenWifiOnly = backgroundSyncWhenWifiOnly;
        this.mStreamingEnabled = streamingEnabled;
        this.mAuthServiceUrl = authServiceUrl;
        this.mStreamingServiceUrl = streamingServiceUrl;
        this.mDevelopmentSslConfig = developmentSslConfig;
        this.mSyncConfig = syncConfig;
        this.mLlegacyStorageMigrationEnabled = legacyStorageMigrationEnabled;
        this.mImpressionsMode = impressionsMode;
        this.mIsPersistentAttributesEnabled = isPersistentAttributesEnabled;
        this.mOfflineRefreshRate = offlineRefreshRate;
        this.mTelemetryRefreshRate = telemetryRefreshRate;
        this.mSyncEnabled = syncEnabled;
        this.mLogLevel = logLevel;
        this.mUserConsent = userConsent;
        splitSdkVersion = "Android-5.3.1";
        this.mShouldRecordTelemetry = shouldRecordTelemetry;
        this.mMtkPerPush = mtkPerPush;
        this.mEncryptionEnabled = encryptionEnabled;
        this.mDefaultSSEConnectionDelayInSecs = defaultSSEConnectionDelayInSecs;
        this.mSSEDisconnectionDelayInSecs = sseDisconnectionDelayInSecs;
        this.mPrefix = prefix;
        this.mObserverCacheExpirationPeriod = observerCacheExpirationPeriod;
        this.mCertificatePinningConfiguration = certificatePinningConfiguration;
        this.mImpressionsDedupeTimeInterval = impressionsDedupeTimeInterval;
        this.mRolloutCacheConfiguration = rolloutCacheConfiguration;
    }

    public String trafficType() {
        return this.mTrafficType;
    }

    @Deprecated
    public long cacheExpirationInSeconds() {
        return TimeUnit.DAYS.toSeconds(rolloutCacheConfiguration().getExpirationDays());
    }

    public long eventFlushInterval() {
        return this.mEventFlushInterval;
    }

    public int eventsQueueSize() {
        return this.mEventsQueueSize;
    }

    public int eventsPerPush() {
        return this.mEventsPerPush;
    }

    public String endpoint() {
        return this.mEndpoint;
    }

    public String eventsEndpoint() {
        return this.mEventsEndpoint;
    }

    public String telemetryEndpoint() {
        return this.mTelemetryEndpoint;
    }

    public int featuresRefreshRate() {
        return this.mFeaturesRefreshRate;
    }

    public int segmentsRefreshRate() {
        return this.mSegmentsRefreshRate;
    }

    public int impressionsRefreshRate() {
        return this.mImpressionsRefreshRate;
    }

    public int impressionsQueueSize() {
        return this.mImpressionsQueueSize;
    }

    public long impressionsChunkSize() {
        return this.mImpressionsChunkSize;
    }

    public int impressionsPerPush() {
        return this.mImpressionsPerPush;
    }

    public int connectionTimeout() {
        return this.mConnectionTimeout;
    }

    public int readTimeout() {
        return this.mReadTimeout;
    }

    public boolean labelsEnabled() {
        return this.mLabelsEnabled;
    }

    public int blockUntilReady() {
        return this.mReady;
    }

    public ImpressionListener impressionListener() {
        return this.mImpressionListener;
    }

    public HttpProxy proxy() {
        return this.mProxy;
    }

    @Deprecated
    public SplitAuthenticator proxyAuthenticator() {
        return this.mProxyAuthenticator;
    }

    public String hostname() {
        return this.mHostname;
    }

    public int logLevel() {
        return this.mLogLevel;
    }

    String trackEventNamePattern() {
        return TRACK_EVENT_NAME_PATTERN;
    }

    String defaultDataFolder() {
        return DEFAULT_DATA_FOLDER;
    }

    String prefix() {
        return this.mPrefix;
    }

    public String ip() {
        return this.mIp;
    }

    public boolean synchronizeInBackground() {
        return this.mSynchronizeInBackground;
    }

    public long backgroundSyncPeriod() {
        return this.mBackgroundSyncPeriod;
    }

    public boolean backgroundSyncWhenBatteryNotLow() {
        return this.mBackgroundSyncWhenBatteryNotLow;
    }

    public boolean backgroundSyncWhenBatteryWifiOnly() {
        return this.mBackgroundSyncWhenWifiOnly;
    }

    public boolean streamingEnabled() {
        return this.mStreamingEnabled;
    }

    public String authServiceUrl() {
        return this.mAuthServiceUrl;
    }

    public String streamingServiceUrl() {
        return this.mStreamingServiceUrl;
    }

    public SplitAuthenticator authenticator() {
        return this.mProxyAuthenticator;
    }

    public DevelopmentSslConfig developmentSslConfig() {
        return this.mDevelopmentSslConfig;
    }

    public SyncConfig syncConfig() {
        return this.mSyncConfig;
    }

    public boolean isStorageMigrationEnabled() {
        return this.mLlegacyStorageMigrationEnabled;
    }

    public ImpressionsMode impressionsMode() {
        return this.mImpressionsMode;
    }

    public int impressionsCounterRefreshRate() {
        return this.mImpCountersRefreshRate;
    }

    public boolean persistentAttributesEnabled() {
        return this.mIsPersistentAttributesEnabled;
    }

    public int offlineRefreshRate() {
        return this.mOfflineRefreshRate;
    }

    public boolean shouldRecordTelemetry() {
        return this.mShouldRecordTelemetry;
    }

    public long telemetryRefreshRate() {
        return this.mTelemetryRefreshRate;
    }

    public boolean syncEnabled() {
        return this.mSyncEnabled;
    }

    public int mtkPerPush() {
        return this.mMtkPerPush;
    }

    public int mtkRefreshRate() {
        return this.mMtkRefreshRate;
    }

    public UserConsent userConsent() {
        return this.mUserConsent;
    }

    protected void setUserConsent(UserConsent status) {
        this.mUserConsent = status;
    }

    public boolean encryptionEnabled() {
        return this.mEncryptionEnabled;
    }

    public long defaultSSEConnectionDelay() {
        return this.mDefaultSSEConnectionDelayInSecs;
    }

    public int sseDisconnectionDelay() {
        return this.mSSEDisconnectionDelayInSecs;
    }

    private void enableTelemetry() {
        this.mShouldRecordTelemetry = true;
    }

    public long observerCacheExpirationPeriod() {
        return Math.max(this.mImpressionsDedupeTimeInterval, this.mObserverCacheExpirationPeriod);
    }

    public CertificatePinningConfiguration certificatePinningConfiguration() {
        return this.mCertificatePinningConfiguration;
    }

    public long impressionsDedupeTimeInterval() {
        return this.mImpressionsDedupeTimeInterval;
    }

    public RolloutCacheConfiguration rolloutCacheConfiguration() {
        return this.mRolloutCacheConfiguration;
    }

    public static final class Builder {
        static final int DEFAULT_TELEMETRY_REFRESH_RATE = 3600;
        static final int OFFLINE_REFRESH_RATE_DEFAULT = -1;
        static final int PROXY_PORT_DEFAULT = 80;
        private DevelopmentSslConfig mDevelopmentSslConfig;
        private ImpressionListener mImpressionListener;
        private ServiceEndpoints mServiceEndpoints;
        private int mFeaturesRefreshRate = 3600;
        private int mSegmentsRefreshRate = 1800;
        private int mImpressionsRefreshRate = 1800;
        private int mImpressionsQueueSize = 30000;
        private int mImpressionsPerPush = 2000;
        private int mImpCountersRefreshRate = 1800;
        private int mConnectionTimeout = 10000;
        private int mReadTimeout = 10000;
        private int mReady = -1;
        private boolean mLabelsEnabled = true;
        private long mImpressionsChunkSize = 2048;
        private boolean mIsPersistentAttributesEnabled = false;
        private int mEventsQueueSize = 10000;
        private long mEventFlushInterval = 1800;
        private int mEventsPerPush = 2000;
        private String mTrafficType = null;
        private String mHostname = "unknown";
        private String mIp = "unknown";
        private String mProxyHost = null;
        private SplitAuthenticator mProxyAuthenticator = null;
        private boolean mSynchronizeInBackground = false;
        private long mBackgroundSyncPeriod = 15;
        private boolean mBackgroundSyncWhenBatteryNotLow = true;
        private boolean mBackgroundSyncWhenWifiOnly = false;
        private boolean mStreamingEnabled = true;
        private SyncConfig mSyncConfig = SyncConfig.builder().build();
        private boolean mLegacyStorageMigrationEnabled = false;
        private ImpressionsMode mImpressionsMode = ImpressionsMode.OPTIMIZED;
        private int mOfflineRefreshRate = -1;
        private long mTelemetryRefreshRate = 3600;
        private boolean mSyncEnabled = true;
        private int mLogLevel = -100;
        private final int mMtkPerPush = 30000;
        private final int mMtkRefreshRate = 900;
        private UserConsent mUserConsent = UserConsent.GRANTED;
        private boolean mEncryptionEnabled = false;
        private final long mDefaultSSEConnectionDelayInSecs = 60;
        private final int mSSEDisconnectionDelayInSecs = 60;
        private final long mObserverCacheExpirationPeriod = SplitClientConfig.OBSERVER_CACHE_EXPIRATION_PERIOD;
        private String mPrefix = null;
        private CertificatePinningConfiguration mCertificatePinningConfiguration = null;
        private long mImpressionsDedupeTimeInterval = 3600000;
        private RolloutCacheConfiguration mRolloutCacheConfiguration = RolloutCacheConfiguration.builder().build();

        public Builder() {
            this.mServiceEndpoints = null;
            this.mServiceEndpoints = ServiceEndpoints.builder().build();
        }

        public Builder trafficType(String trafficType) {
            this.mTrafficType = trafficType;
            return this;
        }

        public Builder eventsQueueSize(int eventsQueueSize) {
            this.mEventsQueueSize = eventsQueueSize;
            return this;
        }

        public Builder eventsPerPush(int eventsPerPush) {
            this.mEventsPerPush = eventsPerPush;
            return this;
        }

        public Builder eventFlushInterval(long eventFlushInterval) {
            this.mEventFlushInterval = eventFlushInterval;
            return this;
        }

        public Builder featuresRefreshRate(int seconds) {
            this.mFeaturesRefreshRate = seconds;
            return this;
        }

        public Builder segmentsRefreshRate(int seconds) {
            this.mSegmentsRefreshRate = seconds;
            return this;
        }

        public Builder impressionsRefreshRate(int seconds) {
            this.mImpressionsRefreshRate = seconds;
            return this;
        }

        public Builder impressionsQueueSize(int impressionsQueueSize) {
            this.mImpressionsQueueSize = impressionsQueueSize;
            return this;
        }

        public Builder impressionsPerPush(int impressionsPerPush) {
            this.mImpressionsPerPush = impressionsPerPush;
            return this;
        }

        public Builder impressionListener(ImpressionListener impressionListener) {
            this.mImpressionListener = impressionListener;
            return this;
        }

        public Builder connectionTimeout(int ms) {
            this.mConnectionTimeout = ms;
            return this;
        }

        public Builder readTimeout(int ms) {
            this.mReadTimeout = ms;
            return this;
        }

        public Builder logLevel(int level) {
            this.mLogLevel = level;
            Logger.instance().setLevel(this.mLogLevel);
            return this;
        }

        public Builder disableLabels() {
            this.mLabelsEnabled = false;
            return this;
        }

        public Builder ready(int milliseconds) {
            this.mReady = milliseconds;
            return this;
        }

        public Builder proxyHost(String proxyHost) {
            if (proxyHost != null && proxyHost.endsWith("/")) {
                this.mProxyHost = proxyHost.substring(0, proxyHost.length() - 1);
                return this;
            }
            this.mProxyHost = proxyHost;
            return this;
        }

        public Builder proxyAuthenticator(SplitAuthenticator proxyAuthenticator) {
            this.mProxyAuthenticator = proxyAuthenticator;
            return this;
        }

        public Builder impressionsChunkSize(long size) {
            this.mImpressionsChunkSize = size;
            return this;
        }

        public Builder hostname(String hostname) {
            this.mHostname = hostname;
            return this;
        }

        public Builder ip(String ip) {
            this.mIp = ip;
            return this;
        }

        public Builder synchronizeInBackground(boolean synchronizeInBackground) {
            this.mSynchronizeInBackground = synchronizeInBackground;
            return this;
        }

        public Builder synchronizeInBackgroundPeriod(long backgroundSyncPeriod) {
            this.mBackgroundSyncPeriod = backgroundSyncPeriod;
            return this;
        }

        public Builder backgroundSyncWhenBatteryNotLow(boolean backgroundSyncWhenBatteryNotLow) {
            this.mBackgroundSyncWhenBatteryNotLow = backgroundSyncWhenBatteryNotLow;
            return this;
        }

        public Builder backgroundSyncWhenWifiOnly(boolean backgroundSyncWhenWifiOnly) {
            this.mBackgroundSyncWhenWifiOnly = backgroundSyncWhenWifiOnly;
            return this;
        }

        public Builder streamingEnabled(boolean streamingEnabled) {
            this.mStreamingEnabled = streamingEnabled;
            return this;
        }

        public Builder serviceEndpoints(ServiceEndpoints serviceEndpoints) {
            this.mServiceEndpoints = serviceEndpoints;
            return this;
        }

        public Builder developmentSslConfig(SSLSocketFactory sslSocketFactory, X509TrustManager trustManager, HostnameVerifier hostnameVerifier) {
            this.mDevelopmentSslConfig = new DevelopmentSslConfig((SSLSocketFactory) Utils.checkNotNull(sslSocketFactory), (X509TrustManager) Utils.checkNotNull(trustManager), (HostnameVerifier) Utils.checkNotNull(hostnameVerifier));
            return this;
        }

        public Builder syncConfig(SyncConfig syncConfig) {
            this.mSyncConfig = syncConfig;
            return this;
        }

        public Builder legacyStorageMigrationEnabled(boolean legacyStorageMigrationEnabled) {
            this.mLegacyStorageMigrationEnabled = legacyStorageMigrationEnabled;
            return this;
        }

        public Builder impressionsMode(ImpressionsMode mode) {
            this.mImpressionsMode = mode;
            return this;
        }

        public Builder impressionsMode(String mode) {
            this.mImpressionsMode = ImpressionsMode.fromString(mode);
            return this;
        }

        public Builder persistentAttributesEnabled(boolean enabled) {
            this.mIsPersistentAttributesEnabled = enabled;
            return this;
        }

        public Builder offlineRefreshRate(int offlineRefreshRate) {
            this.mOfflineRefreshRate = offlineRefreshRate;
            return this;
        }

        public Builder telemetryRefreshRate(long telemetryRefreshRate) {
            this.mTelemetryRefreshRate = telemetryRefreshRate;
            return this;
        }

        public Builder syncEnabled(boolean syncEnabled) {
            this.mSyncEnabled = syncEnabled;
            return this;
        }

        public Builder userConsent(UserConsent value) {
            this.mUserConsent = value;
            Logger.v("User consent has been set to " + value.toString());
            return this;
        }

        public Builder encryptionEnabled(boolean enabled) {
            this.mEncryptionEnabled = enabled;
            return this;
        }

        public Builder prefix(String prefix) {
            if (prefix == null) {
                prefix = "";
            }
            this.mPrefix = prefix;
            return this;
        }

        public Builder certificatePinningConfiguration(CertificatePinningConfiguration certificatePinningConfiguration) {
            this.mCertificatePinningConfiguration = certificatePinningConfiguration;
            return this;
        }

        @Deprecated
        public Builder impressionsDedupeTimeInterval(long impressionsDedupeTimeInterval) {
            this.mImpressionsDedupeTimeInterval = impressionsDedupeTimeInterval;
            return this;
        }

        public Builder rolloutCacheConfiguration(RolloutCacheConfiguration rolloutCacheConfiguration) {
            if (rolloutCacheConfiguration == null) {
                Logger.w("Rollout cache configuration is null. Setting to default value.");
                this.mRolloutCacheConfiguration = RolloutCacheConfiguration.builder().build();
                return this;
            }
            this.mRolloutCacheConfiguration = rolloutCacheConfiguration;
            return this;
        }

        public SplitClientConfig build() {
            ValidationErrorInfo validationErrorInfoValidate;
            Logger.instance().setLevel(this.mLogLevel);
            if (this.mFeaturesRefreshRate < 30) {
                Logger.w("Features refresh rate is lower than allowed. Setting to default value.");
                this.mFeaturesRefreshRate = 3600;
            }
            if (this.mSegmentsRefreshRate < 30) {
                Logger.w("Segments refresh rate is lower than allowed. Setting to default value.");
                this.mSegmentsRefreshRate = 1800;
            }
            if (this.mImpressionsRefreshRate < 30) {
                Logger.w("Impressions refresh rate is lower than allowed. Setting to default value.");
                this.mImpressionsRefreshRate = 1800;
            }
            if (this.mImpressionsQueueSize <= 0) {
                Logger.w("Impressions queue size is lower than allowed. Setting to default value.");
                this.mImpressionsQueueSize = 30000;
            }
            if (this.mImpressionsChunkSize <= 0) {
                Logger.w("Impressions chunk size is lower than allowed. Setting to default value.");
                this.mImpressionsChunkSize = 2048L;
            }
            if (this.mConnectionTimeout <= 0) {
                Logger.w("Connection timeout is lower than allowed. Setting to default value.");
                this.mConnectionTimeout = 10000;
            }
            if (this.mReadTimeout <= 0) {
                Logger.w("Read timeout is lower than allowed. Setting to default value.");
                this.mReadTimeout = 10000;
            }
            if (this.mBackgroundSyncPeriod < 15) {
                Logger.w("Background sync period is lower than allowed. Setting to default value.");
                this.mBackgroundSyncPeriod = 15L;
            }
            if (this.mTelemetryRefreshRate < 60) {
                Logger.w("Telemetry refresh rate is lower than allowed. Setting to default value.");
                this.mTelemetryRefreshRate = 3600L;
            }
            if (this.mPrefix != null && (validationErrorInfoValidate = new PrefixValidatorImpl().validate(this.mPrefix)) != null) {
                Logger.e(validationErrorInfoValidate.getErrorMessage());
                Logger.w("Setting prefix to empty string");
                this.mPrefix = "";
            }
            CertificatePinningConfiguration certificatePinningConfiguration = this.mCertificatePinningConfiguration;
            if (certificatePinningConfiguration != null && (certificatePinningConfiguration.getPins() == null || this.mCertificatePinningConfiguration.getPins().isEmpty())) {
                Logger.w("Certificate pinning configuration is empty. Disabling certificate pinning.");
                this.mCertificatePinningConfiguration = null;
            }
            if (this.mImpressionsDedupeTimeInterval < SplitClientConfig.MIN_IMPRESSIONS_DEDUPE_TIME_INTERVAL || this.mImpressionsDedupeTimeInterval > SplitClientConfig.MAX_IMPRESSIONS_DEDUPE_TIME_INTERVAL) {
                Logger.w("Time interval for impressions dedupe is out of bounds. Setting to default value.");
                this.mImpressionsDedupeTimeInterval = 3600000L;
            }
            return new SplitClientConfig(this.mServiceEndpoints.getSdkEndpoint(), this.mServiceEndpoints.getEventsEndpoint(), this.mFeaturesRefreshRate, this.mSegmentsRefreshRate, this.mImpressionsRefreshRate, this.mImpressionsQueueSize, this.mImpressionsChunkSize, this.mImpressionsPerPush, this.mConnectionTimeout, this.mReadTimeout, this.mReady, this.mLabelsEnabled, this.mImpressionListener, this.mHostname, this.mIp, parseProxyHost(this.mProxyHost), this.mProxyAuthenticator, this.mEventsQueueSize, this.mEventsPerPush, this.mEventFlushInterval, this.mTrafficType, this.mSynchronizeInBackground, this.mBackgroundSyncPeriod, this.mBackgroundSyncWhenBatteryNotLow, this.mBackgroundSyncWhenWifiOnly, this.mStreamingEnabled, this.mServiceEndpoints.getAuthServiceEndpoint(), this.mServiceEndpoints.getStreamingServiceEndpoint(), this.mDevelopmentSslConfig, this.mSyncConfig, this.mLegacyStorageMigrationEnabled, this.mImpressionsMode, this.mImpCountersRefreshRate, this.mIsPersistentAttributesEnabled, this.mOfflineRefreshRate, this.mServiceEndpoints.getTelemetryEndpoint(), this.mTelemetryRefreshRate, new TelemetryHelperImpl().shouldRecordTelemetry(), this.mSyncEnabled, this.mLogLevel, 30000, 900, this.mUserConsent, this.mEncryptionEnabled, 60L, 60, this.mPrefix, this.mObserverCacheExpirationPeriod, this.mCertificatePinningConfiguration, this.mImpressionsDedupeTimeInterval, this.mRolloutCacheConfiguration);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0033  */
        private HttpProxy parseProxyHost(String proxyUri) {
            String str;
            String str2 = null;
            if (Utils.isNullOrEmpty(proxyUri)) {
                return null;
            }
            try {
                URI uriCreate = URI.create(proxyUri);
                int port = uriCreate.getPort() != -1 ? uriCreate.getPort() : 80;
                String userInfo = uriCreate.getUserInfo();
                if (Utils.isNullOrEmpty(userInfo)) {
                    str = null;
                } else {
                    String[] strArrSplit = userInfo.split(":");
                    if (strArrSplit.length > 1) {
                        str2 = strArrSplit[0];
                        str = strArrSplit[1];
                    } else {
                        str = null;
                    }
                }
                return new HttpProxy(String.format("%s%s", uriCreate.getHost(), uriCreate.getPath()), port, str2, str);
            } catch (IllegalArgumentException e) {
                Logger.e("Proxy URI not valid: " + e.getLocalizedMessage());
                throw new IllegalArgumentException();
            } catch (Exception e2) {
                Logger.e("Unknown error while parsing proxy URI: " + e2.getLocalizedMessage());
                throw new IllegalArgumentException();
            }
        }
    }
}
