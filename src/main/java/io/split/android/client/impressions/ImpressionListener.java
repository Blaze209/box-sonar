package io.split.android.client.impressions;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface ImpressionListener {

    public static final class NoopImpressionListener implements ImpressionListener, DecoratedImpressionListener {
        @Override // io.split.android.client.impressions.ImpressionListener
        public void close() {
        }

        @Override // io.split.android.client.impressions.DecoratedImpressionListener
        public void log(DecoratedImpression impression) {
        }

        @Override // io.split.android.client.impressions.ImpressionListener
        public void log(Impression impression) {
        }
    }

    void close();

    void log(Impression impression);

    public static final class FederatedImpressionListener implements ImpressionListener, DecoratedImpressionListener {
        private final List<ImpressionListener> _delegates;
        private final DecoratedImpressionListener mDecoratedImpressionListener;

        public FederatedImpressionListener(DecoratedImpressionListener decoratedImpressionListener, List<ImpressionListener> delegates) {
            this.mDecoratedImpressionListener = decoratedImpressionListener;
            this._delegates = delegates;
        }

        @Override // io.split.android.client.impressions.ImpressionListener
        public void log(Impression impression) {
            Iterator<ImpressionListener> it = this._delegates.iterator();
            while (it.hasNext()) {
                it.next().log(impression);
            }
        }

        @Override // io.split.android.client.impressions.DecoratedImpressionListener
        public void log(DecoratedImpression impression) {
            this.mDecoratedImpressionListener.log(impression);
        }

        @Override // io.split.android.client.impressions.ImpressionListener
        public void close() {
            Iterator<ImpressionListener> it = this._delegates.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
        }
    }
}
