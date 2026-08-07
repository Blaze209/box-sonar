package com.box.android.collections.itempicker;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CollectionItemPickerScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.collections.itempicker.CollectionItemPickerScreenKt$CollectionItemPickerScreen$1$1$1$2$1", f = "CollectionItemPickerScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CollectionItemPickerScreenKt$CollectionItemPickerScreen$1$1$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<String, Boolean, Unit> $onNavigationChanged;
    final /* synthetic */ String $screenName;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CollectionItemPickerScreenKt$CollectionItemPickerScreen$1$1$1$2$1(Function2<? super String, ? super Boolean, Unit> function2, String str, Continuation<? super CollectionItemPickerScreenKt$CollectionItemPickerScreen$1$1$1$2$1> continuation) {
        super(2, continuation);
        this.$onNavigationChanged = function2;
        this.$screenName = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CollectionItemPickerScreenKt$CollectionItemPickerScreen$1$1$1$2$1(this.$onNavigationChanged, this.$screenName, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CollectionItemPickerScreenKt$CollectionItemPickerScreen$1$1$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$onNavigationChanged.invoke(this.$screenName, Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
