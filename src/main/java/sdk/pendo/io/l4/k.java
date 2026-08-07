package sdk.pendo.io.l4;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0003\u001a\u00020\u0002*\u00060\u0000j\u0002`\u0001H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a'\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0006*\u00020\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a+\u0010\b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0006*\u00020\u0005*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007H\u0087@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\t\u001a)\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\t\u001a\u001c\u0010\u000e\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\rH\u0086\b¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Ljava/lang/Exception;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/l4/b;", "await", "(Lretrofit2/Call;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitNullable", "Lsdk/pendo/io/l4/r;", "awaitResponse", "Lsdk/pendo/io/l4/s;", PasskeyWebListener.CREATE_UNIQUE_KEY, "(Lretrofit2/Retrofit;)Ljava/lang/Object;", "retrofit"}, k = 2, mv = {1, 4, 0})
public final class k {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "it", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Ljava/lang/Throwable;)V", "external/sdk/pendo/io/retrofit2/KotlinExtensions$await$2$1"}, k = 3, mv = {1, 4, 0})
    static final class a extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ sdk.pendo.io.l4.b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(sdk.pendo.io.l4.b bVar) {
            super(1);
            this.a = bVar;
        }

        public final void a(Throwable th) {
            this.a.cancel();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            a(th);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "it", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Ljava/lang/Throwable;)V", "external/sdk/pendo/io/retrofit2/KotlinExtensions$await$4$1"}, k = 3, mv = {1, 4, 0})
    static final class b extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ sdk.pendo.io.l4.b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(sdk.pendo.io.l4.b bVar) {
            super(1);
            this.a = bVar;
        }

        public final void a(Throwable th) {
            this.a.cancel();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            a(th);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J$\u0010\u0007\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J\u001e\u0010\u0007\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"sdk/pendo/io/l4/k$c", "Lsdk/pendo/io/l4/d;", "Lsdk/pendo/io/l4/b;", NotificationCompat.CATEGORY_CALL, "Lsdk/pendo/io/l4/r;", "response", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "t", "retrofit"}, k = 1, mv = {1, 4, 0})
    public static final class c<T> implements sdk.pendo.io.l4.d<T> {
        final /* synthetic */ CancellableContinuation a;

        c(CancellableContinuation cancellableContinuation) {
            this.a = cancellableContinuation;
        }

        @Override // sdk.pendo.io.l4.d
        public void a(sdk.pendo.io.l4.b<T> call, Throwable t) {
            Intrinsics.checkParameterIsNotNull(call, "call");
            Intrinsics.checkParameterIsNotNull(t, "t");
            CancellableContinuation cancellableContinuation = this.a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m14780constructorimpl(ResultKt.createFailure(t)));
        }

        @Override // sdk.pendo.io.l4.d
        public void a(sdk.pendo.io.l4.b<T> call, r<T> response) {
            CancellableContinuation cancellableContinuation;
            Object objCreateFailure;
            Object objM14780constructorimpl;
            Intrinsics.checkParameterIsNotNull(call, "call");
            Intrinsics.checkParameterIsNotNull(response, "response");
            if (response.d()) {
                T tA = response.a();
                if (tA == null) {
                    Object objA = call.request().a(j.class);
                    if (objA == null) {
                        Intrinsics.throwNpe();
                    }
                    Intrinsics.checkExpressionValueIsNotNull(objA, "call.request().tag(Invocation::class.java)!!");
                    Method method = ((j) objA).a();
                    StringBuilder sb = new StringBuilder("Response from ");
                    Intrinsics.checkExpressionValueIsNotNull(method, "method");
                    Class<?> declaringClass = method.getDeclaringClass();
                    Intrinsics.checkExpressionValueIsNotNull(declaringClass, "method.declaringClass");
                    KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(sb.append(declaringClass.getName()).append('.').append(method.getName()).append(" was null but response body type was declared as non-null").toString());
                    cancellableContinuation = this.a;
                    Result.Companion companion = Result.INSTANCE;
                    objCreateFailure = ResultKt.createFailure(kotlinNullPointerException);
                } else {
                    cancellableContinuation = this.a;
                    Result.Companion companion2 = Result.INSTANCE;
                    objM14780constructorimpl = Result.m14780constructorimpl(tA);
                }
                cancellableContinuation.resumeWith(objM14780constructorimpl);
            }
            cancellableContinuation = this.a;
            sdk.pendo.io.l4.h hVar = new sdk.pendo.io.l4.h(response);
            Result.Companion companion3 = Result.INSTANCE;
            objCreateFailure = ResultKt.createFailure(hVar);
            objM14780constructorimpl = Result.m14780constructorimpl(objCreateFailure);
            cancellableContinuation.resumeWith(objM14780constructorimpl);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001J(\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00022\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004H\u0016J \u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"sdk/pendo/io/l4/k$d", "Lsdk/pendo/io/l4/d;", "Lsdk/pendo/io/l4/b;", NotificationCompat.CATEGORY_CALL, "Lsdk/pendo/io/l4/r;", "response", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "t", "retrofit"}, k = 1, mv = {1, 4, 0})
    public static final class d<T> implements sdk.pendo.io.l4.d<T> {
        final /* synthetic */ CancellableContinuation a;

        d(CancellableContinuation cancellableContinuation) {
            this.a = cancellableContinuation;
        }

        @Override // sdk.pendo.io.l4.d
        public void a(sdk.pendo.io.l4.b<T> call, Throwable t) {
            Intrinsics.checkParameterIsNotNull(call, "call");
            Intrinsics.checkParameterIsNotNull(t, "t");
            CancellableContinuation cancellableContinuation = this.a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m14780constructorimpl(ResultKt.createFailure(t)));
        }

        @Override // sdk.pendo.io.l4.d
        public void a(sdk.pendo.io.l4.b<T> call, r<T> response) {
            Object objCreateFailure;
            Intrinsics.checkParameterIsNotNull(call, "call");
            Intrinsics.checkParameterIsNotNull(response, "response");
            boolean zD = response.d();
            CancellableContinuation cancellableContinuation = this.a;
            if (zD) {
                objCreateFailure = response.a();
                Result.Companion companion = Result.INSTANCE;
            } else {
                sdk.pendo.io.l4.h hVar = new sdk.pendo.io.l4.h(response);
                Result.Companion companion2 = Result.INSTANCE;
                objCreateFailure = ResultKt.createFailure(hVar);
            }
            cancellableContinuation.resumeWith(Result.m14780constructorimpl(objCreateFailure));
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "L;", "it", "", "invoke", "(L;)V", "kotlin/Throwable", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    static final class e extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ sdk.pendo.io.l4.b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(sdk.pendo.io.l4.b bVar) {
            super(1);
            this.a = bVar;
        }

        public final void a(Throwable th) {
            this.a.cancel();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            a(th);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J$\u0010\u0007\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J\u001e\u0010\u0007\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"sdk/pendo/io/l4/k$f", "Lsdk/pendo/io/l4/d;", "Lsdk/pendo/io/l4/b;", NotificationCompat.CATEGORY_CALL, "Lsdk/pendo/io/l4/r;", "response", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "t", "retrofit"}, k = 1, mv = {1, 4, 0})
    public static final class f<T> implements sdk.pendo.io.l4.d<T> {
        final /* synthetic */ CancellableContinuation a;

        f(CancellableContinuation cancellableContinuation) {
            this.a = cancellableContinuation;
        }

        @Override // sdk.pendo.io.l4.d
        public void a(sdk.pendo.io.l4.b<T> call, Throwable t) {
            Intrinsics.checkParameterIsNotNull(call, "call");
            Intrinsics.checkParameterIsNotNull(t, "t");
            CancellableContinuation cancellableContinuation = this.a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m14780constructorimpl(ResultKt.createFailure(t)));
        }

        @Override // sdk.pendo.io.l4.d
        public void a(sdk.pendo.io.l4.b<T> call, r<T> response) {
            Intrinsics.checkParameterIsNotNull(call, "call");
            Intrinsics.checkParameterIsNotNull(response, "response");
            CancellableContinuation cancellableContinuation = this.a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m14780constructorimpl(response));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "external/sdk/pendo/io/retrofit2/KotlinExtensions$suspendAndThrow$2$1"}, k = 3, mv = {1, 1, 15})
    static final class g implements Runnable {
        final /* synthetic */ Continuation a;
        final /* synthetic */ Exception b;

        g(Continuation continuation, Exception exc) {
            this.a = continuation;
            this.b = exc;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Continuation continuationIntercepted = IntrinsicsKt.intercepted(this.a);
            Exception exc = this.b;
            Result.Companion companion = Result.INSTANCE;
            continuationIntercepted.resumeWith(Result.m14780constructorimpl(ResultKt.createFailure(exc)));
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00060\u0000j\u0002`\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0080@"}, d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "suspendAndThrow"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "external.sdk.pendo.io.retrofit2.KotlinExtensions", f = "KotlinExtensions.kt", i = {0}, l = {113}, m = "suspendAndThrow", n = {"$this$suspendAndThrow"}, s = {"L$0"})
    static final class h extends ContinuationImpl {
        /* synthetic */ Object a;
        int b;
        Object c;

        h(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return k.a((Exception) null, this);
        }
    }

    public static final <T> Object a(sdk.pendo.io.l4.b<T> bVar, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.invokeOnCancellation(new a(bVar));
        bVar.a(new c(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final <T> Object b(sdk.pendo.io.l4.b<T> bVar, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.invokeOnCancellation(new b(bVar));
        bVar.a(new d(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final <T> Object c(sdk.pendo.io.l4.b<T> bVar, Continuation<? super r<T>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.invokeOnCancellation(new e(bVar));
        bVar.a(new f(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(Exception exc, Continuation<?> continuation) {
        h hVar;
        if (continuation instanceof h) {
            hVar = (h) continuation;
            int i = hVar.b;
            if ((i & Integer.MIN_VALUE) != 0) {
                hVar.b = i - Integer.MIN_VALUE;
            } else {
                hVar = new h(continuation);
            }
        } else {
            hVar = new h(continuation);
        }
        Object obj = hVar.a;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = hVar.b;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            hVar.c = exc;
            hVar.b = 1;
            Dispatchers.getDefault().mo16386dispatch(hVar.get$context(), new g(hVar, exc));
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (coroutine_suspended2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(hVar);
            }
            if (coroutine_suspended2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
