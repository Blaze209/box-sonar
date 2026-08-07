package com.box.android.domain.configuration;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IFeatureFlip.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\b\f\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/box/android/domain/configuration/FeatureFlipRule;", "", "<init>", "()V", "Disabled", "Enabled", "Eval", "SplitRule", "SelectedTestRun", "EnabledIn", "And", "Or", "Lcom/box/android/domain/configuration/FeatureFlipRule$And;", "Lcom/box/android/domain/configuration/FeatureFlipRule$Disabled;", "Lcom/box/android/domain/configuration/FeatureFlipRule$Enabled;", "Lcom/box/android/domain/configuration/FeatureFlipRule$EnabledIn;", "Lcom/box/android/domain/configuration/FeatureFlipRule$Eval;", "Lcom/box/android/domain/configuration/FeatureFlipRule$Or;", "Lcom/box/android/domain/configuration/FeatureFlipRule$SelectedTestRun;", "Lcom/box/android/domain/configuration/FeatureFlipRule$SplitRule;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class FeatureFlipRule {
    public /* synthetic */ FeatureFlipRule(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: IFeatureFlip.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/domain/configuration/FeatureFlipRule$Disabled;", "Lcom/box/android/domain/configuration/FeatureFlipRule;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Disabled extends FeatureFlipRule {
        public static final Disabled INSTANCE = new Disabled();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Disabled)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1327020866;
        }

        public String toString() {
            return "Disabled";
        }

        private Disabled() {
            super(null);
        }
    }

    private FeatureFlipRule() {
    }

    /* JADX INFO: compiled from: IFeatureFlip.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/domain/configuration/FeatureFlipRule$Enabled;", "Lcom/box/android/domain/configuration/FeatureFlipRule;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Enabled extends FeatureFlipRule {
        public static final Enabled INSTANCE = new Enabled();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Enabled)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1245499201;
        }

        public String toString() {
            return "Enabled";
        }

        private Enabled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: IFeatureFlip.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u001c\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bR)\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/box/android/domain/configuration/FeatureFlipRule$Eval;", "Lcom/box/android/domain/configuration/FeatureFlipRule;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getBlock", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function1;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Eval extends FeatureFlipRule {
        private final Function1<Continuation<? super Boolean>, Object> block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Eval(Function1<? super Continuation<? super Boolean>, ? extends Object> block) {
            super(null);
            Intrinsics.checkNotNullParameter(block, "block");
            this.block = block;
        }

        public final Function1<Continuation<? super Boolean>, Object> getBlock() {
            return this.block;
        }
    }

    /* JADX INFO: compiled from: IFeatureFlip.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/configuration/FeatureFlipRule$SplitRule;", "Lcom/box/android/domain/configuration/FeatureFlipRule;", "split", "Lcom/box/android/domain/configuration/Split;", "<init>", "(Lcom/box/android/domain/configuration/Split;)V", "getSplit", "()Lcom/box/android/domain/configuration/Split;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SplitRule extends FeatureFlipRule {
        private final Split split;

        public static /* synthetic */ SplitRule copy$default(SplitRule splitRule, Split split, int i, Object obj) {
            if ((i & 1) != 0) {
                split = splitRule.split;
            }
            return splitRule.copy(split);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Split getSplit() {
            return this.split;
        }

        public final SplitRule copy(Split split) {
            Intrinsics.checkNotNullParameter(split, "split");
            return new SplitRule(split);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SplitRule) && this.split == ((SplitRule) other).split;
        }

        public int hashCode() {
            return this.split.hashCode();
        }

        public String toString() {
            return "SplitRule(split=" + this.split + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SplitRule(Split split) {
            super(null);
            Intrinsics.checkNotNullParameter(split, "split");
            this.split = split;
        }

        public final Split getSplit() {
            return this.split;
        }
    }

    /* JADX INFO: compiled from: IFeatureFlip.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/domain/configuration/FeatureFlipRule$SelectedTestRun;", "Lcom/box/android/domain/configuration/FeatureFlipRule;", "featureFlipName", "", "<init>", "(Ljava/lang/String;)V", "getFeatureFlipName", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SelectedTestRun extends FeatureFlipRule {
        private final String featureFlipName;

        public static /* synthetic */ SelectedTestRun copy$default(SelectedTestRun selectedTestRun, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = selectedTestRun.featureFlipName;
            }
            return selectedTestRun.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFeatureFlipName() {
            return this.featureFlipName;
        }

        public final SelectedTestRun copy(String featureFlipName) {
            Intrinsics.checkNotNullParameter(featureFlipName, "featureFlipName");
            return new SelectedTestRun(featureFlipName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SelectedTestRun) && Intrinsics.areEqual(this.featureFlipName, ((SelectedTestRun) other).featureFlipName);
        }

        public int hashCode() {
            return this.featureFlipName.hashCode();
        }

        public String toString() {
            return "SelectedTestRun(featureFlipName=" + this.featureFlipName + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelectedTestRun(String featureFlipName) {
            super(null);
            Intrinsics.checkNotNullParameter(featureFlipName, "featureFlipName");
            this.featureFlipName = featureFlipName;
        }

        public final String getFeatureFlipName() {
            return this.featureFlipName;
        }
    }

    /* JADX INFO: compiled from: IFeatureFlip.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/domain/configuration/FeatureFlipRule$EnabledIn;", "Lcom/box/android/domain/configuration/FeatureFlipRule;", "targets", "", "Lcom/box/android/domain/configuration/FeatureFlipTarget;", "<init>", "(Ljava/util/Set;)V", "getTargets", "()Ljava/util/Set;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class EnabledIn extends FeatureFlipRule {
        private final Set<FeatureFlipTarget> targets;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ EnabledIn copy$default(EnabledIn enabledIn, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                set = enabledIn.targets;
            }
            return enabledIn.copy(set);
        }

        public final Set<FeatureFlipTarget> component1() {
            return this.targets;
        }

        public final EnabledIn copy(Set<? extends FeatureFlipTarget> targets) {
            Intrinsics.checkNotNullParameter(targets, "targets");
            return new EnabledIn(targets);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof EnabledIn) && Intrinsics.areEqual(this.targets, ((EnabledIn) other).targets);
        }

        public int hashCode() {
            return this.targets.hashCode();
        }

        public String toString() {
            return "EnabledIn(targets=" + this.targets + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public EnabledIn(Set<? extends FeatureFlipTarget> targets) {
            super(null);
            Intrinsics.checkNotNullParameter(targets, "targets");
            this.targets = targets;
        }

        public final Set<FeatureFlipTarget> getTargets() {
            return this.targets;
        }
    }

    /* JADX INFO: compiled from: IFeatureFlip.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/configuration/FeatureFlipRule$And;", "Lcom/box/android/domain/configuration/FeatureFlipRule;", "rules", "", "<init>", "(Ljava/util/List;)V", "getRules", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class And extends FeatureFlipRule {
        private final List<FeatureFlipRule> rules;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ And copy$default(And and, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = and.rules;
            }
            return and.copy(list);
        }

        public final List<FeatureFlipRule> component1() {
            return this.rules;
        }

        public final And copy(List<? extends FeatureFlipRule> rules) {
            Intrinsics.checkNotNullParameter(rules, "rules");
            return new And(rules);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof And) && Intrinsics.areEqual(this.rules, ((And) other).rules);
        }

        public int hashCode() {
            return this.rules.hashCode();
        }

        public String toString() {
            return "And(rules=" + this.rules + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public And(List<? extends FeatureFlipRule> rules) {
            super(null);
            Intrinsics.checkNotNullParameter(rules, "rules");
            this.rules = rules;
        }

        public final List<FeatureFlipRule> getRules() {
            return this.rules;
        }
    }

    /* JADX INFO: compiled from: IFeatureFlip.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/configuration/FeatureFlipRule$Or;", "Lcom/box/android/domain/configuration/FeatureFlipRule;", "rules", "", "<init>", "(Ljava/util/List;)V", "getRules", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Or extends FeatureFlipRule {
        private final List<FeatureFlipRule> rules;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Or copy$default(Or or, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = or.rules;
            }
            return or.copy(list);
        }

        public final List<FeatureFlipRule> component1() {
            return this.rules;
        }

        public final Or copy(List<? extends FeatureFlipRule> rules) {
            Intrinsics.checkNotNullParameter(rules, "rules");
            return new Or(rules);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Or) && Intrinsics.areEqual(this.rules, ((Or) other).rules);
        }

        public int hashCode() {
            return this.rules.hashCode();
        }

        public String toString() {
            return "Or(rules=" + this.rules + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Or(List<? extends FeatureFlipRule> rules) {
            super(null);
            Intrinsics.checkNotNullParameter(rules, "rules");
            this.rules = rules;
        }

        public final List<FeatureFlipRule> getRules() {
            return this.rules;
        }
    }
}
