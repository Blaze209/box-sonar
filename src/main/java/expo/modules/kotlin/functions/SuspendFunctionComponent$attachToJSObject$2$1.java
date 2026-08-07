package expo.modules.kotlin.functions;

import expo.modules.core.errors.CodedException;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.FunctionCallException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.PromiseImpl;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: SuspendFunctionComponent.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.kotlin.functions.SuspendFunctionComponent$attachToJSObject$2$1", f = "SuspendFunctionComponent.kt", i = {0}, l = {47}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u241"}, s = {"L$3"})
final class SuspendFunctionComponent$attachToJSObject$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppContext $appContext;
    final /* synthetic */ Object[] $args;
    final /* synthetic */ String $moduleName;
    final /* synthetic */ PromiseImpl $promiseImpl;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ SuspendFunctionComponent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SuspendFunctionComponent$attachToJSObject$2$1(PromiseImpl promiseImpl, SuspendFunctionComponent suspendFunctionComponent, String str, Object[] objArr, AppContext appContext, Continuation<? super SuspendFunctionComponent$attachToJSObject$2$1> continuation) {
        super(2, continuation);
        this.$promiseImpl = promiseImpl;
        this.this$0 = suspendFunctionComponent;
        this.$moduleName = str;
        this.$args = objArr;
        this.$appContext = appContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SuspendFunctionComponent$attachToJSObject$2$1 suspendFunctionComponent$attachToJSObject$2$1 = new SuspendFunctionComponent$attachToJSObject$2$1(this.$promiseImpl, this.this$0, this.$moduleName, this.$args, this.$appContext, continuation);
        suspendFunctionComponent$attachToJSObject$2$1.L$0 = obj;
        return suspendFunctionComponent$attachToJSObject$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuspendFunctionComponent$attachToJSObject$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0077 A[Catch: all -> 0x00af, TryCatch #2 {all -> 0x00af, blocks: (B:25:0x0073, B:27:0x0077, B:29:0x007b, B:32:0x00a3, B:33:0x00ae, B:30:0x0098, B:31:0x00a0, B:13:0x0033), top: B:52:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x007b A[Catch: all -> 0x00af, TryCatch #2 {all -> 0x00af, blocks: (B:25:0x0073, B:27:0x0077, B:29:0x007b, B:32:0x00a3, B:33:0x00ae, B:30:0x0098, B:31:0x00a0, B:13:0x0033), top: B:52:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0098 A[Catch: all -> 0x00af, TryCatch #2 {all -> 0x00af, blocks: (B:25:0x0073, B:27:0x0077, B:29:0x007b, B:32:0x00a3, B:33:0x00ae, B:30:0x0098, B:31:0x00a0, B:13:0x0033), top: B:52:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x00a0 A[Catch: all -> 0x00af, TryCatch #2 {all -> 0x00af, blocks: (B:25:0x0073, B:27:0x0077, B:29:0x007b, B:32:0x00a3, B:33:0x00ae, B:30:0x0098, B:31:0x00a0, B:13:0x0033), top: B:52:0x0033 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SuspendFunctionComponent suspendFunctionComponent;
        CodedException codedException;
        String str;
        CoroutineScope coroutineScope;
        PromiseImpl promiseImpl;
        UnexpectedException unexpectedException;
        UnexpectedException unexpectedException2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            try {
                suspendFunctionComponent = this.this$0;
                String str2 = this.$moduleName;
                Object[] objArr = this.$args;
                AppContext appContext = this.$appContext;
                PromiseImpl promiseImpl2 = this.$promiseImpl;
                try {
                    SuspendFunctionComponent$attachToJSObject$2$1 suspendFunctionComponent$attachToJSObject$2$1 = this;
                    Function3 function3 = suspendFunctionComponent.body;
                    Object[] objArrConvertArgs$default = AnyFunction.convertArgs$default(suspendFunctionComponent, objArr, appContext, false, 4, null);
                    this.L$0 = suspendFunctionComponent;
                    this.L$1 = str2;
                    this.L$2 = promiseImpl2;
                    this.L$3 = coroutineScope2;
                    this.label = 1;
                    Object objInvoke = function3.invoke(coroutineScope2, objArrConvertArgs$default, this);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    coroutineScope = coroutineScope2;
                    obj = objInvoke;
                    str = str2;
                    promiseImpl = promiseImpl2;
                } catch (Throwable th) {
                    codedException = th;
                    str = str2;
                    if (!(codedException instanceof expo.modules.kotlin.exception.CodedException)) {
                        unexpectedException2 = (expo.modules.kotlin.exception.CodedException) codedException;
                    } else if (codedException instanceof CodedException) {
                        String code = codedException.getCode();
                        Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                        unexpectedException2 = new expo.modules.kotlin.exception.CodedException(code, codedException.getMessage(), codedException.getCause());
                    } else {
                        unexpectedException2 = new UnexpectedException(codedException);
                    }
                    throw new FunctionCallException(suspendFunctionComponent.getName(), str, unexpectedException2);
                }
            } catch (Throwable th2) {
                if (this.$promiseImpl.getWasSettled()) {
                    throw th2;
                }
                PromiseImpl promiseImpl3 = this.$promiseImpl;
                if (th2 instanceof expo.modules.kotlin.exception.CodedException) {
                    unexpectedException = (expo.modules.kotlin.exception.CodedException) th2;
                } else if (th2 instanceof CodedException) {
                    CodedException codedException2 = (CodedException) th2;
                    String code2 = codedException2.getCode();
                    Intrinsics.checkNotNullExpressionValue(code2, "getCode(...)");
                    unexpectedException = new expo.modules.kotlin.exception.CodedException(code2, codedException2.getMessage(), codedException2.getCause());
                } else {
                    unexpectedException = new UnexpectedException(th2);
                }
                promiseImpl3.reject(unexpectedException);
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.L$3;
            promiseImpl = (PromiseImpl) this.L$2;
            str = (String) this.L$1;
            suspendFunctionComponent = (SuspendFunctionComponent) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                codedException = th3;
                if (!(codedException instanceof expo.modules.kotlin.exception.CodedException)) {
                    unexpectedException2 = (expo.modules.kotlin.exception.CodedException) codedException;
                } else if (codedException instanceof CodedException) {
                    String code3 = codedException.getCode();
                    Intrinsics.checkNotNullExpressionValue(code3, "getCode(...)");
                    unexpectedException2 = new expo.modules.kotlin.exception.CodedException(code3, codedException.getMessage(), codedException.getCause());
                } else {
                    unexpectedException2 = new UnexpectedException(codedException);
                }
                throw new FunctionCallException(suspendFunctionComponent.getName(), str, unexpectedException2);
            }
        }
        if (CoroutineScopeKt.isActive(coroutineScope)) {
            promiseImpl.resolve(obj);
        }
        Unit unit = Unit.INSTANCE;
        return Unit.INSTANCE;
    }
}
