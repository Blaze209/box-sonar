package io.split.android.client.storage.cipher;

/* JADX INFO: loaded from: classes4.dex */
public enum SplitEncryptionLevel {
    AES_128_CBC("AES_128_CBC"),
    NONE("NONE");

    private final String mDescription;

    SplitEncryptionLevel(String description) {
        this.mDescription = description;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.mDescription;
    }

    public static SplitEncryptionLevel fromString(String stringValue) {
        for (SplitEncryptionLevel splitEncryptionLevel : values()) {
            if (splitEncryptionLevel.mDescription.equalsIgnoreCase(stringValue)) {
                return splitEncryptionLevel;
            }
        }
        throw new IllegalArgumentException("Invalid string value for SplitEncryptionLevel: " + stringValue);
    }
}
