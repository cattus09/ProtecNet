package com.protecNet.protecNet.services.encryption;

public interface IEncryptionService {

    boolean matches(String sentence, String encodedSentence);

    String encode(String sentence);
}
