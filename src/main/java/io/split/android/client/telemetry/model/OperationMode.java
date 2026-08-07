package io.split.android.client.telemetry.model;

/* JADX INFO: loaded from: classes4.dex */
public enum OperationMode {
    STANDALONE(0),
    CONSUMER(1);

    private final int numericValue;

    OperationMode(int numericValue) {
        this.numericValue = numericValue;
    }

    public int getNumericValue() {
        return this.numericValue;
    }
}
