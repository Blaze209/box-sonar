package androidx.compose.material3.internal;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.uimanager.ViewProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MenuPosition.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00128\b\u0002\u0010\t\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\n¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010(\u001a\u00020)2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020+H\u0016¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b2\u0010\u0014J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0007HÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J9\u00106\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\nHÆ\u0003Jr\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u000728\b\u0002\u0010\t\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\nHÆ\u0001¢\u0006\u0004\b8\u00109J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=HÖ\u0003J\t\u0010>\u001a\u00020\u0007HÖ\u0001J\t\u0010?\u001a\u00020@HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019RA\u0010\t\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Landroidx/compose/material3/internal/DropdownMenuPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "contentOffset", "Landroidx/compose/ui/unit/DpOffset;", "density", "Landroidx/compose/ui/unit/Density;", "verticalMargin", "", "horizontalMargin", "onPositionCalculated", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntRect;", "Lkotlin/ParameterName;", "name", "anchorBounds", "menuBounds", "", "<init>", "(JLandroidx/compose/ui/unit/Density;IILkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContentOffset-RKDOV3M", "()J", "J", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getVerticalMargin", "()I", "getHorizontalMargin", "getOnPositionCalculated", "()Lkotlin/jvm/functions/Function2;", "startToAnchorStart", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "endToAnchorEnd", "leftToWindowLeft", "rightToWindowRight", "topToAnchorBottom", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "bottomToAnchorTop", "centerToAnchorTop", "topToWindowTop", "bottomToWindowBottom", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", ViewProps.LAYOUT_DIRECTION, "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "component1", "component1-RKDOV3M", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-_0NXZrk", "(JLandroidx/compose/ui/unit/Density;IILkotlin/jvm/functions/Function2;)Landroidx/compose/material3/internal/DropdownMenuPositionProvider;", "equals", "", "other", "", "hashCode", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class DropdownMenuPositionProvider implements PopupPositionProvider {
    public static final int $stable = 0;
    private final MenuPosition.Vertical bottomToAnchorTop;
    private final MenuPosition.Vertical bottomToWindowBottom;
    private final MenuPosition.Vertical centerToAnchorTop;
    private final long contentOffset;
    private final Density density;
    private final MenuPosition.Horizontal endToAnchorEnd;
    private final int horizontalMargin;
    private final MenuPosition.Horizontal leftToWindowLeft;
    private final Function2<IntRect, IntRect, Unit> onPositionCalculated;
    private final MenuPosition.Horizontal rightToWindowRight;
    private final MenuPosition.Horizontal startToAnchorStart;
    private final MenuPosition.Vertical topToAnchorBottom;
    private final MenuPosition.Vertical topToWindowTop;
    private final int verticalMargin;

    public /* synthetic */ DropdownMenuPositionProvider(long j, Density density, int i, int i2, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, density, i, i2, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-_0NXZrk$default, reason: not valid java name */
    public static /* synthetic */ DropdownMenuPositionProvider m4977copy_0NXZrk$default(DropdownMenuPositionProvider dropdownMenuPositionProvider, long j, Density density, int i, int i2, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j = dropdownMenuPositionProvider.contentOffset;
        }
        long j2 = j;
        if ((i3 & 2) != 0) {
            density = dropdownMenuPositionProvider.density;
        }
        Density density2 = density;
        if ((i3 & 4) != 0) {
            i = dropdownMenuPositionProvider.verticalMargin;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = dropdownMenuPositionProvider.horizontalMargin;
        }
        int i5 = i2;
        if ((i3 & 16) != 0) {
            function2 = dropdownMenuPositionProvider.onPositionCalculated;
        }
        return dropdownMenuPositionProvider.m4979copy_0NXZrk(j2, density2, i4, i5, function2);
    }

    /* JADX INFO: renamed from: component1-RKDOV3M, reason: not valid java name and from getter */
    public final long getContentOffset() {
        return this.contentOffset;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Density getDensity() {
        return this.density;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getVerticalMargin() {
        return this.verticalMargin;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getHorizontalMargin() {
        return this.horizontalMargin;
    }

    public final Function2<IntRect, IntRect, Unit> component5() {
        return this.onPositionCalculated;
    }

    /* JADX INFO: renamed from: copy-_0NXZrk, reason: not valid java name */
    public final DropdownMenuPositionProvider m4979copy_0NXZrk(long contentOffset, Density density, int verticalMargin, int horizontalMargin, Function2<? super IntRect, ? super IntRect, Unit> onPositionCalculated) {
        return new DropdownMenuPositionProvider(contentOffset, density, verticalMargin, horizontalMargin, onPositionCalculated, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DropdownMenuPositionProvider)) {
            return false;
        }
        DropdownMenuPositionProvider dropdownMenuPositionProvider = (DropdownMenuPositionProvider) other;
        return DpOffset.m9747equalsimpl0(this.contentOffset, dropdownMenuPositionProvider.contentOffset) && Intrinsics.areEqual(this.density, dropdownMenuPositionProvider.density) && this.verticalMargin == dropdownMenuPositionProvider.verticalMargin && this.horizontalMargin == dropdownMenuPositionProvider.horizontalMargin && Intrinsics.areEqual(this.onPositionCalculated, dropdownMenuPositionProvider.onPositionCalculated);
    }

    public int hashCode() {
        return (((((((DpOffset.m9752hashCodeimpl(this.contentOffset) * 31) + this.density.hashCode()) * 31) + Integer.hashCode(this.verticalMargin)) * 31) + Integer.hashCode(this.horizontalMargin)) * 31) + this.onPositionCalculated.hashCode();
    }

    public String toString() {
        return "DropdownMenuPositionProvider(contentOffset=" + ((Object) DpOffset.m9755toStringimpl(this.contentOffset)) + ", density=" + this.density + ", verticalMargin=" + this.verticalMargin + ", horizontalMargin=" + this.horizontalMargin + ", onPositionCalculated=" + this.onPositionCalculated + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DropdownMenuPositionProvider(long j, Density density, int i, int i2, Function2<? super IntRect, ? super IntRect, Unit> function2) {
        this.contentOffset = j;
        this.density = density;
        this.verticalMargin = i;
        this.horizontalMargin = i2;
        this.onPositionCalculated = function2;
        int iMo748roundToPx0680j_4 = density.mo748roundToPx0680j_4(DpOffset.m9748getXD9Ej5fM(j));
        this.startToAnchorStart = MenuPosition.INSTANCE.startToAnchorStart(iMo748roundToPx0680j_4);
        this.endToAnchorEnd = MenuPosition.INSTANCE.endToAnchorEnd(iMo748roundToPx0680j_4);
        this.leftToWindowLeft = MenuPosition.INSTANCE.leftToWindowLeft(i2);
        this.rightToWindowRight = MenuPosition.INSTANCE.rightToWindowRight(i2);
        int iMo748roundToPx0680j_5 = density.mo748roundToPx0680j_4(DpOffset.m9750getYD9Ej5fM(j));
        this.topToAnchorBottom = MenuPosition.INSTANCE.topToAnchorBottom(iMo748roundToPx0680j_5);
        this.bottomToAnchorTop = MenuPosition.INSTANCE.bottomToAnchorTop(iMo748roundToPx0680j_5);
        this.centerToAnchorTop = MenuPosition.INSTANCE.centerToAnchorTop(iMo748roundToPx0680j_5);
        this.topToWindowTop = MenuPosition.INSTANCE.topToWindowTop(i);
        this.bottomToWindowBottom = MenuPosition.INSTANCE.bottomToWindowBottom(i);
    }

    /* JADX INFO: renamed from: getContentOffset-RKDOV3M, reason: not valid java name */
    public final long m4980getContentOffsetRKDOV3M() {
        return this.contentOffset;
    }

    public final Density getDensity() {
        return this.density;
    }

    public /* synthetic */ DropdownMenuPositionProvider(long j, Density density, int i, int i2, Function2 function2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, density, (i3 & 4) != 0 ? density.mo748roundToPx0680j_4(MenuKt.getMenuVerticalMargin()) : i, (i3 & 8) != 0 ? density.mo748roundToPx0680j_4(MenuKt.getMenuHorizontalMargin()) : i2, (i3 & 16) != 0 ? new Function2() { // from class: androidx.compose.material3.internal.DropdownMenuPositionProvider$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DropdownMenuPositionProvider._init_$lambda$2((IntRect) obj, (IntRect) obj2);
            }
        } : function2, null);
    }

    public final int getVerticalMargin() {
        return this.verticalMargin;
    }

    public final int getHorizontalMargin() {
        return this.horizontalMargin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$2(IntRect intRect, IntRect intRect2) {
        return Unit.INSTANCE;
    }

    public final Function2<IntRect, IntRect, Unit> getOnPositionCalculated() {
        return this.onPositionCalculated;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public long mo718calculatePositionllwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
        MenuPosition.Horizontal horizontal;
        IntRect intRect;
        long j;
        char c;
        int iMo4895position95KtPRI;
        MenuPosition.Vertical vertical;
        int iMo4896positionJVtK1S4;
        int i;
        int i2;
        char c2 = 3;
        MenuPosition.Horizontal[] horizontalArr = new MenuPosition.Horizontal[3];
        horizontalArr[0] = this.startToAnchorStart;
        horizontalArr[1] = this.endToAnchorEnd;
        int i3 = (int) (windowSize >> 32);
        if (IntOffset.m9815getXimpl(anchorBounds.m9839getCenternOccac()) < i3 / 2) {
            horizontal = this.leftToWindowLeft;
        } else {
            horizontal = this.rightToWindowRight;
        }
        horizontalArr[2] = horizontal;
        List listListOf = CollectionsKt.listOf((Object[]) horizontalArr);
        int size = listListOf.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                intRect = anchorBounds;
                j = windowSize;
                c = c2;
                iMo4895position95KtPRI = 0;
                break;
            }
            MenuPosition.Horizontal horizontal2 = (MenuPosition.Horizontal) listListOf.get(i4);
            int i5 = (int) (popupContentSize >> 32);
            int i6 = size;
            c = c2;
            j = windowSize;
            int i7 = i4;
            intRect = anchorBounds;
            iMo4895position95KtPRI = horizontal2.mo4895position95KtPRI(intRect, j, i5, layoutDirection);
            if (i7 == CollectionsKt.getLastIndex(listListOf) || (iMo4895position95KtPRI >= (i2 = this.horizontalMargin) && i5 + iMo4895position95KtPRI <= i3 - i2)) {
                break;
            }
            i4 = i7 + 1;
            size = i6;
            c2 = c;
        }
        MenuPosition.Vertical[] verticalArr = new MenuPosition.Vertical[4];
        verticalArr[0] = this.topToAnchorBottom;
        verticalArr[1] = this.bottomToAnchorTop;
        verticalArr[2] = this.centerToAnchorTop;
        int i8 = (int) (j & 4294967295L);
        if (IntOffset.m9816getYimpl(intRect.m9839getCenternOccac()) < i8 / 2) {
            vertical = this.topToWindowTop;
        } else {
            vertical = this.bottomToWindowBottom;
        }
        verticalArr[c] = vertical;
        List listListOf2 = CollectionsKt.listOf((Object[]) verticalArr);
        int size2 = listListOf2.size();
        int i9 = 0;
        while (i9 < size2) {
            int i10 = i8;
            int i11 = (int) (popupContentSize & 4294967295L);
            iMo4896positionJVtK1S4 = ((MenuPosition.Vertical) listListOf2.get(i9)).mo4896positionJVtK1S4(intRect, j, i11);
            if (i9 == CollectionsKt.getLastIndex(listListOf2) || (iMo4896positionJVtK1S4 >= (i = this.verticalMargin) && i11 + iMo4896positionJVtK1S4 <= i10 - i)) {
                long jM9809constructorimpl = IntOffset.m9809constructorimpl((((long) iMo4895position95KtPRI) << 32) | (((long) iMo4896positionJVtK1S4) & 4294967295L));
                this.onPositionCalculated.invoke(intRect, IntRectKt.m9848IntRectVbeCjmY(jM9809constructorimpl, popupContentSize));
                return jM9809constructorimpl;
            }
            i9++;
            i8 = i10;
        }
        iMo4896positionJVtK1S4 = 0;
        long jM9809constructorimpl2 = IntOffset.m9809constructorimpl((((long) iMo4895position95KtPRI) << 32) | (((long) iMo4896positionJVtK1S4) & 4294967295L));
        this.onPositionCalculated.invoke(intRect, IntRectKt.m9848IntRectVbeCjmY(jM9809constructorimpl2, popupContentSize));
        return jM9809constructorimpl2;
    }
}
