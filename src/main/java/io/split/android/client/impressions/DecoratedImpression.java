package io.split.android.client.impressions;

/* JADX INFO: loaded from: classes4.dex */
public class DecoratedImpression {
    private final boolean mDisabled;
    private final Impression mImpression;

    public DecoratedImpression(Impression impression, boolean disabled) {
        this.mImpression = impression;
        this.mDisabled = disabled;
    }

    public Impression getImpression() {
        return this.mImpression;
    }

    public boolean isImpressionsDisabled() {
        return this.mDisabled;
    }
}
