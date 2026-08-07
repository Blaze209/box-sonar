package com.pspdfkit.listeners;

import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.internal.go;
import com.pspdfkit.internal.uw;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class OnVisibilityChangedListenerManager implements OnVisibilityChangedListener {
    private final go<OnVisibilityChangedListener> listeners = new go<>();

    public void addOnVisibilityChangedListener(OnVisibilityChangedListener onVisibilityChangedListener) {
        uw.a(onVisibilityChangedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.listeners.a(onVisibilityChangedListener);
    }

    public void clear() {
        this.listeners.clear();
    }

    @Override // com.pspdfkit.listeners.OnVisibilityChangedListener
    public void onHide(View view) {
        Iterator<OnVisibilityChangedListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onHide(view);
        }
    }

    @Override // com.pspdfkit.listeners.OnVisibilityChangedListener
    public void onShow(View view) {
        Iterator<OnVisibilityChangedListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onShow(view);
        }
    }

    public void removeOnVisibilityChangedListener(OnVisibilityChangedListener onVisibilityChangedListener) {
        uw.a(onVisibilityChangedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.listeners.b(onVisibilityChangedListener);
    }
}
