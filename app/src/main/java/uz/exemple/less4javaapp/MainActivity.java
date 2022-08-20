package uz.exemple.less4javaapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import uz.exemple.less4javaapp.model.Member;
import uz.exemple.less4javaapp.model.User;

public class MainActivity extends AppCompatActivity {
    int LAUNCH_PAGE = 1000;
    TextView tv_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LAUNCH_PAGE){
            if (resultCode == Activity.RESULT_OK){
                Member member = (Member) data.getSerializableExtra("result");
                tv_main.setText(member.toString());
            }
        }
    }*/
    ActivityResultLauncher<Intent> secondPageLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();
                        Member member = (Member) data.getSerializableExtra("result");
                        tv_main.setText(member.toString());
                    }
                }
            }
    );

    void initViews(){
        tv_main = (TextView)findViewById(R.id.tv_main);
        Button btnNextPage = (Button) findViewById(R.id.btnNextPage);
        btnNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User("Xushnud",32);
                openNext(user);
            }
        });
    }

    void openNext(User user){
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("name","Xushnud");
        intent.putExtra("user",user);
        intent.putExtra("age",32);

        //startActivityForResult(intent,LAUNCH_PAGE);
        secondPageLauncher.launch(intent);
    }
}