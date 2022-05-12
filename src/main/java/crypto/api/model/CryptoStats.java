package crypto.api.model;


public class CryptoStats {
    private final String status;
    private final String message;
    private final String currencyName;
    private final String price;
    private final String change;
    private final String changePercentage;
    private final String prevClose;
    private final String open;
    private final String dayRange;
    private final String yearRange;
    private final String startDate;
    private final String marketCap;
    private final String circulatingSupply;
    private final String volume;
    private final String description;

    public CryptoStats(String status, String message, String currencyName, String price, String change, String changePercentage, String prevClose, String open, String dayRange, String yearRange, String startDate, String marketCap, String circulatingSupply, String volume, String description){
        this.status = status;
        this.message = message;
        this.currencyName = currencyName;
        this.price = price;
        this.change = change;
        this.changePercentage = changePercentage;
        this.prevClose = prevClose;
        this.open = open;
        this.dayRange = dayRange;
        this.yearRange = yearRange;
        this.startDate = startDate;
        this.marketCap = marketCap;
        this.circulatingSupply = circulatingSupply;
        this.volume = volume;
        this.description = description;
    }

    public static CryptoStats error(String status, String message){
        return new CryptoStats(status, message, "", "", "", "", "", "", "", "", "", "", "", "", "");
    }

    public String getStatus(){
        return status;
    }

    public String getMessage(){
        return message;
    }

    public String getCurrencyName(){
        return currencyName;
    }

    public String getPrice(){
        return price;
    }

    public String getChange(){
        return change;
    }

    public String getChangePercentage(){
        return changePercentage;
    }

    public String getPrevClose(){
        return prevClose;
    }

    public String getOpen(){
        return open;
    }

    public String getDayRange(){
        return dayRange;
    }

    public String getYearRange(){
        return yearRange;
    }

    public String getStartDate(){
        return startDate;
    }

    public String getMarketCap(){
        return marketCap;
    }

    public String getCirculatingSupply(){
        return circulatingSupply;
    }


    public String getVolume(){
        return volume;
    }

    public String getDesc(){
        return description;
    }

    public String toString(){
        return currencyName;
    }

    public boolean equals(CryptoStats other){
        return this.toString().equals(other.toString());
    }
}