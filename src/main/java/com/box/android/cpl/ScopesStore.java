package com.box.android.cpl;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.observability.DiagnosisParams;
import com.box.android.utilities.Node;
import com.box.android.utilities.Tree;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: ScopesStore.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005J\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\u0005H\u0086\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u00150\u0013\"\u0004\b\u0000\u0010\u0014\"\u0004\b\u0001\u0010\u00152\u0006\u0010\n\u001a\u00020\u0005J!\u0010\u0016\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0001H\u0086\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/box/android/cpl/ScopesStore;", "", "()V", "scopeTree", "Lcom/box/android/utilities/Tree;", "", "scopedStores", "", DiagnosisParams.CLEAR_ON_LOGOUT, "", "key", "createKey", "parentKey", "childKey", PasskeyWebListener.GET_UNIQUE_KEY, "isEmpty", "", "remove", "requireStore", "Lcom/box/android/cpl/Store;", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "set", "store", "toString", "cpl-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ScopesStore {
    public static final ScopesStore INSTANCE = new ScopesStore();
    private static final Map<String, Object> scopedStores = new LinkedHashMap();
    private static final Tree<String> scopeTree = new Tree<>(new Node("", new ArrayList()));

    private ScopesStore() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void set(String parentKey, String key, Object store) {
        Intrinsics.checkNotNullParameter(parentKey, "parentKey");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(store, "store");
        Tree<String> tree = scopeTree;
        Node<String> nodeFind = tree.find(parentKey);
        scopedStores.put(key, store);
        int i = 2;
        List list = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        if (nodeFind == null) {
            tree.getRoot().add(new Node<>(key, list, i, objArr3 == true ? 1 : 0));
        } else {
            nodeFind.getChildren().add(new Node<>(key, objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0));
        }
    }

    public final Object get(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return scopedStores.get(key);
    }

    public final void remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        scopedStores.remove(key);
    }

    public final void clear(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        scopeTree.remove(key, new Function1<Node<String>, Unit>() { // from class: com.box.android.cpl.ScopesStore.clear.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Node<String> node) {
                invoke2(node);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Node<String> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ScopesStore.scopedStores.remove(it.getValue());
            }
        });
    }

    public final boolean isEmpty() {
        return scopedStores.isEmpty();
    }

    public final void clear() {
        scopedStores.clear();
        scopeTree.clear();
    }

    public final String createKey(String parentKey, String childKey) {
        Intrinsics.checkNotNullParameter(parentKey, "parentKey");
        Intrinsics.checkNotNullParameter(childKey, "childKey");
        return parentKey.hashCode() + AbstractJsonLexerKt.COLON + childKey;
    }

    public String toString() {
        return scopedStores.toString();
    }

    public final <S, A> Store<S, A> requireStore(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = get(key);
        if (obj != null) {
            return (Store) obj;
        }
        throw new IllegalStateException("Store for key \"" + key + "\" does not exists");
    }
}
