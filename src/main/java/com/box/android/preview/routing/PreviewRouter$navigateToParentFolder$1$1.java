package com.box.android.preview.routing;

import android.content.Intent;
import androidx.activity.ComponentActivity;
import androidx.core.app.TaskStackBuilder;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PreviewRouter.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.routing.PreviewRouter$navigateToParentFolder$1$1", f = "PreviewRouter.kt", i = {}, l = {233}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class PreviewRouter$navigateToParentFolder$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ComponentActivity $activity;
    final /* synthetic */ FolderModel $parent;
    int label;
    final /* synthetic */ PreviewRouter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PreviewRouter$navigateToParentFolder$1$1(PreviewRouter previewRouter, FolderModel folderModel, ComponentActivity componentActivity, Continuation<? super PreviewRouter$navigateToParentFolder$1$1> continuation) {
        super(2, continuation);
        this.this$0 = previewRouter;
        this.$parent = folderModel;
        this.$activity = componentActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PreviewRouter$navigateToParentFolder$1$1(this.this$0, this.$parent, this.$activity, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PreviewRouter$navigateToParentFolder$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.idMappingService.getRemoteId(this.$parent.getItemId(), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ItemId.Remote remote = (ItemId.Remote) obj;
        if (remote == null) {
            this.this$0.navigateToAllFiles(this.$activity);
        } else {
            Intent intentNavigationActivityIntent = this.this$0.intentServices.navigationActivityIntent(this.$activity, this.this$0.featureFlips.getMainScreenRedesign().getEnabled(), IntentServices.NavigationIntentTarget.ALL_FILES);
            intentNavigationActivityIntent.setFlags(268468224);
            TaskStackBuilder.create(this.$activity).addNextIntent(intentNavigationActivityIntent).addNextIntent(this.this$0.intentServices.mainPhoneActivityIntent(this.$activity, remote, this.$parent.getName(), 335544320)).startActivities();
        }
        return Unit.INSTANCE;
    }
}
