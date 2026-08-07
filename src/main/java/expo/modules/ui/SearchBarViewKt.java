package expo.modules.ui;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.text.input.TextFieldStateKt;
import androidx.compose.material3.SearchBarKt;
import androidx.compose.material3.SearchBarState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.ExpoComposeView;
import expo.modules.kotlin.views.FunctionalComposableScope;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBarView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\t\u001a\u001d\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0003¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"SearchBarContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/SearchBarProps;", "onSearch", "Lkotlin/Function1;", "Lexpo/modules/ui/GenericEventPayload1;", "", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/SearchBarProps;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ExpandedFullScreenSearchBarView", "composableScope", "Lexpo/modules/kotlin/views/ComposableScope;", "view", "Lexpo/modules/ui/SlotView;", "(Lexpo/modules/kotlin/views/ComposableScope;Lexpo/modules/ui/SlotView;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SearchBarViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpandedFullScreenSearchBarView$lambda$4(ComposableScope composableScope, SlotView slotView, int i, Composer composer, int i2) {
        ExpandedFullScreenSearchBarView(composableScope, slotView, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchBarContent$lambda$1(FunctionalComposableScope functionalComposableScope, SearchBarProps searchBarProps, Function1 function1, int i, Composer composer, int i2) {
        SearchBarContent(functionalComposableScope, searchBarProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SearchBarContent(final FunctionalComposableScope functionalComposableScope, final SearchBarProps props, final Function1<? super GenericEventPayload1<String>, Unit> onSearch, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onSearch, "onSearch");
        Composer composerStartRestartGroup = composer.startRestartGroup(371565385);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SearchBarContent)P(1)21@858L24,22@906L24,25@967L331,38@1401L83,35@1301L187,*46@1737L74,43@1642L169:SearchBarView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onSearch) ? 256 : 128;
        }
        if ((i2 & Token.DOTQUERY) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(371565385, i2, -1, "expo.modules.ui.SearchBarContent (SearchBarView.kt:20)");
            }
            SearchBarState searchBarStateRememberSearchBarState = SearchBarKt.rememberSearchBarState(null, null, null, composerStartRestartGroup, 0, 7);
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-316915073, true, new SearchBarViewKt$SearchBarContent$inputField$1(TextFieldStateKt.m1832rememberTextFieldStateLepunE(null, 0L, composerStartRestartGroup, 0, 3), searchBarStateRememberSearchBarState, onSearch, functionalComposableScope), composerStartRestartGroup, 54);
            SearchBarKt.m4103SearchBarnbWgWpA(searchBarStateRememberSearchBarState, composableLambdaRememberComposableLambda, ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, (AppContext.$stable << 3) | (ComposableScope.$stable << 6)), null, null, 0.0f, 0.0f, composerStartRestartGroup, 48, 120);
            composerStartRestartGroup = composerStartRestartGroup;
            final SlotView slotViewFindChildSlotView = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "expandedFullScreenSearchBar");
            if (slotViewFindChildSlotView != null) {
                SearchBarKt.m4099ExpandedFullScreenSearchBar_UtchM0(searchBarStateRememberSearchBarState, composableLambdaRememberComposableLambda, null, null, null, 0.0f, 0.0f, null, null, ComposableLambdaKt.rememberComposableLambda(-1850969304, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: expo.modules.ui.SearchBarViewKt$SearchBarContent$1$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                        invoke(columnScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ColumnScope ExpandedFullScreenSearchBar, Composer composer2, int i3) {
                        Intrinsics.checkNotNullParameter(ExpandedFullScreenSearchBar, "$this$ExpandedFullScreenSearchBar");
                        ComposerKt.sourceInformation(composer2, "C47@1745L60:SearchBarView.kt#v15e7d");
                        if ((i3 & 17) == 16 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1850969304, i3, -1, "expo.modules.ui.SearchBarContent.<anonymous>.<anonymous> (SearchBarView.kt:47)");
                        }
                        SearchBarViewKt.ExpandedFullScreenSearchBarView(new ComposableScope(null, null, null, null, 15, null), slotViewFindChildSlotView, composer2, ComposableScope.$stable | ((ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 508);
                composerStartRestartGroup = composerStartRestartGroup;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SearchBarViewKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchBarViewKt.SearchBarContent$lambda$1(functionalComposableScope, props, onSearch, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ExpandedFullScreenSearchBarView(final ComposableScope composableScope, final SlotView slotView, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-520515525);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExpandedFullScreenSearchBarView):SearchBarView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(composableScope) : composerStartRestartGroup.changedInstance(composableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(slotView) : composerStartRestartGroup.changedInstance(slotView) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-520515525, i2, -1, "expo.modules.ui.ExpandedFullScreenSearchBarView (SearchBarView.kt:53)");
            }
            composerStartRestartGroup.startReplaceGroup(-1999208739);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*56@1976L9");
            slotView.Content(composableScope, composerStartRestartGroup, ComposableScope.$stable | ((ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3));
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SearchBarViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchBarViewKt.ExpandedFullScreenSearchBarView$lambda$4(composableScope, slotView, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
