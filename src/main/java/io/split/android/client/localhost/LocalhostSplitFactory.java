package io.split.android.client.localhost;

import android.content.Context;
import io.split.android.client.FilterBuilder;
import io.split.android.client.FlagSetsFilterImpl;
import io.split.android.client.SplitClient;
import io.split.android.client.SplitClientConfig;
import io.split.android.client.SplitFactory;
import io.split.android.client.SplitFilter;
import io.split.android.client.SplitManager;
import io.split.android.client.SplitManagerImpl;
import io.split.android.client.SyncConfig;
import io.split.android.client.api.Key;
import io.split.android.client.attributes.AttributesManagerFactoryImpl;
import io.split.android.client.attributes.AttributesMergerImpl;
import io.split.android.client.events.EventsManagerCoordinator;
import io.split.android.client.localhost.shared.LocalhostSplitClientContainerImpl;
import io.split.android.client.service.executor.SplitTaskExecutorImpl;
import io.split.android.client.shared.SplitClientContainer;
import io.split.android.client.shared.UserConsent;
import io.split.android.client.storage.legacy.FileStorage;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.telemetry.storage.NoOpTelemetryStorage;
import io.split.android.client.utils.logger.Logger;
import io.split.android.client.validators.AttributesValidatorImpl;
import io.split.android.client.validators.SplitValidatorImpl;
import io.split.android.client.validators.ValidationMessageLoggerImpl;
import io.split.android.engine.experiments.ParserCommons;
import io.split.android.engine.experiments.SplitParser;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class LocalhostSplitFactory implements SplitFactory {
    private final SplitClientContainer mClientContainer;
    private final String mDefaultKey;
    private String mLocalhostFileName;
    private final SplitManager mManager;
    private final LocalhostSynchronizer mSynchronizer;

    @Override // io.split.android.client.SplitFactory
    public void setUserConsent(boolean enabled) {
    }

    public LocalhostSplitFactory(String key, Context context, SplitClientConfig config) {
        this(key, context, config, null);
    }

    public LocalhostSplitFactory(String key, Context context, SplitClientConfig config, String localhostFileName) {
        SplitFilter splitFilter;
        FlagSetsFilterImpl flagSetsFilterImpl = null;
        this.mLocalhostFileName = null;
        if (localhostFileName != null) {
            this.mLocalhostFileName = localhostFileName;
        }
        this.mDefaultKey = key;
        EventsManagerCoordinator eventsManagerCoordinator = new EventsManagerCoordinator();
        LocalhostSplitsStorage localhostSplitsStorage = new LocalhostSplitsStorage(this.mLocalhostFileName, context, new FileStorage(context.getCacheDir(), "localhost"), eventsManagerCoordinator);
        SplitParser splitParser = getSplitParser();
        SplitTaskExecutorImpl splitTaskExecutorImpl = new SplitTaskExecutorImpl();
        AttributesManagerFactoryImpl attributesManagerFactoryImpl = new AttributesManagerFactoryImpl(new AttributesValidatorImpl(), new ValidationMessageLoggerImpl());
        this.mManager = new SplitManagerImpl(localhostSplitsStorage, new SplitValidatorImpl(), splitParser);
        if (config.syncConfig() != null) {
            Map<SplitFilter.Type, SplitFilter> groupedFilter = new FilterBuilder(config.syncConfig().getFilters()).getGroupedFilter();
            if (!groupedFilter.isEmpty() && (splitFilter = groupedFilter.get(SplitFilter.Type.BY_SET)) != null) {
                flagSetsFilterImpl = new FlagSetsFilterImpl(splitFilter.getValues());
            }
        }
        this.mClientContainer = new LocalhostSplitClientContainerImpl(this, config, localhostSplitsStorage, splitParser, attributesManagerFactoryImpl, new AttributesMergerImpl(), new NoOpTelemetryStorage(), eventsManagerCoordinator, splitTaskExecutorImpl, flagSetsFilterImpl);
        LocalhostSynchronizer localhostSynchronizer = new LocalhostSynchronizer(splitTaskExecutorImpl, config, localhostSplitsStorage, buildQueryString(config.syncConfig()));
        this.mSynchronizer = localhostSynchronizer;
        localhostSynchronizer.start();
        Logger.i("Android SDK initialized!");
    }

    private static SplitParser getSplitParser() {
        ParserCommons parserCommons = new ParserCommons(new LocalhostMySegmentsStorageContainer(), new LocalhostMySegmentsStorageContainer());
        parserCommons.setRuleBasedSegmentStorage(new LocalhostRuleBasedSegmentsStorage());
        return new SplitParser(parserCommons);
    }

    LocalhostSplitFactory(SplitsStorage splitsStorage, SplitParser splitParser, String defaultKey, LocalhostSynchronizer synchronizer, SplitClientContainer clientContainer) {
        this.mLocalhostFileName = null;
        this.mSynchronizer = synchronizer;
        this.mClientContainer = clientContainer;
        this.mDefaultKey = defaultKey;
        this.mManager = new SplitManagerImpl(splitsStorage, new SplitValidatorImpl(), splitParser);
    }

    @Override // io.split.android.client.SplitFactory
    public SplitClient client() {
        return this.mClientContainer.getClient(new Key(this.mDefaultKey));
    }

    @Override // io.split.android.client.SplitFactory
    public SplitClient client(Key key) {
        return this.mClientContainer.getClient(key);
    }

    @Override // io.split.android.client.SplitFactory
    public SplitClient client(String matchingKey) {
        return this.mClientContainer.getClient(new Key(matchingKey));
    }

    @Override // io.split.android.client.SplitFactory
    public SplitClient client(String matchingKey, String bucketingKey) {
        return this.mClientContainer.getClient(new Key(matchingKey, bucketingKey));
    }

    @Override // io.split.android.client.SplitFactory
    public SplitManager manager() {
        return this.mManager;
    }

    @Override // io.split.android.client.SplitFactory
    public void destroy() {
        this.mSynchronizer.stop();
    }

    @Override // io.split.android.client.SplitFactory
    public void flush() {
        Iterator<SplitClient> it = this.mClientContainer.getAll().iterator();
        while (it.hasNext()) {
            it.next().flush();
        }
    }

    @Override // io.split.android.client.SplitFactory
    public UserConsent getUserConsent() {
        return UserConsent.GRANTED;
    }

    private static String buildQueryString(SyncConfig syncConfig) {
        if (syncConfig != null) {
            return new FilterBuilder(syncConfig.getFilters()).buildQueryString();
        }
        return "";
    }
}
