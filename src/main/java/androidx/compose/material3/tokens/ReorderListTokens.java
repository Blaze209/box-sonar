package androidx.compose.material3.tokens;

import kotlin.Metadata;

/* JADX INFO: compiled from: ReorderListTokens.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001a"}, d2 = {"Landroidx/compose/material3/tokens/ReorderListTokens;", "", "<init>", "()V", "ItemContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getItemContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ItemDropZoneColor", "getItemDropZoneColor", "ItemLabelTextColor", "getItemLabelTextColor", "ItemLeadingIconColor", "getItemLeadingIconColor", "ItemOverlineColor", "getItemOverlineColor", "ItemShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getItemShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ItemSupportingTextColor", "getItemSupportingTextColor", "ItemTrailingIconColor", "getItemTrailingIconColor", "ItemTrailingSupportingTextColor", "getItemTrailingSupportingTextColor", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ReorderListTokens {
    public static final int $stable = 0;
    public static final ReorderListTokens INSTANCE = new ReorderListTokens();
    private static final ColorSchemeKeyTokens ItemContainerColor = ColorSchemeKeyTokens.TertiaryContainer;
    private static final ColorSchemeKeyTokens ItemDropZoneColor = ColorSchemeKeyTokens.SurfaceContainerLow;
    private static final ColorSchemeKeyTokens ItemLabelTextColor = ColorSchemeKeyTokens.OnTertiaryContainer;
    private static final ColorSchemeKeyTokens ItemLeadingIconColor = ColorSchemeKeyTokens.OnTertiaryContainer;
    private static final ColorSchemeKeyTokens ItemOverlineColor = ColorSchemeKeyTokens.OnTertiaryContainer;
    private static final ShapeKeyTokens ItemShape = ShapeKeyTokens.CornerLarge;
    private static final ColorSchemeKeyTokens ItemSupportingTextColor = ColorSchemeKeyTokens.OnTertiaryContainer;
    private static final ColorSchemeKeyTokens ItemTrailingIconColor = ColorSchemeKeyTokens.OnTertiaryContainer;
    private static final ColorSchemeKeyTokens ItemTrailingSupportingTextColor = ColorSchemeKeyTokens.OnTertiaryContainer;

    private ReorderListTokens() {
    }

    public final ColorSchemeKeyTokens getItemContainerColor() {
        return ItemContainerColor;
    }

    public final ColorSchemeKeyTokens getItemDropZoneColor() {
        return ItemDropZoneColor;
    }

    public final ColorSchemeKeyTokens getItemLabelTextColor() {
        return ItemLabelTextColor;
    }

    public final ColorSchemeKeyTokens getItemLeadingIconColor() {
        return ItemLeadingIconColor;
    }

    public final ColorSchemeKeyTokens getItemOverlineColor() {
        return ItemOverlineColor;
    }

    public final ShapeKeyTokens getItemShape() {
        return ItemShape;
    }

    public final ColorSchemeKeyTokens getItemSupportingTextColor() {
        return ItemSupportingTextColor;
    }

    public final ColorSchemeKeyTokens getItemTrailingIconColor() {
        return ItemTrailingIconColor;
    }

    public final ColorSchemeKeyTokens getItemTrailingSupportingTextColor() {
        return ItemTrailingSupportingTextColor;
    }
}
