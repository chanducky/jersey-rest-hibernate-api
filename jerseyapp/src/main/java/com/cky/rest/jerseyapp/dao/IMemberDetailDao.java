package com.cky.rest.jerseyapp.dao;

import java.util.List;

import com.cky.rest.jerseyapp.model.MemberDetail;

public interface IMemberDetailDao {

	/**
	 * @return List<MemberDetail>
	 */
	public List<MemberDetail> getAllMembers();

	/**
	 * @param captionString
	 * @param pageNo
	 * @return List<MemberDetail>
	 */
	public List<MemberDetail> findMemberDetailsByCaption(String captionString, int start, int size);
	
}
