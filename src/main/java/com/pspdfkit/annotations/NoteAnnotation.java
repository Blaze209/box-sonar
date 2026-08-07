package com.pspdfkit.annotations;

import android.graphics.RectF;
import androidx.media3.common.PlaybackException;
import com.pspdfkit.internal.j3;
import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.internal.uw;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public class NoteAnnotation extends Annotation {
    public static final String CHECK = "Check";
    public static final String CIRCLE = "Circle";
    public static final String COMMENT = "Comment";
    public static final String CROSS = "Cross";
    public static final String HELP = "Help";
    public static final String INSERT = "Insert";
    public static final String KEY = "Key";
    public static final String NEW_PARAGRAPH = "NewParagraph";
    public static final String NOTE = "Note";
    public static final String PARAGRAPH = "Paragraph";
    public static final String RIGHT_ARROW = "RightArrow";
    public static final String RIGHT_POINTER = "RightPointer";
    public static final String STAR = "Star";

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface IconName {
    }

    public NoteAnnotation(int i, RectF rectF, String str, String str2) {
        super(i);
        uw.a(rectF, "annotationRect", null);
        uw.a(str, "contents", null);
        j3 j3Var = this.propertyManager;
        j3Var.f.a(9, rectF, true);
        j3Var.l();
        j3 j3Var2 = this.propertyManager;
        j3Var2.f.a(3, str, true);
        j3Var2.l();
        j3 j3Var3 = this.propertyManager;
        j3Var3.f.a(4000, str2, true);
        j3Var3.l();
        j3 j3Var4 = this.propertyManager;
        j3Var4.f.a(PlaybackException.ERROR_CODE_DECODER_INIT_FAILED, Boolean.FALSE, true);
        j3Var4.l();
    }

    public String getIconName() {
        String strG = this.propertyManager.g(4000);
        return strG == null ? NOTE : strG;
    }

    @Override // com.pspdfkit.annotations.Annotation
    public AnnotationType getType() {
        return AnnotationType.NOTE;
    }

    public boolean isOpen() {
        return this.propertyManager.a(PlaybackException.ERROR_CODE_DECODER_INIT_FAILED);
    }

    @Override // com.pspdfkit.annotations.Annotation
    /* JADX INFO: renamed from: isResizable */
    public boolean getIsResizable() {
        return false;
    }

    @Override // com.pspdfkit.annotations.Annotation
    public void onBeforeAttachToDocument(NativeAnnotation nativeAnnotation) {
        super.onBeforeAttachToDocument(nativeAnnotation);
        if (getInternal().isInstantCommentThreadRoot()) {
            getInternal().syncToBackend();
        }
    }

    public void setIconName(String str) {
        uw.a(str, "iconName", "Note annotation icon name must not be null!");
        j3 j3Var = this.propertyManager;
        j3Var.f.a(4000, str, true);
        j3Var.l();
    }

    @Override // com.pspdfkit.annotations.Annotation
    public void updateTransformationProperties(RectF rectF, RectF rectF2) {
    }

    @Override // com.pspdfkit.annotations.Annotation
    public NoteAnnotation getCopy() {
        NoteAnnotation noteAnnotation = new NoteAnnotation(this.propertyManager, true);
        noteAnnotation.getInternal().prepareForCopy();
        return noteAnnotation;
    }

    public NoteAnnotation(j3 j3Var, boolean z) {
        super(j3Var, z);
    }
}
