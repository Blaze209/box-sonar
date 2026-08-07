package io.split.android.client.dtos;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class Matcher {

    @SerializedName("betweenMatcherData")
    public BetweenMatcherData betweenMatcherData;

    @SerializedName("betweenStringMatcherData")
    public BetweenStringMatcherData betweenStringMatcherData;

    @SerializedName("booleanMatcherData")
    public Boolean booleanMatcherData;

    @SerializedName("dependencyMatcherData")
    public DependencyMatcherData dependencyMatcherData;

    @SerializedName("keySelector")
    public KeySelector keySelector;

    @SerializedName("matcherType")
    public MatcherType matcherType;

    @SerializedName("negate")
    public boolean negate;

    @SerializedName("stringMatcherData")
    public String stringMatcherData;

    @SerializedName("unaryNumericMatcherData")
    public UnaryNumericMatcherData unaryNumericMatcherData;

    @SerializedName("userDefinedLargeSegmentMatcherData")
    public UserDefinedLargeSegmentMatcherData userDefinedLargeSegmentMatcherData;

    @SerializedName("userDefinedSegmentMatcherData")
    public UserDefinedSegmentMatcherData userDefinedSegmentMatcherData;

    @SerializedName("whitelistMatcherData")
    public WhitelistMatcherData whitelistMatcherData;
}
