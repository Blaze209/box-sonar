package com.swmansion.rnscreens.gamma.stack.host;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.swmansion.rnscreens.gamma.stack.screen.StackScreen;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackContainerUpdateCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0011J\u0015\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0013J#\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018H\u0000¢\u0006\u0002\b\u0019R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/host/StackContainerUpdateCoordinator;", "", "<init>", "()V", "pendingPushOperations", "", "Lcom/swmansion/rnscreens/gamma/stack/host/PushOperation;", "pendingPopOperations", "Lcom/swmansion/rnscreens/gamma/stack/host/PopOperation;", "hasPendingOperations", "", "getHasPendingOperations", "()Z", "addPushOperation", "", "stackScreen", "Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen;", "addPushOperation$react_native_screens_release", "addPopOperation", "addPopOperation$react_native_screens_release", "executePendingOperationsIfNeeded", TtmlNode.RUBY_CONTAINER, "Lcom/swmansion/rnscreens/gamma/stack/host/StackContainer;", "renderedScreens", "", "executePendingOperationsIfNeeded$react_native_screens_release", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StackContainerUpdateCoordinator {
    private final List<PushOperation> pendingPushOperations = new ArrayList();
    private final List<PopOperation> pendingPopOperations = new ArrayList();

    private final boolean getHasPendingOperations() {
        return (this.pendingPushOperations.isEmpty() && this.pendingPopOperations.isEmpty()) ? false : true;
    }

    public final void addPushOperation$react_native_screens_release(StackScreen stackScreen) {
        Intrinsics.checkNotNullParameter(stackScreen, "stackScreen");
        this.pendingPushOperations.add(new PushOperation(stackScreen));
    }

    public final void addPopOperation$react_native_screens_release(StackScreen stackScreen) {
        Intrinsics.checkNotNullParameter(stackScreen, "stackScreen");
        this.pendingPopOperations.add(new PopOperation(stackScreen));
    }

    public final void executePendingOperationsIfNeeded$react_native_screens_release(StackContainer container, List<StackScreen> renderedScreens) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(renderedScreens, "renderedScreens");
        if (getHasPendingOperations()) {
            List<PopOperation> list = this.pendingPopOperations;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (PopOperation popOperation : list) {
                arrayList.add(new Pair(Integer.valueOf(renderedScreens.indexOf(popOperation.getScreen())), popOperation));
            }
            Iterator it = CollectionsKt.asReversed(CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.swmansion.rnscreens.gamma.stack.host.StackContainerUpdateCoordinator$executePendingOperationsIfNeeded$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues((Integer) ((Pair) t).getFirst(), (Integer) ((Pair) t2).getFirst());
                }
            })).iterator();
            while (it.hasNext()) {
                container.enqueuePopOperation$react_native_screens_release(((PopOperation) ((Pair) it.next()).component2()).getScreen());
            }
            List<PushOperation> list2 = this.pendingPushOperations;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (PushOperation pushOperation : list2) {
                arrayList2.add(new Pair(Integer.valueOf(renderedScreens.indexOf(pushOperation.getScreen())), pushOperation));
            }
            Iterator it2 = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.swmansion.rnscreens.gamma.stack.host.StackContainerUpdateCoordinator$executePendingOperationsIfNeeded$$inlined$sortedBy$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues((Integer) ((Pair) t).getFirst(), (Integer) ((Pair) t2).getFirst());
                }
            }).iterator();
            while (it2.hasNext()) {
                container.enqueuePushOperation$react_native_screens_release(((PushOperation) ((Pair) it2.next()).component2()).getScreen());
            }
            container.performContainerUpdateIfNeeded$react_native_screens_release();
            this.pendingPopOperations.clear();
            this.pendingPushOperations.clear();
        }
    }
}
