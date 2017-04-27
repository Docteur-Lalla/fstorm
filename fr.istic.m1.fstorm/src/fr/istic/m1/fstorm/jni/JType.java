package fr.istic.m1.fstorm.jni;

import java.util.List;

public interface JType extends JNIType {
	/**
	 * Cr� et initialise des Variables d�crivant un CType
	 * vers lequel le JType doit �tre converti:
	 * 
	 * ex. d'un JArray vers un CArray, la fonction
	 *     cr�ra un CArray ET un CPrim(INT) pour d�finir un tableau
	 * 
	 * La fonction doit aussi modifier le buffer du WrapperEnvironment
	 * en y �crivant les �tapes de conversion. (cf. doc de CType)
	 * 
	 * @param v la variable a convertir
	 * @param ct le type d'arriv�e
	 * @return les variables d�crivant le nouveau type
	 */
    public abstract List<Variable> toKernel(Variable v, CType ct);
    
    /**
     * Assigne des valeurs � des Variables C dans le but "d'assigner" la valeur
     * d'une Variable Java.
     * 
     * Cette fonction est similaire � toKernel(), mais elle ne cr� pas de nouvelles variables,
     * elle prend des variables d�j� existantes.
     * 
     * @param from_var la variable Java de d�part
     * @param to_vars les variables C � modifier
     * @param ct le type C d'arriv�e
     */
    public abstract void assignKernel(String from_var, List<Variable> to_vars, CType ct);
    
    /**
     * Retourne la signature Java d'un type
     * ex. JString().getSignature() == "Ljava/lang/String;"
     *     JPrim(CHAR).getSignature() == "C"
     *     JArray(JPrim(INT)).getSignature() == "[I"
     * @return
     */
    public abstract String getSignature();
}
