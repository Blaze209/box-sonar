package com.pspdfkit.internal;

import android.graphics.Matrix;
import com.pspdfkit.exceptions.NutrientException;
import com.pspdfkit.internal.jni.NativeContentEditingError;
import com.pspdfkit.internal.jni.NativeContentEditingResult;
import com.pspdfkit.utils.PdfLog;
import com.pspdfkit.utils.Size;
import java.util.HashMap;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.ContentEditingModeHandler$parseTextBlockDetails$1", f = "ContentEditingModeHandler.kt", i = {}, l = {652}, m = "invokeSuspend", n = {}, nl = {655}, s = {}, v = 2)
public final class ua extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ Size b;
    public final /* synthetic */ NativeContentEditingResult c;
    public final /* synthetic */ ta d;

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.ContentEditingModeHandler$parseTextBlockDetails$1$1", f = "ContentEditingModeHandler.kt", i = {0}, l = {642}, m = "invokeSuspend", n = {"$this$flow"}, nl = {647}, s = {"L$0"}, v = 2)
    public static final class a extends SuspendLambda implements Function2<FlowCollector<? super HashMap<String, i50>>, Continuation<? super Unit>, Object> {
        public int a;
        public /* synthetic */ Object b;
        public final /* synthetic */ Size c;
        public final /* synthetic */ NativeContentEditingResult d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Size size, NativeContentEditingResult nativeContentEditingResult, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = size;
            this.d = nativeContentEditingResult;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(this.c, this.d, continuation);
            aVar.b = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super HashMap<String, i50>> flowCollector, Continuation<? super Unit> continuation) {
            return ((a) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.b;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Size size = this.c;
                size.getClass();
                KSerializer kSerializerListSerializer = BuiltinSerializersKt.ListSerializer(i50.Companion.serializer());
                Function2 function2A = zi.a.a(size);
                za zaVar = new za(kSerializerListSerializer, function2A);
                NativeContentEditingResult nativeContentEditingResult = this.d;
                NativeContentEditingError error = nativeContentEditingResult.getError();
                if (error != null) {
                    PdfLog.e("Nutri.ContEditingResCon", error.toString(), new Object[0]);
                    throw new NutrientException(error.toString());
                }
                Object objDecodeFromString = ra.a.decodeFromString(kSerializerListSerializer, zaVar.a(nativeContentEditingResult));
                function2A.invoke(objDecodeFromString, nativeContentEditingResult);
                HashMap map = new HashMap();
                for (Object obj2 : (Iterable) objDecodeFromString) {
                    map.put(((i50) obj2).c, obj2);
                }
                this.b = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.a = 1;
                if (flowCollector.emit(map, this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.ContentEditingModeHandler$parseTextBlockDetails$1$2", f = "ContentEditingModeHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class b extends SuspendLambda implements Function3<FlowCollector<? super HashMap<String, i50>>, Throwable, Continuation<? super Unit>, Object> {
        public /* synthetic */ Throwable a;
        public final /* synthetic */ ta b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ta taVar, Continuation<? super b> continuation) {
            super(3, continuation);
            this.b = taVar;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super HashMap<String, i50>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            b bVar = new b(this.b, continuation);
            bVar.a = th;
            return bVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Throwable th = this.a;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            PdfLog.e("Nutri.ContEditModeHand", "parseTextBlockDetails(" + this.b.c + ")", th);
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ ta a;

        public c(ta taVar) {
            this.a = taVar;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object obj, Continuation continuation) {
            HashMap map = (HashMap) obj;
            ta taVar = this.a;
            Matrix matrix = ta.R;
            Map mapEmptyMap = (Map) taVar.a.h.b.get(Integer.valueOf(taVar.c));
            if (mapEmptyMap == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
            taVar.a(MapsKt.plus(map, mapEmptyMap));
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ua(Size size, NativeContentEditingResult nativeContentEditingResult, ta taVar, Continuation<? super ua> continuation) {
        super(2, continuation);
        this.b = size;
        this.c = nativeContentEditingResult;
        this.d = taVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ua(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ua) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow flowM16356catch = FlowKt.m16356catch(FlowKt.flowOn(FlowKt.flow(new a(this.b, this.c, null)), Dispatchers.getDefault()), new b(this.d, null));
            c cVar = new c(this.d);
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
