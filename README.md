# crypto-stats-api
REST API for retrieving statistics on cryptocurrencies

* allows for queries on all crypto symbols

# Installation

Clone the repo

```bash
git clone https://yuvrajvirdi/crypto-stats-api.git
```

# Use

Run the application

```bash
./mvnw spring-boot:run
```

Hit the following endpoint: `http://localhost:8080/cryptostats?symbol=<YOUR-SYMBOL>-USD`

**All crypto symbols are followed by "-USD" in order to properly hit the endpoint**

# Example

Endpoint: `http://localhost:8080/cryptostats?symbol=BTC-USD`

 ```java
{
  "status":"200",
  "message":"retrieved",
  "currencyName":"Bitcoin USD (BTC-USD)",
  "price":"28,537.00",
  "change":"-943.39 ",
  "changePercentage":"-3.20%",
  "prevClose":"29,061.51",
  "open":"29,061.51",
  "dayRange":"26,350.49 - 30,016.65",
  "yearRange":"26,350.49 - 68,789.62",
  "startDate":"2013-04-28",
  "marketCap":"543.29B",
  "circulatingSupply":"19.04M",
  "volume":"71,981,875,200",
  "desc":"Bitcoin (BTC) is a cryptocurrency . Users are able to generate BTC through the process of mining. Bitcoin has a current supply of 19,037,437. The last known price of Bitcoin is 29,610.99377613 USD and is down -3.89 over the last 24 hours. It is currently trading on 9423 active market(s) with $73,466,920,005.65 traded over the last 24 hours. More information can be found at https://bitcoin.org/."
}
 ```
