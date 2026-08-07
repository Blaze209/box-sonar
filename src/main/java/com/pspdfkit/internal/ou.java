package com.pspdfkit.internal;

import android.graphics.Bitmap;
import com.pspdfkit.internal.jni.NativeDocument;
import com.pspdfkit.internal.jni.NativePage;
import com.pspdfkit.internal.jni.NativePageInfo;
import com.pspdfkit.internal.jni.NativePageRenderingConfig;
import com.pspdfkit.internal.jni.NativeRenderResult;
import com.pspdfkit.utils.Size;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ou {
    public final String a;
    public final NativeDocument b;
    public final boolean c;
    public final ReentrantLock d;
    public final ReentrantReadWriteLock e;
    public b f;
    public final Map<Integer, vv> g;

    public static final class a implements b {
        public final NativeDocument a;

        public a(NativeDocument nativeDocument) {
            nativeDocument.getClass();
            this.a = nativeDocument;
        }

        public final NativePageInfo a(int i) {
            NativePageInfo pageInfo = this.a.getPageInfo(i);
            if (pageInfo != null) {
                return pageInfo;
            }
            throw new IllegalStateException("No page information from index " + i);
        }

        @Override // com.pspdfkit.internal.ou.b
        public final String getPageLabel(int i, boolean z) {
            return this.a.getPageLabel(i, z);
        }

        @Override // com.pspdfkit.internal.ou.b
        public final byte getPageRotation(int i) {
            return a(i).getRotation();
        }

        @Override // com.pspdfkit.internal.ou.b
        public final Size getPageSize(int i) {
            Size size = a(i).getSize();
            size.getClass();
            return size;
        }

        @Override // com.pspdfkit.internal.ou.b
        public final byte getRotationOffset(int i) {
            return a(i).getRotationOffset();
        }
    }

    public interface b {
        String getPageLabel(int i, boolean z);

        byte getPageRotation(int i);

        Size getPageSize(int i);

        byte getRotationOffset(int i);
    }

    public ou(String str, NativeDocument nativeDocument, boolean z) {
        str.getClass();
        nativeDocument.getClass();
        this.a = str;
        this.b = nativeDocument;
        this.c = z;
        this.d = new ReentrantLock();
        this.e = new ReentrantReadWriteLock();
        this.f = new a(nativeDocument);
        this.g = Collections.synchronizedMap(new c());
    }

    public final NativeRenderResult a(int i, Bitmap bitmap, int i2, int i3, int i4, int i5, NativePageRenderingConfig nativePageRenderingConfig, int i6) {
        bitmap.getClass();
        nativePageRenderingConfig.getClass();
        this.e.readLock().lock();
        try {
            vv vvVarB = b(i);
            bitmap.getClass();
            nativePageRenderingConfig.getClass();
            NativePage nativePage = vvVarB.c;
            return nativePage != null ? nativePage.renderPage(bitmap, i2, i3, i4, i5, nativePageRenderingConfig, Integer.valueOf(i6)) : null;
        } finally {
            this.e.readLock().unlock();
        }
    }

    public final vv b(int i) {
        a(i);
        this.d.lock();
        try {
            Map<Integer, vv> map = this.g;
            map.getClass();
            Integer numValueOf = Integer.valueOf(i);
            vv vvVar = map.get(numValueOf);
            if (vvVar == null) {
                NativeDocument nativeDocument = this.b;
                nativeDocument.getClass();
                vv vvVar2 = new vv(nativeDocument, i, i);
                map.put(numValueOf, vvVar2);
                vvVar = vvVar2;
            }
            return vvVar;
        } finally {
            this.d.unlock();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ou)) {
            return false;
        }
        ou ouVar = (ou) obj;
        return Intrinsics.areEqual(this.a, ouVar.a) && Intrinsics.areEqual(this.b, ouVar.b) && this.c == ouVar.c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.c) + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "PageRenderingHelper(uid=" + this.a + ", nativeDocument=" + this.b + ", isMultithreadedRenderingEnabled=" + this.c + ")";
    }

    public static final class c extends LinkedHashMap<Integer, vv> {
        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof Integer) {
                return super.containsKey((Integer) obj);
            }
            return false;
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof vv) {
                return super.containsValue((vv) obj);
            }
            return false;
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object get(Object obj) {
            if (obj instanceof Integer) {
                return (vv) super.get((Integer) obj);
            }
            return null;
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof Integer) ? obj2 : (vv) super.getOrDefault((Integer) obj, (vv) obj2);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object remove(Object obj) {
            if (obj instanceof Integer) {
                return (vv) super.remove((Integer) obj);
            }
            return null;
        }

        @Override // java.util.LinkedHashMap
        public final boolean removeEldestEntry(Map.Entry<Integer, vv> entry) {
            return super.size() > 3;
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj instanceof Integer) && (obj2 instanceof vv)) {
                return super.remove((Integer) obj, (vv) obj2);
            }
            return false;
        }
    }

    public final void a(int i) {
        int pageCount = this.b.getPageCount();
        if (i < 0 || i >= pageCount) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            throw new IllegalArgumentException(String.format(Locale.getDefault(), "Invalid page number passed: %d. Page number has to be in the interval [0, %d)", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(pageCount)}, 2)).toString());
        }
    }
}
