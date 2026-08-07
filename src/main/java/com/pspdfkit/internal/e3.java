package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.pspdfkit.R;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.FileAnnotation;
import com.pspdfkit.annotations.SoundAnnotation;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.annotations.configuration.AnnotationProperty;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.sharing.ShareFeatures;
import com.pspdfkit.document.DocumentPermissions;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.sharing.DocumentSharingProviderProcessor;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.listeners.OnPreparePopupToolbarListener;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.PopupToolbar;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import com.pspdfkit.ui.toolbar.popup.AnnotationPopupToolbar;
import com.pspdfkit.ui.toolbar.popup.PopupToolbarMenuItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class e3 {
    public final au a;
    public final DocumentView b;
    public final PdfConfiguration c;
    public final Matrix d;
    public final wt e;
    public boolean f;
    public boolean g;
    public final Lazy h;
    public final Lazy i;

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AnnotationType.values().length];
            try {
                iArr[AnnotationType.FREETEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotationType.NOTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotationType.FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnnotationType.STAMP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AnnotationType.SOUND.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    public e3(au auVar, DocumentView documentView, PdfConfiguration pdfConfiguration, Matrix matrix, wt wtVar) {
        documentView.getClass();
        pdfConfiguration.getClass();
        this.a = auVar;
        this.b = documentView;
        this.c = pdfConfiguration;
        this.d = matrix;
        this.e = wtVar;
        this.h = LazyKt.lazy(new Function0() { // from class: com.pspdfkit.internal.e3$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Float.valueOf(e3.b(this.f$0));
            }
        });
        this.i = LazyKt.lazy(new Function0() { // from class: com.pspdfkit.internal.e3$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Float.valueOf(e3.a(this.f$0));
            }
        });
    }

    public static final float b(e3 e3Var) {
        Context context = e3Var.a.getContext();
        context.getClass();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        displayMetrics.getClass();
        return TypedValue.applyDimension(1, 20.0f, displayMetrics);
    }

    public final void a() {
        this.b.a.a();
        this.f = false;
    }

    public final void b() {
        float f;
        PointF pointF;
        boolean z;
        m40 state;
        if (this.c.isAnnotationPopupToolbarEnabled()) {
            List<? extends Annotation> listUnmodifiableList = Collections.unmodifiableList(this.e.a.t);
            listUnmodifiableList.getClass();
            if (listUnmodifiableList.isEmpty()) {
                return;
            }
            AnnotationPopupToolbar annotationPopupToolbarA = a(listUnmodifiableList);
            zd zdVar = this.b.a;
            zdVar.getClass();
            OnPreparePopupToolbarListener onPreparePopupToolbarListener = zdVar.i;
            if (onPreparePopupToolbarListener != null) {
                onPreparePopupToolbarListener.onPrepareAnnotationPopupToolbar(annotationPopupToolbarA);
            }
            a();
            if (listUnmodifiableList.isEmpty()) {
                pointF = null;
            } else {
                RectF rectF = new RectF();
                rectF.set(((Annotation) CollectionsKt.first((List) listUnmodifiableList)).getBoundingBox());
                Iterator<T> it = listUnmodifiableList.iterator();
                while (it.hasNext()) {
                    RectF boundingBox = ((Annotation) it.next()).getBoundingBox();
                    rectF.left = Math.min(rectF.left, boundingBox.left);
                    rectF.right = Math.max(rectF.right, boundingBox.right);
                    rectF.top = Math.max(rectF.top, boundingBox.top);
                    rectF.bottom = Math.min(rectF.bottom, boundingBox.bottom);
                }
                RectF pdfRect = this.a.getPdfRect();
                float f2 = rectF.bottom - pdfRect.bottom;
                float f3 = pdfRect.top - rectF.top;
                float fA = s60.a(((Number) this.h.getValue()).floatValue(), this.d);
                float fA2 = s60.a(((Number) this.i.getValue()).floatValue(), this.d);
                float fCenterX = rectF.centerX();
                if (f2 > f3) {
                    f = (rectF.bottom - fA2) - fA;
                } else {
                    f = rectF.top + fA;
                }
                pointF = new PointF(fCenterX, f);
            }
            if (pointF == null || (state = this.a.getState()) == null) {
                z = false;
            } else {
                DocumentView documentView = this.b;
                int i = state.b;
                float f4 = pointF.x;
                float f5 = pointF.y;
                zd zdVar2 = documentView.a;
                zdVar2.getClass();
                zdVar2.a();
                annotationPopupToolbarA.show(i, f4, f5);
                zdVar2.h = annotationPopupToolbarA;
                z = true;
            }
            this.f = z;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:102:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:105:0x0205  */
    /* JADX WARN: Code duplicated, block: B:114:0x0236  */
    /* JADX WARN: Code duplicated, block: B:117:0x0240  */
    /* JADX WARN: Code duplicated, block: B:123:0x0265  */
    /* JADX WARN: Code duplicated, block: B:126:0x026c  */
    /* JADX WARN: Code duplicated, block: B:129:0x0276  */
    /* JADX WARN: Code duplicated, block: B:132:0x0286  */
    /* JADX WARN: Code duplicated, block: B:135:0x0295  */
    /* JADX WARN: Code duplicated, block: B:140:0x02af  */
    /* JADX WARN: Code duplicated, block: B:161:0x010e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:163:0x0137 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:164:0x0135 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:? A[LOOP:3: B:58:0x0123->B:165:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:0x024f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:? A[LOOP:4: B:115:0x023a->B:168:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:0x0286 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:170:0x02af A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:171:? A[LOOP:5: B:127:0x0270->B:171:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x02a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:175:0x028f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:37:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:39:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:41:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:47:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:52:0x010e  */
    /* JADX WARN: Code duplicated, block: B:54:0x0114  */
    /* JADX WARN: Code duplicated, block: B:57:0x011f  */
    /* JADX WARN: Code duplicated, block: B:60:0x0129  */
    /* JADX WARN: Code duplicated, block: B:63:0x0137 A[EDGE_INSN: B:63:0x0137->B:64:0x0138 BREAK  A[LOOP:3: B:58:0x0123->B:165:?]] */
    /* JADX WARN: Code duplicated, block: B:66:0x0148  */
    /* JADX WARN: Code duplicated, block: B:67:0x014d  */
    /* JADX WARN: Code duplicated, block: B:77:0x0193  */
    /* JADX WARN: Code duplicated, block: B:79:0x019b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:82:0x01ae A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:84:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:88:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:89:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:92:0x01ce A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:94:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:97:0x01e3  */
    public final AnnotationPopupToolbar a(List<? extends Annotation> list) {
        boolean z;
        boolean z2;
        AnnotationType type;
        ArrayList arrayList;
        Iterator<T> it;
        String group;
        Iterator<T> it2;
        Annotation annotation;
        int i;
        PdfFragment pdfFragment;
        tg tgVarB;
        PdfConfiguration configuration;
        int i2;
        boolean z3;
        Annotation annotation2;
        int color;
        Iterator<T> it3;
        Iterator<T> it4;
        Annotation annotation3;
        AnnotationPopupToolbar annotationPopupToolbar = new AnnotationPopupToolbar(this.b.getAnnotatingHandler().f, list);
        ArrayList arrayList2 = new ArrayList();
        q0 annotatingHandler = this.b.getAnnotatingHandler();
        annotatingHandler.getClass();
        Annotation annotation4 = (Annotation) CollectionsKt.singleOrNull((List) list);
        if (list.isEmpty()) {
            z = false;
            break;
        }
        Iterator<T> it5 = list.iterator();
        while (true) {
            if (!it5.hasNext()) {
                z = false;
                break;
            }
            if (((Annotation) it5.next()).getInternal().isInstantCommentThreadRoot()) {
                z = true;
                break;
            }
        }
        tg tgVarB2 = ar.b();
        synchronized (tgVarB2) {
            z2 = !tgVarB2.a(NativeLicenseFeatures.ANNOTATION_EDITING) && tg.b();
        }
        int color2 = ContextCompat.getColor(this.a.getContext(), R.color.pspdf__inspector_error_color);
        if (z2 && !list.isEmpty()) {
            Iterator<T> it6 = list.iterator();
            while (it6.hasNext()) {
                if (((Annotation) it6.next()).isSignature()) {
                    PopupToolbarMenuItem popupToolbarMenuItem = new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_delete, R.string.pspdf__delete, R.drawable.pspdf__ic_delete, annotatingHandler.isDeleteEnabled(list));
                    popupToolbarMenuItem.setTintColor(color2);
                    arrayList2.add(popupToolbarMenuItem);
                }
            }
            if (annotatingHandler.isCopyEnabled(list)) {
                arrayList2.add(new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_copy, R.string.pspdf__copy, R.drawable.pspdf__ic_content_copy, true));
                if (annotatingHandler.isCutEnabled(list)) {
                    arrayList2.add(new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_cut, R.string.pspdf__cut, R.drawable.pspdf__ic_content_cut, true));
                }
            }
            if (!z) {
                PopupToolbarMenuItem popupToolbarMenuItem2 = new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_delete, R.string.pspdf__delete, R.drawable.pspdf__ic_delete, annotatingHandler.isDeleteEnabled(list));
                popupToolbarMenuItem2.setTintColor(color2);
                arrayList2.add(popupToolbarMenuItem2);
            }
            if (!z) {
                if (list.isEmpty()) {
                    it4 = list.iterator();
                    while (true) {
                        if (it4.hasNext()) {
                            annotation3 = (Annotation) it4.next();
                            if (annotation3.getType() != AnnotationType.NOTE) {
                            }
                        } else if (annotatingHandler.shouldDisplayPicker()) {
                            int i3 = R.id.pspdf__annotation_popup_toolbar_item_picker;
                            int i4 = R.string.pspdf__inspector;
                            if (list.isEmpty()) {
                                z3 = false;
                                break;
                            }
                            it3 = list.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    z3 = false;
                                    break;
                                }
                                if (((Annotation) it3.next()).getHasLockedContents()) {
                                    z3 = true;
                                    break;
                                }
                            }
                            PopupToolbarMenuItem popupToolbarMenuItem3 = new PopupToolbarMenuItem(i3, i4, 0, !z3);
                            annotation2 = (Annotation) CollectionsKt.firstOrNull((List) list);
                            if (annotation2 != null) {
                                color = annotation2.getColor();
                            } else {
                                color = -16777216;
                            }
                            popupToolbarMenuItem3.setIconDrawable(new e9(this.a.getContext(), -16777216, color | (-16777216), 8.0f, 10.0f, 1.0f));
                            arrayList2.add(popupToolbarMenuItem3);
                        }
                    }
                } else if (annotatingHandler.shouldDisplayPicker()) {
                    int i5 = R.id.pspdf__annotation_popup_toolbar_item_picker;
                    int i6 = R.string.pspdf__inspector;
                    if (list.isEmpty()) {
                        z3 = false;
                        break;
                    }
                    it3 = list.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            z3 = false;
                            break;
                        }
                        if (((Annotation) it3.next()).getHasLockedContents()) {
                            z3 = true;
                            break;
                        }
                    }
                    PopupToolbarMenuItem popupToolbarMenuItem4 = new PopupToolbarMenuItem(i5, i6, 0, !z3);
                    annotation2 = (Annotation) CollectionsKt.firstOrNull((List) list);
                    if (annotation2 != null) {
                        color = annotation2.getColor();
                    } else {
                        color = -16777216;
                    }
                    popupToolbarMenuItem4.setIconDrawable(new e9(this.a.getContext(), -16777216, color | (-16777216), 8.0f, 10.0f, 1.0f));
                    arrayList2.add(popupToolbarMenuItem4);
                }
            }
            if (annotation4 != null) {
                pdfFragment = this.b.getAnnotatingHandler().f;
                boolean zIsAnnotationPropertySupported = pdfFragment.getAnnotationConfiguration().isAnnotationPropertySupported(annotation4.getType(), AnnotationProperty.ANNOTATION_NOTE);
                if (ww.g(annotation4)) {
                    if (annotation4.getType() == AnnotationType.FREETEXT) {
                        tgVarB = ar.b();
                        configuration = pdfFragment.getConfiguration();
                        configuration.getClass();
                        if (tgVarB.b(configuration)) {
                            if (z) {
                                i2 = R.string.pspdf__note_icon_comment;
                            } else {
                                i2 = R.string.pspdf__edit_menu_note;
                            }
                            arrayList2.add(new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_annotation_note, i2, R.drawable.pspdf__ic_note, true));
                        }
                    }
                } else if (annotation4.getType() == AnnotationType.FREETEXT) {
                    tgVarB = ar.b();
                    configuration = pdfFragment.getConfiguration();
                    configuration.getClass();
                    if (tgVarB.b(configuration)) {
                        if (z) {
                            i2 = R.string.pspdf__note_icon_comment;
                        } else {
                            i2 = R.string.pspdf__edit_menu_note;
                        }
                        arrayList2.add(new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_annotation_note, i2, R.drawable.pspdf__ic_note, true));
                    }
                }
            }
            if (annotation4 != null) {
                type = annotation4.getType();
            } else {
                type = null;
            }
            if (type == AnnotationType.NOTE) {
                if (z) {
                    i = R.string.pspdf__note_icon_comment;
                } else {
                    i = R.string.pspdf__edit;
                }
                arrayList2.add(new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_edit, i, R.drawable.pspdf__ic_edit, true));
            }
            if ((annotation4 != null ? annotation4.getType() : null) == AnnotationType.SOUND) {
                if (annotatingHandler.shouldDisplayPlayAudioButton()) {
                    arrayList2.add(new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_play, R.string.pspdf__audio_play, R.drawable.pspdf__ic_play, true));
                }
                if (annotatingHandler.shouldDisplayRecordAudioButton()) {
                    arrayList2.add(new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_record, R.string.pspdf__audio_record, R.drawable.pspdf__ic_record, true));
                }
            }
            if (annotation4 != null) {
                arrayList2.add(new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_share, R.string.pspdf__share, R.drawable.pspdf__ic_share, a(annotation4)));
            }
            if (!list.isEmpty()) {
                for (Annotation annotation5 : list) {
                    annotation5.getClass();
                    if (annotation5.getGroup() != null) {
                        arrayList2.add(new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_ungroup, R.string.pspdf__ungroup, R.drawable.pspdf__ic_ungroup, true));
                        break;
                    }
                }
            }
            if (list.size() >= 2) {
                if (list.isEmpty()) {
                    it2 = list.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            annotation = (Annotation) it2.next();
                            annotation.getClass();
                            if (annotation.getGroup() != null) {
                            }
                        } else {
                            arrayList = new ArrayList();
                            it = list.iterator();
                            while (it.hasNext()) {
                                group = ((Annotation) it.next()).getGroup();
                                if (group != null) {
                                    arrayList.add(group);
                                }
                            }
                            if (CollectionsKt.toSet(arrayList).size() > 1) {
                            }
                        }
                        arrayList2.add(new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_group, R.string.pspdf__group, R.drawable.pspdf__ic_group, true));
                    }
                } else {
                    arrayList = new ArrayList();
                    it = list.iterator();
                    while (it.hasNext()) {
                        group = ((Annotation) it.next()).getGroup();
                        if (group != null) {
                            arrayList.add(group);
                        }
                    }
                    if (CollectionsKt.toSet(arrayList).size() > 1) {
                        arrayList2.add(new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_group, R.string.pspdf__group, R.drawable.pspdf__ic_group, true));
                    }
                }
            }
            if (!this.b.h()) {
                arrayList2.add(new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_select_objects, R.string.pspdf__select_more, R.drawable.pspdf__ic_annotation_selection, true));
            }
        } else {
            if (annotatingHandler.isCopyEnabled(list)) {
                arrayList2.add(new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_copy, R.string.pspdf__copy, R.drawable.pspdf__ic_content_copy, true));
                if (annotatingHandler.isCutEnabled(list)) {
                    arrayList2.add(new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_cut, R.string.pspdf__cut, R.drawable.pspdf__ic_content_cut, true));
                }
            }
            if (!z) {
                PopupToolbarMenuItem popupToolbarMenuItem5 = new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_delete, R.string.pspdf__delete, R.drawable.pspdf__ic_delete, annotatingHandler.isDeleteEnabled(list));
                popupToolbarMenuItem5.setTintColor(color2);
                arrayList2.add(popupToolbarMenuItem5);
            }
            if (!z) {
                if (list.isEmpty()) {
                    it4 = list.iterator();
                    while (true) {
                        if (it4.hasNext()) {
                            annotation3 = (Annotation) it4.next();
                            if (annotation3.getType() != AnnotationType.NOTE || annotation3.getType() == AnnotationType.SOUND) {
                            }
                        } else if (annotatingHandler.shouldDisplayPicker()) {
                            int i7 = R.id.pspdf__annotation_popup_toolbar_item_picker;
                            int i8 = R.string.pspdf__inspector;
                            if (list.isEmpty()) {
                                z3 = false;
                                break;
                            }
                            it3 = list.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    z3 = false;
                                    break;
                                }
                                if (((Annotation) it3.next()).getHasLockedContents()) {
                                    z3 = true;
                                    break;
                                }
                            }
                            PopupToolbarMenuItem popupToolbarMenuItem6 = new PopupToolbarMenuItem(i7, i8, 0, !z3);
                            annotation2 = (Annotation) CollectionsKt.firstOrNull((List) list);
                            if (annotation2 != null) {
                                color = annotation2.getColor();
                            } else {
                                color = -16777216;
                            }
                            popupToolbarMenuItem6.setIconDrawable(new e9(this.a.getContext(), -16777216, color | (-16777216), 8.0f, 10.0f, 1.0f));
                            arrayList2.add(popupToolbarMenuItem6);
                        }
                    }
                } else if (annotatingHandler.shouldDisplayPicker()) {
                    int i9 = R.id.pspdf__annotation_popup_toolbar_item_picker;
                    int i10 = R.string.pspdf__inspector;
                    if (list.isEmpty()) {
                        z3 = false;
                        break;
                    }
                    it3 = list.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            z3 = false;
                            break;
                        }
                        if (((Annotation) it3.next()).getHasLockedContents()) {
                            z3 = true;
                            break;
                        }
                    }
                    PopupToolbarMenuItem popupToolbarMenuItem7 = new PopupToolbarMenuItem(i9, i10, 0, !z3);
                    annotation2 = (Annotation) CollectionsKt.firstOrNull((List) list);
                    if (annotation2 != null) {
                        color = annotation2.getColor();
                    } else {
                        color = -16777216;
                    }
                    popupToolbarMenuItem7.setIconDrawable(new e9(this.a.getContext(), -16777216, color | (-16777216), 8.0f, 10.0f, 1.0f));
                    arrayList2.add(popupToolbarMenuItem7);
                }
            }
            if (annotation4 != null && annotation4.getType() != AnnotationType.NOTE) {
                pdfFragment = this.b.getAnnotatingHandler().f;
                boolean zIsAnnotationPropertySupported2 = pdfFragment.getAnnotationConfiguration().isAnnotationPropertySupported(annotation4.getType(), AnnotationProperty.ANNOTATION_NOTE);
                if (ww.g(annotation4) || !zIsAnnotationPropertySupported2) {
                    if (annotation4.getType() == AnnotationType.FREETEXT && zIsAnnotationPropertySupported2) {
                        tgVarB = ar.b();
                        configuration = pdfFragment.getConfiguration();
                        configuration.getClass();
                        if (tgVarB.b(configuration)) {
                            if (z) {
                                i2 = R.string.pspdf__note_icon_comment;
                            } else {
                                i2 = R.string.pspdf__edit_menu_note;
                            }
                            arrayList2.add(new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_annotation_note, i2, R.drawable.pspdf__ic_note, true));
                        }
                    }
                } else {
                    if (z) {
                        i2 = R.string.pspdf__note_icon_comment;
                    } else {
                        i2 = R.string.pspdf__edit_menu_note;
                    }
                    arrayList2.add(new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_annotation_note, i2, R.drawable.pspdf__ic_note, true));
                }
            }
            if (annotation4 != null) {
                type = annotation4.getType();
            } else {
                type = null;
            }
            if (type == AnnotationType.NOTE) {
                if (z) {
                    i = R.string.pspdf__note_icon_comment;
                } else {
                    i = R.string.pspdf__edit;
                }
                arrayList2.add(new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_edit, i, R.drawable.pspdf__ic_edit, true));
            }
            if ((annotation4 != null ? annotation4.getType() : null) == AnnotationType.SOUND) {
                if (annotatingHandler.shouldDisplayPlayAudioButton()) {
                    arrayList2.add(new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_play, R.string.pspdf__audio_play, R.drawable.pspdf__ic_play, true));
                }
                if (annotatingHandler.shouldDisplayRecordAudioButton()) {
                    arrayList2.add(new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_record, R.string.pspdf__audio_record, R.drawable.pspdf__ic_record, true));
                }
            }
            if (annotation4 != null && !z && b(annotation4)) {
                arrayList2.add(new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_share, R.string.pspdf__share, R.drawable.pspdf__ic_share, a(annotation4)));
            }
            if (!list.isEmpty()) {
                while (r4.hasNext()) {
                    annotation5.getClass();
                    if (annotation5.getGroup() != null) {
                        arrayList2.add(new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_ungroup, R.string.pspdf__ungroup, R.drawable.pspdf__ic_ungroup, true));
                        break;
                    }
                }
            }
            if (list.size() >= 2) {
                if (list.isEmpty()) {
                    it2 = list.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            annotation = (Annotation) it2.next();
                            annotation.getClass();
                            if (annotation.getGroup() != null) {
                            }
                        } else {
                            arrayList = new ArrayList();
                            it = list.iterator();
                            while (it.hasNext()) {
                                group = ((Annotation) it.next()).getGroup();
                                if (group != null) {
                                    arrayList.add(group);
                                }
                            }
                            if (CollectionsKt.toSet(arrayList).size() > 1) {
                            }
                        }
                        arrayList2.add(new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_group, R.string.pspdf__group, R.drawable.pspdf__ic_group, true));
                    }
                } else {
                    arrayList = new ArrayList();
                    it = list.iterator();
                    while (it.hasNext()) {
                        group = ((Annotation) it.next()).getGroup();
                        if (group != null) {
                            arrayList.add(group);
                        }
                    }
                    if (CollectionsKt.toSet(arrayList).size() > 1) {
                        arrayList2.add(new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_group, R.string.pspdf__group, R.drawable.pspdf__ic_group, true));
                    }
                }
            }
            if (!this.b.h() && ar.b().a(this.c, AnnotationTool.ANNOTATION_MULTI_SELECTION)) {
                arrayList2.add(new PopupToolbarMenuItem(R.id.pspdf__annotation_popup_toolbar_item_select_objects, R.string.pspdf__select_more, R.drawable.pspdf__ic_annotation_selection, true));
            }
        }
        annotationPopupToolbar.setMenuItems(arrayList2);
        annotationPopupToolbar.setDefaultItemHandler(new PopupToolbar.DefaultItemHandler() { // from class: com.pspdfkit.internal.e3$$ExternalSyntheticLambda0
            @Override // com.pspdfkit.ui.PopupToolbar.DefaultItemHandler
            public final boolean onItemClicked(PopupToolbarMenuItem popupToolbarMenuItem8) {
                return e3.a(this.f$0, popupToolbarMenuItem8);
            }
        });
        return annotationPopupToolbar;
    }

    public final boolean b(Annotation annotation) {
        EnumSet<ShareFeatures> enabledShareFeatures = this.b.getAnnotatingHandler().f.getConfiguration().getEnabledShareFeatures();
        int i = a.a[annotation.getType().ordinal()];
        if (i == 1) {
            return enabledShareFeatures.contains(ShareFeatures.FREE_TEXT_ANNOTATION_SHARING);
        }
        if (i == 2) {
            return enabledShareFeatures.contains(ShareFeatures.NOTE_ANNOTATION_SHARING);
        }
        if (i == 3) {
            return enabledShareFeatures.contains(ShareFeatures.EMBEDDED_FILE_SHARING);
        }
        if (i != 4) {
            if (i != 5) {
                return false;
            }
            return enabledShareFeatures.contains(ShareFeatures.SOUND_SHARING);
        }
        if (enabledShareFeatures.contains(ShareFeatures.IMAGE_SHARING)) {
            StampAnnotation stampAnnotation = annotation instanceof StampAnnotation ? (StampAnnotation) annotation : null;
            if (stampAnnotation != null && stampAnnotation.hasBitmap()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean a(e3 e3Var, PopupToolbarMenuItem popupToolbarMenuItem) {
        popupToolbarMenuItem.getClass();
        e3Var.a();
        int id = popupToolbarMenuItem.getId();
        if (id == R.id.pspdf__annotation_popup_toolbar_item_copy) {
            vt vtVar = e3Var.e.a;
            ub copyPasteManager = vtVar.n.getCopyPasteManager();
            if (copyPasteManager == null) {
                return true;
            }
            copyPasteManager.a((List<? extends Annotation>) vtVar.t);
            return true;
        }
        if (id == R.id.pspdf__annotation_popup_toolbar_item_cut) {
            vt vtVar2 = e3Var.e.a;
            ub copyPasteManager2 = vtVar2.n.getCopyPasteManager();
            if (copyPasteManager2 == null) {
                return true;
            }
            copyPasteManager2.b((List<? extends Annotation>) vtVar2.t);
            return true;
        }
        int i = 0;
        if (id == R.id.pspdf__annotation_popup_toolbar_item_delete) {
            vt vtVar3 = e3Var.e.a;
            List<? extends Annotation> list = CollectionsKt.toList(vtVar3.t);
            List listAsList = ArraysKt.asList(new Annotation[0]);
            listAsList.getClass();
            vtVar3.a(false, (Collection<? extends Annotation>) listAsList);
            vtVar3.n.getAnnotatingHandler().a(list);
            return true;
        }
        if (id == R.id.pspdf__annotation_popup_toolbar_item_picker) {
            e3Var.b.getAnnotatingHandler().toggleAnnotationInspector();
            return true;
        }
        if (id == R.id.pspdf__annotation_popup_toolbar_item_annotation_note) {
            List listUnmodifiableList = Collections.unmodifiableList(e3Var.e.a.t);
            listUnmodifiableList.getClass();
            Annotation annotation = (Annotation) CollectionsKt.singleOrNull(listUnmodifiableList);
            if (annotation == null) {
                return true;
            }
            q0 annotatingHandler = e3Var.b.getAnnotatingHandler();
            annotatingHandler.getClass();
            annotatingHandler.d.a(annotation);
            return true;
        }
        if (id == R.id.pspdf__annotation_popup_toolbar_item_edit) {
            List listUnmodifiableList2 = Collections.unmodifiableList(e3Var.e.a.t);
            listUnmodifiableList2.getClass();
            Annotation annotation2 = (Annotation) CollectionsKt.singleOrNull(listUnmodifiableList2);
            if (annotation2 == null) {
                return true;
            }
            Annotation annotation3 = annotation2.getType() == AnnotationType.NOTE ? annotation2 : null;
            if (annotation3 == null) {
                return true;
            }
            q0 annotatingHandler2 = e3Var.b.getAnnotatingHandler();
            annotatingHandler2.getClass();
            annotatingHandler2.d.a(annotation3);
            return true;
        }
        if (id == R.id.pspdf__annotation_popup_toolbar_item_play) {
            e3Var.b.getAnnotatingHandler().enterAudioPlaybackMode();
            return true;
        }
        if (id == R.id.pspdf__annotation_popup_toolbar_item_record) {
            e3Var.b.getAnnotatingHandler().enterAudioRecordingMode();
            return true;
        }
        if (id == R.id.pspdf__annotation_popup_toolbar_item_share) {
            List listUnmodifiableList3 = Collections.unmodifiableList(e3Var.e.a.t);
            listUnmodifiableList3.getClass();
            Annotation annotation4 = (Annotation) CollectionsKt.singleOrNull(listUnmodifiableList3);
            if (annotation4 == null || !e3Var.a(annotation4)) {
                return true;
            }
            PdfFragment pdfFragment = e3Var.b.getAnnotatingHandler().f;
            int i2 = s4.e;
            s4 s4Var = (s4) pdfFragment.getParentFragmentManager().findFragmentByTag("com.pspdfkit.ui.AnnotationSharingMenuFragment.FRAGMENT_TAG");
            if (s4Var == null) {
                s4Var = new s4();
            }
            s4Var.a = pdfFragment;
            s4Var.b = annotation4;
            FragmentManager parentFragmentManager = pdfFragment.getParentFragmentManager();
            if (!s4Var.isAdded()) {
                FragmentTransaction fragmentTransactionBeginTransaction = parentFragmentManager.beginTransaction();
                fragmentTransactionBeginTransaction.add(s4Var, "com.pspdfkit.ui.AnnotationSharingMenuFragment.FRAGMENT_TAG");
                fragmentTransactionBeginTransaction.commitNow();
            }
            s4Var.a();
            return true;
        }
        if (id == R.id.pspdf__annotation_popup_toolbar_item_group) {
            vt vtVar4 = e3Var.e.a;
            ArrayList arrayList = vtVar4.t;
            at atVar = vtVar4.f;
            arrayList.getClass();
            atVar.getClass();
            i3 i3Var = new i3(arrayList, atVar);
            String strMakeNewGroupId = Annotation.INSTANCE.makeNewGroupId();
            i3Var.b();
            ArrayList arrayList2 = vtVar4.t;
            int size = arrayList2.size();
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                ((Annotation) obj).setGroup(strMakeNewGroupId);
            }
            i3Var.c();
            return true;
        }
        if (id == R.id.pspdf__annotation_popup_toolbar_item_ungroup) {
            vt vtVar5 = e3Var.e.a;
            ArrayList arrayList3 = vtVar5.t;
            at atVar2 = vtVar5.f;
            arrayList3.getClass();
            atVar2.getClass();
            i3 i3Var2 = new i3(arrayList3, atVar2);
            i3Var2.b();
            ArrayList arrayList4 = vtVar5.t;
            int size2 = arrayList4.size();
            while (i < size2) {
                Object obj2 = arrayList4.get(i);
                i++;
                ((Annotation) obj2).setGroup(null);
            }
            i3Var2.c();
            return true;
        }
        if (id != R.id.pspdf__annotation_popup_toolbar_item_select_objects) {
            return true;
        }
        DocumentView documentView = e3Var.b;
        AnnotationTool annotationTool = AnnotationTool.ANNOTATION_MULTI_SELECTION;
        documentView.getClass();
        documentView.enterAnnotatingMode(annotationTool, AnnotationToolVariant.defaultVariant());
        return true;
    }

    public static final float a(e3 e3Var) {
        float fApplyDimension;
        TypedArray typedArrayObtainStyledAttributes = e3Var.a.getContext().obtainStyledAttributes(new int[]{com.google.android.material.R.attr.minTouchTargetSize});
        typedArrayObtainStyledAttributes.getClass();
        try {
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            if (dimensionPixelSize > 0) {
                fApplyDimension = dimensionPixelSize;
            } else {
                Context context = e3Var.a.getContext();
                context.getClass();
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                displayMetrics.getClass();
                fApplyDimension = TypedValue.applyDimension(1, 48.0f, displayMetrics);
            }
            return fApplyDimension;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final boolean a(Annotation annotation) {
        PdfDocument document;
        EnumSet<DocumentPermissions> permissions;
        if (b(annotation) && (document = this.b.getAnnotatingHandler().f.getDocument()) != null && (permissions = document.getPermissions()) != null && permissions.contains(DocumentPermissions.EXTRACT)) {
            int i = a.a[annotation.getType().ordinal()];
            if (i != 1 && i != 2) {
                if (i == 3) {
                    FileAnnotation fileAnnotation = annotation instanceof FileAnnotation ? (FileAnnotation) annotation : null;
                    return (fileAnnotation != null ? fileAnnotation.getFile() : null) != null;
                }
                if (i == 4) {
                    return true;
                }
                if (i != 5) {
                    return false;
                }
                return DocumentSharingProviderProcessor.soundAnnotationSupportsSharing((SoundAnnotation) annotation);
            }
            if (!TextUtils.isEmpty(annotation.getContents())) {
                return true;
            }
        }
        return false;
    }
}
