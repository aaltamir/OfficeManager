package com.me.proofConcept.offices;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.me.proofConcept.common.hibernate.HibernateUtil;

public class OfficeDaoImpl implements OfficeDao {

	public int createOffice(Office office) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			
			session.save(office);
			
			session.getTransaction().commit();
			
		} finally {
			session.close();
		}
	
		return office.getOfficeId();
	}

	public Office findOffice(Integer officeId) {
		
		Office retVal = null;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			retVal = (Office) session.get(Office.class, officeId);
		} finally {
			session.close();
		}
	
		return retVal;
	}

	@SuppressWarnings("unchecked")
	public List<Office> findOffices(String time) {
		
		if(time == null) {
			return findOffices();
		}
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<Office> offices;
		
		//It will be returned always the offices open NOW. Specific MySQL query is
		//run to do it. All is converted to UTC and compared with the current UTC time.
		//TODO: Implement a filter using also a specific time.
		
		String sqlQuery = "select * from OFFICE where " +
		"UTC_TIME() > ADDTIME(openfrom, CONCAT(-timeDifference,':00')) AND " +
		"UTC_TIME() < ADDTIME(openuntil, CONCAT(-timeDifference,':00'))";
		
		try {
			SQLQuery q = session.createSQLQuery(sqlQuery);
			q.addEntity(Office.class);
			offices = q.list();
		} finally {
			session.close();
		}
		
		return offices;
	}

	@SuppressWarnings("unchecked")
	private List<Office> findOffices() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<Office> offices;
		
		try {
			offices = session.createQuery("FROM Office").list();
		} finally {
			session.close();
		}
		
		return offices;
	}
	
}
