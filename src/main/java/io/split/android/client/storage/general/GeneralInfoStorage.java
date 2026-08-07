package io.split.android.client.storage.general;

/* JADX INFO: loaded from: classes4.dex */
public interface GeneralInfoStorage {
    String getDatabaseEncryptionMode();

    long getFlagsChangeNumber();

    String getFlagsSpec();

    long getLastProxyUpdateTimestamp();

    long getRbsChangeNumber();

    long getRolloutCacheLastClearTimestamp();

    String getSplitsFilterQueryString();

    long getSplitsUpdateTimestamp();

    void setDatabaseEncryptionMode(String value);

    void setFlagsChangeNumber(long changeNumber);

    void setFlagsSpec(String value);

    void setLastProxyUpdateTimestamp(long timestamp);

    void setRbsChangeNumber(long changeNumber);

    void setRolloutCacheLastClearTimestamp(long timestamp);

    void setSplitsFilterQueryString(String queryString);

    void setSplitsUpdateTimestamp(long timestamp);
}
