package com.mathymath.equationgenerator.Controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.mathymath.equationgenerator.Model.EquationType;
import com.mathymath.equationgenerator.Model.Generator;
import com.mathymath.equationgenerator.Model.GeneratorFactory;
import com.mathymath.equationgenerator.Model.Selection.MainViewSelection;
import com.mathymath.equationgenerator.Model.Selection.SelectionList;
import com.mathymath.equationgenerator.R;

import java.util.Map;

import io.github.kexanie.library.MathView;

public class EquationViewController extends AppCompatActivity {

    private final String EQUATION = "equation";

    private final String ANSWER = "answer";

    private final String mathViewConfig = "MathJax.Hub.Config({\n" +
            "  CommonHTML: { linebreaks: { automatic: true } },\n" +
            "  \"HTML-CSS\": { linebreaks: { automatic: true } },\n" +
            "         SVG: { linebreaks: { automatic: true } }\n" +
            "});";

    private Toolbar toolbar;

    private Spinner secondarySpinner;
    private TextView secondarySpinnerLabel;

    private Spinner equationType;
    private TextView problemType;

    private Switch switchButton;
    private Button generateEquation;

    private MathView equationView;
    private Switch showAnswer;
    private MathView answerView;

    private Generator generator;
    private SelectionList selectionList;


    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.equation_view );

        // TODO hook up real ads
        final String admobtestid = "ca-app-pub-3940256099942544~3347511713";
        MobileAds.initialize(this, admobtestid );
        AdView adView = findViewById( R.id.adView2 );
        AdRequest request = new AdRequest.Builder().build();
        adView.loadAd( request );

        // Set the UI components
        initializeUI();

        // Configure Secondary Spinner
        configureSecondarySpinner( generator, secondarySpinnerLabel, secondarySpinner );

        // Configure Dropdown and Switch
        configureSpinner( selectionList, equationType );
        configureSwitch( generator, switchButton );

        // Configure MathViews
        MathView[] mathViews = { equationView, answerView };
        configureMathView( mathViews );

        // Set the default visibility
        answerVisibility( showAnswer.isChecked(), answerView );

        // Set up listeners
        setGenerateEquationListener();
        setShowAnswerListener();

        // Load saved state
        if ( savedInstanceState != null ) {
            equationView.setText( savedInstanceState.getString( EQUATION ) );
            answerView.setText( savedInstanceState.getString( ANSWER ) );
        }
    }

    @Override
    protected void onSaveInstanceState( Bundle state ) {
        super.onSaveInstanceState( state );

        String equation = equationView.getText();
        String answer = answerView.getText();

        state.putString( EQUATION, equation );
        state.putString( ANSWER, answer );
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void initializeUI() {
        // Optional Components
        secondarySpinner = findViewById( R.id.secondarySpinner );
        secondarySpinnerLabel = findViewById( R.id.secondarySpinnerLabel );
        switchButton = findViewById( R.id.switchButton );

        toolbar = findViewById( R.id.toolbar );
        equationType = findViewById( R.id.equationType );
        problemType = findViewById( R.id.problemTypeLabel );
        showAnswer = findViewById( R.id.showAnswer );
        equationView = findViewById( R.id.equationView );
        answerView = findViewById( R.id.answerView );
        generateEquation = findViewById( R.id.generateEquation );

        String selection = getIntent().getExtras().getString( "selection" );
        MainViewSelection mainViewSelection = new MainViewSelection();

        MainViewSelection.Equation equationType = ( MainViewSelection.Equation ) mainViewSelection.getSelectionMap().get( selection );

        toolbar.setTitle( selection );
        setSupportActionBar( toolbar );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        getSupportActionBar().setDisplayShowHomeEnabled( true );

        generator = GeneratorFactory.getGenerator( equationType );
        selectionList = generator.getSelectionList();
    }

    private void configureMathView( MathView[] views ) {
        for ( MathView mathView : views ) {
            mathView.config( mathViewConfig );
        }
    }

    private void configureSpinner( SelectionList selection, Spinner spinner ) {
        ArrayAdapter< String > spinnerArray = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, selection.getSelectionList()
        );

        spinnerArray.setDropDownViewResource( R.layout.spinner_layout );
        spinner.setAdapter( spinnerArray );
    }

    private void configureSwitch( Generator generator, Switch switchButton ) {
        if ( !generator.hasSwitch() ) {
            switchButton.setVisibility( View.GONE );
        } else {
            switchButton.setText( generator.getSwitchLabel() );
        }
    }

    private void configureSecondarySpinner( Generator generator,
                                            TextView secondarySpinnerLabel,
                                            Spinner secondarySpinner ) {
        if ( !generator.hasSecondarySpinner() ) {
            secondarySpinner.setVisibility( View.GONE );
            secondarySpinnerLabel.setVisibility( View.GONE );
        } else {
            ArrayAdapter< String > spinnerArray = new ArrayAdapter<>(
                    this, android.R.layout.simple_spinner_item, generator.getSecondarySpinnerList()
            );

            spinnerArray.setDropDownViewResource( R.layout.spinner_layout );
            secondarySpinner.setAdapter( spinnerArray );
            secondarySpinnerLabel.setText( generator.getSecondarySpinnerLabel() );
        }
    }

    private void answerVisibility( boolean checked, MathView answerView ) {
        if ( checked ) {
            answerView.setVisibility( TextView.VISIBLE );
        } else {
            answerView.setVisibility( TextView.GONE );
        }
    }

    private void setGenerateEquationListener() {
        generateEquation.setOnClickListener( new View.OnClickListener() {
            public void onClick( View v ) {
                String selectedType = equationType.getSelectedItem().toString();
                Map< String, EquationType > map = selectionList.getSelectionMap();

                generator.setType( map.get( selectedType ) );

                if ( generator.hasSwitch() ) {
                    boolean checked = switchButton.isChecked();
                    generator.switchListener( checked );
                }

                if ( generator.hasSecondarySpinner() ) {
                    String secondarySelectedItem = secondarySpinner.getSelectedItem().toString();
                    Map< String, EquationType > spinnerMap = generator.getSpinnerMap();
                    generator.secondarySpinnerListener( spinnerMap.get( secondarySelectedItem ) );
                }

                generator.generate();
                String equation = generator.getEquation();
                String answer = generator.getAnswer();

                equationView.setText( equation );
                answerView.setText( answer );
            }
        } );
    }

    private void setShowAnswerListener() {
        showAnswer.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged( CompoundButton buttonView, boolean isChecked ) {
                answerVisibility( isChecked, answerView );
            }
        } );
    }
}
