package com.pspdfkit.internal;

import com.pspdfkit.undo.edit.Edit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q7<T extends Edit> implements y60<T> {
    public final Class<T> a;
    public final a<? super T> b;
    public final CoroutineScope c;
    public final String d;

    public interface a<T extends Edit> {
        void a(q7<? extends T> q7Var, T t);
    }

    public q7(Class cls, a aVar, int i) {
        aVar = (i & 2) != 0 ? null : aVar;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        CoroutineScope.getClass();
        this.a = cls;
        this.b = aVar;
        this.c = CoroutineScope;
        this.d = "Nutri.BaseUndoExecutor";
    }

    public abstract Object a(Edit edit, s7 s7Var);

    public abstract Object a(Edit edit, t7 t7Var);

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.pspdfkit.internal.y60
    public final Object a(Edit edit, ContinuationImpl continuationImpl) {
        s7 s7Var;
        if (continuationImpl instanceof s7) {
            s7Var = (s7) continuationImpl;
            int i = s7Var.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                s7Var.d = i - Integer.MIN_VALUE;
            } else {
                s7Var = new s7(this, continuationImpl);
            }
        } else {
            s7Var = new s7(this, continuationImpl);
        }
        Object obj = s7Var.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = s7Var.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            s7Var.a = edit;
            s7Var.d = 1;
            if (a(edit, s7Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            edit = s7Var.a;
            ResultKt.throwOnFailure(obj);
        }
        a<? super T> aVar = this.b;
        if (aVar != null) {
            BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new r7(aVar, this, edit, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.pspdfkit.internal.y60
    public final Object b(Edit edit, ContinuationImpl continuationImpl) {
        t7 t7Var;
        if (continuationImpl instanceof t7) {
            t7Var = (t7) continuationImpl;
            int i = t7Var.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                t7Var.d = i - Integer.MIN_VALUE;
            } else {
                t7Var = new t7(this, continuationImpl);
            }
        } else {
            t7Var = new t7(this, continuationImpl);
        }
        Object obj = t7Var.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = t7Var.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            t7Var.a = edit;
            t7Var.d = 1;
            if (a(edit, t7Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            edit = t7Var.a;
            ResultKt.throwOnFailure(obj);
        }
        a<? super T> aVar = this.b;
        if (aVar != null) {
            BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new r7(aVar, this, edit, null), 3, null);
        }
        return Unit.INSTANCE;
    }
}
