package io.split.android.client;

import io.split.android.client.validators.FlagSetsValidatorImpl;
import io.split.android.client.validators.SplitFilterValidator;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SplitFilter {
    private int mInvalidValueCount;
    private int mTotalValueCount;
    private final Type mType;
    private final List<String> mValues;

    /* JADX INFO: renamed from: io.split.android.client.SplitFilter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$SplitFilter$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$io$split$android$client$SplitFilter$Type = iArr;
            try {
                iArr[Type.BY_NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$SplitFilter$Type[Type.BY_PREFIX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$split$android$client$SplitFilter$Type[Type.BY_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum Type {
        BY_NAME,
        BY_PREFIX,
        BY_SET;

        @Override // java.lang.Enum
        public String toString() {
            int i = AnonymousClass1.$SwitchMap$io$split$android$client$SplitFilter$Type[ordinal()];
            if (i == 1) {
                return "by split name";
            }
            if (i == 2) {
                return "by split prefix";
            }
            if (i == 3) {
                return "by flag set";
            }
            return "Invalid type";
        }

        public String queryStringField() {
            int i = AnonymousClass1.$SwitchMap$io$split$android$client$SplitFilter$Type[ordinal()];
            if (i == 1) {
                return "names";
            }
            if (i == 2) {
                return "prefixes";
            }
            if (i == 3) {
                return "sets";
            }
            return "unknown";
        }

        public int maxValuesCount() {
            int i = AnonymousClass1.$SwitchMap$io$split$android$client$SplitFilter$Type[ordinal()];
            if (i == 1) {
                return 400;
            }
            if (i != 2) {
                return i != 3 ? 0 : 999999;
            }
            return 50;
        }
    }

    public static SplitFilter byName(List<String> values) {
        return new SplitFilter(Type.BY_NAME, values);
    }

    public static SplitFilter byPrefix(List<String> values) {
        return new SplitFilter(Type.BY_PREFIX, values);
    }

    public static SplitFilter bySet(List<String> values) {
        if (values == null) {
            values = new ArrayList<>();
        }
        return new SplitFilter(Type.BY_SET, values, new FlagSetsValidatorImpl());
    }

    SplitFilter(Type type, List<String> values) {
        if (values == null) {
            throw new IllegalArgumentException("Values can't be null for " + type.toString() + " filter");
        }
        this.mType = type;
        this.mValues = new ArrayList(values);
    }

    SplitFilter(Type type, List<String> values, SplitFilterValidator validator) {
        this.mType = type;
        SplitFilterValidator.ValidationResult validationResultCleanup = validator.cleanup("SDK config", values);
        this.mValues = validationResultCleanup.getValues();
        this.mInvalidValueCount = validationResultCleanup.getInvalidValueCount();
        this.mTotalValueCount = values != null ? values.size() - validationResultCleanup.getInvalidValueCount() : 0;
    }

    public Type getType() {
        return this.mType;
    }

    public List<String> getValues() {
        return this.mValues;
    }

    public int getInvalidValueCount() {
        return this.mInvalidValueCount;
    }

    public int getTotalValueCount() {
        return this.mTotalValueCount;
    }
}
