package com.box.android.preview.previewtype.document.print;

import android.content.Context;
import com.box.android.cpl.Store;
import com.box.android.domain.utils.result.Result;
import java.net.URI;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PrintOverlay.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.previewtype.document.print.PrintOverlayKt$PrintOverlay$1$1", f = "PrintOverlay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class PrintOverlayKt$PrintOverlay$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ PrintReducer.State $state;
    final /* synthetic */ Store<PrintReducer.State, PrintReducer.Action> $store;
    final /* synthetic */ URI $uri;
    int label;

    /* JADX INFO: compiled from: PrintOverlay.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PrintManager.Error.values().length];
            try {
                iArr[PrintManager.Error.INVALID_PASSWORD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PrintManager.Error.UNKNOWN_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PrintOverlayKt$PrintOverlay$1$1(PrintReducer.State state, Context context, URI uri, Store<PrintReducer.State, PrintReducer.Action> store, Continuation<? super PrintOverlayKt$PrintOverlay$1$1> continuation) {
        super(2, continuation);
        this.$state = state;
        this.$context = context;
        this.$uri = uri;
        this.$store = store;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PrintOverlayKt$PrintOverlay$1$1(this.$state, this.$context, this.$uri, this.$store, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PrintOverlayKt$PrintOverlay$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (this.$state.isPrinting()) {
            Result<Unit, PrintManager.Error> resultPrint = new PrintManager().print(this.$context, this.$uri, this.$state.getPassword());
            Store<PrintReducer.State, PrintReducer.Action> store = this.$store;
            boolean z = resultPrint instanceof Result.Success;
            if (z) {
                store.send(PrintReducer.Action.Finish.INSTANCE);
            } else if (!(resultPrint instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            Store<PrintReducer.State, PrintReducer.Action> store2 = this.$store;
            if (!z) {
                if (!(resultPrint instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                int i = WhenMappings.$EnumSwitchMapping$0[((PrintManager.Error) ((Result.Error) resultPrint).getValue()).ordinal()];
                if (i == 1) {
                    store2.send(PrintReducer.Action.InvalidPasswordEntered.INSTANCE);
                } else {
                    if (i != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    store2.send(PrintReducer.Action.Failed.INSTANCE);
                }
            }
        }
        return Unit.INSTANCE;
    }
}
