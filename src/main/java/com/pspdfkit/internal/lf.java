package com.pspdfkit.internal;

import com.pspdfkit.undo.edit.CompoundEdit;
import com.pspdfkit.undo.edit.Edit;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public class lf<T extends Edit> {
    public final at a;
    public boolean b;
    public ArrayList c;

    public lf(at atVar) {
        atVar.getClass();
        this.a = atVar;
        this.c = new ArrayList();
    }

    public final <R> R a(Function0<? extends R> function0) {
        function0.getClass();
        b();
        try {
            R rInvoke = function0.invoke();
            c();
            return rInvoke;
        } catch (Throwable th) {
            try {
                this.b = false;
                this.c.clear();
                throw th;
            } catch (Throwable th2) {
                c();
                throw th2;
            }
        }
    }

    public void a() {
    }

    public void b() {
        this.b = true;
    }

    public void c() {
        this.b = false;
        if (this.c.isEmpty()) {
            return;
        }
        a();
        at atVar = this.a;
        int size = this.c.size();
        ArrayList arrayList = this.c;
        atVar.a(size == 1 ? (Edit) CollectionsKt.first((List) arrayList) : new CompoundEdit(arrayList));
        this.c = new ArrayList();
    }
}
