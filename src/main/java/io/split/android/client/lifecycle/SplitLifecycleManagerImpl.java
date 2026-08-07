package io.split.android.client.lifecycle;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import io.split.android.client.service.synchronizer.ThreadUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SplitLifecycleManagerImpl implements DefaultLifecycleObserver, SplitLifecycleManager {
    private final List<WeakReference<SplitLifecycleAware>> mComponents = new ArrayList();

    public SplitLifecycleManagerImpl() {
        ThreadUtils.runInMainThread(new Runnable() { // from class: io.split.android.client.lifecycle.SplitLifecycleManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                ProcessLifecycleOwner.get().getLifecycle().addObserver(SplitLifecycleManagerImpl.this);
            }
        });
    }

    @Override // io.split.android.client.lifecycle.SplitLifecycleManager
    public void register(SplitLifecycleAware component) {
        this.mComponents.add(new WeakReference<>(component));
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        changeRunningStatus(false);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        changeRunningStatus(true);
    }

    private void changeRunningStatus(boolean run) {
        SplitLifecycleAware splitLifecycleAware;
        for (WeakReference<SplitLifecycleAware> weakReference : this.mComponents) {
            if (weakReference != null && (splitLifecycleAware = weakReference.get()) != null) {
                if (run) {
                    splitLifecycleAware.resume();
                } else {
                    splitLifecycleAware.pause();
                }
            }
        }
    }

    @Override // io.split.android.client.lifecycle.SplitLifecycleManager
    public void destroy() {
        ThreadUtils.runInMainThread(new Runnable() { // from class: io.split.android.client.lifecycle.SplitLifecycleManagerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                ProcessLifecycleOwner.get().getLifecycle().removeObserver(SplitLifecycleManagerImpl.this);
            }
        });
    }
}
