package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes14.dex */
final class MessageSchema<T> implements Schema<T> {
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int INTS_PER_FIELD = 3;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_MASK = 268435456;
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final boolean proto3;
    private final int repeatedFieldOffsetStart;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();

    private static boolean isEnforceUtf8(int i) {
        return (i & 536870912) != 0;
    }

    private static boolean isRequired(int i) {
        return (i & 268435456) != 0;
    }

    private static long offset(int i) {
        return i & OFFSET_MASK;
    }

    private static int type(int i) {
        return (i & FIELD_TYPE_MASK) >>> 20;
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i, int i2, MessageLite messageLite, boolean z, boolean z2, int[] iArr2, int i3, int i4, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i;
        this.maxFieldNumber = i2;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.proto3 = z;
        this.hasExtensions = extensionSchema != null && extensionSchema.hasExtensions(messageLite);
        this.useCachedSizeField = z2;
        this.intArray = iArr2;
        this.checkInitializedCount = i3;
        this.repeatedFieldOffsetStart = i4;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema;
    }

    static <T> MessageSchema<T> newSchema(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        if (messageInfo instanceof RawMessageInfo) {
            return newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
        }
        return newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Code duplicated, block: B:124:0x0279  */
    /* JADX WARN: Code duplicated, block: B:125:0x027c  */
    /* JADX WARN: Code duplicated, block: B:128:0x0296  */
    /* JADX WARN: Code duplicated, block: B:129:0x0299  */
    /* JADX WARN: Code duplicated, block: B:164:0x0351  */
    /* JADX WARN: Code duplicated, block: B:179:0x039d  */
    /* JADX WARN: Code duplicated, block: B:182:0x03a7  */
    static <T> MessageSchema<T> newSchemaForRawMessageInfo(RawMessageInfo rawMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int i;
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int i2;
        int i3;
        int i4;
        int[] iArr;
        int i5;
        char cCharAt;
        int i6;
        char cCharAt2;
        int i7;
        char cCharAt3;
        int i8;
        char cCharAt4;
        int i9;
        char cCharAt5;
        int i10;
        char cCharAt6;
        int i11;
        char cCharAt7;
        int i12;
        char cCharAt8;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int iObjectFieldOffset;
        int i18;
        int iObjectFieldOffset2;
        int i19;
        int i20;
        int i21;
        Field fieldReflectField;
        char cCharAt9;
        int i22;
        int i23;
        int i24;
        Object obj;
        Field fieldReflectField2;
        int i25;
        Object obj2;
        Field fieldReflectField3;
        int i26;
        char cCharAt10;
        int i27;
        char cCharAt11;
        int i28;
        int i29;
        char cCharAt12;
        int i30;
        char cCharAt13;
        char cCharAt14;
        int i31 = 0;
        boolean z = rawMessageInfo.getSyntax() == ProtoSyntax.PROTO3;
        String stringInfo = rawMessageInfo.getStringInfo();
        int length = stringInfo.length();
        int iCharAt4 = stringInfo.charAt(0);
        if (iCharAt4 >= 55296) {
            int i32 = iCharAt4 & 8191;
            int i33 = 1;
            int i34 = 13;
            while (true) {
                i = i33 + 1;
                cCharAt14 = stringInfo.charAt(i33);
                if (cCharAt14 < 55296) {
                    break;
                }
                i32 |= (cCharAt14 & 8191) << i34;
                i34 += 13;
                i33 = i;
            }
            iCharAt4 = i32 | (cCharAt14 << i34);
        } else {
            i = 1;
        }
        int i35 = i + 1;
        int iCharAt5 = stringInfo.charAt(i);
        if (iCharAt5 >= 55296) {
            int i36 = iCharAt5 & 8191;
            int i37 = 13;
            while (true) {
                i30 = i35 + 1;
                cCharAt13 = stringInfo.charAt(i35);
                if (cCharAt13 < 55296) {
                    break;
                }
                i36 |= (cCharAt13 & 8191) << i37;
                i37 += 13;
                i35 = i30;
            }
            iCharAt5 = i36 | (cCharAt13 << i37);
            i35 = i30;
        }
        if (iCharAt5 == 0) {
            iCharAt = 0;
            i4 = 0;
            iCharAt2 = 0;
            i2 = 0;
            iCharAt3 = 0;
            iArr = EMPTY_INT_ARRAY;
            i3 = 0;
        } else {
            int i38 = i35 + 1;
            int iCharAt6 = stringInfo.charAt(i35);
            if (iCharAt6 >= 55296) {
                int i39 = iCharAt6 & 8191;
                int i40 = 13;
                while (true) {
                    i12 = i38 + 1;
                    cCharAt8 = stringInfo.charAt(i38);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i39 |= (cCharAt8 & 8191) << i40;
                    i40 += 13;
                    i38 = i12;
                }
                iCharAt6 = i39 | (cCharAt8 << i40);
                i38 = i12;
            }
            int i41 = i38 + 1;
            int iCharAt7 = stringInfo.charAt(i38);
            if (iCharAt7 >= 55296) {
                int i42 = iCharAt7 & 8191;
                int i43 = 13;
                while (true) {
                    i11 = i41 + 1;
                    cCharAt7 = stringInfo.charAt(i41);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i42 |= (cCharAt7 & 8191) << i43;
                    i43 += 13;
                    i41 = i11;
                }
                iCharAt7 = i42 | (cCharAt7 << i43);
                i41 = i11;
            }
            int i44 = i41 + 1;
            iCharAt = stringInfo.charAt(i41);
            if (iCharAt >= 55296) {
                int i45 = iCharAt & 8191;
                int i46 = 13;
                while (true) {
                    i10 = i44 + 1;
                    cCharAt6 = stringInfo.charAt(i44);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt6 & 8191) << i46;
                    i46 += 13;
                    i44 = i10;
                }
                iCharAt = i45 | (cCharAt6 << i46);
                i44 = i10;
            }
            int i47 = i44 + 1;
            int iCharAt8 = stringInfo.charAt(i44);
            if (iCharAt8 >= 55296) {
                int i48 = iCharAt8 & 8191;
                int i49 = 13;
                while (true) {
                    i9 = i47 + 1;
                    cCharAt5 = stringInfo.charAt(i47);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt5 & 8191) << i49;
                    i49 += 13;
                    i47 = i9;
                }
                iCharAt8 = i48 | (cCharAt5 << i49);
                i47 = i9;
            }
            int i50 = i47 + 1;
            int iCharAt9 = stringInfo.charAt(i47);
            if (iCharAt9 >= 55296) {
                int i51 = iCharAt9 & 8191;
                int i52 = 13;
                while (true) {
                    i8 = i50 + 1;
                    cCharAt4 = stringInfo.charAt(i50);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt4 & 8191) << i52;
                    i52 += 13;
                    i50 = i8;
                }
                iCharAt9 = i51 | (cCharAt4 << i52);
                i50 = i8;
            }
            int i53 = i50 + 1;
            iCharAt2 = stringInfo.charAt(i50);
            if (iCharAt2 >= 55296) {
                int i54 = iCharAt2 & 8191;
                int i55 = 13;
                while (true) {
                    i7 = i53 + 1;
                    cCharAt3 = stringInfo.charAt(i53);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i54 |= (cCharAt3 & 8191) << i55;
                    i55 += 13;
                    i53 = i7;
                }
                iCharAt2 = i54 | (cCharAt3 << i55);
                i53 = i7;
            }
            int i56 = i53 + 1;
            int iCharAt10 = stringInfo.charAt(i53);
            if (iCharAt10 >= 55296) {
                int i57 = iCharAt10 & 8191;
                int i58 = 13;
                while (true) {
                    i6 = i56 + 1;
                    cCharAt2 = stringInfo.charAt(i56);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i57 |= (cCharAt2 & 8191) << i58;
                    i58 += 13;
                    i56 = i6;
                }
                iCharAt10 = i57 | (cCharAt2 << i58);
                i56 = i6;
            }
            int i59 = i56 + 1;
            iCharAt3 = stringInfo.charAt(i56);
            if (iCharAt3 >= 55296) {
                int i60 = iCharAt3 & 8191;
                int i61 = i59;
                int i62 = 13;
                while (true) {
                    i5 = i61 + 1;
                    cCharAt = stringInfo.charAt(i61);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i60 |= (cCharAt & 8191) << i62;
                    i62 += 13;
                    i61 = i5;
                }
                iCharAt3 = i60 | (cCharAt << i62);
                i59 = i5;
            }
            int[] iArr2 = new int[iCharAt3 + iCharAt2 + iCharAt10];
            i2 = (iCharAt6 * 2) + iCharAt7;
            i3 = iCharAt8;
            i4 = iCharAt9;
            iArr = iArr2;
            i31 = iCharAt6;
            i35 = i59;
        }
        Unsafe unsafe = UNSAFE;
        Object[] objects = rawMessageInfo.getObjects();
        Class<?> cls = rawMessageInfo.getDefaultInstance().getClass();
        int[] iArr3 = new int[i4 * 3];
        Object[] objArr = new Object[i4 * 2];
        int i63 = iCharAt2 + iCharAt3;
        int i64 = i63;
        int i65 = iCharAt3;
        int i66 = 0;
        int i67 = 0;
        while (i35 < length) {
            int i68 = i35 + 1;
            int iCharAt11 = stringInfo.charAt(i35);
            int i69 = length;
            if (iCharAt11 >= 55296) {
                int i70 = iCharAt11 & 8191;
                int i71 = i68;
                int i72 = 13;
                while (true) {
                    i29 = i71 + 1;
                    cCharAt12 = stringInfo.charAt(i71);
                    i13 = i31;
                    if (cCharAt12 < 55296) {
                        break;
                    }
                    i70 |= (cCharAt12 & 8191) << i72;
                    i72 += 13;
                    i71 = i29;
                    i31 = i13;
                }
                iCharAt11 = i70 | (cCharAt12 << i72);
                i14 = i29;
            } else {
                i13 = i31;
                i14 = i68;
            }
            int i73 = i14 + 1;
            int iCharAt12 = stringInfo.charAt(i14);
            if (iCharAt12 >= 55296) {
                int i74 = iCharAt12 & 8191;
                int i75 = i73;
                int i76 = 13;
                while (true) {
                    i27 = i75 + 1;
                    cCharAt11 = stringInfo.charAt(i75);
                    i28 = i74;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i74 = i28 | ((cCharAt11 & 8191) << i76);
                    i76 += 13;
                    i75 = i27;
                }
                iCharAt12 = i28 | (cCharAt11 << i76);
                i15 = i27;
            } else {
                i15 = i73;
            }
            int i77 = iCharAt4;
            int i78 = iCharAt12 & 255;
            int[] iArr4 = iArr3;
            if ((iCharAt12 & 1024) != 0) {
                iArr[i66] = i67;
                i66++;
            }
            int i79 = iCharAt11;
            if (i78 >= 51) {
                int i80 = i15 + 1;
                int iCharAt13 = stringInfo.charAt(i15);
                char c = 55296;
                if (iCharAt13 >= 55296) {
                    int i81 = iCharAt13 & 8191;
                    int i82 = 13;
                    while (true) {
                        i26 = i80 + 1;
                        cCharAt10 = stringInfo.charAt(i80);
                        if (cCharAt10 < c) {
                            break;
                        }
                        i81 |= (cCharAt10 & 8191) << i82;
                        i82 += 13;
                        i80 = i26;
                        c = 55296;
                    }
                    iCharAt13 = i81 | (cCharAt10 << i82);
                    i80 = i26;
                }
                int i83 = i78 - 51;
                int i84 = iCharAt13;
                if (i83 == 9 || i83 == 17) {
                    i23 = i2 + 1;
                    objArr[((i67 / 3) * 2) + 1] = objects[i2];
                } else {
                    if (i83 == 12 && (i77 & 1) == 1) {
                        i23 = i2 + 1;
                        objArr[((i67 / 3) * 2) + 1] = objects[i2];
                    }
                    i24 = i84 * 2;
                    obj = objects[i24];
                    if (obj instanceof Field) {
                        fieldReflectField2 = (Field) obj;
                    } else {
                        fieldReflectField2 = reflectField(cls, (String) obj);
                        objects[i24] = fieldReflectField2;
                    }
                    int i85 = i80;
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldReflectField2);
                    i25 = i24 + 1;
                    obj2 = objects[i25];
                    if (obj2 instanceof Field) {
                        fieldReflectField3 = (Field) obj2;
                    } else {
                        fieldReflectField3 = reflectField(cls, (String) obj2);
                        objects[i25] = fieldReflectField3;
                    }
                    stringInfo = stringInfo;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldReflectField3);
                    i35 = i85;
                    i21 = iObjectFieldOffset3;
                    i19 = 0;
                    i16 = i3;
                    i20 = i2;
                    iCharAt = iCharAt;
                }
                i2 = i23;
                i24 = i84 * 2;
                obj = objects[i24];
                if (obj instanceof Field) {
                    fieldReflectField2 = (Field) obj;
                } else {
                    fieldReflectField2 = reflectField(cls, (String) obj);
                    objects[i24] = fieldReflectField2;
                }
                int i86 = i80;
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldReflectField2);
                i25 = i24 + 1;
                obj2 = objects[i25];
                if (obj2 instanceof Field) {
                    fieldReflectField3 = (Field) obj2;
                } else {
                    fieldReflectField3 = reflectField(cls, (String) obj2);
                    objects[i25] = fieldReflectField3;
                }
                stringInfo = stringInfo;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldReflectField3);
                i35 = i86;
                i21 = iObjectFieldOffset4;
                i19 = 0;
                i16 = i3;
                i20 = i2;
                iCharAt = iCharAt;
            } else {
                int i87 = i2 + 1;
                Field fieldReflectField4 = reflectField(cls, (String) objects[i2]);
                if (i78 == 9 || i78 == 17) {
                    i16 = i3;
                    objArr[((i67 / 3) * 2) + 1] = fieldReflectField4.getType();
                } else {
                    if (i78 == 27 || i78 == 49) {
                        i16 = i3;
                        i22 = i2 + 2;
                        objArr[((i67 / 3) * 2) + 1] = objects[i87];
                    } else if (i78 == 12 || i78 == 30 || i78 == 44) {
                        i16 = i3;
                        if ((i77 & 1) == 1) {
                            i22 = i2 + 2;
                            objArr[((i67 / 3) * 2) + 1] = objects[i87];
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                        if ((i77 & 1) == 1 || i78 > 17) {
                            i18 = i15;
                            iObjectFieldOffset2 = 0;
                            i19 = 0;
                        } else {
                            int i88 = i15 + 1;
                            int iCharAt14 = stringInfo.charAt(i15);
                            if (iCharAt14 >= 55296) {
                                int i89 = iCharAt14 & 8191;
                                int i90 = 13;
                                while (true) {
                                    i18 = i88 + 1;
                                    cCharAt9 = stringInfo.charAt(i88);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i89 |= (cCharAt9 & 8191) << i90;
                                    i90 += 13;
                                    i88 = i18;
                                }
                                iCharAt14 = i89 | (cCharAt9 << i90);
                            } else {
                                i18 = i88;
                            }
                            int i91 = (i13 * 2) + (iCharAt14 / 32);
                            Object obj3 = objects[i91];
                            if (obj3 instanceof Field) {
                                fieldReflectField = (Field) obj3;
                            } else {
                                fieldReflectField = reflectField(cls, (String) obj3);
                                objects[i91] = fieldReflectField;
                            }
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldReflectField);
                            i19 = iCharAt14 % 32;
                        }
                        if (i78 >= 18 && i78 <= 49) {
                            iArr[i64] = iObjectFieldOffset;
                            i64++;
                        }
                        i20 = i17;
                        i21 = iObjectFieldOffset;
                        i35 = i18;
                    } else {
                        if (i78 == 50) {
                            int i92 = i65 + 1;
                            iArr[i65] = i67;
                            int i93 = (i67 / 3) * 2;
                            int i94 = i2 + 2;
                            objArr[i93] = objects[i87];
                            if ((iCharAt12 & 2048) != 0) {
                                i17 = i2 + 3;
                                objArr[i93 + 1] = objects[i94];
                                i16 = i3;
                                i65 = i92;
                            } else {
                                i17 = i94;
                                i65 = i92;
                                i16 = i3;
                            }
                        } else {
                            i16 = i3;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                        if ((i77 & 1) == 1) {
                            i18 = i15;
                            iObjectFieldOffset2 = 0;
                            i19 = 0;
                        } else {
                            i18 = i15;
                            iObjectFieldOffset2 = 0;
                            i19 = 0;
                        }
                        if (i78 >= 18) {
                            iArr[i64] = iObjectFieldOffset;
                            i64++;
                        }
                        i20 = i17;
                        i21 = iObjectFieldOffset;
                        i35 = i18;
                    }
                    i17 = i22;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                    if ((i77 & 1) == 1) {
                        i18 = i15;
                        iObjectFieldOffset2 = 0;
                        i19 = 0;
                    } else {
                        i18 = i15;
                        iObjectFieldOffset2 = 0;
                        i19 = 0;
                    }
                    if (i78 >= 18) {
                        iArr[i64] = iObjectFieldOffset;
                        i64++;
                    }
                    i20 = i17;
                    i21 = iObjectFieldOffset;
                    i35 = i18;
                }
                i17 = i87;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                if ((i77 & 1) == 1) {
                    i18 = i15;
                    iObjectFieldOffset2 = 0;
                    i19 = 0;
                } else {
                    i18 = i15;
                    iObjectFieldOffset2 = 0;
                    i19 = 0;
                }
                if (i78 >= 18) {
                    iArr[i64] = iObjectFieldOffset;
                    i64++;
                }
                i20 = i17;
                i21 = iObjectFieldOffset;
                i35 = i18;
            }
            int i95 = i67 + 1;
            iArr4[i67] = i79;
            int i96 = i67 + 2;
            int i97 = iObjectFieldOffset2;
            iArr4[i95] = ((iCharAt12 & 512) != 0 ? 536870912 : 0) | ((iCharAt12 & 256) != 0 ? 268435456 : 0) | (i78 << 20) | i21;
            i67 += 3;
            iArr4[i96] = (i19 << 20) | i97;
            iCharAt = iCharAt;
            iCharAt4 = i77;
            length = i69;
            iArr3 = iArr4;
            i31 = i13;
            stringInfo = stringInfo;
            i2 = i20;
            i3 = i16;
        }
        return new MessageSchema<>(iArr3, objArr, iCharAt, i3, rawMessageInfo.getDefaultInstance(), z, false, iArr, iCharAt3, i63, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    private static Field reflectField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int fieldNumber;
        int fieldNumber2;
        boolean z = structuralMessageInfo.getSyntax() == ProtoSyntax.PROTO3;
        FieldInfo[] fields = structuralMessageInfo.getFields();
        if (fields.length == 0) {
            fieldNumber = 0;
            fieldNumber2 = 0;
        } else {
            fieldNumber = fields[0].getFieldNumber();
            fieldNumber2 = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        int i = 0;
        int i2 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == FieldType.MAP) {
                i++;
            } else if (fieldInfo.getType().id() >= 18 && fieldInfo.getType().id() <= 49) {
                i2++;
            }
        }
        int[] iArr2 = i > 0 ? new int[i] : null;
        int[] iArr3 = i2 > 0 ? new int[i2] : null;
        int[] checkInitialized = structuralMessageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i3 < fields.length) {
            FieldInfo fieldInfo2 = fields[i3];
            int fieldNumber3 = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr, i4, z, objArr);
            if (i5 < checkInitialized.length && checkInitialized[i5] == fieldNumber3) {
                checkInitialized[i5] = i4;
                i5++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr2[i6] = i4;
                i6++;
            } else {
                if (fieldInfo2.getType().id() >= 18 && fieldInfo2.getType().id() <= 49) {
                    iArr3[i7] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                    i7++;
                }
                i3++;
                i4 += 3;
            }
            i3++;
            i4 += 3;
        }
        if (iArr2 == null) {
            iArr2 = EMPTY_INT_ARRAY;
        }
        if (iArr3 == null) {
            iArr3 = EMPTY_INT_ARRAY;
        }
        int[] iArr4 = new int[checkInitialized.length + iArr2.length + iArr3.length];
        System.arraycopy(checkInitialized, 0, iArr4, 0, checkInitialized.length);
        System.arraycopy(iArr2, 0, iArr4, checkInitialized.length, iArr2.length);
        System.arraycopy(iArr3, 0, iArr4, checkInitialized.length + iArr2.length, iArr3.length);
        return new MessageSchema<>(iArr, objArr, fieldNumber, fieldNumber2, structuralMessageInfo.getDefaultInstance(), z, true, iArr4, checkInitialized.length, checkInitialized.length + iArr2.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0081  */
    /* JADX WARN: Code duplicated, block: B:20:0x0084  */
    /* JADX WARN: Code duplicated, block: B:23:0x008b  */
    /* JADX WARN: Code duplicated, block: B:26:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:28:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:30:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:32:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:37:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:39:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    private static void storeFieldData(FieldInfo fieldInfo, int[] iArr, int i, boolean z, Object[] objArr) {
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int iId;
        int iNumberOfTrailingZeros;
        int i2;
        int i3;
        int i4;
        Class<?> messageFieldClass;
        int i5;
        OneofInfo oneof = fieldInfo.getOneof();
        if (oneof != null) {
            iId = fieldInfo.getType().id() + 51;
            iObjectFieldOffset = (int) UnsafeUtil.objectFieldOffset(oneof.getValueField());
            iObjectFieldOffset2 = (int) UnsafeUtil.objectFieldOffset(oneof.getCaseField());
        } else {
            FieldType type = fieldInfo.getType();
            iObjectFieldOffset = (int) UnsafeUtil.objectFieldOffset(fieldInfo.getField());
            int iId2 = type.id();
            if (!z && !type.isList() && !type.isMap()) {
                int iObjectFieldOffset3 = (int) UnsafeUtil.objectFieldOffset(fieldInfo.getPresenceField());
                iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(fieldInfo.getPresenceMask());
                iId = iId2;
                i2 = iObjectFieldOffset;
                i3 = iObjectFieldOffset3;
            } else if (fieldInfo.getCachedSizeField() == null) {
                iNumberOfTrailingZeros = 0;
                iId = iId2;
                i2 = iObjectFieldOffset;
                i3 = 0;
            } else {
                iObjectFieldOffset2 = (int) UnsafeUtil.objectFieldOffset(fieldInfo.getCachedSizeField());
                iId = iId2;
            }
            iArr[i] = fieldInfo.getFieldNumber();
            int i6 = i + 1;
            if (fieldInfo.isEnforceUtf8()) {
                i4 = 536870912;
            } else {
                i4 = 0;
            }
            iArr[i6] = (iId << 20) | (fieldInfo.isRequired() ? 268435456 : 0) | i4 | i2;
            iArr[i + 2] = (iNumberOfTrailingZeros << 20) | i3;
            messageFieldClass = fieldInfo.getMessageFieldClass();
            if (fieldInfo.getMapDefaultEntry() != null) {
                if (messageFieldClass != null) {
                    objArr[((i / 3) * 2) + 1] = messageFieldClass;
                    return;
                } else {
                    if (fieldInfo.getEnumVerifier() != null) {
                        objArr[((i / 3) * 2) + 1] = fieldInfo.getEnumVerifier();
                        return;
                    }
                    return;
                }
            }
            i5 = (i / 3) * 2;
            objArr[i5] = fieldInfo.getMapDefaultEntry();
            if (messageFieldClass != null) {
                objArr[i5 + 1] = messageFieldClass;
            } else if (fieldInfo.getEnumVerifier() != null) {
                objArr[i5 + 1] = fieldInfo.getEnumVerifier();
            }
        }
        i2 = iObjectFieldOffset;
        i3 = iObjectFieldOffset2;
        iNumberOfTrailingZeros = 0;
        iArr[i] = fieldInfo.getFieldNumber();
        int i7 = i + 1;
        if (fieldInfo.isEnforceUtf8()) {
            i4 = 536870912;
        } else {
            i4 = 0;
        }
        iArr[i7] = (iId << 20) | (fieldInfo.isRequired() ? 268435456 : 0) | i4 | i2;
        iArr[i + 2] = (iNumberOfTrailingZeros << 20) | i3;
        messageFieldClass = fieldInfo.getMessageFieldClass();
        if (fieldInfo.getMapDefaultEntry() != null) {
            if (messageFieldClass != null) {
                objArr[((i / 3) * 2) + 1] = messageFieldClass;
                return;
            } else {
                if (fieldInfo.getEnumVerifier() != null) {
                    objArr[((i / 3) * 2) + 1] = fieldInfo.getEnumVerifier();
                    return;
                }
                return;
            }
        }
        i5 = (i / 3) * 2;
        objArr[i5] = fieldInfo.getMapDefaultEntry();
        if (messageFieldClass != null) {
            objArr[i5 + 1] = messageFieldClass;
        } else if (fieldInfo.getEnumVerifier() != null) {
            objArr[i5 + 1] = fieldInfo.getEnumVerifier();
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public boolean equals(T t, T t2) {
        int length = this.buffer.length;
        for (int i = 0; i < length; i += 3) {
            if (!equals(t, t2, i)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(t).equals(this.unknownFieldSchema.getFromMessage(t2))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t).equals(this.extensionSchema.getExtensions(t2));
        }
        return true;
    }

    private boolean equals(T t, T t2, int i) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        long jOffset = offset(iTypeAndOffsetAt);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                return arePresentForEquals(t, t2, i) && Double.doubleToLongBits(UnsafeUtil.getDouble(t, jOffset)) == Double.doubleToLongBits(UnsafeUtil.getDouble(t2, jOffset));
            case 1:
                return arePresentForEquals(t, t2, i) && Float.floatToIntBits(UnsafeUtil.getFloat(t, jOffset)) == Float.floatToIntBits(UnsafeUtil.getFloat(t2, jOffset));
            case 2:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong(t, jOffset) == UnsafeUtil.getLong(t2, jOffset);
            case 3:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong(t, jOffset) == UnsafeUtil.getLong(t2, jOffset);
            case 4:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, jOffset) == UnsafeUtil.getInt(t2, jOffset);
            case 5:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong(t, jOffset) == UnsafeUtil.getLong(t2, jOffset);
            case 6:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, jOffset) == UnsafeUtil.getInt(t2, jOffset);
            case 7:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getBoolean(t, jOffset) == UnsafeUtil.getBoolean(t2, jOffset);
            case 8:
                return arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset));
            case 9:
                return arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset));
            case 10:
                return arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset));
            case 11:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, jOffset) == UnsafeUtil.getInt(t2, jOffset);
            case 12:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, jOffset) == UnsafeUtil.getInt(t2, jOffset);
            case 13:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, jOffset) == UnsafeUtil.getInt(t2, jOffset);
            case 14:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong(t, jOffset) == UnsafeUtil.getLong(t2, jOffset);
            case 15:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, jOffset) == UnsafeUtil.getInt(t2, jOffset);
            case 16:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong(t, jOffset) == UnsafeUtil.getLong(t2, jOffset);
            case 17:
                return arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset));
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset));
            case 50:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset));
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                return isOneofCaseEqual(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset));
            default:
                return true;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public int hashCode(T t) {
        int i;
        int iHashLong;
        int length = this.buffer.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i3);
            int iNumberAt = numberAt(i3);
            long jOffset = offset(iTypeAndOffsetAt);
            int iHashCode = 37;
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(t, jOffset)));
                    i2 = i + iHashLong;
                    break;
                case 1:
                    i = i2 * 53;
                    iHashLong = Float.floatToIntBits(UnsafeUtil.getFloat(t, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 2:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 3:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 4:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(t, jOffset);
                    i2 = i + iHashLong;
                    break;
                case 5:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 6:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(t, jOffset);
                    i2 = i + iHashLong;
                    break;
                case 7:
                    i = i2 * 53;
                    iHashLong = Internal.hashBoolean(UnsafeUtil.getBoolean(t, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 8:
                    i = i2 * 53;
                    iHashLong = ((String) UnsafeUtil.getObject(t, jOffset)).hashCode();
                    i2 = i + iHashLong;
                    break;
                case 9:
                    Object object = UnsafeUtil.getObject(t, jOffset);
                    if (object != null) {
                        iHashCode = object.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                    i2 = i + iHashLong;
                    break;
                case 11:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(t, jOffset);
                    i2 = i + iHashLong;
                    break;
                case 12:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(t, jOffset);
                    i2 = i + iHashLong;
                    break;
                case 13:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(t, jOffset);
                    i2 = i + iHashLong;
                    break;
                case 14:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 15:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(t, jOffset);
                    i2 = i + iHashLong;
                    break;
                case 16:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 17:
                    Object object2 = UnsafeUtil.getObject(t, jOffset);
                    if (object2 != null) {
                        iHashCode = object2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                    i2 = i + iHashLong;
                    break;
                case 50:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                    i2 = i + iHashLong;
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(t, jOffset)));
                        i2 = i + iHashLong;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Float.floatToIntBits(oneofFloatAt(t, jOffset));
                        i2 = i + iHashLong;
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i2 = i + iHashLong;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i2 = i + iHashLong;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(t, jOffset);
                        i2 = i + iHashLong;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i2 = i + iHashLong;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(t, jOffset);
                        i2 = i + iHashLong;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashBoolean(oneofBooleanAt(t, jOffset));
                        i2 = i + iHashLong;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = ((String) UnsafeUtil.getObject(t, jOffset)).hashCode();
                        i2 = i + iHashLong;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                        i2 = i + iHashLong;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                        i2 = i + iHashLong;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(t, jOffset);
                        i2 = i + iHashLong;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(t, jOffset);
                        i2 = i + iHashLong;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(t, jOffset);
                        i2 = i + iHashLong;
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i2 = i + iHashLong;
                    }
                    break;
                case 66:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(t, jOffset);
                        i2 = i + iHashLong;
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i2 = i + iHashLong;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                        i2 = i + iHashLong;
                    }
                    break;
            }
        }
        int iHashCode2 = (i2 * 53) + this.unknownFieldSchema.getFromMessage(t).hashCode();
        return this.hasExtensions ? (iHashCode2 * 53) + this.extensionSchema.getExtensions(t).hashCode() : iHashCode2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void mergeFrom(T t, T t2) {
        t2.getClass();
        for (int i = 0; i < this.buffer.length; i += 3) {
            mergeSingleField(t, t2, i);
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t, t2);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t, t2);
        }
    }

    private void mergeSingleField(T t, T t2, int i) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        long jOffset = offset(iTypeAndOffsetAt);
        int iNumberAt = numberAt(i);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putDouble(t, jOffset, UnsafeUtil.getDouble(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 1:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putFloat(t, jOffset, UnsafeUtil.getFloat(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 2:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 3:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 4:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 5:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 6:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 7:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putBoolean(t, jOffset, UnsafeUtil.getBoolean(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 8:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 9:
                mergeMessage(t, t2, i);
                break;
            case 10:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 11:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 12:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 13:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 14:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 15:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 16:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 17:
                mergeMessage(t, t2, i);
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.listFieldSchema.mergeListsAt(t, t2, jOffset);
                break;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, t, t2, jOffset);
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(t2, iNumberAt, i)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setOneofPresent(t, iNumberAt, i);
                }
                break;
            case 60:
                mergeOneofMessage(t, t2, i);
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (isOneofPresent(t2, iNumberAt, i)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setOneofPresent(t, iNumberAt, i);
                }
                break;
            case 68:
                mergeOneofMessage(t, t2, i);
                break;
        }
    }

    private void mergeMessage(T t, T t2, int i) {
        long jOffset = offset(typeAndOffsetAt(i));
        if (isFieldPresent(t2, i)) {
            Object object = UnsafeUtil.getObject(t, jOffset);
            Object object2 = UnsafeUtil.getObject(t2, jOffset);
            if (object != null && object2 != null) {
                UnsafeUtil.putObject(t, jOffset, Internal.mergeMessage(object, object2));
                setFieldPresent(t, i);
            } else if (object2 != null) {
                UnsafeUtil.putObject(t, jOffset, object2);
                setFieldPresent(t, i);
            }
        }
    }

    private void mergeOneofMessage(T t, T t2, int i) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        int iNumberAt = numberAt(i);
        long jOffset = offset(iTypeAndOffsetAt);
        if (isOneofPresent(t2, iNumberAt, i)) {
            Object object = UnsafeUtil.getObject(t, jOffset);
            Object object2 = UnsafeUtil.getObject(t2, jOffset);
            if (object != null && object2 != null) {
                UnsafeUtil.putObject(t, jOffset, Internal.mergeMessage(object, object2));
                setOneofPresent(t, iNumberAt, i);
            } else if (object2 != null) {
                UnsafeUtil.putObject(t, jOffset, object2);
                setOneofPresent(t, iNumberAt, i);
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public int getSerializedSize(T t) {
        return this.proto3 ? getSerializedSizeProto3(t) : getSerializedSizeProto2(t);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:186:0x0425 A[PHI: r6
      0x0425: PHI (r6v4 int) = 
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v8 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v9 int)
      (r6v1 int)
     binds: [B:21:0x0062, B:225:0x04cc, B:222:0x04c1, B:216:0x04a5, B:213:0x0494, B:210:0x0485, B:207:0x0478, B:204:0x046b, B:200:0x0460, B:197:0x0457, B:194:0x044a, B:191:0x043d, B:188:0x042a, B:161:0x0337, B:155:0x031a, B:149:0x02fd, B:143:0x02e0, B:137:0x02c2, B:131:0x02a4, B:125:0x0286, B:119:0x0268, B:113:0x024a, B:107:0x022c, B:101:0x020e, B:95:0x01f0, B:89:0x01d2, B:83:0x01b4, B:78:0x0180, B:75:0x0174, B:72:0x0164, B:69:0x0154, B:66:0x0144, B:63:0x0138, B:60:0x012b, B:57:0x011e, B:51:0x0100, B:48:0x00ec, B:45:0x00da, B:42:0x00ca, B:39:0x00ba, B:202:0x0467, B:36:0x00ad, B:33:0x00a1, B:30:0x0091, B:27:0x0081, B:185:0x0424, B:24:0x006b] A[DONT_GENERATE, DONT_INLINE]] */
    private int getSerializedSizeProto2(T t) {
        int i;
        int i2;
        int iComputeDoubleSize;
        int iComputeBoolSize;
        int iComputeSFixed32Size;
        boolean z;
        int iComputeSizeFixed32List;
        int iComputeSizeFixed64ListNoTag;
        int iComputeTagSize;
        int iComputeUInt32SizeNoTag;
        Unsafe unsafe = UNSAFE;
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < this.buffer.length) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i4);
            int iNumberAt = numberAt(i4);
            int iType = type(iTypeAndOffsetAt);
            if (iType <= 17) {
                i = this.buffer[i4 + 2];
                int i7 = OFFSET_MASK & i;
                int i8 = 1 << (i >>> 20);
                if (i7 != i3) {
                    i6 = unsafe.getInt(t, i7);
                    i3 = i7;
                }
                i2 = i8;
            } else {
                i = (!this.useCachedSizeField || iType < FieldType.DOUBLE_LIST_PACKED.id() || iType > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.buffer[i4 + 2] & OFFSET_MASK;
                i2 = 0;
            }
            long jOffset = offset(iTypeAndOffsetAt);
            int i9 = i3;
            switch (iType) {
                case 0:
                    if ((i6 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i5 += iComputeDoubleSize;
                    }
                    break;
                case 1:
                    if ((i6 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i5 += iComputeDoubleSize;
                    }
                    break;
                case 2:
                    if ((i6 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, unsafe.getLong(t, jOffset));
                        i5 += iComputeDoubleSize;
                    }
                    break;
                case 3:
                    if ((i6 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, unsafe.getLong(t, jOffset));
                        i5 += iComputeDoubleSize;
                    }
                    break;
                case 4:
                    if ((i6 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, unsafe.getInt(t, jOffset));
                        i5 += iComputeDoubleSize;
                    }
                    break;
                case 5:
                    if ((i6 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i5 += iComputeDoubleSize;
                    }
                    break;
                case 6:
                    if ((i6 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i5 += iComputeDoubleSize;
                    }
                    break;
                case 7:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 8:
                    if ((i6 & i2) != 0) {
                        Object object = unsafe.getObject(t, jOffset);
                        if (object instanceof ByteString) {
                            iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object);
                        } else {
                            iComputeBoolSize = CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        }
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 9:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i4));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 10:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 11:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, unsafe.getInt(t, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 12:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, unsafe.getInt(t, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 13:
                    if ((i6 & i2) != 0) {
                        iComputeSFixed32Size = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 14:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 15:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, unsafe.getInt(t, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 16:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, unsafe.getLong(t, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 17:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t, jOffset), getMessageFieldSchema(i4));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 18:
                    iComputeBoolSize = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 19:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeSizeFixed32List;
                    break;
                case 20:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeInt64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeSizeFixed32List;
                    break;
                case 21:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeUInt64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeSizeFixed32List;
                    break;
                case 22:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeInt32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeSizeFixed32List;
                    break;
                case 23:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeSizeFixed32List;
                    break;
                case 24:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeSizeFixed32List;
                    break;
                case 25:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeBoolList(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeSizeFixed32List;
                    break;
                case 26:
                    iComputeBoolSize = SchemaUtil.computeSizeStringList(iNumberAt, (List) unsafe.getObject(t, jOffset));
                    i5 += iComputeBoolSize;
                    break;
                case 27:
                    iComputeBoolSize = SchemaUtil.computeSizeMessageList(iNumberAt, (List) unsafe.getObject(t, jOffset), getMessageFieldSchema(i4));
                    i5 += iComputeBoolSize;
                    break;
                case 28:
                    iComputeBoolSize = SchemaUtil.computeSizeByteStringList(iNumberAt, (List) unsafe.getObject(t, jOffset));
                    i5 += iComputeBoolSize;
                    break;
                case 29:
                    iComputeBoolSize = SchemaUtil.computeSizeUInt32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 30:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeEnumList(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeSizeFixed32List;
                    break;
                case 31:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeSizeFixed32List;
                    break;
                case 32:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeSizeFixed32List;
                    break;
                case 33:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeSInt32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeSizeFixed32List;
                    break;
                case 34:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeSInt64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeSizeFixed32List;
                    break;
                case 35:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 36:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 37:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 38:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 39:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 40:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 41:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 42:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 43:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 44:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 45:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 46:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 47:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 48:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 49:
                    iComputeBoolSize = SchemaUtil.computeSizeGroupList(iNumberAt, (List) unsafe.getObject(t, jOffset), getMessageFieldSchema(i4));
                    i5 += iComputeBoolSize;
                    break;
                case 50:
                    iComputeBoolSize = this.mapFieldSchema.getSerializedSize(iNumberAt, unsafe.getObject(t, jOffset), getMapFieldDefaultEntry(i4));
                    i5 += iComputeBoolSize;
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeSFixed32Size = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        Object object2 = unsafe.getObject(t, jOffset);
                        if (object2 instanceof ByteString) {
                            iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2);
                        } else {
                            iComputeBoolSize = CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        }
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i4));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeSFixed32Size = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 66:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t, jOffset), getMessageFieldSchema(i4));
                        i5 += iComputeBoolSize;
                    }
                    break;
                default:
                    break;
            }
            i4 += 3;
            i3 = i9;
        }
        int unknownFieldsSerializedSize = i5 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(t).getSerializedSize() : unknownFieldsSerializedSize;
    }

    private int getSerializedSizeProto3(T t) {
        int iComputeDoubleSize;
        int iComputeSizeFixed64ListNoTag;
        int iComputeTagSize;
        int iComputeUInt32SizeNoTag;
        Unsafe unsafe = UNSAFE;
        int i = 0;
        for (int i2 = 0; i2 < this.buffer.length; i2 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i2);
            int iType = type(iTypeAndOffsetAt);
            int iNumberAt = numberAt(i2);
            long jOffset = offset(iTypeAndOffsetAt);
            int i3 = (iType < FieldType.DOUBLE_LIST_PACKED.id() || iType > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.buffer[i2 + 2] & OFFSET_MASK;
            switch (iType) {
                case 0:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 1:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 2:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, UnsafeUtil.getLong(t, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 3:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, UnsafeUtil.getLong(t, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 4:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, UnsafeUtil.getInt(t, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 5:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 6:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 7:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 8:
                    if (isFieldPresent(t, i2)) {
                        Object object = UnsafeUtil.getObject(t, jOffset);
                        if (object instanceof ByteString) {
                            iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object);
                        } else {
                            iComputeDoubleSize = CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        }
                        i += iComputeDoubleSize;
                    }
                    break;
                case 9:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = SchemaUtil.computeSizeMessage(iNumberAt, UnsafeUtil.getObject(t, jOffset), getMessageFieldSchema(i2));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 10:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) UnsafeUtil.getObject(t, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 11:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(iNumberAt, UnsafeUtil.getInt(t, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 12:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(iNumberAt, UnsafeUtil.getInt(t, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 13:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 14:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 15:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(iNumberAt, UnsafeUtil.getInt(t, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 16:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(iNumberAt, UnsafeUtil.getLong(t, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 17:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) UnsafeUtil.getObject(t, jOffset), getMessageFieldSchema(i2));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 18:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 19:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 20:
                    iComputeDoubleSize = SchemaUtil.computeSizeInt64List(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 21:
                    iComputeDoubleSize = SchemaUtil.computeSizeUInt64List(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 22:
                    iComputeDoubleSize = SchemaUtil.computeSizeInt32List(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 23:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 24:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 25:
                    iComputeDoubleSize = SchemaUtil.computeSizeBoolList(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 26:
                    iComputeDoubleSize = SchemaUtil.computeSizeStringList(iNumberAt, listAt(t, jOffset));
                    i += iComputeDoubleSize;
                    break;
                case 27:
                    iComputeDoubleSize = SchemaUtil.computeSizeMessageList(iNumberAt, listAt(t, jOffset), getMessageFieldSchema(i2));
                    i += iComputeDoubleSize;
                    break;
                case 28:
                    iComputeDoubleSize = SchemaUtil.computeSizeByteStringList(iNumberAt, listAt(t, jOffset));
                    i += iComputeDoubleSize;
                    break;
                case 29:
                    iComputeDoubleSize = SchemaUtil.computeSizeUInt32List(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 30:
                    iComputeDoubleSize = SchemaUtil.computeSizeEnumList(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 31:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 32:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 33:
                    iComputeDoubleSize = SchemaUtil.computeSizeSInt32List(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 34:
                    iComputeDoubleSize = SchemaUtil.computeSizeSInt64List(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 35:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 36:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 37:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 38:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 39:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 40:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 41:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 42:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 43:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 44:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 45:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 46:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 47:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 48:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 49:
                    iComputeDoubleSize = SchemaUtil.computeSizeGroupList(iNumberAt, listAt(t, jOffset), getMessageFieldSchema(i2));
                    i += iComputeDoubleSize;
                    break;
                case 50:
                    iComputeDoubleSize = this.mapFieldSchema.getSerializedSize(iNumberAt, UnsafeUtil.getObject(t, jOffset), getMapFieldDefaultEntry(i2));
                    i += iComputeDoubleSize;
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        Object object2 = UnsafeUtil.getObject(t, jOffset);
                        if (object2 instanceof ByteString) {
                            iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2);
                        } else {
                            iComputeDoubleSize = CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        }
                        i += iComputeDoubleSize;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = SchemaUtil.computeSizeMessage(iNumberAt, UnsafeUtil.getObject(t, jOffset), getMessageFieldSchema(i2));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) UnsafeUtil.getObject(t, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 66:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) UnsafeUtil.getObject(t, jOffset), getMessageFieldSchema(i2));
                        i += iComputeDoubleSize;
                    }
                    break;
            }
        }
        return i + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t);
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t) {
        return unknownFieldSchema.getSerializedSize(unknownFieldSchema.getFromMessage(t));
    }

    private static List<?> listAt(Object obj, long j) {
        return (List) UnsafeUtil.getObject(obj, j);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void writeTo(T t, Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t, writer);
        } else if (this.proto3) {
            writeFieldsInAscendingOrderProto3(t, writer);
        } else {
            writeFieldsInAscendingOrderProto2(t, writer);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    private void writeFieldsInAscendingOrderProto2(T t, Writer writer) throws IOException {
        Iterator it;
        Map.Entry<?, ?> entry;
        boolean z;
        int i;
        boolean z2;
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(t);
            if (extensions.isEmpty()) {
                it = null;
                entry = null;
            } else {
                it = extensions.iterator();
                entry = (Map.Entry) it.next();
            }
        } else {
            it = null;
            entry = null;
        }
        int length = this.buffer.length;
        Unsafe unsafe = UNSAFE;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i3);
            int iNumberAt = numberAt(i3);
            int iType = type(iTypeAndOffsetAt);
            if (this.proto3 || iType > 17) {
                z = true;
                entry = entry;
                i = 0;
            } else {
                int i5 = this.buffer[i3 + 2];
                int i6 = i5 & OFFSET_MASK;
                Map.Entry<?, ?> entry2 = entry;
                z = true;
                if (i6 != i2) {
                    i4 = unsafe.getInt(t, i6);
                    i2 = i6;
                }
                i = 1 << (i5 >>> 20);
                entry = entry2;
            }
            while (entry != null && this.extensionSchema.extensionNumber(entry) <= iNumberAt) {
                this.extensionSchema.serializeExtension(writer, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            Iterator it2 = it;
            int i7 = i;
            long jOffset = offset(iTypeAndOffsetAt);
            switch (iType) {
                case 0:
                    if ((i4 & i7) != 0) {
                        writer.writeDouble(iNumberAt, doubleAt(t, jOffset));
                    }
                    break;
                case 1:
                    if ((i4 & i7) != 0) {
                        writer.writeFloat(iNumberAt, floatAt(t, jOffset));
                    }
                    break;
                case 2:
                    if ((i4 & i7) != 0) {
                        writer.writeInt64(iNumberAt, unsafe.getLong(t, jOffset));
                    }
                    break;
                case 3:
                    if ((i4 & i7) != 0) {
                        writer.writeUInt64(iNumberAt, unsafe.getLong(t, jOffset));
                    }
                    break;
                case 4:
                    if ((i4 & i7) != 0) {
                        writer.writeInt32(iNumberAt, unsafe.getInt(t, jOffset));
                    }
                    break;
                case 5:
                    if ((i4 & i7) != 0) {
                        writer.writeFixed64(iNumberAt, unsafe.getLong(t, jOffset));
                    }
                    break;
                case 6:
                    if ((i4 & i7) != 0) {
                        writer.writeFixed32(iNumberAt, unsafe.getInt(t, jOffset));
                    }
                    break;
                case 7:
                    if ((i4 & i7) != 0) {
                        writer.writeBool(iNumberAt, booleanAt(t, jOffset));
                    }
                    break;
                case 8:
                    if ((i4 & i7) != 0) {
                        writeString(iNumberAt, unsafe.getObject(t, jOffset), writer);
                    }
                    break;
                case 9:
                    if ((i4 & i7) != 0) {
                        writer.writeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i3));
                    }
                    break;
                case 10:
                    if ((i4 & i7) != 0) {
                        writer.writeBytes(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                    }
                    break;
                case 11:
                    if ((i4 & i7) != 0) {
                        writer.writeUInt32(iNumberAt, unsafe.getInt(t, jOffset));
                    }
                    break;
                case 12:
                    if ((i4 & i7) != 0) {
                        writer.writeEnum(iNumberAt, unsafe.getInt(t, jOffset));
                    }
                    break;
                case 13:
                    if ((i4 & i7) != 0) {
                        writer.writeSFixed32(iNumberAt, unsafe.getInt(t, jOffset));
                    }
                    break;
                case 14:
                    if ((i4 & i7) != 0) {
                        writer.writeSFixed64(iNumberAt, unsafe.getLong(t, jOffset));
                    }
                    break;
                case 15:
                    if ((i4 & i7) != 0) {
                        writer.writeSInt32(iNumberAt, unsafe.getInt(t, jOffset));
                    }
                    break;
                case 16:
                    if ((i4 & i7) != 0) {
                        writer.writeSInt64(iNumberAt, unsafe.getLong(t, jOffset));
                    }
                    break;
                case 17:
                    if ((i4 & i7) != 0) {
                        writer.writeGroup(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i3));
                    }
                    break;
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, getMessageFieldSchema(i3));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer);
                    break;
                case 29:
                    z2 = false;
                    SchemaUtil.writeUInt32List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 30:
                    z2 = false;
                    SchemaUtil.writeEnumList(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 31:
                    z2 = false;
                    SchemaUtil.writeSFixed32List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 32:
                    z2 = false;
                    SchemaUtil.writeSFixed64List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 33:
                    z2 = false;
                    SchemaUtil.writeSInt32List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 34:
                    z2 = false;
                    SchemaUtil.writeSInt64List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 37:
                    SchemaUtil.writeInt64List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 39:
                    SchemaUtil.writeInt32List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 44:
                    SchemaUtil.writeEnumList(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 49:
                    SchemaUtil.writeGroupList(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, getMessageFieldSchema(i3));
                    break;
                case 50:
                    writeMapHelper(writer, iNumberAt, unsafe.getObject(t, jOffset), i3);
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeDouble(iNumberAt, oneofDoubleAt(t, jOffset));
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeFloat(iNumberAt, oneofFloatAt(t, jOffset));
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeInt64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeUInt64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeInt32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeFixed64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeFixed32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeBool(iNumberAt, oneofBooleanAt(t, jOffset));
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writeString(iNumberAt, unsafe.getObject(t, jOffset), writer);
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i3));
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeBytes(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeUInt32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeEnum(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeSFixed32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeSFixed64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    break;
                case 66:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeSInt32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeSInt64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeGroup(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i3));
                    }
                    break;
                default:
                    break;
            }
            i3 += 3;
            it = it2;
        }
        Iterator it3 = it;
        while (entry != null) {
            this.extensionSchema.serializeExtension(writer, entry);
            entry = it3.hasNext() ? (Map.Entry) it3.next() : null;
        }
        writeUnknownInMessageTo(this.unknownFieldSchema, t, writer);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    private void writeFieldsInAscendingOrderProto3(T t, Writer writer) throws IOException {
        Iterator it;
        Map.Entry<?, ?> entry;
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(t);
            if (extensions.isEmpty()) {
                it = null;
                entry = null;
            } else {
                it = extensions.iterator();
                entry = (Map.Entry) it.next();
            }
        } else {
            it = null;
            entry = null;
        }
        int length = this.buffer.length;
        for (int i = 0; i < length; i += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i);
            int iNumberAt = numberAt(i);
            while (entry != null && this.extensionSchema.extensionNumber(entry) <= iNumberAt) {
                this.extensionSchema.serializeExtension(writer, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    if (isFieldPresent(t, i)) {
                        writer.writeDouble(iNumberAt, doubleAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 1:
                    if (isFieldPresent(t, i)) {
                        writer.writeFloat(iNumberAt, floatAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 2:
                    if (isFieldPresent(t, i)) {
                        writer.writeInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 3:
                    if (isFieldPresent(t, i)) {
                        writer.writeUInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 4:
                    if (isFieldPresent(t, i)) {
                        writer.writeInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 5:
                    if (isFieldPresent(t, i)) {
                        writer.writeFixed64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 6:
                    if (isFieldPresent(t, i)) {
                        writer.writeFixed32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 7:
                    if (isFieldPresent(t, i)) {
                        writer.writeBool(iNumberAt, booleanAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 8:
                    if (isFieldPresent(t, i)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    }
                    break;
                case 9:
                    if (isFieldPresent(t, i)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(i));
                    }
                    break;
                case 10:
                    if (isFieldPresent(t, i)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 11:
                    if (isFieldPresent(t, i)) {
                        writer.writeUInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 12:
                    if (isFieldPresent(t, i)) {
                        writer.writeEnum(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 13:
                    if (isFieldPresent(t, i)) {
                        writer.writeSFixed32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 14:
                    if (isFieldPresent(t, i)) {
                        writer.writeSFixed64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 15:
                    if (isFieldPresent(t, i)) {
                        writer.writeSInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 16:
                    if (isFieldPresent(t, i)) {
                        writer.writeSInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 17:
                    if (isFieldPresent(t, i)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(i));
                    }
                    break;
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(i));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 29:
                    SchemaUtil.writeUInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 30:
                    SchemaUtil.writeEnumList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 31:
                    SchemaUtil.writeSFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 32:
                    SchemaUtil.writeSFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 33:
                    SchemaUtil.writeSInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 34:
                    SchemaUtil.writeSInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 37:
                    SchemaUtil.writeInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 39:
                    SchemaUtil.writeInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 44:
                    SchemaUtil.writeEnumList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 49:
                    SchemaUtil.writeGroupList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(i));
                    break;
                case 50:
                    writeMapHelper(writer, iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), i);
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeDouble(iNumberAt, oneofDoubleAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeFloat(iNumberAt, oneofFloatAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeUInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeFixed64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeFixed32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeBool(iNumberAt, oneofBooleanAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(i));
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeUInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeEnum(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeSFixed32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeSFixed64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 66:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeSInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeSInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(i));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.extensionSchema.serializeExtension(writer, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        writeUnknownInMessageTo(this.unknownFieldSchema, t, writer);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    private void writeFieldsInDescendingOrder(T t, Writer writer) throws IOException {
        Iterator itDescendingIterator;
        Map.Entry<?, ?> entry;
        writeUnknownInMessageTo(this.unknownFieldSchema, t, writer);
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(t);
            if (extensions.isEmpty()) {
                itDescendingIterator = null;
                entry = null;
            } else {
                itDescendingIterator = extensions.descendingIterator();
                entry = (Map.Entry) itDescendingIterator.next();
            }
        } else {
            itDescendingIterator = null;
            entry = null;
        }
        for (int length = this.buffer.length - 3; length >= 0; length -= 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(length);
            int iNumberAt = numberAt(length);
            while (entry != null && this.extensionSchema.extensionNumber(entry) > iNumberAt) {
                this.extensionSchema.serializeExtension(writer, entry);
                entry = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
            }
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    if (isFieldPresent(t, length)) {
                        writer.writeDouble(iNumberAt, doubleAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 1:
                    if (isFieldPresent(t, length)) {
                        writer.writeFloat(iNumberAt, floatAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 2:
                    if (isFieldPresent(t, length)) {
                        writer.writeInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 3:
                    if (isFieldPresent(t, length)) {
                        writer.writeUInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 4:
                    if (isFieldPresent(t, length)) {
                        writer.writeInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 5:
                    if (isFieldPresent(t, length)) {
                        writer.writeFixed64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 6:
                    if (isFieldPresent(t, length)) {
                        writer.writeFixed32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 7:
                    if (isFieldPresent(t, length)) {
                        writer.writeBool(iNumberAt, booleanAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 8:
                    if (isFieldPresent(t, length)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    }
                    break;
                case 9:
                    if (isFieldPresent(t, length)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case 10:
                    if (isFieldPresent(t, length)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 11:
                    if (isFieldPresent(t, length)) {
                        writer.writeUInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 12:
                    if (isFieldPresent(t, length)) {
                        writer.writeEnum(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 13:
                    if (isFieldPresent(t, length)) {
                        writer.writeSFixed32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 14:
                    if (isFieldPresent(t, length)) {
                        writer.writeSFixed64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 15:
                    if (isFieldPresent(t, length)) {
                        writer.writeSInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 16:
                    if (isFieldPresent(t, length)) {
                        writer.writeSInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 17:
                    if (isFieldPresent(t, length)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(length));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 29:
                    SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 30:
                    SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 31:
                    SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 32:
                    SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 33:
                    SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 34:
                    SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 37:
                    SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 39:
                    SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 44:
                    SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 49:
                    SchemaUtil.writeGroupList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(length));
                    break;
                case 50:
                    writeMapHelper(writer, iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), length);
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeDouble(iNumberAt, oneofDoubleAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeFloat(iNumberAt, oneofFloatAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeUInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeFixed64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeFixed32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeBool(iNumberAt, oneofBooleanAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeUInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeEnum(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeSFixed32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeSFixed64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 66:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeSInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeSInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.extensionSchema.serializeExtension(writer, entry);
            entry = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
        }
    }

    private <K, V> void writeMapHelper(Writer writer, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            writer.writeMap(i, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t, Writer writer) throws IOException {
        unknownFieldSchema.writeTo(unknownFieldSchema.getFromMessage(t), writer);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void mergeFrom(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        extensionRegistryLite.getClass();
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t, reader, extensionRegistryLite);
    }

    /* JADX WARN: Code duplicated, block: B:175:0x05f2 A[LOOP:2: B:173:0x05ee->B:175:0x05f2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:179:0x0603 A[Catch: all -> 0x0624, TRY_ENTER, TryCatch #3 {all -> 0x0624, blocks: (B:19:0x0042, B:34:0x006f, B:159:0x05c4, B:168:0x05e0, B:170:0x05e6, B:179:0x0603, B:180:0x0608), top: B:209:0x0042 }] */
    /* JADX WARN: Code duplicated, block: B:185:0x0614 A[LOOP:1: B:183:0x0610->B:185:0x0614, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:198:0x0631 A[LOOP:3: B:196:0x062d->B:198:0x0631, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:200:0x063e  */
    /* JADX WARN: Code duplicated, block: B:307:0x0601 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:308:0x05ec A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:311:0x05e6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:312:0x060e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:318:0x0007 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:319:0x0007 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:335:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:336:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema, com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema<UT, UB>] */
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema, ExtensionSchema<ET> extensionSchema, T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        int i;
        ExtensionSchema<ET> extensionSchema2;
        Object objFindExtensionByNumber;
        Object obj;
        int i2;
        int i3;
        T t2 = t;
        ExtensionRegistryLite extensionRegistryLite2 = extensionRegistryLite;
        Object objFilterMapUnknownEnumValues = null;
        FieldSet mutableExtensions = null;
        while (true) {
            try {
                int fieldNumber = reader.getFieldNumber();
                int iPositionForFieldNumber = positionForFieldNumber(fieldNumber);
                if (iPositionForFieldNumber < 0) {
                    if (fieldNumber == Integer.MAX_VALUE) {
                        for (int i4 = this.checkInitializedCount; i4 < this.repeatedFieldOffsetStart; i4++) {
                            objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i4], objFilterMapUnknownEnumValues, unknownFieldSchema);
                        }
                        if (objFilterMapUnknownEnumValues == null) {
                            return;
                        }
                    } else {
                        if (this.hasExtensions) {
                            extensionSchema2 = extensionSchema;
                            objFindExtensionByNumber = extensionSchema2.findExtensionByNumber(extensionRegistryLite2, this.defaultInstance, fieldNumber);
                        } else {
                            extensionSchema2 = extensionSchema;
                            objFindExtensionByNumber = null;
                        }
                        if (objFindExtensionByNumber != null) {
                            if (mutableExtensions == null) {
                                try {
                                    mutableExtensions = extensionSchema.getMutableExtensions(t);
                                } catch (Throwable th) {
                                    th = th;
                                    for (i = this.checkInitializedCount; i < this.repeatedFieldOffsetStart; i++) {
                                        objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                    }
                                    if (objFilterMapUnknownEnumValues != null) {
                                        unknownFieldSchema.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                    }
                                    throw th;
                                }
                            }
                            FieldSet fieldSet = mutableExtensions;
                            objFilterMapUnknownEnumValues = extensionSchema2.parseExtension(reader, objFindExtensionByNumber, extensionRegistryLite2, fieldSet, objFilterMapUnknownEnumValues, unknownFieldSchema);
                            mutableExtensions = fieldSet;
                        } else {
                            obj = objFilterMapUnknownEnumValues;
                            try {
                                if (unknownFieldSchema.shouldDiscardUnknownFields(reader)) {
                                    if (!reader.skipField()) {
                                        objFilterMapUnknownEnumValues = obj;
                                    }
                                    objFilterMapUnknownEnumValues = obj;
                                } else {
                                    objFilterMapUnknownEnumValues = obj == null ? unknownFieldSchema.getBuilderFromMessage(t2) : obj;
                                    if (unknownFieldSchema.mergeOneFieldFrom(objFilterMapUnknownEnumValues, reader)) {
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                objFilterMapUnknownEnumValues = obj;
                                while (i < this.repeatedFieldOffsetStart) {
                                    objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                }
                                if (objFilterMapUnknownEnumValues != null) {
                                    unknownFieldSchema.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                }
                                throw th;
                            }
                        }
                    }
                    unknownFieldSchema.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                }
                Reader reader2 = reader;
                obj = objFilterMapUnknownEnumValues;
                int iTypeAndOffsetAt = typeAndOffsetAt(iPositionForFieldNumber);
                try {
                    switch (type(iTypeAndOffsetAt)) {
                        case 0:
                            UnsafeUtil.putDouble(t2, offset(iTypeAndOffsetAt), reader2.readDouble());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 1:
                            UnsafeUtil.putFloat(t2, offset(iTypeAndOffsetAt), reader2.readFloat());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 2:
                            UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader2.readInt64());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 3:
                            UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader2.readUInt64());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 4:
                            UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader2.readInt32());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 5:
                            UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader2.readFixed64());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 6:
                            UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader2.readFixed32());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 7:
                            UnsafeUtil.putBoolean(t2, offset(iTypeAndOffsetAt), reader2.readBool());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 8:
                            readString(t2, iTypeAndOffsetAt, reader2);
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 9:
                            if (isFieldPresent(t2, iPositionForFieldNumber)) {
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Internal.mergeMessage(UnsafeUtil.getObject(t2, offset(iTypeAndOffsetAt)), reader2.readMessageBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2)));
                            } else {
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader2.readMessageBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2));
                                setFieldPresent(t2, iPositionForFieldNumber);
                            }
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 10:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader2.readBytes());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 11:
                            UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader2.readUInt32());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 12:
                            int i5 = reader2.readEnum();
                            Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(iPositionForFieldNumber);
                            if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i5)) {
                                UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), i5);
                                setFieldPresent(t2, iPositionForFieldNumber);
                                objFilterMapUnknownEnumValues = obj;
                            } else {
                                objFilterMapUnknownEnumValues = SchemaUtil.storeUnknownEnum(fieldNumber, i5, obj, unknownFieldSchema);
                            }
                            break;
                        case 13:
                            UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader2.readSFixed32());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 14:
                            UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader2.readSFixed64());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 15:
                            UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader2.readSInt32());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 16:
                            UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader2.readSInt64());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 17:
                            if (isFieldPresent(t2, iPositionForFieldNumber)) {
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Internal.mergeMessage(UnsafeUtil.getObject(t2, offset(iTypeAndOffsetAt)), reader2.readGroupBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2)));
                            } else {
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader2.readGroupBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2));
                                setFieldPresent(t2, iPositionForFieldNumber);
                            }
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 18:
                            reader2.readDoubleList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 19:
                            reader2.readFloatList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 20:
                            reader2.readInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 21:
                            reader2.readUInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 22:
                            reader2.readInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 23:
                            reader2.readFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 24:
                            reader2.readFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 25:
                            reader2.readBoolList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 26:
                            readStringList(t2, iTypeAndOffsetAt, reader2);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 27:
                            T t3 = t2;
                            try {
                                readMessageList(t3, iTypeAndOffsetAt, reader2, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite);
                                t2 = t3;
                                extensionRegistryLite2 = extensionRegistryLite;
                                objFilterMapUnknownEnumValues = obj;
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                                t2 = t3;
                                extensionRegistryLite2 = extensionRegistryLite;
                                objFilterMapUnknownEnumValues = obj;
                                if (!unknownFieldSchema.shouldDiscardUnknownFields(reader2)) {
                                    if (objFilterMapUnknownEnumValues == null) {
                                        objFilterMapUnknownEnumValues = unknownFieldSchema.getBuilderFromMessage(t2);
                                    }
                                    if (!unknownFieldSchema.mergeOneFieldFrom(objFilterMapUnknownEnumValues, reader2)) {
                                        for (i3 = this.checkInitializedCount; i3 < this.repeatedFieldOffsetStart; i3++) {
                                            objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i3], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                        }
                                        if (objFilterMapUnknownEnumValues == null) {
                                            return;
                                        }
                                        unknownFieldSchema.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                    }
                                } else if (!reader2.skipField()) {
                                    for (i2 = this.checkInitializedCount; i2 < this.repeatedFieldOffsetStart; i2++) {
                                        objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i2], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                    }
                                    if (objFilterMapUnknownEnumValues == null) {
                                        return;
                                    }
                                    unknownFieldSchema.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                }
                            }
                            break;
                        case 28:
                            reader2.readBytesList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 29:
                            reader2.readUInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 30:
                            List<Integer> listMutableListAt = this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt));
                            reader2.readEnumList(listMutableListAt);
                            objFilterMapUnknownEnumValues = SchemaUtil.filterUnknownEnumList(fieldNumber, listMutableListAt, getEnumFieldVerifier(iPositionForFieldNumber), obj, (UnknownFieldSchema<UT, Object>) unknownFieldSchema);
                            extensionRegistryLite2 = extensionRegistryLite;
                            break;
                        case 31:
                            reader2.readSFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 32:
                            reader2.readSFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 33:
                            reader2.readSInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 34:
                            reader2.readSInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 35:
                            reader2.readDoubleList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 36:
                            reader2.readFloatList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 37:
                            reader2.readInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 38:
                            reader2.readUInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 39:
                            reader2.readInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 40:
                            reader2.readFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 41:
                            reader2.readFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 42:
                            reader2.readBoolList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 43:
                            reader2.readUInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 44:
                            List<Integer> listMutableListAt2 = this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt));
                            reader2.readEnumList(listMutableListAt2);
                            objFilterMapUnknownEnumValues = SchemaUtil.filterUnknownEnumList(fieldNumber, listMutableListAt2, getEnumFieldVerifier(iPositionForFieldNumber), obj, (UnknownFieldSchema<UT, Object>) unknownFieldSchema);
                            extensionRegistryLite2 = extensionRegistryLite;
                            break;
                        case 45:
                            reader2.readSFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 46:
                            reader2.readSFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 47:
                            reader2.readSInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 48:
                            try {
                                reader2.readSInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                extensionRegistryLite2 = extensionRegistryLite;
                                objFilterMapUnknownEnumValues = obj;
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused2) {
                                extensionRegistryLite2 = extensionRegistryLite;
                                objFilterMapUnknownEnumValues = obj;
                                if (!unknownFieldSchema.shouldDiscardUnknownFields(reader2)) {
                                    if (objFilterMapUnknownEnumValues == null) {
                                        objFilterMapUnknownEnumValues = unknownFieldSchema.getBuilderFromMessage(t2);
                                    }
                                    if (!unknownFieldSchema.mergeOneFieldFrom(objFilterMapUnknownEnumValues, reader2)) {
                                        while (i3 < this.repeatedFieldOffsetStart) {
                                            objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i3], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                        }
                                        if (objFilterMapUnknownEnumValues == null) {
                                            return;
                                        }
                                        unknownFieldSchema.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                    }
                                } else if (!reader2.skipField()) {
                                    while (i2 < this.repeatedFieldOffsetStart) {
                                        objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i2], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                    }
                                    if (objFilterMapUnknownEnumValues == null) {
                                        return;
                                    }
                                    unknownFieldSchema.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                }
                            }
                            break;
                        case 49:
                            try {
                                try {
                                    readGroupList(t, offset(iTypeAndOffsetAt), reader, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite);
                                    t2 = t;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    objFilterMapUnknownEnumValues = obj;
                                } catch (Throwable th3) {
                                    th = th3;
                                    t2 = t;
                                    objFilterMapUnknownEnumValues = obj;
                                    while (i < this.repeatedFieldOffsetStart) {
                                        objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                    }
                                    if (objFilterMapUnknownEnumValues != null) {
                                        unknownFieldSchema.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                    }
                                    throw th;
                                }
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused3) {
                                t2 = t;
                                reader2 = reader;
                                objFilterMapUnknownEnumValues = obj;
                                extensionRegistryLite2 = extensionRegistryLite;
                                if (!unknownFieldSchema.shouldDiscardUnknownFields(reader2)) {
                                    if (objFilterMapUnknownEnumValues == null) {
                                        objFilterMapUnknownEnumValues = unknownFieldSchema.getBuilderFromMessage(t2);
                                    }
                                    if (!unknownFieldSchema.mergeOneFieldFrom(objFilterMapUnknownEnumValues, reader2)) {
                                        while (i3 < this.repeatedFieldOffsetStart) {
                                            objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i3], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                        }
                                        if (objFilterMapUnknownEnumValues == null) {
                                            return;
                                        }
                                        unknownFieldSchema.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                    }
                                } else if (!reader2.skipField()) {
                                    while (i2 < this.repeatedFieldOffsetStart) {
                                        objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i2], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                    }
                                    if (objFilterMapUnknownEnumValues == null) {
                                        return;
                                    }
                                    unknownFieldSchema.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                }
                            }
                            break;
                        case 50:
                            try {
                                mergeMap(t2, iPositionForFieldNumber, getMapFieldDefaultEntry(iPositionForFieldNumber), extensionRegistryLite2, reader);
                                t2 = t;
                                extensionRegistryLite2 = extensionRegistryLite;
                                objFilterMapUnknownEnumValues = obj;
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused4) {
                                t2 = t;
                                reader2 = reader;
                                extensionRegistryLite2 = extensionRegistryLite;
                                objFilterMapUnknownEnumValues = obj;
                                if (!unknownFieldSchema.shouldDiscardUnknownFields(reader2)) {
                                    if (objFilterMapUnknownEnumValues == null) {
                                        objFilterMapUnknownEnumValues = unknownFieldSchema.getBuilderFromMessage(t2);
                                    }
                                    if (!unknownFieldSchema.mergeOneFieldFrom(objFilterMapUnknownEnumValues, reader2)) {
                                        while (i3 < this.repeatedFieldOffsetStart) {
                                            objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i3], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                        }
                                        if (objFilterMapUnknownEnumValues == null) {
                                            return;
                                        }
                                        unknownFieldSchema.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                    }
                                } else if (!reader2.skipField()) {
                                    while (i2 < this.repeatedFieldOffsetStart) {
                                        objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i2], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                    }
                                    if (objFilterMapUnknownEnumValues == null) {
                                        return;
                                    }
                                    unknownFieldSchema.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                t2 = t;
                                objFilterMapUnknownEnumValues = obj;
                                while (i < this.repeatedFieldOffsetStart) {
                                    objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                }
                                if (objFilterMapUnknownEnumValues != null) {
                                    unknownFieldSchema.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                }
                                throw th;
                            }
                            break;
                        case 51:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Double.valueOf(reader2.readDouble()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 52:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Float.valueOf(reader2.readFloat()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 53:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader2.readInt64()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 54:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader2.readUInt64()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 55:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader2.readInt32()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 56:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader2.readFixed64()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 57:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader2.readFixed32()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 58:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Boolean.valueOf(reader2.readBool()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 59:
                            readString(t2, iTypeAndOffsetAt, reader2);
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 60:
                            if (isOneofPresent(t2, fieldNumber, iPositionForFieldNumber)) {
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Internal.mergeMessage(UnsafeUtil.getObject(t2, offset(iTypeAndOffsetAt)), reader2.readMessageBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2)));
                            } else {
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader2.readMessageBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2));
                                setFieldPresent(t2, iPositionForFieldNumber);
                            }
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 61:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader2.readBytes());
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 62:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader2.readUInt32()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 63:
                            int i6 = reader2.readEnum();
                            Internal.EnumVerifier enumFieldVerifier2 = getEnumFieldVerifier(iPositionForFieldNumber);
                            if (enumFieldVerifier2 == null || enumFieldVerifier2.isInRange(i6)) {
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(i6));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                objFilterMapUnknownEnumValues = obj;
                            } else {
                                objFilterMapUnknownEnumValues = SchemaUtil.storeUnknownEnum(fieldNumber, i6, obj, unknownFieldSchema);
                            }
                            break;
                        case 64:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader2.readSFixed32()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 65:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader2.readSFixed64()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 66:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader2.readSInt32()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 67:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader2.readSInt64()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 68:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader2.readGroupBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        default:
                            objFilterMapUnknownEnumValues = obj == null ? unknownFieldSchema.newBuilder() : obj;
                            try {
                                if (!unknownFieldSchema.mergeOneFieldFrom(objFilterMapUnknownEnumValues, reader2)) {
                                    for (int i7 = this.checkInitializedCount; i7 < this.repeatedFieldOffsetStart; i7++) {
                                        objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i7], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                    }
                                    if (objFilterMapUnknownEnumValues == null) {
                                        return;
                                    }
                                    unknownFieldSchema.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                }
                                break;
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused5) {
                                if (!unknownFieldSchema.shouldDiscardUnknownFields(reader2)) {
                                    if (objFilterMapUnknownEnumValues == null) {
                                        objFilterMapUnknownEnumValues = unknownFieldSchema.getBuilderFromMessage(t2);
                                    }
                                    if (!unknownFieldSchema.mergeOneFieldFrom(objFilterMapUnknownEnumValues, reader2)) {
                                        while (i3 < this.repeatedFieldOffsetStart) {
                                            objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i3], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                        }
                                        if (objFilterMapUnknownEnumValues == null) {
                                            return;
                                        }
                                        unknownFieldSchema.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                    }
                                } else if (!reader2.skipField()) {
                                    while (i2 < this.repeatedFieldOffsetStart) {
                                        objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i2], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                    }
                                    if (objFilterMapUnknownEnumValues == null) {
                                        return;
                                    }
                                    unknownFieldSchema.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                }
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException.InvalidWireTypeException unused6) {
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
        for (int i8 = this.checkInitializedCount; i8 < this.repeatedFieldOffsetStart; i8++) {
            objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i8], objFilterMapUnknownEnumValues, unknownFieldSchema);
        }
        if (objFilterMapUnknownEnumValues == null) {
            return;
        }
        unknownFieldSchema.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
    }

    static UnknownFieldSetLite getMutableUnknownFields(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite unknownFieldSetLiteNewInstance = UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = unknownFieldSetLiteNewInstance;
        return unknownFieldSetLiteNewInstance;
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.MessageSchema$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private int decodeMapEntryValue(byte[] bArr, int i, int i2, WireFormat.FieldType fieldType, Class<?> cls, ArrayDecoders.Registers registers) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Boolean.valueOf(registers.long1 != 0);
                return iDecodeVarint64;
            case 2:
                return ArrayDecoders.decodeBytes(bArr, i, registers);
            case 3:
                registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(bArr, i));
                return i + 8;
            case 4:
            case 5:
                registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i));
                return i + 4;
            case 6:
            case 7:
                registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i));
                return i + 8;
            case 8:
                registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(registers.int1);
                return iDecodeVarint32;
            case 12:
            case 13:
                int iDecodeVarint65 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(registers.long1);
                return iDecodeVarint65;
            case 14:
                return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor((Class) cls), bArr, i, i2, registers);
            case 15:
                int iDecodeVarint33 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                return iDecodeVarint33;
            case 16:
                int iDecodeVarint66 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                return iDecodeVarint66;
            case 17:
                return ArrayDecoders.decodeStringRequireUtf8(bArr, i, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> int decodeMapEntry(byte[] bArr, int i, int i2, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map, ArrayDecoders.Registers registers) throws IOException {
        int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
        int i3 = registers.int1;
        if (i3 < 0 || i3 > i2 - iDecodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i4 = iDecodeVarint32 + i3;
        Object obj = metadata.defaultKey;
        Object obj2 = metadata.defaultValue;
        while (iDecodeVarint32 < i4) {
            int iDecodeVarint33 = iDecodeVarint32 + 1;
            int i5 = bArr[iDecodeVarint32];
            if (i5 < 0) {
                iDecodeVarint33 = ArrayDecoders.decodeVarint32(i5, bArr, iDecodeVarint33, registers);
                i5 = registers.int1;
            }
            int i6 = iDecodeVarint33;
            int i7 = i5 >>> 3;
            int i8 = i5 & 7;
            if (i7 == 1) {
                if (i8 == metadata.keyType.getWireType()) {
                    iDecodeVarint32 = decodeMapEntryValue(bArr, i6, i2, metadata.keyType, null, registers);
                    obj = registers.object1;
                } else {
                    iDecodeVarint32 = ArrayDecoders.skipField(i5, bArr, i6, i2, registers);
                }
            } else if (i7 == 2 && i8 == metadata.valueType.getWireType()) {
                iDecodeVarint32 = decodeMapEntryValue(bArr, i6, i2, metadata.valueType, metadata.defaultValue.getClass(), registers);
                obj2 = registers.object1;
            } else {
                iDecodeVarint32 = ArrayDecoders.skipField(i5, bArr, i6, i2, registers);
            }
        }
        if (iDecodeVarint32 != i4) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        map.put(obj, obj2);
        return i4;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    private int parseRepeatedField(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, ArrayDecoders.Registers registers) throws IOException {
        int iDecodeVarint32List;
        Unsafe unsafe = UNSAFE;
        Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe.getObject(t, j2);
        if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
            int size = protobufListMutableCopyWithCapacity2.size();
            protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
            unsafe.putObject(t, j2, protobufListMutableCopyWithCapacity2);
        }
        Internal.ProtobufList protobufList = protobufListMutableCopyWithCapacity2;
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedDoubleList(bArr, i, protobufList, registers);
                }
                if (i5 == 1) {
                    return ArrayDecoders.decodeDoubleList(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 19:
            case 36:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFloatList(bArr, i, protobufList, registers);
                }
                if (i5 == 5) {
                    return ArrayDecoders.decodeFloatList(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedVarint64List(bArr, i, protobufList, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeVarint64List(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedVarint32List(bArr, i, protobufList, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeVarint32List(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFixed64List(bArr, i, protobufList, registers);
                }
                if (i5 == 1) {
                    return ArrayDecoders.decodeFixed64List(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFixed32List(bArr, i, protobufList, registers);
                }
                if (i5 == 5) {
                    return ArrayDecoders.decodeFixed32List(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 25:
            case 42:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedBoolList(bArr, i, protobufList, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeBoolList(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        return ArrayDecoders.decodeStringList(i3, bArr, i, i2, protobufList, registers);
                    }
                    return ArrayDecoders.decodeStringListRequireUtf8(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 27:
                if (i5 == 2) {
                    return ArrayDecoders.decodeMessageList(getMessageFieldSchema(i6), i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 28:
                if (i5 == 2) {
                    return ArrayDecoders.decodeBytesList(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 30:
            case 44:
                if (i5 != 2) {
                    if (i5 == 0) {
                        iDecodeVarint32List = ArrayDecoders.decodeVarint32List(i3, bArr, i, i2, protobufList, registers);
                    }
                    return i;
                }
                iDecodeVarint32List = ArrayDecoders.decodePackedVarint32List(bArr, i, protobufList, registers);
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t;
                UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
                if (unknownFieldSetLite == UnknownFieldSetLite.getDefaultInstance()) {
                    unknownFieldSetLite = null;
                }
                UnknownFieldSetLite unknownFieldSetLite2 = (UnknownFieldSetLite) SchemaUtil.filterUnknownEnumList(i4, (List<Integer>) protobufList, getEnumFieldVerifier(i6), unknownFieldSetLite, (UnknownFieldSchema<UT, UnknownFieldSetLite>) this.unknownFieldSchema);
                if (unknownFieldSetLite2 != null) {
                    generatedMessageLite.unknownFields = unknownFieldSetLite2;
                }
                return iDecodeVarint32List;
            case 33:
            case 47:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedSInt32List(bArr, i, protobufList, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeSInt32List(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 34:
            case 48:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedSInt64List(bArr, i, protobufList, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeSInt64List(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 49:
                if (i5 == 3) {
                    return ArrayDecoders.decodeGroupList(getMessageFieldSchema(i6), i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            default:
                return i;
        }
    }

    private <K, V> int parseMapField(T t, byte[] bArr, int i, int i2, int i3, long j, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i3);
        Object object = unsafe.getObject(t, j);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            unsafe.putObject(t, j, objNewMapField);
            object = objNewMapField;
        }
        return decodeMapEntry(bArr, i, i2, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), registers);
    }

    private int parseOneofField(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, ArrayDecoders.Registers registers) throws IOException {
        Object object;
        Unsafe unsafe = UNSAFE;
        long j2 = this.buffer[i8 + 2] & OFFSET_MASK;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Double.valueOf(ArrayDecoders.decodeDouble(bArr, i)));
                int i9 = i + 8;
                unsafe.putInt(t, j2, i4);
                return i9;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Float.valueOf(ArrayDecoders.decodeFloat(bArr, i)));
                int i10 = i + 4;
                unsafe.putInt(t, j2, i4);
                return i10;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t, j, Long.valueOf(registers.long1));
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint64;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                unsafe.putObject(t, j, Integer.valueOf(registers.int1));
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint32;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i)));
                int i11 = i + 8;
                unsafe.putInt(t, j2, i4);
                return i11;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i)));
                int i12 = i + 4;
                unsafe.putInt(t, j2, i4);
                return i12;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint65 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t, j, Boolean.valueOf(registers.long1 != 0));
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint65;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iDecodeVarint33 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                int i13 = registers.int1;
                if (i13 == 0) {
                    unsafe.putObject(t, j, "");
                } else {
                    if ((i6 & 536870912) != 0 && !Utf8.isValidUtf8(bArr, iDecodeVarint33, iDecodeVarint33 + i13)) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    unsafe.putObject(t, j, new String(bArr, iDecodeVarint33, i13, Internal.UTF_8));
                    iDecodeVarint33 += i13;
                }
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint33;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                int iDecodeMessageField = ArrayDecoders.decodeMessageField(getMessageFieldSchema(i8), bArr, i, i2, registers);
                object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                if (object == null) {
                    unsafe.putObject(t, j, registers.object1);
                } else {
                    unsafe.putObject(t, j, Internal.mergeMessage(object, registers.object1));
                }
                unsafe.putInt(t, j2, i4);
                return iDecodeMessageField;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                int iDecodeBytes = ArrayDecoders.decodeBytes(bArr, i, registers);
                unsafe.putObject(t, j, registers.object1);
                unsafe.putInt(t, j2, i4);
                return iDecodeBytes;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint34 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                int i14 = registers.int1;
                Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i8);
                if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i14)) {
                    unsafe.putObject(t, j, Integer.valueOf(i14));
                    unsafe.putInt(t, j2, i4);
                    return iDecodeVarint34;
                }
                getMutableUnknownFields(t).storeField(i3, Long.valueOf(i14));
                return iDecodeVarint34;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint35 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                unsafe.putObject(t, j, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1)));
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint35;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint66 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t, j, Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1)));
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint66;
            case 68:
                if (i5 == 3) {
                    int iDecodeGroupField = ArrayDecoders.decodeGroupField(getMessageFieldSchema(i8), bArr, i, i2, (i3 & (-8)) | 4, registers);
                    object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, registers.object1);
                    } else {
                        unsafe.putObject(t, j, Internal.mergeMessage(object, registers.object1));
                    }
                    unsafe.putInt(t, j2, i4);
                    return iDecodeGroupField;
                }
                break;
        }
        return i;
    }

    private Schema getMessageFieldSchema(int i) {
        int i2 = (i / 3) * 2;
        Schema schema = (Schema) this.objects[i2];
        if (schema != null) {
            return schema;
        }
        Schema<T> schemaSchemaFor = Protobuf.getInstance().schemaFor((Class) this.objects[i2 + 1]);
        this.objects[i2] = schemaSchemaFor;
        return schemaSchemaFor;
    }

    private Object getMapFieldDefaultEntry(int i) {
        return this.objects[(i / 3) * 2];
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int i) {
        return (Internal.EnumVerifier) this.objects[((i / 3) * 2) + 1];
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 11901. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    int parseProto2Message(T r28, byte[] r29, int r30, int r31, int r32, com.google.crypto.tink.shaded.protobuf.ArrayDecoders.Registers r33) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1190
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.parseProto2Message(java.lang.Object, byte[], int, int, int, com.google.crypto.tink.shaded.protobuf.ArrayDecoders$Registers):int");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0052. Please report as an issue. */
    private int parseProto3Message(T t, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers) throws IOException {
        int iPositionForFieldNumber;
        Unsafe unsafe;
        int i3;
        int i4;
        Unsafe unsafe2;
        int iDecodeVarint64;
        int i5;
        int i6;
        int i7;
        this = this;
        bArr = bArr;
        i2 = i2;
        registers = registers;
        Unsafe unsafe3 = UNSAFE;
        int i8 = -1;
        int iDecodeUnknownField = i;
        int i9 = -1;
        int i10 = 0;
        while (iDecodeUnknownField < i2) {
            int iDecodeVarint32 = iDecodeUnknownField + 1;
            int i11 = bArr[iDecodeUnknownField];
            if (i11 < 0) {
                iDecodeVarint32 = ArrayDecoders.decodeVarint32(i11, bArr, iDecodeVarint32, registers);
                i11 = registers.int1;
            }
            int i12 = iDecodeVarint32;
            int i13 = i11;
            int i14 = (i13 == true ? 1 : 0) >>> 3;
            int i15 = (i13 == true ? 1 : 0) & 7;
            if (i14 > i9) {
                iPositionForFieldNumber = this.positionForFieldNumber(i14, i10 / 3);
            } else {
                iPositionForFieldNumber = this.positionForFieldNumber(i14);
            }
            int i16 = iPositionForFieldNumber;
            if (i16 == i8) {
                unsafe = unsafe3;
                i3 = i12;
                i4 = i14;
                i16 = 0;
            } else {
                int i17 = this.buffer[i16 + 1];
                int iType = type(i17);
                long jOffset = offset(i17);
                if (iType <= 17) {
                    switch (iType) {
                        case 0:
                            i13 = i13 == true ? 1 : 0;
                            if (i15 == 1) {
                                UnsafeUtil.putDouble(t, jOffset, ArrayDecoders.decodeDouble(bArr, i12));
                                iDecodeUnknownField = i12 + 8;
                                i9 = i14;
                                i10 = i16;
                            }
                            unsafe = unsafe3;
                            i5 = i12;
                            i6 = i14;
                            i7 = i13;
                            i3 = i5;
                            i4 = i6;
                            i13 = i7;
                            break;
                        case 1:
                            i13 = i13 == true ? 1 : 0;
                            if (i15 == 5) {
                                UnsafeUtil.putFloat(t, jOffset, ArrayDecoders.decodeFloat(bArr, i12));
                                iDecodeUnknownField = i12 + 4;
                                i9 = i14;
                                i10 = i16;
                            }
                            unsafe = unsafe3;
                            i5 = i12;
                            i6 = i14;
                            i7 = i13;
                            i3 = i5;
                            i4 = i6;
                            i13 = i7;
                            break;
                        case 2:
                        case 3:
                            unsafe2 = unsafe3;
                            if (i15 != 0) {
                                unsafe = unsafe2;
                                i5 = i12;
                                i6 = i14;
                                i7 = i13;
                                i3 = i5;
                                i4 = i6;
                                i13 = i7;
                            } else {
                                iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i12, registers);
                                unsafe3 = unsafe2;
                                unsafe3.putLong(t, jOffset, registers.long1);
                                iDecodeUnknownField = iDecodeVarint64;
                                i9 = i14;
                                i10 = i16;
                            }
                            break;
                        case 4:
                        case 11:
                            unsafe2 = unsafe3;
                            if (i15 == 0) {
                                iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr, i12, registers);
                                unsafe2.putInt(t, jOffset, registers.int1);
                                unsafe3 = unsafe2;
                                i9 = i14;
                                i10 = i16;
                            }
                            unsafe = unsafe2;
                            i5 = i12;
                            i6 = i14;
                            i7 = i13;
                            i3 = i5;
                            i4 = i6;
                            i13 = i7;
                            break;
                        case 5:
                        case 14:
                            unsafe2 = unsafe3;
                            if (i15 == 1) {
                                unsafe2.putLong(t, jOffset, ArrayDecoders.decodeFixed64(bArr, i12));
                                unsafe2 = unsafe2;
                                iDecodeUnknownField = i12 + 8;
                                unsafe3 = unsafe2;
                                i9 = i14;
                                i10 = i16;
                            }
                            unsafe = unsafe2;
                            i5 = i12;
                            i6 = i14;
                            i7 = i13;
                            i3 = i5;
                            i4 = i6;
                            i13 = i7;
                            break;
                        case 6:
                        case 13:
                            unsafe2 = unsafe3;
                            if (i15 == 5) {
                                unsafe2.putInt(t, jOffset, ArrayDecoders.decodeFixed32(bArr, i12));
                                iDecodeUnknownField = i12 + 4;
                                unsafe3 = unsafe2;
                                i9 = i14;
                                i10 = i16;
                            }
                            unsafe = unsafe2;
                            i5 = i12;
                            i6 = i14;
                            i7 = i13;
                            i3 = i5;
                            i4 = i6;
                            i13 = i7;
                            break;
                        case 7:
                            unsafe2 = unsafe3;
                            if (i15 == 0) {
                                iDecodeUnknownField = ArrayDecoders.decodeVarint64(bArr, i12, registers);
                                UnsafeUtil.putBoolean(t, jOffset, registers.long1 != 0);
                                unsafe3 = unsafe2;
                                i9 = i14;
                                i10 = i16;
                            }
                            unsafe = unsafe2;
                            i5 = i12;
                            i6 = i14;
                            i7 = i13;
                            i3 = i5;
                            i4 = i6;
                            i13 = i7;
                            break;
                        case 8:
                            unsafe2 = unsafe3;
                            if (i15 == 2) {
                                if ((536870912 & i17) == 0) {
                                    iDecodeUnknownField = ArrayDecoders.decodeString(bArr, i12, registers);
                                } else {
                                    iDecodeUnknownField = ArrayDecoders.decodeStringRequireUtf8(bArr, i12, registers);
                                }
                                unsafe2.putObject(t, jOffset, registers.object1);
                                unsafe3 = unsafe2;
                                i9 = i14;
                                i10 = i16;
                            }
                            unsafe = unsafe2;
                            i5 = i12;
                            i6 = i14;
                            i7 = i13;
                            i3 = i5;
                            i4 = i6;
                            i13 = i7;
                            break;
                        case 9:
                            unsafe2 = unsafe3;
                            if (i15 == 2) {
                                iDecodeUnknownField = ArrayDecoders.decodeMessageField(this.getMessageFieldSchema(i16), bArr, i12, i2, registers);
                                Object object = unsafe2.getObject(t, jOffset);
                                if (object == null) {
                                    unsafe2.putObject(t, jOffset, registers.object1);
                                } else {
                                    unsafe2.putObject(t, jOffset, Internal.mergeMessage(object, registers.object1));
                                }
                                unsafe3 = unsafe2;
                                i9 = i14;
                                i10 = i16;
                            }
                            unsafe = unsafe2;
                            i5 = i12;
                            i6 = i14;
                            i7 = i13;
                            i3 = i5;
                            i4 = i6;
                            i13 = i7;
                            break;
                        case 10:
                            unsafe2 = unsafe3;
                            if (i15 == 2) {
                                iDecodeUnknownField = ArrayDecoders.decodeBytes(bArr, i12, registers);
                                unsafe2.putObject(t, jOffset, registers.object1);
                                unsafe3 = unsafe2;
                                i9 = i14;
                                i10 = i16;
                            }
                            unsafe = unsafe2;
                            i5 = i12;
                            i6 = i14;
                            i7 = i13;
                            i3 = i5;
                            i4 = i6;
                            i13 = i7;
                            break;
                        case 12:
                            unsafe2 = unsafe3;
                            if (i15 == 0) {
                                iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr, i12, registers);
                                unsafe2.putInt(t, jOffset, registers.int1);
                                unsafe3 = unsafe2;
                                i9 = i14;
                                i10 = i16;
                            }
                            unsafe = unsafe2;
                            i5 = i12;
                            i6 = i14;
                            i7 = i13 == true ? 1 : 0;
                            i3 = i5;
                            i4 = i6;
                            i13 = i7;
                            break;
                        case 15:
                            unsafe2 = unsafe3;
                            if (i15 == 0) {
                                iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr, i12, registers);
                                unsafe2.putInt(t, jOffset, CodedInputStream.decodeZigZag32(registers.int1));
                                unsafe3 = unsafe2;
                                i9 = i14;
                                i10 = i16;
                            }
                            unsafe = unsafe2;
                            i5 = i12;
                            i6 = i14;
                            i7 = i13 == true ? 1 : 0;
                            i3 = i5;
                            i4 = i6;
                            i13 = i7;
                            break;
                        case 16:
                            if (i15 != 0) {
                                unsafe2 = unsafe3;
                                unsafe = unsafe2;
                                i5 = i12;
                                i6 = i14;
                                i7 = i13 == true ? 1 : 0;
                                i3 = i5;
                                i4 = i6;
                                i13 = i7;
                            } else {
                                iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i12, registers);
                                unsafe3.putLong(t, jOffset, CodedInputStream.decodeZigZag64(registers.long1));
                                unsafe3 = unsafe3;
                                iDecodeUnknownField = iDecodeVarint64;
                                i9 = i14;
                                i10 = i16;
                            }
                            break;
                        default:
                            unsafe = unsafe3;
                            i5 = i12;
                            i6 = i14;
                            i7 = i13 == true ? 1 : 0;
                            i3 = i5;
                            i4 = i6;
                            i13 = i7;
                            break;
                    }
                    i8 = -1;
                } else {
                    i13 = i13 == true ? 1 : 0;
                    if (iType != 27) {
                        unsafe = unsafe3;
                        if (iType <= 49) {
                            int repeatedField = this.parseRepeatedField(t, bArr, i12, i2, i13 == true ? 1 : 0, i14, i15, i16, i17, iType, jOffset, registers);
                            i7 = i13 == true ? 1 : 0;
                            i6 = i14;
                            if (repeatedField != i12) {
                                i16 = i16;
                                iDecodeUnknownField = repeatedField;
                                i9 = i6;
                                i10 = i16;
                                unsafe3 = unsafe;
                                i8 = -1;
                                bArr = bArr;
                            } else {
                                i16 = i16;
                                i3 = repeatedField;
                                i4 = i6;
                                i13 = i7;
                            }
                        } else {
                            i6 = i14;
                            i7 = i13 == true ? 1 : 0;
                            i5 = i12;
                            if (iType == 50) {
                                if (i15 == 2) {
                                    int mapField = parseMapField(t, bArr, i5, i2, i16, jOffset, registers);
                                    if (mapField != i5) {
                                        this = this;
                                        i2 = i2;
                                        iDecodeUnknownField = mapField;
                                        i9 = i6;
                                    } else {
                                        i3 = mapField;
                                    }
                                } else {
                                    i3 = i5;
                                }
                                i4 = i6;
                                i13 = i7;
                            } else {
                                i4 = i6;
                                i13 = i7 == true ? 1 : 0;
                                int oneofField = parseOneofField(t, bArr, i5, i2, i13 == true ? 1 : 0, i4, i15, i17, iType, jOffset, i16, registers);
                                if (oneofField != i5) {
                                    i9 = i4;
                                    iDecodeUnknownField = oneofField;
                                    i10 = i16;
                                    unsafe3 = unsafe;
                                    i8 = -1;
                                    bArr = bArr;
                                } else {
                                    i3 = oneofField;
                                }
                            }
                        }
                    } else if (i15 == 2) {
                        Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe3.getObject(t, jOffset);
                        if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
                            int size = protobufListMutableCopyWithCapacity2.size();
                            protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
                            unsafe3.putObject(t, jOffset, protobufListMutableCopyWithCapacity2);
                        }
                        unsafe = unsafe3;
                        iDecodeUnknownField = ArrayDecoders.decodeMessageList(this.getMessageFieldSchema(i16), i13 == true ? 1 : 0, bArr, i12, i2, protobufListMutableCopyWithCapacity2, registers);
                        i2 = i2;
                        i9 = i14;
                    } else {
                        unsafe = unsafe3;
                        i5 = i12;
                        i6 = i14;
                        i7 = i13;
                        i3 = i5;
                        i4 = i6;
                        i13 = i7;
                    }
                    i10 = i16;
                    unsafe3 = unsafe;
                    i8 = -1;
                }
            }
            iDecodeUnknownField = ArrayDecoders.decodeUnknownField(i13 == true ? 1 : 0, bArr, i3, i2, getMutableUnknownFields(t), registers);
            this = this;
            i2 = i2;
            i9 = i4;
            i10 = i16;
            unsafe3 = unsafe;
            i8 = -1;
        }
        if (iDecodeUnknownField == i2) {
            return iDecodeUnknownField;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void mergeFrom(T t, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers) throws IOException {
        if (this.proto3) {
            parseProto3Message(t, bArr, i, i2, registers);
        } else {
            parseProto2Message(t, bArr, i, i2, 0, registers);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void makeImmutable(T t) {
        int i;
        int i2 = this.checkInitializedCount;
        while (true) {
            i = this.repeatedFieldOffsetStart;
            if (i2 >= i) {
                break;
            }
            long jOffset = offset(typeAndOffsetAt(this.intArray[i2]));
            Object object = UnsafeUtil.getObject(t, jOffset);
            if (object != null) {
                UnsafeUtil.putObject(t, jOffset, this.mapFieldSchema.toImmutable(object));
            }
            i2++;
        }
        int length = this.intArray.length;
        while (i < length) {
            this.listFieldSchema.makeImmutableListAt(t, this.intArray[i]);
            i++;
        }
        this.unknownFieldSchema.makeImmutable(t);
        if (this.hasExtensions) {
            this.extensionSchema.makeImmutable(t);
        }
    }

    private final <K, V> void mergeMap(Object obj, int i, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) throws IOException {
        long jOffset = offset(typeAndOffsetAt(i));
        Object object = UnsafeUtil.getObject(obj, jOffset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(obj2);
            UnsafeUtil.putObject(obj, jOffset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            UnsafeUtil.putObject(obj, jOffset, objNewMapField);
            object = objNewMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    private final <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        Internal.EnumVerifier enumFieldVerifier;
        int iNumberAt = numberAt(i);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i)));
        return (object == null || (enumFieldVerifier = getEnumFieldVerifier(i)) == null) ? ub : (UB) filterUnknownEnumMap(i, iNumberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub, unknownFieldSchema);
    }

    private final <K, V, UT, UB> UB filterUnknownEnumMap(int i, int i2, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        MapEntryLite.Metadata<?, ?> metadataForMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema.newBuilder();
                }
                ByteString.CodedBuilder codedBuilderNewCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(metadataForMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.writeTo(codedBuilderNewCodedBuilder.getCodedOutput(), metadataForMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema.addLengthDelimited(ub, i2, codedBuilderNewCodedBuilder.build());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0078  */
    /* JADX WARN: Code duplicated, block: B:58:0x007e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x0090 A[SYNTHETIC] */
    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final boolean isInitialized(T t) {
        int i;
        int i2 = -1;
        int i3 = 0;
        for (int i4 = 0; i4 < this.checkInitializedCount; i4++) {
            int i5 = this.intArray[i4];
            int iNumberAt = numberAt(i5);
            int iTypeAndOffsetAt = typeAndOffsetAt(i5);
            if (this.proto3) {
                i = 0;
            } else {
                int i6 = this.buffer[i5 + 2];
                int i7 = OFFSET_MASK & i6;
                i = 1 << (i6 >>> 20);
                if (i7 != i2) {
                    i3 = UNSAFE.getInt(t, i7);
                    i2 = i7;
                }
            }
            if (isRequired(iTypeAndOffsetAt) && !isFieldPresent(t, i5, i3, i)) {
                return false;
            }
            int iType = type(iTypeAndOffsetAt);
            if (iType == 9 || iType == 17) {
                if (isFieldPresent(t, i5, i3, i) && !isInitialized(t, iTypeAndOffsetAt, getMessageFieldSchema(i5))) {
                    return false;
                }
            } else if (iType == 27) {
                if (!isListInitialized(t, iTypeAndOffsetAt, i5)) {
                    return false;
                }
            } else if (iType == 60 || iType == 68) {
                if (isOneofPresent(t, iNumberAt, i5) && !isInitialized(t, iTypeAndOffsetAt, getMessageFieldSchema(i5))) {
                    return false;
                }
            } else if (iType == 49) {
                if (!isListInitialized(t, iTypeAndOffsetAt, i5)) {
                    return false;
                }
            } else if (iType == 50 && !isMapInitialized(t, iTypeAndOffsetAt, i5)) {
                return false;
            }
        }
        return !this.hasExtensions || this.extensionSchema.getExtensions(t).isInitialized();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object obj, int i, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(obj, offset(i)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object obj, int i, int i2) {
        List list = (List) UnsafeUtil.getObject(obj, offset(i));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!messageFieldSchema.isInitialized(list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.crypto.tink.shaded.protobuf.Schema] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    private boolean isMapInitialized(T t, int i, int i2) {
        Map<?, ?> mapForMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(t, offset(i)));
        if (mapForMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        ?? SchemaFor = 0;
        for (Object obj : mapForMapData.values()) {
            if (SchemaFor == 0) {
                SchemaFor = SchemaFor;
                SchemaFor = Protobuf.getInstance().schemaFor((Class) obj.getClass());
            }
            SchemaFor = SchemaFor;
            if (!SchemaFor.isInitialized(obj)) {
                return false;
            }
        }
        return true;
    }

    private void writeString(int i, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.writeString(i, (String) obj);
        } else {
            writer.writeBytes(i, (ByteString) obj);
        }
    }

    private void readString(Object obj, int i, Reader reader) throws IOException {
        if (isEnforceUtf8(i)) {
            UnsafeUtil.putObject(obj, offset(i), reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(obj, offset(i), reader.readString());
        } else {
            UnsafeUtil.putObject(obj, offset(i), reader.readBytes());
        }
    }

    private void readStringList(Object obj, int i, Reader reader) throws IOException {
        if (isEnforceUtf8(i)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(obj, offset(i)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(obj, offset(i)));
        }
    }

    private <E> void readMessageList(Object obj, int i, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(i)), schema, extensionRegistryLite);
    }

    private <E> void readGroupList(Object obj, long j, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readGroupList(this.listFieldSchema.mutableListAt(obj, j), schema, extensionRegistryLite);
    }

    private int numberAt(int i) {
        return this.buffer[i];
    }

    private int typeAndOffsetAt(int i) {
        return this.buffer[i + 1];
    }

    private int presenceMaskAndOffsetAt(int i) {
        return this.buffer[i + 2];
    }

    private static <T> double doubleAt(T t, long j) {
        return UnsafeUtil.getDouble(t, j);
    }

    private static <T> float floatAt(T t, long j) {
        return UnsafeUtil.getFloat(t, j);
    }

    private static <T> int intAt(T t, long j) {
        return UnsafeUtil.getInt(t, j);
    }

    private static <T> long longAt(T t, long j) {
        return UnsafeUtil.getLong(t, j);
    }

    private static <T> boolean booleanAt(T t, long j) {
        return UnsafeUtil.getBoolean(t, j);
    }

    private static <T> double oneofDoubleAt(T t, long j) {
        return ((Double) UnsafeUtil.getObject(t, j)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t, long j) {
        return ((Float) UnsafeUtil.getObject(t, j)).floatValue();
    }

    private static <T> int oneofIntAt(T t, long j) {
        return ((Integer) UnsafeUtil.getObject(t, j)).intValue();
    }

    private static <T> long oneofLongAt(T t, long j) {
        return ((Long) UnsafeUtil.getObject(t, j)).longValue();
    }

    private static <T> boolean oneofBooleanAt(T t, long j) {
        return ((Boolean) UnsafeUtil.getObject(t, j)).booleanValue();
    }

    private boolean arePresentForEquals(T t, T t2, int i) {
        return isFieldPresent(t, i) == isFieldPresent(t2, i);
    }

    private boolean isFieldPresent(T t, int i, int i2, int i3) {
        if (this.proto3) {
            return isFieldPresent(t, i);
        }
        return (i2 & i3) != 0;
    }

    private boolean isFieldPresent(T t, int i) {
        boolean zEquals;
        if (this.proto3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i);
            long jOffset = offset(iTypeAndOffsetAt);
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    return UnsafeUtil.getDouble(t, jOffset) != 0.0d;
                case 1:
                    return UnsafeUtil.getFloat(t, jOffset) != 0.0f;
                case 2:
                    return UnsafeUtil.getLong(t, jOffset) != 0;
                case 3:
                    return UnsafeUtil.getLong(t, jOffset) != 0;
                case 4:
                    return UnsafeUtil.getInt(t, jOffset) != 0;
                case 5:
                    return UnsafeUtil.getLong(t, jOffset) != 0;
                case 6:
                    return UnsafeUtil.getInt(t, jOffset) != 0;
                case 7:
                    return UnsafeUtil.getBoolean(t, jOffset);
                case 8:
                    Object object = UnsafeUtil.getObject(t, jOffset);
                    if (object instanceof String) {
                        zEquals = ((String) object).isEmpty();
                    } else if (object instanceof ByteString) {
                        zEquals = ByteString.EMPTY.equals(object);
                    } else {
                        throw new IllegalArgumentException();
                    }
                    break;
                case 9:
                    return UnsafeUtil.getObject(t, jOffset) != null;
                case 10:
                    zEquals = ByteString.EMPTY.equals(UnsafeUtil.getObject(t, jOffset));
                    break;
                case 11:
                    return UnsafeUtil.getInt(t, jOffset) != 0;
                case 12:
                    return UnsafeUtil.getInt(t, jOffset) != 0;
                case 13:
                    return UnsafeUtil.getInt(t, jOffset) != 0;
                case 14:
                    return UnsafeUtil.getLong(t, jOffset) != 0;
                case 15:
                    return UnsafeUtil.getInt(t, jOffset) != 0;
                case 16:
                    return UnsafeUtil.getLong(t, jOffset) != 0;
                case 17:
                    return UnsafeUtil.getObject(t, jOffset) != null;
                default:
                    throw new IllegalArgumentException();
            }
            return !zEquals;
        }
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        return (UnsafeUtil.getInt(t, (long) (iPresenceMaskAndOffsetAt & OFFSET_MASK)) & (1 << (iPresenceMaskAndOffsetAt >>> 20))) != 0;
    }

    private void setFieldPresent(T t, int i) {
        if (this.proto3) {
            return;
        }
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        long j = iPresenceMaskAndOffsetAt & OFFSET_MASK;
        UnsafeUtil.putInt(t, j, UnsafeUtil.getInt(t, j) | (1 << (iPresenceMaskAndOffsetAt >>> 20)));
    }

    private boolean isOneofPresent(T t, int i, int i2) {
        return UnsafeUtil.getInt(t, (long) (presenceMaskAndOffsetAt(i2) & OFFSET_MASK)) == i;
    }

    private boolean isOneofCaseEqual(T t, T t2, int i) {
        long jPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i) & OFFSET_MASK;
        return UnsafeUtil.getInt(t, jPresenceMaskAndOffsetAt) == UnsafeUtil.getInt(t2, jPresenceMaskAndOffsetAt);
    }

    private void setOneofPresent(T t, int i, int i2) {
        UnsafeUtil.putInt(t, presenceMaskAndOffsetAt(i2) & OFFSET_MASK, i);
    }

    private int positionForFieldNumber(int i) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, 0);
    }

    private int positionForFieldNumber(int i, int i2) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, i2);
    }

    private int slowPositionForFieldNumber(int i, int i2) {
        int length = (this.buffer.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int iNumberAt = numberAt(i4);
            if (i == iNumberAt) {
                return i4;
            }
            if (i < iNumberAt) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    int getSchemaSize() {
        return this.buffer.length * 3;
    }
}
