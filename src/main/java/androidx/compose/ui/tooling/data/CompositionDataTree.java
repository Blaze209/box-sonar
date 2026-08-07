package androidx.compose.ui.tooling.data;

import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionDataKt;
import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.compose.runtime.tooling.CompositionInstance;
import androidx.exifinterface.media.ExifInterface;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.ComposeIdentificationData;

/* JADX INFO: compiled from: CompositionDataTree.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u008f\u0001\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u00122\u0010\u000b\u001a.\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00018\u00000\f\u0012(\u0010\u0010\u001a$\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fJ\u0017\u0010\u001d\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u001e\u001a\u00020\tH\u0002¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\tH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R:\u0010\u000b\u001a.\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00018\u00000\fX\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\u0010\u001a$\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/compose/ui/tooling/data/CompositionDataTree;", ExifInterface.GPS_DIRECTION_TRUE, "R", "", "compositions", "", "Landroidx/compose/runtime/tooling/CompositionData;", "prepareResult", "Lkotlin/Function1;", "Landroidx/compose/runtime/tooling/CompositionInstance;", "", "createNode", "Lkotlin/Function4;", "Landroidx/compose/runtime/tooling/CompositionGroup;", "Landroidx/compose/ui/tooling/data/SourceContext;", "", "createResult", "Lkotlin/Function3;", SemanticAttributes.DbSystemValues.CACHE, "Landroidx/compose/ui/tooling/data/ContextCache;", "<init>", "(Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/tooling/data/ContextCache;)V", ComposeIdentificationData.HIERARCHY, "", "", "processedNodes", "rootCompositionInstances", "", "build", "mapTree", "instance", "(Landroidx/compose/runtime/tooling/CompositionInstance;)Ljava/lang/Object;", "buildCompositionParentHierarchy", "ui-tooling-data"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class CompositionDataTree<T, R> {
    private final ContextCache cache;
    private final Set<CompositionData> compositions;
    private final Function4<CompositionGroup, SourceContext, List<? extends T>, List<? extends R>, T> createNode;
    private final Function3<CompositionInstance, T, List<? extends CompositionInstance>, R> createResult;
    private final Function1<CompositionInstance, Unit> prepareResult;
    private final Map<CompositionInstance, List<CompositionInstance>> hierarchy = new LinkedHashMap();
    private final Map<CompositionInstance, R> processedNodes = new LinkedHashMap();
    private final Set<CompositionInstance> rootCompositionInstances = new LinkedHashSet();

    /* JADX WARN: Multi-variable type inference failed */
    public CompositionDataTree(Set<? extends CompositionData> set, Function1<? super CompositionInstance, Unit> function1, Function4<? super CompositionGroup, ? super SourceContext, ? super List<? extends T>, ? super List<? extends R>, ? extends T> function4, Function3<? super CompositionInstance, ? super T, ? super List<? extends CompositionInstance>, ? extends R> function3, ContextCache contextCache) {
        this.compositions = set;
        this.prepareResult = function1;
        this.createNode = function4;
        this.createResult = function3;
        this.cache = contextCache;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            CompositionInstance compositionInstanceFindCompositionInstance = CompositionDataKt.findCompositionInstance((CompositionData) it.next());
            if (compositionInstanceFindCompositionInstance != null) {
                buildCompositionParentHierarchy(compositionInstanceFindCompositionInstance);
            }
        }
    }

    public final List<R> build() {
        Set<CompositionInstance> set = this.rootCompositionInstances;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            R rMapTree = mapTree((CompositionInstance) it.next());
            if (rMapTree != null) {
                arrayList.add(rMapTree);
            }
        }
        return arrayList;
    }

    private final R mapTree(CompositionInstance instance) {
        if (this.processedNodes.containsKey(instance)) {
            return this.processedNodes.get(instance);
        }
        CompositionData data = instance.getData();
        List<CompositionInstance> listEmptyList = this.hierarchy.get(instance);
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        Iterator<CompositionInstance> it = listEmptyList.iterator();
        while (it.hasNext()) {
            mapTree(it.next());
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList<CompositionInstance> arrayList = new ArrayList();
        for (T t : listEmptyList) {
            if (this.processedNodes.containsKey((CompositionInstance) t)) {
                arrayList.add(t);
            }
        }
        for (CompositionInstance compositionInstance : arrayList) {
            CompositionGroup compositionGroupFindContextGroup = compositionInstance.findContextGroup();
            Intrinsics.checkNotNull(compositionGroupFindContextGroup);
            Object obj = linkedHashMap.get(compositionGroupFindContextGroup);
            if (obj == null) {
                obj = (List) new ArrayList();
                linkedHashMap.put(compositionGroupFindContextGroup, obj);
            }
            R r = this.processedNodes.get(compositionInstance);
            Intrinsics.checkNotNull(r);
            ((List) obj).add(r);
        }
        this.prepareResult.invoke(instance);
        R rInvoke = this.createResult.invoke(instance, (T) SlotTreeKt.mapTreeWithStitching(data, this.createNode, this.cache, linkedHashMap), listEmptyList);
        this.processedNodes.put(instance, rInvoke);
        return rInvoke;
    }

    private final void buildCompositionParentHierarchy(CompositionInstance instance) {
        CompositionInstance parent = instance.getParent();
        while (true) {
            CompositionInstance compositionInstance = parent;
            CompositionInstance compositionInstance2 = instance;
            instance = compositionInstance;
            if (instance != null) {
                Map<CompositionInstance, List<CompositionInstance>> map = this.hierarchy;
                ArrayList arrayList = map.get(instance);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(instance, arrayList);
                }
                List<CompositionInstance> list = arrayList;
                if (list.contains(compositionInstance2)) {
                    return;
                }
                list.add(compositionInstance2);
                parent = instance.getParent();
            } else {
                this.rootCompositionInstances.add(compositionInstance2);
                return;
            }
        }
    }
}
