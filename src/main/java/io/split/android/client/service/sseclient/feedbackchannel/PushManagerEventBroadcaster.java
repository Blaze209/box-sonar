package io.split.android.client.service.sseclient.feedbackchannel;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class PushManagerEventBroadcaster {
    private final List<WeakReference<BroadcastedEventListener>> mListeners = new CopyOnWriteArrayList();

    public void pushMessage(PushStatusEvent message) {
        Iterator<WeakReference<BroadcastedEventListener>> it = this.mListeners.iterator();
        while (it.hasNext()) {
            BroadcastedEventListener broadcastedEventListener = it.next().get();
            if (broadcastedEventListener != null) {
                broadcastedEventListener.onEvent(message);
            }
        }
    }

    public void register(BroadcastedEventListener listener) {
        this.mListeners.add(new WeakReference<>(listener));
    }

    public void close() {
        this.mListeners.clear();
    }
}
