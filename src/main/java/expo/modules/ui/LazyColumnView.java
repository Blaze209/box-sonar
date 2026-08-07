package expo.modules.ui;

import android.content.Context;
import android.view.View;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.media3.extractor.text.ttml.TtmlNode;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.types.Either;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.ExpoComposeView;
import expo.modules.ui.convertibles.ArrangementKt;
import expo.modules.ui.convertibles.VerticalArrangementCustom;
import expo.modules.ui.convertibles.VerticalArrangementDefault;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LazyColumnView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0011\u0010\u0013\u001a\u00020\u000f*\u00020\u0014H\u0017¢\u0006\u0002\u0010\u0015R\u0014\u0010\t\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lexpo/modules/ui/LazyColumnView;", "Lexpo/modules/kotlin/views/ExpoComposeView;", "Lexpo/modules/ui/LazyColumnProps;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "props", "getProps", "()Lexpo/modules/ui/LazyColumnProps;", "composableChildCount", "Landroidx/compose/runtime/MutableIntState;", "onViewAdded", "", "child", "Landroid/view/View;", "onViewRemoved", "Content", "Lexpo/modules/kotlin/views/ComposableScope;", "(Lexpo/modules/kotlin/views/ComposableScope;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LazyColumnView extends ExpoComposeView<LazyColumnProps> {
    public static final int $stable = ExpoComposeView.$stable;
    private final MutableIntState composableChildCount;
    private final LazyColumnProps props;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$2(LazyColumnView lazyColumnView, ComposableScope composableScope, int i, Composer composer, int i2) {
        lazyColumnView.Content(composableScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyColumnView(Context context, AppContext appContext) {
        super(context, appContext, false, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.props = new LazyColumnProps(null, null, null, null, 15, null);
        this.composableChildCount = SnapshotIntStateKt.mutableIntStateOf(0);
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public LazyColumnProps getProps() {
        return this.props;
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView, android.view.ViewGroup
    public void onViewAdded(View child) {
        super.onViewAdded(child);
        this.composableChildCount.setIntValue(getChildCount());
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView, android.view.ViewGroup
    public void onViewRemoved(View child) {
        super.onViewRemoved(child);
        this.composableChildCount.setIntValue(getChildCount());
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00e6 A[REMOVE] */
    @Override // expo.modules.kotlin.views.ExpoComposeView
    public void Content(final ComposableScope composableScope, Composer composer, final int i) {
        int i2;
        Arrangement.Vertical top;
        Alignment.Horizontal start;
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(360525237);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Content)58@2129L21,71@2570L86,80@2969L301,70@2524L746:LazyColumnView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(composableScope) : composerStartRestartGroup.changedInstance(composableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(this) : composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        int i3 = i2;
        if ((i3 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(360525237, i3, -1, "expo.modules.ui.LazyColumnView.Content (LazyColumnView.kt:57)");
            }
            setRecomposeScope(ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0));
            Either<VerticalArrangementDefault, VerticalArrangementCustom> value = getProps().getVerticalArrangement().getValue();
            if (value == null || (top = ArrangementKt.m14684toComposeArrangement(value)) == null) {
                top = Arrangement.INSTANCE.getTop();
            }
            Arrangement.Vertical vertical = top;
            String value2 = getProps().getHorizontalAlignment().getValue();
            if (value2 == null) {
                start = Alignment.INSTANCE.getStart();
            } else {
                int iHashCode = value2.hashCode();
                if (iHashCode != -1364013995) {
                    if (iHashCode != 100571) {
                        if (iHashCode == 109757538 && value2.equals("start")) {
                            start = Alignment.INSTANCE.getStart();
                        } else {
                            start = Alignment.INSTANCE.getStart();
                        }
                    } else if (value2.equals("end")) {
                        start = Alignment.INSTANCE.getEnd();
                    } else {
                        start = Alignment.INSTANCE.getStart();
                    }
                } else if (value2.equals(TtmlNode.CENTER)) {
                    start = Alignment.INSTANCE.getCenterHorizontally();
                } else {
                    start = Alignment.INSTANCE.getStart();
                }
            }
            Alignment.Horizontal horizontal = start;
            ContentPadding value3 = getProps().getContentPadding().getValue();
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(getProps().getModifiers().getValue(), getAppContext(), composableScope, getGlobalEventDispatcher(), composerStartRestartGroup, (AppContext.$stable << 3) | (ComposableScope.$stable << 6) | ((i3 << 6) & 896));
            PaddingValues paddingValuesM1214PaddingValuesa9UjIt4 = PaddingKt.m1214PaddingValuesa9UjIt4(Dp.m9687constructorimpl(value3 != null ? value3.getStart() : 0), Dp.m9687constructorimpl(value3 != null ? value3.getTop() : 0), Dp.m9687constructorimpl(value3 != null ? value3.getEnd() : 0), Dp.m9687constructorimpl(value3 != null ? value3.getBottom() : 0));
            composerStartRestartGroup.startReplaceGroup(-1633490746);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):LazyColumnView.kt#9igjgp");
            boolean z = ((i3 & 112) == 32 || ((i3 & 64) != 0 && composerStartRestartGroup.changedInstance(this))) | ((i3 & 14) == 4 || ((i3 & 8) != 0 && composerStartRestartGroup.changedInstance(composableScope)));
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.LazyColumnView$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LazyColumnView.Content$lambda$1$lambda$0(this.f$0, composableScope, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            LazyDslKt.LazyColumn(modifierApplyModifiers, null, paddingValuesM1214PaddingValuesa9UjIt4, false, vertical, horizontal, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, 0, 458);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.LazyColumnView$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LazyColumnView.Content$lambda$2(this.f$0, composableScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$1$lambda$0(LazyColumnView lazyColumnView, final ComposableScope composableScope, LazyListScope LazyColumn) {
        LazyListScope lazyListScope;
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        int intValue = lazyColumnView.composableChildCount.getIntValue();
        int i = 0;
        while (i < intValue) {
            View childAt = lazyColumnView.getChildAt(i);
            final ExpoComposeView expoComposeView = childAt instanceof ExpoComposeView ? (ExpoComposeView) childAt : null;
            if (expoComposeView == null) {
                lazyListScope = LazyColumn;
            } else {
                lazyListScope = LazyColumn;
                LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-419189588, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: expo.modules.ui.LazyColumnView$Content$1$1$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                        invoke(lazyItemScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope item, Composer composer, int i2) {
                        Intrinsics.checkNotNullParameter(item, "$this$item");
                        ComposerKt.sourceInformation(composer, "C:LazyColumnView.kt#v15e7d");
                        if ((i2 & 17) == 16 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-419189588, i2, -1, "expo.modules.ui.LazyColumnView.Content.<anonymous>.<anonymous>.<anonymous> (LazyColumnView.kt:85)");
                        }
                        ComposableScope composableScope2 = composableScope;
                        ExpoComposeView<?> expoComposeView2 = expoComposeView;
                        composer.startReplaceGroup(885733247);
                        ComposerKt.sourceInformation(composer, "*87@3211L9");
                        expoComposeView2.Content(composableScope2, composer, ComposableScope.$stable | (ExpoComposeView.$stable << 3));
                        composer.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), 3, null);
            }
            i++;
            LazyColumn = lazyListScope;
        }
        return Unit.INSTANCE;
    }
}
