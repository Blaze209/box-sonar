package com.pspdfkit.internal;

import com.pspdfkit.contentediting.models.Alignment;
import com.pspdfkit.contentediting.models.TextBlockStyleInfo;
import com.pspdfkit.exceptions.ContentEditingUnavailableException;
import com.pspdfkit.undo.edit.Edit;
import com.pspdfkit.undo.edit.contentediting.ContentEditingTextBlockAlignmentEdit;
import com.pspdfkit.undo.exceptions.UndoEditFailedException;
import java.util.ArrayList;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public final class db extends ib<ContentEditingTextBlockAlignmentEdit> {
    public final ab e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public db(ab abVar, q7.a<? super ContentEditingTextBlockAlignmentEdit> aVar) {
        super(ContentEditingTextBlockAlignmentEdit.class, aVar);
        abVar.getClass();
        this.e = abVar;
    }

    @Override // com.pspdfkit.internal.q7
    public final Object a(Edit edit, s7 s7Var) {
        a((ContentEditingTextBlockAlignmentEdit) edit, false);
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.q7
    public final Object a(Edit edit, t7 t7Var) {
        a((ContentEditingTextBlockAlignmentEdit) edit, true);
        return Unit.INSTANCE;
    }

    public final void a(ContentEditingTextBlockAlignmentEdit contentEditingTextBlockAlignmentEdit, boolean z) {
        ta taVar;
        try {
            final i50 i50VarA = this.e.a(contentEditingTextBlockAlignmentEdit.getPageIndex(), contentEditingTextBlockAlignmentEdit.getTextBlockId());
            if (i50VarA == null) {
                return;
            }
            ArrayList<ta> arrayList = this.e.i;
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
            } while (taVar.c != contentEditingTextBlockAlignmentEdit.getPageIndex());
            final ta taVar2 = taVar;
            ab abVar = this.e;
            Alignment alignment = contentEditingTextBlockAlignmentEdit.getAlignment(z);
            abVar.getClass();
            alignment.getClass();
            abVar.a(new w00(i50VarA, abVar.a(i50VarA), alignment));
            if (taVar2 != null) {
                taVar2.a(i50VarA, false, true, false);
                h60.a(new Runnable() { // from class: com.pspdfkit.internal.db$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        db.a(taVar2, i50VarA);
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

    public static final void a(ta taVar, i50 i50Var) {
        taVar.a(i50Var.c);
        l50 l50Var = i50Var.d;
        Alignment alignment = l50Var.b;
        Float f = l50Var.d;
        aj ajVar = l50Var.c;
        taVar.a.onTextBlockStyleChange(i50Var.c, new TextBlockStyleInfo(alignment, f, ajVar.a, ajVar.b));
    }
}
