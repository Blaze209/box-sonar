package com.box.android.utilities;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.box.android.domain.services.IAppInBackgroundService;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppInBackgroundService.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R2\u0010\t\u001a&\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b \f*\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/box/android/utilities/AppInBackgroundService;", "Lcom/box/android/domain/services/IAppInBackgroundService;", "Landroidx/lifecycle/LifecycleEventObserver;", "<init>", "()V", "isAppInBackground", "", "LOG_TAG", "", "listeners", "", "Lcom/box/android/domain/services/IAppInBackgroundService$Listener;", "kotlin.jvm.PlatformType", "", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "add", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "remove", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AppInBackgroundService implements IAppInBackgroundService, LifecycleEventObserver {
    public static final int $stable;
    private static final String LOG_TAG = "AppInBackgroundService";
    public static final AppInBackgroundService INSTANCE = new AppInBackgroundService();
    private static boolean isAppInBackground = true;
    private static final List<IAppInBackgroundService.Listener> listeners = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: compiled from: AppInBackgroundService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private AppInBackgroundService() {
    }

    static {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.box.android.utilities.AppInBackgroundService$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AppInBackgroundService._init_$lambda$0();
            }
        });
        $stable = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0() {
        ProcessLifecycleOwner.INSTANCE.get().getLifecycleRegistry().addObserver(INSTANCE);
    }

    @Override // com.box.android.domain.services.IAppInBackgroundService
    public boolean isAppInBackground() {
        return isAppInBackground;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            isAppInBackground = false;
            List<IAppInBackgroundService.Listener> listeners2 = listeners;
            Intrinsics.checkNotNullExpressionValue(listeners2, "listeners");
            Iterator<T> it = listeners2.iterator();
            while (it.hasNext()) {
                ((IAppInBackgroundService.Listener) it.next()).onMoveToForeground();
            }
            return;
        }
        if (i == 2) {
            isAppInBackground = true;
            List<IAppInBackgroundService.Listener> listeners3 = listeners;
            Intrinsics.checkNotNullExpressionValue(listeners3, "listeners");
            Iterator<T> it2 = listeners3.iterator();
            while (it2.hasNext()) {
                ((IAppInBackgroundService.Listener) it2.next()).onMoveToBackground();
            }
            return;
        }
        BoxLogUtils.e(LOG_TAG, "Unexpected else branch");
    }

    @Override // com.box.android.domain.services.IAppInBackgroundService
    public void add(IAppInBackgroundService.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.add(listener);
    }

    @Override // com.box.android.domain.services.IAppInBackgroundService
    public void remove(IAppInBackgroundService.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.remove(listener);
    }
}
