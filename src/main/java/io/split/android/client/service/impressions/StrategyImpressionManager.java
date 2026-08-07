package io.split.android.client.service.impressions;

import androidx.core.util.Pair;
import io.split.android.client.impressions.DecoratedImpression;
import io.split.android.client.service.impressions.strategy.PeriodicTracker;
import io.split.android.client.service.impressions.strategy.ProcessStrategy;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class StrategyImpressionManager implements ImpressionManager, PeriodicTracker {
    private final AtomicBoolean isTrackingEnabled;
    private final ProcessStrategy mNoneStrategy;
    private final Set<PeriodicTracker> mPeriodicTrackers;
    private final ProcessStrategy mProcessStrategy;

    public StrategyImpressionManager(Pair<ProcessStrategy, PeriodicTracker> noneComponents, Pair<ProcessStrategy, PeriodicTracker> strategy) {
        this(noneComponents.first, noneComponents.second, strategy.first, strategy.second);
    }

    StrategyImpressionManager(ProcessStrategy noneStrategy, PeriodicTracker noneTracker, ProcessStrategy strategy, PeriodicTracker strategyTracker) {
        this.isTrackingEnabled = new AtomicBoolean(true);
        this.mProcessStrategy = (ProcessStrategy) Utils.checkNotNull(strategy);
        this.mNoneStrategy = (ProcessStrategy) Utils.checkNotNull(noneStrategy);
        HashSet hashSet = new HashSet();
        this.mPeriodicTrackers = hashSet;
        hashSet.add(noneTracker);
        hashSet.add(strategyTracker);
    }

    @Override // io.split.android.client.service.impressions.ImpressionManager
    public void pushImpression(DecoratedImpression impression) {
        if (!this.isTrackingEnabled.get()) {
            Logger.v("Impression not tracked because tracking is disabled");
        } else if (impression.isImpressionsDisabled()) {
            this.mNoneStrategy.apply(impression.getImpression());
        } else {
            this.mProcessStrategy.apply(impression.getImpression());
        }
    }

    @Override // io.split.android.client.service.impressions.ImpressionManager, io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void enableTracking(boolean enable) {
        this.isTrackingEnabled.set(enable);
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void flush() {
        Iterator<PeriodicTracker> it = this.mPeriodicTrackers.iterator();
        while (it.hasNext()) {
            it.next().flush();
        }
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void startPeriodicRecording() {
        Iterator<PeriodicTracker> it = this.mPeriodicTrackers.iterator();
        while (it.hasNext()) {
            it.next().startPeriodicRecording();
        }
    }

    @Override // io.split.android.client.service.impressions.strategy.PeriodicTracker
    public void stopPeriodicRecording() {
        Iterator<PeriodicTracker> it = this.mPeriodicTrackers.iterator();
        while (it.hasNext()) {
            it.next().stopPeriodicRecording();
        }
    }
}
