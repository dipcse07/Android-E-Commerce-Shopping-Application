package com.example.weshopapplication;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

// Author of Application: Sabin Constantin Lungu
// Purpose of Application: Displays the clothing category products.
// Date of Last Modification: 02/03/2020
// Any Errors? None Yet.

public class ClothingCategory extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private int current_product_id = 1;

    private TextView clothingFirstProductTxt;
    private ImageView clothingFirstProductImg;
    private TextView clothingFirstProductCostLbl;

    private TextView clothingFirstProductColourLbl;
    private Spinner clothingFirstProductColourMenu;

    private TextView clothingFirstProductSizeLbl; // The size label of the first clothing product.
    private Spinner clothingFirstProductSizeMenu; // The size menu of the clothing activity.

    private TextView clothingFirstProductQuantityLbl;
    private Spinner clothingFirstProductQuantityMenu;

    private Button clothingFirstProductAddToBasketBtn;

    private TextView clothingSecondProductTxt;
    private ImageView clothingSecondProductImg;
    private TextView clothingSecondProductCostLbl;

    private TextView clothingSecondProductColourLbl;
    private Spinner clothingSecondProductColourMenu;

    private TextView clothingSecondProductSizeLbl;
    private Spinner clothingSecondProductSizeMenu;

    private TextView clothingSecondProductQuantityLbl;
    private Spinner clothingSecondProductQuantityMenu;

    private Button clothingSecondProductAddToBasketBtn;

    private double[] clothingProductOneCosts = new double[]{0.00, 25.00, 50.00, 150.00, 450.00, 1350.00};
    private double[] clothingProductTwoCosts = new double[]{0.00, 30.00, 60.00, 120.00, 240.00, 480.00};

    private CustomArrayAdapter quantitiesAdapter;
    private ColourArrayAdapter coloursAdapter;
    private SizeArrayAdapter sizeArrayAdapter;

    private ArrayList<TechActivity.Colours> listOfClothingColoursOne = null;
    private ArrayList<Size> listOfClothingSizesOne = null;
    private ArrayList<TechActivity.Quantities> listOfClothingQuantitiesOne = null;

    private ArrayList<TechActivity.Colours> listOfClothingColoursTwo = null;
    private ArrayList<Size> listOfClothingSizesTwo = null;
    private ArrayList<TechActivity.Quantities> listOfClothingQuantitiesTwo = null;

    private ImageView cartIcon;
    private Button nextPageBtn;
    private HashMap<Integer, Products> listOfProductsToAddToBasket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing_category);

        this.clothingFirstProductTxt = findViewById(R.id.clothingFirstProductTxt);
        this.clothingFirstProductImg = findViewById(R.id.clothingFirstProductImg);
        this.clothingFirstProductCostLbl = findViewById(R.id.clothingFirstProductCostLbl);

        this.clothingFirstProductColourLbl = findViewById(R.id.clothingFirstProductColourLbl);
        this.clothingFirstProductColourMenu = findViewById(R.id.clothingFirstProductColourMenu);

        this.clothingFirstProductSizeLbl = findViewById(R.id.clothingFirstProductSizeLbl);
        this.clothingFirstProductSizeMenu = findViewById(R.id.clothingFirstProductSizeMenu);

        this.clothingFirstProductQuantityLbl = findViewById(R.id.clothingFirstProductQuantityLbl);
        this.clothingFirstProductQuantityMenu = findViewById(R.id.clothingFirstProductQuantityMenu);

        this.clothingSecondProductTxt = findViewById(R.id.clothingSecondProductTxt);
        this.clothingSecondProductImg = findViewById(R.id.clothingSecondProductImg);

        this.clothingSecondProductColourLbl = findViewById(R.id.clothingSecondProductColourLbl);
        this.clothingSecondProductColourMenu = findViewById(R.id.clothingSecondProductColourMenu);

        this.clothingSecondProductSizeLbl = findViewById(R.id.clothingSecondProductSizeLbl);
        this.clothingSecondProductSizeMenu = findViewById(R.id.clothingSecondProductSizeMenu);

        this.clothingSecondProductQuantityLbl = findViewById(R.id.clothingSecondProductQuantityLbl);
        this.clothingSecondProductQuantityMenu = findViewById(R.id.clothingSecondProductQuantityMenu);

        this.clothingSecondProductAddToBasketBtn = findViewById(R.id.clothingSecondProductAddToBasketBtn);

        this.listOfClothingColoursOne = new ArrayList<>();
        this.listOfClothingSizesOne = new ArrayList<>();
        this.listOfClothingQuantitiesOne = new ArrayList<>();

        this.listOfClothingColoursTwo = new ArrayList<>();
        this.listOfClothingSizesTwo = new ArrayList<>();
        this.listOfClothingQuantitiesTwo = new ArrayList<>();

        addToColoursList();
        addToSizesList();
        addToQuantitiesList();

        // Set-up Adapters.
        this.coloursAdapter = new ColourArrayAdapter(ClothingCategory.this, listOfClothingColoursOne);
        coloursAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        clothingFirstProductColourMenu.setAdapter(coloursAdapter);
        clothingFirstProductColourMenu.setOnItemSelectedListener(ClothingCategory.this);

        this.nextPageBtn = findViewById(R.id.clothingNextPageBtn);

        this.nextPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                try {
                    Intent intent = new Intent(ClothingCategory.this, ClothingActivityTwo.class);
                    startActivity(intent);

                } catch (ActivityNotFoundException exc) {
                    Log.d(String.valueOf(R.string.error), exc.toString());
                }
            }
        });
    }

    private boolean addToColoursList() {

        return true;
    }

    private boolean addToSizesList() {
        return true;
    }

    private boolean addToQuantitiesList() {
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // Add the toolbar menu
        // Inflate the activities menu
        MenuInflater activityInflater = getMenuInflater(); // Get the activity inflater
        activityInflater.inflate(R.menu.homepagemenu, menu);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.basket_action_button, menu);

        View view = menu.findItem(R.id.cart_menu).getActionView();

        cartIcon = view.findViewById(R.id.cart_icon);

        cartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent basketIntent = new Intent(ClothingCategory.this, BasketActivity.class); // Create a basket intent
                basketIntent.putExtra("map", listOfProductsToAddToBasket); // Transit over the hash map data to the basket
                startActivity(basketIntent); // Start the intent
            }
        });

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        try {
            switch (item.getItemId()) {
                case R.id.sportsAndOutdoorsCategory:
                    Intent sportsCategory = new Intent(ClothingCategory.this, SportsAndOutdoorsActivity.class);
                    startActivity(sportsCategory);

                    break;

                case R.id.techCategory:
                    Intent techActivity = new Intent(ClothingCategory.this, TechActivity.class);
                    startActivity(techActivity);
                    break;

                case R.id.clothingCategory:
                    Intent clothingActivity = new Intent(ClothingCategory.this, ClothingCategory.class);
                    startActivity(clothingActivity);
                    break;

                case R.id.diyCategory:
                    Intent diyActivity = new Intent(ClothingCategory.this, DIYActivity.class);
                    startActivity(diyActivity);
                    break;

                default:
                    super.onOptionsItemSelected(item);

            }

        } catch (ActivityNotFoundException exc) {
            Log.d(String.valueOf(R.string.error), exc.toString());
        }

        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
