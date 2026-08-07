package com.pspdfkit.annotations.appearance;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.activities.addcontent.CreateDocumentTaskActivity;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.document.providers.AssetDataProvider;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.internal.uw;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public class AssetAppearanceStreamGenerator implements AppearanceStreamGenerator, Parcelable {
    public static final Parcelable.Creator<AssetAppearanceStreamGenerator> CREATOR = new Parcelable.Creator<AssetAppearanceStreamGenerator>() { // from class: com.pspdfkit.annotations.appearance.AssetAppearanceStreamGenerator.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AssetAppearanceStreamGenerator createFromParcel(Parcel parcel) {
            return new AssetAppearanceStreamGenerator(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AssetAppearanceStreamGenerator[] newArray(int i) {
            return new AssetAppearanceStreamGenerator[i];
        }
    };
    private final String assetName;

    public AssetAppearanceStreamGenerator(String str) {
        uw.a(str, CreateDocumentTaskActivity.EXTRA_ASSET_NAME, null);
        this.assetName = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AssetAppearanceStreamGenerator) {
            return this.assetName.equals(((AssetAppearanceStreamGenerator) obj).assetName);
        }
        return false;
    }

    @Override // com.pspdfkit.annotations.appearance.AppearanceStreamGenerator
    public DataProvider getDataProviderForAnnotation(Annotation annotation, EnumSet<AppearanceStreamGenerator.AppearanceStreamGenerationOptions> enumSet) {
        return new AssetDataProvider(this.assetName);
    }

    public int hashCode() {
        return this.assetName.hashCode();
    }

    @Override // com.pspdfkit.annotations.appearance.AppearanceStreamGenerator
    public boolean shouldUseGeneratorForAnnotation(Annotation annotation) {
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.assetName);
    }

    public AssetAppearanceStreamGenerator(Parcel parcel) {
        this.assetName = parcel.readString();
    }
}
