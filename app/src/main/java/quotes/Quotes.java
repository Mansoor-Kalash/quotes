package quotes;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Quotes {
    private String author;
    private String text;
    private Quotes[] quotes;
    public Quotes(){}

    public Quotes(String author, String text) {
        this.author = author;
        this.text = text;

    }

    public Quotes[] getQuotes() {
        return quotes;
    }

    public void setQuotes(Quotes[] quotes) {
        this.quotes = quotes;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
//    BufferedReader
   public void read (String path)  {

            Gson gson=new Gson();
       Reader reader = null;
       try {
           reader = Files.newBufferedReader(Paths.get(path));
       } catch (IOException e) {
           e.printStackTrace();
       }
       BufferedReader readJsonFile =new BufferedReader(reader);
            quotes = gson.fromJson(readJsonFile, Quotes[].class);
//           return readJsonFile;


    }
    public int random (){

        int radnom = (int)(Math.random()*(quotes.length-1));
        return radnom;
    }
    public void reandomQuote(int random){
        System.out.println("Author: "+quotes[random].getAuthor());
        System.out.println("Quote : " + quotes[random].getText());
        System.out.println("number : " + random);
    }


}
