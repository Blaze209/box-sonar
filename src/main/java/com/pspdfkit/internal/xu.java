package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativeFormNotifications;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.annotations.ParceledAnnotation", f = "ParceledAnnotation.kt", i = {0, 0, 1, 1}, l = {38, 39}, m = "getAnnotation", n = {"document", NativeFormNotifications.PROVIDER_INDEX_INFO_KEY, "document", NativeFormNotifications.PROVIDER_INDEX_INFO_KEY}, nl = {39, 38}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 2)
public final class xu extends ContinuationImpl {
    public Object a;
    public Object b;
    public /* synthetic */ Object c;
    public final /* synthetic */ wu d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xu(wu wuVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.d = wuVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.a(null, this);
    }
}
