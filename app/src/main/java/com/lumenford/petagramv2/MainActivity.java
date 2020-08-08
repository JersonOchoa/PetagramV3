package com.lumenford.petagramv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;
import com.lumenford.petagramv2.adapter.MascotaAdaptador;
import com.lumenford.petagramv2.adapter.PageAdapter;
import com.lumenford.petagramv2.fragment.FragmentRecyclerView;
import com.lumenford.petagramv2.fragment.PerfilFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.mFavorites:
                Intent intent = new Intent(MainActivity.this, VerLikes.class);
                startActivity(intent);
                break;

            case R.id.mContacto:
                Intent intent1 = new Intent(MainActivity.this, ContactoActivity.class);
                startActivity(intent1);
                break;

            case R.id.mAbout:
                Intent intent2 = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void VerLikes(View v)
    {
        Intent intent = new Intent(MainActivity.this, VerLikes.class);
        startActivity(intent);
    }

    private ArrayList<Fragment> agregarFragments()
    {
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new FragmentRecyclerView());
        fragments.add(new PerfilFragment());

        return  fragments;
    }

    private void setUpViewPager()
    {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_person);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_pin);
    }
}