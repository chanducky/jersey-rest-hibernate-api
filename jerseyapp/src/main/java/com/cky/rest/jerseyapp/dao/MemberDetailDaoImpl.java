package com.cky.rest.jerseyapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.cky.rest.jerseyapp.model.MemberDetail;


public class MemberDetailDaoImpl extends HibernateUtil implements IMemberDetailDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<MemberDetail> getAllMembers() {
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		Criteria crt = session.createCriteria(MemberDetail.class);
		List<MemberDetail> memberDetailList =  crt.list();
		tx.commit();
		return memberDetailList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MemberDetail> findMemberDetailsByCaption(String captionString, int start, int size){
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria crt = session.createCriteria(MemberDetail.class);
		crt.add(Restrictions.like("caption", "%"+captionString+"%"));

		crt.setFirstResult(start);
		crt.setMaxResults(size);

		List<MemberDetail> memberDetailList = crt.list();
		tx.commit();
		return memberDetailList;
	}

}
