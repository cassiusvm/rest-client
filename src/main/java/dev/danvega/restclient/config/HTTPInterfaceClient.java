package dev.danvega.restclient.config;

import dev.danvega.restclient.service.JsonPlaceholderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
@Profile("httpinterfaceclient")
public class HTTPInterfaceClient {

    @Bean
    JsonPlaceholderService jsonPlaceholderService() {
        RestClient client = RestClient.create("https://jsonplaceholder.typicode.com");
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(client))
                .build();
        return factory.createClient(JsonPlaceholderService.class);
    }

}
