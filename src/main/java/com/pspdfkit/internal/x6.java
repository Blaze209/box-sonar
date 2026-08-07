package com.pspdfkit.internal;

import android.util.SparseIntArray;
import com.pspdfkit.annotations.SoundAnnotation;
import com.pspdfkit.undo.edit.Edit;
import com.pspdfkit.undo.edit.annotations.AnnotationEdit;
import com.pspdfkit.undo.edit.annotations.AudioResourceEdit;
import com.pspdfkit.undo.exceptions.RedoEditFailedException;
import com.pspdfkit.undo.exceptions.UndoEditFailedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* JADX INFO: loaded from: classes3.dex */
public final class x6 extends y4<AudioResourceEdit> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x6(o3 o3Var, SparseIntArray sparseIntArray, q7.a<? super AudioResourceEdit> aVar) {
        super(o3Var, sparseIntArray, AudioResourceEdit.class, aVar);
        o3Var.getClass();
    }

    @Override // com.pspdfkit.internal.y60
    public final boolean a(Edit edit) {
        AudioResourceEdit audioResourceEdit = (AudioResourceEdit) edit;
        audioResourceEdit.getClass();
        try {
            return ((Boolean) BuildersKt__BuildersKt.runBlocking$default(null, new u6(this, audioResourceEdit, null), 1, null)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.pspdfkit.internal.y60
    public final boolean b(Edit edit) {
        AudioResourceEdit audioResourceEdit = (AudioResourceEdit) edit;
        audioResourceEdit.getClass();
        try {
            return ((Boolean) BuildersKt__BuildersKt.runBlocking$default(null, new u6(this, audioResourceEdit, null), 1, null)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.pspdfkit.internal.q7
    public final /* bridge */ /* synthetic */ Object a(Edit edit, s7 s7Var) {
        return a((AudioResourceEdit) edit, (ContinuationImpl) s7Var);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b(AudioResourceEdit audioResourceEdit, ContinuationImpl continuationImpl) {
        w6 w6Var;
        if (continuationImpl instanceof w6) {
            w6Var = (w6) continuationImpl;
            int i = w6Var.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                w6Var.d = i - Integer.MIN_VALUE;
            } else {
                w6Var = new w6(this, continuationImpl);
            }
        } else {
            w6Var = new w6(this, continuationImpl);
        }
        Object objA = w6Var.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = w6Var.d;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objA);
                w6Var.a = SpillingKt.nullOutSpilledVariable(audioResourceEdit);
                w6Var.d = 1;
                objA = a((AnnotationEdit) audioResourceEdit, (ContinuationImpl) w6Var);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objA);
            }
            SoundAnnotation soundAnnotation = objA instanceof SoundAnnotation ? (SoundAnnotation) objA : null;
            if (soundAnnotation != null) {
                soundAnnotation.setAudioSource(null);
            }
            return Unit.INSTANCE;
        } catch (Exception e) {
            throw new UndoEditFailedException("Could not perform undo operation.", e);
        }
    }

    @Override // com.pspdfkit.internal.q7
    public final /* bridge */ /* synthetic */ Object a(Edit edit, t7 t7Var) {
        return b((AudioResourceEdit) edit, (ContinuationImpl) t7Var);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(AudioResourceEdit audioResourceEdit, ContinuationImpl continuationImpl) {
        v6 v6Var;
        if (continuationImpl instanceof v6) {
            v6Var = (v6) continuationImpl;
            int i = v6Var.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                v6Var.d = i - Integer.MIN_VALUE;
            } else {
                v6Var = new v6(this, continuationImpl);
            }
        } else {
            v6Var = new v6(this, continuationImpl);
        }
        Object objA = v6Var.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = v6Var.d;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objA);
                v6Var.a = audioResourceEdit;
                v6Var.d = 1;
                objA = a((AnnotationEdit) audioResourceEdit, (ContinuationImpl) v6Var);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                audioResourceEdit = v6Var.a;
                ResultKt.throwOnFailure(objA);
            }
            SoundAnnotation soundAnnotation = objA instanceof SoundAnnotation ? (SoundAnnotation) objA : null;
            if (soundAnnotation != null) {
                soundAnnotation.setAudioSource(audioResourceEdit.getAudioData());
            }
            return Unit.INSTANCE;
        } catch (Exception e) {
            throw new RedoEditFailedException("Could not perform redo operation.", e);
        }
    }
}
