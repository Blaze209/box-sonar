package com.box.android.search.presentation.ui;

import android.app.Activity;
import android.content.Intent;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import com.box.android.boxai.AiCenterActivity;
import com.box.brownfieldApi.featuresNavigator.HostSurface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AiCenterLauncher.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.search.presentation.ui.AiCenterLauncherKt$AiCenterLauncher$1$1", f = "AiCenterLauncher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class AiCenterLauncherKt$AiCenterLauncher$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $initialPrompt;
    final /* synthetic */ ManagedActivityResultLauncher<Intent, ActivityResult> $launcher;
    final /* synthetic */ String $sessionId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AiCenterLauncherKt$AiCenterLauncher$1$1(ManagedActivityResultLauncher<Intent, ActivityResult> managedActivityResultLauncher, Activity activity, String str, String str2, Continuation<? super AiCenterLauncherKt$AiCenterLauncher$1$1> continuation) {
        super(2, continuation);
        this.$launcher = managedActivityResultLauncher;
        this.$activity = activity;
        this.$sessionId = str;
        this.$initialPrompt = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AiCenterLauncherKt$AiCenterLauncher$1$1(this.$launcher, this.$activity, this.$sessionId, this.$initialPrompt, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AiCenterLauncherKt$AiCenterLauncher$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$launcher.launch(AiCenterActivity.Companion.createIntent$default(AiCenterActivity.INSTANCE, this.$activity, HostSurface.FILES, this.$sessionId, null, null, this.$initialPrompt, 24, null));
        return Unit.INSTANCE;
    }
}
