package io.split.android.client.storage.db;

/* JADX INFO: loaded from: classes4.dex */
public class GeneralInfoEntity {
    public static final String CHANGE_NUMBER_INFO = "splitChangesChangeNumber";
    public static final String DATABASE_ENCRYPTION_MODE = "databaseEncryptionMode";
    public static final String FLAGS_SPEC = "flagsSpec";
    public static final String FLAG_SETS_MAP = "flagSetsMap";
    public static final String SPLITS_FILTER_QUERY_STRING = "splitsFilterQueryString";
    public static final String SPLITS_UPDATE_TIMESTAMP = "splitsUpdateTimestamp";
    public static final String TRAFFIC_TYPES_MAP = "trafficTypesMap";
    private long longValue;
    private String name;
    private String stringValue;
    private long updatedAt;

    public GeneralInfoEntity() {
    }

    public GeneralInfoEntity(String name, String stringValue) {
        this.name = name;
        this.stringValue = stringValue;
    }

    public GeneralInfoEntity(String name, long longValue) {
        this.name = name;
        this.longValue = longValue;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStringValue() {
        return this.stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public long getLongValue() {
        return this.longValue;
    }

    public void setLongValue(long longValue) {
        this.longValue = longValue;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
