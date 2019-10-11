package com.example.dagger2;

import com.example.dagger2.presenters.MainActivityPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MainActivityPresenterTest {

    @Mock
    private MainActivityPresenter.View view;
    private MainActivityPresenter presenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new MainActivityPresenter(view);
    }

    @Test
    public void updatedUserSuccess() {
        String name = "Teste";
        int age = 18;
        presenter.updateUser(name, age);
        verify(view, times(1)).updateUserNameAndAgeTextView(name, String.valueOf(age));
    }

    @Test
    public void updatedUserNameFailed() {
        String name = "";
        int age = 18;
        presenter.updateUser(name, age);
        verify(view, times(1)).showErrorMessage();
    }

    @Test
    public void updatedUserAgeFailed() {
        String name = "Teste";
        int age = 0;
        presenter.updateUser(name, age);
        verify(view, times(1)).showErrorMessage();
    }

    @Test
    public void updatedUserViewIsDetached() {
        presenter.detachView();
        assertNull(presenter.detachView());
    }

}
