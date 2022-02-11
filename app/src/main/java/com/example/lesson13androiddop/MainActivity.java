package com.example.lesson13androiddop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lesson13androiddop.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;

    private TextView tvOutput;
    private Button btnAc, btnDivide,
            btn7, btn8, btn9, btnMultiply,
            btn4, btn5, btn6, btnMinus,
            btn1, btn2, btn3, btnPlus,
            btn0, btnPeriod, btnEquals;

    private MainActivityPresenters mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initializeComponents();
        mainActivityPresenter = new MainActivityPresenters(tvOutput, btnEquals,
                btnPlus, btnMinus, btnDivide, btnMultiply);
    }

    private void initializeComponents() {
        tvOutput = findViewById(R.id.tv_output);

        btnAc = findViewById(R.id.btn_ac);
        btnDivide = findViewById(R.id.btn_divide);
        btn7 = findViewById(R.id.btn_seven);
        btn8 = findViewById(R.id.btn_eight);
        btn9 = findViewById(R.id.btn_nine);
        btnMultiply = findViewById(R.id.btn_multiply);
        btn4 = findViewById(R.id.btn_four);
        btn5 = findViewById(R.id.btn_five);
        btn6 = findViewById(R.id.btn_six);
        btnMinus = findViewById(R.id.btn_minus);
        btn1 = findViewById(R.id.btn_one);
        btn2 = findViewById(R.id.btn_two);
        btn3 = findViewById(R.id.btn_three);
        btnPlus = findViewById(R.id.btn_plus);
        btn0 = findViewById(R.id.btn_zero);
        btnPeriod = findViewById(R.id.btn_period);
        btnEquals = findViewById(R.id.btn_equals);


        btnAc.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnPeriod.setOnClickListener(this);
        btnEquals.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ac:
                mainActivityPresenter.setText(btnAc.getText().toString());
                break;
            case R.id.btn_divide:
                mainActivityPresenter.updateMethod(btnDivide.getText().toString());
                break;
            case R.id.btn_seven:
                mainActivityPresenter.setText(btn7.getText().toString());
                break;
            case R.id.btn_eight:
                mainActivityPresenter.setText(btn8.getText().toString());
                break;
            case R.id.btn_nine:
                mainActivityPresenter.setText(btn9.getText().toString());
                break;
            case R.id.btn_multiply:
                mainActivityPresenter.updateMethod(btnMultiply.getText().toString());
                break;
            case R.id.btn_four:
                mainActivityPresenter.setText(btn4.getText().toString());
                break;
            case R.id.btn_five:
                mainActivityPresenter.setText(btn5.getText().toString());
                break;
            case R.id.btn_six:
                mainActivityPresenter.setText(btn6.getText().toString());
                break;
            case R.id.btn_minus:
                mainActivityPresenter.updateMethod(btnMinus.getText().toString());
                break;
            case R.id.btn_one:
                mainActivityPresenter.setText(btn1.getText().toString());
                break;
            case R.id.btn_two:
                mainActivityPresenter.setText(btn2.getText().toString());
                break;
            case R.id.btn_three:
                mainActivityPresenter.setText(btn3.getText().toString());
                break;
            case R.id.btn_plus:
                mainActivityPresenter.updateMethod(btnPlus.getText().toString());
                break;
            case R.id.btn_zero:
                mainActivityPresenter.setText(btn0.getText().toString());
                break;
            case R.id.btn_period:
                mainActivityPresenter.setText(btnPeriod.getText().toString());
                break;
            case R.id.btn_equals:
                mainActivityPresenter.showOutput();
                break;

        }
    }
}