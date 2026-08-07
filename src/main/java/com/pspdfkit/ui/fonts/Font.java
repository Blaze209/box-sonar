package com.pspdfkit.ui.fonts;

import android.graphics.Typeface;
import android.os.Looper;
import java.io.File;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0017\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB\u001f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\t\u0010\u000bB\u001b\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\fJ\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010\u0019\u001a\u00020\u001aH\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/pspdfkit/ui/fonts/Font;", "", "name", "", "fontFiles", "", "Ljava/io/File;", "defaultTypeface", "Landroid/graphics/Typeface;", "<init>", "(Ljava/lang/String;Ljava/util/List;Landroid/graphics/Typeface;)V", "(Ljava/lang/String;Ljava/util/List;)V", "(Ljava/lang/String;Landroid/graphics/Typeface;)V", "getName", "()Ljava/lang/String;", "getFontFiles", "()Ljava/util/List;", "getDefaultTypeface", "()Landroid/graphics/Typeface;", "defaultFontFile", "getDefaultFontFile", "()Ljava/io/File;", "equals", "", "other", "hashCode", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class Font {
    public static final int $stable = 8;
    private final Typeface defaultTypeface;
    private final List<File> fontFiles;
    private final String name;

    /* JADX WARN: Multi-variable type inference failed */
    public Font(String str, List<? extends File> list, Typeface typeface) {
        str.getClass();
        list.getClass();
        this.name = str;
        this.fontFiles = list;
        this.defaultTypeface = typeface;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Font)) {
            return false;
        }
        Font font = (Font) other;
        return Intrinsics.areEqual(this.name, font.name) && Intrinsics.areEqual(this.fontFiles, font.fontFiles) && Intrinsics.areEqual(this.defaultTypeface, font.defaultTypeface);
    }

    public final File getDefaultFontFile() {
        return (File) CollectionsKt.firstOrNull((List) this.fontFiles);
    }

    public final Typeface getDefaultTypeface() {
        return this.defaultTypeface;
    }

    public final List<File> getFontFiles() {
        return this.fontFiles;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return Objects.hash(this.name, this.fontFiles, this.defaultTypeface);
    }

    public /* synthetic */ Font(String str, List list, Typeface typeface, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : typeface);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Font(String str, List<? extends File> list) {
        Typeface typefaceCreateFromFile;
        str.getClass();
        list.getClass();
        File file = (File) CollectionsKt.firstOrNull((List) list);
        if (file == null) {
            typefaceCreateFromFile = null;
        } else if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            typefaceCreateFromFile = Typeface.createFromFile(file);
        } else {
            throw new IllegalStateException("Font may not be loaded from the main thread.");
        }
        this(str, list, typefaceCreateFromFile);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Font(String str, Typeface typeface) {
        this(str, CollectionsKt.emptyList(), typeface);
        str.getClass();
    }
}
