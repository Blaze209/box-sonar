package com.pspdfkit.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.SoundAnnotation;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;

/* JADX INFO: loaded from: classes3.dex */
public final class y6 implements Parcelable {
    public static final a CREATOR = new a();
    public final wu a;
    public final boolean b;
    public final boolean c;
    public final int d;

    public static final class a implements Parcelable.Creator<y6> {
        @Override // android.os.Parcelable.Creator
        public final y6 createFromParcel(Parcel parcel) {
            parcel.getClass();
            return new y6(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final y6[] newArray(int i) {
            return new y6[i];
        }
    }

    public y6(SoundAnnotation soundAnnotation, boolean z, boolean z2, int i) {
        soundAnnotation.getClass();
        wu wuVar = new wu(soundAnnotation.getPageIndex(), soundAnnotation.getInternal().getUuid(), soundAnnotation.getObjectNumber());
        wuVar.d = soundAnnotation;
        this.a = wuVar;
        this.c = z;
        this.b = z2;
        this.d = i;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(lm lmVar, ContinuationImpl continuationImpl) {
        z6 z6Var;
        if (continuationImpl instanceof z6) {
            z6Var = (z6) continuationImpl;
            int i = z6Var.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                z6Var.d = i - Integer.MIN_VALUE;
            } else {
                z6Var = new z6(this, continuationImpl);
            }
        } else {
            z6Var = new z6(this, continuationImpl);
        }
        Object objA = z6Var.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = z6Var.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            wu wuVar = this.a;
            z6Var.a = SpillingKt.nullOutSpilledVariable(lmVar);
            z6Var.d = 1;
            objA = wuVar.a(lmVar, z6Var);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objA);
        }
        Annotation annotation = (Annotation) objA;
        if (annotation != null) {
            if (annotation.getType() != AnnotationType.SOUND) {
                annotation = null;
            }
            if (annotation != null && (annotation instanceof SoundAnnotation)) {
                return (SoundAnnotation) annotation;
            }
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeParcelable(this.a, 0);
        parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.d);
    }

    public y6(Parcel parcel) {
        Object parcelable = parcel.readParcelable(wu.class.getClassLoader(), wu.class);
        parcelable.getClass();
        this.a = (wu) parcelable;
        this.b = parcel.readByte() != 0;
        this.c = parcel.readByte() != 0;
        this.d = parcel.readInt();
    }
}
