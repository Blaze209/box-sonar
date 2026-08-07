package androidx.compose.material3.tokens;

import kotlin.Metadata;

/* JADX INFO: compiled from: ExpandedListTokens.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\r¨\u0006\u0018"}, d2 = {"Landroidx/compose/material3/tokens/ExpandedListTokens;", "", "<init>", "()V", "CollapsedItemTrailingIconContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getCollapsedItemTrailingIconContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "CollapsedItemTrailingIconIconColor", "getCollapsedItemTrailingIconIconColor", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ExpandedItemContainerColor", "getExpandedItemContainerColor", "ExpandedItemSegmentedContainerColor", "getExpandedItemSegmentedContainerColor", "ExpandedItemTrailingIconContainerColor", "getExpandedItemTrailingIconContainerColor", "ExpandedItemTrailingIconIconColor", "getExpandedItemTrailingIconIconColor", "TrailingIconShape", "getTrailingIconShape", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExpandedListTokens {
    public static final int $stable = 0;
    public static final ExpandedListTokens INSTANCE = new ExpandedListTokens();
    private static final ColorSchemeKeyTokens CollapsedItemTrailingIconContainerColor = ColorSchemeKeyTokens.Surface;
    private static final ColorSchemeKeyTokens CollapsedItemTrailingIconIconColor = ColorSchemeKeyTokens.OnSurface;
    private static final ShapeKeyTokens ContainerShape = ShapeKeyTokens.CornerLarge;
    private static final ColorSchemeKeyTokens ExpandedItemContainerColor = ColorSchemeKeyTokens.Surface;
    private static final ColorSchemeKeyTokens ExpandedItemSegmentedContainerColor = ColorSchemeKeyTokens.Surface;
    private static final ColorSchemeKeyTokens ExpandedItemTrailingIconContainerColor = ColorSchemeKeyTokens.SurfaceContainer;
    private static final ColorSchemeKeyTokens ExpandedItemTrailingIconIconColor = ColorSchemeKeyTokens.OnSurface;
    private static final ShapeKeyTokens TrailingIconShape = ShapeKeyTokens.CornerFull;

    private ExpandedListTokens() {
    }

    public final ColorSchemeKeyTokens getCollapsedItemTrailingIconContainerColor() {
        return CollapsedItemTrailingIconContainerColor;
    }

    public final ColorSchemeKeyTokens getCollapsedItemTrailingIconIconColor() {
        return CollapsedItemTrailingIconIconColor;
    }

    public final ShapeKeyTokens getContainerShape() {
        return ContainerShape;
    }

    public final ColorSchemeKeyTokens getExpandedItemContainerColor() {
        return ExpandedItemContainerColor;
    }

    public final ColorSchemeKeyTokens getExpandedItemSegmentedContainerColor() {
        return ExpandedItemSegmentedContainerColor;
    }

    public final ColorSchemeKeyTokens getExpandedItemTrailingIconContainerColor() {
        return ExpandedItemTrailingIconContainerColor;
    }

    public final ColorSchemeKeyTokens getExpandedItemTrailingIconIconColor() {
        return ExpandedItemTrailingIconIconColor;
    }

    public final ShapeKeyTokens getTrailingIconShape() {
        return TrailingIconShape;
    }
}
