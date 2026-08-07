package com.pspdfkit.jetpack.compose.components;

import androidx.compose.runtime.MutableState;
import com.pspdfkit.jetpack.compose.interactors.DocumentState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.pspdfkit.jetpack.compose.components.MainToolbarKt$MainToolbar$1$1", f = "MainToolbar.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
public final class MainToolbarKt$MainToolbar$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $coroutine;
    final /* synthetic */ DocumentState $documentState;
    final /* synthetic */ MutableState<Boolean> $expanded$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainToolbarKt$MainToolbar$1$1(DocumentState documentState, CoroutineScope coroutineScope, MutableState<Boolean> mutableState, Continuation<? super MainToolbarKt$MainToolbar$1$1> continuation) {
        super(2, continuation);
        this.$documentState = documentState;
        this.$coroutine = coroutineScope;
        this.$expanded$delegate = mutableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(CoroutineScope coroutineScope, DocumentState documentState, final MutableState mutableState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new MainToolbarKt$MainToolbar$1$1$1$1(documentState, null), 3, null);
        documentState.setOnMenuVisibleCallback$sdk_nutrient(new Function1() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$MainToolbar$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainToolbarKt$MainToolbar$1$1.invokeSuspend$lambda$0$0(mutableState, ((Boolean) obj).booleanValue());
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(MutableState mutableState, boolean z) {
        MainToolbarKt.MainToolbar$lambda$2(mutableState, z);
        return Unit.INSTANCE;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainToolbarKt$MainToolbar$1$1(this.$documentState, this.$coroutine, this.$expanded$delegate, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        final DocumentState documentState = this.$documentState;
        final CoroutineScope coroutineScope = this.$coroutine;
        final MutableState<Boolean> mutableState = this.$expanded$delegate;
        documentState.setOnDocumentLoadedCallback$sdk_nutrient(new Function0() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$MainToolbar$1$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MainToolbarKt$MainToolbar$1$1.invokeSuspend$lambda$0(coroutineScope, documentState, mutableState);
            }
        });
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainToolbarKt$MainToolbar$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
