package noone.pro.mrvull.myshop.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import noone.pro.mrvull.myshop.Fragment.Fragment_Ao;
import noone.pro.mrvull.myshop.Fragment.Fragment_Giay;
import noone.pro.mrvull.myshop.Fragment.Fragment_KhuyenMai;
import noone.pro.mrvull.myshop.Fragment.Fragment_PhuKien;
import noone.pro.mrvull.myshop.Fragment.Fragment_Quan;
import noone.pro.mrvull.myshop.Fragment.Fragment_TinTuc;
import noone.pro.mrvull.myshop.R;
import noone.pro.mrvull.myshop.Adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();

        setSupportActionBar(toolbar);//hiện toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//hiện mũi tên của toolbar
        toolbar.setNavigationIcon(R.drawable.ic_action_name);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);//mở navigation
            }
        });
        navigationView.setItemIconTintList(null);//lấy hình, màu của icon gốc.
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuAoSoMi:
                        Toast.makeText(MainActivity.this, "Áo", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuAoKhoac:
                        Toast.makeText(MainActivity.this, "Quần", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuAoThun:
                        Toast.makeText(MainActivity.this, "Giày", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuAoVet:
                        Toast.makeText(MainActivity.this, "Phụ kiện", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuQuanJean:
                        Toast.makeText(MainActivity.this, "Áo", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuQuanKaKi:
                        Toast.makeText(MainActivity.this, "Quần", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuQuanTay:
                        Toast.makeText(MainActivity.this, "Giày", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuQuanShort:
                        Toast.makeText(MainActivity.this, "Phụ kiện", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuGiay:
                        Toast.makeText(MainActivity.this, "Áo", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuVi:
                        Toast.makeText(MainActivity.this, "Quần", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuNon:
                        Toast.makeText(MainActivity.this, "Giày", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuThatLung:
                        Toast.makeText(MainActivity.this, "Phụ kiện", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuBaLo:
                        Toast.makeText(MainActivity.this, "Áo", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuCaVat:
                        Toast.makeText(MainActivity.this, "Quần", Toast.LENGTH_SHORT).show();
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment_KhuyenMai(), "Khuyến mãi");
        adapter.addFragment(new Fragment_Ao(), "Áo");
        adapter.addFragment(new Fragment_Quan(), "Quần");
        adapter.addFragment(new Fragment_Giay(), "Giày");
        adapter.addFragment(new Fragment_PhuKien(), "Phụ kiện");
        adapter.addFragment(new Fragment_TinTuc(), "Tin tức");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        //tabLayout.getTabAt(0).setIcon(R.mipmap.ic_launcher);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        SubMenu submenu = menu.addSubMenu(0, Menu.NONE, Menu.NONE, "My Account");
//        //submenu.add(0, 10, Menu.NONE, "My Profile");
//        //submenu.add(0, 15, Menu.NONE, "Change Job");
//        SubMenu submenu2 = submenu.addSubMenu(0, Menu.NONE, Menu.NONE, "Change Job");
//        submenu2.add(0, 100, Menu.NONE, "Pilot");
//        submenu2.add(0, 105, Menu.NONE, "Fligh Attendant");
//        submenu2.add(0, 110, Menu.NONE, "Technical");
//        //submenu.add(0, 20, Menu.NONE, "Log Out");
        switch (item.getItemId()) {
            case R.id.menuDangNhap:
                startActivity(new Intent(this,Manager.class));
                break;
            case R.id.menuCart:
                Toast.makeText(this, "Cart", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuChinhSach:
                Toast.makeText(this, "Chinh sach", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuLienHe:
                Toast.makeText(this, "Liên hệ", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_right, menu);

        return super.onCreateOptionsMenu(menu);
    }

    private void AnhXa() {
        toolbar = (Toolbar) findViewById(R.id.myToolBar);
        drawerLayout = (DrawerLayout) findViewById(R.id.myDrawerLayout);
        navigationView = (NavigationView) findViewById(R.id.myNavigationView);
        tabLayout = (TabLayout) findViewById(R.id.myTabLayout);
        viewPager = (ViewPager) findViewById(R.id.myViewPager);
    }


}
