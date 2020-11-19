package com.example.notemag;

public class WordDict {
    private String Word;
    private String Def;

    public WordDict() {

    }
    public WordDict(String word, String def) {
        Word = word;
        Def = def;
    }

    public String getWord() {
        return Word;
    }

    public void setWord(String word) {
        Word = word;
    }

    public String getDef() {
        return Def;
    }

    public void setDef(String def) {
        Def = def;
    }
    @Override
    public String toString()
    {
        StringBuilder sb= new StringBuilder();
        sb.append("\n"+this.Word.toUpperCase());
        sb.append("\n"+this.Def);
        return  sb.toString();
    }
}
