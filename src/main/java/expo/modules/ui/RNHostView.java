package expo.modules.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.ExpoComposeView;
import expo.modules.kotlin.views.RNHostViewInterface;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RNHostView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u0015\u001a\u00020\u0016*\u00020\u0017H\u0017¢\u0006\u0002\u0010\u0018J \u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dH\u0014J0\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u001dH\u0014R\u0014\u0010\n\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\u000e8VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lexpo/modules/ui/RNHostView;", "Lexpo/modules/kotlin/views/ExpoComposeView;", "Lexpo/modules/ui/RNHostProps;", "Lexpo/modules/kotlin/views/RNHostViewInterface;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "props", "getProps", "()Lexpo/modules/ui/RNHostProps;", "matchContents", "", "getMatchContents", "()Z", "setMatchContents", "(Z)V", TtmlNode.RUBY_CONTAINER, "Lexpo/modules/ui/RNHostContainerView;", "Content", "", "Lexpo/modules/kotlin/views/ComposableScope;", "(Lexpo/modules/kotlin/views/ComposableScope;Landroidx/compose/runtime/Composer;I)V", "addView", "child", "Landroid/view/View;", FirebaseAnalytics.Param.INDEX, "", SerializedNames.PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "left", ViewProps.TOP, "right", ViewProps.BOTTOM, "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RNHostView extends ExpoComposeView<RNHostProps> implements RNHostViewInterface {
    public static final int $stable = 8;
    private final RNHostContainerView container;
    private boolean matchContents;
    private final RNHostProps props;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$2(RNHostView rNHostView, ComposableScope composableScope, int i, Composer composer, int i2) {
        rNHostView.Content(composableScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RNHostView(Context context, AppContext appContext) {
        super(context, appContext, false, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.props = new RNHostProps(null, null, null, 7, null);
        this.container = new RNHostContainerView(context, new WeakReference(getShadowNodeProxy()));
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public RNHostProps getProps() {
        return this.props;
    }

    @Override // expo.modules.kotlin.views.RNHostViewInterface
    public void setMatchContents(boolean z) {
        this.matchContents = z;
    }

    @Override // expo.modules.kotlin.views.RNHostViewInterface
    public boolean getMatchContents() {
        Boolean value = getProps().getMatchContents().getValue();
        if (value != null) {
            return value.booleanValue();
        }
        return false;
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public void Content(ComposableScope composableScope, Composer composer, final int i) {
        int i2;
        final ComposableScope composableScope2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1802934975);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Content)43@1694L27,46@1757L74,42@1665L283:RNHostView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(composableScope) : composerStartRestartGroup.changedInstance(composableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1802934975, i2, -1, "expo.modules.ui.RNHostView.Content (RNHostView.kt:38)");
            }
            Boolean boolComponent1 = getProps().getVerticalScrollEnabled().component1();
            List<Map<String, Object>> listComponent1 = getProps().getModifiers().component1();
            composerStartRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):RNHostView.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(this);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.RNHostView$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RNHostView.Content$lambda$1$lambda$0(this.f$0, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(listComponent1, getAppContext(), composableScope, getGlobalEventDispatcher(), composerStartRestartGroup, ((i2 << 6) & 896) | (AppContext.$stable << 3) | (ComposableScope.$stable << 6));
            composableScope2 = composableScope;
            composerStartRestartGroup.startReplaceGroup(-1748679680);
            ComposerKt.sourceInformation(composerStartRestartGroup, "47@1905L21");
            Modifier.Companion companionVerticalScroll$default = Intrinsics.areEqual((Object) boolComponent1, (Object) true) ? ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null) : Modifier.INSTANCE;
            composerStartRestartGroup.endReplaceGroup();
            AndroidView_androidKt.AndroidView(function1, modifierApplyModifiers.then(companionVerticalScroll$default), null, composerStartRestartGroup, 0, 4);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composableScope2 = composableScope;
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.RNHostView$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RNHostView.Content$lambda$2(this.f$0, composableScope2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RNHostContainerView Content$lambda$1$lambda$0(RNHostView rNHostView, Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return rNHostView.container;
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView, android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(params, "params");
        this.container.addView(child, index, params);
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView, android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.container.measure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView, android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        this.container.layout(paddingLeft, paddingRight, getWidth() + paddingLeft, getHeight() + paddingRight);
    }
}
