package crypto.api.service;

import crypto.api.model.CryptoStats;

public interface CryptoService {
    CryptoStats getStats(String cryptoName);
}