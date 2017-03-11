package noone.pro.mrvull.myshop.Activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import noone.pro.mrvull.myshop.Adapter.ExpandList_QuanTri_Adapter;
import noone.pro.mrvull.myshop.Fragment.Fragment_DanhMuc;
import noone.pro.mrvull.myshop.Fragment.Fragment_ThemMoi_DanhMuc;
import noone.pro.mrvull.myshop.Model.QuanTri;
import noone.pro.mrvull.myshop.R;

public class Manager extends AppCompatActivity {
    private ExpandableListView expandableListView;
    private HashMap<QuanTri, List<String>> listHashMap;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    int REQUEST_CODE_IMAGE = 456;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        AnhXa();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_action_name);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        //chuyển drop_down sang phải
        ViewTreeObserver observer = expandableListView.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                expandableListView.setIndicatorBounds(expandableListView.getRight() - 40, expandableListView.getWidth());
            }
        });

        AddDataGroupMenu();
        //Even when click on Group
//        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {}
        //Even when click on child
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, final long id) {
                //Toast.makeText(Manager.this,groupPosition+"==="+id, Toast.LENGTH_SHORT).show();
                switch (groupPosition) {
                    case 0:
                        switch (childPosition) {
                            case 0:
                                Toast.makeText(Manager.this, "danh sách áo", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(Manager.this, "Thêm mới áo", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        break;
                    case 1:
                        switch (childPosition) {
                            case 0:
                                Toast.makeText(Manager.this, "danh sách quần", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(Manager.this, "Thêm mới quần", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        break;
                    case 2:
                        switch (childPosition) {
                            case 0:
                                Toast.makeText(Manager.this, "danh sách giày", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(Manager.this, "Thêm mới giày", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        break;
                    case 3:
                        switch (childPosition) {
                            case 0:
                                Toast.makeText(Manager.this, "danh sách ví", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(Manager.this, "danh sách nón", Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                Toast.makeText(Manager.this, "danh sách thắt lưng", Toast.LENGTH_SHORT).show();
                                break;
                            case 3:
                                Toast.makeText(Manager.this, "danh sách balo", Toast.LENGTH_SHORT).show();
                                break;
                            case 4:
                                Toast.makeText(Manager.this, "danh sách cà vạt", Toast.LENGTH_SHORT).show();
                                break;
                            case 5:
                                Toast.makeText(Manager.this, "Thêm mới phụ kiện", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        break;
                    case 4:
                        switch (childPosition) {
                            case 0:
                                Toast.makeText(Manager.this, "danh sách tin", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(Manager.this, "Thêm mới tin", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        break;
                    case 5:
                        switch (childPosition) {
                            case 0:

                                //Toast.makeText(Manager.this, "danh sách danh mục", Toast.LENGTH_SHORT).show();
                                Fragment_DanhMuc fragment_danhMuc = new Fragment_DanhMuc();
                                if(fragment_danhMuc.isInLayout()){
                                    getSupportFragmentManager().beginTransaction().
                                            remove(getSupportFragmentManager().findFragmentById(R.id.myFrameLayout)).commit();
                                }else {
                                    fragmentTransaction.add(R.id.myFrameLayout,fragment_danhMuc,String.valueOf(fragment_danhMuc.getId()));
                                    fragmentTransaction.addToBackStack(null);
                                    fragmentTransaction.commit();
                                }

                                break;
                            case 1:
                                //Toast.makeText(Manager.this, "Thêm mới danh mục", Toast.LENGTH_SHORT).show();
                                Fragment_ThemMoi_DanhMuc fragment_themMoi_danhMuc = new Fragment_ThemMoi_DanhMuc();
                                fragmentTransaction.add(R.id.myFrameLayout,fragment_themMoi_danhMuc,String.valueOf(fragment_themMoi_danhMuc.getId()));
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                                break;
                        }
                        break;
                    case 6:
                        switch (childPosition) {
                            case 0:
                                Toast.makeText(Manager.this, "danh sách loại", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(Manager.this, "Thêm mới loại", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });
        //đóng những sub khi click vào sub khác
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                int c = expandableListView.getCount();
                for (int i = 0; i < c; i++) {
                    if (i != groupPosition)
                        expandableListView.collapseGroup(i);
                }
            }
        });

    }

    private void AddDataGroupMenu() {
        //data for header group
        final List<QuanTri> listHeader = new ArrayList<>();
        listHeader.add(new QuanTri("Quản lý áo", R.drawable.ao));
        listHeader.add(new QuanTri("Quản lý quần", R.drawable.quan));
        listHeader.add(new QuanTri("Quản lý giày", R.drawable.giay));
        listHeader.add(new QuanTri("Quản lý phụ kiện", R.drawable.cavat));
        listHeader.add(new QuanTri("Quản lý tin tức", R.drawable.bell));
        listHeader.add(new QuanTri("Quản lý danh mục", R.drawable.menu));
        listHeader.add(new QuanTri("Quản lý loại sản phẩm", R.drawable.type));
        //data for child
        listHashMap = new HashMap<>();
        List<String> listItemQuanLyAo = new ArrayList<>();
        listItemQuanLyAo.add("Danh sách áo");
        listItemQuanLyAo.add("Thêm mới");

        List<String> listItemQuanLyQuan = new ArrayList<>();
        listItemQuanLyQuan.add("Danh sách quần");
        listItemQuanLyQuan.add("Thêm mới");

        List<String> listItemQuanLyGiay = new ArrayList<>();
        listItemQuanLyGiay.add("Danh sách giày Giày");
        listItemQuanLyGiay.add("Thêm mới");

        List<String> listItemQuanLyPhuKien = new ArrayList<>();
        listItemQuanLyPhuKien.add("Ví");
        listItemQuanLyPhuKien.add("Nón");
        listItemQuanLyPhuKien.add("Thắt lưng");
        listItemQuanLyPhuKien.add("Balo");
        listItemQuanLyPhuKien.add("Cà vạt");
        listItemQuanLyPhuKien.add("Thêm mới");

        List<String> listItemQuanLyTinTuc = new ArrayList<>();
        listItemQuanLyTinTuc.add("Danh sách tin");
        listItemQuanLyTinTuc.add("Thêm mới");

        List<String> listItemQuanLyDanhMuc = new ArrayList<>();
        listItemQuanLyDanhMuc.add("Danh sánh danh mục");
        listItemQuanLyDanhMuc.add("Thêm mới");

        List<String> listItemQuanLyLoaiSanPham = new ArrayList<>();
        listItemQuanLyLoaiSanPham.add("Danh sanh loại sản phẩm");
        listItemQuanLyLoaiSanPham.add("Thêm mới");

        listHashMap.put(listHeader.get(0), listItemQuanLyAo);
        listHashMap.put(listHeader.get(1), listItemQuanLyQuan);
        listHashMap.put(listHeader.get(2), listItemQuanLyGiay);
        listHashMap.put(listHeader.get(3), listItemQuanLyPhuKien);
        listHashMap.put(listHeader.get(4), listItemQuanLyTinTuc);
        listHashMap.put(listHeader.get(5),listItemQuanLyDanhMuc);
        listHashMap.put(listHeader.get(6),listItemQuanLyLoaiSanPham);
        ExpandList_QuanTri_Adapter adapter = new ExpandList_QuanTri_Adapter(Manager.this, listHeader, listHashMap);
        expandableListView.setAdapter(adapter);
    }

    private void AnhXa() {
        drawerLayout = (DrawerLayout) findViewById(R.id.manageDrawerLayout);
        toolbar = (Toolbar) findViewById(R.id.manageToolBar);
        navigationView = (NavigationView) findViewById(R.id.manageNavigationView);
        expandableListView = (ExpandableListView) findViewById(R.id.myExpandableListView);
    }
}
