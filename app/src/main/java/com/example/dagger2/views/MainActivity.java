package com.example.dagger2.views;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dagger2.R;
import com.example.dagger2.presenters.MainActivityPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View {
    @BindView(R.id.editTextName)
    EditText editTextName;
    @BindView(R.id.editTextAge)
    EditText editTextAge;
    @BindView(R.id.textViewName)
    TextView textViewName;
    @BindView(R.id.textViewAge)
    TextView textViewAge;
    private MainActivityPresenter presenter;

    @OnClick(R.id.btnSubmit)
    public void onBtnSubmitClick() {
        submitUser();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        setContentView(R.layout.activity_main);
        presenter = new MainActivityPresenter(this);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void updateUserNameAndAgeTextView(String name, String age) {
        textViewName.setText(name);
        textViewAge.setText(age);
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "Erro ao criar usuário", Toast.LENGTH_SHORT).show();
    }

    public void submitUser() {
        String name = editTextName.getText().toString();
        int age = 0;

        if (editTextAge.length() > 0)
            age = Integer.valueOf(editTextAge.getText().toString());
        else
            showErrorMessage();

        presenter.updateUser(name, age);

    }
}