package com.pspdfkit.internal;

import com.pspdfkit.document.files.EmbeddedFile;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.outline.embed.EmbeddedFilesViewModel$addEmbeddedFileToGroup$1", f = "EmbeddedFilesViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
public final class bg extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public /* synthetic */ Object a;
    public final /* synthetic */ fg b;
    public final /* synthetic */ EmbeddedFile c;
    public final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg(fg fgVar, EmbeddedFile embeddedFile, int i, Continuation<? super bg> continuation) {
        super(2, continuation);
        this.b = fgVar;
        this.c = embeddedFile;
        this.d = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        bg bgVar = new bg(this.b, this.c, this.d, continuation);
        bgVar.a = obj;
        return bgVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((bg) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        int i = this.d;
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
        if (vfVar == null) {
            this.b.d.add(new vf(this.d, CollectionsKt.listOf(this.c)));
            fg.a(this.b);
        } else if (!vfVar.b.contains(this.c)) {
            vf vfVar2 = new vf(this.d, CollectionsKt.plus((Collection<? extends EmbeddedFile>) vfVar.b, this.c));
            this.b.d.set(this.b.d.indexOf(vfVar), vfVar2);
            fg.a(this.b);
        }
        return Unit.INSTANCE;
    }
}
