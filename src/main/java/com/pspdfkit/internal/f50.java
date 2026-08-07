package com.pspdfkit.internal;

import com.pspdfkit.ui.fonts.Font;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.ui.fonts.SystemFontManager$getFontByFileName$1", f = "SystemFontManager.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
public final class f50 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Font>, Object> {
    public e50 a;
    public int b;
    public final /* synthetic */ e50 c;
    public final /* synthetic */ String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f50(e50 e50Var, String str, Continuation<? super f50> continuation) {
        super(2, continuation);
        this.c = e50Var;
        this.d = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new f50(this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Font> continuation) {
        return new f50(this.c, this.d, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        e50 e50Var;
        Object next;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.b;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            e50 e50Var2 = this.c;
            Deferred<List<Font>> deferred = e50Var2.b;
            this.a = e50Var2;
            this.b = 1;
            Object objAwait = deferred.await(this);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
            e50Var = e50Var2;
            obj = objAwait;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            e50Var = this.a;
            ResultKt.throwOnFailure(obj);
        }
        String str = this.d;
        Map<String, Integer> map = e50.e;
        e50Var.getClass();
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            next = it.next();
            List<File> fontFiles = ((Font) next).getFontFiles();
            if (!(fontFiles instanceof Collection) || !fontFiles.isEmpty()) {
                Iterator<T> it2 = fontFiles.iterator();
                while (it2.hasNext()) {
                    if (Intrinsics.areEqual(((File) it2.next()).getPath(), str)) {
                        return (Font) next;
                    }
                }
            }
        }
        next = null;
        return (Font) next;
    }
}
