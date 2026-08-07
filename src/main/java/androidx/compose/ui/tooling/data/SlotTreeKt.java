package androidx.compose.ui.tooling.data;

import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.compose.runtime.tooling.LocationSourceInformation;
import androidx.compose.runtime.tooling.ParameterSourceInformation;
import androidx.compose.runtime.tooling.SourceInformation;
import androidx.compose.runtime.tooling.SourceInformationKt;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.unit.IntRect;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SlotTree.jvm.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0002\u001a\u0016\u0010\t\u001a\u00020\n*\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0003\u001a\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001aK\u0010\u0010\u001a\u0004\u0018\u0001H\u0011\"\u0004\b\u0000\u0010\u0011*\u00020\u00122&\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00110\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001ay\u0010\u001a\u001a\u0004\u0018\u0001H\u0011\"\u0004\b\u0000\u0010\u0011\"\u0004\b\u0001\u0010\u001b*\u00020\u001222\u0010\u001c\u001a.\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00110\u001d2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001a\b\u0002\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0 0\u001fH\u0000¢\u0006\u0002\u0010!\u001a\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0016*\u00020\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007\u001a\f\u0010$\u001a\u00020\n*\u00020\u0012H\u0007\u001a\u0014\u0010%\u001a\u00020\u0001*\u00020\u00012\u0006\u0010&\u001a\u00020\u0001H\u0000\u001a\u0014\u0010'\u001a\u0004\u0018\u00010\u00072\b\u0010(\u001a\u0004\u0018\u00010)H\u0003\u001a(\u00103\u001a\b\u0012\u0004\u0012\u00020#0\u00162\u000e\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0\u00162\b\u00105\u001a\u0004\u0018\u00010\u0005H\u0003\u001a2\u00106\u001a\b\u0012\u0004\u0012\u00020#0\u00162\f\u00107\u001a\b\u0012\u0004\u0012\u0002080\u00162\u0006\u00109\u001a\u00020)2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u0016H\u0002\u001a2\u0010<\u001a\b\u0012\u0004\u0012\u00020#0\u00162\f\u00107\u001a\b\u0012\u0004\u0012\u0002080\u00162\u0006\u00109\u001a\u00020)2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u0016H\u0002\u001a:\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u0002082\u0006\u00109\u001a\u00020)2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020@2\b\u0010:\u001a\u0004\u0018\u00010;H\u0003\u001a)\u0010C\u001a\b\u0012\u0004\u0012\u0002080\u00162\f\u00107\u001a\b\u0012\u0004\u0012\u0002080D2\u0006\u0010E\u001a\u00020FH\u0002¢\u0006\u0002\u0010G\u001a\u001a\u0010Q\u001a\u0004\u0018\u000108*\u0006\u0012\u0002\b\u00030R2\u0006\u0010S\u001a\u00020\u0007H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010-\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010.\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010/\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00100\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00101\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00102\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010H\u001a\u00020@X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010I\u001a\u00020@X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010J\u001a\u00020@X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010K\u001a\u00020@X\u0082T¢\u0006\u0002\n\u0000\" \u0010L\u001a\u0004\u0018\u00010\u0007*\u00020\n8FX\u0087\u0004¢\u0006\f\u0012\u0004\bM\u0010N\u001a\u0004\bO\u0010P¨\u0006T"}, d2 = {"emptyBox", "Landroidx/compose/ui/unit/IntRect;", "getEmptyBox", "()Landroidx/compose/ui/unit/IntRect;", "sourceInformationContextOf", "Landroidx/compose/ui/tooling/data/SourceInformationContext;", TtmlNode.TAG_INFORMATION, "", "parent", "getGroup", "Landroidx/compose/ui/tooling/data/Group;", "Landroidx/compose/runtime/tooling/CompositionGroup;", "parentContext", "boundsOfLayoutNode", "node", "Landroidx/compose/ui/layout/LayoutInfo;", "mapTree", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/tooling/CompositionData;", "factory", "Lkotlin/Function3;", "Landroidx/compose/ui/tooling/data/SourceContext;", "", SemanticAttributes.DbSystemValues.CACHE, "Landroidx/compose/ui/tooling/data/ContextCache;", "(Landroidx/compose/runtime/tooling/CompositionData;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/tooling/data/ContextCache;)Ljava/lang/Object;", "mapTreeWithStitching", "R", "createNode", "Lkotlin/Function4;", "childrenToAdd", "", "", "(Landroidx/compose/runtime/tooling/CompositionData;Lkotlin/jvm/functions/Function4;Landroidx/compose/ui/tooling/data/ContextCache;Ljava/util/Map;)Ljava/lang/Object;", "findParameters", "Landroidx/compose/ui/tooling/data/ParameterInformation;", "asTree", "union", "other", "keyPosition", "key", "", "indyLambdaRegex", "Lkotlin/text/Regex;", "legacyLambdaRegex", "parameterPrefix", "internalFieldPrefix", "defaultFieldName", "changedFieldName", "jacocoDataField", "recomposeScopeNameSuffix", "extractParameterInfo", "data", "context", "extractFromIndyLambdaFields", "fields", "Ljava/lang/reflect/Field;", "block", "metadata", "Landroidx/compose/runtime/tooling/ParameterSourceInformation;", "extractFromLegacyFields", "buildParameterInfo", "field", FirebaseAnalytics.Param.INDEX, "", RemoteConfigComponent.DEFAULTS_FILE_NAME, "changed", "filterParameterFields", "", "isIndyLambda", "", "([Ljava/lang/reflect/Field;Z)Ljava/util/List;", "BITS_PER_SLOT", "SLOT_MASK", "STATIC_BITS", "STABLE_BITS", ViewProps.POSITION, "getPosition$annotations", "(Landroidx/compose/ui/tooling/data/Group;)V", "getPosition", "(Landroidx/compose/ui/tooling/data/Group;)Ljava/lang/String;", "accessibleField", "Ljava/lang/Class;", "name", "ui-tooling-data"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SlotTreeKt {
    private static final int BITS_PER_SLOT = 3;
    private static final int SLOT_MASK = 7;
    private static final int STABLE_BITS = 4;
    private static final int STATIC_BITS = 3;
    private static final String changedFieldName = "$$changed";
    private static final String defaultFieldName = "$$default";
    private static final String internalFieldPrefix = "$$";
    private static final String jacocoDataField = "$jacoco";
    private static final String parameterPrefix = "$";
    private static final String recomposeScopeNameSuffix = ".RecomposeScopeImpl";
    private static final IntRect emptyBox = new IntRect(0, 0, 0, 0);
    private static final Regex indyLambdaRegex = new Regex("^f\\$\\d+$");
    private static final Regex legacyLambdaRegex = new Regex("^\\$([^$]+)$|\\$\\$.*?\\$-([^$]+)\\$\\d+$");

    public static /* synthetic */ void getPosition$annotations(Group group) {
    }

    public static final IntRect getEmptyBox() {
        return emptyBox;
    }

    static /* synthetic */ SourceInformationContext sourceInformationContextOf$default(String str, SourceInformationContext sourceInformationContext, int i, Object obj) {
        if ((i & 2) != 0) {
            sourceInformationContext = null;
        }
        return sourceInformationContextOf(str, sourceInformationContext);
    }

    private static final SourceInformationContext sourceInformationContextOf(String str, SourceInformationContext sourceInformationContext) {
        String str2;
        int i;
        SourceInformation sourceInformation = SourceInformationKt.parseSourceInformation(str);
        Integer numValueOf = null;
        if (sourceInformation == null) {
            return null;
        }
        String functionName = sourceInformation.getFunctionName();
        String sourceFile = sourceInformation.getSourceFile();
        if (sourceFile != null) {
            str2 = sourceFile;
        } else if (sourceInformationContext != null) {
            sourceFile = sourceInformationContext.getSourceFile();
            str2 = sourceFile;
        } else {
            str2 = null;
        }
        if (sourceInformation.getSourceFile() != null) {
            String packageHash = sourceInformation.getPackageHash();
            if (packageHash != null) {
                numValueOf = StringsKt.toIntOrNull(packageHash, 36);
            }
        } else if (sourceInformationContext != null) {
            numValueOf = Integer.valueOf(sourceInformationContext.getPackageHash());
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : -1;
        List<LocationSourceInformation> locations = sourceInformation.getLocations();
        Iterator<LocationSourceInformation> it = sourceInformation.getLocations().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (it.next().getIsRepeatable()) {
                i = i2;
                return new SourceInformationContext(functionName, str2, iIntValue, locations, i, sourceInformation.getParameters(), sourceInformation.getIsCall(), sourceInformation.getIsInline());
            }
            i2++;
        }
        i = -1;
        return new SourceInformationContext(functionName, str2, iIntValue, locations, i, sourceInformation.getParameters(), sourceInformation.getIsCall(), sourceInformation.getIsInline());
    }

    private static final Group getGroup(CompositionGroup compositionGroup, SourceInformationContext sourceInformationContext) {
        SourceInformationContext sourceInformationContextSourceInformationContextOf;
        SourceLocation sourceLocation;
        List<ModifierInfo> listEmptyList;
        IntRect intRectBoundsOfLayoutNode;
        ArrayList arrayList;
        Object key = compositionGroup.getKey();
        String sourceInfo = compositionGroup.getSourceInfo();
        if (sourceInfo != null) {
            sourceInformationContextSourceInformationContextOf = sourceInformationContextOf(sourceInfo, sourceInformationContext);
            sourceLocation = null;
        } else {
            sourceInformationContextSourceInformationContextOf = null;
            sourceLocation = null;
        }
        Object node = compositionGroup.getNode();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        CollectionsKt.addAll(arrayList4, compositionGroup.getData());
        Iterator<CompositionGroup> it = compositionGroup.getCompositionGroups().iterator();
        while (it.hasNext()) {
            arrayList3.add(getGroup(it.next(), sourceInformationContextSourceInformationContextOf));
        }
        boolean z = node instanceof LayoutInfo;
        if (z) {
            listEmptyList = ((LayoutInfo) node).getModifierInfo();
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        if (z) {
            intRectBoundsOfLayoutNode = boundsOfLayoutNode((LayoutInfo) node);
        } else if (arrayList3.isEmpty()) {
            intRectBoundsOfLayoutNode = emptyBox;
        } else {
            ArrayList arrayList5 = arrayList3;
            ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
            Iterator it2 = arrayList5.iterator();
            while (it2.hasNext()) {
                arrayList6.add(((Group) it2.next()).getBox());
            }
            Iterator it3 = arrayList6.iterator();
            if (!it3.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object next = it3.next();
            while (it3.hasNext()) {
                next = union((IntRect) it3.next(), (IntRect) next);
            }
            intRectBoundsOfLayoutNode = (IntRect) next;
        }
        boolean z2 = true;
        SourceLocation sourceLocationNextSourceLocation = (sourceInformationContextSourceInformationContextOf == null || !sourceInformationContextSourceInformationContextOf.getIsCall() || sourceInformationContext == null) ? sourceLocation : sourceInformationContext.nextSourceLocation();
        if (node != null) {
            return new NodeGroup(key, node, intRectBoundsOfLayoutNode, arrayList4, listEmptyList, arrayList3);
        }
        Object identity = sourceLocation;
        IntRect intRect = intRectBoundsOfLayoutNode;
        SourceInformationContext sourceInformationContext2 = sourceInformationContextSourceInformationContextOf;
        Object name = sourceInformationContext2 != null ? sourceInformationContext2.getName() : identity;
        CharSequence charSequence = (CharSequence) (sourceInformationContext2 != null ? sourceInformationContext2.getName() : identity);
        if (charSequence != null && charSequence.length() != 0 && (intRect.getBottom() - intRect.getTop() > 0 || intRect.getRight() - intRect.getLeft() > 0)) {
            identity = compositionGroup.getIdentity();
        }
        List<ParameterInformation> listExtractParameterInfo = extractParameterInfo(arrayList2, sourceInformationContext2);
        ArrayList arrayList7 = arrayList3;
        if (sourceInformationContext2 == null || !sourceInformationContext2.getIsInline()) {
            arrayList = arrayList7;
            z2 = false;
        } else {
            arrayList = arrayList7;
        }
        return new CallGroup(key, name, intRect, sourceLocationNextSourceLocation, identity, listExtractParameterInfo, arrayList4, arrayList, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntRect boundsOfLayoutNode(LayoutInfo layoutInfo) {
        LayoutCoordinates coordinates = layoutInfo.getCoordinates();
        if (!layoutInfo.isAttached() || !coordinates.isAttached()) {
            return new IntRect(0, 0, layoutInfo.getWidth(), layoutInfo.getHeight());
        }
        long jPositionInWindow = LayoutCoordinatesKt.positionInWindow(coordinates);
        if ((((9223372034707292159L & jPositionInWindow) + InlineClassHelperKt.DualLoadedSignificand) & (-9223372034707292160L)) != 0) {
            return new IntRect(0, 0, layoutInfo.getWidth(), layoutInfo.getHeight());
        }
        long jMo8273getSizeYbymL2g = coordinates.mo8273getSizeYbymL2g();
        int iRoundToInt = MathKt.roundToInt(Float.intBitsToFloat((int) (jPositionInWindow >> 32)));
        int iRoundToInt2 = MathKt.roundToInt(Float.intBitsToFloat((int) (jPositionInWindow & 4294967295L)));
        return new IntRect(iRoundToInt, iRoundToInt2, ((int) (jMo8273getSizeYbymL2g >> 32)) + iRoundToInt, ((int) (jMo8273getSizeYbymL2g & 4294967295L)) + iRoundToInt2);
    }

    public static /* synthetic */ Object mapTree$default(CompositionData compositionData, Function3 function3, ContextCache contextCache, int i, Object obj) {
        if ((i & 2) != 0) {
            contextCache = new ContextCache();
        }
        return mapTree(compositionData, function3, contextCache);
    }

    public static final <T> T mapTree(CompositionData compositionData, final Function3<? super CompositionGroup, ? super SourceContext, ? super List<? extends T>, ? extends T> function3, ContextCache contextCache) {
        CompositionGroup compositionGroup = (CompositionGroup) CollectionsKt.firstOrNull(compositionData.getCompositionGroups());
        if (compositionGroup == null) {
            return null;
        }
        CompositionCallStack compositionCallStack = new CompositionCallStack(new Function4() { // from class: androidx.compose.ui.tooling.data.SlotTreeKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SlotTreeKt.mapTree$lambda$0(function3, (CompositionGroup) obj, (SourceContext) obj2, (List) obj3, (List) obj4);
            }
        }, contextCache.getContexts$ui_tooling_data(), null, 4, null);
        ArrayList arrayList = new ArrayList();
        compositionCallStack.convert(compositionGroup, 0, arrayList);
        return (T) CollectionsKt.firstOrNull((List) arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object mapTree$lambda$0(Function3 function3, CompositionGroup compositionGroup, SourceContext sourceContext, List list, List list2) {
        return function3.invoke(compositionGroup, sourceContext, list);
    }

    public static /* synthetic */ Object mapTreeWithStitching$default(CompositionData compositionData, Function4 function4, ContextCache contextCache, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            contextCache = new ContextCache();
        }
        if ((i & 4) != 0) {
            map = new LinkedHashMap();
        }
        return mapTreeWithStitching(compositionData, function4, contextCache, map);
    }

    public static final <T, R> T mapTreeWithStitching(CompositionData compositionData, Function4<? super CompositionGroup, ? super SourceContext, ? super List<? extends T>, ? super List<? extends R>, ? extends T> function4, ContextCache contextCache, Map<CompositionGroup, List<R>> map) {
        CompositionGroup compositionGroup = (CompositionGroup) CollectionsKt.firstOrNull(compositionData.getCompositionGroups());
        if (compositionGroup == null) {
            return null;
        }
        CompositionCallStack compositionCallStack = new CompositionCallStack(function4, contextCache.getContexts$ui_tooling_data(), map);
        ArrayList arrayList = new ArrayList();
        compositionCallStack.convert(compositionGroup, 0, arrayList);
        return (T) CollectionsKt.firstOrNull((List) arrayList);
    }

    public static /* synthetic */ List findParameters$default(CompositionGroup compositionGroup, ContextCache contextCache, int i, Object obj) {
        if ((i & 1) != 0) {
            contextCache = null;
        }
        return findParameters(compositionGroup, contextCache);
    }

    public static final List<ParameterInformation> findParameters(CompositionGroup compositionGroup, ContextCache contextCache) {
        String sourceInfo = compositionGroup.getSourceInfo();
        if (sourceInfo == null) {
            return CollectionsKt.emptyList();
        }
        SourceInformationContext sourceInformationContextSourceInformationContextOf$default = null;
        if (contextCache == null) {
            sourceInformationContextSourceInformationContextOf$default = sourceInformationContextOf$default(sourceInfo, null, 2, null);
        } else {
            Map<String, Object> contexts$ui_tooling_data = contextCache.getContexts$ui_tooling_data();
            Object objSourceInformationContextOf$default = contexts$ui_tooling_data.get(sourceInfo);
            if (objSourceInformationContextOf$default == null) {
                objSourceInformationContextOf$default = sourceInformationContextOf$default(sourceInfo, null, 2, null);
                contexts$ui_tooling_data.put(sourceInfo, objSourceInformationContextOf$default);
            }
            if (objSourceInformationContextOf$default instanceof SourceInformationContext) {
                sourceInformationContextSourceInformationContextOf$default = (SourceInformationContext) objSourceInformationContextOf$default;
            }
        }
        ArrayList arrayList = new ArrayList();
        CollectionsKt.addAll(arrayList, compositionGroup.getData());
        return extractParameterInfo(arrayList, sourceInformationContextSourceInformationContextOf$default);
    }

    public static final Group asTree(CompositionData compositionData) {
        Group group;
        CompositionGroup compositionGroup = (CompositionGroup) CollectionsKt.firstOrNull(compositionData.getCompositionGroups());
        return (compositionGroup == null || (group = getGroup(compositionGroup, null)) == null) ? EmptyGroup.INSTANCE : group;
    }

    public static final IntRect union(IntRect intRect, IntRect intRect2) {
        IntRect intRect3 = emptyBox;
        if (Intrinsics.areEqual(intRect, intRect3)) {
            return intRect2;
        }
        if (Intrinsics.areEqual(intRect2, intRect3)) {
            return intRect;
        }
        return new IntRect(Math.min(intRect.getLeft(), intRect2.getLeft()), Math.min(intRect.getTop(), intRect2.getTop()), Math.max(intRect.getRight(), intRect2.getRight()), Math.max(intRect.getBottom(), intRect2.getBottom()));
    }

    private static final String keyPosition(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof JoinedKey)) {
            return null;
        }
        JoinedKey joinedKey = (JoinedKey) obj;
        String strKeyPosition = keyPosition(joinedKey.getLeft());
        return strKeyPosition == null ? keyPosition(joinedKey.getRight()) : strKeyPosition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<ParameterInformation> extractParameterInfo(List<? extends Object> list, SourceInformationContext sourceInformationContext) {
        Object next;
        Object obj;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next != null && StringsKt.endsWith$default(next.getClass().getName(), recomposeScopeNameSuffix, false, 2, (Object) null)) {
                break;
            }
        }
        if (next == null) {
            return CollectionsKt.emptyList();
        }
        Field fieldAccessibleField = accessibleField(next.getClass(), "block");
        if (fieldAccessibleField == null || (obj = fieldAccessibleField.get(next)) == null) {
            return CollectionsKt.emptyList();
        }
        List<ParameterSourceInformation> parameters = sourceInformationContext != null ? sourceInformationContext.getParameters() : null;
        if (parameters == null) {
            parameters = CollectionsKt.emptyList();
        }
        Class<?> cls = obj.getClass();
        try {
            List<Field> listFilterParameterFields = filterParameterFields(cls.getDeclaredFields(), true);
            if (!listFilterParameterFields.isEmpty()) {
                return extractFromIndyLambdaFields(listFilterParameterFields, obj, parameters);
            }
            return extractFromLegacyFields(filterParameterFields(cls.getDeclaredFields(), false), obj, parameters);
        } catch (Exception unused) {
            return CollectionsKt.emptyList();
        }
    }

    private static final List<ParameterInformation> extractFromIndyLambdaFields(List<Field> list, Object obj, List<ParameterSourceInformation> list2) {
        boolean z;
        Object next;
        List listSortedWith = CollectionsKt.sortedWith(list, new Comparator() { // from class: androidx.compose.ui.tooling.data.SlotTreeKt$extractFromIndyLambdaFields$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Integer intOrNull = StringsKt.toIntOrNull(StringsKt.substringAfter$default(((Field) t).getName(), "f$", (String) null, 2, (Object) null));
                Integer numValueOf = Integer.valueOf(intOrNull != null ? intOrNull.intValue() : Integer.MAX_VALUE);
                Integer intOrNull2 = StringsKt.toIntOrNull(StringsKt.substringAfter$default(((Field) t2).getName(), "f$", (String) null, 2, (Object) null));
                return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(intOrNull2 != null ? intOrNull2.intValue() : Integer.MAX_VALUE));
            }
        });
        int i = 0;
        if (list2.isEmpty()) {
            z = true;
        } else {
            List<ParameterSourceInformation> list3 = list2;
            if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                Iterator<T> it = list3.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((ParameterSourceInformation) it.next()).getName() != null) {
                            z = true;
                        }
                    }
                }
            }
            z = false;
        }
        List listTake = z ? CollectionsKt.take(listSortedWith, list2.size()) : listSortedWith;
        int size = z ? list2.size() : listSortedWith.size();
        Field field = (Field) CollectionsKt.getOrNull(listSortedWith, size);
        Object obj2 = field != null ? field.get(obj) : null;
        Integer num = obj2 instanceof Integer ? (Integer) obj2 : null;
        int iIntValue = num != null ? num.intValue() : 0;
        Field field2 = (Field) CollectionsKt.getOrNull(listSortedWith, size + 1);
        Object obj3 = field2 != null ? field2.get(obj) : null;
        Integer num2 = obj3 instanceof Integer ? (Integer) obj3 : null;
        int iIntValue2 = num2 != null ? num2.intValue() : 0;
        List list4 = listTake;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
        Iterator it2 = list4.iterator();
        while (true) {
            int i2 = i;
            if (it2.hasNext()) {
                Object next2 = it2.next();
                i = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Field field3 = (Field) next2;
                Iterator<T> it3 = list2.iterator();
                do {
                    if (!it3.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it3.next();
                } while (((ParameterSourceInformation) next).getSortedIndex() != i2);
                Object obj4 = obj;
                arrayList.add(buildParameterInfo(field3, obj4, i2, iIntValue2, iIntValue, (ParameterSourceInformation) next));
                obj = obj4;
            } else {
                return arrayList;
            }
        }
    }

    private static final List<ParameterInformation> extractFromLegacyFields(List<Field> list, Object obj, List<ParameterSourceInformation> list2) throws IllegalAccessException {
        List<ParameterSourceInformation> listSortedWith;
        ParameterSourceInformation parameterSourceInformation;
        Field field;
        int i;
        ParameterInformation parameterInformationBuildParameterInfo;
        Object obj2 = obj;
        Class<?> cls = obj2.getClass();
        Field fieldAccessibleField = accessibleField(cls, defaultFieldName);
        Object obj3 = fieldAccessibleField != null ? fieldAccessibleField.get(obj2) : null;
        Integer num = obj3 instanceof Integer ? (Integer) obj3 : null;
        int iIntValue = num != null ? num.intValue() : 0;
        Field fieldAccessibleField2 = accessibleField(cls, changedFieldName);
        Object obj4 = fieldAccessibleField2 != null ? fieldAccessibleField2.get(obj2) : null;
        Integer num2 = obj4 instanceof Integer ? (Integer) obj4 : null;
        int iIntValue2 = num2 != null ? num2.intValue() : 0;
        if (!list2.isEmpty()) {
            List<ParameterSourceInformation> list3 = list2;
            if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                Iterator<T> it = list3.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((ParameterSourceInformation) it.next()).getName() != null) {
                            listSortedWith = CollectionsKt.sortedWith(list2, new Comparator() { // from class: androidx.compose.ui.tooling.data.SlotTreeKt$extractFromLegacyFields$$inlined$sortedBy$1
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // java.util.Comparator
                                public final int compare(T t, T t2) {
                                    return ComparisonsKt.compareValues(((ParameterSourceInformation) t).getName(), ((ParameterSourceInformation) t2).getName());
                                }
                            });
                        }
                    }
                }
            }
            listSortedWith = list2;
        } else {
            listSortedWith = CollectionsKt.sortedWith(list2, new Comparator() { // from class: androidx.compose.ui.tooling.data.SlotTreeKt$extractFromLegacyFields$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((ParameterSourceInformation) t).getName(), ((ParameterSourceInformation) t2).getName());
                }
            });
        }
        List listSortedWith2 = CollectionsKt.sortedWith(list, new Comparator() { // from class: androidx.compose.ui.tooling.data.SlotTreeKt$extractFromLegacyFields$$inlined$sortedBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(SlotTreeKt.extractFromLegacyFields$extractedName((Field) t), SlotTreeKt.extractFromLegacyFields$extractedName((Field) t2));
            }
        });
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj5 : listSortedWith2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ParameterSourceInformation parameterSourceInformation2 = (ParameterSourceInformation) CollectionsKt.getOrNull(listSortedWith, i2);
            if (parameterSourceInformation2 == null) {
                parameterSourceInformation2 = new ParameterSourceInformation(i2, null, null, 6, null);
            }
            int sortedIndex = parameterSourceInformation2.getSortedIndex();
            if (sortedIndex >= list.size()) {
                i = iIntValue;
                parameterInformationBuildParameterInfo = null;
            } else {
                Field field2 = (Field) listSortedWith2.get(sortedIndex);
                if (parameterSourceInformation2.getName() == null) {
                    ParameterSourceInformation parameterSourceInformation3 = new ParameterSourceInformation(sortedIndex, extractFromLegacyFields$extractedName(field2), parameterSourceInformation2.getInlineClass());
                    field = field2;
                    parameterSourceInformation = parameterSourceInformation3;
                } else {
                    parameterSourceInformation = parameterSourceInformation2;
                    field = field2;
                }
                i = iIntValue;
                parameterInformationBuildParameterInfo = buildParameterInfo(field, obj2, i2, i, iIntValue2, parameterSourceInformation);
            }
            if (parameterInformationBuildParameterInfo != null) {
                arrayList.add(parameterInformationBuildParameterInfo);
            }
            obj2 = obj;
            iIntValue = i;
            i2 = i3;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String extractFromLegacyFields$extractedName(Field field) {
        MatchGroup matchGroup;
        MatchResult matchResultFind$default = Regex.find$default(legacyLambdaRegex, field.getName(), 0, 2, null);
        MatchGroupCollection groups = matchResultFind$default != null ? matchResultFind$default.getGroups() : null;
        if (groups == null || (matchGroup = groups.get(1)) == null) {
            matchGroup = groups != null ? groups.get(2) : null;
        }
        if (matchGroup != null) {
            return matchGroup.getValue();
        }
        return null;
    }

    private static final ParameterInformation buildParameterInfo(Field field, Object obj, int i, int i2, int i3, ParameterSourceInformation parameterSourceInformation) throws IllegalAccessException {
        String strSubstring;
        field.setAccessible(true);
        Object obj2 = field.get(obj);
        boolean z = ((1 << i) & i2) != 0;
        int i4 = (i * 3) + 1;
        int i5 = (i3 & (7 << i4)) >> i4;
        int i6 = i5 & 3;
        boolean z2 = i6 == 3;
        boolean z3 = i6 == 0;
        boolean z4 = (i5 & 4) == 0;
        if (parameterSourceInformation == null || (strSubstring = parameterSourceInformation.getName()) == null) {
            strSubstring = field.getName().substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        }
        return new ParameterInformation(strSubstring, obj2, z, z2, z3 && !z, parameterSourceInformation != null ? parameterSourceInformation.getInlineClass() : null, z4);
    }

    public static final String getPosition(Group group) {
        return keyPosition(group.getKey());
    }

    private static final Field accessibleField(Class<?> cls, String str) {
        Field field;
        Field[] declaredFields = cls.getDeclaredFields();
        int length = declaredFields.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                field = null;
                break;
            }
            field = declaredFields[i];
            if (Intrinsics.areEqual(field.getName(), str)) {
                break;
            }
            i++;
        }
        if (field == null) {
            return null;
        }
        field.setAccessible(true);
        return field;
    }

    private static final List<Field> filterParameterFields(Field[] fieldArr, boolean z) {
        boolean zMatches;
        ArrayList arrayList = new ArrayList();
        for (Field field : fieldArr) {
            String name = field.getName();
            if (z) {
                zMatches = indyLambdaRegex.matches(name);
            } else {
                zMatches = legacyLambdaRegex.matches(name);
            }
            if (zMatches && !StringsKt.startsWith$default(name, jacocoDataField, false, 2, (Object) null)) {
                arrayList.add(field);
            }
        }
        return arrayList;
    }
}
