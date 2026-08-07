package external.sdk.pendo.io.glide.manager;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import external.sdk.pendo.io.glide.RequestManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
final class h {
    final Map<Lifecycle, RequestManager> a = new HashMap();
    private final j.b b;

    class a implements sdk.pendo.io.r.b {
        final /* synthetic */ Lifecycle a;

        a(Lifecycle lifecycle) {
            this.a = lifecycle;
        }

        @Override // sdk.pendo.io.r.b
        public void onDestroy() {
            h.this.a.remove(this.a);
        }

        @Override // sdk.pendo.io.r.b
        public void onStart() {
        }

        @Override // sdk.pendo.io.r.b
        public void onStop() {
        }
    }

    private final class b implements sdk.pendo.io.r.c {
        private final FragmentManager a;

        b(FragmentManager fragmentManager) {
            this.a = fragmentManager;
        }

        private void a(FragmentManager fragmentManager, Set<RequestManager> set) {
            List<Fragment> fragments = fragmentManager.getFragments();
            int size = fragments.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = fragments.get(i);
                a(fragment.getChildFragmentManager(), set);
                RequestManager requestManagerA = h.this.a(fragment.getLifecycleRegistry());
                if (requestManagerA != null) {
                    set.add(requestManagerA);
                }
            }
        }

        @Override // sdk.pendo.io.r.c
        public Set<RequestManager> a() {
            HashSet hashSet = new HashSet();
            a(this.a, hashSet);
            return hashSet;
        }
    }

    h(j.b bVar) {
        this.b = bVar;
    }

    RequestManager a(Lifecycle lifecycle) {
        l.b();
        return this.a.get(lifecycle);
    }

    RequestManager a(Context context, external.sdk.pendo.io.glide.a aVar, Lifecycle lifecycle, FragmentManager fragmentManager, boolean z) {
        l.b();
        RequestManager requestManagerA = a(lifecycle);
        if (requestManagerA != null) {
            return requestManagerA;
        }
        LifecycleLifecycle lifecycleLifecycle = new LifecycleLifecycle(lifecycle);
        RequestManager requestManagerA2 = this.b.a(aVar, lifecycleLifecycle, new b(fragmentManager), context);
        this.a.put(lifecycle, requestManagerA2);
        lifecycleLifecycle.a(new a(lifecycle));
        if (z) {
            requestManagerA2.onStart();
        }
        return requestManagerA2;
    }
}
