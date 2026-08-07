package io.split.android.client;

/* JADX INFO: loaded from: classes4.dex */
public class SplitResult {
    private String config;
    private String treatment;

    public SplitResult(String treatment, String config) {
        this.treatment = treatment;
        this.config = config;
    }

    public SplitResult(String treatment) {
        this(treatment, null);
    }

    public String treatment() {
        return this.treatment;
    }

    public String config() {
        return this.config;
    }
}
