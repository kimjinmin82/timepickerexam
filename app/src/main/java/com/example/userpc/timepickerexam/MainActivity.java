package com.example.userpc.timepickerexam;

import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    int year, month, day, hour, minute;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GregorianCalendar calendar = new GregorianCalendar();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day= calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new TimePickerDialog(MainActivity.this, timeSetListener, hour, minute, false).show();
            }
        });
    }
    private TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Button btn1 = (Button) findViewById(R.id.btn1);
            String aMpM = "AM";
            if(hourOfDay>11){
                aMpM = "PM";
            }
            int currentHour;
            if(hourOfDay >11) {
                currentHour = hourOfDay - 12;
            }
            else{
                currentHour = hourOfDay;
            }
            btn1.setText("");
            btn1.setText(btn1.getText()+String.valueOf(hourOfDay) + "시"
                    + String.valueOf(minute)+ "분\n");



            // TODO Auto-generated method stub

            String msg = String.format("%d / %d / %d", year, hourOfDay, minute);
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
    };



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.actionexam, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //ActionBar 메뉴 클릭에 대한 이벤트 처리
        String txt = null;
        int id = item.getItemId();
        switch (id){
            case R.id.item2:
                txt = "item3 click";
                break;
        }
        Toast.makeText(this,txt,Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }
}


