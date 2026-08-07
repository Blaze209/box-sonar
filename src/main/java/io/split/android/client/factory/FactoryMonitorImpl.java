package io.split.android.client.factory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class FactoryMonitorImpl implements FactoryMonitor {
    private static FactoryMonitor sharedInstance;
    private Map<String, Integer> factories = new HashMap();

    public static FactoryMonitor getSharedInstance() {
        if (sharedInstance == null) {
            sharedInstance = new FactoryMonitorImpl();
        }
        return sharedInstance;
    }

    @Override // io.split.android.client.factory.FactoryMonitor
    public synchronized int count() {
        int iIntValue;
        Iterator<Integer> it = this.factories.values().iterator();
        iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += it.next().intValue();
        }
        return iIntValue;
    }

    @Override // io.split.android.client.factory.FactoryMonitor
    public synchronized int count(String apiKey) {
        Integer num;
        num = this.factories.get(apiKey);
        return num != null ? num.intValue() : 0;
    }

    @Override // io.split.android.client.factory.FactoryMonitor
    public synchronized void add(String apiKey) {
        Integer num = this.factories.get(apiKey);
        this.factories.put(apiKey, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
    }

    @Override // io.split.android.client.factory.FactoryMonitor
    public synchronized void remove(String apiKey) {
        Integer num = this.factories.get(apiKey);
        int iIntValue = (num != null ? num.intValue() : 0) - 1;
        if (iIntValue > 0) {
            this.factories.put(apiKey, Integer.valueOf(iIntValue));
        } else {
            this.factories.remove(apiKey);
        }
    }
}
