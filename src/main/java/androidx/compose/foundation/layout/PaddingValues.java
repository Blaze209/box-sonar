package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Padding.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bg\u0018\u0000 \u00102\u00020\u0001:\u0002\u000f\u0010J\u0017\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0004\b\f\u0010\u0007J\u000f\u0010\r\u001a\u00020\u0003H&¢\u0006\u0004\b\u000e\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValues;", "", "calculateLeftPadding", "Landroidx/compose/ui/unit/Dp;", ViewProps.LAYOUT_DIRECTION, "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "()F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateBottomPadding", "calculateBottomPadding-D9Ej5fM", "Absolute", "Companion", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PaddingValues {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM */
    float getBottom();

    /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM */
    float mo1163calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection);

    /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
    float mo1164calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection);

    /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM */
    float getTop();

    /* JADX INFO: compiled from: Padding.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0018\u0010\u0013J\u000f\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u0016J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0016R\u0018\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\n\n\u0002\u0010\u000b\u0012\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\n\n\u0002\u0010\u000b\u0012\u0004\b\f\u0010\nR\u0018\u0010\u0005\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\n\n\u0002\u0010\u000b\u0012\u0004\b\r\u0010\nR\u0018\u0010\u0006\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\n\n\u0002\u0010\u000b\u0012\u0004\b\u000e\u0010\n¨\u0006#"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValues$Absolute;", "Landroidx/compose/foundation/layout/PaddingValues;", "left", "Landroidx/compose/ui/unit/Dp;", ViewProps.TOP, "right", ViewProps.BOTTOM, "<init>", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLeft-D9Ej5fM$annotations", "()V", "F", "getTop-D9Ej5fM$annotations", "getRight-D9Ej5fM$annotations", "getBottom-D9Ej5fM$annotations", "calculateLeftPadding", ViewProps.LAYOUT_DIRECTION, "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "()F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateBottomPadding", "calculateBottomPadding-D9Ej5fM", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Absolute implements PaddingValues {
        public static final int $stable = 0;
        private final float bottom;
        private final float left;
        private final float right;
        private final float top;

        public /* synthetic */ Absolute(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, f2, f3, f4);
        }

        /* JADX INFO: renamed from: getBottom-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m1232getBottomD9Ej5fM$annotations() {
        }

        /* JADX INFO: renamed from: getLeft-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m1233getLeftD9Ej5fM$annotations() {
        }

        /* JADX INFO: renamed from: getRight-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m1234getRightD9Ej5fM$annotations() {
        }

        /* JADX INFO: renamed from: getTop-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m1235getTopD9Ej5fM$annotations() {
        }

        private Absolute(float f, float f2, float f3, float f4) {
            this.left = f;
            this.top = f2;
            this.right = f3;
            this.bottom = f4;
            if (!((f >= 0.0f) & (f2 >= 0.0f) & (f3 >= 0.0f)) || !(f4 >= 0.0f)) {
                InlineClassHelperKt.throwIllegalArgumentException("Padding must be non-negative");
            }
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM */
        public float mo1163calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection) {
            return this.left;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM, reason: from getter */
        public float getTop() {
            return this.top;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
        public float mo1164calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection) {
            return this.right;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM, reason: from getter */
        public float getBottom() {
            return this.bottom;
        }

        public boolean equals(Object other) {
            if (!(other instanceof Absolute)) {
                return false;
            }
            Absolute absolute = (Absolute) other;
            return Dp.m9692equalsimpl0(this.left, absolute.left) && Dp.m9692equalsimpl0(this.top, absolute.top) && Dp.m9692equalsimpl0(this.right, absolute.right) && Dp.m9692equalsimpl0(this.bottom, absolute.bottom);
        }

        public int hashCode() {
            return (((((Dp.m9693hashCodeimpl(this.left) * 31) + Dp.m9693hashCodeimpl(this.top)) * 31) + Dp.m9693hashCodeimpl(this.right)) * 31) + Dp.m9693hashCodeimpl(this.bottom);
        }

        public String toString() {
            return "PaddingValues.Absolute(left=" + ((Object) Dp.m9698toStringimpl(this.left)) + ", top=" + ((Object) Dp.m9698toStringimpl(this.top)) + ", right=" + ((Object) Dp.m9698toStringimpl(this.right)) + ", bottom=" + ((Object) Dp.m9698toStringimpl(this.bottom)) + ')';
        }

        public /* synthetic */ Absolute(float f, float f2, float f3, float f4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Dp.m9687constructorimpl(0) : f, (i & 2) != 0 ? Dp.m9687constructorimpl(0) : f2, (i & 4) != 0 ? Dp.m9687constructorimpl(0) : f3, (i & 8) != 0 ? Dp.m9687constructorimpl(0) : f4, null);
        }
    }

    /* JADX INFO: compiled from: Padding.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValues$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/foundation/layout/PaddingValues;", "getZero$annotations", "getZero", "()Landroidx/compose/foundation/layout/PaddingValues;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final PaddingValues Zero = new Absolute(0.0f, 0.0f, 0.0f, 0.0f, 15, null);

        public static /* synthetic */ void getZero$annotations() {
        }

        private Companion() {
        }

        public final PaddingValues getZero() {
            return Zero;
        }
    }
}
