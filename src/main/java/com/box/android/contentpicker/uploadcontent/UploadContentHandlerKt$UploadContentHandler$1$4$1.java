package com.box.android.contentpicker.uploadcontent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import com.box.android.contentpicker.ContentPickerActivityKt;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: UploadContentHandler.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.contentpicker.uploadcontent.UploadContentHandlerKt$UploadContentHandler$1$4$1", f = "UploadContentHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class UploadContentHandlerKt$UploadContentHandler$1$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ ManagedActivityResultLauncher<Intent, ActivityResult> $filePickerLauncher;
    final /* synthetic */ Function0<Unit> $onCancel;
    final /* synthetic */ ManagedActivityResultLauncher<Intent, ActivityResult> $storageAccessLauncher;
    final /* synthetic */ Store<UploadContentHandlerReducer.State, UploadContentHandlerReducer.Action> $store;
    final /* synthetic */ UploadContentHandlerReducer.ViewEffect $viewEffect;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UploadContentHandlerKt$UploadContentHandler$1$4$1(UploadContentHandlerReducer.ViewEffect viewEffect, ManagedActivityResultLauncher<Intent, ActivityResult> managedActivityResultLauncher, Store<UploadContentHandlerReducer.State, UploadContentHandlerReducer.Action> store, ManagedActivityResultLauncher<Intent, ActivityResult> managedActivityResultLauncher2, Activity activity, Function0<Unit> function0, Continuation<? super UploadContentHandlerKt$UploadContentHandler$1$4$1> continuation) {
        super(2, continuation);
        this.$viewEffect = viewEffect;
        this.$filePickerLauncher = managedActivityResultLauncher;
        this.$store = store;
        this.$storageAccessLauncher = managedActivityResultLauncher2;
        this.$activity = activity;
        this.$onCancel = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UploadContentHandlerKt$UploadContentHandler$1$4$1(this.$viewEffect, this.$filePickerLauncher, this.$store, this.$storageAccessLauncher, this.$activity, this.$onCancel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UploadContentHandlerKt$UploadContentHandler$1$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        UploadContentHandlerReducer.ViewEffect viewEffect = this.$viewEffect;
        if (!Intrinsics.areEqual(viewEffect, UploadContentHandlerReducer.ViewEffect.None.INSTANCE)) {
            if (Intrinsics.areEqual(viewEffect, UploadContentHandlerReducer.ViewEffect.LaunchFilePicker.INSTANCE)) {
                Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                intent.setType("*/*");
                this.$filePickerLauncher.launch(intent);
                this.$store.send(UploadContentHandlerReducer.Action.OnViewEffectProcessed.INSTANCE);
            } else {
                if (Intrinsics.areEqual(viewEffect, UploadContentHandlerReducer.ViewEffect.RequestStorageAccess.INSTANCE)) {
                    Intent intent2 = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
                    Activity activity = this.$activity;
                    intent2.setData(Uri.fromParts("package", activity != null ? activity.getPackageName() : null, null));
                    this.$storageAccessLauncher.launch(intent2);
                    this.$store.send(UploadContentHandlerReducer.Action.OnViewEffectProcessed.INSTANCE);
                } else if (viewEffect instanceof UploadContentHandlerReducer.ViewEffect.FilesSelected) {
                    Activity activity2 = this.$activity;
                    Intent intentBuildContentPickerResultIntent$default = activity2 != null ? ContentPickerActivityKt.buildContentPickerResultIntent$default(activity2, null, ((UploadContentHandlerReducer.ViewEffect.FilesSelected) this.$viewEffect).getItems(), 1, null) : null;
                    Activity activity3 = this.$activity;
                    if (activity3 != null) {
                        activity3.setResult(-1, intentBuildContentPickerResultIntent$default);
                    }
                    Activity activity4 = this.$activity;
                    if (activity4 != null) {
                        activity4.finish();
                    }
                    this.$store.send(UploadContentHandlerReducer.Action.OnViewEffectProcessed.INSTANCE);
                } else {
                    if (!Intrinsics.areEqual(viewEffect, UploadContentHandlerReducer.ViewEffect.Cancelled.INSTANCE)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    this.$onCancel.invoke();
                    this.$store.send(UploadContentHandlerReducer.Action.OnViewEffectProcessed.INSTANCE);
                }
            }
        }
        return Unit.INSTANCE;
    }
}
