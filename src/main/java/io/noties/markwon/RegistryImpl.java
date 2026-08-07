package io.noties.markwon;

import io.noties.markwon.core.CorePlugin;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
class RegistryImpl implements MarkwonPlugin.Registry {
    private final List<MarkwonPlugin> origin;
    private final Set<MarkwonPlugin> pending = new HashSet(3);
    private final List<MarkwonPlugin> plugins;

    RegistryImpl(List<MarkwonPlugin> list) {
        this.origin = list;
        this.plugins = new ArrayList(list.size());
    }

    @Override // io.noties.markwon.MarkwonPlugin.Registry
    public <P extends MarkwonPlugin> P require(Class<P> cls) {
        return (P) get(cls);
    }

    @Override // io.noties.markwon.MarkwonPlugin.Registry
    public <P extends MarkwonPlugin> void require(Class<P> cls, MarkwonPlugin.Action<? super P> action) {
        action.apply(get(cls));
    }

    List<MarkwonPlugin> process() {
        Iterator<MarkwonPlugin> it = this.origin.iterator();
        while (it.hasNext()) {
            configure(it.next());
        }
        return this.plugins;
    }

    private void configure(MarkwonPlugin markwonPlugin) {
        if (this.plugins.contains(markwonPlugin)) {
            return;
        }
        if (this.pending.contains(markwonPlugin)) {
            throw new IllegalStateException("Cyclic dependency chain found: " + this.pending);
        }
        this.pending.add(markwonPlugin);
        markwonPlugin.configure(this);
        this.pending.remove(markwonPlugin);
        if (this.plugins.contains(markwonPlugin)) {
            return;
        }
        if (CorePlugin.class.isAssignableFrom(markwonPlugin.getClass())) {
            this.plugins.add(0, markwonPlugin);
        } else {
            this.plugins.add(markwonPlugin);
        }
    }

    private <P extends MarkwonPlugin> P get(Class<P> cls) {
        P p = (P) find(this.plugins, cls);
        if (p != null) {
            return p;
        }
        P p2 = (P) find(this.origin, cls);
        if (p2 == null) {
            throw new IllegalStateException("Requested plugin is not added: " + cls.getName() + ", plugins: " + this.origin);
        }
        configure(p2);
        return p2;
    }

    private static <P extends MarkwonPlugin> P find(List<MarkwonPlugin> list, Class<P> cls) {
        Iterator<MarkwonPlugin> it = list.iterator();
        while (it.hasNext()) {
            P p = (P) it.next();
            if (cls.isAssignableFrom(p.getClass())) {
                return p;
            }
        }
        return null;
    }
}
