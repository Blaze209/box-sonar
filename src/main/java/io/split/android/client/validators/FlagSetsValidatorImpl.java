package io.split.android.client.validators;

import io.split.android.client.FlagSetsFilter;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes4.dex */
public class FlagSetsValidatorImpl implements SplitFilterValidator {
    private static final String FLAG_SET_REGEX = "^[a-z0-9][_a-z0-9]{0,49}$";

    @Override // io.split.android.client.validators.SplitFilterValidator
    public SplitFilterValidator.ValidationResult cleanup(String method, List<String> values) {
        int i = 0;
        if (values == null || values.isEmpty()) {
            return new SplitFilterValidator.ValidationResult(Collections.emptyList(), 0);
        }
        TreeSet treeSet = new TreeSet();
        Iterator<String> it = values.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null && !next.isEmpty()) {
                if (next.trim().length() != next.length()) {
                    Logger.w(method + ": Flag Set name " + next + " has extra whitespace, trimming");
                    next = next.trim();
                }
                if (!next.toLowerCase().equals(next)) {
                    Logger.w(method + ": Flag Set name " + next + " should be all lowercase - converting string to lowercase");
                    next = next.toLowerCase();
                }
                if (next.matches(FLAG_SET_REGEX)) {
                    if (!treeSet.add(next)) {
                        Logger.w(method + ": you passed duplicated Flag Set. " + next + " was deduplicated");
                    }
                } else {
                    i++;
                    Logger.w(method + ": you passed " + next + ", Flag Set must adhere to the regular expressions ^[a-z0-9][_a-z0-9]{0,49}$. This means a Flag Set must be start with a letter, be in lowercase, alphanumeric and have a max length of 50 characters. " + next + " was discarded.");
                }
            }
            i++;
        }
        return new SplitFilterValidator.ValidationResult(new ArrayList(treeSet), i);
    }

    @Override // io.split.android.client.validators.SplitFilterValidator
    public boolean isValid(String value) {
        return value != null && value.trim().matches(FLAG_SET_REGEX);
    }

    @Override // io.split.android.client.validators.SplitFilterValidator
    public Set<String> items(String method, List<String> values, FlagSetsFilter flagSetsFilter) {
        HashSet hashSet = new HashSet();
        if (values != null && !values.isEmpty()) {
            Iterator<String> it = values.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next.trim().length() != next.length()) {
                    Logger.w(method + ": Flag Set name " + next + " has extra whitespace, trimming");
                    next = next.trim();
                }
                if (!next.toLowerCase().equals(next)) {
                    Logger.w(method + ": Flag Set name " + next + " should be all lowercase - converting string to lowercase");
                    next = next.toLowerCase();
                }
                if (!isValid(next)) {
                    Logger.w(method + ": you passed " + next + ", Flag Set must adhere to the regular expressions ^[a-z0-9][_a-z0-9]{0,49}$. This means a Flag Set must be start with a letter, be in lowercase, alphanumeric and have a max length of 50 characters. " + next + " was discarded.");
                } else if (flagSetsFilter != null && !flagSetsFilter.intersect(next)) {
                    Logger.w(method + ": you passed Flag Set: " + next + " and is not part of the configured Flag set list, ignoring the request.");
                } else {
                    hashSet.add(next);
                }
            }
        }
        return hashSet;
    }
}
