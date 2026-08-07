package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: ButtonGroup.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u0003*\u00020\u00032\b\b\u0001\u0010\u0002\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H'J\u0016\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\b\b\u0001\u0010\u0002\u001a\u00020\u0004H&J\u0014\u0010\u0007\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0014\u0010\n\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH'JN\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0002\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0006H&¢\u0006\u0002\u0010\u0016J\\\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\u001a2\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0002\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0006H&¢\u0006\u0002\u0010\u001bJ9\u0010\u001c\u001a\u00020\u000e2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\u0002\b\u00142\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000e0\u001a¢\u0006\u0002\b\u0014H&¢\u0006\u0002\u0010 ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006!À\u0006\u0001"}, d2 = {"Landroidx/compose/material3/ButtonGroupScope;", "", "weight", "Landroidx/compose/ui/Modifier;", "", "fill", "", "animateWidth", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "align", "alignment", "Landroidx/compose/ui/Alignment$Vertical;", "clickableItem", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", "label", "", HubsObservability.HUB_ASSET_ICON, "Landroidx/compose/runtime/Composable;", "enabled", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function2;FZ)V", "toggleableItem", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLjava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;FZ)V", "customItem", "buttonGroupContent", "menuContent", "Landroidx/compose/material3/ButtonGroupMenuState;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ButtonGroupScope {
    Modifier align(Modifier modifier, Alignment.Vertical vertical);

    Modifier animateWidth(Modifier modifier, InteractionSource interactionSource);

    void clickableItem(Function0<Unit> onClick, String label, Function2<? super Composer, ? super Integer, Unit> icon, float weight, boolean enabled);

    void customItem(Function2<? super Composer, ? super Integer, Unit> buttonGroupContent, Function3<? super ButtonGroupMenuState, ? super Composer, ? super Integer, Unit> menuContent);

    void toggleableItem(boolean checked, String label, Function1<? super Boolean, Unit> onCheckedChange, Function2<? super Composer, ? super Integer, Unit> icon, float weight, boolean enabled);

    Modifier weight(Modifier modifier, float f);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "For binary compatibility")
    /* synthetic */ Modifier weight(Modifier modifier, float f, boolean z);

    static /* synthetic */ Modifier weight$default(ButtonGroupScope buttonGroupScope, Modifier modifier, float f, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: weight");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return buttonGroupScope.weight(modifier, f, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void clickableItem$default(ButtonGroupScope buttonGroupScope, Function0 function0, String str, Function2 function2, float f, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clickableItem");
        }
        if ((i & 4) != 0) {
            function2 = null;
        }
        Function2 function3 = function2;
        if ((i & 8) != 0) {
            f = Float.NaN;
        }
        float f2 = f;
        if ((i & 16) != 0) {
            z = true;
        }
        buttonGroupScope.clickableItem(function0, str, function3, f2, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void toggleableItem$default(ButtonGroupScope buttonGroupScope, boolean z, String str, Function1 function1, Function2 function2, float f, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toggleableItem");
        }
        if ((i & 8) != 0) {
            function2 = null;
        }
        Function2 function3 = function2;
        if ((i & 16) != 0) {
            f = Float.NaN;
        }
        float f2 = f;
        if ((i & 32) != 0) {
            z2 = true;
        }
        buttonGroupScope.toggleableItem(z, str, function1, function3, f2, z2);
    }
}
