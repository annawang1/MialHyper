package com.learning.annawang.mailhyper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {

    private Button mBtnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnClick = (Button) this.findViewById(R.id.btn_click);

        mBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                BlankFragment blankFragment = new BlankFragment();
//                getFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.frame_container, blankFragment, BlankFragment.class.getSimpleName())
//                        .commit();

                BlankFragment blankFragment = new BlankFragment();
                blankFragment.setMaliClick(new BlankFragment.MailClick() {
                    @Override
                    public void onMailClick() {
                        Intent data = new Intent(Intent.ACTION_SENDTO);
                        String[] deliveredTo = {"mailto:way.ping.li@gmail.com"};
                        data.putExtra(Intent.EXTRA_EMAIL, deliveredTo);
                        startActivity(data);
                    }
                });
                blankFragment.show(getFragmentManager(), BlankFragment.class.getSimpleName());


            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
