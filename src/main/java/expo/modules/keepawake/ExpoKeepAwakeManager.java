package expo.modules.keepawake;

import android.app.Activity;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.microsoft.intune.mam.client.view.MAMWindowManagement;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.Exceptions;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoKeepAwakeManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000f¨\u0006\u0014"}, d2 = {"Lexpo/modules/keepawake/ExpoKeepAwakeManager;", "", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Lexpo/modules/kotlin/AppContext;)V", "tags", "", "", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "isActivated", "", "()Z", RemoteConfigComponent.ACTIVATE_FILE_NAME, "", "tag", "deactivate", "expo-keep-awake_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExpoKeepAwakeManager {
    private final AppContext appContext;
    private final Set<String> tags = new LinkedHashSet();

    public ExpoKeepAwakeManager(AppContext appContext) {
        this.appContext = appContext;
    }

    private final Activity getCurrentActivity() throws Exceptions.AppContextLost {
        AppContext appContext = this.appContext;
        if (appContext != null) {
            return appContext.getThrowingActivity();
        }
        throw new Exceptions.AppContextLost();
    }

    public final boolean isActivated() {
        return !this.tags.isEmpty();
    }

    public final void activate(String tag) throws Exceptions.AppContextLost {
        Intrinsics.checkNotNullParameter(tag, "tag");
        final Activity currentActivity = getCurrentActivity();
        if (!isActivated()) {
            currentActivity.runOnUiThread(new Runnable() { // from class: expo.modules.keepawake.ExpoKeepAwakeManager$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ExpoKeepAwakeManager.activate$lambda$0(currentActivity);
                }
            });
        }
        this.tags.add(tag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void activate$lambda$0(Activity activity) {
        activity.getWindow().addFlags(128);
    }

    public final void deactivate(String tag) throws Exceptions.AppContextLost {
        Intrinsics.checkNotNullParameter(tag, "tag");
        final Activity currentActivity = getCurrentActivity();
        if (this.tags.size() == 1 && this.tags.contains(tag)) {
            currentActivity.runOnUiThread(new Runnable() { // from class: expo.modules.keepawake.ExpoKeepAwakeManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ExpoKeepAwakeManager.deactivate$lambda$1(currentActivity);
                }
            });
        }
        this.tags.remove(tag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deactivate$lambda$1(Activity activity) {
        MAMWindowManagement.clearFlags(activity.getWindow(), 128);
    }
}
