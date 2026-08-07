package com.splunk.rum;

import android.app.Activity;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
class VisibleScreenTracker {
    private final AtomicReference<String> lastResumedActivity = new AtomicReference<>();
    private final AtomicReference<String> previouslyLastResumedActivity = new AtomicReference<>();
    private final AtomicReference<String> lastResumedFragment = new AtomicReference<>();
    private final AtomicReference<String> previouslyLastResumedFragment = new AtomicReference<>();

    VisibleScreenTracker() {
    }

    String getPreviouslyVisibleScreen() {
        String str = this.previouslyLastResumedFragment.get();
        return str != null ? str : this.previouslyLastResumedActivity.get();
    }

    String getCurrentlyVisibleScreen() {
        String str = this.lastResumedFragment.get();
        if (str != null) {
            return str;
        }
        String str2 = this.lastResumedActivity.get();
        return str2 != null ? str2 : "unknown";
    }

    void activityResumed(Activity activity) {
        this.lastResumedActivity.set(activity.getClass().getSimpleName());
    }

    void activityPaused(Activity activity) {
        this.previouslyLastResumedActivity.set(activity.getClass().getSimpleName());
        PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.lastResumedActivity, activity.getClass().getSimpleName(), null);
    }

    void fragmentResumed(Fragment fragment) {
        if (fragment instanceof NavHostFragment) {
            return;
        }
        if (fragment instanceof DialogFragment) {
            this.previouslyLastResumedFragment.set(this.lastResumedFragment.get());
        }
        this.lastResumedFragment.set(fragment.getClass().getSimpleName());
    }

    void fragmentPaused(Fragment fragment) {
        if (fragment instanceof NavHostFragment) {
            return;
        }
        if (fragment instanceof DialogFragment) {
            this.lastResumedFragment.set(this.previouslyLastResumedFragment.get());
        } else {
            PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.lastResumedFragment, fragment.getClass().getSimpleName(), null);
        }
        this.previouslyLastResumedFragment.set(fragment.getClass().getSimpleName());
    }
}
