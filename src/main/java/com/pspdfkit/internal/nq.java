package com.pspdfkit.internal;

import com.pspdfkit.annotations.RichMediaAnnotation;
import com.pspdfkit.annotations.actions.RichMediaExecuteAction;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes3.dex */
public final class nq<T> implements Consumer {
    public final /* synthetic */ kq a;
    public final /* synthetic */ RichMediaExecuteAction b;

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RichMediaExecuteAction.RichMediaExecuteActionType.values().length];
            try {
                iArr[RichMediaExecuteAction.RichMediaExecuteActionType.PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RichMediaExecuteAction.RichMediaExecuteActionType.SEEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RichMediaExecuteAction.RichMediaExecuteActionType.REWIND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RichMediaExecuteAction.RichMediaExecuteActionType.PLAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RichMediaExecuteAction.RichMediaExecuteActionType.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    public nq(kq kqVar, RichMediaExecuteAction richMediaExecuteAction) {
        this.a = kqVar;
        this.b = richMediaExecuteAction;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        iq iqVarA;
        RichMediaAnnotation richMediaAnnotation = (RichMediaAnnotation) obj;
        richMediaAnnotation.getClass();
        Iterator it = this.a.f.keySet().iterator();
        do {
            if (!it.hasNext()) {
                iqVarA = iq.a(richMediaAnnotation);
                break;
            }
            iqVarA = (iq) it.next();
        } while (iqVarA.a != richMediaAnnotation);
        if (iqVarA == null) {
            return;
        }
        int i = a.a[this.b.getActionType().ordinal()];
        if (i == 1) {
            qq qqVarA = this.a.a(iqVarA);
            if (qqVarA.i.b()) {
                qqVarA.j = 5;
                qqVarA.a();
                return;
            }
            return;
        }
        if (i == 2) {
            kq kqVar = this.a;
            kqVar.a(iqVarA).i.b(kqVar.a(iqVarA).getPosition() + 5000);
        } else if (i == 3) {
            kq kqVar2 = this.a;
            kqVar2.a(iqVarA).i.b(kqVar2.a(iqVarA).getPosition() - 5000);
        } else {
            if (i != 4 && i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            qq qqVarA2 = this.a.a(iqVarA);
            if (qqVarA2.i.b()) {
                return;
            }
            qqVarA2.j = 4;
            qqVarA2.a();
        }
    }
}
