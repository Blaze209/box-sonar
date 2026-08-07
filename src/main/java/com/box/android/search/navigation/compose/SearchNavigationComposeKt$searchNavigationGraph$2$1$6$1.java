package com.box.android.search.navigation.compose;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchNavigationCompose.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class SearchNavigationComposeKt$searchNavigationGraph$2$1$6$1 extends FunctionReferenceImpl implements Function0<Unit> {
    final /* synthetic */ MutableState<String> $aiCenterInitialPrompt$delegate;
    final /* synthetic */ MutableState<String> $aiCenterSessionId$delegate;
    final /* synthetic */ MutableState<Boolean> $isAiCenterLauncherVisible$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchNavigationComposeKt$searchNavigationGraph$2$1$6$1(MutableState<String> mutableState, MutableState<String> mutableState2, MutableState<Boolean> mutableState3) {
        super(0, Intrinsics.Kotlin.class, "dismissAiCenterLauncher", "searchNavigationGraph$lambda$1$0$dismissAiCenterLauncher(Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;)V", 0);
        this.$aiCenterSessionId$delegate = mutableState;
        this.$aiCenterInitialPrompt$delegate = mutableState2;
        this.$isAiCenterLauncherVisible$delegate = mutableState3;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        SearchNavigationComposeKt.searchNavigationGraph$lambda$1$0$dismissAiCenterLauncher(this.$aiCenterSessionId$delegate, this.$aiCenterInitialPrompt$delegate, this.$isAiCenterLauncherVisible$delegate);
    }
}
