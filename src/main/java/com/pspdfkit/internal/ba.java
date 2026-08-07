package com.pspdfkit.internal;

import com.pspdfkit.undo.edit.CompoundEdit;
import com.pspdfkit.undo.edit.Edit;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ba extends q7<CompoundEdit> {
    public final z60 e;

    public ba(z60 z60Var) {
        super(CompoundEdit.class, null, 6);
        this.e = z60Var;
    }

    @Override // com.pspdfkit.internal.y60
    public final boolean a(Edit edit) {
        CompoundEdit compoundEdit = (CompoundEdit) edit;
        compoundEdit.getClass();
        Edit edit2 = (Edit) CollectionsKt.lastOrNull((List) compoundEdit.getEdits());
        if (edit2 == null) {
            return false;
        }
        z60 z60Var = this.e;
        z60Var.getClass();
        return z60Var.a(edit2.getClass()).a(edit2);
    }

    @Override // com.pspdfkit.internal.y60
    public final boolean b(Edit edit) {
        CompoundEdit compoundEdit = (CompoundEdit) edit;
        compoundEdit.getClass();
        Edit edit2 = (Edit) CollectionsKt.firstOrNull((List) compoundEdit.getEdits());
        if (edit2 == null) {
            return false;
        }
        z60 z60Var = this.e;
        z60Var.getClass();
        return z60Var.a(edit2.getClass()).b(edit2);
    }

    @Override // com.pspdfkit.internal.q7
    public final /* bridge */ /* synthetic */ Object a(Edit edit, s7 s7Var) {
        return a((CompoundEdit) edit, (ContinuationImpl) s7Var);
    }

    @Override // com.pspdfkit.internal.q7
    public final /* bridge */ /* synthetic */ Object a(Edit edit, t7 t7Var) {
        return b((CompoundEdit) edit, (ContinuationImpl) t7Var);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(CompoundEdit compoundEdit, ContinuationImpl continuationImpl) {
        z9 z9Var;
        Iterable edits;
        Iterator it;
        CompoundEdit compoundEdit2;
        int i;
        if (continuationImpl instanceof z9) {
            z9Var = (z9) continuationImpl;
            int i2 = z9Var.i;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                z9Var.i = i2 - Integer.MIN_VALUE;
            } else {
                z9Var = new z9(this, continuationImpl);
            }
        } else {
            z9Var = new z9(this, continuationImpl);
        }
        Object obj = z9Var.g;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = z9Var.i;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            edits = compoundEdit.getEdits();
            it = edits.iterator();
            compoundEdit2 = compoundEdit;
            i = 0;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = z9Var.f;
            it = z9Var.c;
            edits = (Iterable) z9Var.b;
            compoundEdit2 = (CompoundEdit) z9Var.a;
            ResultKt.throwOnFailure(obj);
        }
        while (it.hasNext()) {
            Object next = it.next();
            Edit edit = (Edit) next;
            z60 z60Var = this.e;
            z60Var.getClass();
            edit.getClass();
            y60 y60VarA = z60Var.a(edit.getClass());
            z9Var.a = SpillingKt.nullOutSpilledVariable(compoundEdit2);
            z9Var.b = SpillingKt.nullOutSpilledVariable(edits);
            z9Var.c = it;
            z9Var.d = SpillingKt.nullOutSpilledVariable(next);
            z9Var.e = SpillingKt.nullOutSpilledVariable(edit);
            z9Var.f = i;
            z9Var.i = 1;
            if (y60VarA.a(edit, z9Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b(CompoundEdit compoundEdit, ContinuationImpl continuationImpl) {
        aa aaVar;
        Iterable iterableAsReversed;
        Iterator it;
        CompoundEdit compoundEdit2;
        int i;
        if (continuationImpl instanceof aa) {
            aaVar = (aa) continuationImpl;
            int i2 = aaVar.i;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                aaVar.i = i2 - Integer.MIN_VALUE;
            } else {
                aaVar = new aa(this, continuationImpl);
            }
        } else {
            aaVar = new aa(this, continuationImpl);
        }
        Object obj = aaVar.g;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = aaVar.i;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            iterableAsReversed = CollectionsKt.asReversed(compoundEdit.getEdits());
            it = iterableAsReversed.iterator();
            compoundEdit2 = compoundEdit;
            i = 0;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = aaVar.f;
            it = aaVar.c;
            iterableAsReversed = (Iterable) aaVar.b;
            compoundEdit2 = (CompoundEdit) aaVar.a;
            ResultKt.throwOnFailure(obj);
        }
        while (it.hasNext()) {
            Object next = it.next();
            Edit edit = (Edit) next;
            z60 z60Var = this.e;
            z60Var.getClass();
            edit.getClass();
            y60 y60VarA = z60Var.a(edit.getClass());
            aaVar.a = SpillingKt.nullOutSpilledVariable(compoundEdit2);
            aaVar.b = SpillingKt.nullOutSpilledVariable(iterableAsReversed);
            aaVar.c = it;
            aaVar.d = SpillingKt.nullOutSpilledVariable(next);
            aaVar.e = SpillingKt.nullOutSpilledVariable(edit);
            aaVar.f = i;
            aaVar.i = 1;
            if (y60VarA.b(edit, aaVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
