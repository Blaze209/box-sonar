package androidx.compose.ui.tooling.data;

import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.unit.IntRect;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.react.devsupport.StackTraceHelper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.identity.common.java.providers.oauth2.TokenRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.events.ComposeIdentificationData;

/* JADX INFO: compiled from: SlotTree.jvm.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003Bo\u00122\u0010\u0004\u001a.\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t\u0012\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0018\u00010\t¢\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\rJ\u0010\u0010.\u001a\u00020/2\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\b\u00100\u001a\u00020\u0006H\u0002J\u0012\u00104\u001a\u0004\u0018\u00010\u00062\u0006\u00105\u001a\u00020\u0013H\u0002J\u0012\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u00020\nH\u0002J\u0010\u00109\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0006H\u0002R:\u0010\u0004\u001a.\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001eR\u001e\u0010 \u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0015@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010#\u001a\u0004\u0018\u00010$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u00101\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u00103¨\u0006:"}, d2 = {"Landroidx/compose/ui/tooling/data/CompositionCallStack;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Landroidx/compose/ui/tooling/data/SourceContext;", "createNode", "Lkotlin/Function4;", "Landroidx/compose/runtime/tooling/CompositionGroup;", "", "contexts", "", "", "", "childrenToAdd", "", "<init>", "(Lkotlin/jvm/functions/Function4;Ljava/util/Map;Ljava/util/Map;)V", StackTraceHelper.STACK_KEY, "Lkotlin/collections/ArrayDeque;", "currentCallIndex", "", "convert", "Landroidx/compose/ui/unit/IntRect;", "group", "callIndex", "out", "name", "getName", "()Ljava/lang/String;", "isInline", "", "()Z", "value", "bounds", "getBounds", "()Landroidx/compose/ui/unit/IntRect;", FirebaseAnalytics.Param.LOCATION, "Landroidx/compose/ui/tooling/data/SourceLocation;", "getLocation", "()Landroidx/compose/ui/tooling/data/SourceLocation;", "parameters", "Landroidx/compose/ui/tooling/data/ParameterInformation;", "getParameters", "()Ljava/util/List;", ComposeIdentificationData.FIELD_DEPTH, "getDepth", "()I", "push", "", TokenRequest.TokenType.POP, "current", "getCurrent", "()Landroidx/compose/runtime/tooling/CompositionGroup;", "parentGroup", "parentDepth", "contextOf", "Landroidx/compose/ui/tooling/data/SourceInformationContext;", TtmlNode.TAG_INFORMATION, "isCall", "ui-tooling-data"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class CompositionCallStack<T, R> implements SourceContext {
    private IntRect bounds;
    private final Map<CompositionGroup, List<R>> childrenToAdd;
    private final Map<String, Object> contexts;
    private final Function4<CompositionGroup, SourceContext, List<? extends T>, List<? extends R>, T> createNode;
    private int currentCallIndex;
    private final ArrayDeque<CompositionGroup> stack;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositionCallStack(Function4<? super CompositionGroup, ? super SourceContext, ? super List<? extends T>, ? super List<? extends R>, ? extends T> function4, Map<String, Object> map, Map<CompositionGroup, List<R>> map2) {
        this.createNode = function4;
        this.contexts = map;
        this.childrenToAdd = map2;
        this.stack = new ArrayDeque<>();
        this.bounds = SlotTreeKt.getEmptyBox();
    }

    public /* synthetic */ CompositionCallStack(Function4 function4, Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function4, map, (i & 4) != 0 ? null : map2);
    }

    public final IntRect convert(CompositionGroup group, int callIndex, List<T> out) {
        IntRect intRectBoundsOfLayoutNode;
        ArrayList arrayList = new ArrayList();
        IntRect emptyBox = SlotTreeKt.getEmptyBox();
        push(group);
        int i = 0;
        for (CompositionGroup compositionGroup : group.getCompositionGroups()) {
            emptyBox = SlotTreeKt.union(emptyBox, convert(compositionGroup, i, arrayList));
            if (isCall(compositionGroup)) {
                i++;
            }
        }
        Object node = group.getNode();
        List<R> listEmptyList = null;
        LayoutInfo layoutInfo = node instanceof LayoutInfo ? (LayoutInfo) node : null;
        if (layoutInfo != null && (intRectBoundsOfLayoutNode = SlotTreeKt.boundsOfLayoutNode(layoutInfo)) != null) {
            emptyBox = intRectBoundsOfLayoutNode;
        }
        this.currentCallIndex = callIndex;
        this.bounds = emptyBox;
        Map<CompositionGroup, List<R>> map = this.childrenToAdd;
        if (map != null) {
            if (map.isEmpty()) {
                map = null;
            }
            if (map != null) {
                listEmptyList = map.remove(group);
            }
        }
        Function4<CompositionGroup, SourceContext, List<? extends T>, List<? extends R>, T> function4 = this.createNode;
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        T tInvoke = function4.invoke(group, this, arrayList, listEmptyList);
        if (tInvoke != null) {
            out.add(tInvoke);
        }
        pop();
        return emptyBox;
    }

    @Override // androidx.compose.ui.tooling.data.SourceContext
    public String getName() {
        int i;
        String sourceInfo = getCurrent().getSourceInfo();
        if (sourceInfo == null) {
            return null;
        }
        if (!StringsKt.startsWith$default(sourceInfo, "CC(", false, 2, (Object) null)) {
            i = StringsKt.startsWith$default(sourceInfo, "C(", false, 2, (Object) null) ? 2 : 3;
            return null;
        }
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) sourceInfo, ')', 0, false, 6, (Object) null);
        if (iIndexOf$default > 2) {
            String strSubstring = sourceInfo.substring(i, iIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring;
        }
        return null;
    }

    @Override // androidx.compose.ui.tooling.data.SourceContext
    public boolean isInline() {
        String sourceInfo = getCurrent().getSourceInfo();
        return sourceInfo != null && StringsKt.startsWith$default(sourceInfo, "CC", false, 2, (Object) null);
    }

    @Override // androidx.compose.ui.tooling.data.SourceContext
    public IntRect getBounds() {
        return this.bounds;
    }

    @Override // androidx.compose.ui.tooling.data.SourceContext
    public SourceLocation getLocation() {
        String sourceInfo;
        SourceInformationContext sourceInformationContextContextOf;
        String sourceInfo2;
        CompositionGroup compositionGroupParentGroup = parentGroup(1);
        if (compositionGroupParentGroup == null || (sourceInfo = compositionGroupParentGroup.getSourceInfo()) == null || (sourceInformationContextContextOf = contextOf(sourceInfo)) == null) {
            return null;
        }
        int i = 2;
        SourceInformationContext sourceInformationContextContextOf2 = sourceInformationContextContextOf;
        while (i < this.stack.size()) {
            if ((sourceInformationContextContextOf2 != null ? sourceInformationContextContextOf2.getSourceFile() : null) != null) {
                break;
            }
            int i2 = i + 1;
            CompositionGroup compositionGroupParentGroup2 = parentGroup(i);
            sourceInformationContextContextOf2 = (compositionGroupParentGroup2 == null || (sourceInfo2 = compositionGroupParentGroup2.getSourceInfo()) == null) ? null : contextOf(sourceInfo2);
            i = i2;
        }
        return sourceInformationContextContextOf.sourceLocation(this.currentCallIndex, sourceInformationContextContextOf2);
    }

    @Override // androidx.compose.ui.tooling.data.SourceContext
    public List<ParameterInformation> getParameters() {
        SourceInformationContext sourceInformationContextContextOf;
        CompositionGroup current = getCurrent();
        String sourceInfo = current.getSourceInfo();
        if (sourceInfo == null || (sourceInformationContextContextOf = contextOf(sourceInfo)) == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        CollectionsKt.addAll(arrayList, current.getData());
        return SlotTreeKt.extractParameterInfo(arrayList, sourceInformationContextContextOf);
    }

    @Override // androidx.compose.ui.tooling.data.SourceContext
    public int getDepth() {
        return this.stack.size();
    }

    private final void push(CompositionGroup group) {
        this.stack.addLast(group);
    }

    private final CompositionGroup pop() {
        return this.stack.removeLast();
    }

    private final CompositionGroup getCurrent() {
        return this.stack.last();
    }

    private final CompositionGroup parentGroup(int parentDepth) {
        if (this.stack.size() <= parentDepth) {
            return null;
        }
        ArrayDeque<CompositionGroup> arrayDeque = this.stack;
        return arrayDeque.get((arrayDeque.size() - parentDepth) - 1);
    }

    private final SourceInformationContext contextOf(String information) {
        Map<String, Object> map = this.contexts;
        Object objSourceInformationContextOf$default = map.get(information);
        if (objSourceInformationContextOf$default == null) {
            objSourceInformationContextOf$default = SlotTreeKt.sourceInformationContextOf$default(information, null, 2, null);
            map.put(information, objSourceInformationContextOf$default);
        }
        if (objSourceInformationContextOf$default instanceof SourceInformationContext) {
            return (SourceInformationContext) objSourceInformationContextOf$default;
        }
        return null;
    }

    private final boolean isCall(CompositionGroup group) {
        String sourceInfo = group.getSourceInfo();
        if (sourceInfo != null) {
            return StringsKt.startsWith$default(sourceInfo, "C", false, 2, (Object) null);
        }
        return false;
    }
}
