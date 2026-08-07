package com.box.android.preview.preview.previewbar.topbar;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.box.android.cpl.Store;
import com.box.android.preview.preview.PreviewReducer;
import com.box.android.preview.preview.PreviewReducerScopingKt;
import com.box.android.preview.previewtype.document.search.ui.DocumentSearchTopBarKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewTopBar.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class PreviewTopBarKt$PreviewTopBar$1$4 implements Function4<AnimatedContentScope, Boolean, Composer, Integer, Unit> {
    final /* synthetic */ Transition<Boolean> $renameTransition;
    final /* synthetic */ State<PreviewReducer.State> $state$delegate;
    final /* synthetic */ Store<PreviewReducer.State, PreviewReducer.Action> $store;

    PreviewTopBarKt$PreviewTopBar$1$4(Store<PreviewReducer.State, PreviewReducer.Action> store, Transition<Boolean> transition, State<PreviewReducer.State> state) {
        this.$store = store;
        this.$renameTransition = transition;
        this.$state$delegate = state;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, Boolean bool, Composer composer, Integer num) {
        invoke(animatedContentScope, bool.booleanValue(), composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedContentScope AnimatedContent, boolean z, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
        ComposerKt.sourceInformation(composer, "CN(isSearching):PreviewTopBar.kt#l0df2e");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1619529431, i, -1, "com.box.android.preview.preview.previewbar.topbar.PreviewTopBar.<anonymous>.<anonymous> (PreviewTopBar.kt:122)");
        }
        if (!z || !PreviewTopBarKt.PreviewTopBar$lambda$0(this.$state$delegate).getIsSearching()) {
            if (!z && PreviewTopBarKt.PreviewTopBar$lambda$0(this.$state$delegate).getTopBarState().isFileDetailsShown()) {
                composer.startReplaceGroup(-2033007978);
                ComposerKt.sourceInformation(composer, "128@6510L163");
                PreviewTopBarKt.PreviewTopBarTitle(this.$renameTransition, PreviewTopBarKt.PreviewTopBar$lambda$0(this.$state$delegate), this.$store, composer, 0);
            } else {
                composer.startReplaceGroup(-2039455079);
            }
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-2033252413);
            ComposerKt.sourceInformation(composer, "123@6264L150");
            DocumentSearchTopBarKt.PreviewSearchTopBar(PreviewReducerScopingKt.searchScope(this.$store), PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(48), 0.0f, 0.0f, 0.0f, 14, null), composer, 48, 0);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
