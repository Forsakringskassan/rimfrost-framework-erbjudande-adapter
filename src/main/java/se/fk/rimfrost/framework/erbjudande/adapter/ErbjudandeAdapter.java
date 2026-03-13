package se.fk.rimfrost.framework.erbjudande.adapter;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.proxy.WebResourceFactory;
import se.fk.rimfrost.framework.erbjudande.model.Erbjudande;
import se.fk.rimfrost.framework.erbjudande.model.ErbjudandeInterface;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.ErbjudandeControllerApi;
import java.util.UUID;

@SuppressWarnings("unused")
@ApplicationScoped
public class ErbjudandeAdapter implements ErbjudandeInterface
{

   @ConfigProperty(name = "erbjudande.api.base-url")
   String erbjudandeBaseUrl;

   private ErbjudandeControllerApi erbjudandeClient;

   @Inject
   ErbjudandeMapper erbjudandeMapper;

   @PostConstruct
   void init()
   {
      ClientConfig clientConfig = new ClientConfig();
      clientConfig.connectorProvider(new ApacheConnectorProvider());
      Client client = ClientBuilder.newClient(clientConfig);

      this.erbjudandeClient = WebResourceFactory.newResource(
            ErbjudandeControllerApi.class,
            client.target(this.erbjudandeBaseUrl));
   }

   public Erbjudande getErbjudande(UUID erbjudandeId)
   {
      var apiResponse = erbjudandeClient.getErbjudande(erbjudandeId);
      return erbjudandeMapper.toErbjudande(apiResponse);
   }

}
