package ar.com.rys.z2020.ui.gallery;

import android.widget.ImageView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.squareup.picasso.Picasso;

import ar.com.rys.z2020.R;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    ImageView ivImageViewFromUrl;
    final String URL ="Aquí colocamos la url de la imagen a mostrar";

    public GalleryViewModel() {
        /*
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
        */

        /*
        ivImageViewFromUrl = (ImageView)findViewById(R.id.iv_image_from_url);
        Picasso.with(getApplicationContext()).load(URL).into(ivImageViewFromUrl);

         */
    }

    public LiveData<String> getText() {
        return mText;
    }
}