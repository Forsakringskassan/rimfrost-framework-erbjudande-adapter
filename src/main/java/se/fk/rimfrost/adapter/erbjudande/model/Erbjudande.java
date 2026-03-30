package se.fk.rimfrost.adapter.erbjudande.model;

import org.immutables.value.Value;
import java.util.UUID;

@Value.Immutable
public interface Erbjudande
{

   UUID id();

   String version();

   String namn();

   UUID produktId();
}
