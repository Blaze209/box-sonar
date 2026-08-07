package com.pspdfkit.internal;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.pspdfkit.annotations.BaseRectsAnnotation;
import com.pspdfkit.annotations.RedactionAnnotation;
import com.pspdfkit.internal.jni.NativeRectDescriptor;
import com.pspdfkit.internal.jni.NativeTextParser;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
public final class xx extends dp {
    public boolean p;
    public final AnnotationTool q;

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.RedactionModeHandler$finishEditing$1$1", f = "RedactionModeHandler.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, nl = {97}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ lm b;
        public final /* synthetic */ BaseRectsAnnotation c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(lm lmVar, BaseRectsAnnotation baseRectsAnnotation, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = lmVar;
            this.c = baseRectsAnnotation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new a(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                o3 annotationProvider = this.b.getAnnotationProvider();
                BaseRectsAnnotation baseRectsAnnotation = this.c;
                this.a = 1;
                if (annotationProvider.removeAnnotationFromPage(baseRectsAnnotation, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xx(q0 q0Var, AnnotationToolVariant annotationToolVariant) {
        super(q0Var, annotationToolVariant);
        q0Var.getClass();
        annotationToolVariant.getClass();
        this.q = AnnotationTool.REDACTION;
    }

    @Override // com.pspdfkit.internal.dp
    public final BaseRectsAnnotation a(ArrayList arrayList) {
        RedactionAnnotation redactionAnnotation = new RedactionAnnotation(k(), (List<RectF>) CollectionsKt.emptyList());
        redactionAnnotation.setColor(this.a.p.b);
        redactionAnnotation.setFillColor(this.a.p.c);
        redactionAnnotation.setOutlineColor(this.a.p.d);
        redactionAnnotation.setOverlayText(this.a.p.j);
        redactionAnnotation.setRepeatOverlayText(this.a.p.k);
        redactionAnnotation.setRepeatOverlayText(this.a.p.k);
        return redactionAnnotation;
    }

    @Override // com.pspdfkit.internal.gu
    public final int f() {
        return 22;
    }

    @Override // com.pspdfkit.internal.d3
    public final AnnotationTool h() {
        return this.q;
    }

    @Override // com.pspdfkit.internal.dp
    public final void m() {
        BaseRectsAnnotation baseRectsAnnotation = this.g;
        if (baseRectsAnnotation != null) {
            lm lmVarJ = j();
            if (lmVarJ == null) {
                return;
            }
            if (!a(baseRectsAnnotation)) {
                q0 q0Var = this.a;
                a aVar = new a(lmVarJ, baseRectsAnnotation, null);
                CoroutineDispatcher coroutineDispatcher = Dispatchers.getDefault();
                q0Var.getClass();
                coroutineDispatcher.getClass();
                q0Var.q.incrementAndGet();
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(coroutineDispatcher), null, null, new r0(aVar, q0Var, null), 3, null);
                this.g = null;
            }
        }
        super.m();
    }

    @Override // com.pspdfkit.internal.dp
    public final boolean n() {
        return !this.p;
    }

    @Override // com.pspdfkit.internal.dp
    public final boolean o() {
        return this.p;
    }

    @Override // com.pspdfkit.internal.dp
    public final boolean p() {
        return false;
    }

    @Override // com.pspdfkit.internal.dp
    public final void a(RectF rectF) {
        au auVarL;
        Collection collectionA;
        lm lmVarJ = j();
        boolean z = false;
        if (lmVarJ != null && (auVarL = l()) != null) {
            Matrix matrixA = auVarL.a((Matrix) null);
            RectF rectF2 = new RectF();
            rectF2.set(rectF);
            s60.a(rectF2, matrixA);
            NativeTextParser nativeTextParserA = lmVarJ.c.b(k()).a();
            if (nativeTextParserA == null) {
                collectionA = CollectionsKt.emptyList();
            } else {
                ArrayList<NativeRectDescriptor> arrayListTextRectsBoundedByRect = nativeTextParserA.textRectsBoundedByRect(rectF2, true, false, true);
                arrayListTextRectsBoundedByRect.getClass();
                collectionA = r10.a(arrayListTextRectsBoundedByRect);
            }
            z = !collectionA.isEmpty();
        }
        this.p = z;
    }

    @Override // com.pspdfkit.internal.dp
    public final void a(BaseRectsAnnotation baseRectsAnnotation, ArrayList arrayList, RectF rectF) {
        baseRectsAnnotation.getClass();
        rectF.getClass();
        if (this.p) {
            if (arrayList.isEmpty()) {
                return;
            }
            hp.a(baseRectsAnnotation, arrayList);
            return;
        }
        au auVarL = l();
        if (auVarL == null) {
            return;
        }
        Matrix matrixA = auVarL.a((Matrix) null);
        RectF rectF2 = new RectF();
        rectF2.set(rectF);
        s60.a(rectF2, matrixA);
        baseRectsAnnotation.setBoundingBox(rectF2);
        baseRectsAnnotation.setRects(CollectionsKt.listOf(rectF2));
    }

    @Override // com.pspdfkit.internal.dp
    public final boolean a(BaseRectsAnnotation baseRectsAnnotation) {
        baseRectsAnnotation.getClass();
        if (Math.abs(baseRectsAnnotation.getBoundingBox().width()) > 20.0f && Math.abs(baseRectsAnnotation.getBoundingBox().height()) > 20.0f) {
            return true;
        }
        if (this.p && !baseRectsAnnotation.getRects().isEmpty()) {
            return true;
        }
        List<RectF> rects = baseRectsAnnotation.getRects();
        if ((rects instanceof Collection) && rects.isEmpty()) {
            return false;
        }
        for (RectF rectF : rects) {
            if (Math.abs(rectF.width()) > 20.0f && Math.abs(rectF.height()) > 20.0f) {
                return true;
            }
        }
        return false;
    }
}
