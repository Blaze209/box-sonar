package com.box.android.updates.proposal;

import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.box.android.common.utilities.Clock;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.configuration.IBoxAccountSettings;
import com.box.android.domain.utils.result.Result;
import com.box.android.updates.AppUpdateManagerExtensionsKt;
import com.box.android.updates.UpdateFlowResult;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: AppUpdateProposalManager.kt */
/* JADX INFO: loaded from: classes13.dex */
@Singleton
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 /2\u00020\u0001:\u0002./B;\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u0015H\u0002J\u001e\u0010\"\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020$H\u0082@¢\u0006\u0002\u0010%J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$H\u0002J\u001e\u0010'\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020$H\u0082@¢\u0006\u0002\u0010%J\n\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,H\u0002J\u0006\u0010-\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00060"}, d2 = {"Lcom/box/android/updates/proposal/AppUpdateProposalManager;", "", "appUpdateManager", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "sharedPreferences", "Landroid/content/SharedPreferences;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "clock", "Lcom/box/android/common/utilities/Clock;", "appUpdateProposalAnalytics", "Lcom/box/android/updates/proposal/AppUpdateProposalAnalytics;", "accountSettings", "Lcom/box/android/domain/configuration/IBoxAccountSettings;", "<init>", "(Lcom/google/android/play/core/appupdate/AppUpdateManager;Landroid/content/SharedPreferences;Lcom/box/android/domain/configuration/FeatureFlips;Lcom/box/android/common/utilities/Clock;Lcom/box/android/updates/proposal/AppUpdateProposalAnalytics;Lcom/box/android/domain/configuration/IBoxAccountSettings;)V", "_updateDownloadingEventFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "_updateDownloadedStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "updateDownloadingEventFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getUpdateDownloadingEventFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "updateDownloadedStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getUpdateDownloadedStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "handleUpdateProposal", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "shouldCheckForUpdates", "handleUpdateInfo", "updateInfo", "Lcom/google/android/play/core/appupdate/AppUpdateInfo;", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/google/android/play/core/appupdate/AppUpdateInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldShowUpdatePrompt", "startFlexibleUpdate", "getLastPromptInfo", "Lcom/box/android/updates/proposal/AppUpdateProposalManager$LastPromptInfo;", "saveLastPromptInfo", "versionCode", "", "completeUpdate", "LastPromptInfo", "Companion", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AppUpdateProposalManager {
    private static final int DAYS_OF_WAITING_BETWEEN_PROMPTS = 14;
    private static final String LAST_PROMPT_TIME_KEY = "last_prompt_time";
    private static final String LAST_PROMPT_VERSION_CODE_KEY = "last_prompt_version";
    private static final String LOG_TAG = "AppUpdateProposalManager";
    private static final int MINIMUM_UPDATE_STALENESS_DAYS = 1;
    private final MutableStateFlow<Boolean> _updateDownloadedStateFlow;
    private final MutableSharedFlow<Unit> _updateDownloadingEventFlow;
    private final IBoxAccountSettings accountSettings;
    private final AppUpdateManager appUpdateManager;
    private final AppUpdateProposalAnalytics appUpdateProposalAnalytics;
    private final Clock clock;
    private final FeatureFlips featureFlips;
    private final SharedPreferences sharedPreferences;
    private final StateFlow<Boolean> updateDownloadedStateFlow;
    private final SharedFlow<Unit> updateDownloadingEventFlow;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.box.android.updates.proposal.AppUpdateProposalManager$startFlexibleUpdate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AppUpdateProposalManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.updates.proposal.AppUpdateProposalManager", f = "AppUpdateProposalManager.kt", i = {0, 0}, l = {119}, m = "startFlexibleUpdate", n = {"activity", "updateInfo"}, s = {"L$0", "L$1"}, v = 1)
    static final class C17251 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C17251(Continuation<? super C17251> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppUpdateProposalManager.this.startFlexibleUpdate(null, null, this);
        }
    }

    @Inject
    public AppUpdateProposalManager(AppUpdateManager appUpdateManager, @Named("app_updates_shared_preferences") SharedPreferences sharedPreferences, FeatureFlips featureFlips, Clock clock, AppUpdateProposalAnalytics appUpdateProposalAnalytics, IBoxAccountSettings accountSettings) {
        Intrinsics.checkNotNullParameter(appUpdateManager, "appUpdateManager");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(appUpdateProposalAnalytics, "appUpdateProposalAnalytics");
        Intrinsics.checkNotNullParameter(accountSettings, "accountSettings");
        this.appUpdateManager = appUpdateManager;
        this.sharedPreferences = sharedPreferences;
        this.featureFlips = featureFlips;
        this.clock = clock;
        this.appUpdateProposalAnalytics = appUpdateProposalAnalytics;
        this.accountSettings = accountSettings;
        MutableSharedFlow<Unit> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 5, null);
        this._updateDownloadingEventFlow = mutableSharedFlowMutableSharedFlow$default;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(false);
        this._updateDownloadedStateFlow = MutableStateFlow;
        this.updateDownloadingEventFlow = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
        this.updateDownloadedStateFlow = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final SharedFlow<Unit> getUpdateDownloadingEventFlow() {
        return this.updateDownloadingEventFlow;
    }

    public final StateFlow<Boolean> getUpdateDownloadedStateFlow() {
        return this.updateDownloadedStateFlow;
    }

    public final void handleUpdateProposal(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (shouldCheckForUpdates()) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(activity), null, null, new AnonymousClass1(activity, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.box.android.updates.proposal.AppUpdateProposalManager$handleUpdateProposal$1, reason: invalid class name */
    /* JADX INFO: compiled from: AppUpdateProposalManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.updates.proposal.AppUpdateProposalManager$handleUpdateProposal$1", f = "AppUpdateProposalManager.kt", i = {1}, l = {79, 82}, m = "invokeSuspend", n = {"updateInfo"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatActivity $activity;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AppCompatActivity appCompatActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$activity = appCompatActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AppUpdateProposalManager.this.new AnonymousClass1(this.$activity, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0086, code lost:
        
            if (r6.this$0.handleUpdateInfo(r6.$activity, r7, r6) == r0) goto L25;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                java.lang.String r2 = "AppUpdateProposalManager"
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L24
                if (r1 == r4) goto L20
                if (r1 != r3) goto L18
                java.lang.Object r6 = r6.L$0
                com.google.android.play.core.appupdate.AppUpdateInfo r6 = (com.google.android.play.core.appupdate.AppUpdateInfo) r6
                kotlin.ResultKt.throwOnFailure(r7)
                goto L89
            L18:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L20:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L3e
            L24:
                kotlin.ResultKt.throwOnFailure(r7)
                java.lang.String r7 = "Checking for app updates"
                com.box.androidsdk.content.utils.BoxLogUtils.d(r2, r7)
                com.box.android.updates.proposal.AppUpdateProposalManager r7 = com.box.android.updates.proposal.AppUpdateProposalManager.this
                com.google.android.play.core.appupdate.AppUpdateManager r7 = com.box.android.updates.proposal.AppUpdateProposalManager.access$getAppUpdateManager$p(r7)
                r1 = r6
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r6.label = r4
                java.lang.Object r7 = com.box.android.updates.AppUpdateManagerExtensionsKt.getAppUpdateInfoAsResult(r7, r1)
                if (r7 != r0) goto L3e
                goto L88
            L3e:
                com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
                boolean r1 = r7 instanceof com.box.android.domain.utils.result.Result.Success
                if (r1 == 0) goto L45
                goto L68
            L45:
                boolean r1 = r7 instanceof com.box.android.domain.utils.result.Result.Error
                if (r1 == 0) goto L8c
                r1 = r7
                com.box.android.domain.utils.result.Result$Error r1 = (com.box.android.domain.utils.result.Result.Error) r1
                java.lang.Object r1 = r1.getValue()
                java.lang.Exception r1 = (java.lang.Exception) r1
                java.lang.String r1 = r1.getMessage()
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                java.lang.String r5 = "Could not check updates: "
                r4.<init>(r5)
                java.lang.StringBuilder r1 = r4.append(r1)
                java.lang.String r1 = r1.toString()
                com.box.androidsdk.content.utils.BoxLogUtils.w(r2, r1)
            L68:
                java.lang.Object r7 = com.box.android.domain.utils.result.ResultKt.getOrNull(r7)
                com.google.android.play.core.appupdate.AppUpdateInfo r7 = (com.google.android.play.core.appupdate.AppUpdateInfo) r7
                if (r7 != 0) goto L73
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            L73:
                com.box.android.updates.proposal.AppUpdateProposalManager r1 = com.box.android.updates.proposal.AppUpdateProposalManager.this
                androidx.appcompat.app.AppCompatActivity r2 = r6.$activity
                r4 = r6
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                r6.L$0 = r5
                r6.label = r3
                java.lang.Object r6 = com.box.android.updates.proposal.AppUpdateProposalManager.access$handleUpdateInfo(r1, r2, r7, r4)
                if (r6 != r0) goto L89
            L88:
                return r0
            L89:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            L8c:
                kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
                r6.<init>()
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.updates.proposal.AppUpdateProposalManager.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final boolean shouldCheckForUpdates() {
        return this.featureFlips.getInAppUpdates().getEnabled() && !this.accountSettings.isEMMMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleUpdateInfo(AppCompatActivity appCompatActivity, AppUpdateInfo appUpdateInfo, Continuation<? super Unit> continuation) {
        if (appUpdateInfo.updateAvailability() == 2 && shouldShowUpdatePrompt(appUpdateInfo)) {
            Object objStartFlexibleUpdate = startFlexibleUpdate(appCompatActivity, appUpdateInfo, continuation);
            return objStartFlexibleUpdate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objStartFlexibleUpdate : Unit.INSTANCE;
        }
        if (appUpdateInfo.installStatus() == 11) {
            this.appUpdateManager.completeUpdate();
        }
        return Unit.INSTANCE;
    }

    private final boolean shouldShowUpdatePrompt(AppUpdateInfo updateInfo) {
        BoxLogUtils.v(LOG_TAG, "Update found: versionCode=" + updateInfo.availableVersionCode() + ", staleness=" + updateInfo.clientVersionStalenessDays());
        if (!updateInfo.isUpdateTypeAllowed(0)) {
            return false;
        }
        Integer numClientVersionStalenessDays = updateInfo.clientVersionStalenessDays();
        if (numClientVersionStalenessDays != null && numClientVersionStalenessDays.intValue() < 1) {
            return false;
        }
        LastPromptInfo lastPromptInfo = getLastPromptInfo();
        if (lastPromptInfo != null) {
            boolean z = updateInfo.availableVersionCode() > lastPromptInfo.getVersionCode();
            boolean z2 = lastPromptInfo.getFullDaysAgo() >= 14;
            if (!z && !z2) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object startFlexibleUpdate(AppCompatActivity appCompatActivity, AppUpdateInfo appUpdateInfo, Continuation<? super Unit> continuation) {
        C17251 c17251;
        if (continuation instanceof C17251) {
            c17251 = (C17251) continuation;
            if ((c17251.label & Integer.MIN_VALUE) != 0) {
                c17251.label -= Integer.MIN_VALUE;
            } else {
                c17251 = new C17251(continuation);
            }
        } else {
            c17251 = new C17251(continuation);
        }
        Object objStartUpdateFlowAsResult = c17251.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c17251.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objStartUpdateFlowAsResult);
            BoxLogUtils.d(LOG_TAG, "Showing flexible update");
            AppUpdateManager appUpdateManager = this.appUpdateManager;
            c17251.L$0 = SpillingKt.nullOutSpilledVariable(appCompatActivity);
            c17251.L$1 = appUpdateInfo;
            c17251.label = 1;
            objStartUpdateFlowAsResult = AppUpdateManagerExtensionsKt.startUpdateFlowAsResult(appUpdateManager, appUpdateInfo, appCompatActivity, 0, c17251);
            if (objStartUpdateFlowAsResult == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            appUpdateInfo = (AppUpdateInfo) c17251.L$1;
            ResultKt.throwOnFailure(objStartUpdateFlowAsResult);
        }
        Result result = (Result) objStartUpdateFlowAsResult;
        BoxLogUtils.d(LOG_TAG, "Update prompt result: " + result);
        if (!(result instanceof Result.Success)) {
            this.appUpdateProposalAnalytics.updateProposalCannotBeShown();
            return Unit.INSTANCE;
        }
        saveLastPromptInfo(appUpdateInfo.availableVersionCode());
        this.appUpdateProposalAnalytics.updateProposalShown();
        if (((Result.Success) result).getValue() == UpdateFlowResult.ACCEPTED) {
            this.appUpdateProposalAnalytics.updateProposalAccepted();
            this._updateDownloadingEventFlow.tryEmit(Unit.INSTANCE);
            this.appUpdateManager.registerListener(new InstallStateUpdatedListener() { // from class: com.box.android.updates.proposal.AppUpdateProposalManager$$ExternalSyntheticLambda0
                @Override // com.google.android.play.core.listener.StateUpdatedListener
                public final void onStateUpdate(InstallState installState) {
                    AppUpdateProposalManager.startFlexibleUpdate$lambda$0(this.f$0, installState);
                }
            });
        }
        return Unit.INSTANCE;
    }

    private final LastPromptInfo getLastPromptInfo() {
        long j = this.sharedPreferences.getLong(LAST_PROMPT_TIME_KEY, -1L);
        int i = this.sharedPreferences.getInt(LAST_PROMPT_VERSION_CODE_KEY, 0);
        if (j == -1) {
            return null;
        }
        long jCoerceAtLeast = RangesKt.coerceAtLeast(this.clock.currentTimeMillis() - j, 0L);
        Duration.Companion companion = Duration.INSTANCE;
        return new LastPromptInfo((int) Duration.m16164getInWholeDaysimpl(DurationKt.toDuration(jCoerceAtLeast, DurationUnit.MILLISECONDS)), i);
    }

    private final void saveLastPromptInfo(int versionCode) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putLong(LAST_PROMPT_TIME_KEY, this.clock.currentTimeMillis());
        editorEdit.putInt(LAST_PROMPT_VERSION_CODE_KEY, versionCode);
        editorEdit.apply();
    }

    public final void completeUpdate() {
        this.appUpdateManager.completeUpdate();
    }

    /* JADX INFO: compiled from: AppUpdateProposalManager.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/updates/proposal/AppUpdateProposalManager$LastPromptInfo;", "", "fullDaysAgo", "", "versionCode", "<init>", "(II)V", "getFullDaysAgo", "()I", "getVersionCode", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final /* data */ class LastPromptInfo {
        private final int fullDaysAgo;
        private final int versionCode;

        public static /* synthetic */ LastPromptInfo copy$default(LastPromptInfo lastPromptInfo, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = lastPromptInfo.fullDaysAgo;
            }
            if ((i3 & 2) != 0) {
                i2 = lastPromptInfo.versionCode;
            }
            return lastPromptInfo.copy(i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getFullDaysAgo() {
            return this.fullDaysAgo;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getVersionCode() {
            return this.versionCode;
        }

        public final LastPromptInfo copy(int fullDaysAgo, int versionCode) {
            return new LastPromptInfo(fullDaysAgo, versionCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LastPromptInfo)) {
                return false;
            }
            LastPromptInfo lastPromptInfo = (LastPromptInfo) other;
            return this.fullDaysAgo == lastPromptInfo.fullDaysAgo && this.versionCode == lastPromptInfo.versionCode;
        }

        public int hashCode() {
            return (Integer.hashCode(this.fullDaysAgo) * 31) + Integer.hashCode(this.versionCode);
        }

        public String toString() {
            return "LastPromptInfo(fullDaysAgo=" + this.fullDaysAgo + ", versionCode=" + this.versionCode + ")";
        }

        public LastPromptInfo(int i, int i2) {
            this.fullDaysAgo = i;
            this.versionCode = i2;
        }

        public final int getFullDaysAgo() {
            return this.fullDaysAgo;
        }

        public final int getVersionCode() {
            return this.versionCode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startFlexibleUpdate$lambda$0(AppUpdateProposalManager appUpdateProposalManager, InstallState installState) {
        Intrinsics.checkNotNullParameter(installState, "installState");
        if (installState.installStatus() == 11) {
            appUpdateProposalManager._updateDownloadedStateFlow.setValue(true);
        } else if (installState.installStatus() == 5) {
            appUpdateProposalManager.appUpdateProposalAnalytics.updateProposalInstallFailed();
        }
    }
}
