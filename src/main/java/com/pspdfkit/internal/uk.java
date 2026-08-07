package com.pspdfkit.internal;

import androidx.media3.common.MimeTypes;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.instant.exceptions.InstantException;
import com.pspdfkit.instant.internal.jni.NativeAssetResult;
import com.pspdfkit.utils.PdfLog;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class uk extends c1 implements gl, il.c {
    public final il h;
    public String i;
    public final go<gl.b> j;
    public gl.a k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uk(il ilVar, Annotation annotation) {
        super(annotation);
        ilVar.getClass();
        annotation.getClass();
        this.h = ilVar;
        this.j = new go<>();
        this.a = true;
        this.b = true;
        this.k = gl.a.NOT_LOADED;
    }

    @Override // com.pspdfkit.internal.il.c
    public final void a(String str) {
        str.getClass();
        if (Intrinsics.areEqual(str, this.i)) {
            this.k = gl.a.DOWNLOADING;
            Iterator<gl.b> it = this.j.iterator();
            it.getClass();
            while (it.hasNext()) {
                it.next().j();
            }
        }
    }

    @Override // com.pspdfkit.internal.il.c
    public final void b(String str) {
        str.getClass();
        if (Intrinsics.areEqual(str, this.i)) {
            this.h.c.a.b(this);
            this.c.getInternal().syncToBackend();
            Iterator<gl.b> it = this.j.iterator();
            it.getClass();
            while (it.hasNext()) {
                it.next().k();
            }
        }
    }

    @Override // com.pspdfkit.internal.k4
    public final void c() {
        this.h.c.a.b(this);
    }

    @Override // com.pspdfkit.internal.c1, com.pspdfkit.internal.k4
    public final boolean d() {
        fl flVarA;
        if (this.c.isAttached() && this.a) {
            String str = this.i;
            if (str == null) {
                return super.d();
            }
            try {
                il ilVar = this.h;
                synchronized (ilVar) {
                    NativeAssetResult nativeAssetResultAssetForIdentifier = ilVar.b.assetForIdentifier(str);
                    if (nativeAssetResultAssetForIdentifier.isError()) {
                        throw lr.a(nativeAssetResultAssetForIdentifier.error());
                    }
                    flVarA = il.a(nativeAssetResultAssetForIdentifier.value());
                }
                int iA = y30.a(flVarA.c);
                if (iA != 0) {
                    if (iA == 2 || iA == 3) {
                        this.h.c.a.a(this);
                        this.h.a(flVarA.a);
                        return false;
                    }
                    if (iA != 4) {
                        return false;
                    }
                }
                this.k = gl.a.LOADED;
                this.h.getClass();
                this.g = il.a(flVarA);
                return super.d();
            } catch (InstantException e) {
                this.k = gl.a.ERROR;
                PdfLog.d("Nutri.InstAnnotBitmapRs", e, "Could not load asset for %s", this.c);
            }
        }
        return false;
    }

    @Override // com.pspdfkit.internal.k4
    public final boolean e() {
        byte[] bArrF;
        fl flVarA;
        if (!this.c.isAttached() || !this.a || this.i != null || (bArrF = f()) == null) {
            return false;
        }
        try {
            il ilVar = this.h;
            synchronized (ilVar) {
                NativeAssetResult nativeAssetResultImportData = ilVar.b.importData(bArrF, MimeTypes.IMAGE_JPEG);
                if (nativeAssetResultImportData.isError()) {
                    throw lr.a(nativeAssetResultImportData.error());
                }
                flVarA = il.a(nativeAssetResultImportData.value());
            }
            this.i = flVarA.a;
            this.c.getInternal().setAdditionalData("imageAttachmentId", flVarA.a, false);
            this.c.getInternal().setAdditionalData("contentType", MimeTypes.IMAGE_JPEG, true);
            return true;
        } catch (InstantException e) {
            PdfLog.e("Nutri.InstAnnotBitmapRs", e, "Could not import asset for %s", this.c);
            return false;
        }
    }

    @Override // com.pspdfkit.internal.c1
    public final boolean g() {
        return this.i != null || super.g();
    }

    @Override // com.pspdfkit.internal.il.c
    public final void a(String str, InstantException instantException) {
        str.getClass();
        if (Intrinsics.areEqual(str, this.i)) {
            this.k = gl.a.ERROR;
            PdfLog.d("Nutri.InstAnnotBitmapRs", instantException, "Could not download asset for %s", this.c);
            Iterator<gl.b> it = this.j.iterator();
            it.getClass();
            while (it.hasNext()) {
                it.next().c();
            }
        }
    }

    @Override // com.pspdfkit.internal.gl
    public final gl.a b() {
        return this.k;
    }

    @Override // com.pspdfkit.internal.gl
    public final void b(hl hlVar) {
        this.j.a(hlVar);
    }

    @Override // com.pspdfkit.internal.gl
    public final void a(hl hlVar) {
        this.j.b(hlVar);
    }

    @Override // com.pspdfkit.internal.gl
    public final boolean a() {
        return this.k == gl.a.LOADED;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public uk(il ilVar, Annotation annotation, String str) {
        this(ilVar, annotation);
        ilVar.getClass();
        annotation.getClass();
        str.getClass();
        this.i = str;
        this.b = false;
    }
}
