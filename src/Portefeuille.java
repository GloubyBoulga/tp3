public class Portefeuille {
  private Cryptomonnaie monnaie;
  private double montant; // Soit le nombre de jetons
  private String proprietaire;

  public Portefeuille(Cryptomonnaie monnaie, double montant, String proprietaire)
{
      this.monnaie      = monnaie;
      this.montant      = montant;
      this.proprietaire = proprietaire;
}

  /**
   * Cette fonction vous permet de transférer des devises du portefeuille actuel 
   * vers le portefeuille de destination pour le montant indiqué. Le type de devise 
   * (nom du Jeton) doit être le même entre les deux portefeuilles et le montant 
   * du portefeuille actuel doit être supérieur ou égal à celui indiqué.
   * @param destination 
   * @param montantJetons
   * @return Vrai si la transaction a été effectuée, faux sinon.  
   */
  public boolean transfertDevise (Portefeuille destination, double montantJetons) {
    if ( this.monnaie == destination.getMonnaie() && this.montant >= montantJetons ) {
      this.montant -= montantJetons;
      destination.montant += this.montant;
      return true;
    }
    else
      return false;
    }
  }

  /**
   * Cette fonction vous permet d'acheter des jetons de la 
   * crypto-devise en fonction de leur valeur en euros. 
   * Le résultat est l'augmentation des jetons de la crypto-monnaie.
   * @param montantEuros Valeur d'achat en euros 
   * @return true si le montant en euros est supérieur ou égal à 0 
   */
  public boolean achatDevise (double montantEuros){
<<<<<<< HEAD
    if ( montantEuros <= 0 && this.montant < montantEuros)
      return false;
    else {
      this.montant -= montantEuros;
      this.monnaie += montantEuros/monnaie.getValeurDeJeton();
      return true;
    }
=======
	if ( this.montant >= 0  )
    {
        this.montant = this.montant - montantEuros ;
        return true;
    }
    else
        return false;
>>>>>>> f137b14c6a6b2133a954be4f4463d2a26cc35c22
  }

  /**
   * Valide si le proprietaire passé en parametre est celui
   * qui as le portefeuille
   * @param proprietaire
   * @return true si les nom du propriétaire est correct
   */
  public boolean estProprietaire (String proprietaire){
        return (proprietaire.equals(this.proprietaire))?true:false;
  }

  /**
   * 
   * @return La valeur en euros du Portefeuille. 
   * Autrement dit, le monant de jetons multiplié par la valeur des jetons. 
   */
  public double valeurEnEuros(){
      return this.montant * this.monnaie.getValeurDeJeton();
  }

  public String getProprietaire() {
      return proprietaire;
  }

  public Cryptomonnaie getMonnaie() {
      return monnaie;
  }

  public double getMontant() {
      return montant;
  }

  @Override
  public String toString() {
      return String.format("%10s",proprietaire) + " : "
           + String.format("%10.1f", montant)   + " x " 
           + this.monnaie.toString()            + " = "
           + String.format("%10.1f", valeurEnEuros());
  }

}
