package com.box.android.boxai.homescreen;

import androidx.compose.runtime.MutableState;
import com.box.brownfieldApi.featuresNavigator.PreviewRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiHomeScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class BoxAiHomeScreenKt$BoxAiHomeScreen$5$showPreview$1$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    final /* synthetic */ MutableState<PreviewRequest> $activePreviewRequest$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BoxAiHomeScreenKt$BoxAiHomeScreen$5$showPreview$1$1$1(MutableState<PreviewRequest> mutableState) {
        super(0, Intrinsics.Kotlin.class, "dismissActivePreviewRequest", "BoxAiHomeScreen$lambda$7$dismissActivePreviewRequest(Landroidx/compose/runtime/MutableState;)V", 0);
        this.$activePreviewRequest$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$dismissActivePreviewRequest(this.$activePreviewRequest$delegate);
    }
}
