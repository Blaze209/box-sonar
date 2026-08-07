package androidx.compose.material3.tokens;

import kotlin.Metadata;

/* JADX INFO: compiled from: RevealListTokens.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0018\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011¨\u0006\u001a"}, d2 = {"Landroidx/compose/material3/tokens/RevealListTokens;", "", "<init>", "()V", "ItemActionButtonIconIconColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getItemActionButtonIconIconColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ItemActionIconButtonContainerColor", "getItemActionIconButtonContainerColor", "ItemButtonIconIconColor", "getItemButtonIconIconColor", "ItemContainerColor", "getItemContainerColor", "ItemContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getItemContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ItemIconButtonActionContainerShape", "getItemIconButtonActionContainerShape", "ItemIconButtonContainerColor", "getItemIconButtonContainerColor", "ItemIconButtonContainerShape", "getItemIconButtonContainerShape", "ItemSegmentedContainerShape", "getItemSegmentedContainerShape", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RevealListTokens {
    public static final int $stable = 0;
    public static final RevealListTokens INSTANCE = new RevealListTokens();
    private static final ColorSchemeKeyTokens ItemActionButtonIconIconColor = ColorSchemeKeyTokens.OnPrimary;
    private static final ColorSchemeKeyTokens ItemActionIconButtonContainerColor = ColorSchemeKeyTokens.Primary;
    private static final ColorSchemeKeyTokens ItemButtonIconIconColor = ColorSchemeKeyTokens.OnSecondaryContainer;
    private static final ColorSchemeKeyTokens ItemContainerColor = ColorSchemeKeyTokens.Surface;
    private static final ShapeKeyTokens ItemContainerShape = ShapeKeyTokens.CornerLarge;
    private static final ShapeKeyTokens ItemIconButtonActionContainerShape = ShapeKeyTokens.CornerLarge;
    private static final ColorSchemeKeyTokens ItemIconButtonContainerColor = ColorSchemeKeyTokens.SecondaryContainer;
    private static final ShapeKeyTokens ItemIconButtonContainerShape = ShapeKeyTokens.CornerFull;
    private static final ShapeKeyTokens ItemSegmentedContainerShape = ShapeKeyTokens.CornerLarge;

    private RevealListTokens() {
    }

    public final ColorSchemeKeyTokens getItemActionButtonIconIconColor() {
        return ItemActionButtonIconIconColor;
    }

    public final ColorSchemeKeyTokens getItemActionIconButtonContainerColor() {
        return ItemActionIconButtonContainerColor;
    }

    public final ColorSchemeKeyTokens getItemButtonIconIconColor() {
        return ItemButtonIconIconColor;
    }

    public final ColorSchemeKeyTokens getItemContainerColor() {
        return ItemContainerColor;
    }

    public final ShapeKeyTokens getItemContainerShape() {
        return ItemContainerShape;
    }

    public final ShapeKeyTokens getItemIconButtonActionContainerShape() {
        return ItemIconButtonActionContainerShape;
    }

    public final ColorSchemeKeyTokens getItemIconButtonContainerColor() {
        return ItemIconButtonContainerColor;
    }

    public final ShapeKeyTokens getItemIconButtonContainerShape() {
        return ItemIconButtonContainerShape;
    }

    public final ShapeKeyTokens getItemSegmentedContainerShape() {
        return ItemSegmentedContainerShape;
    }
}
