package com.pspdfkit.internal;

import com.pspdfkit.contentediting.models.Alignment;
import com.pspdfkit.contentediting.models.TextBlockStyleInfo;
import com.pspdfkit.exceptions.ContentEditingUnavailableException;
import com.pspdfkit.undo.edit.Edit;
import com.pspdfkit.undo.edit.contentediting.ContentEditingTextBlockLineSpacingEdit;
import com.pspdfkit.undo.exceptions.UndoEditFailedException;
import java.util.ArrayList;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public final class eb extends ib<ContentEditingTextBlockLineSpacingEdit> {
    public final ab e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eb(ab abVar, q7.a<? super ContentEditingTextBlockLineSpacingEdit> aVar) {
        super(ContentEditingTextBlockLineSpacingEdit.class, aVar);
        abVar.getClass();
        this.e = abVar;
    }

    @Override // com.pspdfkit.internal.q7
    public final Object a(Edit edit, s7 s7Var) {
        a((ContentEditingTextBlockLineSpacingEdit) edit, false);
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.q7
    public final Object a(Edit edit, t7 t7Var) {
        a((ContentEditingTextBlockLineSpacingEdit) edit, true);
        return Unit.INSTANCE;
    }

    public final void a(ContentEditingTextBlockLineSpacingEdit contentEditingTextBlockLineSpacingEdit, boolean z) {
        ta taVar;
        try {
            i50 i50VarA = this.e.a(contentEditingTextBlockLineSpacingEdit.getPageIndex(), contentEditingTextBlockLineSpacingEdit.getTextBlockId());
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
            } while (taVar.c != contentEditingTextBlockLineSpacingEdit.getPageIndex());
            ta taVar2 = taVar;
            ab abVar = this.e;
            Float lineSpacing = contentEditingTextBlockLineSpacingEdit.getLineSpacing(z);
            abVar.getClass();
            abVar.a(new x00(i50VarA, abVar.a(i50VarA), lineSpacing));
            if (taVar2 != null) {
                taVar2.a(i50VarA, false, true, false);
                taVar2.a(i50VarA.c);
                l50 l50Var = i50VarA.d;
                Alignment alignment = l50Var.b;
                Float f = l50Var.d;
                aj ajVar = l50Var.c;
                taVar2.a.onTextBlockStyleChange(i50VarA.c, new TextBlockStyleInfo(alignment, f, ajVar.a, ajVar.b));
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
}
