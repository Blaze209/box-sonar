package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.R;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.defaults.AnnotationPreferencesManager;
import com.pspdfkit.annotations.note.AnnotationStateChange;
import com.pspdfkit.instant.annotations.InstantAnnotationProvider;
import com.pspdfkit.instant.internal.jni.NativeComment;
import com.pspdfkit.instant.internal.jni.NativeCommentInsertionResult;
import com.pspdfkit.instant.internal.jni.NativeCommentThreadResult;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class nl implements gs, AnnotationProvider.OnAnnotationUpdatedListener {
    public final Annotation a;
    public final AnnotationPreferencesManager b;
    public final wk c;
    public final String d;
    public as e;
    public List<? extends ds> f;
    public boolean g;
    public hs h;
    public boolean i;
    public long j;

    public nl(Context context, Annotation annotation, AnnotationPreferencesManager annotationPreferencesManager, wk wkVar) {
        annotation.getClass();
        annotationPreferencesManager.getClass();
        this.a = annotation;
        this.b = annotationPreferencesManager;
        this.c = wkVar;
        String string = context.getString(R.string.pspdf__annotation_type_instantComments);
        string.getClass();
        this.d = string;
        this.f = CollectionsKt.emptyList();
        annotation.getInternal().addOnAnnotationUpdatedListener(this);
        this.i = true;
    }

    @Override // com.pspdfkit.internal.gs
    public final String a() {
        return null;
    }

    @Override // com.pspdfkit.internal.gs
    public final void a(cs csVar, int i) {
    }

    @Override // com.pspdfkit.internal.gs
    public final void a(String str) {
        str.getClass();
    }

    @Override // com.pspdfkit.internal.gs
    public final boolean b() {
        return false;
    }

    @Override // com.pspdfkit.internal.gs
    public final boolean b(ds dsVar) {
        dsVar.getClass();
        return false;
    }

    @Override // com.pspdfkit.internal.gs
    public final void c(ds dsVar) {
    }

    @Override // com.pspdfkit.internal.gs
    public final boolean c() {
        return this.g && !this.f.isEmpty();
    }

    @Override // com.pspdfkit.internal.gs
    public final List<String> d() {
        return CollectionsKt.emptyList();
    }

    @Override // com.pspdfkit.internal.gs
    public final ds e() {
        if (this.f.isEmpty()) {
            this.f = q();
            this.g = true;
        }
        ds dsVar = (ds) CollectionsKt.firstOrNull((List) this.f);
        if (dsVar != null) {
            return dsVar;
        }
        throw new IllegalStateException("Instant comment editor expects at least one card when accessed immediately");
    }

    @Override // com.pspdfkit.internal.gs
    public final boolean f() {
        return false;
    }

    @Override // com.pspdfkit.internal.gs
    public final String g() {
        String annotationCreator = this.b.getAnnotationCreator();
        return annotationCreator == null ? "" : annotationCreator;
    }

    @Override // com.pspdfkit.internal.gs
    public final String getTitle() {
        return this.d;
    }

    @Override // com.pspdfkit.internal.gs
    public final boolean h() {
        return false;
    }

    @Override // com.pspdfkit.internal.gs
    public final boolean i() {
        return true;
    }

    @Override // com.pspdfkit.internal.gs
    public final void j() {
        as asVar = this.e;
        if (asVar == null) {
            return;
        }
        this.e = null;
        hs hsVar = this.h;
        if (hsVar != null) {
            hsVar.b(this);
        }
        wk wkVar = this.c;
        String str = asVar.e;
        if (str == null) {
            str = "";
        }
        String strG = g();
        Annotation annotation = this.a;
        annotation.getClass();
        gm gmVar = wkVar.m;
        gmVar.getClass();
        NativeCommentInsertionResult nativeCommentInsertionResultCreateComment = gmVar.c.createComment(str, strG, null, annotation.getInternal().getNativeAnnotation());
        if (nativeCommentInsertionResultCreateComment.isError()) {
            throw lr.a(nativeCommentInsertionResultCreateComment.error());
        }
        ArrayList<NativeComment> updatedThread = nativeCommentInsertionResultCreateComment.value().getUpdatedThread();
        uw.a(updatedThread, "rawThread", null);
        ArrayList arrayList = new ArrayList(updatedThread.size());
        int size = updatedThread.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            NativeComment nativeComment = updatedThread.get(i2);
            i2++;
            arrayList.add(new ml(nativeComment));
        }
        InstantAnnotationProvider.NonAnnotationChange nonAnnotationChange = InstantAnnotationProvider.NonAnnotationChange.COMMENT_CREATED;
        ArrayList arrayList2 = wkVar.q;
        int size2 = arrayList2.size();
        while (i < size2) {
            Object obj = arrayList2.get(i);
            i++;
            ((InstantAnnotationProvider.OnNonAnnotationChangeListener) obj).onNonAnnotationChange(nonAnnotationChange);
        }
        this.f = q();
        this.g = true;
    }

    @Override // com.pspdfkit.internal.gs
    public final boolean k() {
        return false;
    }

    @Override // com.pspdfkit.internal.gs
    public final boolean l() {
        return this.e == null;
    }

    @Override // com.pspdfkit.internal.gs
    public final int m() {
        return this.a.getColor();
    }

    @Override // com.pspdfkit.internal.gs
    public final List<Integer> n() {
        return CollectionsKt.emptyList();
    }

    @Override // com.pspdfkit.internal.gs
    public final void o() {
        this.e = null;
        hs hsVar = this.h;
        if (hsVar != null) {
            hsVar.b(this);
        }
        this.f = q();
        this.g = true;
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationCreated(Annotation annotation) {
        annotation.getClass();
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationRemoved(Annotation annotation) {
        annotation.getClass();
        Annotation annotation2 = this.a;
        if (annotation == annotation2) {
            this.e = null;
            if (this.i) {
                this.i = false;
                annotation2.getInternal().removeOnAnnotationUpdatedListener(this);
            }
            hs hsVar = this.h;
            if (hsVar != null) {
                hsVar.a(this);
            }
        }
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationUpdated(Annotation annotation) {
        annotation.getClass();
        if (annotation == this.a) {
            this.f = q();
            this.g = true;
        }
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationZOrderChanged(int i, List<? extends Annotation> list, List<? extends Annotation> list2) {
        list.getClass();
        list2.getClass();
    }

    @Override // com.pspdfkit.internal.gs
    public final boolean p() {
        return false;
    }

    public final ArrayList q() {
        wk wkVar = this.c;
        Annotation annotation = this.a;
        annotation.getClass();
        gm gmVar = wkVar.m;
        gmVar.getClass();
        NativeCommentThreadResult nativeCommentThreadResultCommentsForAnnotation = gmVar.c.commentsForAnnotation(annotation.getInternal().getNativeAnnotation());
        uw.a(nativeCommentThreadResultCommentsForAnnotation, "commentThreadResult", null);
        if (nativeCommentThreadResultCommentsForAnnotation.isError()) {
            throw lr.a(nativeCommentThreadResultCommentsForAnnotation.error());
        }
        ArrayList<NativeComment> arrayListValue = nativeCommentThreadResultCommentsForAnnotation.value();
        uw.a(arrayListValue, "rawThread", null);
        ArrayList arrayList = new ArrayList(arrayListValue.size());
        int size = arrayListValue.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            NativeComment nativeComment = arrayListValue.get(i2);
            i2++;
            arrayList.add(new ml(nativeComment));
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size() + (this.e == null ? 0 : 1));
        int size2 = arrayList.size();
        while (i < size2) {
            Object obj = arrayList.get(i);
            i++;
            arrayList2.add(new ls((ml) obj, this.a));
        }
        as asVar = this.e;
        if (asVar != null) {
            arrayList2.add(asVar);
        }
        return arrayList2;
    }

    @Override // com.pspdfkit.internal.gs
    public final void a(cs csVar, String str) {
        str.getClass();
    }

    @Override // com.pspdfkit.internal.gs
    public final boolean a(ds dsVar) {
        dsVar.getClass();
        if (dsVar instanceof ls) {
            return Intrinsics.areEqual(((ls) dsVar).a.b, g());
        }
        return false;
    }

    @Override // com.pspdfkit.internal.gs
    public final Object b(Continuation<? super List<? extends ds>> continuation) {
        if (!this.g) {
            this.f = q();
            this.g = true;
        }
        return this.f;
    }

    @Override // com.pspdfkit.internal.gs
    public final Object a(cs csVar, AnnotationStateChange annotationStateChange, Continuation<? super Unit> continuation) {
        Object objAppendAnnotationState = this.c.appendAnnotationState(this.a, annotationStateChange, continuation);
        return objAppendAnnotationState == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAppendAnnotationState : Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.gs
    public final Object b(ds dsVar, Continuation<? super Boolean> continuation) {
        if (dsVar instanceof ls) {
            ml mlVar = ((ls) dsVar).a;
            if (Intrinsics.areEqual(mlVar.b, g())) {
                wk wkVar = this.c;
                Annotation annotation = this.a;
                annotation.getClass();
                gm gmVar = wkVar.m;
                gmVar.getClass();
                NativeCommentThreadResult nativeCommentThreadResultRemoveCommentWithId = gmVar.c.removeCommentWithId(mlVar.a, annotation.getInternal().getNativeAnnotation());
                uw.a(nativeCommentThreadResultRemoveCommentWithId, "commentThreadResult", null);
                if (!nativeCommentThreadResultRemoveCommentWithId.isError()) {
                    ArrayList<NativeComment> arrayListValue = nativeCommentThreadResultRemoveCommentWithId.value();
                    uw.a(arrayListValue, "rawThread", null);
                    ArrayList arrayList = new ArrayList(arrayListValue.size());
                    int size = arrayListValue.size();
                    int i = 0;
                    while (i < size) {
                        NativeComment nativeComment = arrayListValue.get(i);
                        i++;
                        arrayList.add(new ml(nativeComment));
                    }
                    InstantAnnotationProvider.NonAnnotationChange nonAnnotationChange = InstantAnnotationProvider.NonAnnotationChange.COMMENT_DELETED;
                    ArrayList arrayList2 = wkVar.q;
                    int size2 = arrayList2.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        Object obj = arrayList2.get(i2);
                        i2++;
                        ((InstantAnnotationProvider.OnNonAnnotationChangeListener) obj).onNonAnnotationChange(nonAnnotationChange);
                    }
                    this.f = q();
                    this.g = true;
                } else {
                    throw lr.a(nativeCommentThreadResultRemoveCommentWithId.error());
                }
            }
        }
        return Boxing.boxBoolean(false);
    }

    @Override // com.pspdfkit.internal.gs
    public final void a(ds dsVar, String str) {
        if (dsVar == this.e) {
            ((as) dsVar).e = str;
        }
    }

    @Override // com.pspdfkit.internal.gs
    public final Object a(Continuation<? super ds> continuation) {
        String str;
        as asVar = this.e;
        String strG = g();
        if (asVar != null && (str = asVar.e) != null && str.length() != 0) {
            Annotation annotation = this.a;
            long j = this.j + 1;
            this.j = j;
            this.e = new as(annotation, strG, j);
        } else if (asVar == null) {
            Annotation annotation2 = this.a;
            long j2 = this.j + 1;
            this.j = j2;
            this.e = new as(annotation2, strG, j2);
            hs hsVar = this.h;
            if (hsVar != null) {
                hsVar.b(this);
            }
            this.f = q();
            this.g = true;
        }
        as asVar2 = this.e;
        if (asVar2 != null) {
            return asVar2;
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override // com.pspdfkit.internal.gs
    public final Object a(ds dsVar, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.gs
    public final void a(int i) {
        this.b.setColor(AnnotationTool.NOTE, this.a.getInternal().getVariant(), i);
    }

    @Override // com.pspdfkit.internal.gs
    public final void a(hs hsVar) {
        this.h = hsVar;
    }

    @Override // com.pspdfkit.internal.gs
    public final void a(List<? extends ds> list) {
        ArrayList arrayList = (ArrayList) list;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((ds) obj).getClass();
        }
    }
}
