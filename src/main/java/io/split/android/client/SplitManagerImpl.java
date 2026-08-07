package io.split.android.client;

import io.split.android.client.api.SplitView;
import io.split.android.client.dtos.Partition;
import io.split.android.client.dtos.Split;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import io.split.android.client.validators.SplitValidator;
import io.split.android.client.validators.ValidationErrorInfo;
import io.split.android.client.validators.ValidationMessageLogger;
import io.split.android.client.validators.ValidationMessageLoggerImpl;
import io.split.android.engine.experiments.ParsedCondition;
import io.split.android.engine.experiments.ParsedSplit;
import io.split.android.engine.experiments.SplitParser;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class SplitManagerImpl implements SplitManager {
    private final SplitParser _splitParser;
    private final SplitValidator _splitValidator;
    private final SplitsStorage _splitsStorage;
    private boolean _isManagerDestroyed = false;
    private final ValidationMessageLogger _validationMessageLogger = new ValidationMessageLoggerImpl();

    public SplitManagerImpl(SplitsStorage splitsStorage, SplitValidator splitValidator, SplitParser splitParser) {
        this._splitsStorage = (SplitsStorage) Utils.checkNotNull(splitsStorage);
        this._splitValidator = (SplitValidator) Utils.checkNotNull(splitValidator);
        this._splitParser = (SplitParser) Utils.checkNotNull(splitParser);
    }

    @Override // io.split.android.client.SplitManager
    public List<SplitView> splits() {
        ArrayList arrayList = new ArrayList();
        try {
            if (this._isManagerDestroyed) {
                Logger.e("Manager has already been destroyed - no calls possible");
                return arrayList;
            }
            Map<String, Split> all = this._splitsStorage.getAll();
            if (all != null && all.size() > 0) {
                Iterator<Split> it = this._splitsStorage.getAll().values().iterator();
                while (it.hasNext()) {
                    ParsedSplit parsedSplit = this._splitParser.parse(it.next());
                    if (parsedSplit != null) {
                        arrayList.add(toSplitView(parsedSplit));
                    }
                }
            }
            return arrayList;
        } catch (Exception e) {
            Logger.e("Error getting feature flags: " + e.getLocalizedMessage());
            return arrayList;
        }
    }

    @Override // io.split.android.client.SplitManager
    public SplitView split(String featureFlagName) {
        try {
            if (this._isManagerDestroyed) {
                Logger.e("Manager has already been destroyed - no calls possible");
                return null;
            }
            ValidationErrorInfo validationErrorInfoValidateName = this._splitValidator.validateName(featureFlagName);
            if (validationErrorInfoValidateName != null) {
                this._validationMessageLogger.log(validationErrorInfoValidateName, "split");
                if (validationErrorInfoValidateName.isError()) {
                    return null;
                }
                featureFlagName = featureFlagName.trim();
            }
            Split split = this._splitsStorage.get(featureFlagName);
            ParsedSplit parsedSplit = split != null ? this._splitParser.parse(split) : null;
            if (parsedSplit == null) {
                this._validationMessageLogger.w(this._splitValidator.splitNotFoundMessage(featureFlagName), "split");
                return null;
            }
            return toSplitView(parsedSplit);
        } catch (Exception e) {
            Logger.e("Error getting split: " + e.getLocalizedMessage());
            return null;
        }
    }

    @Override // io.split.android.client.SplitManager
    public List<String> splitNames() {
        ArrayList arrayList = new ArrayList();
        try {
            if (this._isManagerDestroyed) {
                Logger.e("Manager has already been destroyed - no calls possible");
                return arrayList;
            }
            Map<String, Split> all = this._splitsStorage.getAll();
            if (all != null && all.size() > 0) {
                Iterator<Split> it = all.values().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().name);
                }
            }
            return arrayList;
        } catch (Exception e) {
            Logger.e("Error getting feature flags: " + e.getLocalizedMessage());
            return arrayList;
        }
    }

    @Override // io.split.android.client.SplitManager
    public void destroy() {
        this._isManagerDestroyed = true;
    }

    private SplitView toSplitView(ParsedSplit parsedSplit) {
        SplitView splitView = new SplitView();
        splitView.name = parsedSplit.feature();
        splitView.trafficType = parsedSplit.trafficTypeName();
        splitView.killed = parsedSplit.killed();
        splitView.changeNumber = parsedSplit.changeNumber();
        splitView.configs = parsedSplit.configurations();
        splitView.sets = new ArrayList(parsedSplit.sets() == null ? new HashSet<>() : parsedSplit.sets());
        splitView.defaultTreatment = parsedSplit.defaultTreatment();
        splitView.impressionsDisabled = parsedSplit.impressionsDisabled();
        splitView.prerequisites = parsedSplit.prerequisites();
        HashSet hashSet = new HashSet();
        Iterator<ParsedCondition> it = parsedSplit.parsedConditions().iterator();
        while (it.hasNext()) {
            Iterator<Partition> it2 = it.next().partitions().iterator();
            while (it2.hasNext()) {
                hashSet.add(it2.next().treatment);
            }
        }
        hashSet.add(parsedSplit.defaultTreatment());
        splitView.treatments = new ArrayList(hashSet);
        return splitView;
    }
}
