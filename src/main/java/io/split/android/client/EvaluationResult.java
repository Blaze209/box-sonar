package io.split.android.client;

/* JADX INFO: loaded from: classes4.dex */
public final class EvaluationResult {
    private final Long mChangeNumber;
    private final String mConfigurations;
    private final boolean mImpressionsDisabled;
    private final String mLabel;
    private final String mTreatment;

    public EvaluationResult(String treatment, String label) {
        this(treatment, label, null, null, false);
    }

    public EvaluationResult(String treatment, String label, boolean impressionsDisabled) {
        this(treatment, label, null, null, impressionsDisabled);
    }

    EvaluationResult(String treatment, String label, Long changeNumber, boolean impressionsDisabled) {
        this(treatment, label, changeNumber, null, impressionsDisabled);
    }

    public EvaluationResult(String treatment, String label, Long changeNumber, String configurations, boolean impressionsDisabled) {
        this.mTreatment = treatment;
        this.mLabel = label;
        this.mChangeNumber = changeNumber;
        this.mConfigurations = configurations;
        this.mImpressionsDisabled = impressionsDisabled;
    }

    public String getTreatment() {
        return this.mTreatment;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public Long getChangeNumber() {
        return this.mChangeNumber;
    }

    public String getConfigurations() {
        return this.mConfigurations;
    }

    public boolean isImpressionsDisabled() {
        return this.mImpressionsDisabled;
    }
}
