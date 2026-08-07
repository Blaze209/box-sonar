package com.pspdfkit.ui.toolbar.grouping.presets;

import android.content.Context;
import com.pspdfkit.internal.n;
import java.util.EnumSet;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u0004\u0010\tJ'\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0001\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/pspdfkit/ui/toolbar/grouping/presets/AnnotationCreationToolbarGroupingRule;", "Lcom/pspdfkit/ui/toolbar/grouping/presets/PresetMenuItemGroupingRule;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Ljava/util/EnumSet;", "Lcom/pspdfkit/internal/n;", "adaptiveFeatures", "(Landroid/content/Context;Ljava/util/EnumSet;)V", "", "capacity", "itemsCount", "", "Lcom/pspdfkit/ui/toolbar/grouping/presets/MenuItem;", "getGroupPreset", "(II)Ljava/util/List;", "", "areGeneratedGroupItemsSelectable", "()Z", "Ljava/util/EnumSet;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AnnotationCreationToolbarGroupingRule extends PresetMenuItemGroupingRule {
    public static final int $stable = 8;
    private final EnumSet<n> adaptiveFeatures;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnotationCreationToolbarGroupingRule(Context context) {
        super(context);
        context.getClass();
        EnumSet<n> enumSetNoneOf = EnumSet.noneOf(n.class);
        enumSetNoneOf.getClass();
        this.adaptiveFeatures = enumSetNoneOf;
    }

    @Override // com.pspdfkit.ui.toolbar.grouping.DefaultMenuItemGroupingRule, com.pspdfkit.ui.toolbar.grouping.MenuItemGroupingRule
    public boolean areGeneratedGroupItemsSelectable() {
        return true;
    }

    @Override // com.pspdfkit.ui.toolbar.grouping.presets.PresetMenuItemGroupingRule
    public List<MenuItem> getGroupPreset(int capacity, int itemsCount) {
        if (capacity >= 4) {
            return AnnotationCreationToolbarItemPresets.getPreset(capacity, this.adaptiveFeatures);
        }
        throw new IllegalArgumentException("Capacity must be at least 4");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnotationCreationToolbarGroupingRule(Context context, EnumSet<n> enumSet) {
        super(context);
        context.getClass();
        enumSet.getClass();
        this.adaptiveFeatures = enumSet;
    }
}
