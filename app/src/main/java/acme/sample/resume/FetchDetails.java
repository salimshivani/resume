package acme.sample.resume;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;

@TargetApi(17)
public class FetchDetails extends ActionBarActivity {
    public final static String EXTRA_NAME = "acme.sample.resume.NAME";
    public final static String EXTRA_EMAIL = "acme.sample.resume.EMAIL";
    public final static String EXTRA_CONTACT = "acme.sample.resume.CONTACT";
    public final static String EXTRA_SKILLS = "acme.sample.resume.SKILLS";
    public final static String EXTRA_DOB = "acme.sample.resume.DOB";

    Intent intent;

    public static Bitmap PHOTO = null;

    Button btnSubmit;
    ImageView imageView;
    EditText etNam, eteMail, etContacts, etSkill, etDob;
    Bitmap bitmp;
    DatePicker dpDoB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_details);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        imageView = (ImageView) findViewById(R.id.picUser);

        etNam = (EditText) findViewById(R.id.etName);
        eteMail = (EditText) findViewById(R.id.etEmail);
        etContacts = (EditText) findViewById(R.id.etContact);
        etSkill = (EditText) findViewById(R.id.etSkills);
//        etDob = (EditText) findViewById(R.id.etDOB);
        dpDoB = (DatePicker) findViewById(R.id.datePicker);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                imageView.setImageURI(intent.getData());
                startActivityForResult(intent, 0);
            }
        });

//        btnSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(.ShowDetails);
//            }
//        });

//        etNam.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//        public void onFocusChange(View view, boolean hasFocus) {
//                if (hasFocus)
//                    etNam.setHint("");
//                else
//                    etNam.setHint(R.string.etName);
//
//            }
//        });
//
//        eteMail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View view, boolean hasFocus) {
//                if (hasFocus)
//                    eteMail.setHint("");
//                else
//                    eteMail.setHint(R.string.etEmail);
//            }
//        });
//
//        etContacts.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View view, boolean hasFocus) {
//                if (hasFocus)
//                    etContacts.setHint("");
//                else
//                    etContacts.setHint(R.string.etContact);
//            }
//        });
//
//        etDob.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View view, boolean hasFocus) {
//                if (hasFocus)
//                    etDob.setHint("");
//                else
//                    etDob.setHint(R.string.etDOB);
//            }
//        });
//
//        etSkill.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View view, boolean hasFocus) {
//                if (hasFocus)
//                    etSkill.setHint("");
//                else
//                    etSkill.setHint(R.string.etSkills);
//            }
//        });
    }

//
//    public void getPath() {
//
////        File storageDirectory = Environment.getExternalStorageDirectory();
//        String storageDirectory = Environment.getExternalStorageDirectory().toString();
//        //                String imgPath = "";
////        long imgTime = imageView.getDrawingTime();
//
////        String img_path = imageView.getTransitionName();
//        String img_path = Uri.parse(url).getLastPathSegment();
//
//        storageDirectory += img_path;
////        img_path += imageView.getDrawingTime();
//        File imgFile = new File(storageDirectory, img_path);
//
//
////                Context context = getActivity();
//        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("image", storageDirectory);
//        editor.commit();
//    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //TODO auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bitmp = (Bitmap) data.getExtras().get("data");
        imageView.setImageBitmap(bitmp);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fetch_details, menu);
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

//    @Override
//    public void captureImage(int requestCode, int resultCode, Intent data) {
//        super.captureIm
//    }

    //    @Override
    public void forwardDetails(View view) {

        imageView.buildDrawingCache();
        bitmp = imageView.getDrawingCache();

        /*Intent */
        intent = new Intent(this, showDetails.class);/*FetchDetails.*/

        intent.putExtra("picUser", bitmp);

        String name = etNam.getText().toString();
        intent.putExtra("strName", name);

        String email = eteMail.getText().toString();
        intent.putExtra("strEmail", email);

        String contact = etContacts.getText().toString();
        intent.putExtra("strContact", contact);

        String skills = etSkill.getText().toString();
        intent.putExtra("strSkill", skills);

        String DoB = String.valueOf(dpDoB.getDayOfMonth()) + "/" + String.valueOf(dpDoB.getMonth() + 1) + "/" + String.valueOf(dpDoB.getYear());
        intent.putExtra("strDob", DoB);

        startActivity(intent);
    }

    public boolean isExternalReadable() {
        String state = Environment.getExternalStorageState();

        if (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {


            return true;
        }
        return true;
    }
}
