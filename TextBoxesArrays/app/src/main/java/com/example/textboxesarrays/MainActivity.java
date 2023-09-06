package com.example.textboxesarrays;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button btn_j_addRestaurant;
    Button btn_j_pickRestaurant;
    TextView txt_j_restaurant;
    TextView txt_j_errorNoRestaurant;
    EditText et_j_newRestaurant;
    int count = 0;
    int randomPos;
    private String[] restaurants = new String[6];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_j_addRestaurant = findViewById(R.id.btn_v_add);
        btn_j_pickRestaurant = findViewById(R.id.btn_v_find);
        txt_j_restaurant = findViewById(R.id.txt_v_restaurant);
        et_j_newRestaurant = findViewById(R.id.et_v_newRestaurant);
        txt_j_errorNoRestaurant = findViewById(R.id.txt_v_errorNoRestaurant);


        //Testing to make sure I can edit the text view
        txt_j_restaurant.setText("Hello");

        addRestaurantButtonListener();
        pickRestaurantButtonListener();
    }

    public void addRestaurantButtonListener()
    {
        btn_j_addRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("Add","Add Button Pressed");
                //Check to see if array is full
                if (checkArrayFull())
                {
                    //do something to make sure the user cannot add more restaurants
                    txt_j_errorNoRestaurant.setText("List is full. Click find restaurant.");
                    txt_j_errorNoRestaurant.setVisibility(View.VISIBLE);
                }
                else
                {
                    //If not, add restaurant
                    //Get the value from the edit text and convert to string
                    //string are compared in java using .equals
                    if (!et_j_newRestaurant.getText().toString().equals(""))
                    {
                        //add to array
                        restaurants[count] = et_j_newRestaurant.getText().toString();
                        //increment amount
                        count++;
                        //clear textbox
                        et_j_newRestaurant.setText("");
                        //make error message not visible
                        txt_j_errorNoRestaurant.setVisibility(View.INVISIBLE);
                    }
                    else
                    {
                        //error: enter a restaurant
                        //make error message visible
                        txt_j_errorNoRestaurant.setVisibility(View.VISIBLE);
                    }
                }


            }
        });
    }

    public void pickRestaurantButtonListener()
    {
        btn_j_pickRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Pick","Pick Button Pressed");
                //displayRestaurants();
                randomPos = (int) (Math.random() * count);
                //Log.d("random: ", randomPos + "");
                txt_j_restaurant.setText(restaurants[randomPos]);
            }
        });
    }

    public boolean checkArrayFull()
    {

        Log.d("Length",restaurants.length+"");
        if(count < 6)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public void displayRestaurants()
    {
        for(int i = 0; i < count; i++)
        {
            //Only display if there is something stored in the array at position i

            Log.d("Restaurant " + i + ": ",restaurants[i]);

        }
    }
}