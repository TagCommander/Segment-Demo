package com.tagcommander.tcdemo.tcdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.tagcommander.tcdemo.data.Restaurants;

public class RestaurantDetail extends Activity implements View.OnClickListener
{
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);


        Intent intentObject = getIntent();
        id = intentObject.getIntExtra("ID", 0);

        TextView nameText = (TextView) this.findViewById(R.id.name_text);
        nameText.setText(Restaurants.TITLES[id]);

        TextView typeText = (TextView) this.findViewById(R.id.type_text);
        typeText.setText(Restaurants.TYPES[id]);

        RatingBar rating = (RatingBar) this.findViewById(R.id.rating_bar);
        rating.setProgress(Restaurants.RATINGS[id]);

        RatingBar waiting = (RatingBar) this.findViewById(R.id.wait_bar);
        waiting.setProgress(Restaurants.WAITTIME[id]);

        ImageView image = (ImageView) this.findViewById(R.id.photo_image);
        image.setImageResource(Restaurants.PHOTO[id]);

        this.findViewById(R.id.location_btn).setOnClickListener(this);
        this.findViewById(R.id.send_btn).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_restaurant_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.location_btn:
                Intent map = new Intent();
                map.putExtra("latitude", Restaurants.LATITUDES[id]);
                map.putExtra("longitude", Restaurants.LONGITUDES[id]);
                setResult(Activity.RESULT_OK, map);
                finish();
                break;

            case R.id.send_btn:
                RatingBar rating = (RatingBar) this.findViewById(R.id.rating_bar);
                RatingBar waiting = (RatingBar) this.findViewById(R.id.wait_bar);
                finish();
                break;
        }
    }
}
