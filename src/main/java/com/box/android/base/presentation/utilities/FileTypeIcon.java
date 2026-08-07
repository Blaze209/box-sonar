package com.box.android.base.presentation.utilities;

import com.box.android.base.R;
import com.box.android.domain.utils.SupportedFileExtensions;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'COMPRESSED' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:160)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: SupportedFileExtensionIcons.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0010\u000e\n\u0002\b\"\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B9\b\u0002\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\b\u0003\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fj\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(¨\u0006)"}, d2 = {"Lcom/box/android/base/presentation/utilities/FileTypeIcon;", "", "drawable", "", "color", "extensions", "", "", "contentDescription", "<init>", "(Ljava/lang/String;IIILjava/lang/Iterable;I)V", "getDrawable", "()I", "getColor", "getExtensions", "()Ljava/lang/Iterable;", "getContentDescription", "IMAGE", "VIDEO", "DOCUMENT", "CAD", "AUDIO", "CODE", "PRESENTATION", "SPREADSHEET", "WORD", "COMPRESSED", "INDESIGN", "DOCUWORKS_XBD", "DOCUWORKS_XDW", "GRAPHICS_3D", "PHOTOSHOP_PSD", "VECTOR", "BOXNOTE", "ILLUSTRATOR_AI", "PDF", "BOXCANVAS", "PAGES", "EXCEL", "POWERPOINT", "DEFAULT", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileTypeIcon {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FileTypeIcon[] $VALUES;
    public static final FileTypeIcon BOXCANVAS;
    public static final FileTypeIcon COMPRESSED;
    private final int color;
    private final int contentDescription;
    private final int drawable;
    private final Iterable<String> extensions;
    public static final FileTypeIcon IMAGE = new FileTypeIcon("IMAGE", 0, R.drawable.ic_file_image, R.color.preview_load_image, SupportedFileExtensionIconsKt.imageExtensions, 0, 8, null);
    public static final FileTypeIcon VIDEO = new FileTypeIcon("VIDEO", 1, R.drawable.ic_file_video, R.color.preview_load_video, SupportedFileExtensions.INSTANCE.getVIDEO_EXTENSIONS(), 0, 8, null);
    public static final FileTypeIcon DOCUMENT = new FileTypeIcon("DOCUMENT", 2, R.drawable.ic_file_docs, R.color.preview_load_document, SupportedFileExtensionIconsKt.documentExtensions, 0, 8, null);
    public static final FileTypeIcon CAD = new FileTypeIcon("CAD", 3, R.drawable.ic_file_dwg, R.color.preview_load_cad, SetsKt.setOf(SupportedFileExtensions.DWG_EXTENSION), 0, 8, null);
    public static final FileTypeIcon AUDIO = new FileTypeIcon("AUDIO", 4, R.drawable.ic_file_audio, R.color.preview_load_audio, SupportedFileExtensions.INSTANCE.getAUDIO_EXTENSIONS(), 0, 8, null);
    public static final FileTypeIcon CODE = new FileTypeIcon("CODE", 5, R.drawable.ic_file_code, R.color.preview_load_code, SupportedFileExtensions.INSTANCE.getCODE_EXTENSIONS(), 0, 8, null);
    public static final FileTypeIcon PRESENTATION = new FileTypeIcon("PRESENTATION", 6, R.drawable.ic_file_presentation, R.color.preview_load_presentation, SupportedFileExtensions.INSTANCE.getPRESENTATION_EXTENSIONS(), 0, 8, null);
    public static final FileTypeIcon SPREADSHEET = new FileTypeIcon("SPREADSHEET", 7, R.drawable.ic_file_spreadsheet, R.color.preview_load_spreadsheet, SupportedFileExtensions.INSTANCE.getSPREADSHEET_EXTENSIONS(), 0, 8, null);
    public static final FileTypeIcon WORD = new FileTypeIcon("WORD", 8, R.drawable.ic_file_word, R.color.preview_load_word, SupportedFileExtensions.INSTANCE.getMICROSOFT_WORD_EXTENSIONS(), 0, 8, null);
    public static final FileTypeIcon INDESIGN = new FileTypeIcon("INDESIGN", 10, R.drawable.ic_file_indesign, R.color.preview_load_indesign, SupportedFileExtensions.INSTANCE.getINDESIGN_EXTENSIONS(), 0, 8, null);
    public static final FileTypeIcon DOCUWORKS_XBD = new FileTypeIcon("DOCUWORKS_XBD", 11, R.drawable.ic_file_xbd, R.color.preview_load_docuworks, SetsKt.setOf(SupportedFileExtensions.XBD_EXTENSION), 0, 8, null);
    public static final FileTypeIcon DOCUWORKS_XDW = new FileTypeIcon("DOCUWORKS_XDW", 12, R.drawable.ic_file_xdw, R.color.preview_load_docuworks, SetsKt.setOf(SupportedFileExtensions.XDW_EXTENSION), 0, 8, null);
    public static final FileTypeIcon GRAPHICS_3D = new FileTypeIcon("GRAPHICS_3D", 13, R.drawable.ic_file_three_d, R.color.preview_load_three_d, SupportedFileExtensions.INSTANCE.getGRAPHICS_3D_EXTENSIONS(), 0, 8, null);
    public static final FileTypeIcon PHOTOSHOP_PSD = new FileTypeIcon("PHOTOSHOP_PSD", 14, R.drawable.ic_file_photoshop, R.color.preview_load_photoshop, SetsKt.setOf(SupportedFileExtensions.PSD_EXTENSION), 0, 8, null);
    public static final FileTypeIcon VECTOR = new FileTypeIcon("VECTOR", 15, R.drawable.ic_file_vector, R.color.preview_load_vector, SupportedFileExtensions.INSTANCE.getVECTOR_EXTENSIONS(), 0, 8, null);
    public static final FileTypeIcon BOXNOTE = new FileTypeIcon("BOXNOTE", 16, R.drawable.ic_file_boxnote, R.color.preview_load_boxnote, SetsKt.setOf("boxnote"), 0, 8, null);
    public static final FileTypeIcon ILLUSTRATOR_AI = new FileTypeIcon("ILLUSTRATOR_AI", 17, R.drawable.ic_file_illustrator, R.color.preview_load_illustrator, SetsKt.setOf(SupportedFileExtensions.AI_EXTENSION), 0, 8, null);
    public static final FileTypeIcon PDF = new FileTypeIcon("PDF", 18, R.drawable.ic_file_pdf, R.color.preview_load_pdf, SetsKt.setOf("pdf"), 0, 8, null);
    public static final FileTypeIcon PAGES = new FileTypeIcon("PAGES", 20, R.drawable.ic_file_pages, R.color.preview_load_pages, SetsKt.setOf(SupportedFileExtensions.PAGES_EXTENSION), 0, 8, null);
    public static final FileTypeIcon EXCEL = new FileTypeIcon("EXCEL", 21, R.drawable.ic_file_excel, R.color.preview_load_excel, SupportedFileExtensions.INSTANCE.getMICROSOFT_EXCEL_EXTENSIONS(), 0, 8, null);
    public static final FileTypeIcon POWERPOINT = new FileTypeIcon("POWERPOINT", 22, R.drawable.ic_file_powerpoint, R.color.preview_load_powerpoint, SupportedFileExtensions.INSTANCE.getMICROSOFT_POWERPOINT_EXTENSIONS(), 0, 8, null);
    public static final FileTypeIcon DEFAULT = new FileTypeIcon("DEFAULT", 23, 0, 0, null, 0, 15, null);

    private static final /* synthetic */ FileTypeIcon[] $values() {
        return new FileTypeIcon[]{IMAGE, VIDEO, DOCUMENT, CAD, AUDIO, CODE, PRESENTATION, SPREADSHEET, WORD, COMPRESSED, INDESIGN, DOCUWORKS_XBD, DOCUWORKS_XDW, GRAPHICS_3D, PHOTOSHOP_PSD, VECTOR, BOXNOTE, ILLUSTRATOR_AI, PDF, BOXCANVAS, PAGES, EXCEL, POWERPOINT, DEFAULT};
    }

    public static EnumEntries<FileTypeIcon> getEntries() {
        return $ENTRIES;
    }

    public static FileTypeIcon valueOf(String str) {
        return (FileTypeIcon) Enum.valueOf(FileTypeIcon.class, str);
    }

    public static FileTypeIcon[] values() {
        return (FileTypeIcon[]) $VALUES.clone();
    }

    private FileTypeIcon(String str, int i, int i2, int i3, Iterable iterable, int i4) {
        super(str, i);
        this.drawable = i2;
        this.color = i3;
        this.extensions = iterable;
        this.contentDescription = i4;
    }

    /* synthetic */ FileTypeIcon(String str, int i, int i2, int i3, Iterable iterable, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i5 & 1) != 0 ? R.drawable.ic_file_default : i2, (i5 & 2) != 0 ? R.color.preview_load_other : i3, (i5 & 4) != 0 ? null : iterable, (i5 & 8) != 0 ? R.string.file_icon_label : i4);
    }

    public final int getDrawable() {
        return this.drawable;
    }

    public final int getColor() {
        return this.color;
    }

    public final Iterable<String> getExtensions() {
        return this.extensions;
    }

    public final int getContentDescription() {
        return this.contentDescription;
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        COMPRESSED = new FileTypeIcon("COMPRESSED", 9, R.drawable.ic_file_zip, R.color.preview_load_compressed, SetsKt.setOf("zip"), 0, 8, defaultConstructorMarker);
        BOXCANVAS = new FileTypeIcon("BOXCANVAS", 19, R.drawable.ic_file_canvas, R.color.preview_load_canvas, SetsKt.setOf(SupportedFileExtensions.BOX_CANVAS_EXTENSION), 0, 8, defaultConstructorMarker);
        FileTypeIcon[] fileTypeIconArr$values = $values();
        $VALUES = fileTypeIconArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(fileTypeIconArr$values);
    }
}
