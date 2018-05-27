package com.example.administrator.ysc_experiment_five;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.renderscript.ScriptIntrinsicResize;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected LinearLayout linear_dialog,linear_dialog_list,linear_activity,getLinear_activity_http;
    protected RadioGroup group1;
    protected  RadioButton btn1,btn2,btn3;
    protected View radio_group;
    protected CheckBox checkBox1,checkBox2;
    protected TextView txt1,txt2;
    int choice;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inview();
        setlistern();

    }

    private void setlistern() {
        linear_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                create_dialog_edit();
            }
        });
        linear_dialog_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                create_dialog_list();
            }
        });
        group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.radio_btn1)
                {
                    Toast.makeText(MainActivity.this,"选中第一个",Toast.LENGTH_SHORT).show();
                }
                if(i==R.id.radio_btn2)
                {
                    Toast.makeText(MainActivity.this,"选中第二个",Toast.LENGTH_SHORT).show();
                }
                if(i==R.id.radio_btn3)
                    Toast.makeText(MainActivity.this,"选中第三个",Toast.LENGTH_SHORT).show();
            }
        });
        linear_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Screenpreference.class));
            }
        });
        getLinear_activity_http.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent();
                intent.setData(Uri.parse("https://www.baidu.com"));
                intent.setAction(Intent.ACTION_VIEW);
                startActivity(intent);
            }
        });
        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox1.isChecked()==false)
                {
                    checkBox2.setClickable(false);
                    txt1.setTextColor(Color.GRAY);
                    txt2.setTextColor(Color.GRAY);
                }
                else {
                    checkBox2.setClickable(true);
                    txt1.setTextColor(Color.BLACK);
                    txt2.setTextColor(Color.BLACK);
                }


            }
        });

    }

    private void create_dialog_list() {

        final String []items={"Alpha Option 01","Beta Option 02","Charlie Option 03"};
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Choose one");
        builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                choice=i;
            }
        });
        builder.setNegativeButton("CHANEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

        builder.show();

    }

    private void create_dialog_edit() {
        final EditText editText=new EditText(MainActivity.this);
        AlertDialog.Builder   editdialog=new AlertDialog.Builder(MainActivity.this);
        editdialog.setTitle("Pick your favourite animal");
        editdialog.setView(editText);
        editdialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,editText.getText().toString(),Toast.LENGTH_SHORT).show();

            }
        });
        editdialog.setNegativeButton("CHANEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        editdialog.show();

    }

    private void inview() {
        linear_dialog=findViewById(R.id.linear_dialog);
        linear_dialog_list=findViewById(R.id.linear_dialog_list);
        linear_activity=findViewById(R.id.intent_activity);
        getLinear_activity_http=findViewById(R.id.intent_activity_http);
        radio_group=getLayoutInflater().inflate(R.layout.radio_group,null);
        group1=radio_group.findViewById(R.id.radiogroup);
        btn1=radio_group.findViewById(R.id.radio_btn1);
        btn2=radio_group.findViewById(R.id.radio_btn2);
        btn3=radio_group.findViewById(R.id.radio_btn3);
        checkBox2=findViewById(R.id.checkbox_);
        checkBox1=findViewById(R.id.checkbox);
        txt1=findViewById(R.id.txt1);
        txt2=findViewById(R.id.txt2);
        checkBox2.setClickable(false);
    }
}

