package com.pspdfkit.ui.special_mode.controller;

import android.os.Parcel;
import android.os.Parcelable;
import com.pspdfkit.internal.uw;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationToolVariant implements Parcelable {
    private final String name;
    private static final AnnotationToolVariant DEFAULT_VARIANT = fromPreset(Preset.DEFAULT);
    public static final Parcelable.Creator<AnnotationToolVariant> CREATOR = new Parcelable.Creator<AnnotationToolVariant>() { // from class: com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AnnotationToolVariant createFromParcel(Parcel parcel) {
            return new AnnotationToolVariant(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AnnotationToolVariant[] newArray(int i) {
            return new AnnotationToolVariant[i];
        }
    };

    public enum Preset {
        DEFAULT(null),
        PEN("Pen"),
        HIGHLIGHTER("Highlighter"),
        ARROW("Arrow"),
        MAGIC("Magic"),
        CALLOUT("Callout"),
        CLOUDY("Cloudy"),
        DASHED("Dashed");

        private final String name;

        Preset(String str) {
            this.name = str;
        }

        public String getName() {
            return this.name;
        }
    }

    private AnnotationToolVariant(String str) {
        this.name = str;
    }

    public static AnnotationToolVariant defaultVariant() {
        return DEFAULT_VARIANT;
    }

    public static AnnotationToolVariant fromName(String str) {
        uw.a(str, "variantName", "Annotation tool variant must have a name specified if initialized via AnnotationToolVariant#fromName().If you want to use the default tool variant, please use AnnotationToolVariant#defaultVariant() static creator.");
        return new AnnotationToolVariant(str);
    }

    public static AnnotationToolVariant fromPreset(Preset preset) {
        uw.a(preset, "preset", null);
        return new AnnotationToolVariant(preset.name);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AnnotationToolVariant)) {
            return false;
        }
        String str = ((AnnotationToolVariant) obj).name;
        if (str == null && this.name == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(this.name);
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return Objects.hash(this.name);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
    }

    public AnnotationToolVariant(Parcel parcel) {
        this.name = parcel.readString();
    }
}
