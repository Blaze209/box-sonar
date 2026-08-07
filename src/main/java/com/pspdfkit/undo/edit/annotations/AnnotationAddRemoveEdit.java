package com.pspdfkit.undo.edit.annotations;

import android.graphics.Bitmap;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.SoundAnnotation;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.annotations.appearance.AppearanceStreamGenerator;
import com.pspdfkit.annotations.sound.EmbeddedAudioSource;
import com.pspdfkit.internal.j3;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u00010B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0019\u0010,\u001a\u0004\u0018\u00010+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00061"}, d2 = {"Lcom/pspdfkit/undo/edit/annotations/AnnotationAddRemoveEdit;", "Lcom/pspdfkit/undo/edit/annotations/AnnotationEdit;", "Lcom/pspdfkit/annotations/Annotation;", "annotation", "Lcom/pspdfkit/undo/edit/annotations/AnnotationAddRemoveEdit$Type;", "type", "<init>", "(Lcom/pspdfkit/annotations/Annotation;Lcom/pspdfkit/undo/edit/annotations/AnnotationAddRemoveEdit$Type;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lcom/pspdfkit/undo/edit/annotations/AnnotationAddRemoveEdit$Type;", "getType", "()Lcom/pspdfkit/undo/edit/annotations/AnnotationAddRemoveEdit$Type;", "Lcom/pspdfkit/internal/j3;", "properties", "Lcom/pspdfkit/internal/j3;", "getProperties", "()Lcom/pspdfkit/internal/j3;", "Lcom/pspdfkit/annotations/AnnotationType;", "annotationType", "Lcom/pspdfkit/annotations/AnnotationType;", "getAnnotationType", "()Lcom/pspdfkit/annotations/AnnotationType;", "Landroid/graphics/Bitmap;", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "Lcom/pspdfkit/annotations/sound/EmbeddedAudioSource;", "audioData", "Lcom/pspdfkit/annotations/sound/EmbeddedAudioSource;", "getAudioData", "()Lcom/pspdfkit/annotations/sound/EmbeddedAudioSource;", "setAudioData", "(Lcom/pspdfkit/annotations/sound/EmbeddedAudioSource;)V", "Lcom/pspdfkit/annotations/appearance/AppearanceStreamGenerator;", "appearanceStreamGenerator", "Lcom/pspdfkit/annotations/appearance/AppearanceStreamGenerator;", "getAppearanceStreamGenerator", "()Lcom/pspdfkit/annotations/appearance/AppearanceStreamGenerator;", "Type", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AnnotationAddRemoveEdit extends AnnotationEdit {
    public static final int $stable = 8;
    private final AnnotationType annotationType;
    private final AppearanceStreamGenerator appearanceStreamGenerator;
    private EmbeddedAudioSource audioData;
    private Bitmap bitmap;
    private final j3 properties;
    private final Type type;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/pspdfkit/undo/edit/annotations/AnnotationAddRemoveEdit$Type;", "", "<init>", "(Ljava/lang/String;I)V", "ADD_ANNOTATION", "REMOVE_ANNOTATION", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum Type {
        ADD_ANNOTATION,
        REMOVE_ANNOTATION;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnotationAddRemoveEdit(Annotation annotation, Type type) {
        super(annotation.getPageIndex(), annotation.getObjectNumber());
        annotation.getClass();
        type.getClass();
        this.type = type;
        j3 properties = annotation.getInternal().getProperties();
        properties.getClass();
        j3 j3Var = new j3();
        j3Var.a(properties, false);
        this.properties = j3Var;
        AnnotationType type2 = annotation.getType();
        this.annotationType = type2;
        this.appearanceStreamGenerator = annotation.get_appearanceStreamGenerator();
        if (type2 == AnnotationType.STAMP) {
            this.bitmap = ((StampAnnotation) annotation).getBitmap();
        } else {
            this.bitmap = null;
        }
        if (type2 != AnnotationType.SOUND) {
            this.audioData = null;
            return;
        }
        SoundAnnotation soundAnnotation = (SoundAnnotation) annotation;
        byte[] audioData = soundAnnotation.getAudioData();
        if (audioData != null) {
            this.audioData = new EmbeddedAudioSource(audioData, soundAnnotation.getAudioEncoding(), soundAnnotation.getSampleRate(), soundAnnotation.getSampleSize(), soundAnnotation.getChannels(), (String) null);
        } else {
            this.audioData = null;
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnnotationAddRemoveEdit)) {
            return false;
        }
        AnnotationAddRemoveEdit annotationAddRemoveEdit = (AnnotationAddRemoveEdit) other;
        return Intrinsics.areEqual(this.properties, annotationAddRemoveEdit.properties) && this.annotationType == annotationAddRemoveEdit.annotationType && this.type == annotationAddRemoveEdit.type && Intrinsics.areEqual(this.bitmap, annotationAddRemoveEdit.bitmap) && Intrinsics.areEqual(this.audioData, annotationAddRemoveEdit.audioData) && Intrinsics.areEqual(this.appearanceStreamGenerator, annotationAddRemoveEdit.appearanceStreamGenerator);
    }

    public final AnnotationType getAnnotationType() {
        return this.annotationType;
    }

    public final AppearanceStreamGenerator getAppearanceStreamGenerator() {
        return this.appearanceStreamGenerator;
    }

    public final EmbeddedAudioSource getAudioData() {
        return this.audioData;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final j3 getProperties() {
        return this.properties;
    }

    public final Type getType() {
        return this.type;
    }

    public int hashCode() {
        return Objects.hash(this.properties, this.annotationType, this.type, this.bitmap, this.appearanceStreamGenerator);
    }

    public final void setAudioData(EmbeddedAudioSource embeddedAudioSource) {
        this.audioData = embeddedAudioSource;
    }

    public final void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
