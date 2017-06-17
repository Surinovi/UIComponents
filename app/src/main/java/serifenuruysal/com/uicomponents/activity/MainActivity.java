package serifenuruysal.com.uicomponents.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import serifenuruysal.com.uicomponents.R;
import serifenuruysal.com.uicomponents.fragments.FirstFragment;
import serifenuruysal.com.uicomponents.fragments.SecondFragment;
import serifenuruysal.com.uicomponents.fragments.ThirdFragment;

public class MainActivity extends AppCompatActivity {
    FragmentManager manager = getSupportFragmentManager();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Fragment fragment = (Fragment) manager.findFragmentByTag(FirstFragment.class.getSimpleName());
                    if (fragment == null) {
                        fragment = FirstFragment.newInstance("Tebrikler Doğru Cevap");
                    }
                    setFragment(fragment);
                    return true;
                case R.id.navigation_dashboard:
                    Fragment fragment2 = (Fragment) manager.findFragmentByTag(SecondFragment.class.getSimpleName());
                    if (fragment2 == null) {
                        fragment2 = SecondFragment.newInstance("navigation_dashboard  için data");
                    }
                    setFragment(fragment2);
                    return true;
                case R.id.navigation_notifications:
                    Fragment fragment3 = (Fragment) manager.findFragmentByTag(ThirdFragment.class.getSimpleName());
                    if (fragment3 == null) {
                        fragment3 = ThirdFragment.newInstance("navigation_notifications  için data");
                    }
                    setFragment(fragment3);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Fragment fragment = FirstFragment.newInstance("navigation_home için data");
        setFragment(fragment);


    }


    public void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment, fragment.getClass().getSimpleName());
        fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action1) {
            Toast.makeText(this, "action1",
                    Toast.LENGTH_SHORT).show();
            return true;
        }else     if (id == R.id.action2) {
            Toast.makeText(this, "action2",
                    Toast.LENGTH_SHORT).show();
            return true;
        }else     if (id == R.id.action3) {
            Toast.makeText(this, "action3",
                    Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
