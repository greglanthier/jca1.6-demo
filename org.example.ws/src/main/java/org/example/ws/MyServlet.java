package org.example.ws;

import java.io.IOException;

import javax.annotation.Resource;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.Interaction;
import javax.resource.cci.Record;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "endpoint")
public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Resource(name = "eis/echo")
	ConnectionFactory factory;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.getWriter().println("Got factory >" + factory + "<");

		Connection con = null;
		try {
			con = factory.getConnection();
			resp.getWriter().println("Got connection >" + con + "<");
			Interaction interaction = con.createInteraction();
			Record x = interaction.execute(null, null);
			resp.getWriter().println("Got response >" + x.getRecordName() + "<");
		} catch (ResourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != con) {
				try {
					con.close();
				} catch (ResourceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
