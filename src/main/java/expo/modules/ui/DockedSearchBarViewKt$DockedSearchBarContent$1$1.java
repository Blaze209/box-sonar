package expo.modules.ui;

import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.runtime.SnapshotStateKt;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: DockedSearchBarView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.ui.DockedSearchBarViewKt$DockedSearchBarContent$1$1", f = "DockedSearchBarView.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
final class DockedSearchBarViewKt$DockedSearchBarContent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<GenericEventPayload1<String>, Unit> $onQueryChange;
    final /* synthetic */ TextFieldState $textFieldState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DockedSearchBarViewKt$DockedSearchBarContent$1$1(TextFieldState textFieldState, Function1<? super GenericEventPayload1<String>, Unit> function1, Continuation<? super DockedSearchBarViewKt$DockedSearchBarContent$1$1> continuation) {
        super(2, continuation);
        this.$textFieldState = textFieldState;
        this.$onQueryChange = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DockedSearchBarViewKt$DockedSearchBarContent$1$1(this.$textFieldState, this.$onQueryChange, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DockedSearchBarViewKt$DockedSearchBarContent$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final TextFieldState textFieldState = this.$textFieldState;
            Flow flowSnapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: expo.modules.ui.DockedSearchBarViewKt$DockedSearchBarContent$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DockedSearchBarViewKt$DockedSearchBarContent$1$1.invokeSuspend$lambda$0(textFieldState);
                }
            });
            final Function1<GenericEventPayload1<String>, Unit> function1 = this.$onQueryChange;
            this.label = 1;
            if (flowSnapshotFlow.collect(new FlowCollector() { // from class: expo.modules.ui.DockedSearchBarViewKt$DockedSearchBarContent$1$1.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((String) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(String str, Continuation<? super Unit> continuation) {
                    function1.invoke(new GenericEventPayload1<>(str));
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String invokeSuspend$lambda$0(TextFieldState textFieldState) {
        return textFieldState.getText().toString();
    }
}
