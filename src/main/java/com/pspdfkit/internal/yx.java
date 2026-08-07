package com.pspdfkit.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes3.dex */
public final class yx implements Flow<Boolean> {
    public final /* synthetic */ Flow a;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ FlowCollector a;

        /* JADX INFO: renamed from: com.pspdfkit.internal.yx$a$a, reason: collision with other inner class name */
        @DebugMetadata(c = "com.pspdfkit.internal.ui.redaction.RedactionProcessorFragment$awaitPdfUi$$inlined$filter$1$2", f = "RedactionProcessorFragment.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$filter_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$filter$1"}, nl = {52}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 2)
        public static final class C0296a extends ContinuationImpl {
            public /* synthetic */ Object a;
            public int b;
            public Object c;
            public Object d;
            public Object f;
            public Object g;

            public C0296a(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.a = obj;
                this.b |= Integer.MIN_VALUE;
                return a.this.emit(null, this);
            }
        }

        public a(FlowCollector flowCollector) {
            this.a = flowCollector;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object obj, Continuation continuation) {
            C0296a c0296a;
            if (continuation instanceof C0296a) {
                c0296a = (C0296a) continuation;
                int i = c0296a.b;
                if ((i & Integer.MIN_VALUE) != 0) {
                    c0296a.b = i - Integer.MIN_VALUE;
                } else {
                    c0296a = new C0296a(continuation);
                }
            } else {
                c0296a = new C0296a(continuation);
            }
            Object obj2 = c0296a.a;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = c0296a.b;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj2);
                FlowCollector flowCollector = this.a;
                if (((Boolean) obj).booleanValue()) {
                    c0296a.c = SpillingKt.nullOutSpilledVariable(obj);
                    c0296a.d = SpillingKt.nullOutSpilledVariable(c0296a);
                    c0296a.f = SpillingKt.nullOutSpilledVariable(obj);
                    c0296a.g = SpillingKt.nullOutSpilledVariable(flowCollector);
                    c0296a.b = 1;
                    if (flowCollector.emit(obj, c0296a) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj2);
            }
            return Unit.INSTANCE;
        }
    }

    public yx(Flow flow) {
        this.a = flow;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
        Object objCollect = this.a.collect(new a(flowCollector), continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }
}
