package org.yaml.snakeyaml.representer;

import androidx.exifinterface.media.ExifInterface;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.codec.language.Soundex;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.reader.StreamReader;

/* JADX INFO: loaded from: classes5.dex */
class SafeRepresenter extends BaseRepresenter {
    private static final Pattern MULTILINE_PATTERN = Pattern.compile("\n|\u0085|\u2028|\u2029");
    protected Map<Class<? extends Object>, Tag> classTags;
    protected DumperOptions.NonPrintableStyle nonPrintableStyle;
    protected TimeZone timeZone = null;

    public SafeRepresenter(DumperOptions dumperOptions) {
        if (dumperOptions == null) {
            throw new NullPointerException("DumperOptions must be provided.");
        }
        this.nullRepresenter = new RepresentNull();
        this.representers.put(String.class, new RepresentString());
        this.representers.put(Boolean.class, new RepresentBoolean());
        this.representers.put(Character.class, new RepresentString());
        this.representers.put(UUID.class, new RepresentUuid());
        this.representers.put(byte[].class, new RepresentByteArray());
        RepresentPrimitiveArray representPrimitiveArray = new RepresentPrimitiveArray();
        this.representers.put(short[].class, representPrimitiveArray);
        this.representers.put(int[].class, representPrimitiveArray);
        this.representers.put(long[].class, representPrimitiveArray);
        this.representers.put(float[].class, representPrimitiveArray);
        this.representers.put(double[].class, representPrimitiveArray);
        this.representers.put(char[].class, representPrimitiveArray);
        this.representers.put(boolean[].class, representPrimitiveArray);
        this.multiRepresenters.put(Number.class, new RepresentNumber());
        this.multiRepresenters.put(List.class, new RepresentList());
        this.multiRepresenters.put(Map.class, new RepresentMap());
        this.multiRepresenters.put(Set.class, new RepresentSet());
        this.multiRepresenters.put(Iterator.class, new RepresentIterator());
        this.multiRepresenters.put(new Object[0].getClass(), new RepresentArray());
        this.multiRepresenters.put(Date.class, new RepresentDate());
        this.multiRepresenters.put(Enum.class, new RepresentEnum());
        this.multiRepresenters.put(Calendar.class, new RepresentDate());
        this.classTags = new HashMap();
        this.nonPrintableStyle = dumperOptions.getNonPrintableStyle();
        setDefaultScalarStyle(dumperOptions.getDefaultScalarStyle());
        setDefaultFlowStyle(dumperOptions.getDefaultFlowStyle());
    }

    protected Tag getTag(Class<?> cls, Tag tag) {
        return this.classTags.containsKey(cls) ? this.classTags.get(cls) : tag;
    }

    public Tag addClassTag(Class<? extends Object> cls, Tag tag) {
        if (tag == null) {
            throw new NullPointerException("Tag must be provided.");
        }
        return this.classTags.put(cls, tag);
    }

