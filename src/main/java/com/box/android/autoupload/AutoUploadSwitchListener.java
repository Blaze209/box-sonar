package com.box.android.autoupload;

import android.content.DialogInterface;
import android.content.Intent;
import android.widget.CompoundButton;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.box.android.R;
import com.box.android.activities.AutoContentUploadPaywallActivity;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.OSPermissionUtils;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IJobService;
import com.box.android.domain.utils.result.Result;
import com.box.android.fragments.AutoUploadUtils;
import com.box.android.utilities.notificationmanager.BoxNotificationHelper;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: AutoUploadSwitchListener.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0018BI\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/box/android/autoupload/AutoUploadSwitchListener;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "activity", "Landroidx/fragment/app/FragmentActivity;", "onAutoUploadStatusChanged", "Lkotlin/Function1;", "", "", "resetSwitchState", "Lkotlin/Function0;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "jobService", "Lcom/box/android/domain/services/IJobService;", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/domain/services/IJobService;)V", "onCheckedChanged", "buttonView", "Landroid/widget/CompoundButton;", "isChecked", "handleEnableAutoUpload", "handleDisableAutoUpload", "checkAutoUploadJobsAndShowDialog", "showDisableAutoUploadConfirmation", "Factory", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AutoUploadSwitchListener implements CompoundButton.OnCheckedChangeListener {
    public static final int $stable = 8;
    private final FragmentActivity activity;
    private final IJobService jobService;
    private final Function1<Boolean, Unit> onAutoUploadStatusChanged;
    private final Function0<Unit> resetSwitchState;
    private final IUserContextManager userContextManager;

    /* JADX INFO: compiled from: AutoUploadSwitchListener.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/box/android/autoupload/AutoUploadSwitchListener$Factory;", "", "createListener", "Lcom/box/android/autoupload/AutoUploadSwitchListener;", "activity", "Landroidx/fragment/app/FragmentActivity;", "onAutoUploadStatusChanged", "Lkotlin/Function1;", "", "", "resetSwitchState", "Lkotlin/Function0;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        AutoUploadSwitchListener createListener(FragmentActivity activity, Function1<? super Boolean, Unit> onAutoUploadStatusChanged, Function0<Unit> resetSwitchState);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @AssistedInject
    public AutoUploadSwitchListener(@Assisted FragmentActivity activity, @Assisted Function1<? super Boolean, Unit> onAutoUploadStatusChanged, @Assisted Function0<Unit> resetSwitchState, IUserContextManager userContextManager, IJobService jobService) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(onAutoUploadStatusChanged, "onAutoUploadStatusChanged");
        Intrinsics.checkNotNullParameter(resetSwitchState, "resetSwitchState");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        this.activity = activity;
        this.onAutoUploadStatusChanged = onAutoUploadStatusChanged;
        this.resetSwitchState = resetSwitchState;
        this.userContextManager = userContextManager;
        this.jobService = jobService;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Intrinsics.checkNotNullParameter(buttonView, "buttonView");
        if (isChecked) {
            handleEnableAutoUpload();
        } else {
            handleDisableAutoUpload();
        }
    }

    private final void handleEnableAutoUpload() {
        if (!AutoUploadUtils.INSTANCE.isAutoContentUploadEnabledByAdmin(this.userContextManager.getUserInfo(), this.userContextManager)) {
            this.resetSwitchState.invoke();
            BoxNotificationHelper.displayDialog(R.string.Feature_disabled, R.string.This_feature_has_been_disabled_by_your_or_your_administrator);
            return;
        }
        if (!AutoUploadUtils.INSTANCE.isAutoContentUploadFeatureAvailable(this.userContextManager)) {
            this.resetSwitchState.invoke();
            this.activity.startActivity(new Intent(this.activity, (Class<?>) AutoContentUploadPaywallActivity.class));
        } else if (!OSPermissionUtils.INSTANCE.hasStoragePermission(true)) {
            this.resetSwitchState.invoke();
            OSPermissionUtils.INSTANCE.requestStoragePermission(this.activity, 204);
        } else {
            if (AutoUploadUtils.isSyncEnabled(this.userContextManager)) {
                return;
            }
            this.onAutoUploadStatusChanged.invoke(true);
        }
    }

    private final void handleDisableAutoUpload() {
        if (AutoUploadUtils.isSyncEnabled(this.userContextManager)) {
            checkAutoUploadJobsAndShowDialog();
        }
    }

    /* JADX INFO: renamed from: com.box.android.autoupload.AutoUploadSwitchListener$checkAutoUploadJobsAndShowDialog$1, reason: invalid class name */
    /* JADX INFO: compiled from: AutoUploadSwitchListener.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.autoupload.AutoUploadSwitchListener$checkAutoUploadJobsAndShowDialog$1", f = "AutoUploadSwitchListener.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AutoUploadSwitchListener.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = AutoUploadSwitchListener.this.jobService.getEnqueuedAutoUploadJobs(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Result result = (Result) obj;
            AutoUploadSwitchListener autoUploadSwitchListener = AutoUploadSwitchListener.this;
            boolean z = result instanceof Result.Success;
            if (z) {
                if (((List) ((Result.Success) result).getValue()).isEmpty()) {
                    autoUploadSwitchListener.onAutoUploadStatusChanged.invoke(Boxing.boxBoolean(false));
                } else {
                    autoUploadSwitchListener.showDisableAutoUploadConfirmation();
                }
            } else if (!(result instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            AutoUploadSwitchListener autoUploadSwitchListener2 = AutoUploadSwitchListener.this;
            if (!z) {
                if (!(result instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                autoUploadSwitchListener2.showDisableAutoUploadConfirmation();
            }
            return Unit.INSTANCE;
        }
    }

    private final void checkAutoUploadJobsAndShowDialog() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.activity), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDisableAutoUploadConfirmation() {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this.activity);
        materialAlertDialogBuilder.setTitle(R.string.disable_auto_upload_title);
        materialAlertDialogBuilder.setMessage(R.string.disable_auto_upload_message);
        materialAlertDialogBuilder.setPositiveButton((CharSequence) CommonBoxUtil.LS(R.string.LO_continue), new DialogInterface.OnClickListener() { // from class: com.box.android.autoupload.AutoUploadSwitchListener$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AutoUploadSwitchListener.showDisableAutoUploadConfirmation$lambda$0(this.f$0, dialogInterface, i);
            }
        });
        materialAlertDialogBuilder.setNegativeButton((CharSequence) CommonBoxUtil.LS(R.string.do_no_cancel), new DialogInterface.OnClickListener() { // from class: com.box.android.autoupload.AutoUploadSwitchListener$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AutoUploadSwitchListener.showDisableAutoUploadConfirmation$lambda$1(this.f$0, dialogInterface, i);
            }
        });
        materialAlertDialogBuilder.setCancelable(false);
        materialAlertDialogBuilder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDisableAutoUploadConfirmation$lambda$0(AutoUploadSwitchListener autoUploadSwitchListener, DialogInterface dialogInterface, int i) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AutoUploadSwitchListener$showDisableAutoUploadConfirmation$1$1(autoUploadSwitchListener, null), 3, null);
        autoUploadSwitchListener.onAutoUploadStatusChanged.invoke(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDisableAutoUploadConfirmation$lambda$1(AutoUploadSwitchListener autoUploadSwitchListener, DialogInterface dialogInterface, int i) {
        autoUploadSwitchListener.resetSwitchState.invoke();
    }
}
