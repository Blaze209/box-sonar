package com.box.android.updates;

import androidx.appcompat.app.AppCompatActivity;
import com.box.android.domain.utils.result.Result;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateOptions;
import com.google.android.play.core.ktx.AppUpdateManagerKtxKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.tasks.TasksKt;

/* JADX INFO: compiled from: AppUpdateManagerExtensions.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0001*\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001a<\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0001*\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"getAppUpdateInfoAsResult", "Lcom/box/android/domain/utils/result/Result;", "Lcom/google/android/play/core/appupdate/AppUpdateInfo;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "(Lcom/google/android/play/core/appupdate/AppUpdateManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startUpdateFlowAsResult", "Lcom/box/android/updates/UpdateFlowResult;", "updateInfo", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "updateType", "", "(Lcom/google/android/play/core/appupdate/AppUpdateManager;Lcom/google/android/play/core/appupdate/AppUpdateInfo;Landroidx/appcompat/app/AppCompatActivity;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app-updates_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AppUpdateManagerExtensionsKt {

    /* JADX INFO: renamed from: com.box.android.updates.AppUpdateManagerExtensionsKt$getAppUpdateInfoAsResult$1, reason: invalid class name */
    /* JADX INFO: compiled from: AppUpdateManagerExtensions.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.updates.AppUpdateManagerExtensionsKt", f = "AppUpdateManagerExtensions.kt", i = {0}, l = {24}, m = "getAppUpdateInfoAsResult", n = {"$this$getAppUpdateInfoAsResult"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppUpdateManagerExtensionsKt.getAppUpdateInfoAsResult(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.updates.AppUpdateManagerExtensionsKt$startUpdateFlowAsResult$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AppUpdateManagerExtensions.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.updates.AppUpdateManagerExtensionsKt", f = "AppUpdateManagerExtensions.kt", i = {0, 0, 0, 0, 0}, l = {41}, m = "startUpdateFlowAsResult", n = {"$this$startUpdateFlowAsResult", "updateInfo", "activity", "updateOptions", "updateType"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
    static final class C17241 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C17241(Continuation<? super C17241> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppUpdateManagerExtensionsKt.startUpdateFlowAsResult(null, null, null, 0, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object getAppUpdateInfoAsResult(AppUpdateManager appUpdateManager, Continuation<? super Result<? extends AppUpdateInfo, ? extends Exception>> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objRequestAppUpdateInfo = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objRequestAppUpdateInfo);
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(appUpdateManager);
                anonymousClass1.label = 1;
                objRequestAppUpdateInfo = AppUpdateManagerKtxKt.requestAppUpdateInfo(appUpdateManager, anonymousClass1);
                if (objRequestAppUpdateInfo == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objRequestAppUpdateInfo);
            }
            return com.box.android.domain.utils.result.ResultKt.toResultSuccess(objRequestAppUpdateInfo);
        } catch (Exception e) {
            return new Result.Error(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object startUpdateFlowAsResult(AppUpdateManager appUpdateManager, AppUpdateInfo appUpdateInfo, AppCompatActivity appCompatActivity, int i, Continuation<? super Result<? extends UpdateFlowResult, ? extends Exception>> continuation) {
        C17241 c17241;
        UpdateFlowResult updateFlowResult;
        if (continuation instanceof C17241) {
            c17241 = (C17241) continuation;
            if ((c17241.label & Integer.MIN_VALUE) != 0) {
                c17241.label -= Integer.MIN_VALUE;
            } else {
                c17241 = new C17241(continuation);
            }
        } else {
            c17241 = new C17241(continuation);
        }
        Object objAwait = c17241.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c17241.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objAwait);
                AppUpdateOptions appUpdateOptionsBuild = AppUpdateOptions.newBuilder(i).build();
                Intrinsics.checkNotNullExpressionValue(appUpdateOptionsBuild, "build(...)");
                Task<Integer> taskStartUpdateFlow = appUpdateManager.startUpdateFlow(appUpdateInfo, appCompatActivity, appUpdateOptionsBuild);
                Intrinsics.checkNotNullExpressionValue(taskStartUpdateFlow, "startUpdateFlow(...)");
                c17241.L$0 = SpillingKt.nullOutSpilledVariable(appUpdateManager);
                c17241.L$1 = SpillingKt.nullOutSpilledVariable(appUpdateInfo);
                c17241.L$2 = SpillingKt.nullOutSpilledVariable(appCompatActivity);
                c17241.L$3 = SpillingKt.nullOutSpilledVariable(appUpdateOptionsBuild);
                c17241.I$0 = i;
                c17241.label = 1;
                objAwait = TasksKt.await(taskStartUpdateFlow, c17241);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = c17241.I$0;
                ResultKt.throwOnFailure(objAwait);
            }
            Integer num = (Integer) objAwait;
            if (num != null && num.intValue() == -1) {
                updateFlowResult = UpdateFlowResult.ACCEPTED;
            } else {
                updateFlowResult = (num != null && num.intValue() == 0) ? UpdateFlowResult.REJECTED : UpdateFlowResult.SHOWN_BUT_FAILED;
            }
            return com.box.android.domain.utils.result.ResultKt.toResultSuccess(updateFlowResult);
        } catch (Exception e) {
            return new Result.Error(e);
        }
    }
}
