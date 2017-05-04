package info.mschmitt.myapplication;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import info.mschmitt.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends Activity {
    State state = new State();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setState(state);
    }

    /**
     * Two-way data binding discovers and changes the checked field, but doesn't notify the observable
     */
    public static class State extends BaseObservable {
        @Bindable public boolean checked;
    }
//
//    /**
//     * This one works, but is a lot of boilerplate code, especially for prototyping
//     */
//    public static class State extends BaseObservable {
//        private boolean checked;
//
//        @Bindable
//        public boolean isChecked() {
//            return checked;
//        }
//
//        public void setChecked(boolean checked) {
//            this.checked = checked;
//            notifyPropertyChanged(BR.checked);
//        }
//    }
}
