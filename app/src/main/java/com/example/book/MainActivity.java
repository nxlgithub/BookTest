package com.example.book;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.example.book.buttomfragment.BookCityFragment;
import com.example.book.buttomfragment.BookRackFragment;
import com.example.book.buttomfragment.CommunityFragment;
import com.example.book.buttomfragment.MineFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.viewpager);
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new BookCityFragment());
        fragmentList.add(new BookRackFragment());
        fragmentList.add(new CommunityFragment());
        fragmentList.add(new MineFragment());
        MfragmentAdapter mfragmentAdapter=new MfragmentAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(mfragmentAdapter);
        ViewCompat.setOnApplyWindowInsetsListener(viewPager, new OnApplyWindowInsetsListener() {
            @Override
            public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
                insets = ViewCompat.onApplyWindowInsets(v, insets);
                if (insets.isConsumed()) {
                    return insets;
                }
                boolean consumed = false;
                for (int i = 0, count = viewPager.getChildCount(); i < count; ++i) {
                    ViewCompat.dispatchApplyWindowInsets(viewPager.getChildAt(i), insets);
                    if (insets.isConsumed()) {
                        consumed = true;
                    }
                }
                return consumed ? insets.consumeSystemWindowInsets() : insets;
            }
        });

        bottomNavigationView=findViewById(R.id.bottom_button);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.button1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.button2:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.button3:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.button4:
                        viewPager.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });
    }
}