    protected class RepresentNull implements Represent {
        protected RepresentNull() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            return SafeRepresenter.this.representScalar(Tag.NULL, AbstractJsonLexerKt.NULL);
        }
    }

    protected class RepresentString implements Represent {
        protected RepresentString() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            Tag tag = Tag.STR;
            DumperOptions.ScalarStyle scalarStyle = SafeRepresenter.this.defaultScalarStyle;
            String string = obj.toString();
            if (SafeRepresenter.this.nonPrintableStyle == DumperOptions.NonPrintableStyle.BINARY && !StreamReader.isPrintable(string)) {
                tag = Tag.BINARY;
                byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
                if (!new String(bytes, StandardCharsets.UTF_8).equals(string)) {
                    throw new YAMLException("invalid string value has occurred");
                }
                string = String.valueOf(Base64Coder.encode(bytes));
                scalarStyle = DumperOptions.ScalarStyle.LITERAL;
            }
            if (SafeRepresenter.this.defaultScalarStyle == DumperOptions.ScalarStyle.PLAIN && SafeRepresenter.MULTILINE_PATTERN.matcher(string).find()) {
                scalarStyle = DumperOptions.ScalarStyle.LITERAL;
            }
            return SafeRepresenter.this.representScalar(tag, string, scalarStyle);
        }
    }

    protected class RepresentBoolean implements Represent {
        protected RepresentBoolean() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            String str;
            if (Boolean.TRUE.equals(obj)) {
                str = TelemetryEventStrings.Value.TRUE;
            } else {
                str = "false";
            }
            return SafeRepresenter.this.representScalar(Tag.BOOL, str);
        }
    }

    protected class RepresentNumber implements Represent {
        protected RepresentNumber() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            Tag tag;
            String string;
            if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof BigInteger)) {
                tag = Tag.INT;
                string = obj.toString();
            } else {
                Number number = (Number) obj;
                tag = Tag.FLOAT;
                if (number.equals(Double.valueOf(Double.NaN))) {
                    string = ".NaN";
                } else if (number.equals(Double.valueOf(Double.POSITIVE_INFINITY))) {
                    string = ".inf";
                } else if (number.equals(Double.valueOf(Double.NEGATIVE_INFINITY))) {
                    string = "-.inf";
                } else {
                    string = number.toString();
                }
            }
            SafeRepresenter safeRepresenter = SafeRepresenter.this;
            return safeRepresenter.representScalar(safeRepresenter.getTag(obj.getClass(), tag), string);
        }
    }

    protected class RepresentList implements Represent {
        protected RepresentList() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            SafeRepresenter safeRepresenter = SafeRepresenter.this;
            return safeRepresenter.representSequence(safeRepresenter.getTag(obj.getClass(), Tag.SEQ), (List) obj, DumperOptions.FlowStyle.AUTO);
        }
    }

    protected class RepresentIterator implements Represent {
        protected RepresentIterator() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            Iterator it = (Iterator) obj;
            SafeRepresenter safeRepresenter = SafeRepresenter.this;
            return safeRepresenter.representSequence(safeRepresenter.getTag(obj.getClass(), Tag.SEQ), new IteratorWrapper(it), DumperOptions.FlowStyle.AUTO);
        }
    }

    private static class IteratorWrapper implements Iterable<Object> {
        private final Iterator<Object> iter;

        public IteratorWrapper(Iterator<Object> it) {
            this.iter = it;
        }

        @Override // java.lang.Iterable
        public Iterator<Object> iterator() {
            return this.iter;
        }
    }

    protected class RepresentArray implements Represent {
        protected RepresentArray() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            return SafeRepresenter.this.representSequence(Tag.SEQ, Arrays.asList((Object[]) obj), DumperOptions.FlowStyle.AUTO);
        }
    }

    protected class RepresentPrimitiveArray implements Represent {
        protected RepresentPrimitiveArray() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (Byte.TYPE == componentType) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, asByteList(obj), DumperOptions.FlowStyle.AUTO);
            }
            if (Short.TYPE == componentType) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, asShortList(obj), DumperOptions.FlowStyle.AUTO);
            }
            if (Integer.TYPE == componentType) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, asIntList(obj), DumperOptions.FlowStyle.AUTO);
            }
            if (Long.TYPE == componentType) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, asLongList(obj), DumperOptions.FlowStyle.AUTO);
            }
            if (Float.TYPE == componentType) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, asFloatList(obj), DumperOptions.FlowStyle.AUTO);
            }
            if (Double.TYPE == componentType) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, asDoubleList(obj), DumperOptions.FlowStyle.AUTO);
            }
            if (Character.TYPE == componentType) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, asCharList(obj), DumperOptions.FlowStyle.AUTO);
            }
            if (Boolean.TYPE == componentType) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, asBooleanList(obj), DumperOptions.FlowStyle.AUTO);
            }
            throw new YAMLException("Unexpected primitive '" + componentType.getCanonicalName() + "'");
        }

        private List<Byte> asByteList(Object obj) {
            byte[] bArr = (byte[]) obj;
            ArrayList arrayList = new ArrayList(bArr.length);
            for (byte b : bArr) {
                arrayList.add(Byte.valueOf(b));
            }
            return arrayList;
        }

        private List<Short> asShortList(Object obj) {
            short[] sArr = (short[]) obj;
            ArrayList arrayList = new ArrayList(sArr.length);
            for (short s : sArr) {
                arrayList.add(Short.valueOf(s));
            }
            return arrayList;
        }

        private List<Integer> asIntList(Object obj) {
            int[] iArr = (int[]) obj;
            ArrayList arrayList = new ArrayList(iArr.length);
            for (int i : iArr) {
                arrayList.add(Integer.valueOf(i));
            }
            return arrayList;
        }

        private List<Long> asLongList(Object obj) {
            long[] jArr = (long[]) obj;
            ArrayList arrayList = new ArrayList(jArr.length);
            for (long j : jArr) {
                arrayList.add(Long.valueOf(j));
            }
            return arrayList;
        }

        private List<Float> asFloatList(Object obj) {
            float[] fArr = (float[]) obj;
            ArrayList arrayList = new ArrayList(fArr.length);
            for (float f : fArr) {
                arrayList.add(Float.valueOf(f));
            }
            return arrayList;
        }

        private List<Double> asDoubleList(Object obj) {
            double[] dArr = (double[]) obj;
            ArrayList arrayList = new ArrayList(dArr.length);
            for (double d : dArr) {
                arrayList.add(Double.valueOf(d));
            }
            return arrayList;
        }

        private List<Character> asCharList(Object obj) {
            char[] cArr = (char[]) obj;
            ArrayList arrayList = new ArrayList(cArr.length);
            for (char c : cArr) {
                arrayList.add(Character.valueOf(c));
            }
            return arrayList;
        }

        private List<Boolean> asBooleanList(Object obj) {
            boolean[] zArr = (boolean[]) obj;
            ArrayList arrayList = new ArrayList(zArr.length);
            for (boolean z : zArr) {
                arrayList.add(Boolean.valueOf(z));
            }
            return arrayList;
        }
    }

    protected class RepresentMap implements Represent {
        protected RepresentMap() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            SafeRepresenter safeRepresenter = SafeRepresenter.this;
            return safeRepresenter.representMapping(safeRepresenter.getTag(obj.getClass(), Tag.MAP), (Map) obj, DumperOptions.FlowStyle.AUTO);
        }
    }

    protected class RepresentSet implements Represent {
        protected RepresentSet() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = ((Set) obj).iterator();
            while (it.hasNext()) {
                linkedHashMap.put(it.next(), null);
            }
            SafeRepresenter safeRepresenter = SafeRepresenter.this;
            return safeRepresenter.representMapping(safeRepresenter.getTag(obj.getClass(), Tag.SET), linkedHashMap, DumperOptions.FlowStyle.AUTO);
        }
    }

    protected class RepresentDate implements Represent {
        protected RepresentDate() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            Calendar calendar;
            if (obj instanceof Calendar) {
                calendar = (Calendar) obj;
            } else {
                calendar = Calendar.getInstance(SafeRepresenter.this.getTimeZone() == null ? TimeZone.getTimeZone("UTC") : SafeRepresenter.this.timeZone);
                calendar.setTime((Date) obj);
            }
            int i = calendar.get(1);
            int i2 = calendar.get(2) + 1;
            int i3 = calendar.get(5);
            int i4 = calendar.get(11);
            int i5 = calendar.get(12);
            int i6 = calendar.get(13);
            int i7 = calendar.get(14);
            StringBuilder sb = new StringBuilder(String.valueOf(i));
            while (sb.length() < 4) {
                sb.insert(0, "0");
            }
            sb.append(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
            if (i2 < 10) {
                sb.append("0");
            }
            sb.append(i2);
            sb.append(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
            if (i3 < 10) {
                sb.append("0");
            }
            sb.append(i3);
            sb.append(ExifInterface.GPS_DIRECTION_TRUE);
            if (i4 < 10) {
                sb.append("0");
            }
            sb.append(i4);
            sb.append(":");
            if (i5 < 10) {
                sb.append("0");
            }
            sb.append(i5);
            sb.append(":");
            if (i6 < 10) {
                sb.append("0");
            }
            sb.append(i6);
            if (i7 > 0) {
                if (i7 < 10) {
                    sb.append(".00");
                } else if (i7 < 100) {
                    sb.append(".0");
                } else {
                    sb.append(".");
                }
                sb.append(i7);
            }
            int offset = calendar.getTimeZone().getOffset(calendar.getTime().getTime());
            if (offset == 0) {
                sb.append('Z');
            } else {
                if (offset < 0) {
                    sb.append(Soundex.SILENT_MARKER);
                    offset *= -1;
                } else {
                    sb.append('+');
                }
                int i8 = offset / 60000;
                int i9 = i8 / 60;
                int i10 = i8 % 60;
                if (i9 < 10) {
                    sb.append('0');
                }
                sb.append(i9);
                sb.append(AbstractJsonLexerKt.COLON);
                if (i10 < 10) {
                    sb.append('0');
                }
                sb.append(i10);
            }
            SafeRepresenter safeRepresenter = SafeRepresenter.this;
            return safeRepresenter.representScalar(safeRepresenter.getTag(obj.getClass(), Tag.TIMESTAMP), sb.toString(), DumperOptions.ScalarStyle.PLAIN);
        }
    }

    protected class RepresentEnum implements Represent {
        protected RepresentEnum() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            Tag tag = new Tag((Class<? extends Object>) obj.getClass());
            SafeRepresenter safeRepresenter = SafeRepresenter.this;
            return safeRepresenter.representScalar(safeRepresenter.getTag(obj.getClass(), tag), ((Enum) obj).name());
        }
    }

    protected class RepresentByteArray implements Represent {
        protected RepresentByteArray() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            return SafeRepresenter.this.representScalar(Tag.BINARY, String.valueOf(Base64Coder.encode((byte[]) obj)), DumperOptions.ScalarStyle.LITERAL);
        }
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    protected class RepresentUuid implements Represent {
        protected RepresentUuid() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            SafeRepresenter safeRepresenter = SafeRepresenter.this;
            return safeRepresenter.representScalar(safeRepresenter.getTag(obj.getClass(), new Tag((Class<? extends Object>) UUID.class)), obj.toString());
        }
    }
}
