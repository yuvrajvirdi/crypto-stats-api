package crypto.api.service;

import crypto.api.model.CryptoStats;
import org.springframework.stereotype.Service;

import java.util.List;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlTableDataCell;

@Service
public class CryptoServiceImplementation implements CryptoService{
    @Override
    public CryptoStats getStats(String cryptoName){
        String query = cryptoName;

        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);

        String url = String.format("https://finance.yahoo.com/quote/%s", query);
        try {
            HtmlPage page = client.getPage(url);

            List<HtmlHeading1> name = page.getByXPath("//h1[@class='D(ib) Fz(18px)']");
            String currencyName = name.get(0).asNormalizedText();

            List<HtmlDivision> infoHeader = page.getByXPath("//div[@class='D(ib) Mend(20px)']");

            String info = infoHeader.get(0).asNormalizedText();
            String[] infoArr = info.split("\n");

            String priceAndChange = infoArr[0];

            String price = "";
            String change = "";
            String changePercentage = "";

            int tracker1 = 0;
            int tracker2 = 0;

            for (int i = 0; i < priceAndChange.length(); i++){
                if (priceAndChange.charAt(i)=='-' || priceAndChange.charAt(i)=='+'){
                    tracker1 = i;

                    break;
                }

                price += priceAndChange.charAt(i);
            }

            for (int i = tracker1; i < priceAndChange.length(); i++){
                if (priceAndChange.charAt(i)=='('){
                    tracker2 = i;

                    break;
                }

                change += priceAndChange.charAt(i);
            }
            
            for (int i = tracker2; i < priceAndChange.length(); i++){
                changePercentage += priceAndChange.charAt(i);
            }

            changePercentage = changePercentage.replaceAll("[\\[\\](){}]","");

            List<HtmlTableDataCell> currencyStats = page.getByXPath("//td[@class='Ta(end) Fw(600) Lh(14px)']");
            String prevClose = currencyStats.get(0).asNormalizedText();
            String open = currencyStats.get(1).asNormalizedText();
            String dayRange = currencyStats.get(2).asNormalizedText();
            String yearRange = currencyStats.get(3).asNormalizedText();
            String startDate = currencyStats.get(4).asNormalizedText();
            String marketCap = currencyStats.get(6).asNormalizedText();
            String circulatingSupply = currencyStats.get(7).asNormalizedText();
            String volume = currencyStats.get(9).asNormalizedText();


            String descUrl = "https://finance.yahoo.com/quote/"+query+"/profile?p="+query;
            HtmlPage descPage = client.getPage(descUrl);

            List<HtmlDivision> descriptionArr = descPage.getByXPath("//div[@data-test='prof-desc']");
            String desc =descriptionArr.get(0).asNormalizedText();
            client.close();
            return new CryptoStats("200", "retrieved", currencyName, price, change, changePercentage, prevClose, open, dayRange, yearRange, startDate, marketCap, circulatingSupply, volume, desc);
        } catch (IOException ex){
            client.close();
            return CryptoStats.error("400", ex.getMessage());
        }
       
    }

}