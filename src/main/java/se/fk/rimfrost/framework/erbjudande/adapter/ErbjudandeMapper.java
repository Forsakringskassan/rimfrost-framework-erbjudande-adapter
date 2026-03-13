package se.fk.rimfrost.framework.erbjudande.adapter;

import jakarta.enterprise.context.ApplicationScoped;
import se.fk.rimfrost.framework.erbjudande.model.ImmutableErbjudande;
import se.fk.rimfrost.framework.erbjudande.model.Erbjudande;
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
