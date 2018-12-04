package com.abed.prawo;

public class Item {
    private String imageUrl;
    private String word;
    private String translatedWord;
    private String soundUrl;
    private String translatedSoundUrl;

    public Item() {
    }

    public Item(String imageUrl, String word, String translatedWord, String soundUrl, String translatedSoundUrl) {
        this.imageUrl = imageUrl;
        this.word = word;
        this.translatedWord = translatedWord;
        this.soundUrl = soundUrl;
        this.translatedSoundUrl = translatedSoundUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslatedWord() {
        return translatedWord;
    }

    public void setTranslatedWord(String translatedWord) {
        this.translatedWord = translatedWord;
    }

    public String getSoundUrl() {
        return soundUrl;
    }

    public void setSoundUrl(String soundUrl) {
        this.soundUrl = soundUrl;
    }

    public String getTranslatedSoundUrl() {
        return translatedSoundUrl;
    }

    public void setTranslatedSoundUrl(String translatedSoundUrl) {
        this.translatedSoundUrl = translatedSoundUrl;
    }
}
