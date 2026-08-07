package com.pspdfkit.internal;

import android.util.SparseIntArray;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.undo.edit.Edit;
import com.pspdfkit.undo.edit.annotations.AnnotationEdit;
import com.pspdfkit.undo.edit.annotations.AnnotationPropertyEdit;
import com.pspdfkit.undo.exceptions.RedoEditFailedException;
import com.pspdfkit.undo.exceptions.UndoEditFailedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class l3 extends y4<AnnotationPropertyEdit> {

    @DebugMetadata(c = "com.pspdfkit.internal.undo.annotations.AnnotationPropertyUndoExecutor$canProcess$1$1", f = "AnnotationPropertyUndoExecutor.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Annotation>, Object> {
        public int a;
        public final /* synthetic */ AnnotationPropertyEdit c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AnnotationPropertyEdit annotationPropertyEdit, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = annotationPropertyEdit;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return l3.this.new a(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Annotation> continuation) {
            return l3.this.new a(this.c, continuation).invokeSuspend(Unit.INSTANCE);
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
            o3 o3Var = l3.this.e;
            int pageIndex = this.c.getPageIndex();
            l3 l3Var = l3.this;
            int objectNumber = this.c.getObjectNumber();
            while (true) {
                int i2 = l3Var.f.get(objectNumber, objectNumber);
                if (i2 == objectNumber) {
                    break;
                }
                objectNumber = i2;
            }
            this.a = 1;
            o3Var.getClass();
            Object objA = o3.a(o3Var, pageIndex, objectNumber, this);
            return objA == coroutine_suspended ? coroutine_suspended : objA;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l3(o3 o3Var, SparseIntArray sparseIntArray, q7.a<? super AnnotationPropertyEdit> aVar) {
        super(o3Var, sparseIntArray, AnnotationPropertyEdit.class, aVar);
        o3Var.getClass();
    }

    @Override // com.pspdfkit.internal.y60
    public final boolean a(Edit edit) {
        AnnotationPropertyEdit annotationPropertyEdit = (AnnotationPropertyEdit) edit;
        annotationPropertyEdit.getClass();
        return a(annotationPropertyEdit);
    }

    @Override // com.pspdfkit.internal.y60
    public final boolean b(Edit edit) {
        AnnotationPropertyEdit annotationPropertyEdit = (AnnotationPropertyEdit) edit;
        annotationPropertyEdit.getClass();
        return a(annotationPropertyEdit);
    }

    @Override // com.pspdfkit.internal.q7
    public final /* bridge */ /* synthetic */ Object a(Edit edit, s7 s7Var) {
        return a((AnnotationPropertyEdit) edit, (ContinuationImpl) s7Var);
    }

    @Override // com.pspdfkit.internal.q7
    public final /* bridge */ /* synthetic */ Object a(Edit edit, t7 t7Var) {
        return b((AnnotationPropertyEdit) edit, (ContinuationImpl) t7Var);
    }

    public final boolean a(AnnotationPropertyEdit annotationPropertyEdit) {
        Object objM14780constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM14780constructorimpl = Result.m14780constructorimpl((Annotation) BuildersKt__BuildersKt.runBlocking$default(null, new a(annotationPropertyEdit, null), 1, null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m14787isSuccessimpl(objM14780constructorimpl);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b(AnnotationPropertyEdit annotationPropertyEdit, ContinuationImpl continuationImpl) {
        n3 n3Var;
        Object objM14780constructorimpl;
        if (continuationImpl instanceof n3) {
            n3Var = (n3) continuationImpl;
            int i = n3Var.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                n3Var.e = i - Integer.MIN_VALUE;
            } else {
                n3Var = new n3(this, continuationImpl);
            }
        } else {
            n3Var = new n3(this, continuationImpl);
        }
        Object objA = n3Var.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = n3Var.e;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objA);
                Result.Companion companion = Result.INSTANCE;
                n3Var.a = annotationPropertyEdit;
                n3Var.b = this;
                n3Var.e = 1;
                objA = a((AnnotationEdit) annotationPropertyEdit, (ContinuationImpl) n3Var);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this = n3Var.b;
                annotationPropertyEdit = n3Var.a;
                ResultKt.throwOnFailure(objA);
            }
            int propertyKey = annotationPropertyEdit.getPropertyKey();
            Object oldValue = annotationPropertyEdit.getOldValue();
            this.getClass();
            j3 properties = ((Annotation) objA).getInternal().getProperties();
            properties.f.a(propertyKey, oldValue, true);
            properties.l();
            objM14780constructorimpl = Result.m14780constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM14783exceptionOrNullimpl = Result.m14783exceptionOrNullimpl(objM14780constructorimpl);
        if (thM14783exceptionOrNullimpl == null) {
            return Unit.INSTANCE;
        }
        throw new UndoEditFailedException("Could not perform undo operation.", thM14783exceptionOrNullimpl);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(AnnotationPropertyEdit annotationPropertyEdit, ContinuationImpl continuationImpl) {
        m3 m3Var;
        Object objM14780constructorimpl;
        if (continuationImpl instanceof m3) {
            m3Var = (m3) continuationImpl;
            int i = m3Var.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                m3Var.e = i - Integer.MIN_VALUE;
            } else {
                m3Var = new m3(this, continuationImpl);
            }
        } else {
            m3Var = new m3(this, continuationImpl);
        }
        Object objA = m3Var.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = m3Var.e;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objA);
                Result.Companion companion = Result.INSTANCE;
                m3Var.a = annotationPropertyEdit;
                m3Var.b = this;
                m3Var.e = 1;
                objA = a((AnnotationEdit) annotationPropertyEdit, (ContinuationImpl) m3Var);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this = m3Var.b;
                annotationPropertyEdit = m3Var.a;
                ResultKt.throwOnFailure(objA);
            }
            int propertyKey = annotationPropertyEdit.getPropertyKey();
            Object newValue = annotationPropertyEdit.getNewValue();
            this.getClass();
            j3 properties = ((Annotation) objA).getInternal().getProperties();
            properties.f.a(propertyKey, newValue, true);
            properties.l();
            objM14780constructorimpl = Result.m14780constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM14783exceptionOrNullimpl = Result.m14783exceptionOrNullimpl(objM14780constructorimpl);
        if (thM14783exceptionOrNullimpl == null) {
            return Unit.INSTANCE;
        }
        throw new RedoEditFailedException("Could not perform redo operation.", thM14783exceptionOrNullimpl);
    }
}
