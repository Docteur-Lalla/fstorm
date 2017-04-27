package fr.istic.m1.fstorm.jni;

/**
 *
 * @author Arthur Blanleuil
 *
 * D�finit un type qu'on aura besoin de lib�rer plus tard
 * ex. les tableaux doivent �tre lib�r�s avec Release<Type>Array();
 */
public interface JNIReleaseable {
	public void release(String arr, String body);
}
