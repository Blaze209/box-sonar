package com.pspdfkit.internal;

import android.util.SparseIntArray;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.undo.edit.annotations.AnnotationEdit;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes3.dex */
public abstract class y4<T extends AnnotationEdit> extends q7<T> {
    public final o3 e;
    public final SparseIntArray f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y4(o3 o3Var, SparseIntArray sparseIntArray, Class<T> cls, q7.a<? super T> aVar) {
        super(cls, aVar, 4);
        o3Var.getClass();
        this.e = o3Var;
        this.f = sparseIntArray;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(AnnotationEdit annotationEdit, ContinuationImpl continuationImpl) {
        x4 x4Var;
        if (continuationImpl instanceof x4) {
            x4Var = (x4) continuationImpl;
            int i = x4Var.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                x4Var.d = i - Integer.MIN_VALUE;
            } else {
                x4Var = new x4(this, continuationImpl);
            }
        } else {
            x4Var = new x4(this, continuationImpl);
        }
        Object objA = x4Var.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = x4Var.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            x4Var.a = annotationEdit;
            x4Var.d = 1;
            o3 o3Var = this.e;
            int pageIndex = annotationEdit.getPageIndex();
            int objectNumber = annotationEdit.getObjectNumber();
            while (true) {
                int i3 = this.f.get(objectNumber, objectNumber);
                if (i3 == objectNumber) {
                    break;
                }
                objectNumber = i3;
            }
            o3Var.getClass();
            objA = o3.a(o3Var, pageIndex, objectNumber, x4Var);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            annotationEdit = x4Var.a;
            ResultKt.throwOnFailure(objA);
        }
        Annotation annotation = (Annotation) objA;
        if (annotation != null) {
            return annotation;
        }
        int objectNumber2 = annotationEdit.getObjectNumber();
        while (true) {
            int i4 = this.f.get(objectNumber2, objectNumber2);
            if (i4 == objectNumber2) {
                throw new IllegalStateException("Annotation with object number " + objectNumber2 + " on page index " + annotationEdit.getPageIndex() + " was not found.");
            }
            objectNumber2 = i4;
        }
    }
}
