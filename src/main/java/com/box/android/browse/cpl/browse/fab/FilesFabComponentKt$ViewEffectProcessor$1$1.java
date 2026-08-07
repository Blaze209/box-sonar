package com.box.android.browse.cpl.browse.fab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarHostState;
import com.box.android.browse.R;
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

/* JADX INFO: compiled from: FilesFabComponent.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$ViewEffectProcessor$1$1", f = "FilesFabComponent.kt", i = {}, l = {352}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FilesFabComponentKt$ViewEffectProcessor$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Context $context;
    final /* synthetic */ FilesFabReducer.ViewEffect $effect;
    final /* synthetic */ ActivityResultLauncher<Intent> $filePickerLauncher;
    final /* synthetic */ ActivityResultLauncher<Intent> $folderPickerLauncher;
    final /* synthetic */ Function0<Unit> $onProcessed;
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    final /* synthetic */ String $storageAccessGrantedMessage;
    final /* synthetic */ ActivityResultLauncher<Intent> $storageAccessRequestLauncher;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FilesFabComponentKt$ViewEffectProcessor$1$1(FilesFabReducer.ViewEffect viewEffect, ActivityResultLauncher<Intent> activityResultLauncher, Function0<Unit> function0, ActivityResultLauncher<Intent> activityResultLauncher2, Context context, ActivityResultLauncher<Intent> activityResultLauncher3, SnackbarHostState snackbarHostState, String str, Activity activity, Continuation<? super FilesFabComponentKt$ViewEffectProcessor$1$1> continuation) {
        super(2, continuation);
        this.$effect = viewEffect;
        this.$filePickerLauncher = activityResultLauncher;
        this.$onProcessed = function0;
        this.$folderPickerLauncher = activityResultLauncher2;
        this.$context = context;
        this.$storageAccessRequestLauncher = activityResultLauncher3;
        this.$snackbarHostState = snackbarHostState;
        this.$storageAccessGrantedMessage = str;
        this.$activity = activity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FilesFabComponentKt$ViewEffectProcessor$1$1(this.$effect, this.$filePickerLauncher, this.$onProcessed, this.$folderPickerLauncher, this.$context, this.$storageAccessRequestLauncher, this.$snackbarHostState, this.$storageAccessGrantedMessage, this.$activity, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilesFabComponentKt$ViewEffectProcessor$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FilesFabReducer.ViewEffect viewEffect = this.$effect;
            if (Intrinsics.areEqual(viewEffect, FilesFabReducer.ViewEffect.LaunchFilePicker.INSTANCE)) {
                Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                intent.setType("*/*");
                intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"*/*"});
                this.$filePickerLauncher.launch(intent);
                this.$onProcessed.invoke();
            } else if (Intrinsics.areEqual(viewEffect, FilesFabReducer.ViewEffect.LaunchFolderPicker.INSTANCE)) {
                this.$folderPickerLauncher.launch(new Intent("android.intent.action.OPEN_DOCUMENT_TREE"));
                this.$onProcessed.invoke();
            } else if (Intrinsics.areEqual(viewEffect, FilesFabReducer.ViewEffect.NoConnectivityErrorMessage.INSTANCE)) {
                Toast.makeText(this.$context, R.string.err_conn1, 0).show();
                this.$onProcessed.invoke();
            } else if (Intrinsics.areEqual(viewEffect, FilesFabReducer.ViewEffect.RequestStorageAccess.INSTANCE)) {
                Intent intent2 = new Intent();
                Activity activity = this.$activity;
                intent2.setAction("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
                intent2.setData(Uri.fromParts("package", activity.getPackageName(), null));
                this.$storageAccessRequestLauncher.launch(intent2);
                this.$onProcessed.invoke();
            } else if (Intrinsics.areEqual(viewEffect, FilesFabReducer.ViewEffect.StorageAccessGrantedMessage.INSTANCE)) {
                this.label = 1;
                if (SnackbarHostState.showSnackbar$default(this.$snackbarHostState, this.$storageAccessGrantedMessage, null, false, SnackbarDuration.Short, this, 6, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (!Intrinsics.areEqual(viewEffect, FilesFabReducer.ViewEffect.None.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$onProcessed.invoke();
        return Unit.INSTANCE;
    }
}
