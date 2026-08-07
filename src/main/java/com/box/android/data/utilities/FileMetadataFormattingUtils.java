package com.box.android.data.utilities;

import androidx.exifinterface.media.ExifInterface;
import com.box.androidsdk.content.models.BoxOrder;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.time.TimeZones;
import org.slf4j.Marker;

/* JADX INFO: compiled from: FileMetadataUtils.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005J\u0016\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u0005H\u0002R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/box/android/data/utilities/FileMetadataFormattingUtils;", "", "<init>", "()V", "formatExifGpsLocation", "", "latRational", "latRef", "lonRational", "lonRef", "formatIso6709LocationToHumanReadable", "iso6709OrRaw", "formatImageTimestamp", "dateTime", "offset", "formatMediaTimestamp", BoxOrder.SORT_DATE, "EXIF_TAG_LABELS", "", "formatExifTagLabel", "tag", "formatExifTagValue", "rawValue", "formatExposureTime", "value", "formatFNumber", "formatFocalLength", "parseGpsRationalToDecimal", "", "rational", "(Ljava/lang/String;)Ljava/lang/Double;", "parseMediaDate", "Ljava/util/Date;", "mediaDate", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileMetadataFormattingUtils {
    public static final FileMetadataFormattingUtils INSTANCE = new FileMetadataFormattingUtils();
    private static final Map<String, String> EXIF_TAG_LABELS = MapsKt.mapOf(TuplesKt.to(ExifInterface.TAG_EXPOSURE_MODE, "exposure mode"), TuplesKt.to(ExifInterface.TAG_EXPOSURE_PROGRAM, "exposure program"), TuplesKt.to(ExifInterface.TAG_EXPOSURE_TIME, "exposure time"), TuplesKt.to(ExifInterface.TAG_F_NUMBER, "f number"), TuplesKt.to(ExifInterface.TAG_FOCAL_LENGTH, "focal length"), TuplesKt.to(ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, ExifInterface.TAG_RW2_ISO), TuplesKt.to(ExifInterface.TAG_LENS_MAKE, "lens make"), TuplesKt.to(ExifInterface.TAG_LENS_MODEL, "lens model"), TuplesKt.to(ExifInterface.TAG_WHITE_BALANCE, "white balance"));

    private FileMetadataFormattingUtils() {
    }

    public final String formatExifGpsLocation(String latRational, String latRef, String lonRational, String lonRef) {
        Intrinsics.checkNotNullParameter(latRational, "latRational");
        Intrinsics.checkNotNullParameter(latRef, "latRef");
        Intrinsics.checkNotNullParameter(lonRational, "lonRational");
        Intrinsics.checkNotNullParameter(lonRef, "lonRef");
        Double gpsRationalToDecimal = parseGpsRationalToDecimal(latRational);
        if (gpsRationalToDecimal != null) {
            double dDoubleValue = gpsRationalToDecimal.doubleValue();
            Double gpsRationalToDecimal2 = parseGpsRationalToDecimal(lonRational);
            if (gpsRationalToDecimal2 != null) {
                double dDoubleValue2 = gpsRationalToDecimal2.doubleValue();
                Locale locale = Locale.ENGLISH;
                Double dValueOf = Double.valueOf(dDoubleValue);
                String upperCase = latRef.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                Double dValueOf2 = Double.valueOf(dDoubleValue2);
                String upperCase2 = lonRef.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                String str = String.format(locale, "%.6f %s, %.6f %s", Arrays.copyOf(new Object[]{dValueOf, upperCase, dValueOf2, upperCase2}, 4));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }
        return null;
    }

    public final String formatIso6709LocationToHumanReadable(String iso6709OrRaw) {
        Intrinsics.checkNotNullParameter(iso6709OrRaw, "iso6709OrRaw");
        MatchResult matchResultFind$default = Regex.find$default(new Regex("^([+-])([0-9]+(?:\\.[0-9]+)?)([+-])([0-9]+(?:\\.[0-9]+)?)([+-][0-9]+(?:\\.[0-9]+)?)?$"), StringsKt.trimEnd(StringsKt.trim((CharSequence) iso6709OrRaw).toString(), '/'), 0, 2, null);
        if (matchResultFind$default == null) {
            return null;
        }
        MatchResult.Destructured destructured = matchResultFind$default.getDestructured();
        String str = destructured.getMatch().getGroupValues().get(1);
        String str2 = destructured.getMatch().getGroupValues().get(2);
        String str3 = destructured.getMatch().getGroupValues().get(3);
        String str4 = destructured.getMatch().getGroupValues().get(4);
        Double doubleOrNull = StringsKt.toDoubleOrNull(str2);
        if (doubleOrNull != null) {
            double dDoubleValue = doubleOrNull.doubleValue();
            Double doubleOrNull2 = StringsKt.toDoubleOrNull(str4);
            if (doubleOrNull2 != null) {
                String str5 = String.format(Locale.ENGLISH, "%.6f %s, %.6f %s", Arrays.copyOf(new Object[]{Double.valueOf(dDoubleValue), Intrinsics.areEqual(str, Marker.ANY_NON_NULL_MARKER) ? "N" : ExifInterface.LATITUDE_SOUTH, Double.valueOf(doubleOrNull2.doubleValue()), Intrinsics.areEqual(str3, Marker.ANY_NON_NULL_MARKER) ? ExifInterface.LONGITUDE_EAST : ExifInterface.LONGITUDE_WEST}, 4));
                Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                return str5;
            }
        }
        return null;
    }

    public final String formatImageTimestamp(String dateTime, String offset) {
        Intrinsics.checkNotNullParameter(dateTime, "dateTime");
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.ENGLISH);
            String str = offset;
            simpleDateFormat.setTimeZone((str == null || StringsKt.isBlank(str)) ? TimeZone.getDefault() : TimeZone.getTimeZone(TimeZones.GMT_ID + offset));
            Date date = simpleDateFormat.parse(dateTime);
            if (date == null) {
                return null;
            }
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat2.format(date);
        } catch (Exception unused) {
            return null;
        }
    }

    public final String formatMediaTimestamp(String date) {
        Date mediaDate;
        if (date == null || (mediaDate = INSTANCE.parseMediaDate(date)) == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(mediaDate);
    }

    public final String formatExifTagLabel(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        String str = EXIF_TAG_LABELS.get(tag);
        if (str != null) {
            return str;
        }
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = tag.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final String formatExifTagValue(String tag, String rawValue) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(rawValue, "rawValue");
        int iHashCode = tag.hashCode();
        if (iHashCode != -1484604268) {
            if (iHashCode != 45218607) {
                if (iHashCode == 767426955 && tag.equals(ExifInterface.TAG_FOCAL_LENGTH)) {
                    return formatFocalLength(rawValue);
                }
            } else if (tag.equals(ExifInterface.TAG_F_NUMBER)) {
                return formatFNumber(rawValue);
            }
        } else if (tag.equals(ExifInterface.TAG_EXPOSURE_TIME)) {
            return formatExposureTime(rawValue);
        }
        return rawValue;
    }

    private final String formatExposureTime(String value) {
        Double doubleOrNull = StringsKt.toDoubleOrNull(value);
        if (doubleOrNull != null) {
            double dDoubleValue = doubleOrNull.doubleValue();
            if (dDoubleValue > 0.0d) {
                if (dDoubleValue >= 1.0d) {
                    return new BigDecimal(String.valueOf(dDoubleValue)).stripTrailingZeros().toPlainString() + "s";
                }
                long jRint = (long) Math.rint(1.0d / dDoubleValue);
                if (jRint > 1) {
                    return "1/" + jRint + "s";
                }
                return new BigDecimal(String.valueOf(dDoubleValue)).stripTrailingZeros().toPlainString() + "s";
            }
        }
        return value;
    }

    private final String formatFNumber(String value) {
        BigDecimal bigDecimalStripTrailingZeros;
        String plainString;
        Double doubleOrNull = StringsKt.toDoubleOrNull(value);
        if (doubleOrNull != null) {
            doubleOrNull.doubleValue();
            BigDecimal bigDecimalOrNull = StringsKt.toBigDecimalOrNull(value);
            if (bigDecimalOrNull != null && (bigDecimalStripTrailingZeros = bigDecimalOrNull.stripTrailingZeros()) != null && (plainString = bigDecimalStripTrailingZeros.toPlainString()) != null) {
                return "f/" + plainString;
            }
        }
        return value;
    }

    private final String formatFocalLength(String value) {
        BigDecimal bigDecimalStripTrailingZeros;
        String plainString;
        Double doubleOrNull;
        String str = value;
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "/", false, 2, (Object) null)) {
            List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{"/"}, false, 0, 6, (Object) null);
            if (listSplit$default.size() == 2 && (doubleOrNull = StringsKt.toDoubleOrNull(StringsKt.trim((CharSequence) listSplit$default.get(0)).toString())) != null) {
                double dDoubleValue = doubleOrNull.doubleValue();
                Double doubleOrNull2 = StringsKt.toDoubleOrNull(StringsKt.trim((CharSequence) listSplit$default.get(1)).toString());
                if (doubleOrNull2 != null) {
                    double dDoubleValue2 = doubleOrNull2.doubleValue();
                    return dDoubleValue2 == 0.0d ? value : new BigDecimal(String.valueOf(dDoubleValue / dDoubleValue2)).stripTrailingZeros().toPlainString() + "mm";
                }
            }
        } else {
            Double doubleOrNull3 = StringsKt.toDoubleOrNull(value);
            if (doubleOrNull3 != null) {
                doubleOrNull3.doubleValue();
                BigDecimal bigDecimalOrNull = StringsKt.toBigDecimalOrNull(value);
                if (bigDecimalOrNull != null && (bigDecimalStripTrailingZeros = bigDecimalOrNull.stripTrailingZeros()) != null && (plainString = bigDecimalStripTrailingZeros.toPlainString()) != null) {
                    return plainString + "mm";
                }
            }
        }
        return value;
    }

    private final Double parseGpsRationalToDecimal(String rational) {
        Double doubleOrNull;
        List listSplit$default = StringsKt.split$default((CharSequence) rational, new String[]{","}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        Iterator it = listSplit$default.iterator();
        while (true) {
            Double dValueOf = null;
            if (!it.hasNext()) {
                break;
            }
            List listSplit$default2 = StringsKt.split$default((CharSequence) StringsKt.trim((CharSequence) it.next()).toString(), new String[]{"/"}, false, 0, 6, (Object) null);
            if (listSplit$default2.size() == 2 && (doubleOrNull = StringsKt.toDoubleOrNull(StringsKt.trim((CharSequence) listSplit$default2.get(0)).toString())) != null) {
                double dDoubleValue = doubleOrNull.doubleValue();
                Double doubleOrNull2 = StringsKt.toDoubleOrNull(StringsKt.trim((CharSequence) listSplit$default2.get(1)).toString());
                if (doubleOrNull2 != null) {
                    double dDoubleValue2 = doubleOrNull2.doubleValue();
                    if (dDoubleValue2 != 0.0d) {
                        dValueOf = Double.valueOf(dDoubleValue / dDoubleValue2);
                    }
                }
            }
            if (dValueOf != null) {
                arrayList.add(dValueOf);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.size() != 3) {
            return null;
        }
        return Double.valueOf(((Number) arrayList2.get(0)).doubleValue() + (((Number) arrayList2.get(1)).doubleValue() / 60.0d) + (((Number) arrayList2.get(2)).doubleValue() / 3600.0d));
    }

    private final Date parseMediaDate(String mediaDate) {
        Date date;
        Iterator it = CollectionsKt.listOf((Object[]) new String[]{"yyyyMMdd'T'HHmmss.SSS'Z'", "yyyyMMdd'T'HHmmss'Z'"}).iterator();
        do {
            date = null;
            if (!it.hasNext()) {
                break;
            }
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat((String) it.next(), Locale.ENGLISH);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                date = simpleDateFormat.parse(mediaDate);
            } catch (Exception unused) {
            }
        } while (date == null);
        return date;
    }
}
