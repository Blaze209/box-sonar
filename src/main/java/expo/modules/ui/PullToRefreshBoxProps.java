package expo.modules.ui;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.views.ComposeProps;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PullToRefreshBoxView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012$\b\u0002\u0010\u0004\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006j\u0002`\t0\u0005j\u0002`\n\u0012$\b\u0002\u0010\u000b\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006j\u0002`\t0\u0005j\u0002`\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J%\u0010\u0013\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006j\u0002`\t0\u0005j\u0002`\nHÆ\u0003J%\u0010\u0014\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006j\u0002`\t0\u0005j\u0002`\nHÆ\u0003J_\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032$\b\u0002\u0010\u0004\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006j\u0002`\t0\u0005j\u0002`\n2$\b\u0002\u0010\u000b\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006j\u0002`\t0\u0005j\u0002`\nHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000eR-\u0010\u0004\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006j\u0002`\t0\u0005j\u0002`\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R-\u0010\u000b\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006j\u0002`\t0\u0005j\u0002`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001b"}, d2 = {"Lexpo/modules/ui/PullToRefreshBoxProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "isRefreshing", "", "modifiers", "", "", "", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "loadingIndicatorModifiers", "<init>", "(ZLjava/util/List;Ljava/util/List;)V", "()Z", "getModifiers", "()Ljava/util/List;", "getLoadingIndicatorModifiers", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class PullToRefreshBoxProps implements ComposeProps {
    public static final int $stable = 8;
    private final boolean isRefreshing;
    private final List<Map<String, Object>> loadingIndicatorModifiers;
    private final List<Map<String, Object>> modifiers;

    public PullToRefreshBoxProps() {
        this(false, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PullToRefreshBoxProps copy$default(PullToRefreshBoxProps pullToRefreshBoxProps, boolean z, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = pullToRefreshBoxProps.isRefreshing;
        }
        if ((i & 2) != 0) {
            list = pullToRefreshBoxProps.modifiers;
        }
        if ((i & 4) != 0) {
            list2 = pullToRefreshBoxProps.loadingIndicatorModifiers;
        }
        return pullToRefreshBoxProps.copy(z, list, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsRefreshing() {
        return this.isRefreshing;
    }

    public final List<Map<String, Object>> component2() {
        return this.modifiers;
    }

    public final List<Map<String, Object>> component3() {
        return this.loadingIndicatorModifiers;
    }

    public final PullToRefreshBoxProps copy(boolean isRefreshing, List<? extends Map<String, ? extends Object>> modifiers, List<? extends Map<String, ? extends Object>> loadingIndicatorModifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        Intrinsics.checkNotNullParameter(loadingIndicatorModifiers, "loadingIndicatorModifiers");
        return new PullToRefreshBoxProps(isRefreshing, modifiers, loadingIndicatorModifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PullToRefreshBoxProps)) {
            return false;
        }
        PullToRefreshBoxProps pullToRefreshBoxProps = (PullToRefreshBoxProps) other;
        return this.isRefreshing == pullToRefreshBoxProps.isRefreshing && Intrinsics.areEqual(this.modifiers, pullToRefreshBoxProps.modifiers) && Intrinsics.areEqual(this.loadingIndicatorModifiers, pullToRefreshBoxProps.loadingIndicatorModifiers);
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.isRefreshing) * 31) + this.modifiers.hashCode()) * 31) + this.loadingIndicatorModifiers.hashCode();
    }

    public String toString() {
        return "PullToRefreshBoxProps(isRefreshing=" + this.isRefreshing + ", modifiers=" + this.modifiers + ", loadingIndicatorModifiers=" + this.loadingIndicatorModifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PullToRefreshBoxProps(boolean z, List<? extends Map<String, ? extends Object>> modifiers, List<? extends Map<String, ? extends Object>> loadingIndicatorModifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        Intrinsics.checkNotNullParameter(loadingIndicatorModifiers, "loadingIndicatorModifiers");
        this.isRefreshing = z;
        this.modifiers = modifiers;
        this.loadingIndicatorModifiers = loadingIndicatorModifiers;
    }

    public final boolean isRefreshing() {
        return this.isRefreshing;
    }

    public /* synthetic */ PullToRefreshBoxProps(boolean z, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2);
    }

    public final List<Map<String, Object>> getModifiers() {
        return this.modifiers;
    }

    public final List<Map<String, Object>> getLoadingIndicatorModifiers() {
        return this.loadingIndicatorModifiers;
    }
}
