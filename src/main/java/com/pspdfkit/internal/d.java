package com.pspdfkit.internal;

import android.util.Pair;
import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.ActionAccessors;
import com.pspdfkit.annotations.actions.ActionType;
import com.pspdfkit.annotations.actions.AnnotationTriggerEvent;
import com.pspdfkit.annotations.actions.GoToAction;
import com.pspdfkit.annotations.actions.GoToEmbeddedAction;
import com.pspdfkit.annotations.actions.GoToRemoteAction;
import com.pspdfkit.annotations.actions.HideAction;
import com.pspdfkit.annotations.actions.JavaScriptAction;
import com.pspdfkit.annotations.actions.LaunchAction;
import com.pspdfkit.annotations.actions.NamedAction;
import com.pspdfkit.annotations.actions.RenditionAction;
import com.pspdfkit.annotations.actions.ResetFormAction;
import com.pspdfkit.annotations.actions.RichMediaExecuteAction;
import com.pspdfkit.annotations.actions.SubmitFormAction;
import com.pspdfkit.annotations.actions.UriAction;
import com.pspdfkit.document.DestinationType;
import com.pspdfkit.utils.PdfLog;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[ActionType.values().length];
            try {
                iArr[ActionType.GOTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ActionType.GOTO_REMOTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ActionType.GOTO_EMBEDDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ActionType.LAUNCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ActionType.URI.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ActionType.HIDE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ActionType.NAMED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ActionType.SUBMIT_FORM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ActionType.RESET_FORM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ActionType.RENDITION.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[ActionType.RICH_MEDIA_EXECUTE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[ActionType.IMPORT_DATA.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[ActionType.JAVASCRIPT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            a = iArr;
            int[] iArr2 = new int[AnnotationTriggerEvent.values().length];
            try {
                iArr2[AnnotationTriggerEvent.CURSOR_ENTERS.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[AnnotationTriggerEvent.CURSOR_EXITS.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[AnnotationTriggerEvent.MOUSE_DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr2[AnnotationTriggerEvent.MOUSE_UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[AnnotationTriggerEvent.RECEIVE_FOCUS.ordinal()] = 5;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr2[AnnotationTriggerEvent.LOOSE_FOCUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr2[AnnotationTriggerEvent.PAGE_OPENED.ordinal()] = 7;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr2[AnnotationTriggerEvent.PAGE_CLOSED.ordinal()] = 8;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr2[AnnotationTriggerEvent.PAGE_VISIBLE.ordinal()] = 9;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr2[AnnotationTriggerEvent.FORM_CHANGED.ordinal()] = 10;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr2[AnnotationTriggerEvent.FIELD_FORMAT.ordinal()] = 11;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr2[AnnotationTriggerEvent.FORM_VALIDATE.ordinal()] = 12;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr2[AnnotationTriggerEvent.FORM_CALCULATE.ordinal()] = 13;
            } catch (NoSuchFieldError unused26) {
            }
            b = iArr2;
            int[] iArr3 = new int[DestinationType.values().length];
            try {
                iArr3[DestinationType.FitPage.ordinal()] = 1;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr3[DestinationType.OriginAndZoom.ordinal()] = 2;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr3[DestinationType.FitWidth.ordinal()] = 3;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr3[DestinationType.FitHeight.ordinal()] = 4;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr3[DestinationType.FitRectangle.ordinal()] = 5;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr3[DestinationType.FitPageBoundingBox.ordinal()] = 6;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr3[DestinationType.FitPageBoundingBoxWidth.ordinal()] = 7;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr3[DestinationType.FitPageBoundingBoxHeight.ordinal()] = 8;
            } catch (NoSuchFieldError unused34) {
            }
            c = iArr3;
        }
    }

    public static final Pair<AnnotationTriggerEvent, Action> a(s0 s0Var) {
        if (s0Var == null) {
            return null;
        }
        int iA = s0Var.a(4);
        AnnotationTriggerEvent annotationTriggerEventA = a(iA != 0 ? s0Var.b.getShort(iA + s0Var.a) : (short) 0);
        b bVar = new b();
        int iA2 = s0Var.a(6);
        if (iA2 != 0) {
            int i = iA2 + s0Var.a;
            int i2 = s0Var.b.getInt(i) + i;
            ByteBuffer byteBuffer = s0Var.b;
            byteBuffer.getClass();
            bVar.a(i2, byteBuffer);
        } else {
            bVar = null;
        }
        Action actionA = a(bVar);
        if (actionA == null) {
            return null;
        }
        return new Pair<>(annotationTriggerEventA, actionA);
    }

    public static final p a(t0 t0Var) {
        int iA = t0Var.a(4);
        int iD = iA != 0 ? t0Var.d(iA) : 0;
        if (iD == 0) {
            return null;
        }
        p pVar = new p(iD);
        for (int i = 0; i < iD; i++) {
            s0 s0Var = new s0();
            int iA2 = t0Var.a(4);
            if (iA2 != 0) {
                int iC = (i * 4) + t0Var.c(iA2);
                int i2 = t0Var.b.getInt(iC) + iC;
                ByteBuffer byteBuffer = t0Var.b;
                byteBuffer.getClass();
                s0Var.a(i2, byteBuffer);
            } else {
                s0Var = null;
            }
            Pair<AnnotationTriggerEvent, Action> pairA = a(s0Var);
            if (pairA != null) {
                Object obj = pairA.first;
                obj.getClass();
                AnnotationTriggerEvent annotationTriggerEvent = (AnnotationTriggerEvent) obj;
                Action action = (Action) pairA.second;
                HashMap<AnnotationTriggerEvent, Action> map = pVar.a;
                if (action == null) {
                    map.remove(annotationTriggerEvent);
                } else {
                    map.put(annotationTriggerEvent, action);
                }
            }
        }
        return pVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final Integer a(p pVar, yg ygVar) {
        if (pVar.a.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Set<Map.Entry<AnnotationTriggerEvent, Action>> setEntrySet = pVar.a.entrySet();
        setEntrySet.getClass();
        Iterator<Map.Entry<AnnotationTriggerEvent, Action>> it = setEntrySet.iterator();
        while (true) {
            short s = 4;
            if (it.hasNext()) {
                Map.Entry<AnnotationTriggerEvent, Action> next = it.next();
                AnnotationTriggerEvent key = next.getKey();
                Action value = next.getValue();
                Integer numA = a(value, ygVar);
                if (numA == null) {
                    PdfLog.e("Nutri.ActFlatbuffConvs", "Unsupported action type for writing to flatbuffers: " + value.getType().name(), new Object[0]);
                } else {
                    ygVar.d(2);
                    switch (a.b[key.ordinal()]) {
                        case 1:
                            s = 0;
                            ygVar.a(0, s);
                            ygVar.b(1, numA.intValue());
                            arrayList.add(Integer.valueOf(ygVar.a()));
                            break;
                        case 2:
                            s = 1;
                            ygVar.a(0, s);
                            ygVar.b(1, numA.intValue());
                            arrayList.add(Integer.valueOf(ygVar.a()));
                            break;
                        case 3:
                            s = 2;
                            ygVar.a(0, s);
                            ygVar.b(1, numA.intValue());
                            arrayList.add(Integer.valueOf(ygVar.a()));
                            break;
                        case 4:
                            s = 3;
                            ygVar.a(0, s);
                            ygVar.b(1, numA.intValue());
                            arrayList.add(Integer.valueOf(ygVar.a()));
                            break;
                        case 5:
                            ygVar.a(0, s);
                            ygVar.b(1, numA.intValue());
                            arrayList.add(Integer.valueOf(ygVar.a()));
                            break;
                        case 6:
                            s = 5;
                            ygVar.a(0, s);
                            ygVar.b(1, numA.intValue());
                            arrayList.add(Integer.valueOf(ygVar.a()));
                            break;
                        case 7:
                            s = 6;
                            ygVar.a(0, s);
                            ygVar.b(1, numA.intValue());
                            arrayList.add(Integer.valueOf(ygVar.a()));
                            break;
                        case 8:
                            s = 7;
                            ygVar.a(0, s);
                            ygVar.b(1, numA.intValue());
                            arrayList.add(Integer.valueOf(ygVar.a()));
                            break;
                        case 9:
                            s = 8;
                            ygVar.a(0, s);
                            ygVar.b(1, numA.intValue());
                            arrayList.add(Integer.valueOf(ygVar.a()));
                            break;
                        case 10:
                            s = 9;
                            ygVar.a(0, s);
                            ygVar.b(1, numA.intValue());
                            arrayList.add(Integer.valueOf(ygVar.a()));
                            break;
                        case 11:
                            s = 10;
                            ygVar.a(0, s);
                            ygVar.b(1, numA.intValue());
                            arrayList.add(Integer.valueOf(ygVar.a()));
                            break;
                        case 12:
                            s = 11;
                            ygVar.a(0, s);
                            ygVar.b(1, numA.intValue());
                            arrayList.add(Integer.valueOf(ygVar.a()));
                            break;
                        case 13:
                            s = 12;
                            ygVar.a(0, s);
                            ygVar.b(1, numA.intValue());
                            arrayList.add(Integer.valueOf(ygVar.a()));
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                }
            } else {
                if (arrayList.isEmpty()) {
                    return null;
                }
                int[] intArray = CollectionsKt.toIntArray(arrayList);
                intArray.getClass();
                ygVar.a(4, intArray.length, 4);
                for (int length = intArray.length - 1; -1 < length; length--) {
                    ygVar.a(intArray[length]);
                }
                return Integer.valueOf(ygVar.b());
            }
        }
    }

    public static final <T extends h50> T a(b bVar, T t) {
        int iA = bVar.a(10);
        if (iA != 0) {
            int i = iA + bVar.a;
            ByteBuffer byteBuffer = bVar.b;
            t.a(byteBuffer.getInt(i) + i, byteBuffer);
        } else {
            t = null;
        }
        t.getClass();
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.pspdfkit.annotations.actions.ActionAccessors$Companion] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12, types: [com.pspdfkit.internal.h50] */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r16v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v9 */
    /* JADX WARN: Type inference failed for: r1v11, types: [com.pspdfkit.annotations.actions.ActionAccessors$Companion] */
    /* JADX WARN: Type inference failed for: r1v13, types: [com.pspdfkit.annotations.actions.ActionAccessors$Companion] */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.pspdfkit.annotations.actions.ActionAccessors$Companion] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v33, types: [com.pspdfkit.annotations.actions.ActionAccessors$Companion] */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v43, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.util.List] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final Action a(b bVar) {
        ?? arrayList;
        int iD;
        int i;
        RichMediaExecuteAction.RichMediaExecuteActionType key;
        Object objB;
        int iD2;
        int i2;
        int iD3;
        int i3;
        ?? r10;
        String strB;
        NamedAction.NamedActionType key2;
        String strB2 = null;
        if (bVar == null) {
            return null;
        }
        int iA = bVar.a(12);
        if ((iA != 0 ? bVar.d(iA) : 0) == 0) {
            arrayList = CollectionsKt.emptyList();
        } else {
            int iA2 = bVar.a(12);
            arrayList = new ArrayList(iA2 != 0 ? bVar.d(iA2) : 0);
            int iA3 = bVar.a(12);
            if (iA3 != 0) {
                iD = bVar.d(iA3);
                i = 0;
            } else {
                iD = 0;
                i = 0;
            }
            while (i < iD) {
                b bVar2 = new b();
                int iA4 = bVar.a(12);
                if (iA4 != 0) {
                    int iC = (i * 4) + bVar.c(iA4);
                    int i4 = bVar.b.getInt(iC) + iC;
                    ByteBuffer byteBuffer = bVar.b;
                    byteBuffer.getClass();
                    bVar2.a(i4, byteBuffer);
                } else {
                    bVar2 = null;
                }
                Action actionA = a(bVar2);
                if (actionA != null) {
                    arrayList.add(actionA);
                }
                i++;
            }
        }
        ?? EmptyList = arrayList;
        int iA5 = bVar.a(4);
        short s = iA5 != 0 ? bVar.b.getShort(iA5 + bVar.a) : (short) 0;
        if (s == 1) {
            bj bjVar = (bj) a(bVar, new bj());
            int iA6 = bjVar.a(4);
            return new GoToAction((int) (iA6 != 0 ? bjVar.b.getLong(iA6 + bjVar.a) : 0L), EmptyList, null, 4, null);
        }
        if (s == 2) {
            hj hjVar = (hj) a(bVar, new hj());
            int iA7 = hjVar.a(4);
            String strB3 = iA7 != 0 ? hjVar.b(iA7 + hjVar.a) : null;
            int iA8 = hjVar.a(6);
            return new GoToRemoteAction(strB3, (int) (iA8 != 0 ? hjVar.b.getLong(iA8 + hjVar.a) : 0L), EmptyList, null, 8, null);
        }
        if (s == 3) {
            dj djVar = (dj) a(bVar, new dj());
            ?? r2 = ActionAccessors.INSTANCE;
            int iA9 = djVar.a(6);
            strB2 = iA9 != 0 ? djVar.b(iA9 + djVar.a) : null;
            int iA10 = djVar.a(8);
            int i5 = (int) (iA10 != 0 ? djVar.b.getLong(iA10 + djVar.a) : 0L);
            int iA11 = djVar.a(4);
            return r2.createGoToEmbeddedAction(strB2, i5, (iA11 != 0 ? djVar.b.get(iA11 + djVar.a) : (byte) 0) == 0, EmptyList);
        }
        if (s == 6) {
            v60 v60Var = (v60) a(bVar, new v60());
            int iA12 = v60Var.a(4);
            return new UriAction(iA12 != 0 ? v60Var.b(iA12 + v60Var.a) : null, EmptyList);
        }
        if (s == 4) {
            jn jnVar = (jn) a(bVar, new jn());
            int iA13 = jnVar.a(4);
            return new LaunchAction(iA13 != 0 ? jnVar.b(iA13 + jnVar.a) : null, EmptyList);
        }
        if (s == 10) {
            er erVar = (er) a(bVar, new er());
            int iA14 = erVar.a(4);
            strB2 = iA14 != 0 ? erVar.b(iA14 + erVar.a) : null;
            if (strB2 != null) {
                for (Map.Entry<NamedAction.NamedActionType, String> entry : gr.a.entrySet()) {
                    if (Intrinsics.areEqual(entry.getValue(), strB2)) {
                        key2 = entry.getKey();
                        return new NamedAction(key2, EmptyList);
                    }
                }
                key2 = NamedAction.NamedActionType.UNKNOWN;
                return new NamedAction(key2, EmptyList);
            }
            throw new IllegalStateException("Flatbuffers error: named action is null");
        }
        if (s == 9) {
            kj kjVar = (kj) a(bVar, new kj());
            int iA15 = kjVar.a(4);
            ArrayList arrayList2 = new ArrayList(iA15 != 0 ? kjVar.d(iA15) : 0);
            int iA16 = kjVar.a(4);
            if (iA16 != 0) {
                iD3 = kjVar.d(iA16);
                i3 = 0;
            } else {
                iD3 = 0;
                i3 = 0;
            }
            while (i3 < iD3) {
                e4 e4Var = new e4();
                int iA17 = kjVar.a(4);
                if (iA17 != 0) {
                    int iC2 = (i3 * 4) + kjVar.c(iA17);
                    int i6 = kjVar.b.getInt(iC2) + iC2;
                    ByteBuffer byteBuffer2 = kjVar.b;
                    byteBuffer2.getClass();
                    e4Var.a(i6, byteBuffer2);
                } else {
                    r10 = strB2;
                }
                if (r10 != 0) {
                    int iA18 = r10.a(4);
                    if (iA18 != 0) {
                        r10 = e4Var;
                        strB = r10.b(iA18 + r10.a);
                    } else {
                        r10 = e4Var;
                        strB = strB2;
                    }
                    int iA19 = r10.a(6);
                    int i7 = iA19 != 0 ? r10.b.getInt(iA19 + r10.a) : 0;
                    int iA20 = r10.a(8);
                    arrayList2.add(new f4(strB, i7, iA20 != 0 ? r10.b.getInt(iA20 + r10.a) : 0));
                } else {
                    r10 = e4Var;
                    strB2 = strB2;
                }
                i3++;
                strB2 = strB2;
            }
            ?? r1 = ActionAccessors.INSTANCE;
            int iA21 = kjVar.a(6);
            boolean z = iA21 == 0 || kjVar.b.get(iA21 + kjVar.a) != 0;
            if (EmptyList == 0) {
                EmptyList = CollectionsKt.emptyList();
            }
            return r1.createHideAction(arrayList2, z, EmptyList);
        }
        Integer numValueOf = null;
        if (s == 12) {
            fz fzVar = (fz) a(bVar, new fz());
            Map<SubmitFormAction.SubmitFormActionFlag, ULong> map = gh.a;
            int iA22 = fzVar.a(4);
            ArrayList arrayList3 = new ArrayList(iA22 != 0 ? fzVar.d(iA22) : 0);
            int iA23 = fzVar.a(4);
            if (iA23 != 0) {
                iD2 = fzVar.d(iA23);
                i2 = 0;
            } else {
                iD2 = 0;
                i2 = 0;
            }
            while (i2 < iD2) {
                e4 e4Var2 = new e4();
                int iA24 = fzVar.a(4);
                if (iA24 != 0) {
                    int iC3 = (i2 * 4) + fzVar.c(iA24);
                    int i8 = fzVar.b.getInt(iC3) + iC3;
                    ByteBuffer byteBuffer3 = fzVar.b;
                    byteBuffer3.getClass();
                    e4Var2.a(i8, byteBuffer3);
                } else {
                    e4Var2 = null;
                }
                if (e4Var2 != null) {
                    int iA25 = e4Var2.a(4);
                    String strB4 = iA25 != 0 ? e4Var2.b(iA25 + e4Var2.a) : null;
                    if (strB4 != null) {
                        arrayList3.add(strB4);
                    }
                }
                i2++;
            }
            int iA26 = fzVar.a(6);
            boolean z2 = UInt.m14875constructorimpl((iA26 != 0 ? UInt.m14875constructorimpl(fzVar.b.getInt(iA26 + fzVar.a)) : 0) & 1) != 0;
            ?? EmptyList2 = EmptyList;
            if (EmptyList == 0) {
                EmptyList2 = CollectionsKt.emptyList();
            }
            return new ResetFormAction(arrayList3, z2, EmptyList2);
        }
        ?? r3 = "";
        if (s == 11) {
            a50 a50Var = (a50) a(bVar, new a50());
            Map<SubmitFormAction.SubmitFormActionFlag, ULong> map2 = gh.a;
            int iA27 = a50Var.a(6);
            ArrayList arrayList4 = new ArrayList(iA27 != 0 ? a50Var.d(iA27) : 0);
            int iA28 = a50Var.a(6);
            int iD4 = iA28 != 0 ? a50Var.d(iA28) : 0;
            for (int i9 = 0; i9 < iD4; i9++) {
                e4 e4Var3 = new e4();
                int iA29 = a50Var.a(6);
                if (iA29 != 0) {
                    int iC4 = (i9 * 4) + a50Var.c(iA29);
                    int i10 = a50Var.b.getInt(iC4) + iC4;
                    ByteBuffer byteBuffer4 = a50Var.b;
                    byteBuffer4.getClass();
                    e4Var3.a(i10, byteBuffer4);
                } else {
                    e4Var3 = null;
                }
                if (e4Var3 != null) {
                    int iA30 = e4Var3.a(4);
                    String strB5 = iA30 != 0 ? e4Var3.b(iA30 + e4Var3.a) : null;
                    if (strB5 != null) {
                        arrayList4.add(strB5);
                    }
                }
            }
            int iA31 = a50Var.a(4);
            ?? B = numValueOf;
            if (iA31 != 0) {
                B = a50Var.b(iA31 + a50Var.a);
            }
            Charset charset = u40.a;
            ?? string = r3;
            if (B != 0) {
                string = B.toString();
            }
            string.getClass();
            int iA32 = a50Var.a(8);
            long jM14954constructorimpl = iA32 != 0 ? ULong.m14954constructorimpl(a50Var.b.getLong(iA32 + a50Var.a)) : 0L;
            EnumSet enumSetNoneOf = EnumSet.noneOf(SubmitFormAction.SubmitFormActionFlag.class);
            for (Map.Entry<SubmitFormAction.SubmitFormActionFlag, ULong> entry2 : gh.a.entrySet()) {
                SubmitFormAction.SubmitFormActionFlag key3 = entry2.getKey();
                if (ULong.m14954constructorimpl(entry2.getValue().getData() & jM14954constructorimpl) != 0) {
                    enumSetNoneOf.add(key3);
                }
            }
            enumSetNoneOf.getClass();
            ?? EmptyList3 = EmptyList;
            if (EmptyList == 0) {
                EmptyList3 = CollectionsKt.emptyList();
            }
            return new SubmitFormAction(string, arrayList4, enumSetNoneOf, EmptyList3);
        }
        if (s == 14) {
            xm xmVar = (xm) a(bVar, new xm());
            int iA33 = xmVar.a(4);
            if (iA33 != 0) {
                objB = numValueOf;
                objB = xmVar.b(iA33 + xmVar.a);
            }
            return new JavaScriptAction(objB != null ? objB : "", EmptyList);
        }
        if (s == 16) {
            bz bzVar = (bz) a(bVar, new bz());
            ?? r4 = ActionAccessors.INSTANCE;
            RenditionAction.RenditionActionType.Companion companion = RenditionAction.RenditionActionType.INSTANCE;
            int iA34 = bzVar.a(4);
            RenditionAction.RenditionActionType renditionActionTypeFromValue = companion.fromValue(iA34 != 0 ? bzVar.b.getInt(iA34 + bzVar.a) : 0);
            e4 e4Var4 = new e4();
            int iA35 = bzVar.a(6);
            if (iA35 != 0) {
                int i11 = iA35 + bzVar.a;
                int i12 = bzVar.b.getInt(i11) + i11;
                ByteBuffer byteBuffer5 = bzVar.b;
                byteBuffer5.getClass();
                e4Var4.a(i12, byteBuffer5);
            } else {
                e4Var4 = null;
            }
            if (e4Var4 != null) {
                int iA36 = e4Var4.a(6);
                int i13 = iA36 != 0 ? e4Var4.b.getInt(iA36 + e4Var4.a) : 0;
                int iA37 = bzVar.a(8);
                return r4.createRenditionAction(renditionActionTypeFromValue, i13, iA37 != 0 ? bzVar.b(iA37 + bzVar.a) : null, EmptyList);
            }
            throw new IllegalArgumentException("Required value was null.");
        }
        if (s != 19) {
            if (s == 13) {
                return ActionAccessors.INSTANCE.createImportDataAction(EmptyList);
            }
            int iA38 = bVar.a(4);
            PdfLog.e("Nutri.ActFlatbuffConvs", "Unsupported action type. ID: " + ((int) (iA38 != 0 ? bVar.b.getShort(iA38 + bVar.a) : (short) 0)), new Object[0]);
            return null;
        }
        pz pzVar = (pz) a(bVar, new pz());
        ?? r5 = ActionAccessors.INSTANCE;
        int iA39 = pzVar.a(6);
        String strB6 = iA39 != 0 ? pzVar.b(iA39 + pzVar.a) : null;
        if (strB6 == null) {
            Map<RichMediaExecuteAction.RichMediaExecuteActionType, String> map3 = dr.a;
            key = RichMediaExecuteAction.RichMediaExecuteActionType.UNKNOWN;
        } else {
            Iterator<Map.Entry<RichMediaExecuteAction.RichMediaExecuteActionType, String>> it = dr.a.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<RichMediaExecuteAction.RichMediaExecuteActionType, String> next = it.next();
                    if (Intrinsics.areEqual(next.getValue(), strB6)) {
                        key = next.getKey();
                        break;
                    }
                } else {
                    key = RichMediaExecuteAction.RichMediaExecuteActionType.UNKNOWN;
                    break;
                }
            }
        }
        e4 e4Var5 = new e4();
        int iA40 = pzVar.a(4);
        if (iA40 != 0) {
            int i14 = iA40 + pzVar.a;
            int i15 = pzVar.b.getInt(i14) + i14;
            ByteBuffer byteBuffer6 = pzVar.b;
            byteBuffer6.getClass();
            e4Var5.a(i15, byteBuffer6);
        } else {
            e4Var5 = null;
        }
        if (e4Var5 != null) {
            int iA41 = e4Var5.a(6);
            numValueOf = Integer.valueOf(iA41 != 0 ? e4Var5.b.getInt(iA41 + e4Var5.a) : 0);
        }
        if (numValueOf != null) {
            return r5.createRichMediaExecuteAction(key, numValueOf.intValue(), EmptyList);
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public static final p a(g3 g3Var) {
        int iA = g3Var.a(30);
        int iD = iA != 0 ? g3Var.d(iA) : 0;
        if (iD == 0) {
            return null;
        }
        p pVar = new p(iD);
        for (int i = 0; i < iD; i++) {
            s0 s0Var = new s0();
            int iA2 = g3Var.a(30);
            if (iA2 != 0) {
                int iC = (i * 4) + g3Var.c(iA2);
                int i2 = g3Var.b.getInt(iC) + iC;
                ByteBuffer byteBuffer = g3Var.b;
                byteBuffer.getClass();
                s0Var.a(i2, byteBuffer);
            } else {
                s0Var = null;
            }
            Pair<AnnotationTriggerEvent, Action> pairA = a(s0Var);
            if (pairA != null) {
                Object obj = pairA.first;
                obj.getClass();
                AnnotationTriggerEvent annotationTriggerEvent = (AnnotationTriggerEvent) obj;
                Action action = (Action) pairA.second;
                HashMap<AnnotationTriggerEvent, Action> map = pVar.a;
                if (action == null) {
                    map.remove(annotationTriggerEvent);
                } else {
                    map.put(annotationTriggerEvent, action);
                }
            }
        }
        return pVar;
    }

    /* JADX WARN: Code duplicated, block: B:93:0x03dc A[LOOP:1: B:92:0x03da->B:93:0x03dc, LOOP_END] */
    public static final Integer a(Action action, yg ygVar) {
        int i;
        int iA;
        int[] intArray;
        int length;
        if (action == null) {
            return null;
        }
        List<Action> subActions = action.getSubActions();
        ArrayList arrayList = new ArrayList(subActions.size());
        if (!subActions.isEmpty()) {
            int size = subActions.size();
            for (int i2 = 0; i2 < size; i2++) {
                Integer numA = a(subActions.get(i2), ygVar);
                if (numA != null) {
                    arrayList.add(numA);
                }
            }
        }
        if (action instanceof GoToAction) {
            GoToAction goToAction = (GoToAction) action;
            long pageIndex = goToAction.getPageIndex();
            short sA = a(goToAction.getDestination().getType());
            float left = goToAction.getDestination().getLeft();
            float top = goToAction.getDestination().getTop();
            float width = goToAction.getDestination().getWidth();
            float height = goToAction.getDestination().getHeight();
            float zoom = goToAction.getDestination().getZoom();
            ygVar.d(7);
            ygVar.a(0, pageIndex);
            ygVar.a(6, zoom);
            ygVar.a(5, height);
            ygVar.a(4, width);
            ygVar.a(3, top);
            ygVar.a(2, left);
            ygVar.a(1, sA);
            iA = ygVar.a();
        } else if (action instanceof GoToRemoteAction) {
            GoToRemoteAction goToRemoteAction = (GoToRemoteAction) action;
            int iA2 = ygVar.a(goToRemoteAction.getPdfPath());
            long pageIndex2 = goToRemoteAction.getPageIndex();
            short sA2 = a(goToRemoteAction.getDestination().getType());
            float left2 = goToRemoteAction.getDestination().getLeft();
            float top2 = goToRemoteAction.getDestination().getTop();
            float width2 = goToRemoteAction.getDestination().getWidth();
            float height2 = goToRemoteAction.getDestination().getHeight();
            float zoom2 = goToRemoteAction.getDestination().getZoom();
            ygVar.d(8);
            ygVar.a(1, pageIndex2);
            ygVar.a(7, zoom2);
            ygVar.a(6, height2);
            ygVar.a(5, width2);
            ygVar.a(4, top2);
            ygVar.a(3, left2);
            ygVar.b(0, iA2);
            ygVar.a(2, sA2);
            iA = ygVar.a();
        } else if (action instanceof GoToEmbeddedAction) {
            GoToEmbeddedAction goToEmbeddedAction = (GoToEmbeddedAction) action;
            boolean z = !goToEmbeddedAction.getIsNewWindow();
            int iA3 = ygVar.a(goToEmbeddedAction.getPdfPath());
            long pageIndex3 = goToEmbeddedAction.getPageIndex();
            short sA3 = a(goToEmbeddedAction.getDestination().getType());
            float left3 = goToEmbeddedAction.getDestination().getLeft();
            float top3 = goToEmbeddedAction.getDestination().getTop();
            float width3 = goToEmbeddedAction.getDestination().getWidth();
            float height3 = goToEmbeddedAction.getDestination().getHeight();
            float zoom3 = goToEmbeddedAction.getDestination().getZoom();
            ygVar.d(10);
            ygVar.a(2, pageIndex3);
            ygVar.a(8, zoom3);
            ygVar.a(7, height3);
            ygVar.a(6, width3);
            ygVar.a(5, top3);
            ygVar.a(4, left3);
            ygVar.b(1, iA3);
            ygVar.a(3, sA3);
            ygVar.a(9, (byte) 0);
            ygVar.a(0, z ? (byte) 1 : (byte) 0);
            iA = ygVar.a();
        } else {
            if (action instanceof UriAction) {
                int iA4 = ygVar.a(((UriAction) action).getUri());
                i = 1;
                ygVar.d(1);
                ygVar.b(0, iA4);
                iA = ygVar.a();
            } else if (action instanceof LaunchAction) {
                int iA5 = ygVar.a(((LaunchAction) action).getPath());
                ygVar.d(1);
                ygVar.b(0, iA5);
                iA = ygVar.a();
            } else if (action instanceof NamedAction) {
                NamedAction.NamedActionType namedActionType = ((NamedAction) action).getNamedActionType();
                Map<NamedAction.NamedActionType, String> map = gr.a;
                namedActionType.getClass();
                String str = gr.a.get(namedActionType);
                if (str == null) {
                    str = "Unknown";
                }
                int iA6 = ygVar.a(str);
                ygVar.d(2);
                ygVar.b(0, iA6);
                i = 1;
                ygVar.a(1, (short) 0);
                iA = ygVar.a();
            } else if (action instanceof JavaScriptAction) {
                int iA7 = ygVar.a(((JavaScriptAction) action).getScript());
                ygVar.d(1);
                ygVar.b(0, iA7);
                iA = ygVar.a();
            } else if (action instanceof HideAction) {
                HideAction hideAction = (HideAction) action;
                List<f4> annotationReferences = ActionAccessors.INSTANCE.getAnnotationReferences(hideAction);
                int size2 = annotationReferences.size();
                int[] iArr = new int[size2];
                int i3 = 0;
                for (f4 f4Var : annotationReferences) {
                    int i4 = i3 + 1;
                    String str2 = f4Var.c;
                    int iA8 = str2 != null ? ygVar.a(str2) : 0;
                    int i5 = f4Var.a;
                    int i6 = f4Var.b;
                    ygVar.d(4);
                    ygVar.a(3, 0);
                    ygVar.a(2, i6);
                    ygVar.a(1, i5);
                    ygVar.b(0, iA8);
                    iArr[i3] = ygVar.a();
                    i3 = i4;
                }
                ygVar.a(4, size2, 4);
                for (int i7 = size2 - 1; -1 < i7; i7--) {
                    ygVar.a(iArr[i7]);
                }
                int iB = ygVar.b();
                boolean zShouldHide = hideAction.getHideTargets();
                ygVar.d(2);
                ygVar.b(0, iB);
                if (ygVar.l || !zShouldHide) {
                    ygVar.d(1, 0);
                    ByteBuffer byteBuffer = ygVar.a;
                    int i8 = ygVar.b - 1;
                    ygVar.b = i8;
                    byteBuffer.put(i8, zShouldHide ? (byte) 1 : (byte) 0);
                    ygVar.c(1);
                }
                iA = ygVar.a();
            } else if (action instanceof ResetFormAction) {
                ResetFormAction resetFormAction = (ResetFormAction) action;
                Map<SubmitFormAction.SubmitFormActionFlag, ULong> map2 = gh.a;
                int size3 = resetFormAction.getFieldNames().size();
                int[] iArr2 = new int[size3];
                Iterator<T> it = resetFormAction.getFieldNames().iterator();
                int i9 = 0;
                while (it.hasNext()) {
                    int iA9 = ygVar.a((String) it.next());
                    ygVar.d(4);
                    ygVar.a(3, 0);
                    ygVar.a(2, 0);
                    ygVar.a(1, 0);
                    ygVar.b(0, iA9);
                    iArr2[i9] = ygVar.a();
                    i9++;
                }
                ygVar.a(4, size3, 4);
                for (int i10 = size3 - 1; -1 < i10; i10--) {
                    ygVar.a(iArr2[i10]);
                }
                int iB2 = ygVar.b();
                boolean zShouldExcludeFormFields = resetFormAction.getExcludeFormFields();
                ygVar.d(2);
                ygVar.a(1, zShouldExcludeFormFields ? 1 : 0);
                ygVar.b(0, iB2);
                iA = ygVar.a();
            } else {
                if (!(action instanceof SubmitFormAction)) {
                    PdfLog.e("Nutri.ActFlatbuffConvs", "Unsupported action type for writing to flatbuffers: " + action.getType().name(), new Object[0]);
                    return null;
                }
                SubmitFormAction submitFormAction = (SubmitFormAction) action;
                Map<SubmitFormAction.SubmitFormActionFlag, ULong> map3 = gh.a;
                int size4 = submitFormAction.getFieldNames().size();
                int[] iArr3 = new int[size4];
                Iterator<T> it2 = submitFormAction.getFieldNames().iterator();
                int i11 = 0;
                while (it2.hasNext()) {
                    int iA10 = ygVar.a((String) it2.next());
                    ygVar.d(4);
                    ygVar.a(3, 0);
                    ygVar.a(2, 0);
                    ygVar.a(1, 0);
                    ygVar.b(0, iA10);
                    iArr3[i11] = ygVar.a();
                    i11++;
                }
                int iA11 = ygVar.a(submitFormAction.getUri());
                ygVar.a(4, size4, 4);
                for (int i12 = size4 - 1; -1 < i12; i12--) {
                    ygVar.a(iArr3[i12]);
                }
                int iB3 = ygVar.b();
                EnumSet<SubmitFormAction.SubmitFormActionFlag> flags = submitFormAction.getFlags();
                long j = 0;
                if (!flags.isEmpty()) {
                    Iterator<SubmitFormAction.SubmitFormActionFlag> it3 = flags.iterator();
                    it3.getClass();
                    long jM14954constructorimpl = 0;
                    while (it3.hasNext()) {
                        ULong uLong = gh.a.get(it3.next());
                        jM14954constructorimpl = ULong.m14954constructorimpl(jM14954constructorimpl | (uLong != null ? uLong.getData() : 0L));
                    }
                    j = jM14954constructorimpl;
                }
                ygVar.d(3);
                ygVar.a(2, j);
                i = 1;
                ygVar.b(1, iB3);
                ygVar.b(0, iA11);
                iA = ygVar.a();
            }
            intArray = CollectionsKt.toIntArray(arrayList);
            intArray.getClass();
            ygVar.a(4, intArray.length, 4);
            for (length = intArray.length - i; -1 < length; length--) {
                ygVar.a(intArray[length]);
            }
            int iB4 = ygVar.b();
            ygVar.d(5);
            ygVar.a(0, a(action.getType()));
            ygVar.b(3, iA);
            ygVar.b(4, iB4);
            return Integer.valueOf(ygVar.a());
        }
        i = 1;
        intArray = CollectionsKt.toIntArray(arrayList);
        intArray.getClass();
        ygVar.a(4, intArray.length, 4);
        while (-1 < length) {
            ygVar.a(intArray[length]);
        }
        int iB5 = ygVar.b();
        ygVar.d(5);
        ygVar.a(0, a(action.getType()));
        ygVar.b(3, iA);
        ygVar.b(4, iB5);
        return Integer.valueOf(ygVar.a());
    }

    public static final short a(ActionType actionType) {
        switch (a.a[actionType.ordinal()]) {
            case 1:
                return (short) 1;
            case 2:
                return (short) 2;
            case 3:
                return (short) 3;
            case 4:
                return (short) 4;
            case 5:
                return (short) 6;
            case 6:
                return (short) 9;
            case 7:
                return (short) 10;
            case 8:
                return (short) 11;
            case 9:
                return (short) 12;
            case 10:
                return (short) 16;
            case 11:
                return (short) 19;
            case 12:
                return (short) 13;
            case 13:
                return (short) 14;
            default:
                throw new IllegalStateException("Unknown action type: " + actionType.name());
        }
    }

    public static final AnnotationTriggerEvent a(short s) {
        if (s == 0) {
            return AnnotationTriggerEvent.CURSOR_ENTERS;
        }
        if (s == 1) {
            return AnnotationTriggerEvent.CURSOR_EXITS;
        }
        if (s == 2) {
            return AnnotationTriggerEvent.MOUSE_DOWN;
        }
        if (s == 3) {
            return AnnotationTriggerEvent.MOUSE_UP;
        }
        if (s == 4) {
            return AnnotationTriggerEvent.RECEIVE_FOCUS;
        }
        if (s == 5) {
            return AnnotationTriggerEvent.LOOSE_FOCUS;
        }
        if (s == 6) {
            return AnnotationTriggerEvent.PAGE_OPENED;
        }
        if (s == 7) {
            return AnnotationTriggerEvent.PAGE_CLOSED;
        }
        if (s == 8) {
            return AnnotationTriggerEvent.PAGE_VISIBLE;
        }
        if (s == 9) {
            return AnnotationTriggerEvent.FORM_CHANGED;
        }
        if (s == 10) {
            return AnnotationTriggerEvent.FIELD_FORMAT;
        }
        if (s == 11) {
            return AnnotationTriggerEvent.FORM_VALIDATE;
        }
        if (s == 12) {
            return AnnotationTriggerEvent.FORM_CALCULATE;
        }
        throw new IllegalStateException("Unknown trigger event: " + ((int) s));
    }

    public static final short a(DestinationType destinationType) {
        switch (a.c[destinationType.ordinal()]) {
            case 1:
                return (short) 0;
            case 2:
                return (short) 1;
            case 3:
                return (short) 2;
            case 4:
                return (short) 3;
            case 5:
                return (short) 4;
            case 6:
                return (short) 5;
            case 7:
                return (short) 6;
            case 8:
                return (short) 7;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
