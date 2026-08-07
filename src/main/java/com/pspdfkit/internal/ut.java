package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativePageCache;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.functions.Action;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class ut {
    public final NativePageCache a;
    public final ri b = new ri();

    public ut(NativePageCache nativePageCache) {
        this.a = nativePageCache;
    }

    public final Completable a(String str, int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(Integer.valueOf(i2));
        }
        return a(str, arrayList);
    }

    public final Completable a(final String str, final Collection<Integer> collection) {
        return Completable.fromAction(new Action() { // from class: com.pspdfkit.internal.ut$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                this.f$0.a(collection, str);
            }
        });
    }

    public final void a(Collection collection, String str) throws Throwable {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            NativePageCache nativePageCache = this.a;
            num.getClass();
            nativePageCache.remove(String.format(Locale.getDefault(), "d[%s]p[%d]_", str, num));
            ri riVar = this.b;
            int iIntValue = num.intValue();
            riVar.getClass();
            str.getClass();
            riVar.a.remove(ri.a(str, iIntValue));
        }
    }
}
