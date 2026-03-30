package se.fk.rimfrost.adapter.erbjudande.adapter;

import jakarta.enterprise.context.ApplicationScoped;
import se.fk.rimfrost.adapter.erbjudande.model.ImmutableErbjudande;
import se.fk.rimfrost.adapter.erbjudande.model.Erbjudande;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.GetErbjudandeResponse;

@ApplicationScoped
public class ErbjudandeMapper
{

   public Erbjudande toErbjudande(GetErbjudandeResponse apiResponse)
   {
      var responseBuilder = ImmutableErbjudande.builder()
            .id(apiResponse.getErbjudande().getId())
            .version(apiResponse.getErbjudande().getVersion())
            .namn(apiResponse.getErbjudande().getNamn())
            .produktId(apiResponse.getErbjudande().getProduktId());
      return responseBuilder.build();
   }
}
