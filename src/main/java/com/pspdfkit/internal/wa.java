package com.pspdfkit.internal;

import com.pspdfkit.contentediting.models.Alignment;
import com.pspdfkit.contentediting.models.TextBlockStyleInfo;
import com.pspdfkit.exceptions.ContentEditingUnavailableException;
import com.pspdfkit.undo.edit.Edit;
import com.pspdfkit.undo.edit.contentediting.ContentEditingNativeChangeEdit;
import com.pspdfkit.undo.exceptions.UndoEditFailedException;
import java.util.ArrayList;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public final class wa extends ib<ContentEditingNativeChangeEdit> {
    public final ab e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wa(ab abVar, q7.a<? super ContentEditingNativeChangeEdit> aVar) {
        super(ContentEditingNativeChangeEdit.class, aVar);
        abVar.getClass();
        this.e = abVar;
    }

    @Override // com.pspdfkit.internal.q7
    public final Object a(Edit edit, s7 s7Var) {
        a((ContentEditingNativeChangeEdit) edit, false);
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.y60
    public final <T extends ContentEditingNativeChangeEdit> boolean a(Class<T> cls) {
        return true;
    }

    @Override // com.pspdfkit.internal.q7
    public final Object a(Edit edit, t7 t7Var) {
        a((ContentEditingNativeChangeEdit) edit, true);
        return Unit.INSTANCE;
    }

    public final void a(final ContentEditingNativeChangeEdit contentEditingNativeChangeEdit, final boolean z) throws UndoEditFailedException {
        ta taVar;
        try {
            ab abVar = this.e;
            final i50 i50VarA = abVar.a(contentEditingNativeChangeEdit.getPageIndex(), contentEditingNativeChangeEdit.getTextBlockId());
            if (i50VarA == null) {
                return;
            }
            ArrayList<ta> arrayList = abVar.i;
            int size = arrayList.size();
            int i = 0;
            do {
                if (i >= size) {
                    taVar = null;
                    break;
                } else {
                    taVar = arrayList.get(i);
                    i++;
                }
            } while (taVar.c != contentEditingNativeChangeEdit.getPageIndex());
            final ta taVar2 = taVar;
            int iM14307versionOGnWXxg = contentEditingNativeChangeEdit.m14307versionOGnWXxg(z);
            if (iM14307versionOGnWXxg != i50VarA.e.g) {
                ng externalControlState = contentEditingNativeChangeEdit.getExternalControlState();
                externalControlState.getClass();
                abVar.a(new kz(i50VarA, abVar.a(i50VarA), iM14307versionOGnWXxg, externalControlState));
            }
            Boolean boolIsDeleted = contentEditingNativeChangeEdit.isDeleted(z);
            if (boolIsDeleted != null) {
                i50VarA.b = boolIsDeleted.booleanValue();
            }
            if (taVar2 != null) {
                taVar2.a(i50VarA, false, true, true);
                h60.a(new Runnable() { // from class: com.pspdfkit.internal.wa$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        wa.a(taVar2, i50VarA, contentEditingNativeChangeEdit, z);
                    }
                });
            }
        } catch (ContentEditingUnavailableException unused) {
        } catch (Exception e) {
            String str = z ? "undo" : null;
            if (str == null) {
                str = "redo";
            }
            throw new UndoEditFailedException("Content Editing " + str + " operation failed", e);
        }
    }

    public static final void a(ta taVar, i50 i50Var, ContentEditingNativeChangeEdit contentEditingNativeChangeEdit, boolean z) {
        l50 l50Var = i50Var.d;
        Alignment alignment = l50Var.b;
        Float f = l50Var.d;
        aj ajVar = l50Var.c;
        TextBlockStyleInfo textBlockStyleInfo = new TextBlockStyleInfo(alignment, f, ajVar.a, ajVar.b);
        taVar.getClass();
        taVar.a.onTextBlockStyleChange(i50Var.c, textBlockStyleInfo);
        Integer numSelStart = contentEditingNativeChangeEdit.selStart(z);
        if (numSelStart != null) {
            int iB = i50Var.b(numSelStart.intValue());
            Integer numSelEnd = contentEditingNativeChangeEdit.selEnd(z);
            Integer numValueOf = numSelEnd != null ? Integer.valueOf(i50Var.b(numSelEnd.intValue())) : null;
            Integer num = (numValueOf == null || numValueOf.intValue() - iB != 1) ? numValueOf : null;
            gb gbVar = taVar.p;
            if (gbVar == null) {
                return;
            }
            if (num != null && num.intValue() != iB) {
                int iIntValue = num.intValue();
                int i = gb.b0;
                gbVar.a(iB, iIntValue, true);
            } else {
                int i2 = gb.b0;
                gbVar.b(iB, true);
            }
        }
    }
}
