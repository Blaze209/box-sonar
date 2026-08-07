package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.R;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.configuration.sharing.ShareFeatures;
import com.pspdfkit.document.DocumentPermissions;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.printing.DocumentPrintManager;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.ui.PdfActivity;
import com.pspdfkit.ui.PdfReaderView;
import java.util.ArrayList;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class bv {
    public final Context a;
    public final PdfActivityConfiguration b;
    public final cv c;
    public PdfDocument d;
    public a e;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.pspdfkit.internal.bv$a[], still in use, count: 1, list:
      (r0v1 com.pspdfkit.internal.bv$a[]) from 0x004c: INVOKE (r0v1 com.pspdfkit.internal.bv$a[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class a {
        NONE,
        THUMBNAIL_GRID,
        OUTLINE,
        SEARCH,
        ANNOTATION_CREATION,
        READER_VIEW,
        CONTENT_EDITING;

        static {
            EnumEntriesKt.enumEntries(aVarArr);
        }

        public a() {
            super(str, i);
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) h.clone();
        }
    }

    public bv(Context context, PdfActivityConfiguration pdfActivityConfiguration) {
        context.getClass();
        pdfActivityConfiguration.getClass();
        this.a = context;
        this.b = pdfActivityConfiguration;
        this.c = new cv(context);
        this.e = a.NONE;
    }

    public final ArrayList a() {
        ArrayList arrayList = new ArrayList();
        tg tgVarB = ar.b();
        tgVarB.getClass();
        tg tgVarB2 = ar.b();
        PdfConfiguration configuration = this.b.getConfiguration();
        synchronized (tgVarB2) {
            configuration.getClass();
            if (tgVarB2.a(NativeLicenseFeatures.ANNOTATION_EDITING) && configuration.isAnnotationEditingEnabled()) {
                arrayList.add(Integer.valueOf(PdfActivity.MENU_OPTION_EDIT_ANNOTATIONS));
            }
        }
        PdfActivityConfiguration pdfActivityConfiguration = this.b;
        pdfActivityConfiguration.getClass();
        if (pdfActivityConfiguration.getConfiguration().isAiAssistantEnabled()) {
            arrayList.add(Integer.valueOf(PdfActivity.MENU_OPTION_AI_ASSISTANT));
        }
        if (ar.b().d(this.b.getConfiguration())) {
            arrayList.add(Integer.valueOf(PdfActivity.MENU_OPTION_EDIT_CONTENT));
        }
        if (sg.a(this.b, tgVarB)) {
            arrayList.add(Integer.valueOf(PdfActivity.MENU_OPTION_SIGNATURE));
        }
        PdfActivityConfiguration pdfActivityConfiguration2 = this.b;
        pdfActivityConfiguration2.getClass();
        if (pdfActivityConfiguration2.isOutlineEnabled() || pdfActivityConfiguration2.isAnnotationListEnabled() || pdfActivityConfiguration2.isBookmarkListEnabled()) {
            arrayList.add(Integer.valueOf(PdfActivity.MENU_OPTION_OUTLINE));
        }
        PdfActivityConfiguration pdfActivityConfiguration3 = this.b;
        Context context = this.a;
        pdfActivityConfiguration3.getClass();
        context.getClass();
        if (pdfActivityConfiguration3.isReaderViewEnabled() && PdfReaderView.doesDeviceSupportReaderView(context)) {
            arrayList.add(Integer.valueOf(PdfActivity.MENU_OPTION_READER_VIEW));
        }
        if (this.b.isSearchEnabled()) {
            arrayList.add(Integer.valueOf(PdfActivity.MENU_OPTION_SEARCH));
        }
        if (this.b.isSettingsItemEnabled()) {
            arrayList.add(Integer.valueOf(PdfActivity.MENU_OPTION_SETTINGS));
        }
        PdfActivityConfiguration pdfActivityConfiguration4 = this.b;
        pdfActivityConfiguration4.getClass();
        if (pdfActivityConfiguration4.getConfiguration().getEnabledShareFeatures().contains(ShareFeatures.DOCUMENT_SHARING) || DocumentPrintManager.get().isPrintingAvailable(pdfActivityConfiguration4)) {
            arrayList.add(Integer.valueOf(PdfActivity.MENU_OPTION_SHARE));
        }
        if (this.b.isThumbnailGridEnabled()) {
            arrayList.add(Integer.valueOf(PdfActivity.MENU_OPTION_THUMBNAIL_GRID));
        }
        PdfActivityConfiguration pdfActivityConfiguration5 = this.b;
        pdfActivityConfiguration5.getClass();
        if (pdfActivityConfiguration5.isDocumentInfoViewEnabled() && pdfActivityConfiguration5.isDocumentInfoViewSeparated()) {
            arrayList.add(Integer.valueOf(PdfActivity.MENU_OPTION_DOCUMENT_INFO));
        }
        return arrayList;
    }

    public final String b(int i) {
        int i2;
        if (i == PdfActivity.MENU_OPTION_EDIT_ANNOTATIONS) {
            i2 = R.string.pspdf__annotations;
        } else if (i == PdfActivity.MENU_OPTION_AI_ASSISTANT) {
            i2 = R.string.pspdf__ai_assistant_title;
        } else if (i == PdfActivity.MENU_OPTION_EDIT_CONTENT) {
            i2 = R.string.pspdf__contentediting_title;
        } else if (i == PdfActivity.MENU_OPTION_SIGNATURE) {
            i2 = R.string.pspdf__signature;
        } else if (i == PdfActivity.MENU_OPTION_OUTLINE) {
            i2 = R.string.pspdf__activity_menu_outline;
        } else if (i == PdfActivity.MENU_OPTION_SEARCH) {
            i2 = R.string.pspdf__activity_menu_search;
        } else if (i == PdfActivity.MENU_OPTION_SETTINGS) {
            i2 = R.string.pspdf__activity_menu_settings;
        } else if (i == PdfActivity.MENU_OPTION_READER_VIEW) {
            i2 = R.string.pspdf__activity_menu_reader_view;
        } else if (i == PdfActivity.MENU_OPTION_SHARE) {
            i2 = !this.b.getConfiguration().getEnabledShareFeatures().contains(ShareFeatures.DOCUMENT_SHARING) ? R.string.pspdf__print : R.string.pspdf__share;
        } else if (i == PdfActivity.MENU_OPTION_THUMBNAIL_GRID) {
            i2 = R.string.pspdf__activity_menu_pagegrid;
        } else {
            i2 = i == PdfActivity.MENU_OPTION_DOCUMENT_INFO ? R.string.pspdf__document_info : 0;
        }
        return i2 != 0 ? no.a(this.a, i2, null) : "";
    }

    public final boolean c(int i) {
        if (i == PdfActivity.MENU_OPTION_THUMBNAIL_GRID && this.e == a.THUMBNAIL_GRID) {
            return true;
        }
        if (i == PdfActivity.MENU_OPTION_OUTLINE && this.e == a.OUTLINE) {
            return true;
        }
        if (i == PdfActivity.MENU_OPTION_SEARCH && this.e == a.SEARCH) {
            return true;
        }
        if (i == PdfActivity.MENU_OPTION_EDIT_ANNOTATIONS && this.e == a.ANNOTATION_CREATION) {
            return true;
        }
        if (i == PdfActivity.MENU_OPTION_SIGNATURE && this.e == a.ANNOTATION_CREATION) {
            return true;
        }
        if (i == PdfActivity.MENU_OPTION_READER_VIEW && this.e == a.READER_VIEW) {
            return true;
        }
        return i == PdfActivity.MENU_OPTION_EDIT_CONTENT && this.e == a.CONTENT_EDITING;
    }

    public final boolean d(int i) {
        PdfDocument pdfDocument = this.d;
        if (i == PdfActivity.MENU_OPTION_EDIT_ANNOTATIONS || i == PdfActivity.MENU_OPTION_SIGNATURE) {
            return pdfDocument != null && pdfDocument.hasPermission(DocumentPermissions.ANNOTATIONS_AND_FORMS);
        }
        if (i == PdfActivity.MENU_OPTION_AI_ASSISTANT) {
            return pdfDocument != null && pdfDocument.getDocumentSources().size() == 1;
        }
        if (i == PdfActivity.MENU_OPTION_OUTLINE) {
            if (pdfDocument == null) {
                return false;
            }
            return (this.b.isOutlineEnabled() && pdfDocument.hasOutline()) || this.b.isAnnotationListEnabled() || this.b.isBookmarkListEnabled();
        }
        if (i == PdfActivity.MENU_OPTION_SHARE) {
            return pdfDocument != null && ((pdfDocument != null && DocumentPrintManager.get().isPrintingEnabled(this.b, pdfDocument)) || this.b.getConfiguration().getEnabledShareFeatures().contains(ShareFeatures.DOCUMENT_SHARING));
        }
        if (i == PdfActivity.MENU_OPTION_EDIT_CONTENT) {
            return pdfDocument != null && pdfDocument.isWritableAndCanSave();
        }
        return pdfDocument != null;
    }

    public final int a(int i) {
        if (i == PdfActivity.MENU_OPTION_EDIT_ANNOTATIONS) {
            boolean zC = c(i);
            cv cvVar = this.c;
            if (zC) {
                return cvVar.C;
            }
            return cvVar.A;
        }
        if (i == PdfActivity.MENU_OPTION_AI_ASSISTANT) {
            return this.c.B;
        }
        if (i == PdfActivity.MENU_OPTION_EDIT_CONTENT) {
            boolean zC2 = c(i);
            cv cvVar2 = this.c;
            if (zC2) {
                return cvVar2.E;
            }
            return cvVar2.D;
        }
        if (i == PdfActivity.MENU_OPTION_SIGNATURE) {
            boolean zC3 = c(i);
            cv cvVar3 = this.c;
            if (zC3) {
                return cvVar3.G;
            }
            return cvVar3.F;
        }
        if (i == PdfActivity.MENU_OPTION_OUTLINE) {
            boolean zC4 = c(i);
            cv cvVar4 = this.c;
            if (zC4) {
                return cvVar4.K;
            }
            return cvVar4.x;
        }
        if (i == PdfActivity.MENU_OPTION_SEARCH) {
            boolean zC5 = c(i);
            cv cvVar5 = this.c;
            if (zC5) {
                return cvVar5.L;
            }
            return cvVar5.y;
        }
        if (i == PdfActivity.MENU_OPTION_SETTINGS) {
            boolean zC6 = c(i);
            cv cvVar6 = this.c;
            if (zC6) {
                return cvVar6.N;
            }
            return cvVar6.J;
        }
        if (i == PdfActivity.MENU_OPTION_READER_VIEW) {
            boolean zC7 = c(i);
            cv cvVar7 = this.c;
            if (zC7) {
                return cvVar7.P;
            }
            return cvVar7.O;
        }
        if (i == PdfActivity.MENU_OPTION_SHARE) {
            boolean zContains = this.b.getConfiguration().getEnabledShareFeatures().contains(ShareFeatures.DOCUMENT_SHARING);
            cv cvVar8 = this.c;
            if (zContains) {
                return cvVar8.H;
            }
            return cvVar8.I;
        }
        if (i == PdfActivity.MENU_OPTION_THUMBNAIL_GRID) {
            boolean zC8 = c(i);
            cv cvVar9 = this.c;
            if (zC8) {
                return cvVar9.M;
            }
            return cvVar9.z;
        }
        if (i != PdfActivity.MENU_OPTION_DOCUMENT_INFO) {
            return 0;
        }
        boolean zC9 = c(i);
        cv cvVar10 = this.c;
        if (zC9) {
            return cvVar10.R;
        }
        return cvVar10.Q;
    }
}
