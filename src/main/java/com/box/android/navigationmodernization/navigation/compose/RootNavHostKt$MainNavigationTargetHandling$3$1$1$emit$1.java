package com.box.android.navigationmodernization.navigation.compose;

import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.navigationmodernization.MainNavigationTarget;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: RootNavHost.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$MainNavigationTargetHandling$3$1$1", f = "RootNavHost.kt", i = {0}, l = {BoxCommonConstants.REQUEST_DELETE_CURRENT_FOLDER}, m = "emit", n = {"request"}, s = {"L$0"}, v = 1)
final class RootNavHostKt$MainNavigationTargetHandling$3$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RootNavHostKt$MainNavigationTargetHandling$3$1.AnonymousClass1<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    RootNavHostKt$MainNavigationTargetHandling$3$1$1$emit$1(RootNavHostKt$MainNavigationTargetHandling$3$1.AnonymousClass1<? super T> anonymousClass1, Continuation<? super RootNavHostKt$MainNavigationTargetHandling$3$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((MainNavigationTarget) null, (Continuation<? super Unit>) this);
    }
}
