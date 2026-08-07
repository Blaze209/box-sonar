package expo.modules.kotlin.records.formatters;

import androidx.exifinterface.media.ExifInterface;
import com.pspdfkit.analytics.Analytics;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KProperty1;

/* JADX INFO: compiled from: PropertySelector.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004:\u0002\u0016\u0017B6\u0012-\u0010\u0005\u001a)\u0012\u001f\u0012\u001d\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0002\b\u00030\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0004\b\f\u0010\rR;\u0010\u0005\u001a)\u0012\u001f\u0012\u001d\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0002\b\u00030\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR2\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lexpo/modules/kotlin/records/formatters/PropertySelector;", "RecordType", "Lexpo/modules/kotlin/records/Record;", "PropertyType", "", "selector", "Lkotlin/Function1;", "Lkotlin/reflect/KProperty1;", "Lkotlin/ParameterName;", "name", "property", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getSelector$expo_modules_core_release", "()Lkotlin/jvm/functions/Function1;", Analytics.Data.ACTION, "Lkotlin/Function2;", "getAction$expo_modules_core_release", "()Lkotlin/jvm/functions/Function2;", "setAction$expo_modules_core_release", "(Lkotlin/jvm/functions/Function2;)V", "ActionBuilder", "ActionBuilderForRecord", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PropertySelector<RecordType extends Record, PropertyType> {
    public static final int $stable = 8;
    private Function2<? super RecordType, Object, ? extends Object> action;
    private final Function1<KProperty1<? super RecordType, ?>, Boolean> selector;

    /* JADX WARN: Multi-variable type inference failed */
    public PropertySelector(Function1<? super KProperty1<? super RecordType, ?>, Boolean> selector) {
        Intrinsics.checkNotNullParameter(selector, "selector");
        this.selector = selector;
    }

    public final Function1<KProperty1<? super RecordType, ?>, Boolean> getSelector$expo_modules_core_release() {
        return this.selector;
    }

    public final Function2<RecordType, Object, Object> getAction$expo_modules_core_release() {
        return this.action;
    }

    public final void setAction$expo_modules_core_release(Function2<? super RecordType, Object, ? extends Object> function2) {
        this.action = function2;
    }

    /* JADX INFO: compiled from: PropertySelector.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0096\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004Jf\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u0002H\u00060\u0000R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\"\u0004\b\u0003\u0010\u0006\"\u0004\b\u0004\u0010\b2\u001e\b\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u0002H\u00060\u0000R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00072\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\nH\u0002J8\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00028\u00020\u0000R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00072\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\r0\nH\u0002J6\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00028\u00020\u0000R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\"\u0004\b\u0003\u0010\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u0002H\u000f0\u0011J<\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00028\u00020\u0000R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\"\u0004\b\u0003\u0010\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u0002H\u000f0\nJA\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00028\u00020\u0000R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00072#\b\u0002\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\r0\u0011J*\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00028\u00020\u0000R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00020\u0017JT\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00028\u00020\u0000R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000726\u0010\u0013\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\r0\n¨\u0006\u0019"}, d2 = {"Lexpo/modules/kotlin/records/formatters/PropertySelector$ActionBuilder;", "InputType", "", "<init>", "(Lexpo/modules/kotlin/records/formatters/PropertySelector;)V", "nextAction", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/records/formatters/PropertySelector;", "R", "nextBuilder", "Lkotlin/Function2;", "defaultSkipAction", "shouldSkip", "", "map", "ResultType", "mapper", "Lkotlin/Function1;", "skip", "valueSelector", "Lkotlin/ParameterName;", "name", "value", "Lexpo/modules/kotlin/records/formatters/ValueSelector;", "record", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public class ActionBuilder<InputType> {
        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean skip$lambda$4(Object obj) {
            return true;
        }

        public ActionBuilder() {
        }

        static /* synthetic */ ActionBuilder nextAction$default(ActionBuilder actionBuilder, ActionBuilder actionBuilder2, Function2 function2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextAction");
            }
            if ((i & 1) != 0) {
                actionBuilder2 = PropertySelector.this.new ActionBuilder();
            }
            return actionBuilder.nextAction(actionBuilder2, function2);
        }

        private final <T, R> PropertySelector<RecordType, PropertyType>.ActionBuilder<T> nextAction(PropertySelector<RecordType, PropertyType>.ActionBuilder<T> nextBuilder, Function2<? super RecordType, ? super InputType, ? extends Object> nextAction) {
            Intrinsics.checkNotNull(nextAction, "null cannot be cast to non-null type kotlin.Function2<RecordType of expo.modules.kotlin.records.formatters.PropertySelector, kotlin.Any?, kotlin.Any?>");
            final Function2<? super RecordType, Object, ? extends Object> function2 = (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(nextAction, 2);
            final Function2<RecordType, Object, Object> action$expo_modules_core_release = PropertySelector.this.getAction$expo_modules_core_release();
            PropertySelector<RecordType, PropertyType> propertySelector = PropertySelector.this;
            if (action$expo_modules_core_release != null) {
                function2 = new Function2() { // from class: expo.modules.kotlin.records.formatters.PropertySelector$ActionBuilder$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PropertySelector.ActionBuilder.nextAction$lambda$0(action$expo_modules_core_release, function2, (Record) obj, obj2);
                    }
                };
            }
            propertySelector.setAction$expo_modules_core_release(function2);
            return nextBuilder;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object nextAction$lambda$0(Function2 function2, Function2 function3, Record record, Object obj) {
            Intrinsics.checkNotNullParameter(record, "record");
            Object objInvoke = function2.invoke(record, obj);
            if (objInvoke instanceof ValueOrSkip) {
                ValueOrSkip valueOrSkip = (ValueOrSkip) objInvoke;
                if (valueOrSkip instanceof ValueOrSkip.Value) {
                    return function3.invoke(record, ((ValueOrSkip.Value) objInvoke).getValue());
                }
                if (Intrinsics.areEqual(valueOrSkip, ValueOrSkip.Skip.INSTANCE)) {
                    return ValueOrSkip.Skip.INSTANCE;
                }
                throw new NoWhenBranchMatchedException();
            }
            return function3.invoke(record, objInvoke);
        }

        private final PropertySelector<RecordType, PropertyType>.ActionBuilder<InputType> defaultSkipAction(final Function2<? super RecordType, ? super InputType, Boolean> shouldSkip) {
            return (PropertySelector<RecordType, PropertyType>.ActionBuilder<InputType>) nextAction(PropertySelector.this.new ActionBuilder<>(), new Function2() { // from class: expo.modules.kotlin.records.formatters.PropertySelector$ActionBuilder$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PropertySelector.ActionBuilder.defaultSkipAction$lambda$1(shouldSkip, (Record) obj, obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ValueOrSkip defaultSkipAction$lambda$1(Function2 function2, Record record, Object obj) {
            Intrinsics.checkNotNullParameter(record, "record");
            if (((Boolean) function2.invoke(record, obj)).booleanValue()) {
                return ValueOrSkip.Skip.INSTANCE;
            }
            return new ValueOrSkip.Value(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object map$lambda$2(Function1 function1, Record record, Object obj) {
            Intrinsics.checkNotNullParameter(record, "<unused var>");
            return function1.invoke(obj);
        }

        public final <ResultType> PropertySelector<RecordType, PropertyType>.ActionBuilder<InputType> map(final Function1<? super InputType, ? extends ResultType> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return nextAction$default(this, null, new Function2() { // from class: expo.modules.kotlin.records.formatters.PropertySelector$ActionBuilder$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PropertySelector.ActionBuilder.map$lambda$2(mapper, (Record) obj, obj2);
                }
            }, 1, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object map$lambda$3(Function2 function2, Record record, Object obj) {
            Intrinsics.checkNotNullParameter(record, "record");
            return function2.invoke(record, obj);
        }

        public final <ResultType> PropertySelector<RecordType, PropertyType>.ActionBuilder<InputType> map(final Function2<? super RecordType, ? super InputType, ? extends ResultType> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            return nextAction$default(this, null, new Function2() { // from class: expo.modules.kotlin.records.formatters.PropertySelector$ActionBuilder$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PropertySelector.ActionBuilder.map$lambda$3(mapper, (Record) obj, obj2);
                }
            }, 1, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ActionBuilder skip$default(ActionBuilder actionBuilder, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: skip");
            }
            if ((i & 1) != 0) {
                function1 = new Function1() { // from class: expo.modules.kotlin.records.formatters.PropertySelector$ActionBuilder$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return Boolean.valueOf(PropertySelector.ActionBuilder.skip$lambda$4(obj2));
                    }
                };
            }
            return actionBuilder.skip(function1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean skip$lambda$5(Function1 function1, Record record, Object obj) {
            Intrinsics.checkNotNullParameter(record, "<unused var>");
            return ((Boolean) function1.invoke(obj)).booleanValue();
        }

        public final PropertySelector<RecordType, PropertyType>.ActionBuilder<InputType> skip(final Function1<? super InputType, Boolean> valueSelector) {
            Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
            return defaultSkipAction(new Function2() { // from class: expo.modules.kotlin.records.formatters.PropertySelector$ActionBuilder$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Boolean.valueOf(PropertySelector.ActionBuilder.skip$lambda$5(valueSelector, (Record) obj, obj2));
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean skip$lambda$6(ValueSelector valueSelector, Record record, Object obj) {
            Intrinsics.checkNotNullParameter(record, "<unused var>");
            return valueSelector.invoke(obj);
        }

        public final PropertySelector<RecordType, PropertyType>.ActionBuilder<InputType> skip(final ValueSelector<InputType> valueSelector) {
            Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
            return defaultSkipAction(new Function2() { // from class: expo.modules.kotlin.records.formatters.PropertySelector$ActionBuilder$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Boolean.valueOf(PropertySelector.ActionBuilder.skip$lambda$6(valueSelector, (Record) obj, obj2));
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean skip$lambda$7(Function2 function2, Record record, Object obj) {
            Intrinsics.checkNotNullParameter(record, "record");
            return ((Boolean) function2.invoke(record, obj)).booleanValue();
        }

        public final PropertySelector<RecordType, PropertyType>.ActionBuilder<InputType> skip(final Function2<? super RecordType, ? super InputType, Boolean> valueSelector) {
            Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
            return defaultSkipAction(new Function2() { // from class: expo.modules.kotlin.records.formatters.PropertySelector$ActionBuilder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Boolean.valueOf(PropertySelector.ActionBuilder.skip$lambda$7(valueSelector, (Record) obj, obj2));
                }
            });
        }
    }

    /* JADX INFO: compiled from: PropertySelector.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u0018\u0012\u0004\u0012\u0002H\u00010\u0003R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J*\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00028\u00020\u0003R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\tJ;\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00028\u00020\u0003R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lexpo/modules/kotlin/records/formatters/PropertySelector$ActionBuilderForRecord;", "InputType", "Lexpo/modules/kotlin/records/Record;", "Lexpo/modules/kotlin/records/formatters/PropertySelector$ActionBuilder;", "Lexpo/modules/kotlin/records/formatters/PropertySelector;", "<init>", "(Lexpo/modules/kotlin/records/formatters/PropertySelector;)V", "format", "formatter", "Lexpo/modules/kotlin/records/formatters/Formatter;", "builder", "Lkotlin/Function1;", "Lexpo/modules/kotlin/records/formatters/Formatter$Builder;", "", "Lkotlin/ExtensionFunctionType;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ActionBuilderForRecord<InputType extends Record> extends PropertySelector<RecordType, PropertyType>.ActionBuilder<InputType> {
        public ActionBuilderForRecord() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final FormattedRecord format$lambda$0(Formatter formatter, Record record) {
            Intrinsics.checkNotNullParameter(record, "record");
            return formatter.format(record);
        }

        public final PropertySelector<RecordType, PropertyType>.ActionBuilder<InputType> format(final Formatter<InputType> formatter) {
            Intrinsics.checkNotNullParameter(formatter, "formatter");
            return map(new Function1() { // from class: expo.modules.kotlin.records.formatters.PropertySelector$ActionBuilderForRecord$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PropertySelector.ActionBuilderForRecord.format$lambda$0(formatter, (Record) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final FormattedRecord format$lambda$1(Function1 function1, Record record) {
            Intrinsics.checkNotNullParameter(record, "record");
            return FormatterKt.formatter(function1).format(record);
        }

        public final PropertySelector<RecordType, PropertyType>.ActionBuilder<InputType> format(final Function1<? super Formatter.Builder<InputType>, Unit> builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            return map(new Function1() { // from class: expo.modules.kotlin.records.formatters.PropertySelector$ActionBuilderForRecord$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PropertySelector.ActionBuilderForRecord.format$lambda$1(builder, (Record) obj);
                }
            });
        }
    }
}
