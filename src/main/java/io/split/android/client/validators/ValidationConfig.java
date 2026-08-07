package io.split.android.client.validators;

/* JADX INFO: loaded from: classes4.dex */
public class ValidationConfig {
    private static final ValidationConfig mInstance = new ValidationConfig();
    private static final int maximumEventPropertyBytes = 32768;
    private int mMaximumKeyLength = 250;
    private String mTrackEventNamePattern = "^[a-zA-Z0-9][-_.:a-zA-Z0-9]{0,79}$";

    public int getMaximumEventPropertyBytes() {
        return 32768;
    }

    public static ValidationConfig getInstance() {
        return mInstance;
    }

    private ValidationConfig() {
    }

    public int getMaximumKeyLength() {
        return this.mMaximumKeyLength;
    }

    public void setMaximumKeyLength(int maximumKeyLength) {
        this.mMaximumKeyLength = maximumKeyLength;
    }

    public String getTrackEventNamePattern() {
        return this.mTrackEventNamePattern;
    }

    public void setTrackEventNamePattern(String trackEventNamePattern) {
        this.mTrackEventNamePattern = trackEventNamePattern;
    }
}
