package com.pro.mylistpokemon;

public class ListPokemon {

    private  String textUrl;
    private String textName;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String image;

    public String getName() {
        return textName;
    }

    public void setName(String textName) {
        this.textName = textName;
    }

    public String getUrl() {
        return textUrl;
    }

    public void setUrl(String textUrl) {
        this.textUrl = textUrl;
    }

    public ListPokemon(String textName, String textUrl,String image) {
        this.textUrl = textUrl;
        this.textName = textName;
        this.image=image;
    }

}
