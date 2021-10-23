package quotes;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
public class ApiQuotes {


    final String urlString = "http://api.forismatic.com/api/1";

    public void sendGetRequest(){
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = setUpConnectionObject(url);
            if(connection.getResponseCode() == 200){
                BufferedReader in = getBufferedReaderFromConnection(connection);
                printBufferedReaderContect(in);
                in.close();

            }else {
                String path ="app/src/main/resources/data.json";
                Quotes q = new Quotes();
                q.read(path);
                q.reandomQuote(q.random());

            }
        } catch (MalformedURLException e) {
            System.out.println("Sorry, there was a problem creating the URL object,the error was:");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Sorry, there was a problem opening the connection from the URL object, the error was:");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
    public HttpURLConnection setUpConnectionObject(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        return connection;
    }
    public BufferedReader getBufferedReaderFromConnection(HttpURLConnection connection) throws IOException {
          BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        return in;
    }
    public void printBufferedReaderContect(BufferedReader in) throws IOException {

        String path ="app/src/main/resources/data.json";
        Quotes q = new Quotes();
        q.read(path);
        String line = in.readLine();

        String allLine = "";
        while(line != null){
            allLine+= line;
            line = in.readLine();
        }
        Gson gson=new Gson();
        Quotes newLine = gson.fromJson(allLine,Quotes.class);
        System.out.println(toString(newLine));
        q.adddd(newLine);
        String h = gson.toJson(q.newq);
        FileWriter myWriter = new FileWriter(path);
        myWriter.write(h);
        myWriter.close();

    }


    public String toString(Quotes newLine) {
        return
        "Author: "+ newLine.getQuoteAuthor()+"\n"+
       "Quote : " +newLine.getQuoteText();

    }
}
