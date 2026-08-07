package com.pspdfkit.internal;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.RectF;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.microsoft.intune.mam.client.content.MAMClipboard;
import com.pspdfkit.Nutrient;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.FreeTextAnnotation;
import com.pspdfkit.configuration.policy.ApplicationPolicy;
import com.pspdfkit.utils.PdfLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d1 implements ClipboardManager.OnPrimaryClipChangedListener {
    public ClipboardManager a;
    public final ArrayList b = new ArrayList();
    public String c;
    public boolean d;
    public final Set<AnnotationType> e;

    public d1() {
        a();
        this.e = SetsKt.setOf((Object[]) new AnnotationType[]{AnnotationType.INK, AnnotationType.FREETEXT, AnnotationType.NOTE, AnnotationType.STAMP, AnnotationType.CIRCLE, AnnotationType.LINE, AnnotationType.POLYGON, AnnotationType.POLYLINE, AnnotationType.SQUARE});
    }

    public final ClipboardManager a() {
        if (this.a == null) {
            h60.a(new Runnable() { // from class: com.pspdfkit.internal.d1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    d1.a(this.f$0);
                }
            });
        }
        return this.a;
    }

    @Override // android.content.ClipboardManager.OnPrimaryClipChangedListener
    public final void onPrimaryClipChanged() {
        ClipboardManager clipboardManagerA;
        ClipDescription primaryClipDescription;
        this.d = Nutrient.isInitialized() && Nutrient.getApplicationPolicy().hasPermissionForEvent(ApplicationPolicy.PolicyEvent.ANNOTATION_COPY_PASTE_SYSTEM_INTEGRATION) && (clipboardManagerA = a()) != null && MAMClipboard.hasPrimaryClip(clipboardManagerA) && (primaryClipDescription = MAMClipboard.getPrimaryClipDescription(clipboardManagerA)) != null && (primaryClipDescription.hasMimeType("text/plain") || primaryClipDescription.hasMimeType("image/*"));
    }

    public static final void a(d1 d1Var) {
        synchronized (d1Var) {
            Context context = n5.a;
            if (context != null) {
                ClipboardManager clipboardManager = (ClipboardManager) ContextCompat.getSystemService(context, ClipboardManager.class);
                if (clipboardManager != null) {
                    clipboardManager.addPrimaryClipChangedListener(d1Var);
                    d1Var.a = clipboardManager;
                }
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IllegalStateException("The application context should not be null. Please call fun setApplicationContext(context: Context) first");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00e5 A[PHI: r6
      0x00e5: PHI (r6v5 com.pspdfkit.internal.e1) = (r6v3 com.pspdfkit.internal.e1), (r6v10 com.pspdfkit.internal.e1) binds: [B:54:0x00d9, B:34:0x006f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:57:0x00e7  */
    public final ArrayList a(String str) {
        Annotation copy;
        bm internal;
        ClipData primaryClip;
        Object obj;
        e1 e1Var;
        e1 giVar;
        Object obj2;
        t30 t30Var;
        int i = 0;
        if (this.d) {
            this.d = false;
            ClipboardManager clipboardManagerA = a();
            if (clipboardManagerA == null) {
                primaryClip = null;
            } else {
                try {
                    primaryClip = MAMClipboard.getPrimaryClip(clipboardManagerA);
                } catch (SecurityException e) {
                    PdfLog.w("Nutri.Clipboard", e, "Got security exception when reading clipboard.", new Object[0]);
                    primaryClip = null;
                } catch (RuntimeException e2) {
                    PdfLog.w("Nutri.Clipboard", e2, "Got runtime exception when reading clipboard. Probably too much data on the clipboard.", new Object[0]);
                    primaryClip = null;
                }
            }
            if (primaryClip != null) {
                ArrayList arrayList = this.b;
                arrayList.getClass();
                if (primaryClip.getDescription().hasMimeType("image/*")) {
                    Uri uri = primaryClip.getItemAt(0).getUri();
                    if (uri == null) {
                        giVar = null;
                    } else {
                        int size = arrayList.size();
                        int i2 = 0;
                        do {
                            if (i2 >= size) {
                                obj2 = null;
                                break;
                            }
                            obj2 = arrayList.get(i2);
                            i2++;
                            e1 e1Var2 = (e1) obj2;
                            t30Var = e1Var2 instanceof t30 ? (t30) e1Var2 : null;
                        } while (!Intrinsics.areEqual(t30Var != null ? t30Var.b : null, uri));
                        e1Var = (e1) obj2;
                        if (e1Var == null) {
                            giVar = new t30(uri);
                        } else {
                            giVar = e1Var;
                        }
                    }
                } else if (primaryClip.getDescription().hasMimeType("text/plain")) {
                    CharSequence text = primaryClip.getItemAt(0).getText();
                    if (TextUtils.isEmpty(text)) {
                        giVar = null;
                    } else {
                        int size2 = arrayList.size();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size2) {
                                obj = null;
                                break;
                            }
                            obj = arrayList.get(i3);
                            i3++;
                            e1 e1Var3 = (e1) obj;
                            if (e1Var3 instanceof gi) {
                                gi giVar2 = (gi) e1Var3;
                                String string = text.toString();
                                string.getClass();
                                Annotation annotation = giVar2.a;
                                FreeTextAnnotation freeTextAnnotation = annotation instanceof FreeTextAnnotation ? (FreeTextAnnotation) annotation : null;
                                if (freeTextAnnotation != null) {
                                    freeTextAnnotation.setContents(string);
                                    break;
                                }
                                FreeTextAnnotation freeTextAnnotation2 = new FreeTextAnnotation(0, new RectF(0.0f, 0.0f, 100.0f, 100.0f), string);
                                freeTextAnnotation2.setTextSize(12.0f);
                                giVar2.a = freeTextAnnotation2;
                                break;
                            }
                        }
                        e1Var = (e1) obj;
                        if (e1Var == null) {
                            giVar = new gi(text.toString());
                        } else {
                            giVar = e1Var;
                        }
                    }
                } else {
                    giVar = null;
                }
                if (giVar != null) {
                    this.b.remove(giVar);
                    ArrayList arrayList2 = this.b;
                    int size3 = arrayList2.size();
                    int i4 = 0;
                    while (i4 < size3) {
                        Object obj3 = arrayList2.get(i4);
                        i4++;
                        ((e1) obj3).c();
                    }
                    this.b.clear();
                    this.d = false;
                    this.b.add(giVar);
                    this.c = null;
                }
            }
        }
        ArrayList arrayList3 = this.b;
        ArrayList arrayList4 = new ArrayList();
        int size4 = arrayList3.size();
        int i5 = 0;
        while (i5 < size4) {
            Object obj4 = arrayList3.get(i5);
            i5++;
            Annotation annotationA = ((e1) obj4).a();
            if (annotationA == null || (internal = annotationA.getInternal()) == null || (copy = internal.getCopy()) == null) {
                copy = null;
            } else {
                copy.setModifiedDate(new Date());
                copy.setCreator(str);
            }
            if (copy != null) {
                arrayList4.add(copy);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size5 = arrayList4.size();
        while (i < size5) {
            Object obj5 = arrayList4.get(i);
            i++;
            String group = ((Annotation) obj5).getGroup();
            Object arrayList5 = linkedHashMap.get(group);
            if (arrayList5 == null) {
                arrayList5 = new ArrayList();
                linkedHashMap.put(group, arrayList5);
            }
            ((List) arrayList5).add(obj5);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (str2 != null) {
                String strMakeNewGroupId = Annotation.INSTANCE.makeNewGroupId();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((Annotation) it.next()).setGroup(strMakeNewGroupId);
                }
            }
        }
        if (arrayList4.isEmpty()) {
            return null;
        }
        return arrayList4;
    }
}
