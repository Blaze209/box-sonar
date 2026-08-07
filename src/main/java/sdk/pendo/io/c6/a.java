package sdk.pendo.io.c6;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerTabStrip;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.events.ConditionData;
import sdk.pendo.io.events.IdentificationData;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.s7.e1;
import sdk.pendo.io.s7.m0;
import sdk.pendo.io.s7.s0;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static volatile a a;
    private static final sdk.pendo.io.v5.a<Integer, View> b = new sdk.pendo.io.v5.a<>();
    private static final ReentrantReadWriteLock c;
    private static final ReentrantReadWriteLock.WriteLock d;
    private static final ReentrantReadWriteLock.WriteLock e;

    static {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        c = reentrantReadWriteLock;
        d = reentrantReadWriteLock.writeLock();
        e = reentrantReadWriteLock.writeLock();
    }

    private a() {
    }

    public static <T> View a(View view, String str) {
        return a(view, str, (HashSet<View>) new HashSet());
    }

    public static void b() {
        a();
    }

    public static View a(View view, IdentificationData identificationData, List<View> list, boolean z, ConditionData conditionData) {
        View viewA;
        if (view == null || identificationData == null) {
            return null;
        }
        sdk.pendo.io.b2.b bVar = new sdk.pendo.io.b2.b();
        if (bVar.e()) {
            bVar.g();
        }
        if (!bVar.d()) {
            bVar.h();
        }
        try {
            int iHashCode = (view.hashCode() * 7) + (identificationData.hashCode() * 31);
            if (list == null && (viewA = a(Integer.valueOf(iHashCode))) != null && m0.a(identificationData, viewA, conditionData)) {
                PendoLogger.d("View cache found!", new Object[0]);
                if (!z || e1.a(viewA, 0)) {
                    if (bVar.d() || bVar.f()) {
                        bVar.i();
                    }
                    PendoLogger.i("Finding view took: " + bVar.c() + " Millis", new Object[0]);
                    return viewA;
                }
                PendoLogger.d("Outside the display.", new Object[0]);
                if (bVar.d() || bVar.f()) {
                    bVar.i();
                }
                PendoLogger.i("Finding view took: " + bVar.c() + " Millis", new Object[0]);
                return null;
            }
            HashSet hashSet = new HashSet();
            String id = identificationData.getId();
            if (id != null) {
                PendoLogger.d("Identification data has ID.", new Object[0]);
                int iB = s0.b(id);
                if (iB != -1) {
                    a(view, (HashSet<View>) new HashSet(), hashSet, iB);
                    HashSet hashSet2 = new HashSet();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        View viewA2 = a((View) it.next(), identificationData, (HashSet<View>) hashSet2, z, conditionData);
                        if (viewA2 != null) {
                            if (list == null) {
                                a(Integer.valueOf(iHashCode), viewA2);
                                if (bVar.d() || bVar.f()) {
                                    bVar.i();
                                }
                                PendoLogger.i("Finding view took: " + bVar.c() + " Millis", new Object[0]);
                                return viewA2;
                            }
                            list.add(viewA2);
                        }
                    }
                    if (list != null && !list.isEmpty()) {
                        View viewRemove = list.remove(0);
                        if (bVar.d() || bVar.f()) {
                            bVar.i();
                        }
                        PendoLogger.i("Finding view took: " + bVar.c() + " Millis", new Object[0]);
                        return viewRemove;
                    }
                    if (bVar.d() || bVar.f()) {
                        bVar.i();
                    }
                    PendoLogger.i("Finding view took: " + bVar.c() + " Millis", new Object[0]);
                    return null;
                }
            }
            ArrayList<String> idOfParents = identificationData.getIdOfParents();
            if (idOfParents == null || idOfParents.isEmpty()) {
                View viewA3 = a(view, identificationData, (HashSet<View>) new HashSet(), true, conditionData);
                if (viewA3 != null) {
                    a(Integer.valueOf(iHashCode), viewA3);
                }
                if (bVar.d() || bVar.f()) {
                    bVar.i();
                }
                PendoLogger.i("Finding view took: " + bVar.c() + " Millis", new Object[0]);
                return viewA3;
            }
            PendoLogger.d("Identification data has parents IDs.", new Object[0]);
            a(view, (HashSet<View>) new HashSet(), idOfParents, hashSet);
            HashSet hashSet3 = new HashSet();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                View viewA4 = a((View) it2.next(), identificationData, (HashSet<View>) hashSet3, z, conditionData);
                if (viewA4 != null) {
                    if (list == null) {
                        a(Integer.valueOf(iHashCode), viewA4);
                        if (bVar.d() || bVar.f()) {
                            bVar.i();
                        }
                        PendoLogger.i("Finding view took: " + bVar.c() + " Millis", new Object[0]);
                        return viewA4;
                    }
                    list.add(viewA4);
                }
            }
            if (list != null && !list.isEmpty()) {
                View viewRemove2 = list.remove(0);
                if (bVar.d() || bVar.f()) {
                    bVar.i();
                }
                PendoLogger.i("Finding view took: " + bVar.c() + " Millis", new Object[0]);
                return viewRemove2;
            }
            if (bVar.d() || bVar.f()) {
                bVar.i();
            }
            PendoLogger.i("Finding view took: " + bVar.c() + " Millis", new Object[0]);
            return null;
        } catch (Throwable th) {
            if (bVar.d() || bVar.f()) {
                bVar.i();
            }
            PendoLogger.i("Finding view took: " + bVar.c() + " Millis", new Object[0]);
            throw th;
        }
    }

    public static View a(View view, IdentificationData identificationData, boolean z, ConditionData conditionData) {
        return a(view, identificationData, (List<View>) null, z, conditionData);
    }

    public static <T> View a(View view, Object obj) {
        return a(view, obj, (HashSet<View>) new HashSet());
    }

    private static <T> View a(View view, Object obj, HashSet<View> hashSet) {
        View viewA;
        if (view == null) {
            return null;
        }
        hashSet.add(view);
        if (view instanceof ViewGroup) {
            View viewFindViewWithTag = view.findViewWithTag(obj);
            if (viewFindViewWithTag != null) {
                return viewFindViewWithTag;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (!hashSet.contains(childAt) && (viewA = a(childAt, obj, hashSet)) != null) {
                        return viewA;
                    }
                }
            }
        }
        return null;
    }

    public static synchronized a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    private static View a(Integer num) {
        e.lock();
        try {
            return b.get(num);
        } finally {
            e.unlock();
        }
    }

    private static void a(Integer num, View view) {
        d.lock();
        try {
            Object parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                if (!(view2 instanceof PagerTabStrip) && !e1.j(view2)) {
                    parent = view2.getParent();
                }
            }
            b.put(num, view);
        } finally {
            d.unlock();
        }
    }

    private static <T> View a(View view, String str, HashSet<View> hashSet) {
        ViewGroup viewGroup;
        int childCount;
        View viewA;
        if (view == null) {
            return null;
        }
        CharSequence contentDescription = view.getContentDescription();
        if (contentDescription != null && str.equals(contentDescription.toString())) {
            return view;
        }
        hashSet.add(view);
        if ((view instanceof ViewGroup) && (childCount = (viewGroup = (ViewGroup) view).getChildCount()) > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (!hashSet.contains(childAt) && (viewA = a(childAt, str, hashSet)) != null) {
                    return viewA;
                }
            }
        }
        return null;
    }

    private static View a(View view, IdentificationData identificationData, HashSet<View> hashSet, boolean z, ConditionData conditionData) {
        ViewGroup viewGroup;
        int childCount;
        View viewA;
        if (view != null && view.getVisibility() == 0) {
            if (!z || e1.a(view, 0)) {
                if (b.a(identificationData, b.a(view, Boolean.valueOf(PendoInternal.y().includePageViewTexts), Boolean.valueOf(PendoInternal.y().includeNestedText)), false, conditionData).a().booleanValue()) {
                    return view;
                }
                hashSet.add(view);
                if ((view instanceof ViewGroup) && (childCount = (viewGroup = (ViewGroup) view).getChildCount()) > 0) {
                    for (int i = 0; i < childCount; i++) {
                        View childAt = viewGroup.getChildAt(i);
                        if (childAt != null && !hashSet.contains(childAt) && (viewA = a(childAt, identificationData, hashSet, z, conditionData)) != null) {
                            return viewA;
                        }
                    }
                }
            }
        }
        return null;
    }

    private static void a(View view, HashSet<View> hashSet, ArrayList<String> arrayList, Set<View> set) {
        ViewGroup viewGroup;
        int childCount;
        View viewFindViewById;
        try {
            hashSet.add(view);
            if (!(view instanceof ViewGroup) || (childCount = (viewGroup = (ViewGroup) view).getChildCount()) <= 0) {
                return;
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != null) {
                    Iterator<String> it = arrayList.iterator();
                    View view2 = childAt;
                    while (it.hasNext()) {
                        int iB = s0.b(it.next());
                        if (iB != -1 && (viewFindViewById = view2.findViewById(iB)) != null) {
                            view2 = viewFindViewById;
                        }
                    }
                    if (!view2.equals(childAt)) {
                        set.add(view2);
                    }
                    if (!hashSet.contains(childAt)) {
                        a(childAt, hashSet, arrayList, set);
                    }
                }
            }
        } catch (NullPointerException e2) {
            PendoLogger.d(e2);
        }
    }

    private static void a(View view, HashSet<View> hashSet, Set<View> set, int i) {
        ViewGroup viewGroup;
        int childCount;
        if (view == null) {
            return;
        }
        if (view.getId() == i) {
            set.add(view);
        }
        hashSet.add(view);
        if (!(view instanceof ViewGroup) || (childCount = (viewGroup = (ViewGroup) view).getChildCount()) <= 0) {
            return;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (!hashSet.contains(childAt)) {
                a(childAt, hashSet, set, i);
            }
        }
    }
}
