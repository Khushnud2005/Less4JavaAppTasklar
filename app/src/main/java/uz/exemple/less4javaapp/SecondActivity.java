package uz.exemple.less4javaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import uz.exemple.less4javaapp.model.Member;
import uz.exemple.less4javaapp.model.User;

public class SecondActivity extends AppCompatActivity {

    static final String TAG = SecondActivity.class.toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
    }

    void initViews(){
        TextView text1 = (TextView) findViewById(R.id.tv1_SecondActivity);
        Button btn_back = (Button) findViewById(R.id.btnBackPage);
        User user = (User) getIntent().getSerializableExtra("user");
        String name = getIntent().getStringExtra("name");
        int age = getIntent().getIntExtra("age",18);
        //String strAge = String.valueOf(age);
        Log.d(TAG,name);
       // Log.d(TAG,strAge);

        text1.setText(name + " " + age+"\n"+ user.toString());

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Member member = new Member(777, "Khushnud");
                toBackPage(member);
            }
        });

    }
    void toBackPage(Member member){
        Intent intent = new Intent();
        intent.putExtra("result",member);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }
}