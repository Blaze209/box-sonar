package com.box.android.contentpicker.uploadcontent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.compose.ManagedActivityResultLauncher;
import com.box.android.base.presentation.multiselect.SelectionItemInfo;
import com.box.android.contentpicker.ContentPickerActivityKt;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CaptureMediaHandler.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.contentpicker.uploadcontent.CaptureMediaHandlerKt$CaptureMediaHandler$1$3$1", f = "CaptureMediaHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CaptureMediaHandlerKt$CaptureMediaHandler$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Function0<Unit> $onCancel;
    final /* synthetic */ Store<CaptureMediaHandlerReducer.State, CaptureMediaHandlerReducer.Action> $store;
    final /* synthetic */ ManagedActivityResultLauncher<Uri, Boolean> $takePictureLauncher;
    final /* synthetic */ CaptureMediaHandlerReducer.ViewEffect $viewEffect;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CaptureMediaHandlerKt$CaptureMediaHandler$1$3$1(CaptureMediaHandlerReducer.ViewEffect viewEffect, ManagedActivityResultLauncher<Uri, Boolean> managedActivityResultLauncher, Store<CaptureMediaHandlerReducer.State, CaptureMediaHandlerReducer.Action> store, Activity activity, Function0<Unit> function0, Continuation<? super CaptureMediaHandlerKt$CaptureMediaHandler$1$3$1> continuation) {
        super(2, continuation);
        this.$viewEffect = viewEffect;
        this.$takePictureLauncher = managedActivityResultLauncher;
        this.$store = store;
        this.$activity = activity;
        this.$onCancel = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CaptureMediaHandlerKt$CaptureMediaHandler$1$3$1(this.$viewEffect, this.$takePictureLauncher, this.$store, this.$activity, this.$onCancel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CaptureMediaHandlerKt$CaptureMediaHandler$1$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CaptureMediaHandlerReducer.ViewEffect viewEffect = this.$viewEffect;
        if (!Intrinsics.areEqual(viewEffect, CaptureMediaHandlerReducer.ViewEffect.None.INSTANCE)) {
            if (viewEffect instanceof CaptureMediaHandlerReducer.ViewEffect.LaunchCamera) {
                this.$takePictureLauncher.launch(((CaptureMediaHandlerReducer.ViewEffect.LaunchCamera) this.$viewEffect).getUri());
                this.$store.send(CaptureMediaHandlerReducer.Action.OnViewEffectProcessed.INSTANCE);
            } else if (viewEffect instanceof CaptureMediaHandlerReducer.ViewEffect.PhotoCaptured) {
                Activity activity = this.$activity;
                Intent intentBuildContentPickerResultIntent$default = activity != null ? ContentPickerActivityKt.buildContentPickerResultIntent$default(activity, null, CollectionsKt.listOf(new SelectionItemInfo(((CaptureMediaHandlerReducer.ViewEffect.PhotoCaptured) this.$viewEffect).getItemId().toString(), ((CaptureMediaHandlerReducer.ViewEffect.PhotoCaptured) this.$viewEffect).getName(), "file", null, null, "capture_media", 24, null)), 1, null) : null;
                Activity activity2 = this.$activity;
                if (activity2 != null) {
                    activity2.setResult(-1, intentBuildContentPickerResultIntent$default);
                }
                Activity activity3 = this.$activity;
                if (activity3 != null) {
                    activity3.finish();
                }
                this.$store.send(CaptureMediaHandlerReducer.Action.OnViewEffectProcessed.INSTANCE);
            } else {
                if (!Intrinsics.areEqual(viewEffect, CaptureMediaHandlerReducer.ViewEffect.PhotoNotCaptured.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                this.$onCancel.invoke();
                this.$store.send(CaptureMediaHandlerReducer.Action.OnViewEffectProcessed.INSTANCE);
            }
        }
        return Unit.INSTANCE;
    }
}
