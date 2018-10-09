package ng.com.mistaglobe.measure;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MeasurementsListPage extends AppCompatActivity {
    private BottomNavigationView measurementsBottomNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurements_list_page);

        setupBottomNavigation();

        if(savedInstanceState == null) {
            loadAllFragment();
        }
    }

    private void setupBottomNavigation() {
        measurementsBottomNavView = findViewById(R.id.bottom_navigation);

        measurementsBottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navigation_recents:
                        loadRecentsFragment();
                        return true;
                    case R.id.navigation_favorites:
                        loadFavoritesFragment();
                        return true;
                    case R.id.navigation_all:
                        loadAllFragment();
                        return true;
                }
                return false;
            }
        });
    }

    private void loadRecentsFragment() {
        RecentsFragment fragment = RecentsFragment.newInstance();
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame, fragment);
        ft.commit();
    }

    private void loadFavoritesFragment() {
        FavoritesFragment fragment = FavoritesFragment.newInstance();
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame, fragment);
        ft.commit();
    }

    private void loadAllFragment() {
        AllFragment fragment = AllFragment.newInstance();
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame, fragment);
        ft.commit();
    }
}
