package dev.danvega.restclient.config;

import dev.danvega.restclient.service.JsonPlaceholderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HTTPInterfaceClientConfig {


    @Primary
    @Bean(name = "jsonPlaceholderService")
    JsonPlaceholderService jsonPlaceholderService() {
        RestClient client = RestClient.create("https://jsonplaceholder.typicode.com");
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(client))
                .build();
        return factory.createClient(JsonPlaceholderService.class);
    }

}
