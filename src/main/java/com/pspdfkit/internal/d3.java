package com.pspdfkit.internal;

import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d3 implements gu {
    public final q0 a;
    public q30 b;

    public d3(q0 q0Var) {
        q0Var.getClass();
        this.a = q0Var;
    }

    @Override // com.pspdfkit.internal.gu
    public void a(q30 q30Var) {
        this.b = q30Var;
    }

    public abstract AnnotationTool h();

    public abstract AnnotationToolVariant i();

    public final lm j() {
        m40 state;
        au auVarL = l();
        if (auVarL == null || (state = auVarL.getState()) == null) {
            return null;
        }
        return state.a;
    }

    public final int k() {
        m40 state;
        au auVarL = l();
        if (auVarL == null || (state = auVarL.getState()) == null) {
            return 0;
        }
        return state.b;
    }

    public final au l() {
        q30 q30Var = this.b;
        if (q30Var != null) {
            return q30Var.getParentView();
        }
        return null;
    }
}
