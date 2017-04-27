package fr.istic.m1.fstorm.jni;

import java.util.List;

public interface CType extends JNIType {
	/**
	 * Cr� une variable d�finie par un JType � partir d'un CType
	 * 
	 * Cette fonction doit renvoyer une Variable valide si la conversion
	 * a pu se faire. Le buffer du WrapperEnvironment (WE) doit �tre modifi�
	 * en cons�quence (ajouter les lignes de code n�cessaires au cast).
	 * 
	 * @param v les variables d�crivant les attributs du type
	 * @param jt le type java vers lequel on converti 
	 * @return La variable java cr��e
	 */
    public abstract Variable toJava(List<Variable> v, JType jt);
    
    /**
     * Assigne la valeur de variables d�crivant un CType
     * dans une variable d�crivant un JType.
     * 
     * Cette fonction doit modifier le buffer du WE pour y faire
     * apparaitre les lignes de code de la conversion et de l'assignation.
     * (ex. "jvar = cvar;") pour un simple cast entre deux types primitifs (int -> jint)
     *  
     * @param from_vars les noms des variables d�crivant le CType
     * @param to_var le nom de la variable d�crivant le JType
     * @param jt le JType de la variable � assigner 
     */
    public abstract void assignJava(List<String> from_vars, String to_var, JType jt);
}
