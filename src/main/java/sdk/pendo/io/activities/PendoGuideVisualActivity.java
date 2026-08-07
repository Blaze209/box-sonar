package sdk.pendo.io.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.actions.CarouselVisualGuide;
import sdk.pendo.io.actions.GuidesManager;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.actions.PendoCommandDispatcher;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.actions.PendoCommandsEventBus;
import sdk.pendo.io.actions.StepSeenManager;
import sdk.pendo.io.actions.StepSeenManagerInterface;
import sdk.pendo.io.actions.VisualAnimationManager;
import sdk.pendo.io.actions.VisualGuide;
import sdk.pendo.io.actions.VisualGuidesManager;
import sdk.pendo.io.actions.VisualGuidesManagerInterface;
import sdk.pendo.io.d6.c;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.o6.a;
import sdk.pendo.io.q3.e;
import sdk.pendo.io.r5.g;
import sdk.pendo.io.r5.i;
import sdk.pendo.io.s7.r;
import sdk.pendo.io.t6.d;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b#\u0010\u001aJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\f\u001a\u00020\u0006H\u0014J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0014J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\"\u0010\u0007\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0007J\u000f\u0010\u0019\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\"\u0010\u0003\u001a\u00020\u00172\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u0017R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010!¨\u0006%"}, d2 = {"Lsdk/pendo/io/activities/PendoGuideVisualActivity;", "Lsdk/pendo/io/activities/BaseRxActivity;", "Landroid/view/View;", "b", "", "guideId", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "d", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "onDestroy", "onBackPressed", "outState", "onSaveInstanceState", "", "requestedOrientation", "setRequestedOrientation", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "activatedBy", "", "isPreviewGuide", "c", "()V", "Lsdk/pendo/io/o3/b;", "Lsdk/pendo/io/o3/b;", "sAnimationEndedSub", "Lsdk/pendo/io/actions/VisualGuide;", "Lsdk/pendo/io/actions/VisualGuide;", "mVisualGuide", "Z", "mIsCarousel", "<init>", "e", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class PendoGuideVisualActivity extends BaseRxActivity {

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private sdk.pendo.io.o3.b sAnimationEndedSub;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private VisualGuide mVisualGuide;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private boolean mIsCarousel;

    /* JADX INFO: renamed from: sdk.pendo.io.activities.PendoGuideVisualActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000b¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/activities/PendoGuideVisualActivity$a;", "", "", "guideId", "Lsdk/pendo/io/actions/ActivationManager$ActivationEvents;", "activationEvent", "", "isPreview", "Landroid/content/Intent;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "EXTRA_ACTIVATED_BY", "Ljava/lang/String;", "EXTRA_GUIDE_ID", "EXTRA_IS_PREVIEW", "", "ID", "I", "TAG", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(String guideId, ActivationManager.ActivationEvents activationEvent, boolean isPreview) {
            Intent intent = new Intent(PendoInternal.o(), (Class<?>) PendoGuideVisualActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("GUIDE_ID", guideId);
            bundle.putString("ACTIVATED_BY", activationEvent != null ? activationEvent.getActivationEvent() : null);
            bundle.putBoolean("IS_PREVIEW", isPreview);
            intent.putExtras(bundle);
            return intent;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0003\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "kotlin.jvm.PlatformType", "isAnimationFinished", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Ljava/lang/Boolean;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0})
    static final class b extends Lambda implements Function1<Boolean, Boolean> {
        public static final b a = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Boolean bool) {
            Intrinsics.checkNotNull(bool);
            return bool;
        }
    }

    private final View b() {
        ViewGroup container;
        try {
            VisualGuide visualGuide = this.mVisualGuide;
            View childAt = (visualGuide == null || (container = visualGuide.getContainer()) == null) ? null : container.getChildAt(0);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
            return ((ViewGroup) childAt).getChildAt(0);
        } catch (Exception e) {
            PendoLogger.w("PendoGuideVisualActivity getGuideContentLayout caught error:" + e + " with message: " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    private final void d() {
        sdk.pendo.io.o3.b bVar = this.sAnimationEndedSub;
        if (bVar != null) {
            bVar.dispose();
        }
        this.sAnimationEndedSub = null;
    }

    public final boolean a(String guideId, String activatedBy, boolean isPreviewGuide) {
        VisualGuide visualGuide;
        Intrinsics.checkNotNullParameter(guideId, "guideId");
        GuideModel guideModelE = isPreviewGuide ? a.d().e() : GuidesManager.INSTANCE.getGuide(guideId);
        String currentStepId = StepSeenManager.getInstance().getCurrentStepId();
        if (guideModelE == null || currentStepId == null) {
            PendoLogger.w("PendoGuideVisualActivity Not showing guide due to guideModel or guideStepId being null", new Object[0]);
            return false;
        }
        a(guideId);
        g gVarA = i.e().a(guideModelE);
        String guideStepCarouselId = guideModelE.getGuideStepCarouselId(currentStepId);
        if (guideStepCarouselId != null) {
            this.mIsCarousel = true;
            VisualGuidesManagerInterface visualGuidesManager = VisualGuidesManager.getInstance();
            StepSeenManagerInterface stepSeenManager = StepSeenManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(stepSeenManager, "getInstance(...)");
            visualGuide = new CarouselVisualGuide(guideModelE, guideStepCarouselId, visualGuidesManager, stepSeenManager);
        } else {
            visualGuide = new VisualGuide(guideModelE, VisualGuidesManager.getInstance(), StepSeenManager.getInstance());
        }
        this.mVisualGuide = visualGuide;
        return r.a(this, visualGuide, gVarA, activatedBy, currentStepId);
    }

    public final void c() {
        try {
            VisualGuide visualGuide = this.mVisualGuide;
            d dVar = null;
            VisualAnimationManager animationManager = visualGuide != null ? visualGuide.getAnimationManager() : null;
            if (animationManager == null) {
                finish();
            } else {
                j<Boolean> finishedAnimationObservable = animationManager.getFinishedAnimationObservable();
                if (finishedAnimationObservable != null) {
                    final b bVar = b.a;
                    j<Boolean> jVarA = finishedAnimationObservable.a(new sdk.pendo.io.q3.j() { // from class: sdk.pendo.io.activities.PendoGuideVisualActivity$$ExternalSyntheticLambda0
                        @Override // sdk.pendo.io.q3.j
                        public final boolean test(Object obj) {
                            return PendoGuideVisualActivity.a(bVar, obj);
                        }
                    });
                    if (jVarA != null) {
                        dVar = (d) jVarA.c(d.a(new e() { // from class: sdk.pendo.io.activities.PendoGuideVisualActivity$$ExternalSyntheticLambda1
                            @Override // sdk.pendo.io.q3.e
                            public final void accept(Object obj) {
                                PendoGuideVisualActivity.a(this.f$0, (Boolean) obj);
                            }
                        }, "PendoGuideVisualActivity FinishedAnimationObservable"));
                    }
                }
                this.sAnimationEndedSub = dVar;
                if (dVar != null) {
                    return;
                } else {
                    finish();
                }
            }
            overridePendingTransition(0, 0);
        } catch (Exception e) {
            PendoLogger.e("PendoGuideVisualActivity", "GuideCloseCommand error with exception:", e);
            finish();
            overridePendingTransition(0, 0);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            PendoCommand pendoCommand = PendoCommandDispatcher.PredefinedCommands.BACK_PRESSED;
            VisualGuide visualGuide = this.mVisualGuide;
            pendoCommand.setParameters(PendoCommandAction.PendoCommandGlobalAction.PendoInfoConsts.createPendoMetadataParams(visualGuide != null ? visualGuide.getGuideId() : null));
            PendoCommandDispatcher.getInstance().dispatchCommand(pendoCommand, false);
        } catch (Exception e) {
            PendoLogger.e("PendoGuideVisualActivity onBackPressed caught error:" + e + " with message: " + e.getMessage(), new Object[0]);
        }
        super.onBackPressed();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        try {
            super.onConfigurationChanged(newConfig);
            c.h().k();
        } catch (Exception e) {
            PendoLogger.e("PendoGuideVisualActivity onConfigurationChanged caught with error: " + e + " with message: " + e.getMessage(), new Object[0]);
        }
    }

    @Override // sdk.pendo.io.activities.BaseRxActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        VisualGuide visualGuide;
        ViewGroup container;
        super.onMAMCreate(bundle);
        if (!b(getIntent().getStringExtra("GUIDE_ID"), getIntent().getStringExtra("ACTIVATED_BY"), getIntent().getBooleanExtra("IS_PREVIEW", false)) || (visualGuide = this.mVisualGuide) == null || (container = visualGuide.getContainer()) == null) {
            return;
        }
        ViewCompat.setOnApplyWindowInsetsListener(container, new OnApplyWindowInsetsListener() { // from class: sdk.pendo.io.activities.PendoGuideVisualActivity$$ExternalSyntheticLambda3
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return PendoGuideVisualActivity.a(this.f$0, view, windowInsetsCompat);
            }
        });
    }

    @Override // sdk.pendo.io.activities.BaseRxActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        super.onMAMDestroy();
        GuidesManager.INSTANCE.setCurrentGuideAsNull();
        VisualGuidesManager.getInstance().setIsAnyGuideDisplayed(false);
        this.mVisualGuide = null;
        d();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        try {
            super.onMAMSaveInstanceState(outState);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int requestedOrientation) {
        super.setRequestedOrientation(requestedOrientation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    public final boolean b(String guideId, String activatedBy, boolean isPreviewGuide) {
        String str;
        if (guideId != null) {
            try {
                if (guideId.length() != 0) {
                    if (activatedBy == null || activatedBy.length() == 0) {
                        PendoLogger.i("PendoGuideVisualActivity Activation method was not received", new Object[0]);
                        str = "";
                    } else {
                        str = activatedBy;
                    }
                    if (a(guideId, str, isPreviewGuide)) {
                        return true;
                    }
                    finish();
                    return false;
                }
            } catch (Exception e) {
                if (activatedBy == null) {
                    activatedBy = "missing";
                }
                if (guideId == null) {
                    guideId = "no id";
                }
                PendoLogger.e("PendoGuideVisualActivity " + e + " activated by: " + activatedBy + "\n isPreview: " + isPreviewGuide + "\n guideId: " + guideId + " with message: " + e.getMessage(), new Object[0]);
                finish();
                return false;
            }
        }
        PendoLogger.i("PendoGuideVisualActivity Aborting showing guide, as the guide id received is invalid", new Object[0]);
        finish();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PendoGuideVisualActivity this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
        this$0.overridePendingTransition(0, 0);
        this$0.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat a(PendoGuideVisualActivity this$0, View view, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.ime());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        View viewB = this$0.b();
        if (viewB != null) {
            viewB.setPadding(insets2.left, insets2.top, insets2.right, insets2.bottom);
        }
        return insets;
    }

    private final void a(String guideId) {
        PendoCommandsEventBus.getInstance().subscribe(a(), PendoCommand.createFilter(guideId, "any", PendoCommandAction.PendoCommandGlobalAction.NOTIFY_CLOSE, PendoCommandEventType.PENDO_COMMAND_EVENT_TYPE_ANY, PendoCommand.PendoCommandScope.PENDO_COMMAND_SCOPE_ANY), new e() { // from class: sdk.pendo.io.activities.PendoGuideVisualActivity$$ExternalSyntheticLambda2
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                PendoGuideVisualActivity.a(this.f$0, (PendoCommand) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PendoGuideVisualActivity this$0, PendoCommand pendoCommand) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c();
    }
}
