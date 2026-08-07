package expo.modules.ui;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.ExpoComposeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: SlotView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u0013\u001a\u00020\u000e*\u00020\u0014H\u0017¢\u0006\u0002\u0010\u0015R\u0014\u0010\t\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lexpo/modules/ui/SlotView;", "Lexpo/modules/kotlin/views/ExpoComposeView;", "Lexpo/modules/ui/SlotProps;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "props", "getProps", "()Lexpo/modules/ui/SlotProps;", "onSlotEvent", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "", "getOnSlotEvent$expo_ui_release", "()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "onSlotEvent$delegate", "Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", "Content", "Lexpo/modules/kotlin/views/ComposableScope;", "(Lexpo/modules/kotlin/views/ComposableScope;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SlotView extends ExpoComposeView<SlotProps> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(SlotView.class, "onSlotEvent", "getOnSlotEvent$expo_ui_release()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0))};
    public static final int $stable = ExpoComposeView.$stable | ViewEventDelegate.$stable;

    /* JADX INFO: renamed from: onSlotEvent$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onSlotEvent;
    private final SlotProps props;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$0(SlotView slotView, ComposableScope composableScope, int i, Composer composer, int i2) {
        slotView.Content(composableScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlotView(Context context, AppContext appContext) {
        super(context, appContext, false, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.props = new SlotProps(null, 1, null);
        this.onSlotEvent = new ViewEventDelegate(this, null);
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public SlotProps getProps() {
        return this.props;
    }

    public final ViewEventCallback<Unit> getOnSlotEvent$expo_ui_release() {
        return this.onSlotEvent.getValue(this, $$delegatedProperties[0]);
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public void Content(final ComposableScope composableScope, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(-985518323);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Content)32@1145L14:SlotView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(composableScope) : composerStartRestartGroup.changedInstance(composableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(this) : composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-985518323, i2, -1, "expo.modules.ui.SlotView.Content (SlotView.kt:31)");
            }
            Children(composableScope, composerStartRestartGroup, ComposableScope.$stable | (i2 & 14) | ((ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3) | (i2 & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SlotView$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SlotView.Content$lambda$0(this.f$0, composableScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
