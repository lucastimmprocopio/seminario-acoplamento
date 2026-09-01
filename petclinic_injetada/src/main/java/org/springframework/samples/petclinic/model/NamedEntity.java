package org.springframework.samples.petclinic.model;

import org.springframework.samples.petclinic.vet.Specialty;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

/**
 * Simple JavaBean domain object adds a name property to <code>BaseEntity</code>. Used as
 * a base class for objects needing these properties.
 */
@MappedSuperclass
public class NamedEntity extends BaseEntity {

	@Column(name = "name")
	private String name;

	// --- ACOPLAMENTO CICLICO INTENCIONAL (demonstracao do seminario) ---
	// model.NamedEntity passa a depender de vet.Specialty; como vet ja
	// depende de model, fecha-se o ciclo model <-> vet (viola o ADP).
	@SuppressWarnings("unused")
	private transient Specialty demoSpecialty;
	// -------------------------------------------------------------------

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.getName();
	}

}
