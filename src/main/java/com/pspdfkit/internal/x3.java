package com.pspdfkit.internal;

import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.forms.FormField;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.annotations.AnnotationProviderImpl$getWidgetAnnotations$2", f = "AnnotationProviderImpl.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {265}, m = "invokeSuspend", n = {"nativeAnnotations", "annotations", "$this$forEach$iv", "element$iv", "nativeAnnotation", "nativeAnnotationHolder", "platformAnnotation", "$i$f$forEach", "$i$a$-forEach-AnnotationProviderImpl$getWidgetAnnotations$2$1"}, nl = {261}, s = {"L$0", "L$1", "L$2", "L$5", "L$6", "L$7", "L$8", "I$0", "I$1"}, v = 2)
public final class x3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArrayList<WidgetAnnotation>>, Object> {
    public Object a;
    public ArrayList b;
    public Object c;
    public o3 d;
    public Iterator e;
    public Object f;
    public Object g;
    public kr h;
    public Object i;
    public int j;
    public int k;
    public final /* synthetic */ FormField l;
    public final /* synthetic */ o3 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x3(FormField formField, o3 o3Var, Continuation<? super x3> continuation) {
        super(2, continuation);
        this.l = formField;
        this.m = o3Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new x3(this.l, this.m, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ArrayList<WidgetAnnotation>> continuation) {
        return new x3(this.l, this.m, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0086  */
    /* JADX WARN: Code duplicated, block: B:19:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:22:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:24:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:26:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:28:0x0103 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x0104  */
    /* JADX WARN: Code duplicated, block: B:34:0x0110  */
    /* JADX WARN: Code duplicated, block: B:36:0x0113  */
    /* JADX WARN: Code duplicated, block: B:38:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:? A[LOOP:0: B:13:0x0080->B:41:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0104 -> B:30:0x0105). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0110 -> B:35:0x0111). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:38:0x0095
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.x3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
