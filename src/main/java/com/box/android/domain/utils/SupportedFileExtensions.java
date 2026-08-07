package com.box.android.domain.utils;

import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.android.capture.documentscanning.logic.TextRecognitionConverter;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxRepresentation;
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import io.split.android.client.service.ServiceConstants;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.utilities.script.JavascriptRunner;

/* JADX INFO: compiled from: SupportedFileExtensions.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b/\n\u0002\u0010\u000b\n\u0002\b\u001f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010:\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010;\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010<\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010=\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010>\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010?\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010@\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010A\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010B\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010C\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010D\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010E\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010F\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010G\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010H\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010I\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010J\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010K\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010L\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010M\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010N\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010O\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010P\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010Q\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010R\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010S\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010T\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010U\u001a\u0002082\u0006\u00109\u001a\u00020\u0005J\u000e\u0010V\u001a\u0002082\u0006\u00109\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0019R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0019R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0019R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0019R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0019¨\u0006W"}, d2 = {"Lcom/box/android/domain/utils/SupportedFileExtensions;", "", "<init>", "()V", "OPENABLE_DOCUMENT_EXTENSION", "", "OPENABLE_GIF_EXTENSION", "OPENABLE_IMAGE_EXTENSIONS", "", "PLAYABLE_AUDIO_EXTENSIONS", "PLAYABLE_VIDEO_EXTENSIONS", "OPENABLE_CODE_EXTENSIONS", "AI_EXTENSION", "BOX_CANVAS_EXTENSION", "BOX_NOTE_EXTENSION", "DWG_EXTENSION", "GIF_EXTENSION", "PDF_EXTENSION", "PAGES_EXTENSION", "PSD_EXTENSION", "XBD_EXTENSION", "XDW_EXTENSION", "ZIP_EXTENSION", "DOCUMENT_EXTENSIONS", "getDOCUMENT_EXTENSIONS", "()Ljava/util/Set;", "IMAGE_EXTENSIONS", "getIMAGE_EXTENSIONS", "AUDIO_EXTENSIONS", "getAUDIO_EXTENSIONS", "VIDEO_EXTENSIONS", "getVIDEO_EXTENSIONS", "CODE_EXTENSIONS", "getCODE_EXTENSIONS", "GRAPHICS_3D_EXTENSIONS", "getGRAPHICS_3D_EXTENSIONS", "INDESIGN_EXTENSIONS", "getINDESIGN_EXTENSIONS", "IWORK_EXTENSIONS", "getIWORK_EXTENSIONS", "PRESENTATION_EXTENSIONS", "getPRESENTATION_EXTENSIONS", "SPREADSHEET_EXTENSIONS", "getSPREADSHEET_EXTENSIONS", "VECTOR_EXTENSIONS", "getVECTOR_EXTENSIONS", "MICROSOFT_EXCEL_EXTENSIONS", "getMICROSOFT_EXCEL_EXTENSIONS", "MICROSOFT_POWERPOINT_EXTENSIONS", "getMICROSOFT_POWERPOINT_EXTENSIONS", "MICROSOFT_WORD_EXTENSIONS", "getMICROSOFT_WORD_EXTENSIONS", "UNSUPPORTED_WATERMARK_EXTENSIONS", "ALL_SUPPORTED_EXTENSIONS", "getALL_SUPPORTED_EXTENSIONS", "isOpenableDocument", "", BoxFile.FIELD_EXTENSION, "isOpenableGif", "isOpenableImage", "isPlayableAudio", "isPlayableVideo", "isOpenableCode", "isOriginalFilePreviewable", "isAdobeIllustratorExtension", "isDocumentExtension", "isGifExtension", "isImageExtension", "isAudioExtension", "isVideoExtension", "isCodeExtension", "isBoxCanvasExtension", "isBoxNoteExtension", "isAutoCADExtension", "isAdobePhotoshopExtension", "isDocuWorksExtension", "isInDesignExtension", "isIWorkExtension", "isPresentationExtension", "isSpreadsheetExtension", "isVectorExtension", "isMicrosoftExcelExtension", "isMicrosoftPowerPointExtension", "isMicrosoftWordExtension", "isMicrosoftOfficeExtension", "isSupportedExtension", "isWatermarkUnsupportedExtension", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SupportedFileExtensions {
    public static final String AI_EXTENSION = "ai";
    private static final Set<String> ALL_SUPPORTED_EXTENSIONS;
    private static final Set<String> AUDIO_EXTENSIONS;
    public static final String BOX_CANVAS_EXTENSION = "boxcanvas";
    public static final String BOX_NOTE_EXTENSION = "boxnote";
    private static final Set<String> CODE_EXTENSIONS;
    private static final Set<String> DOCUMENT_EXTENSIONS;
    public static final String DWG_EXTENSION = "dwg";
    public static final String GIF_EXTENSION = "gif";
    private static final Set<String> GRAPHICS_3D_EXTENSIONS;
    private static final Set<String> IMAGE_EXTENSIONS;
    private static final Set<String> INDESIGN_EXTENSIONS;
    public static final SupportedFileExtensions INSTANCE = new SupportedFileExtensions();
    private static final Set<String> IWORK_EXTENSIONS;
    private static final Set<String> MICROSOFT_EXCEL_EXTENSIONS;
    private static final Set<String> MICROSOFT_POWERPOINT_EXTENSIONS;
    private static final Set<String> MICROSOFT_WORD_EXTENSIONS;
    private static final Set<String> OPENABLE_CODE_EXTENSIONS;
    private static final String OPENABLE_DOCUMENT_EXTENSION = "pdf";
    private static final String OPENABLE_GIF_EXTENSION = "gif";
    private static final Set<String> OPENABLE_IMAGE_EXTENSIONS;
    public static final String PAGES_EXTENSION = "pages";
    public static final String PDF_EXTENSION = "pdf";
    private static final Set<String> PLAYABLE_AUDIO_EXTENSIONS;
    private static final Set<String> PLAYABLE_VIDEO_EXTENSIONS;
    private static final Set<String> PRESENTATION_EXTENSIONS;
    public static final String PSD_EXTENSION = "psd";
    private static final Set<String> SPREADSHEET_EXTENSIONS;
    private static final Set<String> UNSUPPORTED_WATERMARK_EXTENSIONS;
    private static final Set<String> VECTOR_EXTENSIONS;
    private static final Set<String> VIDEO_EXTENSIONS;
    public static final String XBD_EXTENSION = "xbd";
    public static final String XDW_EXTENSION = "xdw";
    public static final String ZIP_EXTENSION = "zip";

    private SupportedFileExtensions() {
    }

    static {
        Set<String> of = SetsKt.setOf((Object[]) new String[]{BoxRepresentation.TYPE_PNG, "jpeg", BoxRepresentation.TYPE_JPG, "tiff", "tif"});
        OPENABLE_IMAGE_EXTENSIONS = of;
        Set<String> of2 = SetsKt.setOf((Object[]) new String[]{"aac", "amr", "flac", "m4a", BoxRepresentation.TYPE_MP3, "wav"});
        PLAYABLE_AUDIO_EXTENSIONS = of2;
        Set<String> of3 = SetsKt.setOf((Object[]) new String[]{"3g2", "3gp", "avi", "m2v", "m4v", "mkv", "mov", BoxRepresentation.TYPE_MP4, "mpeg", "mpg", "mts", "ogg", "qt", "wmv"});
        PLAYABLE_VIDEO_EXTENSIONS = of3;
        Set<String> of4 = SetsKt.setOf((Object[]) new String[]{"as", "as3", "asm", "bat", "c", "cc", "cmake", ResourceAttributes.TelemetrySdkLanguageValues.CPP, "cs", "css", "cxx", "diff", "erb", "groovy", CmcdData.STREAMING_FORMAT_HLS, "haml", "hh", "htm", TextRecognitionConverter.Tags.HTML, ResourceAttributes.TelemetrySdkLanguageValues.JAVA, "js", "json", "less", "log", CmcdData.OBJECT_TYPE_MANIFEST, "make", "md", "ml", "mm", ResourceAttributes.TelemetrySdkLanguageValues.PHP, "pl", "properties", "py", "rb", "rst", "sass", "scala", "scm", JavascriptRunner.SCRIPT_NAME, "sh", "sml", "sql", "vi", "vim", "webdoc", "xhtml", "xml", ServiceConstants.YAML_EXTENSION});
        OPENABLE_CODE_EXTENSIONS = of4;
        Set<String> of5 = SetsKt.setOf((Object[]) new String[]{"pdf", "gdoc", NotificationCompat.CATEGORY_MESSAGE, "odt", "rtf", "txt", "wpd", "xsd", "xsl"});
        DOCUMENT_EXTENSIONS = of5;
        Set<String> setPlus = SetsKt.plus((Set) of, (Iterable) SetsKt.setOf((Object[]) new String[]{"bmp", "cr2", "crw", "dng", "heic", "nef", "ps", "raf", "raw", "svs", "tga", "webp"}));
        IMAGE_EXTENSIONS = setPlus;
        Set<String> setPlus2 = SetsKt.plus((Set) of2, (Iterable) SetsKt.setOf((Object[]) new String[]{"aif", "aifc", "aiff", "au", "ra", "wma"}));
        AUDIO_EXTENSIONS = setPlus2;
        Set<String> setPlus3 = SetsKt.plus((Set) of3, (Iterable) SetsKt.setOf((Object[]) new String[]{"flv", "m2ts", "swf", "ts"}));
        VIDEO_EXTENSIONS = setPlus3;
        CODE_EXTENSIONS = of4;
        Set<String> of6 = SetsKt.setOf((Object[]) new String[]{"3ds", "box3d", "dae", "fbx", "obj", "ply", "stl"});
        GRAPHICS_3D_EXTENSIONS = of6;
        Set<String> of7 = SetsKt.setOf((Object[]) new String[]{"indd", "idml", "indt", "inx"});
        INDESIGN_EXTENSIONS = of7;
        Set<String> of8 = SetsKt.setOf((Object[]) new String[]{"keynote", "numbers", PAGES_EXTENSION});
        IWORK_EXTENSIONS = of8;
        Set<String> of9 = SetsKt.setOf((Object[]) new String[]{"gslides", "key", "odp"});
        PRESENTATION_EXTENSIONS = of9;
        Set<String> of10 = SetsKt.setOf((Object[]) new String[]{"csv", "gsheet", "ods", "tsv"});
        SPREADSHEET_EXTENSIONS = of10;
        Set<String> of11 = SetsKt.setOf((Object[]) new String[]{"eps", "svg"});
        VECTOR_EXTENSIONS = of11;
        Set<String> of12 = SetsKt.setOf((Object[]) new String[]{"xls", "xlsb", "xlsm", "xlsx"});
        MICROSOFT_EXCEL_EXTENSIONS = of12;
        Set<String> of13 = SetsKt.setOf((Object[]) new String[]{"ppt", "pptx"});
        MICROSOFT_POWERPOINT_EXTENSIONS = of13;
        Set<String> of14 = SetsKt.setOf((Object[]) new String[]{"doc", "docx"});
        MICROSOFT_WORD_EXTENSIONS = of14;
        UNSUPPORTED_WATERMARK_EXTENSIONS = SetsKt.plus(SetsKt.setOf((Object[]) new String[]{"boxnote", "zip", "swf", "fla", "exe", "msi", "dll", "usdz", "obj", "fbx", "stl", "gltf", "glb", "dae", "3ds", "blend"}), (Iterable) setPlus2);
        ALL_SUPPORTED_EXTENSIONS = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.setOf((Object[]) new String[]{AI_EXTENSION, BOX_CANVAS_EXTENSION, "boxnote", DWG_EXTENSION, "gif", "pdf", PAGES_EXTENSION, PSD_EXTENSION, XBD_EXTENSION, XDW_EXTENSION, "zip"}), (Iterable) of5), (Iterable) setPlus), (Iterable) setPlus2), (Iterable) setPlus3), (Iterable) of4), (Iterable) of6), (Iterable) of7), (Iterable) of8), (Iterable) of9), (Iterable) of10), (Iterable) of11), (Iterable) of12), (Iterable) of13), (Iterable) of14);
    }

    public final Set<String> getDOCUMENT_EXTENSIONS() {
        return DOCUMENT_EXTENSIONS;
    }

    public final Set<String> getIMAGE_EXTENSIONS() {
        return IMAGE_EXTENSIONS;
    }

    public final Set<String> getAUDIO_EXTENSIONS() {
        return AUDIO_EXTENSIONS;
    }

    public final Set<String> getVIDEO_EXTENSIONS() {
        return VIDEO_EXTENSIONS;
    }

    public final Set<String> getCODE_EXTENSIONS() {
        return CODE_EXTENSIONS;
    }

    public final Set<String> getGRAPHICS_3D_EXTENSIONS() {
        return GRAPHICS_3D_EXTENSIONS;
    }

    public final Set<String> getINDESIGN_EXTENSIONS() {
        return INDESIGN_EXTENSIONS;
    }

    public final Set<String> getIWORK_EXTENSIONS() {
        return IWORK_EXTENSIONS;
    }

    public final Set<String> getPRESENTATION_EXTENSIONS() {
        return PRESENTATION_EXTENSIONS;
    }

    public final Set<String> getSPREADSHEET_EXTENSIONS() {
        return SPREADSHEET_EXTENSIONS;
    }

    public final Set<String> getVECTOR_EXTENSIONS() {
        return VECTOR_EXTENSIONS;
    }

    public final Set<String> getMICROSOFT_EXCEL_EXTENSIONS() {
        return MICROSOFT_EXCEL_EXTENSIONS;
    }

    public final Set<String> getMICROSOFT_POWERPOINT_EXTENSIONS() {
        return MICROSOFT_POWERPOINT_EXTENSIONS;
    }

    public final Set<String> getMICROSOFT_WORD_EXTENSIONS() {
        return MICROSOFT_WORD_EXTENSIONS;
    }

    public final Set<String> getALL_SUPPORTED_EXTENSIONS() {
        return ALL_SUPPORTED_EXTENSIONS;
    }

    public final boolean isOpenableDocument(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        String lowerCase = extension.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return Intrinsics.areEqual("pdf", lowerCase);
    }

    public final boolean isOpenableGif(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        String lowerCase = extension.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return Intrinsics.areEqual("gif", lowerCase);
    }

    public final boolean isOpenableImage(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        return SupportedFileExtensionsKt.isExtensionInSet(extension, OPENABLE_IMAGE_EXTENSIONS);
    }

    public final boolean isPlayableAudio(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        return SupportedFileExtensionsKt.isExtensionInSet(extension, PLAYABLE_AUDIO_EXTENSIONS);
    }

    public final boolean isPlayableVideo(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        return SupportedFileExtensionsKt.isExtensionInSet(extension, PLAYABLE_VIDEO_EXTENSIONS);
    }

    public final boolean isOpenableCode(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        return SupportedFileExtensionsKt.isExtensionInSet(extension, OPENABLE_CODE_EXTENSIONS);
    }

    public final boolean isOriginalFilePreviewable(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        return isOpenableDocument(extension) || isOpenableGif(extension) || isOpenableImage(extension) || isPlayableAudio(extension) || isPlayableVideo(extension) || isOpenableCode(extension);
    }

    public final boolean isAdobeIllustratorExtension(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        String lowerCase = extension.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return Intrinsics.areEqual(AI_EXTENSION, lowerCase);
    }

    public final boolean isDocumentExtension(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        return SupportedFileExtensionsKt.isExtensionInSet(extension, DOCUMENT_EXTENSIONS);
    }

    public final boolean isGifExtension(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        String lowerCase = extension.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return Intrinsics.areEqual("gif", lowerCase);
    }

    public final boolean isImageExtension(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        return SupportedFileExtensionsKt.isExtensionInSet(extension, IMAGE_EXTENSIONS);
    }

    public final boolean isAudioExtension(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        return SupportedFileExtensionsKt.isExtensionInSet(extension, AUDIO_EXTENSIONS);
    }

    public final boolean isVideoExtension(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        return SupportedFileExtensionsKt.isExtensionInSet(extension, VIDEO_EXTENSIONS);
    }

    public final boolean isCodeExtension(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        return SupportedFileExtensionsKt.isExtensionInSet(extension, CODE_EXTENSIONS);
    }

    public final boolean isBoxCanvasExtension(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        String lowerCase = extension.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return Intrinsics.areEqual(BOX_CANVAS_EXTENSION, lowerCase);
    }

    public final boolean isBoxNoteExtension(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        String lowerCase = extension.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return Intrinsics.areEqual("boxnote", lowerCase);
    }

    public final boolean isAutoCADExtension(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        String lowerCase = extension.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return Intrinsics.areEqual(DWG_EXTENSION, lowerCase);
    }

    public final boolean isAdobePhotoshopExtension(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        String lowerCase = extension.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return Intrinsics.areEqual(PSD_EXTENSION, lowerCase);
    }

    public final boolean isDocuWorksExtension(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        String lowerCase = extension.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return Intrinsics.areEqual(XBD_EXTENSION, lowerCase) || Intrinsics.areEqual(XDW_EXTENSION, lowerCase);
    }

    public final boolean isInDesignExtension(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        return SupportedFileExtensionsKt.isExtensionInSet(extension, INDESIGN_EXTENSIONS);
    }

    public final boolean isIWorkExtension(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        return SupportedFileExtensionsKt.isExtensionInSet(extension, IWORK_EXTENSIONS);
    }

    public final boolean isPresentationExtension(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        return SupportedFileExtensionsKt.isExtensionInSet(extension, PRESENTATION_EXTENSIONS);
    }

    public final boolean isSpreadsheetExtension(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        return SupportedFileExtensionsKt.isExtensionInSet(extension, SPREADSHEET_EXTENSIONS);
    }

    public final boolean isVectorExtension(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        return SupportedFileExtensionsKt.isExtensionInSet(extension, VECTOR_EXTENSIONS);
    }

    public final boolean isMicrosoftExcelExtension(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        return SupportedFileExtensionsKt.isExtensionInSet(extension, MICROSOFT_EXCEL_EXTENSIONS);
    }

    public final boolean isMicrosoftPowerPointExtension(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        return SupportedFileExtensionsKt.isExtensionInSet(extension, MICROSOFT_POWERPOINT_EXTENSIONS);
    }

    public final boolean isMicrosoftWordExtension(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        return SupportedFileExtensionsKt.isExtensionInSet(extension, MICROSOFT_WORD_EXTENSIONS);
    }

    public final boolean isMicrosoftOfficeExtension(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        return isMicrosoftWordExtension(extension) || isMicrosoftExcelExtension(extension) || isMicrosoftPowerPointExtension(extension);
    }

    public final boolean isSupportedExtension(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        return SupportedFileExtensionsKt.isExtensionInSet(extension, ALL_SUPPORTED_EXTENSIONS);
    }

    public final boolean isWatermarkUnsupportedExtension(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        return SupportedFileExtensionsKt.isExtensionInSet(extension, UNSUPPORTED_WATERMARK_EXTENSIONS);
    }
}
