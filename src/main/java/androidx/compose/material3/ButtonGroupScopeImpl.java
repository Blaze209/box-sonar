package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.facebook.react.modules.dialog.AlertFragment;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ButtonGroup.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007JH\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0016¢\u0006\u0002\b\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0016¢\u0006\u0002\u0010\u001eJV\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00140\"2\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0016¢\u0006\u0002\b\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0016¢\u0006\u0002\u0010#J9\u0010$\u001a\u00020\u00142\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\u0002\b\u001a2\u0017\u0010&\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00140\"¢\u0006\u0002\b\u001aH\u0016¢\u0006\u0002\u0010(J\u001c\u0010\u001b\u001a\u00020)*\u00020)2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u001dH\u0017J\u0014\u0010\u001b\u001a\u00020)*\u00020)2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0014\u0010+\u001a\u00020)*\u00020)2\u0006\u0010,\u001a\u00020-H\u0016J\u0014\u0010.\u001a\u00020)*\u00020)2\u0006\u0010/\u001a\u000200H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u00061"}, d2 = {"Landroidx/compose/material3/ButtonGroupScopeImpl;", "Landroidx/compose/material3/ButtonGroupScope;", "Landroidx/compose/material3/ButtonGroupItemProvider;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(Landroidx/compose/animation/core/AnimationSpec;)V", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", AlertFragment.ARG_ITEMS, "", "Landroidx/compose/material3/ButtonGroupItem;", "getItems", "()Ljava/util/List;", "itemsCount", "", "getItemsCount", "()I", "clickableItem", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", "label", "", HubsObservability.HUB_ASSET_ICON, "Landroidx/compose/runtime/Composable;", "weight", "enabled", "", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function2;FZ)V", "toggleableItem", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLjava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;FZ)V", "customItem", "buttonGroupContent", "menuContent", "Landroidx/compose/material3/ButtonGroupMenuState;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)V", "Landroidx/compose/ui/Modifier;", "fill", "animateWidth", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "align", "alignment", "Landroidx/compose/ui/Alignment$Vertical;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ButtonGroupScopeImpl implements ButtonGroupScope, ButtonGroupItemProvider {
    private final AnimationSpec<Float> animationSpec;
    private final List<ButtonGroupItem> items = new ArrayList();

    public ButtonGroupScopeImpl(AnimationSpec<Float> animationSpec) {
        this.animationSpec = animationSpec;
    }

    public final AnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    @Override // androidx.compose.material3.ButtonGroupItemProvider
    public List<ButtonGroupItem> getItems() {
        return this.items;
    }

    @Override // androidx.compose.material3.ButtonGroupItemProvider
    public int getItemsCount() {
        return getItems().size();
    }

    @Override // androidx.compose.material3.ButtonGroupScope
    public void clickableItem(Function0<Unit> onClick, String label, Function2<? super Composer, ? super Integer, Unit> icon, float weight, boolean enabled) {
        if (weight <= 0.0d && !Float.isNaN(weight)) {
            throw new IllegalArgumentException(("invalid weight " + weight + "; must be greater than zero or Float.NaN").toString());
        }
        getItems().add(new ClickableButtonGroupItem(onClick, icon, weight, this.animationSpec, enabled, label));
    }

    @Override // androidx.compose.material3.ButtonGroupScope
    public void toggleableItem(boolean checked, String label, Function1<? super Boolean, Unit> onCheckedChange, Function2<? super Composer, ? super Integer, Unit> icon, float weight, boolean enabled) {
        if (weight <= 0.0d && !Float.isNaN(weight)) {
            throw new IllegalArgumentException(("invalid weight " + weight + "; must be greater than zero or Float.NaN").toString());
        }
        getItems().add(new ToggleableButtonGroupItem(checked, onCheckedChange, weight, this.animationSpec, icon, enabled, label));
    }

    @Override // androidx.compose.material3.ButtonGroupScope
    public void customItem(Function2<? super Composer, ? super Integer, Unit> buttonGroupContent, Function3<? super ButtonGroupMenuState, ? super Composer, ? super Integer, Unit> menuContent) {
        getItems().add(new CustomButtonGroupItem(buttonGroupContent, menuContent));
    }

    @Override // androidx.compose.material3.ButtonGroupScope
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public /* synthetic */ Modifier weight(Modifier modifier, float f, boolean z) {
        return weight(modifier, f);
    }

    @Override // androidx.compose.material3.ButtonGroupScope
    public Modifier weight(Modifier modifier, float f) {
        if (f <= 0.0d) {
            throw new IllegalArgumentException(("invalid weight " + f + "; must be greater than zero").toString());
        }
        return modifier.then(new ButtonGroupElement(RangesKt.coerceAtMost(f, Float.MAX_VALUE)));
    }

    @Override // androidx.compose.material3.ButtonGroupScope
    public Modifier animateWidth(Modifier modifier, InteractionSource interactionSource) {
        return modifier.then(new EnlargeOnPressElement(interactionSource, this.animationSpec));
    }

    @Override // androidx.compose.material3.ButtonGroupScope
    public Modifier align(Modifier modifier, Alignment.Vertical vertical) {
        return modifier.then(new VerticalAlignElement(vertical));
    }
}
