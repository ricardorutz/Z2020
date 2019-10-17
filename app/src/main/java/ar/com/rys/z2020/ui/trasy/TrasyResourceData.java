package ar.com.rys.z2020.ui.trasy;

import com.yanzhenjie.album.AlbumFile;

public class TrasyResourceData {

    private int imagesResource;
    private String imageTitle;
    private AlbumFile albumFile;

    public String getImagesResource() {
        return String.valueOf(imagesResource);
    }

    public void setImagesResource(int imagesResource) {
        this.imagesResource = imagesResource;
    }

    public String getImageTitle() {
        return String.valueOf(imageTitle);
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public AlbumFile getAlbumFile(){

        if(albumFile==null){
            albumFile = new AlbumFile();
            albumFile.setMediaType(AlbumFile.TYPE_IMAGE);
            albumFile.setPath(getImagesResource());
        }

        return albumFile;
    }
}
