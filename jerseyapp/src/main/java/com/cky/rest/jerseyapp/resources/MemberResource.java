package com.cky.rest.jerseyapp.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import com.cky.rest.jerseyapp.dao.MemberDetailDaoImpl;
import com.cky.rest.jerseyapp.model.MemberDetail;

@Provider
@Path("/member")
public class MemberResource {

	MemberDetailDaoImpl md = null;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getApplicationStatus(){
		return "Hey there server is running..";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/all")
	public Response getAllMembers() {
		md = new MemberDetailDaoImpl();
		List<MemberDetail> memberList = null;
		memberList = md.getAllMembers();

		GenericEntity<List<MemberDetail>> ge = new GenericEntity<List<MemberDetail>>(memberList){};

		return Response.status(Status.OK).entity(ge).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/xml/all")
	public List<MemberDetail>  getAllMembersXML() {
		md = new MemberDetailDaoImpl();
		List<MemberDetail> memberList = null;
		memberList = md.getAllMembers();
		return memberList;
	}

	@GET
	@Path("/search_caption")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchCaption(@QueryParam("caption")String caption,
			@QueryParam("start") int start,
			@QueryParam("size") int size) {
		md = new MemberDetailDaoImpl();
		
		System.out.println("caption " + caption + " start "+start + " size " +size );
		
		List<MemberDetail> memberList = md.findMemberDetailsByCaption(caption, start,size);

		if(memberList.isEmpty()){
			return Response.noContent().build();
		}
		GenericEntity<List<MemberDetail>> ge = new GenericEntity<List<MemberDetail>>(memberList){};

		return Response.status(Status.OK).entity(ge).build();
	}
}
