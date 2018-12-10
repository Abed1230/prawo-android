package com.abed.prawo;

public class Item {
    private String imageFilePath;
    private String word;
    private String translatedWord;
    private String soundFilePath;
    private String translatedSoundFilePath;

    public Item() {
    }

    public Item(String imageFilePath, String word, String translatedWord, String soundFilePath, String translatedSoundFilePath) {
        this.imageFilePath = imageFilePath;
        this.word = word;
        this.translatedWord = translatedWord;
        this.soundFilePath = soundFilePath;
        this.translatedSoundFilePath = translatedSoundFilePath;
    }

    public String getImageFilePath() {
        return imageFilePath;
    }

    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
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

    public String getSoundFilePath() {
        return soundFilePath;
    }

    public void setSoundFilePath(String soundFilePath) {
        this.soundFilePath = soundFilePath;
    }

    public String getTranslatedSoundFilePath() {
        return translatedSoundFilePath;
    }

    public void setTranslatedsoundFilePath(String translatedSoundFilePath) {
        this.translatedSoundFilePath = translatedSoundFilePath;
    }
}
