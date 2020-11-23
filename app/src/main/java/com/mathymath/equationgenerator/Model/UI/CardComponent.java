package com.mathymath.equationgenerator.Model.UI;

import com.mathymath.equationgenerator.Model.Selection.MainViewSelection;

public class CardComponent {

    private String name;

    private String description;

    private GradeLevel gradeLevel;

    private String[] keywords;

    MainViewSelection.Equation type;


    public enum GradeLevel {
        GRADE_6,
        GRADE_7,
        GRADE_8
    }

    public CardComponent( String name, String description, String keywords, MainViewSelection.Equation type ) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.keywords = keywords.split( "," );
    }

    public CardComponent( String name, String description, MainViewSelection.Equation type, GradeLevel gradeLevel ) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.gradeLevel = gradeLevel;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public MainViewSelection.Equation getType() {
        return type;
    }

    public void setType( MainViewSelection.Equation type ) {
        this.type = type;
    }

    public GradeLevel getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel( GradeLevel gradeLevel ) {
        this.gradeLevel = gradeLevel;
    }

    public String[] getKeywords() {
        return keywords;
    }
}
