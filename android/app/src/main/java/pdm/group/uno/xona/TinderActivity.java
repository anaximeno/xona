package pdm.group.uno.xona;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class TinderActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ExploreFragment exploreFragment = new ExploreFragment();

    MessageFragment messageFragment = new MessageFragment();

    AccountFragment accountFragment = new AccountFragment();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinder);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,exploreFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch(item.getItemId()){
                    case R.id.tinder_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,exploreFragment).commit();
                        return true;

                    case R.id.tinder_message:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,messageFragment).commit();
                        return true;

                    case R.id.tinder_account:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,accountFragment).commit();
                        return true;
                }
                return false;
            }
        });

    }
}
