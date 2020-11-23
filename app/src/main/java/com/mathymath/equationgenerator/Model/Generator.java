package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.SelectionList;
import com.mathymath.equationgenerator.Util.Util;

import java.io.Serializable;
import java.util.Map;

abstract public class Generator implements EquationType {

    protected Util util;

    protected String equation = "";

    protected String answer = "";

    protected EquationType type;

    protected SelectionList selectionList;

    public Generator() {
        this.util = new Util();
    }

    abstract public String getEquation();

    abstract public String getAnswer();

    abstract public void generate();

    public void setType(EquationType type) {
        this.type = type;
    }

    public boolean hasSwitch() {
        return false;
    }

    public String getSwitchLabel() {
        return "";
    }

    public void switchListener(boolean checked) {
        // Do nothing
    }

    public String getSecondarySpinnerLabel() {
        return "";
    }

    public String[] getSecondarySpinnerList() {
        return null;
    }

    public boolean hasSecondarySpinner() {
        return false;
    }

    public void secondarySpinnerListener(EquationType selection) {
        // Do nothing
    }

    public Map<String, EquationType> getSpinnerMap() {
        return null;
    }

    public SelectionList getSelectionList() {
        return selectionList;
    }
}
