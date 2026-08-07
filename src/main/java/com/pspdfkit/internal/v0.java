package com.pspdfkit.internal;

import android.util.SparseIntArray;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.CircleAnnotation;
import com.pspdfkit.annotations.FreeTextAnnotation;
import com.pspdfkit.annotations.HighlightAnnotation;
import com.pspdfkit.annotations.InkAnnotation;
import com.pspdfkit.annotations.LineAnnotation;
import com.pspdfkit.annotations.LinkAnnotation;
import com.pspdfkit.annotations.NoteAnnotation;
import com.pspdfkit.annotations.PolygonAnnotation;
import com.pspdfkit.annotations.PolylineAnnotation;
import com.pspdfkit.annotations.RedactionAnnotation;
import com.pspdfkit.annotations.SoundAnnotation;
import com.pspdfkit.annotations.SquareAnnotation;
import com.pspdfkit.annotations.SquigglyAnnotation;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.annotations.StrikeOutAnnotation;
import com.pspdfkit.annotations.UnderlineAnnotation;
import com.pspdfkit.undo.edit.Edit;
import com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* JADX INFO: loaded from: classes3.dex */
public final class v0 extends y4<AnnotationAddRemoveEdit> {

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AnnotationType.values().length];
            try {
                iArr[AnnotationType.LINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotationType.HIGHLIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotationType.STRIKEOUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnnotationType.UNDERLINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AnnotationType.SQUIGGLY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AnnotationType.FREETEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AnnotationType.INK.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[AnnotationType.SQUARE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[AnnotationType.CIRCLE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[AnnotationType.LINE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[AnnotationType.NOTE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[AnnotationType.STAMP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[AnnotationType.POLYGON.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[AnnotationType.POLYLINE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[AnnotationType.REDACT.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[AnnotationType.SOUND.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(o3 o3Var, SparseIntArray sparseIntArray, q7.a<? super AnnotationAddRemoveEdit> aVar) {
        super(o3Var, sparseIntArray, AnnotationAddRemoveEdit.class, aVar);
        o3Var.getClass();
        aVar.getClass();
    }

    @Override // com.pspdfkit.internal.y60
    public final boolean a(Edit edit) {
        AnnotationAddRemoveEdit annotationAddRemoveEdit = (AnnotationAddRemoveEdit) edit;
        annotationAddRemoveEdit.getClass();
        return (annotationAddRemoveEdit.getType() == AnnotationAddRemoveEdit.Type.ADD_ANNOTATION) == ((Boolean) BuildersKt__BuildersKt.runBlocking$default(null, new x0(this, annotationAddRemoveEdit, null), 1, null)).booleanValue();
    }

    @Override // com.pspdfkit.internal.y60
    public final boolean b(Edit edit) {
        AnnotationAddRemoveEdit annotationAddRemoveEdit = (AnnotationAddRemoveEdit) edit;
        annotationAddRemoveEdit.getClass();
        return (annotationAddRemoveEdit.getType() == AnnotationAddRemoveEdit.Type.ADD_ANNOTATION) != ((Boolean) BuildersKt__BuildersKt.runBlocking$default(null, new x0(this, annotationAddRemoveEdit, null), 1, null)).booleanValue();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
    
        if (a(r6, (kotlin.coroutines.jvm.internal.ContinuationImpl) r0) == r1) goto L26;
     */
    @Override // com.pspdfkit.internal.q7
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.pspdfkit.internal.z0
            if (r0 == 0) goto L13
            r0 = r7
            com.pspdfkit.internal.z0 r0 = (com.pspdfkit.internal.z0) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.pspdfkit.internal.z0 r0 = new com.pspdfkit.internal.z0
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 == r4) goto L31
            if (r2 != r3) goto L29
            goto L31
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit r6 = r0.a
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L5b
            goto L58
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit$Type r7 = r6.getType()     // Catch: java.lang.Exception -> L5b
            com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit$Type r2 = com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit.Type.ADD_ANNOTATION     // Catch: java.lang.Exception -> L5b
            if (r7 != r2) goto L4d
            r0.a = r6     // Catch: java.lang.Exception -> L5b
            r0.d = r4     // Catch: java.lang.Exception -> L5b
            java.lang.Object r5 = r5.d(r6, r0)     // Catch: java.lang.Exception -> L5b
            if (r5 != r1) goto L58
            goto L57
        L4d:
            r0.a = r6     // Catch: java.lang.Exception -> L5b
            r0.d = r3     // Catch: java.lang.Exception -> L5b
            java.lang.Object r5 = r5.a(r6, r0)     // Catch: java.lang.Exception -> L5b
            if (r5 != r1) goto L58
        L57:
            return r1
        L58:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L5b:
            com.pspdfkit.undo.exceptions.UndoEditFailedException r5 = new com.pspdfkit.undo.exceptions.UndoEditFailedException
            com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit$Type r7 = r6.getType()
            com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit$Type r0 = com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit.Type.ADD_ANNOTATION
            if (r7 != r0) goto L68
            java.lang.String r7 = "adding"
            goto L6b
        L68:
            java.lang.String r7 = "removing"
        L6b:
            com.pspdfkit.internal.j3 r6 = r6.getProperties()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Could not undo "
            r0.<init>(r1)
            java.lang.StringBuilder r7 = r0.append(r7)
            java.lang.String r0 = " of the annotation. Annotation properties: "
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.StringBuilder r6 = r7.append(r6)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.v0.a(com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006d, code lost:
    
        if (r5.a(r7, false, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0) == r1) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.pspdfkit.internal.a1
            if (r0 == 0) goto L13
            r0 = r7
            com.pspdfkit.internal.a1 r0 = (com.pspdfkit.internal.a1) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            com.pspdfkit.internal.a1 r0 = new com.pspdfkit.internal.a1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r5 = r0.b
            com.pspdfkit.annotations.Annotation r5 = (com.pspdfkit.annotations.Annotation) r5
            java.lang.Object r5 = r0.a
            com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit r5 = (com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit) r5
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L73
            goto L70
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3c:
            java.lang.Object r6 = r0.a
            com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit r6 = (com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit) r6
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L73
            goto L56
        L44:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)     // Catch: java.lang.Exception -> L73
            r0.a = r7     // Catch: java.lang.Exception -> L73
            r0.e = r4     // Catch: java.lang.Exception -> L73
            java.lang.Object r7 = r5.a(r6, r0)     // Catch: java.lang.Exception -> L73
            if (r7 != r1) goto L56
            goto L6f
        L56:
            com.pspdfkit.annotations.Annotation r7 = (com.pspdfkit.annotations.Annotation) r7     // Catch: java.lang.Exception -> L73
            com.pspdfkit.internal.o3 r5 = r5.e     // Catch: java.lang.Exception -> L73
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)     // Catch: java.lang.Exception -> L73
            r0.a = r6     // Catch: java.lang.Exception -> L73
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)     // Catch: java.lang.Exception -> L73
            r0.b = r6     // Catch: java.lang.Exception -> L73
            r0.e = r3     // Catch: java.lang.Exception -> L73
            r6 = 0
            java.lang.Object r5 = r5.a(r7, r6, r0)     // Catch: java.lang.Exception -> L73
            if (r5 != r1) goto L70
        L6f:
            return r1
        L70:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L73:
            r5 = move-exception
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Could not remove annotation from the document."
            r6.<init>(r7, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.v0.d(com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // com.pspdfkit.internal.q7
    public final /* bridge */ /* synthetic */ Object a(Edit edit, s7 s7Var) {
        return b((AnnotationAddRemoveEdit) edit, (ContinuationImpl) s7Var);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(AnnotationAddRemoveEdit annotationAddRemoveEdit, ContinuationImpl continuationImpl) {
        w0 w0Var;
        int i;
        Annotation annotation;
        int i2;
        if (continuationImpl instanceof w0) {
            w0Var = (w0) continuationImpl;
            int i3 = w0Var.f;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                w0Var.f = i3 - Integer.MIN_VALUE;
            } else {
                w0Var = new w0(this, continuationImpl);
            }
        } else {
            w0Var = new w0(this, continuationImpl);
        }
        w0 w0Var2 = w0Var;
        Object obj = w0Var2.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = w0Var2.f;
        try {
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                Annotation annotationA = a(annotationAddRemoveEdit);
                int objectNumber = annotationAddRemoveEdit.getObjectNumber();
                do {
                    i = objectNumber;
                    objectNumber = this.f.get(i, i);
                } while (objectNumber != i);
                o3 o3Var = this.e;
                Integer numBoxInt = Boxing.boxInt(i);
                w0Var2.a = SpillingKt.nullOutSpilledVariable(annotationAddRemoveEdit);
                w0Var2.b = annotationA;
                w0Var2.c = i;
                w0Var2.f = 1;
                Object objA = o3Var.a(annotationA, numBoxInt, (Integer) null, false, (Continuation<? super Unit>) w0Var2);
                if (objA != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    objA = Unit.INSTANCE;
                }
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
                annotation = annotationA;
                i2 = i;
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i2 = w0Var2.c;
                annotation = w0Var2.b;
                ResultKt.throwOnFailure(obj);
            }
            int objectNumber2 = annotation.getObjectNumber();
            if (objectNumber2 != i2) {
                this.f.put(i2, objectNumber2);
            }
            return Unit.INSTANCE;
        } catch (Exception e) {
            throw new IllegalStateException("Could not add annotation to the document.", e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
    
        if (d(r6, r0) == r1) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.pspdfkit.internal.y0
            if (r0 == 0) goto L13
            r0 = r7
            com.pspdfkit.internal.y0 r0 = (com.pspdfkit.internal.y0) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.pspdfkit.internal.y0 r0 = new com.pspdfkit.internal.y0
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 == r4) goto L31
            if (r2 != r3) goto L29
            goto L31
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit r6 = r0.a
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L5b
            goto L58
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit$Type r7 = r6.getType()     // Catch: java.lang.Exception -> L5b
            com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit$Type r2 = com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit.Type.ADD_ANNOTATION     // Catch: java.lang.Exception -> L5b
            if (r7 != r2) goto L4d
            r0.a = r6     // Catch: java.lang.Exception -> L5b
            r0.d = r4     // Catch: java.lang.Exception -> L5b
            java.lang.Object r5 = r5.a(r6, r0)     // Catch: java.lang.Exception -> L5b
            if (r5 != r1) goto L58
            goto L57
        L4d:
            r0.a = r6     // Catch: java.lang.Exception -> L5b
            r0.d = r3     // Catch: java.lang.Exception -> L5b
            java.lang.Object r5 = r5.d(r6, r0)     // Catch: java.lang.Exception -> L5b
            if (r5 != r1) goto L58
        L57:
            return r1
        L58:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L5b:
            com.pspdfkit.undo.exceptions.RedoEditFailedException r5 = new com.pspdfkit.undo.exceptions.RedoEditFailedException
            com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit$Type r6 = r6.getType()
            com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit$Type r7 = com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit.Type.ADD_ANNOTATION
            if (r6 != r7) goto L68
            java.lang.String r6 = "adding"
            goto L6b
        L68:
            java.lang.String r6 = "removing"
        L6b:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "Could not redo "
            r7.<init>(r0)
            java.lang.StringBuilder r6 = r7.append(r6)
            java.lang.String r7 = " of the annotation."
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.v0.b(com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static Annotation a(AnnotationAddRemoveEdit annotationAddRemoveEdit) {
        Annotation linkAnnotation;
        switch (a.a[annotationAddRemoveEdit.getAnnotationType().ordinal()]) {
            case 1:
                linkAnnotation = new LinkAnnotation(annotationAddRemoveEdit.getProperties(), true);
                break;
            case 2:
                linkAnnotation = new HighlightAnnotation(annotationAddRemoveEdit.getProperties(), true);
                break;
            case 3:
                linkAnnotation = new StrikeOutAnnotation(annotationAddRemoveEdit.getProperties(), true);
                break;
            case 4:
                linkAnnotation = new UnderlineAnnotation(annotationAddRemoveEdit.getProperties(), true);
                break;
            case 5:
                linkAnnotation = new SquigglyAnnotation(annotationAddRemoveEdit.getProperties(), true);
                break;
            case 6:
                linkAnnotation = new FreeTextAnnotation(annotationAddRemoveEdit.getProperties(), true);
                break;
            case 7:
                linkAnnotation = new InkAnnotation(annotationAddRemoveEdit.getProperties(), true);
                break;
            case 8:
                linkAnnotation = new SquareAnnotation(annotationAddRemoveEdit.getProperties(), true);
                break;
            case 9:
                linkAnnotation = new CircleAnnotation(annotationAddRemoveEdit.getProperties(), true);
                break;
            case 10:
                linkAnnotation = new LineAnnotation(annotationAddRemoveEdit.getProperties(), true);
                break;
            case 11:
                linkAnnotation = new NoteAnnotation(annotationAddRemoveEdit.getProperties(), true);
                break;
            case 12:
                linkAnnotation = new StampAnnotation(annotationAddRemoveEdit.getProperties(), true, annotationAddRemoveEdit.getBitmap());
                break;
            case 13:
                linkAnnotation = new PolygonAnnotation(annotationAddRemoveEdit.getProperties(), true);
                break;
            case 14:
                linkAnnotation = new PolylineAnnotation(annotationAddRemoveEdit.getProperties(), true);
                break;
            case 15:
                linkAnnotation = new RedactionAnnotation(annotationAddRemoveEdit.getProperties(), true);
                break;
            case 16:
                linkAnnotation = new SoundAnnotation(annotationAddRemoveEdit.getProperties(), true, annotationAddRemoveEdit.getAudioData());
                break;
            default:
                throw new IllegalStateException("Can't create annotation of type " + annotationAddRemoveEdit.getAnnotationType().name());
        }
        if (annotationAddRemoveEdit.getAppearanceStreamGenerator() != null) {
            linkAnnotation.setAppearanceStreamGenerator(annotationAddRemoveEdit.getAppearanceStreamGenerator());
        }
        return linkAnnotation;
    }
}
