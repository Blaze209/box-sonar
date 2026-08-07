package androidx.constraintlayout.compose;

import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.HelperWidget;
import com.box.android.preview.wopi.WopiService;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ToolingUtils.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a.\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002\u001a\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0002\u001a0\u0010!\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u001aH\u0000\u001a$\u0010'\u001a\n (*\u0004\u0018\u00010 0 *\u00020)2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0001H\u0002\u001a\u0014\u0010*\u001a\u00020\u001a*\u00020)2\u0006\u0010\"\u001a\u00020#H\u0002\u001a\u000e\u0010+\u001a\u00020\u001a*\u0004\u0018\u00010)H\u0002\u001aV\u0010,\u001a\u00020\u0015*\u00020 2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a022\u0006\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002002\b\b\u0002\u00106\u001a\u000200H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\"5\u0010\n\u001a\u00020\u0006*\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00068@@@X\u0081\u008e\u0002¢\u0006\u0018\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013*\u0004\b\u000e\u0010\u000f¨\u00067"}, d2 = {"BOUNDS", "", "CONSTRAINTS", "CONSTRAINTS_JSON_VERSION", "DesignInfoDataKey", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/constraintlayout/compose/DesignInfoProvider;", "getDesignInfoDataKey", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "<set-?>", "designInfoProvider", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "getDesignInfoProvider$annotations", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V", "getDesignInfoProvider$delegate", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/Object;", "getDesignInfoProvider", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/constraintlayout/compose/DesignInfoProvider;", "setDesignInfoProvider", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/constraintlayout/compose/DesignInfoProvider;)V", "addReferencesIds", "", "helperWidget", "Landroidx/constraintlayout/core/widgets/HelperWidget;", "helperReferences", "", "", "root", "Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;", "rootId", "createDesignInfoJson", "content", "Lorg/json/JSONObject;", "parseConstraintsToJson", "state", "Landroidx/constraintlayout/compose/State;", "startX", "startY", "args", "boundsToJson", "kotlin.jvm.PlatformType", "Landroidx/constraintlayout/core/widgets/ConstraintWidget;", "getHelperId", "getRefId", "putViewIdToBoundsAndConstraints", "viewId", "boxJson", "isHelper", "", "isRoot", "", "constraintsInfoArray", "Lorg/json/JSONArray;", "withConstraints", "withBounds", "constraintlayout-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ToolingUtilsKt {
    private static final int BOUNDS = 1;
    private static final int CONSTRAINTS = 0;
    private static final int CONSTRAINTS_JSON_VERSION = 1;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ToolingUtilsKt.class, "designInfoProvider", "getDesignInfoProvider(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/constraintlayout/compose/DesignInfoProvider;", 1))};
    private static final SemanticsPropertyKey<DesignInfoProvider> DesignInfoDataKey = new SemanticsPropertyKey<>("DesignInfoProvider", (Function2) null, 2, (DefaultConstructorMarker) null);

    public static /* synthetic */ void getDesignInfoProvider$annotations(SemanticsPropertyReceiver semanticsPropertyReceiver) {
    }

    public static final SemanticsPropertyKey<DesignInfoProvider> getDesignInfoDataKey() {
        return DesignInfoDataKey;
    }

    public static final DesignInfoProvider getDesignInfoProvider(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return DesignInfoDataKey.getValue(semanticsPropertyReceiver, $$delegatedProperties[0]);
    }

    public static final void setDesignInfoProvider(SemanticsPropertyReceiver semanticsPropertyReceiver, DesignInfoProvider designInfoProvider) {
        DesignInfoDataKey.setValue(semanticsPropertyReceiver, $$delegatedProperties[0], designInfoProvider);
    }

    public static final String parseConstraintsToJson(ConstraintWidgetContainer constraintWidgetContainer, State state, int i, int i2, String str) throws JSONException {
        boolean z;
        boolean z2;
        String refId;
        ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
        String strValueOf = String.valueOf(androidx.constraintlayout.core.state.State.PARENT);
        JSONObject jSONObject = new JSONObject();
        Integer intOrNull = StringsKt.toIntOrNull(str);
        if (intOrNull != null) {
            int iIntValue = intOrNull.intValue();
            boolean z3 = (iIntValue >> 1) == 1;
            z = iIntValue == 1;
            z2 = z3;
        } else {
            z = true;
            z2 = true;
        }
        ArrayList<ConstraintWidget> children = constraintWidgetContainer2.getChildren();
        int size = children.size();
        int i3 = 0;
        while (i3 < size) {
            ConstraintWidget constraintWidget = children.get(i3);
            boolean z4 = z2;
            JSONArray jSONArray = new JSONArray();
            ArrayList arrayList = new ArrayList();
            boolean z5 = constraintWidget instanceof HelperWidget;
            int i4 = i3;
            String str2 = constraintWidget.stringId;
            if (z5) {
                Intrinsics.checkNotNull(constraintWidget, "null cannot be cast to non-null type androidx.constraintlayout.core.widgets.HelperWidget");
                addReferencesIds((HelperWidget) constraintWidget, arrayList, constraintWidgetContainer2, strValueOf);
            }
            ArrayList<ConstraintAnchor> anchors = constraintWidget.getAnchors();
            ArrayList<ConstraintWidget> arrayList2 = children;
            int size2 = anchors.size();
            JSONObject jSONObject2 = jSONObject;
            int i5 = 0;
            while (i5 < size2) {
                ConstraintAnchor constraintAnchor = anchors.get(i5);
                if (constraintAnchor.isConnected()) {
                    ConstraintWidget owner = constraintAnchor.getTarget().getOwner();
                    boolean zAreEqual = Intrinsics.areEqual(constraintWidgetContainer2, owner);
                    boolean z6 = owner instanceof HelperWidget;
                    if (zAreEqual) {
                        refId = strValueOf;
                    } else if (z6) {
                        refId = getHelperId(owner, state);
                    } else {
                        refId = getRefId(owner);
                    }
                    JSONObject jSONObjectPut = new JSONObject().put("originAnchor", constraintAnchor.getType());
                    ConstraintAnchor target = constraintAnchor.getTarget();
                    Intrinsics.checkNotNull(target);
                    jSONArray.put(jSONObjectPut.put("targetAnchor", target.getType()).put("target", refId).put(ViewProps.MARGIN, constraintAnchor.getMargin()));
                }
                i5++;
                constraintWidgetContainer2 = constraintWidgetContainer;
                size2 = size2;
                strValueOf = strValueOf;
            }
            boolean z7 = z;
            putViewIdToBoundsAndConstraints(jSONObject2, str2, boundsToJson(constraintWidget, i, i2), z5, false, arrayList, jSONArray, z7, z4);
            i3 = i4 + 1;
            size = size;
            z = z7;
            z2 = z4;
            children = arrayList2;
            jSONObject = jSONObject2;
            constraintWidgetContainer2 = constraintWidgetContainer;
        }
        putViewIdToBoundsAndConstraints(jSONObject, strValueOf, boundsToJson(constraintWidgetContainer, i, i2), false, true, CollectionsKt.emptyList(), new JSONArray(), z, z2);
        return createDesignInfoJson(jSONObject);
    }

    private static final void addReferencesIds(HelperWidget helperWidget, List<String> list, ConstraintWidgetContainer constraintWidgetContainer, String str) {
        int i = helperWidget.mWidgetsCount;
        for (int i2 = 0; i2 < i; i2++) {
            ConstraintWidget constraintWidget = helperWidget.mWidgets[i2];
            list.add(Intrinsics.areEqual(constraintWidget, constraintWidgetContainer) ? str : getRefId(constraintWidget));
        }
    }

    private static final String getHelperId(ConstraintWidget constraintWidget, State state) {
        Intrinsics.checkNotNull(constraintWidget, "null cannot be cast to non-null type androidx.constraintlayout.core.widgets.HelperWidget");
        return String.valueOf(state.getKeyId$constraintlayout_compose_release((HelperWidget) constraintWidget));
    }

    private static final String getRefId(ConstraintWidget constraintWidget) {
        Object layoutId;
        String string;
        Object companionWidget = constraintWidget != null ? constraintWidget.getCompanionWidget() : null;
        Measurable measurable = companionWidget instanceof Measurable ? (Measurable) companionWidget : null;
        if (measurable == null || (layoutId = LayoutIdKt.getLayoutId(measurable)) == null || (string = layoutId.toString()) == null) {
            return String.valueOf(constraintWidget != null ? constraintWidget.stringId : null);
        }
        return string;
    }

    private static final String createDesignInfoJson(JSONObject jSONObject) {
        return new JSONObject().put("type", "CONSTRAINTS").put("version", 1).put("content", jSONObject).toString();
    }

    private static final JSONObject boundsToJson(ConstraintWidget constraintWidget, int i, int i2) {
        return new JSONObject().put("left", constraintWidget.getLeft() + i).put(ViewProps.TOP, constraintWidget.getTop() + i2).put("right", constraintWidget.getRight() + i).put(ViewProps.BOTTOM, constraintWidget.getBottom() + i2);
    }

    static /* synthetic */ void putViewIdToBoundsAndConstraints$default(JSONObject jSONObject, String str, JSONObject jSONObject2, boolean z, boolean z2, List list, JSONArray jSONArray, boolean z3, boolean z4, int i, Object obj) throws JSONException {
        if ((i & 64) != 0) {
            z3 = true;
        }
        if ((i & 128) != 0) {
            z4 = true;
        }
        putViewIdToBoundsAndConstraints(jSONObject, str, jSONObject2, z, z2, list, jSONArray, z3, z4);
    }

    private static final void putViewIdToBoundsAndConstraints(JSONObject jSONObject, String str, JSONObject jSONObject2, boolean z, boolean z2, List<String> list, JSONArray jSONArray, boolean z3, boolean z4) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("viewId", str);
        if (z4) {
            jSONObject3.put(WopiService.BOX, jSONObject2);
        }
        jSONObject3.put("isHelper", z);
        jSONObject3.put("isRoot", z2);
        JSONArray jSONArray2 = new JSONArray();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            jSONArray2.put(list.get(i));
        }
        jSONObject3.put("helperReferences", jSONArray2);
        if (z3) {
            jSONObject3.put("constraints", jSONArray);
        }
        jSONObject.put(str, jSONObject3);
    }
}
