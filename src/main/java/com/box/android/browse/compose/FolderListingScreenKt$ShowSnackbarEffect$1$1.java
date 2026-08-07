package com.box.android.browse.compose;

import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarResult;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.browse.fragments.BoxSearchFragment;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FolderListingScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.browse.compose.FolderListingScreenKt$ShowSnackbarEffect$1$1", f = "FolderListingScreen.kt", i = {}, l = {BoxSearchFragment.REQUEST_FILTER_SEARCH_RESULTS, 233}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FolderListingScreenKt$ShowSnackbarEffect$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isNetworkError;
    final /* synthetic */ String $message;
    final /* synthetic */ String $networkErrorRetryLabel;
    final /* synthetic */ Function4<String, String, SnackbarDuration, Continuation<? super SnackbarResult>, Object> $onShowSnackbar;
    final /* synthetic */ Store<ItemsListReducer.State, ItemsListReducer.Action> $store;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FolderListingScreenKt$ShowSnackbarEffect$1$1(boolean z, Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function4, String str, String str2, Store<ItemsListReducer.State, ItemsListReducer.Action> store, Continuation<? super FolderListingScreenKt$ShowSnackbarEffect$1$1> continuation) {
        super(2, continuation);
        this.$isNetworkError = z;
        this.$onShowSnackbar = function4;
        this.$message = str;
        this.$networkErrorRetryLabel = str2;
        this.$store = store;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FolderListingScreenKt$ShowSnackbarEffect$1$1(this.$isNetworkError, this.$onShowSnackbar, this.$message, this.$networkErrorRetryLabel, this.$store, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FolderListingScreenKt$ShowSnackbarEffect$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
    
        if (r6 == r0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
    
        if (r6.invoke(r1, null, r3, r5) == r0) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r6)
            goto L56
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L1a:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L36
        L1e:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r5.$isNetworkError
            if (r6 == 0) goto L46
            kotlin.jvm.functions.Function4<java.lang.String, java.lang.String, androidx.compose.material3.SnackbarDuration, kotlin.coroutines.Continuation<? super androidx.compose.material3.SnackbarResult>, java.lang.Object> r6 = r5.$onShowSnackbar
            java.lang.String r1 = r5.$message
            java.lang.String r2 = r5.$networkErrorRetryLabel
            androidx.compose.material3.SnackbarDuration r4 = androidx.compose.material3.SnackbarDuration.Indefinite
            r5.label = r3
            java.lang.Object r6 = r6.invoke(r1, r2, r4, r5)
            if (r6 != r0) goto L36
            goto L55
        L36:
            androidx.compose.material3.SnackbarResult r6 = (androidx.compose.material3.SnackbarResult) r6
            androidx.compose.material3.SnackbarResult r0 = androidx.compose.material3.SnackbarResult.ActionPerformed
            if (r6 != r0) goto L43
            com.box.android.cpl.Store<com.box.android.browse.cpl.itemsList.ItemsListReducer$State, com.box.android.browse.cpl.itemsList.ItemsListReducer$Action> r6 = r5.$store
            com.box.android.browse.cpl.itemsList.ItemsListReducer$Action$RefreshFromRemote r0 = com.box.android.browse.cpl.itemsList.ItemsListReducer.Action.RefreshFromRemote.INSTANCE
            r6.send(r0)
        L43:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            goto L56
        L46:
            kotlin.jvm.functions.Function4<java.lang.String, java.lang.String, androidx.compose.material3.SnackbarDuration, kotlin.coroutines.Continuation<? super androidx.compose.material3.SnackbarResult>, java.lang.Object> r6 = r5.$onShowSnackbar
            java.lang.String r1 = r5.$message
            androidx.compose.material3.SnackbarDuration r3 = androidx.compose.material3.SnackbarDuration.Short
            r5.label = r2
            r2 = 0
            java.lang.Object r6 = r6.invoke(r1, r2, r3, r5)
            if (r6 != r0) goto L56
        L55:
            return r0
        L56:
            com.box.android.cpl.Store<com.box.android.browse.cpl.itemsList.ItemsListReducer$State, com.box.android.browse.cpl.itemsList.ItemsListReducer$Action> r5 = r5.$store
            com.box.android.browse.cpl.itemsList.ItemsListReducer$Action$HandledError r6 = com.box.android.browse.cpl.itemsList.ItemsListReducer.Action.HandledError.INSTANCE
            r5.send(r6)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.browse.compose.FolderListingScreenKt$ShowSnackbarEffect$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
