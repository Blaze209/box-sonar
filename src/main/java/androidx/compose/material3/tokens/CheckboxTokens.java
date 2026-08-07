package androidx.compose.material3.tokens;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: CheckboxTokens.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b#\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\u000bR\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0015\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u0018X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u0013\u0010\u001a\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u001b\u0010\u000bR\u0011\u0010\u001c\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0010R\u0011\u0010\u001e\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0010R\u0011\u0010 \u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0010R\u0011\u0010\"\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0010R\u0011\u0010$\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0010R\u0011\u0010&\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0010R\u0011\u0010(\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0010R\u0011\u0010*\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0010R\u0011\u0010,\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0010R\u0011\u0010.\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0010R\u0011\u00100\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0010R\u0013\u00102\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b3\u0010\u000bR\u0011\u00104\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0010R\u0011\u00106\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0010R\u0013\u00108\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b9\u0010\u000bR\u0011\u0010:\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0010R\u0013\u0010<\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b=\u0010\u000bR\u0011\u0010>\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0010R\u0011\u0010@\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0010R\u0013\u0010B\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\bC\u0010\u000bR\u0011\u0010D\u001a\u00020E¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0013\u0010H\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\bI\u0010\u000bR\u0014\u0010J\u001a\u00020\u0018X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u000bR\u0011\u0010L\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u0010R\u0013\u0010N\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\bO\u0010\u000bR\u0011\u0010P\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0010R\u0011\u0010R\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u0010R\u0011\u0010T\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u0010R\u0011\u0010V\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bW\u0010\u0010R\u0011\u0010X\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bY\u0010\u0010R\u0013\u0010Z\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b[\u0010\u000bR\u0011\u0010\\\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\u0010R\u0013\u0010^\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b_\u0010\u000bR\u0011\u0010`\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\u0010R\u0013\u0010b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\bc\u0010\u000bR\u0011\u0010d\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\be\u0010\u0010R\u0013\u0010f\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\bg\u0010\u000b¨\u0006h"}, d2 = {"Landroidx/compose/material3/tokens/CheckboxTokens;", "", "<init>", "()V", "ContainerShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "getContainerShape", "()Landroidx/compose/foundation/shape/RoundedCornerShape;", "ContainerSize", "Landroidx/compose/ui/unit/Dp;", "getContainerSize-D9Ej5fM", "()F", "F", "FocusIndicatorColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getFocusIndicatorColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "IconSize", "getIconSize-D9Ej5fM", "SelectedContainerColor", "getSelectedContainerColor", "SelectedDisabledContainerColor", "getSelectedDisabledContainerColor", "SelectedDisabledContainerOpacity", "", "getSelectedDisabledContainerOpacity", "SelectedDisabledContainerOutlineWidth", "getSelectedDisabledContainerOutlineWidth-D9Ej5fM", "SelectedDisabledIconColor", "getSelectedDisabledIconColor", "SelectedErrorContainerColor", "getSelectedErrorContainerColor", "SelectedErrorFocusContainerColor", "getSelectedErrorFocusContainerColor", "SelectedErrorFocusIconColor", "getSelectedErrorFocusIconColor", "SelectedErrorHoverContainerColor", "getSelectedErrorHoverContainerColor", "SelectedErrorHoverIconColor", "getSelectedErrorHoverIconColor", "SelectedErrorIconColor", "getSelectedErrorIconColor", "SelectedErrorPressedContainerColor", "getSelectedErrorPressedContainerColor", "SelectedErrorPressedIconColor", "getSelectedErrorPressedIconColor", "SelectedFocusContainerColor", "getSelectedFocusContainerColor", "SelectedFocusIconColor", "getSelectedFocusIconColor", "SelectedFocusOutlineWidth", "getSelectedFocusOutlineWidth-D9Ej5fM", "SelectedHoverContainerColor", "getSelectedHoverContainerColor", "SelectedHoverIconColor", "getSelectedHoverIconColor", "SelectedHoverOutlineWidth", "getSelectedHoverOutlineWidth-D9Ej5fM", "SelectedIconColor", "getSelectedIconColor", "SelectedOutlineWidth", "getSelectedOutlineWidth-D9Ej5fM", "SelectedPressedContainerColor", "getSelectedPressedContainerColor", "SelectedPressedIconColor", "getSelectedPressedIconColor", "SelectedPressedOutlineWidth", "getSelectedPressedOutlineWidth-D9Ej5fM", "StateLayerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getStateLayerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "StateLayerSize", "getStateLayerSize-D9Ej5fM", "UnselectedDisabledContainerOpacity", "getUnselectedDisabledContainerOpacity", "UnselectedDisabledOutlineColor", "getUnselectedDisabledOutlineColor", "UnselectedDisabledOutlineWidth", "getUnselectedDisabledOutlineWidth-D9Ej5fM", "UnselectedErrorFocusOutlineColor", "getUnselectedErrorFocusOutlineColor", "UnselectedErrorHoverOutlineColor", "getUnselectedErrorHoverOutlineColor", "UnselectedErrorOutlineColor", "getUnselectedErrorOutlineColor", "UnselectedErrorPressedOutlineColor", "getUnselectedErrorPressedOutlineColor", "UnselectedFocusOutlineColor", "getUnselectedFocusOutlineColor", "UnselectedFocusOutlineWidth", "getUnselectedFocusOutlineWidth-D9Ej5fM", "UnselectedHoverOutlineColor", "getUnselectedHoverOutlineColor", "UnselectedHoverOutlineWidth", "getUnselectedHoverOutlineWidth-D9Ej5fM", "UnselectedOutlineColor", "getUnselectedOutlineColor", "UnselectedOutlineWidth", "getUnselectedOutlineWidth-D9Ej5fM", "UnselectedPressedOutlineColor", "getUnselectedPressedOutlineColor", "UnselectedPressedOutlineWidth", "getUnselectedPressedOutlineWidth-D9Ej5fM", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CheckboxTokens {
    public static final int $stable = 0;
    private static final RoundedCornerShape ContainerShape;
    private static final float ContainerSize;
    private static final float IconSize;
    private static final float SelectedDisabledContainerOutlineWidth;
    private static final float SelectedFocusOutlineWidth;
    private static final float SelectedHoverOutlineWidth;
    private static final float SelectedOutlineWidth;
    private static final float SelectedPressedOutlineWidth;
    private static final float UnselectedDisabledOutlineWidth;
    private static final float UnselectedFocusOutlineWidth;
    private static final float UnselectedHoverOutlineWidth;
    private static final float UnselectedOutlineWidth;
    private static final float UnselectedPressedOutlineWidth;
    public static final CheckboxTokens INSTANCE = new CheckboxTokens();
    private static final ColorSchemeKeyTokens FocusIndicatorColor = ColorSchemeKeyTokens.Secondary;
    private static final ColorSchemeKeyTokens SelectedContainerColor = ColorSchemeKeyTokens.Primary;
    private static final ColorSchemeKeyTokens SelectedDisabledContainerColor = ColorSchemeKeyTokens.OnSurface;
    private static final float SelectedDisabledContainerOpacity = 0.38f;
    private static final ColorSchemeKeyTokens SelectedDisabledIconColor = ColorSchemeKeyTokens.Surface;
    private static final ColorSchemeKeyTokens SelectedErrorContainerColor = ColorSchemeKeyTokens.Error;
    private static final ColorSchemeKeyTokens SelectedErrorFocusContainerColor = ColorSchemeKeyTokens.Error;
    private static final ColorSchemeKeyTokens SelectedErrorFocusIconColor = ColorSchemeKeyTokens.OnError;
    private static final ColorSchemeKeyTokens SelectedErrorHoverContainerColor = ColorSchemeKeyTokens.Error;
    private static final ColorSchemeKeyTokens SelectedErrorHoverIconColor = ColorSchemeKeyTokens.OnError;
    private static final ColorSchemeKeyTokens SelectedErrorIconColor = ColorSchemeKeyTokens.OnError;
    private static final ColorSchemeKeyTokens SelectedErrorPressedContainerColor = ColorSchemeKeyTokens.Error;
    private static final ColorSchemeKeyTokens SelectedErrorPressedIconColor = ColorSchemeKeyTokens.OnError;
    private static final ColorSchemeKeyTokens SelectedFocusContainerColor = ColorSchemeKeyTokens.Primary;
    private static final ColorSchemeKeyTokens SelectedFocusIconColor = ColorSchemeKeyTokens.OnPrimary;
    private static final ColorSchemeKeyTokens SelectedHoverContainerColor = ColorSchemeKeyTokens.Primary;
    private static final ColorSchemeKeyTokens SelectedHoverIconColor = ColorSchemeKeyTokens.OnPrimary;
    private static final ColorSchemeKeyTokens SelectedIconColor = ColorSchemeKeyTokens.OnPrimary;
    private static final ColorSchemeKeyTokens SelectedPressedContainerColor = ColorSchemeKeyTokens.Primary;
    private static final ColorSchemeKeyTokens SelectedPressedIconColor = ColorSchemeKeyTokens.OnPrimary;
    private static final ShapeKeyTokens StateLayerShape = ShapeKeyTokens.CornerFull;
    private static final float StateLayerSize = Dp.m9687constructorimpl((float) 40.0d);
    private static final float UnselectedDisabledContainerOpacity = 0.38f;
    private static final ColorSchemeKeyTokens UnselectedDisabledOutlineColor = ColorSchemeKeyTokens.OnSurface;
    private static final ColorSchemeKeyTokens UnselectedErrorFocusOutlineColor = ColorSchemeKeyTokens.Error;
    private static final ColorSchemeKeyTokens UnselectedErrorHoverOutlineColor = ColorSchemeKeyTokens.Error;
    private static final ColorSchemeKeyTokens UnselectedErrorOutlineColor = ColorSchemeKeyTokens.Error;
    private static final ColorSchemeKeyTokens UnselectedErrorPressedOutlineColor = ColorSchemeKeyTokens.Error;
    private static final ColorSchemeKeyTokens UnselectedFocusOutlineColor = ColorSchemeKeyTokens.OnSurface;
    private static final ColorSchemeKeyTokens UnselectedHoverOutlineColor = ColorSchemeKeyTokens.OnSurface;
    private static final ColorSchemeKeyTokens UnselectedOutlineColor = ColorSchemeKeyTokens.OnSurfaceVariant;
    private static final ColorSchemeKeyTokens UnselectedPressedOutlineColor = ColorSchemeKeyTokens.OnSurface;

    private CheckboxTokens() {
    }

    public final RoundedCornerShape getContainerShape() {
        return ContainerShape;
    }

    /* JADX INFO: renamed from: getContainerSize-D9Ej5fM, reason: not valid java name */
    public final float m5193getContainerSizeD9Ej5fM() {
        return ContainerSize;
    }

    public final ColorSchemeKeyTokens getFocusIndicatorColor() {
        return FocusIndicatorColor;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m5194getIconSizeD9Ej5fM() {
        return IconSize;
    }

    public final ColorSchemeKeyTokens getSelectedContainerColor() {
        return SelectedContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectedDisabledContainerColor() {
        return SelectedDisabledContainerColor;
    }

    public final float getSelectedDisabledContainerOpacity() {
        return SelectedDisabledContainerOpacity;
    }

    /* JADX INFO: renamed from: getSelectedDisabledContainerOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m5195getSelectedDisabledContainerOutlineWidthD9Ej5fM() {
        return SelectedDisabledContainerOutlineWidth;
    }

    public final ColorSchemeKeyTokens getSelectedDisabledIconColor() {
        return SelectedDisabledIconColor;
    }

    public final ColorSchemeKeyTokens getSelectedErrorContainerColor() {
        return SelectedErrorContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectedErrorFocusContainerColor() {
        return SelectedErrorFocusContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectedErrorFocusIconColor() {
        return SelectedErrorFocusIconColor;
    }

    public final ColorSchemeKeyTokens getSelectedErrorHoverContainerColor() {
        return SelectedErrorHoverContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectedErrorHoverIconColor() {
        return SelectedErrorHoverIconColor;
    }

    public final ColorSchemeKeyTokens getSelectedErrorIconColor() {
        return SelectedErrorIconColor;
    }

    public final ColorSchemeKeyTokens getSelectedErrorPressedContainerColor() {
        return SelectedErrorPressedContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectedErrorPressedIconColor() {
        return SelectedErrorPressedIconColor;
    }

    public final ColorSchemeKeyTokens getSelectedFocusContainerColor() {
        return SelectedFocusContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectedFocusIconColor() {
        return SelectedFocusIconColor;
    }

    /* JADX INFO: renamed from: getSelectedFocusOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m5196getSelectedFocusOutlineWidthD9Ej5fM() {
        return SelectedFocusOutlineWidth;
    }

    public final ColorSchemeKeyTokens getSelectedHoverContainerColor() {
        return SelectedHoverContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectedHoverIconColor() {
        return SelectedHoverIconColor;
    }

    /* JADX INFO: renamed from: getSelectedHoverOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m5197getSelectedHoverOutlineWidthD9Ej5fM() {
        return SelectedHoverOutlineWidth;
    }

    public final ColorSchemeKeyTokens getSelectedIconColor() {
        return SelectedIconColor;
    }

    /* JADX INFO: renamed from: getSelectedOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m5198getSelectedOutlineWidthD9Ej5fM() {
        return SelectedOutlineWidth;
    }

    public final ColorSchemeKeyTokens getSelectedPressedContainerColor() {
        return SelectedPressedContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectedPressedIconColor() {
        return SelectedPressedIconColor;
    }

    /* JADX INFO: renamed from: getSelectedPressedOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m5199getSelectedPressedOutlineWidthD9Ej5fM() {
        return SelectedPressedOutlineWidth;
    }

    public final ShapeKeyTokens getStateLayerShape() {
        return StateLayerShape;
    }

    /* JADX INFO: renamed from: getStateLayerSize-D9Ej5fM, reason: not valid java name */
    public final float m5200getStateLayerSizeD9Ej5fM() {
        return StateLayerSize;
    }

    public final float getUnselectedDisabledContainerOpacity() {
        return UnselectedDisabledContainerOpacity;
    }

    public final ColorSchemeKeyTokens getUnselectedDisabledOutlineColor() {
        return UnselectedDisabledOutlineColor;
    }

    /* JADX INFO: renamed from: getUnselectedDisabledOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m5201getUnselectedDisabledOutlineWidthD9Ej5fM() {
        return UnselectedDisabledOutlineWidth;
    }

    public final ColorSchemeKeyTokens getUnselectedErrorFocusOutlineColor() {
        return UnselectedErrorFocusOutlineColor;
    }

    public final ColorSchemeKeyTokens getUnselectedErrorHoverOutlineColor() {
        return UnselectedErrorHoverOutlineColor;
    }

    public final ColorSchemeKeyTokens getUnselectedErrorOutlineColor() {
        return UnselectedErrorOutlineColor;
    }

    public final ColorSchemeKeyTokens getUnselectedErrorPressedOutlineColor() {
        return UnselectedErrorPressedOutlineColor;
    }

    public final ColorSchemeKeyTokens getUnselectedFocusOutlineColor() {
        return UnselectedFocusOutlineColor;
    }

    /* JADX INFO: renamed from: getUnselectedFocusOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m5202getUnselectedFocusOutlineWidthD9Ej5fM() {
        return UnselectedFocusOutlineWidth;
    }

    public final ColorSchemeKeyTokens getUnselectedHoverOutlineColor() {
        return UnselectedHoverOutlineColor;
    }

    /* JADX INFO: renamed from: getUnselectedHoverOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m5203getUnselectedHoverOutlineWidthD9Ej5fM() {
        return UnselectedHoverOutlineWidth;
    }

    public final ColorSchemeKeyTokens getUnselectedOutlineColor() {
        return UnselectedOutlineColor;
    }

    /* JADX INFO: renamed from: getUnselectedOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m5204getUnselectedOutlineWidthD9Ej5fM() {
        return UnselectedOutlineWidth;
    }

    public final ColorSchemeKeyTokens getUnselectedPressedOutlineColor() {
        return UnselectedPressedOutlineColor;
    }

    /* JADX INFO: renamed from: getUnselectedPressedOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m5205getUnselectedPressedOutlineWidthD9Ej5fM() {
        return UnselectedPressedOutlineWidth;
    }

    static {
        float f = (float) 2.0d;
        ContainerShape = RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f));
        float f2 = (float) 18.0d;
        ContainerSize = Dp.m9687constructorimpl(f2);
        IconSize = Dp.m9687constructorimpl(f2);
        float f3 = (float) 0.0d;
        SelectedDisabledContainerOutlineWidth = Dp.m9687constructorimpl(f3);
        SelectedFocusOutlineWidth = Dp.m9687constructorimpl(f3);
        SelectedHoverOutlineWidth = Dp.m9687constructorimpl(f3);
        SelectedOutlineWidth = Dp.m9687constructorimpl(f3);
        SelectedPressedOutlineWidth = Dp.m9687constructorimpl(f3);
        UnselectedDisabledOutlineWidth = Dp.m9687constructorimpl(f);
        UnselectedFocusOutlineWidth = Dp.m9687constructorimpl(f);
        UnselectedHoverOutlineWidth = Dp.m9687constructorimpl(f);
        UnselectedOutlineWidth = Dp.m9687constructorimpl(f);
        UnselectedPressedOutlineWidth = Dp.m9687constructorimpl(f);
    }
}
