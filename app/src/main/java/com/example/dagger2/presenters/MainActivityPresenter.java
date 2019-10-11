package com.example.dagger2.presenters;

import com.example.dagger2.models.User;

import javax.inject.Inject;

public class MainActivityPresenter {
    @Inject
    User user;
    @Inject
    View view;

    public MainActivityPresenter(View view) {
        this.user = new User();
        this.view = view;
    }

    public void updateUser(String name, int age) {
        user.setName(name);
        user.setAge(age);
        int checkUserResult = user.checkUser();

        if (checkUserResult == 0) {
            view.updateUserNameAndAgeTextView(user.getName(), String.valueOf(user.getAge()));
        } else {
            view.showErrorMessage();
        }
    }

    public View detachView() {
        view = null;
        return null;
    }

    public interface View {
        void updateUserNameAndAgeTextView(String name, String age);

        void showErrorMessage();
    }
}