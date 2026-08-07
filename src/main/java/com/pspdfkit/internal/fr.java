package com.pspdfkit.internal;

import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.ActionSender;
import com.pspdfkit.annotations.actions.NamedAction;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.navigation.PageNavigator;
import com.pspdfkit.utils.PdfLog;

/* JADX INFO: loaded from: classes3.dex */
public final class fr implements c<NamedAction> {
    public final PageNavigator a;

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[NamedAction.NamedActionType.values().length];
            try {
                iArr[NamedAction.NamedActionType.GOFORWARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NamedAction.NamedActionType.NEXTPAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NamedAction.NamedActionType.GOBACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[NamedAction.NamedActionType.PREVIOUSPAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[NamedAction.NamedActionType.FIRSTPAGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[NamedAction.NamedActionType.LASTPAGE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[NamedAction.NamedActionType.GOTOPAGE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            a = iArr;
        }
    }

    public fr(PdfFragment pdfFragment) {
        pdfFragment.getClass();
        this.a = pdfFragment;
    }

    public final void a(NamedAction namedAction, ActionSender actionSender) {
        int pageIndex = this.a.getPageIndex();
        int pageCount = this.a.getPageCount();
        this.a.beginNavigation();
        switch (a.a[namedAction.getNamedActionType().ordinal()]) {
            case 1:
            case 2:
                if (pageIndex < pageCount - 1) {
                    this.a.setPageIndex(pageIndex + 1);
                } else {
                    PdfLog.d("Nutri.NamedActionExec", "Go to next page action executed, but the current page is already the last one.", new Object[0]);
                }
                break;
            case 3:
            case 4:
                if (pageIndex > 0) {
                    this.a.setPageIndex(pageIndex - 1);
                } else {
                    PdfLog.d("Nutri.NamedActionExec", "Go to previous page action executed, but the current page is already the first one.", new Object[0]);
                }
                break;
            case 5:
                this.a.setPageIndex(0);
                break;
            case 6:
                this.a.setPageIndex(pageCount - 1);
                break;
            case 7:
                int pageIndex2 = actionSender != null ? actionSender.getPageIndex() : Integer.MIN_VALUE;
                if (pageIndex2 >= 0 && pageIndex2 <= pageCount - 1) {
                    this.a.setPageIndex(pageIndex2);
                } else {
                    PdfLog.w("Nutri.NamedActionExec", "Go to page action executed, but the target page doesn't exist in the current document.", new Object[0]);
                }
                break;
            default:
                PdfLog.w("Nutri.NamedActionExec", "Unknown named action type: " + namedAction.getNamedActionType(), new Object[0]);
                break;
        }
        this.a.endNavigation();
    }

    @Override // com.pspdfkit.internal.c
    public final /* bridge */ /* synthetic */ boolean executeAction(Action action, ActionSender actionSender) {
        a((NamedAction) action, actionSender);
        return true;
    }
}
