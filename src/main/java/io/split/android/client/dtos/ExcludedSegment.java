package io.split.android.client.dtos;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class ExcludedSegment {
    private static final String TYPE_LARGE = "large";
    private static final String TYPE_RULE_BASED = "rule-based";
    private static final String TYPE_STANDARD = "standard";

    @SerializedName("name")
    private String mName;

    @SerializedName("type")
    private String mType;

    public ExcludedSegment() {
    }

    private ExcludedSegment(String name, String type) {
        this.mName = name;
        this.mType = type;
    }

    public static ExcludedSegment standard(String name) {
        return new ExcludedSegment(name, "standard");
    }

    public static ExcludedSegment large(String name) {
        return new ExcludedSegment(name, "large");
    }

    public static ExcludedSegment ruleBased(String name) {
        return new ExcludedSegment(name, TYPE_RULE_BASED);
    }

    public String getName() {
        return this.mName;
    }

    public boolean isStandard() {
        return "standard".equals(this.mType);
    }

    public boolean isLarge() {
        return "large".equals(this.mType);
    }

    public boolean isRuleBased() {
        return TYPE_RULE_BASED.equals(this.mType);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExcludedSegment)) {
            return false;
        }
        ExcludedSegment excludedSegment = (ExcludedSegment) obj;
        return this.mName.equals(excludedSegment.mName) && this.mType.equals(excludedSegment.mType);
    }

    public int hashCode() {
        return ((527 + this.mName.hashCode()) * 31) + this.mType.hashCode();
    }
}
