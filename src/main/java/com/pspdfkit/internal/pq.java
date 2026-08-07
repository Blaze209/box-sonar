package com.pspdfkit.internal;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class pq implements qq.a {
    public final ArrayDeque a;
    public final int c;
    public final HashSet b = new HashSet();
    public List<jq> d = null;

    public pq() {
        int iMin = Integer.MAX_VALUE;
        for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(0).getCodecInfos()) {
            for (String str : mediaCodecInfo.getSupportedTypes()) {
                iMin = Math.min(iMin, mediaCodecInfo.getCapabilitiesForType(str).getMaxSupportedInstances());
            }
        }
        this.c = iMin;
        this.a = new ArrayDeque(iMin);
    }

    public final ArrayList a() {
        kq kqVar;
        ArrayList arrayList = new ArrayList();
        for (iq iqVar : this.a) {
            int pageIndex = iqVar.a.getPageIndex();
            Iterator it = this.b.iterator();
            while (true) {
                kqVar = null;
                if (!it.hasNext()) {
                    break;
                }
                kq kqVar2 = (kq) it.next();
                m40 state = kqVar2.a.getState();
                Integer numValueOf = state != null ? Integer.valueOf(state.b) : null;
                if (numValueOf != null && numValueOf.intValue() == pageIndex) {
                    kqVar = kqVar2;
                    break;
                }
            }
            if (kqVar != null) {
                arrayList.add(new jq(iqVar.a.getPageIndex(), iqVar.a.getObjectNumber(), iqVar.i, kqVar.a(iqVar).getPosition()));
            }
        }
        return arrayList;
    }

    public final void b(iq iqVar) {
        iqVar.i = false;
        this.a.remove(iqVar);
    }

    public static void a(List list, HashSet hashSet) {
        if (list == null) {
            list = new ArrayList();
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            kq kqVar = (kq) it.next();
            ArrayList arrayList = new ArrayList();
            m40 state = kqVar.a.getState();
            Integer numValueOf = state != null ? Integer.valueOf(state.b) : null;
            if (numValueOf != null) {
                for (jq jqVar : list) {
                    if (jqVar.a == numValueOf.intValue()) {
                        arrayList.add(jqVar);
                    }
                }
            }
            list.removeAll(arrayList);
            kqVar.l = true;
            if (!arrayList.isEmpty()) {
                kqVar.n = arrayList;
            }
        }
    }

    public final void a(iq iqVar) {
        kq kqVar;
        if (this.a.contains(iqVar)) {
            return;
        }
        this.a.addLast(iqVar);
        if (this.a.size() > this.c) {
            iq iqVar2 = (iq) this.a.removeFirst();
            int pageIndex = iqVar2.a.getPageIndex();
            Iterator it = this.b.iterator();
            while (true) {
                kqVar = null;
                if (!it.hasNext()) {
                    break;
                }
                kq kqVar2 = (kq) it.next();
                m40 state = kqVar2.a.getState();
                Integer numValueOf = state != null ? Integer.valueOf(state.b) : null;
                if (numValueOf != null && numValueOf.intValue() == pageIndex) {
                    kqVar = kqVar2;
                    break;
                }
            }
            if (kqVar != null) {
                kqVar.b(iqVar2);
                return;
            }
            return;
        }
        iqVar.i = true;
    }
}
