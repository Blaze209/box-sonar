package com.pspdfkit.internal;

import android.util.SparseArray;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.forms.FormField;
import com.pspdfkit.forms.FormProviderImpl;
import com.pspdfkit.internal.jni.NativeFormField;
import com.pspdfkit.internal.jni.NativeFormManager;
import com.pspdfkit.internal.jni.NativeTabOrder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* JADX INFO: loaded from: classes3.dex */
public final class kh {
    public final FormProviderImpl a;
    public final lm b;
    public final NativeFormManager c;
    public final int d;
    public final ArrayList e;
    public final ArrayList f;
    public final ArrayList g;
    public final ArrayList h;
    public final ArrayList i;

    public kh(FormProviderImpl formProviderImpl, lm lmVar, NativeFormManager nativeFormManager) throws InterruptedException {
        lmVar.getClass();
        nativeFormManager.getClass();
        this.a = formProviderImpl;
        this.b = lmVar;
        this.c = nativeFormManager;
        List listUnmodifiableList = Collections.unmodifiableList(lmVar.A);
        listUnmodifiableList.getClass();
        int size = listUnmodifiableList.size();
        this.d = size;
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        for (int i = 0; i < size; i++) {
            this.e.add(new HashMap());
            this.g.add(new SparseArray());
            this.i.add(CollectionsKt.emptyList());
        }
        ArrayList<ArrayList<NativeFormField>> formFields = this.c.getFormFields();
        if (formFields != null) {
            int size2 = formFields.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size2) {
                ArrayList<NativeFormField> arrayList = formFields.get(i2);
                i2++;
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ArrayList<NativeFormField> arrayList2 = arrayList;
                Map map = (Map) this.e.get(i3);
                arrayList2.getClass();
                int size3 = arrayList2.size();
                int i5 = 0;
                while (i5 < size3) {
                    NativeFormField nativeFormField = arrayList2.get(i5);
                    i5++;
                    NativeFormField nativeFormField2 = nativeFormField;
                    FormProviderImpl formProviderImpl2 = this.a;
                    nativeFormField2.getClass();
                    FormField formFieldCreateFormField = formProviderImpl2.createFormField(i3, nativeFormField2);
                    map.put(formFieldCreateFormField.getFullyQualifiedName(), formFieldCreateFormField);
                    this.f.add(formFieldCreateFormField);
                }
                i3 = i4;
            }
        }
        BuildersKt__BuildersKt.runBlocking$default(null, new hh(this, null), 1, null);
        int i6 = this.d;
        for (int i7 = 0; i7 < i6; i7++) {
            a(i7);
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0061  */
    /* JADX WARN: Code duplicated, block: B:23:0x0090 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:33:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ca A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x008e -> B:24:0x0091). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:39:0x00ca
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object a(com.pspdfkit.internal.kh r10, java.util.List r11, int r12, kotlin.coroutines.jvm.internal.ContinuationImpl r13) {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.kh.a(com.pspdfkit.internal.kh, java.util.List, int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final FormField a(int i, NativeFormField nativeFormField) throws InterruptedException {
        nativeFormField.getClass();
        Map map = (Map) this.e.get(i);
        FormField formFieldCreateFormField = (FormField) map.get(nativeFormField.getFQN());
        if (formFieldCreateFormField == null) {
            formFieldCreateFormField = this.a.createFormField(i, nativeFormField);
            map.put(formFieldCreateFormField.getFullyQualifiedName(), formFieldCreateFormField);
            this.f.add(formFieldCreateFormField);
        }
        List listListOf = CollectionsKt.listOf(formFieldCreateFormField);
        if (listListOf.isEmpty()) {
            return formFieldCreateFormField;
        }
        BuildersKt__BuildersKt.runBlocking$default(null, new ih(this, listListOf, i, null), 1, null);
        return formFieldCreateFormField;
    }

    public final void a(int i) {
        NativeTabOrder tabOrderForProvider = this.c.getTabOrderForProvider(i);
        if (tabOrderForProvider == null) {
            return;
        }
        ArrayList<Integer> widgetIDs = tabOrderForProvider.getWidgetIDs();
        widgetIDs.getClass();
        if (widgetIDs.isEmpty()) {
            return;
        }
        SparseArray sparseArray = (SparseArray) this.g.get(i);
        ArrayList arrayList = new ArrayList(widgetIDs.size());
        Iterator<Integer> it = widgetIDs.iterator();
        it.getClass();
        FormElement formElement = null;
        while (it.hasNext()) {
            Integer next = it.next();
            next.getClass();
            FormElement formElement2 = (FormElement) sparseArray.get(next.intValue());
            if (formElement2 != null) {
                formElement2.setPreviousElement(formElement);
                if (formElement != null) {
                    formElement.setNextElement(formElement2);
                }
                arrayList.add(formElement2);
                formElement = formElement2;
            }
        }
        this.i.set(i, arrayList);
        a(i - 1, i);
        a(i, i + 1);
    }

    public final void a(int i, int i2) {
        Integer num;
        Integer next;
        if (i < 0 || i2 >= this.d) {
            return;
        }
        Iterator<Integer> it = RangesKt.downTo(i, 0).iterator();
        do {
            num = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((Collection) this.i.get(next.intValue())).isEmpty());
        Integer num2 = next;
        if (num2 != null) {
            List list = (List) this.i.get(num2.intValue());
            for (Integer num3 : RangesKt.until(i2, this.d)) {
                if (!((Collection) this.i.get(num3.intValue())).isEmpty()) {
                    num = num3;
                    break;
                }
            }
            Integer num4 = num;
            if (num4 != null) {
                List list2 = (List) this.i.get(num4.intValue());
                FormElement formElement = (FormElement) CollectionsKt.last(list);
                FormElement formElement2 = (FormElement) CollectionsKt.first(list2);
                formElement.setNextElement(formElement2);
                formElement2.setPreviousElement(formElement);
            }
        }
    }
}
