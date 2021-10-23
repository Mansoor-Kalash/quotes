package quotes;

import com.google.gson.Gson;
import org.checkerframework.checker.units.qual.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Quotes {
    private String author;
    private String text;
    private String quoteAuthor;
    private String quoteText;
    private Quotes[] quotes;
    public Quotes[] newq;

    public void adddd (Quotes t){
         newq = new Quotes[quotes.length+1];
        for (int i=0;i<newq.length-1;i++){
            newq[i]=quotes[i];
        }
        newq[newq.length-1]=t;
    }


    public Quotes(){}

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }

    public String getQuoteAuthor() {
        return quoteAuthor;
    }

    public void setQuoteAuthor(String quoteAuthor) {
        this.quoteAuthor = quoteAuthor;
    }

    public Quotes(String author, String text,String quoteAuthor,String quoteText ) {
        this.author = author;
        this.text = text;
        this.quoteAuthor=quoteAuthor;
        this.quoteText=quoteText;


    }
//    public Quotes(String quoteAuthor, String quoteText) {
//        this.quoteAuthor = quoteAuthor;
//        this.quoteText = quoteText;
//
//    }

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
    public void ww (String ww){

        Gson gson=new Gson();

        quotes = gson.fromJson(ww,Quotes[].class);
        System.out.println(quotes[0].getQuoteAuthor());
    }
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
        System.out.println("Authorrrrr: "+ (quotes[random].getAuthor()!=null? quotes[random].getAuthor():quotes[random].getQuoteAuthor()));
        System.out.println("Quote : " + (quotes[random].getText()!=null?quotes[random].getText():quotes[random].getQuoteText()));
        System.out.println("number : " + random);
    }


}
