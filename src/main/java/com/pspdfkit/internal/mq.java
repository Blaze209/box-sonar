package com.pspdfkit.internal;

import com.pspdfkit.annotations.ScreenAnnotation;
import com.pspdfkit.annotations.actions.RenditionAction;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes3.dex */
public final class mq<T> implements Consumer {
    public final /* synthetic */ kq a;
    public final /* synthetic */ RenditionAction b;

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RenditionAction.RenditionActionType.values().length];
            try {
                iArr[RenditionAction.RenditionActionType.PLAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RenditionAction.RenditionActionType.PLAY_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RenditionAction.RenditionActionType.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RenditionAction.RenditionActionType.RESUME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RenditionAction.RenditionActionType.STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[RenditionAction.RenditionActionType.UNKNOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            a = iArr;
        }
    }

    public mq(kq kqVar, RenditionAction renditionAction) {
        this.a = kqVar;
        this.b = renditionAction;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        iq iqVarA;
        ScreenAnnotation screenAnnotation = (ScreenAnnotation) obj;
        screenAnnotation.getClass();
        Iterator it = this.a.f.keySet().iterator();
        do {
            if (!it.hasNext()) {
                iqVarA = iq.a(screenAnnotation);
                break;
            }
            iqVarA = (iq) it.next();
        } while (iqVarA.a != screenAnnotation);
        if (iqVarA == null) {
            return;
        }
        switch (a.a[this.b.getRenditionActionType().ordinal()]) {
            case 1:
                qq qqVarA = this.a.a(iqVarA);
                if (qqVarA.i.b()) {
                    return;
                }
                qqVarA.j = 4;
                qqVarA.a();
                return;
            case 2:
                kq kqVar = this.a;
                if (kqVar.a(iqVarA).i.b()) {
                    kqVar.b(iqVarA);
                    return;
                }
                qq qqVarA2 = kqVar.a(iqVarA);
                if (qqVarA2.i.b()) {
                    return;
                }
                qqVarA2.j = 4;
                qqVarA2.a();
                return;
            case 3:
                qq qqVarA3 = this.a.a(iqVarA);
                if (qqVarA3.i.b()) {
                    qqVarA3.j = 5;
                    qqVarA3.a();
                    return;
                }
                return;
            case 4:
                qq qqVarA4 = this.a.a(iqVarA);
                if (qqVarA4.i.b()) {
                    return;
                }
                qqVarA4.j = 4;
                qqVarA4.a();
                return;
            case 5:
                this.a.b(iqVarA);
                return;
            case 6:
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
