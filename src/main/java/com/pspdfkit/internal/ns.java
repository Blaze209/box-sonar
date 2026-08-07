package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.annotations.note.NoteEditorModel", f = "NoteEditorModel.kt", i = {0}, l = {313}, m = "createCardItemForAnnotation", n = {"annotation"}, nl = {314}, s = {"L$0"}, v = 2)
public final class ns extends ContinuationImpl {
    public Annotation a;
    public Annotation b;
    public /* synthetic */ Object c;
    public final /* synthetic */ ms d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ns(ms msVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.d = msVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.a((Annotation) null, this);
    }
}
