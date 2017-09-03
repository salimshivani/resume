package acme.sample.resume;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class showDetails extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        Bundle bundle = getIntent().getExtras();

        if (getIntent()!=null) {
//            Bundle extras = getIntent().getExtras();
//            byte[] byteArray = extras.getByteArray("picUser");
            Intent intent = getIntent();


            Bitmap bitmp = (Bitmap) intent.getParcelableExtra("picUser");
//            BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
//            Bitmap bitmp = BitmapFactory.decodeByteArray(
//                    getIntent().getByteArrayExtra("picUser"), 0, getIntent().getByteArrayExtra("picUser").length);

            ImageView ivGet = (ImageView) findViewById(R.id.ivGet);
//            ImageView ivGet = new ImageView(this);
            ivGet.setImageBitmap(bitmp);

            TextView tvName = (TextView) findViewById(R.id.tvName);
            tvName.setText(intent.getStringExtra("strName"));

            TextView tvEmail = (TextView) findViewById(R.id.tvEmail);
            tvEmail.setText(intent.getStringExtra("strEmail"));

            TextView tvCon = (TextView) findViewById(R.id.tvContact);
            tvCon.setText(intent.getStringExtra("strContact"));

            TextView tvSkill = (TextView) findViewById(R.id.tvSkills);
            tvSkill.setText(intent.getStringExtra("strSkill"));

            TextView tvDOb = (TextView) findViewById(R.id.tvDOB);
            tvDOb.setText(intent.getStringExtra("strDob"));

//            WebView webView = (WebView) findViewById(R.id.webView);
//            webView.loadUrl("www.acmeuniverse.com");
//            webView.setWebViewClient();
        }
//        String messageName = intent.getStringExtra(FetchDetails.EXTRA_NAME);
//        tvName.setId(R.id.tvNameAS);
//        tvName.setText(messageName);

//        String messageEmail = intent.getStringExtra(FetchDetails.EXTRA_EMAIL);
//        tvEmail.setId(R.id.tvEmailAS);
//        tvEmail.setText(messageEmail);

//        String messageCon = intent.getStringExtra(FetchDetails.EXTRA_CONTACT);
//        tvCon.setId(R.id.tvContactAS);
//        tvCon.setText(messageCon);

//        String messageSkill = intent.getStringExtra(FetchDetails.EXTRA_SKILLS);
//        tvSkill.setId(R.id.tvSkillsAS);
//        tvSkill.setText(messageSkill);

//        String messageDOb = intent.getStringExtra(FetchDetails.EXTRA_DOB);
//        tvDOb.setId(R.id.tvDOBAS);
//        tvDOb.setText(messageDOb);

//        layoutParams.addRule(RelativeLayout.BELOW, tvName);
//        RelativeLayout layout = (RelativeLayout) findViewById(R.id.showDetails);
//        layout.addView(tvName);
//        layout.addView(tvEmail);
//        layout.addView(tvCon);
//        layout.addView(tvSkill);
//        layout.addView(tvDOb);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
