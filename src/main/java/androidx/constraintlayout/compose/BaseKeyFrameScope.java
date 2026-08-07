package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLContainer;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLString;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: TransitionScope.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J3\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\n\b\u0000\u0010\u000b*\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u0002H\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0004¢\u0006\u0002\u0010\u000fJ-\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00110\n\"\u0004\b\u0000\u0010\u00112\u0006\u0010\r\u001a\u0002H\u00112\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0004¢\u0006\u0002\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u0017J \u0010\u0018\u001a\u00020\u0014*\u00020\u00162\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u001aH\u0002R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0001\u0004\u001b\u001c\u001d\u001e¨\u0006\u001f"}, d2 = {"Landroidx/constraintlayout/compose/BaseKeyFrameScope;", "", "()V", "customPropertiesValue", "", "", "getCustomPropertiesValue$constraintlayout_compose_release", "()Ljava/util/Map;", "keyFramePropertiesValue", "addNameOnPropertyChange", "Lkotlin/properties/ObservableProperty;", ExifInterface.LONGITUDE_EAST, "Landroidx/constraintlayout/compose/NamedPropertyOrValue;", "initialValue", "nameOverride", "(Landroidx/constraintlayout/compose/NamedPropertyOrValue;Ljava/lang/String;)Lkotlin/properties/ObservableProperty;", "addOnPropertyChange", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/Object;Ljava/lang/String;)Lkotlin/properties/ObservableProperty;", "addToContainer", "", TtmlNode.RUBY_CONTAINER, "Landroidx/constraintlayout/core/parser/CLContainer;", "addToContainer$constraintlayout_compose_release", "putValuesAsArrayElements", "propertiesSource", "", "Landroidx/constraintlayout/compose/FakeKeyFrameScope;", "Landroidx/constraintlayout/compose/KeyAttributeScope;", "Landroidx/constraintlayout/compose/KeyCycleScope;", "Landroidx/constraintlayout/compose/KeyPositionScope;", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BaseKeyFrameScope {
    public static final int $stable = 8;
    private final Map<String, Object> customPropertiesValue;
    private final Map<String, Object> keyFramePropertiesValue;

    public /* synthetic */ BaseKeyFrameScope(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private BaseKeyFrameScope() {
        this.keyFramePropertiesValue = new LinkedHashMap();
        this.customPropertiesValue = new LinkedHashMap();
    }

    public final Map<String, Object> getCustomPropertiesValue$constraintlayout_compose_release() {
        return this.customPropertiesValue;
    }

    public static /* synthetic */ ObservableProperty addOnPropertyChange$default(BaseKeyFrameScope baseKeyFrameScope, Object obj, String str, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addOnPropertyChange");
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return baseKeyFrameScope.addOnPropertyChange(obj, str);
    }

    protected final <T> ObservableProperty<T> addOnPropertyChange(T initialValue, final String nameOverride) {
        return new ObservableProperty<T>(initialValue) { // from class: androidx.constraintlayout.compose.BaseKeyFrameScope.addOnPropertyChange.1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, T oldValue, T newValue) {
                if (newValue != null) {
                    Map map = this.keyFramePropertiesValue;
                    String name = nameOverride;
                    if (name == null) {
                        name = property.getName();
                    }
                    map.put(name, newValue);
                    return;
                }
                Map map2 = this.keyFramePropertiesValue;
                String name2 = nameOverride;
                if (name2 == null) {
                    name2 = property.getName();
                }
                map2.remove(name2);
            }
        };
    }

    public static /* synthetic */ ObservableProperty addNameOnPropertyChange$default(BaseKeyFrameScope baseKeyFrameScope, NamedPropertyOrValue namedPropertyOrValue, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addNameOnPropertyChange");
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return baseKeyFrameScope.addNameOnPropertyChange(namedPropertyOrValue, str);
    }

    protected final <E extends NamedPropertyOrValue> ObservableProperty<E> addNameOnPropertyChange(E initialValue, final String nameOverride) {
        return (ObservableProperty) new ObservableProperty<E>(initialValue) { // from class: androidx.constraintlayout.compose.BaseKeyFrameScope.addNameOnPropertyChange.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Incorrect types in method signature: (Lkotlin/reflect/KProperty<*>;TE;TE;)V */
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty property, NamedPropertyOrValue oldValue, NamedPropertyOrValue newValue) {
                String name = nameOverride;
                if (name == null) {
                    name = property.getName();
                }
                if (newValue != null) {
                    this.keyFramePropertiesValue.put(name, newValue.getName());
                }
            }
        };
    }

    public final void addToContainer$constraintlayout_compose_release(CLContainer container) {
        putValuesAsArrayElements(container, this.keyFramePropertiesValue);
        CLObject objectOrNull = container.getObjectOrNull(SchedulerSupport.CUSTOM);
        if (objectOrNull == null) {
            objectOrNull = new CLObject(new char[0]);
            container.put(SchedulerSupport.CUSTOM, objectOrNull);
        }
        putValuesAsArrayElements(objectOrNull, this.customPropertiesValue);
    }

    private final void putValuesAsArrayElements(CLContainer cLContainer, Map<String, ? extends Object> map) {
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            CLArray arrayOrCreate = cLContainer.getArrayOrCreate(key);
            if (value instanceof String) {
                char[] charArray = ((String) value).toCharArray();
                Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
                CLString cLString = new CLString(charArray);
                cLString.setStart(0L);
                cLString.setEnd(((long) charArray.length) - 1);
                arrayOrCreate.add(cLString);
            } else if (value instanceof Dp) {
                arrayOrCreate.add(new CLNumber(((Dp) value).m9701unboximpl()));
            } else if (value instanceof Number) {
                arrayOrCreate.add(new CLNumber(((Number) value).floatValue()));
            }
        }
    }
}
