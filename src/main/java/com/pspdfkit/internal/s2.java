package com.pspdfkit.internal;

import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.outline.annotations.AnnotationListProvider$commitReorder$1", f = "AnnotationListProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1}, l = {Token.SET_REF_OP, Token.DOTQUERY}, m = "invokeSuspend", n = {"$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "it", "$i$f$map", "$i$f$mapTo", "$i$a$-map-AnnotationListProvider$commitReorder$1$zIndices$1", "zIndices", "i"}, nl = {304, Token.XML}, s = {"L$0", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1", "I$2", "L$0", "I$0"}, v = 2)
public final class s2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public Object a;
    public o3 b;
    public Object c;
    public Collection d;
    public Iterator e;
    public Object f;
    public Object g;
    public Collection h;
    public int i;
    public int j;
    public int k;
    public final /* synthetic */ ArrayList l;
    public final /* synthetic */ o3 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s2(ArrayList arrayList, o3 o3Var, Continuation continuation) {
        super(2, continuation);
        this.l = arrayList;
        this.m = o3Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new s2(this.l, this.m, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new s2(this.l, this.m, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0063 A[Catch: all -> 0x00fc, TryCatch #0 {all -> 0x00fc, blocks: (B:7:0x0017, B:25:0x00be, B:12:0x003c, B:22:0x009f, B:16:0x005d, B:18:0x0063, B:23:0x00ae, B:15:0x0043), top: B:33:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x009d  */
    /* JADX WARN: Code duplicated, block: B:21:0x009e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x009e -> B:22:0x009f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00f7 -> B:28:0x00fa). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.s2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
