package crypto.api.controller;

import crypto.api.model.CryptoStats;
import crypto.api.service.CryptoService;
import crypto.api.service.CryptoServiceImplementation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class CryptoStatsController {
    @Autowired
    private CryptoService cryptoService;

    @GetMapping("/cryptostats")
    public CryptoStats getStats(@RequestParam(value = "symbol", defaultValue = "error") String symbol){
        if (!symbol.equals("error")){
            CryptoServiceImplementation service = new CryptoServiceImplementation();
            return cryptoService.getStats(symbol);
        }
        return CryptoStats.error("400", "Please enter a valid query. Refer to https://github.com/yuvrajvirdi/crypto-stats-api/blob/main/README.md on how to make valid queries.");
    }
}
