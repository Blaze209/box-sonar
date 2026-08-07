package com.pspdfkit.annotations;

import android.graphics.RectF;
import com.pspdfkit.document.files.EmbeddedFile;
import com.pspdfkit.document.files.EmbeddedFileSource;
import com.pspdfkit.internal.d2;
import com.pspdfkit.internal.j3;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.wf;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public class FileAnnotation extends Annotation {
    public static final String GRAPH = "Graph";
    public static final String PAPERCLIP = "Paperclip";
    public static final String PUSH_PIN = "PushPin";
    public static final String TAG = "Tag";
    private d2 fileResource;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface IconName {
    }

    public FileAnnotation(int i, RectF rectF, EmbeddedFileSource embeddedFileSource) {
        super(i);
        uw.a(rectF, "boundingBox", null);
        uw.a(embeddedFileSource, "embeddedFileSource", null);
        setBoundingBox(rectF);
        setIconName(PUSH_PIN);
        setContents(embeddedFileSource.getFileDescription());
        d2 d2Var = new d2(this, embeddedFileSource);
        this.fileResource = d2Var;
        this.propertyManager.a(d2Var);
    }

    public EmbeddedFile getFile() {
        wf wfVar;
        synchronized (this) {
            d2 d2Var = this.fileResource;
            if (d2Var == null || (wfVar = d2Var.e) == null) {
                wfVar = null;
            } else {
                wfVar.a();
            }
        }
        return wfVar;
    }

    public String getIconName() {
        String strG = this.propertyManager.g(4000);
        return strG == null ? PUSH_PIN : strG;
    }

    @Override // com.pspdfkit.annotations.Annotation
    public AnnotationType getType() {
        return AnnotationType.FILE;
    }

    @Override // com.pspdfkit.annotations.Annotation
    public boolean isLocked() {
        return true;
    }

    @Override // com.pspdfkit.annotations.Annotation
    /* JADX INFO: renamed from: isResizable */
    public boolean getIsResizable() {
        return false;
    }

    public void setFileSource(EmbeddedFileSource embeddedFileSource) {
        uw.a(embeddedFileSource, "fileSource", null);
        synchronized (this) {
            d2 d2Var = new d2(this, embeddedFileSource);
            this.fileResource = d2Var;
            this.propertyManager.a(d2Var);
            setContents(embeddedFileSource.getFileDescription());
        }
    }

    public void setIconName(String str) {
        uw.a(str, str, "File annotation icon name must not be null.");
        j3 j3Var = this.propertyManager;
        j3Var.f.a(4000, str, true);
        j3Var.l();
    }

    @Override // com.pspdfkit.annotations.Annotation
    public void updateTransformationProperties(RectF rectF, RectF rectF2) {
    }

    public FileAnnotation(j3 j3Var, boolean z, String str) {
        super(j3Var, z);
        if (str != null) {
            d2 d2Var = new d2(this, str);
            this.fileResource = d2Var;
            this.propertyManager.a(d2Var);
        }
    }
}
