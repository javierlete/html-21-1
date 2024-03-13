package com.ipartek.formacion.tienda.accesodatos;

import static com.ipartek.formacion.tienda.accesodatos.GlobalesAccesoDatos.EMF;

import com.ipartek.formacion.tienda.modelos.Usuario;

public class DaoUsuarioJpa implements DaoUsuario {

	@Override
	public Iterable<Usuario> obtenerTodos() {
		var em = EMF.createEntityManager();
		var t = em.getTransaction();
		t.begin();

		var usuarios = em.createQuery("from Usuario u join fetch u.rol", Usuario.class).getResultList();

		t.commit();
		em.close();

		return usuarios;
	}

	@Override
	public Usuario obtenerPorId(Long id) {
		var em = EMF.createEntityManager();
		var t = em.getTransaction();
		t.begin();

		var usuario = em.createQuery("from Usuario u join fetch u.rol where id = :id", Usuario.class).setParameter("id", id).getSingleResult();

		System.out.println(usuario);
		System.out.println(usuario.getRol());
		
		t.commit();
		em.close();

		return usuario;
	}

	@Override
	public Usuario insertar(Usuario usuario) {
		var em = EMF.createEntityManager();
		var t = em.getTransaction();
		t.begin();

		em.persist(usuario);

		t.commit();
		em.close();

		return usuario;
	}

	@Override
	public Usuario modificar(Usuario usuario) {
		var em = EMF.createEntityManager();
		var t = em.getTransaction();
		t.begin();

		em.merge(usuario);

		t.commit();
		em.close();

		return usuario;
	}

	@Override
	public void borrar(Long id) {
		var em = EMF.createEntityManager();
		var t = em.getTransaction();
		t.begin();

		em.remove(em.find(Usuario.class, id));

		t.commit();
		em.close();
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		var em = EMF.createEntityManager();
		var t = em.getTransaction();
		t.begin();

		var usuarios = em.createQuery("from Usuario u join fetch u.rol where email = :email", Usuario.class)
				.setParameter("email", email).getResultList();

		if(usuarios.size() == 0) {
			return null;
		}
		
		var usuario = usuarios.get(0);
		
		t.commit();
		em.close();

		return usuario;
	}
}
