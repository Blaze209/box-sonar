package com.box.android.browse.search.component;

import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: FilesSearchInputField.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.browse.search.component.FilesSearchInputFieldKt$FilesSearchInputField$4$1", f = "FilesSearchInputField.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FilesSearchInputFieldKt$FilesSearchInputField$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<String> $currentQuery$delegate;
    final /* synthetic */ Function1<String, Unit> $onQueryChange;
    final /* synthetic */ TextFieldState $textFieldState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FilesSearchInputFieldKt$FilesSearchInputField$4$1(TextFieldState textFieldState, Function1<? super String, Unit> function1, State<String> state, Continuation<? super FilesSearchInputFieldKt$FilesSearchInputField$4$1> continuation) {
        super(2, continuation);
        this.$textFieldState = textFieldState;
        this.$onQueryChange = function1;
        this.$currentQuery$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FilesSearchInputFieldKt$FilesSearchInputField$4$1(this.$textFieldState, this.$onQueryChange, this.$currentQuery$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilesSearchInputFieldKt$FilesSearchInputField$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.box.android.browse.search.component.FilesSearchInputFieldKt$FilesSearchInputField$4$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: FilesSearchInputField.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "text", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.search.component.FilesSearchInputFieldKt$FilesSearchInputField$4$1$2", f = "FilesSearchInputField.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
        final /* synthetic */ State<String> $currentQuery$delegate;
        final /* synthetic */ Function1<String, Unit> $onQueryChange;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function1<? super String, Unit> function1, State<String> state, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$onQueryChange = function1;
            this.$currentQuery$delegate = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$onQueryChange, this.$currentQuery$delegate, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str = (String) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (!Intrinsics.areEqual(FilesSearchInputFieldKt.FilesSearchInputField$lambda$3(this.$currentQuery$delegate), str)) {
                    this.$onQueryChange.invoke(str);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final TextFieldState textFieldState = this.$textFieldState;
            this.label = 1;
            if (FlowKt.collectLatest(SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$FilesSearchInputField$4$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FilesSearchInputFieldKt$FilesSearchInputField$4$1.invokeSuspend$lambda$0(textFieldState);
                }
            }), new AnonymousClass2(this.$onQueryChange, this.$currentQuery$delegate, null), this) == coroutine_suspended) {
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
