package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.utils.PdfLog;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.page.MediaPlayer$fetchVideoAnnotations$1", f = "MediaPlayer.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, nl = {135}, s = {}, v = 2)
public final class oq extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ kq b;
    public final /* synthetic */ m40 c;

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.MediaPlayer$fetchVideoAnnotations$1$annotations$1", f = "MediaPlayer.kt", i = {}, l = {Token.SCRIPT}, m = "invokeSuspend", n = {}, nl = {Token.SETELEM_OP}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Annotation>>, Object> {
        public int a;
        public final /* synthetic */ kq b;
        public final /* synthetic */ m40 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(kq kqVar, m40 m40Var, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = kqVar;
            this.c = m40Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Annotation>> continuation) {
            return new a(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            AnnotationProvider annotationProvider = this.b.b.getAnnotationProvider();
            EnumSet<AnnotationType> enumSet = kq.o;
            int i2 = this.c.b;
            this.a = 1;
            Object allAnnotationsOfType = annotationProvider.getAllAnnotationsOfType(enumSet, i2, 1, this);
            return allAnnotationsOfType == coroutine_suspended ? coroutine_suspended : allAnnotationsOfType;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oq(kq kqVar, m40 m40Var, Continuation<? super oq> continuation) {
        super(2, continuation);
        this.b = kqVar;
        this.c = m40Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new oq(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new oq(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        iq iqVar;
        iq iqVarA;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher io2 = Dispatchers.getIO();
                a aVar = new a(this.b, this.c, null);
                this.a = 1;
                obj = BuildersKt.withContext(io2, aVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            kq kqVar = this.b;
            for (Annotation annotation : (List) obj) {
                EnumSet<AnnotationType> enumSet = kq.o;
                Iterator it = kqVar.f.entrySet().iterator();
                do {
                    if (!it.hasNext()) {
                        iqVar = null;
                        break;
                    }
                    iqVar = (iq) ((Map.Entry) it.next()).getKey();
                } while (!Intrinsics.areEqual(iqVar.a, annotation));
                if (iqVar == null && (iqVarA = iq.a(annotation)) != null) {
                    kqVar.f.put(iqVarA, null);
                }
            }
            kq kqVar2 = this.b;
            kqVar2.k = true;
            if (kqVar2.i) {
                kqVar2.b();
            }
        } catch (CancellationException unused) {
        } catch (Throwable th) {
            PdfLog.e("Nutri.MediaPlayer", th, "Error while retrieving video annotations.", new Object[0]);
        }
        return Unit.INSTANCE;
    }
}
