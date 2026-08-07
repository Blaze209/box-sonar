package expo.modules.kotlin.views;

import android.view.View;
import androidx.compose.runtime.MutableState;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.bridge.Dynamic;
import expo.modules.core.logging.Logger;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.CoreLoggerKt;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.PropSetException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.types.AnyType;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.full.KClasses;

/* JADX INFO: compiled from: ComposeViewProp.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u0019\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0016¨\u0006\u0017"}, d2 = {"Lexpo/modules/kotlin/views/ComposeViewProp;", "Lexpo/modules/kotlin/views/AnyViewProp;", "name", "", "anyType", "Lexpo/modules/kotlin/types/AnyType;", "property", "Lkotlin/reflect/KProperty1;", "<init>", "(Ljava/lang/String;Lexpo/modules/kotlin/types/AnyType;Lkotlin/reflect/KProperty1;)V", "getProperty", "()Lkotlin/reflect/KProperty1;", "set", "", "prop", "Lcom/facebook/react/bridge/Dynamic;", "onView", "Landroid/view/View;", "appContext", "Lexpo/modules/kotlin/AppContext;", "isNullable", "", "()Z", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ComposeViewProp extends AnyViewProp {
    public static final int $stable = 8;
    private final boolean isNullable;
    private final KProperty1<?, ?> property;

    public final KProperty1<?, ?> getProperty() {
        return this.property;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposeViewProp(String name, AnyType anyType, KProperty1<?, ?> property) {
        super(name, anyType);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(anyType, "anyType");
        Intrinsics.checkNotNullParameter(property, "property");
        this.property = property;
        this.isNullable = anyType.getKType().getIsMarkedNullable();
    }

    @Override // expo.modules.kotlin.views.AnyViewProp
    public void set(Dynamic prop, View onView, AppContext appContext) throws PropSetException {
        UnexpectedException unexpectedException;
        Object next;
        Intrinsics.checkNotNullParameter(prop, "prop");
        Intrinsics.checkNotNullParameter(onView, "onView");
        try {
            ComposeProps props = ((ExpoComposeView) onView).getProps();
            if (props != null) {
                Object obj = null;
                if (onView instanceof ComposeFunctionHolder) {
                    ComposeProps composeProps = (ComposeProps) ((ComposeFunctionHolder) onView).getPropsMutableState().getValue();
                    Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(composeProps.getClass())).iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!Intrinsics.areEqual(((KFunction) next).getName(), BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB));
                    KFunction kFunction = (KFunction) next;
                    if (kFunction == null) {
                        Logger.warn$default(CoreLoggerKt.getLogger(), "⚠️ Props are not a data class with default values for all properties, cannot set prop " + getName() + " dynamically.", null, 2, null);
                    } else {
                        KParameter instanceParameter = KCallables.getInstanceParameter(kFunction);
                        Intrinsics.checkNotNull(instanceParameter);
                        for (Object obj2 : kFunction.getParameters()) {
                            if (Intrinsics.areEqual(((KParameter) obj2).getName(), getName())) {
                                obj = obj2;
                                break;
                            }
                        }
                        KParameter kParameter = (KParameter) obj;
                        if (kParameter != null) {
                            R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, composeProps), TuplesKt.to(kParameter, AnyType.convert$default(getType(), prop, appContext, false, 4, null))));
                            MutableState propsMutableState = ((ComposeFunctionHolder) onView).getPropsMutableState();
                            Intrinsics.checkNotNull(propsMutableState, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<kotlin.Any?>");
                            propsMutableState.setValue(rCallBy);
                        }
                    }
                } else {
                    Object objCall = getProperty().getGetter().call(props);
                    if (objCall instanceof MutableState) {
                        ((MutableState) objCall).setValue(AnyType.convert$default(getType(), prop, appContext, false, 4, null));
                    } else {
                        Logger.warn$default(CoreLoggerKt.getLogger(), "⚠️ Property " + getName() + " is not a MutableState in " + onView.getClass(), null, 2, null);
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        } catch (Throwable th) {
            if (th instanceof CodedException) {
                unexpectedException = (CodedException) th;
            } else if (th instanceof expo.modules.core.errors.CodedException) {
                expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) th;
                String code = codedException.getCode();
                Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                unexpectedException = new CodedException(code, codedException.getMessage(), codedException.getCause());
            } else {
                unexpectedException = new UnexpectedException(th);
            }
            throw new PropSetException(getName(), Reflection.getOrCreateKotlinClass(onView.getClass()), unexpectedException);
        }
    }

    @Override // expo.modules.kotlin.views.AnyViewProp
    /* JADX INFO: renamed from: isNullable, reason: from getter */
    public boolean getIsNullable() {
        return this.isNullable;
    }
}
