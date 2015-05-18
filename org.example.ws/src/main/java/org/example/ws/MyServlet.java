/*
 * Copyright 2015 Greg Lanthier
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
