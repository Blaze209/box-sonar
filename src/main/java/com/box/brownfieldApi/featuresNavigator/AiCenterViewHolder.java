package com.box.brownfieldApi.featuresNavigator;

import android.widget.FrameLayout;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.callstack.reactnativebrownfield.ReactDelegateWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AICenterCompose.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000e\u0010\u001e\u001a\u00020\u0007HÀ\u0003¢\u0006\u0002\b\u001fJ\u000e\u0010 \u001a\u00020\tHÀ\u0003¢\u0006\u0002\b!J\u000e\u0010\"\u001a\u00020\u000bHÀ\u0003¢\u0006\u0002\b#J\u000e\u0010$\u001a\u00020\rHÀ\u0003¢\u0006\u0002\b%JE\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\f\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006-"}, d2 = {"Lcom/box/brownfieldApi/featuresNavigator/AiCenterViewHolder;", "", "view", "Landroid/widget/FrameLayout;", "recipientId", "", "reactDelegate", "Lcom/callstack/reactnativebrownfield/ReactDelegateWrapper;", "backPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "activity", "Landroidx/fragment/app/FragmentActivity;", "lifecycleObserver", "Landroidx/lifecycle/DefaultLifecycleObserver;", "<init>", "(Landroid/widget/FrameLayout;Ljava/lang/String;Lcom/callstack/reactnativebrownfield/ReactDelegateWrapper;Landroidx/activity/OnBackPressedCallback;Landroidx/fragment/app/FragmentActivity;Landroidx/lifecycle/DefaultLifecycleObserver;)V", "getView", "()Landroid/widget/FrameLayout;", "getRecipientId", "()Ljava/lang/String;", "getReactDelegate$brownfieldApi_release", "()Lcom/callstack/reactnativebrownfield/ReactDelegateWrapper;", "getBackPressedCallback$brownfieldApi_release", "()Landroidx/activity/OnBackPressedCallback;", "getActivity$brownfieldApi_release", "()Landroidx/fragment/app/FragmentActivity;", "getLifecycleObserver$brownfieldApi_release", "()Landroidx/lifecycle/DefaultLifecycleObserver;", "component1", "component2", "component3", "component3$brownfieldApi_release", "component4", "component4$brownfieldApi_release", "component5", "component5$brownfieldApi_release", "component6", "component6$brownfieldApi_release", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "brownfieldApi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AiCenterViewHolder {
    public static final int $stable = 8;
    private final FragmentActivity activity;
    private final OnBackPressedCallback backPressedCallback;
    private final DefaultLifecycleObserver lifecycleObserver;
    private final ReactDelegateWrapper reactDelegate;
    private final String recipientId;
    private final FrameLayout view;

    public static /* synthetic */ AiCenterViewHolder copy$default(AiCenterViewHolder aiCenterViewHolder, FrameLayout frameLayout, String str, ReactDelegateWrapper reactDelegateWrapper, OnBackPressedCallback onBackPressedCallback, FragmentActivity fragmentActivity, DefaultLifecycleObserver defaultLifecycleObserver, int i, Object obj) {
        if ((i & 1) != 0) {
            frameLayout = aiCenterViewHolder.view;
        }
        if ((i & 2) != 0) {
            str = aiCenterViewHolder.recipientId;
        }
        if ((i & 4) != 0) {
            reactDelegateWrapper = aiCenterViewHolder.reactDelegate;
        }
        if ((i & 8) != 0) {
            onBackPressedCallback = aiCenterViewHolder.backPressedCallback;
        }
        if ((i & 16) != 0) {
            fragmentActivity = aiCenterViewHolder.activity;
        }
        if ((i & 32) != 0) {
            defaultLifecycleObserver = aiCenterViewHolder.lifecycleObserver;
        }
        FragmentActivity fragmentActivity2 = fragmentActivity;
        DefaultLifecycleObserver defaultLifecycleObserver2 = defaultLifecycleObserver;
        return aiCenterViewHolder.copy(frameLayout, str, reactDelegateWrapper, onBackPressedCallback, fragmentActivity2, defaultLifecycleObserver2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FrameLayout getView() {
        return this.view;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRecipientId() {
        return this.recipientId;
    }

    /* JADX INFO: renamed from: component3$brownfieldApi_release, reason: from getter */
    public final ReactDelegateWrapper getReactDelegate() {
        return this.reactDelegate;
    }

    /* JADX INFO: renamed from: component4$brownfieldApi_release, reason: from getter */
    public final OnBackPressedCallback getBackPressedCallback() {
        return this.backPressedCallback;
    }

    /* JADX INFO: renamed from: component5$brownfieldApi_release, reason: from getter */
    public final FragmentActivity getActivity() {
        return this.activity;
    }

    /* JADX INFO: renamed from: component6$brownfieldApi_release, reason: from getter */
    public final DefaultLifecycleObserver getLifecycleObserver() {
        return this.lifecycleObserver;
    }

    public final AiCenterViewHolder copy(FrameLayout view, String recipientId, ReactDelegateWrapper reactDelegate, OnBackPressedCallback backPressedCallback, FragmentActivity activity, DefaultLifecycleObserver lifecycleObserver) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recipientId, "recipientId");
        Intrinsics.checkNotNullParameter(reactDelegate, "reactDelegate");
        Intrinsics.checkNotNullParameter(backPressedCallback, "backPressedCallback");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(lifecycleObserver, "lifecycleObserver");
        return new AiCenterViewHolder(view, recipientId, reactDelegate, backPressedCallback, activity, lifecycleObserver);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AiCenterViewHolder)) {
            return false;
        }
        AiCenterViewHolder aiCenterViewHolder = (AiCenterViewHolder) other;
        return Intrinsics.areEqual(this.view, aiCenterViewHolder.view) && Intrinsics.areEqual(this.recipientId, aiCenterViewHolder.recipientId) && Intrinsics.areEqual(this.reactDelegate, aiCenterViewHolder.reactDelegate) && Intrinsics.areEqual(this.backPressedCallback, aiCenterViewHolder.backPressedCallback) && Intrinsics.areEqual(this.activity, aiCenterViewHolder.activity) && Intrinsics.areEqual(this.lifecycleObserver, aiCenterViewHolder.lifecycleObserver);
    }

    public int hashCode() {
        return (((((((((this.view.hashCode() * 31) + this.recipientId.hashCode()) * 31) + this.reactDelegate.hashCode()) * 31) + this.backPressedCallback.hashCode()) * 31) + this.activity.hashCode()) * 31) + this.lifecycleObserver.hashCode();
    }

    public String toString() {
        return "AiCenterViewHolder(view=" + this.view + ", recipientId=" + this.recipientId + ", reactDelegate=" + this.reactDelegate + ", backPressedCallback=" + this.backPressedCallback + ", activity=" + this.activity + ", lifecycleObserver=" + this.lifecycleObserver + ")";
    }

    public AiCenterViewHolder(FrameLayout view, String recipientId, ReactDelegateWrapper reactDelegate, OnBackPressedCallback backPressedCallback, FragmentActivity activity, DefaultLifecycleObserver lifecycleObserver) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recipientId, "recipientId");
        Intrinsics.checkNotNullParameter(reactDelegate, "reactDelegate");
        Intrinsics.checkNotNullParameter(backPressedCallback, "backPressedCallback");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(lifecycleObserver, "lifecycleObserver");
        this.view = view;
        this.recipientId = recipientId;
        this.reactDelegate = reactDelegate;
        this.backPressedCallback = backPressedCallback;
        this.activity = activity;
        this.lifecycleObserver = lifecycleObserver;
    }

    public final FrameLayout getView() {
        return this.view;
    }

    public final String getRecipientId() {
        return this.recipientId;
    }

    public final ReactDelegateWrapper getReactDelegate$brownfieldApi_release() {
        return this.reactDelegate;
    }

    public final OnBackPressedCallback getBackPressedCallback$brownfieldApi_release() {
        return this.backPressedCallback;
    }

    public final FragmentActivity getActivity$brownfieldApi_release() {
        return this.activity;
    }

    public final DefaultLifecycleObserver getLifecycleObserver$brownfieldApi_release() {
        return this.lifecycleObserver;
    }
}
