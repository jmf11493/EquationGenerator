package com.mathymath.equationgenerator.Controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.mathymath.equationgenerator.Model.Selection.MainViewSelection;
import com.mathymath.equationgenerator.Model.UI.CardComponent;
import com.mathymath.equationgenerator.R;

import java.util.HashMap;
import java.util.Map;


public class MainViewController extends AppCompatActivity {

    Map<CardView, CardComponent> cardViewCardComponentMap = new HashMap<>();

    private LinearLayout linearLayout;

    private SearchView searchView;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        final MainViewSelection mainViewSelection = new MainViewSelection();

        // TODO hook up real ads
        final String admobtestid = "ca-app-pub-3940256099942544~3347511713";
        MobileAds.initialize(this, admobtestid );
        AdView adView = findViewById( R.id.adView );
        AdRequest request = new AdRequest.Builder().build();
        adView.loadAd( request );

        searchView = findViewById( R.id.searchView );
        linearLayout = findViewById( R.id.linear );

        searchView.setIconifiedByDefault( false );

        addCardLayouts( mainViewSelection );
        initializeSearchView();
    }

    private void initializeSearchView() {
        final MainViewController me = this;
        searchView.setOnQueryTextListener( new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit( String query ) {
                if ("".equals( query.trim() )) {
                    me.showAllCards();
                } else {
                    me.hideCards( query.trim() );
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange( String newText ) {
                if ("".equals( newText.trim() )) {
                    me.showAllCards();
                } else {
                    me.hideCards( newText.trim() );
                }
                return true;
            }
        } );
    }

    /**
     * Create a new card layout for each generator and add it to the view
     */
    private void addCardLayouts( MainViewSelection mainViewSelection ) {
        // For each item in the selection create a new card and add it to the view
        for ( CardComponent cardComponent : mainViewSelection.getCardComponents() ) {
            CardView card = createCardItem( cardComponent, getApplicationContext() );
            linearLayout.addView( card );
        }
    }

    private CardView createCardItem( CardComponent cardComponent, Context context) {
        final String generator = cardComponent.getName();

        CardView cardView = new CardView( context );

        // Add to map for easy card control
        cardViewCardComponentMap.put(cardView, cardComponent);

        // Style card view
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins( 8, 8, 8, 8 );

        cardView.setLayoutParams(layoutParams);
        cardView.setRadius( 15 );
        cardView.setContentPadding( 8, 8, 8, 8 );
        cardView.setPadding( 25, 25, 25, 25 );
        cardView.setMaxCardElevation(30);
        cardView.setCardElevation(6);

        // Add click listener
        cardView.setOnClickListener( new View.OnClickListener() {
            public void onClick( View v ) {
                Context context = getApplicationContext();

                Intent intent = new Intent( context, EquationViewController.class );
                intent.putExtra( "selection", generator );

                context.startActivity( intent );
            }
        } );

        LinearLayout linearLayout = new LinearLayout( context );
        linearLayout.setOrientation( LinearLayout.VERTICAL );

        TextView nameView = new TextView( context );
        nameView.setTextSize( 20 );
        nameView.setPadding( 4, 4, 4, 4 );

        TextView descriptionView = new TextView( context );
        descriptionView.setPadding( 4, 4, 4, 4 );

        nameView.setText( cardComponent.getName() );
        descriptionView.setText( cardComponent.getDescription() );

        linearLayout.addView( nameView );
        linearLayout.addView( descriptionView );

        cardView.addView( linearLayout );

        return cardView;
    }

    private void hideCards(String filter) {
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            CardView card = (CardView) linearLayout.getChildAt( i );

            CardComponent cardComponent = cardViewCardComponentMap.get(card);
            String[] keywords = cardComponent.getKeywords();

            String lcFilter = filter.toLowerCase();

            boolean matchKeyword = false;

            for ( String keyword : keywords ) {
                if ( keyword.trim().toLowerCase().contains( lcFilter )) {
                    matchKeyword = true;
                    break;
                }
            }

            if (!cardComponent.getName().toLowerCase().contains(lcFilter)
                    && !cardComponent.getDescription().toLowerCase().contains(lcFilter)
                    && !matchKeyword) {
                card.setVisibility( View.GONE );
            } else {
                card.setVisibility( View.VISIBLE );
            }
        }
    }

    private void hideCards(CardComponent.GradeLevel gradeLevel) {
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            CardView card = (CardView) linearLayout.getChildAt( i );

            CardComponent cardComponent = cardViewCardComponentMap.get(card);

            if (cardComponent.getGradeLevel() != gradeLevel) {
                card.setVisibility( View.GONE );
            } else {
                card.setVisibility( View.VISIBLE );
            }
        }
    }

    private void showAllCards() {
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            CardView card = (CardView) linearLayout.getChildAt( i );
            card.setVisibility( View.VISIBLE );
        }
    }
}
