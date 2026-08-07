package expo.modules.localization;

import android.content.Context;
import android.content.SharedPreferences;
import android.icu.util.LocaleData;
import android.icu.util.ULocale;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
import androidx.core.os.LocaleListCompat;
import androidx.tracing.Trace;
import com.box.androidsdk.content.models.BoxClassification;
import com.box.rnBrownfield.R;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeProvider;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: LocalizationModule.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001e\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001c\u0010\u0013\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00110\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\rH\u0002J\u001c\u0010\u0018\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00110\u0014H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lexpo/modules/localization/LocalizationModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "observer", "Lkotlin/Function0;", "", BoxClassification.FIELD_DEFINITION, "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "setRTLFromStringResources", "context", "Landroid/content/Context;", "getMeasurementSystem", "", "locale", "Ljava/util/Locale;", "getCurrencyProperties", "", "", "getPreferredLocales", "", "uses24HourClock", "", "getCalendarType", "getCalendars", "expo-localization_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalizationModule extends Module {
    private Function0<Unit> observer = new Function0() { // from class: expo.modules.localization.LocalizationModule$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Unit.INSTANCE;
        }
    };

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        LocalizationModule localizationModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (localizationModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(localizationModule);
            moduleDefinitionBuilder.Name("ExpoLocalization");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[0];
            ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
            ReturnType returnType = returnTypeProvider.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
            if (returnType == null) {
                returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
                returnTypeProvider.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
            }
            moduleDefinitionBuilder2.getSyncFunctions().put("getLocales", new SyncFunctionComponent("getLocales", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.localization.LocalizationModule$definition$lambda$6$$inlined$FunctionWithoutArgs$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return this.this$0.getPreferredLocales();
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr2 = new AnyType[0];
            ReturnTypeProvider returnTypeProvider2 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType2 = returnTypeProvider2.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
            if (returnType2 == null) {
                returnType2 = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
                returnTypeProvider2.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType2);
            }
            moduleDefinitionBuilder3.getSyncFunctions().put("getCalendars", new SyncFunctionComponent("getCalendars", anyTypeArr2, returnType2, new Function1<Object[], Object>() { // from class: expo.modules.localization.LocalizationModule$definition$lambda$6$$inlined$FunctionWithoutArgs$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return this.this$0.getCalendars();
                }
            }));
            moduleDefinitionBuilder.Events("onLocaleSettingsChanged", "onCalendarSettingsChanged");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.localization.LocalizationModule$definition$lambda$6$$inlined$OnCreate$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Context reactContext = this.this$0.getAppContext().getReactContext();
                    if (reactContext != null) {
                        this.this$0.setRTLFromStringResources(reactContext);
                    }
                    LocalizationModule localizationModule2 = this.this$0;
                    final LocalizationModule localizationModule3 = this.this$0;
                    localizationModule2.observer = new Function0<Unit>() { // from class: expo.modules.localization.LocalizationModule$definition$1$3$2
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Module.sendEvent$default(localizationModule3, "onLocaleSettingsChanged", (Bundle) null, 2, (Object) null);
                            Module.sendEvent$default(localizationModule3, "onCalendarSettingsChanged", (Bundle) null, 2, (Object) null);
                        }
                    };
                    Notifier.INSTANCE.registerObserver(this.this$0.observer);
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.localization.LocalizationModule$definition$lambda$6$$inlined$OnDestroy$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Notifier.INSTANCE.deregisterObserver(this.this$0.observer);
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRTLFromStringResources(Context context) {
        Context reactContext = getAppContext().getReactContext();
        String string = reactContext != null ? reactContext.getString(R.string.ExpoLocalization_supportsRTL) : null;
        Context reactContext2 = getAppContext().getReactContext();
        String string2 = reactContext2 != null ? reactContext2.getString(R.string.ExpoLocalization_forcesRTL) : null;
        if (Intrinsics.areEqual(string2, TelemetryEventStrings.Value.TRUE)) {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.facebook.react.modules.i18nmanager.I18nUtil", 0).edit();
            editorEdit.putBoolean("RCTI18nUtil_allowRTL", true);
            editorEdit.putBoolean("RCTI18nUtil_forceRTL", true);
            editorEdit.apply();
            return;
        }
        if (Intrinsics.areEqual(string, TelemetryEventStrings.Value.TRUE) || Intrinsics.areEqual(string, "false")) {
            SharedPreferences.Editor editorEdit2 = context.getSharedPreferences("com.facebook.react.modules.i18nmanager.I18nUtil", 0).edit();
            editorEdit2.putBoolean("RCTI18nUtil_allowRTL", Intrinsics.areEqual(string, TelemetryEventStrings.Value.TRUE));
            if (Intrinsics.areEqual(string2, "false")) {
                editorEdit2.putBoolean("RCTI18nUtil_forceRTL", false);
            }
            editorEdit2.apply();
        }
    }

    private final String getMeasurementSystem(Locale locale) {
        LocaleData.MeasurementSystem measurementSystem = LocaleData.getMeasurementSystem(ULocale.forLocale(locale));
        if (Intrinsics.areEqual(measurementSystem, LocaleData.MeasurementSystem.SI)) {
            return "metric";
        }
        if (Intrinsics.areEqual(measurementSystem, LocaleData.MeasurementSystem.UK)) {
            return "uk";
        }
        return Intrinsics.areEqual(measurementSystem, LocaleData.MeasurementSystem.US) ? "us" : "metric";
    }

    private final Map<String, Object> getCurrencyProperties(Locale locale) {
        try {
            return MapsKt.mapOf(TuplesKt.to("currencyCode", Currency.getInstance(locale).getCurrencyCode()), TuplesKt.to("currencySymbol", Currency.getInstance(locale).getSymbol(locale)), TuplesKt.to("languageCurrencyCode", Currency.getInstance(locale).getCurrencyCode()), TuplesKt.to("languageCurrencySymbol", Currency.getInstance(locale).getSymbol(locale)));
        } catch (Exception unused) {
            return MapsKt.mapOf(TuplesKt.to("currencyCode", null), TuplesKt.to("currencySymbol", null), TuplesKt.to("languageCurrencyCode", null), TuplesKt.to("languageCurrencySymbol", null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Map<String, Object>> getPreferredLocales() {
        ArrayList arrayList = new ArrayList();
        LocaleListCompat localeListCompat = LocaleListCompat.getDefault();
        Intrinsics.checkNotNullExpressionValue(localeListCompat, "getDefault(...)");
        int size = localeListCompat.size();
        for (int i = 0; i < size; i++) {
            try {
                Locale locale = localeListCompat.get(i);
                if (locale != null) {
                    DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(locale);
                    Pair[] pairArr = new Pair[10];
                    pairArr[0] = TuplesKt.to("languageTag", locale.toLanguageTag());
                    pairArr[1] = TuplesKt.to("regionCode", LocalizationUtilsKt.getRegionCode(locale));
                    pairArr[2] = TuplesKt.to("languageRegionCode", LocalizationUtilsKt.getCountryCode(locale));
                    pairArr[3] = TuplesKt.to("textDirection", TextUtils.getLayoutDirectionFromLocale(locale) == 1 ? "rtl" : "ltr");
                    pairArr[4] = TuplesKt.to(RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE, locale.getLanguage());
                    String script = locale.getScript();
                    if (script.length() == 0) {
                        script = null;
                    }
                    pairArr[5] = TuplesKt.to("languageScriptCode", script);
                    pairArr[6] = TuplesKt.to("decimalSeparator", String.valueOf(decimalFormatSymbols.getDecimalSeparator()));
                    pairArr[7] = TuplesKt.to("digitGroupingSeparator", String.valueOf(decimalFormatSymbols.getGroupingSeparator()));
                    pairArr[8] = TuplesKt.to("measurementSystem", getMeasurementSystem(locale));
                    pairArr[9] = TuplesKt.to("temperatureUnit", LocalizationUtilsKt.getTemperatureUnit(locale));
                    arrayList.add(MapsKt.plus(MapsKt.mapOf(pairArr), getCurrencyProperties(locale)));
                }
            } catch (Exception e) {
                Log.w("expo-localization", "Failed to get locale for index " + i, e);
            }
        }
        return arrayList;
    }

    private final boolean uses24HourClock() {
        if (getAppContext().getReactContext() == null) {
            return false;
        }
        return DateFormat.is24HourFormat(getAppContext().getReactContext());
    }

    private final String getCalendarType() {
        return Calendar.getInstance().getCalendarType().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Map<String, Object>> getCalendars() {
        return CollectionsKt.listOf(MapsKt.mapOf(TuplesKt.to("calendar", getCalendarType()), TuplesKt.to("uses24hourClock", Boolean.valueOf(uses24HourClock())), TuplesKt.to("firstWeekday", Integer.valueOf(Calendar.getInstance().getFirstDayOfWeek())), TuplesKt.to(RemoteConfigConstants.RequestFieldKey.TIME_ZONE, Calendar.getInstance().getTimeZone().getID())));
    }
}
