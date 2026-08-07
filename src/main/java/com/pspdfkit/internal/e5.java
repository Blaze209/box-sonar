package com.pspdfkit.internal;

import android.util.SparseIntArray;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.undo.edit.Edit;
import com.pspdfkit.undo.edit.annotations.AnnotationZIndexEdit;
import com.pspdfkit.undo.exceptions.UndoEditFailedException;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class e5 extends y4<AnnotationZIndexEdit> {

    @DebugMetadata(c = "com.pspdfkit.internal.undo.annotations.AnnotationZIndexUndoExecutor$canProcess$1$1", f = "AnnotationZIndexUndoExecutor.kt", i = {1}, l = {54, 55}, m = "invokeSuspend", n = {"annotations"}, nl = {55, 56}, s = {"L$0"}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        public List a;
        public int b;
        public final /* synthetic */ AnnotationZIndexEdit d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AnnotationZIndexEdit annotationZIndexEdit, Continuation<? super a> continuation) {
            super(2, continuation);
            this.d = annotationZIndexEdit;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e5.this.new a(this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return e5.this.new a(this.d, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0083  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List list;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    list = this.a;
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxBoolean(!CollectionsKt.contains(list, (Annotation) obj) && list.size() > Math.max(this.d.getOldZIndex(), this.d.getNewZIndex()));
            }
            ResultKt.throwOnFailure(obj);
            o3 o3Var = e5.this.e;
            int pageIndex = this.d.getPageIndex();
            this.b = 1;
            obj = o3Var.getAnnotations(pageIndex, this);
            if (obj != coroutine_suspended) {
            }
            return coroutine_suspended;
            List list2 = (List) obj;
            o3 o3Var2 = e5.this.e;
            int pageIndex2 = this.d.getPageIndex();
            e5 e5Var = e5.this;
            int objectNumber = this.d.getObjectNumber();
            while (true) {
                int i2 = e5Var.f.get(objectNumber, objectNumber);
                if (i2 == objectNumber) {
                    break;
                }
                objectNumber = i2;
            }
            this.a = list2;
            this.b = 2;
            o3Var2.getClass();
            Object objA = o3.a(o3Var2, pageIndex2, objectNumber, this);
            if (objA != coroutine_suspended) {
                list = list2;
                obj = objA;
                return Boxing.boxBoolean(!CollectionsKt.contains(list, (Annotation) obj) && list.size() > Math.max(this.d.getOldZIndex(), this.d.getNewZIndex()));
            }
            return coroutine_suspended;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e5(o3 o3Var, SparseIntArray sparseIntArray, q7.a<? super AnnotationZIndexEdit> aVar) {
        super(o3Var, sparseIntArray, AnnotationZIndexEdit.class, aVar);
        o3Var.getClass();
    }

    @Override // com.pspdfkit.internal.y60
    public final boolean a(Edit edit) {
        AnnotationZIndexEdit annotationZIndexEdit = (AnnotationZIndexEdit) edit;
        annotationZIndexEdit.getClass();
        return a(annotationZIndexEdit);
    }

    @Override // com.pspdfkit.internal.y60
    public final boolean b(Edit edit) {
        AnnotationZIndexEdit annotationZIndexEdit = (AnnotationZIndexEdit) edit;
        annotationZIndexEdit.getClass();
        return a(annotationZIndexEdit);
    }

    @Override // com.pspdfkit.internal.q7
    public final /* bridge */ /* synthetic */ Object a(Edit edit, s7 s7Var) {
        return a((AnnotationZIndexEdit) edit, (ContinuationImpl) s7Var);
    }

    @Override // com.pspdfkit.internal.q7
    public final /* bridge */ /* synthetic */ Object a(Edit edit, t7 t7Var) {
        return b((AnnotationZIndexEdit) edit, (ContinuationImpl) t7Var);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(AnnotationZIndexEdit annotationZIndexEdit, ContinuationImpl continuationImpl) {
        f5 f5Var;
        Object objM14780constructorimpl;
        if (continuationImpl instanceof f5) {
            f5Var = (f5) continuationImpl;
            int i = f5Var.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                f5Var.e = i - Integer.MIN_VALUE;
            } else {
                f5Var = new f5(this, continuationImpl);
            }
        } else {
            f5Var = new f5(this, continuationImpl);
        }
        Object obj = f5Var.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = f5Var.e;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                Result.Companion companion = Result.INSTANCE;
                o3 o3Var = this.e;
                int pageIndex = annotationZIndexEdit.getPageIndex();
                int oldZIndex = annotationZIndexEdit.getOldZIndex();
                int newZIndex = annotationZIndexEdit.getNewZIndex();
                f5Var.a = SpillingKt.nullOutSpilledVariable(annotationZIndexEdit);
                f5Var.b = SpillingKt.nullOutSpilledVariable(this);
                f5Var.e = 1;
                if (o3Var.moveAnnotation(pageIndex, oldZIndex, newZIndex, f5Var) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            objM14780constructorimpl = Result.m14780constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM14783exceptionOrNullimpl = Result.m14783exceptionOrNullimpl(objM14780constructorimpl);
        if (thM14783exceptionOrNullimpl == null) {
            return Unit.INSTANCE;
        }
        throw new UndoEditFailedException("Could not perform redo action on z-index change.", thM14783exceptionOrNullimpl);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b(AnnotationZIndexEdit annotationZIndexEdit, ContinuationImpl continuationImpl) {
        g5 g5Var;
        Object objM14780constructorimpl;
        if (continuationImpl instanceof g5) {
            g5Var = (g5) continuationImpl;
            int i = g5Var.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                g5Var.e = i - Integer.MIN_VALUE;
            } else {
                g5Var = new g5(this, continuationImpl);
            }
        } else {
            g5Var = new g5(this, continuationImpl);
        }
        Object obj = g5Var.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = g5Var.e;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                Result.Companion companion = Result.INSTANCE;
                o3 o3Var = this.e;
                int pageIndex = annotationZIndexEdit.getPageIndex();
                int newZIndex = annotationZIndexEdit.getNewZIndex();
                int oldZIndex = annotationZIndexEdit.getOldZIndex();
                g5Var.a = SpillingKt.nullOutSpilledVariable(annotationZIndexEdit);
                g5Var.b = SpillingKt.nullOutSpilledVariable(this);
                g5Var.e = 1;
                if (o3Var.moveAnnotation(pageIndex, newZIndex, oldZIndex, g5Var) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            objM14780constructorimpl = Result.m14780constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM14783exceptionOrNullimpl = Result.m14783exceptionOrNullimpl(objM14780constructorimpl);
        if (thM14783exceptionOrNullimpl == null) {
            return Unit.INSTANCE;
        }
        throw new UndoEditFailedException("Could not perform undo action on z-index change.", thM14783exceptionOrNullimpl);
    }

    public final boolean a(AnnotationZIndexEdit annotationZIndexEdit) {
        Object objM14780constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Boolean bool = (Boolean) BuildersKt__BuildersKt.runBlocking$default(null, new a(annotationZIndexEdit, null), 1, null);
            bool.getClass();
            objM14780constructorimpl = Result.m14780constructorimpl(bool);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(th));
        }
        Boolean bool2 = Boolean.FALSE;
        if (Result.m14786isFailureimpl(objM14780constructorimpl)) {
            objM14780constructorimpl = bool2;
        }
        return ((Boolean) objM14780constructorimpl).booleanValue();
    }
}
