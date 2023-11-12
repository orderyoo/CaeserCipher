package com.example.caesercipherprogect;

public class ParametersForCommander {
    private String text;
    private String language;
    private int mov;

    public void setText(String text) {
        this.text = text;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public void setMov(int mov) {
        this.mov = mov;
    }

    public String getText() {
        return text;
    }
    public String getLanguage() {
        return language;
    }
    public int getMov() {
        return mov;
    }
}
