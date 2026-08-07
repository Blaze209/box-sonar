package com.pspdfkit.internal.ui.dialog.signatures;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import com.microsoft.intune.mam.client.widget.MAMRelativeLayout;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.g20;
import com.pspdfkit.internal.ip;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.no;
import com.pspdfkit.signatures.BiometricSignatureData;
import com.pspdfkit.signatures.Signature;
import com.pspdfkit.ui.signatures.SignatureUiData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends MAMRelativeLayout {
    public final Paint a;
    public final Paint b;
    public float c;
    public float d;
    public float e;
    public ArrayList f;
    public a g;
    public int h;
    public int i;
    public float j;
    public int k;
    public b l;
    public boolean m;
    public Uri n;
    public g20 o;

    public interface b {
        void a();

        void b();

        void c();

        void d();
    }

    public static class c extends View.BaseSavedState {
        public static final Parcelable.Creator<c> CREATOR = new a();
        public ArrayList a;
        public boolean b;
        public Uri c;

        public class a implements Parcelable.Creator<c> {
            @Override // android.os.Parcelable.Creator
            public final c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final c[] newArray(int i) {
                return new c[i];
            }
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeTypedList(this.a);
            parcel.writeInt(this.b ? 1 : 0);
            parcel.writeValue(this.c);
        }

        public c(Parcel parcel) {
            super(parcel);
            this.a = parcel.createTypedArrayList(a.CREATOR);
            this.b = parcel.readInt() == 1;
            this.c = (Uri) parcel.readValue(Uri.class.getClassLoader());
        }
    }

    public e(Context context) {
        super(context);
        this.a = new Paint();
        this.b = new Paint();
        this.c = 1.0f;
        this.f = new ArrayList();
        this.g = null;
        this.k = -16777216;
        this.m = true;
        this.n = null;
        g();
    }

    private int getPrevailingMotionEventToolType() {
        if (this.f.isEmpty()) {
            return 0;
        }
        SparseIntArray sparseIntArray = new SparseIntArray(4);
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            int i2 = ((a) obj).e;
            sparseIntArray.put(i2, sparseIntArray.get(i2) + 1);
        }
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < sparseIntArray.size(); i5++) {
            int iKeyAt = sparseIntArray.keyAt(i5);
            int i6 = sparseIntArray.get(iKeyAt);
            if (i6 > i4) {
                i3 = iKeyAt;
                i4 = i6;
            }
        }
        return i3;
    }

    public abstract float a();

    public abstract void a(Canvas canvas);

    public abstract void a(Paint paint);

    public void a(MotionEvent motionEvent) {
        float f = this.j;
        float fMax = (Math.max(this.c * 5.0f, 0.02f * f) + f) / 2.0f;
        PointF pointF = new PointF(Math.max(fMax, Math.min(motionEvent.getX(), this.h - fMax)), Math.max(fMax, Math.min(motionEvent.getY(), this.i - fMax)));
        this.d = pointF.x;
        this.e = pointF.y;
        this.g = new a(pointF, motionEvent.getEventTime(), motionEvent.getPressure(), motionEvent.getToolType(0), motionEvent.getSize());
        if (this.l != null && this.f.isEmpty()) {
            this.l.d();
        }
        if (this.f.isEmpty()) {
            f();
        }
    }

    public abstract float b();

    public void c() {
        this.f.clear();
        this.g = null;
        b bVar = this.l;
        if (bVar != null) {
            bVar.c();
        }
        d();
        invalidate();
    }

    public abstract void d();

    public final SignatureUiData e() {
        BiometricSignatureData.InputMethod inputMethod;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = this.f;
        int size = arrayList5.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList5.get(i);
            i++;
            a aVar = (a) obj;
            arrayList.add(aVar.b);
            arrayList2.addAll(aVar.d);
            arrayList3.addAll(aVar.c);
            arrayList4.addAll(aVar.f);
        }
        int prevailingMotionEventToolType = getPrevailingMotionEventToolType();
        if (prevailingMotionEventToolType == 1) {
            inputMethod = BiometricSignatureData.InputMethod.FINGER;
        } else if (prevailingMotionEventToolType != 2) {
            inputMethod = prevailingMotionEventToolType != 3 ? null : BiometricSignatureData.InputMethod.MOUSE;
        } else {
            inputMethod = BiometricSignatureData.InputMethod.STYLUS;
        }
        return new SignatureUiData(arrayList, arrayList2, arrayList3, arrayList4, inputMethod);
    }

    public abstract void f();

    public final void g() {
        this.o = new g20(getContext());
        this.b.setAntiAlias(true);
        this.b.setDither(true);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setStrokeJoin(Paint.Join.ROUND);
        this.b.setStrokeCap(Paint.Cap.ROUND);
        this.b.setColor(this.k);
    }

    public List<a> getCurrentLines() {
        ArrayList arrayList = new ArrayList(this.f);
        a aVar = this.g;
        if (aVar != null) {
            arrayList.add(aVar);
        }
        return arrayList;
    }

    public Signature getCurrentlyDrawnSignature() {
        BiometricSignatureData.InputMethod inputMethod;
        Float fValueOf;
        BiometricSignatureData biometricSignatureData;
        if (this.f.isEmpty()) {
            return null;
        }
        ArrayList arrayListA = a(this.f, 1.0f / this.c);
        this.f = arrayListA;
        int size = arrayListA.size();
        float f = 0.0f;
        int i = 0;
        float f2 = Float.MAX_VALUE;
        float f3 = Float.MIN_VALUE;
        float f4 = 0.0f;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayListA.get(i2);
            i2++;
            ArrayList arrayList = ((a) obj).b;
            int size2 = arrayList.size();
            int i3 = 0;
            while (i3 < size2) {
                Object obj2 = arrayList.get(i3);
                i3++;
                PointF pointF = (PointF) obj2;
                float f5 = pointF.x;
                if (f5 < f2) {
                    f2 = f5;
                }
                float f6 = pointF.y;
                if (f6 > f4) {
                    f4 = f6;
                }
                if (f5 > f3) {
                    f3 = f5;
                }
            }
        }
        float f7 = f3 + 2.0f;
        float f8 = f2 - 2.0f;
        float f9 = 200.0f;
        float f10 = 200.0f - (f4 + 2.0f);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = this.f;
        int size3 = arrayList3.size();
        int i4 = 0;
        while (i4 < size3) {
            Object obj3 = arrayList3.get(i4);
            i4++;
            a aVar = (a) obj3;
            ArrayList arrayList4 = aVar.b;
            int size4 = arrayList4.size();
            int i5 = 0;
            while (i5 < size4) {
                Object obj4 = arrayList4.get(i5);
                i5++;
                float f11 = f9;
                PointF pointF2 = (PointF) obj4;
                pointF2.x -= f8;
                pointF2.y = f11 - (pointF2.y + f10);
                f9 = f11;
            }
            arrayList2.add(aVar.b);
            f9 = f9;
        }
        if (ar.b().a(NativeLicenseFeatures.DIGITAL_SIGNATURES)) {
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            ArrayList arrayList7 = this.f;
            int size5 = arrayList7.size();
            int i6 = 0;
            while (i6 < size5) {
                Object obj5 = arrayList7.get(i6);
                i6++;
                a aVar2 = (a) obj5;
                arrayList5.addAll(aVar2.d);
                arrayList6.addAll(aVar2.c);
            }
            int prevailingMotionEventToolType = getPrevailingMotionEventToolType();
            if (prevailingMotionEventToolType == 1) {
                inputMethod = BiometricSignatureData.InputMethod.FINGER;
            } else if (prevailingMotionEventToolType != 2) {
                inputMethod = prevailingMotionEventToolType != 3 ? null : BiometricSignatureData.InputMethod.MOUSE;
            } else {
                inputMethod = BiometricSignatureData.InputMethod.STYLUS;
            }
            if (this.f.isEmpty()) {
                fValueOf = null;
            } else {
                ArrayList arrayList8 = this.f;
                int size6 = arrayList8.size();
                while (i < size6) {
                    Object obj6 = arrayList8.get(i);
                    i++;
                    f += ((a) obj6).g;
                }
                fValueOf = Float.valueOf(f / this.f.size());
            }
            biometricSignatureData = new BiometricSignatureData(arrayList5, BiometricSignatureData.INSTANCE.normalizeTimePoints(arrayList6), fValueOf, inputMethod);
        } else {
            biometricSignatureData = null;
        }
        return Signature.INSTANCE.createInkSignature(this.k, 4.0f, arrayList2, biometricSignatureData, ((f7 - f8) * this.c) / this.h);
    }

    public int getInkColor() {
        return this.k;
    }

    public abstract int getSignHereStringRes();

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(this.a);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        PointF pointF;
        super.onDraw(canvas);
        float fA = a80.a(getContext(), 12);
        float fA2 = a();
        canvas.drawLine(fA, fA2, getWidth() - fA, fA2, this.a);
        if (this.m) {
            canvas.drawText(no.a(getContext(), getSignHereStringRes(), this), getWidth() / 2.0f, b(), this.a);
        } else {
            a(canvas);
        }
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            Object obj = arrayList.get(i);
            i++;
            a aVar = (a) obj;
            if (aVar.b.size() == 1) {
                pointF = aVar.b.isEmpty() ? null : (PointF) aVar.b.get(0);
                if (pointF != null) {
                    canvas.drawPoint(pointF.x, pointF.y, this.b);
                }
            } else {
                canvas.drawPath(aVar.a, this.b);
            }
        }
        a aVar2 = this.g;
        if (aVar2 != null) {
            int size2 = aVar2.b.size();
            a aVar3 = this.g;
            if (size2 != 1) {
                canvas.drawPath(aVar3.a, this.b);
                return;
            }
            pointF = aVar3.b.isEmpty() ? null : (PointF) aVar3.b.get(0);
            if (pointF != null) {
                canvas.drawPoint(pointF.x, pointF.y, this.b);
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.h = getWidth();
        int height = getHeight();
        this.i = height;
        float f = height / 200.0f;
        if (!ip.a(f, this.c) && !this.f.isEmpty()) {
            this.f = a(this.f, f / this.c);
        }
        this.c = f;
        float f2 = f * 4.0f;
        this.j = f2;
        this.b.setStrokeWidth(f2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        b bVar;
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        ArrayList arrayList = cVar.a;
        this.f = arrayList;
        this.m = cVar.b;
        this.n = cVar.c;
        if ((arrayList.isEmpty() && this.n == null) || (bVar = this.l) == null) {
            return;
        }
        bVar.a();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.a = a(this.f, 1.0f / this.c);
        cVar.b = this.m;
        cVar.c = this.n;
        return cVar;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            a(motionEvent);
        } else if (action == 1) {
            a aVar = this.g;
            if (aVar != null) {
                this.f.add(aVar);
                this.g = null;
                b bVar = this.l;
                if (bVar != null) {
                    bVar.b();
                }
            }
        } else if (action == 2) {
            float f = this.j;
            float fMax = (Math.max(this.c * 5.0f, 0.02f * f) + f) / 2.0f;
            PointF pointF = new PointF(Math.max(fMax, Math.min(motionEvent.getX(), this.h - fMax)), Math.max(fMax, Math.min(motionEvent.getY(), this.i - fMax)));
            if (Math.abs(this.d - pointF.x) > 4.0f || Math.abs(this.e - pointF.y) > 4.0f) {
                this.d = pointF.x;
                this.e = pointF.y;
                a aVar2 = this.g;
                if (aVar2 != null) {
                    aVar2.a(pointF, motionEvent.getEventTime(), motionEvent.getPressure(), motionEvent.getToolType(0), motionEvent.getSize());
                    b bVar2 = this.l;
                    if (bVar2 != null) {
                        bVar2.b();
                    }
                }
            }
        } else if (action == 3) {
            this.g = null;
        }
        invalidate();
        return true;
    }

    public void setActive(Boolean bool) {
    }

    public void setInkColor(int i) {
        this.k = i;
        this.b.setColor(i);
        invalidate();
    }

    public void setListener(b bVar) {
        this.l = bVar;
    }

    public static final class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new C0291a();
        public final Path a;
        public final ArrayList b;
        public final ArrayList c;
        public final ArrayList d;
        public int e;
        public final ArrayList f;
        public float g;

        /* JADX INFO: renamed from: com.pspdfkit.internal.ui.dialog.signatures.e$a$a, reason: collision with other inner class name */
        public class C0291a implements Parcelable.Creator<a> {
            @Override // android.os.Parcelable.Creator
            public final a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final a[] newArray(int i) {
                return new a[i];
            }
        }

        public a(PointF pointF, long j, float f, int i, float f2) {
            Path path = new Path();
            this.a = path;
            ArrayList arrayList = new ArrayList(200);
            this.b = arrayList;
            ArrayList arrayList2 = new ArrayList(200);
            this.c = arrayList2;
            ArrayList arrayList3 = new ArrayList(200);
            this.d = arrayList3;
            this.e = 0;
            ArrayList arrayList4 = new ArrayList(200);
            this.f = arrayList4;
            this.g = 0.0f;
            if (!arrayList.isEmpty()) {
                throw new IllegalStateException("Starting point is already set.");
            }
            arrayList.add(pointF);
            arrayList2.add(Long.valueOf(j));
            arrayList3.add(Float.valueOf(f));
            this.e = i;
            this.g = f2;
            arrayList4.add(Float.valueOf(f2));
            path.moveTo(pointF.x, pointF.y);
        }

        public final void a(ArrayList arrayList, List list, List list2, int i, float f) {
            a aVar;
            int i2;
            float f2;
            int i3 = 0;
            while (i3 < arrayList.size()) {
                if (i3 == 0) {
                    PointF pointF = (PointF) arrayList.get(i3);
                    Long l = (Long) list.get(i3);
                    l.longValue();
                    Float f3 = (Float) list2.get(i3);
                    f3.floatValue();
                    if (!this.b.isEmpty()) {
                        throw new IllegalStateException("Starting point is already set.");
                    }
                    this.b.add(pointF);
                    this.c.add(l);
                    this.d.add(f3);
                    this.e = i;
                    this.g = f;
                    this.f.add(Float.valueOf(f));
                    this.a.moveTo(pointF.x, pointF.y);
                    aVar = this;
                    i2 = i;
                    f2 = f;
                } else {
                    aVar = this;
                    i2 = i;
                    f2 = f;
                    aVar.a((PointF) arrayList.get(i3), ((Long) list.get(i3)).longValue(), ((Float) list2.get(i3)).floatValue(), i2, f2);
                }
                i3++;
                this = aVar;
                i = i2;
                f = f2;
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            long[] jArr;
            parcel.writeTypedList(this.b);
            parcel.writeInt(this.c.size());
            Long[] lArr = (Long[]) this.c.toArray(new Long[0]);
            float[] fArr = null;
            if (lArr == null) {
                jArr = null;
            } else {
                jArr = new long[lArr.length];
                for (int i2 = 0; i2 < lArr.length; i2++) {
                    jArr[i2] = lArr[i2].longValue();
                }
            }
            parcel.writeLongArray(jArr);
            parcel.writeInt(this.d.size());
            Float[] fArr2 = (Float[]) this.d.toArray(new Float[0]);
            if (fArr2 != null) {
                fArr = new float[fArr2.length];
                for (int i3 = 0; i3 < fArr2.length; i3++) {
                    fArr[i3] = fArr2[i3].floatValue();
                }
            }
            parcel.writeFloatArray(fArr);
            parcel.writeInt(this.e);
            parcel.writeFloat(this.g);
        }

        public final void a(PointF pointF, long j, float f, int i, float f2) {
            if (!this.b.isEmpty()) {
                ArrayList arrayList = this.b;
                PointF pointF2 = (PointF) arrayList.get(arrayList.size() - 1);
                Path path = this.a;
                float f3 = pointF2.x;
                float f4 = pointF2.y;
                path.quadTo(f3, f4, (pointF.x + f3) / 2.0f, (pointF.y + f4) / 2.0f);
                this.b.add(pointF);
                this.c.add(Long.valueOf(j));
                this.d.add(Float.valueOf(f));
                this.e = i;
                this.g = f2;
                this.f.add(Float.valueOf(f2));
                return;
            }
            throw new IllegalStateException("Starting point is not set.");
        }

        public a(ArrayList arrayList, List list, List list2, int i, float f) {
            this.a = new Path();
            this.b = new ArrayList(200);
            this.c = new ArrayList(200);
            this.d = new ArrayList(200);
            this.e = 0;
            this.f = new ArrayList(200);
            this.g = 0.0f;
            a(arrayList, list, list2, i, f);
        }

        public a(Parcel parcel) {
            this.a = new Path();
            this.b = new ArrayList(200);
            this.c = new ArrayList(200);
            this.d = new ArrayList(200);
            this.e = 0;
            this.f = new ArrayList(200);
            this.g = 0.0f;
            ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(PointF.CREATOR);
            int i = parcel.readInt();
            long[] jArr = new long[i];
            parcel.readLongArray(jArr);
            Long[] lArr = new Long[i];
            for (int i2 = 0; i2 < i; i2++) {
                lArr[i2] = Long.valueOf(jArr[i2]);
            }
            List listAsList = Arrays.asList(lArr);
            int i3 = parcel.readInt();
            float[] fArr = new float[i3];
            parcel.readFloatArray(fArr);
            Float[] fArr2 = new Float[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                fArr2[i4] = Float.valueOf(fArr[i4]);
            }
            a(arrayListCreateTypedArrayList, listAsList, Arrays.asList(fArr2), parcel.readInt(), parcel.readFloat());
        }
    }

    public static ArrayList a(List list, float f) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            ArrayList arrayList2 = new ArrayList(aVar.b.size());
            ArrayList arrayList3 = aVar.b;
            int size = arrayList3.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList3.get(i);
                i++;
                PointF pointF = (PointF) obj;
                arrayList2.add(new PointF(pointF.x * f, pointF.y * f));
            }
            arrayList.add(new a(arrayList2, aVar.c, aVar.d, aVar.e, aVar.g));
        }
        return arrayList;
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Paint();
        this.b = new Paint();
        this.c = 1.0f;
        this.f = new ArrayList();
        this.g = null;
        this.k = -16777216;
        this.m = true;
        this.n = null;
        g();
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Paint();
        this.b = new Paint();
        this.c = 1.0f;
        this.f = new ArrayList();
        this.g = null;
        this.k = -16777216;
        this.m = true;
        this.n = null;
        g();
    }
}
