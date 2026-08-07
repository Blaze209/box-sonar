package com.box.android.domain.configuration;

import android.content.SharedPreferences;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* JADX INFO: compiled from: IFeatureFlip.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\fHÆ\u0003JG\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006+"}, d2 = {"Lcom/box/android/domain/configuration/FeatureFlip;", "Lcom/box/android/domain/configuration/IFeatureFlip;", "owner", "", "name", "rule", "Lcom/box/android/domain/configuration/FeatureFlipRule;", "debugOverridePrefs", "Landroid/content/SharedPreferences;", "evaluator", "Lcom/box/android/domain/configuration/FeatureFlipEvaluator;", "flippablePreRelease", "Lcom/box/android/domain/configuration/FlippablePreRelease;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/configuration/FeatureFlipRule;Landroid/content/SharedPreferences;Lcom/box/android/domain/configuration/FeatureFlipEvaluator;Lcom/box/android/domain/configuration/FlippablePreRelease;)V", "getOwner", "()Ljava/lang/String;", "getName", "getRule", "()Lcom/box/android/domain/configuration/FeatureFlipRule;", "getDebugOverridePrefs", "()Landroid/content/SharedPreferences;", "getEvaluator", "()Lcom/box/android/domain/configuration/FeatureFlipEvaluator;", "getFlippablePreRelease", "()Lcom/box/android/domain/configuration/FlippablePreRelease;", "enabled", "", "getEnabled", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FeatureFlip implements IFeatureFlip {
    private final SharedPreferences debugOverridePrefs;
    private final FeatureFlipEvaluator evaluator;
    private final FlippablePreRelease flippablePreRelease;
    private final String name;
    private final String owner;
    private final FeatureFlipRule rule;

    public static /* synthetic */ FeatureFlip copy$default(FeatureFlip featureFlip, String str, String str2, FeatureFlipRule featureFlipRule, SharedPreferences sharedPreferences, FeatureFlipEvaluator featureFlipEvaluator, FlippablePreRelease flippablePreRelease, int i, Object obj) {
        if ((i & 1) != 0) {
            str = featureFlip.owner;
        }
        if ((i & 2) != 0) {
            str2 = featureFlip.name;
        }
        if ((i & 4) != 0) {
            featureFlipRule = featureFlip.rule;
        }
        if ((i & 8) != 0) {
            sharedPreferences = featureFlip.debugOverridePrefs;
        }
        if ((i & 16) != 0) {
            featureFlipEvaluator = featureFlip.evaluator;
        }
        if ((i & 32) != 0) {
            flippablePreRelease = featureFlip.flippablePreRelease;
        }
        FeatureFlipEvaluator featureFlipEvaluator2 = featureFlipEvaluator;
        FlippablePreRelease flippablePreRelease2 = flippablePreRelease;
        return featureFlip.copy(str, str2, featureFlipRule, sharedPreferences, featureFlipEvaluator2, flippablePreRelease2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOwner() {
        return this.owner;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final FeatureFlipRule getRule() {
        return this.rule;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final SharedPreferences getDebugOverridePrefs() {
        return this.debugOverridePrefs;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final FeatureFlipEvaluator getEvaluator() {
        return this.evaluator;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final FlippablePreRelease getFlippablePreRelease() {
        return this.flippablePreRelease;
    }

    public final FeatureFlip copy(String owner, String name, FeatureFlipRule rule, SharedPreferences debugOverridePrefs, FeatureFlipEvaluator evaluator, FlippablePreRelease flippablePreRelease) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(rule, "rule");
        Intrinsics.checkNotNullParameter(debugOverridePrefs, "debugOverridePrefs");
        Intrinsics.checkNotNullParameter(evaluator, "evaluator");
        return new FeatureFlip(owner, name, rule, debugOverridePrefs, evaluator, flippablePreRelease);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeatureFlip)) {
            return false;
        }
        FeatureFlip featureFlip = (FeatureFlip) other;
        return Intrinsics.areEqual(this.owner, featureFlip.owner) && Intrinsics.areEqual(this.name, featureFlip.name) && Intrinsics.areEqual(this.rule, featureFlip.rule) && Intrinsics.areEqual(this.debugOverridePrefs, featureFlip.debugOverridePrefs) && Intrinsics.areEqual(this.evaluator, featureFlip.evaluator) && Intrinsics.areEqual(this.flippablePreRelease, featureFlip.flippablePreRelease);
    }

    public int hashCode() {
        int iHashCode = ((((((((this.owner.hashCode() * 31) + this.name.hashCode()) * 31) + this.rule.hashCode()) * 31) + this.debugOverridePrefs.hashCode()) * 31) + this.evaluator.hashCode()) * 31;
        FlippablePreRelease flippablePreRelease = this.flippablePreRelease;
        return iHashCode + (flippablePreRelease == null ? 0 : flippablePreRelease.hashCode());
    }

    public String toString() {
        return "FeatureFlip(owner=" + this.owner + ", name=" + this.name + ", rule=" + this.rule + ", debugOverridePrefs=" + this.debugOverridePrefs + ", evaluator=" + this.evaluator + ", flippablePreRelease=" + this.flippablePreRelease + ")";
    }

    public FeatureFlip(String owner, String name, FeatureFlipRule rule, SharedPreferences debugOverridePrefs, FeatureFlipEvaluator evaluator, FlippablePreRelease flippablePreRelease) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(rule, "rule");
        Intrinsics.checkNotNullParameter(debugOverridePrefs, "debugOverridePrefs");
        Intrinsics.checkNotNullParameter(evaluator, "evaluator");
        this.owner = owner;
        this.name = name;
        this.rule = rule;
        this.debugOverridePrefs = debugOverridePrefs;
        this.evaluator = evaluator;
        this.flippablePreRelease = flippablePreRelease;
    }

    public /* synthetic */ FeatureFlip(String str, String str2, FeatureFlipRule featureFlipRule, SharedPreferences sharedPreferences, FeatureFlipEvaluator featureFlipEvaluator, FlippablePreRelease flippablePreRelease, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, featureFlipRule, sharedPreferences, featureFlipEvaluator, (i & 32) != 0 ? null : flippablePreRelease);
    }

    public final String getOwner() {
        return this.owner;
    }

    @Override // com.box.android.domain.configuration.IFeatureFlip
    public String getName() {
        return this.name;
    }

    public final FeatureFlipRule getRule() {
        return this.rule;
    }

    public final SharedPreferences getDebugOverridePrefs() {
        return this.debugOverridePrefs;
    }

    public final FeatureFlipEvaluator getEvaluator() {
        return this.evaluator;
    }

    public final FlippablePreRelease getFlippablePreRelease() {
        return this.flippablePreRelease;
    }

    @Override // com.box.android.domain.configuration.IFeatureFlip
    public boolean getEnabled() {
        return ((Boolean) BuildersKt__BuildersKt.runBlocking$default(null, new FeatureFlip$enabled$1(this, null), 1, null)).booleanValue();
    }
}
