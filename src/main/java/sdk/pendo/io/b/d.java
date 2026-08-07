package sdk.pendo.io.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.box.android.R;
import external.sdk.pendo.io.gson.Gson;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import sdk.pendo.io.a0.i;
import sdk.pendo.io.a0.l;
import sdk.pendo.io.a0.m;
import sdk.pendo.io.actions.GuideActionConfiguration;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.actions.PendoCommandDispatcher;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.actions.StepSeenManager;
import sdk.pendo.io.actions.VisualGuideBase;
import sdk.pendo.io.actions.handlers.PendoCommandViewHandlerUtility;
import sdk.pendo.io.k3.o;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.PersonalizationDefVal;
import sdk.pendo.io.s7.k0;
import sdk.pendo.io.s7.w;
import sdk.pendo.io.utilities.script.JavascriptRunner;
import sdk.pendo.io.views.custom.ActionableBlock;
import sdk.pendo.io.views.custom.IBackgroundRenderView;
import sdk.pendo.io.views.custom.PendoForm;
import sdk.pendo.io.views.custom.PendoRegularRadioButton;
import sdk.pendo.io.views.custom.PendoScrollView;
import sdk.pendo.io.views.custom.VisualActionImage;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    private static HashMap<String, Integer> a = new HashMap<>();
    private static Type b = new a().b();
    private static Lazy<k0> c = sdk.pendo.io.w5.b.a(k0.class);

    class a extends sdk.pendo.io.g0.a<HashMap<String, PersonalizationDefVal>> {
        a() {
        }
    }

    class b implements sdk.pendo.io.q3.e<Boolean> {
        final /* synthetic */ List a;

        b(List list) {
            this.a = list;
        }

        @Override // sdk.pendo.io.q3.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Boolean bool) {
            PendoCommandDispatcher.getInstance().dispatchCommands(this.a, PendoCommandEventType.UserEventType.TAP_ON, true);
        }
    }

    class c implements sdk.pendo.io.q3.e<Integer> {
        final /* synthetic */ List a;

        c(List list) {
            this.a = list;
        }

        @Override // sdk.pendo.io.q3.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Integer num) {
            PendoCommandDispatcher pendoCommandDispatcher;
            List<PendoCommand> list;
            PendoCommandEventType.FormEventType formEventType;
            if (num.intValue() != -1) {
                PendoCommandDispatcher.getInstance().dispatchCommands(this.a, PendoCommandEventType.FormEventType.ON_SELECTION_CHANGED, true);
                pendoCommandDispatcher = PendoCommandDispatcher.getInstance();
                list = this.a;
                formEventType = PendoCommandEventType.FormEventType.ON_VALID;
            } else {
                pendoCommandDispatcher = PendoCommandDispatcher.getInstance();
                list = this.a;
                formEventType = PendoCommandEventType.FormEventType.ON_INVALID;
            }
            pendoCommandDispatcher.dispatchCommands(list, formEventType, true);
        }
    }

    public static void a(View view, Map<String, sdk.pendo.io.b.c> map) {
        if (view instanceof TextView) {
            a(map, sdk.pendo.io.b.c.b.BACKGROUND.name(), new sdk.pendo.io.b.c((l) new Gson().a("{\"name\": \"background\",\"type\": \"color\",\"value\": \"#FFFFFF00\"}", l.class)));
            a(map, sdk.pendo.io.b.c.b.INCLUDE_FONT_PADDING.name(), new sdk.pendo.io.b.c((l) new Gson().a("{\"name\": \"include_font_padding\",\"type\": \"boolean\",\"value\": \"false\"}", l.class)));
        }
    }

    public static Map<String, sdk.pendo.io.b.c> b(l lVar) {
        HashMap map = new HashMap();
        sdk.pendo.io.a0.f fVarB = lVar.b("properties");
        if (fVarB != null) {
            for (int i = 0; i < fVarB.size(); i++) {
                sdk.pendo.io.b.c cVar = new sdk.pendo.io.b.c(fVarB.a(i).e());
                if (cVar.l()) {
                    map.put(cVar.a.name(), cVar);
                }
            }
        }
        return map;
    }

    public static View a(Context context, l lVar, ViewGroup viewGroup, Class cls, String str, String str2) {
        HashMap map;
        View viewA;
        if (lVar == null || (viewA = a(context, lVar, viewGroup, (HashMap<String, Integer>) (map = new HashMap()), str, str2, (HashMap<String, WeakReference<View>>) new HashMap())) == null) {
            return null;
        }
        if (viewA.getTag(R.animator.chevron_checked_unchecked) != null) {
            sdk.pendo.io.b.a.a(viewA, (Map<String, sdk.pendo.io.b.c>) viewA.getTag(R.animator.chevron_checked_unchecked), viewGroup, (HashMap<String, Integer>) map);
        }
        viewA.setTag(null);
        if (cls != null) {
            try {
                Object objNewInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                sdk.pendo.io.b.a.a(objNewInstance, viewA, (HashMap<String, Integer>) map);
                viewA.setTag(objNewInstance);
                return viewA;
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), "holder class:" + cls.getCanonicalName() + "guideId: " + str + " stepId: " + str2);
            }
        }
        return viewA;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:40:0x00e6 A[Catch: Exception -> 0x011a, TryCatch #3 {Exception -> 0x011a, blocks: (B:38:0x00c1, B:40:0x00e6, B:41:0x0100, B:43:0x0104), top: B:62:0x00c1 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0118  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private static View a(Context context, l lVar, ViewGroup viewGroup, HashMap<String, Integer> map, String str, String str2, HashMap<String, WeakReference<View>> map2) {
        HashMap<String, Integer> map3;
        HashMap<String, WeakReference<View>> map4;
        Map<String, sdk.pendo.io.b.c> mapB;
        Map<String, PersonalizationDefVal> mapA;
        String strA;
        View viewA;
        String str3;
        String str4;
        sdk.pendo.io.b.c cVar;
        View view;
        String strA2;
        int iGenerateViewId;
        HashMap map5 = new HashMap();
        try {
            String strA3 = w.a(lVar, "widget");
            try {
                if (strA3.equals("Swiper")) {
                    return a(context, lVar.b(GuideActionConfiguration.GUIDE_BUILDING_BLOCK_VIEWS).a(0).e(), viewGroup, map, str, str2, map2);
                }
                map3 = map;
                map4 = map2;
                mapB = b(lVar);
                try {
                    a(mapB, strA3);
                    strA = f.a(mapB, strA3);
                    try {
                        viewA = a(context, strA, lVar, viewGroup, str, str2);
                        try {
                            mapA = viewA instanceof TextView ? a(lVar) : null;
                            try {
                                cVar = mapB.get(sdk.pendo.io.b.c.b.POLLTITLEID.name());
                                str3 = str;
                                str4 = str2;
                            } catch (Exception e) {
                                e = e;
                                str3 = str;
                                str4 = str2;
                                PendoLogger.e(e, e.getMessage(), "createViewInternal guideId: " + str3 + " stepId: " + str4);
                                cVar = null;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            mapA = null;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        mapA = null;
                        viewA = null;
                    }
                } catch (Exception e4) {
                    e = e4;
                    mapA = null;
                    strA = null;
                    viewA = null;
                }
                if (viewA == null) {
                    PendoLogger.w("View couldn't be created: " + strA, new Object[0]);
                    return null;
                }
                try {
                    a(viewA, mapB);
                    viewA.setTag(R.animator.chevron_checked_unchecked, mapB);
                    strA2 = sdk.pendo.io.b.a.a(viewA, mapB, mapA);
                    String strC = w.c(lVar, "layoutId");
                    String strC2 = w.c(lVar, "id");
                    iGenerateViewId = View.generateViewId();
                    a(map3, strA2, strC, strC2, iGenerateViewId);
                    if (!TextUtils.isEmpty(strA2)) {
                        a.put(strA2, Integer.valueOf(iGenerateViewId));
                        map4.put(strA2, new WeakReference<>(viewA));
                        viewA.setId(iGenerateViewId);
                        PendoCommandViewHandlerUtility.handlePendoCommandsForView(viewA, strA2);
                        a(iGenerateViewId, cVar, map4);
                    }
                    if ((viewA instanceof ViewGroup) || !lVar.d(GuideActionConfiguration.GUIDE_BUILDING_BLOCK_VIEWS)) {
                        view = viewA;
                    } else {
                        HashMap<String, Integer> map6 = map3;
                        view = viewA;
                        try {
                            a(context, view, lVar, map6, str3, str4, map4);
                            map3 = map6;
                        } catch (Exception e5) {
                            e = e5;
                            map3 = map6;
                            PendoLogger.e(e, e.getMessage(), new Object[0]);
                        }
                    }
                } catch (Exception e6) {
                    e = e6;
                    view = viewA;
                }
                return a(context, view, viewGroup, lVar, map3);
            } catch (Exception e7) {
                e = e7;
                mapB = map5;
            }
        } catch (Exception e8) {
            e = e8;
            map3 = map;
            map4 = map2;
        }
        mapB = map5;
        mapA = null;
        strA = null;
        viewA = null;
        str3 = str;
        str4 = str2;
        PendoLogger.e(e, e.getMessage(), "createViewInternal guideId: " + str3 + " stepId: " + str4);
        cVar = null;
        if (viewA == null) {
            PendoLogger.w("View couldn't be created: " + strA, new Object[0]);
            return null;
        }
        a(viewA, mapB);
        viewA.setTag(R.animator.chevron_checked_unchecked, mapB);
        strA2 = sdk.pendo.io.b.a.a(viewA, mapB, mapA);
        String strC3 = w.c(lVar, "layoutId");
        String strC4 = w.c(lVar, "id");
        iGenerateViewId = View.generateViewId();
        a(map3, strA2, strC3, strC4, iGenerateViewId);
        if (!TextUtils.isEmpty(strA2)) {
            a.put(strA2, Integer.valueOf(iGenerateViewId));
            map4.put(strA2, new WeakReference<>(viewA));
            viewA.setId(iGenerateViewId);
            PendoCommandViewHandlerUtility.handlePendoCommandsForView(viewA, strA2);
            a(iGenerateViewId, cVar, map4);
        }
        if (viewA instanceof ViewGroup) {
            view = viewA;
        } else {
            view = viewA;
        }
        return a(context, view, viewGroup, lVar, map3);
    }

    public static void a(Map<String, sdk.pendo.io.b.c> map, String str) {
        if (str.equals("RowBlock")) {
            sdk.pendo.io.b.c cVar = new sdk.pendo.io.b.c((l) new Gson().a("{\"name\": \"orientation\",\"type\": \"string\",\"value\": \"horizontal\"}", l.class));
            map.put(cVar.a.name(), cVar);
        }
    }

    public static HashMap<String, Integer> a() {
        return a;
    }

    public static Map<String, PersonalizationDefVal> a(l lVar) {
        i iVarA;
        if (lVar != null && (iVarA = lVar.a(GuideActionConfiguration.GUIDE_SCREEN_PERSONALIZATION)) != null) {
            try {
                return (Map) c.getValue().a().a(iVarA, b);
            } catch (m unused) {
                PendoLogger.d("initDefaultValuesForView - fromJson failed: " + iVarA, new Object[0]);
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void a(View view, l lVar, String str) {
        sdk.pendo.io.a0.f fVarB = w.b(lVar, "actions");
        if (fVarB == null || fVarB.size() <= 0) {
            return;
        }
        List<PendoCommand> pendoCommands = PendoCommand.getPendoCommands(fVarB);
        String currentStepId = StepSeenManager.getInstance().getCurrentStepId();
        for (PendoCommand pendoCommand : pendoCommands) {
            pendoCommand.addParameter(PendoCommandAction.PendoCommandGlobalAction.PendoInfoConsts.createPendoMetadataParam(str));
            JavascriptRunner.GuideContext context = pendoCommand.getContext();
            if (context == null) {
                context = new JavascriptRunner.GuideContext(str);
                pendoCommand.setContext(context);
            } else if (context.getGuideId() == null) {
                context.set("guideId", str);
            }
            if (((String) context.get(VisualGuideBase.GUIDE_STEP_ID_PARAMETER_NAME, String.class)) == null && currentStepId != null) {
                context.set(VisualGuideBase.GUIDE_STEP_ID_PARAMETER_NAME, currentStepId);
            }
        }
        if (view instanceof ActionableBlock) {
            ((ActionableBlock) view).setActions(pendoCommands);
        }
        if (view instanceof PendoForm) {
            ((PendoForm) view).processForm(lVar, pendoCommands, str);
        } else if (view instanceof RadioButton) {
            sdk.pendo.io.r4.c.a((CompoundButton) view).a(sdk.pendo.io.t4.g.a(view)).b(1L).a((o) sdk.pendo.io.t6.d.a(new b(pendoCommands), "DynamicView RxCompoundButton isChecked observer"));
        } else if (view instanceof RadioGroup) {
            sdk.pendo.io.r4.e.a((RadioGroup) view).a(sdk.pendo.io.t4.g.a(view)).b(1L).a((o) sdk.pendo.io.t6.d.a(new c(pendoCommands), "DynamicView RxRadioGroup checkedId observer"));
        }
    }

    private static void a(Context context, View view, l lVar, HashMap<String, Integer> map, String str, String str2, HashMap<String, WeakReference<View>> map2) {
        ViewGroup viewGroup = (ViewGroup) view;
        ArrayList<View> arrayList = new ArrayList();
        sdk.pendo.io.a0.f fVarB = lVar.b(GuideActionConfiguration.GUIDE_BUILDING_BLOCK_VIEWS);
        if (fVarB != null) {
            int size = fVarB.size();
            int i = 0;
            while (i < size) {
                ViewGroup viewGroup2 = viewGroup;
                View viewA = a(context, fVarB.a(i).e(), viewGroup2, map, str, str2, map2);
                if (viewA == null || viewA.getParent() != null) {
                    PendoLogger.e("Error: Cannot create view: " + fVarB.a(i).e(), new Object[0]);
                } else {
                    arrayList.add(viewA);
                    viewGroup2.addView(viewA);
                }
                i++;
                viewGroup = viewGroup2;
            }
        }
        ViewGroup viewGroup3 = viewGroup;
        for (View view2 : arrayList) {
            Map map3 = (Map) view2.getTag(R.animator.chevron_checked_unchecked);
            if (map3 != null) {
                sdk.pendo.io.b.a.a(view2, (Map<String, sdk.pendo.io.b.c>) map3, viewGroup3, map);
                view2.setTag(R.animator.chevron_checked_unchecked, null);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0048  */
    private static View a(Context context, String str, l lVar, ViewGroup viewGroup, String str2, String str3) {
        View pendoRegularRadioButton;
        View view;
        str.hashCode();
        if (!str.equals("sdk.pendo.io.views.custom.PendoRegularRadioButton")) {
            if (str.equals("sdk.pendo.io.views.custom.VisualActionImage")) {
                pendoRegularRadioButton = str3.isEmpty() ? new VisualActionImage(context, str2) : new VisualActionImage(context, str3);
            } else {
                view = (View) Class.forName(str).getConstructor(Context.class).newInstance(context);
            }
            if (view != null) {
                a(view, lVar, str2);
                view.setLayoutParams(sdk.pendo.io.b.a.a(viewGroup));
            }
            return view;
        }
        pendoRegularRadioButton = new PendoRegularRadioButton(context);
        view = pendoRegularRadioButton;
        if (view != null) {
            a(view, lVar, str2);
            view.setLayoutParams(sdk.pendo.io.b.a.a(viewGroup));
        }
        return view;
    }

    private static void a(Map<String, sdk.pendo.io.b.c> map, String str, sdk.pendo.io.b.c cVar) {
        if (map.get(str) == null) {
            map.put(str, cVar);
        }
    }

    private static void a(int i, sdk.pendo.io.b.c cVar, HashMap<String, WeakReference<View>> map) {
        WeakReference<View> weakReference;
        if (cVar == null || cVar.j() == null) {
            return;
        }
        String strJ = cVar.j();
        if (!map.containsKey(strJ) || (weakReference = map.get(strJ)) == null || weakReference.get() == null) {
            return;
        }
        weakReference.get().setLabelFor(i);
    }

    private static void a(HashMap<String, Integer> map, String str, String str2, String str3, int i) {
        if (!TextUtils.isEmpty(str)) {
            map.put(str, Integer.valueOf(i));
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put(str2, Integer.valueOf(i));
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        map.put(str3, Integer.valueOf(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static View a(Context context, View view, ViewGroup viewGroup, l lVar, HashMap<String, Integer> map) {
        if (!w.a(lVar, "scrollable", false)) {
            return view;
        }
        boolean zEquals = "fill".equals(w.a(lVar, "scrollMode", "fill"));
        PendoScrollView pendoScrollView = new PendoScrollView(context);
        pendoScrollView.setLayoutParams(sdk.pendo.io.b.a.a(viewGroup));
        pendoScrollView.setFillViewport(zEquals);
        pendoScrollView.setId(view.getId());
        view.setId(View.generateViewId());
        pendoScrollView.addView(view);
        Map map2 = (Map) view.getTag(R.animator.chevron_checked_unchecked);
        pendoScrollView.setTag(R.animator.chevron_checked_unchecked, map2);
        if (map2 != null) {
            sdk.pendo.io.b.a.a(view, (Map<String, sdk.pendo.io.b.c>) map2, pendoScrollView, map);
            if (view instanceof IBackgroundRenderView) {
                ((IBackgroundRenderView) view).setImageBackgroundURL(null);
                view.setBackground(null);
                sdk.pendo.io.b.a.a(pendoScrollView, (Map<String, sdk.pendo.io.b.c>) map2);
            }
            view.setTag(R.animator.chevron_checked_unchecked, null);
        }
        return pendoScrollView;
    }
}
