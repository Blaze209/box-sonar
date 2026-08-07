package com.pspdfkit.internal;

import android.graphics.PointF;
import com.pspdfkit.exceptions.ContentEditingUnavailableException;
import com.pspdfkit.undo.edit.Edit;
import com.pspdfkit.undo.edit.contentediting.ContentEditingTextBlockMoveAndResizeEdit;
import com.pspdfkit.undo.exceptions.UndoEditFailedException;
import java.util.ArrayList;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public final class fb extends ib<ContentEditingTextBlockMoveAndResizeEdit> {
    public final ab e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fb(ab abVar, q7.a<? super ContentEditingTextBlockMoveAndResizeEdit> aVar) {
        super(ContentEditingTextBlockMoveAndResizeEdit.class, aVar);
        abVar.getClass();
        this.e = abVar;
    }

    @Override // com.pspdfkit.internal.q7
    public final Object a(Edit edit, s7 s7Var) throws Throwable {
        a((ContentEditingTextBlockMoveAndResizeEdit) edit, false);
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.q7
    public final Object a(Edit edit, t7 t7Var) throws Throwable {
        a((ContentEditingTextBlockMoveAndResizeEdit) edit, true);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(ContentEditingTextBlockMoveAndResizeEdit contentEditingTextBlockMoveAndResizeEdit, boolean z) throws Throwable {
        ta taVar;
        try {
            i50 i50VarA = this.e.a(contentEditingTextBlockMoveAndResizeEdit.getPageIndex(), contentEditingTextBlockMoveAndResizeEdit.getTextBlockId());
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
            } while (taVar.c != contentEditingTextBlockMoveAndResizeEdit.getPageIndex());
            ta taVar2 = taVar;
            if (taVar2 != null) {
                t70 anchor = contentEditingTextBlockMoveAndResizeEdit.getAnchor(z);
                taVar2.a(i50VarA, anchor != null ? new PointF(anchor.a, anchor.b) : null, contentEditingTextBlockMoveAndResizeEdit.getSize(z));
                taVar2.a(i50VarA.c);
                return;
            }
            t70 anchor2 = contentEditingTextBlockMoveAndResizeEdit.getAnchor(z);
            if (anchor2 != null) {
                PointF pointF = new PointF(anchor2.a, anchor2.b);
                float f = pointF.x;
                t70 t70Var = i50VarA.d.a;
                PointF pointF2 = new PointF(f - t70Var.a, t70Var.b - pointF.y);
                l50 l50Var = i50VarA.d;
                t70 t70Var2 = new t70(pointF.x, pointF.y);
                l50Var.getClass();
                l50Var.a = t70Var2;
                i50VarA.c().a.getPageRect().offset(pointF2.x, pointF2.y);
            }
            Float size2 = contentEditingTextBlockMoveAndResizeEdit.getSize(z);
            if (size2 != null) {
                float fFloatValue = size2.floatValue();
                ab abVar = this.e;
                Float fValueOf = Float.valueOf(fFloatValue);
                abVar.getClass();
                g70 g70Var = (g70) abVar.a(new y00(i50VarA, abVar.a(i50VarA), fValueOf)).a;
                g70Var.getClass();
                tc tcVar = g70Var.e;
                zq zqVar = tcVar.a;
                i50VarA.e = g70Var;
                if (zqVar == null) {
                    tcVar.a = zqVar;
                }
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
