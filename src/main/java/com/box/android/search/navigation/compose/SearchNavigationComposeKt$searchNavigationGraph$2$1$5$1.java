package com.box.android.search.navigation.compose;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchNavigationCompose.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class SearchNavigationComposeKt$searchNavigationGraph$2$1$5$1 extends FunctionReferenceImpl implements Function2<String, String, Unit> {
    final /* synthetic */ MutableState<String> $aiCenterInitialPrompt$delegate;
    final /* synthetic */ MutableState<String> $aiCenterSessionId$delegate;
    final /* synthetic */ MutableState<Boolean> $isAiCenterLauncherVisible$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchNavigationComposeKt$searchNavigationGraph$2$1$5$1(MutableState<Boolean> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3) {
        super(2, Intrinsics.Kotlin.class, "showAiCenterLauncher", "searchNavigationGraph$lambda$1$0$showAiCenterLauncher(Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Ljava/lang/String;Ljava/lang/String;)V", 0);
        this.$isAiCenterLauncherVisible$delegate = mutableState;
        this.$aiCenterSessionId$delegate = mutableState2;
        this.$aiCenterInitialPrompt$delegate = mutableState3;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
        invoke2(str, str2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, String str2) {
        SearchNavigationComposeKt.searchNavigationGraph$lambda$1$0$showAiCenterLauncher(this.$isAiCenterLauncherVisible$delegate, this.$aiCenterSessionId$delegate, this.$aiCenterInitialPrompt$delegate, str, str2);
    }
}
