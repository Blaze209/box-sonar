package com.pspdfkit.utils;

import android.R;
import androidx.exifinterface.media.ExifInterface;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0004\u001c\u001d\u001e\u001fB\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eJ8\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\"\u0010\u0010\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0014J2\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u001c\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017J \u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00130\u0016J\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00130\u001bR\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0007R\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007\u0082\u0001\u0004 !\"#¨\u0006$"}, d2 = {"Lcom/pspdfkit/utils/Response;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "isSuccess", "", "()Z", "isError", "isLoading", "getOrNull", "()Ljava/lang/Object;", "getOrDefault", "defaultValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "onSuccess", Analytics.Data.ACTION, "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSuccessEmpty", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onError", "", "onLoading", "Lkotlin/Function0;", "Success", "SuccessEmpty", "Error", "Loading", "Lcom/pspdfkit/utils/Response$Error;", "Lcom/pspdfkit/utils/Response$Loading;", "Lcom/pspdfkit/utils/Response$Success;", "Lcom/pspdfkit/utils/Response$SuccessEmpty;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class Response<T> {
    public static final int $stable = 0;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/pspdfkit/utils/Response$Error;", "Lcom/pspdfkit/utils/Response;", "", "exception", "", "<init>", "(Ljava/lang/Throwable;)V", "getException", "()Ljava/lang/Throwable;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Error extends Response {
        public static final int $stable = 8;
        private final Throwable exception;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Throwable th) {
            super(null);
            th.getClass();
            this.exception = th;
        }

        public static /* synthetic */ Error copy$default(Error error, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = error.exception;
            }
            return error.copy(th);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Throwable getException() {
            return this.exception;
        }

        public final Error copy(Throwable exception) {
            exception.getClass();
            return new Error(exception);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && Intrinsics.areEqual(this.exception, ((Error) other).exception);
        }

        public final Throwable getException() {
            return this.exception;
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Error(exception=" + this.exception + ")";
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bHÖ\u0083\u0004J\n\u0010\t\u001a\u00020\nHÖ\u0081\u0004J\n\u0010\u000b\u001a\u00020\fHÖ\u0081\u0004¨\u0006\r"}, d2 = {"Lcom/pspdfkit/utils/Response$Loading;", "Lcom/pspdfkit/utils/Response;", "", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Loading extends Response {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof Loading);
        }

        public int hashCode() {
            return 968345894;
        }

        public String toString() {
            return "Loading";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/pspdfkit/utils/Response$Success;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/pspdfkit/utils/Response;", "data", "<init>", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Object;)Lcom/pspdfkit/utils/Response$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Success<T> extends Response<T> {
        public static final int $stable = 0;
        private final T data;

        public Success(T t) {
            super(null);
            this.data = t;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = success.data;
            }
            return success.copy(obj);
        }

        public final T component1() {
            return this.data;
        }

        public final Success<T> copy(T data) {
            return new Success<>(data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && Intrinsics.areEqual(this.data, ((Success) other).data);
        }

        public final T getData() {
            return this.data;
        }

        public int hashCode() {
            T t = this.data;
            if (t == null) {
                return 0;
            }
            return t.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.data + ")";
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bHÖ\u0083\u0004J\n\u0010\t\u001a\u00020\nHÖ\u0081\u0004J\n\u0010\u000b\u001a\u00020\fHÖ\u0081\u0004¨\u0006\r"}, d2 = {"Lcom/pspdfkit/utils/Response$SuccessEmpty;", "Lcom/pspdfkit/utils/Response;", "", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class SuccessEmpty extends Response {
        public static final int $stable = 0;
        public static final SuccessEmpty INSTANCE = new SuccessEmpty();

        private SuccessEmpty() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof SuccessEmpty);
        }

        public int hashCode() {
            return 143677792;
        }

        public String toString() {
            return "SuccessEmpty";
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.utils.Response$onSuccess$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.utils.Response", f = "Response.kt", i = {0}, l = {111}, m = "onSuccess", n = {Analytics.Data.ACTION}, nl = {112}, s = {"L$0"}, v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ Response<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Response<? extends T> response, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = response;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.onSuccess(null, this);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.utils.Response$onSuccessEmpty$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.utils.Response", f = "Response.kt", i = {0}, l = {122}, m = "onSuccessEmpty", n = {Analytics.Data.ACTION}, nl = {123}, s = {"L$0"}, v = 2)
    public static final class C18661 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ Response<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C18661(Response<? extends T> response, Continuation<? super C18661> continuation) {
            super(continuation);
            this.this$0 = response;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.onSuccessEmpty(null, this);
        }
    }

    public /* synthetic */ Response(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final T getOrDefault(T defaultValue) {
        return this instanceof Success ? (T) ((Success) this).getData() : defaultValue;
    }

    public final T getOrNull() {
        if (this instanceof Success) {
            return (T) ((Success) this).getData();
        }
        return null;
    }

    public final boolean isError() {
        return this instanceof Error;
    }

    public final boolean isLoading() {
        return this instanceof Loading;
    }

    public final boolean isSuccess() {
        return (this instanceof Success) || (this instanceof SuccessEmpty);
    }

    public final Response<T> onError(Function1<? super Throwable, Unit> action) {
        action.getClass();
        if (this instanceof Error) {
            action.invoke(((Error) this).getException());
        }
        return this;
    }

    public final Response<T> onLoading(Function0<Unit> action) {
        action.getClass();
        if (this instanceof Loading) {
            action.invoke();
        }
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object onSuccess(Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Response<? extends T>> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(this, continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(this, continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return this;
        }
        ResultKt.throwOnFailure(obj);
        if (this instanceof Success) {
            R.anim animVar = (Object) ((Success) this).getData();
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(function2);
            anonymousClass1.label = 1;
            if (function2.invoke(animVar, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object onSuccessEmpty(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Response<? extends T>> continuation) {
        C18661 c18661;
        if (continuation instanceof C18661) {
            c18661 = (C18661) continuation;
            int i = c18661.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c18661.label = i - Integer.MIN_VALUE;
            } else {
                c18661 = new C18661(this, continuation);
            }
        } else {
            c18661 = new C18661(this, continuation);
        }
        Object obj = c18661.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c18661.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return this;
        }
        ResultKt.throwOnFailure(obj);
        if (this instanceof SuccessEmpty) {
            c18661.L$0 = SpillingKt.nullOutSpilledVariable(function1);
            c18661.label = 1;
            if (function1.invoke(c18661) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return this;
    }

    private Response() {
    }
}
