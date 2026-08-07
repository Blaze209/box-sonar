package com.pspdfkit.annotations.appearance;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.document.providers.ContentResolverDataProvider;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.internal.uw;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public class ContentResolverAppearanceStreamGenerator implements AppearanceStreamGenerator, Parcelable {
    public static final Parcelable.Creator<ContentResolverAppearanceStreamGenerator> CREATOR = new Parcelable.Creator<ContentResolverAppearanceStreamGenerator>() { // from class: com.pspdfkit.annotations.appearance.ContentResolverAppearanceStreamGenerator.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContentResolverAppearanceStreamGenerator createFromParcel(Parcel parcel) {
            return new ContentResolverAppearanceStreamGenerator(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContentResolverAppearanceStreamGenerator[] newArray(int i) {
            return new ContentResolverAppearanceStreamGenerator[i];
        }
    };
    private final Uri uri;

    public ContentResolverAppearanceStreamGenerator(Uri uri) {
        uw.a(uri, "uri", null);
        this.uri = uri;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ContentResolverAppearanceStreamGenerator) {
            return this.uri.equals(((ContentResolverAppearanceStreamGenerator) obj).uri);
        }
        return false;
    }

    @Override // com.pspdfkit.annotations.appearance.AppearanceStreamGenerator
    public DataProvider getDataProviderForAnnotation(Annotation annotation, EnumSet<AppearanceStreamGenerator.AppearanceStreamGenerationOptions> enumSet) {
        return new ContentResolverDataProvider(this.uri);
    }

    public int hashCode() {
        return this.uri.hashCode();
    }

    @Override // com.pspdfkit.annotations.appearance.AppearanceStreamGenerator
    public boolean shouldUseGeneratorForAnnotation(Annotation annotation) {
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.uri, i);
    }

    public ContentResolverAppearanceStreamGenerator(Parcel parcel) {
        this.uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }
}
