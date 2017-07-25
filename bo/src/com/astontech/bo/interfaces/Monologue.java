package com.astontech.bo.interfaces;

/**
 * Created by Logan.Moen on 6/2/2017.
 */
public class Monologue implements CharSequence {

    private String MonoText;

    public Monologue(){}
    public Monologue(String monoText){
        this.setMonoText(monoText);
    }


    public String getMonoText() {
        return MonoText;
    }

    public void setMonoText(String monoText) {
        MonoText = monoText;
    }

    @Override
    public int length(){
        return MonoText.length();
    }

    @Override
    public char charAt(int index){
        return MonoText.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end){
        StringBuilder backwards = new StringBuilder();
        int x = 1;
        for(Character c : MonoText.toCharArray()){
            backwards.append(charAt(length() - x));
            x++;
        }
        return backwards;}

    @Override
    public String toString(){
        return getMonoText();
    }
}
