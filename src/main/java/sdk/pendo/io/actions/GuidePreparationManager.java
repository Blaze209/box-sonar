package sdk.pendo.io.actions;

import android.graphics.Point;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.j4.a;
import sdk.pendo.io.listeners.glide.GlideListener;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.q3.e;
import sdk.pendo.io.q3.j;
import sdk.pendo.io.t6.c;
import sdk.pendo.io.utilities.AndroidUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class GuidePreparationManager implements GuidePreparationManagerInterface {
    private static final int BUFFER_TIMEOUT = 25;
    public static final String COMMAND_ACTION_DESTINATION = "InsertPreparationManager";
    private static final String FAIL_PARAMETER_VALUE = "false";
    private static final String SUCCESS_PARAMETER_VALUE = "true";
    private static volatile GuidePreparationManager sInstance;
    private static final Object LOCK = new Object();
    private static final Object IMAGES_LOADED_LOCK = new Object();
    private static final Object IMAGES_SET_LOCK = new Object();
    private static final Map<String, Boolean> sHasImages = new HashMap();
    private static final Map<String, a<Boolean>> sImagesLoaded = new HashMap();
    private static final Map<String, a<Boolean>> sImagesSet = new HashMap();

    private GuidePreparationManager() {
    }

    public static GuidePreparationManagerInterface getInstance() {
        GuidePreparationManager guidePreparationManager;
        GuidePreparationManager guidePreparationManager2 = sInstance;
        if (guidePreparationManager2 != null) {
            return guidePreparationManager2;
        }
        synchronized (LOCK) {
            guidePreparationManager = sInstance;
            if (guidePreparationManager == null) {
                guidePreparationManager = new GuidePreparationManager();
                sInstance = guidePreparationManager;
            }
        }
        return guidePreparationManager;
    }

    private void subscribeToEndOfImageFetching(final String str, int i) {
        PendoCommandsEventBus.getInstance().getCommandEventBus().a(new PendoCommand.Builder(PendoCommandAction.PendoInternalAction.PREFETCH_IMAGES, PendoCommandEventType.PendoPreparationEventType.PREFETCH_IMAGES_END).setDestinationId(COMMAND_ACTION_DESTINATION).setSourceId(str).build().getFilter()).a(new j<PendoCommand>() { // from class: sdk.pendo.io.actions.GuidePreparationManager.1
            @Override // sdk.pendo.io.q3.j
            public boolean test(PendoCommand pendoCommand) {
                List<PendoCommandsEventBus.Parameter> parameters = pendoCommand.getParameters();
                if (parameters != null) {
                    for (PendoCommandsEventBus.Parameter parameter : parameters) {
                        if (parameter.getParameterValue().contains("false")) {
                            return false;
                        }
                        if (parameter.getParameterValue().contains("true")) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }).a(i).b(25L, TimeUnit.SECONDS).b().a(c.a(new e<Object>() { // from class: sdk.pendo.io.actions.GuidePreparationManager.2
            @Override // sdk.pendo.io.q3.e
            public void accept(Object obj) {
                GuidePreparationManager.this.setImagesLoaded(str, Boolean.TRUE);
            }
        }, "GuidePreparationManager subscribe to end of image fetching observer"));
    }

    private void subscribeToEndOfImageSetting(final String str, int i) {
        PendoCommandsEventBus.getInstance().getCommandEventBus().a(new PendoCommand.Builder(PendoCommandAction.PendoInternalAction.IMAGES_SET, PendoCommandEventType.PendoPreparationEventType.PREFETCH_IMAGES_END).setDestinationId(COMMAND_ACTION_DESTINATION).setSourceId(str).build().getFilter()).a(i).b().a(c.a(new e<Object>() { // from class: sdk.pendo.io.actions.GuidePreparationManager.3
            @Override // sdk.pendo.io.q3.e
            public void accept(Object obj) {
                GuidePreparationManager.this.setImagesSet(str, Boolean.TRUE);
            }
        }, "GuidePreparationManager subscribe to end of image setting observer"));
    }

    @Override // sdk.pendo.io.actions.GuidePreparationManagerInterface
    public void fetchImages(String str, List<String> list) {
        try {
            Point pointH = AndroidUtils.h();
            GlideListener glideListener = new GlideListener(str, list, PendoCommandAction.PendoInternalAction.PREFETCH_IMAGES);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                external.sdk.pendo.io.glide.a.d(PendoInternal.o()).m14710load(it.next()).override(pointH.x, pointH.y).listener(glideListener).submit();
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            if (list != null) {
                Iterator<String> it2 = list.iterator();
                while (it2.hasNext()) {
                    sb.append(it2.next()).append("\n");
                }
            }
            PendoLogger.e(e, e.getMessage(), "GuideStepId: " + str + " images: " + sb.toString());
        }
    }

    @Override // sdk.pendo.io.actions.GuidePreparationManagerInterface
    public boolean getHasImages(String str) {
        Boolean bool;
        return (str == null || (bool = sHasImages.get(str)) == null || !bool.booleanValue()) ? false : true;
    }

    @Override // sdk.pendo.io.actions.GuidePreparationManagerInterface
    public sdk.pendo.io.k3.j<Boolean> getImagesLoadedAsObservable(String str) {
        a<Boolean> aVar;
        synchronized (IMAGES_LOADED_LOCK) {
            Map<String, a<Boolean>> map = sImagesLoaded;
            if (!map.containsKey(str)) {
                map.put(str, a.b(Boolean.FALSE));
            }
            aVar = map.get(str);
        }
        return aVar;
    }

    @Override // sdk.pendo.io.actions.GuidePreparationManagerInterface
    public void prepareGuideImages(int i, String str) {
        if (i <= 0) {
            setHasImages(str, false);
            setImagesSet(str, Boolean.TRUE);
        } else {
            if (!sHasImages.containsKey(str)) {
                setHasImages(str, true);
            }
            subscribeToEndOfImageFetching(str, i);
            subscribeToEndOfImageSetting(str, i);
        }
    }

    public void setHasImages(String str, boolean z) {
        sHasImages.put(str, Boolean.valueOf(z));
    }

    public void setImagesLoaded(String str, Boolean bool) {
        synchronized (IMAGES_LOADED_LOCK) {
            Map<String, a<Boolean>> map = sImagesLoaded;
            if (!map.containsKey(str)) {
                map.put(str, a.b(Boolean.FALSE));
            }
            a<Boolean> aVar = map.get(str);
            if (aVar != null) {
                aVar.onNext(bool);
            }
        }
    }

    public void setImagesSet(String str, Boolean bool) {
        synchronized (IMAGES_SET_LOCK) {
            Map<String, a<Boolean>> map = sImagesSet;
            if (!map.containsKey(str)) {
                map.put(str, a.b(Boolean.FALSE));
            }
            a<Boolean> aVar = map.get(str);
            if (aVar != null) {
                aVar.onNext(bool);
            }
        }
    }
}
