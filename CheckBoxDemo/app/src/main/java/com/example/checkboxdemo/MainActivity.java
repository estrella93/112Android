package com.example.checkboxdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private CheckBox original,beef,seafood;

    private int[] chkIDs ={R.id.chkOriginal,R.id.chkBeef,R.id.chkSeafood};

    private TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        original = (CheckBox) findViewById(R.id.chkOriginal);
        beef =(CheckBox) findViewById(R.id.chkBeef);
        seafood = (CheckBox) findViewById(R.id.chkSeafood);
        output =(TextView)findViewById(R.id.lblOutput);

        for (int id:chkIDs){
            CheckBox chk =(CheckBox) findViewById(id);
            chk.setOnClickListener(this);
        }
        Button btnConfirm =(Button) findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox original = (CheckBox) findViewById(R.id.chkOriginal);
                CheckBox beef =(CheckBox) findViewById(R.id.chkBeef);
                CheckBox seafood = (CheckBox) findViewById(R.id.chkSeafood);
                String str ="";
                if(original.isChecked())
                    str+= original.getText()+"\n";
                if(beef.isChecked())
                    str+= beef.getText()+"\n";
                if(seafood.isChecked())
                    str+= seafood.getText()+"\n";
                TextView output = (TextView) findViewById(R.id.lblOutput);
                output.setText(str);

            }
        });


    }

    public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){
        //TextView output =(TextView)findViewById(R.id.lblOutput);
        int id = buttonView.getId();
        String str ="";
        String staus="";
       // String str =output.getText().toString();
           if (id==R.id.chkOriginal){
               staus=(isChecked?"選取":"取消")+"原味...";
           } else if (id ==R.id.chkBeef) {
               staus=(isChecked?"選取":"取消")+"牛肉...";

           }else if (id ==R.id.chkSeafood) {
               staus=(isChecked?"選取":"取消")+"海鮮...";

           }
        txvStatus.setText(staus);


        //  }
         //   else if (id==R.id.chkBeef){
         //       output.setText("你點選的是牛肉...\n");
         //   }
         //   else if (id==R.id.chkSeafood){
         //       output.setText("你點選的是海鮮...\n");
         //   }

        for(int i:chkIDs){
            CheckBox chk=(CheckBox) findViewById(i);
            if (chk.isChecked())
                str+=chk.getText()+"\n";
        }
        output.setText(str);
    }

    @Override
    public void onClick(View v) {

    }
}