package com.pspdfkit.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.pspdfkit.annotations.Annotation;

/* JADX INFO: loaded from: classes3.dex */
public final class wu implements Parcelable {
    public static final Parcelable.Creator<wu> CREATOR = new a();
    public final int a;
    public final String b;
    public final int c;
    public Annotation d;

    public static final class a implements Parcelable.Creator<wu> {
        @Override // android.os.Parcelable.Creator
        public final wu createFromParcel(Parcel parcel) {
            parcel.getClass();
            return new wu(parcel.readInt(), parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final wu[] newArray(int i) {
            return new wu[i];
        }
    }

    public wu(int i, String str, int i2) {
        str.getClass();
        this.a = i;
        this.b = str;
        this.c = i2;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009c, code lost:
    
        if (r10 == r1) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(com.pspdfkit.internal.lm r9, kotlin.coroutines.jvm.internal.ContinuationImpl r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.pspdfkit.internal.xu
            if (r0 == 0) goto L13
            r0 = r10
            com.pspdfkit.internal.xu r0 = (com.pspdfkit.internal.xu) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            com.pspdfkit.internal.xu r0 = new com.pspdfkit.internal.xu
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L49
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r9 = r0.b
            com.pspdfkit.internal.o3 r9 = (com.pspdfkit.internal.o3) r9
            java.lang.Object r9 = r0.a
            com.pspdfkit.internal.lm r9 = (com.pspdfkit.internal.lm) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L9f
        L35:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3d:
            java.lang.Object r9 = r0.b
            com.pspdfkit.internal.o3 r9 = (com.pspdfkit.internal.o3) r9
            java.lang.Object r2 = r0.a
            com.pspdfkit.internal.lm r2 = (com.pspdfkit.internal.lm) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L7f
        L49:
            kotlin.ResultKt.throwOnFailure(r10)
            com.pspdfkit.annotations.Annotation r10 = r8.d
            if (r10 == 0) goto L5f
            com.pspdfkit.internal.bm r2 = r10.getInternal()
            com.pspdfkit.internal.lm r2 = r2.getInternalDocument()
            if (r2 != r9) goto L5b
            goto L5c
        L5b:
            r10 = 0
        L5c:
            if (r10 == 0) goto L5f
            return r10
        L5f:
            com.pspdfkit.internal.o3 r10 = r9.getAnnotationProvider()
            int r2 = r8.a
            java.lang.String r5 = r8.b
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.a = r6
            r0.b = r10
            r0.e = r4
            r10.getClass()
            java.lang.Object r2 = com.pspdfkit.internal.o3.a(r10, r2, r5, r0)
            if (r2 != r1) goto L7b
            goto L9e
        L7b:
            r7 = r2
            r2 = r9
            r9 = r10
            r10 = r7
        L7f:
            com.pspdfkit.annotations.Annotation r10 = (com.pspdfkit.annotations.Annotation) r10
            if (r10 != 0) goto La1
            int r10 = r8.a
            int r4 = r8.c
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.a = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.b = r2
            r0.e = r3
            r9.getClass()
            java.lang.Object r10 = com.pspdfkit.internal.o3.a(r9, r10, r4, r0)
            if (r10 != r1) goto L9f
        L9e:
            return r1
        L9f:
            com.pspdfkit.annotations.Annotation r10 = (com.pspdfkit.annotations.Annotation) r10
        La1:
            if (r10 == 0) goto La5
            r8.d = r10
        La5:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.wu.a(com.pspdfkit.internal.lm, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public wu(Annotation annotation) {
        this(annotation.getPageIndex(), annotation.getInternal().getUuid(), annotation.getObjectNumber());
        annotation.getClass();
        this.d = annotation;
    }
}
