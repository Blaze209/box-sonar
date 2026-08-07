package com.pspdfkit.internal;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.graphics.ColorUtils;
import com.facebook.imageutils.JfifUtil;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.note.AnnotationStateChange;
import com.pspdfkit.annotations.note.AuthorState;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Calendar;
import java.util.LinkedHashSet;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class os implements is, hs {
    public final gs a;
    public js b;
    public boolean c;
    public CoroutineScope d;

    public static final class a {
    }

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.note.NoteEditorPresenter$onAddNewReplyCardClicked$2", f = "NoteEditorPresenter.kt", i = {}, l = {248}, m = "invokeSuspend", n = {}, nl = {249}, s = {}, v = 2)
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ js c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(js jsVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = jsVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return os.this.new b(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return os.this.new b(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                gs gsVar = os.this.a;
                this.a = 1;
                obj = gsVar.a(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ds dsVar = (ds) obj;
            os.this.b(dsVar);
            this.c.c(dsVar);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.note.NoteEditorPresenter$onContextualMenuItemClicked$1", f = "NoteEditorPresenter.kt", i = {}, l = {JfifUtil.MARKER_SOI}, m = "invokeSuspend", n = {}, nl = {JfifUtil.MARKER_EOI}, s = {}, v = 2)
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ ds c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ds dsVar, Continuation<? super c> continuation) {
            super(2, continuation);
            this.c = dsVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return os.this.new c(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return os.this.new c(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            js jsVar;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                gs gsVar = os.this.a;
                ds dsVar = this.c;
                this.a = 1;
                obj = gsVar.b(dsVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (((Boolean) obj).booleanValue() && (jsVar = os.this.b) != null) {
                jsVar.b(this.c);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.note.NoteEditorPresenter$onDeleteAnnotationConfirmed$1", f = "NoteEditorPresenter.kt", i = {}, l = {198, 201}, m = "invokeSuspend", n = {}, nl = {200, 202}, s = {}, v = 2)
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ ds b;
        public final /* synthetic */ os c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ds dsVar, os osVar, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = dsVar;
            this.c = osVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new d(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
        
            if (r4.b(r6, r5) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
        
            if (r6.a(r1, r5) == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r6)
                goto L4f
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1a:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L5a
            L1e:
                kotlin.ResultKt.throwOnFailure(r6)
                com.pspdfkit.internal.ds r6 = r5.b
                com.pspdfkit.annotations.AnnotationType r6 = r6.e()
                com.pspdfkit.annotations.AnnotationType r1 = com.pspdfkit.annotations.AnnotationType.NOTE
                com.pspdfkit.internal.os r4 = r5.c
                com.pspdfkit.internal.gs r4 = r4.a
                if (r6 != r1) goto L3a
                com.pspdfkit.internal.ds r6 = r5.b
                r5.a = r3
                java.lang.Object r6 = r4.b(r6, r5)
                if (r6 != r0) goto L5a
                goto L4e
            L3a:
                com.pspdfkit.internal.ds r6 = r5.b
                r1 = 0
                r4.a(r6, r1)
                com.pspdfkit.internal.os r6 = r5.c
                com.pspdfkit.internal.gs r6 = r6.a
                com.pspdfkit.internal.ds r1 = r5.b
                r5.a = r2
                java.lang.Object r6 = r6.a(r1, r5)
                if (r6 != r0) goto L4f
            L4e:
                return r0
            L4f:
                com.pspdfkit.internal.os r6 = r5.c
                com.pspdfkit.internal.gs r6 = r6.a
                com.pspdfkit.internal.ds r0 = r5.b
                r6.c(r0)
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
            L5a:
                com.pspdfkit.internal.os r5 = r5.c
                com.pspdfkit.internal.js r5 = r5.b
                if (r5 == 0) goto L63
                r5.f()
            L63:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.os.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.note.NoteEditorPresenter$onReviewStateSetOnNoteEditorCardItem$1", f = "NoteEditorPresenter.kt", i = {}, l = {Token.SETELEM_OP}, m = "invokeSuspend", n = {}, nl = {Token.XML}, s = {}, v = 2)
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ ds c;
        public final /* synthetic */ AuthorState d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ds dsVar, AuthorState authorState, Continuation<? super e> continuation) {
            super(2, continuation);
            this.c = dsVar;
            this.d = authorState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return os.this.new e(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                gs gsVar = os.this.a;
                ds dsVar = this.c;
                dsVar.getClass();
                AnnotationStateChange annotationStateChange = new AnnotationStateChange(os.this.a.g(), this.d, Calendar.getInstance().getTime());
                this.a = 1;
                if (gsVar.a((cs) dsVar, annotationStateChange, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            js jsVar = os.this.b;
            if (jsVar != null) {
                jsVar.d(this.c);
            }
            return Unit.INSTANCE;
        }
    }

    public os(gs gsVar) {
        this.a = gsVar;
    }

    @Override // com.pspdfkit.internal.is
    public final void a() {
        js jsVar = this.b;
        if (jsVar != null) {
            jsVar.f();
        }
    }

    @Override // com.pspdfkit.internal.hs
    public final void a(nl nlVar) {
    }

    @Override // com.pspdfkit.internal.es
    public final boolean b() {
        js jsVar = this.b;
        if (jsVar == null) {
            return true;
        }
        if (TextUtils.isEmpty(this.a.g())) {
            jsVar.a(new Runnable() { // from class: com.pspdfkit.internal.os$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    os.a(this.f$0);
                }
            });
            return true;
        }
        CoroutineScope coroutineScope = this.d;
        if (coroutineScope != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new b(jsVar, null), 3, null);
        }
        return true;
    }

    @Override // com.pspdfkit.internal.es
    public final void c() {
        js jsVar = this.b;
        if (jsVar != null) {
            jsVar.finishEditing();
        }
        this.a.o();
    }

    @Override // com.pspdfkit.internal.es
    public final void d() {
        js jsVar = this.b;
        if (jsVar != null) {
            if (!jsVar.g()) {
                jsVar.c();
                jsVar.b();
            }
            jsVar.d();
        }
    }

    @Override // com.pspdfkit.internal.es
    public final void e() {
        js jsVar = this.b;
        if (jsVar != null) {
            jsVar.finishEditing();
        }
        this.a.j();
    }

    @Override // com.pspdfkit.internal.is
    public final void f() {
        ds dsVarE = this.a.e();
        if (dsVarE.e() == AnnotationType.FREETEXT) {
            return;
        }
        this.c = true;
        CoroutineScope coroutineScope = this.d;
        if (coroutineScope != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new d(dsVarE, this, null), 3, null);
        }
    }

    @Override // com.pspdfkit.internal.is
    public final void a(js.a aVar) {
        js jsVar;
        if (aVar != js.a.DELETE || (jsVar = this.b) == null) {
            return;
        }
        jsVar.e();
    }

    @Override // com.pspdfkit.internal.is
    public final void a(ds dsVar, fs.b bVar) {
        AuthorState authorState;
        dsVar.getClass();
        bVar.getClass();
        int iOrdinal = bVar.ordinal();
        if (iOrdinal == 0) {
            authorState = AuthorState.ACCEPTED;
        } else if (iOrdinal == 1) {
            authorState = AuthorState.REJECTED;
        } else if (iOrdinal == 2) {
            authorState = AuthorState.CANCELLED;
        } else if (iOrdinal == 3) {
            authorState = AuthorState.COMPLETED;
        } else {
            if (iOrdinal != 4) {
                throw new NoWhenBranchMatchedException();
            }
            authorState = AuthorState.NONE;
        }
        CoroutineScope coroutineScope = this.d;
        if (coroutineScope != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new e(dsVar, authorState, null), 3, null);
        }
    }

    public final void b(ds dsVar) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (this.a.p()) {
            linkedHashSet.add(fs.a.SHARE);
        }
        if (this.a.a(dsVar)) {
            linkedHashSet.add(fs.a.DELETE);
        }
        if (this.a.b(dsVar)) {
            linkedHashSet.add(fs.a.SET_STATUS);
        }
        dsVar.a(linkedHashSet);
    }

    @Override // com.pspdfkit.internal.hs
    public final void b(nl nlVar) {
        js jsVar = this.b;
        if (jsVar != null) {
            js.a aVar = js.a.UNDO;
            jsVar.a(false);
            jsVar.setAddNewReplyBoxDisplayed(nlVar.l());
            jsVar.setStyleBoxDisplayed(false);
            jsVar.setStyleBoxPickerColors(CollectionsKt.emptyList());
            jsVar.setStyleBoxPickerIcons(CollectionsKt.emptyList());
        }
    }

    @Override // com.pspdfkit.internal.es
    public final void a(String str) {
        str.getClass();
        js jsVar = this.b;
        if (jsVar != null) {
            jsVar.setStyleBoxSelectedIcon(str);
            jsVar.setStyleBoxText(ww.a(str));
            jsVar.b();
            jsVar.c();
        }
        this.a.a(str);
        ds dsVarE = this.a.e();
        if (dsVarE instanceof cs) {
            this.a.a((cs) dsVarE, str);
        }
    }

    @Override // com.pspdfkit.internal.es
    public final void a(int i) {
        js jsVar = this.b;
        if (jsVar == null) {
            return;
        }
        jsVar.b();
        jsVar.c();
        jsVar.setStyleBoxSelectedColor(i);
        js jsVar2 = this.b;
        if (jsVar2 != null) {
            jsVar2.b(i9.a(i, 0.2f), true);
            jsVar2.a(i, true);
            int iArgb = Color.argb(255, Color.red(i), Color.green(i), Color.blue(i));
            int alphaComponent = ColorUtils.calculateContrast(-16777216, iArgb) <= ColorUtils.calculateContrast(-1, iArgb) ? -1 : -16777216;
            int iCalculateMinimumAlpha = ColorUtils.calculateMinimumAlpha(alphaComponent, iArgb, 7.0f);
            if (iCalculateMinimumAlpha >= 0) {
                alphaComponent = ColorUtils.setAlphaComponent(alphaComponent, iCalculateMinimumAlpha);
            }
            jsVar2.setToolbarForegroundColor(alphaComponent);
            jsVar2.setStatusBarColor(i);
        }
        this.a.a(i);
        ds dsVarE = this.a.e();
        if (dsVarE instanceof cs) {
            this.a.a((cs) dsVarE, i);
        }
    }

    @Override // com.pspdfkit.internal.es
    public final void a(ds dsVar, fs.a aVar) {
        dsVar.getClass();
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 0) {
            String strG = dsVar.g();
            if (strG == null) {
                strG = "";
            }
            js jsVar = this.b;
            if (jsVar != null) {
                jsVar.a(strG);
                return;
            }
            return;
        }
        if (iOrdinal == 1) {
            js jsVar2 = this.b;
            if (jsVar2 != null) {
                jsVar2.a(dsVar);
                return;
            }
            return;
        }
        if (iOrdinal == 2) {
            CoroutineScope coroutineScope = this.d;
            if (coroutineScope != null) {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new c(dsVar, null), 3, null);
                return;
            }
            return;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.pspdfkit.internal.es
    public final void a(ds dsVar) {
        dsVar.getClass();
        dsVar.a(!dsVar.k());
        js jsVar = this.b;
        if (jsVar != null) {
            jsVar.d(dsVar);
        }
    }

    public static final void a(os osVar) {
        osVar.b();
    }

    @Override // com.pspdfkit.internal.es
    public final void a(ds dsVar, String str) {
        if (dsVar.d()) {
            this.a.a(dsVar, str);
        }
    }
}
