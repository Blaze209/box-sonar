package com.box.android.domain.configuration;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IFeatureFlip.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\b\u001a\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0086\u0004\u001a\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0086\u0004¨\u0006\u0013"}, d2 = {"enabledIn", "Lcom/box/android/domain/configuration/FeatureFlipRule$EnabledIn;", "targets", "", "Lcom/box/android/domain/configuration/FeatureFlipTarget;", "([Lcom/box/android/domain/configuration/FeatureFlipTarget;)Lcom/box/android/domain/configuration/FeatureFlipRule$EnabledIn;", "split", "Lcom/box/android/domain/configuration/FeatureFlipRule$SplitRule;", "Lcom/box/android/domain/configuration/Split;", "selectedTestRun", "Lcom/box/android/domain/configuration/FeatureFlipRule$SelectedTestRun;", "featureFlipName", "", "and", "Lcom/box/android/domain/configuration/FeatureFlipRule$And;", "Lcom/box/android/domain/configuration/FeatureFlipRule;", "other", "or", "Lcom/box/android/domain/configuration/FeatureFlipRule$Or;", "domain_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IFeatureFlipKt {
    public static final FeatureFlipRule.EnabledIn enabledIn(FeatureFlipTarget... targets) {
        Intrinsics.checkNotNullParameter(targets, "targets");
        return new FeatureFlipRule.EnabledIn(ArraysKt.toSet(targets));
    }

    public static final FeatureFlipRule.SplitRule split(Split split) {
        Intrinsics.checkNotNullParameter(split, "split");
        return new FeatureFlipRule.SplitRule(split);
    }

    public static final FeatureFlipRule.SelectedTestRun selectedTestRun(String featureFlipName) {
        Intrinsics.checkNotNullParameter(featureFlipName, "featureFlipName");
        return new FeatureFlipRule.SelectedTestRun(featureFlipName);
    }

    public static final FeatureFlipRule.And and(FeatureFlipRule featureFlipRule, FeatureFlipRule other) {
        Intrinsics.checkNotNullParameter(featureFlipRule, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return new FeatureFlipRule.And(CollectionsKt.plus((Collection) (featureFlipRule instanceof FeatureFlipRule.And ? ((FeatureFlipRule.And) featureFlipRule).getRules() : CollectionsKt.listOf(featureFlipRule)), (Iterable) (other instanceof FeatureFlipRule.And ? ((FeatureFlipRule.And) other).getRules() : CollectionsKt.listOf(other))));
    }

    public static final FeatureFlipRule.Or or(FeatureFlipRule featureFlipRule, FeatureFlipRule other) {
        Intrinsics.checkNotNullParameter(featureFlipRule, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return new FeatureFlipRule.Or(CollectionsKt.plus((Collection) (featureFlipRule instanceof FeatureFlipRule.Or ? ((FeatureFlipRule.Or) featureFlipRule).getRules() : CollectionsKt.listOf(featureFlipRule)), (Iterable) (other instanceof FeatureFlipRule.Or ? ((FeatureFlipRule.Or) other).getRules() : CollectionsKt.listOf(other))));
    }
}
