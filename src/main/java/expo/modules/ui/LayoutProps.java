package expo.modules.ui;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.types.Either;
import expo.modules.kotlin.views.ComposeProps;
import expo.modules.ui.convertibles.ContentAlignment;
import expo.modules.ui.convertibles.HorizontalAlignment;
import expo.modules.ui.convertibles.HorizontalArrangementCustom;
import expo.modules.ui.convertibles.HorizontalArrangementDefault;
import expo.modules.ui.convertibles.VerticalAlignment;
import expo.modules.ui.convertibles.VerticalArrangementCustom;
import expo.modules.ui.convertibles.VerticalArrangementDefault;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ComposeViews.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003j\u0004\u0018\u0001`\u0006\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003j\u0004\u0018\u0001`\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012$\b\u0002\u0010\u0013\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015j\u0002`\u00180\u0014j\u0002`\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003j\u0004\u0018\u0001`\u0006HÆ\u0003J\u001d\u0010*\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003j\u0004\u0018\u0001`\nHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0012HÆ\u0003J%\u0010/\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015j\u0002`\u00180\u0014j\u0002`\u0019HÆ\u0003J\u009b\u0001\u00100\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003j\u0004\u0018\u0001`\u00062\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003j\u0004\u0018\u0001`\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122$\b\u0002\u0010\u0013\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015j\u0002`\u00180\u0014j\u0002`\u0019HÆ\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u00020\u0016HÖ\u0001R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003j\u0004\u0018\u0001`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR%\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003j\u0004\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R-\u0010\u0013\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015j\u0002`\u00180\u0014j\u0002`\u0019¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u00067"}, d2 = {"Lexpo/modules/ui/LayoutProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "horizontalArrangement", "Lexpo/modules/kotlin/types/Either;", "Lexpo/modules/ui/convertibles/HorizontalArrangementDefault;", "Lexpo/modules/ui/convertibles/HorizontalArrangementCustom;", "Lexpo/modules/ui/convertibles/HorizontalArrangement;", "verticalArrangement", "Lexpo/modules/ui/convertibles/VerticalArrangementDefault;", "Lexpo/modules/ui/convertibles/VerticalArrangementCustom;", "Lexpo/modules/ui/convertibles/VerticalArrangement;", "horizontalAlignment", "Lexpo/modules/ui/convertibles/HorizontalAlignment;", "verticalAlignment", "Lexpo/modules/ui/convertibles/VerticalAlignment;", "contentAlignment", "Lexpo/modules/ui/convertibles/ContentAlignment;", "floatingToolbarExitAlwaysScrollBehavior", "Lexpo/modules/ui/FloatingToolbarExitAlwaysScrollBehavior;", "modifiers", "", "", "", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Lexpo/modules/kotlin/types/Either;Lexpo/modules/kotlin/types/Either;Lexpo/modules/ui/convertibles/HorizontalAlignment;Lexpo/modules/ui/convertibles/VerticalAlignment;Lexpo/modules/ui/convertibles/ContentAlignment;Lexpo/modules/ui/FloatingToolbarExitAlwaysScrollBehavior;Ljava/util/List;)V", "getHorizontalArrangement", "()Lexpo/modules/kotlin/types/Either;", "getVerticalArrangement", "getHorizontalAlignment", "()Lexpo/modules/ui/convertibles/HorizontalAlignment;", "getVerticalAlignment", "()Lexpo/modules/ui/convertibles/VerticalAlignment;", "getContentAlignment", "()Lexpo/modules/ui/convertibles/ContentAlignment;", "getFloatingToolbarExitAlwaysScrollBehavior", "()Lexpo/modules/ui/FloatingToolbarExitAlwaysScrollBehavior;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class LayoutProps implements ComposeProps {
    public static final int $stable = 8;
    private final ContentAlignment contentAlignment;
    private final FloatingToolbarExitAlwaysScrollBehavior floatingToolbarExitAlwaysScrollBehavior;
    private final HorizontalAlignment horizontalAlignment;
    private final Either<HorizontalArrangementDefault, HorizontalArrangementCustom> horizontalArrangement;
    private final List<Map<String, Object>> modifiers;
    private final VerticalAlignment verticalAlignment;
    private final Either<VerticalArrangementDefault, VerticalArrangementCustom> verticalArrangement;

    public LayoutProps() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LayoutProps copy$default(LayoutProps layoutProps, Either either, Either either2, HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment, ContentAlignment contentAlignment, FloatingToolbarExitAlwaysScrollBehavior floatingToolbarExitAlwaysScrollBehavior, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            either = layoutProps.horizontalArrangement;
        }
        if ((i & 2) != 0) {
            either2 = layoutProps.verticalArrangement;
        }
        if ((i & 4) != 0) {
            horizontalAlignment = layoutProps.horizontalAlignment;
        }
        if ((i & 8) != 0) {
            verticalAlignment = layoutProps.verticalAlignment;
        }
        if ((i & 16) != 0) {
            contentAlignment = layoutProps.contentAlignment;
        }
        if ((i & 32) != 0) {
            floatingToolbarExitAlwaysScrollBehavior = layoutProps.floatingToolbarExitAlwaysScrollBehavior;
        }
        if ((i & 64) != 0) {
            list = layoutProps.modifiers;
        }
        FloatingToolbarExitAlwaysScrollBehavior floatingToolbarExitAlwaysScrollBehavior2 = floatingToolbarExitAlwaysScrollBehavior;
        List list2 = list;
        ContentAlignment contentAlignment2 = contentAlignment;
        HorizontalAlignment horizontalAlignment2 = horizontalAlignment;
        return layoutProps.copy(either, either2, horizontalAlignment2, verticalAlignment, contentAlignment2, floatingToolbarExitAlwaysScrollBehavior2, list2);
    }

    public final Either<HorizontalArrangementDefault, HorizontalArrangementCustom> component1() {
        return this.horizontalArrangement;
    }

    public final Either<VerticalArrangementDefault, VerticalArrangementCustom> component2() {
        return this.verticalArrangement;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final HorizontalAlignment getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final VerticalAlignment getVerticalAlignment() {
        return this.verticalAlignment;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ContentAlignment getContentAlignment() {
        return this.contentAlignment;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final FloatingToolbarExitAlwaysScrollBehavior getFloatingToolbarExitAlwaysScrollBehavior() {
        return this.floatingToolbarExitAlwaysScrollBehavior;
    }

    public final List<Map<String, Object>> component7() {
        return this.modifiers;
    }

    public final LayoutProps copy(Either<HorizontalArrangementDefault, HorizontalArrangementCustom> horizontalArrangement, Either<VerticalArrangementDefault, VerticalArrangementCustom> verticalArrangement, HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment, ContentAlignment contentAlignment, FloatingToolbarExitAlwaysScrollBehavior floatingToolbarExitAlwaysScrollBehavior, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new LayoutProps(horizontalArrangement, verticalArrangement, horizontalAlignment, verticalAlignment, contentAlignment, floatingToolbarExitAlwaysScrollBehavior, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LayoutProps)) {
            return false;
        }
        LayoutProps layoutProps = (LayoutProps) other;
        return Intrinsics.areEqual(this.horizontalArrangement, layoutProps.horizontalArrangement) && Intrinsics.areEqual(this.verticalArrangement, layoutProps.verticalArrangement) && this.horizontalAlignment == layoutProps.horizontalAlignment && this.verticalAlignment == layoutProps.verticalAlignment && this.contentAlignment == layoutProps.contentAlignment && this.floatingToolbarExitAlwaysScrollBehavior == layoutProps.floatingToolbarExitAlwaysScrollBehavior && Intrinsics.areEqual(this.modifiers, layoutProps.modifiers);
    }

    public int hashCode() {
        Either<HorizontalArrangementDefault, HorizontalArrangementCustom> either = this.horizontalArrangement;
        int iHashCode = (either == null ? 0 : either.hashCode()) * 31;
        Either<VerticalArrangementDefault, VerticalArrangementCustom> either2 = this.verticalArrangement;
        int iHashCode2 = (iHashCode + (either2 == null ? 0 : either2.hashCode())) * 31;
        HorizontalAlignment horizontalAlignment = this.horizontalAlignment;
        int iHashCode3 = (iHashCode2 + (horizontalAlignment == null ? 0 : horizontalAlignment.hashCode())) * 31;
        VerticalAlignment verticalAlignment = this.verticalAlignment;
        int iHashCode4 = (iHashCode3 + (verticalAlignment == null ? 0 : verticalAlignment.hashCode())) * 31;
        ContentAlignment contentAlignment = this.contentAlignment;
        int iHashCode5 = (iHashCode4 + (contentAlignment == null ? 0 : contentAlignment.hashCode())) * 31;
        FloatingToolbarExitAlwaysScrollBehavior floatingToolbarExitAlwaysScrollBehavior = this.floatingToolbarExitAlwaysScrollBehavior;
        return ((iHashCode5 + (floatingToolbarExitAlwaysScrollBehavior != null ? floatingToolbarExitAlwaysScrollBehavior.hashCode() : 0)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "LayoutProps(horizontalArrangement=" + this.horizontalArrangement + ", verticalArrangement=" + this.verticalArrangement + ", horizontalAlignment=" + this.horizontalAlignment + ", verticalAlignment=" + this.verticalAlignment + ", contentAlignment=" + this.contentAlignment + ", floatingToolbarExitAlwaysScrollBehavior=" + this.floatingToolbarExitAlwaysScrollBehavior + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LayoutProps(Either<HorizontalArrangementDefault, HorizontalArrangementCustom> either, Either<VerticalArrangementDefault, VerticalArrangementCustom> either2, HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment, ContentAlignment contentAlignment, FloatingToolbarExitAlwaysScrollBehavior floatingToolbarExitAlwaysScrollBehavior, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.horizontalArrangement = either;
        this.verticalArrangement = either2;
        this.horizontalAlignment = horizontalAlignment;
        this.verticalAlignment = verticalAlignment;
        this.contentAlignment = contentAlignment;
        this.floatingToolbarExitAlwaysScrollBehavior = floatingToolbarExitAlwaysScrollBehavior;
        this.modifiers = modifiers;
    }

    public final Either<HorizontalArrangementDefault, HorizontalArrangementCustom> getHorizontalArrangement() {
        return this.horizontalArrangement;
    }

    public final Either<VerticalArrangementDefault, VerticalArrangementCustom> getVerticalArrangement() {
        return this.verticalArrangement;
    }

    public final HorizontalAlignment getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    public final VerticalAlignment getVerticalAlignment() {
        return this.verticalAlignment;
    }

    public final ContentAlignment getContentAlignment() {
        return this.contentAlignment;
    }

    public final FloatingToolbarExitAlwaysScrollBehavior getFloatingToolbarExitAlwaysScrollBehavior() {
        return this.floatingToolbarExitAlwaysScrollBehavior;
    }

    public /* synthetic */ LayoutProps(Either either, Either either2, HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment, ContentAlignment contentAlignment, FloatingToolbarExitAlwaysScrollBehavior floatingToolbarExitAlwaysScrollBehavior, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : either, (i & 2) != 0 ? null : either2, (i & 4) != 0 ? null : horizontalAlignment, (i & 8) != 0 ? null : verticalAlignment, (i & 16) != 0 ? null : contentAlignment, (i & 32) != 0 ? null : floatingToolbarExitAlwaysScrollBehavior, (i & 64) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<Map<String, Object>> getModifiers() {
        return this.modifiers;
    }
}
