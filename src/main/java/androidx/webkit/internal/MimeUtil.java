package androidx.webkit.internal;

import androidx.media3.common.MimeTypes;
import com.box.android.capture.documentscanning.logic.TextRecognitionConverter;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.google.common.base.Ascii;
import com.pspdfkit.document.sharing.DocumentSharingIntentHelper;
import com.yubico.yubikit.core.fido.CtapException;
import java.net.URLConnection;

/* JADX INFO: loaded from: classes9.dex */
class MimeUtil {
    private MimeUtil() {
    }

    public static String getMimeFromFileName(String str) {
        if (str == null) {
            return null;
        }
        String strGuessContentTypeFromName = URLConnection.guessContentTypeFromName(str);
        return strGuessContentTypeFromName != null ? strGuessContentTypeFromName : guessHardcodedMime(str);
    }

    private static String guessHardcodedMime(String str) {
        byte b = CtapException.ERR_NO_CREDENTIALS;
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf == -1) {
            return null;
        }
        String lowerCase = str.substring(iLastIndexOf + 1).toLowerCase();
        lowerCase.hashCode();
        switch (lowerCase.hashCode()) {
            case 3315:
                b = !lowerCase.equals("gz") ? (byte) -1 : (byte) 0;
                break;
            case 3401:
                b = !lowerCase.equals("js") ? (byte) -1 : (byte) 1;
                break;
            case 97669:
                b = !lowerCase.equals("bmp") ? (byte) -1 : (byte) 2;
                break;
            case 98819:
                b = !lowerCase.equals("css") ? (byte) -1 : (byte) 3;
                break;
            case 102340:
                b = !lowerCase.equals(SupportedFileExtensions.GIF_EXTENSION) ? (byte) -1 : (byte) 4;
                break;
            case 103649:
                b = !lowerCase.equals("htm") ? (byte) -1 : (byte) 5;
                break;
            case 104085:
                b = !lowerCase.equals("ico") ? (byte) -1 : (byte) 6;
                break;
            case 105441:
                b = !lowerCase.equals(BoxRepresentation.TYPE_JPG) ? (byte) -1 : (byte) 7;
                break;
            case 106458:
                b = !lowerCase.equals("m4a") ? (byte) -1 : (byte) 8;
                break;
            case 106479:
                b = !lowerCase.equals("m4v") ? (byte) -1 : (byte) 9;
                break;
            case 108089:
                b = !lowerCase.equals("mht") ? (byte) -1 : (byte) 10;
                break;
            case 108150:
                b = !lowerCase.equals("mjs") ? (byte) -1 : (byte) 11;
                break;
            case 108272:
                b = !lowerCase.equals(BoxRepresentation.TYPE_MP3) ? (byte) -1 : Ascii.FF;
                break;
            case 108273:
                b = !lowerCase.equals(BoxRepresentation.TYPE_MP4) ? (byte) -1 : Ascii.CR;
                break;
            case 108324:
                b = !lowerCase.equals("mpg") ? (byte) -1 : Ascii.SO;
                break;
            case 109961:
                b = !lowerCase.equals("oga") ? (byte) -1 : Ascii.SI;
                break;
            case 109967:
                b = !lowerCase.equals("ogg") ? (byte) -1 : Ascii.DLE;
                break;
            case 109973:
                b = !lowerCase.equals("ogm") ? (byte) -1 : (byte) 17;
                break;
            case 109982:
                b = !lowerCase.equals("ogv") ? (byte) -1 : (byte) 18;
                break;
            case 110834:
                b = !lowerCase.equals("pdf") ? (byte) -1 : (byte) 19;
                break;
            case 111030:
                b = !lowerCase.equals("pjp") ? (byte) -1 : (byte) 20;
                break;
            case 111145:
                b = !lowerCase.equals(BoxRepresentation.TYPE_PNG) ? (byte) -1 : (byte) 21;
                break;
            case 114276:
                b = !lowerCase.equals("svg") ? (byte) -1 : (byte) 22;
                break;
            case 114791:
                b = !lowerCase.equals("tgz") ? (byte) -1 : (byte) 23;
                break;
            case 114833:
                b = !lowerCase.equals("tif") ? (byte) -1 : Ascii.CAN;
                break;
            case 117484:
                b = !lowerCase.equals("wav") ? (byte) -1 : (byte) 25;
                break;
            case 118660:
                b = !lowerCase.equals("xht") ? (byte) -1 : Ascii.SUB;
                break;
            case 118807:
                b = !lowerCase.equals("xml") ? (byte) -1 : Ascii.ESC;
                break;
            case 120609:
                b = !lowerCase.equals("zip") ? (byte) -1 : Ascii.FS;
                break;
            case 3000872:
                b = !lowerCase.equals("apng") ? (byte) -1 : Ascii.GS;
                break;
            case 3145576:
                b = !lowerCase.equals("flac") ? (byte) -1 : Ascii.RS;
                break;
            case 3213227:
                b = !lowerCase.equals(TextRecognitionConverter.Tags.HTML) ? (byte) -1 : Ascii.US;
                break;
            case 3259225:
                b = !lowerCase.equals("jfif") ? (byte) -1 : (byte) 32;
                break;
            case 3268712:
                b = !lowerCase.equals("jpeg") ? (byte) -1 : CtapException.ERR_PROCESSING;
                break;
            case 3271912:
                b = !lowerCase.equals("json") ? (byte) -1 : CtapException.ERR_INVALID_CREDENTIAL;
                break;
            case 3358085:
                b = !lowerCase.equals("mpeg") ? (byte) -1 : CtapException.ERR_USER_ACTION_PENDING;
                break;
            case 3418175:
                b = !lowerCase.equals("opus") ? (byte) -1 : CtapException.ERR_OPERATION_PENDING;
                break;
            case 3529614:
                b = !lowerCase.equals("shtm") ? (byte) -1 : CtapException.ERR_NO_OPERATIONS;
                break;
            case 3542678:
                b = !lowerCase.equals("svgz") ? (byte) -1 : CtapException.ERR_UNSUPPORTED_ALGORITHM;
                break;
            case 3559925:
                b = !lowerCase.equals("tiff") ? (byte) -1 : CtapException.ERR_OPERATION_DENIED;
                break;
            case 3642020:
                b = !lowerCase.equals("wasm") ? (byte) -1 : CtapException.ERR_KEY_STORE_FULL;
                break;
            case 3645337:
                b = !lowerCase.equals("webm") ? (byte) -1 : CtapException.ERR_NOT_BUSY;
                break;
            case 3645340:
                b = !lowerCase.equals("webp") ? (byte) -1 : CtapException.ERR_NO_OPERATION_PENDING;
                break;
            case 3655064:
                b = !lowerCase.equals("woff") ? (byte) -1 : CtapException.ERR_UNSUPPORTED_OPTION;
                break;
            case 3678569:
                b = !lowerCase.equals("xhtm") ? (byte) -1 : CtapException.ERR_INVALID_OPTION;
                break;
            case 96488848:
                b = !lowerCase.equals("ehtml") ? (byte) -1 : CtapException.ERR_KEEPALIVE_CANCEL;
                break;
            case 103877016:
                if (!lowerCase.equals("mhtml")) {
                    b = -1;
                }
                break;
            case 106703064:
                b = !lowerCase.equals("pjpeg") ? (byte) -1 : CtapException.ERR_USER_ACTION_TIMEOUT;
                break;
            case 109418142:
                b = !lowerCase.equals("shtml") ? (byte) -1 : CtapException.ERR_NOT_ALLOWED;
                break;
            case 114035747:
                b = !lowerCase.equals("xhtml") ? (byte) -1 : CtapException.ERR_PIN_INVALID;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
            case 23:
                return "application/gzip";
            case 1:
            case 11:
                return "text/javascript";
            case 2:
                return MimeTypes.IMAGE_BMP;
            case 3:
                return "text/css";
            case 4:
                return "image/gif";
            case 5:
            case 31:
            case 37:
            case 45:
            case 48:
                return "text/html";
            case 6:
                return "image/x-icon";
            case 7:
            case 20:
            case 32:
            case 33:
            case 47:
                return MimeTypes.IMAGE_JPEG;
            case 8:
                return "audio/x-m4a";
            case 9:
            case 13:
                return MimeTypes.VIDEO_MP4;
            case 10:
            case 46:
                return "multipart/related";
            case 12:
                return MimeTypes.AUDIO_MPEG;
            case 14:
            case 35:
                return MimeTypes.VIDEO_MPEG;
            case 15:
            case 16:
            case 36:
                return MimeTypes.AUDIO_OGG;
            case 17:
            case 18:
                return MimeTypes.VIDEO_OGG;
            case 19:
                return DocumentSharingIntentHelper.MIME_TYPE_PDF;
            case 21:
                return MimeTypes.IMAGE_PNG;
            case 22:
            case 38:
                return "image/svg+xml";
            case 24:
            case 39:
                return "image/tiff";
            case 25:
                return MimeTypes.AUDIO_WAV;
            case 26:
            case 44:
            case 49:
                return "application/xhtml+xml";
            case 27:
                return "text/xml";
            case 28:
                return "application/zip";
            case 29:
                return "image/apng";
            case 30:
                return MimeTypes.AUDIO_FLAC;
            case 34:
                return "application/json";
            case 40:
                return "application/wasm";
            case 41:
                return MimeTypes.VIDEO_WEBM;
            case 42:
                return MimeTypes.IMAGE_WEBP;
            case 43:
                return "application/font-woff";
            default:
                return null;
        }
    }
}
