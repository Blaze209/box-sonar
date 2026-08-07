package com.pspdfkit.internal;

import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.domain.metrics.Gen204FileActivityEventLogger;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.pspdfkit.R;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationFlags;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.NoteAnnotation;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.annotations.configuration.AnnotationColorConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry;
import com.pspdfkit.annotations.configuration.AnnotationNoteIconConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationProperty;
import com.pspdfkit.annotations.defaults.AnnotationPreferencesManager;
import com.pspdfkit.annotations.note.AnnotationReviewSummary;
import com.pspdfkit.annotations.note.AnnotationStateChange;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.annotations.AnnotationReplyFeatures;
import com.pspdfkit.configuration.sharing.ShareFeatures;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import external.sdk.pendo.io.mozilla.javascript.Context;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
public final class ms implements gs {
    public final Annotation a;
    public final AnnotationToolVariant b;
    public final PdfConfiguration c;
    public final AnnotationPreferencesManager d;
    public final o3 e;
    public final at f;
    public final String g;
    public final AnnotationColorConfiguration h;
    public final AnnotationNoteIconConfiguration i;
    public final ArrayList j;
    public final int k;
    public final ArrayList l;
    public cs m;
    public Annotation n;
    public i3 o;

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.note.NoteEditorModel", f = "NoteEditorModel.kt", i = {0, 0, 0, 1, 1, 1}, l = {187, PsExtractor.PRIVATE_STREAM_1}, m = "appendAnnotationStateChange", n = {"noteEditorCardItem", "annotationStateChange", "annotation", "noteEditorCardItem", "annotationStateChange", "annotation"}, nl = {TsExtractor.TS_PACKET_SIZE, TsExtractor.TS_PACKET_SIZE}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 2)
    public static final class a extends ContinuationImpl {
        public Object a;
        public Object b;
        public Object c;
        public cs d;
        public /* synthetic */ Object e;
        public int g;

