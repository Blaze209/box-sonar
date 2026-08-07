package com.pspdfkit.annotations.stamps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.annotations.appearance.AppearanceStreamGenerator;
import com.pspdfkit.configuration.rendering.AnnotationRenderConfiguration;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.h4;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.q10;
import com.pspdfkit.internal.uw;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class StampPickerItem implements Parcelable {
    public static final Parcelable.Creator<StampPickerItem> CREATOR = new Parcelable.Creator<StampPickerItem>() { // from class: com.pspdfkit.annotations.stamps.StampPickerItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StampPickerItem createFromParcel(Parcel parcel) {
            return new StampPickerItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StampPickerItem[] newArray(int i) {
            return new StampPickerItem[i];
        }
    };
    public static final float DEFAULT_STAMP_ANNOTATION_ASPECT_RATIO = 0.33333334f;
    public static final float DEFAULT_STAMP_ANNOTATION_PDF_HEIGHT = 70.0f;
    public static final float DEFAULT_STAMP_ANNOTATION_PDF_WIDTH = 210.0f;
    private final AppearanceStreamGenerator appearanceStreamGenerator;
    private final Bitmap bitmap;
    private Bitmap cachedAppearanceStreamBitmap;
    private final boolean customStamp;
    private final float defaultPdfHeight;
    private final float defaultPdfWidth;
    private final StampType stampType;
    private final String subtitle;
    private final Integer textColor;
    private final String title;

    private StampPickerItem(StampType stampType, String str, String str2, float f, float f2, Integer num, Bitmap bitmap, boolean z, AppearanceStreamGenerator appearanceStreamGenerator) {
        this.stampType = stampType;
        this.title = str;
        this.subtitle = str2;
        this.defaultPdfWidth = f;
        this.defaultPdfHeight = f2;
        this.textColor = num;
        this.bitmap = bitmap;
        this.customStamp = z;
        this.appearanceStreamGenerator = appearanceStreamGenerator;
        if (bitmap != null && str != null) {
            throw new IllegalArgumentException("Bitmap can't be used with localized stampType");
        }
        if (bitmap != null && str2 != null) {
            throw new IllegalArgumentException("Bitmap can't be used with subtitle");
        }
        if (bitmap != null && num != null) {
            throw new IllegalArgumentException("Bitmap can't be used with text color");
        }
        if (appearanceStreamGenerator != null && !(appearanceStreamGenerator instanceof Parcelable)) {
            throw new IllegalArgumentException("Appearance stream generator must be parcelable");
        }
    }

    public static BitmapStampBuilder fromBitmap(Bitmap bitmap) {
        uw.a(bitmap, "bitmap", null);
        return new BitmapStampBuilder(bitmap);
    }

    public static Builder fromPredefinedType(Context context, PredefinedStampType predefinedStampType) {
        uw.a(context, "context", null);
        uw.a(predefinedStampType, "predefinedStampType", null);
        return new Builder(context, predefinedStampType);
    }

    public static Builder fromStampType(Context context, StampType stampType) {
        return new Builder(context, stampType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder fromTitle(Context context, String str) {
        uw.a(context, "context", null);
        uw.a(str, "title", null);
        return new Builder(context, (StampType) null).withTitle(str);
    }

    public static List<StampPickerItem> getDefaultStampPickerItems(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(fromPredefinedType(context, PredefinedStampType.APPROVED).build());
        arrayList.add(fromPredefinedType(context, PredefinedStampType.NOT_APPROVED).build());
        arrayList.add(fromPredefinedType(context, PredefinedStampType.DRAFT).build());
        arrayList.add(fromPredefinedType(context, PredefinedStampType.FINAL).build());
        arrayList.add(fromPredefinedType(context, PredefinedStampType.COMPLETED).build());
        arrayList.add(fromPredefinedType(context, PredefinedStampType.CONFIDENTIAL).build());
        arrayList.add(fromPredefinedType(context, PredefinedStampType.FOR_PUBLIC_RELEASE).build());
        arrayList.add(fromPredefinedType(context, PredefinedStampType.NOT_FOR_PUBLIC_RELEASE).build());
        arrayList.add(fromPredefinedType(context, PredefinedStampType.FOR_COMMENT).build());
        arrayList.add(fromPredefinedType(context, PredefinedStampType.VOID).build());
        arrayList.add(fromPredefinedType(context, PredefinedStampType.PRELIMINARY_RESULTS).build());
        arrayList.add(fromPredefinedType(context, PredefinedStampType.INFORMATION_ONLY).build());
        arrayList.add(fromPredefinedType(context, PredefinedStampType.ACCEPTED).build());
        PredefinedStampType predefinedStampType = PredefinedStampType.REJECTED;
        arrayList.add(fromPredefinedType(context, predefinedStampType).build());
        arrayList.add(fromPredefinedType(context, PredefinedStampType.INITIAL_HERE).build());
        arrayList.add(fromPredefinedType(context, PredefinedStampType.SIGN_HERE).build());
        arrayList.add(fromPredefinedType(context, PredefinedStampType.WITNESS).build());
        arrayList.add(fromPredefinedType(context, PredefinedStampType.CUSTOM).build());
        arrayList.add(fromPredefinedType(context, PredefinedStampType.REVISED).withDateTimeSubtitle(true, true).build());
        arrayList.add(fromPredefinedType(context, predefinedStampType).withDateTimeSubtitle(true, true).build());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SingleSource lambda$renderAppearanceStreamToBitmapAsync$0(Context context) throws Throwable {
        StampAnnotation stampAnnotationCreateStampAnnotation = createStampAnnotation(0);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return h4.a(this.appearanceStreamGenerator, stampAnnotationCreateStampAnnotation, Bitmap.createBitmap((int) TypedValue.applyDimension(3, this.defaultPdfWidth, displayMetrics), (int) TypedValue.applyDimension(3, this.defaultPdfHeight, displayMetrics), Bitmap.Config.ARGB_8888), new AnnotationRenderConfiguration.Builder().build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$renderAppearanceStreamToBitmapAsync$1(Bitmap bitmap) throws Throwable {
        this.cachedAppearanceStreamBitmap = bitmap;
    }

    public StampAnnotation createStampAnnotation(int i) {
        if (this.bitmap != null) {
            return new StampAnnotation(i, new RectF(0.0f, getDefaultPdfHeight(), getDefaultPdfWidth(), 0.0f), this.bitmap);
        }
        StampAnnotation stampAnnotation = new StampAnnotation(i, new RectF(0.0f, getDefaultPdfHeight(), getDefaultPdfWidth(), 0.0f), getStampType());
        stampAnnotation.setTitle(getTitle());
        stampAnnotation.setSubtitle(getSubtitle());
        Integer num = this.textColor;
        if (num != null) {
            stampAnnotation.setColor(num.intValue());
        }
        AppearanceStreamGenerator appearanceStreamGenerator = this.appearanceStreamGenerator;
        if (appearanceStreamGenerator != null) {
            stampAnnotation.setAppearanceStreamGenerator(appearanceStreamGenerator);
        }
        return stampAnnotation;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AppearanceStreamGenerator getAppearanceStreamGenerator() {
        return this.appearanceStreamGenerator;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public float getDefaultPdfHeight() {
        return this.defaultPdfHeight;
    }

    public float getDefaultPdfWidth() {
        return this.defaultPdfWidth;
    }

    public StampType getStampType() {
        return this.stampType;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public Integer getTextColor() {
        return this.textColor;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isCustomStamp() {
        return this.customStamp;
    }

    public StampPickerItem mutate() {
        return new StampPickerItem(getStampType(), getTitle(), getSubtitle(), getDefaultPdfWidth(), getDefaultPdfHeight(), getTextColor(), getBitmap(), isCustomStamp(), getAppearanceStreamGenerator());
    }

    public Single<Bitmap> renderAppearanceStreamToBitmapAsync(final Context context) {
        uw.a(context, "context", null);
        if (this.appearanceStreamGenerator == null) {
            return Single.error(new IllegalStateException("Can't render item appearance when appearanceStreamGenerator is not set"));
        }
        Bitmap bitmap = this.cachedAppearanceStreamBitmap;
        if (bitmap != null) {
            return Single.just(bitmap);
        }
        Single singleDefer = Single.defer(new Supplier() { // from class: com.pspdfkit.annotations.stamps.StampPickerItem$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return this.f$0.lambda$renderAppearanceStreamToBitmapAsync$0(context);
            }
        });
        synchronized (ar.class) {
            q10.c();
        }
        Scheduler schedulerIo = Schedulers.io();
        schedulerIo.getClass();
        return singleDefer.subscribeOn(schedulerIo).doOnSuccess(new Consumer() { // from class: com.pspdfkit.annotations.stamps.StampPickerItem$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.lambda$renderAppearanceStreamToBitmapAsync$1((Bitmap) obj);
            }
        });
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.stampType, 0);
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        parcel.writeFloat(this.defaultPdfWidth);
        parcel.writeFloat(this.defaultPdfHeight);
        if (this.textColor == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.textColor.intValue());
        }
        parcel.writeParcelable(this.bitmap, 0);
        parcel.writeByte(this.customStamp ? (byte) 1 : (byte) 0);
        AppearanceStreamGenerator appearanceStreamGenerator = this.appearanceStreamGenerator;
        if (appearanceStreamGenerator instanceof Parcelable) {
            parcel.writeParcelable((Parcelable) appearanceStreamGenerator, 0);
        }
        Bitmap bitmap = this.cachedAppearanceStreamBitmap;
        if (bitmap != null) {
            parcel.writeValue(bitmap);
        }
    }

    public static class BitmapStampBuilder {
        private final Bitmap bitmap;
        private float pdfHeight;
        private float pdfWidth;

        private BitmapStampBuilder(Bitmap bitmap) {
            this.bitmap = bitmap;
            withSize(210.0f);
        }

        public StampPickerItem build() {
            return new StampPickerItem(null, null, null, this.pdfWidth, this.pdfHeight, null, this.bitmap, false, null);
        }

        public BitmapStampBuilder withSize(float f, float f2) {
            this.pdfWidth = f;
            this.pdfHeight = f2;
            return this;
        }

        public BitmapStampBuilder withSize(float f) {
            this.pdfWidth = f;
            this.pdfHeight = (f * this.bitmap.getHeight()) / this.bitmap.getWidth();
            return this;
        }
    }

    public static class Builder {
        private AppearanceStreamGenerator appearanceStreamGenerator;
        private final Context context;
        private boolean isCustom;
        private Float pdfHeight;
        private Float pdfWidth;
        private PredefinedStampType predefinedStampType;
        private final StampType stampType;
        private String subtitle;
        private Integer textColor;
        private String title;

        private Builder(Context context, PredefinedStampType predefinedStampType) {
            this.pdfWidth = null;
            this.pdfHeight = null;
            this.context = context;
            this.predefinedStampType = predefinedStampType;
            this.title = no.a(context, predefinedStampType.getTitleResId(), null);
            this.stampType = predefinedStampType.getStampType();
            this.isCustom = predefinedStampType == PredefinedStampType.CUSTOM;
        }

        public StampPickerItem build() {
            PredefinedStampType predefinedStampType;
            if (this.pdfWidth == null || this.pdfHeight == null) {
                if (this.predefinedStampType != null && TextUtils.isEmpty(this.subtitle) && ((predefinedStampType = this.predefinedStampType) == PredefinedStampType.ACCEPTED || predefinedStampType == PredefinedStampType.REJECTED)) {
                    withSize(210.0f);
                } else {
                    withSize(210.0f, 70.0f);
                }
            }
            StampPickerItem stampPickerItem = new StampPickerItem(this.stampType, this.title, this.subtitle, this.pdfWidth.floatValue(), this.pdfHeight.floatValue(), this.textColor, null, this.isCustom, this.appearanceStreamGenerator);
            if (stampPickerItem.getAppearanceStreamGenerator() != null) {
                stampPickerItem.renderAppearanceStreamToBitmapAsync(this.context).subscribe();
            }
            return stampPickerItem;
        }

        public Builder withAppearanceStreamGenerator(AppearanceStreamGenerator appearanceStreamGenerator) {
            if (!(appearanceStreamGenerator instanceof Parcelable)) {
                throw new IllegalArgumentException("Appearance stream generator must be parcelable");
            }
            this.appearanceStreamGenerator = appearanceStreamGenerator;
            return this;
        }

        public Builder withDateTimeSubtitle(boolean z, boolean z2) {
            if (z && z2) {
                this.subtitle = no.c(this.context);
                return this;
            }
            if (z) {
                this.subtitle = no.b(this.context);
                return this;
            }
            if (z2) {
                this.subtitle = no.d(this.context);
            }
            return this;
        }

        public Builder withSize(float f, float f2) {
            this.pdfWidth = Float.valueOf(f);
            this.pdfHeight = Float.valueOf(f2);
            return this;
        }

        public Builder withSubtitle(String str) {
            this.subtitle = str;
            return this;
        }

        public Builder withTextColor(Integer num) {
            this.textColor = num;
            return this;
        }

        public Builder withTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder withSize(float f) {
            this.pdfWidth = Float.valueOf(f);
            this.pdfHeight = Float.valueOf(f);
            return this;
        }

        private Builder(Context context, StampType stampType) {
            this.pdfWidth = null;
            this.pdfHeight = null;
            this.context = context;
            this.stampType = stampType;
        }
    }

    private StampPickerItem(Parcel parcel) {
        this.stampType = (StampType) parcel.readParcelable(StampType.class.getClassLoader());
        this.title = parcel.readString();
        this.subtitle = parcel.readString();
        this.defaultPdfWidth = parcel.readFloat();
        this.defaultPdfHeight = parcel.readFloat();
        this.textColor = parcel.readByte() == 0 ? null : Integer.valueOf(parcel.readInt());
        this.bitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.customStamp = parcel.readByte() != 0;
        this.appearanceStreamGenerator = (AppearanceStreamGenerator) parcel.readParcelable(AppearanceStreamGenerator.class.getClassLoader());
        this.cachedAppearanceStreamBitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
    }
}
