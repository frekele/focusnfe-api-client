## FocusNFe Brazilian fiscal Issuer NF-e NFC-e Java REST API Client (Open Source) 

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.frekele.fiscal/focusnfe-api-client/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.frekele.fiscal/focusnfe-api-client)
[![Javadocs](http://www.javadoc.io/badge/org.frekele.fiscal/focusnfe-api-client.svg?color=blue)](http://www.javadoc.io/doc/org.frekele.fiscal/focusnfe-api-client)
[![Build Status](https://travis-ci.org/frekele/focusnfe-api-client.svg?branch=master)](https://travis-ci.org/frekele/focusnfe-api-client)
[![Coverage](https://codecov.io/gh/frekele/focusnfe-api-client/branch/master/graph/badge.svg)](https://codecov.io/gh/frekele/focusnfe-api-client)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/2fce31d394434419afdc0d9d42b9afe5)](https://www.codacy.com/app/frekele/focusnfe-api-client?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=frekele/focusnfe-api-client&amp;utm_campaign=Badge_Grade)
[![Codacy Badge](https://api.codacy.com/project/badge/Coverage/2fce31d394434419afdc0d9d42b9afe5)](https://www.codacy.com/app/frekele/focusnfe-api-client?utm_source=github.com&utm_medium=referral&utm_content=frekele/focusnfe-api-client&utm_campaign=Badge_Coverage)


![focusnfe](https://raw.githubusercontent.com/frekele/focusnfe-api-client/master/docs/img/focusnfe-logo.png)

<img src="./docs/img/focusnfe-fiscal-man.svg" height="300" width="450">

### REST Client - FocusNFe Brazilian fiscal Issuer NF-e NFC-e API

Built-based on the documentation: [https://focusnfe.com.br/doc/](https://focusnfe.com.br/doc/)

Project built with RESTEasy 3.5.x + Jackson 2.x.x.


#### Supported Java Versions:
- requires Java 8 (or higher) at runtime.


#### Maven dependency:
```xml
<dependency>
    <groupId>org.frekele.fiscal</groupId>
    <artifactId>focusnfe-api-client</artifactId>
    <version>1.0.0-RC3</version>
</dependency>
```

#### Gradle dependency:
```gradle
compile 'org.frekele.fiscal:focusnfe-api-client:1.0.0-RC3'
```

#### Repositories:

| Interfaces                   | Descriptions                            | Usage Examples                  |
| ---------------------------- | --------------------------------------- |-------------------------------- |
| [FocusNFeV2Repository]       | NF-e API V2 remote call                 | [FocusNFeV2RepositoryIT]        |
| [FocusNFCeV2Repository]      | NFC-e API V2 remote call                | [FocusNFCeV2RepositoryIT]       |
| [FocusMDeV2Repository]       | MD-e API V2 remote call                 | [FocusMDeV2RepositoryIT]        |
| [FocusNcmV2Repository]       | NCM API V2 remote call                  | [FocusNcmV2RepositoryIT]        |
| [FocusWebHookV2Repository]   | WebHook API V2 remote call              | [FocusWebHookV2RepositoryIT]    |
| [FocusBackupRepository]      | Backups API remote call                 | [FocusBackupRepositoryIT]       |


[FocusNFeV2Repository]: ./src/main/java/org/frekele/fiscal/focus/nfe/client/repository/nfe/FocusNFeV2Repository.java
[FocusNFCeV2Repository]: ./src/main/java/org/frekele/fiscal/focus/nfe/client/repository/nfce/FocusNFCeV2Repository.java
[FocusMDeV2Repository]: ./src/main/java/org/frekele/fiscal/focus/nfe/client/repository/mde/FocusMDeV2Repository.java
[FocusNcmV2Repository]: ./src/main/java/org/frekele/fiscal/focus/nfe/client/repository/ncm/FocusNcmV2Repository.java
[FocusWebHookV2Repository]: ./src/main/java/org/frekele/fiscal/focus/nfe/client/repository/webhook/FocusWebHookV2Repository.java
[FocusBackupRepository]: ./src/main/java/org/frekele/fiscal/focus/nfe/client/repository/backup/FocusBackupRepository.java


[FocusNFeV2RepositoryIT]: ./src/test/java/org/frekele/fiscal/focus/nfe/client/repository/nfe/FocusNFeV2RepositoryIT.java
[FocusNFCeV2RepositoryIT]: ./src/test/java/org/frekele/fiscal/focus/nfe/client/repository/nfce/FocusNFCeV2RepositoryIT.java
[FocusMDeV2RepositoryIT]: ./src/test/java/org/frekele/fiscal/focus/nfe/client/repository/mde/FocusMDeV2RepositoryIT.java
[FocusNcmV2RepositoryIT]: ./src/test/java/org/frekele/fiscal/focus/nfe/client/repository/ncm/FocusNcmV2RepositoryIT.java
[FocusWebHookV2RepositoryIT]: ./src/test/java/org/frekele/fiscal/focus/nfe/client/repository/webhook/FocusWebHookV2RepositoryIT.java
[FocusBackupRepositoryIT]: ./src/test/java/org/frekele/fiscal/focus/nfe/client/repository/backup/FocusBackupRepositoryIT.java


#### Usage with CDI (Contexts and Dependency Injection)

```java
public class FocusNFeProducer {

    @Produces
    @FocusNFe
    public FocusNFeAuth producesFocusNFeAuth() {
        String accessToken = System.getenv("FOCUS_NFE_ACCESS_TOKEN");
        String environment = System.getenv("FOCUS_NFE_ENVIRONMENT");
        return new FocusNFeAuth(accessToken, environment);
    }

    @Produces
    @FocusNFe
    public ResteasyClient producesResteasyClient() {
        ResteasyClient client = new ResteasyClientBuilder()
                // Example, you can customize a connections.
                // Add proxy
                //.defaultProxy("192.168.56.67", 3456)
                // Change connection Pool size.
                //.connectionPoolSize(3)
                // Change connection TTL.
                //.connectionTTL(30, TimeUnit.MINUTES)
                .build();
        return client;
    }

    public void closeResteasyClient(@Disposes @FocusNFe ResteasyClient client) {
        client.close();
    }
}

//Then you just need to @inject.
public class MyService {

    @Inject
    @FocusNFe
    private FocusNFeV2Repository repository;

    public void callExample() {
        String reference = UUID.randomUUID().toString();
        NFeEnvioRequisicaoNotaFiscal nfe = NFeEnvioRequisicaoNotaFiscal.newBuilder()
            .withNaturezaOperacao("VENDA DE MERCADORIA")
            .withDataEmissao(OffsetDateTime.now())
            .withTipoDocumento(NFeTipoDocumentoEnum.NOTA_FISCAL_SAIDA)
	    ........... (more fields)
            .build();
        NFeAutorizarResponse response = repository.autorizar(reference, new NFeAutorizarBodyRequest(nfe));
        NFeAutorizarBodyResponse body = response.getBody();
    }
}

```

#### Usage without CDI

```java
public class MyService {
    
    public void callExample() {
        //First create FocusNFeAuth
        Properties prop = // read your Properties or System.env
        String accessToken = prop.getProperty("accessToken");
        String environment = prop.getProperty("environment"); // PRODUCTION OR HOMOLOGATION
        FocusNFeAuth auth = FocusNFeAuth.newBuilder()
                .withAccessToken(accessToken)
                .withEnvironment(environment)
                .build();

        //Build one client per thread, or use CDI Injection.
        ResteasyClient client = new ResteasyClientBuilder()
                // Register your Custom Logging here.
                //.register(CustomLoggingFilter.class)
                .build();

        FocusNFeV2Repository repository = new FocusNFeV2RepositoryImpl(client, auth);
        repository.autorizar(reference, new NFeAutorizarBodyRequest(nfe));

        //Is important to close in end, or use CDI.
        client.close();
    }
}
```

#### Custom Logging for Response and Request

With the filter you can intercept all requests during sending and receiving responses.
Everything before the Jackson conversion (json to Object) and (Object to Json).

```java
public class CustomLoggingFilter implements ClientResponseFilter, ClientRequestFilter {

    private Logger logger = Logger.getLogger(CustomLoggingFilter.class.getName());

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        this.getLogger().debug("--> Request LoggingFilter: Uri = " + requestContext.getUri());
        this.getLogger().debug("--> Request LoggingFilter: Method= " + requestContext.getMethod());
        // Add more logs as you want.
    }

    @Override
    public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
        this.getLogger().debug("<-- Response LoggingFilter:");
        this.getLogger().debug("<-- Response LoggingFilter: Status = " + responseContext.getStatus());
        // Add more logs as you want.
    }

    public Logger getLogger() {
        return logger;
    }
}
```

### Example usage

#### POST - Autorizar
```java
String reference = UUID.randomUUID().toString();
NFeEnvioRequisicaoNotaFiscal nfe = NFeEnvioRequisicaoNotaFiscal.newBuilder()
    .withNaturezaOperacao("VENDA DE MERCADORIA")
    .withDataEmissao(OffsetDateTime.now())
    .withTipoDocumento(NFeTipoDocumentoEnum.NOTA_FISCAL_SAIDA)
    .withFinalidadeEmissao(NFeFinalidadeEmissaoEnum.NOTA_NORMAL)
    .withCnpjEmitente("39315364000104")
    .withNomeDestinatario("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
    .withCpfDestinatario("98445556550")
    .withTelefoneDestinatario("5196185555")
    .withLogradouroDestinatario("Av Otto Niemeyer")
    .withNumeroDestinatario("600")
    .withBairroDestinatario("Tristeza")
    .withMunicipioDestinatario("Porto Alegre")
    .withUfDestinatario(NFeUnidadeFederativaEnum.RIO_GRANDE_DO_SUL)
    .withCepDestinatario("91910-001")
    .withModalidadeFrete(NFeModalidadeFreteEnum.POR_CONTA_EMITENTE)
    .withItems(new ArrayList<>())
    .build();
NFeItem item = NFeItem.newBuilder()
    .withNumeroItem("1")
    .withCodigoProduto("XYZ-12345")
    .withDescricao("Produto Teste 12345 XYZ")
    .withCfop("5102")
    .withCodigoNcm("94036000")
    .withUnidadeComercial("UN")
    .withQuantidadeComercial(BigDecimal.valueOf(1))
    .withValorUnitarioComercial(new BigDecimal("124.35"))
    .withUnidadeTributavel("UN")
    .withQuantidadeTributavel(BigDecimal.valueOf(1))
    .withValorUnitarioTributavel(new BigDecimal("124.35"))
    .withValorBruto(new BigDecimal("124.35"))
    .withIcmsSituacaoTributaria(NFeIcmsSituacaoTributariaEnum.TRIBUTADA_SIMPLES_NACIONAL_SEM_PERMISSAO_CREDITO)
    .withIcmsOrigem(NFeIcmsOrigemEnum.NACIONAL)
    .withPisSituacaoTributaria(NFePisCofinsSituacaoTributariaEnum.OPERACAO_ISENTA_DA_CONTRIBUICAO)
    .withCofinsSituacaoTributaria(NFePisCofinsSituacaoTributariaEnum.OPERACAO_ISENTA_DA_CONTRIBUICAO)
    .withIncluiNoTotal(NFeIncluiNoTotalEnum.SIM)
    .build();
nfe.getItems().add(item);

NFeAutorizarBodyRequest bodyRequest = NFeAutorizarBodyRequest.newBuilder().withNfe(nfe).build();
NFeAutorizarResponse response = repository.autorizar(reference, bodyRequest);

//Get Body with Json Object Mapping.
NFeAutorizarBodyResponse responseBody = response.getBody();
//Get Body with String.
String responseBodyString = response.getBodyString();

//Get Http Header 'X-Rate-Limit-Limit'.
String responseHeaderValue = response.getRateLimitLimit();
//Get Http Header 'X-Rate-Limit-Remaining'.
String responseHeaderValue = response.getRateLimitRemaining();
//Get Http Header 'X-Rate-Limit-Reset'.
String responseHeaderValue = response.getRateLimitReset();
//Get Http Header 'X-Runtime'.
String responseHeaderValue = response.getRuntime();

//Get All Http Response.
Response httpResponse = response.getResponse();
```


#### POST - Cancelar
```java
NFeCancelarResponse response = repository.cancelar(reference, new NFeCancelarBodyRequest("Teste de cancelamento de nota"));

//Or with Builder Pattern.
NFeCancelarBodyRequest bodyRequest = NFeCancelarBodyRequest.newBuilder()
    .withJustificativa("Teste de cancelamento de nota")
    .build();
NFeCancelarResponse response = repository.cancelar(reference, bodyRequest);
```

#### POST - EmitirCCe
```java
NFeCCeBodyRequest bodyRequest = NFeCCeBodyRequest.newBuilder()
    .withCorrecao("Teste de carta de correcao")
    .build();
NFeCCeResponse response = repository.emitirCCe(reference, bodyRequest);
```

#### POST - EnviarEmail
```java
NFeEmailBodyRequest bodyRequest = NFeEmailBodyRequest.newBuilder()
    .withEmails("alguem@example.org", "teste@teste.com.br")
    .build();
NFeEmailResponse response = repository.enviarEmail(reference, bodyRequest);
```

#### POST - Consultar
```java
 NFeConsultarResponse response = repository.consultar(reference);
```

#### POST - ConsultarTudo
```java
NFeConsultarResponse response = repository.consultarTudo(reference);
```

#### POST - Inutilizar
```java
NFeInutilizarBodyRequest bodyRequest = NFeInutilizarBodyRequest.newBuilder()
    .withCnpj("39315364000104")
    .withSerie("1")
    .withNumeroInicial("7")
    .withNumeroFinal("9")
    .withJustificativa("Teste de inutilizacao de nota")
    .build();
NFeInutilizarResponse response = repository.inutilizar(bodyRequest);
```



frekele/focusnfe-api-client is **licensed** under the **[MIT License]**. The terms of the license are as follows:

    MIT License

    Copyright (c) 2018 @frekele<Leandro Kersting de Freitas>

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
