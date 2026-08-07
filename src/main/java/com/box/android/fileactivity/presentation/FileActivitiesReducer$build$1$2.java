package com.box.android.fileactivity.presentation;

import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: FileActivitiesReducer.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action$FileModelRefreshed;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.fileactivity.presentation.FileActivitiesReducer$build$1$2", f = "FileActivitiesReducer.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {550, 553}, m = "invokeSuspend", n = {"$this$flow", "itemId", "$this$flow", "itemId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$onSuccess$iv", "itemModel", "it", "$i$f$onSuccess", "$i$a$-onSuccess-FileActivitiesReducer$build$1$2$1", "$i$a$-let-FileActivitiesReducer$build$1$2$1$1"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2"}, v = 1)
final class FileActivitiesReducer$build$1$2 extends SuspendLambda implements Function2<FlowCollector<? super FileActivitiesReducer.Action.FileModelRefreshed>, Continuation<? super Unit>, Object> {
    final /* synthetic */ FileActivitiesReducer.State $state;
    int I$0;
    int I$1;
    int I$2;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ FileActivitiesReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileActivitiesReducer$build$1$2(FileActivitiesReducer.State state, FileActivitiesReducer fileActivitiesReducer, Continuation<? super FileActivitiesReducer$build$1$2> continuation) {
        super(2, continuation);
        this.$state = state;
        this.this$0 = fileActivitiesReducer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FileActivitiesReducer$build$1$2 fileActivitiesReducer$build$1$2 = new FileActivitiesReducer$build$1$2(this.$state, this.this$0, continuation);
        fileActivitiesReducer$build$1$2.L$0 = obj;
        return fileActivitiesReducer$build$1$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super FileActivitiesReducer.Action.FileModelRefreshed> flowCollector, Continuation<? super Unit> continuation) {
        return ((FileActivitiesReducer$build$1$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00c1, code lost:
    
        if (r0.emit(r6, r9) == r1) goto L28;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.fileactivity.presentation.FileActivitiesReducer$build$1$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