        public a(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return ms.this.a(null, null, this);
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.note.NoteEditorModel", f = "NoteEditorModel.kt", i = {0, 1}, l = {233, 235}, m = "createNewEmptyReplyAnnotationCardItem", n = {"annotation", "annotation"}, nl = {234, -1}, s = {"L$0", "L$0"}, v = 2)
    public static final class b extends ContinuationImpl {
        public Object a;
        public /* synthetic */ Object b;
        public int d;

        public b(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return ms.this.a(this);
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.note.NoteEditorModel", f = "NoteEditorModel.kt", i = {0, 0}, l = {BoxCommonConstants.REQUEST_CHOOSE_LOCAL_UPLOAD_DIR}, m = "deleteAnnotation", n = {"noteEditorContentCard", "annotation"}, nl = {BoxCommonConstants.REQUEST_CHOOSE_REMOTE_UPLOAD_DIR}, s = {"L$0", "L$1"}, v = 2)
    public static final class c extends ContinuationImpl {
        public Object a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public c(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return ms.this.b(null, this);
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.note.NoteEditorModel", f = "NoteEditorModel.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {303, 304}, m = "deleteAnnotationReplies", n = {"contentCard", "annotation", "contentCard", "annotation", "$this$forEach$iv", "element$iv", Gen204FileActivityEventLogger.ACTION_REPLY, "$i$f$forEach", "$i$a$-forEach-NoteEditorModel$deleteAnnotationReplies$2"}, nl = {304, BoxRequestsFile.DownloadThumbnail.SIZE_320}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1"}, v = 2)
    public static final class d extends ContinuationImpl {
        public Object a;
        public Object b;
        public Object c;
        public Iterator d;
        public Object e;
        public Object f;
        public int g;
        public /* synthetic */ Object h;
        public int j;

        public d(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.h = obj;
            this.j |= Integer.MIN_VALUE;
            return ms.this.a((ds) null, this);
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.note.NoteEditorModel", f = "NoteEditorModel.kt", i = {1, 1, 1, 1, 1, 1, 1, 1}, l = {Context.VERSION_1_7, 173}, m = "getCommentThread", n = {"annotations", "replies", "$this$mapTo$iv", "destination$iv", "item$iv", "annotation", "$i$f$mapTo", "$i$a$-mapTo-NoteEditorModel$getCommentThread$2"}, nl = {171, 321}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1"}, v = 2)
    public static final class e extends ContinuationImpl {
        public Object a;
        public ArrayList b;
        public Object c;
        public Collection d;
        public Iterator e;
        public Object f;
        public Object g;
        public Collection h;
        public int i;
        public /* synthetic */ Object j;
        public int l;

        public e(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.j = obj;
            this.l |= Integer.MIN_VALUE;
            return ms.this.b(this);
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.note.NoteEditorModel$getEditedAnnotationCardItem$1", f = "NoteEditorModel.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super cs>, Object> {
        public int a;

        public f(Continuation<? super f> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ms.this.new f(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super cs> continuation) {
            return ms.this.new f(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            ms msVar = ms.this;
            Annotation annotation = msVar.a;
            this.a = 1;
            Object objA = msVar.a(annotation, this);
            return objA == coroutine_suspended ? coroutine_suspended : objA;
        }
    }

    public ms(android.content.Context context, Annotation annotation, AnnotationToolVariant annotationToolVariant, PdfConfiguration pdfConfiguration, AnnotationPreferencesManager annotationPreferencesManager, o3 o3Var, at atVar, AnnotationConfigurationRegistry annotationConfigurationRegistry) {
        annotation.getClass();
        pdfConfiguration.getClass();
        annotationPreferencesManager.getClass();
        o3Var.getClass();
        atVar.getClass();
        annotationConfigurationRegistry.getClass();
        this.a = annotation;
        this.b = annotationToolVariant;
        this.c = pdfConfiguration;
        this.d = annotationPreferencesManager;
        this.e = o3Var;
        this.f = atVar;
        String string = context.getString(R.string.pspdf__annotation_type_note);
        string.getClass();
        this.g = string;
        AnnotationTool annotationTool = AnnotationTool.NOTE;
        AnnotationColorConfiguration annotationColorConfiguration = (AnnotationColorConfiguration) annotationConfigurationRegistry.get(annotationTool, annotationToolVariant, AnnotationColorConfiguration.class);
        this.h = annotationColorConfiguration;
        AnnotationNoteIconConfiguration annotationNoteIconConfiguration = (AnnotationNoteIconConfiguration) annotationConfigurationRegistry.get(annotationTool, annotationToolVariant, AnnotationNoteIconConfiguration.class);
        this.i = annotationNoteIconConfiguration;
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.l = arrayList2;
        if (annotationColorConfiguration != null) {
            List<Integer> availableColors = annotationColorConfiguration.getAvailableColors();
            availableColors.getClass();
            arrayList.addAll(availableColors);
        }
        this.k = annotationColorConfiguration != null ? annotationColorConfiguration.getDefaultColor() : ww.a(context, annotationTool, annotationToolVariant);
        if (annotationNoteIconConfiguration != null) {
            List<String> availableIconNames = annotationNoteIconConfiguration.getAvailableIconNames();
            availableIconNames.getClass();
            arrayList2.addAll(availableIconNames);
        }
    }

    @Override // com.pspdfkit.internal.gs
    public final void a(cs csVar, int i) {
        Annotation annotation = csVar.a;
        a(annotation);
        annotation.setColor(i);
        csVar.j = i;
    }

    @Override // com.pspdfkit.internal.gs
    public final void a(hs hsVar) {
    }

    @Override // com.pspdfkit.internal.gs
    public final boolean b() {
        return (!r() || this.a.getType() == AnnotationType.FREETEXT || this.a.isLocked()) ? false : true;
    }

    @Override // com.pspdfkit.internal.gs
    public final boolean c() {
        return true;
    }

    @Override // com.pspdfkit.internal.gs
    public final List<String> d() {
        return this.l;
    }

    @Override // com.pspdfkit.internal.gs
    public final ds e() {
        if (this.m == null) {
            this.m = (cs) BuildersKt__BuildersKt.runBlocking$default(null, new f(null), 1, null);
        }
        cs csVar = this.m;
        if (csVar != null) {
            return csVar;
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    @Override // com.pspdfkit.internal.gs
    public final boolean f() {
        EnumSet<AnnotationProperty> supportedProperties;
        AnnotationColorConfiguration annotationColorConfiguration = this.h;
        return (annotationColorConfiguration == null || (supportedProperties = annotationColorConfiguration.getSupportedProperties()) == null || !supportedProperties.contains(AnnotationProperty.COLOR)) ? false : true;
    }

    @Override // com.pspdfkit.internal.gs
    public final String g() {
        String annotationCreator = this.d.getAnnotationCreator();
        return annotationCreator == null ? "" : annotationCreator;
    }

    @Override // com.pspdfkit.internal.gs
    public final String getTitle() {
        String subject = this.a.getSubject();
        return (subject == null || subject.length() == 0) ? this.g : subject;
    }

    @Override // com.pspdfkit.internal.gs
    public final boolean h() {
        if (r() && this.a.getType() == AnnotationType.NOTE && !this.a.getHasLockedContents()) {
            return f() || k();
        }
        return false;
    }

    @Override // com.pspdfkit.internal.gs
    public final boolean i() {
        return ar.b().b(this.c);
    }

    @Override // com.pspdfkit.internal.gs
    public final void j() {
    }

    @Override // com.pspdfkit.internal.gs
    public final boolean k() {
        EnumSet<AnnotationProperty> supportedProperties;
        AnnotationNoteIconConfiguration annotationNoteIconConfiguration = this.i;
        return (annotationNoteIconConfiguration == null || (supportedProperties = annotationNoteIconConfiguration.getSupportedProperties()) == null || !supportedProperties.contains(AnnotationProperty.NOTE_ICON)) ? false : true;
    }

    @Override // com.pspdfkit.internal.gs
    public final boolean l() {
        return q();
    }

    @Override // com.pspdfkit.internal.gs
    public final int m() {
        Annotation annotation = this.a;
        float f2 = ww.a;
        annotation.getClass();
        int iA = annotation.getType() == AnnotationType.STAMP ? a40.a((StampAnnotation) annotation) : annotation.getColor();
        return iA == 0 ? this.k : iA;
    }

    @Override // com.pspdfkit.internal.gs
    public final List<Integer> n() {
        return this.j;
    }

    @Override // com.pspdfkit.internal.gs
    public final void o() {
    }

    @Override // com.pspdfkit.internal.gs
    public final boolean p() {
        return this.c.getEnabledShareFeatures().contains(ShareFeatures.NOTE_EDITOR_CONTENT_SHARING);
    }

    public final boolean q() {
        return this.c.getAnnotationReplyFeatures() == AnnotationReplyFeatures.ENABLED && !this.a.getHasLockedContents() && ar.b().b(this.c) && r();
    }

    public final boolean r() {
        return ar.b().a(this.c, this.a) && ww.f(this.a);
    }

    @Override // com.pspdfkit.internal.gs
    public final void c(ds dsVar) {
        a(CollectionsKt.listOf(dsVar));
    }

    @Override // com.pspdfkit.internal.gs
    public final boolean b(ds dsVar) {
        dsVar.getClass();
        return q();
    }

    @Override // com.pspdfkit.internal.gs
    public final void a(cs csVar, String str) {
        str.getClass();
        Annotation annotation = csVar.a;
        a(annotation);
        if (annotation instanceof NoteAnnotation) {
            ((NoteAnnotation) annotation).setIconName(str);
        }
        csVar.l = str;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:29:0x00da  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00da -> B:30:0x00dd). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.pspdfkit.internal.gs
    public final java.lang.Object b(kotlin.coroutines.Continuation<? super java.util.List<? extends com.pspdfkit.internal.ds>> r13) {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.ms.b(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.pspdfkit.internal.gs
    public final boolean a(ds dsVar) {
        dsVar.getClass();
        if (Intrinsics.areEqual(this.a, dsVar.getAnnotation())) {
            return false;
        }
        return q();
    }

    @Override // com.pspdfkit.internal.gs
    public final void a(int i) {
        this.d.setColor(AnnotationTool.NOTE, this.b, i);
    }

    @Override // com.pspdfkit.internal.gs
    public final void a(String str) {
        str.getClass();
        this.d.setNoteAnnotationIcon(AnnotationTool.NOTE, this.b, str);
    }

    @Override // com.pspdfkit.internal.gs
    public final String a() {
        return ((cs) e()).l;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.pspdfkit.internal.gs
    public final Object a(cs csVar, AnnotationStateChange annotationStateChange, Continuation<? super Unit> continuation) {
        a aVar;
        cs csVar2;
        Annotation annotation;
        cs csVar3;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.g;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.g = i - Integer.MIN_VALUE;
            } else {
                aVar = new a((ContinuationImpl) continuation);
            }
        } else {
            aVar = new a((ContinuationImpl) continuation);
        }
        Object reviewSummary = aVar.e;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.g;
        if (i2 == 0) {
            ResultKt.throwOnFailure(reviewSummary);
            Annotation annotation2 = csVar.a;
            a(annotation2);
            o3 o3Var = this.e;
            aVar.a = csVar;
            aVar.b = SpillingKt.nullOutSpilledVariable(annotationStateChange);
            aVar.c = annotation2;
            aVar.g = 1;
            if (o3Var.appendAnnotationState(annotation2, annotationStateChange, aVar) != coroutine_suspended) {
                csVar2 = csVar;
                annotation = annotation2;
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            annotation = (Annotation) aVar.c;
            annotationStateChange = (AnnotationStateChange) aVar.b;
            csVar2 = (cs) aVar.a;
            ResultKt.throwOnFailure(reviewSummary);
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            csVar3 = aVar.d;
            ResultKt.throwOnFailure(reviewSummary);
        }
        csVar3.b = (AnnotationReviewSummary) reviewSummary;
        return Unit.INSTANCE;
        o3 o3Var2 = this.e;
        String annotationCreator = this.d.getAnnotationCreator();
        aVar.a = SpillingKt.nullOutSpilledVariable(csVar2);
        aVar.b = SpillingKt.nullOutSpilledVariable(annotationStateChange);
        aVar.c = SpillingKt.nullOutSpilledVariable(annotation);
        aVar.d = csVar2;
        aVar.g = 2;
        reviewSummary = o3Var2.getReviewSummary(annotation, annotationCreator, aVar);
        if (reviewSummary != coroutine_suspended) {
            csVar3 = csVar2;
            csVar3.b = (AnnotationReviewSummary) reviewSummary;
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }

    @Override // com.pspdfkit.internal.gs
    public final void a(ds dsVar, String str) {
        Annotation annotation = dsVar.getAnnotation();
        if (annotation == null) {
            return;
        }
        a(annotation);
        annotation.setContents(str);
        dsVar.a(str);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.pspdfkit.internal.gs
    public final Object a(Continuation<? super cs> continuation) {
        b bVar;
        Annotation noteAnnotation;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i = bVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar.d = i - Integer.MIN_VALUE;
            } else {
                bVar = new b((ContinuationImpl) continuation);
            }
        } else {
            bVar = new b((ContinuationImpl) continuation);
        }
        Object obj = bVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bVar.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            noteAnnotation = new NoteAnnotation(this.a.getPageIndex(), this.a.getBoundingBox(), "", null);
            noteAnnotation.setInReplyTo(this.a);
            noteAnnotation.setCreator(g());
            noteAnnotation.setCreatedDate(Calendar.getInstance().getTime());
            EnumSet<AnnotationFlags> enumSetCopyOf = EnumSet.copyOf((EnumSet) noteAnnotation.getFlags());
            enumSetCopyOf.add(AnnotationFlags.HIDDEN);
            noteAnnotation.setFlags(enumSetCopyOf);
            noteAnnotation.getInternal().setVariant(this.b);
            o3 o3Var = this.e;
            bVar.a = noteAnnotation;
            bVar.d = 1;
            if (o3Var.addAnnotationToPage(noteAnnotation, bVar) != coroutine_suspended) {
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        noteAnnotation = (NoteAnnotation) bVar.a;
        ResultKt.throwOnFailure(obj);
        a(noteAnnotation);
        bVar.a = SpillingKt.nullOutSpilledVariable(noteAnnotation);
        bVar.d = 2;
        Object objA = a(noteAnnotation, bVar);
        return objA == coroutine_suspended ? coroutine_suspended : objA;
    }

    public final void a(Annotation annotation) {
        Annotation annotation2;
        if (Intrinsics.areEqual(this.n, annotation)) {
            return;
        }
        i3 i3Var = null;
        if (this.o != null && (annotation2 = this.n) != null) {
            bm internal = annotation2.getInternal();
            if (internal != null) {
                internal.setVariant(this.b);
            }
            i3 i3Var2 = this.o;
            if (i3Var2 != null) {
                i3Var2.c();
            }
            this.o = null;
        }
        this.n = annotation;
        if (annotation != null) {
            at atVar = this.f;
            atVar.getClass();
            i3Var = new i3(CollectionsKt.listOf(annotation), atVar);
            i3Var.b();
        }
        this.o = i3Var;
    }

    @Override // com.pspdfkit.internal.gs
    public final void a(List<? extends ds> list) {
        String strI;
        list.getClass();
        if (ar.b().a(NativeLicenseFeatures.ANNOTATION_EDITING)) {
            for (ds dsVar : list) {
                Annotation annotation = dsVar.getAnnotation();
                if (annotation != null) {
                    a(annotation);
                    annotation.setContents(dsVar.g());
                    annotation.getInternal().setVariant(this.b);
                    int color = dsVar.getColor();
                    if (annotation.getColor() != color && color != 0) {
                        annotation.setColor(color);
                    }
                    if ((annotation instanceof NoteAnnotation) && (strI = dsVar.i()) != null) {
                        ((NoteAnnotation) annotation).setIconName(strI);
                    }
                }
            }
            i3 i3Var = this.o;
            if (i3Var != null) {
                i3Var.c();
            }
            this.o = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x009a  */
    /* JADX WARN: Code duplicated, block: B:33:0x00cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:? A[LOOP:0: B:25:0x0094->B:35:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.pspdfkit.internal.gs
    public final Object a(ds dsVar, Continuation<? super Unit> continuation) {
        d dVar;
        Annotation annotation;
        Iterable iterable;
        Iterator it;
        ds dsVar2;
        int i;
        Annotation annotation2;
        o3 o3Var;
        if (continuation instanceof d) {
            dVar = (d) continuation;
            int i2 = dVar.j;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                dVar.j = i2 - Integer.MIN_VALUE;
            } else {
                dVar = new d((ContinuationImpl) continuation);
            }
        } else {
            dVar = new d((ContinuationImpl) continuation);
        }
        Object obj = dVar.h;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = dVar.j;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Annotation annotation3 = dsVar.getAnnotation();
            if (annotation3 == null) {
                return Unit.INSTANCE;
            }
            o3 o3Var2 = this.e;
            dVar.a = SpillingKt.nullOutSpilledVariable(dsVar);
            dVar.b = SpillingKt.nullOutSpilledVariable(annotation3);
            dVar.j = 1;
            o3Var2.getClass();
            Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new u3(true, o3Var2, annotation3, null), dVar);
            if (objWithContext != coroutine_suspended) {
                annotation = annotation3;
                obj = objWithContext;
            }
            return coroutine_suspended;
        }
        if (i3 == 1) {
            Annotation annotation4 = (Annotation) dVar.b;
            ds dsVar3 = (ds) dVar.a;
            ResultKt.throwOnFailure(obj);
            annotation = annotation4;
            dsVar = dsVar3;
        } else {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = dVar.g;
            it = dVar.d;
            iterable = (Iterable) dVar.c;
            annotation = (Annotation) dVar.b;
            dsVar2 = (ds) dVar.a;
            ResultKt.throwOnFailure(obj);
        }
        while (it.hasNext()) {
            Object next = it.next();
            annotation2 = (Annotation) next;
            o3Var = this.e;
            dVar.a = SpillingKt.nullOutSpilledVariable(dsVar2);
            dVar.b = SpillingKt.nullOutSpilledVariable(annotation);
            dVar.c = SpillingKt.nullOutSpilledVariable(iterable);
            dVar.d = it;
            dVar.e = SpillingKt.nullOutSpilledVariable(next);
            dVar.f = SpillingKt.nullOutSpilledVariable(annotation2);
            dVar.g = i;
            dVar.j = 2;
            if (o3Var.removeAnnotationFromPage(annotation2, dVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
        iterable = (Iterable) obj;
        it = iterable.iterator();
        dsVar2 = dsVar;
        i = 0;
        while (it.hasNext()) {
            Object next2 = it.next();
            annotation2 = (Annotation) next2;
            o3Var = this.e;
            dVar.a = SpillingKt.nullOutSpilledVariable(dsVar2);
            dVar.b = SpillingKt.nullOutSpilledVariable(annotation);
            dVar.c = SpillingKt.nullOutSpilledVariable(iterable);
            dVar.d = it;
            dVar.e = SpillingKt.nullOutSpilledVariable(next2);
            dVar.f = SpillingKt.nullOutSpilledVariable(annotation2);
            dVar.g = i;
            dVar.j = 2;
            if (o3Var.removeAnnotationFromPage(annotation2, dVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0079  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Annotation annotation, ContinuationImpl continuationImpl) {
        ns nsVar;
        AnnotationReviewSummary annotationReviewSummary;
        Annotation annotation2;
        Object obj;
        if (continuationImpl instanceof ns) {
            nsVar = (ns) continuationImpl;
            int i = nsVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                nsVar.e = i - Integer.MIN_VALUE;
            } else {
                nsVar = new ns(this, continuationImpl);
            }
        } else {
            nsVar = new ns(this, continuationImpl);
        }
        Object obj2 = nsVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = nsVar.e;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            if (ar.b().b(this.c)) {
                nsVar.a = annotation;
                nsVar.b = annotation;
                nsVar.e = 1;
                Object reviewSummary = this.e.getReviewSummary(annotation, this.d.getAnnotationCreator(), nsVar);
                if (reviewSummary == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = reviewSummary;
                annotation2 = annotation;
            } else {
                annotationReviewSummary = null;
                annotation2 = annotation;
            }
            return new cs(annotation2, annotationReviewSummary, (r() || annotation.getType() == AnnotationType.FREETEXT || annotation.getHasLockedContents()) ? false : true);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Annotation annotation3 = nsVar.b;
        Annotation annotation4 = nsVar.a;
        ResultKt.throwOnFailure(obj2);
        annotation2 = annotation3;
        annotation = annotation4;
        obj = obj2;
        annotationReviewSummary = (AnnotationReviewSummary) obj;
        return new cs(annotation2, annotationReviewSummary, (r() || annotation.getType() == AnnotationType.FREETEXT || annotation.getHasLockedContents()) ? false : true);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.pspdfkit.internal.gs
    public final Object b(ds dsVar, Continuation<? super Boolean> continuation) {
        c cVar;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i = cVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                cVar.e = i - Integer.MIN_VALUE;
            } else {
                cVar = new c((ContinuationImpl) continuation);
            }
        } else {
            cVar = new c((ContinuationImpl) continuation);
        }
        Object obj = cVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = cVar.e;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Annotation annotation = dsVar.getAnnotation();
            if (annotation == null) {
                return Boxing.boxBoolean(false);
            }
            if (annotation.getType() != AnnotationType.NOTE) {
                annotation.setContents(null);
            } else {
                a((Annotation) null);
                o3 o3Var = this.e;
                cVar.a = SpillingKt.nullOutSpilledVariable(dsVar);
                cVar.b = SpillingKt.nullOutSpilledVariable(annotation);
                cVar.e = 1;
                if (o3Var.removeAnnotationFromPage(annotation, cVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxBoolean(true);
    }
}
