# web services
solution to javax.net.ssl.SSLHandshakeException: sun.security.validator.ValidatorException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
disable usual https verification aswell .
RestAssured.useRelaxedHTTPSValidation();
