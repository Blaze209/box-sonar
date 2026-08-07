package com.pspdfkit.internal;

import android.graphics.Matrix;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.exceptions.ContentEditingUnavailableException;
import com.pspdfkit.internal.jni.NativeContentEditingResult;
import com.pspdfkit.utils.PdfLog;
import com.pspdfkit.utils.Size;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.ContentEditingModeHandler$updateTextBlockEssentials$1", f = "ContentEditingModeHandler.kt", i = {}, l = {588}, m = "invokeSuspend", n = {}, nl = {591}, s = {}, v = 2)
public final class va extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ ta b;

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.ContentEditingModeHandler$updateTextBlockEssentials$1$1", f = "ContentEditingModeHandler.kt", i = {0}, l = {567}, m = "invokeSuspend", n = {"$this$flow"}, nl = {570}, s = {"L$0"}, v = 2)
    public static final class a extends SuspendLambda implements Function2<FlowCollector<? super ya<List<? extends k50>>>, Continuation<? super Unit>, Object> {
        public int a;
        public /* synthetic */ Object b;
        public final /* synthetic */ ta c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ta taVar, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = taVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(this.c, continuation);
            aVar.b = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super ya<List<? extends k50>>> flowCollector, Continuation<? super Unit> continuation) {
            a aVar = new a(this.c, continuation);
            aVar.b = flowCollector;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.b;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ta taVar = this.c;
                ab abVar = taVar.a;
                int i2 = taVar.c;
                PdfDocument document = abVar.e.getDocument();
                if (document == null) {
                    throw new ContentEditingUnavailableException("Document is no longer available");
                }
                Size pageSize = document.getPageSize(i2);
                pageSize.getClass();
                ya yaVarA = abVar.a(new sc(i2, pageSize));
                abVar.c();
                this.b = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.a = 1;
                if (flowCollector.emit(yaVarA, this) == coroutine_suspended) {
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
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.ContentEditingModeHandler$updateTextBlockEssentials$1$2", f = "ContentEditingModeHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class b extends SuspendLambda implements Function3<FlowCollector<? super ya<List<? extends k50>>>, Throwable, Continuation<? super Unit>, Object> {
        public /* synthetic */ Throwable a;
        public final /* synthetic */ ta b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ta taVar, Continuation<? super b> continuation) {
            super(3, continuation);
            this.b = taVar;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super ya<List<? extends k50>>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            b bVar = new b(this.b, continuation);
            bVar.a = th;
            return bVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Throwable th = this.a;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            boolean z = th instanceof ContentEditingUnavailableException;
            int i = this.b.c;
            if (z) {
                PdfLog.w("Nutri.ContEditModeHand", "Content editing session no longer available during text block essentials query for page " + i, new Object[0]);
                return Unit.INSTANCE;
            }
            PdfLog.e("Nutri.ContEditModeHand", "updateTextBlockEssentials(" + i + ")", th);
            throw th;
        }
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ ta a;

        public c(ta taVar) {
            this.a = taVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object obj, Continuation continuation) {
            CoroutineScope coroutineScope;
            m40 state;
            ya yaVar = (ya) obj;
            ta taVar = this.a;
            List list = (List) yaVar.a;
            NativeContentEditingResult nativeContentEditingResult = yaVar.b;
            Matrix matrix = ta.R;
            au auVar = taVar.n;
            if (((auVar == null || (state = auVar.getState()) == null) ? null : state.a) != null) {
                if (!taVar.D) {
                    taVar.D = true;
                    Function0<Unit> function0 = taVar.a.n;
                    if (function0 != null) {
                        function0.invoke();
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (T t : list) {
                    if (((k50) t).d.c.a == 0.0f) {
                        arrayList.add(t);
                    }
                }
                HashMap<String, k50> map = new HashMap<>();
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    map.put(((k50) obj2).c, obj2);
                }
                taVar.x = map;
                taVar.o();
                Size size2 = taVar.C;
                if (size2 != null && (coroutineScope = taVar.A) != null) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ua(size2, nativeContentEditingResult, taVar, null), 3, null);
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public va(ta taVar, Continuation<? super va> continuation) {
        super(2, continuation);
        this.b = taVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new va(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new va(this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow flowM16356catch = FlowKt.m16356catch(FlowKt.flowOn(FlowKt.flow(new a(this.b, null)), Dispatchers.getDefault()), new b(this.b, null));
            c cVar = new c(this.b);
            this.a = 1;
            if (flowM16356catch.collect(cVar, this) == coroutine_suspended) {
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
}
