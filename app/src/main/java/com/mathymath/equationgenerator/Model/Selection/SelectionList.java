package com.mathymath.equationgenerator.Model.Selection;

import com.mathymath.equationgenerator.Model.EquationType;

import java.util.LinkedHashMap;
import java.util.Set;

abstract public class SelectionList {

    public LinkedHashMap<String, EquationType> selectionMap;

    public abstract LinkedHashMap<String, EquationType> createMap();

    public LinkedHashMap<String, EquationType> getSelectionMap() {
        // TODO refactor
        if (selectionMap == null) {
            selectionMap = createMap();
        }

        return selectionMap;
    }

    public String[] getSelectionList() {
        if (selectionMap == null) {
            selectionMap = createMap();
        }

        Set<String> keySet = selectionMap.keySet();
        String[] keys = new String[keySet.size()];

        int index = 0;
        for (String key : keySet) {
            keys[index] = key;
            index++;
        }

        return keys;
    }

}
