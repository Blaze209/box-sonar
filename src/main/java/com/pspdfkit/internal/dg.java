package com.pspdfkit.internal;

import com.pspdfkit.document.files.EmbeddedFile;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.outline.embed.EmbeddedFilesViewModel$removeEmbeddedFileFromGroup$1", f = "EmbeddedFilesViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
public final class dg extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public /* synthetic */ Object a;
    public final /* synthetic */ fg b;
    public final /* synthetic */ int c;
    public final /* synthetic */ EmbeddedFile d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dg(fg fgVar, int i, EmbeddedFile embeddedFile, Continuation<? super dg> continuation) {
        super(2, continuation);
        this.b = fgVar;
        this.c = i;
        this.d = embeddedFile;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        dg dgVar = new dg(this.b, this.c, this.d, continuation);
        dgVar.a = obj;
        return dgVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((dg) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        CoroutineScope coroutineScope = (CoroutineScope) this.a;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        if (!CoroutineScopeKt.isActive(coroutineScope)) {
            return Unit.INSTANCE;
        }
        ArrayList arrayList = this.b.d;
        int i = this.c;
        int size = arrayList.size();
        int i2 = 0;
        do {
            if (i2 >= size) {
                obj2 = null;
                break;
            }
            obj2 = arrayList.get(i2);
            i2++;
        } while (((vf) obj2).a != i);
        vf vfVar = (vf) obj2;
        if (vfVar != null) {
            List<EmbeddedFile> list = vfVar.b;
            EmbeddedFile embeddedFile = this.d;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj3 : list) {
                if (!Intrinsics.areEqual((EmbeddedFile) obj3, embeddedFile)) {
                    arrayList2.add(obj3);
                }
            }
            if (arrayList2.isEmpty()) {
                Boxing.boxBoolean(this.b.d.remove(vfVar));
            } else {
                vf vfVar2 = new vf(this.c, arrayList2);
                this.b.d.set(this.b.d.indexOf(vfVar), vfVar2);
            }
            fg.a(this.b);
        }
        return Unit.INSTANCE;
    }
}
