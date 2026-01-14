package es.cursojava.ejercicios.formularioAlumno.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import es.cursojava.hibernate.ejercicios.ejercicio1.entities.Alumno;
import es.cursojava.hibernate.ejercicios.ejercicio3.entities.Aula;
import es.cursojava.hibernate.utilidades.UtilidadesHibernate;

public class AlumnoDAO {

	private Session session;
	private Transaction transaction;
	
	public AlumnoDAO() {
		session = UtilidadesHibernate.getSessionFactory();
		transaction = session.beginTransaction();
	}
	
	public boolean emailExists(String email) throws SQLException{
		Query<Alumno> query = session.createQuery("from Alumno where email = :emailAlumno", Alumno.class);
		query.setParameter("emailAlumno", email);
		
		Alumno alumno = query.uniqueResult();
		transaction.commit();
		return alumno != null;
		
	}
	
	public void save(Alumno alumno) {
		try {
			transaction.begin();
			session.persist(alumno);
			session.flush();
			transaction.commit();
		}
		catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        throw e;
		}
	}
	public List<Alumno> getTodosLosAlumnos(){ //HQL hibernate query language because it uses names of classes instead of names of tables
		List<Alumno> alumnos = new ArrayList<>();
		Query<Alumno> query = session.createQuery("from Alumno", Alumno.class);
		alumnos = query.getResultList();
		
		
		return alumnos;
		
	}
//	public Aula obtenerAulaPorNombreAlumno(String nombreAlumno) {
//		Query<Alumno> query = session.createQuery("from Alumno where nombre = :nombreAlumno", Alumno.class);
//		query.setParameter("nombreAlumno", nombreAlumno);
//
//		return query.uniqueResult().getCurso().getAula();
//	}
	
//	public String obtenerCodigoAulaPorNombreAlumno(String nombreAlumno) {
//		Query<String> query = session.createQuery("select a.curso.aula.codigoAula "
//				+ "from Alumno a where nombre = :nombreAlumno", String.class);
//		
//		query.setParameter("nombreAlumno", nombreAlumno);
//
//		return query.uniqueResult();
//	}
}
