package com.pspdfkit.internal;

import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.media3.common.PlaybackException;
import com.box.boxandroidlibv2private.model.BoxTaskCollaborator;

/* JADX INFO: loaded from: classes3.dex */
public final class h3 {
    public static String a(int i) {
        if (i == 0) {
            return "OBJECT_NUMBER";
        }
        if (i == 1) {
            return "PAGE_INDEX";
        }
        if (i == 2) {
            return "NAME";
        }
        if (i == 3) {
            return "CONTENTS";
        }
        if (i == 4) {
            return "SUBJECT";
        }
        if (i == 5) {
            return "RICH_TEXT";
        }
        if (i == 6) {
            return BoxTaskCollaborator.ROLE_CREATOR;
        }
        if (i == 7) {
            return "CREATED_DATE";
        }
        if (i == 3000) {
            return "ACTION";
        }
        if (i == 3001) {
            return "ADDITIONAL_ACTIONS";
        }
        if (i == 4000) {
            return "ICON";
        }
        if (i == 4001) {
            return "NOTE_IS_OPEN";
        }
        if (i == 6001) {
            return "STAMP_SUBTEXT";
        }
        if (i == 6002) {
            return "STAMP_TITLE";
        }
        switch (i) {
            case 7:
                return "CREATED_DATE";
            case 8:
                return "MODIFIED_DATE";
            case 9:
                return "BOUNDING_BOX";
            case 10:
                return "COLOR";
            case 11:
                return "FILL_COLOR";
            case 12:
                return "ALPHA";
            case 13:
                return "BORDER_COLOR";
            case 14:
                return "BORDER_STYLE";
            case 15:
                return "DASH_ARRAY";
            case 16:
                return "FLAGS";
            case 17:
                return "IN_REPLY_TO";
            case 18:
                return "ROTATION";
            case 19:
                return "AUTHOR_STATE";
            case 20:
                return "UUID";
            case 21:
                return "IN_REPLY_TO_UUID";
            case 22:
                return "CONTENT_SIZE";
            case 23:
                return "BLEND_MODE";
            case 24:
                return "BORDER_EFFECT";
            case 25:
                return "BORDER_EFFECT_INTENSITY";
            case 26:
                return "VARIANT";
            case 27:
                return "GROUP";
            case 28:
                return "STROKE_ALPHA";
            case 29:
                return "FILL_ALPHA";
            case 2000:
                return "IS_SIGNATURE";
            case PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED /* 5001 */:
                return "QUADRILATERALS";
            case 9001:
                return "CUSTOM_DATA_JSON";
            case 11001:
                return "MEASUREMENT_PRECISION";
            case 11002:
                return "MEASUREMENT_SCALE";
            case 12001:
                return "INSTANT_COMMENT_ROOT";
            default:
                switch (i) {
                    case 100:
                        return "LINES";
                    case 101:
                        return "LINE_WIDTH";
                    case 102:
                        return "LINE_ENDS";
                    case 103:
                        return "POINTS";
                    case 104:
                        return "LINE_INTENT";
                    case 105:
                        return "POLYLINE_INTENT";
                    default:
                        switch (i) {
                            case 1000:
                                return "FREE_TEXT_INTENT";
                            case 1001:
                                return "TEXT_FONT";
                            case 1002:
                                return "TEXT_FONT_SIZE";
                            default:
                                switch (i) {
                                    case 1004:
                                        return "TEXT_FONT_STROKE_COLOR";
                                    case 1005:
                                        return "TEXT_JUSTIFICATION";
                                    case 1006:
                                        return "VERTICAL_TEXT_ALIGNMENT";
                                    case 1007:
                                        return "EDGE_INSETS";
                                    default:
                                        switch (i) {
                                            case 7000:
                                                return "MEDIA_WINDOW_TYPE";
                                            case PlaybackException.ERROR_CODE_VIDEO_FRAME_PROCESSING_FAILED /* 7001 */:
                                                return "MEDIA_OPTIONS";
                                            case 7002:
                                                return "ASSET_NAME";
                                            case 7003:
                                                return "ASSET_RESOURCE_REFERENCE";
                                            default:
                                                switch (i) {
                                                    case 8001:
                                                        return "OUTLINE_COLOR";
                                                    case 8002:
                                                        return "OVERLAY_TEXT";
                                                    case 8003:
                                                        return "REPEAT_OVERLAY_TEXT";
                                                    default:
                                                        switch (i) {
                                                            case CameraAccessExceptionCompat.CAMERA_UNAVAILABLE_DO_NOT_DISTURB /* 10001 */:
                                                                return "SOUND_SAMPLE_SIZE";
                                                            case CameraAccessExceptionCompat.CAMERA_CHARACTERISTICS_CREATION_ERROR /* 10002 */:
                                                                return "SOUND_SAMPLE_RATE";
                                                            case 10003:
                                                                return "SOUND_CHANNELS";
                                                            case 10004:
                                                                return "SOUND_ENCODING";
                                                            default:
                                                                return Integer.toString(i);
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }
}
